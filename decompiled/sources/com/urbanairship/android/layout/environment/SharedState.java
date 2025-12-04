package com.urbanairship.android.layout.environment;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.android.layout.util.DelicateLayoutApi;
import defpackage.WrappingViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/environment/SharedState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "(Ljava/lang/Object;)V", "changes", "Lkotlinx/coroutines/flow/StateFlow;", "getChanges", "()Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "update", "", "block", "Lkotlin/Function1;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSharedState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedState.kt\ncom/urbanairship/android/layout/environment/SharedState\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,30:1\n226#2,5:31\n*S KotlinDebug\n*F\n+ 1 SharedState.kt\ncom/urbanairship/android/layout/environment/SharedState\n*L\n26#1:31,5\n*E\n"})
/* loaded from: classes5.dex */
public final class SharedState<T> {
    private final StateFlow changes;
    private final MutableStateFlow stateFlow;

    @DelicateLayoutApi
    public static /* synthetic */ void getValue$annotations() {
    }

    public SharedState(T t) {
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(t);
        this.stateFlow = MutableStateFlow;
        this.changes = FlowKt.asStateFlow(MutableStateFlow);
    }

    @NotNull
    public final StateFlow<T> getChanges() {
        return this.changes;
    }

    public final T getValue() {
        return (T) this.stateFlow.getValue();
    }

    public final void update(@NotNull Function1<? super T, ? extends T> block) {
        WrappingViewGroup wrappingViewGroup;
        Intrinsics.checkNotNullParameter(block, "block");
        MutableStateFlow mutableStateFlow = this.stateFlow;
        do {
            wrappingViewGroup = (Object) mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(wrappingViewGroup, block.invoke(wrappingViewGroup)));
    }
}
