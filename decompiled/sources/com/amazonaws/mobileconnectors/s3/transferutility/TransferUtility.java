package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import androidx.media3.datasource.cache.CacheDataSink;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TransferUtility {
    final ConnectivityManager connManager;
    private TransferDBUtil dbUtil;
    private final String defaultBucket;
    private final AmazonS3 s3;
    private final TransferUtilityOptions transferUtilityOptions;
    private TransferStatusUpdater updater;
    private static final Log LOGGER = LogFactory.getLog(TransferUtility.class);
    private static final Object LOCK = new Object();
    private static String userAgentFromConfig = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static void setUserAgentFromConfig(String str) {
        synchronized (LOCK) {
            userAgentFromConfig = str;
        }
    }

    private static String getUserAgentFromConfig() {
        synchronized (LOCK) {
            try {
                String str = userAgentFromConfig;
                if (str != null && !str.trim().isEmpty()) {
                    return userAgentFromConfig.trim() + "/";
                }
                return "";
            } finally {
            }
        }
    }

    public static class Builder {
        private Context appContext;
        private AWSConfiguration awsConfig;
        private String defaultBucket;
        private AmazonS3 s3;
        private TransferUtilityOptions transferUtilityOptions;

        protected Builder() {
        }

        public Builder s3Client(AmazonS3 amazonS3) {
            this.s3 = amazonS3;
            return this;
        }

        public Builder context(Context context) {
            this.appContext = context.getApplicationContext();
            return this;
        }

        public Builder defaultBucket(String str) {
            this.defaultBucket = str;
            return this;
        }

        public Builder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfig = aWSConfiguration;
            return this;
        }

        public Builder transferUtilityOptions(TransferUtilityOptions transferUtilityOptions) {
            this.transferUtilityOptions = transferUtilityOptions;
            return this;
        }

        public TransferUtility build() {
            if (this.s3 == null) {
                throw new IllegalArgumentException("AmazonS3 client is required please set using .s3Client(yourClient)");
            }
            if (this.appContext == null) {
                throw new IllegalArgumentException("Context is required please set using .context(applicationContext)");
            }
            AWSConfiguration aWSConfiguration = this.awsConfig;
            if (aWSConfiguration != null) {
                try {
                    JSONObject jSONObjectOptJsonObject = aWSConfiguration.optJsonObject("S3TransferUtility");
                    this.s3.setRegion(Region.getRegion(jSONObjectOptJsonObject.getString("Region")));
                    this.defaultBucket = jSONObjectOptJsonObject.getString("Bucket");
                    if (jSONObjectOptJsonObject.has(Constants.LOCAL_TESTING_FLAG_NAME) ? jSONObjectOptJsonObject.getBoolean(Constants.LOCAL_TESTING_FLAG_NAME) : false) {
                        this.s3.setEndpoint(Constants.LOCAL_TESTING_ENDPOINT);
                        this.s3.setS3ClientOptions(S3ClientOptions.builder().setPathStyleAccess(true).skipContentMd5Check(true).build());
                    }
                    TransferUtility.setUserAgentFromConfig(this.awsConfig.getUserAgent());
                } catch (Exception e) {
                    throw new IllegalArgumentException("Failed to read S3TransferUtility please check your setup or awsconfiguration.json file", e);
                }
            }
            if (this.transferUtilityOptions == null) {
                this.transferUtilityOptions = new TransferUtilityOptions();
            }
            return new TransferUtility(this.s3, this.appContext, this.defaultBucket, this.transferUtilityOptions);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private TransferUtility(AmazonS3 amazonS3, Context context, String str, TransferUtilityOptions transferUtilityOptions) {
        this.s3 = amazonS3;
        this.defaultBucket = str;
        this.transferUtilityOptions = transferUtilityOptions;
        this.dbUtil = new TransferDBUtil(context.getApplicationContext());
        this.updater = TransferStatusUpdater.getInstance(context.getApplicationContext());
        TransferThreadPool.init(transferUtilityOptions.getTransferThreadPoolSize());
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    @Deprecated
    public TransferUtility(AmazonS3 amazonS3, Context context) {
        this.s3 = amazonS3;
        this.defaultBucket = null;
        TransferUtilityOptions transferUtilityOptions = new TransferUtilityOptions();
        this.transferUtilityOptions = transferUtilityOptions;
        this.dbUtil = new TransferDBUtil(context.getApplicationContext());
        this.updater = TransferStatusUpdater.getInstance(context.getApplicationContext());
        TransferThreadPool.init(transferUtilityOptions.getTransferThreadPoolSize());
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    private String getDefaultBucketOrThrow() {
        String str = this.defaultBucket;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("TransferUtility has not been configured with a default bucket. Please use the corresponding method that specifies bucket name or configure the default bucket name in construction of the object. See TransferUtility.builder().defaultBucket() or TransferUtility.builder().awsConfiguration()");
    }

    public TransferObserver download(String str, String str2, File file) {
        return download(str, str2, file, null);
    }

    public TransferObserver download(String str, File file) {
        return download(getDefaultBucketOrThrow(), str, file, null);
    }

    public TransferObserver download(String str, String str2, File file, TransferListener transferListener) throws NumberFormatException {
        if (file == null || file.isDirectory()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        int i = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.DOWNLOAD, str, str2, file, this.transferUtilityOptions).getLastPathSegment());
        if (file.isFile()) {
            LOGGER.warn("Overwrite existing file: " + file);
            file.delete();
        }
        TransferObserver transferObserver = new TransferObserver(i, this.dbUtil, str, str2, file, transferListener);
        submitTransferJob("add_transfer", i);
        return transferObserver;
    }

    public TransferObserver download(String str, File file, TransferListener transferListener) {
        return download(getDefaultBucketOrThrow(), str, file, transferListener);
    }

    public TransferObserver upload(String str, String str2, File file) {
        return upload(str, str2, file, new ObjectMetadata());
    }

    public TransferObserver upload(String str, File file) {
        return upload(getDefaultBucketOrThrow(), str, file, new ObjectMetadata());
    }

    public TransferObserver upload(String str, String str2, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(getDefaultBucketOrThrow(), str, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return upload(str, str2, file, objectMetadata, (CannedAccessControlList) null);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, (CannedAccessControlList) null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) throws NumberFormatException {
        int iCreateMultipartUploadRecords;
        if (file == null || file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        if (shouldUploadInMultipart(file)) {
            iCreateMultipartUploadRecords = createMultipartUploadRecords(str, str2, file, objectMetadata, cannedAccessControlList);
        } else {
            iCreateMultipartUploadRecords = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList, this.transferUtilityOptions).getLastPathSegment());
        }
        TransferObserver transferObserver = new TransferObserver(iCreateMultipartUploadRecords, this.dbUtil, str, str2, file, transferListener);
        submitTransferJob("add_transfer", iCreateMultipartUploadRecords);
        return transferObserver;
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, cannedAccessControlList, transferListener);
    }

    public TransferObserver getTransferById(int i) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQueryTransferById = this.dbUtil.queryTransferById(i);
            try {
                if (!cursorQueryTransferById.moveToNext()) {
                    cursorQueryTransferById.close();
                    return null;
                }
                TransferObserver transferObserver = new TransferObserver(i, this.dbUtil);
                transferObserver.updateFromDB(cursorQueryTransferById);
                cursorQueryTransferById.close();
                return transferObserver;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQueryTransferById;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public List<TransferObserver> getTransfersWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQueryAllTransfersWithType = null;
        try {
            cursorQueryAllTransfersWithType = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursorQueryAllTransfersWithType.moveToNext()) {
                TransferObserver transferObserver = new TransferObserver(cursorQueryAllTransfersWithType.getInt(cursorQueryAllTransfersWithType.getColumnIndexOrThrow("_id")), this.dbUtil);
                transferObserver.updateFromDB(cursorQueryAllTransfersWithType);
                arrayList.add(transferObserver);
            }
            cursorQueryAllTransfersWithType.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQueryAllTransfersWithType != null) {
                cursorQueryAllTransfersWithType.close();
            }
            throw th;
        }
    }

    public List<TransferObserver> getTransfersWithTypeAndState(TransferType transferType, TransferState transferState) {
        return getTransfersWithTypeAndStates(transferType, new TransferState[]{transferState});
    }

    public List<TransferObserver> getTransfersWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQueryTransfersWithTypeAndStates = null;
        try {
            cursorQueryTransfersWithTypeAndStates = this.dbUtil.queryTransfersWithTypeAndStates(transferType, transferStateArr);
            while (cursorQueryTransfersWithTypeAndStates.moveToNext()) {
                if (cursorQueryTransfersWithTypeAndStates.getInt(cursorQueryTransfersWithTypeAndStates.getColumnIndexOrThrow("part_num")) == 0) {
                    TransferObserver transferObserver = new TransferObserver(cursorQueryTransfersWithTypeAndStates.getInt(cursorQueryTransfersWithTypeAndStates.getColumnIndexOrThrow("_id")), this.dbUtil);
                    transferObserver.updateFromDB(cursorQueryTransfersWithTypeAndStates);
                    arrayList.add(transferObserver);
                }
            }
            cursorQueryTransfersWithTypeAndStates.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQueryTransfersWithTypeAndStates != null) {
                cursorQueryTransfersWithTypeAndStates.close();
            }
            throw th;
        }
    }

    private List getTransferIdsWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQueryTransfersWithTypeAndStates = null;
        try {
            cursorQueryTransfersWithTypeAndStates = this.dbUtil.queryTransfersWithTypeAndStates(transferType, transferStateArr);
            while (cursorQueryTransfersWithTypeAndStates.moveToNext()) {
                if (cursorQueryTransfersWithTypeAndStates.getInt(cursorQueryTransfersWithTypeAndStates.getColumnIndexOrThrow("part_num")) == 0) {
                    arrayList.add(Integer.valueOf(cursorQueryTransfersWithTypeAndStates.getInt(cursorQueryTransfersWithTypeAndStates.getColumnIndexOrThrow("_id"))));
                }
            }
            cursorQueryTransfersWithTypeAndStates.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQueryTransfersWithTypeAndStates != null) {
                cursorQueryTransfersWithTypeAndStates.close();
            }
            throw th;
        }
    }

    private int createMultipartUploadRecords(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        long length = file.length();
        double d = length;
        long jMax = (long) Math.max(Math.ceil(d / 10000.0d), 5242880.0d);
        int iCeil = ((int) Math.ceil(d / jMax)) + 1;
        ContentValues[] contentValuesArr = new ContentValues[iCeil];
        contentValuesArr[0] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, 0L, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList, this.transferUtilityOptions);
        int i = 1;
        long j = 0;
        for (int i2 = 1; i2 < iCeil; i2++) {
            long jMin = Math.min(jMax, length);
            length -= jMax;
            contentValuesArr[i2] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, j, i, "", jMin, length <= 0 ? 1 : 0, objectMetadata, cannedAccessControlList, this.transferUtilityOptions);
            j += jMax;
            i++;
        }
        return this.dbUtil.bulkInsertTransferRecords(contentValuesArr);
    }

    public boolean pause(int i) {
        submitTransferJob("pause_transfer", i);
        return true;
    }

    public void pauseAllWithType(TransferType transferType) {
        Cursor cursorQueryAllTransfersWithType = null;
        try {
            cursorQueryAllTransfersWithType = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursorQueryAllTransfersWithType.moveToNext()) {
                pause(cursorQueryAllTransfersWithType.getInt(cursorQueryAllTransfersWithType.getColumnIndexOrThrow("_id")));
            }
            cursorQueryAllTransfersWithType.close();
        } catch (Throwable th) {
            if (cursorQueryAllTransfersWithType != null) {
                cursorQueryAllTransfersWithType.close();
            }
            throw th;
        }
    }

    public TransferObserver resume(int i) {
        submitTransferJob("resume_transfer", i);
        return getTransferById(i);
    }

    public List<TransferObserver> resumeAllWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        Iterator it = getTransferIdsWithTypeAndStates(transferType, new TransferState[]{TransferState.PAUSED, TransferState.FAILED, TransferState.CANCELED}).iterator();
        while (it.hasNext()) {
            arrayList.add(resume(((Integer) it.next()).intValue()));
        }
        return arrayList;
    }

    public boolean cancel(int i) {
        submitTransferJob("cancel_transfer", i);
        return true;
    }

    public void cancelAllWithType(TransferType transferType) {
        Cursor cursorQueryAllTransfersWithType = null;
        try {
            cursorQueryAllTransfersWithType = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursorQueryAllTransfersWithType.moveToNext()) {
                cancel(cursorQueryAllTransfersWithType.getInt(cursorQueryAllTransfersWithType.getColumnIndexOrThrow("_id")));
            }
            cursorQueryAllTransfersWithType.close();
        } catch (Throwable th) {
            if (cursorQueryAllTransfersWithType != null) {
                cursorQueryAllTransfersWithType.close();
            }
            throw th;
        }
    }

    public boolean deleteTransferRecord(int i) {
        cancel(i);
        return this.dbUtil.deleteTransferRecords(i) > 0;
    }

    private synchronized void submitTransferJob(String str, int i) {
        S3ClientReference.put(Integer.valueOf(i), this.s3);
        TransferRecord transfer = this.updater.getTransfer(i);
        if (transfer == null) {
            transfer = this.dbUtil.getTransferById(i);
            if (transfer == null) {
                LOGGER.error("Cannot find transfer with id: " + i);
                return;
            }
            this.updater.addTransfer(transfer);
        } else if ("add_transfer".equals(str)) {
            LOGGER.warn("Transfer has already been added: " + i);
            return;
        }
        if ("add_transfer".equals(str) || "resume_transfer".equals(str)) {
            transfer.start(this.s3, this.dbUtil, this.updater, this.connManager);
        } else if ("pause_transfer".equals(str)) {
            transfer.pause(this.s3, this.updater);
        } else if ("cancel_transfer".equals(str)) {
            transfer.cancel(this.s3, this.updater);
        } else {
            LOGGER.error("Unknown action: " + str);
        }
    }

    private boolean shouldUploadInMultipart(File file) {
        return file != null && file.length() > CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    }

    static AmazonWebServiceRequest appendTransferServiceUserAgentString(AmazonWebServiceRequest amazonWebServiceRequest) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent("TransferService/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return amazonWebServiceRequest;
    }

    static AmazonWebServiceRequest appendMultipartTransferServiceUserAgentString(AmazonWebServiceRequest amazonWebServiceRequest) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent("TransferService_multipart/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return amazonWebServiceRequest;
    }
}
