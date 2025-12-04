package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transfermanager.PersistableUpload;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManagerConfiguration;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.UploadResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.EncryptedPutObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UploadCallable implements Callable<UploadResult> {
    private static final Log log = LogFactory.getLog(UploadCallable.class);
    private final TransferManagerConfiguration configuration;
    private final ProgressListenerChain listener;
    private String multipartUploadId;
    private PersistableUpload persistableUpload;
    private final PutObjectRequest putObjectRequest;
    private final AmazonS3 s3;
    private final ExecutorService threadPool;
    private final TransferProgress transferProgress;
    private final UploadImpl upload;
    private final List futures = new ArrayList();
    private final List eTagsToSkip = new ArrayList();

    public UploadCallable(TransferManager transferManager, ExecutorService executorService, UploadImpl uploadImpl, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain, String str, TransferProgress transferProgress) {
        this.s3 = transferManager.getAmazonS3Client();
        this.configuration = transferManager.getConfiguration();
        this.threadPool = executorService;
        this.putObjectRequest = putObjectRequest;
        this.listener = progressListenerChain;
        this.upload = uploadImpl;
        this.multipartUploadId = str;
        this.transferProgress = transferProgress;
    }

    List getFutures() {
        return this.futures;
    }

    List getETags() {
        return this.eTagsToSkip;
    }

    String getMultipartUploadId() {
        return this.multipartUploadId;
    }

    public boolean isMultipartUpload() {
        return TransferManagerUtils.shouldUseMultipartUpload(this.putObjectRequest, this.configuration);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public UploadResult call() throws Exception {
        this.upload.setState(Transfer.TransferState.InProgress);
        if (isMultipartUpload()) {
            fireProgressEvent(2);
            return uploadInParts();
        }
        return uploadInOneChunk();
    }

    private UploadResult uploadInOneChunk() throws AmazonClientException {
        PutObjectResult putObjectResultPutObject = this.s3.putObject(this.putObjectRequest);
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(this.putObjectRequest.getBucketName());
        uploadResult.setKey(this.putObjectRequest.getKey());
        uploadResult.setETag(putObjectResultPutObject.getETag());
        uploadResult.setVersionId(putObjectResultPutObject.getVersionId());
        return uploadResult;
    }

    private void captureUploadStateIfPossible() {
        if (this.putObjectRequest.getSSECustomerKey() == null) {
            this.persistableUpload = new PersistableUpload(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.putObjectRequest.getFile().getAbsolutePath(), this.multipartUploadId, this.configuration.getMinimumUploadPartSize(), this.configuration.getMultipartUploadThreshold());
            notifyPersistableTransferAvailability();
        }
    }

    public PersistableUpload getPersistableUpload() {
        return this.persistableUpload;
    }

    private void notifyPersistableTransferAvailability() {
        S3ProgressPublisher.publishTransferPersistable(this.listener, this.persistableUpload);
    }

    private UploadResult uploadInParts() throws IOException {
        boolean z = this.s3 instanceof AmazonS3EncryptionClient;
        long optimalPartSize = getOptimalPartSize(z);
        if (this.multipartUploadId == null) {
            this.multipartUploadId = initiateMultipartUpload(this.putObjectRequest, z);
        }
        try {
            try {
                UploadPartRequestFactory uploadPartRequestFactory = new UploadPartRequestFactory(this.putObjectRequest, this.multipartUploadId, optimalPartSize);
                if (TransferManagerUtils.isUploadParallelizable(this.putObjectRequest, z)) {
                    captureUploadStateIfPossible();
                    uploadPartsInParallel(uploadPartRequestFactory, this.multipartUploadId);
                    if (this.putObjectRequest.getInputStream() == null) {
                        return null;
                    }
                    try {
                        this.putObjectRequest.getInputStream().close();
                        return null;
                    } catch (Exception e) {
                        log.warn("Unable to cleanly close input stream: " + e.getMessage(), e);
                        return null;
                    }
                }
                return uploadPartsInSeries(uploadPartRequestFactory);
            } finally {
                if (this.putObjectRequest.getInputStream() != null) {
                    try {
                        this.putObjectRequest.getInputStream().close();
                    } catch (Exception e2) {
                        log.warn("Unable to cleanly close input stream: " + e2.getMessage(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            fireProgressEvent(8);
            performAbortMultipartUpload();
            throw e3;
        }
    }

    void performAbortMultipartUpload() {
        try {
            if (this.multipartUploadId != null) {
                this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.multipartUploadId));
            }
        } catch (Exception e) {
            log.info("Unable to abort multipart upload, you may need to manually remove uploaded parts: " + e.getMessage(), e);
        }
    }

    private long getOptimalPartSize(boolean z) {
        long jCalculateOptimalPartSize = TransferManagerUtils.calculateOptimalPartSize(this.putObjectRequest, this.configuration);
        if (z) {
            long j = jCalculateOptimalPartSize % 32;
            if (j > 0) {
                jCalculateOptimalPartSize = (jCalculateOptimalPartSize - j) + 32;
            }
        }
        log.debug("Calculated optimal part size: " + jCalculateOptimalPartSize);
        return jCalculateOptimalPartSize;
    }

    private UploadResult uploadPartsInSeries(UploadPartRequestFactory uploadPartRequestFactory) throws AmazonClientException {
        ArrayList arrayList = new ArrayList();
        while (uploadPartRequestFactory.hasMoreRequests()) {
            if (this.threadPool.isShutdown()) {
                throw new CancellationException("TransferManager has been shutdown");
            }
            UploadPartRequest nextUploadPartRequest = uploadPartRequestFactory.getNextUploadPartRequest();
            InputStream inputStream = nextUploadPartRequest.getInputStream();
            if (inputStream != null && inputStream.markSupported()) {
                if (nextUploadPartRequest.getPartSize() >= 2147483647L) {
                    inputStream.mark(Integer.MAX_VALUE);
                } else {
                    inputStream.mark((int) nextUploadPartRequest.getPartSize());
                }
            }
            arrayList.add(this.s3.uploadPart(nextUploadPartRequest).getPartETag());
        }
        CompleteMultipartUploadResult completeMultipartUploadResultCompleteMultipartUpload = this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.multipartUploadId, arrayList));
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(completeMultipartUploadResultCompleteMultipartUpload.getBucketName());
        uploadResult.setKey(completeMultipartUploadResultCompleteMultipartUpload.getKey());
        uploadResult.setETag(completeMultipartUploadResultCompleteMultipartUpload.getETag());
        uploadResult.setVersionId(completeMultipartUploadResultCompleteMultipartUpload.getVersionId());
        return uploadResult;
    }

    private void uploadPartsInParallel(UploadPartRequestFactory uploadPartRequestFactory, String str) throws AmazonClientException {
        Map mapIdentifyExistingPartsForResume = identifyExistingPartsForResume(str);
        while (uploadPartRequestFactory.hasMoreRequests()) {
            if (this.threadPool.isShutdown()) {
                throw new CancellationException("TransferManager has been shutdown");
            }
            UploadPartRequest nextUploadPartRequest = uploadPartRequestFactory.getNextUploadPartRequest();
            if (mapIdentifyExistingPartsForResume.containsKey(Integer.valueOf(nextUploadPartRequest.getPartNumber()))) {
                PartSummary partSummary = (PartSummary) mapIdentifyExistingPartsForResume.get(Integer.valueOf(nextUploadPartRequest.getPartNumber()));
                this.eTagsToSkip.add(new PartETag(nextUploadPartRequest.getPartNumber(), partSummary.getETag()));
                this.transferProgress.updateProgress(partSummary.getSize());
            } else {
                this.futures.add(this.threadPool.submit(new UploadPartCallable(this.s3, nextUploadPartRequest)));
            }
        }
    }

    private Map identifyExistingPartsForResume(String str) throws AmazonClientException {
        HashMap map = new HashMap();
        if (str == null) {
            return map;
        }
        int iIntValue = 0;
        while (true) {
            PartListing partListingListParts = this.s3.listParts(new ListPartsRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), str).withPartNumberMarker(Integer.valueOf(iIntValue)));
            for (PartSummary partSummary : partListingListParts.getParts()) {
                map.put(Integer.valueOf(partSummary.getPartNumber()), partSummary);
            }
            if (!partListingListParts.isTruncated()) {
                return map;
            }
            iIntValue = partListingListParts.getNextPartNumberMarker().intValue();
        }
    }

    private String initiateMultipartUpload(PutObjectRequest putObjectRequest, boolean z) {
        InitiateMultipartUploadRequest initiateMultipartUploadRequestWithObjectMetadata;
        if (z && (putObjectRequest instanceof EncryptedPutObjectRequest)) {
            initiateMultipartUploadRequestWithObjectMetadata = new EncryptedInitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata());
            ((EncryptedInitiateMultipartUploadRequest) initiateMultipartUploadRequestWithObjectMetadata).setMaterialsDescription(((EncryptedPutObjectRequest) putObjectRequest).getMaterialsDescription());
        } else {
            initiateMultipartUploadRequestWithObjectMetadata = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata());
        }
        TransferManager.appendMultipartUserAgent(initiateMultipartUploadRequestWithObjectMetadata);
        if (putObjectRequest.getStorageClass() != null) {
            initiateMultipartUploadRequestWithObjectMetadata.setStorageClass(StorageClass.fromValue(putObjectRequest.getStorageClass()));
        }
        if (putObjectRequest.getRedirectLocation() != null) {
            initiateMultipartUploadRequestWithObjectMetadata.setRedirectLocation(putObjectRequest.getRedirectLocation());
        }
        if (putObjectRequest.getSSECustomerKey() != null) {
            initiateMultipartUploadRequestWithObjectMetadata.setSSECustomerKey(putObjectRequest.getSSECustomerKey());
        }
        String uploadId = this.s3.initiateMultipartUpload(initiateMultipartUploadRequestWithObjectMetadata).getUploadId();
        log.debug("Initiated new multipart upload: " + uploadId);
        return uploadId;
    }

    private void fireProgressEvent(int i) {
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.setEventCode(i);
        ProgressListenerCallbackExecutor.progressChanged(this.listener, progressEvent);
    }
}
