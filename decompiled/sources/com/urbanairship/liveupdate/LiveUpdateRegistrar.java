package com.urbanairship.liveupdate;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import ch.qos.logback.core.joran.action.Action;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.LiveUpdateMutation;
import com.urbanairship.json.JsonMap;
import com.urbanairship.liveupdate.CallbackLiveUpdateCustomHandler;
import com.urbanairship.liveupdate.CallbackLiveUpdateNotificationHandler;
import com.urbanairship.liveupdate.LiveUpdateProcessor;
import com.urbanairship.liveupdate.LiveUpdateResult;
import com.urbanairship.liveupdate.data.LiveUpdateContent;
import com.urbanairship.liveupdate.data.LiveUpdateDao;
import com.urbanairship.liveupdate.data.LiveUpdateState;
import com.urbanairship.liveupdate.data.LiveUpdateStateWithContent;
import com.urbanairship.liveupdate.notification.LiveUpdateNotificationReceiver;
import com.urbanairship.liveupdate.notification.LiveUpdatePayload;
import com.urbanairship.liveupdate.notification.NotificationTimeoutCompat;
import com.urbanairship.push.NotificationProxyActivity;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.Clock;
import com.urbanairship.util.PendingIntentCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0086@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,J8\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\n\u00101\u001a\u0006\u0012\u0002\b\u0003022\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0016\u00107\u001a\u00020\u001e2\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u000209J6\u0010:\u001a\u0004\u0018\u00010.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00104\u001a\u00020'2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0016\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0014JA\u0010A\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00132\u0006\u0010B\u001a\u00020C2\u0006\u0010 \u001a\u00020!2\b\u0010D\u001a\u0004\u0018\u00010!2\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010EJ;\u0010F\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010 \u001a\u00020!2\b\u0010D\u001a\u0004\u0018\u00010!2\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u00020\u001eJ9\u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010B\u001a\u00020C2\u0006\u0010 \u001a\u00020!2\b\u0010D\u001a\u0004\u0018\u00010!2\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010GR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateRegistrar;", "", "context", "Landroid/content/Context;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "dao", "Lcom/urbanairship/liveupdate/data/LiveUpdateDao;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "processor", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", "notificationTimeoutCompat", "Lcom/urbanairship/liveupdate/notification/NotificationTimeoutCompat;", "(Landroid/content/Context;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/liveupdate/data/LiveUpdateDao;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/urbanairship/liveupdate/LiveUpdateProcessor;Landroidx/core/app/NotificationManagerCompat;Lcom/urbanairship/liveupdate/notification/NotificationTimeoutCompat;)V", "handlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/urbanairship/liveupdate/LiveUpdateHandler;", "getHandlers$urbanairship_live_update_release$annotations", "()V", "getHandlers$urbanairship_live_update_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "job", "Lkotlinx/coroutines/CompletableJob;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "cancel", "", "name", "timestamp", "", "cancelNotification", "tag", "clearAll", "getAllActiveUpdates", "", "Lcom/urbanairship/liveupdate/LiveUpdate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleCallback", "callback", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$HandlerCallback;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$HandlerCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResult", "Lcom/urbanairship/liveupdate/CallbackLiveUpdateNotificationHandler$NotificationResult;", "action", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "result", "Lcom/urbanairship/liveupdate/LiveUpdateResult;", "handler", "update", "message", "Lcom/urbanairship/push/PushMessage;", "onLiveUpdatePushReceived", "payload", "Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", "postNotification", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "extender", "Lcom/urbanairship/liveupdate/LiveUpdateResult$NotificationExtender;", "register", "type", ViewProps.START, "content", "Lcom/urbanairship/json/JsonMap;", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "stop", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "stopLiveUpdatesForClearedNotifications", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdateRegistrar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateRegistrar.kt\ncom/urbanairship/liveupdate/LiveUpdateRegistrar\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1603#2,9:336\n1855#2:345\n1856#2:348\n1612#2:349\n1#3:346\n1#3:347\n*S KotlinDebug\n*F\n+ 1 LiveUpdateRegistrar.kt\ncom/urbanairship/liveupdate/LiveUpdateRegistrar\n*L\n158#1:336,9\n158#1:345\n158#1:348\n158#1:349\n158#1:347\n*E\n"})
/* loaded from: classes5.dex */
public final class LiveUpdateRegistrar {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int NOTIFICATION_ID = 1010;
    private final AirshipChannel channel;
    private final Context context;
    private final LiveUpdateDao dao;
    private final ConcurrentHashMap handlers;
    private final CompletableJob job;
    private final NotificationManagerCompat notificationManager;
    private final NotificationTimeoutCompat notificationTimeoutCompat;
    private final LiveUpdateProcessor processor;
    private final CoroutineScope scope;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LiveUpdateEvent.values().length];
            try {
                iArr[LiveUpdateEvent.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveUpdateEvent.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveUpdateEvent.UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$getAllActiveUpdates$1, reason: invalid class name and case insensitive filesystem */
    static final class C11561 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11561(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateRegistrar.this.getAllActiveUpdates(this);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getHandlers$urbanairship_live_update_release$annotations() {
    }

    public LiveUpdateRegistrar(@NotNull Context context, @NotNull AirshipChannel channel, @NotNull LiveUpdateDao dao, @NotNull CoroutineDispatcher dispatcher, @NotNull LiveUpdateProcessor processor, @NotNull NotificationManagerCompat notificationManager, @NotNull NotificationTimeoutCompat notificationTimeoutCompat) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(notificationTimeoutCompat, "notificationTimeoutCompat");
        this.context = context;
        this.channel = channel;
        this.dao = dao;
        this.processor = processor;
        this.notificationManager = notificationManager;
        this.notificationTimeoutCompat = notificationTimeoutCompat;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(completableJobSupervisorJob$default));
        this.scope = CoroutineScope;
        this.handlers = new ConcurrentHashMap();
        FlowKt.launchIn(FlowKt.onEach(processor.getHandlerCallbacks(), new AnonymousClass1(null)), CoroutineScope);
        FlowKt.launchIn(FlowKt.onEach(processor.getNotificationCancels(), new AnonymousClass2(null)), CoroutineScope);
        FlowKt.launchIn(FlowKt.onEach(processor.getChannelUpdates(), new AnonymousClass3(null)), CoroutineScope);
    }

    public /* synthetic */ LiveUpdateRegistrar(Context context, AirshipChannel airshipChannel, LiveUpdateDao liveUpdateDao, CoroutineDispatcher coroutineDispatcher, LiveUpdateProcessor liveUpdateProcessor, NotificationManagerCompat notificationManagerCompat, NotificationTimeoutCompat notificationTimeoutCompat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        NotificationManagerCompat notificationManagerCompat2;
        NotificationTimeoutCompat notificationTimeoutCompat2;
        CoroutineDispatcher io2 = (i & 8) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher;
        int i2 = 2;
        Clock clock = null;
        byte b = 0;
        LiveUpdateProcessor liveUpdateProcessor2 = (i & 16) != 0 ? new LiveUpdateProcessor(liveUpdateDao, null, 2, null) : liveUpdateProcessor;
        if ((i & 32) != 0) {
            NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
            Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
            notificationManagerCompat2 = notificationManagerCompatFrom;
        } else {
            notificationManagerCompat2 = notificationManagerCompat;
        }
        if ((i & 64) != 0) {
            notificationTimeoutCompat2 = new NotificationTimeoutCompat(context, clock, i2, b == true ? 1 : 0);
        } else {
            notificationTimeoutCompat2 = notificationTimeoutCompat;
        }
        this(context, airshipChannel, liveUpdateDao, io2, liveUpdateProcessor2, notificationManagerCompat2, notificationTimeoutCompat2);
    }

    @NotNull
    public final ConcurrentHashMap<String, LiveUpdateHandler> getHandlers$urbanairship_live_update_release() {
        return this.handlers;
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = LiveUpdateRegistrar.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LiveUpdateProcessor.HandlerCallback handlerCallback, Continuation continuation) {
            return ((AnonymousClass1) create(handlerCallback, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LiveUpdateProcessor.HandlerCallback handlerCallback = (LiveUpdateProcessor.HandlerCallback) this.L$0;
                LiveUpdateRegistrar liveUpdateRegistrar = LiveUpdateRegistrar.this;
                this.label = 1;
                if (liveUpdateRegistrar.handleCallback(handlerCallback, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = LiveUpdateRegistrar.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LiveUpdateProcessor.NotificationCancel notificationCancel, Continuation continuation) {
            return ((AnonymousClass2) create(notificationCancel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LiveUpdateRegistrar.this.cancelNotification(LiveUpdateRegistrarKt.getNotificationTag((LiveUpdateProcessor.NotificationCancel) this.L$0));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = LiveUpdateRegistrar.this.new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LiveUpdateMutation liveUpdateMutation, Continuation continuation) {
            return ((AnonymousClass3) create(liveUpdateMutation, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LiveUpdateRegistrar.this.channel.trackLiveUpdateMutation((LiveUpdateMutation) this.L$0);
            return Unit.INSTANCE;
        }
    }

    public final void register(@NotNull String type, @NotNull LiveUpdateHandler handler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlers.put(type, handler);
    }

    public final void start(@NotNull String name, @NotNull String type, @NotNull JsonMap content, long timestamp, @Nullable Long dismissalTimestamp, @Nullable PushMessage message) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        if (((LiveUpdateHandler) this.handlers.get(type)) == null) {
            UALog.e("Can't start Live Update '" + name + "'. No handler registered for type '" + type + "'!", new Object[0]);
            return;
        }
        this.processor.enqueue$urbanairship_live_update_release(new LiveUpdateProcessor.Operation.Start(name, type, content, timestamp, dismissalTimestamp, message));
    }

    public static /* synthetic */ void update$default(LiveUpdateRegistrar liveUpdateRegistrar, String str, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, Object obj) {
        if ((i & 16) != 0) {
            pushMessage = null;
        }
        liveUpdateRegistrar.update(str, jsonMap, j, l, pushMessage);
    }

    public final void update(@NotNull String name, @NotNull JsonMap content, long timestamp, @Nullable Long dismissalTimestamp, @Nullable PushMessage message) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        this.processor.enqueue$urbanairship_live_update_release(new LiveUpdateProcessor.Operation.Update(name, content, timestamp, dismissalTimestamp, message));
    }

    public static /* synthetic */ void stop$default(LiveUpdateRegistrar liveUpdateRegistrar, String str, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, Object obj) {
        if ((i & 16) != 0) {
            pushMessage = null;
        }
        liveUpdateRegistrar.stop(str, jsonMap, j, l, pushMessage);
    }

    public final void stop(@NotNull String name, @Nullable JsonMap content, long timestamp, @Nullable Long dismissalTimestamp, @Nullable PushMessage message) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.processor.enqueue$urbanairship_live_update_release(new LiveUpdateProcessor.Operation.Stop(name, content, timestamp, dismissalTimestamp, message));
    }

    public static /* synthetic */ void cancel$default(LiveUpdateRegistrar liveUpdateRegistrar, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        liveUpdateRegistrar.cancel(str, j);
    }

    public final void cancel(@NotNull String name, long timestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.processor.enqueue$urbanairship_live_update_release(new LiveUpdateProcessor.Operation.Cancel(name, timestamp));
    }

    public static /* synthetic */ void clearAll$default(LiveUpdateRegistrar liveUpdateRegistrar, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        liveUpdateRegistrar.clearAll(j);
    }

    public final void clearAll(long timestamp) {
        this.processor.enqueue$urbanairship_live_update_release(new LiveUpdateProcessor.Operation.ClearAll(timestamp));
    }

    public final void onLiveUpdatePushReceived(@NotNull PushMessage message, @NotNull LiveUpdatePayload payload) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(payload, "payload");
        int i = WhenMappings.$EnumSwitchMapping$0[payload.getEvent().ordinal()];
        if (i != 1) {
            if (i == 2) {
                stop(payload.getName(), payload.getContent(), payload.getTimestamp(), payload.getDismissalDate(), message);
                return;
            } else {
                if (i != 3) {
                    return;
                }
                update(payload.getName(), payload.getContent(), payload.getTimestamp(), payload.getDismissalDate(), message);
                return;
            }
        }
        if (payload.getType() != null) {
            start(payload.getName(), payload.getType(), payload.getContent(), payload.getTimestamp(), payload.getDismissalDate(), message);
            return;
        }
        UALog.w("Unable to start Live Update: " + payload.getName() + ". Missing required type!", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAllActiveUpdates(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.liveupdate.LiveUpdate>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.liveupdate.LiveUpdateRegistrar.C11561
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.liveupdate.LiveUpdateRegistrar$getAllActiveUpdates$1 r0 = (com.urbanairship.liveupdate.LiveUpdateRegistrar.C11561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.LiveUpdateRegistrar$getAllActiveUpdates$1 r0 = new com.urbanairship.liveupdate.LiveUpdateRegistrar$getAllActiveUpdates$1
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
            com.urbanairship.liveupdate.data.LiveUpdateDao r4 = r4.dao
            r0.label = r3
            java.lang.Object r5 = r4.getAllActive(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r5 = r5.iterator()
        L4a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L6e
            java.lang.Object r0 = r5.next()
            com.urbanairship.liveupdate.data.LiveUpdateStateWithContent r0 = (com.urbanairship.liveupdate.data.LiveUpdateStateWithContent) r0
            com.urbanairship.liveupdate.data.LiveUpdateState r1 = r0.getState()
            com.urbanairship.liveupdate.data.LiveUpdateContent r0 = r0.getContent()
            if (r0 == 0) goto L67
            com.urbanairship.liveupdate.LiveUpdate$Companion r2 = com.urbanairship.liveupdate.LiveUpdate.INSTANCE
            com.urbanairship.liveupdate.LiveUpdate r0 = r2.from$urbanairship_live_update_release(r1, r0)
            goto L68
        L67:
            r0 = 0
        L68:
            if (r0 == 0) goto L4a
            r4.add(r0)
            goto L4a
        L6e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateRegistrar.getAllActiveUpdates(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$stopLiveUpdatesForClearedNotifications$1, reason: invalid class name and case insensitive filesystem */
    static final class C11591 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C11591(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LiveUpdateRegistrar.this.new C11591(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object systemService = LiveUpdateRegistrar.this.context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
                Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
                ArrayList arrayList = new ArrayList(activeNotifications.length);
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    arrayList.add(statusBarNotification.getTag());
                }
                LiveUpdateDao liveUpdateDao = LiveUpdateRegistrar.this.dao;
                this.L$0 = arrayList;
                this.label = 1;
                obj = liveUpdateDao.getAllActive(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = arrayList;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            LiveUpdateRegistrar liveUpdateRegistrar = LiveUpdateRegistrar.this;
            ArrayList<LiveUpdateStateWithContent> arrayList2 = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                LiveUpdateState state = ((LiveUpdateStateWithContent) obj2).getState();
                if ((liveUpdateRegistrar.getHandlers$urbanairship_live_update_release().get(state.getType()) instanceof NotificationLiveUpdateHandler) && !list.contains(LiveUpdateRegistrarKt.notificationTag(state.getType(), state.getName()))) {
                    arrayList2.add(obj2);
                }
            }
            LiveUpdateRegistrar liveUpdateRegistrar2 = LiveUpdateRegistrar.this;
            for (LiveUpdateStateWithContent liveUpdateStateWithContent : arrayList2) {
                LiveUpdateState state2 = liveUpdateStateWithContent.getState();
                LiveUpdateContent content = liveUpdateStateWithContent.getContent();
                LiveUpdateRegistrar.stop$default(liveUpdateRegistrar2, state2.getName(), content != null ? content.getContent() : null, state2.getTimestamp(), state2.getDismissalDate(), null, 16, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void stopLiveUpdatesForClearedNotifications() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11591(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleCallback(LiveUpdateProcessor.HandlerCallback handlerCallback, Continuation continuation) {
        LiveUpdateEvent action = handlerCallback.getAction();
        LiveUpdate update = handlerCallback.getUpdate();
        PushMessage message = handlerCallback.getMessage();
        String type = update.getType();
        LiveUpdateHandler liveUpdateHandler = (LiveUpdateHandler) this.handlers.get(type);
        if (liveUpdateHandler == null) {
            UALog.e("No handler was registered to handle events for Live Update type: " + type + '!', new Object[0]);
            return Unit.INSTANCE;
        }
        if (liveUpdateHandler instanceof SuspendLiveUpdateNotificationHandler) {
            Object objWithContext = BuildersKt.withContext(Dispatchers.getDefault(), new C11572(liveUpdateHandler, this, action, update, message, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
        }
        if (liveUpdateHandler instanceof CallbackLiveUpdateNotificationHandler) {
            Object objWithContext2 = BuildersKt.withContext(Dispatchers.getDefault(), new C11583(liveUpdateHandler, this, action, update, message, null), continuation);
            return objWithContext2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext2 : Unit.INSTANCE;
        }
        if (liveUpdateHandler instanceof CallbackLiveUpdateCustomHandler) {
            Object objWithContext3 = BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass4(liveUpdateHandler, this, action, update, message, null), continuation);
            return objWithContext3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext3 : Unit.INSTANCE;
        }
        if (!(liveUpdateHandler instanceof SuspendLiveUpdateCustomHandler)) {
            return Unit.INSTANCE;
        }
        Object objWithContext4 = BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass5(liveUpdateHandler, this, action, update, message, null), continuation);
        return objWithContext4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext4 : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$handleCallback$2, reason: invalid class name and case insensitive filesystem */
    static final class C11572 extends SuspendLambda implements Function2 {
        final /* synthetic */ LiveUpdateEvent $action;
        final /* synthetic */ LiveUpdateHandler $handler;
        final /* synthetic */ PushMessage $message;
        final /* synthetic */ LiveUpdate $update;
        int label;
        final /* synthetic */ LiveUpdateRegistrar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11572(LiveUpdateHandler liveUpdateHandler, LiveUpdateRegistrar liveUpdateRegistrar, LiveUpdateEvent liveUpdateEvent, LiveUpdate liveUpdate, PushMessage pushMessage, Continuation continuation) {
            super(2, continuation);
            this.$handler = liveUpdateHandler;
            this.this$0 = liveUpdateRegistrar;
            this.$action = liveUpdateEvent;
            this.$update = liveUpdate;
            this.$message = pushMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11572(this.$handler, this.this$0, this.$action, this.$update, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SuspendLiveUpdateNotificationHandler suspendLiveUpdateNotificationHandler = (SuspendLiveUpdateNotificationHandler) this.$handler;
                Context context = this.this$0.context;
                LiveUpdateEvent liveUpdateEvent = this.$action;
                LiveUpdate liveUpdate = this.$update;
                this.label = 1;
                obj = suspendLiveUpdateNotificationHandler.onUpdate(context, liveUpdateEvent, liveUpdate, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return this.this$0.handleResult(this.$action, (LiveUpdateResult) obj, this.$handler, this.$update, this.$message);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$handleCallback$3, reason: invalid class name and case insensitive filesystem */
    static final class C11583 extends SuspendLambda implements Function2 {
        final /* synthetic */ LiveUpdateEvent $action;
        final /* synthetic */ LiveUpdateHandler $handler;
        final /* synthetic */ PushMessage $message;
        final /* synthetic */ LiveUpdate $update;
        int label;
        final /* synthetic */ LiveUpdateRegistrar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11583(LiveUpdateHandler liveUpdateHandler, LiveUpdateRegistrar liveUpdateRegistrar, LiveUpdateEvent liveUpdateEvent, LiveUpdate liveUpdate, PushMessage pushMessage, Continuation continuation) {
            super(2, continuation);
            this.$handler = liveUpdateHandler;
            this.this$0 = liveUpdateRegistrar;
            this.$action = liveUpdateEvent;
            this.$update = liveUpdate;
            this.$message = pushMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11583(this.$handler, this.this$0, this.$action, this.$update, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11583) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CallbackLiveUpdateNotificationHandler callbackLiveUpdateNotificationHandler = (CallbackLiveUpdateNotificationHandler) this.$handler;
            Context context = this.this$0.context;
            final LiveUpdateEvent liveUpdateEvent = this.$action;
            final LiveUpdate liveUpdate = this.$update;
            final LiveUpdateRegistrar liveUpdateRegistrar = this.this$0;
            final LiveUpdateHandler liveUpdateHandler = this.$handler;
            final PushMessage pushMessage = this.$message;
            callbackLiveUpdateNotificationHandler.onUpdate(context, liveUpdateEvent, liveUpdate, new CallbackLiveUpdateNotificationHandler.LiveUpdateResultCallback() { // from class: com.urbanairship.liveupdate.LiveUpdateRegistrar.handleCallback.3.1
                @Override // com.urbanairship.liveupdate.CallbackLiveUpdateNotificationHandler.LiveUpdateResultCallback
                @Nullable
                public CallbackLiveUpdateNotificationHandler.NotificationResult ok(@NotNull NotificationCompat.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return liveUpdateRegistrar.handleResult(liveUpdateEvent, LiveUpdateResult.INSTANCE.ok(builder), liveUpdateHandler, liveUpdate, pushMessage);
                }

                @Override // com.urbanairship.liveupdate.CallbackLiveUpdateNotificationHandler.LiveUpdateResultCallback
                public void cancel() {
                    liveUpdateRegistrar.handleResult(liveUpdateEvent, LiveUpdateResult.INSTANCE.cancel(), liveUpdateHandler, liveUpdate, pushMessage);
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$handleCallback$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        final /* synthetic */ LiveUpdateEvent $action;
        final /* synthetic */ LiveUpdateHandler $handler;
        final /* synthetic */ PushMessage $message;
        final /* synthetic */ LiveUpdate $update;
        int label;
        final /* synthetic */ LiveUpdateRegistrar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(LiveUpdateHandler liveUpdateHandler, LiveUpdateRegistrar liveUpdateRegistrar, LiveUpdateEvent liveUpdateEvent, LiveUpdate liveUpdate, PushMessage pushMessage, Continuation continuation) {
            super(2, continuation);
            this.$handler = liveUpdateHandler;
            this.this$0 = liveUpdateRegistrar;
            this.$action = liveUpdateEvent;
            this.$update = liveUpdate;
            this.$message = pushMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass4(this.$handler, this.this$0, this.$action, this.$update, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CallbackLiveUpdateCustomHandler callbackLiveUpdateCustomHandler = (CallbackLiveUpdateCustomHandler) this.$handler;
            Context context = this.this$0.context;
            final LiveUpdateEvent liveUpdateEvent = this.$action;
            final LiveUpdate liveUpdate = this.$update;
            final LiveUpdateRegistrar liveUpdateRegistrar = this.this$0;
            final LiveUpdateHandler liveUpdateHandler = this.$handler;
            final PushMessage pushMessage = this.$message;
            callbackLiveUpdateCustomHandler.onUpdate(context, liveUpdateEvent, liveUpdate, new CallbackLiveUpdateCustomHandler.LiveUpdateResultCallback() { // from class: com.urbanairship.liveupdate.LiveUpdateRegistrar.handleCallback.4.1
                @Override // com.urbanairship.liveupdate.CallbackLiveUpdateCustomHandler.LiveUpdateResultCallback
                public void ok() {
                    liveUpdateRegistrar.handleResult(liveUpdateEvent, LiveUpdateResult.Companion.ok$default(LiveUpdateResult.INSTANCE, null, 1, null), liveUpdateHandler, liveUpdate, pushMessage);
                }

                @Override // com.urbanairship.liveupdate.CallbackLiveUpdateCustomHandler.LiveUpdateResultCallback
                public void cancel() {
                    liveUpdateRegistrar.handleResult(liveUpdateEvent, LiveUpdateResult.INSTANCE.cancel(), liveUpdateHandler, liveUpdate, pushMessage);
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateRegistrar$handleCallback$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2 {
        final /* synthetic */ LiveUpdateEvent $action;
        final /* synthetic */ LiveUpdateHandler $handler;
        final /* synthetic */ PushMessage $message;
        final /* synthetic */ LiveUpdate $update;
        int label;
        final /* synthetic */ LiveUpdateRegistrar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(LiveUpdateHandler liveUpdateHandler, LiveUpdateRegistrar liveUpdateRegistrar, LiveUpdateEvent liveUpdateEvent, LiveUpdate liveUpdate, PushMessage pushMessage, Continuation continuation) {
            super(2, continuation);
            this.$handler = liveUpdateHandler;
            this.this$0 = liveUpdateRegistrar;
            this.$action = liveUpdateEvent;
            this.$update = liveUpdate;
            this.$message = pushMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass5(this.$handler, this.this$0, this.$action, this.$update, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SuspendLiveUpdateCustomHandler suspendLiveUpdateCustomHandler = (SuspendLiveUpdateCustomHandler) this.$handler;
                Context context = this.this$0.context;
                LiveUpdateEvent liveUpdateEvent = this.$action;
                LiveUpdate liveUpdate = this.$update;
                this.label = 1;
                obj = suspendLiveUpdateCustomHandler.onUpdate(context, liveUpdateEvent, liveUpdate, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return this.this$0.handleResult(this.$action, (LiveUpdateResult) obj, this.$handler, this.$update, this.$message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallbackLiveUpdateNotificationHandler.NotificationResult handleResult(LiveUpdateEvent action, LiveUpdateResult result, LiveUpdateHandler handler, LiveUpdate update, PushMessage message) {
        if (handler instanceof NotificationLiveUpdateHandler) {
            if (result instanceof LiveUpdateResult.Ok) {
                LiveUpdateResult.Ok ok = (LiveUpdateResult.Ok) result;
                if (ok.getValue() instanceof NotificationCompat.Builder) {
                    return postNotification(this.context, update, (NotificationCompat.Builder) ok.getValue(), ok.getExtender(), message);
                }
                return null;
            }
            if (!(result instanceof LiveUpdateResult.Cancel)) {
                return null;
            }
            stop(update.getName(), update.getContent(), System.currentTimeMillis(), null, message);
            cancelNotification(LiveUpdateRegistrarKt.getNotificationTag(update));
            return null;
        }
        if (!(handler instanceof CustomLiveUpdateHandler) || (result instanceof LiveUpdateResult.Ok) || !(result instanceof LiveUpdateResult.Cancel)) {
            return null;
        }
        stop(update.getName(), update.getContent(), System.currentTimeMillis(), null, null);
        return null;
    }

    private final CallbackLiveUpdateNotificationHandler.NotificationResult postNotification(Context context, LiveUpdate update, NotificationCompat.Builder builder, LiveUpdateResult.NotificationExtender extender, PushMessage message) {
        Unit unit;
        Long dismissalTime = update.getDismissalTime();
        if (dismissalTime != null) {
            this.notificationTimeoutCompat.setTimeoutAt$urbanairship_live_update_release(builder, dismissalTime.longValue(), update.getName());
        }
        Notification notificationBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        if (message != null) {
            Intent intentPutExtra = new Intent(context, (Class<?>) NotificationProxyActivity.class).setAction(PushManager.ACTION_NOTIFICATION_RESPONSE).addCategory(UUID.randomUUID().toString()).putExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE, message.getPushBundle()).addFlags(268435456).putExtra(PushManager.EXTRA_NOTIFICATION_ID, 1010).putExtra(PushManager.EXTRA_NOTIFICATION_TAG, LiveUpdateRegistrarKt.getNotificationTag(update));
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            PendingIntent pendingIntent = notificationBuild.contentIntent;
            if (pendingIntent != null) {
                intentPutExtra.putExtra(PushManager.EXTRA_NOTIFICATION_CONTENT_INTENT, pendingIntent);
            }
            notificationBuild.contentIntent = PendingIntentCompat.getActivity(context, 0, intentPutExtra, 0);
        }
        Intent intentDeleteIntent$urbanairship_live_update_release = LiveUpdateNotificationReceiver.INSTANCE.deleteIntent$urbanairship_live_update_release(context, update.getName());
        PendingIntent pendingIntent2 = notificationBuild.deleteIntent;
        if (pendingIntent2 != null) {
            intentDeleteIntent$urbanairship_live_update_release.putExtra(PushManager.EXTRA_NOTIFICATION_DELETE_INTENT, pendingIntent2);
        }
        notificationBuild.deleteIntent = PendingIntentCompat.getBroadcast(context, 0, intentDeleteIntent$urbanairship_live_update_release, 0);
        UALog.d("Posting live update notification for: " + update.getName(), new Object[0]);
        try {
            String notificationTag = LiveUpdateRegistrarKt.getNotificationTag(update);
            if (extender != null) {
                extender.extend(notificationBuild, 1010, notificationTag);
                Unit unit2 = Unit.INSTANCE;
                this.notificationManager.notify(notificationTag, 1010, notificationBuild);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.notificationManager.notify(notificationTag, 1010, notificationBuild);
            }
            return new CallbackLiveUpdateNotificationHandler.NotificationResult(notificationTag, 1010, notificationBuild);
        } catch (Exception e) {
            UALog.e(e, "Failed to post live update notification for: " + update.getName(), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelNotification(String tag) {
        this.notificationManager.cancel(tag, 1010);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateRegistrar$Companion;", "", "()V", "NOTIFICATION_ID", "", "getNOTIFICATION_ID$urbanairship_live_update_release$annotations", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getNOTIFICATION_ID$urbanairship_live_update_release$annotations() {
        }

        private Companion() {
        }
    }
}
