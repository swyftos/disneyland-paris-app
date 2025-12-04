package org.bouncycastle.openpgp.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

/* loaded from: classes6.dex */
public class JcaPGPPublicKeyRingCollection extends PGPPublicKeyRingCollection {
    public JcaPGPPublicKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, new JcaKeyFingerprintCalculator());
    }

    public JcaPGPPublicKeyRingCollection(Collection collection) throws IOException, PGPException {
        super(collection);
    }

    public JcaPGPPublicKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this(new ByteArrayInputStream(bArr));
    }
}
