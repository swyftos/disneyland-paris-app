package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.PGPDataEncryptor;
import org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.PGPKeyEncryptionMethodGenerator;
import org.bouncycastle.util.io.TeeOutputStream;

/* loaded from: classes6.dex */
public class PGPEncryptedDataGenerator implements SymmetricKeyAlgorithmTags, StreamGenerator {
    public static final int S2K_SHA1 = 2;
    public static final int S2K_SHA224 = 11;
    public static final int S2K_SHA256 = 8;
    public static final int S2K_SHA384 = 9;
    public static final int S2K_SHA512 = 10;
    private OutputStream cOut;
    private PGPDataEncryptorBuilder dataEncryptorBuilder;
    private int defAlgorithm;
    private PGPDigestCalculator digestCalc;
    private OutputStream genOut;
    private List methods;
    private boolean oldFormat;
    private BCPGOutputStream pOut;
    private SecureRandom rand;

    private class ClosableBCPGOutputStream extends BCPGOutputStream {
        public ClosableBCPGOutputStream(OutputStream outputStream, int i, long j) {
            super(outputStream, i, j);
        }

        public ClosableBCPGOutputStream(OutputStream outputStream, int i, long j, boolean z) {
            super(outputStream, i, j, z);
        }

        public ClosableBCPGOutputStream(OutputStream outputStream, int i, byte[] bArr) {
            super(outputStream, i, bArr);
        }

        @Override // org.bouncycastle.bcpg.BCPGOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            finish();
        }
    }

    public PGPEncryptedDataGenerator(PGPDataEncryptorBuilder pGPDataEncryptorBuilder) {
        this(pGPDataEncryptorBuilder, false);
    }

    public PGPEncryptedDataGenerator(PGPDataEncryptorBuilder pGPDataEncryptorBuilder, boolean z) {
        this.oldFormat = false;
        this.methods = new ArrayList();
        this.dataEncryptorBuilder = pGPDataEncryptorBuilder;
        this.oldFormat = z;
        this.defAlgorithm = pGPDataEncryptorBuilder.getAlgorithm();
        this.rand = this.dataEncryptorBuilder.getSecureRandom();
    }

    private void addCheckSum(byte[] bArr) {
        int i = 0;
        for (int i2 = 1; i2 != bArr.length - 2; i2++) {
            i += bArr[i2] & 255;
        }
        bArr[bArr.length - 2] = (byte) (i >> 8);
        bArr[bArr.length - 1] = (byte) i;
    }

    private byte[] createSessionInfo(int i, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 3];
        bArr2[0] = (byte) i;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        addCheckSum(bArr2);
        return bArr2;
    }

    private OutputStream open(OutputStream outputStream, long j, byte[] bArr) throws IOException, PGPException {
        byte[] bArrMakeRandomKey;
        if (this.cOut != null) {
            throw new IllegalStateException("generator already in open state");
        }
        if (this.methods.size() == 0) {
            throw new IllegalStateException("no encryption methods specified");
        }
        this.pOut = new BCPGOutputStream(outputStream);
        this.defAlgorithm = this.dataEncryptorBuilder.getAlgorithm();
        this.rand = this.dataEncryptorBuilder.getSecureRandom();
        if (this.methods.size() != 1) {
            bArrMakeRandomKey = PGPUtil.makeRandomKey(this.defAlgorithm, this.rand);
            byte[] bArrCreateSessionInfo = createSessionInfo(this.defAlgorithm, bArrMakeRandomKey);
            for (int i = 0; i != this.methods.size(); i++) {
                this.pOut.writePacket(((PGPKeyEncryptionMethodGenerator) this.methods.get(i)).generate(this.defAlgorithm, bArrCreateSessionInfo));
            }
        } else if (this.methods.get(0) instanceof PBEKeyEncryptionMethodGenerator) {
            bArrMakeRandomKey = ((PBEKeyEncryptionMethodGenerator) this.methods.get(0)).getKey(this.dataEncryptorBuilder.getAlgorithm());
            this.pOut.writePacket(((PGPKeyEncryptionMethodGenerator) this.methods.get(0)).generate(this.defAlgorithm, null));
        } else {
            bArrMakeRandomKey = PGPUtil.makeRandomKey(this.defAlgorithm, this.rand);
            this.pOut.writePacket(((PGPKeyEncryptionMethodGenerator) this.methods.get(0)).generate(this.defAlgorithm, createSessionInfo(this.defAlgorithm, bArrMakeRandomKey)));
        }
        try {
            PGPDataEncryptor pGPDataEncryptorBuild = this.dataEncryptorBuilder.build(bArrMakeRandomKey);
            PGPDigestCalculator integrityCalculator = pGPDataEncryptorBuild.getIntegrityCalculator();
            this.digestCalc = integrityCalculator;
            if (bArr == null) {
                if (integrityCalculator != null) {
                    ClosableBCPGOutputStream closableBCPGOutputStream = new ClosableBCPGOutputStream(outputStream, 18, j + pGPDataEncryptorBuild.getBlockSize() + 25);
                    this.pOut = closableBCPGOutputStream;
                    closableBCPGOutputStream.write(1);
                } else {
                    this.pOut = new ClosableBCPGOutputStream(outputStream, 9, j + pGPDataEncryptorBuild.getBlockSize() + 2, this.oldFormat);
                }
            } else if (integrityCalculator != null) {
                ClosableBCPGOutputStream closableBCPGOutputStream2 = new ClosableBCPGOutputStream(outputStream, 18, bArr);
                this.pOut = closableBCPGOutputStream2;
                closableBCPGOutputStream2.write(1);
            } else {
                this.pOut = new ClosableBCPGOutputStream(outputStream, 9, bArr);
            }
            OutputStream outputStream2 = pGPDataEncryptorBuild.getOutputStream(this.pOut);
            this.cOut = outputStream2;
            this.genOut = outputStream2;
            if (this.digestCalc != null) {
                this.genOut = new TeeOutputStream(this.digestCalc.getOutputStream(), this.cOut);
            }
            int blockSize = pGPDataEncryptorBuild.getBlockSize();
            byte[] bArr2 = new byte[blockSize + 2];
            this.rand.nextBytes(bArr2);
            bArr2[blockSize + 1] = bArr2[blockSize - 1];
            bArr2[blockSize] = bArr2[blockSize - 2];
            this.genOut.write(bArr2);
            return new WrappedGeneratorStream(this.genOut, this);
        } catch (Exception e) {
            throw new PGPException("Exception creating cipher", e);
        }
    }

    public void addMethod(PGPKeyEncryptionMethodGenerator pGPKeyEncryptionMethodGenerator) {
        this.methods.add(pGPKeyEncryptionMethodGenerator);
    }

    @Override // org.bouncycastle.openpgp.StreamGenerator
    public void close() throws IOException {
        if (this.cOut != null) {
            if (this.digestCalc != null) {
                new BCPGOutputStream(this.genOut, 19, 20L).flush();
                this.cOut.write(this.digestCalc.getDigest());
            }
            this.cOut.close();
            this.cOut = null;
            this.pOut = null;
        }
    }

    public OutputStream open(OutputStream outputStream, long j) throws IOException, PGPException {
        return open(outputStream, j, null);
    }

    public OutputStream open(OutputStream outputStream, byte[] bArr) throws IOException, PGPException {
        return open(outputStream, 0L, bArr);
    }
}
