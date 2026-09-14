package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.RectF;
import com.contentsquare.android.api.Currencies;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import net.zetetic.database.DatabaseUtils;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes4.dex */
class PathParser {
    static ArrayList<PathElement> elements;

    /* JADX INFO: renamed from: i */
    private static int f3632i;

    /* JADX INFO: renamed from: l */
    private static int f3633l;
    private static Path mPath;
    private static boolean mPenDown;
    private static float mPenDownX;
    private static float mPenDownY;
    private static float mPenX;
    private static float mPenY;
    private static float mPivotX;
    private static float mPivotY;
    static float mScale;

    /* JADX INFO: renamed from: s */
    private static String f3634s;

    private static boolean is_cmd(char c) {
        switch (c) {
            case EACTags.ELEMENT_LIST /* 65 */:
            case 'C':
            case 'H':
            case 'L':
            case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
            case EACTags.ANSWER_TO_RESET /* 81 */:
            case 'S':
            case Currencies.BZD /* 84 */:
            case 'V':
            case 'Z':
            case 'a':
            case DatabaseUtils.STATEMENT_OTHER /* 99 */:
            case 'h':
            case 'l':
            case 'm':
            case 'q':
            case 's':
            case 't':
            case 'v':
            case 'z':
                return true;
            default:
                return false;
        }
    }

    private static boolean is_number_start(char c) {
        return (c >= '0' && c <= '9') || c == '.' || c == '-' || c == '+';
    }

    PathParser() {
    }

    static Path parse(String str) {
        elements = new ArrayList<>();
        Path path = new Path();
        mPath = path;
        if (str == null) {
            return path;
        }
        f3633l = str.length();
        f3634s = str;
        f3632i = 0;
        mPenX = BitmapDescriptorFactory.HUE_RED;
        mPenY = BitmapDescriptorFactory.HUE_RED;
        mPivotX = BitmapDescriptorFactory.HUE_RED;
        mPivotY = BitmapDescriptorFactory.HUE_RED;
        mPenDownX = BitmapDescriptorFactory.HUE_RED;
        mPenDownY = BitmapDescriptorFactory.HUE_RED;
        mPenDown = false;
        char c = ' ';
        while (f3632i < f3633l) {
            skip_spaces();
            int i = f3632i;
            if (i < f3633l) {
                boolean z = true;
                boolean z2 = c != ' ';
                char cCharAt = f3634s.charAt(i);
                if (!z2 && cCharAt != 'M' && cCharAt != 'm') {
                    throw new IllegalArgumentException(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(f3632i), f3634s));
                }
                if (is_cmd(cCharAt)) {
                    f3632i++;
                    z = false;
                    c = cCharAt;
                } else {
                    if (!is_number_start(cCharAt) || !z2) {
                        throw new IllegalArgumentException(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(f3632i), f3634s));
                    }
                    if (c == 'Z' || c == 'z') {
                        throw new IllegalArgumentException(String.format("Unexpected number after 'z' (s=%s)", f3634s));
                    }
                    if (c == 'M' || c == 'm') {
                        c = is_absolute(c) ? Matrix.MATRIX_TYPE_RANDOM_LT : 'l';
                    } else {
                        z = false;
                    }
                }
                boolean zIs_absolute = is_absolute(c);
                switch (c) {
                    case EACTags.ELEMENT_LIST /* 65 */:
                        arcTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_flag(), parse_flag(), parse_list_number(), parse_list_number());
                        break;
                    case 'C':
                        curveTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 'H':
                        lineTo(parse_list_number(), mPenY);
                        break;
                    case 'L':
                        lineTo(parse_list_number(), parse_list_number());
                        break;
                    case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                        moveTo(parse_list_number(), parse_list_number());
                        break;
                    case EACTags.ANSWER_TO_RESET /* 81 */:
                        quadraticBezierCurveTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 'S':
                        smoothCurveTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case Currencies.BZD /* 84 */:
                        smoothQuadraticBezierCurveTo(parse_list_number(), parse_list_number());
                        break;
                    case 'V':
                        lineTo(mPenX, parse_list_number());
                        break;
                    case 'Z':
                    case 'z':
                        close();
                        break;
                    case 'a':
                        arc(parse_list_number(), parse_list_number(), parse_list_number(), parse_flag(), parse_flag(), parse_list_number(), parse_list_number());
                        break;
                    case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                        curve(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 'h':
                        line(parse_list_number(), BitmapDescriptorFactory.HUE_RED);
                        break;
                    case 'l':
                        line(parse_list_number(), parse_list_number());
                        break;
                    case 'm':
                        move(parse_list_number(), parse_list_number());
                        break;
                    case 'q':
                        quadraticBezierCurve(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 's':
                        smoothCurve(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 't':
                        smoothQuadraticBezierCurve(parse_list_number(), parse_list_number());
                        break;
                    case 'v':
                        line(BitmapDescriptorFactory.HUE_RED, parse_list_number());
                        break;
                    default:
                        throw new IllegalArgumentException(String.format("Unexpected comand '%c' (s=%s)", Character.valueOf(c), f3634s));
                }
                if (z) {
                    c = zIs_absolute ? 'M' : 'm';
                }
            } else {
                return mPath;
            }
        }
        return mPath;
    }

    private static void move(float f, float f2) {
        moveTo(f + mPenX, f2 + mPenY);
    }

    private static void moveTo(float f, float f2) {
        mPenX = f;
        mPivotX = f;
        mPenDownX = f;
        mPenY = f2;
        mPivotY = f2;
        mPenDownY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.moveTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point(f, f2)}));
    }

    private static void line(float f, float f2) {
        lineTo(f + mPenX, f2 + mPenY);
    }

    private static void lineTo(float f, float f2) {
        setPenDown();
        mPenX = f;
        mPivotX = f;
        mPenY = f2;
        mPivotY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.lineTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point(f, f2)}));
    }

    private static void curve(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = mPenX;
        float f8 = mPenY;
        curveTo(f + f7, f2 + f8, f3 + f7, f4 + f8, f5 + f7, f6 + f8);
    }

    private static void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        mPivotX = f3;
        mPivotY = f4;
        cubicTo(f, f2, f3, f4, f5, f6);
    }

    private static void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        setPenDown();
        mPenX = f5;
        mPenY = f6;
        Path path = mPath;
        float f7 = mScale;
        path.cubicTo(f * f7, f2 * f7, f3 * f7, f4 * f7, f5 * f7, f6 * f7);
        elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f, f2), new Point(f3, f4), new Point(f5, f6)}));
    }

    private static void smoothCurve(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPenY;
        smoothCurveTo(f + f5, f2 + f6, f3 + f5, f4 + f6);
    }

    private static void smoothCurveTo(float f, float f2, float f3, float f4) {
        float f5 = (mPenX * 2.0f) - mPivotX;
        float f6 = (mPenY * 2.0f) - mPivotY;
        mPivotX = f;
        mPivotY = f2;
        cubicTo(f5, f6, f, f2, f3, f4);
    }

    private static void quadraticBezierCurve(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPenY;
        quadraticBezierCurveTo(f + f5, f2 + f6, f3 + f5, f4 + f6);
    }

    private static void quadraticBezierCurveTo(float f, float f2, float f3, float f4) {
        mPivotX = f;
        mPivotY = f2;
        float f5 = f * 2.0f;
        float f6 = f2 * 2.0f;
        cubicTo((mPenX + f5) / 3.0f, (mPenY + f6) / 3.0f, (f3 + f5) / 3.0f, (f4 + f6) / 3.0f, f3, f4);
    }

    private static void smoothQuadraticBezierCurve(float f, float f2) {
        smoothQuadraticBezierCurveTo(f + mPenX, f2 + mPenY);
    }

    private static void smoothQuadraticBezierCurveTo(float f, float f2) {
        quadraticBezierCurveTo((mPenX * 2.0f) - mPivotX, (mPenY * 2.0f) - mPivotY, f, f2);
    }

    private static void arc(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        arcTo(f, f2, f3, z, z2, f4 + mPenX, f5 + mPenY);
    }

    private static void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9 = mPenX;
        float f10 = mPenY;
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            f6 = f == BitmapDescriptorFactory.HUE_RED ? f5 - f10 : f;
        } else {
            f6 = f2;
        }
        float fAbs = Math.abs(f6);
        float fAbs2 = Math.abs(f == BitmapDescriptorFactory.HUE_RED ? f4 - f9 : f);
        if (fAbs2 == BitmapDescriptorFactory.HUE_RED || fAbs == BitmapDescriptorFactory.HUE_RED || (f4 == f9 && f5 == f10)) {
            lineTo(f4, f5);
            return;
        }
        float radians = (float) Math.toRadians(f3);
        double d = radians;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f11 = f4 - f9;
        float f12 = f5 - f10;
        float f13 = ((fCos * f11) / 2.0f) + ((fSin * f12) / 2.0f);
        float f14 = -fSin;
        float f15 = ((f14 * f11) / 2.0f) + ((fCos * f12) / 2.0f);
        float f16 = fAbs2 * fAbs2;
        float f17 = f16 * fAbs * fAbs;
        float f18 = fAbs * fAbs * f13 * f13;
        float f19 = f16 * f15 * f15;
        float f20 = (f17 - f19) - f18;
        if (f20 < BitmapDescriptorFactory.HUE_RED) {
            float fSqrt = (float) Math.sqrt(1.0f - (f20 / f17));
            fAbs2 *= fSqrt;
            fAbs *= fSqrt;
            f7 = f11 / 2.0f;
            f8 = f12 / 2.0f;
        } else {
            float fSqrt2 = (float) Math.sqrt(f20 / (f19 + f18));
            if (z == z2) {
                fSqrt2 = -fSqrt2;
            }
            float f21 = (((-fSqrt2) * f15) * fAbs2) / fAbs;
            float f22 = ((fSqrt2 * f13) * fAbs) / fAbs2;
            float f23 = ((fCos * f21) - (fSin * f22)) + (f11 / 2.0f);
            float f24 = (f12 / 2.0f) + (f21 * fSin) + (f22 * fCos);
            f7 = f23;
            f8 = f24;
        }
        float f25 = fCos / fAbs2;
        float f26 = fSin / fAbs2;
        float f27 = f14 / fAbs;
        float f28 = fCos / fAbs;
        float f29 = -f7;
        float f30 = -f8;
        float f31 = fAbs;
        float f32 = fAbs2;
        float fAtan2 = (float) Math.atan2((f27 * f29) + (f28 * f30), (f29 * f25) + (f30 * f26));
        float f33 = f11 - f7;
        float f34 = f12 - f8;
        float fAtan3 = (float) Math.atan2((f27 * f33) + (f28 * f34), (f25 * f33) + (f26 * f34));
        float f35 = f7 + f9;
        float f36 = f8 + f10;
        float f37 = f11 + f9;
        float f38 = f12 + f10;
        setPenDown();
        mPivotX = f37;
        mPenX = f37;
        mPivotY = f38;
        mPenY = f38;
        if (f32 != f31 || radians != BitmapDescriptorFactory.HUE_RED) {
            arcToBezier(f35, f36, f32, f31, fAtan2, fAtan3, z2, radians);
            return;
        }
        float degrees = (float) Math.toDegrees(fAtan2);
        float fAbs3 = Math.abs((degrees - ((float) Math.toDegrees(fAtan3))) % 360.0f);
        if (!z ? fAbs3 > 180.0f : fAbs3 < 180.0f) {
            fAbs3 = 360.0f - fAbs3;
        }
        if (!z2) {
            fAbs3 = -fAbs3;
        }
        float f39 = mScale;
        mPath.arcTo(new RectF((f35 - f32) * f39, (f36 - f32) * f39, (f35 + f32) * f39, (f36 + f32) * f39), degrees, fAbs3);
        elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f37, f38)}));
    }

    private static void close() {
        if (mPenDown) {
            mPenX = mPenDownX;
            mPenY = mPenDownY;
            mPenDown = false;
            mPath.close();
            elements.add(new PathElement(ElementType.kCGPathElementCloseSubpath, new Point[]{new Point(mPenX, mPenY)}));
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0067 A[LOOP:0: B:12:0x0065->B:13:0x0067, LOOP_END] */
    private static void arcToBezier(float f, float f2, float f3, float f4, float f5, float f6, boolean z, float f7) {
        double d;
        int iCeil;
        float f8;
        float fTan;
        float fCos;
        float fSin;
        int i;
        float f9 = f5;
        double d2 = f7;
        float fCos2 = (float) Math.cos(d2);
        float fSin2 = (float) Math.sin(d2);
        float f10 = fCos2 * f3;
        float f11 = (-fSin2) * f4;
        float f12 = fSin2 * f3;
        float f13 = fCos2 * f4;
        float f14 = f6 - f9;
        if (f14 >= BitmapDescriptorFactory.HUE_RED || !z) {
            if (f14 > BitmapDescriptorFactory.HUE_RED && !z) {
                d = ((double) f14) - 6.283185307179586d;
            }
            iCeil = (int) Math.ceil(Math.abs(round(((double) f14) / 1.5707963267948966d)));
            f8 = f14 / iCeil;
            fTan = (float) (Math.tan(f8 / 4.0f) * 1.3333333333333333d);
            double d3 = f9;
            fCos = (float) Math.cos(d3);
            fSin = (float) Math.sin(d3);
            i = 0;
            while (i < iCeil) {
                float f15 = fCos - (fTan * fSin);
                float f16 = fSin + (fCos * fTan);
                float f17 = f9 + f8;
                double d4 = f17;
                float fCos3 = (float) Math.cos(d4);
                float fSin3 = (float) Math.sin(d4);
                float f18 = (fTan * fSin3) + fCos3;
                float f19 = fSin3 - (fTan * fCos3);
                float f20 = f + (f10 * f15) + (f11 * f16);
                float f21 = f2 + (f15 * f12) + (f16 * f13);
                float f22 = f + (f10 * f18) + (f11 * f19);
                float f23 = f2 + (f18 * f12) + (f19 * f13);
                float f24 = f + (f10 * fCos3) + (f11 * fSin3);
                float f25 = f2 + (f12 * fCos3) + (f13 * fSin3);
                Path path = mPath;
                float f26 = mScale;
                path.cubicTo(f20 * f26, f21 * f26, f22 * f26, f23 * f26, f24 * f26, f25 * f26);
                elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f20, f21), new Point(f22, f23), new Point(f24, f25)}));
                i++;
                f9 = f17;
                f13 = f13;
                f8 = f8;
                f12 = f12;
                fTan = fTan;
                fSin = fSin3;
                fCos = fCos3;
                f10 = f10;
                f11 = f11;
                iCeil = iCeil;
            }
        }
        d = ((double) f14) + 6.283185307179586d;
        f14 = (float) d;
        iCeil = (int) Math.ceil(Math.abs(round(((double) f14) / 1.5707963267948966d)));
        f8 = f14 / iCeil;
        fTan = (float) (Math.tan(f8 / 4.0f) * 1.3333333333333333d);
        double d5 = f9;
        fCos = (float) Math.cos(d5);
        fSin = (float) Math.sin(d5);
        i = 0;
        while (i < iCeil) {
            float f110 = fCos - (fTan * fSin);
            float f111 = fSin + (fCos * fTan);
            float f112 = f9 + f8;
            double d6 = f112;
            float fCos4 = (float) Math.cos(d6);
            float fSin4 = (float) Math.sin(d6);
            float f113 = (fTan * fSin4) + fCos4;
            float f114 = fSin4 - (fTan * fCos4);
            float f27 = f + (f10 * f110) + (f11 * f111);
            float f28 = f2 + (f110 * f12) + (f111 * f13);
            float f29 = f + (f10 * f113) + (f11 * f114);
            float f210 = f2 + (f113 * f12) + (f114 * f13);
            float f211 = f + (f10 * fCos4) + (f11 * fSin4);
            float f212 = f2 + (f12 * fCos4) + (f13 * fSin4);
            Path path2 = mPath;
            float f213 = mScale;
            path2.cubicTo(f27 * f213, f28 * f213, f29 * f213, f210 * f213, f211 * f213, f212 * f213);
            elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f27, f28), new Point(f29, f210), new Point(f211, f212)}));
            i++;
            f9 = f112;
            f13 = f13;
            f8 = f8;
            f12 = f12;
            fTan = fTan;
            fSin = fSin4;
            fCos = fCos4;
            f10 = f10;
            f11 = f11;
            iCeil = iCeil;
        }
    }

    private static void setPenDown() {
        if (mPenDown) {
            return;
        }
        mPenDownX = mPenX;
        mPenDownY = mPenY;
        mPenDown = true;
    }

    private static double round(double d) {
        double dPow = Math.pow(10.0d, 4.0d);
        return Math.round(d * dPow) / dPow;
    }

    private static void skip_spaces() {
        while (true) {
            int i = f3632i;
            if (i >= f3633l || !Character.isWhitespace(f3634s.charAt(i))) {
                return;
            } else {
                f3632i++;
            }
        }
    }

    private static boolean is_absolute(char c) {
        return Character.isUpperCase(c);
    }

    private static boolean parse_flag() {
        skip_spaces();
        char cCharAt = f3634s.charAt(f3632i);
        if (cCharAt == '0' || cCharAt == '1') {
            int i = f3632i + 1;
            f3632i = i;
            if (i < f3633l && f3634s.charAt(i) == ',') {
                f3632i++;
            }
            skip_spaces();
            return cCharAt == '1';
        }
        throw new Error(String.format("Unexpected flag '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(f3632i), f3634s));
    }

    private static float parse_list_number() {
        if (f3632i == f3633l) {
            throw new Error(String.format("Unexpected end (s=%s)", f3634s));
        }
        float f = parse_number();
        skip_spaces();
        parse_list_separator();
        return f;
    }

    private static float parse_number() {
        char cCharAt;
        skip_spaces();
        int i = f3632i;
        if (i == f3633l) {
            throw new Error(String.format("Unexpected end (s=%s)", f3634s));
        }
        char cCharAt2 = f3634s.charAt(i);
        if (cCharAt2 == '-' || cCharAt2 == '+') {
            int i2 = f3632i + 1;
            f3632i = i2;
            cCharAt2 = f3634s.charAt(i2);
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            skip_digits();
            int i3 = f3632i;
            if (i3 < f3633l) {
                cCharAt2 = f3634s.charAt(i3);
            }
        } else if (cCharAt2 != '.') {
            throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt2), Integer.valueOf(f3632i), f3634s));
        }
        if (cCharAt2 == '.') {
            f3632i++;
            skip_digits();
            int i4 = f3632i;
            if (i4 < f3633l) {
                cCharAt2 = f3634s.charAt(i4);
            }
        }
        if (cCharAt2 == 'e' || cCharAt2 == 'E') {
            int i5 = f3632i;
            if (i5 + 1 < f3633l && (cCharAt = f3634s.charAt(i5 + 1)) != 'm' && cCharAt != 'x') {
                int i6 = f3632i + 1;
                f3632i = i6;
                char cCharAt3 = f3634s.charAt(i6);
                if (cCharAt3 == '+' || cCharAt3 == '-') {
                    f3632i++;
                    skip_digits();
                } else if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                    skip_digits();
                } else {
                    throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt3), Integer.valueOf(f3632i), f3634s));
                }
            }
        }
        String strSubstring = f3634s.substring(i, f3632i);
        float f = Float.parseFloat(strSubstring);
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw new IllegalArgumentException(String.format("Invalid number '%s' (start=%d, i=%d, s=%s)", strSubstring, Integer.valueOf(i), Integer.valueOf(f3632i), f3634s));
        }
        return f;
    }

    private static void parse_list_separator() {
        int i = f3632i;
        if (i >= f3633l || f3634s.charAt(i) != ',') {
            return;
        }
        f3632i++;
    }

    private static void skip_digits() {
        while (true) {
            int i = f3632i;
            if (i >= f3633l || !Character.isDigit(f3634s.charAt(i))) {
                return;
            } else {
                f3632i++;
            }
        }
    }
}
