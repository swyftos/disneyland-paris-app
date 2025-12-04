package com.contentsquare.android.sdk;

import android.app.Application;
import android.view.View;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.sdk.C0693h2;
import com.contentsquare.android.sdk.InterfaceC0703i2;
import com.contentsquare.android.sdk.x8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class Y1 extends X1 {

    @NotNull
    public final F7 q;

    @Nullable
    public x8<View> r;

    @NotNull
    public final C0713j2 s;

    @NotNull
    public final Z6 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y1(@NotNull Application application, @NotNull F7 touchTargetDetector, @NotNull SystemInstantiable systemInstantiable, @NotNull InterfaceC0665e4<ComposeInterface> composeInterfaceProvider) {
        super(application, systemInstantiable);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.q = touchTargetDetector;
        this.s = new C0713j2(new C0800s0(composeInterfaceProvider), new C0704i3());
        this.t = new Z6();
    }

    @Override // com.contentsquare.android.sdk.X1
    public final void a() {
        super.a();
        x8<View> x8Var = this.r;
        if (x8Var != null) {
            x8.a<View> aVar = x8Var.a;
            while (aVar != null) {
                x8.a<View> aVar2 = aVar.b;
                aVar.a.clear();
                aVar.c = null;
                aVar.b = null;
                aVar = aVar2;
            }
            x8Var.a = null;
            x8Var.b = null;
        }
    }

    @Override // com.contentsquare.android.sdk.X1
    public final void a(@NotNull C0673f2 gestureResult) {
        Y6 c0714j3;
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
        x8<View> x8Var = this.r;
        if (x8Var != null) {
            gestureResult.k = x8Var;
            C0693h2 gestureTarget = this.s.a(new InterfaceC0703i2.a(x8Var, this.e, this.f));
            if (gestureTarget != null) {
                this.t.getClass();
                Intrinsics.checkNotNullParameter(gestureTarget, "gestureTarget");
                C0693h2.b bVar = gestureTarget.b;
                if (bVar instanceof C0790r0) {
                    c0714j3 = new C0818t8(gestureTarget.a, ((C0790r0) bVar).a);
                } else {
                    c0714j3 = new C0714j3(gestureTarget.a);
                }
                gestureResult.c = c0714j3;
                gestureResult.a = gestureTarget.c;
            }
        }
    }
}
