package org.bouncycastle.openpgp;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.OnePassSignaturePacket;
import org.bouncycastle.bcpg.SignaturePacket;
import org.bouncycastle.openpgp.operator.PGPContentSigner;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;

/* JADX INFO: loaded from: classes6.dex */
public class PGPV3SignatureGenerator {
    private PGPContentSigner contentSigner;
    private PGPContentSignerBuilder contentSignerBuilder;
    private byte lastb;
    private int providedKeyAlgorithm = -1;
    private OutputStream sigOut;
    private int sigType;

    public PGPV3SignatureGenerator(PGPContentSignerBuilder pGPContentSignerBuilder) {
        this.contentSignerBuilder = pGPContentSignerBuilder;
    }

    private void blockUpdate(byte[] bArr, int i, int i2) {
        try {
            this.sigOut.write(bArr, i, i2);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException("unable to update signature: " + e.getMessage(), e);
        }
    }

    private void byteUpdate(byte b) {
        try {
            this.sigOut.write(b);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException("unable to update signature: " + e.getMessage(), e);
        }
    }

    public PGPSignature generate() throws PGPException {
        long time = new Date().getTime() / 1000;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.sigType);
        byteArrayOutputStream.write((byte) (time >> 24));
        byteArrayOutputStream.write((byte) (time >> 16));
        byteArrayOutputStream.write((byte) (time >> 8));
        byteArrayOutputStream.write((byte) time);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        blockUpdate(byteArray, 0, byteArray.length);
        MPInteger[] mPIntegerArrDsaSigToMpi = (this.contentSigner.getKeyAlgorithm() == 3 || this.contentSigner.getKeyAlgorithm() == 1) ? new MPInteger[]{new MPInteger(new BigInteger(1, this.contentSigner.getSignature()))} : PGPUtil.dsaSigToMpi(this.contentSigner.getSignature());
        byte[] digest = this.contentSigner.getDigest();
        return new PGPSignature(new SignaturePacket(3, this.contentSigner.getType(), this.contentSigner.getKeyID(), this.contentSigner.getKeyAlgorithm(), this.contentSigner.getHashAlgorithm(), time * 1000, new byte[]{digest[0], digest[1]}, mPIntegerArrDsaSigToMpi));
    }

    public PGPOnePassSignature generateOnePassVersion(boolean z) throws PGPException {
        return new PGPOnePassSignature(new OnePassSignaturePacket(this.sigType, this.contentSigner.getHashAlgorithm(), this.contentSigner.getKeyAlgorithm(), this.contentSigner.getKeyID(), z));
    }

    public void init(int i, PGPPrivateKey pGPPrivateKey) throws PGPException {
        PGPContentSigner pGPContentSignerBuild = this.contentSignerBuilder.build(i, pGPPrivateKey);
        this.contentSigner = pGPContentSignerBuild;
        this.sigOut = pGPContentSignerBuild.getOutputStream();
        this.sigType = this.contentSigner.getType();
        this.lastb = (byte) 0;
        int i2 = this.providedKeyAlgorithm;
        if (i2 >= 0 && i2 != this.contentSigner.getKeyAlgorithm()) {
            throw new PGPException("key algorithm mismatch");
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000b  */
    public void update(byte b) {
        if (this.sigType != 1) {
            byteUpdate(b);
            return;
        }
        if (b == 13) {
            byteUpdate(Ascii.f3522CR);
            byteUpdate((byte) 10);
        } else if (b != 10) {
            byteUpdate(b);
        } else if (this.lastb != 13) {
            byteUpdate(Ascii.f3522CR);
            byteUpdate((byte) 10);
        }
        this.lastb = b;
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        if (this.sigType != 1) {
            blockUpdate(bArr, i, i2);
            return;
        }
        int i3 = i2 + i;
        while (i != i3) {
            update(bArr[i]);
            i++;
        }
    }
}
