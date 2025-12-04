package com.microsoft.appcenter;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.ApplicationLifecycleListener;
import java.util.Map;

/* loaded from: classes4.dex */
public interface AppCenterService extends Application.ActivityLifecycleCallbacks, ApplicationLifecycleListener.ApplicationLifecycleCallbacks {
    @Nullable
    Map<String, LogFactory> getLogFactories();

    String getServiceName();

    boolean isAppSecretRequired();

    boolean isInstanceEnabled();

    @WorkerThread
    void onConfigurationUpdated(String str, String str2);

    @WorkerThread
    void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z);

    void onStarting(@NonNull AppCenterHandler appCenterHandler);

    void setInstanceEnabled(boolean z);
}
