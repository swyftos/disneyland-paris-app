package com.disney.id.android.utils;

import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ActivityFlagParser_MembersInjector implements MembersInjector<ActivityFlagParser> {
    private final Provider loggerProvider;

    public ActivityFlagParser_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<ActivityFlagParser> create(Provider<Logger> provider) {
        return new ActivityFlagParser_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ActivityFlagParser activityFlagParser) {
        injectLogger(activityFlagParser, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.utils.ActivityFlagParser.logger")
    public static void injectLogger(ActivityFlagParser activityFlagParser, Logger logger) {
        activityFlagParser.logger = logger;
    }
}
