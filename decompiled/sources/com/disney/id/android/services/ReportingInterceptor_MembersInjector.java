package com.disney.id.android.services;

import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.Tracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReportingInterceptor_MembersInjector implements MembersInjector<ReportingInterceptor> {
    private final Provider loggerProvider;
    private final Provider trackerProvider;

    public ReportingInterceptor_MembersInjector(Provider<Logger> provider, Provider<Tracker> provider2) {
        this.loggerProvider = provider;
        this.trackerProvider = provider2;
    }

    public static MembersInjector<ReportingInterceptor> create(Provider<Logger> provider, Provider<Tracker> provider2) {
        return new ReportingInterceptor_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ReportingInterceptor reportingInterceptor) {
        injectLogger(reportingInterceptor, (Logger) this.loggerProvider.get2());
        injectTracker(reportingInterceptor, (Tracker) this.trackerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.services.ReportingInterceptor.logger")
    public static void injectLogger(ReportingInterceptor reportingInterceptor, Logger logger) {
        reportingInterceptor.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.services.ReportingInterceptor.tracker")
    public static void injectTracker(ReportingInterceptor reportingInterceptor, Tracker tracker) {
        reportingInterceptor.tracker = tracker;
    }
}
