package com.contentsquare.android.sdk;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0844w5;
import com.contentsquare.android.sdk.K0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSnapshotConfigCreator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotConfigCreator.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/SnapshotConfigCreator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,211:1\n1#2:212\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.c6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0647c6 {

    @NotNull
    public final Function0<ComposeInterface> a;

    @NotNull
    public final C0683g2 b;

    @NotNull
    public final F7 c;

    @NotNull
    public final Y0 d;

    @NotNull
    public final Logger e;

    public C0647c6(K0.b composeInterfaceProvider, C0683g2 gestureStorage, F7 touchTargetDetector) {
        Y0 classNameResolver = new Y0();
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        Intrinsics.checkNotNullParameter(gestureStorage, "gestureStorage");
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        Intrinsics.checkNotNullParameter(classNameResolver, "classNameResolver");
        this.a = composeInterfaceProvider;
        this.b = gestureStorage;
        this.c = touchTargetDetector;
        this.d = classNameResolver;
        this.e = new Logger("SnapshotConfigCreator");
    }

    @VisibleForTesting
    @Nullable
    public static AbstractC0844w5 a(@NotNull View scrollContainer, boolean z) {
        Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
        boolean z2 = scrollContainer.canScrollVertically(-1) || scrollContainer.canScrollVertically(1);
        boolean z3 = scrollContainer.canScrollHorizontally(-1) || scrollContainer.canScrollHorizontally(1);
        if (z2 && z3 && !z) {
            return new AbstractC0844w5.c(scrollContainer);
        }
        if (z2) {
            return new AbstractC0844w5.b(scrollContainer);
        }
        if (!z3 || z) {
            return null;
        }
        return new AbstractC0844w5.a(scrollContainer);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100 A[EDGE_INSN: B:93:0x0100->B:53:0x0100 BREAK  A[LOOP:1: B:20:0x008c->B:97:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[LOOP:1: B:20:0x008c->B:97:?, LOOP_END, SYNTHETIC] */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.contentsquare.android.sdk.AbstractC0637b6 a(@org.jetbrains.annotations.NotNull android.view.ViewGroup r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0647c6.a(android.view.ViewGroup, boolean):com.contentsquare.android.sdk.b6");
    }
}
