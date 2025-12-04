package com.contentsquare.android.sdk;

import com.contentsquare.android.api.bridge.xpf.BridgeManager;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFilteredViewEventForFlutterProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilteredViewEventForFlutterProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/FilteredViewEventForFlutterProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n800#2,11:38\n*S KotlinDebug\n*F\n+ 1 FilteredViewEventForFlutterProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/FilteredViewEventForFlutterProvider\n*L\n28#1:38,11\n*E\n"})
/* loaded from: classes2.dex */
public final class P1 implements InterfaceC0789q8, R6 {

    @NotNull
    public final C0664e3 a;

    @NotNull
    public final BridgeManager b;

    public P1(BridgeManager bridgeManager) {
        C0664e3 mutationDetector = new C0664e3();
        Intrinsics.checkNotNullParameter(mutationDetector, "mutationDetector");
        Intrinsics.checkNotNullParameter(bridgeManager, "bridgeManager");
        this.a = mutationDetector;
        this.b = bridgeManager;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0789q8
    @NotNull
    public final ArrayList a(@NotNull ViewLight viewLight, long j) {
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        boolean zIsSessionReplayEnabled = this.b.isSessionReplayEnabled();
        C0664e3 c0664e3 = this.a;
        if (!zIsSessionReplayEnabled) {
            return c0664e3.a(viewLight, j);
        }
        ArrayList arrayListA = c0664e3.a(viewLight, j);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof C0694h3) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.contentsquare.android.sdk.R6
    public final void a() {
        C0664e3 c0664e3 = this.a;
        synchronized (c0664e3) {
            try {
                ViewLight viewLight = c0664e3.a;
                if (viewLight != null) {
                    ViewLight.INSTANCE.recycleRecursive(viewLight);
                }
                c0664e3.a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
