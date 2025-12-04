package androidx.test.espresso;

import android.os.Looper;
import androidx.test.espresso.base.ActiveRootLister;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.base.BaseLayerModule_FailureHandlerHolder_Factory;
import androidx.test.espresso.base.BaseLayerModule_ProvideActiveRootListerFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideControlledLooperFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideDefaultFailureHanderFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideDynamicNotiferFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideEventInjectorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideFailureHanderFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideFailureHandlerFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideLifecycleMonitorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideMainLooperFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideMainThreadExecutorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideRemoteExecutorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory;
import androidx.test.espresso.base.BaseLayerModule_ProvideTargetContextFactory;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.base.IdlingResourceRegistry_Factory;
import androidx.test.espresso.base.RootViewPicker_Factory;
import androidx.test.espresso.base.RootViewPicker_RootResultFetcher_Factory;
import androidx.test.espresso.base.RootsOracle_Factory;
import androidx.test.espresso.base.ThreadPoolExecutorExtractor_Factory;
import androidx.test.espresso.base.UiControllerImpl_Factory;
import androidx.test.espresso.base.UiControllerModule;
import androidx.test.espresso.base.UiControllerModule_ProvideUiControllerFactory;
import androidx.test.espresso.base.ViewFinderImpl;
import androidx.test.espresso.base.ViewFinderImpl_Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.DoubleCheck;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import androidx.test.internal.platform.os.ControlledLooper;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerBaseLayerComponent implements BaseLayerComponent {
    private final BaseLayerModule baseLayerModule;
    private Provider failureHandlerHolderProvider;
    private Provider idlingResourceRegistryProvider;
    private Provider provideActiveRootListerProvider;
    private Provider provideCompatAsyncTaskMonitorProvider;
    private Provider provideControlledLooperProvider;
    private Provider provideDefaultFailureHanderProvider;
    private Provider provideDynamicNotiferProvider;
    private Provider provideEventInjectorProvider;
    private Provider provideFailureHanderProvider;
    private Provider provideLifecycleMonitorProvider;
    private Provider provideMainLooperProvider;
    private Provider provideMainThreadExecutorProvider;
    private Provider provideRemoteExecutorProvider;
    private Provider provideSdkAsyncTaskMonitorProvider;
    private Provider provideTargetContextProvider;
    private Provider provideUiControllerProvider;
    private Provider rootsOracleProvider;
    private Provider threadPoolExecutorExtractorProvider;
    private Provider uiControllerImplProvider;

    public static final class Builder {
        private BaseLayerModule baseLayerModule;
        private UiControllerModule uiControllerModule;

        private Builder() {
        }

        public Builder baseLayerModule(BaseLayerModule baseLayerModule) {
            this.baseLayerModule = (BaseLayerModule) Preconditions.checkNotNull(baseLayerModule);
            return this;
        }

        public BaseLayerComponent build() {
            if (this.baseLayerModule == null) {
                this.baseLayerModule = new BaseLayerModule();
            }
            if (this.uiControllerModule == null) {
                this.uiControllerModule = new UiControllerModule();
            }
            return new DaggerBaseLayerComponent(this.baseLayerModule, this.uiControllerModule);
        }

        public Builder uiControllerModule(UiControllerModule uiControllerModule) {
            this.uiControllerModule = (UiControllerModule) Preconditions.checkNotNull(uiControllerModule);
            return this;
        }
    }

    private final class ViewInteractionComponentImpl implements ViewInteractionComponent {
        private Provider provideNeedsActivityProvider;
        private Provider provideRootMatcherProvider;
        private Provider provideRootViewProvider;
        private Provider rootResultFetcherProvider;
        private Provider rootViewPickerProvider;
        private final ViewInteractionModule viewInteractionModule;

        private ViewInteractionComponentImpl(ViewInteractionModule viewInteractionModule) {
            this.viewInteractionModule = viewInteractionModule;
            initialize(viewInteractionModule);
        }

        private void initialize(ViewInteractionModule viewInteractionModule) {
            this.provideRootMatcherProvider = ViewInteractionModule_ProvideRootMatcherFactory.create(viewInteractionModule);
            this.rootResultFetcherProvider = RootViewPicker_RootResultFetcher_Factory.create(DaggerBaseLayerComponent.this.provideActiveRootListerProvider, this.provideRootMatcherProvider);
            this.provideNeedsActivityProvider = ViewInteractionModule_ProvideNeedsActivityFactory.create(viewInteractionModule);
            Provider provider = DoubleCheck.provider(RootViewPicker_Factory.create(DaggerBaseLayerComponent.this.provideUiControllerProvider, this.rootResultFetcherProvider, DaggerBaseLayerComponent.this.provideLifecycleMonitorProvider, this.provideNeedsActivityProvider, DaggerBaseLayerComponent.this.provideControlledLooperProvider));
            this.rootViewPickerProvider = provider;
            this.provideRootViewProvider = ViewInteractionModule_ProvideRootViewFactory.create(viewInteractionModule, provider);
        }

        private ViewFinder viewFinder() {
            return ViewInteractionModule_ProvideViewFinderFactory.provideViewFinder(this.viewInteractionModule, viewFinderImpl());
        }

        private ViewFinderImpl viewFinderImpl() {
            return ViewFinderImpl_Factory.newInstance(ViewInteractionModule_ProvideViewMatcherFactory.provideViewMatcher(this.viewInteractionModule), this.provideRootViewProvider);
        }

        @Override // androidx.test.espresso.ViewInteractionComponent
        public ViewInteraction viewInteraction() {
            return new ViewInteraction((UiController) DaggerBaseLayerComponent.this.provideUiControllerProvider.get2(), viewFinder(), (Executor) DaggerBaseLayerComponent.this.provideMainThreadExecutorProvider.get2(), DaggerBaseLayerComponent.this.failureHandler(), ViewInteractionModule_ProvideViewMatcherFactory.provideViewMatcher(this.viewInteractionModule), ViewInteractionModule_ProvideRootMatcherFactory.provideRootMatcher(this.viewInteractionModule), ViewInteractionModule_ProvideNeedsActivityFactory.provideNeedsActivity(this.viewInteractionModule), ViewInteractionModule_ProvideRemoteInteractionFactory.provideRemoteInteraction(this.viewInteractionModule), (ListeningExecutorService) DaggerBaseLayerComponent.this.provideRemoteExecutorProvider.get2(), (ControlledLooper) DaggerBaseLayerComponent.this.provideControlledLooperProvider.get2());
        }
    }

    private DaggerBaseLayerComponent(BaseLayerModule baseLayerModule, UiControllerModule uiControllerModule) {
        this.baseLayerModule = baseLayerModule;
        initialize(baseLayerModule, uiControllerModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static BaseLayerComponent create() {
        return new Builder().build();
    }

    private void initialize(BaseLayerModule baseLayerModule, UiControllerModule uiControllerModule) {
        BaseLayerModule_ProvideTargetContextFactory baseLayerModule_ProvideTargetContextFactoryCreate = BaseLayerModule_ProvideTargetContextFactory.create(baseLayerModule);
        this.provideTargetContextProvider = baseLayerModule_ProvideTargetContextFactoryCreate;
        BaseLayerModule_ProvideDefaultFailureHanderFactory baseLayerModule_ProvideDefaultFailureHanderFactoryCreate = BaseLayerModule_ProvideDefaultFailureHanderFactory.create(baseLayerModule, baseLayerModule_ProvideTargetContextFactoryCreate);
        this.provideDefaultFailureHanderProvider = baseLayerModule_ProvideDefaultFailureHanderFactoryCreate;
        BaseLayerModule_ProvideFailureHanderFactory baseLayerModule_ProvideFailureHanderFactoryCreate = BaseLayerModule_ProvideFailureHanderFactory.create(baseLayerModule, baseLayerModule_ProvideDefaultFailureHanderFactoryCreate);
        this.provideFailureHanderProvider = baseLayerModule_ProvideFailureHanderFactoryCreate;
        this.failureHandlerHolderProvider = DoubleCheck.provider(BaseLayerModule_FailureHandlerHolder_Factory.create(baseLayerModule_ProvideFailureHanderFactoryCreate));
        Provider provider = DoubleCheck.provider(BaseLayerModule_ProvideMainLooperFactory.create(baseLayerModule));
        this.provideMainLooperProvider = provider;
        this.idlingResourceRegistryProvider = DoubleCheck.provider(IdlingResourceRegistry_Factory.create(provider));
        this.provideEventInjectorProvider = DoubleCheck.provider(BaseLayerModule_ProvideEventInjectorFactory.create(baseLayerModule));
        Provider provider2 = DoubleCheck.provider(ThreadPoolExecutorExtractor_Factory.create(this.provideMainLooperProvider));
        this.threadPoolExecutorExtractorProvider = provider2;
        this.provideSdkAsyncTaskMonitorProvider = DoubleCheck.provider(BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory.create(baseLayerModule, provider2));
        this.provideCompatAsyncTaskMonitorProvider = DoubleCheck.provider(BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory.create(baseLayerModule, this.threadPoolExecutorExtractorProvider));
        BaseLayerModule_ProvideDynamicNotiferFactory baseLayerModule_ProvideDynamicNotiferFactoryCreate = BaseLayerModule_ProvideDynamicNotiferFactory.create(baseLayerModule, this.idlingResourceRegistryProvider);
        this.provideDynamicNotiferProvider = baseLayerModule_ProvideDynamicNotiferFactoryCreate;
        Provider provider3 = DoubleCheck.provider(UiControllerImpl_Factory.create(this.provideEventInjectorProvider, this.provideSdkAsyncTaskMonitorProvider, this.provideCompatAsyncTaskMonitorProvider, baseLayerModule_ProvideDynamicNotiferFactoryCreate, this.provideMainLooperProvider, this.idlingResourceRegistryProvider));
        this.uiControllerImplProvider = provider3;
        this.provideUiControllerProvider = DoubleCheck.provider(UiControllerModule_ProvideUiControllerFactory.create(uiControllerModule, provider3));
        this.provideMainThreadExecutorProvider = DoubleCheck.provider(BaseLayerModule_ProvideMainThreadExecutorFactory.create(baseLayerModule, this.provideMainLooperProvider));
        this.provideControlledLooperProvider = DoubleCheck.provider(BaseLayerModule_ProvideControlledLooperFactory.create(baseLayerModule));
        RootsOracle_Factory rootsOracle_FactoryCreate = RootsOracle_Factory.create(this.provideMainLooperProvider);
        this.rootsOracleProvider = rootsOracle_FactoryCreate;
        this.provideActiveRootListerProvider = BaseLayerModule_ProvideActiveRootListerFactory.create(baseLayerModule, rootsOracle_FactoryCreate);
        this.provideLifecycleMonitorProvider = BaseLayerModule_ProvideLifecycleMonitorFactory.create(baseLayerModule);
        this.provideRemoteExecutorProvider = DoubleCheck.provider(BaseLayerModule_ProvideRemoteExecutorFactory.create(baseLayerModule));
    }

    private Object rootsOracle() {
        return RootsOracle_Factory.newInstance((Looper) this.provideMainLooperProvider.get2());
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public ActiveRootLister activeRootLister() {
        return BaseLayerModule_ProvideActiveRootListerFactory.provideActiveRootLister(this.baseLayerModule, rootsOracle());
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public ControlledLooper controlledLooper() {
        return (ControlledLooper) this.provideControlledLooperProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public FailureHandler failureHandler() {
        return BaseLayerModule_ProvideFailureHandlerFactory.provideFailureHandler(this.baseLayerModule, (BaseLayerModule.FailureHandlerHolder) this.failureHandlerHolderProvider.get2());
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public BaseLayerModule.FailureHandlerHolder failureHolder() {
        return (BaseLayerModule.FailureHandlerHolder) this.failureHandlerHolderProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public IdlingResourceRegistry idlingResourceRegistry() {
        return (IdlingResourceRegistry) this.idlingResourceRegistryProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public Executor mainThreadExecutor() {
        return (Executor) this.provideMainThreadExecutorProvider.get2();
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public ViewInteractionComponent plus(ViewInteractionModule viewInteractionModule) {
        Preconditions.checkNotNull(viewInteractionModule);
        return new ViewInteractionComponentImpl(viewInteractionModule);
    }

    @Override // androidx.test.espresso.BaseLayerComponent
    public UiController uiController() {
        return (UiController) this.provideUiControllerProvider.get2();
    }
}
