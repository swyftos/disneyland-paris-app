package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import com.contentsquare.android.sdk.O3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.r7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0797r7<T> {
    @Nullable
    Object a(StatisticRecord statisticRecord, @NotNull O3.e eVar);

    @Nullable
    Object a(@NotNull Continuation<? super T> continuation);

    @Nullable
    Unit clear();
}
