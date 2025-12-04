package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class ViewInteractionModule_ProvideViewMatcherFactory implements Provider<Matcher<View>> {
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideViewMatcherFactory(ViewInteractionModule viewInteractionModule) {
        this.module = viewInteractionModule;
    }

    public static ViewInteractionModule_ProvideViewMatcherFactory create(ViewInteractionModule viewInteractionModule) {
        return new ViewInteractionModule_ProvideViewMatcherFactory(viewInteractionModule);
    }

    public static Matcher<View> provideViewMatcher(ViewInteractionModule viewInteractionModule) {
        return (Matcher) Preconditions.checkNotNullFromProvides(viewInteractionModule.provideViewMatcher());
    }

    @Override // javax.inject.Provider
    /* renamed from: get, reason: avoid collision after fix types in other method */
    public Matcher<View> get2() {
        return provideViewMatcher(this.module);
    }
}
