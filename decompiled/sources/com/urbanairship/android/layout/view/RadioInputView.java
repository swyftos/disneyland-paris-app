package com.urbanairship.android.layout.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.CheckableModel;
import com.urbanairship.android.layout.model.RadioInputModel;
import com.urbanairship.android.layout.property.CheckboxStyle;
import com.urbanairship.android.layout.property.SwitchStyle;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.widget.CheckableView;
import com.urbanairship.android.layout.widget.CheckableViewAdapter;
import com.urbanairship.android.layout.widget.ShapeButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/view/RadioInputView;", "Lcom/urbanairship/android/layout/widget/CheckableView;", "Lcom/urbanairship/android/layout/model/RadioInputModel;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/RadioInputModel;)V", "createCheckboxView", "Lcom/urbanairship/android/layout/widget/ShapeButton;", "style", "Lcom/urbanairship/android/layout/property/CheckboxStyle;", "createSwitchView", "Landroidx/appcompat/widget/SwitchCompat;", "Lcom/urbanairship/android/layout/property/SwitchStyle;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RadioInputView extends CheckableView<RadioInputModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioInputView(@NotNull Context context, @NotNull RadioInputModel model) {
        super(context, model);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        final Drawable background = getBackground();
        model.setListener$urbanairship_layout_release(new CheckableModel.Listener() { // from class: com.urbanairship.android.layout.view.RadioInputView.1
            @Override // com.urbanairship.android.layout.model.CheckableModel.Listener
            public void setChecked(boolean checked) {
                RadioInputView.this.setCheckedInternal(checked);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                RadioInputView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                RadioInputView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background2) {
                Intrinsics.checkNotNullParameter(background2, "new");
                LayoutUtils.updateBackground(RadioInputView.this, background, old, background2);
            }
        });
        String strContentDescription = model.contentDescription(context);
        if (strContentDescription != null) {
            StringExtensionsKt.ifNotEmpty(strContentDescription, new Function1() { // from class: com.urbanairship.android.layout.view.RadioInputView.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    RadioInputView.this.setContentDescription(it);
                }
            });
        }
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.urbanairship.android.layout.view.RadioInputView.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setClassName(RadioButton.class.getName());
                info.setCheckable(host.isEnabled());
                if (host.isEnabled()) {
                    info.setChecked(RadioInputView.this.getCheckableView().isChecked());
                }
            }
        });
    }

    @Override // com.urbanairship.android.layout.widget.CheckableView
    @NotNull
    protected SwitchCompat createSwitchView(@NotNull SwitchStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        return new SwitchCompat(getContext()) { // from class: com.urbanairship.android.layout.view.RadioInputView.createSwitchView.1
            @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
            public void toggle() {
                CheckableViewAdapter.OnCheckedChangeListener checkedChangeListener = RadioInputView.this.getCheckedChangeListener();
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
        return new ShapeButton(getContext(), selected.getShapes(), unselected.getShapes(), selected.getIcon(), unselected.getIcon()) { // from class: com.urbanairship.android.layout.view.RadioInputView.createCheckboxView.1
            @Override // com.urbanairship.android.layout.widget.ShapeButton, android.widget.Checkable
            public void toggle() {
                CheckableViewAdapter.OnCheckedChangeListener checkedChangeListener = RadioInputView.this.getCheckedChangeListener();
                if (checkedChangeListener != null) {
                    checkedChangeListener.onCheckedChange(this, !isChecked());
                }
            }
        };
    }
}
