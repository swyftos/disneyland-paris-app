package com.github.penfeizhou.animation.apng.decode;

import android.text.TextUtils;
import com.github.penfeizhou.animation.apng.p029io.APNGReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class Chunk {
    int crc;
    int fourcc;
    int length;
    int offset;

    void innerParse(APNGReader aPNGReader) {
    }

    Chunk() {
    }

    static int fourCCToInt(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    void parse(APNGReader aPNGReader) throws IOException {
        int iAvailable = aPNGReader.available();
        innerParse(aPNGReader);
        int iAvailable2 = iAvailable - aPNGReader.available();
        int i = this.length;
        if (iAvailable2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iAvailable2 < i) {
            aPNGReader.skip(i - iAvailable2);
        }
    }
}
