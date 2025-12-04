package com.github.barteksc.pdfviewer.util;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ArrayUtils {
    public static int[] deleteDuplicatedPages(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = -1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            Integer numValueOf = Integer.valueOf(i3);
            if (i != i3) {
                arrayList.add(numValueOf);
            }
            i2++;
            i = i3;
        }
        int[] iArr2 = new int[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr2;
    }

    public static int[] calculateIndexesInDuplicateArray(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length == 0) {
            return iArr2;
        }
        int i = 0;
        iArr2[0] = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] != iArr[i2 - 1]) {
                i++;
            }
            iArr2[i2] = i;
        }
        return iArr2;
    }

    public static String arrayToString(int[] iArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]);
            if (i != iArr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
