package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.r7 */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2868r7<T> {
    @Nullable
    /* JADX INFO: renamed from: a */
    Object mo1130a(StatisticRecord statisticRecord, @NotNull C2580O3.e eVar);

    @Nullable
    /* JADX INFO: renamed from: a */
    Object mo1132a(@NotNull Continuation<? super T> continuation);

    @Nullable
    Unit clear();
}
