package com.urbanairship.util;

import androidx.annotation.RestrictTo;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001at\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000126\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00020\bH\u0007¨\u0006\r"}, d2 = {"combineStates", "Lkotlinx/coroutines/flow/StateFlow;", "TR", "T1", "T2", "flow1", "flow2", ViewProps.TRANSFORM, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t1", "t2", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DerivedStateFlowKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final <T1, T2, TR> StateFlow<TR> combineStates(@NotNull final StateFlow<? extends T1> flow1, @NotNull final StateFlow<? extends T2> flow2, @NotNull final Function2<? super T1, ? super T2, ? extends TR> transform) {
        Intrinsics.checkNotNullParameter(flow1, "flow1");
        Intrinsics.checkNotNullParameter(flow2, "flow2");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new DerivedStateFlow(new Function0() { // from class: com.urbanairship.util.DerivedStateFlowKt.combineStates.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return transform.invoke(flow1.getValue(), flow2.getValue());
            }
        }, FlowKt.combine(flow1, flow2, new AnonymousClass2(transform)));
    }

    /* renamed from: com.urbanairship.util.DerivedStateFlowKt$combineStates$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3, SuspendFunction {
        AnonymousClass2(Object obj) {
            super(3, obj, Intrinsics.Kotlin.class, "suspendConversion0", "combineStates$suspendConversion0(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Continuation continuation) {
            return DerivedStateFlowKt.combineStates$suspendConversion0((Function2) this.receiver, obj, obj2, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object combineStates$suspendConversion0(Function2 function2, Object obj, Object obj2, Continuation continuation) {
        return function2.invoke(obj, obj2);
    }
}
