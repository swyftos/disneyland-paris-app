package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ComposeScroller;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.w0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0839w0 extends AbstractC0637b6 {

    /* renamed from: com.contentsquare.android.sdk.w0$a */
    public static final class a extends AbstractC0839w0 {

        @NotNull
        public final ComposeScroller a;

        public a(@NotNull ComposeScroller scroller) {
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            this.a = scroller;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongVertical(scroller=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
