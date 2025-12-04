package com.contentsquare.android.sdk;

import android.view.View;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.h2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0693h2 {

    @NotNull
    public static final a d = new a();

    @NotNull
    public final View a;

    @NotNull
    public final b b;
    public final boolean c;

    /* renamed from: com.contentsquare.android.sdk.h2$a */
    public static final class a implements b {
    }

    /* renamed from: com.contentsquare.android.sdk.h2$b */
    public interface b {
    }

    public C0693h2(@NotNull View view, @NotNull b payload, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.a = view;
        this.b = payload;
        this.c = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0693h2)) {
            return false;
        }
        C0693h2 c0693h2 = (C0693h2) obj;
        return Intrinsics.areEqual(this.a, c0693h2.a) && Intrinsics.areEqual(this.b, c0693h2.b) && this.c == c0693h2.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @NotNull
    public final String toString() {
        return "GestureTarget(view=" + this.a + ", payload=" + this.b + ", isUnresponsive=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
