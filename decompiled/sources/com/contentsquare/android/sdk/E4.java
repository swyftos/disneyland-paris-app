package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0657d6;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class E4 extends AbstractC0626a5<AbstractC0657d6.c> {

    @NotNull
    public final X4 e;

    @NotNull
    public final N0 f;

    @NotNull
    public final Function2<View, InterfaceC0679f8, AbstractC0645c4> g;

    @NotNull
    public final Logger h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E4(@NotNull X4 screenGraphProducer, @NotNull MutableStateFlow snapshotStateFlow, @NotNull Z0 callback, @NotNull InterfaceC0832v2 glassPane, @NotNull C0830v0 composeScreenGraphGenerator) {
        super(snapshotStateFlow, glassPane);
        Intrinsics.checkNotNullParameter(screenGraphProducer, "screenGraphProducer");
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(composeScreenGraphGenerator, "composeScreenGraphGenerator");
        this.e = screenGraphProducer;
        this.f = callback;
        this.g = composeScreenGraphGenerator;
        this.h = new Logger("RegularScreenRecorder");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void a(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.c context = (AbstractC0657d6.c) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final boolean b(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.c context = (AbstractC0657d6.c) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return true;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void e() {
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    @NotNull
    public final Logger a() {
        return this.h;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final Object b(AbstractC0657d6 abstractC0657d6, Continuation continuation) {
        X4 x4 = this.e;
        ViewGroup viewGroupB = b();
        Intrinsics.checkNotNull(viewGroupB);
        String strD = d();
        Intrinsics.checkNotNull(strD);
        Object objA = x4.a(viewGroupB, strD, c(), ((C0723k2) this.b).f, this.f, this.g, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
