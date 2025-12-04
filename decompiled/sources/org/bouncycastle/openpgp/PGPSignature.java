package org.bouncycastle.openpgp;

import com.facebook.imagepipeline.common.RotationOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.Packet;
import org.bouncycastle.bcpg.SignaturePacket;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.TrustPacket;
import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.openpgp.operator.PGPContentVerifier;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class PGPSignature {
    public static final int BINARY_DOCUMENT = 0;
    public static final int CANONICAL_TEXT_DOCUMENT = 1;
    public static final int CASUAL_CERTIFICATION = 18;
    public static final int CERTIFICATION_REVOCATION = 48;
    public static final int DEFAULT_CERTIFICATION = 16;
    public static final int DIRECT_KEY = 31;
    public static final int KEY_REVOCATION = 32;
    public static final int NO_CERTIFICATION = 17;
    public static final int POSITIVE_CERTIFICATION = 19;
    public static final int PRIMARYKEY_BINDING = 25;
    public static final int STAND_ALONE = 2;
    public static final int SUBKEY_BINDING = 24;
    public static final int SUBKEY_REVOCATION = 40;
    public static final int TIMESTAMP = 64;
    private byte lastb;
    private OutputStream sigOut;
    private SignaturePacket sigPck;
    private int signatureType;
    private TrustPacket trustPck;
    private PGPContentVerifier verifier;

    PGPSignature(BCPGInputStream bCPGInputStream) {
        this(cast(bCPGInputStream.readPacket()));
    }

    PGPSignature(SignaturePacket signaturePacket) {
        this.sigPck = signaturePacket;
        this.signatureType = signaturePacket.getSignatureType();
        this.trustPck = null;
    }

    PGPSignature(SignaturePacket signaturePacket, TrustPacket trustPacket) {
        this(signaturePacket);
        this.trustPck = trustPacket;
    }

    private void addTrailer() throws IOException {
        try {
            this.sigOut.write(this.sigPck.getSignatureTrailer());
            this.sigOut.close();
        } catch (IOException e) {
            throw new PGPRuntimeOperationException(e.getMessage(), e);
        }
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

    private static SignaturePacket cast(Packet packet) throws IOException {
        if (packet instanceof SignaturePacket) {
            return (SignaturePacket) packet;
        }
        throw new IOException("unexpected packet in stream: " + packet);
    }

    private PGPSignatureSubpacketVector createSubpacketVector(SignatureSubpacket[] signatureSubpacketArr) {
        if (signatureSubpacketArr != null) {
            return new PGPSignatureSubpacketVector(signatureSubpacketArr);
        }
        return null;
    }

    private byte[] getEncodedPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        try {
            return pGPPublicKey.publicPk.getEncodedContents();
        } catch (IOException e) {
            throw new PGPException("exception preparing key.", e);
        }
    }

    public static boolean isCertification(int i) {
        return 16 == i || 17 == i || 18 == i || 19 == i;
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

    public void encode(OutputStream outputStream) throws IOException {
        encode(outputStream, false);
    }

    public void encode(OutputStream outputStream, boolean z) throws IOException {
        TrustPacket trustPacket;
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        bCPGOutputStream.writePacket(this.sigPck);
        if (z || (trustPacket = this.trustPck) == null) {
            return;
        }
        bCPGOutputStream.writePacket(trustPacket);
    }

    public Date getCreationTime() {
        return new Date(this.sigPck.getCreationTime());
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    public int getHashAlgorithm() {
        return this.sigPck.getHashAlgorithm();
    }

    public PGPSignatureSubpacketVector getHashedSubPackets() {
        return createSubpacketVector(this.sigPck.getHashedSubPackets());
    }

    public int getKeyAlgorithm() {
        return this.sigPck.getKeyAlgorithm();
    }

    public long getKeyID() {
        return this.sigPck.getKeyID();
    }

    public byte[] getSignature() throws PGPException {
        MPInteger[] signature = this.sigPck.getSignature();
        if (signature == null) {
            return this.sigPck.getSignatureBytes();
        }
        if (signature.length == 1) {
            return BigIntegers.asUnsignedByteArray(signature[0].getValue());
        }
        if (getKeyAlgorithm() == 22) {
            byte[] bArr = new byte[64];
            byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(signature[0].getValue());
            byte[] bArrAsUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(signature[1].getValue());
            System.arraycopy(bArrAsUnsignedByteArray, 0, bArr, 32 - bArrAsUnsignedByteArray.length, bArrAsUnsignedByteArray.length);
            System.arraycopy(bArrAsUnsignedByteArray2, 0, bArr, 64 - bArrAsUnsignedByteArray2.length, bArrAsUnsignedByteArray2.length);
            return bArr;
        }
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new ASN1Integer(signature[0].getValue()));
            aSN1EncodableVector.add(new ASN1Integer(signature[1].getValue()));
            return new DERSequence(aSN1EncodableVector).getEncoded();
        } catch (IOException e) {
            throw new PGPException("exception encoding DSA sig.", e);
        }
    }

    public byte[] getSignatureTrailer() {
        return this.sigPck.getSignatureTrailer();
    }

    public int getSignatureType() {
        return this.sigPck.getSignatureType();
    }

    public PGPSignatureSubpacketVector getUnhashedSubPackets() {
        return createSubpacketVector(this.sigPck.getUnhashedSubPackets());
    }

    public int getVersion() {
        return this.sigPck.getVersion();
    }

    public boolean hasSubpackets() {
        return (this.sigPck.getHashedSubPackets() == null && this.sigPck.getUnhashedSubPackets() == null) ? false : true;
    }

    public void init(PGPContentVerifierBuilderProvider pGPContentVerifierBuilderProvider, PGPPublicKey pGPPublicKey) throws PGPException {
        PGPContentVerifier pGPContentVerifierBuild = pGPContentVerifierBuilderProvider.get(this.sigPck.getKeyAlgorithm(), this.sigPck.getHashAlgorithm()).build(pGPPublicKey);
        this.verifier = pGPContentVerifierBuild;
        this.lastb = (byte) 0;
        this.sigOut = pGPContentVerifierBuild.getOutputStream();
    }

    public boolean isCertification() {
        return isCertification(getSignatureType());
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
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.openpgp.PGPSignature.update(byte):void");
    }

    public void update(byte[] bArr) throws IOException {
        update(bArr, 0, bArr.length);
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

    public boolean verify() throws IOException, PGPException {
        try {
            this.sigOut.write(getSignatureTrailer());
            this.sigOut.close();
            return this.verifier.verify(getSignature());
        } catch (IOException e) {
            throw new PGPException(e.getMessage(), e);
        }
    }

    public boolean verifyCertification(String str, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        if (this.verifier == null) {
            throw new PGPException("PGPSignature not initialised - call init().");
        }
        updateWithPublicKey(pGPPublicKey);
        updateWithIdData(RotationOptions.ROTATE_180, Strings.toUTF8ByteArray(str));
        addTrailer();
        return this.verifier.verify(getSignature());
    }

    public boolean verifyCertification(PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        if (this.verifier == null) {
            throw new PGPException("PGPSignature not initialised - call init().");
        }
        if (getSignatureType() != 32 && getSignatureType() != 40 && getSignatureType() != 31) {
            throw new PGPException("signature is not a key signature");
        }
        updateWithPublicKey(pGPPublicKey);
        addTrailer();
        return this.verifier.verify(getSignature());
    }

    public boolean verifyCertification(PGPPublicKey pGPPublicKey, PGPPublicKey pGPPublicKey2) throws IOException, PGPException {
        if (this.verifier == null) {
            throw new PGPException("PGPSignature not initialised - call init().");
        }
        updateWithPublicKey(pGPPublicKey);
        updateWithPublicKey(pGPPublicKey2);
        addTrailer();
        return this.verifier.verify(getSignature());
    }

    public boolean verifyCertification(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        if (this.verifier == null) {
            throw new PGPException("PGPSignature not initialised - call init().");
        }
        updateWithPublicKey(pGPPublicKey);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            UserAttributeSubpacket[] subpacketArray = pGPUserAttributeSubpacketVector.toSubpacketArray();
            for (int i = 0; i != subpacketArray.length; i++) {
                subpacketArray[i].encode(byteArrayOutputStream);
            }
            updateWithIdData(209, byteArrayOutputStream.toByteArray());
            addTrailer();
            return this.verifier.verify(getSignature());
        } catch (IOException e) {
            throw new PGPException("cannot encode subpacket array", e);
        }
    }

    public boolean verifyCertification(byte[] bArr, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        if (this.verifier == null) {
            throw new PGPException("PGPSignature not initialised - call init().");
        }
        updateWithPublicKey(pGPPublicKey);
        updateWithIdData(RotationOptions.ROTATE_180, bArr);
        addTrailer();
        return this.verifier.verify(getSignature());
    }
}
