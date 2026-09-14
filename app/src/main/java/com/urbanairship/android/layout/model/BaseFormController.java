package com.urbanairship.android.layout.model;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.dlp.BluetoothManager;
import com.urbanairship.UALog;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ThomasFormStatus;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.FormInfo;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EnableBehaviorTypeKt;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005B?\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, m1836d2 = {"Lcom/urbanairship/android/layout/model/BaseFormController;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "I", "Lcom/urbanairship/android/layout/info/FormInfo;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "parentFormState", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/FormInfo;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "isChildForm", "", "view", "Lcom/urbanairship/android/layout/model/AnyModel;", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "buildFormData", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/State$Form;", "handleFormUpdate", "", "handlePagerScroll", "initChildForm", "initParentForm", "wireFormValidation", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nBaseFormController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFormController.kt\ncom/urbanairship/android/layout/model/BaseFormController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,221:1\n1#2:222\n*E\n"})
public abstract class BaseFormController<T extends View, I extends FormInfo> extends BaseModel<T, I, BaseModel.Listener> {
    private final ThomasForm formState;
    private final boolean isChildForm;
    private final SharedState pagerState;
    private final ThomasForm parentFormState;

    @NotNull
    public abstract ThomasFormField.BaseForm buildFormData(@NotNull State.Form state);

    @NotNull
    public abstract BaseModel<?, ?, ?> getView();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFormController(@NotNull I viewInfo, @NotNull ThomasForm formState, @Nullable ThomasForm thomasForm, @Nullable SharedState<State.Pager> sharedState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.formState = formState;
        this.parentFormState = thomasForm;
        this.pagerState = sharedState;
        boolean z = viewInfo.getSubmitBehavior() == null;
        this.isChildForm = z;
        if (z) {
            initChildForm();
        } else {
            initParentForm();
        }
        List<EnableBehaviorType> formEnabled = viewInfo.getFormEnabled();
        if (formEnabled != null) {
            if (EnableBehaviorTypeKt.getHasPagerBehaviors(formEnabled)) {
                if (sharedState != null) {
                    BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new BaseFormController$1$2(this, null), 3, null);
                } else {
                    throw new IllegalStateException("Pager state is required for Forms with pager enable behaviors!");
                }
            }
            if (EnableBehaviorTypeKt.getHasFormBehaviors(formEnabled)) {
                BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new BaseFormController$1$3(this, null), 3, null);
            }
        }
        wireFormValidation();
    }

    private final void initChildForm() {
        if (this.parentFormState != null) {
            BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C47322(null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C47353(null), 3, null);
            onFormInputDisplayed(new C47364(null));
            return;
        }
        throw new IllegalStateException("Child form requires parent form state!");
    }

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2 */
    static final class C47322 extends SuspendLambda implements Function2 {
        int label;

        C47322(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C47322(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C47322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow<LayoutEvent> layoutEvents = BaseFormController.this.getEnvironment().getLayoutEvents();
                final Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1

                    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2", m1845f = "BaseFormController.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (obj instanceof LayoutEvent.SubmitForm) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final BaseFormController baseFormController = BaseFormController.this;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Pair<? extends LayoutEvent.SubmitForm, ? extends Pair<? extends ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>>>() { // from class: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseFormController.kt\ncom/urbanairship/android/layout/model/BaseFormController$initChildForm$2\n*L\n1#1,218:1\n50#2:219\n86#3:220\n*E\n"})
                    public static final class C47342<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ BaseFormController this$0;

                        /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2", m1845f = "BaseFormController.kt", m1846i = {}, m1847l = {220, 219}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                                return C47342.this.emit(null, this);
                            }
                        }

                        public C47342(FlowCollector flowCollector, BaseFormController baseFormController) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = baseFormController;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) throws Throwable {
                            AnonymousClass1 anonymousClass1;
                            LayoutEvent.SubmitForm submitForm;
                            FlowCollector flowCollector;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    submitForm = (LayoutEvent.SubmitForm) anonymousClass1.L$1;
                                    flowCollector = (FlowCollector) anonymousClass1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    if (i2 != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = this.$this_unsafeFlow;
                            LayoutEvent.SubmitForm submitForm2 = (LayoutEvent.SubmitForm) obj;
                            ThomasForm thomasForm = this.this$0.formState;
                            anonymousClass1.L$0 = flowCollector2;
                            anonymousClass1.L$1 = submitForm2;
                            anonymousClass1.label = 1;
                            Object objPrepareSubmit = thomasForm.prepareSubmit(anonymousClass1);
                            if (objPrepareSubmit == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = objPrepareSubmit;
                            submitForm = submitForm2;
                            flowCollector = flowCollector2;
                            Pair pairM1842to = TuplesKt.m1842to(submitForm, obj2);
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                            if (flowCollector.emit(pairM1842to, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Pair<? extends LayoutEvent.SubmitForm, ? extends Pair<? extends ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>>> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new C47342(flowCollector, baseFormController), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                AnonymousClass2 anonymousClass2 = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseFormController.initChildForm.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Pair pair, Continuation continuation) {
                        Object objInvoke;
                        return (((Pair) pair.component2()) == null || (objInvoke = ((LayoutEvent.SubmitForm) pair.component1()).getOnSubmitted().invoke(continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objInvoke;
                    }
                };
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
    }

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$3 */
    static final class C47353 extends SuspendLambda implements Function2 {
        int label;

        C47353(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C47353(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C47353) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<State.Form> formUpdates = BaseFormController.this.parentFormState.getFormUpdates();
                final BaseFormController baseFormController = BaseFormController.this;
                FlowCollector<? super State.Form> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseFormController.initChildForm.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(State.Form form, Continuation continuation) {
                        baseFormController.formState.updateStatus(form.getStatus().isSubmitted() ? Boxing.boxBoolean(true) : null, form.isEnabled() ? null : Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (formUpdates.collect(flowCollector, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$4 */
    static final class C47364 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        C47364(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C47364 c47364 = new C47364(continuation);
            c47364.Z$0 = ((Boolean) obj).booleanValue();
            return c47364;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((C47364) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BaseFormController.this.parentFormState.updateWithDisplayState(((FormInfo) BaseFormController.this.getViewInfo()).getIdentifier(), this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1 */
    static final class C47371 extends SuspendLambda implements Function2 {
        int label;

        C47371(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C47371(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C47371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow<LayoutEvent> layoutEvents = BaseFormController.this.getEnvironment().getLayoutEvents();
                final Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1

                    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2", m1845f = "BaseFormController.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (obj instanceof LayoutEvent.SubmitForm) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final BaseFormController baseFormController = BaseFormController.this;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Pair<? extends LayoutEvent.SubmitForm, ? extends Pair<? extends ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>>>() { // from class: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseFormController.kt\ncom/urbanairship/android/layout/model/BaseFormController$initParentForm$1\n*L\n1#1,218:1\n50#2:219\n119#3:220\n*E\n"})
                    public static final class C47392<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ BaseFormController this$0;

                        /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2", m1845f = "BaseFormController.kt", m1846i = {}, m1847l = {220, 219}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                                return C47392.this.emit(null, this);
                            }
                        }

                        public C47392(FlowCollector flowCollector, BaseFormController baseFormController) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = baseFormController;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) throws Throwable {
                            AnonymousClass1 anonymousClass1;
                            LayoutEvent.SubmitForm submitForm;
                            FlowCollector flowCollector;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    submitForm = (LayoutEvent.SubmitForm) anonymousClass1.L$1;
                                    flowCollector = (FlowCollector) anonymousClass1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    if (i2 != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = this.$this_unsafeFlow;
                            LayoutEvent.SubmitForm submitForm2 = (LayoutEvent.SubmitForm) obj;
                            ThomasForm thomasForm = this.this$0.formState;
                            anonymousClass1.L$0 = flowCollector2;
                            anonymousClass1.L$1 = submitForm2;
                            anonymousClass1.label = 1;
                            Object objPrepareSubmit = thomasForm.prepareSubmit(anonymousClass1);
                            if (objPrepareSubmit == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = objPrepareSubmit;
                            submitForm = submitForm2;
                            flowCollector = flowCollector2;
                            Pair pairM1842to = TuplesKt.m1842to(submitForm, obj2);
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                            if (flowCollector.emit(pairM1842to, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Pair<? extends LayoutEvent.SubmitForm, ? extends Pair<? extends ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>>> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new C47392(flowCollector, baseFormController), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                final BaseFormController baseFormController2 = BaseFormController.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseFormController.initParentForm.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Pair pair, Continuation continuation) {
                        LayoutEvent.SubmitForm submitForm = (LayoutEvent.SubmitForm) pair.component1();
                        Pair pair2 = (Pair) pair.component2();
                        if (pair2 != null) {
                            BaseFormController baseFormController3 = baseFormController2;
                            ReportingEvent.FormResult formResult = (ReportingEvent.FormResult) pair2.component1();
                            baseFormController3.report(ReportingEvent.FormResult.copy$default(formResult, null, LayoutState.reportingContext$default(baseFormController3.getLayoutState(), (com.urbanairship.android.layout.reporting.FormInfo) pair2.component2(), null, submitForm.getButtonIdentifier(), 2, null), null, null, 13, null));
                            baseFormController3.updateAttributes(formResult.getAttributes());
                            baseFormController3.registerChannels(formResult.getChannels());
                            Object objInvoke = submitForm.getOnSubmitted().invoke(continuation);
                            if (objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return objInvoke;
                            }
                        }
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

    private final void initParentForm() {
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C47371(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C47402(null), 3, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$2 */
    static final class C47402 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        C47402(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C47402 c47402 = new C47402(continuation);
            c47402.L$0 = obj;
            return c47402;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C47402) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                StateFlow<State.Form> formUpdates = BaseFormController.this.formState.getFormUpdates();
                final BaseFormController baseFormController = BaseFormController.this;
                FlowCollector<? super State.Form> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseFormController.initParentForm.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(State.Form form, Continuation continuation) {
                        if (form.isDisplayReported()) {
                            return Unit.INSTANCE;
                        }
                        if (!form.getDisplayedInputs().isEmpty()) {
                            com.urbanairship.android.layout.reporting.FormInfo formInfoReportingContext = form.reportingContext();
                            BaseFormController baseFormController2 = baseFormController;
                            String identifier = formInfoReportingContext.getIdentifier();
                            Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
                            String formType = formInfoReportingContext.getFormType();
                            Intrinsics.checkNotNullExpressionValue(formType, "getFormType(...)");
                            baseFormController2.report(new ReportingEvent.FormDisplay(new ReportingEvent.FormDisplayData(identifier, formType, formInfoReportingContext.getFormResponseType()), LayoutState.reportingContext$default(baseFormController.getLayoutState(), formInfoReportingContext, null, null, 6, null)));
                            baseFormController.formState.displayReported();
                            CoroutineScopeKt.cancel$default(coroutineScope, "Successfully reported form display.", null, 2, null);
                        } else {
                            UALog.m1751v("Skipped form display reporting! No inputs are currently displayed.", new Object[0]);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (formUpdates.collect(flowCollector, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1 */
    static final class C47411 extends SuspendLambda implements Function2 {
        int label;

        C47411(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C47411(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C47411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow<LayoutEvent> layoutEvents = BaseFormController.this.getEnvironment().getLayoutEvents();
                Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1

                    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2", m1845f = "BaseFormController.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (obj instanceof LayoutEvent.ValidateForm) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BaseFormController.this);
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1, reason: invalid class name */
        static final class AnonymousClass1 implements FlowCollector {
            final /* synthetic */ BaseFormController this$0;

            AnonymousClass1(BaseFormController baseFormController) {
                this.this$0 = baseFormController;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(LayoutEvent.ValidateForm validateForm, Continuation continuation) {
                BaseFormController$wireFormValidation$1$1$emit$1 baseFormController$wireFormValidation$1$1$emit$1;
                if (continuation instanceof BaseFormController$wireFormValidation$1$1$emit$1) {
                    baseFormController$wireFormValidation$1$1$emit$1 = (BaseFormController$wireFormValidation$1$1$emit$1) continuation;
                    int i = baseFormController$wireFormValidation$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        baseFormController$wireFormValidation$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        baseFormController$wireFormValidation$1$1$emit$1 = new BaseFormController$wireFormValidation$1$1$emit$1(this, continuation);
                    }
                } else {
                    baseFormController$wireFormValidation$1$1$emit$1 = new BaseFormController$wireFormValidation$1$1$emit$1(this, continuation);
                }
                Object objValidate = baseFormController$wireFormValidation$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = baseFormController$wireFormValidation$1$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objValidate);
                    if (!this.this$0.formState.getFormUpdates().getValue().getIsSubmitted()) {
                        ThomasForm thomasForm = this.this$0.formState;
                        baseFormController$wireFormValidation$1$1$emit$1.L$0 = validateForm;
                        baseFormController$wireFormValidation$1$1$emit$1.label = 1;
                        objValidate = thomasForm.validate(baseFormController$wireFormValidation$1$1$emit$1);
                        if (objValidate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i2 == 1) {
                        validateForm = (LayoutEvent.ValidateForm) baseFormController$wireFormValidation$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(objValidate);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objValidate);
                    }
                    return Unit.INSTANCE;
                }
                if (!((Boolean) objValidate).booleanValue()) {
                    return Unit.INSTANCE;
                }
                Function1<Continuation<? super Unit>, Object> onValidated = validateForm.getOnValidated();
                baseFormController$wireFormValidation$1$1$emit$1.L$0 = null;
                baseFormController$wireFormValidation$1$1$emit$1.label = 2;
                if (onValidated.invoke(baseFormController$wireFormValidation$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void wireFormValidation() {
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C47411(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    public final void handleFormUpdate(State.Form state) {
        List<EnableBehaviorType> formEnabled = getViewInfo().getFormEnabled();
        if (formEnabled == null) {
            return;
        }
        ThomasForm thomasForm = this.parentFormState;
        boolean zIsEnabled = thomasForm != null ? thomasForm.isEnabled() : true;
        boolean zContains = formEnabled.contains(EnableBehaviorType.FORM_VALIDATION);
        boolean zContains2 = formEnabled.contains(EnableBehaviorType.FORM_SUBMISSION);
        boolean z = false;
        boolean zIsEnabled2 = !zContains || state.getStatus() == ThomasFormStatus.VALID;
        if (zIsEnabled) {
            if (zContains2 && zContains) {
                if (state.getIsSubmitted() || !zIsEnabled2) {
                    zIsEnabled2 = false;
                } else {
                    zIsEnabled2 = true;
                }
            } else if (zContains2) {
                if (state.getIsSubmitted()) {
                    zIsEnabled2 = false;
                } else {
                    zIsEnabled2 = true;
                }
            } else if (!zContains) {
                zIsEnabled2 = state.isEnabled();
            }
            if (zIsEnabled2) {
                z = true;
            }
        }
        ThomasForm.updateStatus$default(this.formState, null, Boolean.valueOf(z), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePagerScroll(State.Pager state) {
        List<EnableBehaviorType> formEnabled;
        if (state.isScrollDisabled() || (formEnabled = getViewInfo().getFormEnabled()) == null) {
            return;
        }
        ThomasForm thomasForm = this.parentFormState;
        boolean zIsEnabled = thomasForm != null ? thomasForm.isEnabled() : true;
        boolean zContains = formEnabled.contains(EnableBehaviorType.PAGER_NEXT);
        boolean zContains2 = formEnabled.contains(EnableBehaviorType.PAGER_PREVIOUS);
        ThomasForm.updateStatus$default(this.formState, null, Boolean.valueOf((zIsEnabled && zContains && zContains2 && (state.getHasNext() || state.getHasPrevious())) || (zContains && state.getHasNext()) || (zContains2 && state.getHasPrevious())), 1, null);
    }
}
