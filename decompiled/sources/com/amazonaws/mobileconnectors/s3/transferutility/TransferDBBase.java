package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes2.dex */
class TransferDBBase {
    private final Uri contentUri;
    private final Context context;
    private SQLiteDatabase database;
    private final TransferDatabaseHelper databaseHelper;
    private final UriMatcher uriMatcher;
    private static final Log LOGGER = LogFactory.getLog(TransferDBBase.class);
    private static final Object LOCK = new Object();

    public TransferDBBase(Context context) {
        this.context = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.databaseHelper = transferDatabaseHelper;
        this.database = transferDatabaseHelper.getWritableDatabase();
        this.contentUri = Uri.parse(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    public Uri getContentUri() {
        return this.contentUri;
    }

    public Uri insert(Uri uri, ContentValues contentValues) throws SQLException {
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            return Uri.parse("transfers/" + this.database.insertOrThrow("awstransfer", null, contentValues));
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int iMatch = this.uriMatcher.match(uri);
        if (iMatch == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (iMatch == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (iMatch == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else if (iMatch == 40) {
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        ensureDatabaseOpen();
        return sQLiteQueryBuilder.query(this.database, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        try {
            int iMatch = this.uriMatcher.match(uri);
            ensureDatabaseOpen();
            if (iMatch == 10) {
                iUpdate = this.database.update("awstransfer", contentValues, str, strArr);
            } else if (iMatch == 20) {
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str)) {
                    iUpdate = this.database.update("awstransfer", contentValues, "_id=" + lastPathSegment, null);
                } else {
                    iUpdate = this.database.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
                }
            } else {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iUpdate;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            return this.database.delete("awstransfer", str, strArr);
        }
        if (iMatch == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                return this.database.delete("awstransfer", "_id=" + lastPathSegment, null);
            }
            return this.database.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            int iInsertOrThrow = 0;
            try {
                try {
                    this.database.beginTransaction();
                    iInsertOrThrow = (int) this.database.insertOrThrow("awstransfer", null, contentValuesArr[0]);
                    for (int i = 1; i < contentValuesArr.length; i++) {
                        contentValuesArr[i].put("main_upload_id", Integer.valueOf(iInsertOrThrow));
                        this.database.insertOrThrow("awstransfer", null, contentValuesArr[i]);
                    }
                    this.database.setTransactionSuccessful();
                } catch (Exception e) {
                    LOGGER.error("bulkInsert error : ", e);
                }
                this.database.endTransaction();
                return iInsertOrThrow;
            } catch (Throwable th) {
                this.database.endTransaction();
                throw th;
            }
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    private void ensureDatabaseOpen() {
        synchronized (LOCK) {
            try {
                if (!this.database.isOpen()) {
                    this.database = this.databaseHelper.getWritableDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
