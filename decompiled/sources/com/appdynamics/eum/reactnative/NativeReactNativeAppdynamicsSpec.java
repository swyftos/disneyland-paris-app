package com.appdynamics.eum.reactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class NativeReactNativeAppdynamicsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ReactNativeAppdynamics";

    @DoNotStrip
    @ReactMethod
    public abstract void beginCall(String str, String str2, ReadableArray readableArray, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void blockScreenshots(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void changeAppKey(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createCrashReport(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void endCallWithError(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void endCallWithSuccess(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void endSessionFrame(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getRequestTrackerWithUrl(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getServerCorrelationHeaders(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void leaveBreadcrumb(String str, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeUserData(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeUserDataBoolean(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeUserDataDate(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeUserDataNumber(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void reportError(String str, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void reportMetric(String str, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void requestTrackerReport(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void restartAgent(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void screenshotsBlocked(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setCrashReportCallback(Callback callback);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerErrorInfo(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerRequestHeaders(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerResponseHeaders(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerStatusCode(String str, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerUserData(String str, String str2, String str3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerUserDataBoolean(String str, String str2, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerUserDataDate(String str, String str2, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setRequestTrackerUserDataNumber(String str, String str2, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setUserData(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setUserDataBoolean(String str, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setUserDataDate(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setUserDataNumber(String str, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void shutdownAgent(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void start(ReadableMap readableMap, String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startNextSession(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startSessionFrame(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startTimer(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stopTimer(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void takeScreenshot(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void trackScreenEnd(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void trackScreenStart(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void trackUIEvent(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void unblockScreenshots(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void updateSessionFrameName(String str, String str2, Promise promise);

    public NativeReactNativeAppdynamicsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "ReactNativeAppdynamics";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @DoNotStrip
    @Nullable
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet(Arrays.asList("BREADCRUMB_VISIBILITY_CRASHES_AND_SESSIONS", "BREADCRUMB_VISIBILITY_CRASHES_ONLY", "ERROR_SEVERITY_LEVEL_CRITICAL", "ERROR_SEVERITY_LEVEL_INFO", "ERROR_SEVERITY_LEVEL_WARNING", "LOGGING_LEVEL_INFO", "LOGGING_LEVEL_NONE", "LOGGING_LEVEL_VERBOSE", "MAX_USER_DATA_STRING_LENGTH"));
            HashSet hashSet3 = new HashSet(typedExportedConstants.keySet());
            hashSet3.removeAll(hashSet);
            hashSet3.removeAll(hashSet2);
            if (!hashSet3.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module Flow doesn't declare constants: %s", hashSet3));
            }
            hashSet.removeAll(typedExportedConstants.keySet());
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module doesn't fill in constants: %s", hashSet));
            }
        }
        return typedExportedConstants;
    }
}
