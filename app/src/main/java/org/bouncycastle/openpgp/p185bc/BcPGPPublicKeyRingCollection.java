package org.bouncycastle.openpgp.p185bc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.operator.p186bc.BcKeyFingerprintCalculator;

/* JADX INFO: loaded from: classes6.dex */
public class BcPGPPublicKeyRingCollection extends PGPPublicKeyRingCollection {
    public BcPGPPublicKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, new BcKeyFingerprintCalculator());
    }

    public BcPGPPublicKeyRingCollection(Collection collection) throws IOException, PGPException {
        super(collection);
    }

    public BcPGPPublicKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this(new ByteArrayInputStream(bArr));
    }
}
