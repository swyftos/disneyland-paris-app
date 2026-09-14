package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.features.srm.SrmKeysCache;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.C6 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.features.srm.SrmKeysCache$load$1", m1845f = "SrmKeysCache.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2463C6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SrmKeysCache f1483a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2463C6(SrmKeysCache srmKeysCache, Continuation<? super C2463C6> continuation) {
        super(2, continuation);
        this.f1483a = srmKeysCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2463C6(this.f1483a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2463C6(this.f1483a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        SrmKeysCache.m842a(this.f1483a);
        return Unit.INSTANCE;
    }
}
