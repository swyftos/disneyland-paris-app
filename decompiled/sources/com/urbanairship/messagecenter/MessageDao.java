package com.urbanairship.messagecenter;

import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.analytics.data.BatchedQueryHelper;
import com.urbanairship.util.Clock;
import com.urbanairship.util.DateUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b!\u0018\u0000 P2\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H'J\u0016\u0010\u0018\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0017J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H§@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H§@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010 J\u0018\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u000e\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0086@¢\u0006\u0002\u0010\u0011J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u0018\u0010)\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010\u0011J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170,J\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170,2\u0006\u0010\u0003\u001a\u00020\u0004H'J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u000e\u0010/\u001a\u00020%H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u00100\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010\u0011J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u000e\u00103\u001a\u00020%H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u00104\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010\u0011J\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170,J\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170,2\u0006\u0010\u0003\u001a\u00020\u0004H'J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 J\u0016\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u001aH\u0087@¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u001aH§@¢\u0006\u0002\u0010;J\u001c\u0010=\u001a\u00020\u00102\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010?J\u001c\u0010@\u001a\u00020\u00102\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H§@¢\u0006\u0002\u0010?J\u000e\u0010A\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010B\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u001c\u0010C\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0086@¢\u0006\u0002\u0010DJ\u001c\u0010E\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H§@¢\u0006\u0002\u0010DJ\u001c\u0010F\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0086@¢\u0006\u0002\u0010DJ\u001c\u0010G\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H§@¢\u0006\u0002\u0010DJ\u001c\u0010H\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0086@¢\u0006\u0002\u0010DJ\u001c\u0010I\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H§@¢\u0006\u0002\u0010DJ\u001c\u0010J\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0086@¢\u0006\u0002\u0010DJ\u001c\u0010K\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H§@¢\u0006\u0002\u0010DJ\u0016\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010 J\u0016\u0010O\u001a\u00020M2\u0006\u0010\u001f\u001a\u00020\u0004H§@¢\u0006\u0002\u0010 R\u001a\u0010\u0003\u001a\u00020\u00048@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006Q"}, d2 = {"Lcom/urbanairship/messagecenter/MessageDao;", "", "()V", "currentTimestamp", "", "getCurrentTimestamp$urbanairship_message_center_release$annotations", "getCurrentTimestamp$urbanairship_message_center_release", "()Ljava/lang/String;", "queryClock", "Lcom/urbanairship/util/Clock;", "getQueryClock$urbanairship_message_center_release$annotations", "getQueryClock$urbanairship_message_center_release", "()Lcom/urbanairship/util/Clock;", "setQueryClock$urbanairship_message_center_release", "(Lcom/urbanairship/util/Clock;)V", "deleteAllMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllMessagesInternal", "deleteMessages", "messageIds", "", "deleteMessagesBatchInternal", "", "deleteMessagesInternal", "getLocallyDeletedMessages", "Lcom/urbanairship/messagecenter/MessageEntity;", "getLocallyDeletedMessagesInternal", "getLocallyReadMessages", "getLocallyReadMessagesInternal", "getMessage", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageByUrl", "url", "getMessageByUrlInternal", "getMessageCount", "", "getMessageCountInternal", "getMessageIds", "getMessageIdsInternal", "getMessageInternal", "getMessages", "getMessagesFlow", "Lkotlinx/coroutines/flow/Flow;", "getMessagesFlowInternal", "getMessagesInternal", "getReadMessageCount", "getReadMessageCountInternal", "getReadMessages", "getReadMessagesInternal", "getUnreadMessageCount", "getUnreadMessageCountInternal", "getUnreadMessages", "getUnreadMessagesFlow", "getUnreadMessagesFlowInternal", "getUnreadMessagesInternal", "insert", "message", "(Lcom/urbanairship/messagecenter/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertInternal", "insertMessages", "messages", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessagesInternal", "markAllMessagesDeleted", "markAllMessagesDeletedInternal", "markMessagesDeleted", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markMessagesDeletedInternal", "markMessagesRead", "markMessagesReadInternal", "markMessagesReadOrigin", "markMessagesReadOriginInternal", "markMessagesUnread", "markMessagesUnreadInternal", "messageExists", "", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "messageExistsInternal", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MessageDao {
    private static final Companion Companion = new Companion(null);
    private Clock queryClock;

    /* renamed from: com.urbanairship.messagecenter.MessageDao$deleteAllMessages$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.deleteAllMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12151 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12151(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getLocallyDeletedMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12171 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12171(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getLocallyReadMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C12191 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12191(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getMessage(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getMessageByUrl$1, reason: invalid class name and case insensitive filesystem */
    static final class C12211 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12211(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getMessageByUrl(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getMessageCount$1, reason: invalid class name and case insensitive filesystem */
    static final class C12231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12231(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getMessageCount(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getMessageIds$1, reason: invalid class name and case insensitive filesystem */
    static final class C12251 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12251(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getMessageIds(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12271(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getReadMessageCount$1, reason: invalid class name and case insensitive filesystem */
    static final class C12301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12301(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getReadMessageCount(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getReadMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12321 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12321(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getReadMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$1, reason: invalid class name and case insensitive filesystem */
    static final class C12341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12341(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getUnreadMessageCount(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$getUnreadMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12361(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.getUnreadMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$insert$1, reason: invalid class name and case insensitive filesystem */
    static final class C12391 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12391(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.insert(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$insertMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12411 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12411(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.insertMessages(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$1, reason: invalid class name and case insensitive filesystem */
    static final class C12431 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12431(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.markAllMessagesDeleted(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$1, reason: invalid class name and case insensitive filesystem */
    static final class C12451 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12451(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.markMessagesDeleted(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesRead$1, reason: invalid class name and case insensitive filesystem */
    static final class C12471 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12471(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.markMessagesRead(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$1, reason: invalid class name and case insensitive filesystem */
    static final class C12501 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12501(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.markMessagesReadOrigin(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesUnread$1, reason: invalid class name and case insensitive filesystem */
    static final class C12531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12531(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.markMessagesUnread(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$messageExists$1, reason: invalid class name and case insensitive filesystem */
    static final class C12561 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12561(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDao.this.messageExists(null, this);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getCurrentTimestamp$urbanairship_message_center_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getQueryClock$urbanairship_message_center_release$annotations() {
    }

    @Query("DELETE FROM richpush")
    @Transaction
    @Nullable
    public abstract Object deleteAllMessagesInternal(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM richpush WHERE message_id IN (:messageIds)")
    public abstract void deleteMessagesBatchInternal(@NotNull List<String> messageIds);

    @Query("SELECT * FROM richpush WHERE deleted = 1")
    @Transaction
    @Nullable
    public abstract Object getLocallyDeletedMessagesInternal(@NotNull Continuation<? super List<MessageEntity>> continuation);

    @Query("SELECT * FROM richpush WHERE unread = 0 AND unread <> unread_orig")
    @Transaction
    @Nullable
    public abstract Object getLocallyReadMessagesInternal(@NotNull Continuation<? super List<MessageEntity>> continuation);

    @Query("SELECT * FROM richpush WHERE message_body_url = :url")
    @Transaction
    @Nullable
    public abstract Object getMessageByUrlInternal(@NotNull String str, @NotNull Continuation<? super MessageEntity> continuation);

    @Query("SELECT COUNT(*) FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getMessageCountInternal(@NotNull String str, @NotNull Continuation<? super Integer> continuation);

    @Query("SELECT message_id FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getMessageIdsInternal(@NotNull String str, @NotNull Continuation<? super List<String>> continuation);

    @Query("SELECT * FROM richpush WHERE message_id = :id")
    @Transaction
    @Nullable
    public abstract Object getMessageInternal(@NotNull String str, @NotNull Continuation<? super MessageEntity> continuation);

    @Query("SELECT * FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @NotNull
    public abstract Flow<List<MessageEntity>> getMessagesFlowInternal(@NotNull String currentTimestamp);

    @Query("SELECT * FROM richpush WHERE (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getMessagesInternal(@NotNull String str, @NotNull Continuation<? super List<MessageEntity>> continuation);

    @Query("SELECT COUNT(*) FROM richpush WHERE unread = 0 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getReadMessageCountInternal(@NotNull String str, @NotNull Continuation<? super Integer> continuation);

    @Query("SELECT * FROM richpush WHERE unread = 0 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getReadMessagesInternal(@NotNull String str, @NotNull Continuation<? super List<MessageEntity>> continuation);

    @Query("SELECT COUNT(*) FROM richpush WHERE unread = 1 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getUnreadMessageCountInternal(@NotNull String str, @NotNull Continuation<? super Integer> continuation);

    @Query("SELECT * FROM richpush WHERE unread = 1 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @NotNull
    public abstract Flow<List<MessageEntity>> getUnreadMessagesFlowInternal(@NotNull String currentTimestamp);

    @Query("SELECT * FROM richpush WHERE unread = 1 AND (expiration_timestamp IS NULL OR datetime(expiration_timestamp) >= datetime(:currentTimestamp)) AND deleted = 0")
    @Transaction
    @Nullable
    public abstract Object getUnreadMessagesInternal(@NotNull String str, @NotNull Continuation<? super List<MessageEntity>> continuation);

    @Insert(onConflict = 1)
    @Nullable
    public abstract Object insertInternal(@NotNull MessageEntity messageEntity, @NotNull Continuation<? super Unit> continuation);

    @Insert(onConflict = 1)
    @Nullable
    public abstract Object insertMessagesInternal(@NotNull List<MessageEntity> list, @NotNull Continuation<? super Unit> continuation);

    @Query("UPDATE richpush SET deleted = 1")
    @Transaction
    @Nullable
    public abstract Object markAllMessagesDeletedInternal(@NotNull Continuation<? super Unit> continuation);

    @Query("UPDATE richpush SET deleted = 1 WHERE message_id IN (:messageIds)")
    @Transaction
    @Nullable
    public abstract Object markMessagesDeletedInternal(@NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation);

    @Query("UPDATE richpush SET unread = 0 WHERE message_id IN (:messageIds)")
    @Transaction
    @Nullable
    public abstract Object markMessagesReadInternal(@NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation);

    @Query("UPDATE richpush SET unread_orig = 0 WHERE message_id IN (:messageIds)")
    @Transaction
    @Nullable
    public abstract Object markMessagesReadOriginInternal(@NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation);

    @Query("UPDATE richpush SET unread = 1 WHERE message_id IN (:messageIds)")
    @Transaction
    @Nullable
    public abstract Object markMessagesUnreadInternal(@NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT EXISTS(SELECT 1 FROM richpush WHERE message_id = :id)")
    @Nullable
    public abstract Object messageExistsInternal(@NotNull String str, @NotNull Continuation<? super Boolean> continuation);

    public MessageDao() {
        Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        this.queryClock = DEFAULT_CLOCK;
    }

    @NotNull
    /* renamed from: getQueryClock$urbanairship_message_center_release, reason: from getter */
    public final Clock getQueryClock() {
        return this.queryClock;
    }

    public final void setQueryClock$urbanairship_message_center_release(@NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "<set-?>");
        this.queryClock = clock;
    }

    @NotNull
    public final String getCurrentTimestamp$urbanairship_message_center_release() {
        String strCreateIso8601TimeStamp = DateUtils.createIso8601TimeStamp(this.queryClock.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(strCreateIso8601TimeStamp, "createIso8601TimeStamp(...)");
        return strCreateIso8601TimeStamp;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull com.urbanairship.messagecenter.MessageEntity r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.MessageDao.C12391
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.MessageDao$insert$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12391) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$insert$1 r0 = new com.urbanairship.messagecenter.MessageDao$insert$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L29
            goto L44
        L29:
            r4 = move-exception
            goto L3f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r4 = r4.insertInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r4 != r1) goto L44
            return r1
        L3f:
            com.urbanairship.messagecenter.MessageDao$insert$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.insert.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$insert$2 r0 = new com.urbanairship.messagecenter.MessageDao$insert$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$insert$2) com.urbanairship.messagecenter.MessageDao.insert.2.INSTANCE com.urbanairship.messagecenter.MessageDao$insert$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12402.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12402.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12402.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to insert message!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12402.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
        L44:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.insert(com.urbanairship.messagecenter.MessageEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object insertMessages(@org.jetbrains.annotations.NotNull java.util.List<com.urbanairship.messagecenter.MessageEntity> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.MessageDao.C12411
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.MessageDao$insertMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$insertMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$insertMessages$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L29
            goto L44
        L29:
            r4 = move-exception
            goto L3f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r4 = r4.insertMessagesInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r4 != r1) goto L44
            return r1
        L3f:
            com.urbanairship.messagecenter.MessageDao$insertMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.insertMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$insertMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$insertMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$insertMessages$2) com.urbanairship.messagecenter.MessageDao.insertMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$insertMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12422.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12422.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12422.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to insert messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12422.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
        L44:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.insertMessages(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessage(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.messagecenter.MessageEntity> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.MessageDao.C12191
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.MessageDao$getMessage$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getMessage$1 r0 = new com.urbanairship.messagecenter.MessageDao$getMessage$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L29
            goto L3f
        L29:
            r4 = move-exception
            goto L42
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r6 = r4.getMessageInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r6 != r1) goto L3f
            return r1
        L3f:
            com.urbanairship.messagecenter.MessageEntity r6 = (com.urbanairship.messagecenter.MessageEntity) r6     // Catch: java.lang.Exception -> L29
            goto L48
        L42:
            com.urbanairship.messagecenter.MessageDao$getMessage$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getMessage.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getMessage$2 r0 = new com.urbanairship.messagecenter.MessageDao$getMessage$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getMessage$2) com.urbanairship.messagecenter.MessageDao.getMessage.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getMessage$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12202.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12202.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12202.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get message!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12202.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            r6 = 0
        L48:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessageByUrl(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.messagecenter.MessageEntity> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.MessageDao.C12211
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.MessageDao$getMessageByUrl$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getMessageByUrl$1 r0 = new com.urbanairship.messagecenter.MessageDao$getMessageByUrl$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L29
            goto L3f
        L29:
            r4 = move-exception
            goto L42
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r6 = r4.getMessageByUrlInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r6 != r1) goto L3f
            return r1
        L3f:
            com.urbanairship.messagecenter.MessageEntity r6 = (com.urbanairship.messagecenter.MessageEntity) r6     // Catch: java.lang.Exception -> L29
            goto L48
        L42:
            com.urbanairship.messagecenter.MessageDao$getMessageByUrl$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getMessageByUrl.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getMessageByUrl$2 r0 = new com.urbanairship.messagecenter.MessageDao$getMessageByUrl$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getMessageByUrl$2) com.urbanairship.messagecenter.MessageDao.getMessageByUrl.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getMessageByUrl$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12222.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12222.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12222.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get message by url!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12222.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            r6 = 0
        L48:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getMessageByUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.messagecenter.MessageEntity>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12271
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$getMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L46
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getMessagesInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L29
            goto L4f
        L46:
            com.urbanairship.messagecenter.MessageDao$getMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$getMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getMessages$2) com.urbanairship.messagecenter.MessageDao.getMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12282.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12282.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12282.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12282.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final Flow<List<MessageEntity>> getMessagesFlow() {
        try {
            return getMessagesFlowInternal(getCurrentTimestamp$urbanairship_message_center_release());
        } catch (Exception e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getMessagesFlow.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get messages flow!";
                }
            });
            return FlowKt.emptyFlow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessageCount(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12231
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getMessageCount$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getMessageCount$1 r0 = new com.urbanairship.messagecenter.MessageDao$getMessageCount$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L4a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getMessageCountInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Exception -> L29
            int r4 = r5.intValue()     // Catch: java.lang.Exception -> L29
            goto L50
        L4a:
            com.urbanairship.messagecenter.MessageDao$getMessageCount$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getMessageCount.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getMessageCount$2 r0 = new com.urbanairship.messagecenter.MessageDao$getMessageCount$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getMessageCount$2) com.urbanairship.messagecenter.MessageDao.getMessageCount.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getMessageCount$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12242.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12242.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12242.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get message count!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12242.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            r4 = 0
        L50:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getMessageCount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getReadMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.messagecenter.MessageEntity>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12321
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getReadMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getReadMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$getReadMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L46
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getReadMessagesInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L29
            goto L4f
        L46:
            com.urbanairship.messagecenter.MessageDao$getReadMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getReadMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getReadMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$getReadMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getReadMessages$2) com.urbanairship.messagecenter.MessageDao.getReadMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getReadMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12332.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12332.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12332.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get read messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12332.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getReadMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getReadMessageCount(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12301
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getReadMessageCount$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12301) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getReadMessageCount$1 r0 = new com.urbanairship.messagecenter.MessageDao$getReadMessageCount$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L4a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getReadMessageCountInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Exception -> L29
            int r4 = r5.intValue()     // Catch: java.lang.Exception -> L29
            goto L50
        L4a:
            com.urbanairship.messagecenter.MessageDao$getReadMessageCount$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getReadMessageCount.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getReadMessageCount$2 r0 = new com.urbanairship.messagecenter.MessageDao$getReadMessageCount$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getReadMessageCount$2) com.urbanairship.messagecenter.MessageDao.getReadMessageCount.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getReadMessageCount$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12312.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12312.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12312.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get read message count!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12312.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            r4 = 0
        L50:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getReadMessageCount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUnreadMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.messagecenter.MessageEntity>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12361
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getUnreadMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getUnreadMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$getUnreadMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L46
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getUnreadMessagesInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L29
            goto L4f
        L46:
            com.urbanairship.messagecenter.MessageDao$getUnreadMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getUnreadMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getUnreadMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$getUnreadMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getUnreadMessages$2) com.urbanairship.messagecenter.MessageDao.getUnreadMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getUnreadMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12372.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12372.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12372.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get unread messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12372.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getUnreadMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final Flow<List<MessageEntity>> getUnreadMessagesFlow() {
        try {
            return getUnreadMessagesFlowInternal(getCurrentTimestamp$urbanairship_message_center_release());
        } catch (Exception e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getUnreadMessagesFlow.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get unread messages flow!";
                }
            });
            return FlowKt.emptyFlow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUnreadMessageCount(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12341
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$1 r0 = new com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L4a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getUnreadMessageCountInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Exception -> L29
            int r4 = r5.intValue()     // Catch: java.lang.Exception -> L29
            goto L50
        L4a:
            com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getUnreadMessageCount.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$2 r0 = new com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$2) com.urbanairship.messagecenter.MessageDao.getUnreadMessageCount.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getUnreadMessageCount$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12352.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12352.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12352.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get unread message count!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12352.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            r4 = 0
        L50:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getUnreadMessageCount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessageIds(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12251
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getMessageIds$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getMessageIds$1 r0 = new com.urbanairship.messagecenter.MessageDao$getMessageIds$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L43
        L29:
            r4 = move-exception
            goto L46
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.getCurrentTimestamp$urbanairship_message_center_release()     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getMessageIdsInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L29
            goto L4f
        L46:
            com.urbanairship.messagecenter.MessageDao$getMessageIds$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getMessageIds.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getMessageIds$2 r0 = new com.urbanairship.messagecenter.MessageDao$getMessageIds$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getMessageIds$2) com.urbanairship.messagecenter.MessageDao.getMessageIds.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getMessageIds$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12262.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12262.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12262.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get message IDs!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12262.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getMessageIds(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLocallyReadMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.messagecenter.MessageEntity>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12171
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L3f
        L29:
            r4 = move-exception
            goto L42
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getLocallyReadMessagesInternal(r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L29
            goto L4b
        L42:
            com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getLocallyReadMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$2) com.urbanairship.messagecenter.MessageDao.getLocallyReadMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getLocallyReadMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12182.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12182.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12182.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get locally read messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12182.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getLocallyReadMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLocallyDeletedMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.messagecenter.MessageEntity>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12151
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L3f
        L29:
            r4 = move-exception
            goto L42
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.getLocallyDeletedMessagesInternal(r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L29
            goto L4b
        L42:
            com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.getLocallyDeletedMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$2) com.urbanairship.messagecenter.MessageDao.getLocallyDeletedMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$getLocallyDeletedMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12162.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12162.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12162.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to get locally deleted messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12162.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.getLocallyDeletedMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markMessagesRead(@org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.messagecenter.MessageDao.C12471
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.messagecenter.MessageDao$markMessagesRead$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$markMessagesRead$1 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesRead$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L29
            goto L4c
        L29:
            r5 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.db.SuspendingBatchedQueryHelper r7 = com.urbanairship.db.SuspendingBatchedQueryHelper.INSTANCE     // Catch: java.lang.Exception -> L29
            com.urbanairship.messagecenter.MessageDao$markMessagesRead$2 r2 = new com.urbanairship.messagecenter.MessageDao$markMessagesRead$2     // Catch: java.lang.Exception -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r7.runBatched(r6, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L4c
            return r1
        L47:
            com.urbanairship.messagecenter.MessageDao$markMessagesRead$3 r6 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.markMessagesRead.3
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$markMessagesRead$3 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesRead$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$markMessagesRead$3) com.urbanairship.messagecenter.MessageDao.markMessagesRead.3.INSTANCE com.urbanairship.messagecenter.MessageDao$markMessagesRead$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12493.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12493.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12493.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to mark messages as read!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12493.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r5, r6)
        L4c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.markMessagesRead(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesRead$2, reason: invalid class name and case insensitive filesystem */
    static final class C12482 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12482(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageDao.this.new C12482(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C12482) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = MessageDao.this;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesReadInternal(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markMessagesUnread(@org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.messagecenter.MessageDao.C12531
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.messagecenter.MessageDao$markMessagesUnread$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$markMessagesUnread$1 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesUnread$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L29
            goto L4c
        L29:
            r5 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.db.SuspendingBatchedQueryHelper r7 = com.urbanairship.db.SuspendingBatchedQueryHelper.INSTANCE     // Catch: java.lang.Exception -> L29
            com.urbanairship.messagecenter.MessageDao$markMessagesUnread$2 r2 = new com.urbanairship.messagecenter.MessageDao$markMessagesUnread$2     // Catch: java.lang.Exception -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r7.runBatched(r6, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L4c
            return r1
        L47:
            com.urbanairship.messagecenter.MessageDao$markMessagesUnread$3 r6 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.markMessagesUnread.3
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$markMessagesUnread$3 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesUnread$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$markMessagesUnread$3) com.urbanairship.messagecenter.MessageDao.markMessagesUnread.3.INSTANCE com.urbanairship.messagecenter.MessageDao$markMessagesUnread$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12553.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12553.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12553.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to mark messages as unread!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12553.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r5, r6)
        L4c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.markMessagesUnread(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesUnread$2, reason: invalid class name and case insensitive filesystem */
    static final class C12542 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12542(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageDao.this.new C12542(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C12542) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = MessageDao.this;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesUnreadInternal(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markMessagesDeleted(@org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.messagecenter.MessageDao.C12451
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$1 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L29
            goto L4c
        L29:
            r5 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.db.SuspendingBatchedQueryHelper r7 = com.urbanairship.db.SuspendingBatchedQueryHelper.INSTANCE     // Catch: java.lang.Exception -> L29
            com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$2 r2 = new com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$2     // Catch: java.lang.Exception -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r7.runBatched(r6, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L4c
            return r1
        L47:
            com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$3 r6 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.markMessagesDeleted.3
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$3 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$3) com.urbanairship.messagecenter.MessageDao.markMessagesDeleted.3.INSTANCE com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass3.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass3.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass3.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to mark messages as deleted!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass3.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r5, r6)
        L4c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.markMessagesDeleted(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesDeleted$2, reason: invalid class name and case insensitive filesystem */
    static final class C12462 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12462(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageDao.this.new C12462(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C12462) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = MessageDao.this;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesDeletedInternal(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markAllMessagesDeleted(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.C12431
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$1 r0 = new com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L44
        L29:
            r4 = move-exception
            goto L3f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r4 = r4.markAllMessagesDeletedInternal(r0)     // Catch: java.lang.Exception -> L29
            if (r4 != r1) goto L44
            return r1
        L3f:
            com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.markAllMessagesDeleted.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$2 r0 = new com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$2) com.urbanairship.messagecenter.MessageDao.markAllMessagesDeleted.2.INSTANCE com.urbanairship.messagecenter.MessageDao$markAllMessagesDeleted$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12442.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12442.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12442.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to mark messages as deleted!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12442.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
        L44:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.markAllMessagesDeleted(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markMessagesReadOrigin(@org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.messagecenter.MessageDao.C12501
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$1 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L29
            goto L4c
        L29:
            r5 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.db.SuspendingBatchedQueryHelper r7 = com.urbanairship.db.SuspendingBatchedQueryHelper.INSTANCE     // Catch: java.lang.Exception -> L29
            com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$2 r2 = new com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$2     // Catch: java.lang.Exception -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r7.runBatched(r6, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L4c
            return r1
        L47:
            com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$3 r6 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.markMessagesReadOrigin.3
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$3 r0 = new com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$3) com.urbanairship.messagecenter.MessageDao.markMessagesReadOrigin.3.INSTANCE com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12523.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12523.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12523.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to mark messages as read (origin)!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12523.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r5, r6)
        L4c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.markMessagesReadOrigin(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.MessageDao$markMessagesReadOrigin$2, reason: invalid class name and case insensitive filesystem */
    static final class C12512 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12512(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageDao.this.new C12512(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C12512) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = MessageDao.this;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesReadOriginInternal(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteMessages(@NotNull Set<String> messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        try {
            deleteMessagesInternal(messageIds);
        } catch (Exception e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.messagecenter.MessageDao.deleteMessages.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to delete messages!";
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteAllMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.MessageDao.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.MessageDao$deleteAllMessages$1 r0 = (com.urbanairship.messagecenter.MessageDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$deleteAllMessages$1 r0 = new com.urbanairship.messagecenter.MessageDao$deleteAllMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L44
        L29:
            r4 = move-exception
            goto L3f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r4 = r4.deleteAllMessagesInternal(r0)     // Catch: java.lang.Exception -> L29
            if (r4 != r1) goto L44
            return r1
        L3f:
            com.urbanairship.messagecenter.MessageDao$deleteAllMessages$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.deleteAllMessages.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$deleteAllMessages$2 r0 = new com.urbanairship.messagecenter.MessageDao$deleteAllMessages$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$deleteAllMessages$2) com.urbanairship.messagecenter.MessageDao.deleteAllMessages.2.INSTANCE com.urbanairship.messagecenter.MessageDao$deleteAllMessages$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass2.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to delete all messages!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.AnonymousClass2.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
        L44:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.deleteAllMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object messageExists(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.MessageDao.C12561
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.MessageDao$messageExists$1 r0 = (com.urbanairship.messagecenter.MessageDao.C12561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.MessageDao$messageExists$1 r0 = new com.urbanairship.messagecenter.MessageDao$messageExists$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L29
            goto L3f
        L29:
            r4 = move-exception
            goto L46
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r6 = r4.messageExistsInternal(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r6 != r1) goto L3f
            return r1
        L3f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Exception -> L29
            boolean r4 = r6.booleanValue()     // Catch: java.lang.Exception -> L29
            goto L4c
        L46:
            com.urbanairship.messagecenter.MessageDao$messageExists$2 r5 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.MessageDao.messageExists.2
                static {
                    /*
                        com.urbanairship.messagecenter.MessageDao$messageExists$2 r0 = new com.urbanairship.messagecenter.MessageDao$messageExists$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.MessageDao$messageExists$2) com.urbanairship.messagecenter.MessageDao.messageExists.2.INSTANCE com.urbanairship.messagecenter.MessageDao$messageExists$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12572.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12572.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12572.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to check if message exists!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.C12572.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r4, r5)
            r4 = 0
        L4c:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageDao.messageExists(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMessagesInternal$lambda$0(MessageDao this$0, List ids) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ids, "ids");
        this$0.deleteMessagesBatchInternal(ids);
    }

    @Transaction
    public void deleteMessagesInternal(@NotNull Set<String> messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BatchedQueryHelper.runBatched(CollectionsKt.toList(messageIds), new Consumer() { // from class: com.urbanairship.messagecenter.MessageDao$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                MessageDao.deleteMessagesInternal$lambda$0(this.f$0, (List) obj);
            }
        });
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
