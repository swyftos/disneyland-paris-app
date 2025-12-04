package com.urbanairship.android.layout.shape;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.widget.ShapeDrawableWrapper;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import java.util.List;
import kotlin.jvm.functions.Function1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class Shape {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_CHECKED_STATE_SET = {-16842910, R.attr.state_checked};
    private static final int[] DISABLED_UNCHECKED_STATE_SET = {-16842910, -16842912};
    private static final int[] EMPTY_STATE_SET = StateSet.NOTHING;
    private final float aspectRatio;
    private final Border border;
    private final Color color;
    private final float scale;
    private final ShapeType type;

    public Shape(@NonNull ShapeType shapeType, float f, float f2, @Nullable Border border, @Nullable Color color) {
        this.type = shapeType;
        this.aspectRatio = f;
        this.scale = f2;
        this.border = border;
        this.color = color;
    }

    @NonNull
    public static Shape fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        return new Shape(ShapeType.from(jsonMap.opt("type").optString()), jsonMap.opt("aspect_ratio").getFloat(1.0f), jsonMap.opt("scale").getFloat(1.0f), Border.fromJson(jsonMap.opt("border").optMap()), Color.fromJsonField(jsonMap, "color"));
    }

    @NonNull
    public static StateListDrawable buildStateListDrawable(@NonNull Context context, @NonNull List<Shape> list, @NonNull List<Shape> list2, @Nullable Image.Icon icon, @Nullable Image.Icon icon2) {
        LayerDrawable layerDrawableBuildLayerDrawable = buildLayerDrawable(context, list, icon, true);
        LayerDrawable layerDrawableBuildLayerDrawable2 = buildLayerDrawable(context, list, icon, false);
        LayerDrawable layerDrawableBuildLayerDrawable3 = buildLayerDrawable(context, list2, icon2, true);
        LayerDrawable layerDrawableBuildLayerDrawable4 = buildLayerDrawable(context, list2, icon2, false);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(DISABLED_CHECKED_STATE_SET, layerDrawableBuildLayerDrawable2);
        stateListDrawable.addState(DISABLED_UNCHECKED_STATE_SET, layerDrawableBuildLayerDrawable4);
        stateListDrawable.addState(CHECKED_STATE_SET, layerDrawableBuildLayerDrawable);
        stateListDrawable.addState(EMPTY_STATE_SET, layerDrawableBuildLayerDrawable3);
        return stateListDrawable;
    }

    private static LayerDrawable buildLayerDrawable(Context context, List list, Image.Icon icon, boolean z) {
        int size = list.size() + (icon != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size];
        for (int i = 0; i < list.size(); i++) {
            drawableArr[i] = ((Shape) list.get(i)).getDrawable(context, z);
        }
        if (icon != null) {
            drawableArr[size - 1] = icon.getDrawable(context, z);
        }
        return new LayerDrawable(drawableArr);
    }

    @NonNull
    public Drawable getDrawable(@NonNull Context context) {
        return getDrawable(context, true);
    }

    @NonNull
    public Drawable getDrawable(@NonNull final Context context, boolean z) {
        Color color;
        Integer num;
        Color color2 = this.color;
        int iGenerateDisabledColor = 0;
        int iResolve = color2 != null ? color2.resolve(context) : 0;
        Border border = this.border;
        int iDpToPx = (border == null || (num = border.strokeWidth) == null) ? 0 : (int) ResourceUtils.dpToPx(context, num.intValue());
        Border border2 = this.border;
        if (border2 != null && (color = border2.strokeColor) != null) {
            iGenerateDisabledColor = color.resolve(context);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(this.type.getDrawableShapeType());
        if (!z) {
            iResolve = LayoutUtils.generateDisabledColor(iResolve);
        }
        gradientDrawable.setColor(iResolve);
        if (!z) {
            iGenerateDisabledColor = LayoutUtils.generateDisabledColor(iGenerateDisabledColor);
        }
        gradientDrawable.setStroke(iDpToPx, iGenerateDisabledColor);
        Border border3 = this.border;
        if (border3 != null) {
            float[] fArrRadii = border3.radii(new Function1() { // from class: com.urbanairship.android.layout.shape.Shape$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Shape.lambda$getDrawable$0(context, (Integer) obj);
                }
            });
            if (fArrRadii != null) {
                gradientDrawable.setCornerRadii(fArrRadii);
            }
        } else {
            gradientDrawable.setCornerRadius(BitmapDescriptorFactory.HUE_RED);
        }
        return new ShapeDrawableWrapper(gradientDrawable, this.aspectRatio, this.scale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float lambda$getDrawable$0(Context context, Integer num) {
        return Float.valueOf(ResourceUtils.dpToPx(context, num.intValue()));
    }

    @NonNull
    public ShapeType getType() {
        return this.type;
    }

    @Nullable
    public Border getBorder() {
        return this.border;
    }

    @Nullable
    public Color getColor() {
        return this.color;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getScale() {
        return this.scale;
    }
}
