package com.urbanairship.android.layout.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.CustomViewModel;
import com.urbanairship.android.layout.util.LayoutUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/view/CustomView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/CustomViewModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/CustomViewModel;)V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomView extends FrameLayout implements BaseView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomView(@NotNull Context context, @NotNull final CustomViewModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.CustomView.1
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                CustomView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                CustomView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(CustomView.this, old, background);
            }
        });
        View viewTryInflateView = model.tryInflateView(context);
        if (viewTryInflateView != null) {
            addView(viewTryInflateView);
        } else {
            addView(new View(context));
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.android.layout.view.CustomView.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No handler found for custom view: " + model.getViewInfo().getName();
                }
            }, 1, null);
        }
    }
}
