package com.urbanairship.android.layout.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.ContainerLayoutItemInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.ContainerLayoutModel;
import com.urbanairship.android.layout.model.ItemProperties;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.util.ConstraintSetBuilder;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.widget.ClippableConstraintLayout;
import com.urbanairship.android.layout.widget.ShrinkableView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/view/ContainerLayoutView;", "Lcom/urbanairship/android/layout/widget/ClippableConstraintLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/ShrinkableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/ContainerLayoutModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/ContainerLayoutModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "frameMargins", "Landroid/util/SparseArray;", "Lcom/urbanairship/android/layout/property/Margin;", "frameShouldIgnoreSafeArea", "Landroid/util/SparseBooleanArray;", "addItem", "", "constraintBuilder", "Lcom/urbanairship/android/layout/util/ConstraintSetBuilder;", "item", "Lcom/urbanairship/android/layout/model/ContainerLayoutModel$Item;", "addItems", "items", "", "isShrinkable", "", "WindowInsetsListener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContainerLayoutView extends ClippableConstraintLayout implements BaseView, ShrinkableView {
    private final SparseArray frameMargins;
    private final SparseBooleanArray frameShouldIgnoreSafeArea;
    private final ContainerLayoutModel model;
    private final ViewEnvironment viewEnvironment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContainerLayoutView(@NotNull Context context, @NotNull ContainerLayoutModel model, @NotNull ViewEnvironment viewEnvironment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.model = model;
        this.viewEnvironment = viewEnvironment;
        this.frameShouldIgnoreSafeArea = new SparseBooleanArray();
        this.frameMargins = new SparseArray();
        setClipChildren(true);
        ConstraintSetBuilder constraintSetBuilderNewBuilder = ConstraintSetBuilder.newBuilder(context);
        Intrinsics.checkNotNullExpressionValue(constraintSetBuilderNewBuilder, "newBuilder(...)");
        addItems(model.getItems(), constraintSetBuilderNewBuilder);
        constraintSetBuilderNewBuilder.build().applyTo(this);
        ViewCompat.setOnApplyWindowInsetsListener(this, new WindowInsetsListener(this, constraintSetBuilderNewBuilder));
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.disableTransitionType(2);
        setLayoutTransition(layoutTransition);
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.ContainerLayoutView.2
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                ContainerLayoutView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                ContainerLayoutView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(ContainerLayoutView.this, old, background);
            }
        });
    }

    @Override // com.urbanairship.android.layout.widget.ShrinkableView
    public boolean isShrinkable() {
        return this.model.getIsShrinkable();
    }

    private final void addItems(List items, ConstraintSetBuilder constraintBuilder) {
        Iterator it = items.iterator();
        while (it.hasNext()) {
            addItem(constraintBuilder, (ContainerLayoutModel.Item) it.next());
        }
    }

    private final void addItem(ConstraintSetBuilder constraintBuilder, ContainerLayoutModel.Item item) {
        BaseModel<?, ?, ?> model = item.getModel();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View viewCreateView = model.createView(context, this.viewEnvironment, new ItemProperties(item.getInfo().getSize()));
        int iGenerateViewId = View.generateViewId();
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(iGenerateViewId);
        frameLayout.addView(viewCreateView, -1, -1);
        addView(frameLayout);
        ContainerLayoutItemInfo info = item.getInfo();
        constraintBuilder.position(info.getPosition(), iGenerateViewId).size(info.getSize(), iGenerateViewId).margin(info.getMargin(), iGenerateViewId);
        this.frameShouldIgnoreSafeArea.put(iGenerateViewId, info.getIgnoreSafeArea());
        SparseArray sparseArray = this.frameMargins;
        Margin margin = info.getMargin();
        if (margin == null) {
            margin = Margin.NONE;
        }
        sparseArray.put(iGenerateViewId, margin);
    }

    private final class WindowInsetsListener implements OnApplyWindowInsetsListener {
        private final ConstraintSetBuilder constraintBuilder;
        final /* synthetic */ ContainerLayoutView this$0;

        public WindowInsetsListener(ContainerLayoutView containerLayoutView, ConstraintSetBuilder constraintBuilder) {
            Intrinsics.checkNotNullParameter(constraintBuilder, "constraintBuilder");
            this.this$0 = containerLayoutView;
            this.constraintBuilder = constraintBuilder;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat windowInsets) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
            WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(v, windowInsets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
            Insets insets = windowInsetsCompatOnApplyWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            if (windowInsetsCompatOnApplyWindowInsets.isConsumed() || Intrinsics.areEqual(insets, Insets.NONE)) {
                WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
                Intrinsics.checkNotNullExpressionValue(CONSUMED, "CONSUMED");
                return CONSUMED;
            }
            int childCount = this.this$0.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = this.this$0.getChildAt(i);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) childAt;
                if (this.this$0.frameShouldIgnoreSafeArea.get(viewGroup.getId(), false)) {
                    ViewCompat.dispatchApplyWindowInsets(viewGroup, windowInsetsCompatOnApplyWindowInsets);
                } else {
                    ViewCompat.dispatchApplyWindowInsets(viewGroup, windowInsetsCompatOnApplyWindowInsets.inset(insets));
                    this.constraintBuilder.margin((Margin) this.this$0.frameMargins.get(viewGroup.getId()), insets, viewGroup.getId());
                    z = true;
                }
            }
            if (z) {
                this.constraintBuilder.build().applyTo(this.this$0);
            }
            WindowInsetsCompat windowInsetsCompatInset = windowInsetsCompatOnApplyWindowInsets.inset(insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatInset, "inset(...)");
            return windowInsetsCompatInset;
        }
    }
}
