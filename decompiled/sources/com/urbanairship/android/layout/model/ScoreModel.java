package com.urbanairship.android.layout.model;

import android.content.Context;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.FormValidationMode;
import com.urbanairship.android.layout.info.ScoreInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.android.layout.view.ScoreView;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/model/ScoreModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/ScoreView;", "Lcom/urbanairship/android/layout/info/ScoreInfo;", "Lcom/urbanairship/android/layout/model/ScoreModel$Listener;", "viewInfo", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/ScoreInfo;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "valuesUpdate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "view", "onViewAttached$urbanairship_layout_release", "onViewCreated", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScoreModel extends BaseModel<ScoreView, ScoreInfo, Listener> {
    private final ThomasForm formState;
    private final MutableStateFlow valuesUpdate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreModel(@NotNull final ScoreInfo viewInfo, @NotNull ThomasForm formState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.formState = formState;
        this.valuesUpdate = StateFlowKt.MutableStateFlow(-1);
        formState.updateFormInput(new ThomasFormField.Score(viewInfo.getIdentifier(), null, ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, -1, new Function1() { // from class: com.urbanairship.android.layout.model.ScoreModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Boolean invoke(int i) {
                return Boolean.valueOf(i > 0 || !viewInfo.isRequired());
            }
        }, null, ThomasFormField.INSTANCE.makeAttributes(viewInfo.getAttributeName(), JsonValue.NULL), 4, null)), properties.getPagerPageId());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/ScoreModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "onSetSelectedScore", "", "value", "", "(Ljava/lang/Integer;)V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void onSetSelectedScore(@Nullable Integer value);

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public ScoreView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Integer originalValue;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        ScoreView scoreView = new ScoreView(context, this);
        scoreView.setId(getViewId());
        ThomasFormField.Score score = (ThomasFormField.Score) this.formState.inputData$urbanairship_layout_release(getViewInfo().getIdentifier());
        if (score != null && (originalValue = score.getOriginalValue()) != null) {
            scoreView.setSelectedScore(Integer.valueOf(originalValue.intValue()));
        }
        return scoreView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewCreated(@NotNull ScoreView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated((ScoreModel) view);
        onFormInputDisplayed(new C09511(null));
    }

    /* renamed from: com.urbanairship.android.layout.model.ScoreModel$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    static final class C09511 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        C09511(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09511 c09511 = ScoreModel.this.new C09511(continuation);
            c09511.Z$0 = ((Boolean) obj).booleanValue();
            return c09511;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((C09511) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ScoreModel.this.formState.updateWithDisplayState(ScoreModel.this.getViewInfo().getIdentifier(), this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull ScoreView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new ScoreModel$onViewAttached$1(view, this, null), 3, null);
        if (EventHandlerKt.hasTapHandler(getViewInfo().getEventHandlers())) {
            BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new ScoreModel$onViewAttached$2(view, this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new ScoreModel$onViewAttached$3(this, null), 3, null);
        if (this.formState.getValidationMode() == FormValidationMode.ON_DEMAND) {
            wireValidationActions(getViewInfo().getIdentifier(), this.formState, this.valuesUpdate.getValue(), this.valuesUpdate, getViewInfo());
        }
    }
}
