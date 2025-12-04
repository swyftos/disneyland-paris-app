package com.allegion.logging.filelogging.s3upload;

import android.app.Activity;
import com.allegion.logging.filelogging.AlLogFileManager;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/allegion/logging/filelogging/s3upload/S3UploadFileLog;", "", "logFileManager", "Lcom/allegion/logging/filelogging/AlLogFileManager;", "(Lcom/allegion/logging/filelogging/AlLogFileManager;)V", "upload", "", "activity", "Landroid/app/Activity;", "zipFile", "Ljava/io/File;", "alTransferListener", "Lcom/allegion/logging/filelogging/s3upload/AlTransferListener;", "als3Config", "Lcom/allegion/logging/filelogging/s3upload/S3UploadFileLog$AlS3UploadConfig;", "uploadLogs", "AlS3UploadConfig", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class S3UploadFileLog {
    private final AlLogFileManager logFileManager;

    public S3UploadFileLog(@NotNull AlLogFileManager logFileManager) {
        Intrinsics.checkParameterIsNotNull(logFileManager, "logFileManager");
        this.logFileManager = logFileManager;
    }

    public final void uploadLogs(@Nullable Activity activity, @NotNull AlTransferListener alTransferListener, @NotNull AlS3UploadConfig als3Config) {
        Intrinsics.checkParameterIsNotNull(alTransferListener, "alTransferListener");
        Intrinsics.checkParameterIsNotNull(als3Config, "als3Config");
        if (activity == null) {
            return;
        }
        try {
            AlLogFileManager alLogFileManager = this.logFileManager;
            File zippedLogFiles = alLogFileManager.getZippedLogFiles(activity, alLogFileManager.getZipFilePath(AlS3UploadConfig.INSTANCE.getFileName()));
            if (zippedLogFiles == null) {
                Intrinsics.throwUninitializedPropertyAccessException("zipFile");
            }
            if (zippedLogFiles.exists() && zippedLogFiles.length() > 0) {
                upload(activity, zippedLogFiles, alTransferListener, als3Config);
            } else if (zippedLogFiles.exists() && zippedLogFiles.delete()) {
                Timber.e("Partial zip file created - [DELETED]", new Object[0]);
            }
        } catch (RuntimeException e) {
            alTransferListener.onError(0, e);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/allegion/logging/filelogging/s3upload/S3UploadFileLog$AlS3UploadConfig;", "", "()V", "awsCredentials", "Lcom/amazonaws/auth/AWSCredentials;", "getAwsCredentials", "()Lcom/amazonaws/auth/AWSCredentials;", "setAwsCredentials", "(Lcom/amazonaws/auth/AWSCredentials;)V", "bucketName", "", "getBucketName", "()Ljava/lang/String;", "setBucketName", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "objectMetadata", "Lcom/amazonaws/services/s3/model/ObjectMetadata;", "getObjectMetadata", "()Lcom/amazonaws/services/s3/model/ObjectMetadata;", "setObjectMetadata", "(Lcom/amazonaws/services/s3/model/ObjectMetadata;)V", "region", "Lcom/amazonaws/regions/Regions;", "getRegion", "()Lcom/amazonaws/regions/Regions;", "setRegion", "(Lcom/amazonaws/regions/Regions;)V", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
    public static final class AlS3UploadConfig {

        @NotNull
        public static AWSCredentials awsCredentials;

        @NotNull
        public static String bucketName;
        public static final AlS3UploadConfig INSTANCE = new AlS3UploadConfig();

        @NotNull
        private static String fileName = "UNKNOWN";

        @NotNull
        private static ObjectMetadata objectMetadata = new ObjectMetadata();

        @NotNull
        private static Regions region = Regions.US_WEST_2;

        private AlS3UploadConfig() {
        }

        @NotNull
        public final AWSCredentials getAwsCredentials() {
            AWSCredentials aWSCredentials = awsCredentials;
            if (aWSCredentials == null) {
                Intrinsics.throwUninitializedPropertyAccessException("awsCredentials");
            }
            return aWSCredentials;
        }

        public final void setAwsCredentials(@NotNull AWSCredentials aWSCredentials) {
            Intrinsics.checkParameterIsNotNull(aWSCredentials, "<set-?>");
            awsCredentials = aWSCredentials;
        }

        @NotNull
        public final String getFileName() {
            return fileName;
        }

        public final void setFileName(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            fileName = str;
        }

        @NotNull
        public final String getBucketName() {
            String str = bucketName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bucketName");
            }
            return str;
        }

        public final void setBucketName(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            bucketName = str;
        }

        @NotNull
        public final ObjectMetadata getObjectMetadata() {
            return objectMetadata;
        }

        public final void setObjectMetadata(@NotNull ObjectMetadata objectMetadata2) {
            Intrinsics.checkParameterIsNotNull(objectMetadata2, "<set-?>");
            objectMetadata = objectMetadata2;
        }

        @NotNull
        public final Regions getRegion() {
            return region;
        }

        public final void setRegion(@NotNull Regions regions) {
            Intrinsics.checkParameterIsNotNull(regions, "<set-?>");
            region = regions;
        }
    }

    private final void upload(Activity activity, final File zipFile, final AlTransferListener alTransferListener, AlS3UploadConfig als3Config) {
        TransferUtility transferUtilityBuild = TransferUtility.builder().context(activity).s3Client(new AmazonS3Client(new StaticCredentialsProvider(als3Config.getAwsCredentials()), Region.getRegion(als3Config.getRegion()))).build();
        Intrinsics.checkExpressionValueIsNotNull(transferUtilityBuild, "TransferUtility.builder(…   )\n            .build()");
        TransferObserver transferObserverUpload = transferUtilityBuild.upload(als3Config.getBucketName(), zipFile.getName(), zipFile, als3Config.getObjectMetadata());
        Intrinsics.checkExpressionValueIsNotNull(transferObserverUpload, "transferUtility.upload(\n….objectMetadata\n        )");
        transferObserverUpload.setTransferListener(new TransferListener() { // from class: com.allegion.logging.filelogging.s3upload.S3UploadFileLog.upload.1
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onStateChanged(int id, @Nullable TransferState state) {
                if (TransferState.COMPLETED == state) {
                    Timber.e("Log Zip file [UPLOAD COMPLETED]", new Object[0]);
                    if (zipFile.exists() && zipFile.delete()) {
                        Timber.e("Log Zip file [DELETED]", new Object[0]);
                    }
                    alTransferListener.onStateChanged(id, state);
                }
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                Timber.d("Log zip file [UPLOAD PROGRESS: %d perc]", Integer.valueOf((int) ((bytesCurrent / bytesTotal) * 100)));
                alTransferListener.onProgressChanged(id, bytesCurrent, bytesTotal);
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onError(int id, @Nullable Exception ex) {
                Timber.e("Log Zip file [UPLOAD FAILED]: " + ex, new Object[0]);
                if (zipFile.exists() && zipFile.delete()) {
                    Timber.e("Log Zip file [DELETED]", new Object[0]);
                }
                alTransferListener.onError(id, ex);
            }
        });
    }
}
