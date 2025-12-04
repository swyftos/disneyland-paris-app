package com.urbanairship.android.layout.model;

import android.content.Context;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.ButtonLayoutInfo;
import com.urbanairship.android.layout.view.ButtonLayoutView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BO\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0012\u001a\u00020\u0013X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R!\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/urbanairship/android/layout/model/ButtonLayoutModel;", "Lcom/urbanairship/android/layout/model/ButtonModel;", "Lcom/urbanairship/android/layout/view/ButtonLayoutView;", "Lcom/urbanairship/android/layout/info/ButtonLayoutInfo;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/ButtonLayoutInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "isShrinkable", "", "isShrinkable$urbanairship_layout_release", "()Z", "setShrinkable$urbanairship_layout_release", "(Z)V", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "contentDescription", "", "context", "Landroid/content/Context;", "onCreateView", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "reportingDescription", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ButtonLayoutModel extends ButtonModel<ButtonLayoutView, ButtonLayoutInfo> {
    private boolean isShrinkable;
    private final BaseModel view;

    @NotNull
    public final BaseModel<?, ?, ?> getView() {
        return this.view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonLayoutModel(@NotNull ButtonLayoutInfo viewInfo, @NotNull BaseModel<?, ?, ?> view, @Nullable ThomasForm thomasForm, @Nullable SharedState<State.Pager> sharedState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, thomasForm, sharedState, environment, properties);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.view = view;
        this.isShrinkable = view.getIsShrinkable();
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    /* renamed from: isShrinkable$urbanairship_layout_release, reason: from getter */
    public boolean getIsShrinkable() {
        return this.isShrinkable;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void setShrinkable$urbanairship_layout_release(boolean z) {
        this.isShrinkable = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @Nullable
    public String contentDescription(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (String) ButtonLayoutModelKt.getContentDescriptionResolver((ButtonLayoutInfo) getViewInfo()).invoke(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbanairship.android.layout.model.ButtonModel
    @NotNull
    public String reportingDescription(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (String) ButtonLayoutModelKt.getReportingDescriptionResolver((ButtonLayoutInfo) getViewInfo()).invoke(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public ButtonLayoutView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        ButtonLayoutView buttonLayoutView = new ButtonLayoutView(context, this, viewEnvironment, itemProperties);
        buttonLayoutView.setId(getViewId());
        return buttonLayoutView;
    }
}
