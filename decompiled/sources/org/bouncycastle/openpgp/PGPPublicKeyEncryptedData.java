package org.bouncycastle.openpgp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.PublicKeyEncSessionPacket;
import org.bouncycastle.bcpg.SymmetricEncIntegrityPacket;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.operator.PGPDataDecryptor;
import org.bouncycastle.openpgp.operator.PublicKeyDataDecryptorFactory;
import org.bouncycastle.util.io.TeeInputStream;

/* loaded from: classes6.dex */
public class PGPPublicKeyEncryptedData extends PGPEncryptedData {
    PublicKeyEncSessionPacket keyData;

    PGPPublicKeyEncryptedData(PublicKeyEncSessionPacket publicKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
        this.keyData = publicKeyEncSessionPacket;
    }

    private boolean confirmCheckSum(byte[] bArr) {
        int i = 0;
        for (int i2 = 1; i2 != bArr.length - 2; i2++) {
            i += bArr[i2] & 255;
        }
        return bArr[bArr.length + (-2)] == ((byte) (i >> 8)) && bArr[bArr.length - 1] == ((byte) i);
    }

    public InputStream getDataStream(PublicKeyDataDecryptorFactory publicKeyDataDecryptorFactory) throws IOException, PGPException {
        byte[] bArrRecoverSessionData = publicKeyDataDecryptorFactory.recoverSessionData(this.keyData.getAlgorithm(), this.keyData.getEncSessionKey());
        if (!confirmCheckSum(bArrRecoverSessionData)) {
            throw new PGPKeyValidationException("key checksum failed");
        }
        if (bArrRecoverSessionData[0] == 0) {
            return this.encData.getInputStream();
        }
        try {
            boolean z = this.encData instanceof SymmetricEncIntegrityPacket;
            int length = bArrRecoverSessionData.length - 3;
            byte[] bArr = new byte[length];
            System.arraycopy(bArrRecoverSessionData, 1, bArr, 0, length);
            PGPDataDecryptor pGPDataDecryptorCreateDataDecryptor = publicKeyDataDecryptorFactory.createDataDecryptor(z, bArrRecoverSessionData[0] & 255, bArr);
            this.encStream = new BCPGInputStream(pGPDataDecryptorCreateDataDecryptor.getInputStream(this.encData.getInputStream()));
            if (z) {
                this.truncStream = new PGPEncryptedData.TruncatedStream(this.encStream);
                this.integrityCalculator = pGPDataDecryptorCreateDataDecryptor.getIntegrityCalculator();
                this.encStream = new TeeInputStream(this.truncStream, this.integrityCalculator.getOutputStream());
            }
            int blockSize = pGPDataDecryptorCreateDataDecryptor.getBlockSize();
            byte[] bArr2 = new byte[blockSize];
            for (int i = 0; i != blockSize; i++) {
                int i2 = this.encStream.read();
                if (i2 < 0) {
                    throw new EOFException("unexpected end of stream.");
                }
                bArr2[i] = (byte) i2;
            }
            int i3 = this.encStream.read();
            int i4 = this.encStream.read();
            if (i3 < 0 || i4 < 0) {
                throw new EOFException("unexpected end of stream.");
            }
            return this.encStream;
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception starting decryption", e2);
        }
    }

    public long getKeyID() {
        return this.keyData.getKeyID();
    }

    public int getSymmetricAlgorithm(PublicKeyDataDecryptorFactory publicKeyDataDecryptorFactory) throws PGPException {
        return publicKeyDataDecryptorFactory.recoverSessionData(this.keyData.getAlgorithm(), this.keyData.getEncSessionKey())[0];
    }
}
