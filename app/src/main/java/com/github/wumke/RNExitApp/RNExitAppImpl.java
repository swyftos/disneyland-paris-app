package com.github.wumke.RNExitApp;

import android.os.Process;
import com.facebook.react.bridge.ReactApplicationContext;

/* JADX INFO: loaded from: classes3.dex */
class RNExitAppImpl {
    ReactApplicationContext RCTContext;

    public RNExitAppImpl(ReactApplicationContext reactApplicationContext) {
        this.RCTContext = reactApplicationContext;
    }

    public void exitApp() {
        Process.killProcess(Process.myPid());
    }
}
