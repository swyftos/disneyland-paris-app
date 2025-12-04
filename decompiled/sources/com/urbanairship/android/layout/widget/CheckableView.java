package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.info.CheckableInfo;
import com.urbanairship.android.layout.model.CheckableModel;
import com.urbanairship.android.layout.property.CheckboxStyle;
import com.urbanairship.android.layout.property.SwitchStyle;
import com.urbanairship.android.layout.property.ToggleStyle;
import com.urbanairship.android.layout.property.ToggleType;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.view.BaseView;
import com.urbanairship.android.layout.widget.CheckableViewAdapter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u0000 0*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u00020\u00032\u00020\u0004:\u00010B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020#H\u0014J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0016H\u0014J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0004J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020-H\u0016R\u001e\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0007\u001a\u00028\u0000X\u0084\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Lcom/urbanairship/android/layout/widget/CheckableView;", "M", "Lcom/urbanairship/android/layout/model/CheckableModel;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/CheckableModel;)V", "checkableView", "Lcom/urbanairship/android/layout/widget/CheckableViewAdapter;", "getCheckableView", "()Lcom/urbanairship/android/layout/widget/CheckableViewAdapter;", "setCheckableView", "(Lcom/urbanairship/android/layout/widget/CheckableViewAdapter;)V", "checkedChangeListener", "Lcom/urbanairship/android/layout/widget/CheckableViewAdapter$OnCheckedChangeListener;", "getCheckedChangeListener", "()Lcom/urbanairship/android/layout/widget/CheckableViewAdapter$OnCheckedChangeListener;", "setCheckedChangeListener", "(Lcom/urbanairship/android/layout/widget/CheckableViewAdapter$OnCheckedChangeListener;)V", ViewProps.MIN_HEIGHT, "", "getMinHeight", "()I", ViewProps.MIN_WIDTH, "getMinWidth", "getModel", "()Lcom/urbanairship/android/layout/model/CheckableModel;", "Lcom/urbanairship/android/layout/model/CheckableModel;", "configureCheckbox", "", "style", "Lcom/urbanairship/android/layout/property/CheckboxStyle;", "configureSwitch", "Lcom/urbanairship/android/layout/property/SwitchStyle;", "createCheckboxView", "Lcom/urbanairship/android/layout/widget/ShapeButton;", "createSwitchView", "Landroidx/appcompat/widget/SwitchCompat;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCheckedInternal", "isChecked", "", "setEnabled", "isEnabled", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CheckableView<M extends CheckableModel<?, ?>> extends FrameLayout implements BaseView {
    public CheckableViewAdapter<?> checkableView;
    private CheckableViewAdapter.OnCheckedChangeListener checkedChangeListener;
    private final CheckableModel model;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleType.values().length];
            try {
                iArr[ToggleType.SWITCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleType.CHECKBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    protected final M getModel() {
        return (M) this.model;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckableView(@NotNull Context context, @NotNull M model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        int i = WhenMappings.$EnumSwitchMapping$0[((CheckableInfo) model.getViewInfo()).getStyle().getType().ordinal()];
        if (i == 1) {
            ToggleStyle style = ((CheckableInfo) model.getViewInfo()).getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.urbanairship.android.layout.property.SwitchStyle");
            configureSwitch((SwitchStyle) style);
        } else if (i == 2) {
            ToggleStyle style2 = ((CheckableInfo) model.getViewInfo()).getStyle();
            Intrinsics.checkNotNull(style2, "null cannot be cast to non-null type com.urbanairship.android.layout.property.CheckboxStyle");
            configureCheckbox((CheckboxStyle) style2);
        }
        String strContentDescription = model.contentDescription(context);
        if (strContentDescription != null) {
            StringExtensionsKt.ifNotEmpty(strContentDescription, new Function1() { // from class: com.urbanairship.android.layout.widget.CheckableView.1
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
                    CheckableView.this.setContentDescription(it);
                }
            });
        }
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.urbanairship.android.layout.widget.CheckableView.2

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.urbanairship.android.layout.widget.CheckableView$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ToggleType.values().length];
                    try {
                        iArr[ToggleType.CHECKBOX.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ToggleType.SWITCH.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                int i2 = WhenMappings.$EnumSwitchMapping$0[((CheckableInfo) CheckableView.this.getModel().getViewInfo()).getStyle().getType().ordinal()];
                if (i2 == 1) {
                    info.setClassName(CheckBox.class.getName());
                } else if (i2 == 2) {
                    info.setClassName(SwitchCompat.class.getName());
                }
                info.setCheckable(host.isEnabled());
                if (host.isEnabled()) {
                    info.setChecked(CheckableView.this.getCheckableView().isChecked());
                }
            }
        });
    }

    @Nullable
    public final CheckableViewAdapter.OnCheckedChangeListener getCheckedChangeListener() {
        return this.checkedChangeListener;
    }

    public final void setCheckedChangeListener(@Nullable CheckableViewAdapter.OnCheckedChangeListener onCheckedChangeListener) {
        this.checkedChangeListener = onCheckedChangeListener;
    }

    @NotNull
    public final CheckableViewAdapter<?> getCheckableView() {
        CheckableViewAdapter<?> checkableViewAdapter = this.checkableView;
        if (checkableViewAdapter != null) {
            return checkableViewAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("checkableView");
        return null;
    }

    public final void setCheckableView(@NotNull CheckableViewAdapter<?> checkableViewAdapter) {
        Intrinsics.checkNotNullParameter(checkableViewAdapter, "<set-?>");
        this.checkableView = checkableViewAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getMinWidth() {
        int i = WhenMappings.$EnumSwitchMapping$0[((CheckableInfo) this.model.getViewInfo()).getStyle().getType().ordinal()];
        if (i == 1) {
            return 48;
        }
        if (i == 2) {
            return 24;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getMinHeight() {
        int i = WhenMappings.$EnumSwitchMapping$0[((CheckableInfo) this.model.getViewInfo()).getStyle().getType().ordinal()];
        if (i == 1 || i == 2) {
            return 24;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int minWidth = getMinWidth();
        int minHeight = getMinHeight();
        if (minWidth == -1 && minHeight == -1) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (minWidth != -1) {
            int iDpToPx = (int) ResourceUtils.dpToPx(getContext(), minWidth);
            if (View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(iDpToPx, 1073741824);
            }
        }
        if (minHeight != -1) {
            int iDpToPx2 = (int) ResourceUtils.dpToPx(getContext(), minHeight);
            if (View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(iDpToPx2, 1073741824);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private final void configureSwitch(SwitchStyle style) {
        SwitchCompat switchCompatCreateSwitchView = createSwitchView(style);
        switchCompatCreateSwitchView.setId(this.model.getCheckableViewId());
        LayoutUtils.applySwitchStyle(switchCompatCreateSwitchView, style);
        setCheckableView(new CheckableViewAdapter.Switch(switchCompatCreateSwitchView));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = -3;
        addView(switchCompatCreateSwitchView, layoutParams);
    }

    private final void configureCheckbox(CheckboxStyle style) {
        ShapeButton shapeButtonCreateCheckboxView = createCheckboxView(style);
        shapeButtonCreateCheckboxView.setId(this.model.getCheckableViewId());
        setCheckableView(new CheckableViewAdapter.Checkbox(shapeButtonCreateCheckboxView));
        addView(shapeButtonCreateCheckboxView, -1, -1);
    }

    @NotNull
    protected SwitchCompat createSwitchView(@NotNull SwitchStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        return new SwitchCompat(getContext());
    }

    @NotNull
    protected ShapeButton createCheckboxView(@NotNull CheckboxStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        CheckboxStyle.Binding selected = style.getBindings().getSelected();
        Intrinsics.checkNotNullExpressionValue(selected, "getSelected(...)");
        CheckboxStyle.Binding unselected = style.getBindings().getUnselected();
        Intrinsics.checkNotNullExpressionValue(unselected, "getUnselected(...)");
        return new ShapeButton(getContext(), selected.getShapes(), unselected.getShapes(), selected.getIcon(), unselected.getIcon());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCheckedInternal(boolean isChecked) {
        getCheckableView().setOnCheckedChangeListener(null);
        getCheckableView().setChecked(isChecked);
        getCheckableView().setOnCheckedChangeListener(this.checkedChangeListener);
    }

    @Override // android.view.View
    public void setEnabled(boolean isEnabled) {
        getCheckableView().setEnabled(isEnabled);
    }
}
