package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ViewInteractionModule_ProvideNeedsActivityFactory implements Provider<AtomicReference<Boolean>> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideNeedsActivityFactory(ViewInteractionModule viewInteractionModule) {
        this.module = viewInteractionModule;
    }

    public static ViewInteractionModule_ProvideNeedsActivityFactory create(ViewInteractionModule viewInteractionModule) {
        return new ViewInteractionModule_ProvideNeedsActivityFactory(viewInteractionModule);
    }

    public static AtomicReference<Boolean> provideNeedsActivity(ViewInteractionModule viewInteractionModule) {
        return (AtomicReference) Preconditions.checkNotNullFromProvides(viewInteractionModule.provideNeedsActivity());
    }

    @Override // javax.inject.Provider
    /* renamed from: get, reason: avoid collision after fix types in other method */
    public AtomicReference<Boolean> get2() {
        return provideNeedsActivity(this.module);
    }
}
