package androidx.test.espresso.base;

import androidx.test.espresso.UiController;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RootViewPicker_Factory implements Provider<RootViewPicker> {
    private final Provider activityLifecycleMonitorProvider;
    private final Provider controlledLooperProvider;
    private final Provider needsActivityProvider;
    private final Provider rootResultFetcherProvider;
    private final Provider uiControllerProvider;

    public RootViewPicker_Factory(Provider<UiController> provider, Provider<RootViewPicker.RootResultFetcher> provider2, Provider<ActivityLifecycleMonitor> provider3, Provider<AtomicReference<Boolean>> provider4, Provider<ControlledLooper> provider5) {
        this.uiControllerProvider = provider;
        this.rootResultFetcherProvider = provider2;
        this.activityLifecycleMonitorProvider = provider3;
        this.needsActivityProvider = provider4;
        this.controlledLooperProvider = provider5;
    }

    public static RootViewPicker_Factory create(Provider<UiController> provider, Provider<RootViewPicker.RootResultFetcher> provider2, Provider<ActivityLifecycleMonitor> provider3, Provider<AtomicReference<Boolean>> provider4, Provider<ControlledLooper> provider5) {
        return new RootViewPicker_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static RootViewPicker newInstance(UiController uiController, Object obj, ActivityLifecycleMonitor activityLifecycleMonitor, AtomicReference<Boolean> atomicReference, ControlledLooper controlledLooper) {
        return new RootViewPicker(uiController, (RootViewPicker.RootResultFetcher) obj, activityLifecycleMonitor, atomicReference, controlledLooper);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public RootViewPicker get2() {
        return newInstance((UiController) this.uiControllerProvider.get2(), this.rootResultFetcherProvider.get2(), (ActivityLifecycleMonitor) this.activityLifecycleMonitorProvider.get2(), (AtomicReference) this.needsActivityProvider.get2(), (ControlledLooper) this.controlledLooperProvider.get2());
    }
}
