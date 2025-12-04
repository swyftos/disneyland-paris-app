package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.sdk.AbstractC0827u7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.d1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0652d1 {

    @Nullable
    public final AbstractC0827u7 a;

    @Nullable
    public final AbstractC0827u7 b;

    @Nullable
    public final AbstractC0655d4 c;

    @Nullable
    public final C0731l0 d;

    @Nullable
    public final C0731l0 e;

    public C0652d1() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0652d1)) {
            return false;
        }
        C0652d1 c0652d1 = (C0652d1) obj;
        return Intrinsics.areEqual(this.a, c0652d1.a) && Intrinsics.areEqual(this.b, c0652d1.b) && Intrinsics.areEqual(this.c, c0652d1.c) && Intrinsics.areEqual(this.d, c0652d1.d) && Intrinsics.areEqual(this.e, c0652d1.e);
    }

    public final int hashCode() {
        AbstractC0827u7 abstractC0827u7 = this.a;
        int iHashCode = (abstractC0827u7 == null ? 0 : abstractC0827u7.hashCode()) * 31;
        AbstractC0827u7 abstractC0827u72 = this.b;
        int iHashCode2 = (iHashCode + (abstractC0827u72 == null ? 0 : abstractC0827u72.hashCode())) * 31;
        AbstractC0655d4 abstractC0655d4 = this.c;
        int iHashCode3 = (iHashCode2 + (abstractC0655d4 == null ? 0 : abstractC0655d4.hashCode())) * 31;
        C0731l0 c0731l0 = this.d;
        int iHashCode4 = (iHashCode3 + (c0731l0 == null ? 0 : c0731l0.hashCode())) * 31;
        C0731l0 c0731l02 = this.e;
        return iHashCode4 + (c0731l02 != null ? c0731l02.hashCode() : 0);
    }

    @NotNull
    public final String toString() {
        return "DialogState(titleText=" + this.a + ", summaryText=" + this.b + ", progressType=" + this.c + ", primaryButton=" + this.d + ", secondaryButton=" + this.e + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public C0652d1(AbstractC0827u7.a aVar, AbstractC0827u7 abstractC0827u7, AbstractC0655d4 abstractC0655d4, C0731l0 c0731l0, C0731l0 c0731l02, int i) {
        aVar = (i & 1) != 0 ? null : aVar;
        abstractC0827u7 = (i & 2) != 0 ? null : abstractC0827u7;
        abstractC0655d4 = (i & 4) != 0 ? null : abstractC0655d4;
        c0731l0 = (i & 8) != 0 ? null : c0731l0;
        c0731l02 = (i & 16) != 0 ? null : c0731l02;
        this.a = aVar;
        this.b = abstractC0827u7;
        this.c = abstractC0655d4;
        this.d = c0731l0;
        this.e = c0731l02;
    }
}
