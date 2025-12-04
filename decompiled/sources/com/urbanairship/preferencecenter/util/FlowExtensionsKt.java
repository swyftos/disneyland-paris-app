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

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u007f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\u0004\u001a\u0002H\u00022L\u0010\u0005\u001aH\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0000¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"scanConcat", "Lkotlinx/coroutines/flow/Flow;", "R", ExifInterface.GPS_DIRECTION_TRUE, "initial", ViewProps.TRANSFORM, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "urbanairship-preference-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowExtensionsKt {

    /* renamed from: com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Object $initial;
        final /* synthetic */ Flow $this_scanConcat;
        final /* synthetic */ Function3 $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, Flow flow, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.$initial = obj;
            this.$this_scanConcat = flow;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$initial, this.$this_scanConcat, this.$transform, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                objectRef = (Ref.ObjectRef) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Flow flow = this.$this_scanConcat;
            C01611 c01611 = new C01611(this.$transform, objectRef, flowCollector);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (flow.collect(c01611, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* renamed from: com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01611 implements FlowCollector {
            final /* synthetic */ FlowCollector $$this$flow;
            final /* synthetic */ Ref.ObjectRef $accumulator;
            final /* synthetic */ Function3 $transform;

            C01611(Function3 function3, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
                this.$transform = function3;
                this.$accumulator = objectRef;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$emit$1 r0 = (com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$emit$1 r0 = new com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$emit$1
                    r0.<init>(r5, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L67
                L2c:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L34:
                    java.lang.Object r5 = r0.L$0
                    com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1 r5 = (com.urbanairship.preferencecenter.util.FlowExtensionsKt.AnonymousClass1.C01611) r5
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L50
                L3c:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlin.jvm.functions.Function3 r7 = r5.$transform
                    kotlin.jvm.internal.Ref$ObjectRef r2 = r5.$accumulator
                    T r2 = r2.element
                    r0.L$0 = r5
                    r0.label = r4
                    java.lang.Object r7 = r7.invoke(r2, r6, r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
                    com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$1 r6 = new com.urbanairship.preferencecenter.util.FlowExtensionsKt$scanConcat$1$1$1
                    kotlin.jvm.internal.Ref$ObjectRef r2 = r5.$accumulator
                    kotlinx.coroutines.flow.FlowCollector r5 = r5.$$this$flow
                    r6.<init>()
                    r5 = 0
                    r0.L$0 = r5
                    r0.label = r3
                    java.lang.Object r5 = r7.collect(r6, r0)
                    if (r5 != r1) goto L67
                    return r1
                L67:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.util.FlowExtensionsKt.AnonymousClass1.C01611.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    @NotNull
    public static final <T, R> Flow<R> scanConcat(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return FlowKt.flow(new AnonymousClass1(r, flow, transform, null));
    }
}
