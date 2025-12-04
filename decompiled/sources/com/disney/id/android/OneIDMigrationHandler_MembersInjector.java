package com.disney.id.android;

import android.content.Context;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDMigrationHandler_MembersInjector implements MembersInjector<OneIDMigrationHandler> {
    private final Provider configHandlerProvider;
    private final Provider contextProvider;
    private final Provider loggerProvider;
    private final Provider storageProvider;
    private final Provider swidControllerProvider;

    public OneIDMigrationHandler_MembersInjector(Provider<LocalStorage> provider, Provider<Context> provider2, Provider<SWID> provider3, Provider<ConfigHandler> provider4, Provider<Logger> provider5) {
        this.storageProvider = provider;
        this.contextProvider = provider2;
        this.swidControllerProvider = provider3;
        this.configHandlerProvider = provider4;
        this.loggerProvider = provider5;
    }

    public static MembersInjector<OneIDMigrationHandler> create(Provider<LocalStorage> provider, Provider<Context> provider2, Provider<SWID> provider3, Provider<ConfigHandler> provider4, Provider<Logger> provider5) {
        return new OneIDMigrationHandler_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDMigrationHandler oneIDMigrationHandler) {
        injectStorage(oneIDMigrationHandler, (LocalStorage) this.storageProvider.get2());
        injectContext(oneIDMigrationHandler, (Context) this.contextProvider.get2());
        injectSwidController(oneIDMigrationHandler, (SWID) this.swidControllerProvider.get2());
        injectConfigHandler(oneIDMigrationHandler, (ConfigHandler) this.configHandlerProvider.get2());
        injectLogger(oneIDMigrationHandler, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDMigrationHandler.storage")
    public static void injectStorage(OneIDMigrationHandler oneIDMigrationHandler, LocalStorage localStorage) {
        oneIDMigrationHandler.storage = localStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDMigrationHandler.context")
    public static void injectContext(OneIDMigrationHandler oneIDMigrationHandler, Context context) {
        oneIDMigrationHandler.context = context;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDMigrationHandler.swidController")
    public static void injectSwidController(OneIDMigrationHandler oneIDMigrationHandler, SWID swid) {
        oneIDMigrationHandler.swidController = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDMigrationHandler.configHandler")
    public static void injectConfigHandler(OneIDMigrationHandler oneIDMigrationHandler, ConfigHandler configHandler) {
        oneIDMigrationHandler.configHandler = configHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDMigrationHandler.logger")
    public static void injectLogger(OneIDMigrationHandler oneIDMigrationHandler, Logger logger) {
        oneIDMigrationHandler.logger = logger;
    }
}
