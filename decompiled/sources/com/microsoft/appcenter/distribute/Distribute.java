package com.microsoft.appcenter.distribute;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class Distribute extends AbstractAppCenterService {
    private static Distribute sInstance;

    public static void checkForUpdate() {
    }

    public static void disableAutomaticCheckForUpdate() {
    }

    public static int getUpdateTrack() {
        return 1;
    }

    public static void notifyUpdateAction(int i) {
    }

    public static void setApiUrl(String str) {
    }

    public static void setEnabledForDebuggableBuild(boolean z) {
    }

    public static void setInstallUrl(String str) {
    }

    public static void setListener(DistributeListener distributeListener) {
    }

    public static void setUpdateTrack(int i) {
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected int getTriggerCount() {
        return 1;
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.utils.ApplicationLifecycleListener.ApplicationLifecycleCallbacks
    public void onApplicationEnterForeground() {
    }

    public static synchronized Distribute getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new Distribute();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static AppCenterFuture<Boolean> isEnabled() {
        DefaultAppCenterFuture defaultAppCenterFuture = new DefaultAppCenterFuture();
        defaultAppCenterFuture.complete(Boolean.TRUE);
        return defaultAppCenterFuture;
    }

    public static AppCenterFuture<Void> setEnabled(boolean z) {
        DefaultAppCenterFuture defaultAppCenterFuture = new DefaultAppCenterFuture();
        defaultAppCenterFuture.complete(Boolean.TRUE);
        return defaultAppCenterFuture;
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected String getGroupName() {
        return "group_distribute";
    }

    @Override // com.microsoft.appcenter.AppCenterService
    public String getServiceName() {
        return "DistributePlay";
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected String getLoggerTag() {
        return DistributeConstants.LOG_TAG;
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.AppCenterService
    public Map<String, LogFactory> getLogFactories() {
        return new HashMap();
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.AppCenterService
    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityPaused(Activity activity) {
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected synchronized void applyEnabledState(boolean z) {
    }
}
