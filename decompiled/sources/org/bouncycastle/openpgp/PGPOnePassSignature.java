package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.OnePassSignaturePacket;
import org.bouncycastle.bcpg.Packet;
import org.bouncycastle.openpgp.operator.PGPContentVerifier;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;

/* loaded from: classes6.dex */
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

    private void blockUpdate(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.sigOut.write(bArr, i, i2);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException(e.getMessage(), e);
        }
    }

    private void byteUpdate(byte b) throws IOException {
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

    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(byte r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.signatureType
            r1 = 1
            if (r0 != r1) goto L1f
            r0 = 10
            r1 = 13
            if (r4 != r1) goto L12
        Lb:
            r3.byteUpdate(r1)
            r3.byteUpdate(r0)
            goto L1c
        L12:
            if (r4 != r0) goto L19
            byte r2 = r3.lastb
            if (r2 == r1) goto L1c
            goto Lb
        L19:
            r3.byteUpdate(r4)
        L1c:
            r3.lastb = r4
            goto L22
        L1f:
            r3.byteUpdate(r4)
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.openpgp.PGPOnePassSignature.update(byte):void");
    }

    public void update(byte[] bArr) throws IOException {
        if (this.signatureType != 1) {
            blockUpdate(bArr, 0, bArr.length);
            return;
        }
        for (int i = 0; i != bArr.length; i++) {
            update(bArr[i]);
        }
    }

    public void update(byte[] bArr, int i, int i2) throws IOException {
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

    public boolean verify(PGPSignature pGPSignature) throws IOException, PGPException {
        try {
            this.sigOut.write(pGPSignature.getSignatureTrailer());
            this.sigOut.close();
            return this.verifier.verify(pGPSignature.getSignature());
        } catch (IOException e) {
            throw new PGPException("unable to add trailer: " + e.getMessage(), e);
        }
    }
}
