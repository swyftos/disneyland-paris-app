package androidx.test.espresso.base;

import androidx.test.espresso.UiController;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UiControllerModule_ProvideUiControllerFactory implements Provider<UiController> {
    private final UiControllerModule module;
    private final Provider uiControllerImplProvider;

    public UiControllerModule_ProvideUiControllerFactory(UiControllerModule uiControllerModule, Provider<UiControllerImpl> provider) {
        this.module = uiControllerModule;
        this.uiControllerImplProvider = provider;
    }

    public static UiControllerModule_ProvideUiControllerFactory create(UiControllerModule uiControllerModule, Provider<UiControllerImpl> provider) {
        return new UiControllerModule_ProvideUiControllerFactory(uiControllerModule, provider);
    }

    public static UiController provideUiController(UiControllerModule uiControllerModule, Object obj) {
        return (UiController) Preconditions.checkNotNullFromProvides(uiControllerModule.provideUiController((UiControllerImpl) obj));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public UiController get2() {
        return provideUiController(this.module, this.uiControllerImplProvider.get2());
    }
}
