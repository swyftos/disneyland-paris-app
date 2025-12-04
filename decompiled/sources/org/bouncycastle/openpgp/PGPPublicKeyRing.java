package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.Packet;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.TrustPacket;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

/* loaded from: classes6.dex */
public class PGPPublicKeyRing extends PGPKeyRing implements Iterable<PGPPublicKey> {
    List keys;

    public PGPPublicKeyRing(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException {
        this.keys = new ArrayList();
        BCPGInputStream bCPGInputStreamWrap = PGPKeyRing.wrap(inputStream);
        int iNextPacketTag = bCPGInputStreamWrap.nextPacketTag();
        if (iNextPacketTag != 6 && iNextPacketTag != 14) {
            throw new IOException("public key ring doesn't start with public key tag: tag 0x" + Integer.toHexString(iNextPacketTag));
        }
        PublicKeyPacket publicKeyPacket = readPublicKeyPacket(bCPGInputStreamWrap);
        TrustPacket optionalTrustPacket = PGPKeyRing.readOptionalTrustPacket(bCPGInputStreamWrap);
        List signaturesAndTrust = PGPKeyRing.readSignaturesAndTrust(bCPGInputStreamWrap);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        PGPKeyRing.readUserIDs(bCPGInputStreamWrap, arrayList, arrayList2, arrayList3);
        try {
            List list = this.keys;
            PGPPublicKey pGPPublicKey = new PGPPublicKey(publicKeyPacket, optionalTrustPacket, signaturesAndTrust, arrayList, arrayList2, arrayList3, keyFingerPrintCalculator);
            while (true) {
                list.add(pGPPublicKey);
                if (bCPGInputStreamWrap.nextPacketTag() != 14) {
                    return;
                }
                list = this.keys;
                pGPPublicKey = readSubkey(bCPGInputStreamWrap, keyFingerPrintCalculator);
            }
        } catch (PGPException e) {
            throw new IOException("processing exception: " + e.toString());
        }
    }

    public PGPPublicKeyRing(List list) {
        this.keys = checkKeys(list);
    }

    public PGPPublicKeyRing(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException {
        this(new ByteArrayInputStream(bArr), keyFingerPrintCalculator);
    }

    private static List checkKeys(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i != list.size(); i++) {
            PGPPublicKey pGPPublicKey = (PGPPublicKey) list.get(i);
            boolean zIsMasterKey = pGPPublicKey.isMasterKey();
            if (i == 0) {
                if (!zIsMasterKey) {
                    throw new IllegalArgumentException("key 0 must be a master key");
                }
            } else if (zIsMasterKey) {
                throw new IllegalArgumentException("key 0 can be only master key");
            }
            arrayList.add(pGPPublicKey);
        }
        return arrayList;
    }

    public static PGPPublicKeyRing insertPublicKey(PGPPublicKeyRing pGPPublicKeyRing, PGPPublicKey pGPPublicKey) {
        ArrayList arrayList = new ArrayList(pGPPublicKeyRing.keys);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i != arrayList.size(); i++) {
            PGPPublicKey pGPPublicKey2 = (PGPPublicKey) arrayList.get(i);
            if (pGPPublicKey2.getKeyID() == pGPPublicKey.getKeyID()) {
                arrayList.set(i, pGPPublicKey);
                z = true;
            }
            if (pGPPublicKey2.isMasterKey()) {
                z2 = true;
            }
        }
        if (!z) {
            if (!pGPPublicKey.isMasterKey()) {
                arrayList.add(pGPPublicKey);
            } else {
                if (z2) {
                    throw new IllegalArgumentException("cannot add a master key to a ring that already has one");
                }
                arrayList.add(0, pGPPublicKey);
            }
        }
        return new PGPPublicKeyRing(arrayList);
    }

    static PublicKeyPacket readPublicKeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        Packet packet = bCPGInputStream.readPacket();
        if (packet instanceof PublicKeyPacket) {
            return (PublicKeyPacket) packet;
        }
        throw new IOException("unexpected packet in stream: " + packet);
    }

    static PGPPublicKey readSubkey(BCPGInputStream bCPGInputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        return new PGPPublicKey(readPublicKeyPacket(bCPGInputStream), PGPKeyRing.readOptionalTrustPacket(bCPGInputStream), PGPKeyRing.readSignaturesAndTrust(bCPGInputStream), keyFingerPrintCalculator);
    }

    public static PGPPublicKeyRing removePublicKey(PGPPublicKeyRing pGPPublicKeyRing, PGPPublicKey pGPPublicKey) {
        ArrayList arrayList = new ArrayList(pGPPublicKeyRing.keys);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((PGPPublicKey) arrayList.get(i)).getKeyID() == pGPPublicKey.getKeyID()) {
                arrayList.remove(i);
                z = true;
            }
        }
        if (z) {
            return new PGPPublicKeyRing(arrayList);
        }
        return null;
    }

    @Override // org.bouncycastle.openpgp.PGPKeyRing
    public void encode(OutputStream outputStream) throws IOException {
        encode(outputStream, false);
    }

    public void encode(OutputStream outputStream, boolean z) throws IOException {
        for (int i = 0; i != this.keys.size(); i++) {
            ((PGPPublicKey) this.keys.get(i)).encode(outputStream, z);
        }
    }

    @Override // org.bouncycastle.openpgp.PGPKeyRing
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

    @Override // org.bouncycastle.openpgp.PGPKeyRing
    public Iterator<PGPPublicKey> getKeysWithSignaturesBy(long j) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.keys.size(); i++) {
            PGPPublicKey pGPPublicKey = (PGPPublicKey) this.keys.get(i);
            if (pGPPublicKey.getSignaturesForKeyID(j).hasNext()) {
                arrayList.add(pGPPublicKey);
            }
        }
        return arrayList.iterator();
    }

    @Override // org.bouncycastle.openpgp.PGPKeyRing
    public PGPPublicKey getPublicKey() {
        return (PGPPublicKey) this.keys.get(0);
    }

    @Override // org.bouncycastle.openpgp.PGPKeyRing
    public PGPPublicKey getPublicKey(long j) {
        for (int i = 0; i != this.keys.size(); i++) {
            PGPPublicKey pGPPublicKey = (PGPPublicKey) this.keys.get(i);
            if (j == pGPPublicKey.getKeyID()) {
                return pGPPublicKey;
            }
        }
        return null;
    }

    @Override // org.bouncycastle.openpgp.PGPKeyRing
    public PGPPublicKey getPublicKey(byte[] bArr) {
        for (int i = 0; i != this.keys.size(); i++) {
            PGPPublicKey pGPPublicKey = (PGPPublicKey) this.keys.get(i);
            if (Arrays.areEqual(bArr, pGPPublicKey.getFingerprint())) {
                return pGPPublicKey;
            }
        }
        return null;
    }

    @Override // org.bouncycastle.openpgp.PGPKeyRing
    public Iterator<PGPPublicKey> getPublicKeys() {
        return Collections.unmodifiableList(this.keys).iterator();
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator<PGPPublicKey> iterator() {
        return getPublicKeys();
    }
}
