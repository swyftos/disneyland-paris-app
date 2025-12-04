package com.disney.id.android.lightbox;

import com.disney.id.android.NewslettersResult;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH&J\b\u0010\u001f\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020\u001dH&J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001c\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010%H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\"\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/disney/id/android/lightbox/WebViewBridge;", "", "accountCreated", "", "getAccountCreated", "()Z", "accountDeleted", "getAccountDeleted", "bundleVersion", "", "getBundleVersion", "()Ljava/lang/String;", "didLogout", "getDidLogout", "didReauth", "getDidReauth", "emailVerificationErrorCode", "getEmailVerificationErrorCode", "newslettersResult", "Lcom/disney/id/android/NewslettersResult;", "getNewslettersResult", "()Lcom/disney/id/android/NewslettersResult;", "successful", "getSuccessful", "updateProfileDelta", "", "getUpdateProfileDelta", "()Ljava/util/Map;", "addLightboxEvent", "", "event", "bridgeInjected", "clearLightboxEvents", "setNewslettersResult", "showPage", "page", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WebViewBridge {
    void addLightboxEvent(@NotNull String event);

    void bridgeInjected();

    void clearLightboxEvents();

    boolean getAccountCreated();

    boolean getAccountDeleted();

    @NotNull
    String getBundleVersion();

    boolean getDidLogout();

    boolean getDidReauth();

    @Nullable
    String getEmailVerificationErrorCode();

    @Nullable
    NewslettersResult getNewslettersResult();

    boolean getSuccessful();

    @Nullable
    Map<String, Object> getUpdateProfileDelta();

    void setNewslettersResult(@NotNull NewslettersResult newslettersResult);

    void showPage(@NotNull LightboxWebView.LightboxPage page, @Nullable OneIDTrackerEvent event);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void showPage$default(WebViewBridge webViewBridge, LightboxWebView.LightboxPage lightboxPage, OneIDTrackerEvent oneIDTrackerEvent, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPage");
            }
            if ((i & 2) != 0) {
                oneIDTrackerEvent = null;
            }
            webViewBridge.showPage(lightboxPage, oneIDTrackerEvent);
        }
    }
}
