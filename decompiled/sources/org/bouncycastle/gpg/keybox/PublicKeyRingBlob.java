package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;

/* loaded from: classes6.dex */
public class PublicKeyRingBlob extends KeyBlob {
    private final KeyFingerPrintCalculator fingerPrintCalculator;

    private PublicKeyRingBlob(int i, long j, BlobType blobType, int i2, int i3, int i4, List list, byte[] bArr, int i5, List list2, int i6, List list3, int i7, int i8, long j2, long j3, long j4, byte[] bArr2, byte[] bArr3, byte[] bArr4, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        super(i, j, blobType, i2, i3, i4, list, bArr, i5, list2, i6, list3, i7, i8, j2, j3, j4, bArr2, bArr3, bArr4);
        this.fingerPrintCalculator = keyFingerPrintCalculator;
    }

    static Blob parseContent(int i, long j, BlobType blobType, int i2, KeyBoxByteBuffer keyBoxByteBuffer, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws IOException {
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
            iU165 = iU165;
        }
        int i6 = iU165;
        int iU8 = keyBoxByteBuffer.u8();
        int iU82 = keyBoxByteBuffer.u8();
        keyBoxByteBuffer.u16();
        long jU323 = keyBoxByteBuffer.u32();
        long jU324 = keyBoxByteBuffer.u32();
        long jU325 = keyBoxByteBuffer.u32();
        long jU326 = keyBoxByteBuffer.u32();
        if (jU326 > keyBoxByteBuffer.remaining()) {
            throw new IllegalStateException("sizeOfReservedSpace exceeds content remaining in buffer");
        }
        byte[] bArrBN2 = keyBoxByteBuffer.bN((int) jU326);
        long j2 = i;
        long j3 = jU32 + j2;
        byte[] bArrRangeOf = keyBoxByteBuffer.rangeOf((int) j3, (int) (j3 + jU322));
        keyBoxByteBuffer.bN((int) ((j - (keyBoxByteBuffer.position() - i)) - 20));
        long j4 = j2 + j;
        byte[] bArrRangeOf2 = keyBoxByteBuffer.rangeOf((int) (j4 - 20), (int) j4);
        keyBoxByteBuffer.consume(bArrRangeOf2.length);
        return new PublicKeyRingBlob(i, j, blobType, i2, iU16, iU162, arrayList, bArrBN, iU164, arrayList2, i6, arrayList3, iU8, iU82, jU323, jU324, jU325, bArrRangeOf, bArrBN2, bArrRangeOf2, keyFingerPrintCalculator);
    }

    public PGPPublicKeyRing getPGPPublicKeyRing() throws IOException {
        if (this.type == BlobType.OPEN_PGP_BLOB) {
            return new PGPPublicKeyRing(getKeyBytes(), this.fingerPrintCalculator);
        }
        throw new IllegalStateException("Blob is not PGP blob, it is " + this.type.name());
    }
}
