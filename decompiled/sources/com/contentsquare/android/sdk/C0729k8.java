package com.contentsquare.android.sdk;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nViewEventProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/ViewEventProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1855#2,2:37\n*S KotlinDebug\n*F\n+ 1 ViewEventProvider.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/eventsproviders/ViewEventProvider\n*L\n34#1:37,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.k8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0729k8 implements InterfaceC0789q8, R6 {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public final C0664e3 b;

    public C0729k8(DeviceInfo deviceInfo) {
        C0664e3 mutationDetector = new C0664e3();
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(mutationDetector, "mutationDetector");
        this.a = deviceInfo;
        this.b = mutationDetector;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0789q8
    @NotNull
    public final ArrayList a(@NotNull ViewLight viewLight, long j) {
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        a(viewLight);
        return this.b.a(viewLight, j);
    }

    @VisibleForTesting
    public final void a(@NotNull ViewLight viewLight) {
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        viewLight.setPosX(this.a.pixelsToDp(viewLight.getPosX()));
        viewLight.setPosY(this.a.pixelsToDp(viewLight.getPosY()));
        viewLight.setWidth(this.a.pixelsToDp(viewLight.getWidth()));
        viewLight.setHeight(this.a.pixelsToDp(viewLight.getHeight()));
        Iterator<T> it = viewLight.getChildren().iterator();
        while (it.hasNext()) {
            a((ViewLight) it.next());
        }
    }

    @Override // com.contentsquare.android.sdk.R6
    public final void a() {
        C0664e3 c0664e3 = this.b;
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
