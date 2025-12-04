package com.contentsquare.rn.utils;

import com.facebook.react.bridge.UiThreadUtil;

/* loaded from: classes3.dex */
public class ReactNativeUiThreadUtil {
    public void runOnUiThread(Runnable runnable) {
        UiThreadUtil.runOnUiThread(runnable);
    }

    public boolean isOnUiThread() {
        return UiThreadUtil.isOnUiThread();
    }
}
