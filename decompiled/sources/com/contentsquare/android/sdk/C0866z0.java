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

/* renamed from: com.contentsquare.android.sdk.z0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0866z0 {
    public static boolean b;
    public static boolean c;

    @NotNull
    public static final C0866z0 a = new C0866z0();

    @NotNull
    public static final LinkedBlockingQueue d = new LinkedBlockingQueue(200);

    @NotNull
    public static final Logger e = new Logger("ContentsquareConsumerExecutor");

    public static void a(final Consumer consumer, final M4 m4) {
        if (C0846w7.a()) {
            consumer.accept(m4);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.contentsquare.android.sdk.z0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0866z0.b(consumer, m4);
                }
            });
        }
    }

    public static final void b(Consumer consumer, M4 runtime) {
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(runtime, "$runtime");
        consumer.accept(runtime);
    }

    @JvmOverloads
    public final void a(@NotNull Consumer<M4> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        a(false, consumer);
    }

    @JvmOverloads
    public final synchronized void a(boolean z, @NotNull Consumer<M4> consumer) {
        Logger logger;
        String str;
        try {
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            if (b) {
                CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
                if (csRuntimeModule != null) {
                    M4 runTime = csRuntimeModule.getRunTime();
                    Intrinsics.checkNotNullExpressionValue(runTime, "runtimeModule.runTime");
                    a(consumer, runTime);
                } else {
                    e.p("Contentsquare SDK: Unable to call the public API, make sure you are not opted out of the Contentsquare tracker and SDK was correctly initialized.");
                }
            } else {
                if (!z && !c) {
                    logger = e;
                    str = "Contentsquare call ignored because SDK is not initialized yet.";
                } else if (!d.offer(consumer)) {
                    logger = e;
                    str = "Contentsquare SDK: Initialization pending, API command buffer is full.";
                }
                logger.p(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
