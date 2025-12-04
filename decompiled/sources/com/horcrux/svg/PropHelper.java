package com.horcrux.svg;

import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.SVGLength;

/* loaded from: classes4.dex */
class PropHelper {
    private static final int inputMatrixDataSize = 6;

    PropHelper() {
    }

    static int toMatrixData(ReadableArray readableArray, float[] fArr, float f) {
        int size = readableArray.size();
        if (size != 6) {
            return size;
        }
        fArr[0] = (float) readableArray.getDouble(0);
        fArr[1] = (float) readableArray.getDouble(2);
        fArr[2] = ((float) readableArray.getDouble(4)) * f;
        fArr[3] = (float) readableArray.getDouble(1);
        fArr[4] = (float) readableArray.getDouble(3);
        fArr[5] = ((float) readableArray.getDouble(5)) * f;
        return 6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static double fromRelative(java.lang.String r8, double r9, double r11, double r13) {
        /*
            r0 = 2
            r1 = 0
            java.lang.String r8 = r8.trim()
            int r2 = r8.length()
            r3 = 1
            int r4 = r2 + (-1)
            if (r2 == 0) goto Lcb
            java.lang.String r5 = "normal"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L19
            goto Lcb
        L19:
            int r5 = r8.codePointAt(r4)
            r6 = 37
            if (r5 != r6) goto L32
            java.lang.String r8 = r8.substring(r1, r4)
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            double r11 = r8.doubleValue()
            r13 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r11 = r11 / r13
            double r11 = r11 * r9
            return r11
        L32:
            int r9 = r2 + (-2)
            if (r9 <= 0) goto Lc2
            java.lang.String r10 = r8.substring(r9)
            r10.hashCode()
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6 = -1
            int r7 = r10.hashCode()
            switch(r7) {
                case 3178: goto L89;
                case 3240: goto L7e;
                case 3365: goto L75;
                case 3488: goto L6a;
                case 3571: goto L5f;
                case 3588: goto L54;
                case 3592: goto L49;
                default: goto L47;
            }
        L47:
            r0 = r6
            goto L93
        L49:
            java.lang.String r0 = "px"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L52
            goto L47
        L52:
            r0 = 6
            goto L93
        L54:
            java.lang.String r0 = "pt"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L5d
            goto L47
        L5d:
            r0 = 5
            goto L93
        L5f:
            java.lang.String r0 = "pc"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L68
            goto L47
        L68:
            r0 = 4
            goto L93
        L6a:
            java.lang.String r0 = "mm"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L73
            goto L47
        L73:
            r0 = 3
            goto L93
        L75:
            java.lang.String r3 = "in"
            boolean r10 = r10.equals(r3)
            if (r10 != 0) goto L93
            goto L47
        L7e:
            java.lang.String r0 = "em"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L87
            goto L47
        L87:
            r0 = r3
            goto L93
        L89:
            java.lang.String r0 = "cm"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L92
            goto L47
        L92:
            r0 = r1
        L93:
            switch(r0) {
                case 0: goto Lad;
                case 1: goto L9c;
                case 2: goto La7;
                case 3: goto La1;
                case 4: goto L9e;
                case 5: goto L9a;
                case 6: goto L98;
                default: goto L96;
            }
        L96:
            r13 = r4
            goto Lb3
        L98:
            r2 = r9
            goto L96
        L9a:
            r13 = 4608308318706860032(0x3ff4000000000000, double:1.25)
        L9c:
            r2 = r9
            goto Lb3
        L9e:
            r13 = 4624633867356078080(0x402e000000000000, double:15.0)
            goto L9c
        La1:
            r13 = 4615161236842447043(0x400c58b1572580c3, double:3.543307)
            goto L9c
        La7:
            r13 = 4636033603912859648(0x4056800000000000, double:90.0)
            goto L9c
        Lad:
            r13 = 4630183578586017914(0x4041b76ed677707a, double:35.43307)
            goto L9c
        Lb3:
            java.lang.String r8 = r8.substring(r1, r2)
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            double r8 = r8.doubleValue()
            double r8 = r8 * r13
        Lc0:
            double r8 = r8 * r11
            return r8
        Lc2:
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            double r8 = r8.doubleValue()
            goto Lc0
        Lcb:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.PropHelper.fromRelative(java.lang.String, double, double, double):double");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static double fromRelative(SVGLength sVGLength, double d, double d2, double d3, double d4) {
        double d5;
        if (sVGLength == null) {
            return d2;
        }
        SVGLength.UnitType unitType = sVGLength.unit;
        double d6 = sVGLength.value;
        switch (AnonymousClass1.$SwitchMap$com$horcrux$svg$SVGLength$UnitType[unitType.ordinal()]) {
            case 1:
            case 2:
                d4 = 1.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 3:
                d5 = (d6 / 100.0d) * d;
                break;
            case 4:
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 5:
                d4 /= 2.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 6:
                d4 = 35.43307d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 7:
                d4 = 3.543307d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 8:
                d4 = 90.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 9:
                d4 = 1.25d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 10:
                d4 = 15.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            default:
                d5 = d6 * d3;
                break;
        }
        return d5 + d2;
    }

    /* renamed from: com.horcrux.svg.PropHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$SVGLength$UnitType;

        static {
            int[] iArr = new int[SVGLength.UnitType.values().length];
            $SwitchMap$com$horcrux$svg$SVGLength$UnitType = iArr;
            try {
                iArr[SVGLength.UnitType.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.PX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.PERCENTAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.EMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.EXS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.CM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.MM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.PT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.PC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$horcrux$svg$SVGLength$UnitType[SVGLength.UnitType.UNKNOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
