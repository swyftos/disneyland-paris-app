package com.disney.id.android.lightbox;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.disney.id.android.Config;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.OneID;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.SWID;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.databinding.ActivityLightboxBinding;
import com.disney.id.android.lightbox.BrowserPromptDialog;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.facebook.react.uimanager.ViewProps;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0010\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0012\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020,H\u0014J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0005H\u0002J\b\u0010;\u001a\u00020,H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/disney/id/android/lightbox/LightboxActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;", "()V", "baseUiState", "", "binding", "Lcom/disney/id/android/databinding/ActivityLightboxBinding;", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "preventBack", "", "statusBarHeight", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "webView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "webViewFactory", "Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "getWebViewFactory$OneID_release", "()Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "setWebViewFactory$OneID_release", "(Lcom/disney/id/android/lightbox/OneIDWebViewFactory;)V", "complete", "", "finish", "hideLoader", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "openUrl", "url", "", "setCloseBehavior", "showBack", "setLayoutTopMargin", ViewProps.MARGIN, "showLoader", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLightboxActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LightboxActivity.kt\ncom/disney/id/android/lightbox/LightboxActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n1#2:354\n*E\n"})
/* loaded from: classes3.dex */
public class LightboxActivity extends AppCompatActivity implements LightboxWebView.WebViewHolder {

    @NotNull
    public static final String ACTION_NAME_EXTRA = "actionName";

    @NotNull
    public static final String CONFIGS_EXTRA = "optionalConfigs";

    @NotNull
    public static final String EVENT_ID_EXTRA = "eventId";

    @NotNull
    public static final String PAGE_EXTRA = "page";
    public static final float STANDARD_BACKGROUND_DIM_AMOUNT = 0.45f;

    @NotNull
    public static final String UI_VERSION_EXTRA = "uiVersion";
    private int baseUiState;
    private ActivityLightboxBinding binding;

    @Inject
    public ConfigHandler configHandler;

    @Inject
    public Logger logger;
    private boolean preventBack;
    private int statusBarHeight;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private LightboxWebView webView;

    @Inject
    public OneIDWebViewFactory webViewFactory;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = LightboxActivity.class.getSimpleName();
    private static final AtomicBoolean isPresenting = new AtomicBoolean(false);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public LightboxActivity() {
        OneIDDagger.getComponent().inject(this);
        LightboxWebView lightboxWebView = null;
        LightboxWebView oneIDWebView$default = OneIDWebViewFactory.getOneIDWebView$default(getWebViewFactory$OneID_release(), null, 1, null);
        if (oneIDWebView$default == null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Unable to get webView", null, 4, null);
        } else {
            lightboxWebView = oneIDWebView$default;
        }
        this.webView = lightboxWebView;
        this.statusBarHeight = -1;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/disney/id/android/lightbox/LightboxActivity$Companion;", "", "()V", "ACTION_NAME_EXTRA", "", "CONFIGS_EXTRA", "EVENT_ID_EXTRA", "PAGE_EXTRA", "STANDARD_BACKGROUND_DIM_AMOUNT", "", "TAG", "kotlin.jvm.PlatformType", "UI_VERSION_EXTRA", "isPresenting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPresenting$OneID_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AtomicBoolean isPresenting$OneID_release() {
            return LightboxActivity.isPresenting;
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

    @NotNull
    public final ConfigHandler getConfigHandler$OneID_release() {
        ConfigHandler configHandler = this.configHandler;
        if (configHandler != null) {
            return configHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configHandler");
        return null;
    }

    public final void setConfigHandler$OneID_release(@NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(configHandler, "<set-?>");
        this.configHandler = configHandler;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        OneIDTrackerEvent event;
        OptionalConfigs optionalConfigs;
        String str;
        String string;
        String string2;
        String string3;
        Bundle extras;
        String string4;
        InstrumentationCallbacks.onCreateCalled(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(0, 0, 0);
        } else {
            overridePendingTransition(0, 0);
        }
        Config config = getConfigHandler$OneID_release().get();
        if (config.getLogLevel().compareTo(OneID.LogLevel.DEBUG) < 0 && OneID.Environment.PROD == config.getEnvironment()) {
            getWindow().setFlags(8192, 8192);
        }
        ActivityLightboxBinding activityLightboxBindingInflate = ActivityLightboxBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityLightboxBindingInflate, "inflate(...)");
        this.binding = activityLightboxBindingInflate;
        if (activityLightboxBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBindingInflate = null;
        }
        setContentView(activityLightboxBindingInflate.getRoot());
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "adding webview", null, 4, null);
        LightboxWebView lightboxWebView = this.webView;
        if (lightboxWebView != null) {
            lightboxWebView.setHolder(this);
        }
        ActivityLightboxBinding activityLightboxBinding = this.binding;
        if (activityLightboxBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding = null;
        }
        this.baseUiState = activityLightboxBinding.oneidLightbox.getSystemUiVisibility();
        ActivityLightboxBinding activityLightboxBinding2 = this.binding;
        if (activityLightboxBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding2 = null;
        }
        activityLightboxBinding2.oneidLightbox.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.disney.id.android.lightbox.LightboxActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return LightboxActivity.onCreate$lambda$1(this.f$0, view, windowInsets);
            }
        });
        Bundle extras2 = getIntent().getExtras();
        if (extras2 == null || (string3 = extras2.getString(EVENT_ID_EXTRA)) == null || (extras = getIntent().getExtras()) == null || (string4 = extras.getString(ACTION_NAME_EXTRA)) == null) {
            event = null;
        } else {
            Tracker tracker$OneID_release = getTracker$OneID_release();
            Intrinsics.checkNotNull(string4);
            event = tracker$OneID_release.getEvent(new TrackerEventKey(string3, string4));
        }
        if (event == null) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release2, TAG2, "Lightbox launched without a tracking event active", null, 4, null);
        }
        Object obj = this.webView;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.webkit.WebView");
        ViewParent parent = ((WebView) obj).getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ViewGroup viewGroup2 = viewGroup;
            Logger.DefaultImpls.w$default(logger$OneID_release3, TAG2, "Webview not detached from previous parent.  Detaching on this activity start.", null, 4, null);
            if (event != null) {
                OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "webviewStillAttached(true)", 3, null);
                Context context = viewGroup2.getContext();
                LightboxActivity lightboxActivity = context instanceof LightboxActivity ? (LightboxActivity) context : null;
                if (lightboxActivity != null) {
                    Bundle extras3 = lightboxActivity.getIntent().getExtras();
                    if (extras3 == null || (string2 = extras3.getString(EVENT_ID_EXTRA)) == null) {
                        str = ")";
                    } else {
                        str = ")";
                        OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "previousEvent(" + string2 + ")", 3, null);
                    }
                    Bundle extras4 = lightboxActivity.getIntent().getExtras();
                    if (extras4 != null && (string = extras4.getString(ACTION_NAME_EXTRA)) != null) {
                        OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "previousAction(" + string + str, 3, null);
                    }
                }
            }
            Object obj2 = this.webView;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            viewGroup2.removeView((WebView) obj2);
        }
        ActivityLightboxBinding activityLightboxBinding3 = this.binding;
        if (activityLightboxBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding3 = null;
        }
        FrameLayout frameLayout = activityLightboxBinding3.oneidLightbox;
        Object obj3 = this.webView;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.webkit.WebView");
        frameLayout.addView((WebView) obj3);
        ActivityLightboxBinding activityLightboxBinding4 = this.binding;
        if (activityLightboxBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding4 = null;
        }
        activityLightboxBinding4.oneidLoaderView.bringToFront();
        Bundle extras5 = getIntent().getExtras();
        if (((String) (extras5 != null ? extras5.get(UI_VERSION_EXTRA) : null)) != null) {
            ActivityLightboxBinding activityLightboxBinding5 = this.binding;
            if (activityLightboxBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLightboxBinding5 = null;
            }
            activityLightboxBinding5.forceVersionMessage.bringToFront();
            ActivityLightboxBinding activityLightboxBinding6 = this.binding;
            if (activityLightboxBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLightboxBinding6 = null;
            }
            activityLightboxBinding6.forceVersionMessage.setVisibility(0);
            Logger logger$OneID_release4 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release4, TAG2, "UI version has been overridden. \nPlease remove forceUIVersion metadata before shipping your app. \nforceUIVersion metadata can be found in app manifest xml.", null, 4, null);
        }
        Bundle extras6 = getIntent().getExtras();
        LightboxWebView.LightboxPage lightboxPage = (LightboxWebView.LightboxPage) (extras6 != null ? extras6.get("page") : null);
        if (lightboxPage == null) {
            throw new IllegalArgumentException("Page must be provided");
        }
        Bundle extras7 = getIntent().getExtras();
        if (extras7 != null) {
            optionalConfigs = null;
            String string5 = extras7.getString(CONFIGS_EXTRA, null);
            if (string5 != null) {
                optionalConfigs = new OptionalConfigs(new JSONObject(string5));
            }
        } else {
            optionalConfigs = null;
        }
        lightboxPage.setOptionalConfigs(optionalConfigs);
        LightboxWebView lightboxWebView2 = this.webView;
        if (lightboxWebView2 != null) {
            lightboxWebView2.showPage(lightboxPage, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onCreate$lambda$1(LightboxActivity this$0, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (this$0.statusBarHeight == -1) {
            this$0.setLayoutTopMargin(insets.getSystemWindowInsetTop());
        }
        this$0.statusBarHeight = insets.getSystemWindowInsetTop();
        return insets;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ActivityLightboxBinding activityLightboxBinding = this.binding;
        ActivityLightboxBinding activityLightboxBinding2 = null;
        if (activityLightboxBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding = null;
        }
        WebView webView = (WebView) activityLightboxBinding.oneidLightbox.findViewWithTag(OneIDWebView.EXTRA_WEB_VIEW_TAG);
        if (webView != null) {
            ActivityLightboxBinding activityLightboxBinding3 = this.binding;
            if (activityLightboxBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityLightboxBinding2 = activityLightboxBinding3;
            }
            activityLightboxBinding2.oneidLightbox.removeView(webView);
            InstrumentationCallbacks.loadUrlCalled(webView);
            webView.loadUrl("about:blank");
            return;
        }
        if (this.preventBack) {
            return;
        }
        LightboxWebView lightboxWebView = this.webView;
        if (lightboxWebView != null) {
            lightboxWebView.complete();
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        LightboxWebView lightboxWebView = this.webView;
        if (lightboxWebView != null) {
            LightboxWebView.DefaultImpls.showPage$default(lightboxWebView, LightboxWebView.LightboxPage.READY, null, 2, null);
        }
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "removing webview", null, 4, null);
        ActivityLightboxBinding activityLightboxBinding = this.binding;
        if (activityLightboxBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding = null;
        }
        FrameLayout frameLayout = activityLightboxBinding.oneidLightbox;
        Object obj = this.webView;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.webkit.WebView");
        frameLayout.removeView((WebView) obj);
        LightboxWebView lightboxWebView2 = this.webView;
        if (lightboxWebView2 != null) {
            lightboxWebView2.setHolder(null);
        }
        super.onDestroy();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C08921(null), 3, null);
    }

    /* renamed from: com.disney.id.android.lightbox.LightboxActivity$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    static final class C08921 extends SuspendLambda implements Function2 {
        int label;

        C08921(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LightboxActivity.this.new C08921(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C08921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LightboxActivity.this.runOnUiThread(new Runnable() { // from class: com.disney.id.android.lightbox.LightboxActivity$onDestroy$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LightboxActivity.C08921.invokeSuspend$lambda$0();
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0() {
            LightboxActivity.INSTANCE.isPresenting$OneID_release().set(false);
        }
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewHolder
    public void showLoader() {
        ActivityLightboxBinding activityLightboxBinding = this.binding;
        if (activityLightboxBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding = null;
        }
        activityLightboxBinding.oneidLoaderView.setVisibility(0);
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewHolder
    public void hideLoader() {
        ActivityLightboxBinding activityLightboxBinding = this.binding;
        if (activityLightboxBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding = null;
        }
        activityLightboxBinding.oneidLoaderView.setVisibility(4);
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewHolder
    public void setCloseBehavior(boolean showBack, boolean preventBack) {
        this.preventBack = preventBack;
        ActivityLightboxBinding activityLightboxBinding = null;
        if (showBack) {
            ActivityLightboxBinding activityLightboxBinding2 = this.binding;
            if (activityLightboxBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityLightboxBinding = activityLightboxBinding2;
            }
            activityLightboxBinding.oneidLightbox.setSystemUiVisibility(this.baseUiState);
            setLayoutTopMargin(0);
            return;
        }
        ActivityLightboxBinding activityLightboxBinding3 = this.binding;
        if (activityLightboxBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLightboxBinding = activityLightboxBinding3;
        }
        activityLightboxBinding.oneidLightbox.setSystemUiVisibility(2818);
        setLayoutTopMargin(this.statusBarHeight);
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewHolder
    public void openUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.EVENT_EXTERNAL_LINK, getSwid$OneID_release().get(), "url(" + url + ")", null, 17, null);
        final Uri uri = Uri.parse(url);
        BrowserPromptDialog.Companion companion = BrowserPromptDialog.INSTANCE;
        Intrinsics.checkNotNull(uri);
        companion.getDialog(uri, new BrowserPromptDialog.BrowserPromptListener() { // from class: com.disney.id.android.lightbox.LightboxActivity$openUrl$promptDialog$1
            @Override // com.disney.id.android.lightbox.BrowserPromptDialog.BrowserPromptListener
            public void onApprove() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.setFlags(268435456);
                    this.startActivity(intent);
                    Tracker.DefaultImpls.finishEvent$default(this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                } catch (ActivityNotFoundException e) {
                    Logger logger$OneID_release = this.getLogger$OneID_release();
                    String str = LightboxActivity.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    logger$OneID_release.wtf(str, "Failed to open URL.", e);
                    OneIDTrackerEvent event = this.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                    if (event != null) {
                        event.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BROWSER_LAUNCH_FAILURE, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, e.getMessage());
                    }
                    Tracker.DefaultImpls.finishEvent$default(this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                }
            }

            @Override // com.disney.id.android.lightbox.BrowserPromptDialog.BrowserPromptListener
            public void onDeny() {
                OneIDTrackerEvent event = this.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                if (event != null) {
                    event.appendCodes$OneID_release("USER_CANCELLED", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null);
                }
                Tracker.DefaultImpls.finishEvent$default(this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            }
        }).show(getSupportFragmentManager(), "BPD");
    }

    private final void setLayoutTopMargin(int margin) {
        ActivityLightboxBinding activityLightboxBinding = this.binding;
        ActivityLightboxBinding activityLightboxBinding2 = null;
        if (activityLightboxBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLightboxBinding = null;
        }
        ViewGroup.LayoutParams layoutParams = activityLightboxBinding.oneidLightbox.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = margin;
        ActivityLightboxBinding activityLightboxBinding3 = this.binding;
        if (activityLightboxBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLightboxBinding2 = activityLightboxBinding3;
        }
        activityLightboxBinding2.oneidLightbox.setLayoutParams(layoutParams2);
    }

    @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewHolder
    public void complete() {
        finish();
    }

    /* renamed from: com.disney.id.android.lightbox.LightboxActivity$finish$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LightboxActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LightboxActivity.super.finish();
                if (Build.VERSION.SDK_INT >= 34) {
                    LightboxActivity.this.overrideActivityTransition(1, 0, 0);
                } else {
                    LightboxActivity.this.overridePendingTransition(0, 0);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null))), null, null, new AnonymousClass1(null), 3, null);
    }
}
