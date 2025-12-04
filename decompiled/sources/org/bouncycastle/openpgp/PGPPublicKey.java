package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.DSAPublicBCPGKey;
import org.bouncycastle.bcpg.ECPublicBCPGKey;
import org.bouncycastle.bcpg.ElGamalPublicBCPGKey;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.bcpg.TrustPacket;
import org.bouncycastle.bcpg.UserAttributePacket;
import org.bouncycastle.bcpg.UserIDPacket;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class PGPPublicKey implements PublicKeyAlgorithmTags {
    private static final int[] MASTER_KEY_CERTIFICATION_TYPES = {19, 18, 17, 16, 31};
    private byte[] fingerprint;
    List idSigs;
    List idTrusts;
    List ids;
    private long keyID;
    List keySigs;
    private int keyStrength;
    PublicKeyPacket publicPk;
    List subSigs;
    TrustPacket trustPk;

    PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, List list2, List list3, List list4, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        new ArrayList();
        this.subSigs = null;
        this.publicPk = publicKeyPacket;
        this.trustPk = trustPacket;
        this.keySigs = list;
        this.ids = list2;
        this.idTrusts = list3;
        this.idSigs = list4;
        init(keyFingerPrintCalculator);
    }

    PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.publicPk = publicKeyPacket;
        this.trustPk = trustPacket;
        this.subSigs = list;
        init(keyFingerPrintCalculator);
    }

    public PGPPublicKey(PublicKeyPacket publicKeyPacket, KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = publicKeyPacket;
        this.ids = new ArrayList();
        this.idSigs = new ArrayList();
        init(keyFingerPrintCalculator);
    }

    PGPPublicKey(PGPPublicKey pGPPublicKey) {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = pGPPublicKey.publicPk;
        this.keySigs = new ArrayList(pGPPublicKey.keySigs);
        this.ids = new ArrayList(pGPPublicKey.ids);
        this.idTrusts = new ArrayList(pGPPublicKey.idTrusts);
        this.idSigs = new ArrayList(pGPPublicKey.idSigs.size());
        for (int i = 0; i != pGPPublicKey.idSigs.size(); i++) {
            this.idSigs.add(new ArrayList((ArrayList) pGPPublicKey.idSigs.get(i)));
        }
        if (pGPPublicKey.subSigs != null) {
            this.subSigs = new ArrayList(pGPPublicKey.subSigs.size());
            for (int i2 = 0; i2 != pGPPublicKey.subSigs.size(); i2++) {
                this.subSigs.add(pGPPublicKey.subSigs.get(i2));
            }
        }
        this.fingerprint = pGPPublicKey.fingerprint;
        this.keyID = pGPPublicKey.keyID;
        this.keyStrength = pGPPublicKey.keyStrength;
    }

    PGPPublicKey(PGPPublicKey pGPPublicKey, TrustPacket trustPacket, List list) {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = pGPPublicKey.publicPk;
        this.trustPk = trustPacket;
        this.subSigs = list;
        this.fingerprint = pGPPublicKey.fingerprint;
        this.keyID = pGPPublicKey.keyID;
        this.keyStrength = pGPPublicKey.keyStrength;
    }

    private static PGPPublicKey addCert(PGPPublicKey pGPPublicKey, Object obj, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = null;
        for (int i = 0; i != pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                list = (List) pGPPublicKey2.idSigs.get(i);
            }
        }
        if (list != null) {
            list.add(pGPSignature);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(pGPSignature);
            pGPPublicKey2.ids.add(obj);
            pGPPublicKey2.idTrusts.add(null);
            pGPPublicKey2.idSigs.add(arrayList);
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, String str, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, new UserIDPacket(str), pGPSignature);
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, PGPSignature pGPSignature) {
        if (pGPPublicKey.isMasterKey()) {
            if (pGPSignature.getSignatureType() == 40) {
                throw new IllegalArgumentException("signature type incorrect for master key revocation.");
            }
        } else if (pGPSignature.getSignatureType() == 32) {
            throw new IllegalArgumentException("signature type incorrect for sub-key revocation.");
        }
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = pGPPublicKey2.subSigs;
        if (list == null) {
            list = pGPPublicKey2.keySigs;
        }
        list.add(pGPSignature);
        return pGPPublicKey2;
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, pGPUserAttributeSubpacketVector, pGPSignature);
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, byte[] bArr, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, new UserIDPacket(bArr), pGPSignature);
    }

    private long getExpirationTimeFromSig(boolean z, int i) {
        Iterator signaturesOfType = getSignaturesOfType(i);
        long j = -1;
        long time = -1;
        while (signaturesOfType.hasNext()) {
            PGPSignature pGPSignature = (PGPSignature) signaturesOfType.next();
            if (!z || pGPSignature.getKeyID() == getKeyID()) {
                PGPSignatureSubpacketVector hashedSubPackets = pGPSignature.getHashedSubPackets();
                if (hashedSubPackets != null && hashedSubPackets.hasSubpacket(9)) {
                    long keyExpirationTime = hashedSubPackets.getKeyExpirationTime();
                    if (pGPSignature.getKeyID() == getKeyID()) {
                        if (pGPSignature.getCreationTime().getTime() > time) {
                            time = pGPSignature.getCreationTime().getTime();
                            j = keyExpirationTime;
                        }
                    } else if (keyExpirationTime == 0 || keyExpirationTime > j) {
                        j = keyExpirationTime;
                    }
                }
            }
        }
        return j;
    }

    private Iterator getSignaturesForID(UserIDPacket userIDPacket) {
        for (int i = 0; i != this.ids.size(); i++) {
            if (userIDPacket.equals(this.ids.get(i))) {
                return ((ArrayList) this.idSigs.get(i)).iterator();
            }
        }
        return null;
    }

    private void init(KeyFingerPrintCalculator keyFingerPrintCalculator) {
        int fieldSize;
        BigInteger p;
        RSAPublicBCPGKey rSAPublicBCPGKey;
        BCPGKey key = this.publicPk.getKey();
        this.fingerprint = keyFingerPrintCalculator.calculateFingerprint(this.publicPk);
        if (this.publicPk.getVersion() <= 3) {
            rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            this.keyID = rSAPublicBCPGKey.getModulus().longValue();
        } else {
            byte[] bArr = this.fingerprint;
            this.keyID = ((bArr[bArr.length - 3] & 255) << 16) | ((bArr[bArr.length - 8] & 255) << 56) | ((bArr[bArr.length - 7] & 255) << 48) | ((bArr[bArr.length - 6] & 255) << 40) | ((bArr[bArr.length - 5] & 255) << 32) | ((bArr[bArr.length - 4] & 255) << 24) | ((bArr[bArr.length - 2] & 255) << 8) | (bArr[bArr.length - 1] & 255);
            if (!(key instanceof RSAPublicBCPGKey)) {
                if (key instanceof DSAPublicBCPGKey) {
                    p = ((DSAPublicBCPGKey) key).getP();
                } else {
                    if (!(key instanceof ElGamalPublicBCPGKey)) {
                        if (key instanceof ECPublicBCPGKey) {
                            X9ECParameters byOID = ECNamedCurveTable.getByOID(((ECPublicBCPGKey) key).getCurveOID());
                            fieldSize = byOID != null ? byOID.getCurve().getFieldSize() : -1;
                            this.keyStrength = fieldSize;
                        }
                        return;
                    }
                    p = ((ElGamalPublicBCPGKey) key).getP();
                }
                fieldSize = p.bitLength();
                this.keyStrength = fieldSize;
            }
            rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
        }
        p = rSAPublicBCPGKey.getModulus();
        fieldSize = p.bitLength();
        this.keyStrength = fieldSize;
    }

    private static PGPPublicKey removeCert(PGPPublicKey pGPPublicKey, Object obj) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        boolean z = false;
        for (int i = 0; i < pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                pGPPublicKey2.ids.remove(i);
                pGPPublicKey2.idTrusts.remove(i);
                pGPPublicKey2.idSigs.remove(i);
                z = true;
            }
        }
        if (z) {
            return pGPPublicKey2;
        }
        return null;
    }

    private static PGPPublicKey removeCert(PGPPublicKey pGPPublicKey, Object obj, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        boolean zRemove = false;
        for (int i = 0; i < pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                zRemove = ((List) pGPPublicKey2.idSigs.get(i)).remove(pGPSignature);
            }
        }
        if (zRemove) {
            return pGPPublicKey2;
        }
        return null;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, String str) {
        return removeCert(pGPPublicKey, new UserIDPacket(str));
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, String str, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, new UserIDPacket(str), pGPSignature);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = pGPPublicKey2.subSigs;
        if (list == null) {
            list = pGPPublicKey2.keySigs;
        }
        boolean zRemove = list.remove(pGPSignature);
        if (!zRemove) {
            Iterator<byte[]> rawUserIDs = pGPPublicKey.getRawUserIDs();
            while (rawUserIDs.hasNext()) {
                byte[] next = rawUserIDs.next();
                Iterator<PGPSignature> signaturesForID = pGPPublicKey.getSignaturesForID(next);
                while (signaturesForID.hasNext()) {
                    if (pGPSignature == signaturesForID.next()) {
                        pGPPublicKey2 = removeCertification(pGPPublicKey2, next, pGPSignature);
                        zRemove = true;
                    }
                }
            }
            if (!zRemove) {
                Iterator<PGPUserAttributeSubpacketVector> userAttributes = pGPPublicKey.getUserAttributes();
                while (userAttributes.hasNext()) {
                    PGPUserAttributeSubpacketVector next2 = userAttributes.next();
                    Iterator signaturesForUserAttribute = pGPPublicKey.getSignaturesForUserAttribute(next2);
                    while (signaturesForUserAttribute.hasNext()) {
                        if (pGPSignature == signaturesForUserAttribute.next()) {
                            pGPPublicKey2 = removeCertification(pGPPublicKey2, next2, pGPSignature);
                        }
                    }
                }
            }
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector) {
        return removeCert(pGPPublicKey, pGPUserAttributeSubpacketVector);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, pGPUserAttributeSubpacketVector, pGPSignature);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, byte[] bArr) {
        return removeCert(pGPPublicKey, new UserIDPacket(bArr));
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, byte[] bArr, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, new UserIDPacket(bArr), pGPSignature);
    }

    public void encode(OutputStream outputStream) throws IOException {
        encode(outputStream, false);
    }

    public void encode(OutputStream outputStream, boolean z) throws IOException {
        TrustPacket trustPacket;
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        bCPGOutputStream.writePacket(this.publicPk);
        if (!z && (trustPacket = this.trustPk) != null) {
            bCPGOutputStream.writePacket(trustPacket);
        }
        if (this.subSigs != null) {
            for (int i = 0; i != this.subSigs.size(); i++) {
                ((PGPSignature) this.subSigs.get(i)).encode(bCPGOutputStream, z);
            }
            return;
        }
        for (int i2 = 0; i2 != this.keySigs.size(); i2++) {
            ((PGPSignature) this.keySigs.get(i2)).encode(bCPGOutputStream);
        }
        for (int i3 = 0; i3 != this.ids.size(); i3++) {
            if (this.ids.get(i3) instanceof UserIDPacket) {
                bCPGOutputStream.writePacket((UserIDPacket) this.ids.get(i3));
            } else {
                bCPGOutputStream.writePacket(new UserAttributePacket(((PGPUserAttributeSubpacketVector) this.ids.get(i3)).toSubpacketArray()));
            }
            if (!z && this.idTrusts.get(i3) != null) {
                bCPGOutputStream.writePacket((ContainedPacket) this.idTrusts.get(i3));
            }
            List list = (List) this.idSigs.get(i3);
            for (int i4 = 0; i4 != list.size(); i4++) {
                ((PGPSignature) list.get(i4)).encode(bCPGOutputStream, z);
            }
        }
    }

    public int getAlgorithm() {
        return this.publicPk.getAlgorithm();
    }

    public int getBitStrength() {
        return this.keyStrength;
    }

    public Date getCreationTime() {
        return this.publicPk.getTime();
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream, false);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getFingerprint() {
        byte[] bArr = this.fingerprint;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public Iterator getKeySignatures() {
        List list = this.subSigs;
        if (list != null) {
            return list.iterator();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.keySigs);
        return arrayList.iterator();
    }

    public PublicKeyPacket getPublicKeyPacket() {
        return this.publicPk;
    }

    public Iterator<byte[]> getRawUserIDs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof UserIDPacket) {
                arrayList.add(((UserIDPacket) this.ids.get(i)).getRawID());
            }
        }
        return arrayList.iterator();
    }

    public Iterator getSignatures() {
        List list = this.subSigs;
        if (list != null) {
            return list.iterator();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.keySigs);
        for (int i = 0; i != this.idSigs.size(); i++) {
            arrayList.addAll((Collection) this.idSigs.get(i));
        }
        return arrayList.iterator();
    }

    public Iterator<PGPSignature> getSignaturesForID(String str) {
        return getSignaturesForID(new UserIDPacket(str));
    }

    public Iterator<PGPSignature> getSignaturesForID(byte[] bArr) {
        return getSignaturesForID(new UserIDPacket(bArr));
    }

    public Iterator<PGPSignature> getSignaturesForKeyID(long j) {
        ArrayList arrayList = new ArrayList();
        Iterator signatures = getSignatures();
        while (signatures.hasNext()) {
            PGPSignature pGPSignature = (PGPSignature) signatures.next();
            if (pGPSignature.getKeyID() == j) {
                arrayList.add(pGPSignature);
            }
        }
        return arrayList.iterator();
    }

    public Iterator getSignaturesForUserAttribute(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector) {
        for (int i = 0; i != this.ids.size(); i++) {
            if (pGPUserAttributeSubpacketVector.equals(this.ids.get(i))) {
                return ((ArrayList) this.idSigs.get(i)).iterator();
            }
        }
        return null;
    }

    public Iterator getSignaturesOfType(int i) {
        ArrayList arrayList = new ArrayList();
        Iterator signatures = getSignatures();
        while (signatures.hasNext()) {
            PGPSignature pGPSignature = (PGPSignature) signatures.next();
            if (pGPSignature.getSignatureType() == i) {
                arrayList.add(pGPSignature);
            }
        }
        return arrayList.iterator();
    }

    public byte[] getTrustData() {
        TrustPacket trustPacket = this.trustPk;
        if (trustPacket == null) {
            return null;
        }
        return Arrays.clone(trustPacket.getLevelAndTrustAmount());
    }

    public Iterator<PGPUserAttributeSubpacketVector> getUserAttributes() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof PGPUserAttributeSubpacketVector) {
                arrayList.add(this.ids.get(i));
            }
        }
        return arrayList.iterator();
    }

    public Iterator<String> getUserIDs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof UserIDPacket) {
                arrayList.add(((UserIDPacket) this.ids.get(i)).getID());
            }
        }
        return arrayList.iterator();
    }

    public int getValidDays() {
        if (this.publicPk.getVersion() <= 3) {
            return this.publicPk.getValidDays();
        }
        long validSeconds = getValidSeconds() % 86400;
        int validSeconds2 = (int) (getValidSeconds() / 86400);
        if (validSeconds <= 0 || validSeconds2 != 0) {
            return validSeconds2;
        }
        return 1;
    }

    public long getValidSeconds() {
        if (this.publicPk.getVersion() <= 3) {
            return this.publicPk.getValidDays() * 86400;
        }
        int i = 0;
        if (isMasterKey()) {
            while (true) {
                int[] iArr = MASTER_KEY_CERTIFICATION_TYPES;
                if (i == iArr.length) {
                    break;
                }
                long expirationTimeFromSig = getExpirationTimeFromSig(true, iArr[i]);
                if (expirationTimeFromSig >= 0) {
                    return expirationTimeFromSig;
                }
                i++;
            }
        } else {
            long expirationTimeFromSig2 = getExpirationTimeFromSig(false, 24);
            if (expirationTimeFromSig2 >= 0) {
                return expirationTimeFromSig2;
            }
            long expirationTimeFromSig3 = getExpirationTimeFromSig(false, 31);
            if (expirationTimeFromSig3 >= 0) {
                return expirationTimeFromSig3;
            }
        }
        return 0L;
    }

    public int getVersion() {
        return this.publicPk.getVersion();
    }

    public boolean hasRevocation() {
        boolean z = false;
        if (isMasterKey()) {
            int i = 0;
            while (!z && i < this.keySigs.size()) {
                int i2 = i + 1;
                if (((PGPSignature) this.keySigs.get(i)).getSignatureType() == 32) {
                    z = true;
                }
                i = i2;
            }
        } else {
            int i3 = 0;
            while (!z && i3 < this.subSigs.size()) {
                int i4 = i3 + 1;
                if (((PGPSignature) this.subSigs.get(i3)).getSignatureType() == 40) {
                    z = true;
                }
                i3 = i4;
            }
        }
        return z;
    }

    public boolean isEncryptionKey() {
        int algorithm = this.publicPk.getAlgorithm();
        return algorithm == 1 || algorithm == 2 || algorithm == 16 || algorithm == 20 || algorithm == 18;
    }

    public boolean isMasterKey() {
        return this.subSigs == null && (!isEncryptionKey() || this.publicPk.getAlgorithm() == 1);
    }

    public boolean isRevoked() {
        return hasRevocation();
    }
}
