package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.b6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0637b6 {

    /* renamed from: com.contentsquare.android.sdk.b6$a */
    public static final class a extends AbstractC0637b6 {

        @NotNull
        public static final a a = new a();
    }

    /* renamed from: com.contentsquare.android.sdk.b6$b */
    public static final class b extends AbstractC0637b6 {

        @NotNull
        public final String a;

        public b() {
            Intrinsics.checkNotNullParameter("No decorView found, no view hierarchy", "errorMessage");
            this.a = "No decorView found, no view hierarchy";
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.a, ((b) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Unknown(errorMessage=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
