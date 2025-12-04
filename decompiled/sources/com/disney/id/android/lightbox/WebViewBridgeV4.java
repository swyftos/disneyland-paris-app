package com.disney.id.android.lightbox;

import android.webkit.JavascriptInterface;
import com.disney.id.android.NewslettersResult;
import com.disney.id.android.OneIDSCALPController;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.disney.id.android.utils.GsonUtils;
import com.dlp.BluetoothManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.urbanairship.reactnative.ReactMessageView;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\b\u00105\u001a\u000201H\u0016J\b\u00106\u001a\u000201H\u0007J\u0010\u00107\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\b\u00108\u001a\u000201H\u0016J\b\u00109\u001a\u000201H\u0007J\u0010\u0010:\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\u0010\u0010;\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\u0010\u0010<\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\b\u0010=\u001a\u000201H\u0007J\u0018\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0007J\u0010\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u0010H\u0007J\u0010\u0010C\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\u0018\u0010D\u001a\u0002012\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0007J\u0010\u0010G\u001a\u0002012\u0006\u00104\u001a\u00020\u0010H\u0007J\u0010\u0010H\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\bH\u0007J\u001a\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020M2\b\u00102\u001a\u0004\u0018\u00010NH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u00020\u001a8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u001e\u0010%\u001a\u00020&8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006P"}, d2 = {"Lcom/disney/id/android/lightbox/WebViewBridgeV4;", "Lcom/disney/id/android/lightbox/WebViewBridge;", "webView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "javascriptExecutor", "Lcom/disney/id/android/lightbox/JavascriptExecutor;", "(Lcom/disney/id/android/lightbox/LightboxWebView;Lcom/disney/id/android/lightbox/JavascriptExecutor;)V", "accountCreated", "", "getAccountCreated", "()Z", "accountDeleted", "getAccountDeleted", "baseBridge", "Lcom/disney/id/android/lightbox/WebToNativeBridgeBase;", "bundleVersion", "", "getBundleVersion", "()Ljava/lang/String;", "didLogout", "getDidLogout", "didReauth", "getDidReauth", "emailVerificationErrorCode", "getEmailVerificationErrorCode", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "newslettersResult", "Lcom/disney/id/android/NewslettersResult;", "getNewslettersResult", "()Lcom/disney/id/android/NewslettersResult;", "successful", "getSuccessful", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "updateProfileDelta", "", "", "getUpdateProfileDelta", "()Ljava/util/Map;", "addLightboxEvent", "", "event", "biometricCheck", "jsonBody", "bridgeInjected", "bridgeReady", "clearData", "clearLightboxEvents", ReactMessageView.EVENT_CLOSE, "fireEvent", "getConfig", "getData", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "openUrl", "url", "options", "pageReady", "data", "sendLogs", "setCloseBehavior", "showCloseButton", "stopCloseEvent", "setData", "setNewslettersResult", "showLoader", "show", "showPage", "page", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewBridgeV4 implements WebViewBridge {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = WebViewBridgeV4.class.getSimpleName();
    private final WebToNativeBridgeBase baseBridge;
    private final String bundleVersion;

    @Inject
    public Logger logger;

    @Inject
    public Tracker tracker;

    public WebViewBridgeV4(@NotNull LightboxWebView webView, @NotNull JavascriptExecutor javascriptExecutor) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(javascriptExecutor, "javascriptExecutor");
        OneIDDagger.getComponent().inject(this);
        this.baseBridge = new WebToNativeBridgeBase(webView, javascriptExecutor);
        this.bundleVersion = OneIDSCALPController.USE_VERSION_4;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/disney/id/android/lightbox/WebViewBridgeV4$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return WebViewBridgeV4.TAG;
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

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public boolean getSuccessful() {
        return this.baseBridge.getSuccessful();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public boolean getAccountCreated() {
        return this.baseBridge.getAccountCreated();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public boolean getAccountDeleted() {
        return this.baseBridge.getAccountDeleted();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    @NotNull
    public String getBundleVersion() {
        return this.bundleVersion;
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public boolean getDidReauth() {
        return this.baseBridge.getDidReauth();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public boolean getDidLogout() {
        return this.baseBridge.getDidLogout();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    @Nullable
    public Map<String, Object> getUpdateProfileDelta() {
        return this.baseBridge.getUpdateProfileDelta();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    @Nullable
    public NewslettersResult getNewslettersResult() {
        return this.baseBridge.getNewslettersResult();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    @Nullable
    public String getEmailVerificationErrorCode() {
        return this.baseBridge.getEmailVerificationErrorCode();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public void bridgeInjected() {
        this.baseBridge.bridgeInjected();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public void showPage(@NotNull LightboxWebView.LightboxPage page, @Nullable OneIDTrackerEvent event) throws JSONException {
        Intrinsics.checkNotNullParameter(page, "page");
        this.baseBridge.showPage(page, event, "conversationId", "transactionId", getBundleVersion());
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public void clearLightboxEvents() {
        this.baseBridge.clearLighboxEvents();
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public void addLightboxEvent(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.baseBridge.addLightboxEvent(event);
    }

    @Override // com.disney.id.android.lightbox.WebViewBridge
    public void setNewslettersResult(@NotNull NewslettersResult newslettersResult) {
        Intrinsics.checkNotNullParameter(newslettersResult, "newslettersResult");
        this.baseBridge.setNewslettersResult(newslettersResult);
    }

    @JavascriptInterface
    public final void bridgeReady() {
        this.baseBridge.bridgeReady();
    }

    @JavascriptInterface
    public final void getConfig(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.getConfig(jsonBody);
    }

    @JavascriptInterface
    public final void showLoader(boolean show) {
        this.baseBridge.showLoader(show);
    }

    @JavascriptInterface
    public final void getData(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.getData(jsonBody);
    }

    @JavascriptInterface
    public final void setData(@NotNull String jsonBody) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.setData(jsonBody);
    }

    @JavascriptInterface
    public final void clearData(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.clearData(jsonBody);
    }

    @JavascriptInterface
    public final void close() {
        this.baseBridge.close();
    }

    @JavascriptInterface
    public final void setCloseBehavior(boolean showCloseButton, boolean stopCloseEvent) {
        this.baseBridge.setCloseBehavior(showCloseButton, stopCloseEvent);
    }

    @JavascriptInterface
    public final void sendLogs(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.sendLogs(jsonBody, OneIDTrackerEvent.EVENT_PARAM_CONVERSATION_ID, "transaction_id");
    }

    @JavascriptInterface
    public final void openUrl(@NotNull String url, @NotNull String options) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(options, "options");
        this.baseBridge.openUrl(url, options);
    }

    @JavascriptInterface
    public final void logout() {
        this.baseBridge.logout();
    }

    @JavascriptInterface
    public final void biometricCheck(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.cancelLaunchTimer();
        this.baseBridge.biometricCheck(jsonBody, BluetoothManager.BLE_STATUS_PARAM);
    }

    @JavascriptInterface
    public final void pageReady(@NotNull String data) {
        Map map;
        Unit unit;
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // pageReady // " + data, null, 4, null);
        Unit unit2 = null;
        try {
            map = (Map) this.baseBridge.getGson().fromJson(data, new TypeToken<HashMap<String, Object>>() { // from class: com.disney.id.android.lightbox.WebViewBridgeV4$pageReady$logJSON$1
            }.getType());
        } catch (JsonSyntaxException e) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.wtf(TAG3, "Web sent invalid JSON for pageReady // " + data, e);
            map = null;
        }
        Object obj = map != null ? map.get(OneIDTrackerEvent.EVENT_PARAM_CONVERSATION_ID) : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release3, TAG4, "Conversation id in pageReady json is null", null, 4, null);
        }
        TrackerEventKey eventFromConversationIdAndEventType = str != null ? getTracker$OneID_release().getEventFromConversationIdAndEventType(str, "api:launch:") : null;
        if (eventFromConversationIdAndEventType != null) {
            this.baseBridge.cancelLaunchTimer();
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), eventFromConversationIdAndEventType, false, null, null, null, false, 62, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Logger logger$OneID_release4 = getLogger$OneID_release();
            String TAG5 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release4, TAG5, "There was not a matching api:launch:* event for the conversation id", null, 4, null);
        }
        TrackerEventKey eventFromConversationIdAndEventType2 = str != null ? getTracker$OneID_release().getEventFromConversationIdAndEventType(str, "event:launch:") : null;
        if (eventFromConversationIdAndEventType2 != null) {
            this.baseBridge.cancelLaunchTimer();
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), eventFromConversationIdAndEventType2, false, null, null, null, false, 62, null);
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            Logger logger$OneID_release5 = getLogger$OneID_release();
            String TAG6 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release5, TAG6, "There was not a matching event:launch:* event for the conversation id", null, 4, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JavascriptInterface
    public final void fireEvent(@NotNull String jsonBody) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        String string = null;
        string = null;
        String string2 = null;
        string = null;
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "JS <- Web // fireEvent // " + jsonBody, null, 4, null);
        Gson gsonCreateStandardGson$default = GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, true, false, 5, null);
        BridgeEvent bridgeEvent = (BridgeEvent) gsonCreateStandardGson$default.fromJson(jsonBody, BridgeEvent.class);
        String name = bridgeEvent.getName();
        String str = "";
        switch (name.hashCode()) {
            case -1742562913:
                if (name.equals(WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGIN_SUCCESS)) {
                    this.baseBridge.loginSuccess();
                    return;
                }
                break;
            case -1424724676:
                if (name.equals(WebToNativeBridgeBase.LIGHTBOX_EVENT_OPT_IN_SUCCESS)) {
                    Map<String, Object> data = bridgeEvent.getData();
                    if (data != null && (obj = data.get("optIn")) != null) {
                        string = obj.toString();
                    }
                    if (string == null) {
                        Logger logger$OneID_release2 = getLogger$OneID_release();
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        Logger.DefaultImpls.w$default(logger$OneID_release2, TAG2, "Lightbox did not send optIn for " + bridgeEvent.getName(), null, 4, null);
                    } else {
                        str = string;
                    }
                    this.baseBridge.optInSuccess(str);
                    return;
                }
                break;
            case -1045758247:
                if (name.equals(WebToNativeBridgeBase.LIGHTBOX_EVENT_REGISTER_SUCCESS)) {
                    this.baseBridge.createSuccess();
                    return;
                }
                break;
            case -973047077:
                if (name.equals(WebToNativeBridgeBase.LIGHTBOX_EVENT_UPDATE_PROFILE_SUCCESS)) {
                    Map<String, Object> data2 = bridgeEvent.getData();
                    Object obj3 = data2 != null ? data2.get("guest") : null;
                    Map<String, Object> data3 = bridgeEvent.getData();
                    Object obj4 = data3 != null ? data3.get("deleted") : null;
                    Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    String json = gsonCreateStandardGson$default.toJson(obj3);
                    if (json == null) {
                        Logger logger$OneID_release3 = getLogger$OneID_release();
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        Logger.DefaultImpls.w$default(logger$OneID_release3, TAG2, "Lightbox did not send a guest for " + bridgeEvent.getName(), null, 4, null);
                    } else {
                        str = json;
                    }
                    this.baseBridge.updateSuccess(str, zBooleanValue);
                    return;
                }
                break;
            case -480435230:
                if (name.equals("email-verification-success")) {
                    Map<String, Object> data4 = bridgeEvent.getData();
                    if (data4 != null && (obj2 = data4.get("status")) != null) {
                        string2 = obj2.toString();
                    }
                    this.baseBridge.emailVerificationComplete(string2);
                    return;
                }
                break;
            case 1705587345:
                if (name.equals(WebToNativeBridgeBase.LIGHTBOX_EVENT_REAUTH_SUCCESS)) {
                    this.baseBridge.reauthSuccess();
                    return;
                }
                break;
        }
        Logger logger$OneID_release4 = getLogger$OneID_release();
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.i$default(logger$OneID_release4, TAG2, "Lightbox sent an unrecognized event // " + bridgeEvent, null, 4, null);
    }
}
