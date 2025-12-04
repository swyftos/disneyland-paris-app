package com.dylanvann.fastimage;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes3.dex */
public abstract class NativeFastImageViewSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "FastImageView";

    @DoNotStrip
    @ReactMethod
    public abstract void clearDiskCache(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void clearMemoryCache(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void preload(ReadableArray readableArray);

    public NativeFastImageViewSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
