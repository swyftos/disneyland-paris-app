package com.contentsquare.android.sdk;

import android.graphics.Rect;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J */
/* JADX INFO: loaded from: classes2.dex */
public final class C2526J {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Rect f1714a;

    /* JADX INFO: renamed from: b */
    public final int f1715b;

    /* JADX INFO: renamed from: c */
    public final int f1716c;

    /* JADX INFO: renamed from: d */
    public final boolean f1717d;

    /* JADX INFO: renamed from: e */
    public final boolean f1718e;

    public C2526J(@NotNull Rect scrollContainerRect, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
        this.f1714a = scrollContainerRect;
        this.f1715b = i;
        this.f1716c = i2;
        this.f1717d = z;
        this.f1718e = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2526J)) {
            return false;
        }
        C2526J c2526j = (C2526J) obj;
        return Intrinsics.areEqual(this.f1714a, c2526j.f1714a) && this.f1715b == c2526j.f1715b && this.f1716c == c2526j.f1716c && this.f1717d == c2526j.f1717d && this.f1718e == c2526j.f1718e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int iHashCode = (Integer.hashCode(this.f1716c) + ((Integer.hashCode(this.f1715b) + (this.f1714a.hashCode() * 31)) * 31)) * 31;
        boolean z = this.f1717d;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.f1718e;
        return i + (z2 ? 1 : z2);
    }

    @NotNull
    public final String toString() {
        return "AppendPageContext(scrollContainerRect=" + this.f1714a + ", initialOffset=" + this.f1715b + ", numberOfSnapshots=" + this.f1716c + ", isFirstSnapshot=" + this.f1717d + ", isLastSnapshot=" + this.f1718e + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
