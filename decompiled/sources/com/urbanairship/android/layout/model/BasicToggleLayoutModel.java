package com.urbanairship.android.layout.model;

import android.content.Context;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.BasicToggleLayoutInfo;
import com.urbanairship.android.layout.info.FormValidationMode;
import com.urbanairship.android.layout.info.Validatable;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001B=\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u001b\u0010\u0016\u001a\u00020\u00172\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0010¢\u0006\u0002\b\u0018J\u0016\u0010\u0019\u001a\u00020\u00172\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/model/BasicToggleLayoutModel;", "Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;", "Lcom/urbanairship/android/layout/view/ToggleLayoutView;", "Lcom/urbanairship/android/layout/info/BasicToggleLayoutInfo;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/BasicToggleLayoutInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "onViewAttached$urbanairship_layout_release", "onViewCreated", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BasicToggleLayoutModel extends BaseToggleLayoutModel<ToggleLayoutView<BasicToggleLayoutModel>, BasicToggleLayoutInfo> {
    private final ThomasForm formState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicToggleLayoutModel(@NotNull BasicToggleLayoutInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @NotNull ThomasForm formState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, view, formState, environment, properties);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.formState = formState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public ToggleLayoutView<BasicToggleLayoutModel> onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        ToggleLayoutView<BasicToggleLayoutModel> toggleLayoutView = new ToggleLayoutView<>(context, this, viewEnvironment, itemProperties);
        toggleLayoutView.setId(getViewId());
        return toggleLayoutView;
    }

    /* renamed from: com.urbanairship.android.layout.model.BasicToggleLayoutModel$onViewCreated$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = BasicToggleLayoutModel.this.new AnonymousClass1(continuation);
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BasicToggleLayoutModel.this.formState.updateWithDisplayState(((BasicToggleLayoutInfo) BasicToggleLayoutModel.this.getViewInfo()).getIdentifier(), this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewCreated(@NotNull ToggleLayoutView<BasicToggleLayoutModel> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated((BasicToggleLayoutModel) view);
        onFormInputDisplayed(new AnonymousClass1(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbanairship.android.layout.model.BaseToggleLayoutModel, com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull ToggleLayoutView<BasicToggleLayoutModel> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewAttached$urbanairship_layout_release((BasicToggleLayoutModel) view);
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new BasicToggleLayoutModel$onViewAttached$1(this, null), 3, null);
        if (this.formState.getValidationMode() == FormValidationMode.ON_DEMAND) {
            wireValidationActions(((BasicToggleLayoutInfo) getViewInfo()).getIdentifier(), this.formState, isOn().getValue(), isOn(), (Validatable) getViewInfo());
        }
    }
}
