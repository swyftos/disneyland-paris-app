package com.urbanairship.android.layout.model;

import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.model.PagerModel;
import com.urbanairship.android.layout.property.PageBranching;
import com.urbanairship.android.layout.property.PagerControllerBranching;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001Bg\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010'\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010(\u001a\u00020\fH\u0002R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerBranchControl;", "", "availablePages", "", "Lcom/urbanairship/android/layout/model/PagerModel$Item;", "controllerBranching", "Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "thomasState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/android/layout/environment/ThomasState;", "onBranchUpdated", "Lkotlin/Function1;", "", "actionsRunner", "Lcom/urbanairship/android/layout/property/StateAction;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/util/List;Lcom/urbanairship/android/layout/property/PagerControllerBranching;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)V", "_isComplete", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "history", "", "isComplete", "()Lkotlinx/coroutines/flow/StateFlow;", "addToHistory", "id", "", "buildPathFrom", "page", "payload", "Lcom/urbanairship/json/JsonSerializable;", "clearHistoryAfter", "evaluateCompletion", "onPageRequest", "request", "Lcom/urbanairship/android/layout/model/PageRequest;", "performCompletionStateActions", "reEvaluatePath", "removeFromHistory", "updateState", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerBranchControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerBranchControl.kt\ncom/urbanairship/android/layout/model/PagerBranchControl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n350#2,7:151\n350#2,7:158\n288#2,2:165\n766#2:172\n857#2,2:173\n1603#2,9:175\n1855#2:184\n1856#2:186\n1612#2:187\n226#3,5:167\n1#4:185\n*S KotlinDebug\n*F\n+ 1 PagerBranchControl.kt\ncom/urbanairship/android/layout/model/PagerBranchControl\n*L\n69#1:151,7\n113#1:158,7\n125#1:165,2\n138#1:172\n138#1:173,2\n139#1:175,9\n139#1:184\n139#1:186\n139#1:187\n133#1:167,5\n139#1:185\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerBranchControl {
    private final MutableStateFlow _isComplete;
    private final Function1 actionsRunner;
    private final List availablePages;
    private final PagerControllerBranching controllerBranching;
    private final List history;
    private final StateFlow isComplete;
    private final Function1 onBranchUpdated;
    private final CoroutineScope scope;
    private final StateFlow thomasState;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageRequest.values().length];
            try {
                iArr[PageRequest.NEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageRequest.FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageRequest.BACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PagerBranchControl(@NotNull List<PagerModel.Item> availablePages, @NotNull PagerControllerBranching controllerBranching, @NotNull StateFlow<ThomasState> thomasState, @NotNull Function1<? super List<PagerModel.Item>, Unit> onBranchUpdated, @NotNull Function1<? super List<? extends StateAction>, Unit> actionsRunner, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(availablePages, "availablePages");
        Intrinsics.checkNotNullParameter(controllerBranching, "controllerBranching");
        Intrinsics.checkNotNullParameter(thomasState, "thomasState");
        Intrinsics.checkNotNullParameter(onBranchUpdated, "onBranchUpdated");
        Intrinsics.checkNotNullParameter(actionsRunner, "actionsRunner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.availablePages = availablePages;
        this.controllerBranching = controllerBranching;
        this.thomasState = thomasState;
        this.onBranchUpdated = onBranchUpdated;
        this.actionsRunner = actionsRunner;
        this.scope = scope;
        this.history = new ArrayList();
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isComplete = MutableStateFlow;
        this.isComplete = FlowKt.asStateFlow(MutableStateFlow);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ PagerBranchControl(List list, PagerControllerBranching pagerControllerBranching, StateFlow stateFlow, Function1 function1, Function1 function12, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, pagerControllerBranching, stateFlow, function1, function12, (i & 32) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }

    @NotNull
    public final StateFlow<Boolean> isComplete() {
        return this.isComplete;
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerBranchControl$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerBranchControl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow stateFlow = PagerBranchControl.this.thomasState;
                final PagerBranchControl pagerBranchControl = PagerBranchControl.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.PagerBranchControl.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(ThomasState thomasState, Continuation continuation) {
                        pagerBranchControl.updateState();
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (stateFlow.collect(flowCollector, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState() {
        ThomasState thomasState = (ThomasState) this.thomasState.getValue();
        reEvaluatePath(thomasState);
        evaluateCompletion(thomasState);
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerBranchControl$addToHistory$1, reason: invalid class name and case insensitive filesystem */
    static final class C09351 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09351(String str, Continuation continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerBranchControl.this.new C09351(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PagerBranchControl.this.clearHistoryAfter(this.$id);
                List list = PagerBranchControl.this.availablePages;
                String str = this.$id;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((PagerModel.Item) next).getIdentifier(), str)) {
                        break;
                    }
                }
                PagerModel.Item item = (PagerModel.Item) next;
                if (item == null) {
                    return Unit.INSTANCE;
                }
                if (!PagerBranchControl.this.history.contains(item)) {
                    PagerBranchControl.this.history.add(item);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void addToHistory(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09351(id, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerBranchControl$removeFromHistory$1, reason: invalid class name and case insensitive filesystem */
    static final class C09371 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09371(String str, Continuation continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerBranchControl.this.new C09371(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = PagerBranchControl.this.availablePages;
                String str = this.$id;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((PagerModel.Item) next).getIdentifier(), str)) {
                        break;
                    }
                }
                PagerModel.Item item = (PagerModel.Item) next;
                if (item == null) {
                    return Unit.INSTANCE;
                }
                PagerBranchControl.this.history.remove(item);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void removeFromHistory(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09371(id, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearHistoryAfter(String id) {
        Iterator it = this.history.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((PagerModel.Item) it.next()).getIdentifier(), id)) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        if (i2 < 1 || i2 >= this.history.size()) {
            return;
        }
        List list = this.history;
        list.subList(i2, list.size()).clear();
    }

    public final void onPageRequest(@NotNull PageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        int i = WhenMappings.$EnumSwitchMapping$0[request.ordinal()];
        if (i == 2) {
            this.history.clear();
        } else {
            if (i != 3) {
                return;
            }
            CollectionsKt.removeLastOrNull(this.history);
        }
    }

    private final void reEvaluatePath(JsonSerializable payload) {
        if (this.history.isEmpty() && !this.availablePages.isEmpty()) {
            this.history.add(CollectionsKt.first(this.availablePages));
        }
        this.onBranchUpdated.invoke(CollectionsKt.plus((Collection) CollectionsKt.dropLast(this.history, 1), (Iterable) buildPathFrom((PagerModel.Item) CollectionsKt.last(this.history), payload)));
    }

    private final List buildPathFrom(PagerModel.Item page, JsonSerializable payload) {
        String strNextPageId;
        int iIndexOf = this.availablePages.indexOf(page);
        if (iIndexOf < 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (iIndexOf >= 0 && iIndexOf < this.availablePages.size()) {
                final PagerModel.Item item = (PagerModel.Item) this.availablePages.get(iIndexOf);
                if (arrayList.contains(item)) {
                    UALog.w$default(null, new Function0() { // from class: com.urbanairship.android.layout.model.PagerBranchControl.buildPathFrom.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Trying to add a duplicate " + item;
                        }
                    }, 1, null);
                    break;
                }
                arrayList.add(item);
                PageBranching branching = item.getBranching();
                if (branching != null && (strNextPageId = PagerBranchControlKt.nextPageId(branching, payload)) != null) {
                    Iterator it = this.availablePages.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            iIndexOf = -1;
                            break;
                        }
                        if (Intrinsics.areEqual(((PagerModel.Item) it.next()).getIdentifier(), strNextPageId)) {
                            iIndexOf = i;
                            break;
                        }
                        i++;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    private final void evaluateCompletion(JsonSerializable payload) {
        Object next;
        Object value;
        if (((Boolean) this._isComplete.getValue()).booleanValue()) {
            return;
        }
        Iterator<T> it = this.controllerBranching.getCompletions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            JsonPredicate predicate = ((PagerControllerBranching.Completion) next).getPredicate();
            if (!((predicate == null || predicate.apply(payload)) ? false : true)) {
                break;
            }
        }
        boolean z = ((PagerControllerBranching.Completion) next) != null;
        if (z && !((Boolean) this._isComplete.getValue()).booleanValue()) {
            performCompletionStateActions(payload);
        }
        MutableStateFlow mutableStateFlow = this._isComplete;
        do {
            value = mutableStateFlow.getValue();
            ((Boolean) value).booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(z)));
    }

    private final void performCompletionStateActions(JsonSerializable payload) {
        List<PagerControllerBranching.Completion> completions = this.controllerBranching.getCompletions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : completions) {
            JsonPredicate predicate = ((PagerControllerBranching.Completion) obj).getPredicate();
            boolean z = false;
            if (predicate != null && !predicate.apply(payload)) {
                z = true;
            }
            if (!z) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List<StateAction> stateActions = ((PagerControllerBranching.Completion) it.next()).getStateActions();
            if (stateActions != null) {
                arrayList2.add(stateActions);
            }
        }
        this.actionsRunner.invoke(CollectionsKt.flatten(arrayList2));
    }
}
