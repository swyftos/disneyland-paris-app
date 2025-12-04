package com.facebook.hermes.reactexecutor;

import com.facebook.hermes.instrumentation.HermesSamplingProfiler;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/hermes/reactexecutor/HermesExecutorFactory;", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "<init>", "()V", "enableDebugger", "", "debuggerName", "", "setEnableDebugger", "", "setDebuggerName", "create", "Lcom/facebook/react/bridge/JavaScriptExecutor;", "startSamplingProfiler", "stopSamplingProfiler", "filename", "toString", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HermesExecutorFactory implements JavaScriptExecutorFactory {
    private boolean enableDebugger = true;
    private String debuggerName = "";

    public final void setEnableDebugger(boolean enableDebugger) {
        this.enableDebugger = enableDebugger;
    }

    public final void setDebuggerName(@NotNull String debuggerName) {
        Intrinsics.checkNotNullParameter(debuggerName, "debuggerName");
        this.debuggerName = debuggerName;
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    @NotNull
    public JavaScriptExecutor create() {
        return new HermesExecutor(this.enableDebugger, this.debuggerName);
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public void startSamplingProfiler() {
        HermesSamplingProfiler.enable();
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public void stopSamplingProfiler(@NotNull String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        HermesSamplingProfiler.dumpSampledTraceToFile(filename);
        HermesSamplingProfiler.disable();
    }

    @NotNull
    public String toString() {
        return "JSIExecutor+HermesRuntime";
    }
}
