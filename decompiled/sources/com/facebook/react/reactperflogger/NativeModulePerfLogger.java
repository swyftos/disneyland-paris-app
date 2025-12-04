package com.facebook.react.reactperflogger;

import com.facebook.jni.HybridData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0005H$J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\tH\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/reactperflogger/NativeModulePerfLogger;", "", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "getMHybridData$annotations", "initHybrid", "moduleDataCreateStart", "", "moduleName", "", "id", "", "moduleDataCreateEnd", "moduleCreateStart", "moduleCreateCacheHit", "moduleCreateConstructStart", "moduleCreateConstructEnd", "moduleCreateSetUpStart", "moduleCreateSetUpEnd", "moduleCreateEnd", "moduleCreateFail", "maybeLoadOtherSoLibraries", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class NativeModulePerfLogger {

    @NotNull
    private final HybridData mHybridData;

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    @NotNull
    protected abstract HybridData initHybrid();

    public abstract void moduleCreateCacheHit(@NotNull String moduleName, int id);

    public abstract void moduleCreateConstructEnd(@NotNull String moduleName, int id);

    public abstract void moduleCreateConstructStart(@NotNull String moduleName, int id);

    public abstract void moduleCreateEnd(@NotNull String moduleName, int id);

    public abstract void moduleCreateFail(@NotNull String moduleName, int id);

    public abstract void moduleCreateSetUpEnd(@NotNull String moduleName, int id);

    public abstract void moduleCreateSetUpStart(@NotNull String moduleName, int id);

    public abstract void moduleCreateStart(@NotNull String moduleName, int id);

    public abstract void moduleDataCreateEnd(@NotNull String moduleName, int id);

    public abstract void moduleDataCreateStart(@NotNull String moduleName, int id);

    protected NativeModulePerfLogger() {
        maybeLoadOtherSoLibraries();
        this.mHybridData = initHybrid();
    }

    protected final synchronized void maybeLoadOtherSoLibraries() {
    }
}
