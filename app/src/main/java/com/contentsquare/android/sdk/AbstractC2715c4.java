package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c4 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2715c4 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c4$a */
    public static final class a extends AbstractC2715c4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final a f2444a = new a();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c4$b */
    public static final class b extends AbstractC2715c4 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final List<C2499G2> f2445a;

        public b(@NotNull List<C2499G2> children) {
            Intrinsics.checkNotNullParameter(children, "children");
            this.f2445a = children;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f2445a, ((b) obj).f2445a);
        }

        public final int hashCode() {
            return this.f2445a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "ScreenGraphNodes(children=" + this.f2445a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
