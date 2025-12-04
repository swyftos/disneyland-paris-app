package com.urbanairship.util;

import androidx.exifinterface.media.ExifInterface;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.urbanairship.util.AutoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1", f = "AutoRefreshingDataProvider.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n+ 2 AutoRefreshingDataProvider.kt\ncom/urbanairship/util/AutoRefreshingDataProvider$updates$2\n*L\n1#1,218:1\n46#2,2:219\n69#2:221\n*E\n"})
/* loaded from: classes5.dex */
public final class AutoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1<T> extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends T>>, Pair<? extends String, ? extends UUID>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $lastIdentifier$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ AutoRefreshingDataProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1(Continuation continuation, AutoRefreshingDataProvider autoRefreshingDataProvider, Ref.ObjectRef objectRef) {
        super(3, continuation);
        this.this$0 = autoRefreshingDataProvider;
        this.$lastIdentifier$inlined = objectRef;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Result<? extends T>> flowCollector, Pair<? extends String, ? extends UUID> pair, @Nullable Continuation<? super Unit> continuation) {
        AutoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1 autoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1 = new AutoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1(continuation, this.this$0, this.$lastIdentifier$inlined);
        autoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1.L$0 = flowCollector;
        autoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1.L$1 = pair;
        return autoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Pair pair = (Pair) this.L$1;
            Flow flowCombine = FlowKt.combine(FlowKt.flow(new AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1(this.this$0, (String) pair.component1(), (UUID) pair.component2(), this.$lastIdentifier$inlined, null)), this.this$0.overrideUpdates, new AutoRefreshingDataProvider$updates$2$2$1(this.this$0, null));
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flowCombine, this) == coroutine_suspended) {
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
