package com.urbanairship.android.layout.environment;

import androidx.exifinterface.media.ExifInterface;
import com.dlp.BluetoothManager;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.reporting.DisplayTimer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/urbanairship/android/layout/environment/ModelEnvironment;", "", "layoutState", "Lcom/urbanairship/android/layout/environment/LayoutState;", "reporter", "Lcom/urbanairship/android/layout/environment/Reporter;", "actionsRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "displayTimer", "Lcom/urbanairship/android/layout/reporting/DisplayTimer;", "modelScope", "Lkotlinx/coroutines/CoroutineScope;", "attributeHandler", "Lcom/urbanairship/android/layout/environment/AttributeHandler;", "channelRegistrar", "Lcom/urbanairship/android/layout/environment/ThomasChannelRegistrar;", "eventHandler", "Lcom/urbanairship/android/layout/environment/LayoutEventHandler;", "pagerTracker", "Lcom/urbanairship/android/layout/environment/PagersViewTracker;", "(Lcom/urbanairship/android/layout/environment/LayoutState;Lcom/urbanairship/android/layout/environment/Reporter;Lcom/urbanairship/android/layout/environment/ThomasActionRunner;Lcom/urbanairship/android/layout/reporting/DisplayTimer;Lkotlinx/coroutines/CoroutineScope;Lcom/urbanairship/android/layout/environment/AttributeHandler;Lcom/urbanairship/android/layout/environment/ThomasChannelRegistrar;Lcom/urbanairship/android/layout/environment/LayoutEventHandler;Lcom/urbanairship/android/layout/environment/PagersViewTracker;)V", "getActionsRunner", "()Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "getAttributeHandler", "()Lcom/urbanairship/android/layout/environment/AttributeHandler;", "getChannelRegistrar", "()Lcom/urbanairship/android/layout/environment/ThomasChannelRegistrar;", "getDisplayTimer", "()Lcom/urbanairship/android/layout/reporting/DisplayTimer;", "getEventHandler", "()Lcom/urbanairship/android/layout/environment/LayoutEventHandler;", "layoutEvents", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "getLayoutEvents", "()Lkotlinx/coroutines/flow/Flow;", "getLayoutState", "()Lcom/urbanairship/android/layout/environment/LayoutState;", "getModelScope", "()Lkotlinx/coroutines/CoroutineScope;", "getPagerTracker", "()Lcom/urbanairship/android/layout/environment/PagersViewTracker;", "getReporter", "()Lcom/urbanairship/android/layout/environment/Reporter;", "withState", BluetoothManager.BLE_STATUS_PARAM, "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModelEnvironment {
    private final ThomasActionRunner actionsRunner;
    private final AttributeHandler attributeHandler;
    private final ThomasChannelRegistrar channelRegistrar;
    private final DisplayTimer displayTimer;
    private final LayoutEventHandler eventHandler;
    private final Flow layoutEvents;
    private final LayoutState layoutState;
    private final CoroutineScope modelScope;
    private final PagersViewTracker pagerTracker;
    private final Reporter reporter;

    public ModelEnvironment(@NotNull LayoutState layoutState, @NotNull Reporter reporter, @NotNull ThomasActionRunner actionsRunner, @NotNull DisplayTimer displayTimer, @NotNull CoroutineScope modelScope, @NotNull AttributeHandler attributeHandler, @NotNull ThomasChannelRegistrar channelRegistrar, @NotNull LayoutEventHandler eventHandler, @NotNull PagersViewTracker pagerTracker) {
        Intrinsics.checkNotNullParameter(layoutState, "layoutState");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(actionsRunner, "actionsRunner");
        Intrinsics.checkNotNullParameter(displayTimer, "displayTimer");
        Intrinsics.checkNotNullParameter(modelScope, "modelScope");
        Intrinsics.checkNotNullParameter(attributeHandler, "attributeHandler");
        Intrinsics.checkNotNullParameter(channelRegistrar, "channelRegistrar");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics.checkNotNullParameter(pagerTracker, "pagerTracker");
        this.layoutState = layoutState;
        this.reporter = reporter;
        this.actionsRunner = actionsRunner;
        this.displayTimer = displayTimer;
        this.modelScope = modelScope;
        this.attributeHandler = attributeHandler;
        this.channelRegistrar = channelRegistrar;
        this.eventHandler = eventHandler;
        this.pagerTracker = pagerTracker;
        this.layoutEvents = eventHandler.getLayoutEvents();
        BuildersKt__Builders_commonKt.launch$default(modelScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @NotNull
    public final LayoutState getLayoutState() {
        return this.layoutState;
    }

    @NotNull
    public final Reporter getReporter() {
        return this.reporter;
    }

    @NotNull
    public final ThomasActionRunner getActionsRunner() {
        return this.actionsRunner;
    }

    @NotNull
    public final DisplayTimer getDisplayTimer() {
        return this.displayTimer;
    }

    public /* synthetic */ ModelEnvironment(LayoutState layoutState, Reporter reporter, ThomasActionRunner thomasActionRunner, DisplayTimer displayTimer, CoroutineScope coroutineScope, AttributeHandler attributeHandler, ThomasChannelRegistrar thomasChannelRegistrar, LayoutEventHandler layoutEventHandler, PagersViewTracker pagersViewTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        AttributeHandler attributeHandler2;
        Function0 function0 = null;
        byte b = 0;
        byte b2 = 0;
        CoroutineScope CoroutineScope = (i & 16) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope;
        if ((i & 32) != 0) {
            attributeHandler2 = new AttributeHandler(function0, b2 == true ? 1 : 0, 3, b == true ? 1 : 0);
        } else {
            attributeHandler2 = attributeHandler;
        }
        this(layoutState, reporter, thomasActionRunner, displayTimer, CoroutineScope, attributeHandler2, (i & 64) != 0 ? new ThomasChannelRegistrar(null, null, null, 7, null) : thomasChannelRegistrar, (i & 128) != 0 ? new LayoutEventHandler(CoroutineScope) : layoutEventHandler, (i & 256) != 0 ? new PagersViewTracker() : pagersViewTracker);
    }

    @NotNull
    public final CoroutineScope getModelScope() {
        return this.modelScope;
    }

    @NotNull
    public final AttributeHandler getAttributeHandler() {
        return this.attributeHandler;
    }

    @NotNull
    public final ThomasChannelRegistrar getChannelRegistrar() {
        return this.channelRegistrar;
    }

    @NotNull
    public final LayoutEventHandler getEventHandler() {
        return this.eventHandler;
    }

    @NotNull
    public final PagersViewTracker getPagerTracker() {
        return this.pagerTracker;
    }

    @NotNull
    public final Flow<LayoutEvent> getLayoutEvents() {
        return this.layoutEvents;
    }

    /* renamed from: com.urbanairship.android.layout.environment.ModelEnvironment$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ModelEnvironment.this.new AnonymousClass1(continuation);
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
                final Flow<LayoutEvent> layoutEvents = ModelEnvironment.this.getLayoutEvents();
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "ModelEnvironment.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.Report
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.environment.ModelEnvironment$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                final ModelEnvironment modelEnvironment = ModelEnvironment.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.environment.ModelEnvironment.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LayoutEvent.Report report, Continuation continuation) {
                        modelEnvironment.getReporter().report(report.getEvent());
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
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

    @NotNull
    public final ModelEnvironment withState(@NotNull LayoutState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new ModelEnvironment(state, this.reporter, this.actionsRunner, this.displayTimer, this.modelScope, this.attributeHandler, null, this.eventHandler, this.pagerTracker, 64, null);
    }
}
