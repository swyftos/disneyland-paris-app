package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.sdk.C0693h2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.r0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0790r0 implements C0693h2.b {

    @NotNull
    public final ViewNode a;

    public C0790r0(@NotNull ViewNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.a = node;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0790r0) && Intrinsics.areEqual(this.a, ((C0790r0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public final String toString() {
        return "ComposeGestureTargetPayload(node=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
