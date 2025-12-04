package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.c4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0645c4 {

    /* renamed from: com.contentsquare.android.sdk.c4$a */
    public static final class a extends AbstractC0645c4 {

        @NotNull
        public static final a a = new a();
    }

    /* renamed from: com.contentsquare.android.sdk.c4$b */
    public static final class b extends AbstractC0645c4 {

        @NotNull
        public final List<G2> a;

        public b(@NotNull List<G2> children) {
            Intrinsics.checkNotNullParameter(children, "children");
            this.a = children;
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
            return "ScreenGraphNodes(children=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
