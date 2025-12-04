package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class N5 {
    public final long a;
    public final long b;

    @Nullable
    public final int c;

    public N5(long j, long j2, @Nullable int i) {
        this.a = j;
        this.b = j2;
        this.c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N5)) {
            return false;
        }
        N5 n5 = (N5) obj;
        return this.a == n5.a && this.b == n5.b && this.c == n5.c;
    }

    public final int hashCode() {
        int iHashCode = (Long.hashCode(this.b) + (Long.hashCode(this.a) * 31)) * 31;
        int i = this.c;
        return iHashCode + (i == 0 ? 0 : z8.a(i));
    }

    @NotNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionState(sessionId=");
        sb.append(this.a);
        sb.append(", screenNumber=");
        sb.append(this.b);
        sb.append(", changeReason=");
        sb.append(this.c != 1 ? "null" : "SCREEN_NUMBER_CHANGED");
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }
}
