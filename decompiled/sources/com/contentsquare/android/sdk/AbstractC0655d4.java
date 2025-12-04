package com.contentsquare.android.sdk;

import androidx.annotation.DrawableRes;
import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.d4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0655d4 {

    /* renamed from: com.contentsquare.android.sdk.d4$a */
    public static final class a extends AbstractC0655d4 {

        @NotNull
        public static final a a = new a();
    }

    /* renamed from: com.contentsquare.android.sdk.d4$b */
    public static final class b extends AbstractC0655d4 {
        public final int a;

        public b(@DrawableRes int i) {
            this.a = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.a);
        }

        @NotNull
        public final String toString() {
            return "Icon(iconRes=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.d4$c */
    public static final class c extends AbstractC0655d4 {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.a == ((c) obj).a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.a);
        }

        @NotNull
        public final String toString() {
            return "Linear(progress=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
