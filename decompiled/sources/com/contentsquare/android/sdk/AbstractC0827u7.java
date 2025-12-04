package com.contentsquare.android.sdk;

import android.text.SpannableString;
import androidx.annotation.StringRes;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.u7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0827u7 {

    /* renamed from: com.contentsquare.android.sdk.u7$a */
    public static final class a extends AbstractC0827u7 {
        public final int a;

        public a(@StringRes int i) {
            this.a = i;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.a);
        }

        @NotNull
        public final String toString() {
            return "Res(stringRes=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.u7$b */
    public static final class b extends AbstractC0827u7 {

        @NotNull
        public final CharSequence a;

        public b(@NotNull SpannableString charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            this.a = charSequence;
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
            return "Text(charSequence=" + ((Object) this.a) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
