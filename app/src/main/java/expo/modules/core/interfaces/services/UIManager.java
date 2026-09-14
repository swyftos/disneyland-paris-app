package expo.modules.core.interfaces.services;

import android.view.View;
import androidx.annotation.Nullable;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.LifecycleEventListener;

/* JADX INFO: loaded from: classes5.dex */
public interface UIManager {

    public interface GroupUIBlock {
        void execute(ViewHolder viewHolder);
    }

    public interface UIBlock<T> {
        void reject(Throwable th);

        void resolve(T t);
    }

    public interface ViewHolder {
        View get(Object obj);
    }

    @Deprecated
    <T> void addUIBlock(int i, UIBlock<T> uIBlock, Class<T> cls);

    @Deprecated
    void addUIBlock(GroupUIBlock groupUIBlock);

    void registerActivityEventListener(ActivityEventListener activityEventListener);

    void registerLifecycleEventListener(LifecycleEventListener lifecycleEventListener);

    @Nullable
    @Deprecated
    View resolveView(int i);

    void runOnClientCodeQueueThread(Runnable runnable);

    void runOnNativeModulesQueueThread(Runnable runnable);

    void runOnUiQueueThread(Runnable runnable);

    void unregisterActivityEventListener(ActivityEventListener activityEventListener);

    void unregisterLifecycleEventListener(LifecycleEventListener lifecycleEventListener);
}
