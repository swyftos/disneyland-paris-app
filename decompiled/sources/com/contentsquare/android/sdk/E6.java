package com.contentsquare.android.sdk;

import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.features.srm.SrmPayloadSplitter$split$1", f = "SrmPayloadSplitter.kt", i = {0, 0, 0}, l = {26, 36}, m = "invokeSuspend", n = {"$this$sequence", "bucket", ViewProps.POSITION}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes2.dex */
public final class E6 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super byte[]>, Continuation<? super Unit>, Object> {
    public C0701i0 a;
    public int b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ int e;
    public final /* synthetic */ F6 f;
    public final /* synthetic */ List<G6> g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E6(int i, F6 f6, ArrayList arrayList, Continuation continuation) {
        super(2, continuation);
        this.e = i;
        this.f = f6;
        this.g = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        E6 e6 = new E6(this.e, this.f, (ArrayList) this.g, continuation);
        e6.d = obj;
        return e6;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super byte[]> sequenceScope, Continuation<? super Unit> continuation) {
        return ((E6) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0147  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0110 -> B:25:0x0113). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.E6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
