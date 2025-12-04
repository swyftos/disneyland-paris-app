package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideOneIDWebViewFactoryFactory implements Factory<OneIDWebViewFactory> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideOneIDWebViewFactoryFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
