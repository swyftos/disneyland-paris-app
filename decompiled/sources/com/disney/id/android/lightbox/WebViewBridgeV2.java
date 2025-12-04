package com.disney.id.android.lightbox;

import android.webkit.JavascriptInterface;
import com.disney.id.android.NewslettersResult;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.urbanairship.reactnative.ReactMessageView;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u000201H\u0007J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u0010H\u0007J\b\u00107\u001a\u000201H\u0016J\b\u00108\u001a\u000201H\u0007J\b\u00109\u001a\u000201H\u0007J\b\u0010:\u001a\u000201H\u0007J\u0010\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020\u0010H\u0007J\u0010\u0010<\u001a\u0002012\u0006\u00106\u001a\u00020\u0010H\u0007J\u0010\u0010=\u001a\u0002012\u0006\u00106\u001a\u00020\u0010H\u0007J\u0010\u0010>\u001a\u0002012\u0006\u00106\u001a\u00020\u0010H\u0007J\b\u0010?\u001a\u000201H\u0007J\b\u0010@\u001a\u000201H\u0007J\u0018\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u0010H\u0007J\u0010\u0010D\u001a\u0002012\u0006\u0010;\u001a\u00020\u0010H\u0007J\b\u0010E\u001a\u000201H\u0007J\u0010\u0010F\u001a\u0002012\u0006\u00106\u001a\u00020\u0010H\u0007J\u0010\u0010G\u001a\u0002012\u0006\u00106\u001a\u00020\u0010H\u0007J\u0010\u0010H\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0007J\u0010\u0010L\u001a\u0002012\u0006\u0010M\u001a\u00020\bH\u0007J\u001a\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020P2\b\u00102\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u0002012\u0006\u0010;\u001a\u00020\u0010H\u0007R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u00020\u001a8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u001e\u0010%\u001a\u00020&8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006S"}, d2 = {"Lcom/disney/id/android/lightbox/WebViewBridgeV2;", "Lcom/disney/id/android/lightbox/WebViewBridge;", "webView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "javascriptExecutor", "Lcom/disney/id/android/lightbox/JavascriptExecutor;", "(Lcom/disney/id/android/lightbox/LightboxWebView;Lcom/disney/id/android/lightbox/JavascriptExecutor;)V", "accountCreated", "", "getAccountCreated", "()Z", "accountDeleted", "getAccountDeleted", "baseBridge", "Lcom/disney/id/android/lightbox/WebToNativeBridgeBase;", "bundleVersion", "", "getBundleVersion", "()Ljava/lang/String;", "didLogout", "getDidLogout", "didReauth", "getDidReauth", "emailVerificationErrorCode", "getEmailVerificationErrorCode", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "newslettersResult", "Lcom/disney/id/android/NewslettersResult;", "getNewslettersResult", "()Lcom/disney/id/android/NewslettersResult;", "successful", "getSuccessful", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "updateProfileDelta", "", "", "getUpdateProfileDelta", "()Ljava/util/Map;", "addLightboxEvent", "", "event", "bridgeInjected", "bridgeReady", "clearData", "jsonBody", "clearLightboxEvents", ReactMessageView.EVENT_CLOSE, "createSuccess", "emailVerificationComplete", "data", "fingerprint", "getConfig", "getData", "loginSuccess", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "openUrl", "url", "options", "optInSuccess", "reauthSuccess", "sendLogs", "setData", "setNewslettersResult", "showCloseShouldPreventBackButtonAction", "showCloseButton", "stopCloseEvent", "showLoader", "show", "showPage", "page", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "updateSuccess", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewBridgeV2 implements WebViewBridge {
    private final WebToNativeBridgeBase baseBridge;
    private final String bundleVersion;

    @Inject
    public Logger logger;

    @Inject
    public Tracker tracker;

    public WebViewBridgeV2(@NotNull LightboxWebView webView, @NotNull JavascriptExecutor javascriptExecutor) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(javascriptExecutor, "javascriptExecutor");
        OneIDDagger.getComponent().inject(this);
        this.baseBridge = new WebToNativeBridgeBase(webView, javascriptExecutor);
        this.bundleVersion = "v2";
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
        return this.baseBridge.getAccountCreated();
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
        this.baseBridge.showPage(page, event, "correlationId", "conversationId", getBundleVersion());
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
    public final void showCloseShouldPreventBackButtonAction(boolean showCloseButton, boolean stopCloseEvent) {
        this.baseBridge.setCloseBehavior(showCloseButton, stopCloseEvent);
    }

    @JavascriptInterface
    public final void sendLogs(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.sendLogs(jsonBody, "correlation_id", OneIDTrackerEvent.EVENT_PARAM_CONVERSATION_ID);
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
    public final void loginSuccess() {
        this.baseBridge.loginSuccess();
    }

    @JavascriptInterface
    public final void reauthSuccess() {
        this.baseBridge.reauthSuccess();
    }

    @JavascriptInterface
    public final void createSuccess() {
        this.baseBridge.createSuccess();
    }

    @JavascriptInterface
    public final void updateSuccess(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        WebToNativeBridgeBase.updateSuccess$default(this.baseBridge, data, false, 2, null);
    }

    @JavascriptInterface
    public final void optInSuccess(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.baseBridge.optInSuccess(data);
    }

    @JavascriptInterface
    public final void emailVerificationComplete() {
        this.baseBridge.emailVerificationComplete(null);
    }

    @JavascriptInterface
    public final void emailVerificationComplete(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.baseBridge.emailVerificationComplete(data);
    }

    @JavascriptInterface
    public final void fingerprint(@NotNull String jsonBody) {
        Intrinsics.checkNotNullParameter(jsonBody, "jsonBody");
        this.baseBridge.biometricCheck(jsonBody, "touchid_state");
    }
}
