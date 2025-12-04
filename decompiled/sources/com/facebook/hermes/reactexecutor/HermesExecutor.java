package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/hermes/reactexecutor/HermesExecutor;", "Lcom/facebook/react/bridge/JavaScriptExecutor;", "enableDebugger", "", "debuggerName", "", "<init>", "(ZLjava/lang/String;)V", "getName", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HermesExecutor extends JavaScriptExecutor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static String mode;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    @DoNotStrip
    public static final native HybridData initHybrid(boolean z, String str, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    @DoNotStrip
    public static final native HybridData initHybridDefaultConfig(boolean z, String str);

    @JvmStatic
    public static final void loadLibrary() throws UnsatisfiedLinkError {
        INSTANCE.loadLibrary();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HermesExecutor(boolean z, @NotNull String debuggerName) {
        super(INSTANCE.initHybridDefaultConfig(z, debuggerName));
        Intrinsics.checkNotNullParameter(debuggerName, "debuggerName");
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutor
    @NotNull
    public String getName() {
        return "HermesExecutor" + mode;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0083 J#\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/hermes/reactexecutor/HermesExecutor$Companion;", "", "<init>", "()V", "mode", "", "loadLibrary", "", "initHybridDefaultConfig", "Lcom/facebook/jni/HybridData;", "enableDebugger", "", "debuggerName", "initHybrid", "heapSizeMB", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @DoNotStrip
        private final HybridData initHybrid(boolean enableDebugger, String debuggerName, long heapSizeMB) {
            return HermesExecutor.initHybrid(enableDebugger, debuggerName, heapSizeMB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        @DoNotStrip
        public final HybridData initHybridDefaultConfig(boolean enableDebugger, String debuggerName) {
            return HermesExecutor.initHybridDefaultConfig(enableDebugger, debuggerName);
        }

        private Companion() {
        }

        @JvmStatic
        public final void loadLibrary() throws UnsatisfiedLinkError {
            if (HermesExecutor.mode == null) {
                SoLoader.loadLibrary("hermes");
                SoLoader.loadLibrary("hermes_executor");
                HermesExecutor.mode = ReactBuildConfig.DEBUG ? "Debug" : "Release";
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        companion.loadLibrary();
    }
}
