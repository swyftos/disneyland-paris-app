package com.oneid;

import android.util.Log;
import androidx.annotation.NonNull;
import com.disney.id.android.Config;
import com.disney.id.android.EditableField;
import com.disney.id.android.NotInitialized;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDListener;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.oneid.common.ConstantsKt;
import com.oneid.common.EventId;
import com.oneid.delegate.GetProfileDelegate;
import com.oneid.delegate.GuestCallBackDelegate;
import com.oneid.delegate.LaunchIdentityFlowDelegate;
import com.oneid.delegate.LaunchProfileDelegate;
import com.oneid.delegate.LoginDelegate;
import com.oneid.delegate.OneIdStateDelegate;
import com.oneid.delegate.RegistrationDelegate;
import com.oneid.delegate.UpdateProfileDelegate;
import com.oneid.model.EventResult;
import com.oneid.model.EventType;
import com.oneid.model.OneIDConfiguration;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001<\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J2\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010#\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010&\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010'\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010(\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u00100\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0007JX\u00101\u001a\u00020\u00192\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u0010.\u001a\u00020/2\u0006\u00103\u001a\u0002042\u001c\u00105\u001a\u0018\u0012\f\u0012\n\u0018\u000107j\u0004\u0018\u0001`8\u0012\u0004\u0012\u00020\u0019\u0018\u0001062\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u0019\u0018\u000106H\u0002J\u0018\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0017H\u0007J\u0010\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020EH\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=¨\u0006G"}, d2 = {"Lcom/oneid/OneidModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "stateDelegate", "Lcom/oneid/delegate/OneIdStateDelegate;", "updateProfileDelegate", "Lcom/oneid/delegate/UpdateProfileDelegate;", "getProfileDelegate", "Lcom/oneid/delegate/GetProfileDelegate;", "guestCallBackDelegate", "Lcom/oneid/delegate/GuestCallBackDelegate;", "loginDelegate", "Lcom/oneid/delegate/LoginDelegate;", "launchProfileDelegate", "Lcom/oneid/delegate/LaunchProfileDelegate;", "registrationDelegate", "Lcom/oneid/delegate/RegistrationDelegate;", "launchIdentityFlowDelegate", "Lcom/oneid/delegate/LaunchIdentityFlowDelegate;", "getName", "", "initialize", "", "clientId", "environment", Constants.LOCALE, "overrideCssUrl", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "initOneIdSession", "oneIDConfiguration", "Lcom/oneid/model/OneIDConfiguration;", FirebaseAnalytics.Event.LOGIN, "updateProfile", "json", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "launchProfile", "createAccount", "isLoggedIn", "isHighTrust", "isLowTrust", "getEditableProfileFields", "getSessionData", "serverUpdate", "", "launchIdentityFlow", "internalGetSessionData", "sinkEventNeeded", LightboxActivity.EVENT_ID_EXTRA, "Lcom/oneid/common/EventId;", PDFView.EVENT_ON_ERROR, "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "callback", "Lcom/oneid/model/EventResult;", "oneIdListener", "com/oneid/OneidModule$oneIdListener$1", "Lcom/oneid/OneidModule$oneIdListener$1;", "sendEvent", "eventName", "params", "Lcom/facebook/react/bridge/WritableMap;", "addListener", "removeListeners", "count", "", "Companion", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneidModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneidModule.kt\ncom/oneid/OneidModule\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,274:1\n1#2:275\n*E\n"})
/* loaded from: classes4.dex */
public final class OneidModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final String NAME = "OneIdModule";
    private GetProfileDelegate getProfileDelegate;
    private GuestCallBackDelegate guestCallBackDelegate;

    @NotNull
    private LaunchIdentityFlowDelegate launchIdentityFlowDelegate;

    @NotNull
    private LaunchProfileDelegate launchProfileDelegate;

    @NotNull
    private LoginDelegate loginDelegate;

    @NotNull
    private final OneidModule$oneIdListener$1 oneIdListener;

    @NotNull
    private RegistrationDelegate registrationDelegate;
    private OneIdStateDelegate stateDelegate;
    private UpdateProfileDelegate updateProfileDelegate;

    @ReactMethod
    public final void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.oneid.OneidModule$oneIdListener$1] */
    public OneidModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.loginDelegate = new LoginDelegate(new OneidModule$loginDelegate$1(this));
        this.launchProfileDelegate = new LaunchProfileDelegate(new OneidModule$launchProfileDelegate$1(this), new OneidModule$launchProfileDelegate$2(this));
        this.registrationDelegate = new RegistrationDelegate(new OneidModule$registrationDelegate$1(this));
        this.launchIdentityFlowDelegate = new LaunchIdentityFlowDelegate(new OneidModule$launchIdentityFlowDelegate$1(this));
        this.oneIdListener = new OneIDListener() { // from class: com.oneid.OneidModule$oneIdListener$1
            @Override // com.disney.id.android.OneIDListener
            public void onLogout() {
                Log.d(ConstantsKt.ONEID_TAG, "onTokenRefreshFailure called by SDK");
                this.this$0.sendEvent(ConstantsKt.ON_LOGOUT, new EventResult(EventType.Logout, EventId.Logout, null, null, 12, null).serialize());
            }

            @Override // com.disney.id.android.OneIDListener
            public void onTokenRefreshFailure() {
                Log.d(ConstantsKt.ONEID_TAG, "onTokenRefreshFailure called by SDK");
            }

            @Override // com.disney.id.android.OneIDListener
            public void onTokenRefreshSuccess() {
                Log.d(ConstantsKt.ONEID_TAG, "onTokenRefreshSuccess called by SDK");
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void initialize(@NotNull String clientId, @NotNull String environment, @NotNull String locale, @Nullable String overrideCssUrl, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "initialize called: " + clientId + " " + environment + " " + locale + " " + overrideCssUrl);
        initOneIdSession(OneIDConfiguration.INSTANCE.fromArguments(clientId, environment, locale, overrideCssUrl), promise);
    }

    private final void initOneIdSession(OneIDConfiguration oneIDConfiguration, final Promise promise) {
        Log.d(ConstantsKt.ONEID_TAG, "initOneIdSession");
        OneID.Environment environment = oneIDConfiguration.getEnvironment();
        String clientId = oneIDConfiguration.getClientId();
        String locale = oneIDConfiguration.getLocale();
        String cssOverrideUrl = oneIDConfiguration.getCssOverrideUrl();
        final Config config = new Config(environment, clientId, locale, cssOverrideUrl != null ? new URL(cssOverrideUrl) : null, null, 16, null);
        this.stateDelegate = new OneIdStateDelegate(new Function0() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OneidModule.initOneIdSession$lambda$2(promise);
            }
        }, new Function0() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OneidModule.initOneIdSession$lambda$3(promise);
            }
        });
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                OneidModule.initOneIdSession$lambda$4(config, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initOneIdSession$lambda$2(Promise promise) {
        promise.resolve(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initOneIdSession$lambda$3(Promise promise) {
        promise.reject(new Exception("OneId Permanent Failure"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOneIdSession$lambda$4(Config config, OneidModule oneidModule) throws InterruptedException {
        OneID.Companion companion = OneID.INSTANCE;
        OneidModule$oneIdListener$1 oneidModule$oneIdListener$1 = oneidModule.oneIdListener;
        ReactApplicationContext reactApplicationContext = oneidModule.getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        OneIdStateDelegate oneIdStateDelegate = oneidModule.stateDelegate;
        if (oneIdStateDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
            oneIdStateDelegate = null;
        }
        OneID.Companion.initialize$default(companion, config, oneidModule$oneIdListener$1, reactApplicationContext, null, oneIdStateDelegate, 8, null);
    }

    @ReactMethod
    public final void login(@NonNull @NotNull Promise promise) throws NotInitialized {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "login called:");
        OneID oneIDShared = OneID.INSTANCE.shared();
        if (!oneIDShared.isLoggedIn()) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            OneID.launchLogin$default(oneIDShared, reactApplicationContext, this.loginDelegate, null, 4, null);
        } else {
            ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
            OneID.launchReauth$default(oneIDShared, reactApplicationContext2, this.loginDelegate, null, 4, null);
        }
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public final void updateProfile(@NotNull String json, @NotNull Promise promise) throws NotInitialized, JsonSyntaxException, JsonIOException {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "updateProfile called:");
        this.updateProfileDelegate = new UpdateProfileDelegate(promise);
        OneID oneIDShared = OneID.INSTANCE.shared();
        List<EditableField> listFromJSON = EditableField.INSTANCE.fromJSON(json);
        UpdateProfileDelegate updateProfileDelegate = this.updateProfileDelegate;
        if (updateProfileDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateProfileDelegate");
            updateProfileDelegate = null;
        }
        OneID.setEditableProfileFields$default(oneIDShared, listFromJSON, updateProfileDelegate, (OptionalConfigs) null, 4, (Object) null);
    }

    @ReactMethod
    public final void logout(@NonNull @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "logout called:");
        OneID.logout$default(OneID.INSTANCE.shared(), null, 1, null);
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public final void launchProfile(@NonNull @NotNull Promise promise) throws NotInitialized {
        Intrinsics.checkNotNullParameter(promise, "promise");
        OneID oneIDShared = OneID.INSTANCE.shared();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        OneID.launchProfile$default(oneIDShared, reactApplicationContext, this.launchProfileDelegate, null, 4, null);
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public final void createAccount(@NonNull @NotNull Promise promise) throws NotInitialized {
        Intrinsics.checkNotNullParameter(promise, "promise");
        OneID oneIDShared = OneID.INSTANCE.shared();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        OneID.launchRegistration$default(oneIDShared, reactApplicationContext, this.registrationDelegate, null, 4, null);
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public final void isLoggedIn(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "isLoggedId called:");
        promise.resolve(Boolean.valueOf(OneID.INSTANCE.shared().isLoggedIn()));
    }

    @ReactMethod
    public final void isHighTrust(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "isHighTrust called:");
        OneID.Companion companion = OneID.INSTANCE;
        promise.resolve(Boolean.valueOf(!companion.shared().isLowTrust() && companion.shared().isLoggedIn()));
    }

    @ReactMethod
    public final void isLowTrust(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "isLowTrust called:");
        OneID.Companion companion = OneID.INSTANCE;
        promise.resolve(Boolean.valueOf(companion.shared().isLowTrust() && companion.shared().isLoggedIn()));
    }

    @ReactMethod
    public final void getEditableProfileFields(@NotNull Promise promise) throws NotInitialized {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.getProfileDelegate = new GetProfileDelegate(promise);
        OneID oneIDShared = OneID.INSTANCE.shared();
        GetProfileDelegate getProfileDelegate = this.getProfileDelegate;
        if (getProfileDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getProfileDelegate");
            getProfileDelegate = null;
        }
        OneID.getEditableProfileFields$default(oneIDShared, getProfileDelegate, null, 2, null);
    }

    @ReactMethod
    public final void getSessionData(boolean serverUpdate, @NotNull final Promise promise) throws NotInitialized {
        Intrinsics.checkNotNullParameter(promise, "promise");
        internalGetSessionData(false, serverUpdate, EventId.GetSessionData, new Function1() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OneidModule.getSessionData$lambda$6(promise, (Exception) obj);
            }
        }, new Function1() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OneidModule.getSessionData$lambda$7(promise, (EventResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSessionData$lambda$6(Promise promise, Exception exc) {
        String message;
        if (exc == null || (message = exc.getMessage()) == null) {
            message = "An unknown error has occurred in OneID Plugin";
        }
        promise.reject(ConstantsKt.ONEID_TAG, message, (Throwable) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSessionData$lambda$7(Promise promise, EventResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        promise.resolve(it.serialize());
        return Unit.INSTANCE;
    }

    @ReactMethod
    public final void launchIdentityFlow(@NonNull @NotNull Promise promise) throws NotInitialized, JSONException {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Log.d(ConstantsKt.ONEID_TAG, "launchIdentityFlow called:");
        OneID oneIDShared = OneID.INSTANCE.shared();
        if (!oneIDShared.isLoggedIn()) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            OneID.launchIdentityFlow$default(oneIDShared, reactApplicationContext, null, this.launchIdentityFlowDelegate, null, 8, null);
        } else {
            ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
            OneID.launchReauth$default(oneIDShared, reactApplicationContext2, this.launchIdentityFlowDelegate, null, 4, null);
        }
        promise.resolve(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalGetSessionData(final boolean sinkEventNeeded, boolean serverUpdate, final EventId eventId, final Function1<? super Exception, Unit> onError, final Function1<? super EventResult, Unit> callback) throws NotInitialized {
        OneID.Companion companion = OneID.INSTANCE;
        if (!companion.shared().isLoggedIn()) {
            Log.d(ConstantsKt.ONEID_TAG, "getSessionData Logout");
            EventResult eventResult = new EventResult(EventType.Logout, eventId, null, null, 12, null);
            sendEvent(ConstantsKt.ON_LOGOUT, eventResult.serialize());
            if (callback != null) {
                callback.invoke(eventResult);
                return;
            }
            return;
        }
        this.guestCallBackDelegate = new GuestCallBackDelegate(eventId, sinkEventNeeded, serverUpdate, new Function0() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OneidModule.internalGetSessionData$lambda$9(this.f$0, sinkEventNeeded, eventId, onError, callback);
            }
        }, new AnonymousClass2(this), callback, onError);
        OneID oneIDShared = companion.shared();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        GuestCallBackDelegate guestCallBackDelegate = this.guestCallBackDelegate;
        if (guestCallBackDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guestCallBackDelegate");
            guestCallBackDelegate = null;
        }
        OneID.getGuest$default(oneIDShared, reactApplicationContext, guestCallBackDelegate, true, serverUpdate, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalGetSessionData$lambda$9(OneidModule oneidModule, boolean z, EventId eventId, Function1 function1, Function1 function12) throws NotInitialized {
        oneidModule.internalGetSessionData(z, false, eventId, function1, function12);
        return Unit.INSTANCE;
    }

    /* renamed from: com.oneid.OneidModule$internalGetSessionData$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2 {
        AnonymousClass2(Object obj) {
            super(2, obj, OneidModule.class, "sendEvent", "sendEvent(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, (WritableMap) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(String p0, WritableMap p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((OneidModule) this.receiver).sendEvent(p0, p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(final String eventName, final WritableMap params) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.oneid.OneidModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OneidModule.sendEvent$lambda$10(this.f$0, eventName, params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendEvent$lambda$10(OneidModule oneidModule, String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) oneidModule.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }
}
