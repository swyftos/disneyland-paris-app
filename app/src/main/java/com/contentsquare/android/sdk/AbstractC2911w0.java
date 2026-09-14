package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ComposeScroller;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.w0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2911w0 extends AbstractC2707b6 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.w0$a */
    public static final class a extends AbstractC2911w0 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final ComposeScroller f3199a;

        public a(@NotNull ComposeScroller scroller) {
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            this.f3199a = scroller;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f3199a, ((a) obj).f3199a);
        }

        public final int hashCode() {
            return this.f3199a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "LongVertical(scroller=" + this.f3199a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
