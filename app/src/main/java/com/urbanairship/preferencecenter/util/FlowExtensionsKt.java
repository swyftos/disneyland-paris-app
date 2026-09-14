package com.urbanairship.preferencecenter.util;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u007f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\u0004\u001a\u0002H\u00022L\u0010\u0005\u001aH\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0000¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1836d2 = {"scanConcat", "Lkotlinx/coroutines/flow/Flow;", "R", ExifInterface.GPS_DIRECTION_TRUE, "initial", ViewProps.TRANSFORM, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "urbanairship-preference-center_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class FlowExtensionsKt {

    /* JADX INFO: renamed from: com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1 */
    static final class C57151 extends SuspendLambda implements Function2 {
        final /* synthetic */ Object $initial;
        final /* synthetic */ Flow $this_scanConcat;
        final /* synthetic */ Function3 $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C57151(Object obj, Flow flow, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.$initial = obj;
            this.$this_scanConcat = flow;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C57151 c57151 = new C57151(this.$initial, this.$this_scanConcat, this.$transform, continuation);
            c57151.L$0 = obj;
            return c57151;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((C57151) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                objectRef = new Ref.ObjectRef();
                ?? r4 = this.$initial;
                objectRef.element = r4;
                this.L$0 = flowCollector2;
                this.L$1 = objectRef;
                this.label = 1;
                if (flowCollector2.emit(r4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
            } else {
                if (i == 1) {
                    objectRef = (Ref.ObjectRef) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            Flow flow = this.$this_scanConcat;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, objectRef, flowCollector);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1, reason: invalid class name */
        static final class AnonymousClass1 implements FlowCollector {
            final /* synthetic */ FlowCollector $$this$flow;
            final /* synthetic */ Ref.ObjectRef $accumulator;
            final /* synthetic */ Function3 $transform;

            AnonymousClass1(Function3 function3, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
                this.$transform = function3;
                this.$accumulator = objectRef;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                FlowExtensionsKt$scanConcat$1$1$emit$1 flowExtensionsKt$scanConcat$1$1$emit$1;
                if (continuation instanceof FlowExtensionsKt$scanConcat$1$1$emit$1) {
                    flowExtensionsKt$scanConcat$1$1$emit$1 = (FlowExtensionsKt$scanConcat$1$1$emit$1) continuation;
                    int i = flowExtensionsKt$scanConcat$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        flowExtensionsKt$scanConcat$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        flowExtensionsKt$scanConcat$1$1$emit$1 = new FlowExtensionsKt$scanConcat$1$1$emit$1(this, continuation);
                    }
                } else {
                    flowExtensionsKt$scanConcat$1$1$emit$1 = new FlowExtensionsKt$scanConcat$1$1$emit$1(this, continuation);
                }
                Object objInvoke = flowExtensionsKt$scanConcat$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = flowExtensionsKt$scanConcat$1$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objInvoke);
                    Function3 function3 = this.$transform;
                    T t = this.$accumulator.element;
                    flowExtensionsKt$scanConcat$1$1$emit$1.L$0 = this;
                    flowExtensionsKt$scanConcat$1$1$emit$1.label = 1;
                    objInvoke = function3.invoke(t, obj, flowExtensionsKt$scanConcat$1$1$emit$1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 == 1) {
                        this = (AnonymousClass1) flowExtensionsKt$scanConcat$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(objInvoke);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objInvoke);
                    }
                    return Unit.INSTANCE;
                }
                final Ref.ObjectRef objectRef = this.$accumulator;
                final FlowCollector flowCollector = this.$$this$flow;
                FlowCollector flowCollector2 = new FlowCollector() { // from class: com.urbanairship.preferencecenter.util.FlowExtensionsKt.scanConcat.1.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation2) {
                        objectRef.element = obj2;
                        Object objEmit = flowCollector.emit(obj2, continuation2);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                };
                flowExtensionsKt$scanConcat$1$1$emit$1.L$0 = null;
                flowExtensionsKt$scanConcat$1$1$emit$1.label = 2;
                if (((Flow) objInvoke).collect(flowCollector2, flowExtensionsKt$scanConcat$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
    }

    @NotNull
    public static final <T, R> Flow<R> scanConcat(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return FlowKt.flow(new C57151(r, flow, transform, null));
    }
}
