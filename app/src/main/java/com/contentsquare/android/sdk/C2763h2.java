package com.contentsquare.android.sdk;

import android.view.View;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.h2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2763h2 {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final a f2684d = new a();

    /* JADX INFO: renamed from: a */
    @NotNull
    public final View f2685a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final b f2686b;

    /* JADX INFO: renamed from: c */
    public final boolean f2687c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h2$a */
    public static final class a implements b {
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h2$b */
    public interface b {
    }

    public C2763h2(@NotNull View view, @NotNull b payload, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.f2685a = view;
        this.f2686b = payload;
        this.f2687c = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2763h2)) {
            return false;
        }
        C2763h2 c2763h2 = (C2763h2) obj;
        return Intrinsics.areEqual(this.f2685a, c2763h2.f2685a) && Intrinsics.areEqual(this.f2686b, c2763h2.f2686b) && this.f2687c == c2763h2.f2687c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int iHashCode = (this.f2686b.hashCode() + (this.f2685a.hashCode() * 31)) * 31;
        boolean z = this.f2687c;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        return iHashCode + r2;
    }

    @NotNull
    public final String toString() {
        return "GestureTarget(view=" + this.f2685a + ", payload=" + this.f2686b + ", isUnresponsive=" + this.f2687c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
