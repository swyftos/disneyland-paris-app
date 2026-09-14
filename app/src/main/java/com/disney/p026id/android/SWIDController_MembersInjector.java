package com.disney.p026id.android;

import com.disney.p026id.android.localdata.LocalStorage;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes3.dex */
@DaggerGenerated
@QualifierMetadata
public final class SWIDController_MembersInjector implements MembersInjector<SWIDController> {
    private final Provider storageProvider;

    public SWIDController_MembersInjector(Provider<LocalStorage> provider) {
        this.storageProvider = provider;
    }

    public static MembersInjector<SWIDController> create(Provider<LocalStorage> provider) {
        return new SWIDController_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SWIDController sWIDController) {
        injectStorage(sWIDController, (LocalStorage) this.storageProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.SWIDController.storage")
    public static void injectStorage(SWIDController sWIDController, LocalStorage localStorage) {
        sWIDController.storage = localStorage;
    }
}
