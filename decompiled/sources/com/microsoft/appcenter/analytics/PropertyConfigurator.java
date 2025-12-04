package com.microsoft.appcenter.analytics;

import android.provider.Settings;
import androidx.annotation.NonNull;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.AppExtension;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.DeviceExtension;
import com.microsoft.appcenter.ingestion.models.one.UserExtension;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.util.Date;
import java.util.Map;

/* loaded from: classes4.dex */
public class PropertyConfigurator extends AbstractChannelListener {
    private String mAppLocale;
    private String mAppName;
    private String mAppVersion;
    private boolean mDeviceIdEnabled;
    private final EventProperties mEventProperties = new EventProperties();
    private final AnalyticsTransmissionTarget mTransmissionTarget;
    private String mUserId;

    PropertyConfigurator(AnalyticsTransmissionTarget analyticsTransmissionTarget) {
        this.mTransmissionTarget = analyticsTransmissionTarget;
    }

    @Override // com.microsoft.appcenter.channel.AbstractChannelListener, com.microsoft.appcenter.channel.Channel.Listener
    public void onPreparingLog(@NonNull Log log, @NonNull String str) {
        if (shouldOverridePartAProperties(log)) {
            CommonSchemaLog commonSchemaLog = (CommonSchemaLog) log;
            AppExtension app = commonSchemaLog.getExt().getApp();
            UserExtension user = commonSchemaLog.getExt().getUser();
            DeviceExtension device = commonSchemaLog.getExt().getDevice();
            String str2 = this.mAppName;
            if (str2 != null) {
                app.setName(str2);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget = this.mTransmissionTarget;
                while (true) {
                    analyticsTransmissionTarget = analyticsTransmissionTarget.mParentTarget;
                    if (analyticsTransmissionTarget == null) {
                        break;
                    }
                    String appName = analyticsTransmissionTarget.getPropertyConfigurator().getAppName();
                    if (appName != null) {
                        app.setName(appName);
                        break;
                    }
                }
            }
            String str3 = this.mAppVersion;
            if (str3 != null) {
                app.setVer(str3);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget2 = this.mTransmissionTarget;
                while (true) {
                    analyticsTransmissionTarget2 = analyticsTransmissionTarget2.mParentTarget;
                    if (analyticsTransmissionTarget2 == null) {
                        break;
                    }
                    String appVersion = analyticsTransmissionTarget2.getPropertyConfigurator().getAppVersion();
                    if (appVersion != null) {
                        app.setVer(appVersion);
                        break;
                    }
                }
            }
            String str4 = this.mAppLocale;
            if (str4 != null) {
                app.setLocale(str4);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget3 = this.mTransmissionTarget;
                while (true) {
                    analyticsTransmissionTarget3 = analyticsTransmissionTarget3.mParentTarget;
                    if (analyticsTransmissionTarget3 == null) {
                        break;
                    }
                    String appLocale = analyticsTransmissionTarget3.getPropertyConfigurator().getAppLocale();
                    if (appLocale != null) {
                        app.setLocale(appLocale);
                        break;
                    }
                }
            }
            String str5 = this.mUserId;
            if (str5 != null) {
                user.setLocalId(str5);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget4 = this.mTransmissionTarget;
                while (true) {
                    analyticsTransmissionTarget4 = analyticsTransmissionTarget4.mParentTarget;
                    if (analyticsTransmissionTarget4 == null) {
                        break;
                    }
                    String userId = analyticsTransmissionTarget4.getPropertyConfigurator().getUserId();
                    if (userId != null) {
                        user.setLocalId(userId);
                        break;
                    }
                }
            }
            if (this.mDeviceIdEnabled) {
                device.setLocalId("a:" + Settings.Secure.getString(this.mTransmissionTarget.mContext.getContentResolver(), "android_id"));
            }
        }
    }

    private boolean shouldOverridePartAProperties(Log log) {
        if (log instanceof CommonSchemaLog) {
            Object tag = log.getTag();
            AnalyticsTransmissionTarget analyticsTransmissionTarget = this.mTransmissionTarget;
            if (tag == analyticsTransmissionTarget && analyticsTransmissionTarget.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    private String getAppName() {
        return this.mAppName;
    }

    public void setAppName(final String str) {
        Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.PropertyConfigurator.1
            @Override // java.lang.Runnable
            public void run() {
                PropertyConfigurator.this.mAppName = str;
            }
        });
    }

    private String getAppVersion() {
        return this.mAppVersion;
    }

    public void setAppVersion(final String str) {
        Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.PropertyConfigurator.2
            @Override // java.lang.Runnable
            public void run() {
                PropertyConfigurator.this.mAppVersion = str;
            }
        });
    }

    private String getAppLocale() {
        return this.mAppLocale;
    }

    public void setAppLocale(final String str) {
        Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.PropertyConfigurator.3
            @Override // java.lang.Runnable
            public void run() {
                PropertyConfigurator.this.mAppLocale = str;
            }
        });
    }

    private String getUserId() {
        return this.mUserId;
    }

    public void setUserId(final String str) {
        if (UserIdContext.checkUserIdValidForOneCollector(str)) {
            Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.PropertyConfigurator.4
                @Override // java.lang.Runnable
                public void run() {
                    PropertyConfigurator.this.mUserId = UserIdContext.getPrefixedUserId(str);
                }
            });
        }
    }

    public synchronized void setEventProperty(String str, boolean z) {
        this.mEventProperties.set(str, z);
    }

    public synchronized void setEventProperty(String str, Date date) {
        this.mEventProperties.set(str, date);
    }

    public synchronized void setEventProperty(String str, double d) {
        this.mEventProperties.set(str, d);
    }

    public synchronized void setEventProperty(String str, long j) {
        this.mEventProperties.set(str, j);
    }

    public synchronized void setEventProperty(String str, String str2) {
        this.mEventProperties.set(str, str2);
    }

    public synchronized void removeEventProperty(String str) {
        this.mEventProperties.getProperties().remove(str);
    }

    public void collectDeviceId() {
        Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.PropertyConfigurator.5
            @Override // java.lang.Runnable
            public void run() {
                PropertyConfigurator.this.mDeviceIdEnabled = true;
            }
        });
    }

    synchronized void mergeEventProperties(EventProperties eventProperties) {
        for (Map.Entry entry : this.mEventProperties.getProperties().entrySet()) {
            String str = (String) entry.getKey();
            if (!eventProperties.getProperties().containsKey(str)) {
                eventProperties.getProperties().put(str, entry.getValue());
            }
        }
    }
}
