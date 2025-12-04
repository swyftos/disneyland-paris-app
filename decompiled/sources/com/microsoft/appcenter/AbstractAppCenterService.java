package com.microsoft.appcenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.media3.common.C;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class AbstractAppCenterService implements AppCenterService {
    protected Channel mChannel;
    private AppCenterHandler mHandler;

    protected Channel.GroupListener getChannelListener() {
        return null;
    }

    protected abstract String getGroupName();

    @Override // com.microsoft.appcenter.AppCenterService
    public Map<String, LogFactory> getLogFactories() {
        return null;
    }

    protected abstract String getLoggerTag();

    protected int getTriggerCount() {
        return 50;
    }

    protected long getTriggerInterval() {
        return C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    protected int getTriggerMaxParallelRequests() {
        return 3;
    }

    @Override // com.microsoft.appcenter.AppCenterService
    public boolean isAppSecretRequired() {
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.microsoft.appcenter.utils.ApplicationLifecycleListener.ApplicationLifecycleCallbacks
    public void onApplicationEnterBackground() {
    }

    @Override // com.microsoft.appcenter.utils.ApplicationLifecycleListener.ApplicationLifecycleCallbacks
    public void onApplicationEnterForeground() {
    }

    @Override // com.microsoft.appcenter.AppCenterService
    public void onConfigurationUpdated(String str, String str2) {
    }

    protected synchronized AppCenterFuture<Boolean> isInstanceEnabledAsync() {
        final DefaultAppCenterFuture defaultAppCenterFuture;
        defaultAppCenterFuture = new DefaultAppCenterFuture();
        postAsyncGetter(new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.1
            @Override // java.lang.Runnable
            public void run() {
                defaultAppCenterFuture.complete(Boolean.TRUE);
            }
        }, defaultAppCenterFuture, Boolean.FALSE);
        return defaultAppCenterFuture;
    }

    protected final synchronized AppCenterFuture<Void> setInstanceEnabledAsync(final boolean z) {
        final DefaultAppCenterFuture defaultAppCenterFuture;
        defaultAppCenterFuture = new DefaultAppCenterFuture();
        Runnable runnable = new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.2
            @Override // java.lang.Runnable
            public void run() {
                AppCenterLog.error("AppCenter", "App Center SDK is disabled.");
                defaultAppCenterFuture.complete(null);
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.3
            @Override // java.lang.Runnable
            public void run() {
                AbstractAppCenterService.this.setInstanceEnabled(z);
                defaultAppCenterFuture.complete(null);
            }
        };
        if (!post(runnable2, runnable, runnable2)) {
            defaultAppCenterFuture.complete(null);
        }
        return defaultAppCenterFuture;
    }

    @Override // com.microsoft.appcenter.AppCenterService
    public synchronized boolean isInstanceEnabled() {
        return SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
    }

    @Override // com.microsoft.appcenter.AppCenterService
    @WorkerThread
    public synchronized void setInstanceEnabled(boolean z) {
        try {
            if (z == isInstanceEnabled()) {
                AppCenterLog.info(getLoggerTag(), String.format("%s service has already been %s.", getServiceName(), z ? "enabled" : "disabled"));
                return;
            }
            String groupName = getGroupName();
            Channel channel = this.mChannel;
            if (channel != null && groupName != null) {
                if (z) {
                    channel.addGroup(groupName, getTriggerCount(), getTriggerInterval(), getTriggerMaxParallelRequests(), null, getChannelListener());
                } else {
                    channel.clear(groupName);
                    this.mChannel.removeGroup(groupName);
                }
            }
            SharedPreferencesManager.putBoolean(getEnabledPreferenceKey(), z);
            AppCenterLog.info(getLoggerTag(), String.format("%s service has been %s.", getServiceName(), z ? "enabled" : "disabled"));
            if (this.mChannel != null) {
                applyEnabledState(z);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @WorkerThread
    protected synchronized void applyEnabledState(boolean z) {
    }

    @Override // com.microsoft.appcenter.AppCenterService
    public final synchronized void onStarting(@NonNull AppCenterHandler appCenterHandler) {
        this.mHandler = appCenterHandler;
    }

    @Override // com.microsoft.appcenter.AppCenterService
    @WorkerThread
    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        try {
            String groupName = getGroupName();
            boolean zIsInstanceEnabled = isInstanceEnabled();
            if (groupName != null) {
                channel.removeGroup(groupName);
                if (zIsInstanceEnabled) {
                    channel.addGroup(groupName, getTriggerCount(), getTriggerInterval(), getTriggerMaxParallelRequests(), null, getChannelListener());
                } else {
                    channel.clear(groupName);
                }
            }
            this.mChannel = channel;
            applyEnabledState(zIsInstanceEnabled);
        } catch (Throwable th) {
            throw th;
        }
    }

    @NonNull
    protected String getEnabledPreferenceKey() {
        return "enabled_" + getServiceName();
    }

    protected synchronized void post(Runnable runnable) {
        post(runnable, null, null);
    }

    protected synchronized boolean post(final Runnable runnable, Runnable runnable2, final Runnable runnable3) {
        AppCenterHandler appCenterHandler = this.mHandler;
        if (appCenterHandler == null) {
            AppCenterLog.error("AppCenter", getServiceName() + " needs to be started before it can be used.");
            return false;
        }
        appCenterHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.4
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractAppCenterService.this.isInstanceEnabled()) {
                    runnable.run();
                    return;
                }
                Runnable runnable4 = runnable3;
                if (runnable4 != null) {
                    runnable4.run();
                    return;
                }
                AppCenterLog.info("AppCenter", AbstractAppCenterService.this.getServiceName() + " service disabled, discarding calls.");
            }
        }, runnable2);
        return true;
    }

    protected synchronized <T> void postAsyncGetter(final Runnable runnable, final DefaultAppCenterFuture<T> defaultAppCenterFuture, final T t) {
        Runnable runnable2 = new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.5
            @Override // java.lang.Runnable
            public void run() {
                defaultAppCenterFuture.complete(t);
            }
        };
        if (!post(new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.6
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, runnable2, runnable2)) {
            runnable2.run();
        }
    }

    protected synchronized void postOnUiThread(final Runnable runnable) {
        post(new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.7
            @Override // java.lang.Runnable
            public void run() {
                HandlerUtils.runOnUiThread(new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        AbstractAppCenterService.this.runIfEnabled(runnable);
                    }
                });
            }
        }, new Runnable() { // from class: com.microsoft.appcenter.AbstractAppCenterService.8
            @Override // java.lang.Runnable
            public void run() {
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void runIfEnabled(Runnable runnable) {
        if (isInstanceEnabled()) {
            runnable.run();
        }
    }
}
