package com.urbanairship.messagecenter;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class MessageDao_Impl extends MessageDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfMessageEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllMessagesInternal;
    private final SharedSQLiteStatement __preparedStmtOfMarkAllMessagesDeletedInternal;

    public MessageDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMessageEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.messagecenter.MessageDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `richpush` (`_id`,`message_id`,`message_url`,`message_body_url`,`message_read_url`,`title`,`extra`,`unread`,`unread_orig`,`deleted`,`timestamp`,`raw_message_object`,`expiration_timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageEntity messageEntity) {
                supportSQLiteStatement.bindLong(1, messageEntity.getId());
                supportSQLiteStatement.bindString(2, messageEntity.getMessageId());
                if (messageEntity.getMessageUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, messageEntity.getMessageUrl());
                }
                if (messageEntity.getMessageBodyUrl() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, messageEntity.getMessageBodyUrl());
                }
                if (messageEntity.getMessageReadUrl() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, messageEntity.getMessageReadUrl());
                }
                if (messageEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, messageEntity.getTitle());
                }
                if (messageEntity.getExtra() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, messageEntity.getExtra());
                }
                supportSQLiteStatement.bindLong(8, messageEntity.getUnread() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, messageEntity.getUnreadOrig() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, messageEntity.getDeleted() ? 1L : 0L);
                if (messageEntity.getTimestamp() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, messageEntity.getTimestamp());
                }
                supportSQLiteStatement.bindString(12, messageEntity.getRawMessageObject());
                if (messageEntity.getExpirationTimestamp() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, messageEntity.getExpirationTimestamp());
                }
            }
        };
        this.__preparedStmtOfMarkAllMessagesDeletedInternal = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.messagecenter.MessageDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE richpush SET deleted = 1";
            }
        };
        this.__preparedStmtOfDeleteAllMessagesInternal = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.messagecenter.MessageDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM richpush";
            }
        };
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object insertInternal(final MessageEntity messageEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageDao_Impl.this.__insertionAdapterOfMessageEntity.insert((EntityInsertionAdapter) messageEntity);
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object insertMessagesInternal(final List<MessageEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageDao_Impl.this.__insertionAdapterOfMessageEntity.insert((Iterable) list);
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public void deleteMessagesInternal(Set<String> set) {
        this.__db.beginTransaction();
        try {
            super.deleteMessagesInternal(set);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object markAllMessagesDeletedInternal(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = MessageDao_Impl.this.__preparedStmtOfMarkAllMessagesDeletedInternal.acquire();
                try {
                    MessageDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        MessageDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    MessageDao_Impl.this.__preparedStmtOfMarkAllMessagesDeletedInternal.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object deleteAllMessagesInternal(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = MessageDao_Impl.this.__preparedStmtOfDeleteAllMessagesInternal.acquire();
                try {
                    MessageDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        MessageDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    MessageDao_Impl.this.__preparedStmtOfDeleteAllMessagesInternal.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getMessageInternal(String str, Continuation<? super MessageEntity> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE message_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.8
            @Override // java.util.concurrent.Callable
            public MessageEntity call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageEntity messageEntity = null;
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                        if (cursorQuery.moveToFirst()) {
                            messageEntity = new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                        }
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return messageEntity;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getMessageByUrlInternal(String str, Continuation<? super MessageEntity> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE message_body_url = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.9
            @Override // java.util.concurrent.Callable
            public MessageEntity call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    MessageEntity messageEntity = null;
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                        if (cursorQuery.moveToFirst()) {
                            messageEntity = new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                        }
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return messageEntity;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getMessagesInternal(String str, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List call() {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                AnonymousClass10 anonymousClass10 = this;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                        }
                        anonymousClass10 = this;
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass10 = this;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Flow<List<MessageEntity>> getMessagesFlowInternal(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"richpush"}, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                        try {
                            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                            while (cursorQuery.moveToNext()) {
                                arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                            }
                            MessageDao_Impl.this.__db.setTransactionSuccessful();
                            cursorQuery.close();
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getMessageCountInternal(String str, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.12
            @Override // java.util.concurrent.Callable
            public Integer call() {
                int iValueOf;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            iValueOf = Integer.valueOf(cursorQuery.getInt(0));
                        } else {
                            iValueOf = 0;
                        }
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return iValueOf;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getReadMessagesInternal(String str, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE unread = 0 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.13
            @Override // java.util.concurrent.Callable
            public List call() {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                AnonymousClass13 anonymousClass13 = this;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                        }
                        anonymousClass13 = this;
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass13 = this;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getReadMessageCountInternal(String str, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM richpush WHERE unread = 0 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Integer call() {
                int iValueOf;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            iValueOf = Integer.valueOf(cursorQuery.getInt(0));
                        } else {
                            iValueOf = 0;
                        }
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return iValueOf;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getUnreadMessagesInternal(String str, Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE unread = 1 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.15
            @Override // java.util.concurrent.Callable
            public List call() {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                AnonymousClass15 anonymousClass15 = this;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                        }
                        anonymousClass15 = this;
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass15 = this;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Flow<List<MessageEntity>> getUnreadMessagesFlowInternal(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE unread = 1 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"richpush"}, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.16
            @Override // java.util.concurrent.Callable
            public List call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                        try {
                            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                            while (cursorQuery.moveToNext()) {
                                arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                            }
                            MessageDao_Impl.this.__db.setTransactionSuccessful();
                            cursorQuery.close();
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getUnreadMessageCountInternal(String str, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM richpush WHERE unread = 1 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.17
            @Override // java.util.concurrent.Callable
            public Integer call() {
                int iValueOf;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            iValueOf = Integer.valueOf(cursorQuery.getInt(0));
                        } else {
                            iValueOf = 0;
                        }
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return iValueOf;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getMessageIdsInternal(String str, Continuation<? super List<String>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT message_id FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(?)) AND deleted = 0", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.18
            @Override // java.util.concurrent.Callable
            public List call() {
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(cursorQuery.getString(0));
                        }
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getLocallyReadMessagesInternal(Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE unread = 0 AND unread <> unread_orig", 0);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.19
            @Override // java.util.concurrent.Callable
            public List call() {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                AnonymousClass19 anonymousClass19 = this;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                        }
                        anonymousClass19 = this;
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass19 = this;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object getLocallyDeletedMessagesInternal(Continuation<? super List<MessageEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM richpush WHERE deleted = 1", 0);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.20
            @Override // java.util.concurrent.Callable
            public List call() {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                AnonymousClass20 anonymousClass20 = this;
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                        columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message_id");
                        columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_URL);
                        columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_BODY_URL);
                        columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_MESSAGE_READ_URL);
                        columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                        columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_EXTRAS);
                        columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Message.KEY_IS_UNREAD);
                        columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unread_orig");
                        columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleted");
                        columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                        columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "raw_message_object");
                        columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiration_timestamp");
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(new MessageEntity(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8) != 0, cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                        }
                        anonymousClass20 = this;
                        MessageDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass20 = this;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object messageExistsInternal(String str, Continuation<? super Boolean> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM richpush WHERE message_id = ?)", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.21
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                Boolean boolValueOf;
                Cursor cursorQuery = DBUtil.query(MessageDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        boolValueOf = Boolean.valueOf(cursorQuery.getInt(0) != 0);
                    } else {
                        boolValueOf = Boolean.FALSE;
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return boolValueOf;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object markMessagesReadInternal(final Set<String> set, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.22
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("UPDATE richpush SET unread = 0 WHERE message_id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, set.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = MessageDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = set.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object markMessagesUnreadInternal(final Set<String> set, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.23
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("UPDATE richpush SET unread = 1 WHERE message_id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, set.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = MessageDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = set.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object markMessagesDeletedInternal(final Set<String> set, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.24
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("UPDATE richpush SET deleted = 1 WHERE message_id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, set.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = MessageDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = set.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public Object markMessagesReadOriginInternal(final Set<String> set, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.messagecenter.MessageDao_Impl.25
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("UPDATE richpush SET unread_orig = 0 WHERE message_id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, set.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = MessageDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = set.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                MessageDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    MessageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MessageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.messagecenter.MessageDao
    public void deleteMessagesBatchInternal(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM richpush WHERE message_id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        Iterator<String> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            supportSQLiteStatementCompileStatement.bindString(i, it.next());
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
