package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.contentsquare.android.Contentsquare;
import com.contentsquare.android.core.features.config.ConfigRetrieverCallback;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class Z5 {
    public static final Logger a = new Logger("SingletonProvider");

    public static void a(@NonNull Context context, @NonNull LifecycleOwner lifecycleOwner, @NonNull ConfigRetrieverCallback configRetrieverCallback) {
        if (CsRuntimeModule.getInstance() != null) {
            return;
        }
        Application application = (Application) context.getApplicationContext();
        if (CsRuntimeModule.getInstance() == null) {
            synchronized (Contentsquare.class) {
                try {
                    if (CsRuntimeModule.getInstance() == null) {
                        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance(application);
                        Logger logger = a;
                        logger.d("Initializing the Runtime...");
                        CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance(application);
                        logger.p("Contentsquare SDK 4.36.0 starting in app: " + application.getPackageName());
                        C0853x5 sdkManager = csApplicationModule.getSdkManager();
                        sdkManager.e = csRuntimeModule.getLegacyComponentsHolder();
                        sdkManager.a();
                        csRuntimeModule.getConfigurationRefresher().bindToAppLifeCycle(configRetrieverCallback);
                        F0.a();
                        logger.d("CsRuntimeModule SDK singleton is now initialized.");
                    }
                } finally {
                }
            }
        }
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        new com.contentsquare.android.reactnative.workaround.a(new ReactNativeProcessLifecycle.a(application), lifecycleOwner);
    }
}
