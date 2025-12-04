package com.disney.id.android.tracker;

import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.LogGoService;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogGoSender_MembersInjector implements MembersInjector<LogGoSender> {
    private final Provider logGoServiceProvider;
    private final Provider loggerProvider;

    public LogGoSender_MembersInjector(Provider<Logger> provider, Provider<LogGoService> provider2) {
        this.loggerProvider = provider;
        this.logGoServiceProvider = provider2;
    }

    public static MembersInjector<LogGoSender> create(Provider<Logger> provider, Provider<LogGoService> provider2) {
        return new LogGoSender_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LogGoSender logGoSender) {
        injectLogger(logGoSender, (Logger) this.loggerProvider.get2());
        injectLogGoService(logGoSender, (LogGoService) this.logGoServiceProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.LogGoSender.logger")
    public static void injectLogger(LogGoSender logGoSender, Logger logger) {
        logGoSender.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.tracker.LogGoSender.logGoService")
    public static void injectLogGoService(LogGoSender logGoSender, LogGoService logGoService) {
        logGoSender.logGoService = logGoService;
    }
}
