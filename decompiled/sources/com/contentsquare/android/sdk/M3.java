package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.ULong;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class M3 {
    public final long a;
    public final long b;
    public final int c;

    public M3(long j, long j2, int i) {
        this.a = j;
        this.b = j2;
        this.c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M3)) {
            return false;
        }
        M3 m3 = (M3) obj;
        return this.a == m3.a && this.b == m3.b && this.c == m3.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + ((ULong.m3031hashCodeimpl(this.b) + (ULong.m3031hashCodeimpl(this.a) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "PerceptualHash(alphaHash=" + ((Object) ULong.m3032toStringimpl(this.a)) + ", grayscaleHash=" + ((Object) ULong.m3032toStringimpl(this.b)) + ", averageColor=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
