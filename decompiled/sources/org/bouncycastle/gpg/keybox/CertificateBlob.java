package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CertificateBlob extends KeyBlob {
    private CertificateBlob(int i, long j, BlobType blobType, int i2, int i3, int i4, List list, byte[] bArr, int i5, List list2, int i6, List list3, int i7, int i8, long j2, long j3, long j4, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(i, j, blobType, i2, i3, i4, list, bArr, i5, list2, i6, list3, i7, i8, j2, j3, j4, bArr2, bArr3, bArr4);
    }

    static Blob parseContent(int i, long j, BlobType blobType, int i2, KeyBoxByteBuffer keyBoxByteBuffer, BlobVerifier blobVerifier) throws IOException {
        KeyBlob.verifyDigest(i, j, keyBoxByteBuffer, blobVerifier);
        int iU16 = keyBoxByteBuffer.u16();
        long jU32 = keyBoxByteBuffer.u32();
        long jU322 = keyBoxByteBuffer.u32();
        int iU162 = keyBoxByteBuffer.u16();
        int iU163 = keyBoxByteBuffer.u16();
        ArrayList arrayList = new ArrayList();
        for (int i3 = iU162 - 1; i3 >= 0; i3--) {
            arrayList.add(KeyInformation.getInstance(keyBoxByteBuffer, iU163, i));
        }
        byte[] bArrBN = keyBoxByteBuffer.bN(keyBoxByteBuffer.u16());
        int iU164 = keyBoxByteBuffer.u16();
        keyBoxByteBuffer.u16();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = iU164 - 1; i4 >= 0; i4--) {
            arrayList2.add(UserID.getInstance(keyBoxByteBuffer, i));
        }
        int iU165 = keyBoxByteBuffer.u16();
        keyBoxByteBuffer.u16();
        ArrayList arrayList3 = new ArrayList();
        int i5 = iU165 - 1;
        while (i5 >= 0) {
            arrayList3.add(Long.valueOf(keyBoxByteBuffer.u32()));
            i5--;
            arrayList2 = arrayList2;
        }
        ArrayList arrayList4 = arrayList2;
        int iU8 = keyBoxByteBuffer.u8();
        int iU82 = keyBoxByteBuffer.u8();
        keyBoxByteBuffer.u16();
        long jU323 = keyBoxByteBuffer.u32();
        long jU324 = keyBoxByteBuffer.u32();
        long jU325 = keyBoxByteBuffer.u32();
        byte[] bArrBN2 = keyBoxByteBuffer.bN((int) keyBoxByteBuffer.u32());
        long j2 = i;
        long j3 = jU32 + j2;
        byte[] bArrRangeOf = keyBoxByteBuffer.rangeOf((int) j3, (int) (j3 + jU322));
        keyBoxByteBuffer.bN((int) ((j - (keyBoxByteBuffer.position() - i)) - 20));
        long j4 = j2 + j;
        byte[] bArrRangeOf2 = keyBoxByteBuffer.rangeOf((int) (j4 - 20), (int) j4);
        keyBoxByteBuffer.consume(bArrRangeOf2.length);
        return new CertificateBlob(i, j, blobType, i2, iU16, iU162, arrayList, bArrBN, iU164, arrayList4, iU165, arrayList3, iU8, iU82, jU323, jU324, jU325, bArrRangeOf, bArrBN2, bArrRangeOf2);
    }

    public byte[] getEncodedCertificate() {
        return getKeyBytes();
    }
}
