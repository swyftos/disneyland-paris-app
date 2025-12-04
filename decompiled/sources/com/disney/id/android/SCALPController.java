package com.disney.id.android;

import android.content.Context;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.tracker.TrackerEventKey;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001:\u0002>?J\b\u0010\u0017\u001a\u00020\u0018H&J(\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\n\u0010 \u001a\u0004\u0018\u00010\u001cH&J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\n\u0010#\u001a\u0004\u0018\u00010\u0003H&J\n\u0010$\u001a\u0004\u0018\u00010\u0003H&J\n\u0010%\u001a\u0004\u0018\u00010\"H&J\n\u0010&\u001a\u0004\u0018\u00010\"H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H&J\u0012\u0010)\u001a\u0004\u0018\u00010\"2\u0006\u0010*\u001a\u00020\u0003H&J\n\u0010+\u001a\u0004\u0018\u00010\u001cH&J\n\u0010,\u001a\u0004\u0018\u00010\u001cH&J \u0010-\u001a\u0004\u0018\u00010\u00032\b\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010/\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\u00032\u0006\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0018H&J\b\u00102\u001a\u00020\u0018H&J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u000205H'J,\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\u00032\u0006\u00108\u001a\u0002092\b\u0010.\u001a\u0004\u0018\u00010\u00032\u0006\u0010:\u001a\u00020;H&J\u001a\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007¨\u0006@"}, d2 = {"Lcom/disney/id/android/SCALPController;", "", "assertedCountry", "", "getAssertedCountry", "()Ljava/lang/String;", "setAssertedCountry", "(Ljava/lang/String;)V", "isLoaded", "Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;", "()Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;", "setLoaded", "(Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;)V", "onLoadedChanged", "Lkotlin/Function2;", "", "getOnLoadedChanged", "()Lkotlin/jvm/functions/Function2;", "setOnLoadedChanged", "(Lkotlin/jvm/functions/Function2;)V", LightboxActivity.UI_VERSION_EXTRA, "getUiVersion", "setUiVersion", "canAutogenerateUsername", "", "getAgeBands", "Ljava/util/HashMap;", "Lcom/disney/id/android/AgeBand;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "getBundleVersion", "getBundlerURL", "getCompliance", "getCountries", "Lorg/json/JSONArray;", "getCountryCode", "getDetectedCountry", "getLegalDisclosures", "getMarketingEntities", "getMessage", "textId", "getNewslettersForCampaignId", Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, "getRegisterFields", "getSiteConfig", "hasCachedMobileConfig", "ageBand", "hasPromotionId", "promotionID", "isBiometricEnabled", "isExpiredNotificationEnabled", "isHeadlessAllowed", "eventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "load", "conversationId", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/SCALPController$LoadListener;", "loadFromCache", "version", "LoadListener", "SiteConfigDownloadStatus", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SCALPController {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/SCALPController$LoadListener;", "", "configLoadComplete", "", "bundleVersion", "", "bundlerURL", "configLoadError", "transactionEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface LoadListener {
        void configLoadComplete(@NotNull String bundleVersion, @NotNull String bundlerURL);

        void configLoadError(@NotNull TrackerEventKey transactionEventKey, @NotNull String error);
    }

    boolean canAutogenerateUsername();

    @Nullable
    HashMap<AgeBand, JSONObject> getAgeBands();

    @Nullable
    String getAssertedCountry();

    @NotNull
    String getBundleVersion();

    @NotNull
    String getBundlerURL();

    @Nullable
    JSONObject getCompliance();

    @Nullable
    JSONArray getCountries();

    @Nullable
    String getCountryCode();

    @Nullable
    String getDetectedCountry();

    @Nullable
    JSONArray getLegalDisclosures();

    @Nullable
    JSONArray getMarketingEntities();

    @NotNull
    String getMessage(@NotNull String textId);

    @Nullable
    JSONArray getNewslettersForCampaignId(@NotNull String campaignId);

    @Nullable
    Function2<SiteConfigDownloadStatus, SiteConfigDownloadStatus, Unit> getOnLoadedChanged();

    @Nullable
    JSONObject getRegisterFields();

    @Nullable
    JSONObject getSiteConfig();

    @Nullable
    String getUiVersion();

    @Nullable
    String hasCachedMobileConfig(@Nullable String ageBand, @Nullable String uiVersion);

    boolean hasPromotionId(@Nullable String ageBand, @NotNull String promotionID);

    boolean isBiometricEnabled();

    boolean isExpiredNotificationEnabled();

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    boolean isHeadlessAllowed(@NotNull TrackerEventKey eventKey);

    @Nullable
    SiteConfigDownloadStatus isLoaded();

    void load(@Nullable String conversationId, @NotNull Context context, @Nullable String ageBand, @NotNull LoadListener listener);

    void loadFromCache(@NotNull String version, @Nullable String ageBand);

    void setAssertedCountry(@Nullable String str);

    void setLoaded(@Nullable SiteConfigDownloadStatus siteConfigDownloadStatus);

    void setOnLoadedChanged(@Nullable Function2<? super SiteConfigDownloadStatus, ? super SiteConfigDownloadStatus, Unit> function2);

    void setUiVersion(@Nullable String str);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String hasCachedMobileConfig$default(SCALPController sCALPController, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasCachedMobileConfig");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return sCALPController.hasCachedMobileConfig(str, str2);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;", "", "(Ljava/lang/String;I)V", "Downloaded", "FailedToDownload", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SiteConfigDownloadStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SiteConfigDownloadStatus[] $VALUES;
        public static final SiteConfigDownloadStatus Downloaded = new SiteConfigDownloadStatus("Downloaded", 0);
        public static final SiteConfigDownloadStatus FailedToDownload = new SiteConfigDownloadStatus("FailedToDownload", 1);

        private static final /* synthetic */ SiteConfigDownloadStatus[] $values() {
            return new SiteConfigDownloadStatus[]{Downloaded, FailedToDownload};
        }

        @NotNull
        public static EnumEntries<SiteConfigDownloadStatus> getEntries() {
            return $ENTRIES;
        }

        public static SiteConfigDownloadStatus valueOf(String str) {
            return (SiteConfigDownloadStatus) Enum.valueOf(SiteConfigDownloadStatus.class, str);
        }

        public static SiteConfigDownloadStatus[] values() {
            return (SiteConfigDownloadStatus[]) $VALUES.clone();
        }

        private SiteConfigDownloadStatus(String str, int i) {
        }

        static {
            SiteConfigDownloadStatus[] siteConfigDownloadStatusArr$values = $values();
            $VALUES = siteConfigDownloadStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(siteConfigDownloadStatusArr$values);
        }
    }
}
