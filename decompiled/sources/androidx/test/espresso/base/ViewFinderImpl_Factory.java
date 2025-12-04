package androidx.test.espresso.base;

import android.view.View;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class ViewFinderImpl_Factory implements Provider<ViewFinderImpl> {
    private final Provider rootViewProvider;
    private final Provider viewMatcherProvider;

    public ViewFinderImpl_Factory(Provider<Matcher<View>> provider, Provider<View> provider2) {
        this.viewMatcherProvider = provider;
        this.rootViewProvider = provider2;
    }

    public static ViewFinderImpl_Factory create(Provider<Matcher<View>> provider, Provider<View> provider2) {
        return new ViewFinderImpl_Factory(provider, provider2);
    }

    public static ViewFinderImpl newInstance(Matcher<View> matcher, Provider<View> provider) {
        return new ViewFinderImpl(matcher, provider);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public ViewFinderImpl get2() {
        return newInstance((Matcher) this.viewMatcherProvider.get2(), this.rootViewProvider);
    }
}
