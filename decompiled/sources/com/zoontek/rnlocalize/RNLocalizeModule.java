package com.zoontek.rnlocalize;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = "RNLocalize")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\r\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lcom/zoontek/rnlocalize/RNLocalizeModule;", "Lcom/zoontek/rnlocalize/NativeRNLocalizeSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "getCalendar", "getCountry", "getCurrencies", "Lcom/facebook/react/bridge/WritableArray;", "getLocales", "getNumberFormatSettings", "Lcom/facebook/react/bridge/WritableMap;", "getTemperatureUnit", "getTimeZone", "uses24HourClock", "", "usesMetricSystem", "usesAutoDateAndTime", "()Ljava/lang/Boolean;", "usesAutoTimeZone", "openAppLanguageSettings", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "react-native-localize_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RNLocalizeModule extends NativeRNLocalizeSpec {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNLocalizeModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RNLocalize";
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public String getCalendar() {
        return RNLocalizeModuleImpl.INSTANCE.getCalendar();
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public String getCountry() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getCountry(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public WritableArray getCurrencies() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getCurrencies(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public WritableArray getLocales() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getLocales(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public WritableMap getNumberFormatSettings() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getNumberFormatSettings(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public String getTemperatureUnit() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getTemperatureUnit(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public String getTimeZone() {
        return RNLocalizeModuleImpl.INSTANCE.getTimeZone();
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    public boolean uses24HourClock() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.uses24HourClock(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    public boolean usesMetricSystem() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.usesMetricSystem(reactApplicationContext);
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public Boolean usesAutoDateAndTime() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return Boolean.valueOf(rNLocalizeModuleImpl.usesAutoDateAndTime(reactApplicationContext));
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    @NotNull
    public Boolean usesAutoTimeZone() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return Boolean.valueOf(rNLocalizeModuleImpl.usesAutoTimeZone(reactApplicationContext));
    }

    @Override // com.zoontek.rnlocalize.NativeRNLocalizeSpec
    public void openAppLanguageSettings(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNLocalizeModuleImpl.openAppLanguageSettings(reactApplicationContext, promise);
    }
}
