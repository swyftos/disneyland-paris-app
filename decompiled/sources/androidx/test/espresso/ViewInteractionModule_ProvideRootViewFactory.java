package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ViewInteractionModule_ProvideRootViewFactory implements Provider<View> {
    private final ViewInteractionModule module;
    private final Provider rootViewPickerProvider;

    public ViewInteractionModule_ProvideRootViewFactory(ViewInteractionModule viewInteractionModule, Provider<RootViewPicker> provider) {
        this.module = viewInteractionModule;
        this.rootViewPickerProvider = provider;
    }

    public static ViewInteractionModule_ProvideRootViewFactory create(ViewInteractionModule viewInteractionModule, Provider<RootViewPicker> provider) {
        return new ViewInteractionModule_ProvideRootViewFactory(viewInteractionModule, provider);
    }

    public static View provideRootView(ViewInteractionModule viewInteractionModule, RootViewPicker rootViewPicker) {
        return (View) Preconditions.checkNotNullFromProvides(viewInteractionModule.provideRootView(rootViewPicker));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public View get2() {
        return provideRootView(this.module, (RootViewPicker) this.rootViewPickerProvider.get2());
    }
}
