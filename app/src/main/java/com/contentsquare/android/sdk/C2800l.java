package com.contentsquare.android.sdk;

import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$setJsonConsumer$1", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2800l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f2837a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f2838b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Function1<JSONObject, Unit> f2839c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.l$a */
    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function1<JSONObject, Unit> f2840a;

        public a(C2498G1.a aVar) {
            this.f2840a = aVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            this.f2840a.invoke((JSONObject) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2800l(C2780j c2780j, C2498G1.a aVar, Continuation continuation) {
        super(2, continuation);
        this.f2838b = c2780j;
        this.f2839c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2800l(this.f2838b, (C2498G1.a) this.f2839c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2800l(this.f2838b, (C2498G1.a) this.f2839c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2837a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow<JSONObject> mutableSharedFlow = this.f2838b.f2757f;
            a aVar = new a((C2498G1.a) this.f2839c);
            this.f2837a = 1;
            if (mutableSharedFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
