package org.bouncycastle.openpgp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.PublicSubkeyPacket;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* loaded from: classes6.dex */
public class PGPKeyRingGenerator {
    private PGPDigestCalculator checksumCalculator;
    private PGPSignatureSubpacketVector hashedPcks;
    private PBESecretKeyEncryptor keyEncryptor;
    private PGPContentSignerBuilder keySignerBuilder;
    List keys;
    private PGPKeyPair masterKey;
    private PGPSignatureSubpacketVector unhashedPcks;

    public PGPKeyRingGenerator(int i, PGPKeyPair pGPKeyPair, String str, PGPDigestCalculator pGPDigestCalculator, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        ArrayList arrayList = new ArrayList();
        this.keys = arrayList;
        this.masterKey = pGPKeyPair;
        this.keyEncryptor = pBESecretKeyEncryptor;
        this.checksumCalculator = pGPDigestCalculator;
        this.keySignerBuilder = pGPContentSignerBuilder;
        this.hashedPcks = pGPSignatureSubpacketVector;
        this.unhashedPcks = pGPSignatureSubpacketVector2;
        arrayList.add(new PGPSecretKey(i, pGPKeyPair, str, pGPDigestCalculator, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, pGPContentSignerBuilder, pBESecretKeyEncryptor));
    }

    public PGPKeyRingGenerator(PGPSecretKeyRing pGPSecretKeyRing, PBESecretKeyDecryptor pBESecretKeyDecryptor, PGPDigestCalculator pGPDigestCalculator, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this.keys = new ArrayList();
        this.masterKey = new PGPKeyPair(pGPSecretKeyRing.getPublicKey(), pGPSecretKeyRing.getSecretKey().extractPrivateKey(pBESecretKeyDecryptor));
        this.keyEncryptor = pBESecretKeyEncryptor;
        this.checksumCalculator = pGPDigestCalculator;
        this.keySignerBuilder = pGPContentSignerBuilder;
        PGPSignature pGPSignature = (PGPSignature) pGPSecretKeyRing.getPublicKey().getSignatures().next();
        ArrayList arrayList = new ArrayList();
        PGPSignatureSubpacketVector hashedSubPackets = pGPSignature.getHashedSubPackets();
        for (int i = 0; i != hashedSubPackets.size(); i++) {
            if (hashedSubPackets.packets[i].getType() != 2) {
                arrayList.add(hashedSubPackets.packets[i]);
            }
        }
        this.hashedPcks = new PGPSignatureSubpacketVector((SignatureSubpacket[]) arrayList.toArray(new SignatureSubpacket[arrayList.size()]));
        this.unhashedPcks = pGPSignature.getUnhashedSubPackets();
        this.keys.addAll(pGPSecretKeyRing.keys);
    }

    public void addSubKey(PGPKeyPair pGPKeyPair) throws PGPException {
        addSubKey(pGPKeyPair, this.hashedPcks, this.unhashedPcks);
    }

    public void addSubKey(PGPKeyPair pGPKeyPair, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2) throws PGPException {
        try {
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(this.keySignerBuilder);
            pGPSignatureGenerator.init(24, this.masterKey.getPrivateKey());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketVector);
            pGPSignatureGenerator.setUnhashedSubpackets(pGPSignatureSubpacketVector2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(pGPSignatureGenerator.generateCertification(this.masterKey.getPublicKey(), pGPKeyPair.getPublicKey()));
            PGPPublicKey pGPPublicKey = new PGPPublicKey(pGPKeyPair.getPublicKey(), null, arrayList);
            pGPPublicKey.publicPk = new PublicSubkeyPacket(pGPPublicKey.getAlgorithm(), pGPPublicKey.getCreationTime(), pGPPublicKey.publicPk.getKey());
            this.keys.add(new PGPSecretKey(pGPKeyPair.getPrivateKey(), pGPPublicKey, this.checksumCalculator, this.keyEncryptor));
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("exception adding subkey: ", e2);
        }
    }

    public PGPPublicKeyRing generatePublicKeyRing() {
        Iterator it = this.keys.iterator();
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(((PGPSecretKey) it.next()).getPublicKey());
        } while (it.hasNext());
        return new PGPPublicKeyRing(arrayList);
    }

    public PGPSecretKeyRing generateSecretKeyRing() {
        return new PGPSecretKeyRing(this.keys);
    }
}
