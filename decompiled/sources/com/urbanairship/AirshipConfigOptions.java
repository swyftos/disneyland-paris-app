package com.urbanairship;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import com.urbanairship.PrivacyManager;
import com.urbanairship.channel.AirshipChannelCreateOption;
import com.urbanairship.inputvalidation.AirshipValidationOverride;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushProvider;
import com.urbanairship.util.PropertiesConfigParser;
import com.urbanairship.util.UAStringUtil;
import com.urbanairship.util.XmlConfigParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class AirshipConfigOptions {

    @NonNull
    public static final String ADM_TRANSPORT = "ADM";
    private static final Pattern APP_CREDENTIAL_PATTERN = Pattern.compile("^[a-zA-Z0-9\\-_]{22}$");

    @NonNull
    public static final String FCM_TRANSPORT = "FCM";

    @NonNull
    public static final String FEATURE_ALL = "all";

    @NonNull
    public static final String FEATURE_ANALYTICS = "analytics";

    @NonNull
    public static final String FEATURE_CONTACTS = "contacts";

    @NonNull
    public static final String FEATURE_FEATURE_FLAGS = "feature_flags";

    @NonNull
    public static final String FEATURE_IN_APP_AUTOMATION = "in_app_automation";

    @NonNull
    public static final String FEATURE_MESSAGE_CENTER = "message_center";

    @NonNull
    public static final String FEATURE_NONE = "none";

    @NonNull
    public static final String FEATURE_PUSH = "push";

    @NonNull
    public static final String FEATURE_TAGS_AND_ATTRIBUTES = "tags_and_attributes";

    @NonNull
    public static final String HMS_TRANSPORT = "HMS";

    @NonNull
    public static final String SITE_EU = "EU";

    @NonNull
    public static final String SITE_US = "US";

    @NonNull
    public final List<String> allowedTransports;
    public final boolean analyticsEnabled;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String analyticsUrl;

    @NonNull
    public final String appKey;

    @NonNull
    public final String appSecret;

    @Nullable
    public final Uri appStoreUri;
    public final boolean autoLaunchApplication;
    public final boolean autoPauseInAppAutomationOnLaunch;
    public final long backgroundReportingIntervalMS;
    public final boolean channelCaptureEnabled;

    @Nullable
    public final AirshipChannelCreateOption channelCreateOption;
    public final boolean channelCreationDelayEnabled;

    @Nullable
    public final PushProvider customPushProvider;

    @Deprecated
    public final boolean dataCollectionOptInEnabled;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String deviceUrl;
    public final PrivacyManager.Feature enabledFeatures;
    public final boolean extendedBroadcastsEnabled;

    @Nullable
    public final String fcmFirebaseAppName;
    public final boolean inProduction;

    @Nullable
    public final String initialConfigUrl;
    final boolean isAllowListScopeOpenSet;
    final boolean isAllowListSet;
    public final boolean isPromptForPermissionOnUserNotificationsEnabled;
    public final int logLevel;
    public final PrivacyLevel logPrivacyLevel;

    @ColorInt
    public final int notificationAccentColor;

    @Nullable
    public final String notificationChannel;

    @DrawableRes
    public final int notificationIcon;

    @DrawableRes
    public final int notificationLargeIcon;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String remoteDataUrl;
    public final boolean requireInitialRemoteConfigEnabled;
    public final boolean resetEnabledFeatures;

    @NonNull
    public final List<String> urlAllowList;

    @NonNull
    public final List<String> urlAllowListScopeJavaScriptInterface;

    @NonNull
    public final List<String> urlAllowListScopeOpenUrl;

    @Nullable
    public final AirshipValidationOverride validationOverride;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String walletUrl;

    public enum PrivacyLevel {
        PRIVATE,
        PUBLIC
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Site {
    }

    public static class ConfigException extends Exception {
        public ConfigException(@NonNull String str, @Nullable Throwable th) {
            super(str, th);
        }
    }

    private AirshipConfigOptions(Builder builder) {
        if (builder.inProduction.booleanValue()) {
            this.appKey = firstOrEmpty(builder.productionAppKey, builder.appKey);
            this.appSecret = firstOrEmpty(builder.productionAppSecret, builder.appSecret);
            this.logLevel = first(builder.productionLogLevel, builder.logLevel, 6);
            this.logPrivacyLevel = builder.productionLogPrivacyLevel;
        } else {
            this.appKey = firstOrEmpty(builder.developmentAppKey, builder.appKey);
            this.appSecret = firstOrEmpty(builder.developmentAppSecret, builder.appSecret);
            this.logLevel = first(builder.developmentLogLevel, builder.logLevel, 3);
            this.logPrivacyLevel = builder.developmentLogPrivacyLevel;
        }
        String str = builder.site;
        int iHashCode = str.hashCode();
        if (iHashCode == 2224) {
            if (str.equals(SITE_EU)) {
                this.deviceUrl = firstOrEmpty(builder.deviceUrl, "https://device-api.asnapieu.com/");
                this.analyticsUrl = firstOrEmpty(builder.analyticsUrl, "https://combine.asnapieu.com/");
                this.remoteDataUrl = firstOrEmpty(builder.remoteDataUrl, "https://remote-data.asnapieu.com/");
                this.walletUrl = firstOrEmpty(builder.walletUrl, "https://wallet-api.asnapieu.com");
            }
            this.allowedTransports = Collections.unmodifiableList(new ArrayList(builder.allowedTransports));
            this.urlAllowList = copyOrEmpty(builder.urlAllowList);
            this.urlAllowListScopeJavaScriptInterface = copyOrEmpty(builder.urlAllowListScopeJavaScriptInterface);
            this.urlAllowListScopeOpenUrl = copyOrEmpty(builder.urlAllowListScopeOpenUrl);
            this.isAllowListScopeOpenSet = builder.isAllowListScopeOpenSet;
            this.isAllowListSet = builder.isAllowListSet;
            this.inProduction = builder.inProduction.booleanValue();
            this.analyticsEnabled = builder.analyticsEnabled;
            this.backgroundReportingIntervalMS = builder.backgroundReportingIntervalMS;
            this.autoLaunchApplication = builder.autoLaunchApplication;
            this.channelCreationDelayEnabled = builder.channelCreationDelayEnabled;
            this.channelCaptureEnabled = builder.channelCaptureEnabled;
            this.notificationIcon = builder.notificationIcon;
            this.notificationLargeIcon = builder.notificationLargeIcon;
            this.notificationAccentColor = builder.notificationAccentColor;
            this.notificationChannel = builder.notificationChannel;
            this.customPushProvider = builder.customPushProvider;
            this.appStoreUri = builder.appStoreUri;
            this.dataCollectionOptInEnabled = builder.dataCollectionOptInEnabled;
            this.enabledFeatures = builder.enabledFeatures;
            this.resetEnabledFeatures = builder.resetEnabledFeatures;
            this.extendedBroadcastsEnabled = builder.extendedBroadcastsEnabled;
            this.requireInitialRemoteConfigEnabled = builder.requireInitialRemoteConfigEnabled;
            this.fcmFirebaseAppName = builder.fcmFirebaseAppName;
            this.initialConfigUrl = builder.initialConfigUrl;
            this.isPromptForPermissionOnUserNotificationsEnabled = builder.isPromptForPermissionOnUserNotificationsEnabled;
            this.autoPauseInAppAutomationOnLaunch = builder.autoPauseInAppAutomationOnLaunch;
            this.channelCreateOption = builder.channelCreateOption;
            this.validationOverride = builder.validationOverride;
        }
        if (iHashCode == 2718) {
            str.equals(SITE_US);
        }
        this.deviceUrl = firstOrEmpty(builder.deviceUrl, "https://device-api.urbanairship.com/");
        this.analyticsUrl = firstOrEmpty(builder.analyticsUrl, "https://combine.urbanairship.com/");
        this.remoteDataUrl = firstOrEmpty(builder.remoteDataUrl, "https://remote-data.urbanairship.com/");
        this.walletUrl = firstOrEmpty(builder.walletUrl, "https://wallet-api.urbanairship.com");
        this.allowedTransports = Collections.unmodifiableList(new ArrayList(builder.allowedTransports));
        this.urlAllowList = copyOrEmpty(builder.urlAllowList);
        this.urlAllowListScopeJavaScriptInterface = copyOrEmpty(builder.urlAllowListScopeJavaScriptInterface);
        this.urlAllowListScopeOpenUrl = copyOrEmpty(builder.urlAllowListScopeOpenUrl);
        this.isAllowListScopeOpenSet = builder.isAllowListScopeOpenSet;
        this.isAllowListSet = builder.isAllowListSet;
        this.inProduction = builder.inProduction.booleanValue();
        this.analyticsEnabled = builder.analyticsEnabled;
        this.backgroundReportingIntervalMS = builder.backgroundReportingIntervalMS;
        this.autoLaunchApplication = builder.autoLaunchApplication;
        this.channelCreationDelayEnabled = builder.channelCreationDelayEnabled;
        this.channelCaptureEnabled = builder.channelCaptureEnabled;
        this.notificationIcon = builder.notificationIcon;
        this.notificationLargeIcon = builder.notificationLargeIcon;
        this.notificationAccentColor = builder.notificationAccentColor;
        this.notificationChannel = builder.notificationChannel;
        this.customPushProvider = builder.customPushProvider;
        this.appStoreUri = builder.appStoreUri;
        this.dataCollectionOptInEnabled = builder.dataCollectionOptInEnabled;
        this.enabledFeatures = builder.enabledFeatures;
        this.resetEnabledFeatures = builder.resetEnabledFeatures;
        this.extendedBroadcastsEnabled = builder.extendedBroadcastsEnabled;
        this.requireInitialRemoteConfigEnabled = builder.requireInitialRemoteConfigEnabled;
        this.fcmFirebaseAppName = builder.fcmFirebaseAppName;
        this.initialConfigUrl = builder.initialConfigUrl;
        this.isPromptForPermissionOnUserNotificationsEnabled = builder.isPromptForPermissionOnUserNotificationsEnabled;
        this.autoPauseInAppAutomationOnLaunch = builder.autoPauseInAppAutomationOnLaunch;
        this.channelCreateOption = builder.channelCreateOption;
        this.validationOverride = builder.validationOverride;
    }

    private static List copyOrEmpty(List list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public void validate() {
        String str = this.inProduction ? "production" : "development";
        Pattern pattern = APP_CREDENTIAL_PATTERN;
        if (!pattern.matcher(this.appKey).matches()) {
            throw new IllegalArgumentException("AirshipConfigOptions: " + this.appKey + " is not a valid " + str + " app key");
        }
        if (!pattern.matcher(this.appSecret).matches()) {
            throw new IllegalArgumentException("AirshipConfigOptions: " + this.appSecret + " is not a valid " + str + " app secret");
        }
        long j = this.backgroundReportingIntervalMS;
        if (j < 60000) {
            UALog.w("AirshipConfigOptions - The backgroundReportingIntervalMS %s may decrease battery life.", Long.valueOf(j));
        } else if (j > 86400000) {
            UALog.w("AirshipConfigOptions - The backgroundReportingIntervalMS %s may provide less detailed analytic reports.", Long.valueOf(j));
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String parseSite(String str) {
        if (SITE_EU.equalsIgnoreCase(str)) {
            return SITE_EU;
        }
        if (SITE_US.equalsIgnoreCase(str)) {
            return SITE_US;
        }
        throw new IllegalArgumentException("Invalid site: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrivacyLevel parseLogPrivacyLevel(String str) {
        PrivacyLevel privacyLevel = PrivacyLevel.PRIVATE;
        if (privacyLevel.name().equalsIgnoreCase(str)) {
            return privacyLevel;
        }
        PrivacyLevel privacyLevel2 = PrivacyLevel.PUBLIC;
        if (privacyLevel2.name().equalsIgnoreCase(str)) {
            return privacyLevel2;
        }
        throw new IllegalArgumentException("Invalid log privacy level: " + str);
    }

    private static String firstOrEmpty(String... strArr) {
        for (String str : strArr) {
            if (!UAStringUtil.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private static int first(Integer... numArr) {
        for (Integer num : numArr) {
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    public static final class Builder {
        private String analyticsUrl;
        private String appKey;
        private String appSecret;
        private Uri appStoreUri;
        private boolean autoLaunchApplication;
        private boolean autoPauseInAppAutomationOnLaunch;
        private boolean channelCaptureEnabled;
        private AirshipChannelCreateOption channelCreateOption;
        private boolean channelCreationDelayEnabled;
        private PushProvider customPushProvider;
        private boolean dataCollectionOptInEnabled;
        private String developmentAppKey;
        private String developmentAppSecret;
        private Integer developmentLogLevel;
        private PrivacyLevel developmentLogPrivacyLevel;
        private String deviceUrl;
        public PrivacyManager.Feature enabledFeatures;
        private boolean extendedBroadcastsEnabled;
        private String fcmFirebaseAppName;
        private String initialConfigUrl;
        private boolean isPromptForPermissionOnUserNotificationsEnabled;
        private Integer logLevel;
        private int notificationAccentColor;
        private String notificationChannel;
        private int notificationIcon;
        private int notificationLargeIcon;
        private String productionAppKey;
        private String productionAppSecret;
        private Integer productionLogLevel;
        private PrivacyLevel productionLogPrivacyLevel;
        private String remoteDataUrl;
        private boolean requireInitialRemoteConfigEnabled;
        public boolean resetEnabledFeatures;
        private String site;
        private AirshipValidationOverride validationOverride;
        private String walletUrl;
        private List allowedTransports = new ArrayList(Arrays.asList(AirshipConfigOptions.ADM_TRANSPORT, "FCM", AirshipConfigOptions.HMS_TRANSPORT));
        private List urlAllowList = null;
        private List urlAllowListScopeJavaScriptInterface = null;
        private List urlAllowListScopeOpenUrl = null;
        private boolean isAllowListScopeOpenSet = false;
        private boolean isAllowListSet = false;
        private Boolean inProduction = null;
        private boolean analyticsEnabled = true;
        private long backgroundReportingIntervalMS = 86400000;

        public Builder() {
            PrivacyLevel privacyLevel = PrivacyLevel.PRIVATE;
            this.developmentLogPrivacyLevel = privacyLevel;
            this.productionLogPrivacyLevel = privacyLevel;
            this.autoLaunchApplication = true;
            this.channelCreationDelayEnabled = false;
            this.channelCaptureEnabled = true;
            this.notificationAccentColor = 0;
            this.site = AirshipConfigOptions.SITE_US;
            this.enabledFeatures = PrivacyManager.Feature.ALL;
            this.resetEnabledFeatures = false;
            this.requireInitialRemoteConfigEnabled = true;
            this.isPromptForPermissionOnUserNotificationsEnabled = true;
            this.autoPauseInAppAutomationOnLaunch = false;
            this.channelCreateOption = null;
        }

        @NonNull
        public Builder applyDefaultProperties(@NonNull Context context) {
            return applyProperties(context, "airshipconfig.properties");
        }

        @NonNull
        public Builder tryApplyDefaultProperties(@NonNull Context context) throws ConfigException {
            return tryApplyProperties(context, "airshipconfig.properties");
        }

        @NonNull
        public Builder applyProperties(@NonNull Context context, @NonNull String str) {
            try {
                tryApplyProperties(context, str);
            } catch (Exception e) {
                UALog.e(e);
            }
            return this;
        }

        @NonNull
        public Builder tryApplyProperties(@NonNull Context context, @NonNull String str) throws ConfigException {
            try {
                applyConfigParser(context, PropertiesConfigParser.fromAssets(context, str));
                return this;
            } catch (Exception e) {
                throw new ConfigException("Unable to apply config from file " + str, e);
            }
        }

        @NonNull
        public Builder applyProperties(@NonNull Context context, @NonNull Properties properties) {
            try {
                applyConfigParser(context, PropertiesConfigParser.fromProperties(context, properties));
            } catch (Exception e) {
                UALog.e(e);
            }
            return this;
        }

        @NonNull
        public Builder tryApplyProperties(@NonNull Context context, @NonNull Properties properties) throws ConfigException {
            try {
                applyConfigParser(context, PropertiesConfigParser.fromProperties(context, properties));
                return this;
            } catch (Exception e) {
                throw new ConfigException("Unable to apply config.", e);
            }
        }

        @NonNull
        public Builder applyConfig(@NonNull Context context, @XmlRes int i) {
            try {
                tryApplyConfig(context, i);
            } catch (Exception e) {
                UALog.e(e);
            }
            return this;
        }

        @NonNull
        public Builder tryApplyConfig(@NonNull Context context, @XmlRes int i) throws Exception {
            XmlConfigParser element = null;
            try {
                try {
                    element = XmlConfigParser.parseElement(context, i, "AirshipConfigOptions");
                    applyConfigParser(context, element);
                    return this;
                } catch (Exception e) {
                    throw new ConfigException("Unable to apply config from xml.", e);
                }
            } finally {
                if (element != null) {
                    element.close();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:163:0x0267  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void applyConfigParser(android.content.Context r9, com.urbanairship.util.ConfigParser r10) {
            /*
                Method dump skipped, instructions count: 1494
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.AirshipConfigOptions.Builder.applyConfigParser(android.content.Context, com.urbanairship.util.ConfigParser):void");
        }

        private PrivacyManager.Feature convertFeatureNames(String[] strArr) {
            try {
                return PrivacyManager.Feature.fromJson(JsonValue.wrap(strArr));
            } catch (Exception e) {
                UALog.e(e, "Failed to parse features array " + String.join(",", strArr), new Object[0]);
                return PrivacyManager.Feature.NONE;
            }
        }

        @NonNull
        public Builder setNotificationChannel(@Nullable String str) {
            this.notificationChannel = str;
            return this;
        }

        @NonNull
        public Builder setNotificationIcon(@DrawableRes int i) {
            this.notificationIcon = i;
            return this;
        }

        @NonNull
        public Builder setNotificationLargeIcon(@DrawableRes int i) {
            this.notificationLargeIcon = i;
            return this;
        }

        @NonNull
        public Builder setNotificationAccentColor(@ColorInt int i) {
            this.notificationAccentColor = i;
            return this;
        }

        @NonNull
        public Builder setAppKey(@Nullable String str) {
            this.appKey = str;
            return this;
        }

        @NonNull
        public Builder setAppSecret(@Nullable String str) {
            this.appSecret = str;
            return this;
        }

        @NonNull
        public Builder setProductionAppKey(@Nullable String str) {
            this.productionAppKey = str;
            return this;
        }

        @NonNull
        public Builder setProductionAppSecret(@Nullable String str) {
            this.productionAppSecret = str;
            return this;
        }

        @NonNull
        public Builder setDevelopmentAppKey(@Nullable String str) {
            this.developmentAppKey = str;
            return this;
        }

        @NonNull
        public Builder setDevelopmentAppSecret(@Nullable String str) {
            this.developmentAppSecret = str;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDeviceUrl(@NonNull String str) {
            this.deviceUrl = str;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setAnalyticsUrl(@NonNull String str) {
            this.analyticsUrl = str;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setRemoteDataUrl(@Nullable String str) {
            this.remoteDataUrl = str;
            return this;
        }

        @NonNull
        public Builder setInitialConfigUrl(@Nullable String str) {
            this.initialConfigUrl = str;
            return this;
        }

        @NonNull
        public Builder setAllowedTransports(@Nullable String[] strArr) {
            this.allowedTransports.clear();
            if (strArr != null) {
                this.allowedTransports.addAll(Arrays.asList(strArr));
            }
            return this;
        }

        @NonNull
        public Builder setUrlAllowList(@Nullable String[] strArr) {
            if (strArr != null) {
                this.urlAllowList = Arrays.asList(strArr);
            } else {
                this.urlAllowList = null;
            }
            this.isAllowListSet = true;
            return this;
        }

        @NonNull
        public Builder setUrlAllowListScopeJavaScriptInterface(@Nullable String[] strArr) {
            if (strArr != null) {
                this.urlAllowListScopeJavaScriptInterface = Arrays.asList(strArr);
            } else {
                this.urlAllowListScopeJavaScriptInterface = null;
            }
            return this;
        }

        @NonNull
        public Builder setUrlAllowListScopeOpenUrl(@Nullable String[] strArr) {
            if (strArr != null) {
                this.urlAllowListScopeOpenUrl = Arrays.asList(strArr);
            } else {
                this.urlAllowListScopeOpenUrl = null;
            }
            this.isAllowListScopeOpenSet = true;
            return this;
        }

        @NonNull
        public Builder setInProduction(boolean z) {
            this.inProduction = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public Builder detectProvisioningMode(@NonNull Context context) {
            try {
                this.inProduction = Boolean.valueOf(!((Boolean) Class.forName(context.getPackageName() + ".BuildConfig").getField("DEBUG").get(null)).booleanValue());
            } catch (Exception unused) {
                UALog.w("AirshipConfigOptions - Unable to determine the build mode. Defaulting to debug.", new Object[0]);
                this.inProduction = Boolean.FALSE;
            }
            return this;
        }

        @NonNull
        public Builder setAnalyticsEnabled(boolean z) {
            this.analyticsEnabled = z;
            return this;
        }

        @NonNull
        public Builder setBackgroundReportingIntervalMS(long j) {
            this.backgroundReportingIntervalMS = j;
            return this;
        }

        @NonNull
        public Builder setDevelopmentLogLevel(int i) {
            this.developmentLogLevel = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder setProductionLogLevel(int i) {
            this.productionLogLevel = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder setLogLevel(int i) {
            this.logLevel = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder setDevelopmentLogPrivacyLevel(PrivacyLevel privacyLevel) {
            this.developmentLogPrivacyLevel = privacyLevel;
            return this;
        }

        @NonNull
        public Builder setProductionLogPrivacyLevel(PrivacyLevel privacyLevel) {
            this.productionLogPrivacyLevel = privacyLevel;
            return this;
        }

        @NonNull
        public Builder setAutoLaunchApplication(boolean z) {
            this.autoLaunchApplication = z;
            return this;
        }

        @NonNull
        public Builder setChannelCreationDelayEnabled(boolean z) {
            this.channelCreationDelayEnabled = z;
            return this;
        }

        @NonNull
        public Builder setChannelCaptureEnabled(boolean z) {
            this.channelCaptureEnabled = z;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setWalletUrl(@NonNull String str) {
            this.walletUrl = str;
            return this;
        }

        @NonNull
        public Builder setCustomPushProvider(@Nullable PushProvider pushProvider) {
            this.customPushProvider = pushProvider;
            return this;
        }

        @NonNull
        public Builder setAppStoreUri(@Nullable Uri uri) {
            this.appStoreUri = uri;
            return this;
        }

        @NonNull
        public Builder setSite(@NonNull String str) {
            this.site = str;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setDataCollectionOptInEnabled(boolean z) {
            this.dataCollectionOptInEnabled = z;
            return this;
        }

        @NonNull
        public Builder setExtendedBroadcastsEnabled(boolean z) {
            this.extendedBroadcastsEnabled = z;
            return this;
        }

        @NonNull
        public Builder setEnabledFeatures(PrivacyManager.Feature... featureArr) {
            this.enabledFeatures = PrivacyManager.Feature.combined(featureArr);
            return this;
        }

        @NonNull
        public Builder setFcmFirebaseAppName(@Nullable String str) {
            this.fcmFirebaseAppName = str;
            return this;
        }

        @NonNull
        public Builder setRequireInitialRemoteConfigEnabled(boolean z) {
            this.requireInitialRemoteConfigEnabled = z;
            return this;
        }

        @NonNull
        public Builder setIsPromptForPermissionOnUserNotificationsEnabled(boolean z) {
            this.isPromptForPermissionOnUserNotificationsEnabled = z;
            return this;
        }

        @NonNull
        public Builder setAutoPauseInAppAutomationOnLaunch(boolean z) {
            this.autoPauseInAppAutomationOnLaunch = z;
            return this;
        }

        @NonNull
        public Builder setInputValidationOverrides(AirshipValidationOverride airshipValidationOverride) {
            this.validationOverride = airshipValidationOverride;
            return this;
        }

        @NonNull
        public Builder setResetEnabledFeatures(boolean z) {
            this.resetEnabledFeatures = z;
            return this;
        }

        @NonNull
        public Builder setAirshipChannelCreateOption(@Nullable AirshipChannelCreateOption airshipChannelCreateOption) {
            this.channelCreateOption = airshipChannelCreateOption;
            return this;
        }

        @NonNull
        public AirshipConfigOptions build() {
            if (this.inProduction == null) {
                this.inProduction = Boolean.FALSE;
            }
            String str = this.productionAppKey;
            if (str != null && str.equals(this.developmentAppKey)) {
                UALog.w("Production App Key matches Development App Key", new Object[0]);
            }
            String str2 = this.productionAppSecret;
            if (str2 != null && str2.equals(this.developmentAppSecret)) {
                UALog.w("Production App Secret matches Development App Secret", new Object[0]);
            }
            if (this.dataCollectionOptInEnabled) {
                UALog.w("dataCollectionOptInEnabled is deprecated. Use enabledFeatures instead.", new Object[0]);
                if (this.enabledFeatures == PrivacyManager.Feature.ALL) {
                    this.enabledFeatures = PrivacyManager.Feature.NONE;
                }
            }
            return new AirshipConfigOptions(this);
        }
    }
}
