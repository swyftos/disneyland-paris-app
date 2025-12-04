package com.urbanairship.android.layout.environment;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.util.DerivedStateFlowKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0000¨\u0006\b"}, d2 = {"makeThomasState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/android/layout/environment/ThomasState;", "formState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Form;", "layoutState", "Lcom/urbanairship/android/layout/environment/State$Layout;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThomasStateKt {
    @NotNull
    public static final StateFlow<ThomasState> makeThomasState(@Nullable SharedState<State.Form> sharedState, @Nullable SharedState<State.Layout> sharedState2) {
        StateFlow<State.Form> stateFlowAsStateFlow;
        if (sharedState2 == null) {
            return FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(new ThomasState(null, null)));
        }
        StateFlow<State.Layout> changes = sharedState2.getChanges();
        if (sharedState == null || (stateFlowAsStateFlow = sharedState.getChanges()) == null) {
            stateFlowAsStateFlow = FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(null));
        }
        return DerivedStateFlowKt.combineStates(changes, stateFlowAsStateFlow, AnonymousClass1.INSTANCE);
    }

    /* renamed from: com.urbanairship.android.layout.environment.ThomasStateKt$makeThomasState$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2, ThomasState.class, "<init>", "<init>(Lcom/urbanairship/android/layout/environment/State$Layout;Lcom/urbanairship/android/layout/environment/State$Form;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final ThomasState invoke(State.Layout layout, State.Form form) {
            return new ThomasState(layout, form);
        }
    }
}
