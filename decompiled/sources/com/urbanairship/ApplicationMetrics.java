package com.urbanairship;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.urbanairship.PrivacyManager;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.app.SimpleApplicationListener;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class ApplicationMetrics extends AirshipComponent {
    private final ActivityMonitor activityMonitor;
    private boolean appVersionUpdated;
    private final ApplicationListener listener;
    private final PrivacyManager privacyManager;

    ApplicationMetrics(Context context, PreferenceDataStore preferenceDataStore, PrivacyManager privacyManager) {
        this(context, preferenceDataStore, privacyManager, GlobalActivityMonitor.shared(context));
    }

    ApplicationMetrics(Context context, PreferenceDataStore preferenceDataStore, final PrivacyManager privacyManager, ActivityMonitor activityMonitor) {
        super(context, preferenceDataStore);
        this.activityMonitor = activityMonitor;
        this.privacyManager = privacyManager;
        this.listener = new SimpleApplicationListener() { // from class: com.urbanairship.ApplicationMetrics.1
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long j) {
                if (privacyManager.isAnyEnabled(PrivacyManager.Feature.ANALYTICS, PrivacyManager.Feature.IN_APP_AUTOMATION)) {
                    ApplicationMetrics.this.getDataStore().put("com.urbanairship.application.metrics.LAST_OPEN", j);
                }
            }
        };
        this.appVersionUpdated = false;
    }

    @Override // com.urbanairship.AirshipComponent
    protected void init() {
        super.init();
        updateData();
        this.privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.ApplicationMetrics.2
            @Override // com.urbanairship.PrivacyManager.Listener
            public void onEnabledFeaturesChanged() {
                ApplicationMetrics.this.updateData();
            }
        });
        this.activityMonitor.addApplicationListener(this.listener);
    }

    @Override // com.urbanairship.AirshipComponent
    protected void tearDown() {
        this.activityMonitor.removeApplicationListener(this.listener);
    }

    @Deprecated
    public long getLastOpenTimeMillis() {
        return getDataStore().getLong("com.urbanairship.application.metrics.LAST_OPEN", -1L);
    }

    public boolean getAppVersionUpdated() {
        return this.appVersionUpdated;
    }

    public long getCurrentAppVersion() {
        return UAirship.getAppVersion();
    }

    private long getLastAppVersion() {
        return getDataStore().getLong("com.urbanairship.application.metrics.APP_VERSION", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateData() {
        if (this.privacyManager.isAnyEnabled(PrivacyManager.Feature.IN_APP_AUTOMATION, PrivacyManager.Feature.ANALYTICS)) {
            long appVersion = UAirship.getAppVersion();
            long lastAppVersion = getLastAppVersion();
            if (lastAppVersion > -1 && appVersion > lastAppVersion) {
                this.appVersionUpdated = true;
            }
            getDataStore().put("com.urbanairship.application.metrics.APP_VERSION", appVersion);
            return;
        }
        getDataStore().remove("com.urbanairship.application.metrics.APP_VERSION");
        getDataStore().remove("com.urbanairship.application.metrics.LAST_OPEN");
    }
}
