package com.urbanairship.android.layout.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.VerticalScrollLayoutModel;
import com.urbanairship.android.layout.util.LayoutUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/view/VerticalScrollLayoutView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/VerticalScrollLayoutModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/VerticalScrollLayoutModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerticalScrollLayoutView extends NestedScrollView implements BaseView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollLayoutView(@NotNull Context context, @NotNull VerticalScrollLayoutModel model, @NotNull ViewEnvironment viewEnvironment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        setFillViewport(false);
        setClipToOutline(true);
        final View viewCreateView = model.getView().createView(context, viewEnvironment, null);
        new FrameLayout.LayoutParams(-1, -2);
        addView(viewCreateView);
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.VerticalScrollLayoutView.1
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                VerticalScrollLayoutView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                VerticalScrollLayoutView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(VerticalScrollLayoutView.this, old, background);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.view.VerticalScrollLayoutView$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return VerticalScrollLayoutView._init_$lambda$1(viewCreateView, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat _init_$lambda$1(View contentView, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return ViewCompat.dispatchApplyWindowInsets(contentView, insets);
    }
}
