package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.AppLifeCycleEvent;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class F {

    @NotNull
    public final Function0<Long> a;

    @NotNull
    public final LinkedHashMap b;
    public long c;

    public F(int i) {
        E currentTime = E.a;
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        this.a = currentTime;
        this.b = new LinkedHashMap();
    }

    public final void a(AppLifeCycleEvent appLifeCycleEvent) {
        AppLifeCycleEvent appLifeCycleEvent2 = (AppLifeCycleEvent) this.b.get(appLifeCycleEvent.a);
        if (appLifeCycleEvent2 == null) {
            this.b.put(appLifeCycleEvent.a, appLifeCycleEvent);
            return;
        }
        LinkedHashMap linkedHashMap = this.b;
        String str = appLifeCycleEvent.a;
        com.contentsquare.android.internal.core.telemetry.event.a aVarA = appLifeCycleEvent2.a(appLifeCycleEvent);
        Intrinsics.checkNotNull(aVarA, "null cannot be cast to non-null type com.contentsquare.android.internal.core.telemetry.event.AppLifeCycleEvent");
        linkedHashMap.put(str, (AppLifeCycleEvent) aVarA);
    }
}
