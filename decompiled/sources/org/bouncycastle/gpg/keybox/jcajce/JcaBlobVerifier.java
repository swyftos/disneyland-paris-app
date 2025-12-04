package org.bouncycastle.gpg.keybox.jcajce;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.gpg.keybox.BlobVerifier;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class JcaBlobVerifier implements BlobVerifier {
    private final MessageDigest md5Digest;
    private final MessageDigest sha1Digest;

    JcaBlobVerifier(JcaJceHelper jcaJceHelper) throws NoSuchProviderException {
        MessageDigest messageDigestCreateMessageDigest;
        this.sha1Digest = jcaJceHelper.createMessageDigest("SHA-1");
        try {
            messageDigestCreateMessageDigest = jcaJceHelper.createMessageDigest(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException unused) {
            messageDigestCreateMessageDigest = null;
        }
        this.md5Digest = messageDigestCreateMessageDigest;
    }

    @Override // org.bouncycastle.gpg.keybox.BlobVerifier
    public boolean isMatched(byte[] bArr, byte[] bArr2) throws DigestException {
        this.sha1Digest.update(bArr, 0, bArr.length);
        byte[] bArrDigest = this.sha1Digest.digest();
        if (Arrays.constantTimeAreEqual(bArrDigest, bArr2)) {
            return true;
        }
        if (bArr2[0] != 0 || bArr2[1] != 0 || bArr2[2] != 0 || bArr2[3] != 0) {
            return false;
        }
        this.md5Digest.update(bArr, 0, bArr.length);
        Arrays.fill(bArrDigest, (byte) 0);
        try {
            MessageDigest messageDigest = this.md5Digest;
            messageDigest.digest(bArrDigest, 4, messageDigest.getDigestLength());
            return Arrays.constantTimeAreEqual(bArrDigest, bArr2);
        } catch (DigestException e) {
            throw new IllegalStateException("internal buffer to small: " + e.getMessage(), e);
        }
    }
}
