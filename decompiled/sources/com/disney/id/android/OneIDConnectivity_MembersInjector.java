package com.disney.id.android;

import android.content.Context;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDConnectivity_MembersInjector implements MembersInjector<OneIDConnectivity> {
    private final Provider appContextProvider;
    private final Provider loggerProvider;

    public OneIDConnectivity_MembersInjector(Provider<Context> provider, Provider<Logger> provider2) {
        this.appContextProvider = provider;
        this.loggerProvider = provider2;
    }

    public static MembersInjector<OneIDConnectivity> create(Provider<Context> provider, Provider<Logger> provider2) {
        return new OneIDConnectivity_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDConnectivity oneIDConnectivity) {
        injectAppContext(oneIDConnectivity, (Context) this.appContextProvider.get2());
        injectLogger(oneIDConnectivity, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDConnectivity.appContext")
    public static void injectAppContext(OneIDConnectivity oneIDConnectivity, Context context) {
        oneIDConnectivity.appContext = context;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDConnectivity.logger")
    public static void injectLogger(OneIDConnectivity oneIDConnectivity, Logger logger) {
        oneIDConnectivity.logger = logger;
    }
}
