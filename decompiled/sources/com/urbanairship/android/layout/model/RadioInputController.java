package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.FormValidationMode;
import com.urbanairship.android.layout.info.RadioInputControllerInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.json.JsonValue;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BK\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0002H\u0010¢\u0006\u0002\b!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/urbanairship/android/layout/model/RadioInputController;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Landroid/view/View;", "Lcom/urbanairship/android/layout/info/RadioInputControllerInfo;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/AnyModel;", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "radioState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Radio;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/RadioInputControllerInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "isValid", "", "selectedItem", "Lcom/urbanairship/json/JsonValue;", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "onViewAttached$urbanairship_layout_release", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRadioInputController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RadioInputController.kt\ncom/urbanairship/android/layout/model/RadioInputController\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,95:1\n49#2:96\n51#2:100\n46#3:97\n51#3:99\n105#4:98\n*S KotlinDebug\n*F\n+ 1 RadioInputController.kt\ncom/urbanairship/android/layout/model/RadioInputController\n*L\n46#1:96\n46#1:100\n46#1:97\n46#1:99\n46#1:98\n*E\n"})
/* loaded from: classes5.dex */
public final class RadioInputController extends BaseModel<View, RadioInputControllerInfo, BaseModel.Listener> {
    private final ThomasForm formState;
    private final SharedState radioState;
    private final BaseModel view;

    @NotNull
    public final BaseModel<?, ?, ?> getView() {
        return this.view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioInputController(@NotNull RadioInputControllerInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @NotNull ThomasForm formState, @NotNull SharedState<State.Radio> radioState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(radioState, "radioState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.view = view;
        this.formState = formState;
        this.radioState = radioState;
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass1(null), 3, null);
        if (formState.getValidationMode() == FormValidationMode.ON_DEMAND) {
            String identifier = viewInfo.getIdentifier();
            State.Radio.Selected selectedItem = radioState.getChanges().getValue().getSelectedItem();
            final StateFlow<State.Radio> changes = radioState.getChanges();
            wireValidationActions(identifier, formState, selectedItem, new Flow<State.Radio.Selected>() { // from class: com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RadioInputController.kt\ncom/urbanairship/android/layout/model/RadioInputController\n*L\n1#1,218:1\n50#2:219\n46#3:220\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1$2", f = "RadioInputController.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1$2$1, reason: invalid class name */
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
                            boolean r0 = r6 instanceof com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1$2$1
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
                            com.urbanairship.android.layout.environment.State$Radio r5 = (com.urbanairship.android.layout.environment.State.Radio) r5
                            com.urbanairship.android.layout.environment.State$Radio$Selected r5 = r5.getSelectedItem()
                            r0.label = r3
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L45
                            return r1
                        L45:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.RadioInputController$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super State.Radio.Selected> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = changes.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, viewInfo);
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.RadioInputController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RadioInputController.this.new AnonymousClass1(continuation);
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
                StateFlow<State.Form> formUpdates = RadioInputController.this.formState.getFormUpdates();
                final RadioInputController radioInputController = RadioInputController.this;
                FlowCollector<? super State.Form> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.RadioInputController.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(final State.Form form, Continuation continuation) {
                        radioInputController.radioState.update(new Function1() { // from class: com.urbanairship.android.layout.model.RadioInputController.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final State.Radio invoke(State.Radio it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return State.Radio.copy$default(it, null, null, form.isEnabled(), 3, null);
                            }
                        });
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

    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    protected View onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        return this.view.createView(context, viewEnvironment, itemProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(JsonValue selectedItem) {
        return ((selectedItem == null || selectedItem.isNull()) && getViewInfo().isRequired()) ? false : true;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewAttached$urbanairship_layout_release(view);
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new RadioInputController$onViewAttached$1(this, null), 3, null);
    }
}
