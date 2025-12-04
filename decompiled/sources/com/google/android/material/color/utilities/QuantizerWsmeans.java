package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class QuantizerWsmeans {

    private static final class Distance implements Comparable {
        int index = -1;
        double distance = -1.0d;

        Distance() {
        }

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i) {
        int[] iArr3;
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr = new double[iArr.length][];
        int[] iArr4 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i6 = 0;
        for (int i7 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i7));
            if (num == null) {
                dArr[i6] = pointProviderLab.fromInt(i7);
                iArr4[i6] = i7;
                i6++;
                linkedHashMap.put(Integer.valueOf(i7), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i7), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr5 = new int[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            iArr5[i8] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr4[i8]))).intValue();
        }
        int iMin = Math.min(i, i6);
        if (iArr2.length != 0) {
            iMin = Math.min(iMin, iArr2.length);
        }
        double[][] dArr2 = new double[iMin][];
        int i9 = 0;
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            dArr2[i10] = pointProviderLab.fromInt(iArr2[i10]);
            i9++;
        }
        int i11 = iMin - i9;
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
            }
        }
        int[] iArr6 = new int[i6];
        for (int i13 = 0; i13 < i6; i13++) {
            iArr6[i13] = random.nextInt(iMin);
        }
        int[][] iArr7 = new int[iMin][];
        for (int i14 = 0; i14 < iMin; i14++) {
            iArr7[i14] = new int[iMin];
        }
        Distance[][] distanceArr = new Distance[iMin][];
        for (int i15 = 0; i15 < iMin; i15++) {
            distanceArr[i15] = new Distance[iMin];
            for (int i16 = 0; i16 < iMin; i16++) {
                distanceArr[i15][i16] = new Distance();
            }
        }
        int[] iArr8 = new int[iMin];
        int i17 = 0;
        while (true) {
            if (i17 >= 10) {
                iArr3 = iArr8;
                i2 = 0;
                break;
            }
            int i18 = 0;
            while (i18 < iMin) {
                int i19 = i18 + 1;
                int i20 = i19;
                while (i20 < iMin) {
                    int[] iArr9 = iArr8;
                    double dDistance = pointProviderLab.distance(dArr2[i18], dArr2[i20]);
                    Distance distance = distanceArr[i20][i18];
                    distance.distance = dDistance;
                    distance.index = i18;
                    Distance distance2 = distanceArr[i18][i20];
                    distance2.distance = dDistance;
                    distance2.index = i20;
                    i5 = 1;
                    i20++;
                    iArr8 = iArr9;
                    i17 = i17;
                }
                int[] iArr10 = iArr8;
                int i21 = i17;
                Arrays.sort(distanceArr[i18]);
                for (int i22 = 0; i22 < iMin; i22 += i5) {
                    iArr7[i18][i22] = distanceArr[i18][i22].index;
                }
                iArr8 = iArr10;
                i17 = i21;
                i18 = i19;
            }
            int[] iArr11 = iArr8;
            int i23 = i17;
            int i24 = 0;
            int i25 = 0;
            while (i24 < i6) {
                double[] dArr3 = dArr[i24];
                int i26 = iArr6[i24];
                double dDistance2 = pointProviderLab.distance(dArr3, dArr2[i26]);
                int[][] iArr12 = iArr7;
                double d = dDistance2;
                int i27 = -1;
                int i28 = 0;
                while (i28 < iMin) {
                    Distance[][] distanceArr2 = distanceArr;
                    int i29 = i6;
                    if (distanceArr[i26][i28].distance < 4.0d * dDistance2) {
                        double dDistance3 = pointProviderLab.distance(dArr3, dArr2[i28]);
                        if (dDistance3 < d) {
                            d = dDistance3;
                            i27 = i28;
                        }
                    }
                    i28++;
                    i6 = i29;
                    distanceArr = distanceArr2;
                }
                Distance[][] distanceArr3 = distanceArr;
                int i30 = i6;
                if (i27 != -1 && Math.abs(Math.sqrt(d) - Math.sqrt(dDistance2)) > 3.0d) {
                    i25++;
                    iArr6[i24] = i27;
                }
                i24++;
                iArr7 = iArr12;
                i6 = i30;
                distanceArr = distanceArr3;
            }
            int[][] iArr13 = iArr7;
            Distance[][] distanceArr4 = distanceArr;
            int i31 = i6;
            if (i25 == 0 && i23 != 0) {
                i2 = 0;
                iArr3 = iArr11;
                break;
            }
            double[] dArr4 = new double[iMin];
            double[] dArr5 = new double[iMin];
            double[] dArr6 = new double[iMin];
            char c = 0;
            Arrays.fill(iArr11, 0);
            int i32 = 0;
            while (true) {
                i3 = i31;
                if (i32 >= i3) {
                    break;
                }
                int i33 = iArr6[i32];
                double[] dArr7 = dArr[i32];
                int i34 = iArr5[i32];
                iArr11[i33] = iArr11[i33] + i34;
                double d2 = dArr4[i33];
                double d3 = dArr7[c];
                int[] iArr14 = iArr5;
                double d4 = i34;
                dArr4[i33] = d2 + (d3 * d4);
                dArr5[i33] = dArr5[i33] + (dArr7[1] * d4);
                dArr6[i33] = dArr6[i33] + (dArr7[2] * d4);
                i32++;
                iArr5 = iArr14;
                iArr6 = iArr6;
                c = 0;
                i31 = i3;
            }
            int[] iArr15 = iArr5;
            int[] iArr16 = iArr6;
            int i35 = 0;
            while (i35 < iMin) {
                int i36 = iArr11[i35];
                if (i36 == 0) {
                    dArr2[i35] = new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
                    i4 = 1;
                } else {
                    double d5 = i36;
                    double d6 = dArr4[i35] / d5;
                    double d7 = dArr5[i35] / d5;
                    double d8 = dArr6[i35] / d5;
                    double[] dArr8 = dArr2[i35];
                    dArr8[0] = d6;
                    i4 = 1;
                    dArr8[1] = d7;
                    dArr8[2] = d8;
                }
                i35 += i4;
            }
            i17 = i23 + 1;
            iArr5 = iArr15;
            i5 = 1;
            iArr7 = iArr13;
            iArr6 = iArr16;
            distanceArr = distanceArr4;
            iArr8 = iArr11;
            i6 = i3;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i37 = i2; i37 < iMin; i37++) {
            int i38 = iArr3[i37];
            if (i38 != 0) {
                int i39 = pointProviderLab.toInt(dArr2[i37]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i39))) {
                    linkedHashMap2.put(Integer.valueOf(i39), Integer.valueOf(i38));
                }
            }
        }
        return linkedHashMap2;
    }
}
