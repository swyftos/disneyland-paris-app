package com.urbanairship.iam.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\tJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\r\u0010\u0018\u0012\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/urbanairship/iam/view/BackgroundDrawableBuilder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "color", "setPressedColor", "(I)Lcom/urbanairship/iam/view/BackgroundDrawableBuilder;", "setBackgroundColor", "", "dps", "borderRadiusFlag", "setBorderRadius", "(FI)Lcom/urbanairship/iam/view/BackgroundDrawableBuilder;", "setStrokeWidth", "strokeColor", "setStrokeColor", "Landroid/graphics/drawable/Drawable;", "build", "()Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", ViewProps.BACKGROUND_COLOR, "I", "Ljava/lang/Integer;", "pressedColor", "strokeWidthDps", "borderRadiusDps", "F", "getBorderRadiusFlag$annotations", "()V", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackgroundDrawableBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int backgroundColor;
    private float borderRadiusDps;
    private int borderRadiusFlag;
    private final Context context;
    private Integer pressedColor;
    private Integer strokeColor;
    private int strokeWidthDps;

    public /* synthetic */ BackgroundDrawableBuilder(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private BackgroundDrawableBuilder(Context context) {
        this.context = context;
    }

    @NotNull
    public final BackgroundDrawableBuilder setPressedColor(@ColorInt int color) {
        this.pressedColor = Integer.valueOf(color);
        return this;
    }

    @NotNull
    public final BackgroundDrawableBuilder setBackgroundColor(@ColorInt int color) {
        this.backgroundColor = color;
        return this;
    }

    @NotNull
    public final BackgroundDrawableBuilder setBorderRadius(float dps, int borderRadiusFlag) {
        this.borderRadiusFlag = borderRadiusFlag;
        this.borderRadiusDps = dps;
        return this;
    }

    @NotNull
    public final BackgroundDrawableBuilder setStrokeWidth(@Dimension(unit = 0) int dps) {
        this.strokeWidthDps = dps;
        return this;
    }

    @NotNull
    public final BackgroundDrawableBuilder setStrokeColor(@ColorInt int strokeColor) {
        this.strokeColor = Integer.valueOf(strokeColor);
        return this;
    }

    @NotNull
    public final Drawable build() {
        int iRound = Math.round(TypedValue.applyDimension(1, this.strokeWidthDps, this.context.getResources().getDisplayMetrics()));
        Integer num = this.strokeColor;
        int iIntValue = num != null ? num.intValue() : this.backgroundColor;
        float[] fArrCreateRadiiArray = BorderRadius.INSTANCE.createRadiiArray(TypedValue.applyDimension(1, this.borderRadiusDps, this.context.getResources().getDisplayMetrics()), this.borderRadiusFlag);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArrCreateRadiiArray);
        gradientDrawable.setColor(this.backgroundColor);
        gradientDrawable.setStroke(iRound, iIntValue);
        Integer num2 = this.pressedColor;
        if (num2 == null) {
            return gradientDrawable;
        }
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(num2.intValue());
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        return new RippleDrawable(colorStateListValueOf, gradientDrawable, new ShapeDrawable(new RoundRectShape(fArrCreateRadiiArray, null, null)));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/view/BackgroundDrawableBuilder$Companion;", "", "()V", "newBuilder", "Lcom/urbanairship/iam/view/BackgroundDrawableBuilder;", "context", "Landroid/content/Context;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final BackgroundDrawableBuilder newBuilder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new BackgroundDrawableBuilder(context, null);
        }
    }
}
