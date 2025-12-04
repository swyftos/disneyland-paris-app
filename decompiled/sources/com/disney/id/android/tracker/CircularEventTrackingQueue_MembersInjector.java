package com.disney.id.android.tracker;

import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CircularEventTrackingQueue_MembersInjector implements MembersInjector<CircularEventTrackingQueue> {
    private final Provider loggerProvider;

    public CircularEventTrackingQueue_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<CircularEventTrackingQueue> create(Provider<Logger> provider) {
        return new CircularEventTrackingQueue_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CircularEventTrackingQueue circularEventTrackingQueue) {
        injectLogger(circularEventTrackingQueue, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.CircularEventTrackingQueue.logger")
    public static void injectLogger(CircularEventTrackingQueue circularEventTrackingQueue, Logger logger) {
        circularEventTrackingQueue.logger = logger;
    }
}
