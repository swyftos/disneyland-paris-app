package com.disney.id.android.lightbox;

import android.content.Context;
import com.disney.id.android.LightboxData;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.TrackerEventKey;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b`\u0018\u00002\u00020\u0001:\u0003234J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H&J\b\u0010&\u001a\u00020$H&J\b\u0010'\u001a\u00020$H&J$\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020$H&J\u001c\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u00192\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001aH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/disney/id/android/lightbox/LightboxWebView;", "", "bundleLoaded", "", "getBundleLoaded", "()Z", "setBundleLoaded", "(Z)V", "holder", "Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;", "getHolder", "()Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;", "setHolder", "(Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;)V", "lightboxReady", "getLightboxReady", "setLightboxReady", "owner", "Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;", "getOwner", "()Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;", "setOwner", "(Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;)V", "pendingPageAndEvent", "Lkotlin/Pair;", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "getPendingPageAndEvent", "()Lkotlin/Pair;", "setPendingPageAndEvent", "(Lkotlin/Pair;)V", "userAgent", "", "getUserAgent", "()Ljava/lang/String;", "bundleVersion", "", "version", "complete", "initializeBridge", "loadBundle", "appContext", "Landroid/content/Context;", "conversationEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "forceLoadBundle", "setStarterPage", "showPage", "page", "event", "LightboxPage", "WebViewHolder", "WebViewOwner", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LightboxWebView {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/disney/id/android/lightbox/LightboxWebView$WebViewHolder;", "", "complete", "", "hideLoader", "openUrl", "url", "", "setCloseBehavior", "showBack", "", "preventBack", "showLoader", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface WebViewHolder {
        void complete();

        void hideLoader();

        void openUrl(@NotNull String url);

        void setCloseBehavior(boolean showBack, boolean preventBack);

        void showLoader();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;", "", "lightboxComplete", "", "lightboxData", "Lcom/disney/id/android/LightboxData;", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface WebViewOwner {
        void lightboxComplete(@NotNull LightboxData lightboxData);

        void logout();
    }

    void bundleVersion(@NotNull String version);

    void complete();

    boolean getBundleLoaded();

    @Nullable
    WebViewHolder getHolder();

    boolean getLightboxReady();

    @Nullable
    WebViewOwner getOwner();

    @Nullable
    Pair<LightboxPage, OneIDTrackerEvent> getPendingPageAndEvent();

    @NotNull
    String getUserAgent();

    void initializeBridge();

    boolean loadBundle(@NotNull Context appContext, @Nullable TrackerEventKey conversationEventKey, boolean forceLoadBundle);

    void setBundleLoaded(boolean z);

    void setHolder(@Nullable WebViewHolder webViewHolder);

    void setLightboxReady(boolean z);

    void setOwner(@Nullable WebViewOwner webViewOwner);

    void setPendingPageAndEvent(@Nullable Pair<? extends LightboxPage, OneIDTrackerEvent> pair);

    void setStarterPage();

    void showPage(@NotNull LightboxPage page, @Nullable OneIDTrackerEvent event);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "", "pageName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "inputData", "Lorg/json/JSONObject;", "getInputData", "()Lorg/json/JSONObject;", "setInputData", "(Lorg/json/JSONObject;)V", LightboxActivity.CONFIGS_EXTRA, "Lcom/disney/id/android/OptionalConfigs;", "getOptionalConfigs", "()Lcom/disney/id/android/OptionalConfigs;", "setOptionalConfigs", "(Lcom/disney/id/android/OptionalConfigs;)V", "getPageName", "()Ljava/lang/String;", "shouldTrackTimeout", "", "EMAIL_VERIFICATION", "EXPIRED_SESSION", "IDENTITYFLOW", "LOGIN", "NEWSLETTERS", "PPU", "READY", "REAUTH", "REGISTER", "UPDATE_PROFILE", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LightboxPage {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LightboxPage[] $VALUES;
        public static final LightboxPage EMAIL_VERIFICATION = new LightboxPage("EMAIL_VERIFICATION", 0, "emailVerification");
        public static final LightboxPage EXPIRED_SESSION = new LightboxPage("EXPIRED_SESSION", 1, "expiredSession");
        public static final LightboxPage IDENTITYFLOW = new LightboxPage("IDENTITYFLOW", 2, "identityFlow");
        public static final LightboxPage LOGIN = new LightboxPage("LOGIN", 3, FirebaseAnalytics.Event.LOGIN);
        public static final LightboxPage NEWSLETTERS = new LightboxPage("NEWSLETTERS", 4, "newsletters");
        public static final LightboxPage PPU = new LightboxPage("PPU", 5, "ppu");
        public static final LightboxPage READY = new LightboxPage("READY", 6, "ready");
        public static final LightboxPage REAUTH = new LightboxPage("REAUTH", 7, "reauth");
        public static final LightboxPage REGISTER = new LightboxPage("REGISTER", 8, "registration");
        public static final LightboxPage UPDATE_PROFILE = new LightboxPage("UPDATE_PROFILE", 9, "profile");
        private JSONObject inputData;
        private OptionalConfigs optionalConfigs;
        private final String pageName;

        private static final /* synthetic */ LightboxPage[] $values() {
            return new LightboxPage[]{EMAIL_VERIFICATION, EXPIRED_SESSION, IDENTITYFLOW, LOGIN, NEWSLETTERS, PPU, READY, REAUTH, REGISTER, UPDATE_PROFILE};
        }

        @NotNull
        public static EnumEntries<LightboxPage> getEntries() {
            return $ENTRIES;
        }

        public static LightboxPage valueOf(String str) {
            return (LightboxPage) Enum.valueOf(LightboxPage.class, str);
        }

        public static LightboxPage[] values() {
            return (LightboxPage[]) $VALUES.clone();
        }

        private LightboxPage(String str, int i, String str2) {
            this.pageName = str2;
        }

        @NotNull
        public final String getPageName() {
            return this.pageName;
        }

        static {
            LightboxPage[] lightboxPageArr$values = $values();
            $VALUES = lightboxPageArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(lightboxPageArr$values);
        }

        @Nullable
        public final OptionalConfigs getOptionalConfigs() {
            return this.optionalConfigs;
        }

        public final void setOptionalConfigs(@Nullable OptionalConfigs optionalConfigs) {
            this.optionalConfigs = optionalConfigs;
        }

        @Nullable
        public final JSONObject getInputData() {
            return this.inputData;
        }

        public final void setInputData(@Nullable JSONObject jSONObject) {
            this.inputData = jSONObject;
        }

        public final boolean shouldTrackTimeout() {
            return this != READY;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean loadBundle$default(LightboxWebView lightboxWebView, Context context, TrackerEventKey trackerEventKey, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBundle");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return lightboxWebView.loadBundle(context, trackerEventKey, z);
        }

        public static /* synthetic */ void showPage$default(LightboxWebView lightboxWebView, LightboxPage lightboxPage, OneIDTrackerEvent oneIDTrackerEvent, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPage");
            }
            if ((i & 2) != 0) {
                oneIDTrackerEvent = null;
            }
            lightboxWebView.showPage(lightboxPage, oneIDTrackerEvent);
        }
    }
}
