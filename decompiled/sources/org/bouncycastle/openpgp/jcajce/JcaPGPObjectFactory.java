package org.bouncycastle.openpgp.jcajce;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

/* loaded from: classes6.dex */
public class JcaPGPObjectFactory extends PGPObjectFactory {
    public JcaPGPObjectFactory(InputStream inputStream) {
        super(inputStream, new JcaKeyFingerprintCalculator());
    }

    public JcaPGPObjectFactory(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
