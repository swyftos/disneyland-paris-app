package com.facebook.react.devsupport.interfaces;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.File;
import kotlin.Metadata;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002qrJ\u001c\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u000b2\b\u00102\u001a\u0004\u0018\u000103H&J\u001c\u00104\u001a\u0002002\b\u00105\u001a\u0004\u0018\u00010\u000b2\b\u00106\u001a\u0004\u0018\u000107H&J\u0014\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010;\u001a\u0002002\b\u0010<\u001a\u0004\u0018\u000109H&J$\u0010=\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u001eH&J\b\u0010A\u001a\u000200H&J\b\u0010B\u001a\u000200H&J\b\u0010C\u001a\u000200H&J\b\u0010D\u001a\u000200H&J\u0010\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020&H&J\u0010\u0010G\u001a\u0002002\u0006\u0010F\u001a\u00020&H&J\b\u0010H\u001a\u00020*H&J\b\u0010I\u001a\u000200H&J\b\u0010J\u001a\u000200H&J\u0018\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020NH&J\u0018\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020QH&J\u0010\u0010R\u001a\u0002002\u0006\u0010M\u001a\u00020SH&J\u0010\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020*H&J\u0010\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020*H&J\b\u0010X\u001a\u000200H&J\u001c\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010ZH&J\u0012\u0010]\u001a\u0002002\b\u0010^\u001a\u0004\u0018\u00010_H&J8\u0010`\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010a2\u001a\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010aH&J\u0012\u0010c\u001a\u0002002\b\u0010d\u001a\u0004\u0018\u00010eH&J\u0014\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010\u000bH&J\b\u0010i\u001a\u000200H&J\u0018\u0010j\u001a\u0002002\u0006\u00101\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020lH&J\b\u0010m\u001a\u000200H&J\u0018\u0010n\u001a\u0002002\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u000bH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u0004\u0018\u00010\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u0004\u0018\u00010&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020*X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006sÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "Lcom/facebook/react/bridge/JSExceptionHandler;", "devSettings", "Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;", "getDevSettings", "()Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;", "redBoxHandler", "Lcom/facebook/react/devsupport/interfaces/RedBoxHandler;", "getRedBoxHandler", "()Lcom/facebook/react/devsupport/interfaces/RedBoxHandler;", "sourceMapUrl", "", "getSourceMapUrl", "()Ljava/lang/String;", "sourceUrl", "getSourceUrl", "downloadedJSBundleFile", "getDownloadedJSBundleFile", "lastErrorTitle", "getLastErrorTitle", "lastErrorStack", "", "Lcom/facebook/react/devsupport/interfaces/StackFrame;", "getLastErrorStack", "()[Lcom/facebook/react/devsupport/interfaces/StackFrame;", "lastErrorType", "Lcom/facebook/react/devsupport/interfaces/ErrorType;", "getLastErrorType", "()Lcom/facebook/react/devsupport/interfaces/ErrorType;", "lastErrorCookie", "", "getLastErrorCookie", "()I", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "currentReactContext", "Lcom/facebook/react/bridge/ReactContext;", "getCurrentReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "devSupportEnabled", "", "getDevSupportEnabled", "()Z", "setDevSupportEnabled", "(Z)V", "showNewJavaError", "", "message", "e", "", "addCustomDevOption", "optionName", "optionHandler", "Lcom/facebook/react/devsupport/interfaces/DevOptionHandler;", "createRootView", "Landroid/view/View;", "appKey", "destroyRootView", "rootView", "showNewJSError", ErrorBundle.DETAIL_ENTRY, "Lcom/facebook/react/bridge/ReadableArray;", "errorCookie", "hideRedboxDialog", "showDevOptionsDialog", "startInspector", "stopInspector", "onNewReactContextCreated", "reactContext", "onReactInstanceDestroyed", "hasUpToDateJSBundleInCache", "reloadSettings", "handleReloadJS", "reloadJSFromServer", "bundleURL", "callback", "Lcom/facebook/react/devsupport/interfaces/BundleLoadCallback;", "loadSplitBundleFromServer", "bundlePath", "Lcom/facebook/react/devsupport/interfaces/DevSplitBundleCallback;", "isPackagerRunning", "Lcom/facebook/react/devsupport/interfaces/PackagerStatusCallback;", "setHotModuleReplacementEnabled", "isHotModuleReplacementEnabled", "setFpsDebugEnabled", "isFpsDebugEnabled", "toggleElementInspector", "downloadBundleResourceFromUrlSync", "Ljava/io/File;", "resourceURL", "outputFile", "registerErrorCustomizer", "errorCustomizer", "Lcom/facebook/react/devsupport/interfaces/ErrorCustomizer;", "processErrorCustomizers", "Landroid/util/Pair;", "errorInfo", "setPackagerLocationCustomizer", "packagerLocationCustomizer", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager$PackagerLocationCustomizer;", "createSurfaceDelegate", "Lcom/facebook/react/common/SurfaceDelegate;", "moduleName", "openDebugger", "showPausedInDebuggerOverlay", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/devsupport/interfaces/DevSupportManager$PausedInDebuggerOverlayCommandListener;", "hidePausedInDebuggerOverlay", "setAdditionalOptionForPackager", "name", "value", "PackagerLocationCustomizer", "PausedInDebuggerOverlayCommandListener", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DevSupportManager extends JSExceptionHandler {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/DevSupportManager$PackagerLocationCustomizer;", "", "run", "", "callback", "Ljava/lang/Runnable;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PackagerLocationCustomizer {
        void run(@Nullable Runnable callback);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/DevSupportManager$PausedInDebuggerOverlayCommandListener;", "", "onResume", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PausedInDebuggerOverlayCommandListener {
        void onResume();
    }

    void addCustomDevOption(@Nullable String optionName, @Nullable DevOptionHandler optionHandler);

    @Nullable
    View createRootView(@Nullable String appKey);

    @Nullable
    SurfaceDelegate createSurfaceDelegate(@Nullable String moduleName);

    void destroyRootView(@Nullable View rootView);

    @Nullable
    File downloadBundleResourceFromUrlSync(@NotNull String resourceURL, @Nullable File outputFile);

    @Nullable
    Activity getCurrentActivity();

    @Nullable
    ReactContext getCurrentReactContext();

    @Nullable
    DeveloperSettings getDevSettings();

    boolean getDevSupportEnabled();

    @Nullable
    String getDownloadedJSBundleFile();

    int getLastErrorCookie();

    @Nullable
    StackFrame[] getLastErrorStack();

    @Nullable
    String getLastErrorTitle();

    @Nullable
    ErrorType getLastErrorType();

    @Nullable
    RedBoxHandler getRedBoxHandler();

    @Nullable
    String getSourceMapUrl();

    @Nullable
    String getSourceUrl();

    void handleReloadJS();

    boolean hasUpToDateJSBundleInCache();

    void hidePausedInDebuggerOverlay();

    void hideRedboxDialog();

    void isPackagerRunning(@NotNull PackagerStatusCallback callback);

    void loadSplitBundleFromServer(@NotNull String bundlePath, @NotNull DevSplitBundleCallback callback);

    void onNewReactContextCreated(@NotNull ReactContext reactContext);

    void onReactInstanceDestroyed(@NotNull ReactContext reactContext);

    void openDebugger();

    @Nullable
    Pair<String, StackFrame[]> processErrorCustomizers(@Nullable Pair<String, StackFrame[]> errorInfo);

    void registerErrorCustomizer(@Nullable ErrorCustomizer errorCustomizer);

    void reloadJSFromServer(@NotNull String bundleURL, @NotNull BundleLoadCallback callback);

    void reloadSettings();

    void setAdditionalOptionForPackager(@NotNull String name, @NotNull String value);

    void setDevSupportEnabled(boolean z);

    void setFpsDebugEnabled(boolean isFpsDebugEnabled);

    void setHotModuleReplacementEnabled(boolean isHotModuleReplacementEnabled);

    void setPackagerLocationCustomizer(@Nullable PackagerLocationCustomizer packagerLocationCustomizer);

    void showDevOptionsDialog();

    void showNewJSError(@Nullable String message, @Nullable ReadableArray details, int errorCookie);

    void showNewJavaError(@Nullable String message, @Nullable Throwable e);

    void showPausedInDebuggerOverlay(@NotNull String message, @NotNull PausedInDebuggerOverlayCommandListener listener);

    void startInspector();

    void stopInspector();

    void toggleElementInspector();
}
