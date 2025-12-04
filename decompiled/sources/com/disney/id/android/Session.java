package com.disney.id.android;

import androidx.autofill.HintConstants;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.tracker.TrackerEventKey;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001:\u0002;<J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J4\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J \u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\rH&J2\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001cH&J\u0014\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H&J:\u0010!\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\"\u001a\u00020\tH&J(\u0010#\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020$2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010%\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H&JX\u0010&\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010(2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010(2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J(\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u0002002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\rH&J\u0012\u00102\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J2\u00103\u001a\u00020\t2\u0006\u00104\u001a\u0002052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J2\u00106\u001a\u00020\t2\u0006\u00107\u001a\u0002082\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J2\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006="}, d2 = {"Lcom/disney/id/android/Session;", "", "owner", "Lcom/disney/id/android/Session$Owner;", "getOwner", "()Lcom/disney/id/android/Session$Owner;", "setOwner", "(Lcom/disney/id/android/Session$Owner;)V", "beginRecovery", "", "lookupValue", "Lcom/disney/id/android/LookupValue;", "conversationId", "", LightboxActivity.CONFIGS_EXTRA, "Lcom/disney/id/android/OptionalConfigs;", "callback", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/OneIDCallbackData;", "completeRecovery", HintConstants.AUTOFILL_HINT_PASSWORD, "Lcom/disney/id/android/GuestCallbackData;", ViewProps.END, "getCountryCode", "getGuestFlow", "loginValue", "Lcom/disney/id/android/GuestFlowCallbackData;", "highTrust", "", "isLoggedIn", "loadGuestFromStorage", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", FirebaseAnalytics.Event.LOGIN, "notifyOwnerOfLogout", "refreshGuest", "Lcom/disney/id/android/Session$ResultCallback;", "refreshTokenExpired", "register", "fields", "", "Lcom/disney/id/android/Field;", "marketing", "Lcom/disney/id/android/MarketingDetail;", "legal", "Lcom/disney/id/android/LegalDetail;", "scheduleTokenRefresh", "delayUntilRefresh", "", "sourceEventInfo", "shouldGuestBeRefreshed", "updateGuest", "updateBody", "Lcom/google/gson/JsonObject;", "updateMarketing", "newsletterDetails", "Lcom/disney/id/android/NewsletterDetails;", "validateOTP", "otp", "Owner", "ResultCallback", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Session {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/Session$ResultCallback;", "", "onFailure", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "onSuccess", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ResultCallback {
        void onFailure(@NotNull OneIDError error);

        void onSuccess();
    }

    void beginRecovery(@NotNull LookupValue lookupValue, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs, @NotNull OneIDCallback<OneIDCallbackData> callback);

    void completeRecovery(@Nullable String password, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs);

    void end(@Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId);

    @Nullable
    String getCountryCode();

    void getGuestFlow(@NotNull String loginValue, @NotNull OneIDCallback<GuestFlowCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs);

    @Nullable
    Owner getOwner();

    boolean highTrust();

    boolean isLoggedIn();

    void loadGuestFromStorage(@Nullable TrackerEventKey trackerEventKey);

    void login(@NotNull String loginValue, @NotNull String password, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs);

    void notifyOwnerOfLogout();

    void refreshGuest(@NotNull ResultCallback callback, @Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId);

    boolean refreshTokenExpired(@Nullable TrackerEventKey trackerEventKey);

    void register(@NotNull List<Field> fields, @Nullable List<MarketingDetail> marketing, @Nullable List<LegalDetail> legal, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs);

    void scheduleTokenRefresh(long delayUntilRefresh, @Nullable String conversationId, @Nullable String sourceEventInfo);

    void setOwner(@Nullable Owner owner);

    boolean shouldGuestBeRefreshed(@Nullable TrackerEventKey trackerEventKey);

    void updateGuest(@NotNull JsonObject updateBody, @Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId, @NotNull OneIDCallback<OneIDCallbackData> callback);

    void updateMarketing(@NotNull NewsletterDetails newsletterDetails, @Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId, @NotNull OneIDCallback<OneIDCallbackData> callback);

    void validateOTP(@NotNull String otp, @NotNull OneIDCallback<OneIDCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001e\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/disney/id/android/Session$Owner;", "", "notifyOfLogout", "", "tokenRefreshFailure", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "tokenRefreshPPU", "ppus", "", "Lcom/disney/id/android/PPU;", "tokenRefreshSuccess", "ppuData", "Lorg/json/JSONObject;", "conversationId", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Owner {
        void notifyOfLogout();

        void tokenRefreshFailure(@Nullable OneIDError error);

        void tokenRefreshPPU(@NotNull List<? extends PPU> ppus);

        void tokenRefreshSuccess(@Nullable JSONObject ppuData, @Nullable String conversationId);

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void tokenRefreshSuccess$default(Owner owner, JSONObject jSONObject, String str, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tokenRefreshSuccess");
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                owner.tokenRefreshSuccess(jSONObject, str);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void loadGuestFromStorage$default(Session session, TrackerEventKey trackerEventKey, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadGuestFromStorage");
            }
            if ((i & 1) != 0) {
                trackerEventKey = null;
            }
            session.loadGuestFromStorage(trackerEventKey);
        }

        public static /* synthetic */ void end$default(Session session, OptionalConfigs optionalConfigs, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: end");
            }
            if ((i & 1) != 0) {
                optionalConfigs = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            session.end(optionalConfigs, str);
        }

        public static /* synthetic */ void refreshGuest$default(Session session, ResultCallback resultCallback, OptionalConfigs optionalConfigs, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshGuest");
            }
            if ((i & 2) != 0) {
                optionalConfigs = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            session.refreshGuest(resultCallback, optionalConfigs, str);
        }

        public static /* synthetic */ void scheduleTokenRefresh$default(Session session, long j, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scheduleTokenRefresh");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            session.scheduleTokenRefresh(j, str, str2);
        }
    }
}
