package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BorderColors;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ColorEdges;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u0002H\u001b0\u0019\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u0002H\u001bH\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020KH\u0014J\u0010\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020-H\u0016J\u0012\u0010N\u001a\u00020H2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020-H\u0017J\u0010\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0016J\u0018\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020/H\u0002J\u0016\u0010W\u001a\u00020H2\u0006\u0010X\u001a\u00020-2\u0006\u0010Y\u001a\u00020/J\u0018\u0010\u0012\u001a\u00020H2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0010\u0010!\u001a\u00020H2\b\u0010^\u001a\u0004\u0018\u00010_J\u001d\u0010`\u001a\u00020H2\u0006\u0010X\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010cJ\u000e\u0010d\u001a\u00020-2\u0006\u0010X\u001a\u00020aJ\u0006\u0010e\u001a\u00020HJ\u0010\u0010f\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010g\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0002JH\u0010h\u001a\u00020-2\u0006\u0010i\u001a\u00020-2\u0006\u0010j\u001a\u00020-2\u0006\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u00020-2\u0006\u0010m\u001a\u00020-2\u0006\u0010n\u001a\u00020-2\u0006\u0010o\u001a\u00020-2\u0006\u0010p\u001a\u00020-H\u0002JX\u0010q\u001a\u00020H2\u0006\u0010S\u001a\u00020T2\u0006\u0010r\u001a\u00020-2\u0006\u0010s\u001a\u00020/2\u0006\u0010t\u001a\u00020/2\u0006\u0010u\u001a\u00020/2\u0006\u0010v\u001a\u00020/2\u0006\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020/2\u0006\u0010y\u001a\u00020/2\u0006\u0010z\u001a\u00020/H\u0002J\b\u0010{\u001a\u00020DH\u0002J\b\u0010|\u001a\u00020/H\u0002J\b\u0010}\u001a\u00020HH\u0002J\u0010\u0010}\u001a\u00020H2\u0006\u0010\u0004\u001a\u00020-H\u0002J\u001a\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020/H\u0002Jb\u0010\u0080\u0001\u001a\u00020H2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\b\u0010\u0084\u0001\u001a\u00030\u0082\u00012\b\u0010\u0085\u0001\u001a\u00030\u0082\u00012\b\u0010\u0086\u0001\u001a\u00030\u0082\u00012\b\u0010\u0087\u0001\u001a\u00030\u0082\u00012\b\u0010\u0088\u0001\u001a\u00030\u0082\u00012\b\u0010\u0089\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u008a\u0001\u001a\u00020?H\u0002J\t\u0010\u008b\u0001\u001a\u00020HH\u0002J\u001a\u0010\u008c\u0001\u001a\u00020-2\u0006\u0010b\u001a\u00020-2\u0007\u0010\u008d\u0001\u001a\u00020-H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0012\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082D¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0004\u0018\u0001012\b\u0010:\u001a\u0004\u0018\u000101@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008e\u0001"}, d2 = {"Lcom/facebook/react/uimanager/drawable/BorderDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", ViewProps.BORDER_WIDTH, "Lcom/facebook/react/uimanager/Spacing;", "borderRadius", "Lcom/facebook/react/uimanager/style/BorderRadiusStyle;", "borderInsets", "Lcom/facebook/react/uimanager/style/BorderInsets;", "borderStyle", "Lcom/facebook/react/uimanager/style/BorderStyle;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/uimanager/Spacing;Lcom/facebook/react/uimanager/style/BorderRadiusStyle;Lcom/facebook/react/uimanager/style/BorderInsets;Lcom/facebook/react/uimanager/style/BorderStyle;)V", "getBorderWidth", "()Lcom/facebook/react/uimanager/Spacing;", "getBorderRadius", "()Lcom/facebook/react/uimanager/style/BorderRadiusStyle;", "setBorderRadius", "(Lcom/facebook/react/uimanager/style/BorderRadiusStyle;)V", "getBorderInsets", "()Lcom/facebook/react/uimanager/style/BorderInsets;", "setBorderInsets", "(Lcom/facebook/react/uimanager/style/BorderInsets;)V", "invalidatingAndPathChange", "Lkotlin/properties/ReadWriteProperty;", "", ExifInterface.GPS_DIRECTION_TRUE, "initialValue", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "<set-?>", "getBorderStyle", "()Lcom/facebook/react/uimanager/style/BorderStyle;", "setBorderStyle", "(Lcom/facebook/react/uimanager/style/BorderStyle;)V", "borderStyle$delegate", "Lkotlin/properties/ReadWriteProperty;", "borderColors", "Lcom/facebook/react/uimanager/style/BorderColors;", "[Ljava/lang/Integer;", "computedBorderColors", "Lcom/facebook/react/uimanager/style/ColorEdges;", "computedBorderRadius", "Lcom/facebook/react/uimanager/style/ComputedBorderRadius;", "borderAlpha", "", "gapBetweenPaths", "", "pathForBorder", "Landroid/graphics/Path;", "borderPaint", "Landroid/graphics/Paint;", "needUpdatePath", "", "pathForSingleBorder", "pathForOutline", "centerDrawPath", "outerClipPathForBorderRadius", "value", "innerClipPathForBorderRadius", "getInnerClipPathForBorderRadius", "()Landroid/graphics/Path;", "innerBottomLeftCorner", "Landroid/graphics/PointF;", "innerBottomRightCorner", "innerTopLeftCorner", "innerTopRightCorner", "innerClipTempRectForBorderRadius", "Landroid/graphics/RectF;", "outerClipTempRectForBorderRadius", "tempRectForCenterDrawPath", "invalidateSelf", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "draw", "canvas", "Landroid/graphics/Canvas;", "getInnerBorderRadius", "computedRadius", "setBorderWidth", ViewProps.POSITION, "width", "property", "Lcom/facebook/react/uimanager/style/BorderRadiusProp;", "radius", "Lcom/facebook/react/uimanager/LengthPercentage;", "style", "", "setBorderColor", "Lcom/facebook/react/uimanager/style/LogicalEdge;", "color", "(Lcom/facebook/react/uimanager/style/LogicalEdge;Ljava/lang/Integer;)V", "getBorderColor", "invalidateSelfAndUpdatePath", "drawRectangularBorders", "drawRoundedBorders", "fastBorderCompatibleColorOrZero", "borderLeft", "borderTop", "borderRight", "borderBottom", "colorLeft", "colorTop", "colorRight", "colorBottom", "drawQuadrilateral", "fillColor", "x1", "y1", "x2", "y2", "x3", "y3", "x4", "y4", "computeBorderInsets", "getFullBorderWidth", "updatePathEffect", "getPathEffect", "Landroid/graphics/PathEffect;", "getEllipseIntersectionWithLine", "ellipseBoundsLeft", "", "ellipseBoundsTop", "ellipseBoundsRight", "ellipseBoundsBottom", "lineStartX", "lineStartY", "lineEndX", "lineEndY", "result", "updatePath", "multiplyColorAlpha", "rawAlpha", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBorderDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BorderDrawable.kt\ncom/facebook/react/uimanager/drawable/BorderDrawable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1072:1\n1#2:1073\n*E\n"})
/* loaded from: classes3.dex */
public final class BorderDrawable extends Drawable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BorderDrawable.class, "borderStyle", "getBorderStyle()Lcom/facebook/react/uimanager/style/BorderStyle;", 0))};
    private int borderAlpha;

    @Nullable
    private Integer[] borderColors;

    @Nullable
    private BorderInsets borderInsets;

    @NotNull
    private final Paint borderPaint;

    @Nullable
    private BorderRadiusStyle borderRadius;

    /* renamed from: borderStyle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty borderStyle;

    @Nullable
    private final Spacing borderWidth;

    @Nullable
    private Path centerDrawPath;

    @NotNull
    private ColorEdges computedBorderColors;

    @Nullable
    private ComputedBorderRadius computedBorderRadius;

    @NotNull
    private final Context context;
    private final float gapBetweenPaths;

    @Nullable
    private PointF innerBottomLeftCorner;

    @Nullable
    private PointF innerBottomRightCorner;

    @Nullable
    private Path innerClipPathForBorderRadius;

    @Nullable
    private RectF innerClipTempRectForBorderRadius;

    @Nullable
    private PointF innerTopLeftCorner;

    @Nullable
    private PointF innerTopRightCorner;
    private boolean needUpdatePath;

    @Nullable
    private Path outerClipPathForBorderRadius;

    @Nullable
    private RectF outerClipTempRectForBorderRadius;

    @Nullable
    private Path pathForBorder;

    @Nullable
    private Path pathForOutline;

    @Nullable
    private Path pathForSingleBorder;

    @Nullable
    private RectF tempRectForCenterDrawPath;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            try {
                iArr[BorderStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int fastBorderCompatibleColorOrZero(int borderLeft, int borderTop, int borderRight, int borderBottom, int colorLeft, int colorTop, int colorRight, int colorBottom) {
        int i = (borderBottom > 0 ? colorBottom : -1) & (borderLeft > 0 ? colorLeft : -1) & (borderTop > 0 ? colorTop : -1) & (borderRight > 0 ? colorRight : -1);
        if (borderLeft <= 0) {
            colorLeft = 0;
        }
        if (borderTop <= 0) {
            colorTop = 0;
        }
        int i2 = colorLeft | colorTop;
        if (borderRight <= 0) {
            colorRight = 0;
        }
        int i3 = i2 | colorRight;
        if (borderBottom <= 0) {
            colorBottom = 0;
        }
        if (i == (i3 | colorBottom)) {
            return i;
        }
        return 0;
    }

    private final int multiplyColorAlpha(int color, int rawAlpha) {
        if (rawAlpha == 255) {
            return color;
        }
        if (rawAlpha == 0) {
            return 16777215 & color;
        }
        return (16777215 & color) | ((((color >>> 24) * ((rawAlpha + (rawAlpha >> 7)) >> 7)) >> 8) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Nullable
    public final Spacing getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final BorderRadiusStyle getBorderRadius() {
        return this.borderRadius;
    }

    public final void setBorderRadius(@Nullable BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    @Nullable
    public final BorderInsets getBorderInsets() {
        return this.borderInsets;
    }

    public final void setBorderInsets(@Nullable BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BorderDrawable(@NotNull Context context, @Nullable Spacing spacing, @Nullable BorderRadiusStyle borderRadiusStyle, @Nullable BorderInsets borderInsets, @Nullable BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderWidth = spacing;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.borderStyle = invalidatingAndPathChange(borderStyle);
        this.computedBorderColors = new ColorEdges(0, 0, 0, 0, 15, null);
        this.borderAlpha = 255;
        this.gapBetweenPaths = 0.8f;
        this.borderPaint = new Paint(1);
        this.needUpdatePath = true;
    }

    private final <T> ReadWriteProperty<Object, T> invalidatingAndPathChange(T initialValue) {
        return new ObservableProperty<T>(initialValue) { // from class: com.facebook.react.uimanager.drawable.BorderDrawable.invalidatingAndPathChange.1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.needUpdatePath = true;
                this.invalidateSelf();
            }
        };
    }

    @Nullable
    public final BorderStyle getBorderStyle() {
        return (BorderStyle) this.borderStyle.getValue(this, $$delegatedProperties[0]);
    }

    public final void setBorderStyle(@Nullable BorderStyle borderStyle) {
        this.borderStyle.setValue(this, $$delegatedProperties[0], borderStyle);
    }

    @Nullable
    public final Path getInnerClipPathForBorderRadius() {
        return this.innerClipPathForBorderRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.needUpdatePath = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.needUpdatePath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.borderAlpha = alpha;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        if (ComparisonsKt.maxOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 0) {
            return -2;
        }
        return ComparisonsKt.minOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 255 ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        ColorEdges colorEdgesM2253resolveimpl;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        updatePathEffect();
        Integer[] numArr = this.borderColors;
        if (numArr == null || (colorEdgesM2253resolveimpl = BorderColors.m2253resolveimpl(numArr, getLayoutDirection(), this.context)) == null) {
            colorEdgesM2253resolveimpl = this.computedBorderColors;
        }
        this.computedBorderColors = colorEdgesM2253resolveimpl;
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null && borderRadiusStyle.hasRoundedBorders()) {
            drawRoundedBorders(canvas);
        } else {
            drawRectangularBorders(canvas);
        }
    }

    private final float getInnerBorderRadius(float computedRadius, float borderWidth) {
        return RangesKt.coerceAtLeast(computedRadius - borderWidth, BitmapDescriptorFactory.HUE_RED);
    }

    public final void setBorderWidth(int position, float width) {
        Spacing spacing = this.borderWidth;
        if (FloatUtil.floatsEqual(spacing != null ? Float.valueOf(spacing.getRaw(position)) : null, Float.valueOf(width))) {
            return;
        }
        Spacing spacing2 = this.borderWidth;
        if (spacing2 != null) {
            spacing2.set(position, width);
        }
        if (position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 8) {
            this.needUpdatePath = true;
        }
        invalidateSelf();
    }

    public final void setBorderRadius(@NotNull BorderRadiusProp property, @Nullable LengthPercentage radius) {
        Intrinsics.checkNotNullParameter(property, "property");
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (Intrinsics.areEqual(radius, borderRadiusStyle != null ? borderRadiusStyle.get(property) : null)) {
            return;
        }
        BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
        if (borderRadiusStyle2 != null) {
            borderRadiusStyle2.set(property, radius);
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final void setBorderStyle(@Nullable String style) {
        BorderStyle borderStyleValueOf;
        if (style == null) {
            borderStyleValueOf = null;
        } else {
            String upperCase = style.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            borderStyleValueOf = BorderStyle.valueOf(upperCase);
        }
        setBorderStyle(borderStyleValueOf);
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final void setBorderColor(@NotNull LogicalEdge position, @Nullable Integer color) {
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArrM2249constructorimpl$default = this.borderColors;
        if (numArrM2249constructorimpl$default == null) {
            numArrM2249constructorimpl$default = BorderColors.m2249constructorimpl$default(null, 1, null);
        }
        this.borderColors = numArrM2249constructorimpl$default;
        if (numArrM2249constructorimpl$default != null) {
            numArrM2249constructorimpl$default[position.ordinal()] = color;
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final int getBorderColor(@NotNull LogicalEdge position) {
        Integer num;
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArr = this.borderColors;
        if (numArr == null || (num = numArr[position.ordinal()]) == null) {
            return -16777216;
        }
        return num.intValue();
    }

    public final void invalidateSelfAndUpdatePath() {
        this.needUpdatePath = true;
        invalidateSelf();
    }

    private final void drawRectangularBorders(Canvas canvas) {
        RectF rectFComputeBorderInsets = computeBorderInsets();
        int iRoundToInt = MathKt.roundToInt(rectFComputeBorderInsets.left);
        int iRoundToInt2 = MathKt.roundToInt(rectFComputeBorderInsets.top);
        int iRoundToInt3 = MathKt.roundToInt(rectFComputeBorderInsets.right);
        int iRoundToInt4 = MathKt.roundToInt(rectFComputeBorderInsets.bottom);
        if (iRoundToInt > 0 || iRoundToInt3 > 0 || iRoundToInt2 > 0 || iRoundToInt4 > 0) {
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            int i = bounds.left;
            int i2 = bounds.top;
            int iFastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(iRoundToInt, iRoundToInt2, iRoundToInt3, iRoundToInt4, this.computedBorderColors.getLeft(), this.computedBorderColors.getTop(), this.computedBorderColors.getRight(), this.computedBorderColors.getBottom());
            if (iFastBorderCompatibleColorOrZero != 0) {
                if (Color.alpha(iFastBorderCompatibleColorOrZero) != 0) {
                    int i3 = bounds.right;
                    int i4 = bounds.bottom;
                    this.borderPaint.setColor(multiplyColorAlpha(iFastBorderCompatibleColorOrZero, this.borderAlpha));
                    this.borderPaint.setStyle(Paint.Style.STROKE);
                    Path path = new Path();
                    this.pathForSingleBorder = path;
                    if (iRoundToInt > 0) {
                        path.reset();
                        int iRoundToInt5 = MathKt.roundToInt(rectFComputeBorderInsets.left);
                        updatePathEffect(iRoundToInt5);
                        this.borderPaint.setStrokeWidth(iRoundToInt5);
                        Path path2 = this.pathForSingleBorder;
                        if (path2 != null) {
                            path2.moveTo(i + (iRoundToInt5 / 2), i2);
                        }
                        Path path3 = this.pathForSingleBorder;
                        if (path3 != null) {
                            path3.lineTo(i + (iRoundToInt5 / 2), i4);
                        }
                        Path path4 = this.pathForSingleBorder;
                        if (path4 != null) {
                            canvas.drawPath(path4, this.borderPaint);
                        }
                    }
                    if (iRoundToInt2 > 0) {
                        Path path5 = this.pathForSingleBorder;
                        if (path5 != null) {
                            path5.reset();
                        }
                        int iRoundToInt6 = MathKt.roundToInt(rectFComputeBorderInsets.top);
                        updatePathEffect(iRoundToInt6);
                        this.borderPaint.setStrokeWidth(iRoundToInt6);
                        Path path6 = this.pathForSingleBorder;
                        if (path6 != null) {
                            path6.moveTo(i, i2 + (iRoundToInt6 / 2));
                        }
                        Path path7 = this.pathForSingleBorder;
                        if (path7 != null) {
                            path7.lineTo(i3, i2 + (iRoundToInt6 / 2));
                        }
                        Path path8 = this.pathForSingleBorder;
                        if (path8 != null) {
                            canvas.drawPath(path8, this.borderPaint);
                        }
                    }
                    if (iRoundToInt3 > 0) {
                        Path path9 = this.pathForSingleBorder;
                        if (path9 != null) {
                            path9.reset();
                        }
                        int iRoundToInt7 = MathKt.roundToInt(rectFComputeBorderInsets.right);
                        updatePathEffect(iRoundToInt7);
                        this.borderPaint.setStrokeWidth(iRoundToInt7);
                        Path path10 = this.pathForSingleBorder;
                        if (path10 != null) {
                            path10.moveTo(i3 - (iRoundToInt7 / 2), i2);
                        }
                        Path path11 = this.pathForSingleBorder;
                        if (path11 != null) {
                            path11.lineTo(i3 - (iRoundToInt7 / 2), i4);
                        }
                        Path path12 = this.pathForSingleBorder;
                        if (path12 != null) {
                            canvas.drawPath(path12, this.borderPaint);
                        }
                    }
                    if (iRoundToInt4 > 0) {
                        Path path13 = this.pathForSingleBorder;
                        if (path13 != null) {
                            path13.reset();
                        }
                        int iRoundToInt8 = MathKt.roundToInt(rectFComputeBorderInsets.bottom);
                        updatePathEffect(iRoundToInt8);
                        this.borderPaint.setStrokeWidth(iRoundToInt8);
                        Path path14 = this.pathForSingleBorder;
                        if (path14 != null) {
                            path14.moveTo(i, i4 - (iRoundToInt8 / 2));
                        }
                        Path path15 = this.pathForSingleBorder;
                        if (path15 != null) {
                            path15.lineTo(i3, i4 - (iRoundToInt8 / 2));
                        }
                        Path path16 = this.pathForSingleBorder;
                        if (path16 != null) {
                            canvas.drawPath(path16, this.borderPaint);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.borderPaint.setAntiAlias(false);
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            if (iRoundToInt > 0) {
                float f = i;
                float f2 = i2;
                float f3 = i + iRoundToInt;
                drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, f2, f3, i2 + iRoundToInt2, f3, r0 - iRoundToInt4, f, i2 + iHeight);
            }
            if (iRoundToInt2 > 0) {
                float f4 = i;
                float f5 = i2;
                float f6 = i + iRoundToInt;
                float f7 = i2 + iRoundToInt2;
                drawQuadrilateral(canvas, this.computedBorderColors.getTop(), f4, f5, f6, f7, r0 - iRoundToInt3, f7, i + iWidth, f5);
            }
            if (iRoundToInt3 > 0) {
                int i5 = i + iWidth;
                float f8 = i5;
                float f9 = i5 - iRoundToInt3;
                drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f8, i2, f8, i2 + iHeight, f9, r7 - iRoundToInt4, f9, i2 + iRoundToInt2);
            }
            if (iRoundToInt4 > 0) {
                int i6 = i2 + iHeight;
                float f10 = i6;
                float f11 = i6 - iRoundToInt4;
                int bottom = this.computedBorderColors.getBottom();
                drawQuadrilateral(canvas, bottom, i, f10, i + iWidth, f10, r8 - iRoundToInt3, f11, i + iRoundToInt, f11);
            }
            this.borderPaint.setAntiAlias(true);
        }
    }

    private final void drawRoundedBorders(Canvas canvas) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        float f;
        float f2;
        float f3;
        PointF pointF5;
        PointF pointF6;
        CornerRadii topLeft;
        CornerRadii pixelFromDIP;
        CornerRadii topLeft2;
        CornerRadii pixelFromDIP2;
        updatePath();
        canvas.save();
        Path path = this.outerClipPathForBorderRadius;
        if (path == null) {
            throw new IllegalStateException("Required value was null.");
        }
        canvas.clipPath(path);
        RectF rectFComputeBorderInsets = computeBorderInsets();
        float f4 = rectFComputeBorderInsets.top;
        float vertical = BitmapDescriptorFactory.HUE_RED;
        if (f4 > BitmapDescriptorFactory.HUE_RED || rectFComputeBorderInsets.bottom > BitmapDescriptorFactory.HUE_RED || rectFComputeBorderInsets.left > BitmapDescriptorFactory.HUE_RED || rectFComputeBorderInsets.right > BitmapDescriptorFactory.HUE_RED) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor = getBorderColor(LogicalEdge.ALL);
            if (rectFComputeBorderInsets.top != fullBorderWidth || rectFComputeBorderInsets.bottom != fullBorderWidth || rectFComputeBorderInsets.left != fullBorderWidth || rectFComputeBorderInsets.right != fullBorderWidth || this.computedBorderColors.getLeft() != borderColor || this.computedBorderColors.getTop() != borderColor || this.computedBorderColors.getRight() != borderColor || this.computedBorderColors.getBottom() != borderColor) {
                this.borderPaint.setStyle(Paint.Style.FILL);
                Path path2 = this.innerClipPathForBorderRadius;
                if (path2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                canvas.clipOutPath(path2);
                RectF rectF = this.outerClipTempRectForBorderRadius;
                if (rectF == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                float f5 = rectF.left;
                float f6 = rectF.right;
                float f7 = rectF.top;
                float f8 = rectF.bottom;
                PointF pointF7 = this.innerTopLeftCorner;
                if (pointF7 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF8 = this.innerTopRightCorner;
                if (pointF8 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF9 = this.innerBottomLeftCorner;
                if (pointF9 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF10 = this.innerBottomRightCorner;
                if (pointF10 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (rectFComputeBorderInsets.left > BitmapDescriptorFactory.HUE_RED) {
                    float f9 = this.gapBetweenPaths;
                    pointF = pointF10;
                    pointF2 = pointF9;
                    pointF3 = pointF8;
                    pointF4 = pointF7;
                    f = f8;
                    f2 = f7;
                    f3 = f6;
                    drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f5, f7 - f9, pointF7.x, pointF7.y - f9, pointF9.x, pointF9.y + f9, f5, f8 + f9);
                } else {
                    pointF = pointF10;
                    pointF2 = pointF9;
                    pointF3 = pointF8;
                    pointF4 = pointF7;
                    f = f8;
                    f2 = f7;
                    f3 = f6;
                }
                if (rectFComputeBorderInsets.top > BitmapDescriptorFactory.HUE_RED) {
                    float f10 = this.gapBetweenPaths;
                    PointF pointF11 = pointF4;
                    PointF pointF12 = pointF3;
                    pointF5 = pointF12;
                    drawQuadrilateral(canvas, this.computedBorderColors.getTop(), f5 - f10, f2, pointF11.x - f10, pointF11.y, pointF12.x + f10, pointF12.y, f3 + f10, f2);
                } else {
                    pointF5 = pointF3;
                }
                if (rectFComputeBorderInsets.right > BitmapDescriptorFactory.HUE_RED) {
                    float f11 = this.gapBetweenPaths;
                    PointF pointF13 = pointF5;
                    PointF pointF14 = pointF;
                    pointF6 = pointF14;
                    drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f3, f2 - f11, pointF13.x, pointF13.y - f11, pointF14.x, pointF14.y + f11, f3, f + f11);
                } else {
                    pointF6 = pointF;
                }
                if (rectFComputeBorderInsets.bottom > BitmapDescriptorFactory.HUE_RED) {
                    float f12 = this.gapBetweenPaths;
                    PointF pointF15 = pointF2;
                    float f13 = pointF15.x - f12;
                    float f14 = pointF15.y;
                    PointF pointF16 = pointF6;
                    drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), f5 - f12, f, f13, f14, pointF16.x + f12, pointF16.y, f3 + f12, f);
                }
            } else if (fullBorderWidth > BitmapDescriptorFactory.HUE_RED) {
                this.borderPaint.setColor(multiplyColorAlpha(borderColor, this.borderAlpha));
                this.borderPaint.setStyle(Paint.Style.STROKE);
                this.borderPaint.setStrokeWidth(fullBorderWidth);
                ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
                if (computedBorderRadius != null && computedBorderRadius.isUniform()) {
                    RectF rectF2 = this.tempRectForCenterDrawPath;
                    if (rectF2 != null) {
                        ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
                        float horizontal = ((computedBorderRadius2 == null || (topLeft2 = computedBorderRadius2.getTopLeft()) == null || (pixelFromDIP2 = topLeft2.toPixelFromDIP()) == null) ? 0.0f : pixelFromDIP2.getHorizontal()) - (rectFComputeBorderInsets.left * 0.5f);
                        ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
                        if (computedBorderRadius3 != null && (topLeft = computedBorderRadius3.getTopLeft()) != null && (pixelFromDIP = topLeft.toPixelFromDIP()) != null) {
                            vertical = pixelFromDIP.getVertical();
                        }
                        canvas.drawRoundRect(rectF2, horizontal, vertical - (rectFComputeBorderInsets.top * 0.5f), this.borderPaint);
                    }
                } else {
                    Path path3 = this.centerDrawPath;
                    if (path3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.drawPath(path3, this.borderPaint);
                }
            }
        }
        canvas.restore();
    }

    private final void drawQuadrilateral(Canvas canvas, int fillColor, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
        if (fillColor == 0) {
            return;
        }
        if (this.pathForBorder == null) {
            this.pathForBorder = new Path();
        }
        this.borderPaint.setColor(multiplyColorAlpha(fillColor, this.borderAlpha));
        Path path = this.pathForBorder;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.pathForBorder;
        if (path2 != null) {
            path2.moveTo(x1, y1);
        }
        Path path3 = this.pathForBorder;
        if (path3 != null) {
            path3.lineTo(x2, y2);
        }
        Path path4 = this.pathForBorder;
        if (path4 != null) {
            path4.lineTo(x3, y3);
        }
        Path path5 = this.pathForBorder;
        if (path5 != null) {
            path5.lineTo(x4, y4);
        }
        Path path6 = this.pathForBorder;
        if (path6 != null) {
            path6.lineTo(x1, y1);
        }
        Path path7 = this.pathForBorder;
        if (path7 != null) {
            canvas.drawPath(path7, this.borderPaint);
        }
    }

    private final RectF computeBorderInsets() {
        RectF rectFResolve;
        BorderInsets borderInsets = this.borderInsets;
        float fDpToPx = BitmapDescriptorFactory.HUE_RED;
        if (borderInsets != null && (rectFResolve = borderInsets.resolve(getLayoutDirection(), this.context)) != null) {
            float fDpToPx2 = Float.isNaN(rectFResolve.left) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.left);
            float fDpToPx3 = Float.isNaN(rectFResolve.top) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.top);
            float fDpToPx4 = Float.isNaN(rectFResolve.right) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.right);
            if (!Float.isNaN(rectFResolve.bottom)) {
                fDpToPx = PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom);
            }
            return new RectF(fDpToPx2, fDpToPx3, fDpToPx4, fDpToPx);
        }
        return new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    private final float getFullBorderWidth() {
        Spacing spacing = this.borderWidth;
        float raw = spacing != null ? spacing.getRaw(8) : Float.NaN;
        return !Float.isNaN(raw) ? raw : BitmapDescriptorFactory.HUE_RED;
    }

    private final void updatePathEffect() {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, getFullBorderWidth()) : null);
        }
    }

    private final void updatePathEffect(int borderWidth) {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, borderWidth) : null);
        }
    }

    private final PathEffect getPathEffect(BorderStyle style, float borderWidth) {
        int i = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            float f = borderWidth * 3;
            return new DashPathEffect(new float[]{f, f, f, f}, BitmapDescriptorFactory.HUE_RED);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new DashPathEffect(new float[]{borderWidth, borderWidth, borderWidth, borderWidth}, BitmapDescriptorFactory.HUE_RED);
    }

    private final void getEllipseIntersectionWithLine(double ellipseBoundsLeft, double ellipseBoundsTop, double ellipseBoundsRight, double ellipseBoundsBottom, double lineStartX, double lineStartY, double lineEndX, double lineEndY, PointF result) {
        double d = 2;
        double d2 = (ellipseBoundsLeft + ellipseBoundsRight) / d;
        double d3 = (ellipseBoundsTop + ellipseBoundsBottom) / d;
        double d4 = lineStartX - d2;
        double d5 = lineStartY - d3;
        double dAbs = Math.abs(ellipseBoundsRight - ellipseBoundsLeft) / d;
        double dAbs2 = Math.abs(ellipseBoundsBottom - ellipseBoundsTop) / d;
        double d6 = ((lineEndY - d3) - d5) / ((lineEndX - d2) - d4);
        double d7 = d5 - (d4 * d6);
        double d8 = dAbs2 * dAbs2;
        double d9 = dAbs * dAbs;
        double d10 = d8 + (d9 * d6 * d6);
        double d11 = d * dAbs * dAbs * d7 * d6;
        double d12 = d * d10;
        double dSqrt = ((-d11) / d12) - Math.sqrt(((-(d9 * ((d7 * d7) - d8))) / d10) + Math.pow(d11 / d12, 2.0d));
        double d13 = (d6 * dSqrt) + d7;
        double d14 = dSqrt + d2;
        double d15 = d13 + d3;
        if (Double.isNaN(d14) || Double.isNaN(d15)) {
            return;
        }
        result.x = (float) d14;
        result.y = (float) d15;
    }

    private final void updatePath() {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        Path path;
        Path path2;
        Path path3;
        CornerRadii bottomRight;
        CornerRadii bottomLeft;
        CornerRadii topRight;
        CornerRadii topLeft;
        if (this.needUpdatePath) {
            this.needUpdatePath = false;
            Path path4 = this.innerClipPathForBorderRadius;
            if (path4 == null) {
                path4 = new Path();
            }
            this.innerClipPathForBorderRadius = path4;
            Path path5 = this.outerClipPathForBorderRadius;
            if (path5 == null) {
                path5 = new Path();
            }
            this.outerClipPathForBorderRadius = path5;
            this.pathForOutline = new Path();
            RectF rectF = this.innerClipTempRectForBorderRadius;
            if (rectF == null) {
                rectF = new RectF();
            }
            this.innerClipTempRectForBorderRadius = rectF;
            RectF rectF2 = this.outerClipTempRectForBorderRadius;
            if (rectF2 == null) {
                rectF2 = new RectF();
            }
            this.outerClipTempRectForBorderRadius = rectF2;
            RectF rectF3 = this.tempRectForCenterDrawPath;
            if (rectF3 == null) {
                rectF3 = new RectF();
            }
            this.tempRectForCenterDrawPath = rectF3;
            Path path6 = this.innerClipPathForBorderRadius;
            if (path6 != null) {
                path6.reset();
                Unit unit = Unit.INSTANCE;
            }
            Path path7 = this.outerClipPathForBorderRadius;
            if (path7 != null) {
                path7.reset();
                Unit unit2 = Unit.INSTANCE;
            }
            RectF rectF4 = this.innerClipTempRectForBorderRadius;
            if (rectF4 != null) {
                rectF4.set(getBounds());
                Unit unit3 = Unit.INSTANCE;
            }
            RectF rectF5 = this.outerClipTempRectForBorderRadius;
            if (rectF5 != null) {
                rectF5.set(getBounds());
                Unit unit4 = Unit.INSTANCE;
            }
            RectF rectF6 = this.tempRectForCenterDrawPath;
            if (rectF6 != null) {
                rectF6.set(getBounds());
                Unit unit5 = Unit.INSTANCE;
            }
            RectF rectFComputeBorderInsets = computeBorderInsets();
            if (Color.alpha(this.computedBorderColors.getLeft()) != 0 || Color.alpha(this.computedBorderColors.getTop()) != 0 || Color.alpha(this.computedBorderColors.getRight()) != 0 || Color.alpha(this.computedBorderColors.getBottom()) != 0) {
                RectF rectF7 = this.innerClipTempRectForBorderRadius;
                if (rectF7 != null) {
                    rectF7.top = rectF7 != null ? rectF7.top + rectFComputeBorderInsets.top : 0.0f;
                    Unit unit6 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.bottom = rectF7 != null ? rectF7.bottom - rectFComputeBorderInsets.bottom : 0.0f;
                    Unit unit7 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.left = rectF7 != null ? rectF7.left + rectFComputeBorderInsets.left : 0.0f;
                    Unit unit8 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.right = rectF7 != null ? rectF7.right - rectFComputeBorderInsets.right : 0.0f;
                    Unit unit9 = Unit.INSTANCE;
                }
            }
            RectF rectF8 = this.tempRectForCenterDrawPath;
            if (rectF8 != null) {
                rectF8.top = rectF8 != null ? rectF8.top + (rectFComputeBorderInsets.top * 0.5f) : 0.0f;
                Unit unit10 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.bottom = rectF8 != null ? rectF8.bottom - (rectFComputeBorderInsets.bottom * 0.5f) : 0.0f;
                Unit unit11 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.left = rectF8 != null ? rectF8.left + (rectFComputeBorderInsets.left * 0.5f) : 0.0f;
                Unit unit12 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.right = rectF8 != null ? rectF8.right - (rectFComputeBorderInsets.right * 0.5f) : 0.0f;
                Unit unit13 = Unit.INSTANCE;
            }
            BorderRadiusStyle borderRadiusStyle = this.borderRadius;
            if (borderRadiusStyle != null) {
                int layoutDirection = getLayoutDirection();
                Context context = this.context;
                RectF rectF9 = this.outerClipTempRectForBorderRadius;
                float fPxToDp = rectF9 != null ? PixelUtil.INSTANCE.pxToDp(rectF9.width()) : 0.0f;
                RectF rectF10 = this.outerClipTempRectForBorderRadius;
                computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, fPxToDp, rectF10 != null ? PixelUtil.INSTANCE.pxToDp(rectF10.height()) : 0.0f);
            } else {
                computedBorderRadiusResolve = null;
            }
            this.computedBorderRadius = computedBorderRadiusResolve;
            if (computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null || (cornerRadii = topLeft.toPixelFromDIP()) == null) {
                cornerRadii = new CornerRadii(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            }
            ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
            if (computedBorderRadius == null || (topRight = computedBorderRadius.getTopRight()) == null || (cornerRadii2 = topRight.toPixelFromDIP()) == null) {
                cornerRadii2 = new CornerRadii(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            }
            ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
            if (computedBorderRadius2 == null || (bottomLeft = computedBorderRadius2.getBottomLeft()) == null || (cornerRadii3 = bottomLeft.toPixelFromDIP()) == null) {
                cornerRadii3 = new CornerRadii(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            }
            ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
            if (computedBorderRadius3 == null || (bottomRight = computedBorderRadius3.getBottomRight()) == null || (cornerRadii4 = bottomRight.toPixelFromDIP()) == null) {
                cornerRadii4 = new CornerRadii(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            }
            float innerBorderRadius = getInnerBorderRadius(cornerRadii.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius2 = getInnerBorderRadius(cornerRadii.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius3 = getInnerBorderRadius(cornerRadii2.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius4 = getInnerBorderRadius(cornerRadii2.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius5 = getInnerBorderRadius(cornerRadii4.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius6 = getInnerBorderRadius(cornerRadii4.getVertical(), rectFComputeBorderInsets.bottom);
            float innerBorderRadius7 = getInnerBorderRadius(cornerRadii3.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius8 = getInnerBorderRadius(cornerRadii3.getVertical(), rectFComputeBorderInsets.bottom);
            RectF rectF11 = this.innerClipTempRectForBorderRadius;
            if (rectF11 != null && (path3 = this.innerClipPathForBorderRadius) != null) {
                path3.addRoundRect(rectF11, new float[]{innerBorderRadius, innerBorderRadius2, innerBorderRadius3, innerBorderRadius4, innerBorderRadius5, innerBorderRadius6, innerBorderRadius7, innerBorderRadius8}, Path.Direction.CW);
                Unit unit14 = Unit.INSTANCE;
            }
            RectF rectF12 = this.outerClipTempRectForBorderRadius;
            if (rectF12 != null && (path2 = this.outerClipPathForBorderRadius) != null) {
                path2.addRoundRect(rectF12, new float[]{cornerRadii.getHorizontal(), cornerRadii.getVertical(), cornerRadii2.getHorizontal(), cornerRadii2.getVertical(), cornerRadii4.getHorizontal(), cornerRadii4.getVertical(), cornerRadii3.getHorizontal(), cornerRadii3.getVertical()}, Path.Direction.CW);
                Unit unit15 = Unit.INSTANCE;
            }
            Spacing spacing = this.borderWidth;
            float f = spacing != null ? spacing.get(8) / 2.0f : BitmapDescriptorFactory.HUE_RED;
            Path path8 = this.pathForOutline;
            if (path8 != null) {
                path8.addRoundRect(new RectF(getBounds()), new float[]{cornerRadii.getHorizontal() + f, cornerRadii.getVertical() + f, cornerRadii2.getHorizontal() + f, cornerRadii2.getVertical() + f, cornerRadii4.getHorizontal() + f, cornerRadii4.getVertical() + f, cornerRadii3.getHorizontal() + f, cornerRadii3.getVertical() + f}, Path.Direction.CW);
                Unit unit16 = Unit.INSTANCE;
            }
            ComputedBorderRadius computedBorderRadius4 = this.computedBorderRadius;
            if (computedBorderRadius4 == null || !computedBorderRadius4.isUniform()) {
                Path path9 = this.centerDrawPath;
                if (path9 == null) {
                    path9 = new Path();
                }
                this.centerDrawPath = path9;
                path9.reset();
                Unit unit17 = Unit.INSTANCE;
                RectF rectF13 = this.tempRectForCenterDrawPath;
                if (rectF13 != null && (path = this.centerDrawPath) != null) {
                    path.addRoundRect(rectF13, new float[]{cornerRadii.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f), cornerRadii.getVertical() - (rectFComputeBorderInsets.top * 0.5f), cornerRadii2.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f), cornerRadii2.getVertical() - (rectFComputeBorderInsets.top * 0.5f), cornerRadii4.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f), cornerRadii4.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f), cornerRadii3.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f), cornerRadii3.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f)}, Path.Direction.CW);
                    Unit unit18 = Unit.INSTANCE;
                }
            }
            RectF rectF14 = this.innerClipTempRectForBorderRadius;
            RectF rectF15 = this.outerClipTempRectForBorderRadius;
            if (rectF14 == null || rectF15 == null) {
                return;
            }
            PointF pointF = this.innerTopLeftCorner;
            if (pointF == null) {
                pointF = new PointF();
            }
            PointF pointF2 = pointF;
            this.innerTopLeftCorner = pointF2;
            pointF2.x = rectF14.left;
            Unit unit19 = Unit.INSTANCE;
            pointF2.y = rectF14.top;
            Unit unit20 = Unit.INSTANCE;
            float f2 = rectF14.left;
            float f3 = rectF14.top;
            float f4 = 2;
            getEllipseIntersectionWithLine(f2, f3, (innerBorderRadius * f4) + f2, (f4 * innerBorderRadius2) + f3, rectF15.left, rectF15.top, f2, f3, pointF2);
            Unit unit21 = Unit.INSTANCE;
            PointF pointF3 = this.innerBottomLeftCorner;
            if (pointF3 == null) {
                pointF3 = new PointF();
            }
            PointF pointF4 = pointF3;
            this.innerBottomLeftCorner = pointF4;
            pointF4.x = rectF14.left;
            Unit unit22 = Unit.INSTANCE;
            pointF4.y = rectF14.bottom;
            Unit unit23 = Unit.INSTANCE;
            float f5 = rectF14.left;
            float f6 = rectF14.bottom;
            float f7 = 2;
            getEllipseIntersectionWithLine(f5, f6 - (innerBorderRadius8 * f7), (f7 * innerBorderRadius7) + f5, f6, rectF15.left, rectF15.bottom, f5, f6, pointF4);
            Unit unit24 = Unit.INSTANCE;
            PointF pointF5 = this.innerTopRightCorner;
            if (pointF5 == null) {
                pointF5 = new PointF();
            }
            PointF pointF6 = pointF5;
            this.innerTopRightCorner = pointF6;
            pointF6.x = rectF14.right;
            Unit unit25 = Unit.INSTANCE;
            pointF6.y = rectF14.top;
            Unit unit26 = Unit.INSTANCE;
            float f8 = rectF14.right;
            float f9 = 2;
            float f10 = rectF14.top;
            getEllipseIntersectionWithLine(f8 - (innerBorderRadius3 * f9), f10, f8, (f9 * innerBorderRadius4) + f10, rectF15.right, rectF15.top, f8, f10, pointF6);
            Unit unit27 = Unit.INSTANCE;
            PointF pointF7 = this.innerBottomRightCorner;
            if (pointF7 == null) {
                pointF7 = new PointF();
            }
            PointF pointF8 = pointF7;
            this.innerBottomRightCorner = pointF8;
            pointF8.x = rectF14.right;
            Unit unit28 = Unit.INSTANCE;
            pointF8.y = rectF14.bottom;
            Unit unit29 = Unit.INSTANCE;
            float f11 = rectF14.right;
            float f12 = 2;
            float f13 = rectF14.bottom;
            getEllipseIntersectionWithLine(f11 - (innerBorderRadius5 * f12), f13 - (f12 * innerBorderRadius6), f11, f13, rectF15.right, rectF15.bottom, f11, f13, pointF8);
            Unit unit30 = Unit.INSTANCE;
        }
    }
}
