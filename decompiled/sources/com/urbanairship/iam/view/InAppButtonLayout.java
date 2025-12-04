package com.urbanairship.iam.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.automation.R;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageButtonLayoutType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0017B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/view/InAppButtonLayout;", "Lcom/urbanairship/iam/view/BoundedLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "defResStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "buttonClickListener", "Lcom/urbanairship/iam/view/InAppButtonLayout$ButtonClickListener;", "buttonLayoutResourceId", "separatedSpaceWidth", "stackedSpaceHeight", "setButtonClickListener", "", "setButtons", "layout", "Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "buttonInfos", "", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "ButtonClickListener", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppButtonLayout extends BoundedLinearLayout {
    private ButtonClickListener buttonClickListener;
    private int buttonLayoutResourceId;
    private int separatedSpaceWidth;
    private int stackedSpaceHeight;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/view/InAppButtonLayout$ButtonClickListener;", "", "onButtonClicked", "", "view", "Landroid/view/View;", "buttonInfo", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ButtonClickListener {
        void onButtonClicked(@NotNull View view, @NotNull InAppMessageButtonInfo buttonInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InAppButtonLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InAppButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InAppButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ InAppButtonLayout(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InAppButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.UrbanAirshipInAppButtonLayout, i, i2);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.stackedSpaceHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipInAppButtonLayout_urbanAirshipStackedSpaceHeight, 0);
            this.separatedSpaceWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipInAppButtonLayout_urbanAirshipSeparatedSpaceWidth, 0);
            this.buttonLayoutResourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.UrbanAirshipInAppButtonLayout_urbanAirshipButtonLayoutResourceId, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void setButtonClickListener(@Nullable ButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    public final void setButtons(@NotNull InAppMessageButtonLayoutType layout, @NotNull List<InAppMessageButtonInfo> buttonInfos) throws Resources.NotFoundException {
        int i;
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(buttonInfos, "buttonInfos");
        removeAllViews();
        setOrientation(layout == InAppMessageButtonLayoutType.STACKED ? 1 : 0);
        setMeasureWithLargestChildEnabled(true);
        int size = buttonInfos.size();
        int i2 = 0;
        while (i2 < size) {
            final InAppMessageButtonInfo inAppMessageButtonInfo = buttonInfos.get(i2);
            InAppMessageButtonLayoutType inAppMessageButtonLayoutType = InAppMessageButtonLayoutType.JOINED;
            if (layout != inAppMessageButtonLayoutType) {
                i = 15;
            } else if (i2 == 0) {
                i = 9;
            } else {
                i = i2 == buttonInfos.size() - 1 ? 6 : 0;
            }
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.buttonLayoutResourceId, (ViewGroup) this, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.Button");
            Button button = (Button) viewInflate;
            InAppViewUtils.INSTANCE.applyButtonInfo(button, inAppMessageButtonInfo, i);
            if (layout == InAppMessageButtonLayoutType.STACKED) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                button.setLayoutParams(layoutParams);
                if (i2 > 0) {
                    layoutParams.setMargins(0, this.stackedSpaceHeight, 0, 0);
                }
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                layoutParams2.weight = 1.0f;
                button.setLayoutParams(layoutParams2);
                if (layout != inAppMessageButtonLayoutType && i2 > 0) {
                    layoutParams2.setMargins(this.separatedSpaceWidth, 0, 0, 0);
                    layoutParams2.setMarginStart(this.separatedSpaceWidth);
                }
            }
            addView(button);
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.urbanairship.iam.view.InAppButtonLayout$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InAppButtonLayout.setButtons$lambda$0(this.f$0, inAppMessageButtonInfo, view);
                }
            });
            i2++;
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$0(InAppButtonLayout this$0, InAppMessageButtonInfo buttonInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(buttonInfo, "$buttonInfo");
        ButtonClickListener buttonClickListener = this$0.buttonClickListener;
        if (buttonClickListener != null) {
            Intrinsics.checkNotNull(view);
            buttonClickListener.onButtonClicked(view, buttonInfo);
        }
    }
}
