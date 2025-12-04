package com.disney.id.android.tracker;

import com.disney.id.android.Connectivity;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDEventQueue_MembersInjector implements MembersInjector<OneIDEventQueue> {
    private final Provider connectivityProvider;
    private final Provider loggerProvider;
    private final Provider senderProvider;

    public OneIDEventQueue_MembersInjector(Provider<Logger> provider, Provider<Sender> provider2, Provider<Connectivity> provider3) {
        this.loggerProvider = provider;
        this.senderProvider = provider2;
        this.connectivityProvider = provider3;
    }

    public static MembersInjector<OneIDEventQueue> create(Provider<Logger> provider, Provider<Sender> provider2, Provider<Connectivity> provider3) {
        return new OneIDEventQueue_MembersInjector(provider, provider2, provider3);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDEventQueue oneIDEventQueue) {
        injectLogger(oneIDEventQueue, (Logger) this.loggerProvider.get2());
        injectSender(oneIDEventQueue, (Sender) this.senderProvider.get2());
        injectConnectivity(oneIDEventQueue, (Connectivity) this.connectivityProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDEventQueue.logger")
    public static void injectLogger(OneIDEventQueue oneIDEventQueue, Logger logger) {
        oneIDEventQueue.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDEventQueue.sender")
    public static void injectSender(OneIDEventQueue oneIDEventQueue, Sender sender) {
        oneIDEventQueue.sender = sender;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.OneIDEventQueue.connectivity")
    public static void injectConnectivity(OneIDEventQueue oneIDEventQueue, Connectivity connectivity) {
        oneIDEventQueue.connectivity = connectivity;
    }
}
