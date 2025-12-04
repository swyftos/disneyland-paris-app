package com.swmansion.reanimated;

import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/* loaded from: classes4.dex */
public class DevMenuUtils {
    public static void addDevMenuOption(ReactApplicationContext reactApplicationContext, DevOptionHandler devOptionHandler) {
        DevSupportManager devSupportManager;
        if (reactApplicationContext.getApplicationContext() instanceof ReactApplication) {
            if (reactApplicationContext.isBridgeless()) {
                devSupportManager = ((ReactApplication) reactApplicationContext.getApplicationContext()).getReactHost().getDevSupportManager();
            } else {
                devSupportManager = ((ReactApplication) reactApplicationContext.getApplicationContext()).getReactNativeHost().getReactInstanceManager().getDevSupportManager();
            }
            if (devSupportManager != null) {
                devSupportManager.addCustomDevOption("Toggle slow animations (Reanimated)", devOptionHandler);
                return;
            }
            throw new RuntimeException("[Reanimated] DevSupportManager is not available");
        }
    }
}
