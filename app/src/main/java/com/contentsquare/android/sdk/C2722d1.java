package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.d1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2722d1 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final AbstractC2898u7 f2486a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final AbstractC2898u7 f2487b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final AbstractC2725d4 f2488c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final C2801l0 f2489d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final C2801l0 f2490e;

    public C2722d1() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2722d1)) {
            return false;
        }
        C2722d1 c2722d1 = (C2722d1) obj;
        return Intrinsics.areEqual(this.f2486a, c2722d1.f2486a) && Intrinsics.areEqual(this.f2487b, c2722d1.f2487b) && Intrinsics.areEqual(this.f2488c, c2722d1.f2488c) && Intrinsics.areEqual(this.f2489d, c2722d1.f2489d) && Intrinsics.areEqual(this.f2490e, c2722d1.f2490e);
    }

    public final int hashCode() {
        AbstractC2898u7 abstractC2898u7 = this.f2486a;
        int iHashCode = (abstractC2898u7 == null ? 0 : abstractC2898u7.hashCode()) * 31;
        AbstractC2898u7 abstractC2898u8 = this.f2487b;
        int iHashCode2 = (iHashCode + (abstractC2898u8 == null ? 0 : abstractC2898u8.hashCode())) * 31;
        AbstractC2725d4 abstractC2725d4 = this.f2488c;
        int iHashCode3 = (iHashCode2 + (abstractC2725d4 == null ? 0 : abstractC2725d4.hashCode())) * 31;
        C2801l0 c2801l0 = this.f2489d;
        int iHashCode4 = (iHashCode3 + (c2801l0 == null ? 0 : c2801l0.hashCode())) * 31;
        C2801l0 c2801l1 = this.f2490e;
        return iHashCode4 + (c2801l1 != null ? c2801l1.hashCode() : 0);
    }

    @NotNull
    public final String toString() {
        return "DialogState(titleText=" + this.f2486a + ", summaryText=" + this.f2487b + ", progressType=" + this.f2488c + ", primaryButton=" + this.f2489d + ", secondaryButton=" + this.f2490e + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public C2722d1(AbstractC2898u7.a aVar, AbstractC2898u7 abstractC2898u7, AbstractC2725d4 abstractC2725d4, C2801l0 c2801l0, C2801l0 c2801l1, int i) {
        aVar = (i & 1) != 0 ? null : aVar;
        abstractC2898u7 = (i & 2) != 0 ? null : abstractC2898u7;
        abstractC2725d4 = (i & 4) != 0 ? null : abstractC2725d4;
        c2801l0 = (i & 8) != 0 ? null : c2801l0;
        c2801l1 = (i & 16) != 0 ? null : c2801l1;
        this.f2486a = aVar;
        this.f2487b = abstractC2898u7;
        this.f2488c = abstractC2725d4;
        this.f2489d = c2801l0;
        this.f2490e = c2801l1;
    }
}
