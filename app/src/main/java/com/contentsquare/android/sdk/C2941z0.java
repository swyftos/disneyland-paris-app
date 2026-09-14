package com.contentsquare.android.sdk;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2941z0 {

    /* JADX INFO: renamed from: b */
    public static boolean f3293b;

    /* JADX INFO: renamed from: c */
    public static boolean f3294c;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C2941z0 f3292a = new C2941z0();

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final LinkedBlockingQueue f3295d = new LinkedBlockingQueue(200);

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final Logger f3296e = new Logger("ContentsquareConsumerExecutor");

    /* JADX INFO: renamed from: a */
    public static void m1241a(final Consumer consumer, final C2561M4 c2561m4) {
        if (C2918w7.m1227a()) {
            consumer.accept(c2561m4);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.contentsquare.android.sdk.z0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2941z0.m1242b(consumer, c2561m4);
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1242b(Consumer consumer, C2561M4 runtime) {
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(runtime, "$runtime");
        consumer.accept(runtime);
    }

    @JvmOverloads
    /* JADX INFO: renamed from: a */
    public final void m1243a(@NotNull Consumer<C2561M4> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        m1244a(false, consumer);
    }

    @JvmOverloads
    /* JADX INFO: renamed from: a */
    public final synchronized void m1244a(boolean z, @NotNull Consumer<C2561M4> consumer) {
        Logger logger;
        String str;
        try {
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            if (f3293b) {
                CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
                if (csRuntimeModule != null) {
                    C2561M4 runTime = csRuntimeModule.getRunTime();
                    Intrinsics.checkNotNullExpressionValue(runTime, "runtimeModule.runTime");
                    m1241a(consumer, runTime);
                } else {
                    f3296e.m833p("Contentsquare SDK: Unable to call the public API, make sure you are not opted out of the Contentsquare tracker and SDK was correctly initialized.");
                }
            } else {
                if (!z && !f3294c) {
                    logger = f3296e;
                    str = "Contentsquare call ignored because SDK is not initialized yet.";
                } else if (!f3295d.offer(consumer)) {
                    logger = f3296e;
                    str = "Contentsquare SDK: Initialization pending, API command buffer is full.";
                }
                logger.m833p(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
