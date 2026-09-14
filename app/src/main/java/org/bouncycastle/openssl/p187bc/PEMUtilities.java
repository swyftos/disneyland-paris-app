package org.bouncycastle.openssl.p187bc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.openssl.EncryptionException;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes6.dex */
abstract class PEMUtilities {
    private static final Map KEYSIZES;
    private static final Set PKCS5_SCHEME_1;
    private static final Set PKCS5_SCHEME_2;

    static {
        HashMap map = new HashMap();
        KEYSIZES = map;
        HashSet hashSet = new HashSet();
        PKCS5_SCHEME_1 = hashSet;
        HashSet hashSet2 = new HashSet();
        PKCS5_SCHEME_2 = hashSet2;
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC);
        hashSet2.add(PKCSObjectIdentifiers.id_PBES2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.des_EDE3_CBC;
        hashSet2.add(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_CBC;
        hashSet2.add(aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes192_CBC;
        hashSet2.add(aSN1ObjectIdentifier3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_aes256_CBC;
        hashSet2.add(aSN1ObjectIdentifier4);
        map.put(aSN1ObjectIdentifier.getId(), Integers.valueOf(192));
        map.put(aSN1ObjectIdentifier2.getId(), Integers.valueOf(128));
        map.put(aSN1ObjectIdentifier3.getId(), Integers.valueOf(192));
        map.put(aSN1ObjectIdentifier4.getId(), Integers.valueOf(256));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.getId(), Integers.valueOf(128));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, Integers.valueOf(40));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, Integers.valueOf(128));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, Integers.valueOf(192));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, Integers.valueOf(128));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, Integers.valueOf(40));
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0130 A[Catch: Exception -> 0x0137, TRY_ENTER, TryCatch #0 {Exception -> 0x0137, blocks: (B:63:0x0130, B:69:0x0141, B:71:0x014d, B:74:0x0167, B:70:0x0145, B:67:0x0139), top: B:82:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0139 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:63:0x0130, B:69:0x0141, B:71:0x014d, B:74:0x0167, B:70:0x0145, B:67:0x0139), top: B:82:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0141 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:63:0x0130, B:69:0x0141, B:71:0x014d, B:74:0x0167, B:70:0x0145, B:67:0x0139), top: B:82:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0145 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:63:0x0130, B:69:0x0141, B:71:0x014d, B:74:0x0167, B:70:0x0145, B:67:0x0139), top: B:82:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0166 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0167 A[Catch: Exception -> 0x0137, TRY_LEAVE, TryCatch #0 {Exception -> 0x0137, blocks: (B:63:0x0130, B:69:0x0141, B:71:0x014d, B:74:0x0167, B:70:0x0145, B:67:0x0139), top: B:82:0x012e }] */
    static byte[] crypt(boolean z, byte[] bArr, char[] cArr, String str, byte[] bArr2) throws EncryptionException {
        String str2;
        byte[] bArr3;
        KeyParameter key;
        BlockCipher aESEngine;
        BlockCipher oFBBlockCipher;
        BufferedBlockCipher paddedBufferedBlockCipher;
        BufferedBlockCipher bufferedBlockCipher;
        int outputSize;
        byte[] bArr4;
        int iDoFinal;
        byte[] bArr5 = bArr2;
        PKCS7Padding pKCS7Padding = new PKCS7Padding();
        PKCS7Padding pKCS7Padding2 = null;
        if (str.endsWith("-CFB")) {
            str2 = "CFB";
            pKCS7Padding = null;
        } else {
            str2 = "CBC";
        }
        if (str.endsWith("-ECB") || "DES-EDE".equals(str) || "DES-EDE3".equals(str)) {
            str2 = "ECB";
            bArr3 = null;
        } else {
            bArr3 = bArr5;
        }
        if (str.endsWith("-OFB")) {
            str2 = "OFB";
        } else {
            pKCS7Padding2 = pKCS7Padding;
        }
        if (str.startsWith("DES-EDE")) {
            key = getKey(cArr, 24, bArr5, !str.startsWith("DES-EDE3"));
            aESEngine = new DESedeEngine();
        } else if (str.startsWith("DES-")) {
            key = getKey(cArr, 8, bArr5);
            aESEngine = new DESEngine();
        } else if (str.startsWith("BF-")) {
            key = getKey(cArr, 16, bArr5);
            aESEngine = new BlowfishEngine();
        } else {
            int i = 128;
            if (str.startsWith("RC2-")) {
                if (str.startsWith("RC2-40-")) {
                    i = 40;
                } else if (str.startsWith("RC2-64-")) {
                    i = 64;
                }
                RC2Parameters rC2Parameters = new RC2Parameters(getKey(cArr, i / 8, bArr5).getKey(), i);
                aESEngine = new RC2Engine();
                key = rC2Parameters;
            } else {
                if (!str.startsWith("AES-")) {
                    throw new EncryptionException("unknown encryption with private key: " + str);
                }
                if (bArr5.length > 8) {
                    byte[] bArr6 = new byte[8];
                    System.arraycopy(bArr5, 0, bArr6, 0, 8);
                    bArr5 = bArr6;
                }
                if (!str.startsWith("AES-128-")) {
                    if (str.startsWith("AES-192-")) {
                        i = 192;
                    } else {
                        if (!str.startsWith("AES-256-")) {
                            throw new EncryptionException("unknown AES encryption with private key: " + str);
                        }
                        i = 256;
                    }
                }
                key = getKey(cArr, i / 8, bArr5);
                aESEngine = new AESEngine();
            }
        }
        try {
            if (str2.equals("CBC")) {
                oFBBlockCipher = new CBCBlockCipher(aESEngine);
            } else {
                if (!str2.equals("CFB")) {
                    if (str2.equals("OFB")) {
                        oFBBlockCipher = new OFBBlockCipher(aESEngine, aESEngine.getBlockSize() * 8);
                    }
                    if (pKCS7Padding2 == null) {
                        paddedBufferedBlockCipher = new BufferedBlockCipher(aESEngine);
                    } else {
                        paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(aESEngine, pKCS7Padding2);
                    }
                    bufferedBlockCipher = paddedBufferedBlockCipher;
                    if (bArr3 == null) {
                        bufferedBlockCipher.init(z, key);
                    } else {
                        bufferedBlockCipher.init(z, new ParametersWithIV(key, bArr3));
                    }
                    outputSize = bufferedBlockCipher.getOutputSize(bArr.length);
                    bArr4 = new byte[outputSize];
                    int iProcessBytes = bufferedBlockCipher.processBytes(bArr, 0, bArr.length, bArr4, 0);
                    iDoFinal = iProcessBytes + bufferedBlockCipher.doFinal(bArr4, iProcessBytes);
                    if (iDoFinal == outputSize) {
                        return bArr4;
                    }
                    byte[] bArr7 = new byte[iDoFinal];
                    System.arraycopy(bArr4, 0, bArr7, 0, iDoFinal);
                    return bArr7;
                }
                oFBBlockCipher = new CFBBlockCipher(aESEngine, aESEngine.getBlockSize() * 8);
            }
            if (pKCS7Padding2 == null) {
                paddedBufferedBlockCipher = new BufferedBlockCipher(aESEngine);
            } else {
                paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(aESEngine, pKCS7Padding2);
            }
            bufferedBlockCipher = paddedBufferedBlockCipher;
            if (bArr3 == null) {
                bufferedBlockCipher.init(z, key);
            } else {
                bufferedBlockCipher.init(z, new ParametersWithIV(key, bArr3));
            }
            outputSize = bufferedBlockCipher.getOutputSize(bArr.length);
            bArr4 = new byte[outputSize];
            int iProcessBytes2 = bufferedBlockCipher.processBytes(bArr, 0, bArr.length, bArr4, 0);
            iDoFinal = iProcessBytes2 + bufferedBlockCipher.doFinal(bArr4, iProcessBytes2);
            if (iDoFinal == outputSize) {
                return bArr4;
            }
            byte[] bArr8 = new byte[iDoFinal];
            System.arraycopy(bArr4, 0, bArr8, 0, iDoFinal);
            return bArr8;
        } catch (Exception e) {
            throw new EncryptionException("exception using cipher - please check password and data.", e);
        }
        aESEngine = oFBBlockCipher;
    }

    private static KeyParameter getKey(char[] cArr, int i, byte[] bArr) {
        return getKey(cArr, i, bArr, false);
    }

    private static KeyParameter getKey(char[] cArr, int i, byte[] bArr, boolean z) {
        OpenSSLPBEParametersGenerator openSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
        openSSLPBEParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(cArr), bArr, 1);
        KeyParameter keyParameter = (KeyParameter) openSSLPBEParametersGenerator.generateDerivedParameters(i * 8);
        if (!z || keyParameter.getKey().length != 24) {
            return keyParameter;
        }
        byte[] key = keyParameter.getKey();
        System.arraycopy(key, 0, key, 16, 8);
        return new KeyParameter(key);
    }
}
