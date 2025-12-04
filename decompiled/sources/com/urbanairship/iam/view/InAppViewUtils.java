package com.urbanairship.iam.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ImageSpan;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.Fonts;
import com.urbanairship.UALog;
import com.urbanairship.automation.R;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageColor;
import com.urbanairship.iam.info.InAppMessageMediaInfo;
import com.urbanairship.iam.info.InAppMessageTextInfo;
import com.urbanairship.iam.view.BackgroundDrawableBuilder;
import com.urbanairship.util.UAStringUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u001fJ)\u0010&\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/urbanairship/iam/view/InAppViewUtils;", "", "<init>", "()V", "Landroid/widget/TextView;", "textView", "Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "textInfo", "", "centerGravity", "", "applyTextInfo", "(Landroid/widget/TextView;Lcom/urbanairship/iam/info/InAppMessageTextInfo;I)V", "Landroid/content/Context;", "context", "", "", "fontFamilies", "Landroid/graphics/Typeface;", "getTypeFace", "(Landroid/content/Context;Ljava/util/List;)Landroid/graphics/Typeface;", "Landroid/widget/Button;", "button", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "buttonInfo", "borderRadiusFlag", "strokeWidthInDps", "applyButtonInfo", "(Landroid/widget/Button;Lcom/urbanairship/iam/info/InAppMessageButtonInfo;II)V", "(Landroid/widget/Button;Lcom/urbanairship/iam/info/InAppMessageButtonInfo;I)V", "applyButtonTextInfo", "(Landroid/widget/TextView;Lcom/urbanairship/iam/info/InAppMessageTextInfo;)V", "Lcom/urbanairship/iam/view/MediaView;", "mediaView", "Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "mediaInfo", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "assets", "loadMediaInfo", "(Lcom/urbanairship/iam/view/MediaView;Lcom/urbanairship/iam/info/InAppMessageMediaInfo;Lcom/urbanairship/iam/assets/AirshipCachedAssets;)V", "Landroid/view/ViewGroup;", "group", "", "getLargestChildZValue", "(Landroid/view/ViewGroup;)F", "CenteredImageSpan", "RemoveUnderlineSpan", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppViewUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppViewUtils.kt\ncom/urbanairship/iam/view/InAppViewUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,312:1\n1#2:313\n81#3:314\n*S KotlinDebug\n*F\n+ 1 InAppViewUtils.kt\ncom/urbanairship/iam/view/InAppViewUtils\n*L\n221#1:314\n*E\n"})
/* loaded from: classes5.dex */
public final class InAppViewUtils {

    @NotNull
    public static final InAppViewUtils INSTANCE = new InAppViewUtils();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InAppMessageTextInfo.Style.values().length];
            try {
                iArr[InAppMessageTextInfo.Style.BOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppMessageTextInfo.Style.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppMessageTextInfo.Style.UNDERLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InAppMessageTextInfo.Alignment.values().length];
            try {
                iArr2[InAppMessageTextInfo.Alignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InAppMessageTextInfo.Alignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[InAppMessageTextInfo.Alignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private InAppViewUtils() {
    }

    public final void applyButtonInfo(@NotNull Button button, @NotNull InAppMessageButtonInfo buttonInfo, int borderRadiusFlag, int strokeWidthInDps) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        applyButtonTextInfo(button, buttonInfo.getLabel());
        InAppMessageColor color = buttonInfo.getLabel().getColor();
        int color2 = color != null ? color.getColor() : button.getCurrentTextColor();
        InAppMessageColor backgroundColor = buttonInfo.getBackgroundColor();
        int color3 = backgroundColor != null ? backgroundColor.getColor() : 0;
        int alphaComponent = ColorUtils.setAlphaComponent(color2, Math.round(Color.alpha(color2) * 0.2f));
        InAppMessageColor borderColor = buttonInfo.getBorderColor();
        int color4 = borderColor != null ? borderColor.getColor() : color3;
        float borderRadius = buttonInfo.getBorderRadius();
        BackgroundDrawableBuilder.Companion companion = BackgroundDrawableBuilder.INSTANCE;
        Context context = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ViewCompat.setBackground(button, companion.newBuilder(context).setBackgroundColor(color3).setBorderRadius(borderRadius, borderRadiusFlag).setPressedColor(alphaComponent).setStrokeColor(color4).setStrokeWidth(strokeWidthInDps).build());
    }

    public final void applyButtonInfo(@NotNull Button button, @NotNull InAppMessageButtonInfo buttonInfo, int borderRadiusFlag) throws Resources.NotFoundException {
        int integer;
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        try {
            integer = button.getContext().getResources().getInteger(R.integer.ua_iam_button_stroke_width_dps);
        } catch (Resources.NotFoundException unused) {
            integer = 2;
        }
        applyButtonInfo(button, buttonInfo, borderRadiusFlag, integer);
    }

    public final void applyButtonTextInfo(@NotNull TextView textView, @NotNull InAppMessageTextInfo textInfo) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(textInfo, "textInfo");
        applyTextInfo(textView, textInfo, 17);
    }

    public final void applyTextInfo(@NotNull TextView textView, @NotNull InAppMessageTextInfo textInfo) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(textInfo, "textInfo");
        applyTextInfo(textView, textInfo, 1);
    }

    private final void applyTextInfo(TextView textView, InAppMessageTextInfo textInfo, int centerGravity) {
        Drawable drawable;
        Float size = textInfo.getSize();
        if (size != null) {
            textView.setTextSize(size.floatValue());
        }
        InAppMessageColor color = textInfo.getColor();
        if (color != null) {
            textView.setTextColor(color.getColor());
        }
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int drawable2 = textInfo.getDrawable(context);
        if (drawable2 != 0) {
            try {
                drawable = ContextCompat.getDrawable(textView.getContext(), drawable2);
            } catch (Resources.NotFoundException unused) {
                UALog.d("Drawable " + drawable2 + " no longer exists.", new Object[0]);
            }
        } else {
            drawable = null;
        }
        if (drawable != null) {
            int iRound = Math.round(textView.getTextSize());
            int currentTextColor = textView.getCurrentTextColor();
            try {
                Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
                Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
                drawableMutate.setBounds(0, 0, iRound, iRound);
                drawableMutate.setColorFilter(new PorterDuffColorFilter(currentTextColor, PorterDuff.Mode.MULTIPLY));
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(drawableMutate);
                SpannableString spannableString = new SpannableString("  " + textInfo.getText());
                spannableString.setSpan(centeredImageSpan, 0, 1, 33);
                spannableString.setSpan(new RemoveUnderlineSpan(), 1, 2, 33);
                textView.setText(spannableString);
            } catch (Resources.NotFoundException e) {
                UALog.e(e, "Unable to find button drawable.", new Object[0]);
                textView.setText(textInfo.getText());
            }
        } else {
            textView.setText(textInfo.getText());
        }
        Typeface typeface = textView.getTypeface();
        int style = typeface != null ? typeface.getStyle() : 0;
        int paintFlags = textView.getPaintFlags() | TsExtractor.TS_STREAM_TYPE_AC3;
        List<InAppMessageTextInfo.Style> style2 = textInfo.getStyle();
        if (style2 == null) {
            style2 = CollectionsKt.emptyList();
        }
        Iterator<InAppMessageTextInfo.Style> it = style2.iterator();
        while (it.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[it.next().ordinal()];
            if (i == 1) {
                style |= 1;
            } else if (i == 2) {
                style |= 2;
            } else if (i == 3) {
                paintFlags |= 8;
            }
        }
        InAppMessageTextInfo.Alignment alignment = textInfo.getAlignment();
        if (alignment != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[alignment.ordinal()];
            if (i2 == 1) {
                centerGravity = GravityCompat.START;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                centerGravity = GravityCompat.END;
            }
            textView.setGravity(centerGravity);
        }
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        Typeface typeFace = getTypeFace(context2, textInfo.getFontFamilies());
        if (typeFace == null) {
            typeFace = textView.getTypeface();
        }
        textView.setTypeface(typeFace, style);
        textView.setPaintFlags(paintFlags);
    }

    private final Typeface getTypeFace(Context context, List fontFamilies) {
        Typeface fontFamily;
        if (fontFamilies == null) {
            return null;
        }
        Iterator it = fontFamilies.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!UAStringUtil.isEmpty(str) && (fontFamily = Fonts.shared(context).getFontFamily(str)) != null) {
                return fontFamily;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void loadMediaInfo(@NotNull final MediaView mediaView, @NotNull final InAppMessageMediaInfo mediaInfo, @Nullable final AirshipCachedAssets assets) {
        String url;
        Uri uriCacheUri;
        String string;
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaView.getWidth() == 0) {
            final WeakReference weakReference = new WeakReference(mediaView);
            OneShotPreDrawListener.add(mediaView, new Runnable() { // from class: com.urbanairship.iam.view.InAppViewUtils$loadMediaInfo$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    MediaView mediaView2 = (MediaView) weakReference.get();
                    if (mediaView2 == null) {
                        return;
                    }
                    Intrinsics.checkNotNull(mediaView2);
                    InAppViewUtils.INSTANCE.loadMediaInfo(mediaView2, mediaInfo, assets);
                }
            });
            return;
        }
        String str = null;
        int iMax = 16;
        int iMax2 = 9;
        if (assets != null && (uriCacheUri = assets.cacheUri((url = mediaInfo.getUrl()))) != null && (string = uriCacheUri.toString()) != null) {
            Intrinsics.checkNotNull(string);
            Size mediaSize = assets.getMediaSize(url);
            iMax = Math.max(mediaSize.getWidth(), 16);
            iMax2 = Math.max(mediaSize.getHeight(), 9);
            str = string;
        }
        ViewGroup.LayoutParams layoutParams = mediaView.getLayoutParams();
        if (layoutParams.height == -2) {
            layoutParams.height = Math.round((mediaView.getWidth() / iMax) * iMax2);
        } else {
            float f = iMax / iMax2;
            if (f >= mediaView.getWidth() / mediaView.getHeight()) {
                layoutParams.height = Math.round(mediaView.getWidth() / f);
            } else {
                layoutParams.width = Math.round(mediaView.getHeight() * f);
            }
        }
        mediaView.setLayoutParams(layoutParams);
        mediaView.setMediaInfo(mediaInfo, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final float getLargestChildZValue(@NotNull ViewGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        int childCount = group.getChildCount();
        float fMax = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(group.getChildAt(0).getZ(), fMax);
        }
        return fMax;
    }

    private static final class RemoveUnderlineSpan extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            textPaint.setUnderlineText(false);
        }
    }

    private static final class CenteredImageSpan extends ImageSpan {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CenteredImageSpan(Drawable drawable) {
            super(drawable);
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(paint, "paint");
            canvas.save();
            Drawable drawable = getDrawable();
            canvas.translate(f, (i5 - drawable.getBounds().bottom) - (paint.getFontMetricsInt().descent / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
