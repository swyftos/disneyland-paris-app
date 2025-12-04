package com.urbanairship.messagecenter;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.contentsquare.android.api.Currencies;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.Cancelable;
import com.urbanairship.CancelableOperation;
import com.urbanairship.PendingResult;
import com.urbanairship.Predicate;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.ChannelRegistrationPayload;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\u001e\u0018\u00002\u00020\u0001:\b\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001B;\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eBs\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u001cJ\u000e\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u000205J\u0006\u0010D\u001a\u00020\rJ\b\u0010E\u001a\u00020\rH\u0002J\u001f\u0010F\u001a\u00020\r2\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0H\"\u00020&¢\u0006\u0002\u0010IJ\u0014\u0010F\u001a\u00020\r2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0JJ\u000e\u0010K\u001a\u00020LH\u0086@¢\u0006\u0002\u0010MJ\u001e\u0010K\u001a\u00020N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010RJ\u000e\u0010K\u001a\u00020N2\u0006\u0010Q\u001a\u00020RJ,\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020U0T2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0002J\u000e\u0010Y\u001a\u00020ZH\u0086@¢\u0006\u0002\u0010MJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0\\J\u001a\u0010]\u001a\u0004\u0018\u00010U2\b\u0010^\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0002\u0010_J\u001a\u0010`\u001a\u0004\u0018\u00010U2\b\u0010a\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0002\u0010_J\u0018\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0\\2\b\u0010a\u001a\u0004\u0018\u00010&J\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020&0JH\u0086@¢\u0006\u0002\u0010MJ\u0012\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0J0\\J\u0018\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0\\2\b\u0010^\u001a\u0004\u0018\u00010&J&\u0010f\u001a\b\u0012\u0004\u0012\u00020U0g2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0086@¢\u0006\u0002\u0010hJ$\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0g0j2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XJ(\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010g0\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0007J\u000e\u0010l\u001a\u00020ZH\u0086@¢\u0006\u0002\u0010MJ\f\u0010m\u001a\b\u0012\u0004\u0012\u00020Z0\\J&\u0010n\u001a\b\u0012\u0004\u0012\u00020U0g2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0086@¢\u0006\u0002\u0010hJ(\u0010o\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010g0\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0007J\u000e\u0010p\u001a\u00020ZH\u0086@¢\u0006\u0002\u0010MJ\f\u0010q\u001a\b\u0012\u0004\u0012\u00020Z0\\J&\u0010r\u001a\b\u0012\u0004\u0012\u00020U0g2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0086@¢\u0006\u0002\u0010hJ$\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0g0j2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XJ(\u0010t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010g0\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010XH\u0007J\u001f\u0010u\u001a\u00020\r2\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0H\"\u00020&¢\u0006\u0002\u0010IJ\u0014\u0010u\u001a\u00020\r2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0JJ\u001f\u0010v\u001a\u00020\r2\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0H\"\u00020&¢\u0006\u0002\u0010IJ\u0014\u0010v\u001a\u00020\r2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0JJ\r\u0010w\u001a\u00020\rH\u0001¢\u0006\u0002\bxJ\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020L0zH\u0080@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b{\u0010MJ\u000e\u0010|\u001a\u00020\r2\u0006\u0010C\u001a\u000205J\u0010\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\fH\u0003J\u0016\u0010\u007f\u001a\u00020\r2\u0006\u0010~\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0080\u0001J\u0017\u0010\u0081\u0001\u001a\u00020\r2\u0006\u0010/\u001a\u00020LH\u0001¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\rH\u0001¢\u0006\u0003\b\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020\rH\u0001¢\u0006\u0003\b\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020LH\u0082@¢\u0006\u0002\u0010MR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020(8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\b\u0012\u0004\u0012\u00020:098\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010*\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/urbanairship/messagecenter/Inbox;", "", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "airshipChannel", "Lcom/urbanairship/channel/AirshipChannel;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "updateScheduler", "Lkotlin/Function1;", "Lcom/urbanairship/messagecenter/Inbox$UpdateType;", "", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/config/AirshipRuntimeConfig;Lkotlin/jvm/functions/Function1;)V", TCEventPropertiesNames.TCE_USER, "Lcom/urbanairship/messagecenter/User;", "messageDao", "Lcom/urbanairship/messagecenter/MessageDao;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "refreshDispatcher", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/messagecenter/User;Lcom/urbanairship/messagecenter/MessageDao;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/util/TaskSleeper;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "applicationListener", "com/urbanairship/messagecenter/Inbox$applicationListener$1", "Lcom/urbanairship/messagecenter/Inbox$applicationListener$1;", "channelRegistrationPayloadExtender", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "configListener", "Lcom/urbanairship/config/AirshipRuntimeConfig$ConfigChangeListener;", "expiryRefresh", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "inboxJobHandler", "Lcom/urbanairship/messagecenter/InboxJobHandler;", "getInboxJobHandler$urbanairship_message_center_release$annotations", "()V", "getInboxJobHandler$urbanairship_message_center_release", "()Lcom/urbanairship/messagecenter/InboxJobHandler;", "setInboxJobHandler$urbanairship_message_center_release", "(Lcom/urbanairship/messagecenter/InboxJobHandler;)V", "isEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "job", "Lkotlinx/coroutines/CompletableJob;", "listeners", "", "Lcom/urbanairship/messagecenter/InboxListener;", "refreshOnMessageExpiresJob", "Lkotlinx/coroutines/Job;", "refreshResults", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/messagecenter/Inbox$RefreshResult;", "getRefreshResults$urbanairship_message_center_release$annotations", "getRefreshResults$urbanairship_message_center_release", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "getUser", "()Lcom/urbanairship/messagecenter/User;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "deleteAllMessages", "deleteAllMessagesInternal", "deleteMessages", "messageIds", "", "([Ljava/lang/String;)V", "", "fetchMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbanairship/Cancelable;", "looper", "Landroid/os/Looper;", "callback", "Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;", "filterMessages", "", "Lcom/urbanairship/messagecenter/Message;", "messages", "predicate", "Lcom/urbanairship/Predicate;", "getCount", "", "getCountPendingResult", "Lcom/urbanairship/PendingResult;", "getMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageByUrl", "messageUrl", "getMessageByUrlPendingResult", "getMessageIds", "getMessageIdsPendingResult", "getMessagePendingResult", "getMessages", "", "(Lcom/urbanairship/Predicate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessagesFlow", "Lkotlinx/coroutines/flow/Flow;", "getMessagesPendingResult", "getReadCount", "getReadCountPendingResult", "getReadMessages", "getReadMessagesPendingResult", "getUnreadCount", "getUnreadCountPendingResult", "getUnreadMessages", "getUnreadMessagesFlow", "getUnreadMessagesPendingResult", "markMessagesRead", "markMessagesUnread", "notifyInboxUpdated", "notifyInboxUpdated$urbanairship_message_center_release", "performUpdate", "Lkotlin/Result;", "performUpdate-IoAF18A$urbanairship_message_center_release", "removeListener", "scheduleUpdate", "reason", "scheduleUpdateIfEnabled", "scheduleUpdateIfEnabled$urbanairship_message_center_release", "setEnabled", "setEnabled$urbanairship_message_center_release", "setupRefreshOnMessageExpiresJob", "setupRefreshOnMessageExpiresJob$urbanairship_message_center_release", "tearDown", "tearDown$urbanairship_message_center_release", "updateInbox", "FetchMessagesCallback", "PendingFetchMessagesCallback", "RefreshResult", "UpdateType", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInbox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 5 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 6 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,711:1\n1#2:712\n1#2:726\n1#2:744\n1#2:762\n766#3:713\n857#3,2:714\n1603#3,9:716\n1855#3:725\n1856#3:727\n1612#3:728\n1603#3,9:734\n1855#3:743\n1856#3:745\n1612#3:746\n1603#3,9:752\n1855#3:761\n1856#3:763\n1612#3:764\n49#4:729\n51#4:733\n49#4:747\n51#4:751\n46#5:730\n51#5:732\n46#5:748\n51#5:750\n105#6:731\n105#6:749\n*S KotlinDebug\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n*L\n397#1:726\n448#1:744\n500#1:762\n387#1:713\n387#1:714,2\n397#1:716,9\n397#1:725\n397#1:727\n397#1:728\n448#1:734,9\n448#1:743\n448#1:745\n448#1:746\n500#1:752,9\n500#1:761\n500#1:763\n500#1:764\n412#1:729\n412#1:733\n464#1:747\n464#1:751\n412#1:730\n412#1:732\n464#1:748\n464#1:750\n412#1:731\n464#1:749\n*E\n"})
/* loaded from: classes5.dex */
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;", "", "onFinished", "", "success", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface FetchMessagesCallback {
        void onFinished(boolean success);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$2, reason: invalid class name and case insensitive filesystem */
    static final class C11672 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11672(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.fetchMessages(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C11691 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11691(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessage(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessageByUrl$1, reason: invalid class name and case insensitive filesystem */
    static final class C11701 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11701(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessageByUrl(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessageIds$1, reason: invalid class name and case insensitive filesystem */
    static final class C11721 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11721(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessageIds(this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C11751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11751(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getMessages(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getReadMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C11791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Inbox.this.getReadMessages(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C11821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11821(Continuation continuation) {
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
    public static /* synthetic */ void getInboxJobHandler$urbanairship_message_center_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshResults$urbanairship_message_center_release$annotations() {
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass2(null), 3, null);
        airshipChannel.addChannelRegistrationPayloadExtender(suspending);
        activityMonitor.addApplicationListener(r1);
        config.addConfigListener(configChangeListener);
        setupRefreshOnMessageExpiresJob$urbanairship_message_center_release();
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
    /* renamed from: getInboxJobHandler$urbanairship_message_center_release, reason: from getter */
    public final InboxJobHandler getInboxJobHandler() {
        return this.inboxJobHandler;
    }

    public final void setInboxJobHandler$urbanairship_message_center_release(@NotNull InboxJobHandler inboxJobHandler) {
        Intrinsics.checkNotNullParameter(inboxJobHandler, "<set-?>");
        this.inboxJobHandler = inboxJobHandler;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/messagecenter/Inbox$RefreshResult;", "", "(Ljava/lang/String;I)V", "LOCAL", "REMOTE_SUCCESS", "REMOTE_FAILED", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RefreshResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RefreshResult[] $VALUES;
        public static final RefreshResult LOCAL = new RefreshResult("LOCAL", 0);
        public static final RefreshResult REMOTE_SUCCESS = new RefreshResult("REMOTE_SUCCESS", 1);
        public static final RefreshResult REMOTE_FAILED = new RefreshResult("REMOTE_FAILED", 2);

        private static final /* synthetic */ RefreshResult[] $values() {
            return new RefreshResult[]{LOCAL, REMOTE_SUCCESS, REMOTE_FAILED};
        }

        @NotNull
        public static EnumEntries<RefreshResult> getEntries() {
            return $ENTRIES;
        }

        public static RefreshResult valueOf(String str) {
            return (RefreshResult) Enum.valueOf(RefreshResult.class, str);
        }

        public static RefreshResult[] values() {
            return (RefreshResult[]) $VALUES.clone();
        }

        static {
            RefreshResult[] refreshResultArr$values = $values();
            $VALUES = refreshResultArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(refreshResultArr$values);
        }

        private RefreshResult(String str, int i) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/messagecenter/Inbox$UpdateType;", "", "(Ljava/lang/String;I)V", "REQUIRED", "BEST_ATTEMPT", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UpdateType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UpdateType[] $VALUES;
        public static final UpdateType REQUIRED = new UpdateType("REQUIRED", 0);
        public static final UpdateType BEST_ATTEMPT = new UpdateType("BEST_ATTEMPT", 1);

        private static final /* synthetic */ UpdateType[] $values() {
            return new UpdateType[]{REQUIRED, BEST_ATTEMPT};
        }

        @NotNull
        public static EnumEntries<UpdateType> getEntries() {
            return $ENTRIES;
        }

        public static UpdateType valueOf(String str) {
            return (UpdateType) Enum.valueOf(UpdateType.class, str);
        }

        public static UpdateType[] values() {
            return (UpdateType[]) $VALUES.clone();
        }

        static {
            UpdateType[] updateTypeArr$values = $values();
            $VALUES = updateTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(updateTypeArr$values);
        }

        private UpdateType(String str, int i) {
        }
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Inbox.kt\ncom/urbanairship/messagecenter/Inbox$1\n*L\n1#1,218:1\n18#2:219\n19#2:221\n138#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ String $id$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2", f = "Inbox.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$id$inlined = str;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L4a
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                r2 = r5
                                java.lang.String r2 = (java.lang.String) r2
                                java.lang.String r4 = r4.$id$inlined
                                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
                                if (r4 == 0) goto L4a
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r5, r0)
                                if (r4 != r1) goto L4a
                                return r1
                            L4a:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = channelIdFlow.collect(new AnonymousClass2(flowCollector, id), continuation);
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            inbox.setupRefreshOnMessageExpiresJob$urbanairship_message_center_release();
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: performUpdate-IoAF18A$urbanairship_message_center_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2906performUpdateIoAF18A$urbanairship_message_center_release(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.Boolean>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.urbanairship.messagecenter.Inbox$performUpdate$1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.messagecenter.Inbox$performUpdate$1 r0 = (com.urbanairship.messagecenter.Inbox$performUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$performUpdate$1 r0 = new com.urbanairship.messagecenter.Inbox$performUpdate$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L49
            if (r2 == r6) goto L45
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            goto L37
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            boolean r7 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lab
        L3d:
            java.lang.Object r7 = r0.L$0
            com.urbanairship.messagecenter.Inbox r7 = (com.urbanairship.messagecenter.Inbox) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7e
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L49:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.isEnabled
            boolean r8 = r8.get()
            if (r8 != 0) goto L73
            kotlinx.coroutines.flow.MutableSharedFlow r7 = r7.refreshResults
            com.urbanairship.messagecenter.Inbox$RefreshResult r8 = com.urbanairship.messagecenter.Inbox.RefreshResult.REMOTE_FAILED
            r0.label = r6
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L61
            return r1
        L61:
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Unable to update when disabled"
            r7.<init>(r8)
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m2968constructorimpl(r7)
            return r7
        L73:
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r7.updateInbox(r0)
            if (r8 != r1) goto L7e
            return r1
        L7e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2 = 0
            if (r8 == 0) goto L9a
            kotlinx.coroutines.flow.MutableSharedFlow r7 = r7.refreshResults
            com.urbanairship.messagecenter.Inbox$RefreshResult r3 = com.urbanairship.messagecenter.Inbox.RefreshResult.REMOTE_SUCCESS
            r0.L$0 = r2
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r7 = r7.emit(r3, r0)
            if (r7 != r1) goto L98
            return r1
        L98:
            r7 = r8
            goto Lab
        L9a:
            kotlinx.coroutines.flow.MutableSharedFlow r7 = r7.refreshResults
            com.urbanairship.messagecenter.Inbox$RefreshResult r4 = com.urbanairship.messagecenter.Inbox.RefreshResult.REMOTE_FAILED
            r0.L$0 = r2
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r7 = r7.emit(r4, r0)
            if (r7 != r1) goto L98
            return r1
        Lab:
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            java.lang.Object r7 = kotlin.Result.m2968constructorimpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.m2906performUpdateIoAF18A$urbanairship_message_center_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$updateInbox$2, reason: invalid class name and case insensitive filesystem */
    static final class C11892 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        C11892(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11892(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00a4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L45
                if (r1 == r5) goto L3d
                if (r1 == r4) goto L31
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lc8
            L1a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L22:
                boolean r1 = r8.Z$0
                java.lang.Object r3 = r8.L$1
                com.urbanairship.messagecenter.UserCredentials r3 = (com.urbanairship.messagecenter.UserCredentials) r3
                java.lang.Object r4 = r8.L$0
                java.lang.String r4 = (java.lang.String) r4
                kotlin.ResultKt.throwOnFailure(r9)
                goto La9
            L31:
                java.lang.Object r1 = r8.L$1
                com.urbanairship.messagecenter.UserCredentials r1 = (com.urbanairship.messagecenter.UserCredentials) r1
                java.lang.Object r4 = r8.L$0
                java.lang.String r4 = (java.lang.String) r4
                kotlin.ResultKt.throwOnFailure(r9)
                goto L8a
            L3d:
                java.lang.Object r1 = r8.L$0
                java.lang.String r1 = (java.lang.String) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L6a
            L45:
                kotlin.ResultKt.throwOnFailure(r9)
                com.urbanairship.messagecenter.Inbox r9 = com.urbanairship.messagecenter.Inbox.this
                com.urbanairship.channel.AirshipChannel r9 = com.urbanairship.messagecenter.Inbox.access$getAirshipChannel$p(r9)
                java.lang.String r1 = r9.getId()
                if (r1 != 0) goto L59
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                return r8
            L59:
                com.urbanairship.messagecenter.Inbox r9 = com.urbanairship.messagecenter.Inbox.this
                com.urbanairship.messagecenter.InboxJobHandler r9 = r9.getInboxJobHandler()
                r8.L$0 = r1
                r8.label = r5
                java.lang.Object r9 = r9.getOrCreateUserCredentials(r1, r8)
                if (r9 != r0) goto L6a
                return r0
            L6a:
                com.urbanairship.messagecenter.UserCredentials r9 = (com.urbanairship.messagecenter.UserCredentials) r9
                if (r9 != 0) goto L73
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                return r8
            L73:
                com.urbanairship.messagecenter.Inbox r5 = com.urbanairship.messagecenter.Inbox.this
                com.urbanairship.messagecenter.InboxJobHandler r5 = r5.getInboxJobHandler()
                r8.L$0 = r1
                r8.L$1 = r9
                r8.label = r4
                java.lang.Object r4 = r5.syncReadMessageState(r9, r1, r8)
                if (r4 != r0) goto L86
                return r0
            L86:
                r7 = r1
                r1 = r9
                r9 = r4
                r4 = r7
            L8a:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                com.urbanairship.messagecenter.Inbox r5 = com.urbanairship.messagecenter.Inbox.this
                com.urbanairship.messagecenter.InboxJobHandler r5 = r5.getInboxJobHandler()
                r8.L$0 = r4
                r8.L$1 = r1
                r8.Z$0 = r9
                r8.label = r3
                java.lang.Object r3 = r5.syncDeletedMessageState(r1, r4, r8)
                if (r3 != r0) goto La5
                return r0
            La5:
                r7 = r1
                r1 = r9
                r9 = r3
                r3 = r7
            La9:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r1 == 0) goto Lc9
                if (r9 != 0) goto Lb4
                goto Lc9
            Lb4:
                com.urbanairship.messagecenter.Inbox r9 = com.urbanairship.messagecenter.Inbox.this
                com.urbanairship.messagecenter.InboxJobHandler r9 = r9.getInboxJobHandler()
                r1 = 0
                r8.L$0 = r1
                r8.L$1 = r1
                r8.label = r2
                java.lang.Object r9 = r9.syncMessageList(r3, r4, r8)
                if (r9 != r0) goto Lc8
                return r0
            Lc8:
                return r9
            Lc9:
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.C11892.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateInbox(Continuation continuation) {
        return BuildersKt.withContext(this.refreshDispatcher, new C11892(null), continuation);
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
    public final void setupRefreshOnMessageExpiresJob$urbanairship_message_center_release() {
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C11661 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingFetchMessagesCallback $cancelableOperation;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11661(PendingFetchMessagesCallback pendingFetchMessagesCallback, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$cancelableOperation = pendingFetchMessagesCallback;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11661(this.$cancelableOperation, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11661(pendingFetchMessagesCallback, this, null), 3, null);
        return pendingFetchMessagesCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object fetchMessages(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.urbanairship.messagecenter.Inbox.C11672
            if (r0 == 0) goto L13
            r0 = r12
            com.urbanairship.messagecenter.Inbox$fetchMessages$2 r0 = (com.urbanairship.messagecenter.Inbox.C11672) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$fetchMessages$2 r0 = new com.urbanairship.messagecenter.Inbox$fetchMessages$2
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L66
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.concurrent.atomic.AtomicBoolean r12 = r11.isEnabled
            boolean r12 = r12.get()
            r2 = 0
            if (r12 != 0) goto L48
            com.urbanairship.messagecenter.Inbox$fetchMessages$3 r11 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.Inbox.fetchMessages.3
                static {
                    /*
                        com.urbanairship.messagecenter.Inbox$fetchMessages$3 r0 = new com.urbanairship.messagecenter.Inbox$fetchMessages$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.Inbox$fetchMessages$3) com.urbanairship.messagecenter.Inbox.fetchMessages.3.INSTANCE com.urbanairship.messagecenter.Inbox$fetchMessages$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.AnonymousClass3.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.AnonymousClass3.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.AnonymousClass3.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to resume fetchMessages, Message Center is disabled."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.AnonymousClass3.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e$default(r2, r11, r4, r2)
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r11
        L48:
            kotlinx.coroutines.CoroutineScope r5 = r11.scope
            com.urbanairship.messagecenter.Inbox$fetchMessages$4 r8 = new com.urbanairship.messagecenter.Inbox$fetchMessages$4
            r8.<init>(r2)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.flow.MutableSharedFlow r11 = r11.refreshResults
            com.urbanairship.messagecenter.Inbox$fetchMessages$5 r12 = new com.urbanairship.messagecenter.Inbox$fetchMessages$5
            r12.<init>(r2)
            r0.label = r4
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.first(r11, r12, r0)
            if (r12 != r1) goto L66
            return r1
        L66:
            com.urbanairship.messagecenter.Inbox$RefreshResult r11 = com.urbanairship.messagecenter.Inbox.RefreshResult.REMOTE_SUCCESS
            if (r12 != r11) goto L6b
            r3 = r4
        L6b:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.fetchMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$fetchMessages$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(RefreshResult refreshResult, Continuation continuation) {
            return ((AnonymousClass5) create(refreshResult, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$getCountPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11681 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11681(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11681(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11681(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object getMessageIds(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.messagecenter.Inbox.C11721
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.messagecenter.Inbox$getMessageIds$1 r0 = (com.urbanairship.messagecenter.Inbox.C11721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$getMessageIds$1 r0 = new com.urbanairship.messagecenter.Inbox$getMessageIds$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.urbanairship.messagecenter.MessageDao r4 = r4.messageDao
            r0.label = r3
            java.lang.Object r5 = r4.getMessageIds(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.getMessageIds(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessageIdsPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11731 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11731(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11731(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11731(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    public final /* synthetic */ Object getReadCount(Continuation continuation) {
        return this.messageDao.getReadMessageCount(continuation);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getReadCountPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11781 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11781(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11781(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11781(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    public final /* synthetic */ Object getUnreadCount(Continuation continuation) {
        return this.messageDao.getUnreadMessageCount(continuation);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getUnreadCountPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11811 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11811(PendingResult pendingResult, Inbox inbox, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11811(this.$result, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11811(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    public static /* synthetic */ Object getMessages$default(Inbox inbox, Predicate predicate, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getMessages(predicate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object getMessages(com.urbanairship.Predicate r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.Inbox.C11751
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.Inbox$getMessages$1 r0 = (com.urbanairship.messagecenter.Inbox.C11751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$getMessages$1 r0 = new com.urbanairship.messagecenter.Inbox$getMessages$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.urbanairship.Predicate r5 = (com.urbanairship.Predicate) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.messagecenter.Inbox r4 = (com.urbanairship.messagecenter.Inbox) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.messagecenter.MessageDao r6 = r4.messageDao
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getMessages(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6d
            java.lang.Object r1 = r6.next()
            com.urbanairship.messagecenter.MessageEntity r1 = (com.urbanairship.messagecenter.MessageEntity) r1
            com.urbanairship.messagecenter.Message r1 = r1.toMessage()
            if (r1 == 0) goto L57
            r0.add(r1)
            goto L57
        L6d:
            java.util.Collection r4 = r4.filterMessages(r0, r5)
            com.urbanairship.messagecenter.Message$Companion r5 = com.urbanairship.messagecenter.Message.INSTANCE
            java.util.Comparator r5 = r5.getSENT_DATE_COMPARATOR()
            java.util.List r4 = kotlin.collections.CollectionsKt.sortedWith(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.getMessages(com.urbanairship.Predicate, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessagesFlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C11761 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        C11761(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(List list, String str, Continuation continuation) {
            C11761 c11761 = new C11761(continuation);
            c11761.L$0 = list;
            return c11761.invokeSuspend(Unit.INSTANCE);
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
        final Flow flowCombine = FlowKt.combine(this.messageDao.getMessagesFlow(), this.expiryRefresh, new C11761(null));
        return FlowKt.distinctUntilChanged(new Flow<List<? extends Message>>() { // from class: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n50#2:219\n413#3:220\n414#3,3:234\n417#3:239\n1603#4,9:221\n1855#4:230\n1856#4:232\n1612#4:233\n766#4:237\n857#4:238\n858#4:240\n1#5:231\n*S KotlinDebug\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n*L\n413#1:221,9\n413#1:230\n413#1:232\n413#1:233\n416#1:237\n416#1:238\n416#1:240\n413#1:231\n*E\n"})
            /* renamed from: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Predicate $predicate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Inbox this$0;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2", f = "Inbox.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2$1, reason: invalid class name */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Inbox inbox, Predicate predicate) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = inbox;
                    this.$predicate$inlined = predicate;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2$1 r0 = (com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2$1 r0 = new com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L92
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Iterator r6 = r6.iterator()
                    L41:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L57
                        java.lang.Object r4 = r6.next()
                        com.urbanairship.messagecenter.MessageEntity r4 = (com.urbanairship.messagecenter.MessageEntity) r4
                        com.urbanairship.messagecenter.Message r4 = r4.toMessage()
                        if (r4 == 0) goto L41
                        r2.add(r4)
                        goto L41
                    L57:
                        com.urbanairship.messagecenter.Inbox r6 = r5.this$0
                        com.urbanairship.Predicate r5 = r5.$predicate$inlined
                        java.util.Collection r5 = com.urbanairship.messagecenter.Inbox.access$filterMessages(r6, r2, r5)
                        com.urbanairship.messagecenter.Message$Companion r6 = com.urbanairship.messagecenter.Message.INSTANCE
                        java.util.Comparator r6 = r6.getSENT_DATE_COMPARATOR()
                        java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r6)
                        java.util.ArrayList r6 = new java.util.ArrayList
                        r6.<init>()
                        java.util.Iterator r5 = r5.iterator()
                    L72:
                        boolean r2 = r5.hasNext()
                        if (r2 == 0) goto L89
                        java.lang.Object r2 = r5.next()
                        r4 = r2
                        com.urbanairship.messagecenter.Message r4 = (com.urbanairship.messagecenter.Message) r4
                        boolean r4 = r4.isExpired()
                        if (r4 != 0) goto L72
                        r6.add(r2)
                        goto L72
                    L89:
                        r0.label = r3
                        java.lang.Object r5 = r7.emit(r6, r0)
                        if (r5 != r1) goto L92
                        return r1
                    L92:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox$getMessagesFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends Message>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowCombine.collect(new AnonymousClass2(flowCollector, this, predicate), continuation);
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessagesPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11771 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11771(PendingResult pendingResult, Inbox inbox, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11771(this.$result, this.this$0, this.$predicate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11771(pendingResult, this, predicate, null), 3, null);
        return pendingResult;
    }

    public static /* synthetic */ Object getUnreadMessages$default(Inbox inbox, Predicate predicate, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getUnreadMessages(predicate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object getUnreadMessages(com.urbanairship.Predicate r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.Inbox.C11821
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.Inbox$getUnreadMessages$1 r0 = (com.urbanairship.messagecenter.Inbox.C11821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$getUnreadMessages$1 r0 = new com.urbanairship.messagecenter.Inbox$getUnreadMessages$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.urbanairship.Predicate r5 = (com.urbanairship.Predicate) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.messagecenter.Inbox r4 = (com.urbanairship.messagecenter.Inbox) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.messagecenter.MessageDao r6 = r4.messageDao
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getUnreadMessages(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6d
            java.lang.Object r1 = r6.next()
            com.urbanairship.messagecenter.MessageEntity r1 = (com.urbanairship.messagecenter.MessageEntity) r1
            com.urbanairship.messagecenter.Message r1 = r1.toMessage()
            if (r1 == 0) goto L57
            r0.add(r1)
            goto L57
        L6d:
            java.util.Collection r4 = r4.filterMessages(r0, r5)
            com.urbanairship.messagecenter.Message$Companion r5 = com.urbanairship.messagecenter.Message.INSTANCE
            java.util.Comparator r5 = r5.getSENT_DATE_COMPARATOR()
            java.util.List r4 = kotlin.collections.CollectionsKt.sortedWith(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.getUnreadMessages(com.urbanairship.Predicate, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C11831 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        C11831(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(List list, String str, Continuation continuation) {
            C11831 c11831 = new C11831(continuation);
            c11831.L$0 = list;
            return c11831.invokeSuspend(Unit.INSTANCE);
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
        final Flow flowCombine = FlowKt.combine(this.messageDao.getUnreadMessagesFlow(), this.expiryRefresh, new C11831(null));
        return FlowKt.distinctUntilChanged(new Flow<List<? extends Message>>() { // from class: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n50#2:219\n465#3:220\n466#3,3:234\n469#3:239\n1603#4,9:221\n1855#4:230\n1856#4:232\n1612#4:233\n766#4:237\n857#4:238\n858#4:240\n1#5:231\n*S KotlinDebug\n*F\n+ 1 Inbox.kt\ncom/urbanairship/messagecenter/Inbox\n*L\n465#1:221,9\n465#1:230\n465#1:232\n465#1:233\n468#1:237\n468#1:238\n468#1:240\n465#1:231\n*E\n"})
            /* renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Predicate $predicate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Inbox this$0;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2", f = "Inbox.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2$1, reason: invalid class name */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Inbox inbox, Predicate predicate) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = inbox;
                    this.$predicate$inlined = predicate;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2$1 r0 = (com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2$1 r0 = new com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L92
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Iterator r6 = r6.iterator()
                    L41:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L57
                        java.lang.Object r4 = r6.next()
                        com.urbanairship.messagecenter.MessageEntity r4 = (com.urbanairship.messagecenter.MessageEntity) r4
                        com.urbanairship.messagecenter.Message r4 = r4.toMessage()
                        if (r4 == 0) goto L41
                        r2.add(r4)
                        goto L41
                    L57:
                        com.urbanairship.messagecenter.Inbox r6 = r5.this$0
                        com.urbanairship.Predicate r5 = r5.$predicate$inlined
                        java.util.Collection r5 = com.urbanairship.messagecenter.Inbox.access$filterMessages(r6, r2, r5)
                        com.urbanairship.messagecenter.Message$Companion r6 = com.urbanairship.messagecenter.Message.INSTANCE
                        java.util.Comparator r6 = r6.getSENT_DATE_COMPARATOR()
                        java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r6)
                        java.util.ArrayList r6 = new java.util.ArrayList
                        r6.<init>()
                        java.util.Iterator r5 = r5.iterator()
                    L72:
                        boolean r2 = r5.hasNext()
                        if (r2 == 0) goto L89
                        java.lang.Object r2 = r5.next()
                        r4 = r2
                        com.urbanairship.messagecenter.Message r4 = (com.urbanairship.messagecenter.Message) r4
                        boolean r4 = r4.isExpired()
                        if (r4 != 0) goto L72
                        r6.add(r2)
                        goto L72
                    L89:
                        r0.label = r3
                        java.lang.Object r5 = r7.emit(r6, r0)
                        if (r5 != r1) goto L92
                        return r1
                    L92:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox$getUnreadMessagesFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends Message>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowCombine.collect(new AnonymousClass2(flowCollector, this, predicate), continuation);
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

    /* renamed from: com.urbanairship.messagecenter.Inbox$getUnreadMessagesPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11841 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11841(PendingResult pendingResult, Inbox inbox, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11841(this.$result, this.this$0, this.$predicate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11841(pendingResult, this, predicate, null), 3, null);
        return pendingResult;
    }

    public static /* synthetic */ Object getReadMessages$default(Inbox inbox, Predicate predicate, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getReadMessages(predicate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object getReadMessages(com.urbanairship.Predicate r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.Inbox.C11791
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.Inbox$getReadMessages$1 r0 = (com.urbanairship.messagecenter.Inbox.C11791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$getReadMessages$1 r0 = new com.urbanairship.messagecenter.Inbox$getReadMessages$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.urbanairship.Predicate r5 = (com.urbanairship.Predicate) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.messagecenter.Inbox r4 = (com.urbanairship.messagecenter.Inbox) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.messagecenter.MessageDao r6 = r4.messageDao
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getReadMessages(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6d
            java.lang.Object r1 = r6.next()
            com.urbanairship.messagecenter.MessageEntity r1 = (com.urbanairship.messagecenter.MessageEntity) r1
            com.urbanairship.messagecenter.Message r1 = r1.toMessage()
            if (r1 == 0) goto L57
            r0.add(r1)
            goto L57
        L6d:
            java.util.Collection r4 = r4.filterMessages(r0, r5)
            com.urbanairship.messagecenter.Message$Companion r5 = com.urbanairship.messagecenter.Message.INSTANCE
            java.util.Comparator r5 = r5.getSENT_DATE_COMPARATOR()
            java.util.List r4 = kotlin.collections.CollectionsKt.sortedWith(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.getReadMessages(com.urbanairship.Predicate, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingResult getReadMessagesPendingResult$default(Inbox inbox, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return inbox.getReadMessagesPendingResult(predicate);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getReadMessagesPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11801 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11801(PendingResult pendingResult, Inbox inbox, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11801(this.$result, this.this$0, this.$predicate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11801(pendingResult, this, predicate, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object getMessage(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.messagecenter.Inbox.C11691
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.messagecenter.Inbox$getMessage$1 r0 = (com.urbanairship.messagecenter.Inbox.C11691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$getMessage$1 r0 = new com.urbanairship.messagecenter.Inbox$getMessage$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L42
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 == 0) goto L4a
            com.urbanairship.messagecenter.MessageDao r5 = r5.messageDao
            r0.label = r4
            java.lang.Object r7 = r5.getMessage(r6, r0)
            if (r7 != r1) goto L42
            return r1
        L42:
            com.urbanairship.messagecenter.MessageEntity r7 = (com.urbanairship.messagecenter.MessageEntity) r7
            if (r7 == 0) goto L4a
            com.urbanairship.messagecenter.Message r3 = r7.toMessage()
        L4a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.getMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessagePendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11741 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $messageId;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11741(PendingResult pendingResult, Inbox inbox, String str, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11741(this.$result, this.this$0, this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11741(pendingResult, this, messageId, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object getMessageByUrl(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.messagecenter.Inbox.C11701
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.messagecenter.Inbox$getMessageByUrl$1 r0 = (com.urbanairship.messagecenter.Inbox.C11701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.Inbox$getMessageByUrl$1 r0 = new com.urbanairship.messagecenter.Inbox$getMessageByUrl$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L42
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 == 0) goto L4a
            com.urbanairship.messagecenter.MessageDao r5 = r5.messageDao
            r0.label = r4
            java.lang.Object r7 = r5.getMessageByUrl(r6, r0)
            if (r7 != r1) goto L42
            return r1
        L42:
            com.urbanairship.messagecenter.MessageEntity r7 = (com.urbanairship.messagecenter.MessageEntity) r7
            if (r7 == 0) goto L4a
            com.urbanairship.messagecenter.Message r3 = r7.toMessage()
        L4a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox.getMessageByUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$getMessageByUrlPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11711 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $messageUrl;
        final /* synthetic */ PendingResult $result;
        Object L$0;
        int label;
        final /* synthetic */ Inbox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11711(PendingResult pendingResult, Inbox inbox, String str, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = inbox;
            this.$messageUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11711(this.$result, this.this$0, this.$messageUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11711(pendingResult, this, messageUrl, null), 3, null);
        return pendingResult;
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$markMessagesRead$1, reason: invalid class name and case insensitive filesystem */
    static final class C11851 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11851(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11851(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11851(messageIds, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$markMessagesRead$2, reason: invalid class name and case insensitive filesystem */
    static final class C11862 extends SuspendLambda implements Function2 {
        final /* synthetic */ String[] $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11862(String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11862(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11862(messageIds, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$markMessagesUnread$1, reason: invalid class name and case insensitive filesystem */
    static final class C11871 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11871(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11871(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11871(messageIds, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$markMessagesUnread$2, reason: invalid class name and case insensitive filesystem */
    static final class C11882 extends SuspendLambda implements Function2 {
        final /* synthetic */ String[] $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11882(String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11882(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11882(messageIds, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$deleteMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C11641 extends SuspendLambda implements Function2 {
        final /* synthetic */ Set $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11641(Set set, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11641(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11641(messageIds, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$deleteMessages$2, reason: invalid class name and case insensitive filesystem */
    static final class C11652 extends SuspendLambda implements Function2 {
        final /* synthetic */ String[] $messageIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11652(String[] strArr, Continuation continuation) {
            super(2, continuation);
            this.$messageIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11652(this.$messageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11652) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11652(messageIds, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$deleteAllMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C11621 extends SuspendLambda implements Function2 {
        int label;

        C11621(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11621(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11621(null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.Inbox$deleteAllMessagesInternal$1, reason: invalid class name and case insensitive filesystem */
    static final class C11631 extends SuspendLambda implements Function2 {
        int label;

        C11631(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Inbox.this.new C11631(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11631(null), 3, null);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/messagecenter/Inbox$PendingFetchMessagesCallback;", "Lcom/urbanairship/CancelableOperation;", "callback", "Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;", "looper", "Landroid/os/Looper;", "(Lcom/urbanairship/messagecenter/Inbox$FetchMessagesCallback;Landroid/os/Looper;)V", "result", "", "getResult", "()Z", "setResult", "(Z)V", "onRun", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
