package com.urbanairship.android.layout.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.urbanairship.Fonts;
import com.urbanairship.android.layout.info.BaseToggleLayoutInfo;
import com.urbanairship.android.layout.info.ButtonLayoutInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.ButtonLayoutModel;
import com.urbanairship.android.layout.model.LabelModel;
import com.urbanairship.android.layout.model.TextInputModel;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.FormInputType;
import com.urbanairship.android.layout.property.MarkdownOptions;
import com.urbanairship.android.layout.property.MarkdownOptionsKt;
import com.urbanairship.android.layout.property.SwitchStyle;
import com.urbanairship.android.layout.property.TapEffect;
import com.urbanairship.android.layout.property.TextAlignment;
import com.urbanairship.android.layout.property.TextAppearance;
import com.urbanairship.android.layout.property.TextStyle;
import com.urbanairship.android.layout.widget.Clippable;
import com.urbanairship.util.UAStringUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class LayoutUtils {
    public static final int DEFAULT_BORDER_RADIUS = 0;
    public static final int DEFAULT_STROKE_WIDTH_DPS = 2;
    public static final float HOVERED_ALPHA_PERCENT = 0.1f;
    public static final float PRESSED_ALPHA_PERCENT = 0.2f;

    public static void updateBackground(@NonNull View view, @Nullable Drawable drawable, @Nullable Background background, @NonNull Background background2) {
        if (background != null && background.getBorder() != null && background.getBorder().strokeWidth != null) {
            removePadding(view, dpToPx(view.getContext(), background.getBorder().strokeWidth.intValue()));
        }
        applyBorderAndBackground(view, drawable, background2.getBorder(), background2.getColor());
    }

    public static void updateBackground(@NonNull View view, @Nullable Background background, @NonNull Background background2) {
        updateBackground(view, null, background, background2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void applyBorderAndBackground(@NonNull View view, @Nullable Drawable drawable, @Nullable Border border, @Nullable Color color) {
        int i;
        final Context context = view.getContext();
        if (border == null) {
            if (color != null) {
                applyBackgrounds(view, drawable, new ColorDrawable(color.resolve(context)));
                return;
            }
            return;
        }
        ShapeAppearanceModel.Builder builder = ShapeAppearanceModel.builder();
        border.applyToShape(builder, new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LayoutUtils.lambda$applyBorderAndBackground$0(context, (Integer) obj);
            }
        });
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(builder.build());
        if (view instanceof Clippable) {
            border.applyToClippable((Clippable) view, new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LayoutUtils.lambda$applyBorderAndBackground$1(context, (Integer) obj);
                }
            });
        }
        Integer num = border.strokeWidth;
        if (num != null) {
            float fDpToPx = dpToPx(context, num.intValue());
            materialShapeDrawable.setStrokeWidth(fDpToPx);
            i = (int) fDpToPx;
        } else {
            i = -1;
        }
        Color color2 = border.strokeColor;
        if (color2 != null) {
            int iResolve = color2.resolve(context);
            materialShapeDrawable.setStrokeColor(new ColorStateListBuilder().add(generateDisabledColor(iResolve), -16842910).add(iResolve).build());
        }
        int iResolve2 = color != null ? color.resolve(context) : 0;
        materialShapeDrawable.setFillColor(new ColorStateListBuilder().add(generateDisabledColor(iResolve2), -16842910).add(iResolve2).build());
        applyBackgrounds(view, drawable, materialShapeDrawable);
        if (i > -1) {
            addPadding(view, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$applyBorderAndBackground$0(Context context, Integer num) {
        return Integer.valueOf(dpToPx(context, num.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float lambda$applyBorderAndBackground$1(Context context, Integer num) {
        return Float.valueOf(ResourceUtils.dpToPx(context, num.intValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void applyMediaVideoBorderAndBackground(@NonNull View view, @Nullable Drawable drawable, @Nullable Border border, @Nullable Color color) {
        int i;
        final Context context = view.getContext();
        if (border == null) {
            if (color != null) {
                applyBackgrounds(view, drawable, new ColorDrawable(color.resolve(context)));
                return;
            }
            return;
        }
        ShapeAppearanceModel.Builder builder = ShapeAppearanceModel.builder();
        border.applyToShape(builder, new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LayoutUtils.lambda$applyMediaVideoBorderAndBackground$2(context, (Integer) obj);
            }
        });
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(builder.build());
        if (view instanceof Clippable) {
            border.applyToClippable((Clippable) view, new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LayoutUtils.lambda$applyMediaVideoBorderAndBackground$3(context, (Integer) obj);
                }
            });
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(builder.build());
        materialShapeDrawable2.setFillColor(new ColorStateListBuilder().add(0).build());
        Integer num = border.strokeWidth;
        if (num != null) {
            float fDpToPx = dpToPx(context, num.intValue());
            materialShapeDrawable2.setStrokeWidth(fDpToPx);
            i = (int) fDpToPx;
        } else {
            i = -1;
        }
        Color color2 = border.strokeColor;
        if (color2 != null) {
            int iResolve = color2.resolve(context);
            materialShapeDrawable2.setStrokeColor(new ColorStateListBuilder().add(generateDisabledColor(iResolve), -16842910).add(iResolve).build());
        }
        int iResolve2 = color != null ? color.resolve(context) : 0;
        materialShapeDrawable.setFillColor(new ColorStateListBuilder().add(generateDisabledColor(iResolve2), -16842910).add(iResolve2).build());
        applyBackgrounds(view, drawable, materialShapeDrawable);
        view.setForeground(materialShapeDrawable2);
        if (i > -1) {
            addPadding(view, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$applyMediaVideoBorderAndBackground$2(Context context, Integer num) {
        return Integer.valueOf(dpToPx(context, num.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float lambda$applyMediaVideoBorderAndBackground$3(Context context, Integer num) {
        return Float.valueOf(ResourceUtils.dpToPx(context, num.intValue()));
    }

    public static void applyMediaImageBorderAndBackground(@NonNull ShapeableImageView shapeableImageView, @Nullable Drawable drawable, @Nullable Border border, @Nullable Color color) {
        final Context context = shapeableImageView.getContext();
        if (border == null) {
            if (color != null) {
                applyBackgrounds(shapeableImageView, drawable, new ColorDrawable(color.resolve(context)));
                return;
            }
            return;
        }
        ShapeAppearanceModel.Builder builder = ShapeAppearanceModel.builder();
        border.applyToShape(builder, new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LayoutUtils.lambda$applyMediaImageBorderAndBackground$4(context, (Integer) obj);
            }
        });
        if (border.strokeWidth != null) {
            shapeableImageView.setStrokeWidth(dpToPx(context, r1.intValue()));
        }
        Color color2 = border.strokeColor;
        if (color2 != null) {
            int iResolve = color2.resolve(context);
            shapeableImageView.setStrokeColor(new ColorStateListBuilder().add(generateDisabledColor(iResolve), -16842910).add(iResolve).build());
        }
        shapeableImageView.setBackgroundColor(color != null ? color.resolve(context) : 0);
        shapeableImageView.setShapeAppearanceModel(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$applyMediaImageBorderAndBackground$4(Context context, Integer num) {
        return Integer.valueOf(dpToPx(context, num.intValue()));
    }

    private static void applyBackgrounds(View view, Drawable drawable, Drawable drawable2) {
        if (drawable != null) {
            drawable2 = new LayerDrawable(new Drawable[]{drawable, drawable2});
        }
        view.setBackground(drawable2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void applyButtonLayoutModel(@NonNull final FrameLayout frameLayout, @NonNull ButtonLayoutModel buttonLayoutModel) {
        float[] fArrRadii;
        TapEffect tapEffect = ((ButtonLayoutInfo) buttonLayoutModel.getViewInfo()).getTapEffect();
        if (tapEffect instanceof TapEffect.Default) {
            Border border = ((ButtonLayoutInfo) buttonLayoutModel.getViewInfo()).getBorder();
            if (border == null || (fArrRadii = border.radii(new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LayoutUtils.lambda$applyButtonLayoutModel$5(frameLayout, (Integer) obj);
                }
            })) == null) {
                return;
            }
            applyRippleEffect(frameLayout, fArrRadii);
            return;
        }
        if (tapEffect instanceof TapEffect.None) {
            frameLayout.setForeground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float lambda$applyButtonLayoutModel$5(FrameLayout frameLayout, Integer num) {
        return Float.valueOf(ResourceUtils.dpToPx(frameLayout.getContext(), num.intValue()));
    }

    public static void applyToggleLayoutRippleEffect(@NonNull final FrameLayout frameLayout, @NonNull BaseToggleLayoutInfo baseToggleLayoutInfo) {
        float[] fArrRadii;
        Border border = baseToggleLayoutInfo.getBorder();
        if (border == null) {
            fArrRadii = new float[8];
            Arrays.fill(fArrRadii, dpToPx(frameLayout.getContext(), 0));
        } else {
            fArrRadii = border.radii(new Function1() { // from class: com.urbanairship.android.layout.util.LayoutUtils$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LayoutUtils.lambda$applyToggleLayoutRippleEffect$6(frameLayout, (Integer) obj);
                }
            });
        }
        if (fArrRadii == null) {
            return;
        }
        applyRippleEffect(frameLayout, fArrRadii);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float lambda$applyToggleLayoutRippleEffect$6(FrameLayout frameLayout, Integer num) {
        return Float.valueOf(ResourceUtils.dpToPx(frameLayout.getContext(), num.intValue()));
    }

    private static RippleDrawable generateRippleDrawable(Context context, float[] fArr) {
        return new RippleDrawable(MaterialColors.getColorStateList(context, R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new ShapeDrawable(new RoundRectShape(fArr, null, null)));
    }

    private static void applyRippleEffect(FrameLayout frameLayout, float[] fArr) {
        frameLayout.setForeground(generateRippleDrawable(frameLayout.getContext(), fArr));
    }

    public static void applyImageButtonRippleAndTint(@NonNull ImageButton imageButton, @Nullable Integer num) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, num == null ? BitmapDescriptorFactory.HUE_RED : dpToPx(imageButton.getContext(), num.intValue()));
        applyImageButtonRippleAndTint(imageButton, fArr);
    }

    public static void applyImageButtonRippleAndTint(@NonNull ImageButton imageButton, @Nullable float[] fArr) {
        applyImageButtonRippleAndTintApi23(imageButton, fArr);
    }

    private static void applyImageButtonRippleAndTintApi23(ImageButton imageButton, float[] fArr) {
        imageButton.setForeground(generateRippleDrawable(imageButton.getContext(), fArr));
        imageButton.setImageTintMode(PorterDuff.Mode.SRC_ATOP);
        imageButton.setImageTintList(new ColorStateListBuilder().add(generateDisabledColor(0), -16842910).add(0).build());
    }

    public static void applyLabelModel(@NonNull TextView textView, @NonNull LabelModel labelModel, @NonNull String str) {
        boolean z;
        TextAppearance textAppearance = labelModel.getViewInfo().getTextAppearance();
        applyTextAppearance(textView, textAppearance);
        Fonts fontsShared = Fonts.shared(textView.getContext());
        Iterator<String> it = textAppearance.getFontFamilies().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (!fontsShared.isSystemFont(it.next())) {
                z = true;
                break;
            }
        }
        boolean zContains = textAppearance.getTextStyles().contains(TextStyle.ITALIC);
        if (z && zContains) {
            str = str + " ";
        } else if (z || zContains) {
            str = str + " ";
        }
        Context context = textView.getContext();
        MarkdownOptions markdownOptions = labelModel.getViewInfo().getMarkdownOptions();
        if (MarkdownOptionsKt.isEnabled(markdownOptions)) {
            ViewExtensionsKt.setHtml(textView, Html.fromHtml(StringExtensionsKt.markdownToHtml(str)), MarkdownOptionsKt.getUnderlineLinks(markdownOptions), MarkdownOptionsKt.resolvedLinkColor(markdownOptions, context));
            return;
        }
        textView.setText(str);
    }

    public static void applyTextInputModel(@NonNull AppCompatEditText appCompatEditText, @NonNull TextInputModel textInputModel) {
        applyTextAppearance(appCompatEditText, textInputModel.getViewInfo().getTextAppearance());
        int iDpToPx = dpToPx(appCompatEditText.getContext(), 8);
        appCompatEditText.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        appCompatEditText.setInputType(textInputModel.getViewInfo().getInputType().getTypeMask());
        FormInputType inputType = textInputModel.getViewInfo().getInputType();
        FormInputType formInputType = FormInputType.TEXT_MULTILINE;
        appCompatEditText.setSingleLine(inputType != formInputType);
        appCompatEditText.setGravity(appCompatEditText.getGravity() | (textInputModel.getViewInfo().getInputType() != formInputType ? 16 : 48));
        if (UAStringUtil.isEmpty(textInputModel.getViewInfo().getHintText())) {
            return;
        }
        appCompatEditText.setHint(textInputModel.getViewInfo().getHintText());
        Color hintColor = textInputModel.getViewInfo().getTextAppearance().getHintColor();
        if (hintColor != null) {
            appCompatEditText.setHintTextColor(hintColor.resolve(appCompatEditText.getContext()));
        }
    }

    public static void applyTextAppearance(@NonNull TextView textView, @NonNull TextAppearance textAppearance) {
        Context context = textView.getContext();
        textView.setTextSize(textAppearance.getFontSize());
        int iResolve = textAppearance.getColor().resolve(context);
        int i = 0;
        textView.setTextColor(new ColorStateListBuilder().add(generateDisabledColor(0, iResolve), -16842910).add(iResolve).build());
        Iterator<TextStyle> it = textAppearance.getTextStyles().iterator();
        int i2 = TsExtractor.TS_STREAM_TYPE_AC3;
        while (it.hasNext()) {
            int i3 = AnonymousClass2.$SwitchMap$com$urbanairship$android$layout$property$TextStyle[it.next().ordinal()];
            if (i3 == 1) {
                i |= 1;
            } else if (i3 == 2) {
                i |= 2;
            } else if (i3 == 3) {
                i2 = 137;
            }
        }
        int i4 = AnonymousClass2.$SwitchMap$com$urbanairship$android$layout$property$TextAlignment[textAppearance.getAlignment().ordinal()];
        if (i4 == 1) {
            textView.setGravity(17);
        } else if (i4 == 2) {
            textView.setGravity(8388627);
        } else if (i4 == 3) {
            textView.setGravity(8388629);
        }
        textView.setTypeface(getTypeFace(textView.getContext(), textAppearance.getFontFamilies()), i);
        textView.setPaintFlags(i2);
    }

    /* renamed from: com.urbanairship.android.layout.util.LayoutUtils$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$TextAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$TextStyle;

        static {
            int[] iArr = new int[TextAlignment.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$TextAlignment = iArr;
            try {
                iArr[TextAlignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$TextAlignment[TextAlignment.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$TextAlignment[TextAlignment.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[TextStyle.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$TextStyle = iArr2;
            try {
                iArr2[TextStyle.BOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$TextStyle[TextStyle.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$TextStyle[TextStyle.UNDERLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static Typeface getTypeFace(Context context, List list) {
        Typeface fontFamily;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!UAStringUtil.isEmpty(str) && (fontFamily = Fonts.shared(context).getFontFamily(str)) != null) {
                return fontFamily;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void applySwitchStyle(@NonNull SwitchCompat switchCompat, @NonNull SwitchStyle switchStyle) {
        Context context = switchCompat.getContext();
        int iResolve = switchStyle.getOnColor().resolve(context);
        int iResolve2 = switchStyle.getOffColor().resolve(context);
        int iLayer = MaterialColors.layer(-1, iResolve, 0.32f);
        int iLayer2 = MaterialColors.layer(-1, iResolve2, 0.32f);
        switchCompat.setTrackTintList(checkedColorStateList(iResolve, iResolve2));
        switchCompat.setThumbTintList(checkedColorStateList(iLayer, iLayer2));
        switchCompat.setBackgroundResource(com.urbanairship.android.layout.R.drawable.ua_layout_imagebutton_ripple);
        switchCompat.setGravity(17);
    }

    private static ColorStateList checkedColorStateList(int i, int i2) {
        return new ColorStateListBuilder().add(generateDisabledColor(i), android.R.attr.state_checked, -16842910).add(generateDisabledColor(i2), -16842912, -16842910).add(i, android.R.attr.state_checked).add(i2).build();
    }

    public static ColorStateList pressedColorStateList(@ColorInt int i) {
        return new ColorStateListBuilder().add(generatePressedColor(i, -16777216), android.R.attr.state_pressed).add(generateHoveredColor(i, -16777216), android.R.attr.state_hovered).add(generateDisabledColor(i), -16842910).add(i).build();
    }

    public static void dismissSoftKeyboard(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void doOnAttachToWindow(@NonNull View view, @NonNull final Runnable runnable) {
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.urbanairship.android.layout.util.LayoutUtils.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                view2.removeOnAttachStateChangeListener(this);
                runnable.run();
            }
        });
    }

    public static void addPadding(@NonNull View view, int i) {
        addPadding(view, i, i, i, i);
    }

    public static void removePadding(@NonNull View view, int i) {
        int i2 = -i;
        addPadding(view, i2, i2, i2, i2);
    }

    public static void addPadding(@NonNull View view, int i, int i2, int i3, int i4) {
        view.setPadding(view.getPaddingLeft() + i, view.getPaddingTop() + i2, view.getPaddingRight() + i3, view.getPaddingBottom() + i4);
    }

    @ColorInt
    public static int generatePressedColor(@ColorInt int i) {
        return generatePressedColor(i, -1);
    }

    @ColorInt
    public static int generateDisabledColor(@ColorInt int i) {
        return generateDisabledColor(i, -1);
    }

    @ColorInt
    public static int generateHoveredColor(@ColorInt int i) {
        return generateHoveredColor(i, -1);
    }

    @ColorInt
    public static int generatePressedColor(@ColorInt int i, @ColorInt int i2) {
        return overlayColors(i, i2, 0.2f);
    }

    @ColorInt
    public static int generateDisabledColor(@ColorInt int i, @ColorInt int i2) {
        return overlayColors(i, i2, 0.38f);
    }

    @ColorInt
    public static int generateHoveredColor(@ColorInt int i, @ColorInt int i2) {
        return overlayColors(i, i2, 0.1f);
    }

    private static int overlayColors(int i, int i2, float f) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static int dpToPx(@NonNull Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
