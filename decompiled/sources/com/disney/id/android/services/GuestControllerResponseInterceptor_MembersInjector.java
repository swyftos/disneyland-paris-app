package com.disney.id.android.services;

import com.disney.id.android.Session;
import com.disney.id.android.tracker.Tracker;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GuestControllerResponseInterceptor_MembersInjector implements MembersInjector<GuestControllerResponseInterceptor> {
    private final Provider sessionProvider;
    private final Provider trackerProvider;

    public GuestControllerResponseInterceptor_MembersInjector(Provider<Tracker> provider, Provider<Session> provider2) {
        this.trackerProvider = provider;
        this.sessionProvider = provider2;
    }

    public static MembersInjector<GuestControllerResponseInterceptor> create(Provider<Tracker> provider, Provider<Session> provider2) {
        return new GuestControllerResponseInterceptor_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(GuestControllerResponseInterceptor guestControllerResponseInterceptor) {
        injectTracker(guestControllerResponseInterceptor, (Tracker) this.trackerProvider.get2());
        injectSession(guestControllerResponseInterceptor, DoubleCheck.lazy(this.sessionProvider));
    }

    @InjectedFieldSignature("com.disney.id.android.services.GuestControllerResponseInterceptor.tracker")
    public static void injectTracker(GuestControllerResponseInterceptor guestControllerResponseInterceptor, Tracker tracker) {
        guestControllerResponseInterceptor.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.services.GuestControllerResponseInterceptor.session")
    public static void injectSession(GuestControllerResponseInterceptor guestControllerResponseInterceptor, Lazy<Session> lazy) {
        guestControllerResponseInterceptor.session = lazy;
    }
}
