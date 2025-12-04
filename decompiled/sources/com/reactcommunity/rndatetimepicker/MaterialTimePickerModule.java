package com.reactcommunity.rndatetimepicker;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/reactcommunity/rndatetimepicker/MaterialTimePickerModule;", "Lcom/reactcommunity/rndatetimepicker/NativeModuleMaterialTimePickerSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "dismiss", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", AbstractCircuitBreaker.PROPERTY_NAME, "params", "Lcom/facebook/react/bridge/ReadableMap;", "Companion", "react-native-community_datetimepicker_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MaterialTimePickerModule extends NativeModuleMaterialTimePickerSpec {

    @NotNull
    public static final String NAME = "RNCMaterialTimePicker";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTimePickerModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleMaterialTimePickerSpec, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RNCMaterialTimePicker";
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleMaterialTimePickerSpec
    public void dismiss(@Nullable Promise promise) {
        Common.dismissDialog((FragmentActivity) getCurrentActivity(), "RNCMaterialTimePicker", promise);
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleMaterialTimePickerSpec
    public void open(@NotNull final ReadableMap params, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to open a MaterialTimePicker dialog while not attached to an Activity");
        }
        Intrinsics.checkNotNull(fragmentActivity);
        final FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactcommunity.rndatetimepicker.MaterialTimePickerModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MaterialTimePickerModule.open$lambda$0(params, promise, supportFragmentManager, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void open$lambda$0(ReadableMap readableMap, Promise promise, FragmentManager fragmentManager, MaterialTimePickerModule materialTimePickerModule) {
        Bundle bundleCreateTimePickerArguments = Common.createTimePickerArguments(readableMap);
        Intrinsics.checkNotNull(bundleCreateTimePickerArguments);
        ReactApplicationContext reactApplicationContext = materialTimePickerModule.getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        new RNMaterialTimePicker(bundleCreateTimePickerArguments, promise, fragmentManager, reactApplicationContext).open();
    }
}
