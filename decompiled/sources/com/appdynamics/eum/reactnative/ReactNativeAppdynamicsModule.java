package com.appdynamics.eum.reactnative;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.urbanairship.analytics.CustomEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\t2\u0006\u00102\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u00103\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\t2\u0006\u00104\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u00108\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010?\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010@\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010A\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010B\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010C\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010E\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010F\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010K\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010N\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010T\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010V\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010W\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010X\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010Z\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010[\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\\\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010]\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010^\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/appdynamics/eum/reactnative/ReactNativeAppdynamicsModule;", "Lcom/appdynamics/eum/reactnative/NativeReactNativeAppdynamicsSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "impl", "Lcom/appdynamics/eum/reactnative/ReactNativeAppdynamicsModuleImpl;", "getName", "", "getTypedExportedConstants", "", "", "setCrashReportCallback", "", "cb", "Lcom/facebook/react/bridge/Callback;", ViewProps.START, CustomEvent.PROPERTIES, "Lcom/facebook/react/bridge/ReadableMap;", "hybridAgentType", "hybridAgentVersion", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "changeAppKey", "appKey", "reportMetric", "name", "value", "", "reportError", "hybridExceptionData", "severityLevel", "createCrashReport", "startTimer", "stopTimer", "shutdownAgent", "restartAgent", "trackScreenStart", "trackedScreen", "trackScreenEnd", "beginCall", "className", "methodName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "isStaticMethod", "", "endCallWithSuccess", "callId", "data", "endCallWithError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "leaveBreadcrumb", "breadcrumb", "mode", "unblockScreenshots", "blockScreenshots", "screenshotsBlocked", "takeScreenshot", "setUserData", "key", "removeUserData", "setUserDataNumber", "removeUserDataNumber", "setUserDataBoolean", "removeUserDataBoolean", "setUserDataDate", "valueStr", "removeUserDataDate", "startNextSession", "startSessionFrame", "sessionFrameName", "updateSessionFrameName", "id", "endSessionFrame", "trackUIEvent", "eventInfo", "getServerCorrelationHeaders", "getRequestTrackerWithUrl", "urlString", "setRequestTrackerErrorInfo", "trackerId", "errorDict", "setRequestTrackerStatusCode", "statusCode", "setRequestTrackerResponseHeaders", "responseHeaders", "setRequestTrackerRequestHeaders", "requestHeaders", "requestTrackerReport", "setRequestTrackerUserData", "setRequestTrackerUserDataNumber", "setRequestTrackerUserDataBoolean", "setRequestTrackerUserDataDate", "appdynamics_react-native-agent_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReactNativeAppdynamicsModule extends NativeReactNativeAppdynamicsSpec {

    @NotNull
    private final ReactNativeAppdynamicsModuleImpl impl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeAppdynamicsModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.impl = new ReactNativeAppdynamicsModuleImpl(reactContext);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "ReactNativeAppdynamics";
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    @NotNull
    protected Map<String, Object> getTypedExportedConstants() {
        return this.impl.getConstants();
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setCrashReportCallback(@NotNull Callback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.impl.setCrashReportCallback(cb);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void start(@NotNull ReadableMap properties, @Nullable String hybridAgentType, @Nullable String hybridAgentVersion, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.start(properties, hybridAgentType, hybridAgentVersion, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void changeAppKey(@NotNull String appKey, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.changeAppKey(appKey, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void reportMetric(@NotNull String name, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.reportMetric(name, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void reportError(@NotNull String hybridExceptionData, double severityLevel, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(hybridExceptionData, "hybridExceptionData");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.reportError(hybridExceptionData, severityLevel, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void createCrashReport(@NotNull String hybridExceptionData, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(hybridExceptionData, "hybridExceptionData");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.createCrashReport(hybridExceptionData, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void startTimer(@NotNull String name, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.startTimer(name, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void stopTimer(@NotNull String name, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.stopTimer(name, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void shutdownAgent(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.shutdownAgent(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void restartAgent(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.restartAgent(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void trackScreenStart(@NotNull ReadableMap trackedScreen, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackedScreen, "trackedScreen");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.trackScreenStart(trackedScreen, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void trackScreenEnd(@NotNull ReadableMap trackedScreen, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackedScreen, "trackedScreen");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.trackScreenEnd(trackedScreen, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void beginCall(@Nullable String className, @Nullable String methodName, @NotNull ReadableArray args, boolean isStaticMethod, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.beginCall(className, methodName, args, isStaticMethod, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void endCallWithSuccess(@Nullable String callId, @NotNull ReadableMap data, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.endCallWithSuccess(callId, data, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void endCallWithError(@Nullable String callId, @NotNull ReadableMap error, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.endCallWithError(callId, error, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void leaveBreadcrumb(@NotNull String breadcrumb, double mode, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.leaveBreadcrumb(breadcrumb, mode, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void unblockScreenshots(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.unblockScreenshots(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void blockScreenshots(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.blockScreenshots(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void screenshotsBlocked(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.screenshotsBlocked(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void takeScreenshot(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.takeScreenshot(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setUserData(@NotNull String key, @NotNull String value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setUserData(key, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void removeUserData(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.removeUserData(key, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setUserDataNumber(@NotNull String key, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setUserDataNumber(key, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void removeUserDataNumber(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.removeUserDataNumber(key, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setUserDataBoolean(@NotNull String key, boolean value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setUserDataBoolean(key, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void removeUserDataBoolean(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.removeUserDataBoolean(key, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setUserDataDate(@NotNull String key, @NotNull String valueStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueStr, "valueStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setUserDataDate(key, valueStr, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void removeUserDataDate(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.removeUserDataDate(key, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void startNextSession(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.startNextSession(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void startSessionFrame(@NotNull String sessionFrameName, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(sessionFrameName, "sessionFrameName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.startSessionFrame(sessionFrameName, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void updateSessionFrameName(@NotNull String id, @NotNull String name, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.updateSessionFrameName(id, name, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void endSessionFrame(@NotNull String id, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.endSessionFrame(id, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void trackUIEvent(@NotNull ReadableMap eventInfo, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.trackUIEvent(eventInfo, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void getServerCorrelationHeaders(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.getServerCorrelationHeaders(promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void getRequestTrackerWithUrl(@NotNull String urlString, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.getRequestTrackerWithUrl(urlString, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerErrorInfo(@NotNull String trackerId, @NotNull ReadableMap errorDict, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(errorDict, "errorDict");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerErrorInfo(trackerId, errorDict, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerStatusCode(@NotNull String trackerId, double statusCode, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerStatusCode(trackerId, statusCode, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerResponseHeaders(@NotNull String trackerId, @NotNull ReadableMap responseHeaders, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerResponseHeaders(trackerId, responseHeaders, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerRequestHeaders(@NotNull String trackerId, @NotNull ReadableMap requestHeaders, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerRequestHeaders(trackerId, requestHeaders, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void requestTrackerReport(@NotNull String trackerId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.requestTrackerReport(trackerId, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerUserData(@NotNull String trackerId, @NotNull String key, @NotNull String value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerUserData(trackerId, key, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerUserDataNumber(@NotNull String trackerId, @NotNull String key, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerUserDataNumber(trackerId, key, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerUserDataBoolean(@NotNull String trackerId, @NotNull String key, boolean value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerUserDataBoolean(trackerId, key, value, promise);
    }

    @Override // com.appdynamics.eum.reactnative.NativeReactNativeAppdynamicsSpec
    public void setRequestTrackerUserDataDate(@NotNull String trackerId, @NotNull String key, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.impl.setRequestTrackerUserDataDate(trackerId, key, value, promise);
    }
}
