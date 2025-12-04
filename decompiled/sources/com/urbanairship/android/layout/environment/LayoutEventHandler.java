package com.urbanairship.android.layout.environment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEventHandler;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "eventsChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "layoutEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "getLayoutEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "broadcast", "", "event", "(Lcom/urbanairship/android/layout/environment/LayoutEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LayoutEventHandler {
    private final Channel eventsChannel;
    private final SharedFlow layoutEvents;

    public LayoutEventHandler(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Channel channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.eventsChannel = channelChannel$default;
        this.layoutEvents = FlowKt__ShareKt.shareIn$default(FlowKt.receiveAsFlow(channelChannel$default), coroutineScope, SharingStarted.INSTANCE.getEagerly(), 0, 4, null);
    }

    @NotNull
    public final SharedFlow<LayoutEvent> getLayoutEvents() {
        return this.layoutEvents;
    }

    @Nullable
    public final Object broadcast(@NotNull LayoutEvent layoutEvent, @NotNull Continuation<? super Unit> continuation) {
        Object objSend = this.eventsChannel.send(layoutEvent, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }
}
