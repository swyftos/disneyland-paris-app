package com.urbanairship.preferencecenter.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.dlp.BluetoothManager;
import com.urbanairship.preferencecenter.ui.item.AlertItem;
import com.urbanairship.preferencecenter.ui.item.SectionBreakItem;
import com.urbanairship.preferencecenter.ui.item.SectionItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/preferencecenter/widget/SectionDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "isAnimating", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "dividerHeight", "", "drawable", "Landroid/graphics/drawable/Drawable;", "unlabeledSectionPadding", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", BluetoothManager.BLE_STATUS_PARAM, "Landroidx/recyclerview/widget/RecyclerView$State;", "isSectionWithoutLabeledBreak", "onDrawOver", "c", "Landroid/graphics/Canvas;", "shouldDrawDividerBelow", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionDividerDecoration extends RecyclerView.ItemDecoration {
    private final int dividerHeight;
    private final Drawable drawable;
    private final Function0 isAnimating;
    private final int unlabeledSectionPadding;

    public SectionDividerDecoration(@NotNull Context context, @NotNull Function0<Boolean> isAnimating) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(isAnimating, "isAnimating");
        this.isAnimating = isAnimating;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dividerHorizontal, typedValue, true);
        Drawable drawable = ContextCompat.getDrawable(context, typedValue.resourceId);
        if (drawable != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "run(...)");
            this.drawable = drawable;
            this.unlabeledSectionPadding = context.getResources().getDimensionPixelSize(com.urbanairship.preferencecenter.R.dimen.ua_preference_center_unlabeled_section_item_top_padding);
            this.dividerHeight = drawable.getIntrinsicHeight();
            return;
        }
        throw new Resources.NotFoundException("Failed to resolve attr 'dividerHorizontal' from theme!");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (((Boolean) this.isAnimating.invoke()).booleanValue()) {
            return;
        }
        if (shouldDrawDividerBelow(view, parent)) {
            outRect.bottom = this.dividerHeight;
        } else if (isSectionWithoutLabeledBreak(view, parent)) {
            outRect.top = this.unlabeledSectionPadding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (((Boolean) this.isAnimating.invoke()).booleanValue()) {
            return;
        }
        int width = parent.getWidth();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (shouldDrawDividerBelow(childAt, parent)) {
                int y = (int) (childAt.getY() + childAt.getHeight());
                this.drawable.setBounds(0, y, width, this.dividerHeight + y);
                this.drawable.draw(c);
            }
        }
    }

    private final boolean shouldDrawDividerBelow(View view, RecyclerView parent) {
        RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(view);
        boolean z = ((childViewHolder instanceof SectionItem.ViewHolder) || (childViewHolder instanceof SectionBreakItem.ViewHolder)) ? false : true;
        int iIndexOfChild = parent.indexOfChild(view);
        if (iIndexOfChild >= parent.getChildCount() - 1) {
            return false;
        }
        RecyclerView.ViewHolder childViewHolder2 = parent.getChildViewHolder(parent.getChildAt(iIndexOfChild + 1));
        return (z && ((childViewHolder2 instanceof SectionItem.ViewHolder) || (childViewHolder2 instanceof SectionBreakItem.ViewHolder))) || (childViewHolder2 instanceof AlertItem.ViewHolder);
    }

    private final boolean isSectionWithoutLabeledBreak(View view, RecyclerView parent) {
        boolean z = parent.getChildViewHolder(view) instanceof SectionItem.ViewHolder;
        int iIndexOfChild = parent.indexOfChild(view);
        if (iIndexOfChild >= parent.getChildCount() || iIndexOfChild <= 0) {
            return false;
        }
        return z && !(parent.getChildViewHolder(parent.getChildAt(iIndexOfChild - 1)) instanceof SectionBreakItem.ViewHolder);
    }
}
