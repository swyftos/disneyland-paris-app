package com.contentsquare.android.sdk;

import android.graphics.Rect;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class J {

    @NotNull
    public final Rect a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;

    public J(@NotNull Rect scrollContainerRect, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
        this.a = scrollContainerRect;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J)) {
            return false;
        }
        J j = (J) obj;
        return Intrinsics.areEqual(this.a, j.a) && this.b == j.b && this.c == j.c && this.d == j.d && this.e == j.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = (Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31)) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z2 = this.e;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    @NotNull
    public final String toString() {
        return "AppendPageContext(scrollContainerRect=" + this.a + ", initialOffset=" + this.b + ", numberOfSnapshots=" + this.c + ", isFirstSnapshot=" + this.d + ", isLastSnapshot=" + this.e + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
