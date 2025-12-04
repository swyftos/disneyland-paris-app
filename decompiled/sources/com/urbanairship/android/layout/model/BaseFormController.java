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
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.FormInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EnableBehaviorTypeKt;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005B?\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/urbanairship/android/layout/model/BaseFormController;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "I", "Lcom/urbanairship/android/layout/info/FormInfo;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "parentFormState", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/FormInfo;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "isChildForm", "", "view", "Lcom/urbanairship/android/layout/model/AnyModel;", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "buildFormData", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/State$Form;", "handleFormUpdate", "", "handlePagerScroll", "initChildForm", "initParentForm", "wireFormValidation", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseFormController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFormController.kt\ncom/urbanairship/android/layout/model/BaseFormController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,221:1\n1#2:222\n*E\n"})
/* loaded from: classes5.dex */
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
            BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass2(null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass3(null), 3, null);
            onFormInputDisplayed(new AnonymousClass4(null));
            return;
        }
        throw new IllegalStateException("Child form requires parent form state!");
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(continuation);
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
                final Flow<LayoutEvent> layoutEvents = BaseFormController.this.getEnvironment().getLayoutEvents();
                final Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2", f = "BaseFormController.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.SubmitForm
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseFormController.kt\ncom/urbanairship/android/layout/model/BaseFormController$initChildForm$2\n*L\n1#1,218:1\n50#2:219\n86#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ BaseFormController this$0;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2", f = "BaseFormController.kt", i = {}, l = {220, 219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, BaseFormController baseFormController) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = baseFormController;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                            /*
                                r6 = this;
                                boolean r0 = r8 instanceof com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r8
                                com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r8)
                            L18:
                                java.lang.Object r8 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 2
                                r4 = 1
                                if (r2 == 0) goto L40
                                if (r2 == r4) goto L34
                                if (r2 != r3) goto L2c
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L70
                            L2c:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L34:
                                java.lang.Object r6 = r0.L$1
                                com.urbanairship.android.layout.environment.LayoutEvent$SubmitForm r6 = (com.urbanairship.android.layout.environment.LayoutEvent.SubmitForm) r6
                                java.lang.Object r7 = r0.L$0
                                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L5e
                            L40:
                                kotlin.ResultKt.throwOnFailure(r8)
                                kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                                com.urbanairship.android.layout.environment.LayoutEvent$SubmitForm r7 = (com.urbanairship.android.layout.environment.LayoutEvent.SubmitForm) r7
                                com.urbanairship.android.layout.model.BaseFormController r6 = r6.this$0
                                com.urbanairship.android.layout.environment.ThomasForm r6 = com.urbanairship.android.layout.model.BaseFormController.access$getFormState$p(r6)
                                r0.L$0 = r8
                                r0.L$1 = r7
                                r0.label = r4
                                java.lang.Object r6 = r6.prepareSubmit(r0)
                                if (r6 != r1) goto L5a
                                return r1
                            L5a:
                                r5 = r8
                                r8 = r6
                                r6 = r7
                                r7 = r5
                            L5e:
                                kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r8)
                                r8 = 0
                                r0.L$0 = r8
                                r0.L$1 = r8
                                r0.label = r3
                                java.lang.Object r6 = r7.emit(r6, r0)
                                if (r6 != r1) goto L70
                                return r1
                            L70:
                                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController$initChildForm$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Pair<? extends LayoutEvent.SubmitForm, ? extends Pair<? extends ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>>> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector, baseFormController), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                C00932 c00932 = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseFormController.initChildForm.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Pair pair, Continuation continuation) {
                        Object objInvoke;
                        return (((Pair) pair.component2()) == null || (objInvoke = ((LayoutEvent.SubmitForm) pair.component1()).getOnSubmitted().invoke(continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objInvoke;
                    }
                };
                this.label = 1;
                if (flowDistinctUntilChanged.collect(c00932, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initChildForm$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((AnonymousClass4) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
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
                final Flow<LayoutEvent> layoutEvents = BaseFormController.this.getEnvironment().getLayoutEvents();
                final Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "BaseFormController.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.SubmitForm
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseFormController.kt\ncom/urbanairship/android/layout/model/BaseFormController$initParentForm$1\n*L\n1#1,218:1\n50#2:219\n119#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ BaseFormController this$0;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2", f = "BaseFormController.kt", i = {}, l = {220, 219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, BaseFormController baseFormController) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = baseFormController;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                            /*
                                r6 = this;
                                boolean r0 = r8 instanceof com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r8
                                com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r8)
                            L18:
                                java.lang.Object r8 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 2
                                r4 = 1
                                if (r2 == 0) goto L40
                                if (r2 == r4) goto L34
                                if (r2 != r3) goto L2c
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L70
                            L2c:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L34:
                                java.lang.Object r6 = r0.L$1
                                com.urbanairship.android.layout.environment.LayoutEvent$SubmitForm r6 = (com.urbanairship.android.layout.environment.LayoutEvent.SubmitForm) r6
                                java.lang.Object r7 = r0.L$0
                                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L5e
                            L40:
                                kotlin.ResultKt.throwOnFailure(r8)
                                kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                                com.urbanairship.android.layout.environment.LayoutEvent$SubmitForm r7 = (com.urbanairship.android.layout.environment.LayoutEvent.SubmitForm) r7
                                com.urbanairship.android.layout.model.BaseFormController r6 = r6.this$0
                                com.urbanairship.android.layout.environment.ThomasForm r6 = com.urbanairship.android.layout.model.BaseFormController.access$getFormState$p(r6)
                                r0.L$0 = r8
                                r0.L$1 = r7
                                r0.label = r4
                                java.lang.Object r6 = r6.prepareSubmit(r0)
                                if (r6 != r1) goto L5a
                                return r1
                            L5a:
                                r5 = r8
                                r8 = r6
                                r6 = r7
                                r7 = r5
                            L5e:
                                kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r8)
                                r8 = 0
                                r0.L$0 = r8
                                r0.L$1 = r8
                                r0.label = r3
                                java.lang.Object r6 = r7.emit(r6, r0)
                                if (r6 != r1) goto L70
                                return r1
                            L70:
                                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController$initParentForm$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Pair<? extends LayoutEvent.SubmitForm, ? extends Pair<? extends ReportingEvent.FormResult, ? extends com.urbanairship.android.layout.reporting.FormInfo>>> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector, baseFormController), continuation);
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
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C09272(null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$initParentForm$2, reason: invalid class name and case insensitive filesystem */
    static final class C09272 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        C09272(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09272 c09272 = new C09272(continuation);
            c09272.L$0 = obj;
            return c09272;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09272) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            UALog.v("Skipped form display reporting! No inputs are currently displayed.", new Object[0]);
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

    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1, reason: invalid class name and case insensitive filesystem */
    static final class C09281 extends SuspendLambda implements Function2 {
        int label;

        C09281(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09281(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow<LayoutEvent> layoutEvents = BaseFormController.this.getEnvironment().getLayoutEvents();
                Flow<Object> flow = new Flow<Object>() { // from class: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,218:1\n18#2:219\n32#2:220\n19#2:221\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "BaseFormController.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1$2$1
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
                                boolean r6 = r5 instanceof com.urbanairship.android.layout.environment.LayoutEvent.ValidateForm
                                if (r6 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                C00941 c00941 = new C00941(BaseFormController.this);
                this.label = 1;
                if (flow.collect(c00941, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00941 implements FlowCollector {
            final /* synthetic */ BaseFormController this$0;

            C00941(BaseFormController baseFormController) {
                this.this$0 = baseFormController;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(com.urbanairship.android.layout.environment.LayoutEvent.ValidateForm r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1$emit$1 r0 = (com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1$emit$1 r0 = new com.urbanairship.android.layout.model.BaseFormController$wireFormValidation$1$1$emit$1
                    r0.<init>(r5, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3d
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L82
                L2c:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L34:
                    java.lang.Object r5 = r0.L$0
                    r6 = r5
                    com.urbanairship.android.layout.environment.LayoutEvent$ValidateForm r6 = (com.urbanairship.android.layout.environment.LayoutEvent.ValidateForm) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L6a
                L3d:
                    kotlin.ResultKt.throwOnFailure(r7)
                    com.urbanairship.android.layout.model.BaseFormController r7 = r5.this$0
                    com.urbanairship.android.layout.environment.ThomasForm r7 = com.urbanairship.android.layout.model.BaseFormController.access$getFormState$p(r7)
                    kotlinx.coroutines.flow.StateFlow r7 = r7.getFormUpdates()
                    java.lang.Object r7 = r7.getValue()
                    com.urbanairship.android.layout.environment.State$Form r7 = (com.urbanairship.android.layout.environment.State.Form) r7
                    boolean r7 = r7.getIsSubmitted()
                    if (r7 == 0) goto L59
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                L59:
                    com.urbanairship.android.layout.model.BaseFormController r5 = r5.this$0
                    com.urbanairship.android.layout.environment.ThomasForm r5 = com.urbanairship.android.layout.model.BaseFormController.access$getFormState$p(r5)
                    r0.L$0 = r6
                    r0.label = r4
                    java.lang.Object r7 = r5.validate(r0)
                    if (r7 != r1) goto L6a
                    return r1
                L6a:
                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                    boolean r5 = r7.booleanValue()
                    if (r5 == 0) goto L85
                    kotlin.jvm.functions.Function1 r5 = r6.getOnValidated()
                    r6 = 0
                    r0.L$0 = r6
                    r0.label = r3
                    java.lang.Object r5 = r5.invoke(r0)
                    if (r5 != r1) goto L82
                    return r1
                L82:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                L85:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController.C09281.C00941.emit(com.urbanairship.android.layout.environment.LayoutEvent$ValidateForm, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    private final void wireFormValidation() {
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C09281(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleFormUpdate(com.urbanairship.android.layout.environment.State.Form r8) {
        /*
            r7 = this;
            com.urbanairship.android.layout.info.View r0 = r7.getViewInfo()
            com.urbanairship.android.layout.info.FormInfo r0 = (com.urbanairship.android.layout.info.FormInfo) r0
            java.util.List r0 = r0.getFormEnabled()
            if (r0 != 0) goto Ld
            return
        Ld:
            com.urbanairship.android.layout.environment.ThomasForm r1 = r7.parentFormState
            r2 = 1
            if (r1 == 0) goto L17
            boolean r1 = r1.isEnabled()
            goto L18
        L17:
            r1 = r2
        L18:
            com.urbanairship.android.layout.property.EnableBehaviorType r3 = com.urbanairship.android.layout.property.EnableBehaviorType.FORM_VALIDATION
            boolean r3 = r0.contains(r3)
            com.urbanairship.android.layout.property.EnableBehaviorType r4 = com.urbanairship.android.layout.property.EnableBehaviorType.FORM_SUBMISSION
            boolean r0 = r0.contains(r4)
            r4 = 0
            if (r3 == 0) goto L32
            com.urbanairship.android.layout.environment.ThomasFormStatus r5 = r8.getStatus()
            com.urbanairship.android.layout.environment.ThomasFormStatus r6 = com.urbanairship.android.layout.environment.ThomasFormStatus.VALID
            if (r5 != r6) goto L30
            goto L32
        L30:
            r5 = r4
            goto L33
        L32:
            r5 = r2
        L33:
            if (r1 == 0) goto L58
            if (r0 == 0) goto L45
            if (r3 == 0) goto L45
            boolean r8 = r8.getIsSubmitted()
            if (r8 != 0) goto L43
            if (r5 == 0) goto L43
        L41:
            r5 = r2
            goto L55
        L43:
            r5 = r4
            goto L55
        L45:
            if (r0 == 0) goto L4e
            boolean r8 = r8.getIsSubmitted()
            if (r8 != 0) goto L43
            goto L41
        L4e:
            if (r3 == 0) goto L51
            goto L55
        L51:
            boolean r5 = r8.isEnabled()
        L55:
            if (r5 == 0) goto L58
            r4 = r2
        L58:
            com.urbanairship.android.layout.environment.ThomasForm r7 = r7.formState
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            r0 = 0
            com.urbanairship.android.layout.environment.ThomasForm.updateStatus$default(r7, r0, r8, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseFormController.handleFormUpdate(com.urbanairship.android.layout.environment.State$Form):void");
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
