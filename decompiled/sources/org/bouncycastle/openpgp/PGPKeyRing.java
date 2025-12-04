package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.Packet;
import org.bouncycastle.bcpg.SignaturePacket;
import org.bouncycastle.bcpg.TrustPacket;
import org.bouncycastle.bcpg.UserAttributePacket;
import org.bouncycastle.bcpg.UserIDPacket;

/* loaded from: classes6.dex */
public abstract class PGPKeyRing {
    PGPKeyRing() {
    }

    static TrustPacket readOptionalTrustPacket(BCPGInputStream bCPGInputStream) {
        if (bCPGInputStream.nextPacketTag() == 12) {
            return (TrustPacket) bCPGInputStream.readPacket();
        }
        return null;
    }

    static List readSignaturesAndTrust(BCPGInputStream bCPGInputStream) {
        try {
            ArrayList arrayList = new ArrayList();
            while (bCPGInputStream.nextPacketTag() == 2) {
                arrayList.add(new PGPSignature((SignaturePacket) bCPGInputStream.readPacket(), readOptionalTrustPacket(bCPGInputStream)));
            }
            return arrayList;
        } catch (PGPException e) {
            throw new IOException("can't create signature object: " + e.getMessage() + ", cause: " + e.getUnderlyingException().toString());
        }
    }

    static void readUserIDs(BCPGInputStream bCPGInputStream, List list, List list2, List list3) {
        while (true) {
            if (bCPGInputStream.nextPacketTag() != 13 && bCPGInputStream.nextPacketTag() != 17) {
                return;
            }
            Packet packet = bCPGInputStream.readPacket();
            if (packet instanceof UserIDPacket) {
                list.add((UserIDPacket) packet);
            } else {
                list.add(new PGPUserAttributeSubpacketVector(((UserAttributePacket) packet).getSubpackets()));
            }
            list2.add(readOptionalTrustPacket(bCPGInputStream));
            list3.add(readSignaturesAndTrust(bCPGInputStream));
        }
    }

    static BCPGInputStream wrap(InputStream inputStream) {
        return inputStream instanceof BCPGInputStream ? (BCPGInputStream) inputStream : new BCPGInputStream(inputStream);
    }

    public abstract void encode(OutputStream outputStream) throws IOException;

    public abstract byte[] getEncoded() throws IOException;

    public abstract Iterator<PGPPublicKey> getKeysWithSignaturesBy(long j);

    public abstract PGPPublicKey getPublicKey();

    public abstract PGPPublicKey getPublicKey(long j);

    public abstract PGPPublicKey getPublicKey(byte[] bArr);

    public abstract Iterator<PGPPublicKey> getPublicKeys();
}
