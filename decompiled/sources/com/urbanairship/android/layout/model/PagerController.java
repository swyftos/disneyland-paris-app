package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.PagersViewTracker;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.PagerControllerInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.PagerControllerBranching;
import com.urbanairship.android.layout.reporting.PagerData;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BO\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\"\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020'H\u0002R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerController;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Landroid/view/View;", "Lcom/urbanairship/android/layout/info/PagerControllerInfo;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/AnyModel;", "branching", "Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/PagerControllerInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/property/PagerControllerBranching;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "getBranching", "()Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "completionReported", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "pagerViewCounts", "", "", "", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "incAndGetViewCount", "pageId", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "reportCompletion", "", "pagerContext", "Lcom/urbanairship/android/layout/reporting/PagerData;", "reportPageView", "stopAndReportPagerSummary", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerController.kt\ncom/urbanairship/android/layout/model/PagerController\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n210#2,5:141\n226#2,5:149\n288#3,2:146\n1#4:148\n*S KotlinDebug\n*F\n+ 1 PagerController.kt\ncom/urbanairship/android/layout/model/PagerController\n*L\n97#1:141,5\n136#1:149,5\n123#1:146,2\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerController extends BaseModel<View, PagerControllerInfo, BaseModel.Listener> {
    private final PagerControllerBranching branching;
    private final MutableStateFlow completionReported;
    private final SharedState pagerState;
    private final MutableStateFlow pagerViewCounts;
    private final BaseModel view;

    public /* synthetic */ PagerController(PagerControllerInfo pagerControllerInfo, BaseModel baseModel, PagerControllerBranching pagerControllerBranching, SharedState sharedState, ModelEnvironment modelEnvironment, ModelProperties modelProperties, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagerControllerInfo, baseModel, (i & 4) != 0 ? null : pagerControllerBranching, sharedState, modelEnvironment, modelProperties);
    }

    @NotNull
    public final BaseModel<?, ?, ?> getView() {
        return this.view;
    }

    @Nullable
    public final PagerControllerBranching getBranching() {
        return this.branching;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerController(@NotNull PagerControllerInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @Nullable PagerControllerBranching pagerControllerBranching, @NotNull SharedState<State.Pager> pagerState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.view = view;
        this.branching = pagerControllerBranching;
        this.pagerState = pagerState;
        this.pagerViewCounts = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.completionReported = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass1(environment, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass2(environment, this, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ModelEnvironment $environment;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModelEnvironment modelEnvironment, Continuation continuation) {
            super(2, continuation);
            this.$environment = modelEnvironment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerController.this.new AnonymousClass1(this.$environment, continuation);
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
                final StateFlow changes = PagerController.this.pagerState.getChanges();
                final ModelEnvironment modelEnvironment = this.$environment;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<PagerData>() { // from class: com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PagerController.kt\ncom/urbanairship/android/layout/model/PagerController$1\n*L\n1#1,218:1\n50#2:219\n46#3,2:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ ModelEnvironment $environment$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1$2", f = "PagerController.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, ModelEnvironment modelEnvironment) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$environment$inlined = modelEnvironment;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L59
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                com.urbanairship.android.layout.environment.State$Pager r5 = (com.urbanairship.android.layout.environment.State.Pager) r5
                                com.urbanairship.android.layout.environment.ModelEnvironment r4 = r4.$environment$inlined
                                com.urbanairship.android.layout.environment.PagersViewTracker r4 = r4.getPagerTracker()
                                java.lang.String r2 = r5.getIdentifier()
                                java.util.List r4 = r4.viewedPages(r2)
                                if (r4 != 0) goto L4c
                                java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
                            L4c:
                                com.urbanairship.android.layout.reporting.PagerData r4 = r5.reportingContext(r4)
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r4, r0)
                                if (r4 != r1) goto L59
                                return r1
                            L59:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerController$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super PagerData> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = changes.collect(new AnonymousClass2(flowCollector, modelEnvironment), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(PagerController.this);
                this.label = 1;
                if (flowDistinctUntilChanged.collect(anonymousClass2, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.android.layout.model.PagerController$1$2, reason: invalid class name */
        /* synthetic */ class AnonymousClass2 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ PagerController $tmp0;

            AnonymousClass2(PagerController pagerController) {
                this.$tmp0 = pagerController;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.$tmp0, PagerController.class, "reportPageView", "reportPageView(Lcom/urbanairship/android/layout/reporting/PagerData;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(PagerData pagerData, Continuation continuation) {
                Object objInvokeSuspend$reportPageView = AnonymousClass1.invokeSuspend$reportPageView(this.$tmp0, pagerData, continuation);
                return objInvokeSuspend$reportPageView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$reportPageView : Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$reportPageView(PagerController pagerController, PagerData pagerData, Continuation continuation) {
            pagerController.reportPageView(pagerData);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerController$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ModelEnvironment $environment;
        int label;
        final /* synthetic */ PagerController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ModelEnvironment modelEnvironment, PagerController pagerController, Continuation continuation) {
            super(2, continuation);
            this.$environment = modelEnvironment;
            this.this$0 = pagerController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$environment, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final SharedFlow<LayoutEvent> layoutEvents = this.$environment.getEventHandler().getLayoutEvents();
                Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1$2", f = "PagerController.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L43
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.Finish
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerController$2$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final PagerController pagerController = this.this$0;
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.PagerController.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.Finish finish, Continuation continuation) {
                        pagerController.stopAndReportPagerSummary();
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    protected View onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        return this.view.createView(context, viewEnvironment, itemProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportPageView(PagerData pagerContext) {
        ReportingEvent.PageViewData pageViewData = new ReportingEvent.PageViewData(pagerContext.getIdentifier(), pagerContext.getPageId(), pagerContext.getIndex(), incAndGetViewCount(pagerContext.getPageId()), pagerContext.getCount(), pagerContext.isCompleted());
        PagersViewTracker pagerTracker = getEnvironment().getPagerTracker();
        Duration.Companion companion = Duration.INSTANCE;
        pagerTracker.m2717onPageViewHG0u8IE(pageViewData, DurationKt.toDuration(getEnvironment().getDisplayTimer().getTime(), DurationUnit.MILLISECONDS));
        report(new ReportingEvent.PageView(pageViewData, LayoutState.reportingContext$default(getLayoutState(), null, pagerContext, null, 5, null)));
        if (pagerContext.isCompleted()) {
            reportCompletion(pagerContext);
        }
    }

    private final void reportCompletion(PagerData pagerContext) {
        Object value;
        Boolean bool;
        MutableStateFlow mutableStateFlow = this.completionReported;
        do {
            value = mutableStateFlow.getValue();
            bool = (Boolean) value;
            bool.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
        if (bool.booleanValue()) {
            return;
        }
        report(new ReportingEvent.PagerComplete(new ReportingEvent.PagerCompleteData(pagerContext.getIdentifier(), pagerContext.getIndex(), pagerContext.getCount(), pagerContext.getPageId()), LayoutState.reportingContext$default(getLayoutState(), null, pagerContext, null, 5, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopAndReportPagerSummary() {
        Object next;
        String identifier = ((State.Pager) this.pagerState.getChanges().getValue()).getIdentifier();
        PagersViewTracker pagerTracker = getEnvironment().getPagerTracker();
        Duration.Companion companion = Duration.INSTANCE;
        pagerTracker.m2718stopHG0u8IE(identifier, DurationKt.toDuration(getEnvironment().getDisplayTimer().getTime(), DurationUnit.MILLISECONDS));
        Iterator<T> it = getEnvironment().getPagerTracker().generateSummaryEvents().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((ReportingEvent.PageSummaryData) next).getIdentifier(), identifier)) {
                    break;
                }
            }
        }
        ReportingEvent.PageSummaryData pageSummaryData = (ReportingEvent.PageSummaryData) next;
        if (pageSummaryData == null) {
            return;
        }
        report(new ReportingEvent.PagerSummary(pageSummaryData, LayoutState.reportingContext$default(getLayoutState(), null, null, null, 7, null)));
    }

    private final int incAndGetViewCount(String pageId) {
        Object value;
        Map mutableMap;
        Object obj = ((Map) this.pagerViewCounts.getValue()).get(pageId);
        if (obj == null) {
            obj = 0;
        }
        int iIntValue = ((Number) obj).intValue() + 1;
        MutableStateFlow mutableStateFlow = this.pagerViewCounts;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap((Map) value);
            mutableMap.put(pageId, Integer.valueOf(iIntValue));
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
        return iIntValue;
    }
}
