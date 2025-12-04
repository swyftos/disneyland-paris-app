package com.facebook.react.internal.turbomodule.core;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.reactperflogger.NativeModulePerfLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0083 J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/internal/turbomodule/core/TurboModulePerfLogger;", "", "<init>", "()V", "nativeModulePerfLogger", "Lcom/facebook/react/reactperflogger/NativeModulePerfLogger;", "moduleCreateStart", "", "moduleName", "", "id", "", "moduleCreateCacheHit", "moduleCreateConstructStart", "moduleCreateConstructEnd", "moduleCreateSetUpStart", "moduleCreateSetUpEnd", "moduleCreateEnd", "moduleCreateFail", "jniEnableCppLogging", "perfLogger", "enableLogging", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TurboModulePerfLogger {

    @NotNull
    public static final TurboModulePerfLogger INSTANCE = new TurboModulePerfLogger();

    @Nullable
    private static NativeModulePerfLogger nativeModulePerfLogger;

    @DoNotStrip
    private final native void jniEnableCppLogging(NativeModulePerfLogger perfLogger);

    private TurboModulePerfLogger() {
    }

    static {
        NativeModuleSoLoader.INSTANCE.maybeLoadSoLibrary();
    }

    @JvmStatic
    public static final void moduleCreateStart(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateStart(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateCacheHit(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateCacheHit(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateConstructStart(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateConstructStart(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateConstructEnd(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateConstructEnd(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateSetUpStart(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateSetUpStart(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateSetUpEnd(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateSetUpEnd(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateEnd(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateEnd(moduleName, id);
        }
    }

    @JvmStatic
    public static final void moduleCreateFail(@Nullable String moduleName, int id) {
        NativeModulePerfLogger nativeModulePerfLogger2 = nativeModulePerfLogger;
        if (nativeModulePerfLogger2 != null) {
            if (moduleName == null) {
                throw new IllegalStateException("Required value was null.");
            }
            nativeModulePerfLogger2.moduleCreateFail(moduleName, id);
        }
    }

    public final void enableLogging(@Nullable NativeModulePerfLogger perfLogger) {
        if (perfLogger != null) {
            nativeModulePerfLogger = perfLogger;
            jniEnableCppLogging(perfLogger);
        }
    }
}
