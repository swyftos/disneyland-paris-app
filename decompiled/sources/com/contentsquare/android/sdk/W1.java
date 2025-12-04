package com.contentsquare.android.sdk;

import android.app.Application;
import androidx.annotation.NonNull;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.C0721k0;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class W1 {
    public static final Logger f = new Logger("GdprControllerImpl");

    @NonNull
    public final S6 a;

    @NonNull
    public final K7 b;

    @NonNull
    public final I1 c;

    @NonNull
    public final L2 d;

    @NonNull
    public final PreferencesStore e;

    public W1(@NonNull Application application, @NonNull S6 s6, @NonNull K7 k7, @NonNull I1 i1, @NonNull L2 l2) {
        this.a = s6;
        this.b = k7;
        this.c = i1;
        this.d = l2;
        this.e = CoreModule.safeInstance(application).getPreferencesStore();
    }

    public final void a() {
        S6 s6 = this.a;
        s6.a.deleteRecursive(new File(s6.b));
        f.i("Wiped storage.");
    }

    public final void b() {
        Logger logger = f;
        logger.d("GdprController, clearAndFlushAll");
        this.e.removeGdprKeys();
        this.c.a.remove(PreferencesKey.SCHEDULED_APP_HIDE_EVENT, PreferencesKey.LAST_EVENT_TIMESTAMP, PreferencesKey.IS_HIDE_EVENT_PENDING);
        logger.i("Wiped preferences.");
        L2 l2 = this.d;
        C0721k0.c onSuccess = new C0721k0.c() { // from class: com.contentsquare.android.sdk.W1$$ExternalSyntheticLambda0
            @Override // com.contentsquare.android.sdk.C0721k0.c
            public final void a() {
                this.f$0.a();
            }
        };
        C0721k0.b onError = new C0721k0.b() { // from class: com.contentsquare.android.sdk.W1$$ExternalSyntheticLambda1
            @Override // com.contentsquare.android.sdk.C0721k0.b
            public final void a() {
                this.f$0.a();
            }
        };
        l2.getClass();
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        G1 g1 = l2.e;
        g1.getClass();
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        C0721k0 c0721k0 = g1.j;
        if (c0721k0 != null) {
            g1.a.a();
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            Intrinsics.checkNotNullExpressionValue(c0721k0.a.submit(new C0721k0.a(c0721k0, onSuccess, onError)), "threadExecutor.submit(Di…able(onSuccess, onError))");
        }
    }
}
