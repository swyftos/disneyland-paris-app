package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes3.dex */
public abstract class NativeAnimatedModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeAnimatedModule";

    @DoNotStrip
    @ReactMethod
    public abstract void addAnimatedEventToView(double d, String str, ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void connectAnimatedNodeToView(double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void connectAnimatedNodes(double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void createAnimatedNode(double d, ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void disconnectAnimatedNodeFromView(double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void disconnectAnimatedNodes(double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void dropAnimatedNode(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void extractAnimatedNodeOffset(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void finishOperationBatch();

    @DoNotStrip
    @ReactMethod
    public abstract void flattenAnimatedNodeOffset(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void getValue(double d, Callback callback);

    @DoNotStrip
    @ReactMethod
    public void queueAndExecuteBatchedOperations(ReadableArray readableArray) {
    }

    @DoNotStrip
    @ReactMethod
    public abstract void removeAnimatedEventFromView(double d, String str, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void restoreDefaultValues(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void setAnimatedNodeOffset(double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void setAnimatedNodeValue(double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void startAnimatingNode(double d, double d2, ReadableMap readableMap, Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void startListeningToAnimatedNodeValue(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void startOperationBatch();

    @DoNotStrip
    @ReactMethod
    public abstract void stopAnimation(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void stopListeningToAnimatedNodeValue(double d);

    @DoNotStrip
    @ReactMethod
    public void updateAnimatedNodeConfig(double d, ReadableMap readableMap) {
    }

    public NativeAnimatedModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
