package com.contentsquare.android.sdk;

import androidx.annotation.StringRes;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2801l0 {

    /* JADX INFO: renamed from: a */
    public final int f2841a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Function0<Unit> f2842b;

    public C2801l0(@StringRes int i, @NotNull Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.f2841a = i;
        this.f2842b = onClick;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2801l0)) {
            return false;
        }
        C2801l0 c2801l0 = (C2801l0) obj;
        return this.f2841a == c2801l0.f2841a && Intrinsics.areEqual(this.f2842b, c2801l0.f2842b);
    }

    public final int hashCode() {
        return this.f2842b.hashCode() + (Integer.hashCode(this.f2841a) * 31);
    }

    @NotNull
    public final String toString() {
        return "ButtonConfig(stringRes=" + this.f2841a + ", onClick=" + this.f2842b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
