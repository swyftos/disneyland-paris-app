package com.urbanairship.util;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m1836d2 = {"Lcom/urbanairship/util/DerivedStateFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/StateFlow;", "onValue", "Lkotlin/Function0;", "updates", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/flow/Flow;)V", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "value", "getValue", "()Ljava/lang/Object;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DerivedStateFlow<T> implements StateFlow<T> {
    private final Function0 onValue;
    private final Flow updates;

    /* JADX INFO: renamed from: com.urbanairship.util.DerivedStateFlow$collect$1 */
    static final class C58761 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C58761(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DerivedStateFlow.this.collect(null, this);
        }
    }

    public DerivedStateFlow(@NotNull Function0<? extends T> onValue, @NotNull Flow<? extends T> updates) {
        Intrinsics.checkNotNullParameter(onValue, "onValue");
        Intrinsics.checkNotNullParameter(updates, "updates");
        this.onValue = onValue;
        this.updates = updates;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return (T) this.onValue.invoke();
    }

    /* JADX INFO: renamed from: com.urbanairship.util.DerivedStateFlow$collect$2 */
    static final class C58772 extends SuspendLambda implements Function2 {
        final /* synthetic */ FlowCollector $collector;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C58772(FlowCollector flowCollector, Continuation continuation) {
            super(2, continuation);
            this.$collector = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C58772 c58772 = new C58772(this.$collector, continuation);
            c58772.L$0 = obj;
            return c58772;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C58772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(DerivedStateFlow.this.updates);
            this.label = 1;
            obj = FlowKt.stateIn(flowDistinctUntilChanged, coroutineScope, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            FlowCollector<? super T> flowCollector = this.$collector;
            this.label = 2;
            if (((StateFlow) obj).collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<?> continuation) {
        C58761 c58761;
        if (continuation instanceof C58761) {
            c58761 = (C58761) continuation;
            int i = c58761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c58761.label = i - Integer.MIN_VALUE;
            } else {
                c58761 = new C58761(continuation);
            }
        } else {
            c58761 = new C58761(continuation);
        }
        Object obj = c58761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c58761.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C58772 c58772 = new C58772(flowCollector, null);
            c58761.label = 1;
            if (CoroutineScopeKt.coroutineScope(c58772, c58761) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
