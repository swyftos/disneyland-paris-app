package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CertificateBlob extends KeyBlob {
    private CertificateBlob(int i, long j, BlobType blobType, int i2, int i3, int i4, List list, byte[] bArr, int i5, List list2, int i6, List list3, int i7, int i8, long j2, long j3, long j4, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(i, j, blobType, i2, i3, i4, list, bArr, i5, list2, i6, list3, i7, i8, j2, j3, j4, bArr2, bArr3, bArr4);
    }

    static Blob parseContent(int i, long j, BlobType blobType, int i2, KeyBoxByteBuffer keyBoxByteBuffer, BlobVerifier blobVerifier) throws IOException {
        KeyBlob.verifyDigest(i, j, keyBoxByteBuffer, blobVerifier);
        int iU16 = keyBoxByteBuffer.u16();
        long jU32 = keyBoxByteBuffer.u32();
        long jU33 = keyBoxByteBuffer.u32();
        int iU17 = keyBoxByteBuffer.u16();
        int iU18 = keyBoxByteBuffer.u16();
        ArrayList arrayList = new ArrayList();
        for (int i3 = iU17 - 1; i3 >= 0; i3--) {
            arrayList.add(KeyInformation.getInstance(keyBoxByteBuffer, iU18, i));
        }
        byte[] bArrM2094bN = keyBoxByteBuffer.m2094bN(keyBoxByteBuffer.u16());
        int iU19 = keyBoxByteBuffer.u16();
        keyBoxByteBuffer.u16();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = iU19 - 1; i4 >= 0; i4--) {
            arrayList2.add(UserID.getInstance(keyBoxByteBuffer, i));
        }
        int iU110 = keyBoxByteBuffer.u16();
        keyBoxByteBuffer.u16();
        ArrayList arrayList3 = new ArrayList();
        int i5 = iU110 - 1;
        while (i5 >= 0) {
            arrayList3.add(Long.valueOf(keyBoxByteBuffer.u32()));
            i5--;
            arrayList2 = arrayList2;
        }
        ArrayList arrayList4 = arrayList2;
        int iM2095u8 = keyBoxByteBuffer.m2095u8();
        int iM2095u9 = keyBoxByteBuffer.m2095u8();
        keyBoxByteBuffer.u16();
        long jU34 = keyBoxByteBuffer.u32();
        long jU35 = keyBoxByteBuffer.u32();
        long jU36 = keyBoxByteBuffer.u32();
        byte[] bArrM2094bN2 = keyBoxByteBuffer.m2094bN((int) keyBoxByteBuffer.u32());
        long j2 = i;
        long j3 = jU32 + j2;
        byte[] bArrRangeOf = keyBoxByteBuffer.rangeOf((int) j3, (int) (j3 + jU33));
        keyBoxByteBuffer.m2094bN((int) ((j - ((long) (keyBoxByteBuffer.position() - i))) - 20));
        long j4 = j2 + j;
        byte[] bArrRangeOf2 = keyBoxByteBuffer.rangeOf((int) (j4 - 20), (int) j4);
        keyBoxByteBuffer.consume(bArrRangeOf2.length);
        return new CertificateBlob(i, j, blobType, i2, iU16, iU17, arrayList, bArrM2094bN, iU19, arrayList4, iU110, arrayList3, iM2095u8, iM2095u9, jU34, jU35, jU36, bArrRangeOf, bArrM2094bN2, bArrRangeOf2);
    }

    public byte[] getEncodedCertificate() {
        return getKeyBytes();
    }
}
