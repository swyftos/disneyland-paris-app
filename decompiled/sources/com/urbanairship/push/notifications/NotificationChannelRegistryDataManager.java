package com.urbanairship.push.notifications;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.DataManager;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NotificationChannelRegistryDataManager extends DataManager {
    public NotificationChannelRegistryDataManager(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        super(context, str, str2, 2);
    }

    @Override // com.urbanairship.util.DataManager
    protected void onCreate(@NonNull SQLiteDatabase sQLiteDatabase) throws SQLException {
        UALog.d("Creating database", new Object[0]);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notification_channels (id INTEGER PRIMARY KEY AUTOINCREMENT,channel_id TEXT UNIQUE,data TEXT);");
    }

    @Override // com.urbanairship.util.DataManager
    protected void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        if (i == 1) {
            sQLiteDatabase.execSQL("DELETE FROM notification_channels WHERE rowid NOT IN ( SELECT max(rowid) FROM notification_channels GROUP BY channel_id);");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX notification_channels_channel_id ON notification_channels(channel_id);");
        } else if (i != 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notification_channels");
            onCreate(sQLiteDatabase);
        }
    }

    @Override // com.urbanairship.util.DataManager
    protected void onDowngrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notification_channels");
        onCreate(sQLiteDatabase);
    }

    @WorkerThread
    public boolean createChannel(@NonNull NotificationChannelCompat notificationChannelCompat) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            UALog.e("NotificationChannelRegistryDataManager - Unable to save notification channel.", new Object[0]);
            return false;
        }
        saveChannel(notificationChannelCompat, writableDatabase);
        return true;
    }

    @NonNull
    @WorkerThread
    public Set<NotificationChannelCompat> getChannels() {
        Cursor cursorQuery = query("notification_channels", null, null, null, null);
        HashSet hashSet = new HashSet();
        if (cursorQuery == null) {
            return hashSet;
        }
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            hashSet.add(getChannel(cursorQuery));
            cursorQuery.moveToNext();
        }
        return hashSet;
    }

    @Nullable
    @WorkerThread
    public NotificationChannelCompat getChannel(@NonNull String str) {
        Cursor cursorQuery = query("notification_channels", null, "channel_id = ?", new String[]{str}, null);
        if (cursorQuery == null) {
            return null;
        }
        cursorQuery.moveToFirst();
        NotificationChannelCompat channel = cursorQuery.isAfterLast() ? null : getChannel(cursorQuery);
        cursorQuery.close();
        return channel;
    }

    @WorkerThread
    public boolean deleteChannel(@NonNull String str) {
        if (delete("notification_channels", "channel_id = ?", new String[]{str}) != -1) {
            return true;
        }
        UALog.e("Unable to remove notification channel: %s", str);
        return false;
    }

    private NotificationChannelCompat getChannel(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("data"));
        try {
            return NotificationChannelCompat.fromJson(JsonValue.parseString(string));
        } catch (JsonException unused) {
            UALog.e("Unable to parse notification channel: %s", string);
            return null;
        }
    }

    private void saveChannel(NotificationChannelCompat notificationChannelCompat, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("channel_id", notificationChannelCompat.getId());
        contentValues.put("data", notificationChannelCompat.getJsonValue().toString());
        sQLiteDatabase.insertWithOnConflict("notification_channels", null, contentValues, 5);
    }
}
