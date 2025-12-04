package com.urbanairship.messagecenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import ch.qos.logback.core.joran.action.Action;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.Predicate;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.messagecenter.ui.MessageCenterActivity;
import com.urbanairship.push.PushListener;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 A2\u00020\u0001:\u0002ABB7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB7\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010)\u001a\u00020*H\u0017J\b\u0010+\u001a\u00020,H\u0015J\r\u0010-\u001a\u00020,H\u0001¢\u0006\u0002\b.J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0017J\u0010\u00109\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u00010\u0019J\u0014\u0010;\u001a\u00020,2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0007J\b\u0010>\u001a\u00020,H\u0017J\r\u0010?\u001a\u00020,H\u0001¢\u0006\u0002\b@R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006C"}, d2 = {"Lcom/urbanairship/messagecenter/MessageCenter;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "pushManager", "Lcom/urbanairship/push/PushManager;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/push/PushManager;)V", "inbox", "Lcom/urbanairship/messagecenter/Inbox;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/messagecenter/Inbox;Lcom/urbanairship/push/PushManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getInbox", "()Lcom/urbanairship/messagecenter/Inbox;", "job", "Lkotlinx/coroutines/CompletableJob;", "onShowMessageCenterListener", "Lcom/urbanairship/messagecenter/MessageCenter$OnShowMessageCenterListener;", "predicate", "Lcom/urbanairship/Predicate;", "Lcom/urbanairship/messagecenter/Message;", "getPredicate", "()Lcom/urbanairship/Predicate;", "setPredicate", "(Lcom/urbanairship/Predicate;)V", "pushListener", "Lcom/urbanairship/push/PushListener;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", TCEventPropertiesNames.TCE_USER, "Lcom/urbanairship/messagecenter/User;", "getUser", "()Lcom/urbanairship/messagecenter/User;", "getComponentGroup", "", "init", "", "initialize", "initialize$urbanairship_message_center_release", "onAirshipDeepLink", "", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "airship", "Lcom/urbanairship/UAirship;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "setOnShowMessageCenterListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showMessageCenter", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "tearDown", "updateInboxEnabledState", "updateInboxEnabledState$urbanairship_message_center_release", "Companion", "OnShowMessageCenterListener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageCenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenter.kt\ncom/urbanairship/messagecenter/MessageCenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,341:1\n1#2:342\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageCenter extends AirshipComponent {

    @NotNull
    public static final String ACTION_UPDATE_INBOX = "ACTION_UPDATE_INBOX";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String MESSAGE_DATA_SCHEME = "message";

    @NotNull
    public static final String VIEW_MESSAGE_CENTER_INTENT_ACTION = "com.urbanairship.VIEW_RICH_PUSH_INBOX";

    @NotNull
    public static final String VIEW_MESSAGE_INTENT_ACTION = "com.urbanairship.VIEW_RICH_PUSH_MESSAGE";
    private final Inbox inbox;
    private final CompletableJob job;
    private OnShowMessageCenterListener onShowMessageCenterListener;
    private Predicate predicate;
    private final PrivacyManager privacyManager;
    private final PushListener pushListener;
    private final PushManager pushManager;
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/MessageCenter$OnShowMessageCenterListener;", "", "onShowMessageCenter", "", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnShowMessageCenterListener {
        boolean onShowMessageCenter(@Nullable String messageId);
    }

    @JvmStatic
    @Nullable
    public static final String parseMessageId(@Nullable Intent intent) {
        return INSTANCE.parseMessageId(intent);
    }

    @JvmStatic
    @NotNull
    public static final MessageCenter shared() {
        return INSTANCE.shared();
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 2;
    }

    @JvmOverloads
    public final void showMessageCenter() {
        showMessageCenter$default(this, null, 1, null);
    }

    @NotNull
    public final Inbox getInbox() {
        return this.inbox;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public MessageCenter(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull PrivacyManager privacyManager, @NotNull Inbox inbox, @NotNull PushManager pushManager, @NotNull CoroutineDispatcher dispatcher) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(inbox, "inbox");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.privacyManager = privacyManager;
        this.inbox = inbox;
        this.pushManager = pushManager;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(completableJobSupervisorJob$default));
        this.pushListener = new PushListener() { // from class: com.urbanairship.messagecenter.MessageCenter$$ExternalSyntheticLambda1
            @Override // com.urbanairship.push.PushListener
            public final void onPushReceived(PushMessage pushMessage, boolean z) {
                MessageCenter.pushListener$lambda$0(this.f$0, pushMessage, z);
            }
        };
    }

    @Nullable
    public final Predicate<Message> getPredicate() {
        return this.predicate;
    }

    public final void setPredicate(@Nullable Predicate<Message> predicate) {
        this.predicate = predicate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pushListener$lambda$0(MessageCenter this$0, PushMessage message, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        if (this$0.privacyManager.isEnabled(PrivacyManager.Feature.MESSAGE_CENTER)) {
            BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new MessageCenter$pushListener$1$1(message, this$0, null), 3, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MessageCenter(@NotNull final Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel channel, @NotNull PushManager pushManager) {
        this(context, dataStore, privacyManager, new Inbox(context, dataStore, channel, config, new Function1() { // from class: com.urbanairship.messagecenter.MessageCenter.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Inbox.UpdateType) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Inbox.UpdateType reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                JobDispatcher jobDispatcherShared = JobDispatcher.shared(context);
                Intrinsics.checkNotNullExpressionValue(jobDispatcherShared, "shared(...)");
                MessageCenterKt.scheduleInboxUpdateJob(jobDispatcherShared, reason);
            }
        }), pushManager, Dispatchers.getIO());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void init() {
        super.init();
        initialize$urbanairship_message_center_release();
    }

    @VisibleForTesting
    public final void initialize$urbanairship_message_center_release() {
        this.pushManager.addInternalPushListener(this.pushListener);
        this.privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.messagecenter.MessageCenter$$ExternalSyntheticLambda0
            @Override // com.urbanairship.PrivacyManager.Listener
            public final void onEnabledFeaturesChanged() {
                MessageCenter.initialize$lambda$2(this.f$0);
            }
        });
        updateInboxEnabledState$urbanairship_message_center_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$2(final MessageCenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AirshipExecutors.newSerialExecutor().execute(new Runnable() { // from class: com.urbanairship.messagecenter.MessageCenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MessageCenter.initialize$lambda$2$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$2$lambda$1(MessageCenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateInboxEnabledState$urbanairship_message_center_release();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void updateInboxEnabledState$urbanairship_message_center_release() {
        this.inbox.setEnabled$urbanairship_message_center_release(this.privacyManager.isEnabled(PrivacyManager.Feature.MESSAGE_CENTER));
    }

    /* renamed from: com.urbanairship.messagecenter.MessageCenter$onPerformJob$1, reason: invalid class name and case insensitive filesystem */
    static final class C12121 extends SuspendLambda implements Function2 {
        int label;

        C12121(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageCenter.this.new C12121(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM2906performUpdateIoAF18A$urbanairship_message_center_release;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Inbox inbox = MessageCenter.this.getInbox();
                this.label = 1;
                objM2906performUpdateIoAF18A$urbanairship_message_center_release = inbox.m2906performUpdateIoAF18A$urbanairship_message_center_release(this);
                if (objM2906performUpdateIoAF18A$urbanairship_message_center_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM2906performUpdateIoAF18A$urbanairship_message_center_release = ((Result) obj).getValue();
            }
            if (Result.m2971exceptionOrNullimpl(objM2906performUpdateIoAF18A$urbanairship_message_center_release) != null) {
                return JobResult.FAILURE;
            }
            if (((Boolean) objM2906performUpdateIoAF18A$urbanairship_message_center_release).booleanValue()) {
                return JobResult.SUCCESS;
            }
            return JobResult.RETRY;
        }
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.MESSAGE_CENTER)) {
            return (JobResult) BuildersKt__BuildersKt.runBlocking$default(null, new C12121(null), 1, null);
        }
        return JobResult.SUCCESS;
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void tearDown() {
        this.inbox.tearDown$urbanairship_message_center_release();
        this.pushManager.removePushListener(this.pushListener);
    }

    @NotNull
    public final User getUser() {
        return this.inbox.getUser();
    }

    public final void setOnShowMessageCenterListener(@Nullable OnShowMessageCenterListener listener) {
        this.onShowMessageCenterListener = listener;
    }

    public static /* synthetic */ void showMessageCenter$default(MessageCenter messageCenter, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        messageCenter.showMessageCenter(str);
    }

    @JvmOverloads
    public final void showMessageCenter(@Nullable String messageId) {
        if (!this.privacyManager.isEnabled(PrivacyManager.Feature.MESSAGE_CENTER)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.messagecenter.MessageCenter.showMessageCenter.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to show Message Center. FEATURE_MESSAGE_CENTER is not enabled in PrivacyManager.";
                }
            }, 1, null);
            return;
        }
        OnShowMessageCenterListener onShowMessageCenterListener = this.onShowMessageCenterListener;
        if (onShowMessageCenterListener == null || !onShowMessageCenterListener.onShowMessageCenter(messageId)) {
            Intent intentAddFlags = new Intent(VIEW_MESSAGE_CENTER_INTENT_ACTION).setPackage(getContext().getPackageName()).addFlags(805306368);
            Intrinsics.checkNotNullExpressionValue(intentAddFlags, "addFlags(...)");
            if (messageId != null) {
                intentAddFlags.setData(Uri.fromParts("message", messageId, null));
            }
            if (intentAddFlags.resolveActivity(getContext().getPackageManager()) != null) {
                getContext().startActivity(intentAddFlags);
                return;
            }
            if (messageId != null) {
                intentAddFlags.setAction(VIEW_MESSAGE_INTENT_ACTION);
                if (intentAddFlags.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(intentAddFlags);
                    return;
                }
            }
            intentAddFlags.setClass(getContext(), MessageCenterActivity.class);
            getContext().startActivity(intentAddFlags);
        }
    }

    @Override // com.urbanairship.AirshipComponent
    public boolean onAirshipDeepLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual(AirshipConfigOptions.FEATURE_MESSAGE_CENTER, uri.getEncodedAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 0) {
                showMessageCenter$default(this, null, 1, null);
                return true;
            }
            if (pathSegments.size() == 1) {
                showMessageCenter(pathSegments.get(0));
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/messagecenter/MessageCenter$Companion;", "", "()V", MessageCenter.ACTION_UPDATE_INBOX, "", "DEEP_LINK_HOST", "MESSAGE_DATA_SCHEME", "VIEW_MESSAGE_CENTER_INTENT_ACTION", "VIEW_MESSAGE_INTENT_ACTION", "parseMessageId", "intent", "Landroid/content/Intent;", "shared", "Lcom/urbanairship/messagecenter/MessageCenter;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final MessageCenter shared() {
            AirshipComponent airshipComponentRequireComponent = UAirship.shared().requireComponent(MessageCenter.class);
            Intrinsics.checkNotNullExpressionValue(airshipComponentRequireComponent, "requireComponent(...)");
            return (MessageCenter) airshipComponentRequireComponent;
        }

        @JvmStatic
        @Nullable
        public final String parseMessageId(@Nullable Intent intent) {
            String action;
            if (intent == null || intent.getData() == null || intent.getAction() == null) {
                return null;
            }
            Uri data = intent.getData();
            if (!StringsKt.equals("message", data != null ? data.getScheme() : null, true) || (action = intent.getAction()) == null) {
                return null;
            }
            int iHashCode = action.hashCode();
            if (iHashCode != 883094839) {
                if (iHashCode != 1558767224 || !action.equals(MessageCenter.VIEW_MESSAGE_INTENT_ACTION)) {
                    return null;
                }
            } else if (!action.equals(MessageCenter.VIEW_MESSAGE_CENTER_INTENT_ACTION)) {
                return null;
            }
            Uri data2 = intent.getData();
            if (data2 != null) {
                return data2.getSchemeSpecificPart();
            }
            return null;
        }
    }
}
