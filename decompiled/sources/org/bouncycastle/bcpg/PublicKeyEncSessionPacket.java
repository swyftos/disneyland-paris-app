package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes6.dex */
public class PublicKeyEncSessionPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private int algorithm;
    private byte[][] data;
    private long keyID;
    private int version;

    public PublicKeyEncSessionPacket(long j, int i, byte[][] bArr) {
        this.version = 3;
        this.keyID = j;
        this.algorithm = i;
        this.data = new byte[bArr.length][];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            this.data[i2] = Arrays.clone(bArr[i2]);
        }
    }

    PublicKeyEncSessionPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.version = bCPGInputStream.read();
        long j = this.keyID | (bCPGInputStream.read() << 56);
        this.keyID = j;
        long j2 = j | (bCPGInputStream.read() << 48);
        this.keyID = j2;
        long j3 = j2 | (bCPGInputStream.read() << 40);
        this.keyID = j3;
        long j4 = j3 | (bCPGInputStream.read() << 32);
        this.keyID = j4;
        long j5 = j4 | (bCPGInputStream.read() << 24);
        this.keyID = j5;
        long j6 = j5 | (bCPGInputStream.read() << 16);
        this.keyID = j6;
        long j7 = j6 | (bCPGInputStream.read() << 8);
        this.keyID = j7;
        this.keyID = j7 | bCPGInputStream.read();
        int i = bCPGInputStream.read();
        this.algorithm = i;
        if (i == 1 || i == 2) {
            this.data = new byte[][]{new MPInteger(bCPGInputStream).getEncoded()};
            return;
        }
        if (i != 16) {
            if (i == 18) {
                this.data = new byte[][]{Streams.readAll(bCPGInputStream)};
                return;
            } else if (i != 20) {
                throw new IOException("unknown PGP public key algorithm encountered");
            }
        }
        byte[][] bArr = new byte[2][];
        this.data = bArr;
        bArr[0] = new MPInteger(bCPGInputStream).getEncoded();
        this.data[1] = new MPInteger(bCPGInputStream).getEncoded();
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream2.write(this.version);
        bCPGOutputStream2.write((byte) (this.keyID >> 56));
        bCPGOutputStream2.write((byte) (this.keyID >> 48));
        bCPGOutputStream2.write((byte) (this.keyID >> 40));
        bCPGOutputStream2.write((byte) (this.keyID >> 32));
        bCPGOutputStream2.write((byte) (this.keyID >> 24));
        bCPGOutputStream2.write((byte) (this.keyID >> 16));
        bCPGOutputStream2.write((byte) (this.keyID >> 8));
        bCPGOutputStream2.write((byte) this.keyID);
        bCPGOutputStream2.write(this.algorithm);
        int i = 0;
        while (true) {
            byte[][] bArr = this.data;
            if (i == bArr.length) {
                bCPGOutputStream2.close();
                bCPGOutputStream.writePacket(1, byteArrayOutputStream.toByteArray(), true);
                return;
            } else {
                bCPGOutputStream2.write(bArr[i]);
                i++;
            }
        }
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public byte[][] getEncSessionKey() {
        return this.data;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public int getVersion() {
        return this.version;
    }
}
