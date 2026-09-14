package com.contentsquare.android.sdk;

import androidx.annotation.DrawableRes;
import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.d4 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2725d4 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d4$a */
    public static final class a extends AbstractC2725d4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final a f2496a = new a();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d4$b */
    public static final class b extends AbstractC2725d4 {

        /* JADX INFO: renamed from: a */
        public final int f2497a;

        public b(@DrawableRes int i) {
            this.f2497a = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f2497a == ((b) obj).f2497a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f2497a);
        }

        @NotNull
        public final String toString() {
            return "Icon(iconRes=" + this.f2497a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d4$c */
    public static final class c extends AbstractC2725d4 {

        /* JADX INFO: renamed from: a */
        public final int f2498a;

        public c(int i) {
            this.f2498a = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.f2498a == ((c) obj).f2498a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f2498a);
        }

        @NotNull
        public final String toString() {
            return "Linear(progress=" + this.f2498a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
