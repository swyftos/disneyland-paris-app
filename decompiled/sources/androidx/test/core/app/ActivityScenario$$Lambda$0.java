package androidx.test.core.app;

import androidx.test.internal.platform.ServiceLoaderWrapper;

/* loaded from: classes2.dex */
final /* synthetic */ class ActivityScenario$$Lambda$0 implements ServiceLoaderWrapper.Factory {
    static final ServiceLoaderWrapper.Factory $instance = new ActivityScenario$$Lambda$0();

    private ActivityScenario$$Lambda$0() {
    }

    @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
    public Object create() {
        return ActivityScenario.lambda$new$0$ActivityScenario();
    }
}
