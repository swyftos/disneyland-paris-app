package com.github.wumke.RNExitApp;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes3.dex */
public class RNExitApp extends NativeRNExitAppSpec {
    private final RNExitAppImpl delegate;

    public RNExitApp(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNExitAppImpl(reactApplicationContext);
    }

    @Override // com.github.wumke.RNExitApp.NativeRNExitAppSpec, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NativeRNExitAppSpec.NAME;
    }

    @Override // com.github.wumke.RNExitApp.NativeRNExitAppSpec
    public void exitApp() {
        this.delegate.exitApp();
    }
}
