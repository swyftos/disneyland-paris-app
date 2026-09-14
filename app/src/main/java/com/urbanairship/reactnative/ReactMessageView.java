package com.urbanairship.reactnative;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.Constants;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.p040ui.widget.MessageWebView;
import com.urbanairship.messagecenter.p040ui.widget.MessageWebViewClient;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\u0006\u0010&\u001a\u00020\u0017R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1836d2 = {"Lcom/urbanairship/reactnative/ReactMessageView;", "Landroid/widget/FrameLayout;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "message", "Lcom/urbanairship/messagecenter/Message;", "webView", "Lcom/urbanairship/messagecenter/ui/widget/MessageWebView;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadJob", "Lkotlinx/coroutines/Job;", "webViewClient", "Landroid/webkit/WebViewClient;", "fetchMessage", "Lcom/urbanairship/reactnative/FetchMessageResult;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMessage", "", "notifyLoadError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "retryable", "", "notifyLoadFinished", "notifyLoadStarted", "notifyClose", "notify", "eventName", "event", "Lcom/facebook/react/bridge/WritableMap;", "onHostResume", "onHostPause", "onHostDestroy", "cleanup", "Companion", "ua_react-native-airship_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SuppressLint({"RestrictedApi"})
public final class ReactMessageView extends FrameLayout implements LifecycleEventListener {

    @NotNull
    public static final String EVENT_CLOSE = "close";

    @NotNull
    public static final String EVENT_CLOSE_HANDLER_NAME = "onClose";

    @NotNull
    public static final String EVENT_CLOSE_REGISTRATION_NAME = "topClose";

    @NotNull
    public static final String EVENT_LOAD_ERROR = "loadError";

    @NotNull
    public static final String EVENT_LOAD_ERROR_HANDLER_NAME = "onLoadError";

    @NotNull
    public static final String EVENT_LOAD_ERROR_REGISTRATION_NAME = "topLoadError";

    @NotNull
    public static final String EVENT_LOAD_FINISHED = "loadFinished";

    @NotNull
    public static final String EVENT_LOAD_FINISHED_HANDLER_NAME = "onLoadFinished";

    @NotNull
    public static final String EVENT_LOAD_FINISHED_REGISTRATION_NAME = "topLoadFinished";

    @NotNull
    public static final String EVENT_LOAD_STARTED = "loadStarted";

    @NotNull
    public static final String EVENT_LOAD_STARTED_HANDLER_NAME = "onLoadStarted";

    @NotNull
    public static final String EVENT_LOAD_STARTED_REGISTRATION_NAME = "topLoadStarted";
    private Job loadJob;
    private Message message;
    private final CoroutineScope scope;
    private MessageWebView webView;
    private final WebViewClient webViewClient;

    /* JADX INFO: renamed from: com.urbanairship.reactnative.ReactMessageView$fetchMessage$1 */
    static final class C58391 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C58391(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReactMessageView.this.fetchMessage(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactMessageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        this.webViewClient = new MessageWebViewClient() { // from class: com.urbanairship.reactnative.ReactMessageView$webViewClient$1
            private Integer error;

            @Override // com.urbanairship.webkit.AirshipWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
                super.onPageFinished(view, url);
                Message message = this.this$0.message;
                if (message != null) {
                    ReactMessageView reactMessageView = this.this$0;
                    if (this.error != null) {
                        reactMessageView.notifyLoadError(message.getId(), "MESSAGE_LOAD_FAILED", false);
                    } else {
                        MessageCenter.INSTANCE.shared().getInbox().markMessagesRead(message.getId());
                        reactMessageView.notifyLoadFinished(message.getId());
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(description, "description");
                super.onReceivedError(view, errorCode, description, failingUrl);
                Message message = this.this$0.message;
                if (message == null || failingUrl == null || !Intrinsics.areEqual(failingUrl, message.getBodyUrl())) {
                    return;
                }
                this.error = Integer.valueOf(errorCode);
            }

            @Override // com.urbanairship.webkit.AirshipWebViewClient
            public void onClose(WebView webView) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                Message message = this.this$0.message;
                if (message != null) {
                    this.this$0.notifyClose(message.getId());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0080  */
    /* JADX WARN: Code duplicated, block: B:30:0x0088  */
    /* JADX WARN: Code duplicated, block: B:32:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchMessage(String str, Continuation continuation) {
        C58391 c58391;
        Message message;
        if (continuation instanceof C58391) {
            c58391 = (C58391) continuation;
            int i = c58391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c58391.label = i - Integer.MIN_VALUE;
            } else {
                c58391 = new C58391(continuation);
            }
        } else {
            c58391 = new C58391(continuation);
        }
        Object message2 = c58391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c58391.label;
        if (i2 != 0) {
            if (i2 == 1) {
                str = (String) c58391.L$0;
                ResultKt.throwOnFailure(message2);
            } else if (i2 == 2) {
                str = (String) c58391.L$0;
                ResultKt.throwOnFailure(message2);
                if (!((Boolean) message2).booleanValue()) {
                    return new FetchMessageResult.Error("FAILED_TO_FETCH_MESSAGE", true);
                }
                Inbox inbox = MessageCenter.INSTANCE.shared().getInbox();
                c58391.L$0 = null;
                c58391.label = 3;
                message2 = inbox.getMessage(str, c58391);
                if (message2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(message2);
            }
            message = (Message) message2;
            if (message != null || message.isExpired()) {
                return new FetchMessageResult.Error("MESSAGE_NOT_AVAILABLE", false);
            }
            return new FetchMessageResult.Success(message);
        }
        ResultKt.throwOnFailure(message2);
        Inbox inbox2 = MessageCenter.INSTANCE.shared().getInbox();
        c58391.L$0 = str;
        c58391.label = 1;
        message2 = inbox2.getMessage(str, c58391);
        if (message2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        message = (Message) message2;
        if (message == null) {
            Inbox inbox3 = MessageCenter.INSTANCE.shared().getInbox();
            c58391.L$0 = str;
            c58391.label = 2;
            message2 = inbox3.fetchMessages(c58391);
            if (message2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!((Boolean) message2).booleanValue()) {
                return new FetchMessageResult.Error("FAILED_TO_FETCH_MESSAGE", true);
            }
            Inbox inbox4 = MessageCenter.INSTANCE.shared().getInbox();
            c58391.L$0 = null;
            c58391.label = 3;
            message2 = inbox4.getMessage(str, c58391);
            if (message2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            message = (Message) message2;
        }
        if (message != null) {
        }
        return new FetchMessageResult.Error("MESSAGE_NOT_AVAILABLE", false);
    }

    public final void loadMessage(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (this.webView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            MessageWebView messageWebView = new MessageWebView(context, null, 0, 0, 14, null);
            this.webView = messageWebView;
            messageWebView.setWebViewClient(this.webViewClient);
            addView(this.webView);
            booleanRef.element = true;
        }
        this.message = null;
        this.loadJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C58401(booleanRef, this, messageId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.reactnative.ReactMessageView$loadMessage$1 */
    static final class C58401 extends SuspendLambda implements Function2 {
        final /* synthetic */ Ref.BooleanRef $delayLoading;
        final /* synthetic */ String $messageId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ReactMessageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C58401(Ref.BooleanRef booleanRef, ReactMessageView reactMessageView, String str, Continuation continuation) {
            super(2, continuation);
            this.$delayLoading = booleanRef;
            this.this$0 = reactMessageView;
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C58401 c58401 = new C58401(this.$delayLoading, this.this$0, this.$messageId, continuation);
            c58401.L$0 = obj;
            return c58401;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C58401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0069  */
        /* JADX WARN: Code duplicated, block: B:27:0x006c  */
        /* JADX WARN: Code duplicated, block: B:29:0x0070  */
        /* JADX WARN: Code duplicated, block: B:30:0x0082  */
        /* JADX WARN: Code duplicated, block: B:32:0x0086  */
        /* JADX WARN: Code duplicated, block: B:34:0x0099  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CoroutineScope coroutineScope2;
            FetchMessageResult fetchMessageResult;
            FetchMessageResult.Success success;
            MessageWebView messageWebView;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                fetchMessageResult = (FetchMessageResult) obj;
                if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                    return Unit.INSTANCE;
                }
                if (fetchMessageResult instanceof FetchMessageResult.Error) {
                    FetchMessageResult.Error error = (FetchMessageResult.Error) fetchMessageResult;
                    this.this$0.notifyLoadError(this.$messageId, error.getError(), error.isRetryable());
                } else {
                    if (fetchMessageResult instanceof FetchMessageResult.Success) {
                        throw new NoWhenBranchMatchedException();
                    }
                    success = (FetchMessageResult.Success) fetchMessageResult;
                    this.this$0.message = success.getMessage();
                    messageWebView = this.this$0.webView;
                    if (messageWebView != null) {
                        messageWebView.loadMessage(success.getMessage());
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (this.$delayLoading.element) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(50L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.this$0.notifyLoadStarted(this.$messageId);
                ReactMessageView reactMessageView = this.this$0;
                String str = this.$messageId;
                this.L$0 = coroutineScope;
                this.label = 2;
                obj = reactMessageView.fetchMessage(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope;
                fetchMessageResult = (FetchMessageResult) obj;
                if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                    return Unit.INSTANCE;
                }
                if (fetchMessageResult instanceof FetchMessageResult.Error) {
                    FetchMessageResult.Error error2 = (FetchMessageResult.Error) fetchMessageResult;
                    this.this$0.notifyLoadError(this.$messageId, error2.getError(), error2.isRetryable());
                } else {
                    if (fetchMessageResult instanceof FetchMessageResult.Success) {
                        throw new NoWhenBranchMatchedException();
                    }
                    success = (FetchMessageResult.Success) fetchMessageResult;
                    this.this$0.message = success.getMessage();
                    messageWebView = this.this$0.webView;
                    if (messageWebView != null) {
                        messageWebView.loadMessage(success.getMessage());
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyLoadError(String messageId, String error, boolean retryable) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, messageId);
        writableMapCreateMap.putBoolean("retryable", retryable);
        writableMapCreateMap.putString(Constants.IPC_BUNDLE_KEY_SEND_ERROR, error);
        Intrinsics.checkNotNull(writableMapCreateMap);
        notify(EVENT_LOAD_ERROR, writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyLoadFinished(String messageId) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, messageId);
        Intrinsics.checkNotNull(writableMapCreateMap);
        notify(EVENT_LOAD_FINISHED, writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyLoadStarted(String messageId) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, messageId);
        Intrinsics.checkNotNull(writableMapCreateMap);
        notify(EVENT_LOAD_STARTED, writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyClose(String messageId) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, messageId);
        Intrinsics.checkNotNull(writableMapCreateMap);
        notify(EVENT_CLOSE, writableMapCreateMap);
    }

    private final void notify(String eventName, WritableMap event) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContextExtensionsKt.airshipDispatchEvent((ReactContext) context, getId(), eventName, event);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        MessageWebView messageWebView = this.webView;
        if (messageWebView != null) {
            messageWebView.onResume();
        }
        MessageWebView messageWebView2 = this.webView;
        if (messageWebView2 != null) {
            messageWebView2.resumeTimers();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        MessageWebView messageWebView = this.webView;
        if (messageWebView != null) {
            messageWebView.onPause();
        }
        MessageWebView messageWebView2 = this.webView;
        if (messageWebView2 != null) {
            messageWebView2.pauseTimers();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        cleanup();
    }

    public final void cleanup() {
        MessageWebView messageWebView = this.webView;
        if (messageWebView != null) {
            messageWebView.destroy();
        }
        this.webView = null;
    }
}
