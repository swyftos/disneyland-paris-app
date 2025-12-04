package com.urbanairship.android.layout.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.SwitchCompat;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.CheckableModel;
import com.urbanairship.android.layout.model.CheckboxModel;
import com.urbanairship.android.layout.property.CheckboxStyle;
import com.urbanairship.android.layout.property.SwitchStyle;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.widget.CheckableView;
import com.urbanairship.android.layout.widget.CheckableViewAdapter;
import com.urbanairship.android.layout.widget.ShapeButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/view/CheckboxView;", "Lcom/urbanairship/android/layout/widget/CheckableView;", "Lcom/urbanairship/android/layout/model/CheckboxModel;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/CheckboxModel;)V", "createCheckboxView", "Lcom/urbanairship/android/layout/widget/ShapeButton;", "style", "Lcom/urbanairship/android/layout/property/CheckboxStyle;", "createSwitchView", "Landroidx/appcompat/widget/SwitchCompat;", "Lcom/urbanairship/android/layout/property/SwitchStyle;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckboxView extends CheckableView<CheckboxModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckboxView(@NotNull Context context, @NotNull CheckboxModel model) {
        super(context, model);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        final Drawable background = getBackground();
        model.setListener$urbanairship_layout_release(new CheckableModel.Listener() { // from class: com.urbanairship.android.layout.view.CheckboxView.1
            @Override // com.urbanairship.android.layout.model.CheckableModel.Listener
            public void setChecked(boolean checked) {
                CheckboxView.this.setCheckedInternal(checked);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                CheckboxView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                CheckboxView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background2) {
                Intrinsics.checkNotNullParameter(background2, "new");
                LayoutUtils.updateBackground(CheckboxView.this, background, old, background2);
            }
        });
    }

    @Override // com.urbanairship.android.layout.widget.CheckableView
    @NotNull
    protected SwitchCompat createSwitchView(@NotNull SwitchStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        return new SwitchCompat(getContext()) { // from class: com.urbanairship.android.layout.view.CheckboxView.createSwitchView.1
            @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
            public void toggle() {
                CheckableViewAdapter.OnCheckedChangeListener checkedChangeListener = CheckboxView.this.getCheckedChangeListener();
                if (checkedChangeListener != null) {
                    checkedChangeListener.onCheckedChange(this, !isChecked());
                }
            }
        };
    }

    @Override // com.urbanairship.android.layout.widget.CheckableView
    @NotNull
    protected ShapeButton createCheckboxView(@NotNull CheckboxStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        CheckboxStyle.Binding selected = style.getBindings().getSelected();
        Intrinsics.checkNotNullExpressionValue(selected, "getSelected(...)");
        CheckboxStyle.Binding unselected = style.getBindings().getUnselected();
        Intrinsics.checkNotNullExpressionValue(unselected, "getUnselected(...)");
        return new ShapeButton(getContext(), selected.getShapes(), unselected.getShapes(), selected.getIcon(), unselected.getIcon()) { // from class: com.urbanairship.android.layout.view.CheckboxView.createCheckboxView.1
            @Override // com.urbanairship.android.layout.widget.ShapeButton, android.widget.Checkable
            public void toggle() {
                CheckableViewAdapter.OnCheckedChangeListener checkedChangeListener = CheckboxView.this.getCheckedChangeListener();
                if (checkedChangeListener != null) {
                    checkedChangeListener.onCheckedChange(this, !isChecked());
                }
            }
        };
    }
}
