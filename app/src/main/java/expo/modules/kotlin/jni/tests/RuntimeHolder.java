package expo.modules.kotlin.jni.tests;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.urbanairship.reactnative.ReactMessageView;
import expo.modules.core.interfaces.DoNotStrip;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u0082 J\t\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u000bH\u0086 J\t\u0010\f\u001a\u00020\rH\u0082 J\b\u0010\u0010\u001a\u00020\rH\u0004J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lexpo/modules/kotlin/jni/tests/RuntimeHolder;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "createRuntime", "", "createCallInvoker", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "release", "", "wasDeallocated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finalize", ReactMessageView.EVENT_CLOSE, "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
public final class RuntimeHolder implements AutoCloseable {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData = initHybrid();
    private AtomicBoolean wasDeallocated = new AtomicBoolean(false);

    private final native HybridData initHybrid();

    private final native void release();

    @NotNull
    public final native CallInvokerHolderImpl createCallInvoker();

    public final native long createRuntime();

    protected final void finalize() throws Throwable {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.wasDeallocated.compareAndSet(false, true)) {
            release();
            this.mHybridData.resetNative();
        }
    }
}
