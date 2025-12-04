package com.urbanairship.android.layout.model;

import android.content.Context;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.CheckboxToggleLayoutInfo;
import com.urbanairship.android.layout.view.ToggleLayoutView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001BK\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u001b\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0010¢\u0006\u0002\b\u001bJ\u0016\u0010\u001c\u001a\u00020\u001a2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0014R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/model/CheckboxToggleLayoutModel;", "Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;", "Lcom/urbanairship/android/layout/view/ToggleLayoutView;", "Lcom/urbanairship/android/layout/info/CheckboxToggleLayoutInfo;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "checkboxState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Checkbox;", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/CheckboxToggleLayoutInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "onViewAttached$urbanairship_layout_release", "onViewCreated", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckboxToggleLayoutModel extends BaseToggleLayoutModel<ToggleLayoutView<CheckboxToggleLayoutModel>, CheckboxToggleLayoutInfo> {
    private final SharedState checkboxState;
    private final ThomasForm formState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckboxToggleLayoutModel(@NotNull CheckboxToggleLayoutInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @NotNull SharedState<State.Checkbox> checkboxState, @NotNull ThomasForm formState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, view, formState, environment, properties);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(checkboxState, "checkboxState");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.checkboxState = checkboxState;
        this.formState = formState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public ToggleLayoutView<CheckboxToggleLayoutModel> onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        ToggleLayoutView<CheckboxToggleLayoutModel> toggleLayoutView = new ToggleLayoutView<>(context, this, viewEnvironment, itemProperties);
        toggleLayoutView.setId(getViewId());
        return toggleLayoutView;
    }

    /* renamed from: com.urbanairship.android.layout.model.CheckboxToggleLayoutModel$onViewCreated$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = CheckboxToggleLayoutModel.this.new AnonymousClass1(continuation);
            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CheckboxToggleLayoutModel.this.formState.updateWithDisplayState(((State.Checkbox) CheckboxToggleLayoutModel.this.checkboxState.getValue()).getIdentifier(), this.Z$0);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewCreated(@NotNull ToggleLayoutView<CheckboxToggleLayoutModel> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated((CheckboxToggleLayoutModel) view);
        onFormInputDisplayed(new AnonymousClass1(null));
    }

    @Override // com.urbanairship.android.layout.model.BaseToggleLayoutModel, com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull ToggleLayoutView<CheckboxToggleLayoutModel> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewAttached$urbanairship_layout_release((CheckboxToggleLayoutModel) view);
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new CheckboxToggleLayoutModel$onViewAttached$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new CheckboxToggleLayoutModel$onViewAttached$2(this, null), 3, null);
    }
}
