package com.contentsquare.p025rn.utils;

import com.facebook.react.bridge.UiThreadUtil;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeUiThreadUtil {
    public void runOnUiThread(Runnable runnable) {
        UiThreadUtil.runOnUiThread(runnable);
    }

    public boolean isOnUiThread() {
        return UiThreadUtil.isOnUiThread();
    }
}
