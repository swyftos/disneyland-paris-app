package com.contentsquare.android.sdk;

import androidx.annotation.StringRes;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.l0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0731l0 {
    public final int a;

    @NotNull
    public final Function0<Unit> b;

    public C0731l0(@StringRes int i, @NotNull Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.a = i;
        this.b = onClick;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0731l0)) {
            return false;
        }
        C0731l0 c0731l0 = (C0731l0) obj;
        return this.a == c0731l0.a && Intrinsics.areEqual(this.b, c0731l0.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    @NotNull
    public final String toString() {
        return "ButtonConfig(stringRes=" + this.a + ", onClick=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
