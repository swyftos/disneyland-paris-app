package org.bouncycastle.openpgp.operator.bc;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.engines.CAST5Engine;
import org.bouncycastle.crypto.engines.CamelliaEngine;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.ElGamalEngine;
import org.bouncycastle.crypto.engines.IDEAEngine;
import org.bouncycastle.crypto.engines.RFC3394WrapEngine;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.signers.DSADigestSigner;
import org.bouncycastle.crypto.signers.DSASigner;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.crypto.signers.RSADigestSigner;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
abstract class BcImplProvider {

    private static class EdDsaSigner implements Signer {
        private final byte[] digBuf;
        private final Digest digest;
        private final Signer signer;

        EdDsaSigner(Signer signer, Digest digest) {
            this.signer = signer;
            this.digest = digest;
            this.digBuf = new byte[digest.getDigestSize()];
        }

        @Override // org.bouncycastle.crypto.Signer
        public byte[] generateSignature() {
            this.digest.doFinal(this.digBuf, 0);
            Signer signer = this.signer;
            byte[] bArr = this.digBuf;
            signer.update(bArr, 0, bArr.length);
            return this.signer.generateSignature();
        }

        @Override // org.bouncycastle.crypto.Signer
        public void init(boolean z, CipherParameters cipherParameters) {
            this.signer.init(z, cipherParameters);
            this.digest.reset();
        }

        @Override // org.bouncycastle.crypto.Signer
        public void reset() {
            Arrays.clear(this.digBuf);
            this.signer.reset();
            this.digest.reset();
        }

        @Override // org.bouncycastle.crypto.Signer
        public void update(byte b) {
            this.digest.update(b);
        }

        @Override // org.bouncycastle.crypto.Signer
        public void update(byte[] bArr, int i, int i2) {
            this.digest.update(bArr, i, i2);
        }

        @Override // org.bouncycastle.crypto.Signer
        public boolean verifySignature(byte[] bArr) {
            this.digest.doFinal(this.digBuf, 0);
            Signer signer = this.signer;
            byte[] bArr2 = this.digBuf;
            signer.update(bArr2, 0, bArr2.length);
            return this.signer.verifySignature(bArr);
        }
    }

    static BlockCipher createBlockCipher(int i) throws PGPException {
        switch (i) {
            case 1:
                return new IDEAEngine();
            case 2:
                return new DESedeEngine();
            case 3:
                return new CAST5Engine();
            case 4:
                return new BlowfishEngine();
            case 5:
            default:
                throw new PGPException("cannot recognise cipher");
            case 6:
                return new DESEngine();
            case 7:
            case 8:
            case 9:
                return new AESEngine();
            case 10:
                return new TwofishEngine();
            case 11:
            case 12:
            case 13:
                return new CamelliaEngine();
        }
    }

    static Digest createDigest(int i) throws PGPException {
        switch (i) {
            case 1:
                return new MD5Digest();
            case 2:
                return new SHA1Digest();
            case 3:
                return new RIPEMD160Digest();
            case 4:
            case 7:
            default:
                throw new PGPException("cannot recognise digest");
            case 5:
                return new MD2Digest();
            case 6:
                return new TigerDigest();
            case 8:
                return new SHA256Digest();
            case 9:
                return new SHA384Digest();
            case 10:
                return new SHA512Digest();
            case 11:
                return new SHA224Digest();
        }
    }

    static AsymmetricBlockCipher createPublicKeyCipher(int i) throws PGPException {
        if (i == 1 || i == 2) {
            return new PKCS1Encoding(new RSABlindedEngine());
        }
        switch (i) {
            case 16:
            case 20:
                return new PKCS1Encoding(new ElGamalEngine());
            case 17:
                throw new PGPException("Can't use DSA for encryption.");
            case 18:
                throw new PGPException("Not implemented.");
            case 19:
                throw new PGPException("Can't use ECDSA for encryption.");
            default:
                throw new PGPException("unknown asymmetric algorithm: " + i);
        }
    }

    static Signer createSigner(int i, int i2) throws PGPException {
        if (i == 1 || i == 3) {
            return new RSADigestSigner(createDigest(i2));
        }
        if (i == 17) {
            return new DSADigestSigner(new DSASigner(), createDigest(i2));
        }
        if (i == 19) {
            return new DSADigestSigner(new ECDSASigner(), createDigest(i2));
        }
        if (i == 22) {
            return new EdDsaSigner(new Ed25519Signer(), createDigest(i2));
        }
        throw new PGPException("cannot recognise keyAlgorithm: " + i);
    }

    static Wrapper createWrapper(int i) throws PGPException {
        switch (i) {
            case 7:
            case 8:
            case 9:
                return new RFC3394WrapEngine(new AESEngine());
            case 10:
            default:
                throw new PGPException("unknown wrap algorithm: " + i);
            case 11:
            case 12:
            case 13:
                return new RFC3394WrapEngine(new CamelliaEngine());
        }
    }
}
