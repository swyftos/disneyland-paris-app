package com.urbanairship.android.layout.model;

import android.content.Context;
import android.os.Bundle;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.WebViewInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.view.WebViewView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\"\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0015\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/model/WebViewModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/WebViewView;", "Lcom/urbanairship/android/layout/info/WebViewInfo;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/WebViewInfo;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "savedState", "Landroid/os/Bundle;", "getSavedState", "()Landroid/os/Bundle;", "setSavedState", "(Landroid/os/Bundle;)V", "onClose", "", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "view", "onViewAttached$urbanairship_layout_release", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewModel extends BaseModel<WebViewView, WebViewInfo, BaseModel.Listener> {
    private Bundle savedState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewModel(@NotNull WebViewInfo viewInfo, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
    }

    @Nullable
    public final Bundle getSavedState() {
        return this.savedState;
    }

    public final void setSavedState(@Nullable Bundle bundle) {
        this.savedState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public WebViewView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        WebViewView webViewView = new WebViewView(context, this, viewEnvironment);
        webViewView.setId(getViewId());
        return webViewView;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull WebViewView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (EventHandlerKt.hasTapHandler(getViewInfo().getEventHandlers())) {
            BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new WebViewModel$onViewAttached$1(view, this, null), 3, null);
        }
    }

    public final void onClose() {
        ReportingEvent.DismissData.UserDismissed userDismissed = ReportingEvent.DismissData.UserDismissed.INSTANCE;
        Duration.Companion companion = Duration.INSTANCE;
        report(new ReportingEvent.Dismiss(userDismissed, DurationKt.toDuration(getEnvironment().getDisplayTimer().getTime(), DurationUnit.MILLISECONDS), LayoutState.reportingContext$default(getLayoutState(), null, null, null, 7, null), null));
        broadcast(LayoutEvent.Finish.INSTANCE);
    }
}
