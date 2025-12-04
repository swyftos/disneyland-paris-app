package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.Packet;
import org.bouncycastle.bcpg.PublicKeyEncSessionPacket;
import org.bouncycastle.bcpg.SymmetricKeyEncSessionPacket;
import org.bouncycastle.util.Iterable;

/* loaded from: classes6.dex */
public class PGPEncryptedDataList implements Iterable<PGPEncryptedData> {
    InputStreamPacket data;
    List methods;

    public PGPEncryptedDataList(InputStream inputStream) throws IOException {
        this(Util.createBCPGInputStream(inputStream, 1, 3));
    }

    public PGPEncryptedDataList(BCPGInputStream bCPGInputStream) throws IOException {
        List list;
        PGPEncryptedData pGPPublicKeyEncryptedData;
        this.methods = new ArrayList();
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (bCPGInputStream.nextPacketTag() != 1 && bCPGInputStream.nextPacketTag() != 3) {
                break;
            } else {
                arrayList.add(bCPGInputStream.readPacket());
            }
        }
        Packet packet = bCPGInputStream.readPacket();
        if (!(packet instanceof InputStreamPacket)) {
            throw new IOException("unexpected packet in stream: " + packet);
        }
        this.data = (InputStreamPacket) packet;
        for (int i = 0; i != arrayList.size(); i++) {
            if (arrayList.get(i) instanceof SymmetricKeyEncSessionPacket) {
                list = this.methods;
                pGPPublicKeyEncryptedData = new PGPPBEEncryptedData((SymmetricKeyEncSessionPacket) arrayList.get(i), this.data);
            } else {
                list = this.methods;
                pGPPublicKeyEncryptedData = new PGPPublicKeyEncryptedData((PublicKeyEncSessionPacket) arrayList.get(i), this.data);
            }
            list.add(pGPPublicKeyEncryptedData);
        }
    }

    public PGPEncryptedDataList(byte[] bArr) throws IOException {
        this(Util.createBCPGInputStream(new ByteArrayInputStream(bArr), 1, 3));
    }

    public PGPEncryptedData get(int i) {
        return (PGPEncryptedData) this.methods.get(i);
    }

    public Iterator<PGPEncryptedData> getEncryptedDataObjects() {
        return this.methods.iterator();
    }

    public boolean isEmpty() {
        return this.methods.isEmpty();
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator<PGPEncryptedData> iterator() {
        return getEncryptedDataObjects();
    }

    public int size() {
        return this.methods.size();
    }
}
