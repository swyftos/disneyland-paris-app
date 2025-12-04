package com.disney.id.android.scalp;

import com.disney.id.android.SWID;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.BundlerService;
import com.disney.id.android.tracker.Tracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SiteConfigAndL10nProvider_MembersInjector implements MembersInjector<SiteConfigAndL10nProvider> {
    private final Provider bundlerServiceProvider;
    private final Provider loggerProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public SiteConfigAndL10nProvider_MembersInjector(Provider<BundlerService> provider, Provider<Tracker> provider2, Provider<SWID> provider3, Provider<Logger> provider4) {
        this.bundlerServiceProvider = provider;
        this.trackerProvider = provider2;
        this.swidProvider = provider3;
        this.loggerProvider = provider4;
    }

    public static MembersInjector<SiteConfigAndL10nProvider> create(Provider<BundlerService> provider, Provider<Tracker> provider2, Provider<SWID> provider3, Provider<Logger> provider4) {
        return new SiteConfigAndL10nProvider_MembersInjector(provider, provider2, provider3, provider4);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SiteConfigAndL10nProvider siteConfigAndL10nProvider) {
        injectBundlerService(siteConfigAndL10nProvider, (BundlerService) this.bundlerServiceProvider.get2());
        injectTracker(siteConfigAndL10nProvider, (Tracker) this.trackerProvider.get2());
        injectSwid(siteConfigAndL10nProvider, (SWID) this.swidProvider.get2());
        injectLogger(siteConfigAndL10nProvider, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.scalp.SiteConfigAndL10nProvider.bundlerService")
    public static void injectBundlerService(SiteConfigAndL10nProvider siteConfigAndL10nProvider, BundlerService bundlerService) {
        siteConfigAndL10nProvider.bundlerService = bundlerService;
    }

    @InjectedFieldSignature("com.disney.id.android.scalp.SiteConfigAndL10nProvider.tracker")
    public static void injectTracker(SiteConfigAndL10nProvider siteConfigAndL10nProvider, Tracker tracker) {
        siteConfigAndL10nProvider.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.scalp.SiteConfigAndL10nProvider.swid")
    public static void injectSwid(SiteConfigAndL10nProvider siteConfigAndL10nProvider, SWID swid) {
        siteConfigAndL10nProvider.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.scalp.SiteConfigAndL10nProvider.logger")
    public static void injectLogger(SiteConfigAndL10nProvider siteConfigAndL10nProvider, Logger logger) {
        siteConfigAndL10nProvider.logger = logger;
    }
}
