package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.e7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2738e7<T extends InterfaceC2421a> {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Channel<T> f2584a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Flow<T> f2585b;

    public C2738e7() {
        Channel<T> channelChannel$default = ChannelKt.Channel$default(10, BufferOverflow.DROP_LATEST, null, 4, null);
        this.f2584a = channelChannel$default;
        this.f2585b = FlowKt.receiveAsFlow(channelChannel$default);
    }

    /* JADX INFO: renamed from: a */
    public final void m1125a(@NotNull T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f2584a.mo5925trySendJP2dKIU(event);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final Flow<T> m1124a() {
        return this.f2585b;
    }
}
