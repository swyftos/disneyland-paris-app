package com.disney.id.android.tracker;

import com.disney.id.android.ConfigHandler;
import com.disney.id.android.Connectivity;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.MigrationHandler;
import com.disney.id.android.SCALPConfigHandler;
import com.disney.id.android.SWID;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDTracker_MembersInjector implements MembersInjector<OneIDTracker> {
    private final Provider configHandlerProvider;
    private final Provider connProvider;
    private final Provider eventQueueProvider;
    private final Provider guestHandlerProvider;
    private final Provider loggerProvider;
    private final Provider migrationHandlerProvider;
    private final Provider scalpConfigHandlerProvider;
    private final Provider swidProvider;

    public OneIDTracker_MembersInjector(Provider<Logger> provider, Provider<SWID> provider2, Provider<EventQueue> provider3, Provider<MigrationHandler> provider4, Provider<ConfigHandler> provider5, Provider<GuestHandler> provider6, Provider<SCALPConfigHandler> provider7, Provider<Connectivity> provider8) {
        this.loggerProvider = provider;
        this.swidProvider = provider2;
        this.eventQueueProvider = provider3;
        this.migrationHandlerProvider = provider4;
        this.configHandlerProvider = provider5;
        this.guestHandlerProvider = provider6;
        this.scalpConfigHandlerProvider = provider7;
        this.connProvider = provider8;
    }

    public static MembersInjector<OneIDTracker> create(Provider<Logger> provider, Provider<SWID> provider2, Provider<EventQueue> provider3, Provider<MigrationHandler> provider4, Provider<ConfigHandler> provider5, Provider<GuestHandler> provider6, Provider<SCALPConfigHandler> provider7, Provider<Connectivity> provider8) {
        return new OneIDTracker_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDTracker oneIDTracker) {
        injectLogger(oneIDTracker, (Logger) this.loggerProvider.get2());
        injectSwid(oneIDTracker, (SWID) this.swidProvider.get2());
        injectEventQueue(oneIDTracker, (EventQueue) this.eventQueueProvider.get2());
        injectMigrationHandler(oneIDTracker, (MigrationHandler) this.migrationHandlerProvider.get2());
        injectConfigHandler(oneIDTracker, (ConfigHandler) this.configHandlerProvider.get2());
        injectGuestHandler(oneIDTracker, (GuestHandler) this.guestHandlerProvider.get2());
        injectScalpConfigHandler(oneIDTracker, (SCALPConfigHandler) this.scalpConfigHandlerProvider.get2());
        injectConn(oneIDTracker, (Connectivity) this.connProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.logger")
    public static void injectLogger(OneIDTracker oneIDTracker, Logger logger) {
        oneIDTracker.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.swid")
    public static void injectSwid(OneIDTracker oneIDTracker, SWID swid) {
        oneIDTracker.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.eventQueue")
    public static void injectEventQueue(OneIDTracker oneIDTracker, EventQueue eventQueue) {
        oneIDTracker.eventQueue = eventQueue;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.migrationHandler")
    public static void injectMigrationHandler(OneIDTracker oneIDTracker, MigrationHandler migrationHandler) {
        oneIDTracker.migrationHandler = migrationHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.configHandler")
    public static void injectConfigHandler(OneIDTracker oneIDTracker, ConfigHandler configHandler) {
        oneIDTracker.configHandler = configHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.guestHandler")
    public static void injectGuestHandler(OneIDTracker oneIDTracker, GuestHandler guestHandler) {
        oneIDTracker.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.scalpConfigHandler")
    public static void injectScalpConfigHandler(OneIDTracker oneIDTracker, SCALPConfigHandler sCALPConfigHandler) {
        oneIDTracker.scalpConfigHandler = sCALPConfigHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDTracker.conn")
    public static void injectConn(OneIDTracker oneIDTracker, Connectivity connectivity) {
        oneIDTracker.conn = connectivity;
    }
}
