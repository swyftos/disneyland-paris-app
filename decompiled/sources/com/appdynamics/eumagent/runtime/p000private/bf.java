package com.appdynamics.eumagent.runtime.p000private;

import android.graphics.Bitmap;
import java.util.UUID;

/* loaded from: classes2.dex */
class bf {
    final String[] b;
    final Bitmap[] d;
    final int e;
    final int f;
    final String a = UUID.randomUUID().toString();
    final cs c = new cs();
    final int g = 4;

    bf(Bitmap[] bitmapArr, String[] strArr, int i, int i2) {
        this.d = bitmapArr;
        this.e = i;
        this.f = i2;
        this.b = strArr;
    }

    public boolean equals(Object obj) {
        String[] strArr;
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        bf bfVar = (bf) obj;
        String[] strArr2 = this.b;
        if (strArr2 == null || (strArr = bfVar.b) == null || strArr2.length != strArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr3 = this.b;
            if (i >= strArr3.length) {
                return true;
            }
            if (!strArr3[i].equals(bfVar.b[i])) {
                return false;
            }
            i++;
        }
    }
}
