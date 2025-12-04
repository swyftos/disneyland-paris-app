package com.urbanairship.android.layout.environment;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.FormValidationMode;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.android.layout.reporting.ThomasFormFieldStatus;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010$\u001a\u00020%J'\u0010&\u001a\u0004\u0018\u0001H'\"\f\b\u0000\u0010'*\u0006\u0012\u0002\b\u00030(2\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0004\b+\u0010,J\u0014\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\u0006\u0010)\u001a\u00020*J\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202\u0018\u000100H\u0086@¢\u0006\u0002\u00103J*\u00104\u001a\u00020%2\n\u00105\u001a\u0006\u0012\u0002\b\u00030(2\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u000107j\u0004\u0018\u0001`8J\u001e\u00104\u001a\u00020%2\n\u00105\u001a\u0006\u0012\u0002\b\u00030(2\n\b\u0002\u00109\u001a\u0004\u0018\u00010*J#\u0010:\u001a\u00020%2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010>\u001a\u00020\u0013J\u000e\u0010?\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u00103R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00138F¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006@"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasForm;", "", "feed", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Form;", "pagerState", "Lcom/urbanairship/android/layout/environment/State$Pager;", "clock", "Lcom/urbanairship/util/Clock;", "sleeper", "Lcom/urbanairship/util/TaskSleeper;", "validationDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;)V", "formUpdates", "Lkotlinx/coroutines/flow/StateFlow;", "getFormUpdates", "()Lkotlinx/coroutines/flow/StateFlow;", "isEnabled", "", "isEnabled$annotations", "()V", "()Z", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "status", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "getStatus", "()Lkotlinx/coroutines/flow/Flow;", "validationMode", "Lcom/urbanairship/android/layout/info/FormValidationMode;", "getValidationMode", "()Lcom/urbanairship/android/layout/info/FormValidationMode;", "displayReported", "", "inputData", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "identifier", "", "inputData$urbanairship_layout_release", "(Ljava/lang/String;)Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "lastProcessedStatus", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "prepareSubmit", "Lkotlin/Pair;", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormResult;", "Lcom/urbanairship/android/layout/reporting/FormInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFormInput", "value", "predicate", "Lkotlin/Function0;", "Lcom/urbanairship/android/layout/environment/FormFieldFilterPredicate;", "pageId", "updateStatus", "isSubmitted", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "updateWithDisplayState", "isDisplayed", "validate", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThomasForm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasForm.kt\ncom/urbanairship/android/layout/environment/ThomasForm\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n49#2:205\n51#2:209\n46#3:206\n51#3:208\n105#4:207\n187#5,3:210\n453#6:213\n403#6:214\n1238#7,4:215\n*S KotlinDebug\n*F\n+ 1 ThomasForm.kt\ncom/urbanairship/android/layout/environment/ThomasForm\n*L\n42#1:205\n42#1:209\n42#1:206\n42#1:208\n42#1:207\n75#1:210,3\n77#1:213\n77#1:214\n77#1:215,4\n*E\n"})
/* loaded from: classes5.dex */
public final class ThomasForm {
    private final Clock clock;
    private final SharedState feed;
    private final StateFlow formUpdates;
    private final SharedState pagerState;
    private final CoroutineScope scope;
    private final TaskSleeper sleeper;

    /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$prepareSubmit$1, reason: invalid class name and case insensitive filesystem */
    static final class C09211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09211(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThomasForm.this.prepareSubmit(this);
        }
    }

    /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$validate$1, reason: invalid class name and case insensitive filesystem */
    static final class C09251 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C09251(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThomasForm.this.validate(this);
        }
    }

    public static /* synthetic */ void isEnabled$annotations() {
    }

    public ThomasForm(@NotNull SharedState<State.Form> feed, @Nullable SharedState<State.Pager> sharedState, @NotNull Clock clock, @NotNull TaskSleeper sleeper, @NotNull CoroutineDispatcher validationDispatcher) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(sleeper, "sleeper");
        Intrinsics.checkNotNullParameter(validationDispatcher, "validationDispatcher");
        this.feed = feed;
        this.pagerState = sharedState;
        this.clock = clock;
        this.sleeper = sleeper;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(validationDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.scope = CoroutineScope;
        this.formUpdates = feed.getChanges();
        if (getValidationMode() == FormValidationMode.IMMEDIATE) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ThomasForm(SharedState sharedState, SharedState sharedState2, Clock DEFAULT_CLOCK, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        SharedState sharedState3 = (i & 2) != 0 ? null : sharedState2;
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(sharedState, sharedState3, DEFAULT_CLOCK, (i & 8) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, (i & 16) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    public final FormValidationMode getValidationMode() {
        return ((State.Form) this.feed.getChanges().getValue()).getValidationMode();
    }

    @NotNull
    public final Flow<ThomasFormStatus> getStatus() {
        final StateFlow changes = this.feed.getChanges();
        return FlowKt.distinctUntilChanged(new Flow<ThomasFormStatus>() { // from class: com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ThomasForm.kt\ncom/urbanairship/android/layout/environment/ThomasForm\n*L\n1#1,218:1\n50#2:219\n42#3:220\n*E\n"})
            /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1$2", f = "ThomasForm.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        com.urbanairship.android.layout.environment.State$Form r5 = (com.urbanairship.android.layout.environment.State.Form) r5
                        com.urbanairship.android.layout.environment.ThomasFormStatus r5 = r5.getStatus()
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.environment.ThomasForm$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super ThomasFormStatus> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = changes.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }

    @NotNull
    public final StateFlow<State.Form> getFormUpdates() {
        return this.formUpdates;
    }

    public final boolean isEnabled() {
        return ((State.Form) this.feed.getValue()).isEnabled();
    }

    /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ThomasForm.this.new AnonymousClass1(continuation);
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
                Flow<ThomasFormStatus> status = ThomasForm.this.getStatus();
                final ThomasForm thomasForm = ThomasForm.this;
                FlowCollector<? super ThomasFormStatus> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.environment.ThomasForm.1.1

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$1$1$WhenMappings */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[ThomasFormStatus.values().length];
                            try {
                                iArr[ThomasFormStatus.ERROR.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[ThomasFormStatus.PENDING_VALIDATION.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(ThomasFormStatus thomasFormStatus, Continuation continuation) {
                        int i2 = WhenMappings.$EnumSwitchMapping$0[thomasFormStatus.ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            Object objValidate = thomasForm.validate(continuation);
                            return objValidate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objValidate : Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (status.collect(flowCollector, this) == coroutine_suspended) {
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

    /* JADX WARN: Path cross not found for [B:24:0x0090, B:25:0x0092], limit reached: 70 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0128 -> B:44:0x0129). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object validate(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.environment.ThomasForm.validate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final ThomasFormFieldStatus<?> lastProcessedStatus(@NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return ((State.Form) this.feed.getChanges().getValue()).lastProcessedStatus(identifier);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object prepareSubmit(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<com.urbanairship.android.layout.event.ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.urbanairship.android.layout.environment.ThomasForm.C09211
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.android.layout.environment.ThomasForm$prepareSubmit$1 r0 = (com.urbanairship.android.layout.environment.ThomasForm.C09211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.layout.environment.ThomasForm$prepareSubmit$1 r0 = new com.urbanairship.android.layout.environment.ThomasForm$prepareSubmit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            com.urbanairship.android.layout.environment.ThomasForm r5 = (com.urbanairship.android.layout.environment.ThomasForm) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7f
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$0
            com.urbanairship.android.layout.environment.ThomasForm r5 = (com.urbanairship.android.layout.environment.ThomasForm) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L40:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.validate(r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L58
            r5 = 0
            return r5
        L58:
            r0.L$0 = r5
            r0.label = r3
            kotlin.coroutines.SafeContinuation r6 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r6.<init>(r2)
            com.urbanairship.android.layout.environment.SharedState r5 = r5.feed
            com.urbanairship.android.layout.environment.ThomasForm$prepareSubmit$result$1$1 r2 = new com.urbanairship.android.layout.environment.ThomasForm$prepareSubmit$result$1$1
            r2.<init>()
            r5.update(r2)
            java.lang.Object r6 = r6.getOrThrow()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r5) goto L7c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L7c:
            if (r6 != r1) goto L7f
            return r1
        L7f:
            kotlin.Pair r6 = (kotlin.Pair) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.environment.ThomasForm.prepareSubmit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final <T extends ThomasFormField<?>> T inputData$urbanairship_layout_release(@NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return (T) ((State.Form) this.feed.getValue()).inputData$urbanairship_layout_release(identifier);
    }

    public static /* synthetic */ void updateFormInput$default(ThomasForm thomasForm, ThomasFormField thomasFormField, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        thomasForm.updateFormInput((ThomasFormField<?>) thomasFormField, str);
    }

    public final void updateFormInput(@NotNull ThomasFormField<?> value, @Nullable final String pageId) {
        Intrinsics.checkNotNullParameter(value, "value");
        updateFormInput(value, new Function0() { // from class: com.urbanairship.android.layout.environment.ThomasForm$updateFormInput$predicate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                State.Pager pager;
                String str = pageId;
                if (str == null) {
                    return Boolean.TRUE;
                }
                SharedState sharedState = this.pagerState;
                if (sharedState == null || (pager = (State.Pager) sharedState.getValue()) == null) {
                    return Boolean.TRUE;
                }
                String currentPageId = pager.getCurrentPageId();
                if (currentPageId == null) {
                    return Boolean.TRUE;
                }
                int iIndexOf = pager.getPageIds().indexOf(currentPageId);
                int iIndexOf2 = pager.getPageIds().indexOf(str);
                return Boolean.valueOf(iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf2 <= iIndexOf);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateFormInput$default(ThomasForm thomasForm, ThomasFormField thomasFormField, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        thomasForm.updateFormInput((ThomasFormField<?>) thomasFormField, (Function0<Boolean>) function0);
    }

    public final void updateFormInput(@NotNull final ThomasFormField<?> value, @Nullable final Function0<Boolean> predicate) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (((State.Form) this.feed.getChanges().getValue()).getIsSubmitted()) {
            return;
        }
        UALog.v("Updating field " + value, new Object[0]);
        this.feed.update(new Function1() { // from class: com.urbanairship.android.layout.environment.ThomasForm.updateFormInput.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Form invoke(State.Form it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copyWithFormInput(value, predicate);
            }
        });
        ThomasFormField.FieldType<?> fieldType$urbanairship_layout_release = value.getFieldType$urbanairship_layout_release();
        if (fieldType$urbanairship_layout_release instanceof ThomasFormField.FieldType.Async) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(fieldType$urbanairship_layout_release, this, null), 3, null);
        } else {
            boolean z = fieldType$urbanairship_layout_release instanceof ThomasFormField.FieldType.Instant;
        }
    }

    /* renamed from: com.urbanairship.android.layout.environment.ThomasForm$updateFormInput$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ThomasFormField.FieldType $method;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ThomasForm this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ThomasFormField.FieldType fieldType, ThomasForm thomasForm, Continuation continuation) {
            super(2, continuation);
            this.$method = fieldType;
            this.this$0 = thomasForm;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$method, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    ThomasFormField.AsyncValueFetcher fetcher = ((ThomasFormField.FieldType.Async) this.$method).getFetcher();
                    this.label = 1;
                    if (fetcher.fetch(coroutineScope, true, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.feed.update(new Function1() { // from class: com.urbanairship.android.layout.environment.ThomasForm.updateFormInput.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final State.Form invoke(State.Form it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return State.Form.copy$default(it, null, null, null, null, null, null, false, false, false, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
                    }
                });
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateWithDisplayState(@NotNull final String identifier, final boolean isDisplayed) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.feed.update(new Function1() { // from class: com.urbanairship.android.layout.environment.ThomasForm.updateWithDisplayState.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Form invoke(State.Form it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copyWithDisplayState(identifier, isDisplayed);
            }
        });
    }

    public final void displayReported() {
        this.feed.update(new Function1() { // from class: com.urbanairship.android.layout.environment.ThomasForm.displayReported.1
            @Override // kotlin.jvm.functions.Function1
            public final State.Form invoke(State.Form it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return State.Form.copy$default(it, null, null, null, null, null, null, false, false, true, null, 767, null);
            }
        });
    }

    public static /* synthetic */ void updateStatus$default(ThomasForm thomasForm, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        thomasForm.updateStatus(bool, bool2);
    }

    public final void updateStatus(@Nullable final Boolean isSubmitted, @Nullable final Boolean isEnabled) {
        this.feed.update(new Function1() { // from class: com.urbanairship.android.layout.environment.ThomasForm.updateStatus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Form invoke(State.Form it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ThomasFormStatus status = Intrinsics.areEqual(isSubmitted, Boolean.TRUE) ? ThomasFormStatus.SUBMITTED : it.getStatus();
                Boolean bool = isEnabled;
                return State.Form.copy$default(it, null, null, null, null, status, null, false, bool != null ? bool.booleanValue() : it.isEnabled(), false, null, 879, null);
            }
        });
    }
}
