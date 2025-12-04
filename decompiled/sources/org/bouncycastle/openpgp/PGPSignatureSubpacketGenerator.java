package org.bouncycastle.openpgp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.sig.EmbeddedSignature;
import org.bouncycastle.bcpg.sig.Exportable;
import org.bouncycastle.bcpg.sig.Features;
import org.bouncycastle.bcpg.sig.IntendedRecipientFingerprint;
import org.bouncycastle.bcpg.sig.IssuerFingerprint;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.KeyExpirationTime;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.bcpg.sig.NotationData;
import org.bouncycastle.bcpg.sig.PreferredAlgorithms;
import org.bouncycastle.bcpg.sig.PrimaryUserID;
import org.bouncycastle.bcpg.sig.Revocable;
import org.bouncycastle.bcpg.sig.RevocationKey;
import org.bouncycastle.bcpg.sig.RevocationReason;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.bcpg.sig.SignatureExpirationTime;
import org.bouncycastle.bcpg.sig.SignatureTarget;
import org.bouncycastle.bcpg.sig.SignerUserID;
import org.bouncycastle.bcpg.sig.TrustSignature;

/* loaded from: classes6.dex */
public class PGPSignatureSubpacketGenerator {
    List packets = new ArrayList();

    public PGPSignatureSubpacketGenerator() {
    }

    public PGPSignatureSubpacketGenerator(PGPSignatureSubpacketVector pGPSignatureSubpacketVector) {
        int i = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = pGPSignatureSubpacketVector.packets;
            if (i == signatureSubpacketArr.length) {
                return;
            }
            this.packets.add(signatureSubpacketArr[i]);
            i++;
        }
    }

    public void addCustomSubpacket(SignatureSubpacket signatureSubpacket) {
        this.packets.add(signatureSubpacket);
    }

    public void addEmbeddedSignature(boolean z, PGPSignature pGPSignature) throws IOException {
        byte[] encoded = pGPSignature.getEncoded();
        byte[] bArr = new byte[encoded.length + (-1) > 256 ? encoded.length - 3 : encoded.length - 2];
        System.arraycopy(encoded, encoded.length - bArr.length, bArr, 0, bArr.length);
        this.packets.add(new EmbeddedSignature(z, false, bArr));
    }

    public void addIntendedRecipientFingerprint(boolean z, PGPPublicKey pGPPublicKey) {
        this.packets.add(new IntendedRecipientFingerprint(z, pGPPublicKey.getVersion(), pGPPublicKey.getFingerprint()));
    }

    public void addNotationData(boolean z, boolean z2, String str, String str2) {
        this.packets.add(new NotationData(z, z2, str, str2));
    }

    public void addRevocationKey(boolean z, int i, byte[] bArr) {
        this.packets.add(new RevocationKey(z, (byte) -128, i, bArr));
    }

    public void addSignerUserID(boolean z, String str) {
        if (str == null) {
            throw new IllegalArgumentException("attempt to set null SignerUserID");
        }
        this.packets.add(new SignerUserID(z, str));
    }

    public PGPSignatureSubpacketVector generate() {
        List list = this.packets;
        return new PGPSignatureSubpacketVector((SignatureSubpacket[]) list.toArray(new SignatureSubpacket[list.size()]));
    }

    public SignatureSubpacket[] getSubpackets(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 != this.packets.size(); i2++) {
            if (((SignatureSubpacket) this.packets.get(i2)).getType() == i) {
                arrayList.add(this.packets.get(i2));
            }
        }
        return (SignatureSubpacket[]) arrayList.toArray(new SignatureSubpacket[0]);
    }

    public boolean hasSubpacket(int i) {
        for (int i2 = 0; i2 != this.packets.size(); i2++) {
            if (((SignatureSubpacket) this.packets.get(i2)).getType() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean removePacket(SignatureSubpacket signatureSubpacket) {
        return this.packets.remove(signatureSubpacket);
    }

    public void setEmbeddedSignature(boolean z, PGPSignature pGPSignature) throws IOException {
        addEmbeddedSignature(z, pGPSignature);
    }

    public void setExportable(boolean z, boolean z2) {
        this.packets.add(new Exportable(z, z2));
    }

    public void setFeature(boolean z, byte b) {
        this.packets.add(new Features(z, b));
    }

    public void setIntendedRecipientFingerprint(boolean z, PGPPublicKey pGPPublicKey) {
        addIntendedRecipientFingerprint(z, pGPPublicKey);
    }

    public void setIssuerFingerprint(boolean z, PGPPublicKey pGPPublicKey) {
        this.packets.add(new IssuerFingerprint(z, pGPPublicKey.getVersion(), pGPPublicKey.getFingerprint()));
    }

    public void setIssuerFingerprint(boolean z, PGPSecretKey pGPSecretKey) {
        setIssuerFingerprint(z, pGPSecretKey.getPublicKey());
    }

    public void setIssuerKeyID(boolean z, long j) {
        this.packets.add(new IssuerKeyID(z, j));
    }

    public void setKeyExpirationTime(boolean z, long j) {
        this.packets.add(new KeyExpirationTime(z, j));
    }

    public void setKeyFlags(boolean z, int i) {
        this.packets.add(new KeyFlags(z, i));
    }

    public void setNotationData(boolean z, boolean z2, String str, String str2) {
        addNotationData(z, z2, str, str2);
    }

    public void setPreferredCompressionAlgorithms(boolean z, int[] iArr) {
        this.packets.add(new PreferredAlgorithms(22, z, iArr));
    }

    public void setPreferredHashAlgorithms(boolean z, int[] iArr) {
        this.packets.add(new PreferredAlgorithms(21, z, iArr));
    }

    public void setPreferredSymmetricAlgorithms(boolean z, int[] iArr) {
        this.packets.add(new PreferredAlgorithms(11, z, iArr));
    }

    public void setPrimaryUserID(boolean z, boolean z2) {
        this.packets.add(new PrimaryUserID(z, z2));
    }

    public void setRevocable(boolean z, boolean z2) {
        this.packets.add(new Revocable(z, z2));
    }

    public void setRevocationKey(boolean z, int i, byte[] bArr) {
        addRevocationKey(z, i, bArr);
    }

    public void setRevocationReason(boolean z, byte b, String str) {
        this.packets.add(new RevocationReason(z, b, str));
    }

    public void setSignatureCreationTime(boolean z, Date date) {
        this.packets.add(new SignatureCreationTime(z, date));
    }

    public void setSignatureExpirationTime(boolean z, long j) {
        this.packets.add(new SignatureExpirationTime(z, j));
    }

    public void setSignatureTarget(boolean z, int i, int i2, byte[] bArr) {
        this.packets.add(new SignatureTarget(z, i, i2, bArr));
    }

    public void setSignerUserID(boolean z, String str) {
        addSignerUserID(z, str);
    }

    public void setSignerUserID(boolean z, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("attempt to set null SignerUserID");
        }
        this.packets.add(new SignerUserID(z, false, bArr));
    }

    public void setTrust(boolean z, int i, int i2) {
        this.packets.add(new TrustSignature(z, i, i2));
    }
}
