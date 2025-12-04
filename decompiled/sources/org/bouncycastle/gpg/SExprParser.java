package org.bouncycastle.gpg;

import com.facebook.common.callercontext.ContextChain;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.bcpg.DSAPublicBCPGKey;
import org.bouncycastle.bcpg.DSASecretBCPGKey;
import org.bouncycastle.bcpg.ECDSAPublicBCPGKey;
import org.bouncycastle.bcpg.ECPublicBCPGKey;
import org.bouncycastle.bcpg.ECSecretBCPGKey;
import org.bouncycastle.bcpg.ElGamalPublicBCPGKey;
import org.bouncycastle.bcpg.ElGamalSecretBCPGKey;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.bcpg.RSASecretBCPGKey;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.bcpg.SecretKeyPacket;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.PBEProtectionRemoverFactory;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.PGPDigestCalculatorProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class SExprParser {
    private final PGPDigestCalculatorProvider digestProvider;

    public SExprParser(PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.digestProvider = pGPDigestCalculatorProvider;
    }

    private static byte[][] extractData(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory) throws IOException, NumberFormatException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        String string = SXprUtils.readString(inputStream, inputStream.read());
        byte[] byteArray = null;
        if (!string.equals("protected")) {
            if (string.equals("d")) {
                return null;
            }
            throw new PGPException("protected block not found");
        }
        String string2 = SXprUtils.readString(inputStream, inputStream.read());
        SXprUtils.skipOpenParenthesis(inputStream);
        S2K s2k = SXprUtils.parseS2K(inputStream);
        byte[] bytes = SXprUtils.readBytes(inputStream, inputStream.read());
        SXprUtils.skipCloseParenthesis(inputStream);
        byte[] bytes2 = SXprUtils.readBytes(inputStream, inputStream.read());
        SXprUtils.skipCloseParenthesis(inputStream);
        PBESecretKeyDecryptor pBESecretKeyDecryptorCreateDecryptor = pBEProtectionRemoverFactory.createDecryptor(string2);
        byte[] bArrRecoverKeyData = pBESecretKeyDecryptorCreateDecryptor.recoverKeyData(7, pBESecretKeyDecryptorCreateDecryptor.makeKeyFromPassPhrase(7, s2k), bytes, bytes2, 0, bytes2.length);
        int i = 40;
        if (inputStream.read() == 40) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            do {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
                if (i < 0) {
                    break;
                }
            } while (i != 41);
            if (i != 41) {
                throw new IOException("unexpected end to SExpr");
            }
            byteArrayOutputStream.write(41);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        SXprUtils.skipCloseParenthesis(inputStream);
        SXprUtils.skipCloseParenthesis(inputStream);
        return new byte[][]{bArrRecoverKeyData, byteArray};
    }

    private BigInteger processDSASecretKey(InputStream inputStream, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, PBEProtectionRemoverFactory pBEProtectionRemoverFactory) throws IOException, NumberFormatException, PGPException {
        byte[][] bArrExtractData = extractData(inputStream, pBEProtectionRemoverFactory);
        byte[] bArr = bArrExtractData[0];
        byte[] bArr2 = bArrExtractData[1];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        BigInteger bigInteger5 = readBigInteger("x", byteArrayInputStream);
        SXprUtils.skipCloseParenthesis(byteArrayInputStream);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        if (!SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read()).equals("hash")) {
            throw new PGPException("hash keyword expected");
        }
        if (!SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read()).equals("sha1")) {
            throw new PGPException("hash keyword expected");
        }
        byte[] bytes = SXprUtils.readBytes(byteArrayInputStream, byteArrayInputStream.read());
        SXprUtils.skipCloseParenthesis(byteArrayInputStream);
        PGPDigestCalculatorProvider pGPDigestCalculatorProvider = this.digestProvider;
        if (pGPDigestCalculatorProvider != null) {
            PGPDigestCalculator pGPDigestCalculator = pGPDigestCalculatorProvider.get(2);
            OutputStream outputStream = pGPDigestCalculator.getOutputStream();
            outputStream.write(Strings.toByteArray("(3:dsa"));
            writeCanonical(outputStream, ContextChain.TAG_PRODUCT, bigInteger);
            writeCanonical(outputStream, "q", bigInteger2);
            writeCanonical(outputStream, "g", bigInteger3);
            writeCanonical(outputStream, "y", bigInteger4);
            writeCanonical(outputStream, "x", bigInteger5);
            if (bArr2 != null) {
                outputStream.write(bArr2);
            }
            outputStream.write(Strings.toByteArray(")"));
            if (!Arrays.constantTimeAreEqual(pGPDigestCalculator.getDigest(), bytes)) {
                throw new PGPException("checksum on protected data failed in SExpr");
            }
        }
        return bigInteger5;
    }

    private BigInteger processECSecretKey(InputStream inputStream, String str, String str2, byte[] bArr, PBEProtectionRemoverFactory pBEProtectionRemoverFactory) throws IOException, NumberFormatException, PGPException {
        byte[][] bArrExtractData = extractData(inputStream, pBEProtectionRemoverFactory);
        byte[] bArr2 = bArrExtractData[0];
        byte[] bArr3 = bArrExtractData[1];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        BigInteger bigInteger = readBigInteger("d", byteArrayInputStream);
        SXprUtils.skipCloseParenthesis(byteArrayInputStream);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        if (!SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read()).equals("hash")) {
            throw new PGPException("hash keyword expected");
        }
        if (!SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read()).equals("sha1")) {
            throw new PGPException("hash keyword expected");
        }
        byte[] bytes = SXprUtils.readBytes(byteArrayInputStream, byteArrayInputStream.read());
        SXprUtils.skipCloseParenthesis(byteArrayInputStream);
        PGPDigestCalculatorProvider pGPDigestCalculatorProvider = this.digestProvider;
        if (pGPDigestCalculatorProvider != null) {
            PGPDigestCalculator pGPDigestCalculator = pGPDigestCalculatorProvider.get(2);
            OutputStream outputStream = pGPDigestCalculator.getOutputStream();
            outputStream.write(Strings.toByteArray("(3:ecc"));
            outputStream.write(Strings.toByteArray("(" + str.length() + ":" + str + str2.length() + ":" + str2 + ")"));
            writeCanonical(outputStream, "q", bArr);
            writeCanonical(outputStream, "d", bigInteger);
            if (bArr3 != null) {
                outputStream.write(bArr3);
            }
            outputStream.write(Strings.toByteArray(")"));
            if (!Arrays.constantTimeAreEqual(pGPDigestCalculator.getDigest(), bytes)) {
                throw new PGPException("checksum on protected data failed in SExpr");
            }
        }
        return bigInteger;
    }

    private BigInteger processElGamalSecretKey(InputStream inputStream, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, PBEProtectionRemoverFactory pBEProtectionRemoverFactory) throws IOException, NumberFormatException, PGPException {
        byte[][] bArrExtractData = extractData(inputStream, pBEProtectionRemoverFactory);
        byte[] bArr = bArrExtractData[0];
        byte[] bArr2 = bArrExtractData[1];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        BigInteger bigInteger4 = readBigInteger("x", byteArrayInputStream);
        SXprUtils.skipCloseParenthesis(byteArrayInputStream);
        SXprUtils.skipOpenParenthesis(byteArrayInputStream);
        if (!SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read()).equals("hash")) {
            throw new PGPException("hash keyword expected");
        }
        if (!SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read()).equals("sha1")) {
            throw new PGPException("hash keyword expected");
        }
        byte[] bytes = SXprUtils.readBytes(byteArrayInputStream, byteArrayInputStream.read());
        SXprUtils.skipCloseParenthesis(byteArrayInputStream);
        PGPDigestCalculatorProvider pGPDigestCalculatorProvider = this.digestProvider;
        if (pGPDigestCalculatorProvider != null) {
            PGPDigestCalculator pGPDigestCalculator = pGPDigestCalculatorProvider.get(2);
            OutputStream outputStream = pGPDigestCalculator.getOutputStream();
            outputStream.write(Strings.toByteArray("(3:elg"));
            writeCanonical(outputStream, ContextChain.TAG_PRODUCT, bigInteger);
            writeCanonical(outputStream, "g", bigInteger2);
            writeCanonical(outputStream, "y", bigInteger3);
            writeCanonical(outputStream, "x", bigInteger4);
            if (bArr2 != null) {
                outputStream.write(bArr2);
            }
            outputStream.write(Strings.toByteArray(")"));
            if (!Arrays.constantTimeAreEqual(pGPDigestCalculator.getDigest(), bytes)) {
                throw new PGPException("checksum on protected data failed in SExpr");
            }
        }
        return bigInteger4;
    }

    private BigInteger[] processRSASecretKey(InputStream inputStream, BigInteger bigInteger, BigInteger bigInteger2, PBEProtectionRemoverFactory pBEProtectionRemoverFactory) throws IOException, NumberFormatException, PGPException {
        byte[] bArr;
        BigInteger bigInteger3;
        byte[][] bArrExtractData = extractData(inputStream, pBEProtectionRemoverFactory);
        if (bArrExtractData == null) {
            bigInteger3 = new BigInteger(1, SXprUtils.readBytes(inputStream, inputStream.read()));
            SXprUtils.skipCloseParenthesis(inputStream);
            bArr = null;
        } else {
            byte[] bArr2 = bArrExtractData[0];
            bArr = bArrExtractData[1];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
            SXprUtils.skipOpenParenthesis(byteArrayInputStream);
            SXprUtils.skipOpenParenthesis(byteArrayInputStream);
            bigInteger3 = readBigInteger("d", byteArrayInputStream);
            inputStream = byteArrayInputStream;
        }
        BigInteger bigInteger4 = readBigInteger(ContextChain.TAG_PRODUCT, inputStream);
        BigInteger bigInteger5 = readBigInteger("q", inputStream);
        BigInteger bigInteger6 = readBigInteger("u", inputStream);
        if (bArrExtractData == null) {
            return new BigInteger[]{bigInteger3, bigInteger4, bigInteger5, bigInteger6};
        }
        SXprUtils.skipCloseParenthesis(inputStream);
        SXprUtils.skipOpenParenthesis(inputStream);
        if (!SXprUtils.readString(inputStream, inputStream.read()).equals("hash")) {
            throw new PGPException("hash keyword expected");
        }
        if (!SXprUtils.readString(inputStream, inputStream.read()).equals("sha1")) {
            throw new PGPException("hash keyword expected");
        }
        byte[] bytes = SXprUtils.readBytes(inputStream, inputStream.read());
        SXprUtils.skipCloseParenthesis(inputStream);
        PGPDigestCalculatorProvider pGPDigestCalculatorProvider = this.digestProvider;
        if (pGPDigestCalculatorProvider != null) {
            PGPDigestCalculator pGPDigestCalculator = pGPDigestCalculatorProvider.get(2);
            OutputStream outputStream = pGPDigestCalculator.getOutputStream();
            outputStream.write(Strings.toByteArray("(3:rsa"));
            writeCanonical(outputStream, "n", bigInteger);
            writeCanonical(outputStream, "e", bigInteger2);
            writeCanonical(outputStream, "d", bigInteger3);
            writeCanonical(outputStream, ContextChain.TAG_PRODUCT, bigInteger4);
            writeCanonical(outputStream, "q", bigInteger5);
            writeCanonical(outputStream, "u", bigInteger6);
            if (bArr != null) {
                outputStream.write(bArr);
            }
            outputStream.write(Strings.toByteArray(")"));
            if (!Arrays.constantTimeAreEqual(pGPDigestCalculator.getDigest(), bytes)) {
                throw new PGPException("checksum on protected data failed in SExpr");
            }
        }
        return new BigInteger[]{bigInteger3, bigInteger4, bigInteger5, bigInteger6};
    }

    private BigInteger readBigInteger(String str, InputStream inputStream) throws IOException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        if (SXprUtils.readString(inputStream, inputStream.read()).equals(str)) {
            BigInteger bigInteger = new BigInteger(1, SXprUtils.readBytes(inputStream, inputStream.read()));
            SXprUtils.skipCloseParenthesis(inputStream);
            return bigInteger;
        }
        throw new PGPException(str + " value expected");
    }

    private void writeCanonical(OutputStream outputStream, String str, BigInteger bigInteger) throws IOException {
        writeCanonical(outputStream, str, bigInteger.toByteArray());
    }

    private void writeCanonical(OutputStream outputStream, String str, byte[] bArr) throws IOException {
        outputStream.write(Strings.toByteArray("(" + str.length() + ":" + str + bArr.length + ":"));
        outputStream.write(bArr);
        outputStream.write(Strings.toByteArray(")"));
    }

    public PGPSecretKey parseSecretKey(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, PGPPublicKey pGPPublicKey) throws IOException, NumberFormatException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        String string = SXprUtils.readString(inputStream, inputStream.read());
        if (!string.equals("protected-private-key") && !string.equals("private-key")) {
            throw new PGPException("unknown key type found");
        }
        SXprUtils.skipOpenParenthesis(inputStream);
        String string2 = SXprUtils.readString(inputStream, inputStream.read());
        if (string2.equals("ecc")) {
            SXprUtils.skipOpenParenthesis(inputStream);
            String string3 = SXprUtils.readString(inputStream, inputStream.read());
            String string4 = SXprUtils.readString(inputStream, inputStream.read());
            SXprUtils.skipCloseParenthesis(inputStream);
            SXprUtils.skipOpenParenthesis(inputStream);
            if (!SXprUtils.readString(inputStream, inputStream.read()).equals("q")) {
                throw new PGPException("no q value found");
            }
            byte[] bytes = SXprUtils.readBytes(inputStream, inputStream.read());
            SXprUtils.skipCloseParenthesis(inputStream);
            BigInteger bigIntegerProcessECSecretKey = processECSecretKey(inputStream, string3, string4, bytes, pBEProtectionRemoverFactory);
            if (string4.startsWith("NIST ")) {
                string4 = string4.substring(5);
            }
            ECDSAPublicBCPGKey eCDSAPublicBCPGKey = new ECDSAPublicBCPGKey(ECNamedCurveTable.getOID(string4), new BigInteger(1, bytes));
            ECPublicBCPGKey eCPublicBCPGKey = (ECPublicBCPGKey) pGPPublicKey.getPublicKeyPacket().getKey();
            if (eCDSAPublicBCPGKey.getCurveOID().equals((ASN1Primitive) eCPublicBCPGKey.getCurveOID()) && eCDSAPublicBCPGKey.getEncodedPoint().equals(eCPublicBCPGKey.getEncodedPoint())) {
                return new PGPSecretKey(new SecretKeyPacket(pGPPublicKey.getPublicKeyPacket(), 0, null, null, new ECSecretBCPGKey(bigIntegerProcessECSecretKey).getEncoded()), pGPPublicKey);
            }
            throw new PGPException("passed in public key does not match secret key");
        }
        if (string2.equals("dsa")) {
            BigInteger bigInteger = readBigInteger(ContextChain.TAG_PRODUCT, inputStream);
            BigInteger bigInteger2 = readBigInteger("q", inputStream);
            BigInteger bigInteger3 = readBigInteger("g", inputStream);
            BigInteger bigInteger4 = readBigInteger("y", inputStream);
            BigInteger bigIntegerProcessDSASecretKey = processDSASecretKey(inputStream, bigInteger, bigInteger2, bigInteger3, bigInteger4, pBEProtectionRemoverFactory);
            DSAPublicBCPGKey dSAPublicBCPGKey = new DSAPublicBCPGKey(bigInteger, bigInteger2, bigInteger3, bigInteger4);
            DSAPublicBCPGKey dSAPublicBCPGKey2 = (DSAPublicBCPGKey) pGPPublicKey.getPublicKeyPacket().getKey();
            if (dSAPublicBCPGKey.getP().equals(dSAPublicBCPGKey2.getP()) && dSAPublicBCPGKey.getQ().equals(dSAPublicBCPGKey2.getQ()) && dSAPublicBCPGKey.getG().equals(dSAPublicBCPGKey2.getG()) && dSAPublicBCPGKey.getY().equals(dSAPublicBCPGKey2.getY())) {
                return new PGPSecretKey(new SecretKeyPacket(pGPPublicKey.getPublicKeyPacket(), 0, null, null, new DSASecretBCPGKey(bigIntegerProcessDSASecretKey).getEncoded()), pGPPublicKey);
            }
            throw new PGPException("passed in public key does not match secret key");
        }
        if (string2.equals("elg")) {
            BigInteger bigInteger5 = readBigInteger(ContextChain.TAG_PRODUCT, inputStream);
            BigInteger bigInteger6 = readBigInteger("g", inputStream);
            BigInteger bigInteger7 = readBigInteger("y", inputStream);
            BigInteger bigIntegerProcessElGamalSecretKey = processElGamalSecretKey(inputStream, bigInteger5, bigInteger6, bigInteger7, pBEProtectionRemoverFactory);
            ElGamalPublicBCPGKey elGamalPublicBCPGKey = new ElGamalPublicBCPGKey(bigInteger5, bigInteger6, bigInteger7);
            ElGamalPublicBCPGKey elGamalPublicBCPGKey2 = (ElGamalPublicBCPGKey) pGPPublicKey.getPublicKeyPacket().getKey();
            if (elGamalPublicBCPGKey.getP().equals(elGamalPublicBCPGKey2.getP()) && elGamalPublicBCPGKey.getG().equals(elGamalPublicBCPGKey2.getG()) && elGamalPublicBCPGKey.getY().equals(elGamalPublicBCPGKey2.getY())) {
                return new PGPSecretKey(new SecretKeyPacket(pGPPublicKey.getPublicKeyPacket(), 0, null, null, new ElGamalSecretBCPGKey(bigIntegerProcessElGamalSecretKey).getEncoded()), pGPPublicKey);
            }
            throw new PGPException("passed in public key does not match secret key");
        }
        if (!string2.equals("rsa")) {
            throw new PGPException("unknown key type: " + string2);
        }
        BigInteger bigInteger8 = readBigInteger("n", inputStream);
        BigInteger bigInteger9 = readBigInteger("e", inputStream);
        BigInteger[] bigIntegerArrProcessRSASecretKey = processRSASecretKey(inputStream, bigInteger8, bigInteger9, pBEProtectionRemoverFactory);
        RSAPublicBCPGKey rSAPublicBCPGKey = new RSAPublicBCPGKey(bigInteger8, bigInteger9);
        RSAPublicBCPGKey rSAPublicBCPGKey2 = (RSAPublicBCPGKey) pGPPublicKey.getPublicKeyPacket().getKey();
        if (rSAPublicBCPGKey.getModulus().equals(rSAPublicBCPGKey2.getModulus()) && rSAPublicBCPGKey.getPublicExponent().equals(rSAPublicBCPGKey2.getPublicExponent())) {
            return new PGPSecretKey(new SecretKeyPacket(pGPPublicKey.getPublicKeyPacket(), 0, null, null, new RSASecretBCPGKey(bigIntegerArrProcessRSASecretKey[0], bigIntegerArrProcessRSASecretKey[1], bigIntegerArrProcessRSASecretKey[2]).getEncoded()), pGPPublicKey);
        }
        throw new PGPException("passed in public key does not match secret key");
    }

    public PGPSecretKey parseSecretKey(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, NumberFormatException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        String string = SXprUtils.readString(inputStream, inputStream.read());
        if (!string.equals("protected-private-key") && !string.equals("private-key")) {
            throw new PGPException("unknown key type found");
        }
        SXprUtils.skipOpenParenthesis(inputStream);
        String string2 = SXprUtils.readString(inputStream, inputStream.read());
        if (string2.equals("ecc")) {
            SXprUtils.skipOpenParenthesis(inputStream);
            String string3 = SXprUtils.readString(inputStream, inputStream.read());
            String string4 = SXprUtils.readString(inputStream, inputStream.read());
            if (string4.startsWith("NIST ")) {
                string4 = string4.substring(5);
            }
            SXprUtils.skipCloseParenthesis(inputStream);
            SXprUtils.skipOpenParenthesis(inputStream);
            if (!SXprUtils.readString(inputStream, inputStream.read()).equals("q")) {
                throw new PGPException("no q value found");
            }
            byte[] bytes = SXprUtils.readBytes(inputStream, inputStream.read());
            PublicKeyPacket publicKeyPacket = new PublicKeyPacket(19, new Date(), new ECDSAPublicBCPGKey(ECNamedCurveTable.getOID(string4), new BigInteger(1, bytes)));
            SXprUtils.skipCloseParenthesis(inputStream);
            return new PGPSecretKey(new SecretKeyPacket(publicKeyPacket, 0, null, null, new ECSecretBCPGKey(processECSecretKey(inputStream, string3, string4, bytes, pBEProtectionRemoverFactory)).getEncoded()), new PGPPublicKey(publicKeyPacket, keyFingerPrintCalculator));
        }
        if (string2.equals("dsa")) {
            BigInteger bigInteger = readBigInteger(ContextChain.TAG_PRODUCT, inputStream);
            BigInteger bigInteger2 = readBigInteger("q", inputStream);
            BigInteger bigInteger3 = readBigInteger("g", inputStream);
            BigInteger bigInteger4 = readBigInteger("y", inputStream);
            BigInteger bigIntegerProcessDSASecretKey = processDSASecretKey(inputStream, bigInteger, bigInteger2, bigInteger3, bigInteger4, pBEProtectionRemoverFactory);
            PublicKeyPacket publicKeyPacket2 = new PublicKeyPacket(17, new Date(), new DSAPublicBCPGKey(bigInteger, bigInteger2, bigInteger3, bigInteger4));
            return new PGPSecretKey(new SecretKeyPacket(publicKeyPacket2, 0, null, null, new DSASecretBCPGKey(bigIntegerProcessDSASecretKey).getEncoded()), new PGPPublicKey(publicKeyPacket2, keyFingerPrintCalculator));
        }
        if (string2.equals("elg")) {
            BigInteger bigInteger5 = readBigInteger(ContextChain.TAG_PRODUCT, inputStream);
            BigInteger bigInteger6 = readBigInteger("g", inputStream);
            BigInteger bigInteger7 = readBigInteger("y", inputStream);
            BigInteger bigIntegerProcessElGamalSecretKey = processElGamalSecretKey(inputStream, bigInteger5, bigInteger6, bigInteger7, pBEProtectionRemoverFactory);
            PublicKeyPacket publicKeyPacket3 = new PublicKeyPacket(16, new Date(), new ElGamalPublicBCPGKey(bigInteger5, bigInteger6, bigInteger7));
            return new PGPSecretKey(new SecretKeyPacket(publicKeyPacket3, 0, null, null, new ElGamalSecretBCPGKey(bigIntegerProcessElGamalSecretKey).getEncoded()), new PGPPublicKey(publicKeyPacket3, keyFingerPrintCalculator));
        }
        if (!string2.equals("rsa")) {
            throw new PGPException("unknown key type: " + string2);
        }
        BigInteger bigInteger8 = readBigInteger("n", inputStream);
        BigInteger bigInteger9 = readBigInteger("e", inputStream);
        BigInteger[] bigIntegerArrProcessRSASecretKey = processRSASecretKey(inputStream, bigInteger8, bigInteger9, pBEProtectionRemoverFactory);
        PublicKeyPacket publicKeyPacket4 = new PublicKeyPacket(1, new Date(), new RSAPublicBCPGKey(bigInteger8, bigInteger9));
        return new PGPSecretKey(new SecretKeyPacket(publicKeyPacket4, 0, null, null, new RSASecretBCPGKey(bigIntegerArrProcessRSASecretKey[0], bigIntegerArrProcessRSASecretKey[1], bigIntegerArrProcessRSASecretKey[2]).getEncoded()), new PGPPublicKey(publicKeyPacket4, keyFingerPrintCalculator));
    }
}
