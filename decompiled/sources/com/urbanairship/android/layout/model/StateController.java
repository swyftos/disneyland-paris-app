package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.StateControllerInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B5\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R!\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/model/StateController;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Landroid/view/View;", "Lcom/urbanairship/android/layout/info/StateControllerInfo;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/AnyModel;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/StateControllerInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StateController extends BaseModel<View, StateControllerInfo, BaseModel.Listener> {
    private final BaseModel view;

    @NotNull
    public final BaseModel<?, ?, ?> getView() {
        return this.view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateController(@NotNull StateControllerInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.view = view;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    protected View onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        final JsonMap initialState = getViewInfo().getInitialState();
        if (initialState != null) {
            getEnvironment().getLayoutState().getLayout().update(new Function1() { // from class: com.urbanairship.android.layout.model.StateController$onCreateView$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final State.Layout invoke(State.Layout it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.copyWithState(initialState);
                }
            });
        }
        return this.view.createView(context, viewEnvironment, itemProperties);
    }
}
