package com.github.doomsower;

import android.os.SystemClock;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class RNStartupTimePackage implements ReactPackage {
    private static final long START_MARK = SystemClock.uptimeMillis();
    private boolean enforceSingleInvocation;

    public RNStartupTimePackage() {
        this(true);
    }

    public RNStartupTimePackage(boolean z) {
        this.enforceSingleInvocation = z;
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNStartupTimeModule(reactApplicationContext, START_MARK, this.enforceSingleInvocation));
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
