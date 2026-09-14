package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b6 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2707b6 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.b6$a */
    public static final class a extends AbstractC2707b6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final a f2415a = new a();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.b6$b */
    public static final class b extends AbstractC2707b6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2416a;

        public b() {
            Intrinsics.checkNotNullParameter("No decorView found, no view hierarchy", "errorMessage");
            this.f2416a = "No decorView found, no view hierarchy";
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f2416a, ((b) obj).f2416a);
        }

        public final int hashCode() {
            return this.f2416a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Unknown(errorMessage=" + this.f2416a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
