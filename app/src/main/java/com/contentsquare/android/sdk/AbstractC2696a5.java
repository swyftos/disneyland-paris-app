package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC2727d6;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.a5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2696a5<CONTEXT extends AbstractC2727d6> {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final MutableStateFlow<AbstractC2686Z4> f2369a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final InterfaceC2903v2 f2370b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public String f2371c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public Bitmap f2372d;

    public AbstractC2696a5(@NotNull MutableStateFlow<AbstractC2686Z4> snapshotStateFlow, @NotNull InterfaceC2903v2 glassPane) {
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        this.f2369a = snapshotStateFlow;
        this.f2370b = glassPane;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Logger mo906a();

    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1086a(@NotNull CONTEXT context, @NotNull Continuation<? super Unit> continuation) {
        if (mo909b(context)) {
            this.f2369a.tryEmit(AbstractC2686Z4.c.f2336a);
        }
        if (m1090d() == null) {
            mo906a().m829e("Failed to capture screen, no screenview");
            AbstractC2686Z4.b.d reason = AbstractC2686Z4.b.d.f2333a;
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.f2369a.tryEmit(new AbstractC2686Z4.a(reason, m1089c()));
        } else {
            if (m1088b() != null) {
                mo907a(context);
                if (mo909b(context)) {
                    mo910e();
                }
                Object objMo908b = mo908b(context, continuation);
                return objMo908b == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo908b : Unit.INSTANCE;
            }
            mo906a().m829e("Failed to capture screen, decorView is null");
            AbstractC2686Z4.b.e reason2 = AbstractC2686Z4.b.e.f2334a;
            Intrinsics.checkNotNullParameter(reason2, "reason");
            this.f2369a.tryEmit(new AbstractC2686Z4.a(reason2, m1089c()));
        }
        return Unit.INSTANCE;
    }

    @VisibleForTesting(otherwise = 4)
    /* JADX INFO: renamed from: a */
    public abstract void mo907a(@NotNull CONTEXT context);

    @Nullable
    /* JADX INFO: renamed from: b */
    public final ViewGroup m1088b() {
        return ((C2793k2) this.f2370b).f2813h.get();
    }

    @VisibleForTesting(otherwise = 4)
    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract Object mo908b(@NotNull CONTEXT context, @NotNull Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo909b(@NotNull CONTEXT context);

    @NotNull
    /* JADX INFO: renamed from: c */
    public final String m1089c() {
        String str = ((C2793k2) this.f2370b).f2810e;
        return str == null ? "" : str;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public final String m1090d() {
        return ((C2793k2) this.f2370b).f2809d;
    }

    @VisibleForTesting(otherwise = 4)
    /* JADX INFO: renamed from: e */
    public abstract void mo910e();

    /* JADX INFO: renamed from: a */
    public final void m1087a(@NotNull Throwable exception) {
        AbstractC2686Z4.b reason;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof OutOfMemoryError) {
            reason = AbstractC2686Z4.b.f.f2335a;
        } else {
            Intrinsics.checkNotNullParameter(exception, "<this>");
            String message = exception.getMessage();
            reason = (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) "hardware bitmap", false, 2, (Object) null)) ? AbstractC2686Z4.b.e.f2334a : AbstractC2686Z4.b.a.f2330a;
        }
        mo906a().m830e(exception, "Failed to capture screen: " + reason);
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.f2369a.tryEmit(new AbstractC2686Z4.a(reason, m1089c()));
    }
}
