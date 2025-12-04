package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.AirshipCustomViewArguments;
import com.urbanairship.android.layout.AirshipCustomViewHandler;
import com.urbanairship.android.layout.AirshipCustomViewManager;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.CustomViewInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.android.layout.view.CustomView;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/model/CustomViewModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/CustomView;", "Lcom/urbanairship/android/layout/info/CustomViewInfo;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/CustomViewInfo;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "handler", "Lcom/urbanairship/android/layout/AirshipCustomViewHandler;", "getHandler", "()Lcom/urbanairship/android/layout/AirshipCustomViewHandler;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "tryInflateView", "Landroid/view/View;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomViewModel extends BaseModel<CustomView, CustomViewInfo, BaseModel.Listener> {
    private ItemProperties itemProperties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomViewModel(@NotNull CustomViewInfo viewInfo, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
    }

    private final AirshipCustomViewHandler getHandler() {
        return AirshipCustomViewManager.INSTANCE.get$urbanairship_layout_release(getViewInfo().getName());
    }

    @Nullable
    public final View tryInflateView(@NotNull Context context) {
        Size size;
        Size.Dimension height;
        Size size2;
        Size.Dimension width;
        Intrinsics.checkNotNullParameter(context, "context");
        String name = getViewInfo().getName();
        JsonMap properties = getViewInfo().getProperties();
        ItemProperties itemProperties = this.itemProperties;
        boolean zIsAuto = false;
        boolean zIsAuto2 = (itemProperties == null || (size2 = itemProperties.getSize()) == null || (width = size2.getWidth()) == null) ? false : width.isAuto();
        ItemProperties itemProperties2 = this.itemProperties;
        if (itemProperties2 != null && (size = itemProperties2.getSize()) != null && (height = size.getHeight()) != null) {
            zIsAuto = height.isAuto();
        }
        AirshipCustomViewArguments airshipCustomViewArguments = new AirshipCustomViewArguments(name, properties, new AirshipCustomViewArguments.SizeInfo(zIsAuto, zIsAuto2));
        AirshipCustomViewHandler handler = getHandler();
        if (handler != null) {
            return handler.onCreateView(context, airshipCustomViewArguments);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public CustomView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.itemProperties = itemProperties;
        CustomView customView = new CustomView(context, this);
        customView.setId(getViewId());
        return customView;
    }
}
