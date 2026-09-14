package com.disney.p026id.android.dagger;

import android.content.Context;
import com.disney.p026id.android.lightbox.OneIDWebViewFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideOneIDWebViewFactoryFactory implements Factory<OneIDWebViewFactory> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideOneIDWebViewFactoryFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public OneIDWebViewFactory get2() {
        return provideOneIDWebViewFactory(this.module, (Context) this.appContextProvider.get2());
    }

    public static OneIDModule_ProvideOneIDWebViewFactoryFactory create(OneIDModule oneIDModule, Provider<Context> provider) {
        return new OneIDModule_ProvideOneIDWebViewFactoryFactory(oneIDModule, provider);
    }

    public static OneIDWebViewFactory provideOneIDWebViewFactory(OneIDModule oneIDModule, Context context) {
        return (OneIDWebViewFactory) Preconditions.checkNotNullFromProvides(oneIDModule.provideOneIDWebViewFactory(context));
    }
}
