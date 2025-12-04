package com.tagcommander.lib.serverside;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* loaded from: classes4.dex */
public class TCLifeCycleCallbacks_LifecycleAdapter implements GeneratedAdapter {
    final TCLifeCycleCallbacks mReceiver;

    TCLifeCycleCallbacks_LifecycleAdapter(TCLifeCycleCallbacks tCLifeCycleCallbacks) {
        this.mReceiver = tCLifeCycleCallbacks;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (z) {
            return;
        }
        if (event == Lifecycle.Event.ON_START) {
            if (!z2 || methodCallsLogger.approveCall("onForeground", 1)) {
                this.mReceiver.onForeground();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_STOP) {
            if (!z2 || methodCallsLogger.approveCall("onBackground", 1)) {
                this.mReceiver.onBackground();
            }
        }
    }
}
