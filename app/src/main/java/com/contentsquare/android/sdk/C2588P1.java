package com.contentsquare.android.sdk;

import com.contentsquare.android.api.bridge.xpf.BridgeManager;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.P1 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nFilteredViewEventForFlutterProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilteredViewEventForFlutterProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/FilteredViewEventForFlutterProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n800#2,11:38\n*S KotlinDebug\n*F\n+ 1 FilteredViewEventForFlutterProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/FilteredViewEventForFlutterProvider\n*L\n28#1:38,11\n*E\n"})
public final class C2588P1 implements InterfaceC2859q8, InterfaceC2612R6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2734e3 f1954a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final BridgeManager f1955b;

    public C2588P1(BridgeManager bridgeManager) {
        C2734e3 mutationDetector = new C2734e3();
        Intrinsics.checkNotNullParameter(mutationDetector, "mutationDetector");
        Intrinsics.checkNotNullParameter(bridgeManager, "bridgeManager");
        this.f1954a = mutationDetector;
        this.f1955b = bridgeManager;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2859q8
    @NotNull
    /* JADX INFO: renamed from: a */
    public final ArrayList mo1000a(@NotNull ViewLight viewLight, long j) {
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        boolean zIsSessionReplayEnabled = this.f1955b.isSessionReplayEnabled();
        C2734e3 c2734e3 = this.f1954a;
        if (!zIsSessionReplayEnabled) {
            return c2734e3.m1121a(viewLight, j);
        }
        ArrayList arrayListM1121a = c2734e3.m1121a(viewLight, j);
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListM1121a) {
            if (obj instanceof C2764h3) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2612R6
    /* JADX INFO: renamed from: a */
    public final void mo888a() {
        C2734e3 c2734e3 = this.f1954a;
        synchronized (c2734e3) {
            try {
                ViewLight viewLight = c2734e3.f2577a;
                if (viewLight != null) {
                    ViewLight.INSTANCE.recycleRecursive(viewLight);
                }
                c2734e3.f2577a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
