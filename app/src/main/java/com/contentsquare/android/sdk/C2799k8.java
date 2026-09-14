package com.contentsquare.android.sdk;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.k8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nViewEventProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/ViewEventProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1855#2,2:37\n*S KotlinDebug\n*F\n+ 1 ViewEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/ViewEventProvider\n*L\n34#1:37,2\n*E\n"})
public final class C2799k8 implements InterfaceC2859q8, InterfaceC2612R6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final DeviceInfo f2835a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2734e3 f2836b;

    public C2799k8(DeviceInfo deviceInfo) {
        C2734e3 mutationDetector = new C2734e3();
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(mutationDetector, "mutationDetector");
        this.f2835a = deviceInfo;
        this.f2836b = mutationDetector;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2859q8
    @NotNull
    /* JADX INFO: renamed from: a */
    public final ArrayList mo1000a(@NotNull ViewLight viewLight, long j) {
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        m1176a(viewLight);
        return this.f2836b.m1121a(viewLight, j);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public final void m1176a(@NotNull ViewLight viewLight) {
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        viewLight.setPosX(this.f2835a.pixelsToDp(viewLight.getPosX()));
        viewLight.setPosY(this.f2835a.pixelsToDp(viewLight.getPosY()));
        viewLight.setWidth(this.f2835a.pixelsToDp(viewLight.getWidth()));
        viewLight.setHeight(this.f2835a.pixelsToDp(viewLight.getHeight()));
        Iterator<T> it = viewLight.getChildren().iterator();
        while (it.hasNext()) {
            m1176a((ViewLight) it.next());
        }
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2612R6
    /* JADX INFO: renamed from: a */
    public final void mo888a() {
        C2734e3 c2734e3 = this.f2836b;
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
