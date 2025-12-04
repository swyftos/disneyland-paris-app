package com.reactnativecommunity.clipboard;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes4.dex */
public abstract class NativeClipboardModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNCClipboard";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void getImage(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getImageJPG(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getImagePNG(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getString(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getStrings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void hasImage(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void hasNumber(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void hasString(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void hasURL(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void hasWebURL(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListener();

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void setImage(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setListener();

    @DoNotStrip
    @ReactMethod
    public abstract void setString(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void setStrings(ReadableArray readableArray);

    public NativeClipboardModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNCClipboard";
    }
}
