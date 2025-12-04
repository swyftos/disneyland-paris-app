package com.urbanairship.android.layout.view;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.R;
import com.urbanairship.android.layout.info.PagerIndicatorInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.PagerIndicatorModel;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.widget.ShapeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/view/PagerIndicatorView;", "Landroid/widget/LinearLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/PagerIndicatorModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/PagerIndicatorModel;)V", "setCount", "", "count", "", "setPosition", ViewProps.POSITION, "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PagerIndicatorView extends LinearLayout implements BaseView {
    private final PagerIndicatorModel model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerIndicatorView(@NotNull Context context, @NotNull PagerIndicatorModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        setOrientation(0);
        setGravity(17);
        if (model.getAnnouncePage()) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            setImportantForAccessibility(1);
        }
        model.setListener$urbanairship_layout_release(new PagerIndicatorModel.Listener() { // from class: com.urbanairship.android.layout.view.PagerIndicatorView.1
            private int itemsCount;

            @Override // com.urbanairship.android.layout.model.PagerIndicatorModel.Listener
            public void onUpdate(int size, int position) {
                if (size != this.itemsCount) {
                    PagerIndicatorView.this.setCount(size);
                    this.itemsCount = size;
                }
                PagerIndicatorView.this.setPosition(position);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                PagerIndicatorView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                PagerIndicatorView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(PagerIndicatorView.this, old, background);
            }
        });
    }

    public final void setCount(int count) {
        removeAllViews();
        PagerIndicatorInfo.Bindings bindings = this.model.getViewInfo().getBindings();
        PagerIndicatorInfo.Binding selected = bindings.getSelected();
        PagerIndicatorInfo.Binding unselected = bindings.getUnselected();
        int iDpToPx = (int) ResourceUtils.dpToPx(getContext(), this.model.getViewInfo().getIndicatorSpacing());
        int i = (int) (iDpToPx / 2.0f);
        int i2 = 0;
        while (i2 < count) {
            ShapeView shapeView = new ShapeView(getContext(), selected.getShapes(), unselected.getShapes(), selected.getIcon(), unselected.getIcon());
            shapeView.setId(this.model.getIndicatorViewId(i2));
            shapeView.setAdjustViewBounds(true);
            shapeView.setFocusable(false);
            shapeView.setFocusableInTouchMode(false);
            shapeView.setImportantForAccessibility(2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(i2 == 0 ? iDpToPx : i);
            layoutParams.setMarginEnd(i2 == count + (-1) ? iDpToPx : i);
            addView(shapeView, layoutParams);
            i2++;
        }
    }

    public final void setPosition(int position) {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= childCount) {
                break;
            }
            KeyEvent.Callback childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.Checkable");
            Checkable checkable = (Checkable) childAt;
            if (i != position) {
                z = false;
            }
            checkable.setChecked(z);
            i++;
        }
        if (this.model.getAnnouncePage()) {
            String string = getContext().getString(R.string.ua_pager_progress, Integer.valueOf(position + 1), Integer.valueOf(getChildCount()));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            setContentDescription(string);
            announceForAccessibility(string);
        }
    }
}
