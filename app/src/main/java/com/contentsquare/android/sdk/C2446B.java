package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.AppBarHandler$resetAppBar$2", m1845f = "AppBarHandler.kt", m1846i = {}, m1847l = {EACTags.DEPRECATED}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2446B extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f1429a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f1430b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2940z.a f1431c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C2940z f1432d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ View f1433e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2446B(View view, C2940z.a aVar, C2940z c2940z, View view2, Continuation<? super C2446B> continuation) {
        super(2, continuation);
        this.f1430b = view;
        this.f1431c = aVar;
        this.f1432d = c2940z;
        this.f1433e = view2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2446B(this.f1430b, this.f1431c, this.f1432d, this.f1433e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C2446B) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f1429a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ViewGroup.LayoutParams layoutParams = this.f1430b.getLayoutParams();
            layoutParams.height = this.f1431c.f3284c;
            this.f1430b.setLayoutParams(layoutParams);
            C2940z.m1239a(this.f1432d, this.f1433e, false);
            View view = this.f1430b;
            this.f1429a = 1;
            if (C2829n8.m1182a(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
