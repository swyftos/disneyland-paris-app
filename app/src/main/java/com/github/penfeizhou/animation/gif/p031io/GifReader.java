package com.github.penfeizhou.animation.gif.p031io;

import com.github.penfeizhou.animation.p032io.FilterReader;
import com.github.penfeizhou.animation.p032io.Reader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GifReader extends FilterReader {
    private static ThreadLocal<byte[]> __intBytes = new ThreadLocal<>();

    private static byte[] ensureBytes() {
        byte[] bArr = __intBytes.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        __intBytes.set(bArr2);
        return bArr2;
    }

    public GifReader(Reader reader) {
        super(reader);
    }

    public int readUInt16() throws IOException {
        byte[] bArrEnsureBytes = ensureBytes();
        read(bArrEnsureBytes, 0, 2);
        return (bArrEnsureBytes[0] & 255) | ((bArrEnsureBytes[1] & 255) << 8);
    }
}
