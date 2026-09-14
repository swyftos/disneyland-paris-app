package com.github.penfeizhou.animation.webp.decode;

import android.text.TextUtils;
import com.github.penfeizhou.animation.webp.p033io.WebPReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class BaseChunk {
    public static final int CHUNCK_HEADER_OFFSET = 8;
    public int chunkFourCC;
    public int offset;
    public int payloadSize;

    void innerParse(WebPReader webPReader) {
    }

    public static int fourCCToInt(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    final void parse(WebPReader webPReader) throws IOException {
        int iAvailable = webPReader.available();
        innerParse(webPReader);
        int iAvailable2 = iAvailable - webPReader.available();
        int i = this.payloadSize;
        int i2 = i + (i & 1);
        if (iAvailable2 > i2) {
            throw new IOException("Out of chunk area");
        }
        if (iAvailable2 < i2) {
            webPReader.skip(i2 - iAvailable2);
        }
    }
}
