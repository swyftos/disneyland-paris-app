package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ViewNode;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.r0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2861r0 implements C2763h2.b {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ViewNode f3056a;

    public C2861r0(@NotNull ViewNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.f3056a = node;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2861r0) && Intrinsics.areEqual(this.f3056a, ((C2861r0) obj).f3056a);
    }

    public final int hashCode() {
        return this.f3056a.hashCode();
    }

    @NotNull
    public final String toString() {
        return "ComposeGestureTargetPayload(node=" + this.f3056a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
