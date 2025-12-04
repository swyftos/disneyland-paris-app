package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyCallable;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyMonitor;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.DownloadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.DownloadMonitor;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileDownloadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileTransferMonitor;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileUploadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.S3ProgressListener;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.S3ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferManagerUtils;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferProgressUpdatingListener;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferStateChangeListener;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadCallable;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadMonitor;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* loaded from: classes2.dex */
public class TransferManager {
    private TransferManagerConfiguration configuration;
    private final AmazonS3 s3;
    private final ExecutorService threadPool;
    private final ScheduledExecutorService timedThreadPool;
    private static final Log log = LogFactory.getLog(TransferManager.class);
    private static final String USER_AGENT = TransferManager.class.getName() + "/" + VersionInfoUtils.getVersion();
    private static final String USER_AGENT_MULTIPART = TransferManager.class.getName() + "_multipart/" + VersionInfoUtils.getVersion();
    private static final ThreadFactory daemonThreadFactory = new ThreadFactory() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.3
        final AtomicInteger threadCount = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int iIncrementAndGet = this.threadCount.incrementAndGet();
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("S3TransferManagerTimedThread-" + iIncrementAndGet);
            return thread;
        }
    };

    public TransferManager() {
        this(new AmazonS3Client(new DefaultAWSCredentialsProviderChain()));
    }

    public TransferManager(AWSCredentialsProvider aWSCredentialsProvider) {
        this(new AmazonS3Client(aWSCredentialsProvider));
    }

    public TransferManager(AWSCredentials aWSCredentials) {
        this(new AmazonS3Client(aWSCredentials));
    }

    public TransferManager(AmazonS3 amazonS3) {
        this(amazonS3, TransferManagerUtils.createDefaultExecutorService());
    }

    public TransferManager(AmazonS3 amazonS3, ExecutorService executorService) {
        this.timedThreadPool = new ScheduledThreadPoolExecutor(1, daemonThreadFactory);
        this.s3 = amazonS3;
        this.threadPool = executorService;
        this.configuration = new TransferManagerConfiguration();
    }

    public void setConfiguration(TransferManagerConfiguration transferManagerConfiguration) {
        this.configuration = transferManagerConfiguration;
    }

    public TransferManagerConfiguration getConfiguration() {
        return this.configuration;
    }

    public AmazonS3 getAmazonS3Client() {
        return this.s3;
    }

    public Upload upload(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonClientException {
        return upload(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public Upload upload(String str, String str2, File file) throws AmazonClientException {
        return upload(new PutObjectRequest(str, str2, file));
    }

    public Upload upload(PutObjectRequest putObjectRequest) throws AmazonClientException {
        return doUpload(putObjectRequest, null, null, null);
    }

    public Upload upload(PutObjectRequest putObjectRequest, S3ProgressListener s3ProgressListener) throws AmazonClientException {
        return doUpload(putObjectRequest, null, s3ProgressListener, null);
    }

    private Upload doUpload(PutObjectRequest putObjectRequest, TransferStateChangeListener transferStateChangeListener, S3ProgressListener s3ProgressListener, PersistableUpload persistableUpload) {
        appendSingleObjectUserAgent(putObjectRequest);
        String multipartUploadId = persistableUpload != null ? persistableUpload.getMultipartUploadId() : null;
        if (putObjectRequest.getMetadata() == null) {
            putObjectRequest.setMetadata(new ObjectMetadata());
        }
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        File requestFile = TransferManagerUtils.getRequestFile(putObjectRequest);
        if (requestFile != null) {
            metadata.setContentLength(requestFile.length());
            if (metadata.getContentType() == null) {
                metadata.setContentType(Mimetypes.getInstance().getMimetype(requestFile));
            }
        } else if (multipartUploadId != null) {
            throw new IllegalArgumentException("Unable to resume the upload. No file specified.");
        }
        String str = "Uploading to " + putObjectRequest.getBucketName() + "/" + putObjectRequest.getKey();
        TransferProgress transferProgress = new TransferProgress();
        transferProgress.setTotalBytesToTransfer(TransferManagerUtils.getContentLength(putObjectRequest));
        S3ProgressListenerChain s3ProgressListenerChain = new S3ProgressListenerChain(new TransferProgressUpdatingListener(transferProgress), putObjectRequest.getGeneralProgressListener(), s3ProgressListener);
        putObjectRequest.setGeneralProgressListener(s3ProgressListenerChain);
        UploadImpl uploadImpl = new UploadImpl(str, transferProgress, s3ProgressListenerChain, transferStateChangeListener);
        UploadMonitor uploadMonitor = new UploadMonitor(this, uploadImpl, this.threadPool, new UploadCallable(this, this.threadPool, uploadImpl, putObjectRequest, s3ProgressListenerChain, multipartUploadId, transferProgress), putObjectRequest, s3ProgressListenerChain);
        uploadMonitor.setTimedThreadPool(this.timedThreadPool);
        uploadImpl.setMonitor(uploadMonitor);
        return uploadImpl;
    }

    public Download download(String str, String str2, File file) {
        return download(new GetObjectRequest(str, str2), file);
    }

    public Download download(GetObjectRequest getObjectRequest, File file) {
        return doDownload(getObjectRequest, file, null, null, false);
    }

    public Download download(GetObjectRequest getObjectRequest, File file, S3ProgressListener s3ProgressListener) {
        return doDownload(getObjectRequest, file, null, s3ProgressListener, false);
    }

    private Download doDownload(GetObjectRequest getObjectRequest, File file, TransferStateChangeListener transferStateChangeListener, S3ProgressListener s3ProgressListener, boolean z) throws AmazonClientException {
        long j;
        appendSingleObjectUserAgent(getObjectRequest);
        String str = "Downloading from " + getObjectRequest.getBucketName() + "/" + getObjectRequest.getKey();
        TransferProgress transferProgress = new TransferProgress();
        S3ProgressListenerChain s3ProgressListenerChain = new S3ProgressListenerChain(new TransferProgressUpdatingListener(transferProgress), getObjectRequest.getGeneralProgressListener(), s3ProgressListener);
        getObjectRequest.setGeneralProgressListener(new ProgressListenerChain(new ProgressListenerChain.ProgressEventFilter() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.1
            @Override // com.amazonaws.event.ProgressListenerChain.ProgressEventFilter
            public ProgressEvent filter(ProgressEvent progressEvent) {
                if (progressEvent.getEventCode() == 4) {
                    progressEvent.setEventCode(0);
                }
                return progressEvent;
            }
        }, s3ProgressListenerChain));
        GetObjectMetadataRequest getObjectMetadataRequest = new GetObjectMetadataRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey());
        if (getObjectRequest.getSSECustomerKey() != null) {
            getObjectMetadataRequest.setSSECustomerKey(getObjectRequest.getSSECustomerKey());
        }
        ObjectMetadata objectMetadata = this.s3.getObjectMetadata(getObjectMetadataRequest);
        DownloadImpl downloadImpl = new DownloadImpl(str, transferProgress, s3ProgressListenerChain, null, transferStateChangeListener, getObjectRequest, file);
        long contentLength = objectMetadata.getContentLength() - 1;
        if (getObjectRequest.getRange() == null || getObjectRequest.getRange().length != 2) {
            j = 0;
        } else {
            long j2 = getObjectRequest.getRange()[0];
            contentLength = getObjectRequest.getRange()[1];
            j = j2;
        }
        long j3 = (contentLength - j) + 1;
        transferProgress.setTotalBytesToTransfer(j3);
        if (z && file.exists()) {
            long length = file.length();
            long j4 = j + length;
            getObjectRequest.setRange(j4, contentLength);
            transferProgress.updateProgress(Math.min(length, j3));
            j3 = (contentLength - j4) + 1;
        }
        if (j3 < 0) {
            throw new IllegalArgumentException("Unable to determine the range for download operation.");
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        downloadImpl.setMonitor(new DownloadMonitor(downloadImpl, submitDownloadTask(getObjectRequest, file, z, countDownLatch, downloadImpl)));
        countDownLatch.countDown();
        return downloadImpl;
    }

    private Future submitDownloadTask(final GetObjectRequest getObjectRequest, final File file, final boolean z, final CountDownLatch countDownLatch, final DownloadImpl downloadImpl) {
        return this.threadPool.submit(new Callable<Object>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.2
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                try {
                    countDownLatch.await();
                    downloadImpl.setState(Transfer.TransferState.InProgress);
                    if (ServiceUtils.retryableDownloadS3ObjectToFile(file, new ServiceUtils.RetryableS3DownloadTask() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.2.1
                        @Override // com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask
                        public S3Object getS3ObjectStream() throws AmazonClientException {
                            S3Object object = TransferManager.this.s3.getObject(getObjectRequest);
                            downloadImpl.setS3Object(object);
                            return object;
                        }

                        @Override // com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask
                        public boolean needIntegrityCheck() {
                            return (ServiceUtils.skipMd5CheckPerRequest(getObjectRequest) || (TransferManager.this.s3 instanceof AmazonS3EncryptionClient)) ? false : true;
                        }
                    }, z) == null) {
                        downloadImpl.setState(Transfer.TransferState.Canceled);
                        DownloadImpl downloadImpl2 = downloadImpl;
                        downloadImpl2.setMonitor(new DownloadMonitor(downloadImpl2, null));
                        return downloadImpl;
                    }
                    downloadImpl.setState(Transfer.TransferState.Completed);
                    return Boolean.TRUE;
                } catch (Throwable th) {
                    if (downloadImpl.getState() != Transfer.TransferState.Canceled) {
                        downloadImpl.setState(Transfer.TransferState.Failed);
                    }
                    if (th instanceof Exception) {
                        throw ((Exception) th);
                    }
                    throw ((Error) th);
                }
            }
        });
    }

    public MultipleFileDownload downloadDirectory(String str, String str2, File file) throws AmazonClientException {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        LinkedList<S3ObjectSummary> linkedList = new LinkedList();
        Stack stack = new Stack();
        stack.add(str3);
        long size = 0;
        do {
            String str4 = (String) stack.pop();
            ObjectListing objectListingListNextBatchOfObjects = null;
            do {
                if (objectListingListNextBatchOfObjects == null) {
                    objectListingListNextBatchOfObjects = this.s3.listObjects(new ListObjectsRequest().withBucketName(str).withDelimiter("/").withPrefix(str4));
                } else {
                    objectListingListNextBatchOfObjects = this.s3.listNextBatchOfObjects(objectListingListNextBatchOfObjects);
                }
                for (S3ObjectSummary s3ObjectSummary : objectListingListNextBatchOfObjects.getObjectSummaries()) {
                    if (!s3ObjectSummary.getKey().equals(str4)) {
                        if (!objectListingListNextBatchOfObjects.getCommonPrefixes().contains(s3ObjectSummary.getKey() + "/")) {
                            linkedList.add(s3ObjectSummary);
                            size += s3ObjectSummary.getSize();
                        }
                    }
                    log.debug("Skipping download for object " + s3ObjectSummary.getKey() + " since it is also a virtual directory");
                }
                stack.addAll(objectListingListNextBatchOfObjects.getCommonPrefixes());
            } while (objectListingListNextBatchOfObjects.isTruncated());
        } while (!stack.isEmpty());
        ProgressListenerChain progressListenerChain = new ProgressListenerChain(new ProgressListener[0]);
        TransferProgress transferProgress = new TransferProgress();
        transferProgress.setTotalBytesToTransfer(size);
        MultipleFileTransferProgressUpdatingListener multipleFileTransferProgressUpdatingListener = new MultipleFileTransferProgressUpdatingListener(transferProgress, progressListenerChain);
        ArrayList arrayList = new ArrayList();
        MultipleFileDownloadImpl multipleFileDownloadImpl = new MultipleFileDownloadImpl("Downloading from " + str + "/" + str3, transferProgress, progressListenerChain, str3, str, arrayList);
        multipleFileDownloadImpl.setMonitor(new MultipleFileTransferMonitor(multipleFileDownloadImpl, arrayList));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        MultipleFileTransferStateChangeListener multipleFileTransferStateChangeListener = new MultipleFileTransferStateChangeListener(countDownLatch, multipleFileDownloadImpl);
        for (S3ObjectSummary s3ObjectSummary2 : linkedList) {
            File file2 = new File(file, s3ObjectSummary2.getKey());
            File parentFile = file2.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new RuntimeException("Couldn't create parent directories for " + file2.getAbsolutePath());
            }
            arrayList.add((DownloadImpl) doDownload(new GetObjectRequest(s3ObjectSummary2.getBucketName(), s3ObjectSummary2.getKey()).withGeneralProgressListener((ProgressListener) multipleFileTransferProgressUpdatingListener), file2, multipleFileTransferStateChangeListener, null, false));
        }
        if (arrayList.isEmpty()) {
            multipleFileDownloadImpl.setState(Transfer.TransferState.Completed);
            return multipleFileDownloadImpl;
        }
        countDownLatch.countDown();
        return multipleFileDownloadImpl;
    }

    public MultipleFileUpload uploadDirectory(String str, String str2, File file, boolean z) {
        return uploadDirectory(str, str2, file, z, null);
    }

    public MultipleFileUpload uploadDirectory(String str, String str2, File file, boolean z, ObjectMetadataProvider objectMetadataProvider) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Must provide a directory to upload");
        }
        LinkedList linkedList = new LinkedList();
        listFiles(file, linkedList, z);
        return uploadFileList(str, str2, file, linkedList, objectMetadataProvider);
    }

    public MultipleFileUpload uploadFileList(String str, String str2, File file, List<File> list) {
        return uploadFileList(str, str2, file, list, null);
    }

    public MultipleFileUpload uploadFileList(String str, String str2, File file, List<File> list, ObjectMetadataProvider objectMetadataProvider) {
        String str3;
        String str4 = str2;
        ObjectMetadataProvider objectMetadataProvider2 = objectMetadataProvider;
        if (file == null || !file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Must provide a common base directory for uploaded files");
        }
        String str5 = "/";
        if (str4 == null || str2.length() == 0) {
            str4 = "";
        } else if (!str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        ProgressListenerChain progressListenerChain = new ProgressListenerChain(new ProgressListener[0]);
        TransferProgress transferProgress = new TransferProgress();
        MultipleFileTransferProgressUpdatingListener multipleFileTransferProgressUpdatingListener = new MultipleFileTransferProgressUpdatingListener(transferProgress, progressListenerChain);
        LinkedList linkedList = new LinkedList();
        MultipleFileUploadImpl multipleFileUploadImpl = new MultipleFileUploadImpl("Uploading etc", transferProgress, progressListenerChain, str4, str, linkedList);
        multipleFileUploadImpl.setMonitor(new MultipleFileTransferMonitor(multipleFileUploadImpl, linkedList));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        MultipleFileTransferStateChangeListener multipleFileTransferStateChangeListener = new MultipleFileTransferStateChangeListener(countDownLatch, multipleFileUploadImpl);
        if (list == null || list.isEmpty()) {
            multipleFileUploadImpl.setState(Transfer.TransferState.Completed);
        } else {
            int length = file.getAbsolutePath().length();
            if (!file.getAbsolutePath().endsWith(File.separator)) {
                length++;
            }
            long length2 = 0;
            for (File file2 : list) {
                if (file2.isFile()) {
                    length2 += file2.length();
                    String strReplaceAll = file2.getAbsolutePath().substring(length).replaceAll("\\\\", str5);
                    ObjectMetadata objectMetadata = new ObjectMetadata();
                    if (objectMetadataProvider2 != null) {
                        objectMetadataProvider2.provideObjectMetadata(file2, objectMetadata);
                    }
                    str3 = str5;
                    linkedList.add((UploadImpl) doUpload(new PutObjectRequest(str, str4 + strReplaceAll, file2).withMetadata(objectMetadata).withGeneralProgressListener((ProgressListener) multipleFileTransferProgressUpdatingListener), multipleFileTransferStateChangeListener, null, null));
                } else {
                    str3 = str5;
                }
                objectMetadataProvider2 = objectMetadataProvider;
                str5 = str3;
            }
            transferProgress.setTotalBytesToTransfer(length2);
        }
        countDownLatch.countDown();
        return multipleFileUploadImpl;
    }

    private void listFiles(File file, List list, boolean z) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isDirectory()) {
                    list.add(file2);
                } else if (z) {
                    listFiles(file2, list, z);
                }
            }
        }
    }

    public void abortMultipartUploads(String str, Date date) throws AmazonClientException {
        MultipartUploadListing multipartUploadListingListMultipartUploads = this.s3.listMultipartUploads((ListMultipartUploadsRequest) appendSingleObjectUserAgent(new ListMultipartUploadsRequest(str)));
        do {
            for (MultipartUpload multipartUpload : multipartUploadListingListMultipartUploads.getMultipartUploads()) {
                if (multipartUpload.getInitiated().compareTo(date) < 0) {
                    this.s3.abortMultipartUpload((AbortMultipartUploadRequest) appendSingleObjectUserAgent(new AbortMultipartUploadRequest(str, multipartUpload.getKey(), multipartUpload.getUploadId())));
                }
            }
            multipartUploadListingListMultipartUploads = this.s3.listMultipartUploads((ListMultipartUploadsRequest) appendSingleObjectUserAgent(new ListMultipartUploadsRequest(str).withUploadIdMarker(multipartUploadListingListMultipartUploads.getNextUploadIdMarker()).withKeyMarker(multipartUploadListingListMultipartUploads.getNextKeyMarker())));
        } while (multipartUploadListingListMultipartUploads.isTruncated());
    }

    public void shutdownNow() {
        shutdownNow(true);
    }

    public void shutdownNow(boolean z) {
        this.threadPool.shutdownNow();
        this.timedThreadPool.shutdownNow();
        if (z) {
            AmazonS3 amazonS3 = this.s3;
            if (amazonS3 instanceof AmazonS3Client) {
                ((AmazonS3Client) amazonS3).shutdown();
            }
        }
    }

    private void shutdown() {
        this.threadPool.shutdown();
        this.timedThreadPool.shutdown();
    }

    public static <X extends AmazonWebServiceRequest> X appendSingleObjectUserAgent(X x) {
        x.getRequestClientOptions().appendUserAgent(USER_AGENT);
        return x;
    }

    public static <X extends AmazonWebServiceRequest> X appendMultipartUserAgent(X x) {
        x.getRequestClientOptions().appendUserAgent(USER_AGENT_MULTIPART);
        return x;
    }

    public Copy copy(String str, String str2, String str3, String str4) throws AmazonClientException {
        return copy(new CopyObjectRequest(str, str2, str3, str4));
    }

    public Copy copy(CopyObjectRequest copyObjectRequest) {
        return copy(copyObjectRequest, null);
    }

    public Copy copy(CopyObjectRequest copyObjectRequest, TransferStateChangeListener transferStateChangeListener) throws AmazonClientException {
        appendSingleObjectUserAgent(copyObjectRequest);
        assertParameterNotNull(copyObjectRequest.getSourceBucketName(), "The source bucket name must be specified when a copy request is initiated.");
        assertParameterNotNull(copyObjectRequest.getSourceKey(), "The source object key must be specified when a copy request is initiated.");
        assertParameterNotNull(copyObjectRequest.getDestinationBucketName(), "The destination bucket name must be specified when a copy request is initiated.");
        assertParameterNotNull(copyObjectRequest.getDestinationKey(), "The destination object key must be specified when a copy request is initiated.");
        String str = "Copying object from " + copyObjectRequest.getSourceBucketName() + "/" + copyObjectRequest.getSourceKey() + " to " + copyObjectRequest.getDestinationBucketName() + "/" + copyObjectRequest.getDestinationKey();
        ObjectMetadata objectMetadata = this.s3.getObjectMetadata(new GetObjectMetadataRequest(copyObjectRequest.getSourceBucketName(), copyObjectRequest.getSourceKey()).withSSECustomerKey(copyObjectRequest.getSourceSSECustomerKey()));
        TransferProgress transferProgress = new TransferProgress();
        transferProgress.setTotalBytesToTransfer(objectMetadata.getContentLength());
        ProgressListenerChain progressListenerChain = new ProgressListenerChain(new TransferProgressUpdatingListener(transferProgress));
        CopyImpl copyImpl = new CopyImpl(str, transferProgress, progressListenerChain, transferStateChangeListener);
        CopyMonitor copyMonitor = new CopyMonitor(this, copyImpl, this.threadPool, new CopyCallable(this, this.threadPool, copyImpl, copyObjectRequest, objectMetadata, progressListenerChain), copyObjectRequest, progressListenerChain);
        copyMonitor.setTimedThreadPool(this.timedThreadPool);
        copyImpl.setMonitor(copyMonitor);
        return copyImpl;
    }

    public Upload resumeUpload(PersistableUpload persistableUpload) {
        assertParameterNotNull(persistableUpload, "PauseUpload is mandatory to resume a upload.");
        this.configuration.setMinimumUploadPartSize(persistableUpload.getPartSize());
        this.configuration.setMultipartUploadThreshold(persistableUpload.getMutlipartUploadThreshold());
        return doUpload(new PutObjectRequest(persistableUpload.getBucketName(), persistableUpload.getKey(), new File(persistableUpload.getFile())), null, null, persistableUpload);
    }

    public Download resumeDownload(PersistableDownload persistableDownload) {
        assertParameterNotNull(persistableDownload, "PausedDownload is mandatory to resume a download.");
        GetObjectRequest getObjectRequest = new GetObjectRequest(persistableDownload.getBucketName(), persistableDownload.getKey(), persistableDownload.getVersionId());
        if (persistableDownload.getRange() != null && persistableDownload.getRange().length == 2) {
            long[] range = persistableDownload.getRange();
            getObjectRequest.setRange(range[0], range[1]);
        }
        getObjectRequest.setRequesterPays(persistableDownload.isRequesterPays());
        getObjectRequest.setResponseHeaders(persistableDownload.getResponseHeaders());
        return doDownload(getObjectRequest, new File(persistableDownload.getFile()), null, null, true);
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    protected void finalize() throws Throwable {
        shutdown();
    }
}
