package org.bouncycastle.gpg;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes6.dex */
abstract class SXprUtils {
    static S2K parseS2K(InputStream inputStream) throws IOException, NumberFormatException {
        skipOpenParenthesis(inputStream);
        readString(inputStream, inputStream.read());
        byte[] bytes = readBytes(inputStream, inputStream.read());
        final long j = Long.parseLong(readString(inputStream, inputStream.read()));
        skipCloseParenthesis(inputStream);
        return new S2K(2, bytes, (int) j) { // from class: org.bouncycastle.gpg.SXprUtils.1
            @Override // org.bouncycastle.bcpg.S2K
            public long getIterationCount() {
                return j;
            }
        };
    }

    static byte[] readBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[readLength(inputStream, i)];
        Streams.readFully(inputStream, bArr);
        return bArr;
    }

    private static int readLength(InputStream inputStream, int i) throws IOException {
        int i2;
        while (true) {
            i2 = i - 48;
            int i3 = inputStream.read();
            if (i3 < 0 || i3 == 58) {
                break;
            }
            i = (i2 * 10) + i3;
        }
        return i2;
    }

    static String readString(InputStream inputStream, int i) throws IOException {
        int length = readLength(inputStream, i);
        char[] cArr = new char[length];
        for (int i2 = 0; i2 != length; i2++) {
            cArr[i2] = (char) inputStream.read();
        }
        return new String(cArr);
    }

    static void skipCloseParenthesis(InputStream inputStream) throws IOException {
        if (inputStream.read() != 41) {
            throw new IOException("unknown character encountered");
        }
    }

    static void skipOpenParenthesis(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i == 40) {
            return;
        }
        throw new IOException("unknown character encountered: " + ((char) i));
    }
}
