package com.contentsquare.android.internal.features.initialize;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.logging.LoggerLevelChooser;
import com.contentsquare.android.sdk.C2502G5;
import com.contentsquare.android.sdk.C2559M2;
import com.contentsquare.android.sdk.C2841p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class ContentsquareModule {
    private static C2841p0 sCaptureTouchEvent;

    @Nullable
    @VisibleForTesting
    public static ContentsquareModule sContentsquareModule;
    private static C2559M2 sLiveActivityProvider;

    @NonNull
    @VisibleForTesting
    public static Logger sLogger = new Logger("ContentsquareModule");
    private static LoggerLevelChooser sLoggerLevelChooser;
    private static C2502G5 sSessionReplayProperties;

    public ContentsquareModule(@NonNull Context context) {
        CoreModule coreModuleSafeInstance = CoreModule.safeInstance(context);
        Intrinsics.checkNotNullParameter(context, "context");
        C2559M2 c2559m2 = C2559M2.f1855b;
        if (c2559m2 == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            c2559m2 = new C2559M2((Application) applicationContext);
            C2559M2.f1855b = c2559m2;
        }
        sLiveActivityProvider = c2559m2;
        sCaptureTouchEvent = new C2841p0();
        sLoggerLevelChooser = new LoggerLevelChooser(new LoggerLevelChooser.LoggerNonStatic(), coreModuleSafeInstance.getPreferencesStore(), context);
        sSessionReplayProperties = new C2502G5(coreModuleSafeInstance.getConfiguration(), coreModuleSafeInstance.getPreferencesStore());
    }

    @Nullable
    public static ContentsquareModule getInstance() {
        return sContentsquareModule;
    }

    @NonNull
    public C2841p0 getCaptureTouchEvent() {
        return sCaptureTouchEvent;
    }

    @NonNull
    public C2559M2 getLiveActivityProvider() {
        return sLiveActivityProvider;
    }

    @NonNull
    public LoggerLevelChooser getLoggerLevelChooser() {
        return sLoggerLevelChooser;
    }

    @NonNull
    public C2502G5 getSessionReplayProperties() {
        return sSessionReplayProperties;
    }

    @NonNull
    public static ContentsquareModule getInstance(@NonNull Context context) {
        if (sContentsquareModule == null) {
            sContentsquareModule = new ContentsquareModule(context);
            sLogger.m827d("ContentsquareModule singleton is now initialized.");
        }
        return sContentsquareModule;
    }
}
