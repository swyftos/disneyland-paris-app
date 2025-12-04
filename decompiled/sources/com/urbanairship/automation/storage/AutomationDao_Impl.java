package com.urbanairship.automation.storage;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.urbanairship.json.JsonTypeConverters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class AutomationDao_Impl extends AutomationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfScheduleEntity;
    private final EntityInsertionAdapter __insertionAdapterOfScheduleEntity;
    private final EntityInsertionAdapter __insertionAdapterOfTriggerEntity;
    private final JsonTypeConverters __jsonTypeConverters = new JsonTypeConverters();

    public AutomationDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfScheduleEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.automation.storage.AutomationDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `schedules` (`id`,`scheduleId`,`group`,`metadata`,`limit`,`priority`,`triggeredTime`,`scheduleStart`,`scheduleEnd`,`editGracePeriod`,`interval`,`scheduleType`,`data`,`count`,`executionState`,`executionStateChangeDate`,`triggerContext`,`appState`,`screens`,`seconds`,`regionId`,`audience`,`campaigns`,`reportingContext`,`frequencyConstraintIds`,`messageType`,`bypassHoldoutGroups`,`newUserEvaluationDate`,`productId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ScheduleEntity scheduleEntity) {
                supportSQLiteStatement.bindLong(1, scheduleEntity.id);
                supportSQLiteStatement.bindString(2, scheduleEntity.scheduleId);
                String str = scheduleEntity.group;
                if (str == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, str);
                }
                String strJsonMapToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonMapToString(scheduleEntity.metadata);
                if (strJsonMapToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, strJsonMapToString);
                }
                supportSQLiteStatement.bindLong(5, scheduleEntity.limit);
                supportSQLiteStatement.bindLong(6, scheduleEntity.priority);
                supportSQLiteStatement.bindLong(7, scheduleEntity.triggeredTime);
                supportSQLiteStatement.bindLong(8, scheduleEntity.scheduleStart);
                supportSQLiteStatement.bindLong(9, scheduleEntity.scheduleEnd);
                supportSQLiteStatement.bindLong(10, scheduleEntity.editGracePeriod);
                supportSQLiteStatement.bindLong(11, scheduleEntity.interval);
                supportSQLiteStatement.bindString(12, scheduleEntity.scheduleType);
                String strJsonValueToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.data);
                if (strJsonValueToString == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, strJsonValueToString);
                }
                supportSQLiteStatement.bindLong(14, scheduleEntity.count);
                supportSQLiteStatement.bindLong(15, scheduleEntity.executionState);
                supportSQLiteStatement.bindLong(16, scheduleEntity.executionStateChangeDate);
                String str2 = scheduleEntity.triggerContext;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, str2);
                }
                supportSQLiteStatement.bindLong(18, scheduleEntity.appState);
                supportSQLiteStatement.bindString(19, Converters.fromArrayList(scheduleEntity.screens));
                supportSQLiteStatement.bindLong(20, scheduleEntity.seconds);
                String str3 = scheduleEntity.regionId;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, str3);
                }
                String str4 = scheduleEntity.audience;
                if (str4 == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, str4);
                }
                String strJsonValueToString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.campaigns);
                if (strJsonValueToString2 == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, strJsonValueToString2);
                }
                String strJsonValueToString3 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.reportingContext);
                if (strJsonValueToString3 == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindString(24, strJsonValueToString3);
                }
                supportSQLiteStatement.bindString(25, Converters.fromArrayList(scheduleEntity.frequencyConstraintIds));
                String str5 = scheduleEntity.messageType;
                if (str5 == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, str5);
                }
                supportSQLiteStatement.bindLong(27, scheduleEntity.bypassHoldoutGroups ? 1L : 0L);
                supportSQLiteStatement.bindLong(28, scheduleEntity.newUserEvaluationDate);
                String str6 = scheduleEntity.productId;
                if (str6 == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, str6);
                }
            }
        };
        this.__insertionAdapterOfTriggerEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.automation.storage.AutomationDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `triggers` (`id`,`triggerType`,`goal`,`jsonPredicate`,`isCancellation`,`progress`,`parentScheduleId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TriggerEntity triggerEntity) {
                supportSQLiteStatement.bindLong(1, triggerEntity.id);
                supportSQLiteStatement.bindLong(2, triggerEntity.triggerType);
                supportSQLiteStatement.bindDouble(3, triggerEntity.goal);
                String strJsonPredicateToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonPredicateToString(triggerEntity.jsonPredicate);
                if (strJsonPredicateToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, strJsonPredicateToString);
                }
                supportSQLiteStatement.bindLong(5, triggerEntity.isCancellation ? 1L : 0L);
                supportSQLiteStatement.bindDouble(6, triggerEntity.progress);
                supportSQLiteStatement.bindString(7, triggerEntity.parentScheduleId);
            }
        };
        this.__deletionAdapterOfScheduleEntity = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.automation.storage.AutomationDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `schedules` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ScheduleEntity scheduleEntity) {
                supportSQLiteStatement.bindLong(1, scheduleEntity.id);
            }
        };
    }

    @Override // com.urbanairship.automation.storage.AutomationDao
    public void insert(ScheduleEntity scheduleEntity, List<TriggerEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfScheduleEntity.insert((EntityInsertionAdapter) scheduleEntity);
            this.__insertionAdapterOfTriggerEntity.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.urbanairship.automation.storage.AutomationDao
    public void delete(ScheduleEntity scheduleEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfScheduleEntity.handle(scheduleEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.urbanairship.automation.storage.AutomationDao
    public void insert(Collection<FullSchedule> collection) {
        this.__db.beginTransaction();
        try {
            super.insert(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02a9 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02ad A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02bd A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0309 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x033d A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0345 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0374 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x037a A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0387 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x038f A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03a4 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03c2 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e4 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ec A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0416 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x041a A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0428 A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x042e A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x043b A[Catch: all -> 0x011b, TryCatch #2 {all -> 0x011b, blocks: (B:6:0x006b, B:7:0x00f0, B:9:0x00f6, B:14:0x010a, B:16:0x0110, B:12:0x0100, B:21:0x0125, B:22:0x0139, B:24:0x013f, B:26:0x0145, B:28:0x014b, B:30:0x0151, B:32:0x0157, B:34:0x015d, B:36:0x0163, B:38:0x0169, B:40:0x016f, B:42:0x0175, B:44:0x017b, B:46:0x0181, B:48:0x0189, B:50:0x0193, B:52:0x019d, B:54:0x01a7, B:56:0x01b1, B:58:0x01bb, B:60:0x01c5, B:62:0x01cf, B:64:0x01d9, B:66:0x01e3, B:68:0x01ed, B:70:0x01f7, B:72:0x0201, B:74:0x020b, B:76:0x0215, B:78:0x021f, B:80:0x0229, B:102:0x0290, B:104:0x02a9, B:106:0x02b3, B:110:0x02c3, B:114:0x030f, B:116:0x033d, B:119:0x034c, B:121:0x0374, B:124:0x0381, B:126:0x0387, B:129:0x0398, B:133:0x03ae, B:137:0x03c8, B:139:0x03e4, B:142:0x03f5, B:146:0x0400, B:148:0x0416, B:150:0x0420, B:155:0x042e, B:158:0x0445, B:157:0x043b, B:153:0x0428, B:149:0x041a, B:141:0x03ec, B:136:0x03c2, B:132:0x03a4, B:128:0x038f, B:123:0x037a, B:118:0x0345, B:113:0x0309, B:109:0x02bd, B:105:0x02ad, B:159:0x0474), top: B:174:0x006b }] */
    @Override // com.urbanairship.automation.storage.AutomationDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.urbanairship.automation.storage.FullSchedule> getSchedules() {
        /*
            Method dump skipped, instructions count: 1176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.storage.AutomationDao_Impl.getSchedules():java.util.List");
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    private void __fetchRelationshiptriggersAscomUrbanairshipAutomationStorageTriggerEntity(ArrayMap arrayMap) {
        ArrayList arrayList;
        Set setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new Function1() { // from class: com.urbanairship.automation.storage.AutomationDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$__fetchRelationshiptriggersAscomUrbanairshipAutomationStorageTriggerEntity$0((ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `id`,`triggerType`,`goal`,`jsonPredicate`,`isCancellation`,`progress`,`parentScheduleId` FROM `triggers` WHERE `parentScheduleId` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        Iterator it = setKeySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            roomSQLiteQueryAcquire.bindString(i, (String) it.next());
            i++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "parentScheduleId");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndex) ? null : cursorQuery.getString(columnIndex);
                if (string != null && (arrayList = (ArrayList) arrayMap.get(string)) != null) {
                    TriggerEntity triggerEntity = new TriggerEntity();
                    triggerEntity.id = cursorQuery.getInt(0);
                    triggerEntity.triggerType = cursorQuery.getInt(1);
                    triggerEntity.goal = cursorQuery.getDouble(2);
                    triggerEntity.jsonPredicate = this.__jsonTypeConverters.jsonPredicateFromString(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                    triggerEntity.isCancellation = cursorQuery.getInt(4) != 0;
                    triggerEntity.progress = cursorQuery.getDouble(5);
                    triggerEntity.parentScheduleId = cursorQuery.getString(6);
                    arrayList.add(triggerEntity);
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshiptriggersAscomUrbanairshipAutomationStorageTriggerEntity$0(ArrayMap arrayMap) {
        __fetchRelationshiptriggersAscomUrbanairshipAutomationStorageTriggerEntity(arrayMap);
        return Unit.INSTANCE;
    }
}
