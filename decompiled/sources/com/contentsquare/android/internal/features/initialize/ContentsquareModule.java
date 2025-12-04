package com.contentsquare.android.internal.features.initialize;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.logging.LoggerLevelChooser;
import com.contentsquare.android.sdk.C0771p0;
import com.contentsquare.android.sdk.G5;
import com.contentsquare.android.sdk.M2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class ContentsquareModule {
    private static C0771p0 sCaptureTouchEvent;

    @Nullable
    @VisibleForTesting
    public static ContentsquareModule sContentsquareModule;
    private static M2 sLiveActivityProvider;

    @NonNull
    @VisibleForTesting
    public static Logger sLogger = new Logger("ContentsquareModule");
    private static LoggerLevelChooser sLoggerLevelChooser;
    private static G5 sSessionReplayProperties;

    public ContentsquareModule(@NonNull Context context) {
        CoreModule coreModuleSafeInstance = CoreModule.safeInstance(context);
        Intrinsics.checkNotNullParameter(context, "context");
        M2 m2 = M2.b;
        if (m2 == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            m2 = new M2((Application) applicationContext);
            M2.b = m2;
        }
        sLiveActivityProvider = m2;
        sCaptureTouchEvent = new C0771p0();
        sLoggerLevelChooser = new LoggerLevelChooser(new LoggerLevelChooser.LoggerNonStatic(), coreModuleSafeInstance.getPreferencesStore(), context);
        sSessionReplayProperties = new G5(coreModuleSafeInstance.getConfiguration(), coreModuleSafeInstance.getPreferencesStore());
    }

    @Nullable
    public static ContentsquareModule getInstance() {
        return sContentsquareModule;
    }

    @NonNull
    public C0771p0 getCaptureTouchEvent() {
        return sCaptureTouchEvent;
    }

    @NonNull
    public M2 getLiveActivityProvider() {
        return sLiveActivityProvider;
    }

    @NonNull
    public LoggerLevelChooser getLoggerLevelChooser() {
        return sLoggerLevelChooser;
    }

    @NonNull
    public G5 getSessionReplayProperties() {
        return sSessionReplayProperties;
    }

    @NonNull
    public static ContentsquareModule getInstance(@NonNull Context context) {
        if (sContentsquareModule == null) {
            sContentsquareModule = new ContentsquareModule(context);
            sLogger.d("ContentsquareModule singleton is now initialized.");
        }
        return sContentsquareModule;
    }
}
