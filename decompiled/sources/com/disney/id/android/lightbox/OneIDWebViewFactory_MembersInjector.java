package com.disney.id.android.lightbox;

import com.disney.id.android.SWID;
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
public final class OneIDWebViewFactory_MembersInjector implements MembersInjector<OneIDWebViewFactory> {
    private final Provider loggerProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneIDWebViewFactory_MembersInjector(Provider<Logger> provider, Provider<Tracker> provider2, Provider<SWID> provider3) {
        this.loggerProvider = provider;
        this.trackerProvider = provider2;
        this.swidProvider = provider3;
    }

    public static MembersInjector<OneIDWebViewFactory> create(Provider<Logger> provider, Provider<Tracker> provider2, Provider<SWID> provider3) {
        return new OneIDWebViewFactory_MembersInjector(provider, provider2, provider3);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDWebViewFactory oneIDWebViewFactory) {
        injectLogger(oneIDWebViewFactory, (Logger) this.loggerProvider.get2());
        injectTracker(oneIDWebViewFactory, (Tracker) this.trackerProvider.get2());
        injectSwid(oneIDWebViewFactory, (SWID) this.swidProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebViewFactory.logger")
    public static void injectLogger(OneIDWebViewFactory oneIDWebViewFactory, Logger logger) {
        oneIDWebViewFactory.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebViewFactory.tracker")
    public static void injectTracker(OneIDWebViewFactory oneIDWebViewFactory, Tracker tracker) {
        oneIDWebViewFactory.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebViewFactory.swid")
    public static void injectSwid(OneIDWebViewFactory oneIDWebViewFactory, SWID swid) {
        oneIDWebViewFactory.swid = swid;
    }
}
