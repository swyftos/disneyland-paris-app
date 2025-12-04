package org.bouncycastle.gpg.keybox.jcajce;

import java.io.InputStream;
import org.bouncycastle.gpg.keybox.BlobVerifier;
import org.bouncycastle.gpg.keybox.KeyBox;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;

/* loaded from: classes6.dex */
public class JcaKeyBox extends KeyBox {
    JcaKeyBox(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) {
        super(inputStream, keyFingerPrintCalculator, blobVerifier);
    }

    JcaKeyBox(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) {
        super(bArr, keyFingerPrintCalculator, blobVerifier);
    }
}
