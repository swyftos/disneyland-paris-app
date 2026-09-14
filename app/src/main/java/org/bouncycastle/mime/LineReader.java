package org.bouncycastle.mime;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
class LineReader {
    private int lastC = -1;
    private final InputStream src;

    LineReader(InputStream inputStream) {
        this.src = inputStream;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x001a, code lost:
    
        r1 = r4.src.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String readLine() {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = this.lastC;
        if (i2 == -1) {
            i2 = this.src.read();
        } else {
            if (i2 == 13) {
                return "";
            }
            this.lastC = -1;
        }
        while (i2 >= 0 && i2 != 13 && i2 != 10) {
            byteArrayOutputStream.write(i2);
            i2 = this.src.read();
        }
        if (i2 == 13 && (i = this.src.read()) != 10 && i >= 0) {
            this.lastC = i;
        }
        if (i2 < 0) {
            return null;
        }
        return Strings.fromUTF8ByteArray(byteArrayOutputStream.toByteArray());
    }
}
