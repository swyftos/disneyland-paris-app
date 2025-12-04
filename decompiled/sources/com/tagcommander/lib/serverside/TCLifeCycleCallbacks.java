package com.tagcommander.lib.serverside;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.tagcommander.lib.core.TCEventManager;

/* loaded from: classes4.dex */
class TCLifeCycleCallbacks extends Application implements LifecycleObserver {
    static ETCApplicationState state = ETCApplicationState.BACKGROUND;

    TCLifeCycleCallbacks(Context context) {
        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.tagcommander.lib.serverside.TCLifeCycleCallbacks.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(TCLifeCycleCallbacks.this);
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onForeground() {
        state = ETCApplicationState.FOREGROUND;
        TCEventManager.getInstance().callOnForeground();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onBackground() {
        state = ETCApplicationState.BACKGROUND;
        TCEventManager.getInstance().callOnBackground();
    }
}
