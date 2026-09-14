package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.ULong;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.M3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2560M3 {

    /* JADX INFO: renamed from: a */
    public final long f1857a;

    /* JADX INFO: renamed from: b */
    public final long f1858b;

    /* JADX INFO: renamed from: c */
    public final int f1859c;

    public C2560M3(long j, long j2, int i) {
        this.f1857a = j;
        this.f1858b = j2;
        this.f1859c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2560M3)) {
            return false;
        }
        C2560M3 c2560m3 = (C2560M3) obj;
        return this.f1857a == c2560m3.f1857a && this.f1858b == c2560m3.f1858b && this.f1859c == c2560m3.f1859c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1859c) + ((ULong.m5340hashCodeimpl(this.f1858b) + (ULong.m5340hashCodeimpl(this.f1857a) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "PerceptualHash(alphaHash=" + ((Object) ULong.m5341toStringimpl(this.f1857a)) + ", grayscaleHash=" + ((Object) ULong.m5341toStringimpl(this.f1858b)) + ", averageColor=" + this.f1859c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
