package com.swmansion.worklets;

import androidx.annotation.OptIn;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.NativeWorkletsModuleSpec;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@ReactModule(name = NativeWorkletsModuleSpec.NAME)
/* loaded from: classes4.dex */
public class WorkletsModule extends NativeWorkletsModuleSpec {
    private final AndroidUIScheduler mAndroidUIScheduler;

    @DoNotStrip
    private HybridData mHybridData;
    private final WorkletsMessageQueueThread mMessageQueueThread;

    @OptIn(markerClass = {FrameworkAPI.class})
    private native HybridData initHybrid(long j, String str, MessageQueueThread messageQueueThread, CallInvokerHolderImpl callInvokerHolderImpl, AndroidUIScheduler androidUIScheduler);

    private native void invalidateCpp();

    static {
        SoLoader.loadLibrary("worklets");
    }

    protected HybridData getHybridData() {
        return this.mHybridData;
    }

    public AndroidUIScheduler getAndroidUIScheduler() {
        return this.mAndroidUIScheduler;
    }

    public WorkletsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mMessageQueueThread = new WorkletsMessageQueueThread();
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactApplicationContext);
    }

    @Override // com.swmansion.reanimated.NativeWorkletsModuleSpec
    @OptIn(markerClass = {FrameworkAPI.class})
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        this.mHybridData = initHybrid(javaScriptContextHolder.get(), str, this.mMessageQueueThread, JSCallInvokerResolver.getJSCallInvokerHolder(reactApplicationContext), this.mAndroidUIScheduler);
        return true;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        invalidateCpp();
        this.mAndroidUIScheduler.deactivate();
    }
}
