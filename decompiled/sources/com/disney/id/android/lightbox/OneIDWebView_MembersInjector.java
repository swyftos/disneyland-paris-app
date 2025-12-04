package com.disney.id.android.lightbox;

import com.disney.id.android.SWID;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.localdata.ExposedStorage;
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
public final class OneIDWebView_MembersInjector implements MembersInjector<OneIDWebView> {
    private final Provider bundleProvider;
    private final Provider loggerProvider;
    private final Provider oneIDStorageProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneIDWebView_MembersInjector(Provider<ExposedStorage> provider, Provider<Logger> provider2, Provider<Bundler> provider3, Provider<Tracker> provider4, Provider<SWID> provider5) {
        this.oneIDStorageProvider = provider;
        this.loggerProvider = provider2;
        this.bundleProvider = provider3;
        this.trackerProvider = provider4;
        this.swidProvider = provider5;
    }

    public static MembersInjector<OneIDWebView> create(Provider<ExposedStorage> provider, Provider<Logger> provider2, Provider<Bundler> provider3, Provider<Tracker> provider4, Provider<SWID> provider5) {
        return new OneIDWebView_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDWebView oneIDWebView) {
        injectOneIDStorage(oneIDWebView, (ExposedStorage) this.oneIDStorageProvider.get2());
        injectLogger(oneIDWebView, (Logger) this.loggerProvider.get2());
        injectBundle(oneIDWebView, (Bundler) this.bundleProvider.get2());
        injectTracker(oneIDWebView, (Tracker) this.trackerProvider.get2());
        injectSwid(oneIDWebView, (SWID) this.swidProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebView.oneIDStorage")
    public static void injectOneIDStorage(OneIDWebView oneIDWebView, ExposedStorage exposedStorage) {
        oneIDWebView.oneIDStorage = exposedStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebView.logger")
    public static void injectLogger(OneIDWebView oneIDWebView, Logger logger) {
        oneIDWebView.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebView.bundle")
    public static void injectBundle(OneIDWebView oneIDWebView, Bundler bundler) {
        oneIDWebView.bundle = bundler;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebView.tracker")
    public static void injectTracker(OneIDWebView oneIDWebView, Tracker tracker) {
        oneIDWebView.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.OneIDWebView.swid")
    public static void injectSwid(OneIDWebView oneIDWebView, SWID swid) {
        oneIDWebView.swid = swid;
    }
}
