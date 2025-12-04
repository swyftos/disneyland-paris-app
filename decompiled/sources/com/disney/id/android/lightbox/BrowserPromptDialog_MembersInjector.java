package com.disney.id.android.lightbox;

import com.disney.id.android.SCALPController;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BrowserPromptDialog_MembersInjector implements MembersInjector<BrowserPromptDialog> {
    private final Provider loggerProvider;
    private final Provider scalpControllerProvider;

    public BrowserPromptDialog_MembersInjector(Provider<Logger> provider, Provider<SCALPController> provider2) {
        this.loggerProvider = provider;
        this.scalpControllerProvider = provider2;
    }

    public static MembersInjector<BrowserPromptDialog> create(Provider<Logger> provider, Provider<SCALPController> provider2) {
        return new BrowserPromptDialog_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BrowserPromptDialog browserPromptDialog) {
        injectLogger(browserPromptDialog, (Logger) this.loggerProvider.get2());
        injectScalpController(browserPromptDialog, (SCALPController) this.scalpControllerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.BrowserPromptDialog.logger")
    public static void injectLogger(BrowserPromptDialog browserPromptDialog, Logger logger) {
        browserPromptDialog.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.BrowserPromptDialog.scalpController")
    public static void injectScalpController(BrowserPromptDialog browserPromptDialog, SCALPController sCALPController) {
        browserPromptDialog.scalpController = sCALPController;
    }
}
