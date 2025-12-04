package org.bouncycastle.openpgp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.SymmetricEncIntegrityPacket;
import org.bouncycastle.bcpg.SymmetricKeyEncSessionPacket;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.operator.PBEDataDecryptorFactory;
import org.bouncycastle.openpgp.operator.PGPDataDecryptor;
import org.bouncycastle.util.io.TeeInputStream;

/* loaded from: classes6.dex */
public class PGPPBEEncryptedData extends PGPEncryptedData {
    SymmetricKeyEncSessionPacket keyData;

    PGPPBEEncryptedData(SymmetricKeyEncSessionPacket symmetricKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
        this.keyData = symmetricKeyEncSessionPacket;
    }

    public InputStream getDataStream(PBEDataDecryptorFactory pBEDataDecryptorFactory) throws IOException, PGPException {
        try {
            byte[] bArrMakeKeyFromPassPhrase = pBEDataDecryptorFactory.makeKeyFromPassPhrase(this.keyData.getEncAlgorithm(), this.keyData.getS2K());
            boolean z = this.encData instanceof SymmetricEncIntegrityPacket;
            byte[] bArrRecoverSessionData = pBEDataDecryptorFactory.recoverSessionData(this.keyData.getEncAlgorithm(), bArrMakeKeyFromPassPhrase, this.keyData.getSecKeyData());
            boolean z2 = true;
            int length = bArrRecoverSessionData.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(bArrRecoverSessionData, 1, bArr, 0, length);
            PGPDataDecryptor pGPDataDecryptorCreateDataDecryptor = pBEDataDecryptorFactory.createDataDecryptor(z, bArrRecoverSessionData[0] & 255, bArr);
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
            boolean z3 = bArr2[blockSize + (-2)] == ((byte) i3) && bArr2[blockSize - 1] == ((byte) i4);
            if (i3 != 0 || i4 != 0) {
                z2 = false;
            }
            if (!z3 && !z2) {
                throw new PGPDataValidationException("data check failed.");
            }
            return this.encStream;
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception creating cipher", e2);
        }
    }

    public int getSymmetricAlgorithm(PBEDataDecryptorFactory pBEDataDecryptorFactory) throws PGPException {
        return pBEDataDecryptorFactory.recoverSessionData(this.keyData.getEncAlgorithm(), pBEDataDecryptorFactory.makeKeyFromPassPhrase(this.keyData.getEncAlgorithm(), this.keyData.getS2K()), this.keyData.getSecKeyData())[0];
    }
}
