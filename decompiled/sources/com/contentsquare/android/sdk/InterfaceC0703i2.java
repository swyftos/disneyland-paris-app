package com.contentsquare.android.sdk;

import android.view.View;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.i2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0703i2 {

    /* renamed from: com.contentsquare.android.sdk.i2$a */
    public static final class a {

        @NotNull
        public final x8<View> a;
        public final int b;
        public final int c;

        public a(@NotNull x8<View> capturedTargetsList, int i, int i2) {
            Intrinsics.checkNotNullParameter(capturedTargetsList, "capturedTargetsList");
            this.a = capturedTargetsList;
            this.b = i;
            this.c = i2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
        }

        public final int hashCode() {
            return Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "Request(capturedTargetsList=" + this.a + ", touchX=" + this.b + ", touchY=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Nullable
    C0693h2 a(@NotNull a aVar);
}
