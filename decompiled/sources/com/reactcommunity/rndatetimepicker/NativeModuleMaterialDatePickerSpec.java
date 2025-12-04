package com.reactcommunity.rndatetimepicker;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes4.dex */
public abstract class NativeModuleMaterialDatePickerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNCMaterialDatePicker";

    @DoNotStrip
    @ReactMethod
    public abstract void dismiss(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void open(ReadableMap readableMap, Promise promise);

    public NativeModuleMaterialDatePickerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNCMaterialDatePicker";
    }
}
