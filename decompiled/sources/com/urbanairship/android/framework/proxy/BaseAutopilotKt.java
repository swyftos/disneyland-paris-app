package com.urbanairship.android.framework.proxy;

import android.content.Context;
import android.net.Uri;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.PrivacyManager;
import com.urbanairship.android.framework.proxy.ProxyConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"applyProxyConfig", "", "Lcom/urbanairship/AirshipConfigOptions$Builder;", "context", "Landroid/content/Context;", "proxyConfig", "Lcom/urbanairship/android/framework/proxy/ProxyConfig;", "airship-framework-proxy_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseAutopilot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseAutopilot.kt\ncom/urbanairship/android/framework/proxy/BaseAutopilotKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,289:1\n1#2:290\n37#3,2:291\n37#3,2:293\n37#3,2:295\n*S KotlinDebug\n*F\n+ 1 BaseAutopilot.kt\ncom/urbanairship/android/framework/proxy/BaseAutopilotKt\n*L\n220#1:291,2\n221#1:293,2\n222#1:295,2\n*E\n"})
/* loaded from: classes2.dex */
public final class BaseAutopilotKt {
    public static final void applyProxyConfig(@NotNull AirshipConfigOptions.Builder builder, @NotNull Context context, @NotNull ProxyConfig proxyConfig) {
        NotificationConfig notificationConfig;
        String fcmFirebaseAppName;
        String appStoreUri;
        AirshipConfigOptions.PrivacyLevel logPrivacyLevel;
        AirshipConfigOptions.PrivacyLevel logPrivacyLevel2;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(proxyConfig, "proxyConfig");
        ProxyConfig.Environment developmentEnvironment = proxyConfig.getDevelopmentEnvironment();
        if (developmentEnvironment != null) {
            AirshipConfigOptions.Builder developmentAppSecret = builder.setDevelopmentAppKey(developmentEnvironment.getAppKey()).setDevelopmentAppSecret(developmentEnvironment.getAppSecret());
            Integer logLevel = developmentEnvironment.getLogLevel();
            developmentAppSecret.setDevelopmentLogLevel(logLevel != null ? logLevel.intValue() : 3);
            ProxyConfig.Android androidConfig = proxyConfig.getAndroidConfig();
            if (androidConfig != null && (logPrivacyLevel2 = androidConfig.getLogPrivacyLevel()) != null) {
                builder.setDevelopmentLogPrivacyLevel(logPrivacyLevel2);
            }
        }
        ProxyConfig.Environment productionEnvironment = proxyConfig.getProductionEnvironment();
        if (productionEnvironment != null) {
            AirshipConfigOptions.Builder productionAppSecret = builder.setProductionAppKey(productionEnvironment.getAppKey()).setProductionAppSecret(productionEnvironment.getAppSecret());
            Integer logLevel2 = productionEnvironment.getLogLevel();
            productionAppSecret.setProductionLogLevel(logLevel2 != null ? logLevel2.intValue() : 3);
            ProxyConfig.Android androidConfig2 = proxyConfig.getAndroidConfig();
            if (androidConfig2 != null && (logPrivacyLevel = androidConfig2.getLogPrivacyLevel()) != null) {
                builder.setProductionLogPrivacyLevel(logPrivacyLevel);
            }
        }
        ProxyConfig.Environment defaultEnvironment = proxyConfig.getDefaultEnvironment();
        if (defaultEnvironment != null) {
            AirshipConfigOptions.Builder appSecret = builder.setAppKey(defaultEnvironment.getAppKey()).setAppSecret(defaultEnvironment.getAppSecret());
            Integer logLevel3 = defaultEnvironment.getLogLevel();
            appSecret.setLogLevel(logLevel3 != null ? logLevel3.intValue() : 6);
        }
        String site = proxyConfig.getSite();
        if (site != null) {
            builder.setSite(site);
        }
        Boolean inProduction = proxyConfig.getInProduction();
        if (inProduction != null) {
            builder.setInProduction(inProduction.booleanValue());
        }
        Boolean boolIsChannelCreationDelayEnabled = proxyConfig.isChannelCreationDelayEnabled();
        if (boolIsChannelCreationDelayEnabled != null) {
            builder.setChannelCreationDelayEnabled(boolIsChannelCreationDelayEnabled.booleanValue());
        }
        Boolean boolIsChannelCaptureEnabled = proxyConfig.isChannelCaptureEnabled();
        if (boolIsChannelCaptureEnabled != null) {
            builder.setChannelCaptureEnabled(boolIsChannelCaptureEnabled.booleanValue());
        }
        String initialConfigUrl = proxyConfig.getInitialConfigUrl();
        if (initialConfigUrl != null) {
            builder.setInitialConfigUrl(initialConfigUrl);
        }
        List<String> urlAllowList = proxyConfig.getUrlAllowList();
        if (urlAllowList != null) {
            builder.setUrlAllowList((String[]) urlAllowList.toArray(new String[0]));
        }
        List<String> urlAllowListScopeJavaScriptInterface = proxyConfig.getUrlAllowListScopeJavaScriptInterface();
        if (urlAllowListScopeJavaScriptInterface != null) {
            builder.setUrlAllowListScopeJavaScriptInterface((String[]) urlAllowListScopeJavaScriptInterface.toArray(new String[0]));
        }
        List<String> urlAllowListScopeOpenUrl = proxyConfig.getUrlAllowListScopeOpenUrl();
        if (urlAllowListScopeOpenUrl != null) {
            builder.setUrlAllowListScopeOpenUrl((String[]) urlAllowListScopeOpenUrl.toArray(new String[0]));
        }
        ProxyConfig.Android androidConfig3 = proxyConfig.getAndroidConfig();
        if (androidConfig3 != null && (appStoreUri = androidConfig3.getAppStoreUri()) != null) {
            builder.setAppStoreUri(Uri.parse(appStoreUri));
        }
        ProxyConfig.Android androidConfig4 = proxyConfig.getAndroidConfig();
        if (androidConfig4 != null && (fcmFirebaseAppName = androidConfig4.getFcmFirebaseAppName()) != null) {
            builder.setFcmFirebaseAppName(fcmFirebaseAppName);
        }
        PrivacyManager.Feature enabledFeatures = proxyConfig.getEnabledFeatures();
        if (enabledFeatures != null) {
            builder.setEnabledFeatures(enabledFeatures);
        }
        Boolean autoPauseInAppAutomationOnLaunch = proxyConfig.getAutoPauseInAppAutomationOnLaunch();
        if (autoPauseInAppAutomationOnLaunch != null) {
            builder.setAutoPauseInAppAutomationOnLaunch(autoPauseInAppAutomationOnLaunch.booleanValue());
        }
        ProxyConfig.Android androidConfig5 = proxyConfig.getAndroidConfig();
        if (androidConfig5 == null || (notificationConfig = androidConfig5.getNotificationConfig()) == null) {
            return;
        }
        String icon = notificationConfig.getIcon();
        if (icon != null) {
            builder.setNotificationIcon(Utils.getNamedResource(context, icon, "drawable"));
        }
        String largeIcon = notificationConfig.getLargeIcon();
        if (largeIcon != null) {
            builder.setNotificationLargeIcon(Utils.getNamedResource(context, largeIcon, "drawable"));
        }
        String defaultChannelId = notificationConfig.getDefaultChannelId();
        if (defaultChannelId != null) {
            builder.setNotificationChannel(defaultChannelId);
        }
        String accentColor = notificationConfig.getAccentColor();
        if (accentColor != null) {
            builder.setNotificationAccentColor(Utils.getHexColor(accentColor, 0));
        }
    }
}
