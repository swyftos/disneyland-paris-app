package androidx.test.core.app;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.p012os.ControlledLooper;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ActivityScenario$$Lambda$3 implements ServiceLoaderWrapper.Factory {
    static final ServiceLoaderWrapper.Factory $instance = new ActivityScenario$$Lambda$3();

    private ActivityScenario$$Lambda$3() {
    }

    @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
    public Object create() {
        return ControlledLooper.NO_OP_CONTROLLED_LOOPER;
    }
}
