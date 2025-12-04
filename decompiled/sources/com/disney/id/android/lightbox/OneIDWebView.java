package com.disney.id.android.lightbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.disney.id.android.LightboxData;
import com.disney.id.android.NewslettersResult;
import com.disney.id.android.SWID;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.bundler.BundlerCallback;
import com.disney.id.android.bundler.BundlerCallbackData;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u001d3\b\u0001\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020PH\u0016J\b\u0010[\u001a\u00020YH\u0002J\b\u0010\\\u001a\u00020YH\u0016J\b\u0010]\u001a\u00020YH\u0016J\"\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020\rH\u0016J\b\u0010c\u001a\u00020YH\u0016J\u001a\u0010d\u001a\u00020Y2\u0006\u0010e\u001a\u00020=2\b\u0010f\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010g\u001a\u00020Y2\b\u0010h\u001a\u0004\u0018\u00010aH\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020'8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R(\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0014\u001a\u0004\u0018\u0001058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020=\u0012\u0006\u0012\u0004\u0018\u00010>\u0018\u00010<X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020D8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020J8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082.¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/disney/id/android/lightbox/OneIDWebView;", "Landroid/webkit/WebView;", "Lcom/disney/id/android/lightbox/LightboxWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bundle", "Lcom/disney/id/android/bundler/Bundler;", "getBundle$OneID_release", "()Lcom/disney/id/android/bundler/Bundler;", "setBundle$OneID_release", "(Lcom/disney/id/android/bundler/Bundler;)V", "bundleLoaded", "", "getBundleLoaded", "()Z", "setBundleLoaded", "(Z)V", "canBridgeBeInjected", "doesBridgeNeedToBeInjected", "value", "Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;", "holder", "getHolder", "()Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;", "setHolder", "(Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;)V", "isAttachedToActivity", "javascriptExecutor", "com/disney/id/android/lightbox/OneIDWebView$javascriptExecutor$1", "Lcom/disney/id/android/lightbox/OneIDWebView$javascriptExecutor$1;", "lightboxReady", "getLightboxReady", "setLightboxReady", "lightboxReadyTimeoutHandler", "Landroid/os/Handler;", "lightboxReadyTimeoutRunnable", "Ljava/lang/Runnable;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "oneIDStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "getOneIDStorage$OneID_release", "()Lcom/disney/id/android/localdata/ExposedStorage;", "setOneIDStorage$OneID_release", "(Lcom/disney/id/android/localdata/ExposedStorage;)V", "oneIDWVC", "com/disney/id/android/lightbox/OneIDWebView$oneIDWVC$1", "Lcom/disney/id/android/lightbox/OneIDWebView$oneIDWVC$1;", "Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;", "owner", "getOwner", "()Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;", "setOwner", "(Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;)V", "pendingPageAndEvent", "Lkotlin/Pair;", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "getPendingPageAndEvent", "()Lkotlin/Pair;", "setPendingPageAndEvent", "(Lkotlin/Pair;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "userAgent", "", "getUserAgent", "()Ljava/lang/String;", "weakHolder", "Ljava/lang/ref/WeakReference;", "weakOwner", "webViewBridge", "Lcom/disney/id/android/lightbox/WebViewBridge;", "bundleVersion", "", "version", "cancelLightboxReadyTimer", "complete", "initializeBridge", "loadBundle", "appContext", "conversationEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "forceLoadBundle", "setStarterPage", "showPage", "page", "event", "startLightboxReadyTimer", "key", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"SetJavaScriptEnabled, JavascriptInterface"})
@SourceDebugExtension({"SMAP\nOneIDWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDWebView.kt\ncom/disney/id/android/lightbox/OneIDWebView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,630:1\n1#2:631\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDWebView extends WebView implements LightboxWebView {

    @NotNull
    public static final String EXTRA_WEB_VIEW_TAG = "EXTRA_WEBVIEW";

    @NotNull
    public static final String NATIVE_TO_WEB_BRIDGE_NAME = "didNativeToWeb";
    public static final long SHOW_PAGE_REQUEST_CODE = Long.MAX_VALUE;
    public static final long SUPPORTED_BY_WEB_VIEW_COMPACT = -1;

    @NotNull
    public static final String WEB_TO_NATIVE_BRIDGE_NAME = "didWebToNative";

    @Inject
    public Bundler bundle;
    private boolean bundleLoaded;
    private boolean canBridgeBeInjected;
    private boolean doesBridgeNeedToBeInjected;
    private boolean isAttachedToActivity;
    private final OneIDWebView$javascriptExecutor$1 javascriptExecutor;
    private boolean lightboxReady;
    private Handler lightboxReadyTimeoutHandler;
    private Runnable lightboxReadyTimeoutRunnable;

    @Inject
    public Logger logger;

    @Inject
    public ExposedStorage oneIDStorage;
    private final OneIDWebView$oneIDWVC$1 oneIDWVC;
    private Pair pendingPageAndEvent;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private WeakReference weakHolder;
    private WeakReference weakOwner;
    private WebViewBridge webViewBridge;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = OneIDWebView.class.getSimpleName();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.webkit.WebViewClient, com.disney.id.android.lightbox.OneIDWebView$oneIDWVC$1] */
    public OneIDWebView(@NotNull Context context) {
        super(new MutableContextWrapper(context));
        Intrinsics.checkNotNullParameter(context, "context");
        this.doesBridgeNeedToBeInjected = true;
        ?? r0 = new WebViewClient() { // from class: com.disney.id.android.lightbox.OneIDWebView$oneIDWVC$1
            @Override // android.webkit.WebViewClient
            @SuppressLint({"WebViewClientOnReceivedSslError"})
            public void onReceivedSslError(@Nullable WebView view, @Nullable SslErrorHandler handler, @Nullable SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(@NotNull WebView view, @NotNull String url, @Nullable Bitmap favIcon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "WVC // onPageStarted // " + url, null, 4, null);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(@NotNull WebView view, @NotNull String url) {
                InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "WVC // onPageFinished // " + url, null, 4, null);
                this.this$0.canBridgeBeInjected = true;
                this.this$0.initializeBridge();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable WebResourceRequest request) {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "WVC // shouldOverrideUrlLoading // " + (request != null ? request.getUrl() : null), null, 4, null);
                if (view != null) {
                    WebView webView = new WebView(view.getContext());
                    webView.setTag(OneIDWebView.EXTRA_WEB_VIEW_TAG);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    String strValueOf = String.valueOf(request != null ? request.getUrl() : null);
                    InstrumentationCallbacks.loadUrlCalled(webView);
                    webView.loadUrl(strValueOf);
                    ViewParent parent = view.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).addView(webView);
                }
                return true;
            }
        };
        this.oneIDWVC = r0;
        this.javascriptExecutor = new OneIDWebView$javascriptExecutor$1(this);
        OneIDDagger.getComponent().inject(this);
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "webview init", null, 4, null);
        this.lightboxReadyTimeoutHandler = new Handler(Looper.getMainLooper());
        setWebViewClient(r0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(false);
        setBackgroundColor(0);
        setVerticalScrollBarEnabled(false);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.disney.id.android.lightbox.OneIDWebView.5
            private Context originalContext;

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Logger logger$OneID_release2 = OneIDWebView.this.getLogger$OneID_release();
                String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release2, tAG$OneID_release, "detach", null, 4, null);
                OneIDWebView.this.isAttachedToActivity = false;
                Context context2 = v.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.MutableContextWrapper");
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context2;
                Context context3 = this.originalContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("originalContext");
                    context3 = null;
                }
                mutableContextWrapper.setBaseContext(context3);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Logger logger$OneID_release2 = OneIDWebView.this.getLogger$OneID_release();
                String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release2, tAG$OneID_release, "attach", null, 4, null);
                OneIDWebView.this.isAttachedToActivity = true;
                Context context2 = v.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.MutableContextWrapper");
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context2;
                Context baseContext = mutableContextWrapper.getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
                this.originalContext = baseContext;
                ViewParent parent = ((OneIDWebView) v).getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                mutableContextWrapper.setBaseContext(((ViewGroup) parent).getContext());
                OneIDWebView.this.initializeBridge();
            }
        });
        setAlpha(BitmapDescriptorFactory.HUE_RED);
        getTracker$OneID_release().setBrowser(getUserAgent());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/disney/id/android/lightbox/OneIDWebView$Companion;", "", "()V", "EXTRA_WEB_VIEW_TAG", "", "NATIVE_TO_WEB_BRIDGE_NAME", "SHOW_PAGE_REQUEST_CODE", "", "SUPPORTED_BY_WEB_VIEW_COMPACT", "TAG", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "WEB_TO_NATIVE_BRIDGE_NAME", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return OneIDWebView.TAG;
        }
    }

    @NotNull
    public final ExposedStorage getOneIDStorage$OneID_release() {
        ExposedStorage exposedStorage = this.oneIDStorage;
        if (exposedStorage != null) {
            return exposedStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIDStorage");
        return null;
    }

    public final void setOneIDStorage$OneID_release(@NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(exposedStorage, "<set-?>");
        this.oneIDStorage = exposedStorage;
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
    public final Bundler getBundle$OneID_release() {
        Bundler bundler = this.bundle;
        if (bundler != null) {
            return bundler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        return null;
    }

    public final void setBundle$OneID_release(@NotNull Bundler bundler) {
        Intrinsics.checkNotNullParameter(bundler, "<set-?>");
        this.bundle = bundler;
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

    @Override // com.disney.id.android.lightbox.LightboxWebView
    @NotNull
    public String getUserAgent() {
        String userAgentString = getSettings().getUserAgentString();
        Intrinsics.checkNotNullExpressionValue(userAgentString, "getUserAgentString(...)");
        return userAgentString;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    @Nullable
    public LightboxWebView.WebViewHolder getHolder() {
        WeakReference weakReference = this.weakHolder;
        if (weakReference != null) {
            return (LightboxWebView.WebViewHolder) weakReference.get();
        }
        return null;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void setHolder(@Nullable LightboxWebView.WebViewHolder webViewHolder) {
        this.weakHolder = webViewHolder != null ? new WeakReference(webViewHolder) : null;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    @Nullable
    public LightboxWebView.WebViewOwner getOwner() {
        WeakReference weakReference = this.weakOwner;
        if (weakReference != null) {
            return (LightboxWebView.WebViewOwner) weakReference.get();
        }
        return null;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void setOwner(@Nullable LightboxWebView.WebViewOwner webViewOwner) {
        this.weakOwner = webViewOwner != null ? new WeakReference(webViewOwner) : null;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public boolean getBundleLoaded() {
        return this.bundleLoaded;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void setBundleLoaded(boolean z) {
        this.bundleLoaded = z;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public boolean getLightboxReady() {
        return this.lightboxReady;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void setLightboxReady(boolean z) {
        this.lightboxReady = z;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    @Nullable
    public Pair<LightboxWebView.LightboxPage, OneIDTrackerEvent> getPendingPageAndEvent() {
        return this.pendingPageAndEvent;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void setPendingPageAndEvent(@Nullable Pair<? extends LightboxWebView.LightboxPage, OneIDTrackerEvent> pair) {
        this.pendingPageAndEvent = pair;
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void bundleVersion(@NotNull String version) {
        String bundleVersion;
        Intrinsics.checkNotNullParameter(version, "version");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "WebView told to use version " + version, null, 4, null);
        WebViewBridge webViewBridge = this.webViewBridge;
        if (webViewBridge != null) {
            if (webViewBridge == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge = null;
            }
            bundleVersion = webViewBridge.getBundleVersion();
        } else {
            bundleVersion = "";
        }
        if (Intrinsics.areEqual(bundleVersion, version)) {
            return;
        }
        setBundleLoaded(false);
        setLightboxReady(false);
        this.webViewBridge = Intrinsics.areEqual(version, "v2") ? new WebViewBridgeV2(this, this.javascriptExecutor) : new WebViewBridgeV4(this, this.javascriptExecutor);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.disney.id.android.lightbox.OneIDWebView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OneIDWebView.bundleVersion$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bundleVersion$lambda$4(OneIDWebView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WebViewBridge webViewBridge = this$0.webViewBridge;
        if (webViewBridge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
            webViewBridge = null;
        }
        this$0.addJavascriptInterface(webViewBridge, WEB_TO_NATIVE_BRIDGE_NAME);
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public boolean loadBundle(@NotNull Context appContext, @Nullable TrackerEventKey conversationEventKey, boolean forceLoadBundle) {
        OneIDTrackerEvent event;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationEventKey != null ? conversationEventKey.getId() : null, EventAction.LOG_GET_BUNDLE, getSwid$OneID_release().get(), null, null, 24, null);
        if (forceLoadBundle && (event = getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default)) != null) {
            event.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BUNDLE_LOAD_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "bundle(forceloadsuccess" + getBundleLoaded() + ")");
        }
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Loading bundle", null, 4, null);
        getBundle$OneID_release().getBundle(trackerEventKeyStartTransactionEvent$default, new BundlerCallback<BundlerCallbackData>() { // from class: com.disney.id.android.lightbox.OneIDWebView.loadBundle.2
            @Override // com.disney.id.android.bundler.BundlerCallback
            public void onSuccess(@NotNull BundlerCallbackData data) {
                Unit unit;
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDWebView.this.doesBridgeNeedToBeInjected = true;
                String bundleString = data.getBundleString();
                if (bundleString != null) {
                    OneIDWebView oneIDWebView = OneIDWebView.this;
                    String bundlerURL = data.getBundlerURL();
                    InstrumentationCallbacks.loadUrlCalled(oneIDWebView);
                    oneIDWebView.loadDataWithBaseURL(bundlerURL, bundleString, Mimetypes.MIMETYPE_HTML, "UTF-8", null);
                    oneIDWebView.setBundleLoaded(true);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    OneIDWebView oneIDWebView2 = OneIDWebView.this;
                    oneIDWebView2.setBundleLoaded(false);
                    Logger logger$OneID_release2 = oneIDWebView2.getLogger$OneID_release();
                    String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                    Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                    Logger.DefaultImpls.e$default(logger$OneID_release2, tAG$OneID_release, "loadBundle called with null bundleString", null, 4, null);
                }
                Tracker.DefaultImpls.finishEvent$default(OneIDWebView.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
            }

            @Override // com.disney.id.android.bundler.BundlerCallback
            public void onFailure(@NotNull BundlerCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Logger logger$OneID_release2 = OneIDWebView.this.getLogger$OneID_release();
                String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
                Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
                Logger.DefaultImpls.e$default(logger$OneID_release2, tAG$OneID_release, "Failed to load the bundle: " + data.getError(), null, 4, null);
                OneIDWebView.this.setBundleLoaded(false);
            }
        });
        setLightboxReady(false);
        return getBundleLoaded();
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void initializeBridge() {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "initializing bridge // attached = " + this.isAttachedToActivity + ", can = " + this.canBridgeBeInjected + ", need = " + this.doesBridgeNeedToBeInjected, null, 4, null);
        if (this.isAttachedToActivity && this.canBridgeBeInjected && this.doesBridgeNeedToBeInjected) {
            this.doesBridgeNeedToBeInjected = false;
            WebViewBridge webViewBridge = this.webViewBridge;
            if (webViewBridge == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge = null;
            }
            webViewBridge.bridgeInjected();
            Logger logger$OneID_release2 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release2, TAG2, "bridge injected", null, 4, null);
        }
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void showPage(@NotNull LightboxWebView.LightboxPage page, @Nullable final OneIDTrackerEvent event) {
        Intrinsics.checkNotNullParameter(page, "page");
        setAlpha(BitmapDescriptorFactory.HUE_RED);
        LightboxWebView.WebViewHolder holder = getHolder();
        if (holder != null) {
            holder.showLoader();
        }
        WebViewBridge webViewBridge = null;
        if (getLightboxReady()) {
            setPendingPageAndEvent(null);
            if (LightboxWebView.LightboxPage.NEWSLETTERS == page) {
                WebViewBridge webViewBridge2 = this.webViewBridge;
                if (webViewBridge2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                    webViewBridge2 = null;
                }
                webViewBridge2.addLightboxEvent(WebToNativeBridgeBase.LIGHTBOX_EVENT_OPT_IN_SUCCESS);
                WebViewBridge webViewBridge3 = this.webViewBridge;
                if (webViewBridge3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                    webViewBridge3 = null;
                }
                webViewBridge3.setNewslettersResult(new NewslettersResult(CollectionsKt.listOf("")));
            }
            WebViewBridge webViewBridge4 = this.webViewBridge;
            if (webViewBridge4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
            } else {
                webViewBridge = webViewBridge4;
            }
            webViewBridge.showPage(page, event);
            if (WebViewFeature.isFeatureSupported("VISUAL_STATE_CALLBACK")) {
                WebViewCompat.postVisualStateCallback(this, Long.MAX_VALUE, new WebViewCompat.VisualStateCallback() { // from class: com.disney.id.android.lightbox.OneIDWebView$$ExternalSyntheticLambda2
                    @Override // androidx.webkit.WebViewCompat.VisualStateCallback
                    public final void onComplete(long j) {
                        OneIDWebView.showPage$lambda$6(this.f$0, event, j);
                    }
                });
                return;
            }
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.i$default(logger$OneID_release, TAG2, "No visual state callback", null, 4, null);
            animate().alpha(1.0f).setDuration(250L);
            return;
        }
        Logger logger$OneID_release2 = getLogger$OneID_release();
        String TAG3 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        Logger.DefaultImpls.i$default(logger$OneID_release2, TAG3, "Lightbox not initialized", null, 4, null);
        cancelLightboxReadyTimer();
        setPendingPageAndEvent(new Pair<>(page, event));
        startLightboxReadyTimer(event != null ? event.getKey$OneID_release() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPage$lambda$6(OneIDWebView this$0, OneIDTrackerEvent oneIDTrackerEvent, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j == Long.MAX_VALUE || j == -1) {
            this$0.animate().alpha(1.0f).setDuration(250L);
            return;
        }
        Logger logger$OneID_release = this$0.getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.wtf$default(logger$OneID_release, TAG2, "VisualStateCallback return code has unexpected value " + j, null, 4, null);
        if (oneIDTrackerEvent != null) {
            oneIDTrackerEvent.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BROWSER_LAUNCH_FAILURE, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "error(unexpectedcode" + j + ")");
        }
    }

    private final void startLightboxReadyTimer(final TrackerEventKey key) {
        Runnable runnable = new Runnable() { // from class: com.disney.id.android.lightbox.OneIDWebView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                OneIDWebView.startLightboxReadyTimer$lambda$7(this.f$0, key);
            }
        };
        this.lightboxReadyTimeoutRunnable = runnable;
        Handler handler = this.lightboxReadyTimeoutHandler;
        if (handler != null) {
            handler.postDelayed(runnable, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLightboxReadyTimer$lambda$7(OneIDWebView this$0, TrackerEventKey trackerEventKey) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getPendingPageAndEvent() != null) {
            Logger logger$OneID_release = this$0.getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "LightboxReadyTimer expired. About to force load bundle.", null, 4, null);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this$0.loadBundle(context, trackerEventKey, true);
            return;
        }
        this$0.cancelLightboxReadyTimer();
    }

    private final void cancelLightboxReadyTimer() {
        Handler handler;
        Runnable runnable = this.lightboxReadyTimeoutRunnable;
        if (runnable == null || (handler = this.lightboxReadyTimeoutHandler) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void complete() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Map<String, Object> updateProfileDelta;
        NewslettersResult newslettersResult;
        String str;
        WebViewBridge webViewBridge = null;
        if (getLightboxReady()) {
            WebViewBridge webViewBridge2 = this.webViewBridge;
            if (webViewBridge2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge2 = null;
            }
            boolean didReauth = webViewBridge2.getDidReauth();
            WebViewBridge webViewBridge3 = this.webViewBridge;
            if (webViewBridge3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge3 = null;
            }
            boolean didLogout = webViewBridge3.getDidLogout();
            WebViewBridge webViewBridge4 = this.webViewBridge;
            if (webViewBridge4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge4 = null;
            }
            NewslettersResult newslettersResult2 = webViewBridge4.getNewslettersResult();
            WebViewBridge webViewBridge5 = this.webViewBridge;
            if (webViewBridge5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge5 = null;
            }
            String emailVerificationErrorCode = webViewBridge5.getEmailVerificationErrorCode();
            WebViewBridge webViewBridge6 = this.webViewBridge;
            if (webViewBridge6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge6 = null;
            }
            boolean successful = true ^ webViewBridge6.getSuccessful();
            WebViewBridge webViewBridge7 = this.webViewBridge;
            if (webViewBridge7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge7 = null;
            }
            boolean accountCreated = webViewBridge7.getAccountCreated();
            WebViewBridge webViewBridge8 = this.webViewBridge;
            if (webViewBridge8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge8 = null;
            }
            updateProfileDelta = webViewBridge8.getUpdateProfileDelta();
            WebViewBridge webViewBridge9 = this.webViewBridge;
            if (webViewBridge9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
                webViewBridge9 = null;
            }
            boolean accountDeleted = webViewBridge9.getAccountDeleted();
            WebViewBridge webViewBridge10 = this.webViewBridge;
            if (webViewBridge10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewBridge");
            } else {
                webViewBridge = webViewBridge10;
            }
            webViewBridge.clearLightboxEvents();
            str = emailVerificationErrorCode;
            z4 = accountDeleted;
            z2 = didReauth;
            newslettersResult = newslettersResult2;
            z = accountCreated;
            z3 = didLogout;
            z5 = successful;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = true;
            updateProfileDelta = null;
            newslettersResult = null;
            str = null;
        }
        LightboxWebView.WebViewOwner owner = getOwner();
        if (owner != null) {
            owner.lightboxComplete(new LightboxData(z5, z, z2, z3, updateProfileDelta, newslettersResult, str, z4));
        }
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView
    public void setStarterPage() {
        final Pair<LightboxWebView.LightboxPage, OneIDTrackerEvent> pendingPageAndEvent = getPendingPageAndEvent();
        if (pendingPageAndEvent != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.disney.id.android.lightbox.OneIDWebView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    OneIDWebView.setStarterPage$lambda$11$lambda$10(this.f$0, pendingPageAndEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStarterPage$lambda$11$lambda$10(OneIDWebView this$0, Pair pending) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pending, "$pending");
        Logger logger$OneID_release = this$0.getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "showing a pending event", null, 4, null);
        this$0.showPage((LightboxWebView.LightboxPage) pending.getFirst(), (OneIDTrackerEvent) pending.getSecond());
    }
}
