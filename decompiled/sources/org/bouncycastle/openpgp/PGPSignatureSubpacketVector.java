package org.bouncycastle.openpgp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.bouncycastle.bcpg.SignaturePacket;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.sig.Features;
import org.bouncycastle.bcpg.sig.IntendedRecipientFingerprint;
import org.bouncycastle.bcpg.sig.IssuerFingerprint;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.KeyExpirationTime;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.bcpg.sig.NotationData;
import org.bouncycastle.bcpg.sig.PreferredAlgorithms;
import org.bouncycastle.bcpg.sig.PrimaryUserID;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.bcpg.sig.SignatureExpirationTime;
import org.bouncycastle.bcpg.sig.SignatureTarget;
import org.bouncycastle.bcpg.sig.SignerUserID;

/* loaded from: classes6.dex */
public class PGPSignatureSubpacketVector {
    SignatureSubpacket[] packets;

    PGPSignatureSubpacketVector(SignatureSubpacket[] signatureSubpacketArr) {
        this.packets = signatureSubpacketArr;
    }

    public int[] getCriticalTags() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                break;
            }
            if (signatureSubpacketArr[i2].isCritical()) {
                i3++;
            }
            i2++;
        }
        int[] iArr = new int[i3];
        int i4 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr2 = this.packets;
            if (i == signatureSubpacketArr2.length) {
                return iArr;
            }
            if (signatureSubpacketArr2[i].isCritical()) {
                iArr[i4] = this.packets[i].getType();
                i4++;
            }
            i++;
        }
    }

    public PGPSignatureList getEmbeddedSignatures() throws PGPException {
        SignatureSubpacket[] subpackets = getSubpackets(32);
        ArrayList arrayList = new ArrayList();
        for (SignatureSubpacket signatureSubpacket : subpackets) {
            try {
                arrayList.add(new PGPSignature(SignaturePacket.fromByteArray(signatureSubpacket.getData())));
            } catch (IOException e) {
                throw new PGPException("Unable to parse signature packet: " + e.getMessage(), e);
            }
        }
        return new PGPSignatureList((PGPSignature[]) arrayList.toArray(new PGPSignature[arrayList.size()]));
    }

    public Features getFeatures() {
        SignatureSubpacket subpacket = getSubpacket(30);
        if (subpacket == null) {
            return null;
        }
        return new Features(subpacket.isCritical(), subpacket.isLongLength(), subpacket.getData());
    }

    public IntendedRecipientFingerprint getIntendedRecipientFingerprint() {
        SignatureSubpacket subpacket = getSubpacket(35);
        if (subpacket == null) {
            return null;
        }
        return new IntendedRecipientFingerprint(subpacket.isCritical(), subpacket.isLongLength(), subpacket.getData());
    }

    public IssuerFingerprint getIssuerFingerprint() {
        SignatureSubpacket subpacket = getSubpacket(33);
        if (subpacket == null) {
            return null;
        }
        return new IssuerFingerprint(subpacket.isCritical(), subpacket.isLongLength(), subpacket.getData());
    }

    public long getIssuerKeyID() {
        SignatureSubpacket subpacket = getSubpacket(16);
        if (subpacket == null) {
            return 0L;
        }
        return ((IssuerKeyID) subpacket).getKeyID();
    }

    public long getKeyExpirationTime() {
        SignatureSubpacket subpacket = getSubpacket(9);
        if (subpacket == null) {
            return 0L;
        }
        return ((KeyExpirationTime) subpacket).getTime();
    }

    public int getKeyFlags() {
        SignatureSubpacket subpacket = getSubpacket(27);
        if (subpacket == null) {
            return 0;
        }
        return ((KeyFlags) subpacket).getFlags();
    }

    public NotationData[] getNotationDataOccurences() {
        return getNotationDataOccurrences();
    }

    public NotationData[] getNotationDataOccurrences() {
        SignatureSubpacket[] subpackets = getSubpackets(20);
        NotationData[] notationDataArr = new NotationData[subpackets.length];
        for (int i = 0; i < subpackets.length; i++) {
            notationDataArr[i] = (NotationData) subpackets[i];
        }
        return notationDataArr;
    }

    public int[] getPreferredCompressionAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(22);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int[] getPreferredHashAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(21);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int[] getPreferredSymmetricAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(11);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public Date getSignatureCreationTime() {
        SignatureSubpacket subpacket = getSubpacket(2);
        if (subpacket == null) {
            return null;
        }
        return ((SignatureCreationTime) subpacket).getTime();
    }

    public long getSignatureExpirationTime() {
        SignatureSubpacket subpacket = getSubpacket(3);
        if (subpacket == null) {
            return 0L;
        }
        return ((SignatureExpirationTime) subpacket).getTime();
    }

    public SignatureTarget getSignatureTarget() {
        SignatureSubpacket subpacket = getSubpacket(31);
        if (subpacket == null) {
            return null;
        }
        return new SignatureTarget(subpacket.isCritical(), subpacket.isLongLength(), subpacket.getData());
    }

    public String getSignerUserID() {
        SignatureSubpacket subpacket = getSubpacket(28);
        if (subpacket == null) {
            return null;
        }
        return ((SignerUserID) subpacket).getID();
    }

    public SignatureSubpacket getSubpacket(int i) {
        int i2 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                return null;
            }
            if (signatureSubpacketArr[i2].getType() == i) {
                return this.packets[i2];
            }
            i2++;
        }
    }

    public SignatureSubpacket[] getSubpackets(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                return (SignatureSubpacket[]) arrayList.toArray(new SignatureSubpacket[0]);
            }
            if (signatureSubpacketArr[i2].getType() == i) {
                arrayList.add(this.packets[i2]);
            }
            i2++;
        }
    }

    public boolean hasSubpacket(int i) {
        return getSubpacket(i) != null;
    }

    public boolean isPrimaryUserID() {
        PrimaryUserID primaryUserID = (PrimaryUserID) getSubpacket(25);
        if (primaryUserID != null) {
            return primaryUserID.isPrimaryUserID();
        }
        return false;
    }

    public int size() {
        return this.packets.length;
    }

    public SignatureSubpacket[] toArray() {
        SignatureSubpacket[] signatureSubpacketArr = this.packets;
        int length = signatureSubpacketArr.length;
        SignatureSubpacket[] signatureSubpacketArr2 = new SignatureSubpacket[length];
        System.arraycopy(signatureSubpacketArr, 0, signatureSubpacketArr2, 0, length);
        return signatureSubpacketArr2;
    }

    SignatureSubpacket[] toSubpacketArray() {
        return this.packets;
    }
}
