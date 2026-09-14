package com.contentsquare.android.sdk;

import android.app.Application;
import android.view.View;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Y1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2674Y1 extends C2665X1 {

    /* JADX INFO: renamed from: q */
    @NotNull
    public final C2494F7 f2291q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public C2929x8<View> f2292r;

    /* JADX INFO: renamed from: s */
    @NotNull
    public final C2783j2 f2293s;

    /* JADX INFO: renamed from: t */
    @NotNull
    public final C2688Z6 f2294t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2674Y1(@NotNull Application application, @NotNull C2494F7 touchTargetDetector, @NotNull SystemInstantiable systemInstantiable, @NotNull InterfaceC2735e4<ComposeInterface> composeInterfaceProvider) {
        super(application, systemInstantiable);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.f2291q = touchTargetDetector;
        this.f2293s = new C2783j2(new C2871s0(composeInterfaceProvider), new C2774i3());
        this.f2294t = new C2688Z6();
    }

    @Override // com.contentsquare.android.sdk.C2665X1
    /* JADX INFO: renamed from: a */
    public final void mo1066a() {
        super.mo1066a();
        C2929x8<View> c2929x8 = this.f2292r;
        if (c2929x8 != null) {
            C2929x8.a aVar = c2929x8.f3247a;
            while (aVar != null) {
                C2929x8.a aVar2 = aVar.f3250b;
                aVar.f3249a.clear();
                aVar.f3251c = null;
                aVar.f3250b = null;
                aVar = aVar2;
            }
            c2929x8.f3247a = null;
            c2929x8.f3248b = null;
        }
    }

    @Override // com.contentsquare.android.sdk.C2665X1
    /* JADX INFO: renamed from: a */
    public final void mo1068a(@NotNull C2743f2 gestureResult) {
        InterfaceC2679Y6 c2784j3;
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
        Intrinsics.checkNotNullParameter(gestureResult, "gestureResult");
        C2929x8<View> c2929x8 = this.f2292r;
        if (c2929x8 != null) {
            gestureResult.f2610k = c2929x8;
            C2763h2 gestureTarget = this.f2293s.mo1155a(new InterfaceC2773i2.a(c2929x8, this.f2239e, this.f2240f));
            if (gestureTarget != null) {
                this.f2294t.getClass();
                Intrinsics.checkNotNullParameter(gestureTarget, "gestureTarget");
                C2763h2.b bVar = gestureTarget.f2686b;
                if (bVar instanceof C2861r0) {
                    c2784j3 = new C2889t8(gestureTarget.f2685a, ((C2861r0) bVar).f3056a);
                } else {
                    c2784j3 = new C2784j3(gestureTarget.f2685a);
                }
                gestureResult.f2602c = c2784j3;
                gestureResult.f2600a = gestureTarget.f2687c;
            }
        }
    }
}
