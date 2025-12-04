package org.bouncycastle.openpgp;

import com.facebook.imagepipeline.common.RotationOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.OnePassSignaturePacket;
import org.bouncycastle.bcpg.SignaturePacket;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.openpgp.operator.PGPContentSigner;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class PGPSignatureGenerator {
    private PGPContentSigner contentSigner;
    private PGPContentSignerBuilder contentSignerBuilder;
    private byte lastb;
    private OutputStream sigOut;
    private int sigType;
    private SignatureSubpacket[] unhashed = new SignatureSubpacket[0];
    private SignatureSubpacket[] hashed = new SignatureSubpacket[0];
    private int providedKeyAlgorithm = -1;

    public PGPSignatureGenerator(PGPContentSignerBuilder pGPContentSignerBuilder) {
        this.contentSignerBuilder = pGPContentSignerBuilder;
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

    private byte[] getEncodedPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        try {
            return pGPPublicKey.publicPk.getEncodedContents();
        } catch (IOException e) {
            throw new PGPException("exception preparing key.", e);
        }
    }

    private SignatureSubpacket[] insertSubpacket(SignatureSubpacket[] signatureSubpacketArr, SignatureSubpacket signatureSubpacket) {
        SignatureSubpacket[] signatureSubpacketArr2 = new SignatureSubpacket[signatureSubpacketArr.length + 1];
        signatureSubpacketArr2[0] = signatureSubpacket;
        System.arraycopy(signatureSubpacketArr, 0, signatureSubpacketArr2, 1, signatureSubpacketArr.length);
        return signatureSubpacketArr2;
    }

    private boolean packetPresent(SignatureSubpacket[] signatureSubpacketArr, int i) {
        for (int i2 = 0; i2 != signatureSubpacketArr.length; i2++) {
            if (signatureSubpacketArr[i2].getType() == i) {
                return true;
            }
        }
        return false;
    }

    private void updateWithIdData(int i, byte[] bArr) throws IOException {
        update((byte) i);
        update((byte) (bArr.length >> 24));
        update((byte) (bArr.length >> 16));
        update((byte) (bArr.length >> 8));
        update((byte) bArr.length);
        update(bArr);
    }

    private void updateWithPublicKey(PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        byte[] encodedPublicKey = getEncodedPublicKey(pGPPublicKey);
        update((byte) -103);
        update((byte) (encodedPublicKey.length >> 8));
        update((byte) encodedPublicKey.length);
        update(encodedPublicKey);
    }

    public PGPSignature generate() throws IOException, PGPException {
        MPInteger[] mPIntegerArrDsaSigToMpi;
        MPInteger[] mPIntegerArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        SignatureSubpacket[] signatureSubpacketArrInsertSubpacket = !packetPresent(this.hashed, 2) ? insertSubpacket(this.hashed, new SignatureCreationTime(false, new Date())) : this.hashed;
        SignatureSubpacket[] signatureSubpacketArrInsertSubpacket2 = (packetPresent(this.hashed, 16) || packetPresent(this.unhashed, 16)) ? this.unhashed : insertSubpacket(this.unhashed, new IssuerKeyID(false, this.contentSigner.getKeyID()));
        byte b = (byte) 4;
        try {
            byteArrayOutputStream.write(b);
            byteArrayOutputStream.write((byte) this.sigType);
            byteArrayOutputStream.write((byte) this.contentSigner.getKeyAlgorithm());
            byteArrayOutputStream.write((byte) this.contentSigner.getHashAlgorithm());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (int i = 0; i != signatureSubpacketArrInsertSubpacket.length; i++) {
                signatureSubpacketArrInsertSubpacket[i].encode(byteArrayOutputStream2);
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream.write((byte) (byteArray.length >> 8));
            byteArrayOutputStream.write((byte) byteArray.length);
            byteArrayOutputStream.write(byteArray);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.write(b);
            byteArrayOutputStream.write(-1);
            byteArrayOutputStream.write((byte) (byteArray2.length >> 24));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 16));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 8));
            byteArrayOutputStream.write((byte) byteArray2.length);
            byte[] byteArray3 = byteArrayOutputStream.toByteArray();
            blockUpdate(byteArray3, 0, byteArray3.length);
            if (this.contentSigner.getKeyAlgorithm() == 3 || this.contentSigner.getKeyAlgorithm() == 1) {
                mPIntegerArrDsaSigToMpi = new MPInteger[]{new MPInteger(new BigInteger(1, this.contentSigner.getSignature()))};
            } else {
                if (this.contentSigner.getKeyAlgorithm() == 22) {
                    byte[] signature = this.contentSigner.getSignature();
                    mPIntegerArr = new MPInteger[]{new MPInteger(new BigInteger(1, Arrays.copyOfRange(signature, 0, signature.length / 2))), new MPInteger(new BigInteger(1, Arrays.copyOfRange(signature, signature.length / 2, signature.length)))};
                    byte[] digest = this.contentSigner.getDigest();
                    return new PGPSignature(new SignaturePacket(this.sigType, this.contentSigner.getKeyID(), this.contentSigner.getKeyAlgorithm(), this.contentSigner.getHashAlgorithm(), signatureSubpacketArrInsertSubpacket, signatureSubpacketArrInsertSubpacket2, new byte[]{digest[0], digest[1]}, mPIntegerArr));
                }
                mPIntegerArrDsaSigToMpi = PGPUtil.dsaSigToMpi(this.contentSigner.getSignature());
            }
            mPIntegerArr = mPIntegerArrDsaSigToMpi;
            byte[] digest2 = this.contentSigner.getDigest();
            return new PGPSignature(new SignaturePacket(this.sigType, this.contentSigner.getKeyID(), this.contentSigner.getKeyAlgorithm(), this.contentSigner.getHashAlgorithm(), signatureSubpacketArrInsertSubpacket, signatureSubpacketArrInsertSubpacket2, new byte[]{digest2[0], digest2[1]}, mPIntegerArr));
        } catch (IOException e) {
            throw new PGPException("exception encoding hashed data.", e);
        }
    }

    public PGPSignature generateCertification(String str, PGPPublicKey pGPPublicKey) throws PGPException {
        updateWithPublicKey(pGPPublicKey);
        updateWithIdData(RotationOptions.ROTATE_180, Strings.toUTF8ByteArray(str));
        return generate();
    }

    public PGPSignature generateCertification(PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        int i = this.sigType;
        if ((i == 40 || i == 24) && !pGPPublicKey.isMasterKey()) {
            throw new IllegalArgumentException("certifications involving subkey requires public key of revoking key as well.");
        }
        updateWithPublicKey(pGPPublicKey);
        return generate();
    }

    public PGPSignature generateCertification(PGPPublicKey pGPPublicKey, PGPPublicKey pGPPublicKey2) throws IOException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        updateWithPublicKey(pGPPublicKey2);
        return generate();
    }

    public PGPSignature generateCertification(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            UserAttributeSubpacket[] subpacketArray = pGPUserAttributeSubpacketVector.toSubpacketArray();
            for (int i = 0; i != subpacketArray.length; i++) {
                subpacketArray[i].encode(byteArrayOutputStream);
            }
            updateWithIdData(209, byteArrayOutputStream.toByteArray());
            return generate();
        } catch (IOException e) {
            throw new PGPException("cannot encode subpacket array", e);
        }
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

    public void setHashedSubpackets(PGPSignatureSubpacketVector pGPSignatureSubpacketVector) {
        if (pGPSignatureSubpacketVector == null) {
            this.hashed = new SignatureSubpacket[0];
        } else {
            this.hashed = pGPSignatureSubpacketVector.toSubpacketArray();
        }
    }

    public void setUnhashedSubpackets(PGPSignatureSubpacketVector pGPSignatureSubpacketVector) {
        if (pGPSignatureSubpacketVector == null) {
            this.unhashed = new SignatureSubpacket[0];
        } else {
            this.unhashed = pGPSignatureSubpacketVector.toSubpacketArray();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(byte r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.sigType
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
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.openpgp.PGPSignatureGenerator.update(byte):void");
    }

    public void update(byte[] bArr) throws IOException {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) throws IOException {
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
