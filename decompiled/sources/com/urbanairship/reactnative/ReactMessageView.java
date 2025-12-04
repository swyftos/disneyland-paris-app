package com.urbanairship.reactnative;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import ch.qos.logback.core.joran.action.Action;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.Constants;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.ui.widget.MessageWebView;
import com.urbanairship.messagecenter.ui.widget.MessageWebViewClient;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\u0006\u0010&\u001a\u00020\u0017R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/urbanairship/reactnative/ReactMessageView;", "Landroid/widget/FrameLayout;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "message", "Lcom/urbanairship/messagecenter/Message;", "webView", "Lcom/urbanairship/messagecenter/ui/widget/MessageWebView;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "loadJob", "Lkotlinx/coroutines/Job;", "webViewClient", "Landroid/webkit/WebViewClient;", "fetchMessage", "Lcom/urbanairship/reactnative/FetchMessageResult;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMessage", "", "notifyLoadError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "retryable", "", "notifyLoadFinished", "notifyLoadStarted", "notifyClose", "notify", "eventName", "event", "Lcom/facebook/react/bridge/WritableMap;", "onHostResume", "onHostPause", "onHostDestroy", "cleanup", "Companion", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
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

    /* renamed from: com.urbanairship.reactnative.ReactMessageView$fetchMessage$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchMessage(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.reactnative.ReactMessageView.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.reactnative.ReactMessageView$fetchMessage$1 r0 = (com.urbanairship.reactnative.ReactMessageView.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.reactnative.ReactMessageView$fetchMessage$1 r0 = new com.urbanairship.reactnative.ReactMessageView$fetchMessage$1
            r0.<init>(r7)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L47
            if (r1 == r4) goto L3f
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r5)
            goto L9e
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L78
        L3f:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5f
        L47:
            kotlin.ResultKt.throwOnFailure(r5)
            com.urbanairship.messagecenter.MessageCenter$Companion r5 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            com.urbanairship.messagecenter.MessageCenter r5 = r5.shared()
            com.urbanairship.messagecenter.Inbox r5 = r5.getInbox()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r5 = r5.getMessage(r6, r0)
            if (r5 != r7) goto L5f
            return r7
        L5f:
            com.urbanairship.messagecenter.Message r5 = (com.urbanairship.messagecenter.Message) r5
            if (r5 != 0) goto La0
            com.urbanairship.messagecenter.MessageCenter$Companion r5 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            com.urbanairship.messagecenter.MessageCenter r5 = r5.shared()
            com.urbanairship.messagecenter.Inbox r5 = r5.getInbox()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.fetchMessages(r0)
            if (r5 != r7) goto L78
            return r7
        L78:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L88
            com.urbanairship.reactnative.FetchMessageResult$Error r5 = new com.urbanairship.reactnative.FetchMessageResult$Error
            java.lang.String r6 = "FAILED_TO_FETCH_MESSAGE"
            r5.<init>(r6, r4)
            return r5
        L88:
            com.urbanairship.messagecenter.MessageCenter$Companion r5 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            com.urbanairship.messagecenter.MessageCenter r5 = r5.shared()
            com.urbanairship.messagecenter.Inbox r5 = r5.getInbox()
            r1 = 0
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r5 = r5.getMessage(r6, r0)
            if (r5 != r7) goto L9e
            return r7
        L9e:
            com.urbanairship.messagecenter.Message r5 = (com.urbanairship.messagecenter.Message) r5
        La0:
            if (r5 == 0) goto Laf
            boolean r6 = r5.isExpired()
            if (r6 == 0) goto La9
            goto Laf
        La9:
            com.urbanairship.reactnative.FetchMessageResult$Success r6 = new com.urbanairship.reactnative.FetchMessageResult$Success
            r6.<init>(r5)
            goto Lb7
        Laf:
            com.urbanairship.reactnative.FetchMessageResult$Error r6 = new com.urbanairship.reactnative.FetchMessageResult$Error
            java.lang.String r5 = "MESSAGE_NOT_AVAILABLE"
            r7 = 0
            r6.<init>(r5, r7)
        Lb7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.reactnative.ReactMessageView.fetchMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
        this.loadJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C13801(booleanRef, this, messageId, null), 3, null);
    }

    /* renamed from: com.urbanairship.reactnative.ReactMessageView$loadMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C13801 extends SuspendLambda implements Function2 {
        final /* synthetic */ Ref.BooleanRef $delayLoading;
        final /* synthetic */ String $messageId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ReactMessageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13801(Ref.BooleanRef booleanRef, ReactMessageView reactMessageView, String str, Continuation continuation) {
            super(2, continuation);
            this.$delayLoading = booleanRef;
            this.this$0 = reactMessageView;
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C13801 c13801 = new C13801(this.$delayLoading, this.this$0, this.$messageId, continuation);
            c13801.L$0 = obj;
            return c13801;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C13801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r5.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L61
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L41
            L26:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.jvm.internal.Ref$BooleanRef r6 = r5.$delayLoading
                boolean r6 = r6.element
                if (r6 == 0) goto L41
                r5.L$0 = r1
                r5.label = r3
                r3 = 50
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r5)
                if (r6 != r0) goto L41
                return r0
            L41:
                boolean r6 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r6 != 0) goto L4a
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L4a:
                com.urbanairship.reactnative.ReactMessageView r6 = r5.this$0
                java.lang.String r3 = r5.$messageId
                com.urbanairship.reactnative.ReactMessageView.access$notifyLoadStarted(r6, r3)
                com.urbanairship.reactnative.ReactMessageView r6 = r5.this$0
                java.lang.String r3 = r5.$messageId
                r5.L$0 = r1
                r5.label = r2
                java.lang.Object r6 = com.urbanairship.reactnative.ReactMessageView.access$fetchMessage(r6, r3, r5)
                if (r6 != r0) goto L60
                return r0
            L60:
                r0 = r1
            L61:
                com.urbanairship.reactnative.FetchMessageResult r6 = (com.urbanairship.reactnative.FetchMessageResult) r6
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                if (r0 != 0) goto L6c
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L6c:
                boolean r0 = r6 instanceof com.urbanairship.reactnative.FetchMessageResult.Error
                if (r0 == 0) goto L82
                com.urbanairship.reactnative.ReactMessageView r0 = r5.this$0
                java.lang.String r5 = r5.$messageId
                com.urbanairship.reactnative.FetchMessageResult$Error r6 = (com.urbanairship.reactnative.FetchMessageResult.Error) r6
                java.lang.String r1 = r6.getError()
                boolean r6 = r6.isRetryable()
                com.urbanairship.reactnative.ReactMessageView.access$notifyLoadError(r0, r5, r1, r6)
                goto La0
            L82:
                boolean r0 = r6 instanceof com.urbanairship.reactnative.FetchMessageResult.Success
                if (r0 == 0) goto La3
                com.urbanairship.reactnative.ReactMessageView r0 = r5.this$0
                com.urbanairship.reactnative.FetchMessageResult$Success r6 = (com.urbanairship.reactnative.FetchMessageResult.Success) r6
                com.urbanairship.messagecenter.Message r1 = r6.getMessage()
                com.urbanairship.reactnative.ReactMessageView.access$setMessage$p(r0, r1)
                com.urbanairship.reactnative.ReactMessageView r5 = r5.this$0
                com.urbanairship.messagecenter.ui.widget.MessageWebView r5 = com.urbanairship.reactnative.ReactMessageView.access$getWebView$p(r5)
                if (r5 == 0) goto La0
                com.urbanairship.messagecenter.Message r6 = r6.getMessage()
                r5.loadMessage(r6)
            La0:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            La3:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.reactnative.ReactMessageView.C13801.invokeSuspend(java.lang.Object):java.lang.Object");
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
