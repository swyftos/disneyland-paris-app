package org.bouncycastle.openpgp.p185bc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.operator.p186bc.BcKeyFingerprintCalculator;

/* JADX INFO: loaded from: classes6.dex */
public class BcPGPSecretKeyRingCollection extends PGPSecretKeyRingCollection {
    public BcPGPSecretKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, new BcKeyFingerprintCalculator());
    }

    public BcPGPSecretKeyRingCollection(Collection collection) throws IOException, PGPException {
        super(collection);
    }

    public BcPGPSecretKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this(new ByteArrayInputStream(bArr));
    }
}
