package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

/* loaded from: classes6.dex */
public class PublicKeyPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private int algorithm;
    private BCPGKey key;
    private long time;
    private int validDays;
    private int version;

    public PublicKeyPacket(int i, Date date, BCPGKey bCPGKey) {
        this.version = 4;
        this.time = date.getTime() / 1000;
        this.algorithm = i;
        this.key = bCPGKey;
    }

    PublicKeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        BCPGKey rSAPublicBCPGKey;
        this.version = bCPGInputStream.read();
        this.time = (bCPGInputStream.read() << 24) | (bCPGInputStream.read() << 16) | (bCPGInputStream.read() << 8) | bCPGInputStream.read();
        if (this.version <= 3) {
            this.validDays = (bCPGInputStream.read() << 8) | bCPGInputStream.read();
        }
        byte b = (byte) bCPGInputStream.read();
        this.algorithm = b;
        if (b == 1 || b == 2 || b == 3) {
            rSAPublicBCPGKey = new RSAPublicBCPGKey(bCPGInputStream);
        } else if (b != 22) {
            switch (b) {
                case 16:
                case 20:
                    rSAPublicBCPGKey = new ElGamalPublicBCPGKey(bCPGInputStream);
                    break;
                case 17:
                    rSAPublicBCPGKey = new DSAPublicBCPGKey(bCPGInputStream);
                    break;
                case 18:
                    rSAPublicBCPGKey = new ECDHPublicBCPGKey(bCPGInputStream);
                    break;
                case 19:
                    rSAPublicBCPGKey = new ECDSAPublicBCPGKey(bCPGInputStream);
                    break;
                default:
                    throw new IOException("unknown PGP public key algorithm encountered: " + this.algorithm);
            }
        } else {
            rSAPublicBCPGKey = new EdDSAPublicBCPGKey(bCPGInputStream);
        }
        this.key = rSAPublicBCPGKey;
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(6, getEncodedContents(), true);
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncodedContents() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream.write(this.version);
        bCPGOutputStream.write((byte) (this.time >> 24));
        bCPGOutputStream.write((byte) (this.time >> 16));
        bCPGOutputStream.write((byte) (this.time >> 8));
        bCPGOutputStream.write((byte) this.time);
        if (this.version <= 3) {
            bCPGOutputStream.write((byte) (this.validDays >> 8));
            bCPGOutputStream.write((byte) this.validDays);
        }
        bCPGOutputStream.write(this.algorithm);
        bCPGOutputStream.writeObject((BCPGObject) this.key);
        bCPGOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public BCPGKey getKey() {
        return this.key;
    }

    public Date getTime() {
        return new Date(this.time * 1000);
    }

    public int getValidDays() {
        return this.validDays;
    }

    public int getVersion() {
        return this.version;
    }
}
