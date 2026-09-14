package com.urbanairship.messagecenter;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.api.Currencies;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.Cancelable;
import com.urbanairship.CancelableOperation;
import com.urbanairship.PendingResult;
import com.urbanairship.Predicate;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.ChannelRegistrationPayload;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\u001e\u0018\u00002\u00020\u0001:\b\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001B;\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eBs\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u001cJ\u000e\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u000205J\u0006\u0010D\u001a\u00020\rJ\b\u0010E\u001a\u00020\rH\u0002J\u001f\u0010F\u001a\u00020\r2\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0H\"\u00020&¢\u0006\u0002\u0010IJ\u0014\u0010F\u001a\u00020\r2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0JJ\u000e\u0010K\u001a\u00020LH\u0086@¢\u0006\u0002\u0010MJ\u001e\u0010K\u001a\u00020N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010RJ\u000e\u0010K\u001a\u00020N2\u0006\u0010Q\u001a\u00020RJ,\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020U0T2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0002J\u000e\u0010Y\u001a\u00020ZH\u0086@¢\u0006\u0002\u0010MJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0\\J\u001a\u0010]\u001a\u0004\u0018\u00010U2\b\u0010^\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0002\u0010_J\u001a\u0010`\u001a\u0004\u0018\u00010U2\b\u0010a\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0002\u0010_J\u0018\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0\\2\b\u0010a\u001a\u0004\u0018\u00010&J\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020&0JH\u0086@¢\u0006\u0002\u0010MJ\u0012\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0J0\\J\u0018\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0\\2\b\u0010^\u001a\u0004\u0018\u00010&J&\u0010f\u001a\b\u0012\u0004\u0012\u00020U0g2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0086@¢\u0006\u0002\u0010hJ$\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0g0j2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XJ(\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010g0\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0007J\u000e\u0010l\u001a\u00020ZH\u0086@¢\u0006\u0002\u0010MJ\f\u0010m\u001a\b\u0012\u0004\u0012\u00020Z0\\J&\u0010n\u001a\b\u0012\u0004\u0012\u00020U0g2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0086@¢\u0006\u0002\u0010hJ(\u0010o\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010g0\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0007J\u000e\u0010p\u001a\u00020ZH\u0086@¢\u0006\u0002\u0010MJ\f\u0010q\u001a\b\u0012\u0004\u0012\u00020Z0\\J&\u0010r\u001a\b\u0012\u0004\u0012\u00020U0g2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0086@¢\u0006\u0002\u0010hJ$\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0g0j2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XJ(\u0010t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010g0\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0007J\u001f\u0010u\u001a\u00020\r2\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0H\"\u00020&¢\u0006\u0002\u0010IJ\u0014\u0010u\u001a\u00020\r2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0JJ\u001f\u0010v\u001a\u00020\r2\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0H\"\u00020&¢\u0006\u0002\u0010IJ\u0014\u0010v\u001a\u00020\r2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0JJ\r\u0010w\u001a\u00020\rH\u0001¢\u0006\u0002\bxJ\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020L0zH\u0080@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b{\u0010MJ\u000e\u0010|\u001a\u00020\r2\u0006\u0010C\u001a\u000205J\u0010\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\fH\u0003J\u0016\u0010\u007f\u001a\u00020\r2\u0006\u0010~\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0080\u0001J\u0017\u0010\u0081\u0001\u001a\u00020\r2\u0006\u0010/\u001a\u00020LH\u0001¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\rH\u0001¢\u0006\u0003\b\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020\rH\u0001¢\u0006\u0003\b\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020LH\u0082@¢\u0006\u0002\u0010MR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020(8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\b\u0012\u0004\u0012\u00020:098\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010*\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u008c\u0001"}, m1836d2 = {"Lcom/urbanairship/messagecenter/Inbox;", "", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "airshipChannel", "Lcom/urbanairship/channel/AirshipChannel;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "updateScheduler", "Lkotlin/Function1;", "Lcom/urbanairship/messagecenter/Inbox$UpdateType;", "", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/config/AirshipRuntimeConfig;Lkotlin/jvm/functions/Function1;)V", TCEventPropertiesNames.TCE_USER, "Lcom/urbanairship/messagecenter/User;", "messageDao", "Lcom/urbanairship/messagecenter/MessageDao;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "refreshDispatcher", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/messagecenter/User;Lcom/urbanairship/messagecenter/MessageDao;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/util/TaskSleeper;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "applicationListener", "com/urbanairship/messagecenter/Inbox$applicationListener$1", "Lcom/urbanairship/messagecenter/Inbox$applicationListener$1;", "channelRegistrationPayloadExtender", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "configListener", "Lcom/urbanairship/config/AirshipRuntimeConfig$ConfigChangeListener;", "expiryRefresh", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "inboxJobHandler", "Lcom/urbanairship/messagecenter/InboxJobHandler;", "getInboxJobHandler$urbanairship_message_center_release$annotations", "()V", "getInboxJobHandler$urbanairship_message_center_release", "()Lcom/urbanairship/messagecenter/InboxJobHandler;", "setInboxJobHandler$urbanairship_message_center_release", "(Lcom/urbanairship/messagecenter/InboxJobHandler;)V", "isEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "job", "Lkotlinx/coroutines/CompletableJob;", "listeners", "", "Lcom/urbanairship/messagecenter/InboxListener;", "refreshOnMessageExpiresJob", "Lkotlinx/coroutines/Job;", "refreshResults", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/messagecenter/Inbox$RefreshResult;", "getRefreshResults$urbanairship_message_center_release$annotations", "getRefreshResults$urbanairship_message_center_release", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getUser", "()Lcom/urbanairship/messagecenter/User;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "deleteAllMessages", "deleteAllMessagesInternal", "deleteMessages", "messageIds", "", "([Ljava/lang/String;)V", "", "fetchMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbanairship/Cancelable;", "looper", "Landroid/os/Looper;", "callback", "Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;", "filterMessages", "", "Lcom/urbanairship/messagecenter/Message;", "messages", "predicate", "Lcom/urbanairship/Predicate;", "getCount", "", "getCountPendingResult", "Lcom/urbanairship/PendingResult;", "getMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageByUrl", "messageUrl", "getMessageByUrlPendingResult", "getMessageIds", "getMessageIdsPendingResult", "getMessagePendingResult", "getMessages", "", "(Lcom/urbanairship/Predicate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessagesFlow", "Lkotlinx/coroutines/flow/Flow;", "getMessagesPendingResult", "getReadCount", "getReadCountPendingResult", "getReadMessages", "getReadMessagesPendingResult", "getUnreadCount", "getUnreadCountPendingResult", "getUnreadMessages", "getUnreadMessagesFlow", "getUnreadMessagesPendingResult", "markMessagesRead", "markMessagesUnread", "notifyInboxUpdated", "notifyInboxUpdated$urbanairship_message_center_release", "performUpdate", "Lkotlin/Result;", "performUpdate-IoAF18A$urbanairship_message_center_release", "removeListener", "scheduleUpdate", "reason", "scheduleUpdateIfEnabled", "scheduleUpdateIfEnabled$urbanairship_message_center_release", "setEnabled", "setEnabled$urbanairship_message_center_release", "setupRefreshOnMessageExpiresJob", "setupRefreshOnMessageExpiresJob$urbanairship_message_center_release", "tearDown", "tearDown$urbanairship_message_center_release", "updateInbox", "FetchMessagesCallback", "PendingFetchMessagesCallback", "RefreshResult", "UpdateType", "urbanairship-message-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nInbox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 5 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 6 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,711:1\n1#2:712\n1#2:726\n1#2:744\n1#2:762\n766#3:713\n857#3,2:714\n1603#3,9:716\n1855#3:725\n1856#3:727\n1612#3:728\n1603#3,9:734\n1855#3:743\n1856#3:745\n1612#3:746\n1603#3,9:752\n1855#3:761\n1856#3:763\n1612#3:764\n49#4:729\n51#4:733\n49#4:747\n51#4:751\n46#5:730\n51#5:732\n46#5:748\n51#5:750\n105#6:731\n105#6:749\n*S KotlinDebug\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n*L\n397#1:726\n448#1:744\n500#1:762\n387#1:713\n387#1:714,2\n397#1:716,9\n397#1:725\n397#1:727\n397#1:728\n448#1:734,9\n448#1:743\n448#1:745\n448#1:746\n500#1:752,9\n500#1:761\n500#1:763\n500#1:764\n412#1:729\n412#1:733\n464#1:747\n464#1:751\n412#1:730\n412#1:732\n464#1:748\n464#1:750\n412#1:731\n464#1:749\n*E\n"})
public final class Inbox {
    private final ActivityMonitor activityMonitor;
    private final AirshipChannel airshipChannel;
    private final Inbox$applicationListener$1 applicationListener;
    private final AirshipChannel.Extender.Suspending channelRegistrationPayloadExtender;
    private final Clock clock;
    private final AirshipRuntimeConfig config;
    private final AirshipRuntimeConfig.ConfigChangeListener configListener;
    private final MutableStateFlow expiryRefresh;
    private InboxJobHandler inboxJobHandler;
    private final AtomicBoolean isEnabled;
    private final CompletableJob job;
    private final List listeners;
    private final MessageDao messageDao;
    private final CoroutineDispatcher refreshDispatcher;
    private Job refreshOnMessageExpiresJob;
    private final MutableSharedFlow refreshResults;
    private final CoroutineScope scope;
    private final TaskSleeper taskSleeper;
    private final Function1 updateScheduler;
    private final User user;

    @Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;", "", "onFinished", "", OneIDTrackerEvent.EVENT_PARAM_SUCCESS, "", "urbanairship-message-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public interface FetchMessagesCallback {
        void onFinished(boolean success);
    }

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1836d2 = {"Lcom/urbanairship/messagecenter/Inbox$RefreshResult;", "", "(Ljava/lang/String;I)V", "LOCAL", "REMOTE_SUCCESS", "REMOTE_FAILED", "urbanairship-message-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum RefreshResult {
        LOCAL,
        REMOTE_SUCCESS,
        REMOTE_FAILED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<RefreshResult> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1836d2 = {"Lcom/urbanairship/messagecenter/Inbox$UpdateType;", "", "(Ljava/lang/String;I)V", "REQUIRED", "BEST_ATTEMPT", "urbanairship-message-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum UpdateType {
        REQUIRED,
        BEST_ATTEMPT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<UpdateType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$2 */
    static final class C54472 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C54472(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.fetchMessages(this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessage$1 */
    static final class C54521 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C54521(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessageByUrl$1 */
    static final class C54531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C54531(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessageByUrl(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessageIds$1 */
    static final class C54551 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C54551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessageIds(this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessages$1 */
    static final class C54581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C54581(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getReadMessages$1 */
    static final class C54631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C54631(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getReadMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessages$1 */
    static final class C54661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C54661(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getUnreadMessages(null, this);
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: getInboxJobHandler$urbanairship_message_center_release$annotations */
    public static /* synthetic */ void m1779x79af9799() {
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: getRefreshResults$urbanairship_message_center_release$annotations */
    public static /* synthetic */ void m1780xb1f55b6d() {
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<List<Message>> getMessagesPendingResult() {
        return getMessagesPendingResult$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<List<Message>> getReadMessagesPendingResult() {
        return getReadMessagesPendingResult$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<List<Message>> getUnreadMessagesPendingResult() {
        return getUnreadMessagesPendingResult$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.urbanairship.app.ApplicationListener, com.urbanairship.messagecenter.Inbox$applicationListener$1] */
    @VisibleForTesting
    public Inbox(@NotNull PreferenceDataStore dataStore, @NotNull User user, @NotNull MessageDao messageDao, @NotNull ActivityMonitor activityMonitor, @NotNull AirshipChannel airshipChannel, @NotNull AirshipRuntimeConfig config, @NotNull TaskSleeper taskSleeper, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher, @NotNull CoroutineDispatcher refreshDispatcher, @NotNull Function1<? super UpdateType, Unit> updateScheduler) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(refreshDispatcher, "refreshDispatcher");
        Intrinsics.checkNotNullParameter(updateScheduler, "updateScheduler");
        this.user = user;
        this.messageDao = messageDao;
        this.activityMonitor = activityMonitor;
        this.airshipChannel = airshipChannel;
        this.config = config;
        this.taskSleeper = taskSleeper;
        this.clock = clock;
        this.refreshDispatcher = refreshDispatcher;
        this.updateScheduler = updateScheduler;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(completableJobSupervisorJob$default));
        this.scope = CoroutineScope;
        this.inboxJobHandler = new InboxJobHandler(user, config, dataStore, messageDao);
        this.expiryRefresh = StateFlowKt.MutableStateFlow(null);
        this.refreshResults = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.listeners = new CopyOnWriteArrayList();
        this.isEnabled = new AtomicBoolean(false);
        ?? r1 = new ApplicationListener() { // from class: com.urbanairship.messagecenter.Inbox$applicationListener$1
            @Override // com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                this.this$0.scheduleUpdateIfEnabled$urbanairship_message_center_release(Inbox.UpdateType.BEST_ATTEMPT);
            }

            @Override // com.urbanairship.app.ApplicationListener
            public void onBackground(long time) {
                this.this$0.scheduleUpdateIfEnabled$urbanairship_message_center_release(Inbox.UpdateType.BEST_ATTEMPT);
            }
        };
        this.applicationListener = r1;
        AirshipRuntimeConfig.ConfigChangeListener configChangeListener = new AirshipRuntimeConfig.ConfigChangeListener() { // from class: com.urbanairship.messagecenter.Inbox$$ExternalSyntheticLambda0
            @Override // com.urbanairship.config.AirshipRuntimeConfig.ConfigChangeListener
            public final void onConfigUpdated() {
                Inbox.configListener$lambda$0(this.f$0);
            }
        };
        this.configListener = configChangeListener;
        AirshipChannel.Extender.Suspending suspending = new AirshipChannel.Extender.Suspending() { // from class: com.urbanairship.messagecenter.Inbox$channelRegistrationPayloadExtender$1
            @Override // com.urbanairship.channel.AirshipChannel.Extender.Suspending
            public final Object extend(ChannelRegistrationPayload.Builder builder, Continuation continuation) {
                if (!this.this$0.isEnabled.get()) {
                    return builder;
                }
                ChannelRegistrationPayload.Builder userId = builder.setUserId(this.this$0.getUser().getId());
                Intrinsics.checkNotNull(userId);
                return userId;
            }
        };
        this.channelRegistrationPayloadExtender = suspending;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C54391(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C54412(null), 3, null);
        airshipChannel.addChannelRegistrationPayloadExtender(suspending);
        activityMonitor.addApplicationListener(r1);
        config.addConfigListener(configChangeListener);
        m1781x1061688f();
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Inbox(PreferenceDataStore preferenceDataStore, User user, MessageDao messageDao, ActivityMonitor activityMonitor, AirshipChannel airshipChannel, AirshipRuntimeConfig airshipRuntimeConfig, TaskSleeper taskSleeper, Clock clock, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        TaskSleeper taskSleeper2 = (i & 64) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper;
        if ((i & 128) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(preferenceDataStore, user, messageDao, activityMonitor, airshipChannel, airshipRuntimeConfig, taskSleeper2, clock2, (i & 256) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i & 512) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher2, function1);
    }

    public Inbox(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipChannel airshipChannel, @NotNull AirshipRuntimeConfig config, @NotNull Function1<? super UpdateType, Unit> updateScheduler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(updateScheduler, "updateScheduler");
        User user = new User(dataStore);
        MessageDao dao = MessageDatabase.createDatabase(context, config.getConfigOptions()).getDao();
        Intrinsics.checkNotNullExpressionValue(dao, "getDao(...)");
        this(dataStore, user, dao, GlobalActivityMonitor.INSTANCE.shared(context), airshipChannel, config, null, null, null, null, updateScheduler, Currencies.XDR, null);
    }

    @NotNull
    /* JADX INFO: renamed from: getInboxJobHandler$urbanairship_message_center_release, reason: from getter */
    public final InboxJobHandler getInboxJobHandler() {
        return this.inboxJobHandler;
    }

    public final void setInboxJobHandler$urbanairship_message_center_release(@NotNull InboxJobHandler inboxJobHandler) {
        Intrinsics.checkNotNullParameter(inboxJobHandler, "<set-?>");
        this.inboxJobHandler = inboxJobHandler;
    }

    @NotNull
    public final MutableSharedFlow<RefreshResult> getRefreshResults$urbanairship_message_center_release() {
        return this.refreshResults;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configListener$lambda$0(Inbox this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scheduleUpdateIfEnabled$urbanairship_message_center_release(UpdateType.REQUIRED);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$1 */
    static final class C54391 extends SuspendLambda implements Function2 {
        int label;

        C54391(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54391(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final String id = Inbox.this.airshipChannel.getId();
                final StateFlow<String> channelIdFlow = Inbox.this.airshipChannel.getChannelIdFlow();
                Flow<String> flow = new Flow<String>() { // from class: com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1

                    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Inbox.kt\ncom/urbanairship/messagecenter/Inbox$1\n*L\n1#1,218:1\n18#2:219\n19#2:221\n138#3:220\n*E\n"})
                    public static final class C54402<T> implements FlowCollector {
                        final /* synthetic */ String $id$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2", m1845f = "Inbox.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return C54402.this.emit(null, this);
                            }
                        }

                        public C54402(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$id$inlined = str;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (Intrinsics.areEqual((String) obj, this.$id$inlined)) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = channelIdFlow.collect(new C54402(flowCollector, id), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final Inbox inbox = Inbox.this;
                FlowCollector<? super String> flowCollector = new FlowCollector() { // from class: com.urbanairship.messagecenter.Inbox.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(String str, Continuation continuation) {
                        inbox.scheduleUpdate(UpdateType.REQUIRED);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$2 */
    static final class C54412 extends SuspendLambda implements Function2 {
        int label;

        C54412(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54412(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<RefreshResult> refreshResults$urbanairship_message_center_release = Inbox.this.getRefreshResults$urbanairship_message_center_release();
                final Inbox inbox = Inbox.this;
                FlowCollector<? super RefreshResult> flowCollector = new FlowCollector() { // from class: com.urbanairship.messagecenter.Inbox.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(RefreshResult refreshResult, Continuation continuation) {
                        inbox.notifyInboxUpdated$urbanairship_message_center_release();
                        if (refreshResult == RefreshResult.REMOTE_SUCCESS) {
                            inbox.m1781x1061688f();
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (refreshResults$urbanairship_message_center_release.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0087  */
    /* JADX WARN: Code duplicated, block: B:34:0x0097 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x009a  */
    /* JADX WARN: Code duplicated, block: B:38:0x00aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: performUpdate-IoAF18A$urbanairship_message_center_release, reason: not valid java name */
    public final Object m5148performUpdateIoAF18A$urbanairship_message_center_release(@NotNull Continuation<? super Result<Boolean>> continuation) {
        Inbox$performUpdate$1 inbox$performUpdate$1;
        boolean zBooleanValue;
        MutableSharedFlow mutableSharedFlow;
        RefreshResult refreshResult;
        boolean z;
        MutableSharedFlow mutableSharedFlow2;
        RefreshResult refreshResult2;
        if (continuation instanceof Inbox$performUpdate$1) {
            inbox$performUpdate$1 = (Inbox$performUpdate$1) continuation;
            int i = inbox$performUpdate$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                inbox$performUpdate$1.label = i - Integer.MIN_VALUE;
            } else {
                inbox$performUpdate$1 = new Inbox$performUpdate$1(this, continuation);
            }
        } else {
            inbox$performUpdate$1 = new Inbox$performUpdate$1(this, continuation);
        }
        Object objUpdateInbox = inbox$performUpdate$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = inbox$performUpdate$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateInbox);
            if (!this.isEnabled.get()) {
                MutableSharedFlow mutableSharedFlow3 = this.refreshResults;
                RefreshResult refreshResult3 = RefreshResult.REMOTE_FAILED;
                inbox$performUpdate$1.label = 1;
                if (mutableSharedFlow3.emit(refreshResult3, inbox$performUpdate$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.Companion companion = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new IllegalStateException("Unable to update when disabled")));
            }
            inbox$performUpdate$1.L$0 = this;
            inbox$performUpdate$1.label = 2;
            objUpdateInbox = updateInbox(inbox$performUpdate$1);
            if (objUpdateInbox == coroutine_suspended) {
                return coroutine_suspended;
            }
            zBooleanValue = ((Boolean) objUpdateInbox).booleanValue();
            if (zBooleanValue) {
                mutableSharedFlow2 = this.refreshResults;
                refreshResult2 = RefreshResult.REMOTE_SUCCESS;
                inbox$performUpdate$1.L$0 = null;
                inbox$performUpdate$1.Z$0 = zBooleanValue;
                inbox$performUpdate$1.label = 3;
                if (mutableSharedFlow2.emit(refreshResult2, inbox$performUpdate$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                mutableSharedFlow = this.refreshResults;
                refreshResult = RefreshResult.REMOTE_FAILED;
                inbox$performUpdate$1.L$0 = null;
                inbox$performUpdate$1.Z$0 = zBooleanValue;
                inbox$performUpdate$1.label = 4;
                if (mutableSharedFlow.emit(refreshResult, inbox$performUpdate$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            z = zBooleanValue;
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objUpdateInbox);
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new IllegalStateException("Unable to update when disabled")));
            }
            if (i2 == 2) {
                this = (Inbox) inbox$performUpdate$1.L$0;
                ResultKt.throwOnFailure(objUpdateInbox);
                zBooleanValue = ((Boolean) objUpdateInbox).booleanValue();
                if (zBooleanValue) {
                    mutableSharedFlow2 = this.refreshResults;
                    refreshResult2 = RefreshResult.REMOTE_SUCCESS;
                    inbox$performUpdate$1.L$0 = null;
                    inbox$performUpdate$1.Z$0 = zBooleanValue;
                    inbox$performUpdate$1.label = 3;
                    if (mutableSharedFlow2.emit(refreshResult2, inbox$performUpdate$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    mutableSharedFlow = this.refreshResults;
                    refreshResult = RefreshResult.REMOTE_FAILED;
                    inbox$performUpdate$1.L$0 = null;
                    inbox$performUpdate$1.Z$0 = zBooleanValue;
                    inbox$performUpdate$1.label = 4;
                    if (mutableSharedFlow.emit(refreshResult, inbox$performUpdate$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                z = zBooleanValue;
            } else {
                if (i2 != 3 && i2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = inbox$performUpdate$1.Z$0;
                ResultKt.throwOnFailure(objUpdateInbox);
            }
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m5277constructorimpl(Boxing.boxBoolean(z));
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$updateInbox$2 */
    static final class C54752 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        C54752(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54752(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00a4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b1 A[ADDED_TO_REGION] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String id;
            UserCredentials userCredentials;
            String str;
            boolean zBooleanValue;
            Object objSyncDeletedMessageState;
            boolean z;
            UserCredentials userCredentials2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    id = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 2) {
                        userCredentials = (UserCredentials) this.L$1;
                        str = (String) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        InboxJobHandler inboxJobHandler = Inbox.this.getInboxJobHandler();
                        this.L$0 = str;
                        this.L$1 = userCredentials;
                        this.Z$0 = zBooleanValue;
                        this.label = 3;
                        objSyncDeletedMessageState = inboxJobHandler.syncDeletedMessageState(userCredentials, str, this);
                        if (objSyncDeletedMessageState == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        UserCredentials userCredentials3 = userCredentials;
                        z = zBooleanValue;
                        obj = objSyncDeletedMessageState;
                        userCredentials2 = userCredentials3;
                        boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                        if (z) {
                        }
                        return Boxing.boxBoolean(false);
                    }
                    if (i == 3) {
                        z = this.Z$0;
                        userCredentials2 = (UserCredentials) this.L$1;
                        str = (String) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        boolean zBooleanValue3 = ((Boolean) obj).booleanValue();
                        if (z || !zBooleanValue3) {
                            return Boxing.boxBoolean(false);
                        }
                        InboxJobHandler inboxJobHandler2 = Inbox.this.getInboxJobHandler();
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 4;
                        obj = inboxJobHandler2.syncMessageList(userCredentials2, str, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                }
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            id = Inbox.this.airshipChannel.getId();
            if (id == null) {
                return Boxing.boxBoolean(false);
            }
            InboxJobHandler inboxJobHandler3 = Inbox.this.getInboxJobHandler();
            this.L$0 = id;
            this.label = 1;
            obj = inboxJobHandler3.getOrCreateUserCredentials(id, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            UserCredentials userCredentials4 = (UserCredentials) obj;
            if (userCredentials4 == null) {
                return Boxing.boxBoolean(false);
            }
            InboxJobHandler inboxJobHandler4 = Inbox.this.getInboxJobHandler();
            this.L$0 = id;
            this.L$1 = userCredentials4;
            this.label = 2;
            Object objSyncReadMessageState = inboxJobHandler4.syncReadMessageState(userCredentials4, id, this);
            if (objSyncReadMessageState == coroutine_suspended) {
                return coroutine_suspended;
            }
            String str2 = id;
            userCredentials = userCredentials4;
            obj = objSyncReadMessageState;
            str = str2;
            zBooleanValue = ((Boolean) obj).booleanValue();
            InboxJobHandler inboxJobHandler5 = Inbox.this.getInboxJobHandler();
            this.L$0 = str;
            this.L$1 = userCredentials;
            this.Z$0 = zBooleanValue;
            this.label = 3;
            objSyncDeletedMessageState = inboxJobHandler5.syncDeletedMessageState(userCredentials, str, this);
            if (objSyncDeletedMessageState == coroutine_suspended) {
                return coroutine_suspended;
            }
            UserCredentials userCredentials5 = userCredentials;
            z = zBooleanValue;
            obj = objSyncDeletedMessageState;
            userCredentials2 = userCredentials5;
            boolean zBooleanValue4 = ((Boolean) obj).booleanValue();
            if (z) {
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateInbox(Continuation continuation) {
        return BuildersKt.withContext(this.refreshDispatcher, new C54752(null), continuation);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void tearDown$urbanairship_message_center_release() {
        this.activityMonitor.removeApplicationListener(this.applicationListener);
        this.airshipChannel.removeChannelRegistrationPayloadExtender(this.channelRegistrationPayloadExtender);
        Job job = this.refreshOnMessageExpiresJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.config.removeRemoteConfigListener(this.configListener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* JADX INFO: renamed from: setupRefreshOnMessageExpiresJob$urbanairship_message_center_release */
    public final void m1781x1061688f() {
        Job job = this.refreshOnMessageExpiresJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.refreshOnMessageExpiresJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new Inbox$setupRefreshOnMessageExpiresJob$1(this, null), 3, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setEnabled$urbanairship_message_center_release(boolean isEnabled) {
        if (this.isEnabled.compareAndSet(!isEnabled, isEnabled)) {
            if (isEnabled) {
                scheduleUpdate(UpdateType.BEST_ATTEMPT);
            } else {
                deleteAllMessagesInternal();
                this.inboxJobHandler.removeStoredData$urbanairship_message_center_release();
            }
        }
    }

    public final void addListener(@NotNull InboxListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeListener(@NotNull InboxListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @NotNull
    public final Cancelable fetchMessages(@NotNull FetchMessagesCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return fetchMessages(null, callback);
    }

    public static /* synthetic */ Cancelable fetchMessages$default(Inbox inbox, Looper looper, FetchMessagesCallback fetchMessagesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            looper = null;
        }
        if ((i & 2) != 0) {
            fetchMessagesCallback = null;
        }
        return inbox.fetchMessages(looper, fetchMessagesCallback);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$1 */
    static final class C54461 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingFetchMessagesCallback $cancelableOperation;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54461(PendingFetchMessagesCallback pendingFetchMessagesCallback, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$cancelableOperation = pendingFetchMessagesCallback;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54461(this.$cancelableOperation, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingFetchMessagesCallback pendingFetchMessagesCallback;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingFetchMessagesCallback pendingFetchMessagesCallback2 = this.$cancelableOperation;
                Inbox inbox = this.this$0;
                this.L$0 = pendingFetchMessagesCallback2;
                this.label = 1;
                Object objFetchMessages = inbox.fetchMessages(this);
                if (objFetchMessages == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pendingFetchMessagesCallback = pendingFetchMessagesCallback2;
                obj = objFetchMessages;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingFetchMessagesCallback = (PendingFetchMessagesCallback) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingFetchMessagesCallback.setResult(((Boolean) obj).booleanValue());
            this.$cancelableOperation.run();
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final Cancelable fetchMessages(@Nullable Looper looper, @Nullable FetchMessagesCallback callback) {
        PendingFetchMessagesCallback pendingFetchMessagesCallback = new PendingFetchMessagesCallback(callback, looper);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54461(pendingFetchMessagesCallback, this, null), 3, null);
        return pendingFetchMessagesCallback;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object fetchMessages(Continuation continuation) {
        C54472 c54472;
        if (continuation instanceof C54472) {
            c54472 = (C54472) continuation;
            int i = c54472.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54472.label = i - Integer.MIN_VALUE;
            } else {
                c54472 = new C54472(continuation);
            }
        } else {
            c54472 = new C54472(continuation);
        }
        Object objFirst = c54472.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54472.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            if (this.isEnabled.get()) {
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54494(null), 3, null);
                MutableSharedFlow mutableSharedFlow = this.refreshResults;
                C54505 c54505 = new C54505(null);
                c54472.label = 1;
                objFirst = FlowKt.first(mutableSharedFlow, c54505, c54472);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.messagecenter.Inbox.fetchMessages.3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to resume fetchMessages, Message Center is disabled.";
                    }
                }, 1, null);
                return Boxing.boxBoolean(false);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirst);
        }
        return Boxing.boxBoolean(objFirst == RefreshResult.REMOTE_SUCCESS);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$4 */
    static final class C54494 extends SuspendLambda implements Function2 {
        int label;

        C54494(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54494(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54494) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Inbox.this.scheduleUpdate(UpdateType.REQUIRED);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$5 */
    static final class C54505 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C54505(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C54505 c54505 = new C54505(continuation);
            c54505.L$0 = obj;
            return c54505;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(RefreshResult refreshResult, Continuation continuation) {
            return ((C54505) create(refreshResult, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((RefreshResult) this.L$0) != RefreshResult.LOCAL);
        }
    }

    public final /* synthetic */ Object getCount(Continuation continuation) {
        return this.messageDao.getMessageCount(continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getCountPendingResult$1 */
    static final class C54511 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54511(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54511(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                MessageDao messageDao = this.this$0.messageDao;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object messageCount = messageDao.getMessageCount(this);
                if (messageCount == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = messageCount;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<Integer> getCountPendingResult() {
        PendingResult<Integer> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54511(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object getMessageIds(Continuation continuation) {
        C54551 c54551;
        if (continuation instanceof C54551) {
            c54551 = (C54551) continuation;
            int i = c54551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54551.label = i - Integer.MIN_VALUE;
            } else {
                c54551 = new C54551(continuation);
            }
        } else {
            c54551 = new C54551(continuation);
        }
        Object messageIds = c54551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(messageIds);
            MessageDao messageDao = this.messageDao;
            c54551.label = 1;
            messageIds = messageDao.getMessageIds(c54551);
            if (messageIds == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(messageIds);
        }
        return CollectionsKt.toSet((Iterable) messageIds);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessageIdsPendingResult$1 */
    static final class C54561 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54561(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54561(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                MessageDao messageDao = this.this$0.messageDao;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object messageIds = messageDao.getMessageIds(this);
                if (messageIds == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = messageIds;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(CollectionsKt.toSet((Iterable) obj));
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<Set<String>> getMessageIdsPendingResult() {
        PendingResult<Set<String>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54561(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    public final /* synthetic */ Object getReadCount(Continuation continuation) {
        return this.messageDao.getReadMessageCount(continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getReadCountPendingResult$1 */
    static final class C54621 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54621(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54621(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                MessageDao messageDao = this.this$0.messageDao;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object readMessageCount = messageDao.getReadMessageCount(this);
                if (readMessageCount == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = readMessageCount;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<Integer> getReadCountPendingResult() {
        PendingResult<Integer> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54621(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    public final /* synthetic */ Object getUnreadCount(Continuation continuation) {
        return this.messageDao.getUnreadMessageCount(continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getUnreadCountPendingResult$1 */
    static final class C54651 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54651(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54651(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                MessageDao messageDao = this.this$0.messageDao;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object unreadMessageCount = messageDao.getUnreadMessageCount(this);
                if (unreadMessageCount == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = unreadMessageCount;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<Integer> getUnreadCountPendingResult() {
        PendingResult<Integer> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54651(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    public static /* synthetic */ Object getMessages$default(Inbox inbox, Predicate predicate, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getMessages(predicate, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object getMessages(Predicate predicate, Continuation continuation) {
        C54581 c54581;
        if (continuation instanceof C54581) {
            c54581 = (C54581) continuation;
            int i = c54581.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54581.label = i - Integer.MIN_VALUE;
            } else {
                c54581 = new C54581(continuation);
            }
        } else {
            c54581 = new C54581(continuation);
        }
        Object messages = c54581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54581.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(messages);
            MessageDao messageDao = this.messageDao;
            c54581.L$0 = this;
            c54581.L$1 = predicate;
            c54581.label = 1;
            messages = messageDao.getMessages(c54581);
            if (messages == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            predicate = (Predicate) c54581.L$1;
            this = (Inbox) c54581.L$0;
            ResultKt.throwOnFailure(messages);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) messages).iterator();
        while (it.hasNext()) {
            Message message = ((MessageEntity) it.next()).toMessage();
            if (message != null) {
                arrayList.add(message);
            }
        }
        return CollectionsKt.sortedWith(this.filterMessages(arrayList, predicate), Message.INSTANCE.getSENT_DATE_COMPARATOR());
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessagesFlow$1 */
    static final class C54601 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        C54601(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(List list, String str, Continuation continuation) {
            C54601 c54601 = new C54601(continuation);
            c54601.L$0 = list;
            return c54601.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (List) this.L$0;
        }
    }

    public static /* synthetic */ Flow getMessagesFlow$default(Inbox inbox, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getMessagesFlow(predicate);
    }

    public final /* synthetic */ Flow getMessagesFlow(final Predicate predicate) {
        final Flow flowCombine = FlowKt.combine(this.messageDao.getMessagesFlow(), this.expiryRefresh, new C54601(null));
        return FlowKt.distinctUntilChanged(new Flow<List<? extends Message>>() { // from class: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1

            /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n50#2:219\n413#3:220\n414#3,3:234\n417#3:239\n1603#4,9:221\n1855#4:230\n1856#4:232\n1612#4:233\n766#4:237\n857#4:238\n858#4:240\n1#5:231\n*S KotlinDebug\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n*L\n413#1:221,9\n413#1:230\n413#1:232\n413#1:233\n416#1:237\n416#1:238\n416#1:240\n413#1:231\n*E\n"})
            public static final class C54592<T> implements FlowCollector {
                final /* synthetic */ Predicate $predicate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Inbox this$0;

                /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2", m1845f = "Inbox.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C54592.this.emit(null, this);
                    }
                }

                public C54592(FlowCollector flowCollector, Inbox inbox, Predicate predicate) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = inbox;
                    this.$predicate$inlined = predicate;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = ((List) obj).iterator();
                        while (it.hasNext()) {
                            Message message = ((MessageEntity) it.next()).toMessage();
                            if (message != null) {
                                arrayList.add(message);
                            }
                        }
                        List listSortedWith = CollectionsKt.sortedWith(this.this$0.filterMessages(arrayList, this.$predicate$inlined), Message.INSTANCE.getSENT_DATE_COMPARATOR());
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : listSortedWith) {
                            if (!((Message) t).isExpired()) {
                                arrayList2.add(t);
                            }
                        }
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends Message>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowCombine.collect(new C54592(flowCollector, this, predicate), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingResult getMessagesPendingResult$default(Inbox inbox, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getMessagesPendingResult(predicate);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessagesPendingResult$1 */
    static final class C54611 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54611(PendingResult pendingResult, Inbox inbox, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54611(this.$result, this.this$0, this.$predicate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                Inbox inbox = this.this$0;
                Predicate predicate = this.$predicate;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object messages = inbox.getMessages(predicate, this);
                if (messages == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = messages;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<List<Message>> getMessagesPendingResult(@Nullable Predicate<Message> predicate) {
        PendingResult<List<Message>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54611(pendingResult, this, predicate, null), 3, null);
        return pendingResult;
    }

    public static /* synthetic */ Object getUnreadMessages$default(Inbox inbox, Predicate predicate, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getUnreadMessages(predicate, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object getUnreadMessages(Predicate predicate, Continuation continuation) {
        C54661 c54661;
        if (continuation instanceof C54661) {
            c54661 = (C54661) continuation;
            int i = c54661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54661.label = i - Integer.MIN_VALUE;
            } else {
                c54661 = new C54661(continuation);
            }
        } else {
            c54661 = new C54661(continuation);
        }
        Object unreadMessages = c54661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54661.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(unreadMessages);
            MessageDao messageDao = this.messageDao;
            c54661.L$0 = this;
            c54661.L$1 = predicate;
            c54661.label = 1;
            unreadMessages = messageDao.getUnreadMessages(c54661);
            if (unreadMessages == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            predicate = (Predicate) c54661.L$1;
            this = (Inbox) c54661.L$0;
            ResultKt.throwOnFailure(unreadMessages);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) unreadMessages).iterator();
        while (it.hasNext()) {
            Message message = ((MessageEntity) it.next()).toMessage();
            if (message != null) {
                arrayList.add(message);
            }
        }
        return CollectionsKt.sortedWith(this.filterMessages(arrayList, predicate), Message.INSTANCE.getSENT_DATE_COMPARATOR());
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$1 */
    static final class C54681 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        C54681(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(List list, String str, Continuation continuation) {
            C54681 c54681 = new C54681(continuation);
            c54681.L$0 = list;
            return c54681.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (List) this.L$0;
        }
    }

    public static /* synthetic */ Flow getUnreadMessagesFlow$default(Inbox inbox, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getUnreadMessagesFlow(predicate);
    }

    public final /* synthetic */ Flow getUnreadMessagesFlow(final Predicate predicate) {
        final Flow flowCombine = FlowKt.combine(this.messageDao.getUnreadMessagesFlow(), this.expiryRefresh, new C54681(null));
        return FlowKt.distinctUntilChanged(new Flow<List<? extends Message>>() { // from class: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1

            /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n50#2:219\n465#3:220\n466#3,3:234\n469#3:239\n1603#4,9:221\n1855#4:230\n1856#4:232\n1612#4:233\n766#4:237\n857#4:238\n858#4:240\n1#5:231\n*S KotlinDebug\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n*L\n465#1:221,9\n465#1:230\n465#1:232\n465#1:233\n468#1:237\n468#1:238\n468#1:240\n465#1:231\n*E\n"})
            public static final class C54672<T> implements FlowCollector {
                final /* synthetic */ Predicate $predicate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Inbox this$0;

                /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2", m1845f = "Inbox.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C54672.this.emit(null, this);
                    }
                }

                public C54672(FlowCollector flowCollector, Inbox inbox, Predicate predicate) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = inbox;
                    this.$predicate$inlined = predicate;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = ((List) obj).iterator();
                        while (it.hasNext()) {
                            Message message = ((MessageEntity) it.next()).toMessage();
                            if (message != null) {
                                arrayList.add(message);
                            }
                        }
                        List listSortedWith = CollectionsKt.sortedWith(this.this$0.filterMessages(arrayList, this.$predicate$inlined), Message.INSTANCE.getSENT_DATE_COMPARATOR());
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : listSortedWith) {
                            if (!((Message) t).isExpired()) {
                                arrayList2.add(t);
                            }
                        }
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends Message>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowCombine.collect(new C54672(flowCollector, this, predicate), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingResult getUnreadMessagesPendingResult$default(Inbox inbox, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getUnreadMessagesPendingResult(predicate);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesPendingResult$1 */
    static final class C54691 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54691(PendingResult pendingResult, Inbox inbox, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54691(this.$result, this.this$0, this.$predicate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                Inbox inbox = this.this$0;
                Predicate predicate = this.$predicate;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object unreadMessages = inbox.getUnreadMessages(predicate, this);
                if (unreadMessages == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = unreadMessages;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<List<Message>> getUnreadMessagesPendingResult(@Nullable Predicate<Message> predicate) {
        PendingResult<List<Message>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54691(pendingResult, this, predicate, null), 3, null);
        return pendingResult;
    }

    public static /* synthetic */ Object getReadMessages$default(Inbox inbox, Predicate predicate, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getReadMessages(predicate, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object getReadMessages(Predicate predicate, Continuation continuation) {
        C54631 c54631;
        if (continuation instanceof C54631) {
            c54631 = (C54631) continuation;
            int i = c54631.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54631.label = i - Integer.MIN_VALUE;
            } else {
                c54631 = new C54631(continuation);
            }
        } else {
            c54631 = new C54631(continuation);
        }
        Object readMessages = c54631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54631.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(readMessages);
            MessageDao messageDao = this.messageDao;
            c54631.L$0 = this;
            c54631.L$1 = predicate;
            c54631.label = 1;
            readMessages = messageDao.getReadMessages(c54631);
            if (readMessages == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            predicate = (Predicate) c54631.L$1;
            this = (Inbox) c54631.L$0;
            ResultKt.throwOnFailure(readMessages);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) readMessages).iterator();
        while (it.hasNext()) {
            Message message = ((MessageEntity) it.next()).toMessage();
            if (message != null) {
                arrayList.add(message);
            }
        }
        return CollectionsKt.sortedWith(this.filterMessages(arrayList, predicate), Message.INSTANCE.getSENT_DATE_COMPARATOR());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingResult getReadMessagesPendingResult$default(Inbox inbox, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getReadMessagesPendingResult(predicate);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getReadMessagesPendingResult$1 */
    static final class C54641 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54641(PendingResult pendingResult, Inbox inbox, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54641(this.$result, this.this$0, this.$predicate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                Inbox inbox = this.this$0;
                Predicate predicate = this.$predicate;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object readMessages = inbox.getReadMessages(predicate, this);
                if (readMessages == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = readMessages;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<List<Message>> getReadMessagesPendingResult(@Nullable Predicate<Message> predicate) {
        PendingResult<List<Message>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54641(pendingResult, this, predicate, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object getMessage(String str, Continuation continuation) {
        C54521 c54521;
        if (continuation instanceof C54521) {
            c54521 = (C54521) continuation;
            int i = c54521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54521.label = i - Integer.MIN_VALUE;
            } else {
                c54521 = new C54521(continuation);
            }
        } else {
            c54521 = new C54521(continuation);
        }
        Object message = c54521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54521.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(message);
            if (str == null) {
                return null;
            }
            MessageDao messageDao = this.messageDao;
            c54521.label = 1;
            message = messageDao.getMessage(str, c54521);
            if (message == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(message);
        }
        MessageEntity messageEntity = (MessageEntity) message;
        if (messageEntity != null) {
            return messageEntity.toMessage();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessagePendingResult$1 */
    static final class C54571 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $messageId;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54571(PendingResult pendingResult, Inbox inbox, String str, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54571(this.$result, this.this$0, this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                Inbox inbox = this.this$0;
                String str = this.$messageId;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object message = inbox.getMessage(str, this);
                if (message == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = message;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<Message> getMessagePendingResult(@Nullable String messageId) {
        PendingResult<Message> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54571(pendingResult, this, messageId, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object getMessageByUrl(String str, Continuation continuation) {
        C54531 c54531;
        if (continuation instanceof C54531) {
            c54531 = (C54531) continuation;
            int i = c54531.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54531.label = i - Integer.MIN_VALUE;
            } else {
                c54531 = new C54531(continuation);
            }
        } else {
            c54531 = new C54531(continuation);
        }
        Object messageByUrl = c54531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54531.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(messageByUrl);
            if (str == null) {
                return null;
            }
            MessageDao messageDao = this.messageDao;
            c54531.label = 1;
            messageByUrl = messageDao.getMessageByUrl(str, c54531);
            if (messageByUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(messageByUrl);
        }
        MessageEntity messageEntity = (MessageEntity) messageByUrl;
        if (messageEntity != null) {
            return messageEntity.toMessage();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$getMessageByUrlPendingResult$1 */
    static final class C54541 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $messageUrl;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54541(PendingResult pendingResult, Inbox inbox, String str, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$messageUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C54541(this.$result, this.this$0, this.$messageUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                Inbox inbox = this.this$0;
                String str = this.$messageUrl;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object messageByUrl = inbox.getMessageByUrl(str, this);
                if (messageByUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = messageByUrl;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<Message> getMessageByUrlPendingResult(@Nullable String messageUrl) {
        PendingResult<Message> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54541(pendingResult, this, messageUrl, null), 3, null);
        return pendingResult;
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$markMessagesRead$1 */
    static final class C54701 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54701(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54701(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesRead(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void markMessagesRead(@NotNull Set<String> messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54701(messageIds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$markMessagesRead$2 */
    static final class C54712 extends SuspendLambda implements Function2 {
        final /* synthetic */ String[] $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54712(String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54712(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                Set<String> set = ArraysKt.toSet(this.$messageIds);
                this.label = 1;
                if (messageDao.markMessagesRead(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void markMessagesRead(@NotNull String... messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54712(messageIds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$markMessagesUnread$1 */
    static final class C54721 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54721(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54721(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesUnread(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void markMessagesUnread(@NotNull Set<String> messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54721(messageIds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$markMessagesUnread$2 */
    static final class C54732 extends SuspendLambda implements Function2 {
        final /* synthetic */ String[] $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54732(String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54732(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                Set<String> set = ArraysKt.toSet(this.$messageIds);
                this.label = 1;
                if (messageDao.markMessagesUnread(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void markMessagesUnread(@NotNull String... messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54732(messageIds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$deleteMessages$1 */
    static final class C54441 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54441(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54441(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                Set<String> set = this.$messageIds;
                this.label = 1;
                if (messageDao.markMessagesDeleted(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void deleteMessages(@NotNull Set<String> messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54441(messageIds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$deleteMessages$2 */
    static final class C54452 extends SuspendLambda implements Function2 {
        final /* synthetic */ String[] $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C54452(String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54452(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                Set<String> set = ArraysKt.toSet(this.$messageIds);
                this.label = 1;
                if (messageDao.markMessagesDeleted(set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void deleteMessages(@NotNull String... messageIds) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54452(messageIds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$deleteAllMessages$1 */
    static final class C54421 extends SuspendLambda implements Function2 {
        int label;

        C54421(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54421(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                this.label = 1;
                if (messageDao.markAllMessagesDeleted(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    public final void deleteAllMessages() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54421(null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.messagecenter.Inbox$deleteAllMessagesInternal$1 */
    static final class C54431 extends SuspendLambda implements Function2 {
        int label;

        C54431(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C54431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDao messageDao = Inbox.this.messageDao;
                this.label = 1;
                if (messageDao.deleteAllMessages(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Inbox.this.getRefreshResults$urbanairship_message_center_release().tryEmit(RefreshResult.LOCAL);
            return Unit.INSTANCE;
        }
    }

    private final void deleteAllMessagesInternal() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54431(null), 3, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyInboxUpdated$urbanairship_message_center_release() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new Inbox$notifyInboxUpdated$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleUpdate(UpdateType reason) {
        this.updateScheduler.invoke(reason);
    }

    public final void scheduleUpdateIfEnabled$urbanairship_message_center_release(@NotNull UpdateType reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.isEnabled.get()) {
            this.updateScheduler.invoke(reason);
        }
    }

    @Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/messagecenter/Inbox$PendingFetchMessagesCallback;", "Lcom/urbanairship/CancelableOperation;", "callback", "Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;", "looper", "Landroid/os/Looper;", "(Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;Landroid/os/Looper;)V", "result", "", "getResult", "()Z", "setResult", "(Z)V", "onRun", "", "urbanairship-message-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class PendingFetchMessagesCallback extends CancelableOperation {
        private final FetchMessagesCallback callback;
        private boolean result;

        public PendingFetchMessagesCallback(@Nullable FetchMessagesCallback fetchMessagesCallback, @Nullable Looper looper) {
            super(looper);
            this.callback = fetchMessagesCallback;
        }

        public final boolean getResult() {
            return this.result;
        }

        public final void setResult(boolean z) {
            this.result = z;
        }

        @Override // com.urbanairship.CancelableOperation
        protected void onRun() {
            FetchMessagesCallback fetchMessagesCallback = this.callback;
            if (fetchMessagesCallback != null) {
                fetchMessagesCallback.onFinished(this.result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection filterMessages(Collection messages, Predicate predicate) {
        if (predicate == null) {
            return messages;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : messages) {
            if (predicate.apply((Message) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
