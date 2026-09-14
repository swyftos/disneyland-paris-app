package com.contentsquare.android.sdk;

import android.text.SpannableString;
import androidx.annotation.StringRes;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u7 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2898u7 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.u7$a */
    public static final class a extends AbstractC2898u7 {

        /* JADX INFO: renamed from: a */
        public final int f3158a;

        public a(@StringRes int i) {
            this.f3158a = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f3158a == ((a) obj).f3158a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f3158a);
        }

        @NotNull
        public final String toString() {
            return "Res(stringRes=" + this.f3158a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.u7$b */
    public static final class b extends AbstractC2898u7 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final CharSequence f3159a;

        public b(@NotNull SpannableString charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            this.f3159a = charSequence;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f3159a, ((b) obj).f3159a);
        }

        public final int hashCode() {
            return this.f3159a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Text(charSequence=" + ((Object) this.f3159a) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
