package com.amazonaws.mobileconnectors.p016s3.transferutility;

import android.database.Cursor;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class TransferObserver {
    private String bucket;
    private long bytesTotal;
    private long bytesTransferred;
    private final TransferDBUtil dbUtil;
    private String filePath;

    /* JADX INFO: renamed from: id */
    private final int f357id;
    private String key;
    private TransferStatusListener statusListener;
    private TransferListener transferListener;
    private TransferState transferState;

    TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.f357id = i;
        this.dbUtil = transferDBUtil;
        this.bucket = str;
        this.key = str2;
        this.filePath = file.getAbsolutePath();
        this.bytesTotal = file.length();
        this.transferState = TransferState.WAITING;
    }

    TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener) {
        this(i, transferDBUtil, str, str2, file);
        setTransferListener(transferListener);
    }

    TransferObserver(int i, TransferDBUtil transferDBUtil) {
        this.f357id = i;
        this.dbUtil = transferDBUtil;
    }

    public void refresh() {
        Cursor cursorQueryTransferById = null;
        try {
            cursorQueryTransferById = this.dbUtil.queryTransferById(this.f357id);
            if (cursorQueryTransferById.moveToFirst()) {
                updateFromDB(cursorQueryTransferById);
            }
            cursorQueryTransferById.close();
        } catch (Throwable th) {
            if (cursorQueryTransferById != null) {
                cursorQueryTransferById.close();
            }
            throw th;
        }
    }

    protected void updateFromDB(Cursor cursor) {
        this.bucket = cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
        this.bytesTransferred = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_current"));
        this.transferState = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow(BluetoothManager.BLE_STATUS_PARAM)));
        this.filePath = cursor.getString(cursor.getColumnIndexOrThrow("file"));
    }

    public void setTransferListener(TransferListener transferListener) {
        if (transferListener != null) {
            synchronized (this) {
                cleanTransferListener();
                TransferStatusListener transferStatusListener = new TransferStatusListener();
                this.statusListener = transferStatusListener;
                TransferStatusUpdater.registerListener(this.f357id, transferStatusListener);
                this.transferListener = transferListener;
                TransferStatusUpdater.registerListener(this.f357id, transferListener);
            }
        }
    }

    public int getId() {
        return this.f357id;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public long getBytesTotal() {
        return this.bytesTotal;
    }

    public String getAbsoluteFilePath() {
        return this.filePath;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public TransferState getState() {
        return this.transferState;
    }

    public void cleanTransferListener() {
        synchronized (this) {
            try {
                TransferListener transferListener = this.transferListener;
                if (transferListener != null) {
                    TransferStatusUpdater.unregisterListener(this.f357id, transferListener);
                    this.transferListener = null;
                }
                TransferStatusListener transferStatusListener = this.statusListener;
                if (transferStatusListener != null) {
                    TransferStatusUpdater.unregisterListener(this.f357id, transferStatusListener);
                    this.statusListener = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private class TransferStatusListener implements TransferListener {
        @Override // com.amazonaws.mobileconnectors.p016s3.transferutility.TransferListener
        public void onError(int i, Exception exc) {
        }

        private TransferStatusListener() {
        }

        @Override // com.amazonaws.mobileconnectors.p016s3.transferutility.TransferListener
        public void onStateChanged(int i, TransferState transferState) {
            TransferObserver.this.transferState = transferState;
        }

        @Override // com.amazonaws.mobileconnectors.p016s3.transferutility.TransferListener
        public void onProgressChanged(int i, long j, long j2) {
            TransferObserver.this.bytesTransferred = j;
            TransferObserver.this.bytesTotal = j2;
        }
    }

    public String toString() {
        return "TransferObserver{id=" + this.f357id + ", bucket='" + this.bucket + CoreConstants.SINGLE_QUOTE_CHAR + ", key='" + this.key + CoreConstants.SINGLE_QUOTE_CHAR + ", bytesTotal=" + this.bytesTotal + ", bytesTransferred=" + this.bytesTransferred + ", transferState=" + this.transferState + ", filePath='" + this.filePath + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
