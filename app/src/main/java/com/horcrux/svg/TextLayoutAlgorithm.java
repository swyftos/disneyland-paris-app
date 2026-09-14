package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
class TextLayoutAlgorithm {
    TextLayoutAlgorithm() {
    }

    class CharacterInformation {
        double advance;
        char character;
        TextView element;
        int index;

        /* JADX INFO: renamed from: x */
        double f3651x = AudioStats.AUDIO_AMPLITUDE_NONE;

        /* JADX INFO: renamed from: y */
        double f3652y = AudioStats.AUDIO_AMPLITUDE_NONE;
        double rotate = AudioStats.AUDIO_AMPLITUDE_NONE;
        boolean hidden = false;
        boolean middle = false;
        boolean resolved = false;
        boolean xSpecified = false;
        boolean ySpecified = false;
        boolean addressable = true;
        boolean anchoredChunk = false;
        boolean rotateSpecified = false;
        boolean firstCharacterInResolvedDescendant = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    class LayoutInput {
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder sb, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            } else {
                while (i < str.length()) {
                    arrayList2.add(tSpanView);
                    arrayList.add(textPathView);
                    i++;
                }
                sb.append(str);
                return;
            }
        }
        if (view instanceof TextPathView) {
            textPathView = (TextPathView) view;
        }
        while (i < textPathView.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, textPathView.getChildAt(i), textPathView);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x029e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0185  */
    /* JADX WARN: Code duplicated, block: B:70:0x0197  */
    /* JADX WARN: Code duplicated, block: B:72:0x019a  */
    /* JADX WARN: Code duplicated, block: B:75:0x019e  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:80:0x01af  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b4 A[LOOP:6: B:81:0x01b2->B:82:0x01b4, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.Canvas, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r2v5 */
    CharacterInformation[] layoutText(LayoutInput layoutInput) {
        int i;
        boolean z;
        int i2;
        ArrayList<TextPathView> arrayList;
        boolean z2;
        Object obj;
        boolean z3;
        Path path;
        char c;
        double d;
        double d2;
        double d3;
        int i3;
        double d4;
        int i4;
        double d5;
        int i5;
        int i6;
        int i7 = 1;
        TextView textView = layoutInput.text;
        StringBuilder sb = new StringBuilder();
        ArrayList<TextView> arrayList2 = new ArrayList<>();
        ArrayList<TextPathView> arrayList3 = new ArrayList<>();
        getSubTreeTypographicCharacterPositions(arrayList3, arrayList2, sb, textView, null);
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        final CharacterInformation[] characterInformationArr = new CharacterInformation[length];
        for (int i8 = 0; i8 < length; i8++) {
            characterInformationArr[i8] = new CharacterInformation(i8, charArray[i8]);
        }
        if (length == 0) {
            return characterInformationArr;
        }
        PointF[] pointFArr = new PointF[length];
        for (int i9 = 0; i9 < length; i9++) {
            pointFArr[i9] = new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        }
        int i10 = 0;
        while (i10 < length) {
            CharacterInformation characterInformation = characterInformationArr[i10];
            characterInformation.addressable = true;
            characterInformation.middle = false;
            characterInformation.anchoredChunk = i10 == 0;
            pointFArr[i10].set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            i10++;
        }
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        new C1CharacterPositioningResolver(characterInformationArr, strArr, strArr2, new String[length], new String[length]);
        PointF pointF = new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        for (int i11 = 0; i11 < length; i11++) {
            if (strArr[i11].equals("")) {
                strArr[i11] = "0";
            }
            if (strArr2[i11].equals("")) {
                strArr2[i11] = "0";
            }
            pointF.x += Float.parseFloat(strArr[i11]);
            float f = pointF.y + Float.parseFloat(strArr2[i11]);
            pointF.y = f;
            CharacterInformation characterInformation2 = characterInformationArr[i11];
            PointF pointF2 = pointFArr[i11];
            characterInformation2.f3651x = pointF2.x + pointF.x;
            characterInformation2.f3652y = pointF2.y + f;
        }
        new Object() { // from class: com.horcrux.svg.TextLayoutAlgorithm.1TextLengthResolver
            int global;

            /* JADX INFO: Access modifiers changed from: private */
            public void resolveTextLength(TextView textView2) {
                Class<?> cls = textView2.getClass();
                boolean z4 = textView2.mTextLength != null;
                if (cls == TSpanView.class && z4) {
                    TSpanView tSpanView = (TSpanView) textView2;
                    String str = tSpanView.mContent;
                    int i12 = this.global;
                    int length2 = (str == null ? 0 : str.length()) + i12;
                    double dMax = Double.NEGATIVE_INFINITY;
                    int i13 = i12;
                    double dMin = Double.POSITIVE_INFINITY;
                    while (i13 <= length2) {
                        CharacterInformation[] characterInformationArr2 = characterInformationArr;
                        CharacterInformation characterInformation3 = characterInformationArr2[i12];
                        if (characterInformation3.addressable) {
                            char c2 = characterInformation3.character;
                            if (c2 == '\n' || c2 == '\r') {
                                return;
                            }
                            CharacterInformation characterInformation4 = characterInformationArr2[i13];
                            double d6 = characterInformation4.f3651x;
                            double d7 = characterInformation4.advance + d6;
                            dMin = Math.min(dMin, Math.min(d6, d7));
                            dMax = Math.max(dMax, Math.max(d6, d7));
                        }
                        i13++;
                        i12 = i12;
                    }
                    int i14 = i12;
                    if (dMin != Double.POSITIVE_INFINITY) {
                        double d8 = textView2.mTextLength.value - (dMax - dMin);
                        int length3 = 0;
                        int i15 = 0;
                        for (int i16 = 0; i16 < textView2.getChildCount(); i16++) {
                            if (((TextPathView) textView2.getChildAt(i16)).mTextLength == null) {
                                String str2 = tSpanView.mContent;
                                length3 += str2 == null ? 0 : str2.length();
                            } else {
                                characterInformationArr[length3].firstCharacterInResolvedDescendant = true;
                                i15++;
                            }
                        }
                        double d9 = d8 / ((double) (length3 + (i15 - 1)));
                        double d10 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        for (int i17 = i14; i17 <= length2; i17++) {
                            CharacterInformation characterInformation5 = characterInformationArr[i17];
                            characterInformation5.f3651x += d10;
                            if (!characterInformation5.middle && (!characterInformation5.resolved || characterInformation5.firstCharacterInResolvedDescendant)) {
                                d10 += d9;
                            }
                        }
                    }
                }
            }
        }.resolveTextLength(textView);
        pointF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        int i12 = 1;
        while (i12 < length) {
            String str = strArr[i12];
            if (str != null) {
                pointF.x = (float) (Double.parseDouble(str) - characterInformationArr[i12].f3651x);
            }
            String str2 = strArr2[i12];
            if (str2 != null) {
                pointF.y = (float) (Double.parseDouble(str2) - characterInformationArr[i12].f3652y);
            }
            CharacterInformation characterInformation3 = characterInformationArr[i12];
            characterInformation3.f3651x += (double) pointF.x;
            characterInformation3.f3652y += (double) pointF.y;
            if (characterInformation3.middle && characterInformation3.anchoredChunk) {
                characterInformation3.anchoredChunk = false;
            }
            i12++;
            if (i12 < length) {
                characterInformationArr[i12].anchoredChunk = true;
            }
        }
        int i13 = 0;
        int i14 = 0;
        double dMin = Double.POSITIVE_INFINITY;
        double d6 = Double.NEGATIVE_INFINITY;
        double d7 = Double.POSITIVE_INFINITY;
        double d8 = Double.NEGATIVE_INFINITY;
        while (i13 < length) {
            CharacterInformation characterInformation4 = characterInformationArr[i13];
            if (characterInformation4.addressable) {
                if (characterInformation4.anchoredChunk) {
                    d7 = dMin;
                    d8 = d6;
                    dMin = Double.POSITIVE_INFINITY;
                    d2 = Double.NEGATIVE_INFINITY;
                } else {
                    d2 = d6;
                }
                double d9 = characterInformation4.f3651x;
                double d10 = characterInformation4.advance + d9;
                dMin = Math.min(dMin, Math.min(d9, d10));
                double dMax = Math.max(d2, Math.max(d9, d10));
                if (i13 > 0 && characterInformationArr[i13].anchoredChunk) {
                    if (d7 != Double.POSITIVE_INFINITY) {
                        i3 = 1;
                    }
                    TextProperties.TextAnchor textAnchor = TextProperties.TextAnchor.start;
                    TextProperties.Direction direction = TextProperties.Direction.ltr;
                    i4 = length - 1;
                    if (i13 == i4) {
                        d8 = dMax;
                        d7 = dMin;
                    }
                    d5 = characterInformationArr[i14].f3651x;
                    i5 = C44071.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
                    if (i5 != i3) {
                        d5 -= d7;
                    } else if (i5 != 2) {
                        d5 -= (d7 + d8) / 2.0d;
                    } else if (i5 == 3) {
                        d5 -= d8;
                    }
                    if (i13 == i4) {
                        i6 = i13;
                        i3 = 1;
                    } else {
                        i3 = 1;
                        i6 = i13 - 1;
                    }
                    while (i14 <= i6) {
                        characterInformationArr[i14].f3651x += d5;
                        i14 += i3;
                        dMax = dMax;
                    }
                    d3 = dMax;
                    i14 = i13;
                    d4 = d3;
                }
                i3 = 1;
                if (i13 == length - 1) {
                    TextProperties.TextAnchor textAnchor2 = TextProperties.TextAnchor.start;
                    TextProperties.Direction direction2 = TextProperties.Direction.ltr;
                    i4 = length - 1;
                    if (i13 == i4) {
                        d8 = dMax;
                        d7 = dMin;
                    }
                    d5 = characterInformationArr[i14].f3651x;
                    i5 = C44071.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor2.ordinal()];
                    if (i5 != i3) {
                        d5 -= d7;
                    } else if (i5 != 2) {
                        d5 -= (d7 + d8) / 2.0d;
                    } else if (i5 == 3) {
                        d5 -= d8;
                    }
                    if (i13 == i4) {
                        i6 = i13;
                        i3 = 1;
                    } else {
                        i3 = 1;
                        i6 = i13 - 1;
                    }
                    while (i14 <= i6) {
                        characterInformationArr[i14].f3651x += d5;
                        i14 += i3;
                        dMax = dMax;
                    }
                    d3 = dMax;
                    i14 = i13;
                } else {
                    d3 = dMax;
                }
                d4 = d3;
            } else {
                i3 = i7;
                d4 = d6;
            }
            i13 += i3;
            i7 = i3;
            arrayList3 = arrayList3;
            d6 = d4;
        }
        ArrayList<TextPathView> arrayList4 = arrayList3;
        PointF pointF3 = new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        PathMeasure pathMeasure = new PathMeasure();
        ?? r2 = 0;
        Path path2 = null;
        int i15 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (i15 < length) {
            ArrayList<TextPathView> arrayList5 = arrayList4;
            TextPathView textPathView = arrayList5.get(i15);
            if (textPathView == 0 || !characterInformationArr[i15].addressable) {
                i = i15;
                z = z4;
                i2 = i14;
                arrayList = arrayList5;
                z2 = z5;
            } else {
                Path textPath = textPathView.getTextPath(r2, r2);
                CharacterInformation characterInformation5 = characterInformationArr[i15];
                if (!characterInformation5.middle) {
                    textPathView.getSide();
                    TextProperties.TextPathSide textPathSide = TextProperties.TextPathSide.left;
                    pathMeasure.setPath(textPath, false);
                    double length2 = pathMeasure.getLength();
                    double d11 = textPathView.getStartOffset().value;
                    CharacterInformation characterInformation6 = characterInformationArr[i15];
                    i = i15;
                    double d12 = characterInformation6.advance;
                    path = textPath;
                    arrayList = arrayList5;
                    double d13 = characterInformation6.f3651x;
                    z = z4;
                    i2 = i14;
                    double d14 = characterInformation6.f3652y;
                    double d15 = characterInformation6.rotate;
                    double d16 = d13 + (d12 / 2.0d) + d11;
                    if (!pathMeasure.isClosed() && (d16 < AudioStats.AUDIO_AMPLITUDE_NONE || d16 > length2)) {
                        characterInformationArr[i].hidden = true;
                    }
                    if (pathMeasure.isClosed()) {
                        TextProperties.TextAnchor textAnchor3 = TextProperties.TextAnchor.start;
                        TextProperties.Direction direction3 = TextProperties.Direction.ltr;
                        double d17 = characterInformationArr[i2].f3651x;
                        int i16 = C44071.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor3.ordinal()];
                        if (i16 == 1) {
                            c = 1;
                            if (d16 < AudioStats.AUDIO_AMPLITUDE_NONE || d16 > length2) {
                                characterInformationArr[i].hidden = true;
                            }
                        } else if (i16 != 2) {
                            if (i16 == 3 && (d16 < (-length2) || d16 > AudioStats.AUDIO_AMPLITUDE_NONE)) {
                                characterInformationArr[i].hidden = true;
                                c = 1;
                            }
                        } else if (d16 < (-length2) / 2.0d || d16 > length2 / 2.0d) {
                            c = 1;
                            characterInformationArr[i].hidden = true;
                        }
                        d = d16 % length2;
                        if (!characterInformationArr[i].hidden) {
                            float[] fArr = new float[2];
                            pathMeasure.getPosTan((float) d, new float[2], fArr);
                            double dAtan2 = Math.atan2(fArr[c], fArr[0]) * 57.29577951308232d;
                            double d18 = 90.0d + dAtan2;
                            Math.cos(d18);
                            Math.sin(d18);
                            characterInformationArr[i].rotate += dAtan2;
                        }
                    }
                    c = 1;
                    d = d16 % length2;
                    if (!characterInformationArr[i].hidden) {
                        float[] fArr2 = new float[2];
                        pathMeasure.getPosTan((float) d, new float[2], fArr2);
                        double dAtan3 = Math.atan2(fArr2[c], fArr2[0]) * 57.29577951308232d;
                        double d19 = 90.0d + dAtan3;
                        Math.cos(d19);
                        Math.sin(d19);
                        characterInformationArr[i].rotate += dAtan3;
                    }
                } else {
                    i = i15;
                    z = z4;
                    i2 = i14;
                    path = textPath;
                    arrayList = arrayList5;
                    CharacterInformation characterInformation7 = characterInformationArr[i - 1];
                    characterInformation5.f3651x = characterInformation7.f3651x;
                    characterInformation5.f3652y = characterInformation7.f3652y;
                    characterInformation5.rotate = characterInformation7.rotate;
                }
                path2 = path;
                z2 = true;
            }
            if (textPathView == 0 && characterInformationArr[i].addressable) {
                if (z2) {
                    pathMeasure.setPath(path2, false);
                    float[] fArr3 = new float[2];
                    obj = null;
                    pathMeasure.getPosTan(pathMeasure.getLength(), fArr3, null);
                    pointF3.set(fArr3[0], fArr3[1]);
                    z5 = false;
                    z3 = true;
                } else {
                    obj = null;
                    z5 = z2;
                    z3 = z;
                }
                if (z3) {
                    CharacterInformation characterInformation8 = characterInformationArr[i];
                    if (characterInformation8.anchoredChunk) {
                        z3 = false;
                    } else {
                        characterInformation8.f3651x += (double) pointF3.x;
                        characterInformation8.f3652y += (double) pointF3.y;
                    }
                }
            } else {
                obj = null;
                z5 = z2;
                z3 = z;
            }
            z4 = z3;
            r2 = obj;
            i15 = i + 1;
            arrayList4 = arrayList;
            i14 = i2;
        }
        return characterInformationArr;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver, reason: invalid class name */
    class C1CharacterPositioningResolver {
        private int global;
        private boolean horizontal;
        private boolean in_text_path;
        private String[] resolve_dx;
        private String[] resolve_dy;
        private String[] resolve_x;
        private String[] resolve_y;
        private CharacterInformation[] result;

        private C1CharacterPositioningResolver(CharacterInformation[] characterInformationArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.global = 0;
            this.horizontal = true;
            this.in_text_path = false;
            this.result = characterInformationArr;
            this.resolve_x = strArr;
            this.resolve_y = strArr2;
            this.resolve_dx = strArr3;
            this.resolve_dy = strArr4;
        }

        private void resolveCharacterPositioning(TextView textView) {
            boolean z = false;
            if (textView.getClass() == TextView.class || textView.getClass() == TSpanView.class) {
                int i = this.global;
                String[] strArr = new String[0];
                String[] strArr2 = new String[0];
                String[] strArr3 = new String[0];
                String[] strArr4 = new String[0];
                double[] dArr = new double[0];
                int iMax = !this.in_text_path ? Math.max(0, 0) : 0;
                String str = ((TSpanView) textView).mContent;
                int length = str == null ? 0 : str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    CharacterInformation[] characterInformationArr = this.result;
                    int i4 = i + i2;
                    CharacterInformation characterInformation = characterInformationArr[i4];
                    if (characterInformation.addressable) {
                        characterInformation.anchoredChunk = i3 < iMax ? true : z;
                        if (i3 < 0) {
                            this.resolve_x[i4] = strArr[i3];
                        }
                        boolean z2 = this.in_text_path;
                        if (z2 && !this.horizontal) {
                            this.resolve_x[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_y[i4] = strArr2[i3];
                        }
                        if (z2 && this.horizontal) {
                            this.resolve_y[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_dx[i4] = strArr3[i3];
                        }
                        if (i3 < 0) {
                            this.resolve_dy[i4] = strArr4[i3];
                        }
                        if (i3 < 0) {
                            characterInformationArr[i4].rotate = dArr[i3];
                        }
                    }
                    i3++;
                    i2++;
                    z = false;
                }
                return;
            }
            if (textView.getClass() == TextPathView.class) {
                this.result[this.global].anchoredChunk = true;
                this.in_text_path = true;
                for (int i5 = 0; i5 < textView.getChildCount(); i5++) {
                    resolveCharacterPositioning((TextView) textView.getChildAt(i5));
                }
                if (textView instanceof TextPathView) {
                    this.in_text_path = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1 */
    static /* synthetic */ class C44071 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;

        static {
            int[] iArr = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr;
            try {
                iArr[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
