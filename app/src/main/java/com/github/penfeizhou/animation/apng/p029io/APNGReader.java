package com.github.penfeizhou.animation.apng.p029io;

import android.text.TextUtils;
import com.github.penfeizhou.animation.p032io.FilterReader;
import com.github.penfeizhou.animation.p032io.Reader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class APNGReader extends FilterReader {
    private static ThreadLocal __intBytes = new ThreadLocal();

    protected static byte[] ensureBytes() {
        byte[] bArr = (byte[]) __intBytes.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        __intBytes.set(bArr2);
        return bArr2;
    }

    public APNGReader(Reader reader) {
        super(reader);
    }

    public int readInt() throws IOException {
        byte[] bArrEnsureBytes = ensureBytes();
        read(bArrEnsureBytes, 0, 4);
        return (bArrEnsureBytes[3] & 255) | ((bArrEnsureBytes[2] & 255) << 8) | ((bArrEnsureBytes[1] & 255) << 16) | ((bArrEnsureBytes[0] & 255) << 24);
    }

    public short readShort() throws IOException {
        byte[] bArrEnsureBytes = ensureBytes();
        read(bArrEnsureBytes, 0, 2);
        return (short) ((bArrEnsureBytes[1] & 255) | ((bArrEnsureBytes[0] & 255) << 8));
    }

    public boolean matchFourCC(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int fourCC = readFourCC();
        for (int i = 0; i < 4; i++) {
            if (((fourCC >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int readFourCC() throws IOException {
        byte[] bArrEnsureBytes = ensureBytes();
        read(bArrEnsureBytes, 0, 4);
        return (bArrEnsureBytes[0] & 255) | ((bArrEnsureBytes[1] & 255) << 8) | ((bArrEnsureBytes[2] & 255) << 16) | ((bArrEnsureBytes[3] & 255) << 24);
    }
}
