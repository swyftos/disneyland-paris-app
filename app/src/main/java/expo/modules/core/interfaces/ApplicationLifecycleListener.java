package expo.modules.core.interfaces;

import android.app.Application;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes5.dex */
public interface ApplicationLifecycleListener {
    default void onConfigurationChanged(Configuration configuration) {
    }

    default void onCreate(Application application) {
    }
}
