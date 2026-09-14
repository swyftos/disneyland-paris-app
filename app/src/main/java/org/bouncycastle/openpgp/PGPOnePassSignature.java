package org.bouncycastle.openpgp;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.OnePassSignaturePacket;
import org.bouncycastle.bcpg.Packet;
import org.bouncycastle.openpgp.operator.PGPContentVerifier;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;

/* JADX INFO: loaded from: classes6.dex */
public class PGPOnePassSignature {
    private byte lastb;
    private OutputStream sigOut;
    private OnePassSignaturePacket sigPack;
    private int signatureType;
    private PGPContentVerifier verifier;

    PGPOnePassSignature(BCPGInputStream bCPGInputStream) {
        this(cast(bCPGInputStream.readPacket()));
    }

    PGPOnePassSignature(OnePassSignaturePacket onePassSignaturePacket) {
        this.sigPack = onePassSignaturePacket;
        this.signatureType = onePassSignaturePacket.getSignatureType();
    }

    private void blockUpdate(byte[] bArr, int i, int i2) {
        try {
            this.sigOut.write(bArr, i, i2);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException(e.getMessage(), e);
        }
    }

    private void byteUpdate(byte b) {
        try {
            this.sigOut.write(b);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException(e.getMessage(), e);
        }
    }

    private static OnePassSignaturePacket cast(Packet packet) throws IOException {
        if (packet instanceof OnePassSignaturePacket) {
            return (OnePassSignaturePacket) packet;
        }
        throw new IOException("unexpected packet in stream: " + packet);
    }

    public void encode(OutputStream outputStream) throws IOException {
        (outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream)).writePacket(this.sigPack);
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int getHashAlgorithm() {
        return this.sigPack.getHashAlgorithm();
    }

    public int getKeyAlgorithm() {
        return this.sigPack.getKeyAlgorithm();
    }

    public long getKeyID() {
        return this.sigPack.getKeyID();
    }

    public int getSignatureType() {
        return this.sigPack.getSignatureType();
    }

    public void init(PGPContentVerifierBuilderProvider pGPContentVerifierBuilderProvider, PGPPublicKey pGPPublicKey) throws PGPException {
        PGPContentVerifier pGPContentVerifierBuild = pGPContentVerifierBuilderProvider.get(this.sigPack.getKeyAlgorithm(), this.sigPack.getHashAlgorithm()).build(pGPPublicKey);
        this.verifier = pGPContentVerifierBuild;
        this.lastb = (byte) 0;
        this.sigOut = pGPContentVerifierBuild.getOutputStream();
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000b  */
    public void update(byte b) {
        if (this.signatureType != 1) {
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
        if (this.signatureType != 1) {
            blockUpdate(bArr, 0, bArr.length);
            return;
        }
        for (int i = 0; i != bArr.length; i++) {
            update(bArr[i]);
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        if (this.signatureType != 1) {
            blockUpdate(bArr, i, i2);
            return;
        }
        int i3 = i2 + i;
        while (i != i3) {
            update(bArr[i]);
            i++;
        }
    }

    public boolean verify(PGPSignature pGPSignature) throws PGPException {
        try {
            this.sigOut.write(pGPSignature.getSignatureTrailer());
            this.sigOut.close();
            return this.verifier.verify(pGPSignature.getSignature());
        } catch (IOException e) {
            throw new PGPException("unable to add trailer: " + e.getMessage(), e);
        }
    }
}
