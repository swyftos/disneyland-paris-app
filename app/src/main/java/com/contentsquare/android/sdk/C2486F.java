package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.AppLifeCycleEvent;
import com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F */
/* JADX INFO: loaded from: classes2.dex */
public final class C2486F {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Function0<Long> f1565a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final LinkedHashMap f1566b;

    /* JADX INFO: renamed from: c */
    public long f1567c;

    public C2486F(int i) {
        C2476E currentTime = C2476E.f1531a;
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        this.f1565a = currentTime;
        this.f1566b = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: a */
    public final void m914a(AppLifeCycleEvent appLifeCycleEvent) {
        AppLifeCycleEvent appLifeCycleEvent2 = (AppLifeCycleEvent) this.f1566b.get(appLifeCycleEvent.f1267a);
        if (appLifeCycleEvent2 == null) {
            this.f1566b.put(appLifeCycleEvent.f1267a, appLifeCycleEvent);
            return;
        }
        LinkedHashMap linkedHashMap = this.f1566b;
        String str = appLifeCycleEvent.f1267a;
        InterfaceC2421a interfaceC2421aMo839a = appLifeCycleEvent2.mo839a(appLifeCycleEvent);
        Intrinsics.checkNotNull(interfaceC2421aMo839a, "null cannot be cast to non-null type com.contentsquare.android.internal.core.telemetry.event.AppLifeCycleEvent");
        linkedHashMap.put(str, (AppLifeCycleEvent) interfaceC2421aMo839a);
    }
}
