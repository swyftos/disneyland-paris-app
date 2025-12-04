package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    private final Provider eventClockProvider;
    private final Provider initializerProvider;
    private final Provider schedulerProvider;
    private final Provider uploaderProvider;
    private final Provider uptimeClockProvider;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.eventClockProvider = provider;
        this.uptimeClockProvider = provider2;
        this.schedulerProvider = provider3;
        this.uploaderProvider = provider4;
        this.initializerProvider = provider5;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public TransportRuntime get2() {
        return newInstance((Clock) this.eventClockProvider.get2(), (Clock) this.uptimeClockProvider.get2(), (Scheduler) this.schedulerProvider.get2(), (Uploader) this.uploaderProvider.get2(), (WorkInitializer) this.initializerProvider.get2());
    }

    public static TransportRuntime_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }
}
