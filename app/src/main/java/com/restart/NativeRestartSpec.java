package com.restart;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRestartSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Restart";

    @DoNotStrip
    @ReactMethod
    public abstract void restart();

    public NativeRestartSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "Restart";
    }
}
