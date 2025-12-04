package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.a;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.e7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0668e7<T extends com.contentsquare.android.internal.core.telemetry.event.a> {

    @NotNull
    public final Channel<T> a;

    @NotNull
    public final Flow<T> b;

    public C0668e7() {
        Channel<T> channelChannel$default = ChannelKt.Channel$default(10, BufferOverflow.DROP_LATEST, null, 4, null);
        this.a = channelChannel$default;
        this.b = FlowKt.receiveAsFlow(channelChannel$default);
    }

    public final void a(@NotNull T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a.mo3620trySendJP2dKIU(event);
    }

    @NotNull
    public final Flow<T> a() {
        return this.b;
    }
}
