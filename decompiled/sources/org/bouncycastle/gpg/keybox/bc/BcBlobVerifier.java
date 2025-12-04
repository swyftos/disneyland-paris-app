package org.bouncycastle.gpg.keybox.bc;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.gpg.keybox.BlobVerifier;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class BcBlobVerifier implements BlobVerifier {
    private final SHA1Digest sha1Digest = new SHA1Digest();
    private final MD5Digest md5Digest = new MD5Digest();

    @Override // org.bouncycastle.gpg.keybox.BlobVerifier
    public boolean isMatched(byte[] bArr, byte[] bArr2) {
        this.sha1Digest.update(bArr, 0, bArr.length);
        byte[] bArr3 = new byte[this.sha1Digest.getDigestSize()];
        this.sha1Digest.doFinal(bArr3, 0);
        if (Arrays.constantTimeAreEqual(bArr3, bArr2)) {
            return true;
        }
        if (bArr2[0] != 0 || bArr2[1] != 0 || bArr2[2] != 0 || bArr2[3] != 0) {
            return false;
        }
        this.md5Digest.update(bArr, 0, bArr.length);
        Arrays.fill(bArr3, (byte) 0);
        this.md5Digest.doFinal(bArr3, 4);
        return Arrays.constantTimeAreEqual(bArr3, bArr2);
    }
}
