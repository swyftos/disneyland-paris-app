package com.disney.id.android.lightbox;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.autofill.HintConstants;
import com.disney.id.android.BiometricSupport;
import com.disney.id.android.NewslettersResult;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.SCALPController;
import com.disney.id.android.SWID;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.utils.GsonUtils;
import com.disney.id.android.utils.StringPatterns;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.urbanairship.reactnative.ReactMessageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u001dJ\u0016\u0010f\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001d2\u0006\u0010h\u001a\u00020\u001dJ\u0006\u0010i\u001a\u00020dJ\u0006\u0010j\u001a\u00020dJ\u0006\u0010k\u001a\u00020dJ\u000e\u0010l\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020dJ\u0006\u0010n\u001a\u00020dJ\u0006\u0010o\u001a\u00020dJ\u0010\u0010p\u001a\u00020d2\b\u0010q\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010r\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001dJ\u000e\u0010s\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001dJ\u0006\u0010t\u001a\u00020dJ\u0006\u0010u\u001a\u00020dJ\u0016\u0010v\u001a\u00020d2\u0006\u0010w\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u001dJ\u000e\u0010y\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001dJ\u0006\u0010z\u001a\u00020dJ\u001e\u0010{\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010}\u001a\u00020\u001dJ\u0017\u0010~\u001a\u00020d2\u0006\u0010\u007f\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\bJ\u000f\u0010\u0081\u0001\u001a\u00020d2\u0006\u0010g\u001a\u00020\u001dJ\u0010\u0010\u0082\u0001\u001a\u00020d2\u0007\u0010\u0083\u0001\u001a\u00020\bJ5\u0010\u0084\u0001\u001a\u00020d2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\t\u0010e\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010}\u001a\u00020\u001d2\u0007\u0010\u0088\u0001\u001a\u00020\u001dJ\u0014\u0010\u0089\u0001\u001a\u00020d2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\u001b\u0010\u008b\u0001\u001a\u00020d2\u0007\u0010\u008c\u0001\u001a\u00020\u001d2\t\b\u0002\u0010\u008d\u0001\u001a\u00020\bR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0011\u0010 \u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b!\u0010\nR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020,8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bD\u0010\nR\u001e\u0010E\u001a\u00020F8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020X8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008f\u0001"}, d2 = {"Lcom/disney/id/android/lightbox/WebToNativeBridgeBase;", "", "webView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "javascriptExecutor", "Lcom/disney/id/android/lightbox/JavascriptExecutor;", "(Lcom/disney/id/android/lightbox/LightboxWebView;Lcom/disney/id/android/lightbox/JavascriptExecutor;)V", "accountCreated", "", "getAccountCreated", "()Z", "accountDeleted", "getAccountDeleted", "setAccountDeleted", "(Z)V", "appContext", "Landroid/content/Context;", "getAppContext$OneID_release", "()Landroid/content/Context;", "setAppContext$OneID_release", "(Landroid/content/Context;)V", "biometrics", "Lcom/disney/id/android/BiometricSupport;", "getBiometrics$OneID_release", "()Lcom/disney/id/android/BiometricSupport;", "setBiometrics$OneID_release", "(Lcom/disney/id/android/BiometricSupport;)V", "currentLightboxEvents", "", "", "didLogout", "getDidLogout", "didReauth", "getDidReauth", "emailVerificationErrorCode", "getEmailVerificationErrorCode", "()Ljava/lang/String;", "setEmailVerificationErrorCode", "(Ljava/lang/String;)V", "gson", "Lcom/google/gson/Gson;", "getGson$OneID_release", "()Lcom/google/gson/Gson;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "newslettersResult", "Lcom/disney/id/android/NewslettersResult;", "getNewslettersResult", "()Lcom/disney/id/android/NewslettersResult;", "setNewslettersResult", "(Lcom/disney/id/android/NewslettersResult;)V", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "successful", "getSuccessful", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "timeoutHandler", "Landroid/os/Handler;", "getTimeoutHandler$OneID_release", "()Landroid/os/Handler;", "setTimeoutHandler$OneID_release", "(Landroid/os/Handler;)V", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable$OneID_release", "()Ljava/lang/Runnable;", "setTimeoutRunnable$OneID_release", "(Ljava/lang/Runnable;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "updateProfileDelta", "", "getUpdateProfileDelta", "()Ljava/util/Map;", "setUpdateProfileDelta", "(Ljava/util/Map;)V", "addLightboxEvent", "", "event", "biometricCheck", "jsonBody", "stateKeyToUse", "bridgeInjected", "bridgeReady", "cancelLaunchTimer", "clearData", "clearLighboxEvents", ReactMessageView.EVENT_CLOSE, "createSuccess", "emailVerificationComplete", "status", "getConfig", "getData", "loginSuccess", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "openUrl", "url", "options", "optInSuccess", "reauthSuccess", "sendLogs", "eventIdNameConversationId", "eventIdNameTransactionId", "setCloseBehavior", "showCloseButton", "stopCloseEvent", "setData", "showLoader", "show", "showPage", "page", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "bundleVersion", "startLaunchTimer", "conversationId", "updateSuccess", "data", "deleted", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWebToNativeBridgeBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebToNativeBridgeBase.kt\ncom/disney/id/android/lightbox/WebToNativeBridgeBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,574:1\n1855#2,2:575\n1855#2,2:579\n215#3,2:577\n*S KotlinDebug\n*F\n+ 1 WebToNativeBridgeBase.kt\ncom/disney/id/android/lightbox/WebToNativeBridgeBase\n*L\n228#1:575,2\n356#1:579,2\n249#1:577,2\n*E\n"})
/* loaded from: classes3.dex */
public final class WebToNativeBridgeBase {
    public static final int CLOSE_WAIT_ATTEMPTS = 20;
    public static final long CLOSE_WAIT_DURATION_MILLISECONDS = 100;

    @NotNull
    public static final String LIGHTBOX_EVENT_EMAIL_VERIFICATION = "email-verification";

    @NotNull
    public static final String LIGHTBOX_EVENT_LOGIN_SUCCESS = "login-success";

    @NotNull
    public static final String LIGHTBOX_EVENT_LOGOUT = "logout";

    @NotNull
    public static final String LIGHTBOX_EVENT_OPT_IN_SUCCESS = "marketing-opt-in-success";

    @NotNull
    public static final String LIGHTBOX_EVENT_REAUTH_SUCCESS = "reauth-success";

    @NotNull
    public static final String LIGHTBOX_EVENT_REGISTER_SUCCESS = "register-success";

    @NotNull
    public static final String LIGHTBOX_EVENT_UPDATE_PROFILE_SUCCESS = "update-profile-success";
    public static final long LIGHTBOX_TIMEOUT = 10000;
    private boolean accountDeleted;

    @Inject
    public Context appContext;

    @Inject
    public BiometricSupport biometrics;
    private final List currentLightboxEvents;
    private String emailVerificationErrorCode;
    private final Gson gson;
    private final JavascriptExecutor javascriptExecutor;

    @Inject
    public Logger logger;
    private NewslettersResult newslettersResult;

    @Inject
    public SCALPController scalpController;

    @Inject
    public LocalStorage storage;

    @Inject
    public SWID swid;
    private Handler timeoutHandler;
    private Runnable timeoutRunnable;

    @Inject
    public Tracker tracker;
    private Map updateProfileDelta;
    private final LightboxWebView webView;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = WebToNativeBridgeBase.class.getSimpleName();

    public WebToNativeBridgeBase(@NotNull LightboxWebView webView, @NotNull JavascriptExecutor javascriptExecutor) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(javascriptExecutor, "javascriptExecutor");
        this.webView = webView;
        this.javascriptExecutor = javascriptExecutor;
        this.currentLightboxEvents = new ArrayList();
        OneIDDagger.getComponent().inject(this);
        this.timeoutHandler = new Handler(Looper.getMainLooper());
        this.gson = GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null);
    }

    public final boolean getAccountDeleted() {
        return this.accountDeleted;
    }

    public final void setAccountDeleted(boolean z) {
        this.accountDeleted = z;
    }

    @Nullable
    public final Map<String, Object> getUpdateProfileDelta() {
        return this.updateProfileDelta;
    }

    public final void setUpdateProfileDelta(@Nullable Map<String, ? extends Object> map) {
        this.updateProfileDelta = map;
    }

    @Nullable
    public final NewslettersResult getNewslettersResult() {
        return this.newslettersResult;
    }

    public final void setNewslettersResult(@Nullable NewslettersResult newslettersResult) {
        this.newslettersResult = newslettersResult;
    }

    @Nullable
    public final String getEmailVerificationErrorCode() {
        return this.emailVerificationErrorCode;
    }

    public final void setEmailVerificationErrorCode(@Nullable String str) {
        this.emailVerificationErrorCode = str;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\b0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/disney/id/android/lightbox/WebToNativeBridgeBase$Companion;", "", "()V", "CLOSE_WAIT_ATTEMPTS", "", "CLOSE_WAIT_DURATION_MILLISECONDS", "", "LIGHTBOX_EVENT_EMAIL_VERIFICATION", "", "LIGHTBOX_EVENT_LOGIN_SUCCESS", "LIGHTBOX_EVENT_LOGOUT", "LIGHTBOX_EVENT_OPT_IN_SUCCESS", "LIGHTBOX_EVENT_REAUTH_SUCCESS", "LIGHTBOX_EVENT_REGISTER_SUCCESS", "LIGHTBOX_EVENT_UPDATE_PROFILE_SUCCESS", "LIGHTBOX_TIMEOUT", "TAG", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return WebToNativeBridgeBase.TAG;
        }
    }

    public final boolean getSuccessful() {
        return this.currentLightboxEvents.contains(LIGHTBOX_EVENT_EMAIL_VERIFICATION) || this.currentLightboxEvents.contains(LIGHTBOX_EVENT_LOGIN_SUCCESS) || this.currentLightboxEvents.contains(LIGHTBOX_EVENT_REGISTER_SUCCESS) || this.currentLightboxEvents.contains(LIGHTBOX_EVENT_UPDATE_PROFILE_SUCCESS) || this.currentLightboxEvents.contains(LIGHTBOX_EVENT_REAUTH_SUCCESS) || this.currentLightboxEvents.contains(LIGHTBOX_EVENT_OPT_IN_SUCCESS);
    }

    public final boolean getAccountCreated() {
        return this.currentLightboxEvents.contains(LIGHTBOX_EVENT_REGISTER_SUCCESS);
    }

    public final boolean getDidReauth() {
        return this.currentLightboxEvents.contains(LIGHTBOX_EVENT_REAUTH_SUCCESS);
    }

    public final boolean getDidLogout() {
        return this.currentLightboxEvents.contains(LIGHTBOX_EVENT_LOGOUT);
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
    public final Context getAppContext$OneID_release() {
        Context context = this.appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void setAppContext$OneID_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
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
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
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
    public final BiometricSupport getBiometrics$OneID_release() {
        BiometricSupport biometricSupport = this.biometrics;
        if (biometricSupport != null) {
            return biometricSupport;
        }
        Intrinsics.throwUninitializedPropertyAccessException("biometrics");
        return null;
    }

    public final void setBiometrics$OneID_release(@NotNull BiometricSupport biometricSupport) {
        Intrinsics.checkNotNullParameter(biometricSupport, "<set-?>");
        this.biometrics = biometricSupport;
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

    @Nullable
    /* renamed from: getTimeoutHandler$OneID_release, reason: from getter */
    public final Handler getTimeoutHandler() {
        return this.timeoutHandler;
    }

    public final void setTimeoutHandler$OneID_release(@Nullable Handler handler) {
        this.timeoutHandler = handler;
    }

    @Nullable
    /* renamed from: getTimeoutRunnable$OneID_release, reason: from getter */
    public final Runnable getTimeoutRunnable() {
        return this.timeoutRunnable;
    }

    public final void setTimeoutRunnable$OneID_release(@Nullable Runnable runnable) {
        this.timeoutRunnable = runnable;
    }

    public final void bridgeInjected() {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS -> Web // notifyBridgeInjected", null, 4, null);
        this.javascriptExecutor.executeJavascript("document.dispatchEvent(new CustomEvent('didMobileBridgeInjected'));");
    }

    public final void clearLighboxEvents() {
        this.currentLightboxEvents.clear();
    }

    public final void addLightboxEvent(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.currentLightboxEvents.add(event);
    }

    public final void showPage(@NotNull LightboxWebView.LightboxPage page, @Nullable OneIDTrackerEvent event, @NotNull String eventIdNameConversationId, @NotNull String eventIdNameTransactionId, @NotNull String bundleVersion) throws JSONException {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(eventIdNameConversationId, "eventIdNameConversationId");
        Intrinsics.checkNotNullParameter(eventIdNameTransactionId, "eventIdNameTransactionId");
        Intrinsics.checkNotNullParameter(bundleVersion, "bundleVersion");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS -> Web // showPage // " + page.getPageName(), null, 4, null);
        cancelLaunchTimer();
        if (page.shouldTrackTimeout()) {
            startLaunchTimer(event != null ? event.getConversationId$OneID_release() : null);
        }
        JSONObject inputData = page.getInputData();
        if (inputData == null) {
            inputData = new JSONObject();
        }
        OptionalConfigs optionalConfigs = page.getOptionalConfigs();
        inputData.put(LightboxActivity.CONFIGS_EXTRA, optionalConfigs != null ? optionalConfigs.toJSON$OneID_release() : null);
        if (event != null) {
            inputData.put(eventIdNameConversationId, event.getConversationId$OneID_release());
            inputData.put(eventIdNameTransactionId, event.getTransactionId$OneID_release());
        }
        String string = inputData.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.javascriptExecutor.executeJavascript("didNativeToWeb.showPage('" + page.getPageName() + "', " + string + ")");
        if (!Intrinsics.areEqual(bundleVersion, "v2") || event == null) {
            return;
        }
        event.stopTiming$OneID_release();
    }

    @NotNull
    /* renamed from: getGson$OneID_release, reason: from getter */
    public final Gson getGson() {
        return this.gson;
    }

    public final void bridgeReady() {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // bridgeReady()", null, 4, null);
        this.webView.setLightboxReady(true);
        this.webView.setStarterPage();
    }

    public final void getConfig(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // getConfig // " + jsonBody, null, 4, null);
        ((BridgeMessage) this.gson.fromJson(jsonBody, BridgeMessage.class)).executeCallback(this.javascriptExecutor, GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 3, null).toJson(new LightboxConfig(getAppContext$OneID_release())));
    }

    public final void showLoader(final boolean show) {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // showLoader // " + show, null, 4, null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WebToNativeBridgeBase.showLoader$lambda$1(show, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoader$lambda$1(boolean z, WebToNativeBridgeBase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            LightboxWebView.WebViewHolder holder = this$0.webView.getHolder();
            if (holder != null) {
                holder.showLoader();
                return;
            }
            return;
        }
        LightboxWebView.WebViewHolder holder2 = this$0.webView.getHolder();
        if (holder2 != null) {
            holder2.hideLoader();
        }
    }

    public final void getData(@NotNull String jsonBody) {
        Object jSONObject;
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // getData // " + jsonBody, null, 4, null);
        BridgeMessage bridgeMessage = (BridgeMessage) this.gson.fromJson(jsonBody, BridgeMessage.class);
        List<String> keys$OneID_release = bridgeMessage.getKeys$OneID_release();
        ArrayList arrayList = new ArrayList();
        if (keys$OneID_release != null) {
            for (String str : keys$OneID_release) {
                String str2 = getStorage$OneID_release().get(str);
                if (str2 != null) {
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (JSONException unused) {
                        jSONObject = "\"" + str2 + "\"";
                    }
                    arrayList.add("\"" + str + "\":" + jSONObject);
                }
            }
        }
        bridgeMessage.executeCallback(this.javascriptExecutor, CollectionsKt.joinToString$default(arrayList, ",", "{", "}", 0, null, null, 56, null));
    }

    public final void setData(@NotNull String jsonBody) throws JSONException {
        String strValueOf;
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // setData // " + jsonBody, null, 4, null);
        BridgeMessage bridgeMessage = (BridgeMessage) this.gson.fromJson(jsonBody, BridgeMessage.class);
        Map<String, Object> data$OneID_release = bridgeMessage.getData$OneID_release();
        if (data$OneID_release != null) {
            for (Map.Entry<String, Object> entry : data$OneID_release.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.gson.toJson(entry.getValue()));
                        if (StringsKt.endsWith$default(entry.getKey(), ".guest", false, 2, (Object) null)) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("token");
                            if (jSONObjectOptJSONObject != null) {
                                Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                                if (!jSONObjectOptJSONObject.has("created")) {
                                    String str = new SimpleDateFormat(StringPatterns.dateFormatPattern, Locale.US).format(new Date());
                                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("token");
                                    if (jSONObjectOptJSONObject2 != null) {
                                        jSONObjectOptJSONObject2.put("created", str);
                                    }
                                }
                            } else {
                                Logger logger$OneID_release2 = getLogger$OneID_release();
                                String TAG3 = TAG;
                                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                Logger.DefaultImpls.wtf$default(logger$OneID_release2, TAG3, "Lightbox provided us a guest that did not have a token", null, 4, null);
                            }
                        }
                        strValueOf = jSONObject.toString();
                    } catch (JSONException unused) {
                        String string = entry.getValue().toString();
                        if (Intrinsics.areEqual(entry.getKey(), HintConstants.AUTOFILL_HINT_PASSWORD)) {
                            LightboxWebView.WebViewHolder holder = this.webView.getHolder();
                            Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.disney.id.android.lightbox.LightboxActivity");
                            LightboxActivity lightboxActivity = (LightboxActivity) holder;
                            if (BiometricSupport.DefaultImpls.isBiometricEnabled$default(getBiometrics$OneID_release(), lightboxActivity, null, 2, null)) {
                                string = getBiometrics$OneID_release().encryptAfterAuthenticate(lightboxActivity, string);
                                if (string == null || string.length() == 0) {
                                    Logger logger$OneID_release3 = getLogger$OneID_release();
                                    String TAG4 = TAG;
                                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                    Logger.DefaultImpls.i$default(logger$OneID_release3, TAG4, "Biometrics did not result in authentication", null, 4, null);
                                }
                            } else {
                                Logger logger$OneID_release4 = getLogger$OneID_release();
                                String TAG5 = TAG;
                                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                                Logger.DefaultImpls.e$default(logger$OneID_release4, TAG5, "Unable to encrypt and store password.  Biometrics support not available.", null, 4, null);
                            }
                        } else if (Intrinsics.areEqual(entry.getKey(), "touchOptOut") || Intrinsics.areEqual(entry.getKey(), "biometricsOptOut")) {
                            Tracker tracker$OneID_release = getTracker$OneID_release();
                            EventAction eventAction = EventAction.LOG_BIOMETRIC_OPTOUT;
                            String str2 = getSwid$OneID_release().get();
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String str3 = String.format("optout(%s)", Arrays.copyOf(new Object[]{entry.getValue().toString()}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            Tracker.DefaultImpls.trackInstantEvent$default(tracker$OneID_release, null, false, eventAction, str2, null, null, str3, null, false, 435, null);
                        }
                        strValueOf = String.valueOf(string);
                    }
                    Intrinsics.checkNotNull(strValueOf);
                    getStorage$OneID_release().put(entry.getKey(), strValueOf);
                } else {
                    Logger logger$OneID_release5 = getLogger$OneID_release();
                    String TAG6 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    Logger.DefaultImpls.w$default(logger$OneID_release5, TAG6, "Lightbox sent us a null value for " + ((Object) entry.getKey()) + ".  Dropping.", null, 4, null);
                }
            }
        }
        Intrinsics.checkNotNull(bridgeMessage);
        BridgeMessage.executeCallback$default(bridgeMessage, this.javascriptExecutor, null, 2, null);
    }

    public final void clearData(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // clearData // " + jsonBody, null, 4, null);
        BridgeMessage bridgeMessage = (BridgeMessage) this.gson.fromJson(jsonBody, BridgeMessage.class);
        List<String> keys$OneID_release = bridgeMessage.getKeys$OneID_release();
        if (keys$OneID_release != null) {
            Iterator<T> it = keys$OneID_release.iterator();
            while (it.hasNext()) {
                getStorage$OneID_release().put((String) it.next(), null);
            }
        }
        Intrinsics.checkNotNull(bridgeMessage);
        BridgeMessage.executeCallback$default(bridgeMessage, this.javascriptExecutor, null, 2, null);
    }

    public final void close() {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // close", null, 4, null);
        LightboxWebView.WebViewHolder holder = this.webView.getHolder();
        if (holder != null) {
            holder.complete();
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = !LightboxActivity.INSTANCE.isPresenting$OneID_release().get();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 20;
        while (!booleanRef.element && intRef.element > 0) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(intRef, booleanRef, null), 1, null);
        }
        long j = 2000 - (intRef.element * 100);
        Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), null, false, EventAction.LOG_LIGHTBOX_CLOSE, getSwid$OneID_release().get(), null, null, "wait(" + j + " ms)", null, intRef.element <= 0, 179, null);
        this.webView.complete();
    }

    /* renamed from: com.disney.id.android.lightbox.WebToNativeBridgeBase$close$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Ref.IntRef $attemptsRemaining;
        final /* synthetic */ Ref.BooleanRef $lightBoxFinished;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.IntRef intRef, Ref.BooleanRef booleanRef, Continuation continuation) {
            super(2, continuation);
            this.$attemptsRemaining = intRef;
            this.$lightBoxFinished = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$attemptsRemaining, this.$lightBoxFinished, continuation);
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
                Ref.IntRef intRef = this.$attemptsRemaining;
                intRef.element--;
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$lightBoxFinished.element = !LightboxActivity.INSTANCE.isPresenting$OneID_release().get();
            return Unit.INSTANCE;
        }
    }

    public final void setCloseBehavior(final boolean showCloseButton, final boolean stopCloseEvent) {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // setCloseBehavior // showClose // " + showCloseButton + " // stopClose // " + stopCloseEvent, null, 4, null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WebToNativeBridgeBase.setCloseBehavior$lambda$8(this.f$0, showCloseButton, stopCloseEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCloseBehavior$lambda$8(WebToNativeBridgeBase this$0, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LightboxWebView.WebViewHolder holder = this$0.webView.getHolder();
        if (holder != null) {
            holder.setCloseBehavior(z, z2);
        }
    }

    public final void sendLogs(@NotNull String jsonBody, @NotNull String eventIdNameConversationId, @NotNull String eventIdNameTransactionId) {
        Map<String, ? extends Object> map;
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Intrinsics.checkNotNullParameter(eventIdNameConversationId, "eventIdNameConversationId");
        Intrinsics.checkNotNullParameter(eventIdNameTransactionId, "eventIdNameTransactionId");
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(jsonBody, eventIdNameTransactionId, "transaction_id", false, 4, (Object) null), eventIdNameConversationId, OneIDTrackerEvent.EVENT_PARAM_CONVERSATION_ID, false, 4, (Object) null);
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // sendLogs // " + strReplace$default, null, 4, null);
        try {
            map = (Map) this.gson.fromJson(strReplace$default, new TypeToken<HashMap<String, Object>>() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$sendLogs$logJSON$1
            }.getType());
        } catch (JsonSyntaxException e) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.wtf(TAG3, "Web sent invalid JSON for sendLogs // " + strReplace$default, e);
            map = null;
        }
        if (map != null) {
            cancelLaunchTimer();
            getTracker$OneID_release().trackWebEvent(map);
        }
    }

    public final void openUrl(@NotNull final String url, @NotNull String options) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(options, "options");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // openUrl // url // " + url + " // options // " + options, null, 4, null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WebToNativeBridgeBase.openUrl$lambda$10(this.f$0, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openUrl$lambda$10(WebToNativeBridgeBase this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        LightboxWebView.WebViewHolder holder = this$0.webView.getHolder();
        if (holder != null) {
            holder.openUrl(url);
        }
    }

    public final void logout() {
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_LOGOUT);
        LightboxWebView.WebViewOwner owner = this.webView.getOwner();
        if (owner != null) {
            owner.logout();
        }
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // logout", null, 4, null);
    }

    public final void loginSuccess() {
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_LOGIN_SUCCESS);
        Logger logger$OneID_release = getLogger$OneID_release();
        String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
        Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
        Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "JS <- Web // loginSuccess", null, 4, null);
    }

    public final void reauthSuccess() {
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_REAUTH_SUCCESS);
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // reauthSuccess", null, 4, null);
    }

    public final void createSuccess() {
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_REGISTER_SUCCESS);
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // createSuccess", null, 4, null);
    }

    public static /* synthetic */ void updateSuccess$default(WebToNativeBridgeBase webToNativeBridgeBase, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        webToNativeBridgeBase.updateSuccess(str, z);
    }

    public final void updateSuccess(@NotNull String data, boolean deleted) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_UPDATE_PROFILE_SUCCESS);
        this.updateProfileDelta = (Map) this.gson.fromJson(data, new TypeToken<HashMap<String, Object>>() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase.updateSuccess.1
        }.getType());
        this.accountDeleted = deleted;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // updateSuccess // " + data, null, 4, null);
    }

    public final void optInSuccess(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_OPT_IN_SUCCESS);
        this.newslettersResult = new NewslettersResult((List) this.gson.fromJson(jsonBody, new TypeToken<List<? extends String>>() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$optInSuccess$data$1
        }.getType()));
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // optInSuccess // " + jsonBody, null, 4, null);
    }

    public final void emailVerificationComplete(@Nullable String status) {
        this.currentLightboxEvents.add(LIGHTBOX_EVENT_EMAIL_VERIFICATION);
        this.emailVerificationErrorCode = (String) this.gson.fromJson(status, new TypeToken<String>() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase.emailVerificationComplete.1
        }.getType());
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // emailVerificationComplete // " + status, null, 4, null);
    }

    public final void biometricCheck(@NotNull String jsonBody, @NotNull String stateKeyToUse) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Intrinsics.checkNotNullParameter(stateKeyToUse, "stateKeyToUse");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // biometricCheck // " + jsonBody, null, 4, null);
        BridgeMessage bridgeMessage = (BridgeMessage) this.gson.fromJson(jsonBody, BridgeMessage.class);
        Map<String, Object> data$OneID_release = bridgeMessage.getData$OneID_release();
        Object obj = data$OneID_release != null ? data$OneID_release.get("conversationId") : null;
        LightboxWebView.WebViewHolder holder = this.webView.getHolder();
        Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.disney.id.android.lightbox.LightboxActivity");
        String bridgeBiometricResponse = getBiometrics$OneID_release().getBridgeBiometricResponse((LightboxActivity) holder, stateKeyToUse, (String) obj);
        if (Intrinsics.areEqual(stateKeyToUse, "touchid_state")) {
            bridgeMessage.executeCallback(this.javascriptExecutor, "'" + bridgeBiometricResponse + "'");
            return;
        }
        bridgeMessage.executeCallback(this.javascriptExecutor, bridgeBiometricResponse);
    }

    private final void startLaunchTimer(final String conversationId) {
        Runnable runnable = new Runnable() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                WebToNativeBridgeBase.startLaunchTimer$lambda$14(this.f$0, conversationId);
            }
        };
        this.timeoutRunnable = runnable;
        Handler handler = this.timeoutHandler;
        if (handler != null) {
            handler.postDelayed(runnable, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLaunchTimer$lambda$14(final WebToNativeBridgeBase this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Tracker.DefaultImpls.trackInstantEvent$default(this$0.getTracker$OneID_release(), str, false, EventAction.LOG_LIGHTBOX_TIMEOUT, this$0.getSwid$OneID_release().get(), null, null, null, null, false, 178, null);
        LightboxWebView.WebViewHolder holder = this$0.webView.getHolder();
        LightboxActivity lightboxActivity = holder instanceof LightboxActivity ? (LightboxActivity) holder : null;
        if (lightboxActivity != null) {
            new AlertDialog.Builder(lightboxActivity).setMessage(this$0.getScalpController$OneID_release().getMessage("ERROR_TIMEOUT")).setPositiveButton(this$0.getScalpController$OneID_release().getMessage("DIALOG_OK"), new DialogInterface.OnClickListener() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WebToNativeBridgeBase.startLaunchTimer$lambda$14$lambda$13$lambda$11(this.f$0, dialogInterface, i);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.disney.id.android.lightbox.WebToNativeBridgeBase$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WebToNativeBridgeBase.startLaunchTimer$lambda$14$lambda$13$lambda$12(this.f$0, dialogInterface);
                }
            }).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLaunchTimer$lambda$14$lambda$13$lambda$11(WebToNativeBridgeBase this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLaunchTimer$lambda$14$lambda$13$lambda$12(WebToNativeBridgeBase this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.close();
    }

    public final void cancelLaunchTimer() {
        Handler handler;
        Runnable runnable = this.timeoutRunnable;
        if (runnable == null || (handler = this.timeoutHandler) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }
}
