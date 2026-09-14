package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.N5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2572N5 {

    /* JADX INFO: renamed from: a */
    public final long f1887a;

    /* JADX INFO: renamed from: b */
    public final long f1888b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final int f1889c;

    public C2572N5(long j, long j2, @Nullable int i) {
        this.f1887a = j;
        this.f1888b = j2;
        this.f1889c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2572N5)) {
            return false;
        }
        C2572N5 c2572n5 = (C2572N5) obj;
        return this.f1887a == c2572n5.f1887a && this.f1888b == c2572n5.f1888b && this.f1889c == c2572n5.f1889c;
    }

    public final int hashCode() {
        int iHashCode = (Long.hashCode(this.f1888b) + (Long.hashCode(this.f1887a) * 31)) * 31;
        int i = this.f1889c;
        return iHashCode + (i == 0 ? 0 : C2949z8.m1254a(i));
    }

    @NotNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionState(sessionId=");
        sb.append(this.f1887a);
        sb.append(", screenNumber=");
        sb.append(this.f1888b);
        sb.append(", changeReason=");
        sb.append(this.f1889c != 1 ? "null" : "SCREEN_NUMBER_CHANGED");
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }
}
