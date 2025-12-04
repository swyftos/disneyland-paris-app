package com.disney.id.android;

import android.content.Context;
import android.os.Looper;
import androidx.media3.extractor.ts.TsExtractor;
import com.disney.id.android.SCALPController;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0096@¢\u0006\u0002\u0010KJ \u0010L\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020FH\u0016J\u0016\u0010O\u001a\u00020J2\u0006\u0010G\u001a\u00020HH\u0096@¢\u0006\u0002\u0010PR\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006R"}, d2 = {"Lcom/disney/id/android/OneIDSCALPBundle;", "Lcom/disney/id/android/SCALPBundle;", "()V", "bundler", "Lcom/disney/id/android/bundler/Bundler;", "getBundler$OneID_release", "()Lcom/disney/id/android/bundler/Bundler;", "setBundler$OneID_release", "(Lcom/disney/id/android/bundler/Bundler;)V", "context", "Landroid/content/Context;", "getContext$OneID_release", "()Landroid/content/Context;", "setContext$OneID_release", "(Landroid/content/Context;)V", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "initializationCallbackHolder", "Lcom/disney/id/android/InitializationCallbackHolder;", "getInitializationCallbackHolder$OneID_release", "()Lcom/disney/id/android/InitializationCallbackHolder;", "setInitializationCallbackHolder$OneID_release", "(Lcom/disney/id/android/InitializationCallbackHolder;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "oneIDWebView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "getOneIDWebView$OneID_release", "()Lcom/disney/id/android/lightbox/LightboxWebView;", "setOneIDWebView$OneID_release", "(Lcom/disney/id/android/lightbox/LightboxWebView;)V", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "version", "", "getVersion$OneID_release", "()Ljava/lang/String;", "setVersion$OneID_release", "(Ljava/lang/String;)V", "webViewFactory", "Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "getWebViewFactory$OneID_release", "()Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "setWebViewFactory$OneID_release", "(Lcom/disney/id/android/lightbox/OneIDWebViewFactory;)V", "initializeBundle", "", "conversationEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "configData", "Lcom/disney/id/android/ConfigData;", "(Lcom/disney/id/android/tracker/TrackerEventKey;Lcom/disney/id/android/ConfigData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBundleIntoWebview", "new", "previousLightboxReadyState", "loadSCALP", "(Lcom/disney/id/android/tracker/TrackerEventKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDSCALPBundle implements SCALPBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = OneIDSCALPBundle.class.getSimpleName();

    @Inject
    public Bundler bundler;

    @Inject
    public Context context;

    @Inject
    public GuestHandler guestHandler;

    @Inject
    public InitializationCallbackHolder initializationCallbackHolder;

    @Inject
    public Logger logger;
    private LightboxWebView oneIDWebView;

    @Inject
    public SCALPController scalpController;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    public String version;

    @Inject
    public OneIDWebViewFactory webViewFactory;

    public OneIDSCALPBundle() {
        OneIDDagger.getComponent().inject(this);
        LightboxWebView lightboxWebView = null;
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate())), null, null, new AnonymousClass2(null), 3, null);
            return;
        }
        LightboxWebView oneIDWebView$default = OneIDWebViewFactory.getOneIDWebView$default(getWebViewFactory$OneID_release(), null, 1, null);
        if (oneIDWebView$default == null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Unable to get webView", null, 4, null);
        } else {
            lightboxWebView = oneIDWebView$default;
        }
        this.oneIDWebView = lightboxWebView;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/disney/id/android/OneIDSCALPBundle$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return OneIDSCALPBundle.TAG;
        }
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    @NotNull
    public final Bundler getBundler$OneID_release() {
        Bundler bundler = this.bundler;
        if (bundler != null) {
            return bundler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundler");
        return null;
    }

    public final void setBundler$OneID_release(@NotNull Bundler bundler) {
        Intrinsics.checkNotNullParameter(bundler, "<set-?>");
        this.bundler = bundler;
    }

    @NotNull
    public final SCALPController getScalpController$OneID_release() {
        SCALPController sCALPController = this.scalpController;
        if (sCALPController != null) {
            return sCALPController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpController");
        return null;
    }

    public final void setScalpController$OneID_release(@NotNull SCALPController sCALPController) {
        Intrinsics.checkNotNullParameter(sCALPController, "<set-?>");
        this.scalpController = sCALPController;
    }

    @NotNull
    public final GuestHandler getGuestHandler$OneID_release() {
        GuestHandler guestHandler = this.guestHandler;
        if (guestHandler != null) {
            return guestHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guestHandler");
        return null;
    }

    public final void setGuestHandler$OneID_release(@NotNull GuestHandler guestHandler) {
        Intrinsics.checkNotNullParameter(guestHandler, "<set-?>");
        this.guestHandler = guestHandler;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final InitializationCallbackHolder getInitializationCallbackHolder$OneID_release() {
        InitializationCallbackHolder initializationCallbackHolder = this.initializationCallbackHolder;
        if (initializationCallbackHolder != null) {
            return initializationCallbackHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initializationCallbackHolder");
        return null;
    }

    public final void setInitializationCallbackHolder$OneID_release(@NotNull InitializationCallbackHolder initializationCallbackHolder) {
        Intrinsics.checkNotNullParameter(initializationCallbackHolder, "<set-?>");
        this.initializationCallbackHolder = initializationCallbackHolder;
    }

    @NotNull
    public final Context getContext$OneID_release() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext$OneID_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    @NotNull
    public final OneIDWebViewFactory getWebViewFactory$OneID_release() {
        OneIDWebViewFactory oneIDWebViewFactory = this.webViewFactory;
        if (oneIDWebViewFactory != null) {
            return oneIDWebViewFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webViewFactory");
        return null;
    }

    public final void setWebViewFactory$OneID_release(@NotNull OneIDWebViewFactory oneIDWebViewFactory) {
        Intrinsics.checkNotNullParameter(oneIDWebViewFactory, "<set-?>");
        this.webViewFactory = oneIDWebViewFactory;
    }

    @Nullable
    /* renamed from: getOneIDWebView$OneID_release, reason: from getter */
    public final LightboxWebView getOneIDWebView() {
        return this.oneIDWebView;
    }

    public final void setOneIDWebView$OneID_release(@Nullable LightboxWebView lightboxWebView) {
        this.oneIDWebView = lightboxWebView;
    }

    @NotNull
    public final String getVersion$OneID_release() {
        String str = this.version;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    public final void setVersion$OneID_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    /* renamed from: com.disney.id.android.OneIDSCALPBundle$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = OneIDSCALPBundle.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OneIDSCALPBundle oneIDSCALPBundle = OneIDSCALPBundle.this;
            LightboxWebView lightboxWebView = null;
            LightboxWebView oneIDWebView$default = OneIDWebViewFactory.getOneIDWebView$default(oneIDSCALPBundle.getWebViewFactory$OneID_release(), null, 1, null);
            if (oneIDWebView$default == null) {
                Logger logger$OneID_release = OneIDSCALPBundle.this.getLogger$OneID_release();
                String tAG$OneID_release = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.e$default(logger$OneID_release, tAG$OneID_release, "Unable to get webView", null, 4, null);
            } else {
                lightboxWebView = oneIDWebView$default;
            }
            oneIDSCALPBundle.setOneIDWebView$OneID_release(lightboxWebView);
            return Unit.INSTANCE;
        }
    }

    @Override // com.disney.id.android.SCALPBundle
    @Nullable
    public Object loadSCALP(@NotNull TrackerEventKey trackerEventKey, @NotNull Continuation<? super ConfigData> continuation) throws Throwable {
        Profile profile;
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), trackerEventKey.getId(), EventAction.LOG_GET_CONFIG_DATA, getSwid$OneID_release().get(), "from(sdkinit)", null, 16, null);
        Guest guest = getGuestHandler$OneID_release().get();
        String ageBand = (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getAgeBand();
        LightboxWebView lightboxWebView = this.oneIDWebView;
        final boolean lightboxReady = lightboxWebView != null ? lightboxWebView.getLightboxReady() : false;
        getScalpController$OneID_release().load(trackerEventKeyStartTransactionEvent$default.getId(), getContext$OneID_release(), ageBand, new SCALPController.LoadListener() { // from class: com.disney.id.android.OneIDSCALPBundle$loadSCALP$2$loadListener$1
            @Override // com.disney.id.android.SCALPController.LoadListener
            public void configLoadComplete(@NotNull String bundleVersion, @NotNull String bundlerURL) {
                Intrinsics.checkNotNullParameter(bundleVersion, "bundleVersion");
                Intrinsics.checkNotNullParameter(bundlerURL, "bundlerURL");
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "SCALP load complete // bundleVersion = " + bundleVersion + " // url = " + bundlerURL, null, 4, null);
                this.this$0.setVersion$OneID_release(bundleVersion);
                OneIDTrackerEvent event = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    event.appendCodes$OneID_release(null, null, "scalp(success)");
                }
                try {
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m2968constructorimpl(new ConfigData(bundleVersion, bundlerURL, lightboxReady)));
                } catch (IllegalStateException unused) {
                    Tracker.DefaultImpls.trackInstantEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default.getId(), false, EventAction.LOG_ERROR_RESUME_COROUTINE, this.this$0.getSwid$OneID_release().get(), OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, OneIDTrackerEvent.ERROR_CODE_EXTRA_RESUME, "scalp(successblock)", null, false, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, null);
                    Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                    String tAG$OneID_release2 = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                    Intrinsics.checkNotNullExpressionValue(tAG$OneID_release2, "<get-TAG>(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release2, tAG$OneID_release2, "SCALP coroutine double resume trapped // success block", null, 4, null);
                }
            }

            @Override // com.disney.id.android.SCALPController.LoadListener
            public void configLoadError(@NotNull TrackerEventKey transactionEventKey, @NotNull String error) {
                Intrinsics.checkNotNullParameter(transactionEventKey, "transactionEventKey");
                Intrinsics.checkNotNullParameter(error, "error");
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "SCALP load failed // resetting lightboxReady to " + lightboxReady, null, 4, null);
                LightboxWebView oneIDWebView = this.this$0.getOneIDWebView();
                if (oneIDWebView != null) {
                    oneIDWebView.setLightboxReady(lightboxReady);
                }
                Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), transactionEventKey, false, null, null, null, false, 62, null);
                InitializationCallbackHolder initializationCallbackHolder$OneID_release = this.this$0.getInitializationCallbackHolder$OneID_release();
                OneIDState oneIDState = OneIDState.PermanentFailure;
                initializationCallbackHolder$OneID_release.reportState(oneIDState);
                TrackerEventKey trackerEventKey2 = this.this$0.getInitializationCallbackHolder$OneID_release().getTrackerEventKey();
                if ((trackerEventKey2 != null ? trackerEventKey2.getId() : null) != null) {
                    Tracker tracker$OneID_release = this.this$0.getTracker$OneID_release();
                    TrackerEventKey trackerEventKey3 = this.this$0.getInitializationCallbackHolder$OneID_release().getTrackerEventKey();
                    Intrinsics.checkNotNull(trackerEventKey3);
                    Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey3, false, null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "oneidstate(" + oneIDState + ")", false, 36, null);
                    this.this$0.getInitializationCallbackHolder$OneID_release().setTrackerEventKey(null);
                }
                Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), transactionEventKey, false, null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "scalp(" + error + ")", false, 32, null);
                try {
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m2968constructorimpl(ResultKt.createFailure(new Throwable("SCALP load failed // " + error))));
                } catch (IllegalStateException unused) {
                    Tracker.DefaultImpls.trackInstantEvent$default(this.this$0.getTracker$OneID_release(), transactionEventKey.getId(), false, EventAction.LOG_ERROR_RESUME_COROUTINE, this.this$0.getSwid$OneID_release().get(), OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, OneIDTrackerEvent.ERROR_CODE_EXTRA_RESUME, "scalp(errorblock)", null, false, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, null);
                    Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                    String tAG$OneID_release2 = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                    Intrinsics.checkNotNullExpressionValue(tAG$OneID_release2, "<get-TAG>(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release2, tAG$OneID_release2, "SCALP coroutine double resume trapped // error block", null, 4, null);
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    @Override // com.disney.id.android.SCALPBundle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean loadBundleIntoWebview(@org.jetbrains.annotations.NotNull com.disney.id.android.tracker.TrackerEventKey r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneIDSCALPBundle.loadBundleIntoWebview(com.disney.id.android.tracker.TrackerEventKey, boolean, boolean):boolean");
    }

    @Override // com.disney.id.android.SCALPBundle
    @Nullable
    public Object initializeBundle(@NotNull final TrackerEventKey trackerEventKey, @NotNull final ConfigData configData, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Bundler.Listener listener = new Bundler.Listener() { // from class: com.disney.id.android.OneIDSCALPBundle$initializeBundle$2$listener$1
            @Override // com.disney.id.android.bundler.Bundler.Listener
            public void onComplete(boolean z) {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "Bundler worker download complete // new = " + z, null, 4, null);
                this.this$0.loadBundleIntoWebview(trackerEventKey, z, configData.getPreviousState());
                Continuation continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m2968constructorimpl(Boolean.TRUE));
            }

            @Override // com.disney.id.android.bundler.Bundler.Listener
            public void onFailure(@NotNull TrackerEventKey transactionEventKey) {
                Intrinsics.checkNotNullParameter(transactionEventKey, "transactionEventKey");
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDSCALPBundle.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "Bundler worker download failed", null, 4, null);
                Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), transactionEventKey, false, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKey, false, null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "bundle(error)", false, 32, null);
                Continuation continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m2968constructorimpl(Boolean.FALSE));
            }
        };
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Attempting to initialize bundler // bundleVersion =" + configData.getBundleVersion() + ", URL = " + configData.getBundlerURL(), null, 4, null);
        getBundler$OneID_release().initialize(trackerEventKey.getId(), configData.getBundleVersion(), configData.getBundlerURL(), listener);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
