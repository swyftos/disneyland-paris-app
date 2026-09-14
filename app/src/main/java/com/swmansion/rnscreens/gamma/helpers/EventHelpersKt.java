package com.swmansion.rnscreens.gamma.helpers;

import com.swmansion.rnscreens.gamma.common.NamingAwareEventType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0003j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, m1836d2 = {"makeEventRegistrationInfo", "Lkotlin/Pair;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "event", "Lcom/swmansion/rnscreens/gamma/common/NamingAwareEventType;", "react-native-screens_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class EventHelpersKt {
    @NotNull
    public static final Pair<String, HashMap<String, String>> makeEventRegistrationInfo(@NotNull NamingAwareEventType event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return TuplesKt.m1842to(event.getEventName(), MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", event.getEventRegistrationName())));
    }
}
