package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.Z4;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.a5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0626a5<CONTEXT extends AbstractC0657d6> {

    @NotNull
    public final MutableStateFlow<Z4> a;

    @NotNull
    public final InterfaceC0832v2 b;

    @Nullable
    public String c;

    @Nullable
    public Bitmap d;

    public AbstractC0626a5(@NotNull MutableStateFlow<Z4> snapshotStateFlow, @NotNull InterfaceC0832v2 glassPane) {
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        this.a = snapshotStateFlow;
        this.b = glassPane;
    }

    @NotNull
    public abstract Logger a();

    @Nullable
    public final Object a(@NotNull CONTEXT context, @NotNull Continuation<? super Unit> continuation) {
        if (b(context)) {
            this.a.tryEmit(Z4.c.a);
        }
        if (d() == null) {
            a().e("Failed to capture screen, no screenview");
            Z4.b.d reason = Z4.b.d.a;
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.a.tryEmit(new Z4.a(reason, c()));
        } else {
            if (b() != null) {
                a((AbstractC0626a5<CONTEXT>) context);
                if (b(context)) {
                    e();
                }
                Object objB = b(context, continuation);
                return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
            }
            a().e("Failed to capture screen, decorView is null");
            Z4.b.e reason2 = Z4.b.e.a;
            Intrinsics.checkNotNullParameter(reason2, "reason");
            this.a.tryEmit(new Z4.a(reason2, c()));
        }
        return Unit.INSTANCE;
    }

    @VisibleForTesting(otherwise = 4)
    public abstract void a(@NotNull CONTEXT context);

    @Nullable
    public final ViewGroup b() {
        return ((C0723k2) this.b).h.get();
    }

    @VisibleForTesting(otherwise = 4)
    @Nullable
    public abstract Object b(@NotNull CONTEXT context, @NotNull Continuation<? super Unit> continuation);

    public abstract boolean b(@NotNull CONTEXT context);

    @NotNull
    public final String c() {
        String str = ((C0723k2) this.b).e;
        return str == null ? "" : str;
    }

    @Nullable
    public final String d() {
        return ((C0723k2) this.b).d;
    }

    @VisibleForTesting(otherwise = 4)
    public abstract void e();

    public final void a(@NotNull Throwable exception) {
        Z4.b reason;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof OutOfMemoryError) {
            reason = Z4.b.f.a;
        } else {
            Intrinsics.checkNotNullParameter(exception, "<this>");
            String message = exception.getMessage();
            reason = (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) "hardware bitmap", false, 2, (Object) null)) ? Z4.b.e.a : Z4.b.a.a;
        }
        a().e(exception, "Failed to capture screen: " + reason);
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.a.tryEmit(new Z4.a(reason, c()));
    }
}
