package com.facebook.react.bridge;

import android.os.SystemClock;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/bridge/ReactBridge;", "", "<init>", "()V", "_loadStartTime", "", "_loadEndTime", "_didInit", "", "staticInit", "", "loadStartTime", "getLoadStartTime$annotations", "getLoadStartTime", "()J", "loadEndTime", "getLoadEndTime$annotations", "getLoadEndTime", "initialized", "isInitialized$annotations", "isInitialized", "()Z", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactBridge {

    @NotNull
    public static final ReactBridge INSTANCE = new ReactBridge();
    private static volatile boolean _didInit;
    private static volatile long _loadEndTime;
    private static volatile long _loadStartTime;

    @JvmStatic
    public static /* synthetic */ void getLoadEndTime$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLoadStartTime$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    private ReactBridge() {
    }

    @JvmStatic
    public static final synchronized void staticInit() {
        if (_didInit) {
            return;
        }
        _loadStartTime = SystemClock.uptimeMillis();
        com.facebook.systrace.Systrace.beginSection(0L, "ReactBridge.staticInit::load:reactnativejni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
        SoLoader.loadLibrary("reactnativejni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
        com.facebook.systrace.Systrace.endSection(0L);
        _loadEndTime = SystemClock.uptimeMillis();
        _didInit = true;
    }

    public static final long getLoadStartTime() {
        return _loadStartTime;
    }

    public static final long getLoadEndTime() {
        return _loadEndTime;
    }

    @JvmName(name = "isInitialized")
    public static final boolean isInitialized() {
        return _didInit;
    }
}
