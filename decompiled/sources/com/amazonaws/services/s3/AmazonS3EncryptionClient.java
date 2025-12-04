package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.internal.MultiFileOutputStream;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.internal.crypto.CryptoModuleDispatcher;
import com.amazonaws.services.s3.internal.crypto.S3CryptoModule;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectId;
import com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Deprecated
/* loaded from: classes2.dex */
public class AmazonS3EncryptionClient extends AmazonS3Client implements AmazonS3Encryption {
    public static final String USER_AGENT = AmazonS3EncryptionClient.class.getName() + "/" + VersionInfoUtils.getVersion();
    private final S3CryptoModule crypto;
    private final boolean isKMSClientInternal;
    private final AWSKMSClient kms;

    public AmazonS3EncryptionClient(EncryptionMaterials encryptionMaterials) {
        this(new StaticEncryptionMaterialsProvider(encryptionMaterials));
    }

    public AmazonS3EncryptionClient(EncryptionMaterialsProvider encryptionMaterialsProvider) {
        this((AWSCredentialsProvider) null, encryptionMaterialsProvider, new ClientConfiguration(), new CryptoConfiguration());
    }

    public AmazonS3EncryptionClient(EncryptionMaterials encryptionMaterials, CryptoConfiguration cryptoConfiguration) {
        this(new StaticEncryptionMaterialsProvider(encryptionMaterials), cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this((AWSCredentialsProvider) null, encryptionMaterialsProvider, new ClientConfiguration(), cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(AWSCredentials aWSCredentials, EncryptionMaterials encryptionMaterials) {
        this(aWSCredentials, new StaticEncryptionMaterialsProvider(encryptionMaterials));
    }

    public AmazonS3EncryptionClient(AWSCredentials aWSCredentials, EncryptionMaterialsProvider encryptionMaterialsProvider) {
        this(aWSCredentials, encryptionMaterialsProvider, new ClientConfiguration(), new CryptoConfiguration());
    }

    public AmazonS3EncryptionClient(AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider) {
        this(aWSCredentialsProvider, encryptionMaterialsProvider, new ClientConfiguration(), new CryptoConfiguration());
    }

    public AmazonS3EncryptionClient(AWSCredentials aWSCredentials, EncryptionMaterials encryptionMaterials, CryptoConfiguration cryptoConfiguration) {
        this(aWSCredentials, new StaticEncryptionMaterialsProvider(encryptionMaterials), cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(AWSCredentials aWSCredentials, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(aWSCredentials, encryptionMaterialsProvider, new ClientConfiguration(), cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(aWSCredentialsProvider, encryptionMaterialsProvider, new ClientConfiguration(), cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(AWSCredentials aWSCredentials, EncryptionMaterials encryptionMaterials, ClientConfiguration clientConfiguration, CryptoConfiguration cryptoConfiguration) {
        this(aWSCredentials, new StaticEncryptionMaterialsProvider(encryptionMaterials), clientConfiguration, cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(AWSCredentials aWSCredentials, EncryptionMaterialsProvider encryptionMaterialsProvider, ClientConfiguration clientConfiguration, CryptoConfiguration cryptoConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), encryptionMaterialsProvider, clientConfiguration, cryptoConfiguration);
    }

    public AmazonS3EncryptionClient(AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, ClientConfiguration clientConfiguration, CryptoConfiguration cryptoConfiguration) {
        this(aWSCredentialsProvider, encryptionMaterialsProvider, clientConfiguration, cryptoConfiguration, null);
    }

    public AmazonS3EncryptionClient(AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, ClientConfiguration clientConfiguration, CryptoConfiguration cryptoConfiguration, RequestMetricCollector requestMetricCollector) {
        this(null, aWSCredentialsProvider, encryptionMaterialsProvider, clientConfiguration, cryptoConfiguration, requestMetricCollector);
    }

    public AmazonS3EncryptionClient(AWSKMSClient aWSKMSClient, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, ClientConfiguration clientConfiguration, CryptoConfiguration cryptoConfiguration, RequestMetricCollector requestMetricCollector) {
        super(aWSCredentialsProvider, clientConfiguration, requestMetricCollector);
        assertParameterNotNull(encryptionMaterialsProvider, "EncryptionMaterialsProvider parameter must not be null.");
        assertParameterNotNull(cryptoConfiguration, "CryptoConfiguration parameter must not be null.");
        boolean z = aWSKMSClient == null;
        this.isKMSClientInternal = z;
        AWSKMSClient aWSKMSClientNewAWSKMSClient = z ? newAWSKMSClient(aWSCredentialsProvider, clientConfiguration, cryptoConfiguration, requestMetricCollector) : aWSKMSClient;
        this.kms = aWSKMSClientNewAWSKMSClient;
        this.crypto = new CryptoModuleDispatcher(aWSKMSClientNewAWSKMSClient, new S3DirectImpl(), aWSCredentialsProvider, encryptionMaterialsProvider, cryptoConfiguration);
    }

    private AWSKMSClient newAWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, CryptoConfiguration cryptoConfiguration, RequestMetricCollector requestMetricCollector) {
        AWSKMSClient aWSKMSClient = new AWSKMSClient(aWSCredentialsProvider, clientConfiguration, requestMetricCollector);
        Region awsKmsRegion = cryptoConfiguration.getAwsKmsRegion();
        if (awsKmsRegion != null) {
            aWSKMSClient.setRegion(awsKmsRegion);
        }
        return aWSKMSClient;
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public PutObjectResult putObject(PutObjectRequest putObjectRequest) {
        return this.crypto.putObjectSecurely(putObjectRequest.mo649clone());
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public S3Object getObject(GetObjectRequest getObjectRequest) {
        return this.crypto.getObjectSecurely(getObjectRequest);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
        return this.crypto.getObjectSecurely(getObjectRequest, file);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3
    public void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException {
        deleteObjectRequest.getRequestClientOptions().appendUserAgent(USER_AGENT);
        super.deleteObject(deleteObjectRequest);
        InstructionFileId instructionFileId = new S3ObjectId(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey()).instructionFileId();
        DeleteObjectRequest deleteObjectRequest2 = (DeleteObjectRequest) deleteObjectRequest.mo649clone();
        deleteObjectRequest2.withBucketName(instructionFileId.getBucket()).withKey(instructionFileId.getKey());
        super.deleteObject(deleteObjectRequest2);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        return this.crypto.completeMultipartUploadSecurely(completeMultipartUploadRequest);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        if (initiateMultipartUploadRequest instanceof EncryptedInitiateMultipartUploadRequest ? ((EncryptedInitiateMultipartUploadRequest) initiateMultipartUploadRequest).isCreateEncryptionMaterial() : true) {
            return this.crypto.initiateMultipartUploadSecurely(initiateMultipartUploadRequest);
        }
        return super.initiateMultipartUpload(initiateMultipartUploadRequest);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws AmazonClientException {
        return this.crypto.uploadPartSecurely(uploadPartRequest);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public CopyPartResult copyPart(CopyPartRequest copyPartRequest) {
        return this.crypto.copyPartSecurely(copyPartRequest);
    }

    @Override // com.amazonaws.services.s3.AmazonS3Client, com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        this.crypto.abortMultipartUploadSecurely(abortMultipartUploadRequest);
    }

    public PutObjectResult putInstructionFile(PutInstructionFileRequest putInstructionFileRequest) {
        return this.crypto.putInstructionFileSecurely(putInstructionFileRequest);
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void shutdown() {
        super.shutdown();
        if (this.isKMSClientInternal) {
            this.kms.shutdown();
        }
    }

    private final class S3DirectImpl extends S3Direct {
        private S3DirectImpl() {
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public PutObjectResult putObject(PutObjectRequest putObjectRequest) {
            return AmazonS3EncryptionClient.super.putObject(putObjectRequest);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public S3Object getObject(GetObjectRequest getObjectRequest) {
            return AmazonS3EncryptionClient.super.getObject(getObjectRequest);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
            return AmazonS3EncryptionClient.super.getObject(getObjectRequest, file);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
            return AmazonS3EncryptionClient.super.completeMultipartUpload(completeMultipartUploadRequest);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
            return AmazonS3EncryptionClient.super.initiateMultipartUpload(initiateMultipartUploadRequest);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) {
            return AmazonS3EncryptionClient.super.uploadPart(uploadPartRequest);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public CopyPartResult copyPart(CopyPartRequest copyPartRequest) {
            return AmazonS3EncryptionClient.super.copyPart(copyPartRequest);
        }

        @Override // com.amazonaws.services.s3.internal.S3Direct, com.amazonaws.services.s3.internal.S3DirectSpi
        public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException {
            AmazonS3EncryptionClient.super.abortMultipartUpload(abortMultipartUploadRequest);
        }
    }

    /* JADX WARN: Finally extract failed */
    public CompleteMultipartUploadResult uploadObject(UploadObjectRequest uploadObjectRequest) throws ExecutionException, InterruptedException, IOException {
        ExecutorService executorService = uploadObjectRequest.getExecutorService();
        boolean z = executorService == null;
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(this.clientConfiguration.getMaxConnections());
        }
        UploadObjectObserver uploadObjectObserver = uploadObjectRequest.getUploadObjectObserver();
        if (uploadObjectObserver == null) {
            uploadObjectObserver = new UploadObjectObserver();
        }
        uploadObjectObserver.init(uploadObjectRequest, new S3DirectImpl(), this, executorService);
        String strOnUploadInitiation = uploadObjectObserver.onUploadInitiation(uploadObjectRequest);
        ArrayList arrayList = new ArrayList();
        MultiFileOutputStream multiFileOutputStream = uploadObjectRequest.getMultiFileOutputStream();
        if (multiFileOutputStream == null) {
            multiFileOutputStream = new MultiFileOutputStream();
        }
        MultiFileOutputStream multiFileOutputStream2 = multiFileOutputStream;
        try {
            try {
                try {
                    try {
                        multiFileOutputStream2.init(uploadObjectObserver, uploadObjectRequest.getPartSize(), uploadObjectRequest.getDiskLimit());
                        this.crypto.putLocalObjectSecurely(uploadObjectRequest, strOnUploadInitiation, multiFileOutputStream2);
                        Iterator<Future<UploadPartResult>> it = uploadObjectObserver.getFutures().iterator();
                        while (it.hasNext()) {
                            UploadPartResult uploadPartResult = it.next().get();
                            arrayList.add(new PartETag(uploadPartResult.getPartNumber(), uploadPartResult.getETag()));
                        }
                        if (z) {
                            executorService.shutdownNow();
                        }
                        multiFileOutputStream2.cleanup();
                        return uploadObjectObserver.onCompletion(arrayList);
                    } catch (Error e) {
                        throw ((Error) onAbort(uploadObjectObserver, e));
                    } catch (RuntimeException e2) {
                        throw ((RuntimeException) onAbort(uploadObjectObserver, e2));
                    }
                } catch (IOException e3) {
                    throw ((IOException) onAbort(uploadObjectObserver, e3));
                } catch (InterruptedException e4) {
                    throw ((InterruptedException) onAbort(uploadObjectObserver, e4));
                }
            } catch (ExecutionException e5) {
                throw ((ExecutionException) onAbort(uploadObjectObserver, e5));
            }
        } catch (Throwable th) {
            if (z) {
                executorService.shutdownNow();
            }
            multiFileOutputStream2.cleanup();
            throw th;
        }
    }

    private Throwable onAbort(UploadObjectObserver uploadObjectObserver, Throwable th) {
        uploadObjectObserver.onAbort();
        return th;
    }
}
