package com.appdynamics.eumagent.runtime.p192private;

import android.graphics.Bitmap;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bf */
/* JADX INFO: loaded from: classes2.dex */
class C2083bf {

    /* JADX INFO: renamed from: b */
    final String[] f646b;

    /* JADX INFO: renamed from: d */
    final Bitmap[] f648d;

    /* JADX INFO: renamed from: e */
    final int f649e;

    /* JADX INFO: renamed from: f */
    final int f650f;

    /* JADX INFO: renamed from: a */
    final String f645a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: c */
    final C2123cs f647c = new C2123cs();

    /* JADX INFO: renamed from: g */
    final int f651g = 4;

    C2083bf(Bitmap[] bitmapArr, String[] strArr, int i, int i2) {
        this.f648d = bitmapArr;
        this.f649e = i;
        this.f650f = i2;
        this.f646b = strArr;
    }

    public boolean equals(Object obj) {
        String[] strArr;
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C2083bf c2083bf = (C2083bf) obj;
        String[] strArr2 = this.f646b;
        if (strArr2 == null || (strArr = c2083bf.f646b) == null || strArr2.length != strArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr3 = this.f646b;
            if (i >= strArr3.length) {
                return true;
            }
            if (!strArr3[i].equals(c2083bf.f646b[i])) {
                return false;
            }
            i++;
        }
    }
}
