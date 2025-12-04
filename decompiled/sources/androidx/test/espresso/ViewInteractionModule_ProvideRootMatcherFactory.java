package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class ViewInteractionModule_ProvideRootMatcherFactory implements Provider<AtomicReference<Matcher<Root>>> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideRootMatcherFactory(ViewInteractionModule viewInteractionModule) {
        this.module = viewInteractionModule;
    }

    public static ViewInteractionModule_ProvideRootMatcherFactory create(ViewInteractionModule viewInteractionModule) {
        return new ViewInteractionModule_ProvideRootMatcherFactory(viewInteractionModule);
    }

    public static AtomicReference<Matcher<Root>> provideRootMatcher(ViewInteractionModule viewInteractionModule) {
        return (AtomicReference) Preconditions.checkNotNullFromProvides(viewInteractionModule.provideRootMatcher());
    }

    @Override // javax.inject.Provider
    /* renamed from: get, reason: avoid collision after fix types in other method */
    public AtomicReference<Matcher<Root>> get2() {
        return provideRootMatcher(this.module);
    }
}
