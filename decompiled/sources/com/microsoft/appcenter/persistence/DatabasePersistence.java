package com.microsoft.appcenter.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ch.qos.logback.classic.net.SyslogAppender;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.messaging.Constants;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.Flags;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.persistence.Persistence;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import com.microsoft.appcenter.utils.storage.DatabaseManager;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SQLiteUtils;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class DatabasePersistence extends Persistence {
    static final ContentValues SCHEMA = getContentValues("", "", "", "", "", 0);
    private final Context mContext;
    final DatabaseManager mDatabaseManager;
    private final File mLargePayloadDirectory;
    final Set mPendingDbIdentifiers;
    final Map mPendingDbIdentifiersGroups;

    public DatabasePersistence(Context context) {
        this(context, 6, SCHEMA);
    }

    DatabasePersistence(Context context, int i, ContentValues contentValues) {
        this.mContext = context;
        this.mPendingDbIdentifiersGroups = new HashMap();
        this.mPendingDbIdentifiers = new HashSet();
        this.mDatabaseManager = new DatabaseManager(context, "com.microsoft.appcenter.persistence", "logs", i, contentValues, "CREATE TABLE IF NOT EXISTS `logs`(`oid` INTEGER PRIMARY KEY AUTOINCREMENT,`target_token` TEXT,`type` TEXT,`priority` INTEGER,`log` TEXT,`persistence_group` TEXT,`target_key` TEXT);", new DatabaseManager.Listener() { // from class: com.microsoft.appcenter.persistence.DatabasePersistence.1
            @Override // com.microsoft.appcenter.utils.storage.DatabaseManager.Listener
            public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
                sQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
            }

            @Override // com.microsoft.appcenter.utils.storage.DatabaseManager.Listener
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
                sQLiteDatabase.execSQL("DROP TABLE `logs`");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `logs`(`oid` INTEGER PRIMARY KEY AUTOINCREMENT,`target_token` TEXT,`type` TEXT,`priority` INTEGER,`log` TEXT,`persistence_group` TEXT,`target_key` TEXT);");
                sQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
            }
        });
        File file = new File(Constants.FILES_PATH + "/appcenter/database_large_payloads");
        this.mLargePayloadDirectory = file;
        file.mkdirs();
    }

    private static ContentValues getContentValues(String str, String str2, String str3, String str4, String str5, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("persistence_group", str);
        contentValues.put("log", str2);
        contentValues.put("target_token", str3);
        contentValues.put("type", str4);
        contentValues.put("target_key", str5);
        contentValues.put(Constants.FirelogAnalytics.PARAM_PRIORITY, Integer.valueOf(i));
        return contentValues;
    }

    @Override // com.microsoft.appcenter.persistence.Persistence
    public boolean setMaxStorageSize(long j) {
        return this.mDatabaseManager.setMaxSize(j);
    }

    @Override // com.microsoft.appcenter.persistence.Persistence
    public long putLog(@NonNull Log log, @NonNull String str, @IntRange(from = 1, to = 2) int i) throws Persistence.PersistenceException, InvalidKeyException, IOException, KeyStoreException {
        String strEncrypt;
        String targetKey;
        try {
            try {
                AppCenterLog.debug("AppCenter", "Storing a log to the Persistence database for log type " + log.getType() + " with flags=" + i);
                String strSerializeLog = getLogSerializer().serializeLog(log);
                int length = strSerializeLog.getBytes("UTF-8").length;
                boolean z = length >= 1992294;
                if (!(log instanceof CommonSchemaLog)) {
                    strEncrypt = null;
                    targetKey = null;
                } else {
                    if (z) {
                        throw new Persistence.PersistenceException("Log is larger than 1992294 bytes, cannot send to OneCollector.");
                    }
                    String next = log.getTransmissionTargetTokens().iterator().next();
                    targetKey = PartAUtils.getTargetKey(next);
                    strEncrypt = CryptoUtils.getInstance(this.mContext).encrypt(next);
                }
                long maxSize = this.mDatabaseManager.getMaxSize();
                if (maxSize == -1) {
                    throw new Persistence.PersistenceException("Failed to store a log to the Persistence database.");
                }
                if (!z && maxSize <= length) {
                    throw new Persistence.PersistenceException("Log is too large (" + length + " bytes) to store in database. Current maximum database size is " + maxSize + " bytes.");
                }
                long jPut = this.mDatabaseManager.put(getContentValues(str, z ? null : strSerializeLog, strEncrypt, log.getType(), targetKey, Flags.getPersistenceFlag(i, false)), Constants.FirelogAnalytics.PARAM_PRIORITY);
                if (jPut == -1) {
                    throw new Persistence.PersistenceException("Failed to store a log to the Persistence database for log type " + log.getType() + InstructionFileId.DOT);
                }
                AppCenterLog.debug("AppCenter", "Stored a log to the Persistence database for log type " + log.getType() + " with databaseId=" + jPut);
                if (z) {
                    AppCenterLog.debug("AppCenter", "Payload is larger than what SQLite supports, storing payload in a separate file.");
                    File largePayloadGroupDirectory = getLargePayloadGroupDirectory(str);
                    largePayloadGroupDirectory.mkdir();
                    File largePayloadFile = getLargePayloadFile(largePayloadGroupDirectory, jPut);
                    try {
                        FileManager.write(largePayloadFile, strSerializeLog);
                        AppCenterLog.debug("AppCenter", "Payload written to " + largePayloadFile);
                    } catch (IOException e) {
                        this.mDatabaseManager.delete(jPut);
                        throw e;
                    }
                }
                return jPut;
            } catch (JSONException e2) {
                throw new Persistence.PersistenceException("Cannot convert to JSON string.", e2);
            }
        } catch (IOException e3) {
            throw new Persistence.PersistenceException("Cannot save large payload in a file.", e3);
        }
    }

    File getLargePayloadGroupDirectory(String str) {
        return new File(this.mLargePayloadDirectory, str);
    }

    File getLargePayloadFile(File file, long j) {
        return new File(file, j + ".json");
    }

    private void deleteLog(File file, long j) {
        getLargePayloadFile(file, j).delete();
        this.mDatabaseManager.delete(j);
    }

    @Override // com.microsoft.appcenter.persistence.Persistence
    public void deleteLogs(@NonNull String str, @NonNull String str2) {
        AppCenterLog.debug("AppCenter", "Deleting logs from the Persistence database for " + str + " with " + str2);
        AppCenterLog.debug("AppCenter", "The IDs for deleting log(s) is/are:");
        List<Long> list = (List) this.mPendingDbIdentifiersGroups.remove(str + str2);
        File largePayloadGroupDirectory = getLargePayloadGroupDirectory(str);
        if (list != null) {
            for (Long l : list) {
                AppCenterLog.debug("AppCenter", SyslogAppender.DEFAULT_STACKTRACE_PATTERN + l);
                deleteLog(largePayloadGroupDirectory, l.longValue());
                this.mPendingDbIdentifiers.remove(l);
            }
        }
    }

    @Override // com.microsoft.appcenter.persistence.Persistence
    public void deleteLogs(String str) {
        AppCenterLog.debug("AppCenter", "Deleting all logs from the Persistence database for " + str);
        File largePayloadGroupDirectory = getLargePayloadGroupDirectory(str);
        File[] fileArrListFiles = largePayloadGroupDirectory.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        largePayloadGroupDirectory.delete();
        AppCenterLog.debug("AppCenter", "Deleted " + this.mDatabaseManager.delete("persistence_group", str) + " logs.");
        Iterator it = this.mPendingDbIdentifiersGroups.keySet().iterator();
        while (it.hasNext()) {
            if (((String) it.next()).startsWith(str)) {
                it.remove();
            }
        }
    }

    @Override // com.microsoft.appcenter.persistence.Persistence
    public int countLogs(@NonNull String str) {
        SQLiteQueryBuilder sQLiteQueryBuilderNewSQLiteQueryBuilder = SQLiteUtils.newSQLiteQueryBuilder();
        sQLiteQueryBuilderNewSQLiteQueryBuilder.appendWhere("persistence_group = ?");
        int i = 0;
        try {
            Cursor cursor = this.mDatabaseManager.getCursor(sQLiteQueryBuilderNewSQLiteQueryBuilder, new String[]{"COUNT(*)"}, new String[]{str}, null);
            try {
                cursor.moveToNext();
                i = cursor.getInt(0);
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get logs count: ", e);
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microsoft.appcenter.persistence.Persistence
    @Nullable
    public String getLogs(@NonNull String str, @NonNull Collection<String> collection, @IntRange(from = 0) int i, @NonNull List<Log> list) throws JSONException, IOException, RuntimeException {
        int i2;
        Cursor cursor;
        AppCenterLog.debug("AppCenter", "Trying to get " + i + " logs from the Persistence database for " + str);
        SQLiteQueryBuilder sQLiteQueryBuilderNewSQLiteQueryBuilder = SQLiteUtils.newSQLiteQueryBuilder();
        sQLiteQueryBuilderNewSQLiteQueryBuilder.appendWhere("persistence_group = ?");
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!collection.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < collection.size(); i3++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sQLiteQueryBuilderNewSQLiteQueryBuilder.appendWhere(" AND ");
            sQLiteQueryBuilderNewSQLiteQueryBuilder.appendWhere("target_key NOT IN (" + sb.toString() + ")");
            arrayList.addAll(collection);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        File largePayloadGroupDirectory = getLargePayloadGroupDirectory(str);
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        try {
            i2 = 0;
            cursor = this.mDatabaseManager.getCursor(sQLiteQueryBuilderNewSQLiteQueryBuilder, null, strArr, "priority DESC, oid");
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get logs: ", e);
            i2 = 0;
            cursor = null;
        }
        while (cursor != null) {
            ContentValues contentValuesNextValues = this.mDatabaseManager.nextValues(cursor);
            if (contentValuesNextValues == null || i2 >= i) {
                break;
            }
            Long asLong = contentValuesNextValues.getAsLong(DatabaseManager.PRIMARY_KEY);
            if (asLong == null) {
                AppCenterLog.error("AppCenter", "Empty database record, probably content was larger than 2MB, need to delete as it's now corrupted.");
                Iterator it = getLogsIds(sQLiteQueryBuilderNewSQLiteQueryBuilder, strArr).iterator();
                while (true) {
                    if (it.hasNext()) {
                        Long l = (Long) it.next();
                        if (!this.mPendingDbIdentifiers.contains(l) && !linkedHashMap.containsKey(l)) {
                            deleteLog(largePayloadGroupDirectory, l.longValue());
                            AppCenterLog.error("AppCenter", "Empty database corrupted empty record deleted, id=" + l);
                            break;
                        }
                    }
                }
            } else if (!this.mPendingDbIdentifiers.contains(asLong)) {
                try {
                    String asString = contentValuesNextValues.getAsString("log");
                    if (asString == null) {
                        File largePayloadFile = getLargePayloadFile(largePayloadGroupDirectory, asLong.longValue());
                        AppCenterLog.debug("AppCenter", "Read payload file " + largePayloadFile);
                        asString = FileManager.read(largePayloadFile);
                        if (asString == null) {
                            throw new JSONException("Log payload is null and not stored as a file.");
                        }
                    }
                    Log logDeserializeLog = getLogSerializer().deserializeLog(asString, contentValuesNextValues.getAsString("type"));
                    String asString2 = contentValuesNextValues.getAsString("target_token");
                    if (asString2 != null) {
                        logDeserializeLog.addTransmissionTarget(CryptoUtils.getInstance(this.mContext).decrypt(asString2).getDecryptedData());
                    }
                    linkedHashMap.put(asLong, logDeserializeLog);
                    i2++;
                } catch (JSONException e2) {
                    AppCenterLog.error("AppCenter", "Cannot deserialize a log in the database", e2);
                    arrayList2.add(asLong);
                }
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException unused) {
            }
        }
        if (arrayList2.size() > 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                deleteLog(largePayloadGroupDirectory, ((Long) it2.next()).longValue());
            }
            AppCenterLog.warn("AppCenter", "Deleted logs that cannot be deserialized");
        }
        if (linkedHashMap.size() <= 0) {
            AppCenterLog.debug("AppCenter", "No logs found in the Persistence database at the moment");
            return null;
        }
        String string = UUID.randomUUID().toString();
        AppCenterLog.debug("AppCenter", "Returning " + linkedHashMap.size() + " log(s) with an ID, " + string);
        AppCenterLog.debug("AppCenter", "The SID/ID pairs for returning log(s) is/are:");
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Long l2 = (Long) entry.getKey();
            this.mPendingDbIdentifiers.add(l2);
            arrayList3.add(l2);
            list.add(entry.getValue());
            AppCenterLog.debug("AppCenter", SyslogAppender.DEFAULT_STACKTRACE_PATTERN + ((Log) entry.getValue()).getSid() + " / " + l2);
        }
        this.mPendingDbIdentifiersGroups.put(str + string, arrayList3);
        return string;
    }

    @Override // com.microsoft.appcenter.persistence.Persistence
    public void clearPendingLogState() {
        this.mPendingDbIdentifiers.clear();
        this.mPendingDbIdentifiersGroups.clear();
        AppCenterLog.debug("AppCenter", "Cleared pending log states");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDatabaseManager.close();
    }

    private List getLogsIds(SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursor = this.mDatabaseManager.getCursor(sQLiteQueryBuilder, DatabaseManager.SELECT_PRIMARY_KEY, strArr, null);
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(this.mDatabaseManager.buildValues(cursor).getAsLong(DatabaseManager.PRIMARY_KEY));
                } catch (Throwable th) {
                    cursor.close();
                    throw th;
                }
            }
            cursor.close();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get corrupted ids: ", e);
        }
        return arrayList;
    }
}
