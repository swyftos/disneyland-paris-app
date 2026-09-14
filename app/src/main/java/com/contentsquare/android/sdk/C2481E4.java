package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2481E4 extends AbstractC2696a5<AbstractC2727d6.c> {

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2668X4 f1549e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final InterfaceC2567N0 f1550f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final Function2<View, InterfaceC2749f8, AbstractC2715c4> f1551g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Logger f1552h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2481E4(@NotNull C2668X4 screenGraphProducer, @NotNull MutableStateFlow snapshotStateFlow, @NotNull C2682Z0 callback, @NotNull InterfaceC2903v2 glassPane, @NotNull C2901v0 composeScreenGraphGenerator) {
        super(snapshotStateFlow, glassPane);
        Intrinsics.checkNotNullParameter(screenGraphProducer, "screenGraphProducer");
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(composeScreenGraphGenerator, "composeScreenGraphGenerator");
        this.f1549e = screenGraphProducer;
        this.f1550f = callback;
        this.f1551g = composeScreenGraphGenerator;
        this.f1552h = new Logger("RegularScreenRecorder");
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: a */
    public final void mo907a(AbstractC2727d6 abstractC2727d6) {
        AbstractC2727d6.c context = (AbstractC2727d6.c) abstractC2727d6;
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: b */
    public final boolean mo909b(AbstractC2727d6 abstractC2727d6) {
        AbstractC2727d6.c context = (AbstractC2727d6.c) abstractC2727d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return true;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: e */
    public final void mo910e() {
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Logger mo906a() {
        return this.f1552h;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: b */
    public final Object mo908b(AbstractC2727d6 abstractC2727d6, Continuation continuation) {
        C2668X4 c2668x4 = this.f1549e;
        ViewGroup viewGroupM1088b = m1088b();
        Intrinsics.checkNotNull(viewGroupM1088b);
        String strM1090d = m1090d();
        Intrinsics.checkNotNull(strM1090d);
        Object objM1071a = c2668x4.m1071a(viewGroupM1088b, strM1090d, m1089c(), ((C2793k2) this.f2370b).f2811f, this.f1550f, this.f1551g, continuation);
        return objM1071a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM1071a : Unit.INSTANCE;
    }
}
