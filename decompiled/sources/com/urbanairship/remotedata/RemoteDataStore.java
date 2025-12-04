package com.urbanairship.remotedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import ch.qos.logback.classic.spi.CallerData;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.DataManager;
import com.urbanairship.util.UAStringUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RemoteDataStore extends DataManager {
    public RemoteDataStore(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        super(context, str, str2, 2);
    }

    @Override // com.urbanairship.util.DataManager
    protected void onCreate(@NonNull SQLiteDatabase sQLiteDatabase) throws SQLException {
        UALog.d("Creating database", new Object[0]);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS payloads (id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,time INTEGER,data TEXT,metadata TEXT);");
    }

    @Override // com.urbanairship.util.DataManager
    protected void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE payloads ADD COLUMN metadata TEXT;");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS payloads");
            onCreate(sQLiteDatabase);
        }
    }

    @Override // com.urbanairship.util.DataManager
    protected void onDowngrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        super.onDowngrade(sQLiteDatabase, i, i2);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS payloads");
        onCreate(sQLiteDatabase);
    }

    public boolean savePayloads(@NonNull Set<RemoteDataPayload> set) {
        if (set.isEmpty()) {
            return true;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            UALog.e("RemoteDataStore - Unable to save remote data payloads.", new Object[0]);
            return false;
        }
        try {
            writableDatabase.beginTransaction();
            for (RemoteDataPayload remoteDataPayload : set) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", remoteDataPayload.getType());
                contentValues.put("time", Long.valueOf(remoteDataPayload.getTimestamp()));
                contentValues.put("data", remoteDataPayload.getData().toString());
                if (remoteDataPayload.getRemoteDataInfo() != null) {
                    contentValues.put("metadata", remoteDataPayload.getRemoteDataInfo().getJsonValue().toString());
                } else {
                    contentValues.put("metadata", JsonValue.NULL.toString());
                }
                try {
                } catch (SQLException e) {
                    UALog.e(e, "RemoteDataStore - Unable to save remote data payload.", new Object[0]);
                }
                if (writableDatabase.insert("payloads", null, contentValues) == -1) {
                    writableDatabase.endTransaction();
                    return false;
                }
                continue;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return true;
        } catch (SQLException e2) {
            UALog.e(e2, "RemoteDataStore - Unable to save remote data payloads.", new Object[0]);
            return false;
        }
    }

    @NonNull
    public Set<RemoteDataPayload> getPayloads() {
        return getPayloads(null);
    }

    Set getPayloads(Collection collection) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            if (collection == null) {
                cursorQuery = query("payloads", null, null, null, null);
            } else {
                cursorQuery = query("payloads", null, "type IN ( " + UAStringUtil.repeat(CallerData.NA, collection.size(), ", ") + " )", (String[]) collection.toArray(new String[0]), null);
            }
            Cursor cursor2 = cursorQuery;
            if (cursor2 == null) {
                Set setEmptySet = Collections.emptySet();
                if (cursor2 != null) {
                    cursor2.close();
                }
                return setEmptySet;
            }
            Set setGeneratePayloadEntries = generatePayloadEntries(cursor2);
            cursor2.close();
            return setGeneratePayloadEntries;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    int deletePayloads() {
        return delete("payloads", null, null);
    }

    private Set generatePayloadEntries(Cursor cursor) {
        cursor.moveToFirst();
        HashSet hashSet = new HashSet();
        while (!cursor.isAfterLast()) {
            try {
                hashSet.add(new RemoteDataPayload(cursor.getString(cursor.getColumnIndex("type")), cursor.getLong(cursor.getColumnIndex("time")), JsonValue.parseString(cursor.getString(cursor.getColumnIndex("data"))).optMap(), parseRemoteDataInfo(cursor.getString(cursor.getColumnIndex("metadata")))));
            } catch (JsonException | IllegalArgumentException e) {
                UALog.e(e, "RemoteDataStore - failed to retrieve payload", new Object[0]);
            }
            cursor.moveToNext();
        }
        return hashSet;
    }

    private RemoteDataInfo parseRemoteDataInfo(String str) {
        if (str == null) {
            return null;
        }
        try {
            JsonValue string = JsonValue.parseString(str);
            if (string.isNull()) {
                return null;
            }
            return new RemoteDataInfo(string);
        } catch (JsonException unused) {
            return null;
        }
    }
}
