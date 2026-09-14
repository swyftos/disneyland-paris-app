package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.text.ReactFontManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.text.Bidi;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
class TSpanView extends TextView {
    private static final String FONTS = "fonts/";
    private static final String OTF = ".otf";
    private static final String TTF = ".ttf";
    static final String additionalLigatures = "'hlig', 'cala', ";
    static final String defaultFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', ";
    static final String disableDiscretionaryLigatures = "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ";
    static final String fontWeightTag = "'wght' ";
    private static final double radToDeg = 57.29577951308232d;
    static final String requiredFontFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',";
    private static final double tau = 6.283185307179586d;
    private final AssetManager assets;
    private final ArrayList<String> emoji;
    private final ArrayList<Matrix> emojiTransforms;
    private Path mCachedPath;

    @Nullable
    String mContent;
    private TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
        this.emoji = new ArrayList<>();
        this.emojiTransforms = new ArrayList<>();
        this.assets = this.mContext.getResources().getAssets();
    }

    public void setContent(@Nullable String str) {
        this.mContent = str;
        invalidate();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView, android.view.View
    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView
    void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent != null) {
            SVGLength sVGLength = this.mInlineSize;
            if (sVGLength != null && sVGLength.value != AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (setupFillPaint(paint, this.fillOpacity * f)) {
                    drawWrappedText(canvas, paint);
                }
                if (setupStrokePaint(paint, f * this.strokeOpacity)) {
                    drawWrappedText(canvas, paint);
                    return;
                }
                return;
            }
            int size = this.emoji.size();
            if (size > 0) {
                applyTextPropertiesToPaint(paint, getTextRootGlyphContext().getFont());
                for (int i = 0; i < size; i++) {
                    String str = this.emoji.get(i);
                    Matrix matrix = this.emojiTransforms.get(i);
                    canvas.save();
                    canvas.concat(matrix);
                    canvas.drawText(str, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
                    canvas.restore();
                }
            }
            drawPath(canvas, paint, f);
            return;
        }
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    private void drawWrappedText(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        pushGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        TextPaint textPaint = new TextPaint(paint);
        applyTextPropertiesToPaint(textPaint, font);
        applySpacingAndFeatures(textPaint, font);
        double fontSize = textRootGlyphContext.getFontSize();
        int i = C44061.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[font.textAnchor.ordinal()];
        if (i == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout staticLayout = getStaticLayout(textPaint, alignment, true, new SpannableString(this.mContent), (int) PropHelper.fromRelative(this.mInlineSize, canvas.getWidth(), AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, fontSize));
        int lineAscent = staticLayout.getLineAscent(0);
        float fNextX = (float) textRootGlyphContext.nextX(AudioStats.AUDIO_AMPLITUDE_NONE);
        float fNextY = (float) (textRootGlyphContext.nextY() + ((double) lineAscent));
        popGlyphContext();
        canvas.save();
        canvas.translate(fNextX, fNextY);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private StaticLayout getStaticLayout(TextPaint textPaint, Layout.Alignment alignment, boolean z, SpannableString spannableString, int i) {
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i).setAlignment(alignment).setLineSpacing(BitmapDescriptorFactory.HUE_RED, 1.0f).setIncludePad(z).setBreakStrategy(1).setHyphenationFrequency(1).build();
    }

    public static String visualToLogical(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Bidi bidi = new Bidi(str, -2);
        if (bidi.isLeftToRight()) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i = 0; i < runCount; i++) {
            bArr[i] = (byte) bidi.getRunLevel(i);
            numArr[i] = Integer.valueOf(i);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < runCount; i2++) {
            int iIntValue = numArr[i2].intValue();
            int runStart = bidi.getRunStart(iIntValue);
            int runLimit = bidi.getRunLimit(iIntValue);
            if ((bArr[iIntValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit >= runStart) {
                        sb.append(str.charAt(runLimit));
                    }
                }
            } else {
                sb.append((CharSequence) str, runStart, runLimit);
            }
        }
        return sb.toString();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mCachedPath;
        if (path != null) {
            return path;
        }
        if (this.mContent == null) {
            Path groupPath = getGroupPath(canvas, paint);
            this.mCachedPath = groupPath;
            return groupPath;
        }
        setupTextPath();
        pushGlyphContext();
        this.mCachedPath = getLinePath(visualToLogical(this.mContent), paint, canvas);
        popGlyphContext();
        return this.mCachedPath;
    }

    @Override // com.horcrux.svg.TextView
    double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        double subtreeTextChunksTotalAdvance = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (str == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    subtreeTextChunksTotalAdvance += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
                }
            }
            this.cachedAdvance = subtreeTextChunksTotalAdvance;
            return subtreeTextChunksTotalAdvance;
        }
        if (str.length() == 0) {
            this.cachedAdvance = AudioStats.AUDIO_AMPLITUDE_NONE;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        FontData font = getTextRootGlyphContext().getFont();
        applyTextPropertiesToPaint(paint, font);
        applySpacingAndFeatures(paint, font);
        double dMeasureText = paint.measureText(str);
        this.cachedAdvance = dMeasureText;
        return dMeasureText;
    }

    private void applySpacingAndFeatures(Paint paint, FontData fontData) {
        double d = fontData.letterSpacing;
        paint.setLetterSpacing((float) (d / (fontData.fontSize * ((double) this.mScale))));
        if (d == AudioStats.AUDIO_AMPLITUDE_NONE && fontData.fontVariantLigatures == TextProperties.FontVariantLigatures.normal) {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + fontData.fontFeatureSettings);
        } else {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + fontData.fontFeatureSettings);
        }
        paint.setFontVariationSettings(fontWeightTag + fontData.absoluteFontWeight + fontData.fontVariationSettings);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:123:0x0317  */
    /* JADX WARN: Code duplicated, block: B:125:0x0321  */
    /* JADX WARN: Code duplicated, block: B:126:0x032a  */
    /* JADX WARN: Code duplicated, block: B:136:0x036e  */
    /* JADX WARN: Code duplicated, block: B:139:0x037a  */
    /* JADX WARN: Code duplicated, block: B:140:0x037c  */
    /* JADX WARN: Code duplicated, block: B:142:0x037f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0382  */
    /* JADX WARN: Code duplicated, block: B:146:0x038a  */
    /* JADX WARN: Code duplicated, block: B:147:0x0391  */
    /* JADX WARN: Code duplicated, block: B:151:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:30:0x0102  */
    /* JADX WARN: Code duplicated, block: B:31:0x0105  */
    /* JADX WARN: Code duplicated, block: B:34:0x0111  */
    /* JADX WARN: Code duplicated, block: B:35:0x0114  */
    /* JADX WARN: Code duplicated, block: B:38:0x0135  */
    /* JADX WARN: Code duplicated, block: B:40:0x013b  */
    /* JADX WARN: Code duplicated, block: B:41:0x013d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0147  */
    /* JADX WARN: Code duplicated, block: B:45:0x014b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0160  */
    /* JADX WARN: Code duplicated, block: B:50:0x0180  */
    /* JADX WARN: Code duplicated, block: B:52:0x018d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0196  */
    /* JADX WARN: Code duplicated, block: B:55:0x0199  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:62:0x01de  */
    /* JADX WARN: Code duplicated, block: B:64:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:66:0x01ec A[PHI: r11
  0x01ec: PHI (r11v26 double) = (r11v8 double), (r11v23 double), (r11v24 double), (r11v28 double) binds: [B:61:0x01db, B:71:0x0201, B:69:0x01fb, B:65:0x01ea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:71:0x0201  */
    /* JADX WARN: Code duplicated, block: B:72:0x0205  */
    /* JADX WARN: Code duplicated, block: B:73:0x021d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0224  */
    /* JADX WARN: Code duplicated, block: B:84:0x0250  */
    /* JADX WARN: Code duplicated, block: B:99:0x028a A[PHI: r3
  0x028a: PHI (r3v17 double) = 
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v16 double)
  (r3v34 double)
 binds: [B:75:0x022b, B:77:0x0231, B:79:0x023d, B:81:0x0241, B:97:0x0276, B:100:0x028e, B:102:0x0294, B:104:0x029a, B:106:0x02a8, B:108:0x02b4, B:98:0x0279] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x0083, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x009e, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    private Path getLinePath(String str, Paint paint, Canvas canvas) {
        PathMeasure pathMeasure;
        boolean z;
        double d;
        boolean[] zArr;
        boolean z2;
        Paint paint2;
        float[] fArr;
        TextProperties.TextAnchor textAnchor;
        double subtreeTextChunksTotalAdvance;
        double textAnchorOffset;
        double fontSize;
        float[] fArr2;
        double d2;
        double d3;
        boolean z3;
        int i;
        SVGLength sVGLength;
        double d4;
        double d5;
        boolean z4;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        int i2;
        double dFromRelative;
        double d11;
        double d12;
        double d13;
        String baselineShift;
        TextProperties.AlignmentBaseline alignmentBaseline;
        boolean z5;
        double d14;
        Matrix matrix;
        float[] fArr3;
        double d15;
        int i3;
        char c;
        String strValueOf;
        boolean z6;
        int i4;
        String str2;
        boolean z7;
        int i5;
        double d16;
        String str3;
        double dMeasureText;
        boolean z8;
        double d17;
        double d18;
        double d19;
        GlyphContext glyphContext;
        char c2;
        GlyphPathBag glyphPathBag;
        String str4;
        boolean z9;
        Path orCreateAndCache;
        int i6;
        double d20;
        int i7;
        ?? r21;
        double d21;
        double dFromRelative2;
        boolean z10;
        int i8;
        double absoluteStartOffset;
        double d22;
        double d23;
        int length = str.length();
        Path path = new Path();
        this.emoji.clear();
        this.emojiTransforms.clear();
        if (length == 0) {
            return path;
        }
        boolean z11 = this.textPath != null;
        if (z11) {
            PathMeasure pathMeasure2 = new PathMeasure(this.textPath.getTextPath(canvas, paint), false);
            double length2 = pathMeasure2.getLength();
            boolean zIsClosed = pathMeasure2.isClosed();
            if (length2 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return path;
            }
            pathMeasure = pathMeasure2;
            d = length2;
            z = zIsClosed;
        } else {
            pathMeasure = null;
            z = false;
            d = 0.0d;
        }
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        applyTextPropertiesToPaint(paint, font);
        GlyphPathBag glyphPathBag2 = new GlyphPathBag(paint);
        boolean[] zArr2 = new boolean[length];
        char[] charArray = str.toCharArray();
        PathMeasure pathMeasure3 = pathMeasure;
        double d24 = font.kerning;
        double d25 = font.wordSpacing;
        double d26 = font.letterSpacing;
        double d27 = d25;
        boolean z12 = font.manualKerning;
        if (d26 == AudioStats.AUDIO_AMPLITUDE_NONE) {
            zArr = zArr2;
            z2 = font.fontVariantLigatures == TextProperties.FontVariantLigatures.normal;
            if (z2) {
                paint2 = paint;
                paint2.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + font.fontFeatureSettings);
            } else {
                paint2 = paint;
                paint2.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + font.fontFeatureSettings);
            }
            paint2.setFontVariationSettings(fontWeightTag + font.absoluteFontWeight + font.fontVariationSettings);
            ReadableMap readableMap = font.fontData;
            fArr = new float[length];
            paint2.getTextWidths(str, fArr);
            textAnchor = font.textAnchor;
            subtreeTextChunksTotalAdvance = getTextAnchorRoot().getSubtreeTextChunksTotalAdvance(paint2);
            textAnchorOffset = getTextAnchorOffset(textAnchor, subtreeTextChunksTotalAdvance);
            fontSize = textRootGlyphContext.getFontSize();
            if (z11) {
                if (this.textPath.getMidLine() == TextProperties.TextPathMidLine.sharp) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (this.textPath.getSide() == TextProperties.TextPathSide.right) {
                    i8 = -1;
                } else {
                    i8 = 1;
                }
                fArr2 = fArr;
                d2 = d;
                absoluteStartOffset = getAbsoluteStartOffset(this.textPath.getStartOffset(), d, fontSize);
                textAnchorOffset += absoluteStartOffset;
                if (z) {
                    d22 = d2 / 2.0d;
                    if (textAnchor == TextProperties.TextAnchor.middle) {
                        d23 = -d22;
                    } else {
                        d23 = 0.0d;
                    }
                    d3 = absoluteStartOffset + d23;
                    d = d3 + d2;
                } else {
                    d = d2;
                    d3 = 0.0d;
                }
                z3 = z10;
                i = i8;
            } else {
                fArr2 = fArr;
                d2 = d;
                d3 = 0.0d;
                z3 = false;
                i = 1;
            }
            sVGLength = this.mTextLength;
            d4 = 1.0d;
            if (sVGLength != null) {
                d6 = d2;
                z4 = z3;
                d5 = d3;
                dFromRelative2 = PropHelper.fromRelative(sVGLength, canvas.getWidth(), AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, fontSize);
                if (dFromRelative2 >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                    throw new IllegalArgumentException("Negative textLength value");
                }
                if (C44061.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[this.mLengthAdjust.ordinal()] != 2) {
                    d26 += (dFromRelative2 - subtreeTextChunksTotalAdvance) / ((double) (length - 1));
                } else {
                    d4 = dFromRelative2 / subtreeTextChunksTotalAdvance;
                }
            } else {
                d5 = d3;
                z4 = z3;
                d6 = d2;
            }
            d7 = d26;
            double d28 = i;
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            d8 = fontMetrics.descent;
            float f = fontMetrics.leading;
            d9 = d4 * d28;
            d10 = ((double) f) + d8;
            i2 = i;
            double d29 = d;
            dFromRelative = (-fontMetrics.ascent) + f;
            d11 = d28;
            d12 = -fontMetrics.top;
            d13 = d12 + d10;
            baselineShift = getBaselineShift();
            alignmentBaseline = getAlignmentBaseline();
            if (alignmentBaseline != null) {
                switch (C44061.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[alignmentBaseline.ordinal()]) {
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                        paint = paint;
                        z5 = false;
                        dFromRelative = -d8;
                        break;
                    case 5:
                        paint = paint;
                        z5 = false;
                        dFromRelative = 0.0d;
                        break;
                    case 7:
                        Rect rect = new Rect();
                        paint = paint;
                        z5 = false;
                        paint.getTextBounds("x", 0, 1, rect);
                        dFromRelative = ((double) rect.height()) / 2.0d;
                        break;
                    case 8:
                        d10 = (dFromRelative - d8) / 2.0d;
                        dFromRelative = d10;
                        z5 = false;
                        paint = paint;
                        break;
                    case 9:
                        d21 = 0.5d;
                        d10 = dFromRelative * d21;
                        dFromRelative = d10;
                        z5 = false;
                        paint = paint;
                        break;
                    case 10:
                        d21 = 0.8d;
                        d10 = dFromRelative * d21;
                        dFromRelative = d10;
                        z5 = false;
                        paint = paint;
                        break;
                    case 11:
                    case 12:
                    case 13:
                        z5 = false;
                        break;
                    case 14:
                        dFromRelative = d10;
                        z5 = false;
                        paint = paint;
                        break;
                    case 15:
                        d10 = d13 / 2.0d;
                        dFromRelative = d10;
                        z5 = false;
                        paint = paint;
                        break;
                    case 16:
                        dFromRelative = d12;
                        z5 = false;
                        break;
                    default:
                        dFromRelative = 0.0d;
                        z5 = false;
                        break;
                }
            } else {
                paint = paint;
                z5 = false;
                dFromRelative = 0.0d;
            }
            if (baselineShift == null && !baselineShift.isEmpty() && (i7 = C44061.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[alignmentBaseline.ordinal()]) != 14 && i7 != 16) {
                switch (baselineShift.hashCode()) {
                    case -1720785339:
                        if (!baselineShift.equals("baseline")) {
                            r21 = -1;
                        } else {
                            r21 = z5;
                        }
                        break;
                    case 114240:
                        if (!baselineShift.equals("sub")) {
                            r21 = -1;
                        } else {
                            r21 = 1;
                        }
                        break;
                    case 109801339:
                        if (!baselineShift.equals("super")) {
                            r21 = -1;
                        } else {
                            r21 = 2;
                        }
                        break;
                    default:
                        r21 = -1;
                        break;
                }
                switch (r21) {
                    case 0:
                        d14 = d6;
                        break;
                    case 1:
                        d14 = d6;
                        if (
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r30v0 ??
                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                            */
                        /*
                            Method dump skipped, instruction units count: 1502
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.getLinePath(java.lang.String, android.graphics.Paint, android.graphics.Canvas):android.graphics.Path");
                    }

                    /* JADX INFO: renamed from: com.horcrux.svg.TSpanView$1 */
                    static /* synthetic */ class C44061 {
                        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline;
                        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;
                        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust;

                        static {
                            int[] iArr = new int[TextProperties.AlignmentBaseline.values().length];
                            $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline = iArr;
                            try {
                                iArr[TextProperties.AlignmentBaseline.baseline.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textBottom.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.afterEdge.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textAfterEdge.ordinal()] = 4;
                            } catch (NoSuchFieldError unused4) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.alphabetic.ordinal()] = 5;
                            } catch (NoSuchFieldError unused5) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.ideographic.ordinal()] = 6;
                            } catch (NoSuchFieldError unused6) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.middle.ordinal()] = 7;
                            } catch (NoSuchFieldError unused7) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.central.ordinal()] = 8;
                            } catch (NoSuchFieldError unused8) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.mathematical.ordinal()] = 9;
                            } catch (NoSuchFieldError unused9) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.hanging.ordinal()] = 10;
                            } catch (NoSuchFieldError unused10) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textTop.ordinal()] = 11;
                            } catch (NoSuchFieldError unused11) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.beforeEdge.ordinal()] = 12;
                            } catch (NoSuchFieldError unused12) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textBeforeEdge.ordinal()] = 13;
                            } catch (NoSuchFieldError unused13) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.bottom.ordinal()] = 14;
                            } catch (NoSuchFieldError unused14) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.center.ordinal()] = 15;
                            } catch (NoSuchFieldError unused15) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.top.ordinal()] = 16;
                            } catch (NoSuchFieldError unused16) {
                            }
                            int[] iArr2 = new int[TextProperties.TextLengthAdjust.values().length];
                            $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust = iArr2;
                            try {
                                iArr2[TextProperties.TextLengthAdjust.spacing.ordinal()] = 1;
                            } catch (NoSuchFieldError unused17) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[TextProperties.TextLengthAdjust.spacingAndGlyphs.ordinal()] = 2;
                            } catch (NoSuchFieldError unused18) {
                            }
                            int[] iArr3 = new int[TextProperties.TextAnchor.values().length];
                            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr3;
                            try {
                                iArr3[TextProperties.TextAnchor.start.ordinal()] = 1;
                            } catch (NoSuchFieldError unused19) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
                            } catch (NoSuchFieldError unused20) {
                            }
                            try {
                                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
                            } catch (NoSuchFieldError unused21) {
                            }
                        }
                    }

                    private double getAbsoluteStartOffset(SVGLength sVGLength, double d, double d2) {
                        return PropHelper.fromRelative(sVGLength, d, AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, d2);
                    }

                    private double getTextAnchorOffset(TextProperties.TextAnchor textAnchor, double d) {
                        int i = C44061.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
                        if (i != 2) {
                            return i != 3 ? AudioStats.AUDIO_AMPLITUDE_NONE : -d;
                        }
                        return (-d) / 2.0d;
                    }

                    private void applyTextPropertiesToPaint(Paint paint, FontData fontData) {
                        Typeface typeface;
                        int i = 0;
                        boolean z = fontData.fontWeight == TextProperties.FontWeight.Bold || fontData.absoluteFontWeight >= 550;
                        boolean z2 = fontData.fontStyle == TextProperties.FontStyle.italic;
                        if (z && z2) {
                            i = 3;
                        } else if (z) {
                            i = 1;
                        } else if (z2) {
                            i = 2;
                        }
                        int i2 = fontData.absoluteFontWeight;
                        String str = fontData.fontFamily;
                        if (str == null || str.length() <= 0) {
                            typeface = null;
                        } else {
                            String str2 = FONTS + str + OTF;
                            String str3 = FONTS + str + TTF;
                            Typeface.Builder builder = new Typeface.Builder(this.assets, str2);
                            builder.setFontVariationSettings(fontWeightTag + i2 + fontData.fontVariationSettings);
                            builder.setWeight(i2);
                            builder.setItalic(z2);
                            typeface = builder.build();
                            if (typeface == null) {
                                Typeface.Builder builder2 = new Typeface.Builder(this.assets, str3);
                                builder2.setFontVariationSettings(fontWeightTag + i2 + fontData.fontVariationSettings);
                                builder2.setWeight(i2);
                                builder2.setItalic(z2);
                                typeface = builder2.build();
                            }
                        }
                        if (typeface == null) {
                            try {
                                typeface = ReactFontManager.getInstance().getTypeface(str, i, this.assets);
                            } catch (Exception unused) {
                            }
                        }
                        Typeface typefaceCreate = Typeface.create(typeface, i2, z2);
                        paint.setLinearText(true);
                        paint.setSubpixelText(true);
                        paint.setTypeface(typefaceCreate);
                        paint.setTextSize((float) (fontData.fontSize * ((double) this.mScale)));
                        paint.setLetterSpacing(BitmapDescriptorFactory.HUE_RED);
                    }

                    private void setupTextPath() {
                        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                            if (parent.getClass() == TextPathView.class) {
                                this.textPath = (TextPathView) parent;
                                return;
                            } else {
                                if (!(parent instanceof TextView)) {
                                    return;
                                }
                            }
                        }
                    }

                    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
                    int hitTest(float[] fArr) {
                        Region region;
                        if (this.mContent == null) {
                            return super.hitTest(fArr);
                        }
                        if (this.mPath != null && this.mInvertible) {
                            float[] fArr2 = new float[2];
                            this.mInvMatrix.mapPoints(fArr2, fArr);
                            this.mInvTransform.mapPoints(fArr2);
                            int iRound = Math.round(fArr2[0]);
                            int iRound2 = Math.round(fArr2[1]);
                            initBounds();
                            Region region2 = this.mRegion;
                            if ((region2 != null && region2.contains(iRound, iRound2)) || ((region = this.mStrokeRegion) != null && region.contains(iRound, iRound2))) {
                                if (getClipPath() == null || this.mClipRegion.contains(iRound, iRound2)) {
                                    return getId();
                                }
                                return -1;
                            }
                        }
                        return -1;
                    }
                }
