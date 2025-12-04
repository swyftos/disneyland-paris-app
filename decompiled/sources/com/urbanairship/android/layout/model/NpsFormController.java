package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import com.dlp.BluetoothManager;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.NpsFormControllerInfo;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BW\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014R$\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/model/NpsFormController;", "Lcom/urbanairship/android/layout/model/BaseFormController;", "Landroid/view/View;", "Lcom/urbanairship/android/layout/info/NpsFormControllerInfo;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "parentForm", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/NpsFormControllerInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "buildFormData", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Nps;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/State$Form;", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NpsFormController extends BaseFormController<View, NpsFormControllerInfo> {
    private final BaseModel view;

    @Override // com.urbanairship.android.layout.model.BaseFormController
    @NotNull
    public BaseModel<?, ?, ?> getView() {
        return this.view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NpsFormController(@NotNull NpsFormControllerInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @NotNull ThomasForm formState, @Nullable ThomasForm thomasForm, @Nullable SharedState<State.Pager> sharedState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, formState, thomasForm, sharedState, environment, properties);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.view = view;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    protected View onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        return getView().createView(context, viewEnvironment, itemProperties);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbanairship.android.layout.model.BaseFormController
    @NotNull
    public ThomasFormField.Nps buildFormData(@NotNull State.Form state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new ThomasFormField.Nps(((NpsFormControllerInfo) getViewInfo()).getIdentifier(), ((NpsFormControllerInfo) getViewInfo()).getNpsIdentifier(), ((NpsFormControllerInfo) getViewInfo()).getResponseType(), CollectionsKt.toSet(state.getFilteredFields().values()), ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, SetsKt.emptySet(), null, null, null, 14, null));
    }
}
