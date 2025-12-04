package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.ConfigRetrieverCallback;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.C5;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class A0 {

    @NotNull
    public static final Logger a = new Logger(null, 1, null);
    public static boolean b;
    public static boolean c;

    @VisibleForTesting
    public static void a() {
        if (b && c) {
            synchronized (C0866z0.a) {
                while (true) {
                    try {
                        LinkedBlockingQueue linkedBlockingQueue = C0866z0.d;
                        if (linkedBlockingQueue.isEmpty()) {
                            C0866z0.b = true;
                        } else {
                            Consumer consumer = (Consumer) linkedBlockingQueue.remove();
                            Intrinsics.checkNotNullExpressionValue(consumer, "consumer");
                            CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
                            if (csRuntimeModule != null) {
                                M4 runTime = csRuntimeModule.getRunTime();
                                Intrinsics.checkNotNullExpressionValue(runTime, "runtimeModule.runTime");
                                C0866z0.a(consumer, runTime);
                            } else {
                                C0866z0.e.p("Contentsquare SDK: Unable to call the public API, make sure you are not opted out of the Contentsquare tracker and SDK was correctly initialized.");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public static final void b() {
        if (c) {
            return;
        }
        c = true;
        a();
    }

    @JvmStatic
    public static final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            a.i("Could not initialize Contentsquare SDK because application context is null.");
            return;
        }
        try {
            CoreModule coreModuleSafeInstance = CoreModule.INSTANCE.safeInstance(applicationContext);
            Telemetry telemetry = Telemetry.INSTANCE;
            telemetry.init((Application) applicationContext);
            Logger logger = Z5.a;
            if (CsRuntimeModule.getInstance() != null) {
                a.i("Contentsquare SDK is already initialized.");
                a();
            } else {
                telemetry.startMeasureTime("sdk_initialize");
                ContentsquareModule.getInstance(applicationContext);
                coreModuleSafeInstance.getPreferencesStore().putBoolean(PreferencesKey.FORGET_ME, false);
                coreModuleSafeInstance.getPreferencesStore().putBoolean(PreferencesKey.PAUSE_TRACKING, false);
                C5 c5 = C5.k;
                C5.a.a((Application) applicationContext, coreModuleSafeInstance);
                Z5.a(applicationContext, ProcessLifecycleOwner.INSTANCE.get(), new ConfigRetrieverCallback() { // from class: com.contentsquare.android.sdk.A0$$ExternalSyntheticLambda0
                    @Override // com.contentsquare.android.core.features.config.ConfigRetrieverCallback
                    public final void onConfigRetrieved() {
                        A0.b();
                    }
                });
                C0644c3.a(applicationContext);
                telemetry.stopMeasureTime("sdk_initialize");
                if (!b) {
                    b = true;
                    a();
                }
            }
        } catch (Exception e) {
            Logger logger2 = a;
            logger2.i("Something went wrong, Contentsquare SDK couldn't be initialized. " + e);
            Q2.a(logger2, "Failed to initialize Contentsquare SDK.", e);
        }
    }
}
