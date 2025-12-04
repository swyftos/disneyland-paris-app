package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Map defaultOids;
    private static final Hashtable des;
    private static final Map keySizes;
    private static final Map nameTable;
    private static final Hashtable oids;
    protected final String kaAlgorithm;
    protected final DerivationFunction kdf;
    protected byte[] ukmParameters;

    static {
        HashMap map = new HashMap();
        defaultOids = map;
        HashMap map2 = new HashMap();
        keySizes = map2;
        HashMap map3 = new HashMap();
        nameTable = map3;
        Hashtable hashtable = new Hashtable();
        oids = hashtable;
        Hashtable hashtable2 = new Hashtable();
        des = hashtable2;
        Integer numValueOf = Integers.valueOf(64);
        Integer numValueOf2 = Integers.valueOf(128);
        Integer numValueOf3 = Integers.valueOf(192);
        Integer numValueOf4 = Integers.valueOf(256);
        map2.put("DES", numValueOf);
        map2.put("DESEDE", numValueOf3);
        map2.put("BLOWFISH", numValueOf2);
        map2.put(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, numValueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), numValueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), numValueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), numValueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes256_CBC;
        map2.put(aSN1ObjectIdentifier.getId(), numValueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), numValueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), numValueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), numValueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), numValueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_wrap;
        map2.put(aSN1ObjectIdentifier2.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), numValueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), numValueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes128_CCM;
        map2.put(aSN1ObjectIdentifier3.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), numValueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), numValueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), numValueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), numValueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), numValueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.id_camellia128_wrap;
        map2.put(aSN1ObjectIdentifier4.getId(), numValueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.id_camellia192_wrap;
        map2.put(aSN1ObjectIdentifier5.getId(), numValueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.id_camellia256_wrap;
        map2.put(aSN1ObjectIdentifier6.getId(), numValueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
        map2.put(aSN1ObjectIdentifier7.getId(), numValueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
        map2.put(aSN1ObjectIdentifier8.getId(), numValueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.des_EDE3_CBC;
        map2.put(aSN1ObjectIdentifier9.getId(), numValueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = OIWObjectIdentifiers.desCBC;
        map2.put(aSN1ObjectIdentifier10.getId(), numValueOf);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = CryptoProObjectIdentifiers.gostR28147_gcfb;
        map2.put(aSN1ObjectIdentifier11.getId(), numValueOf4);
        map2.put(CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.getId(), numValueOf4);
        map2.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.getId(), numValueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        map2.put(aSN1ObjectIdentifier12.getId(), Integers.valueOf(160));
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        map2.put(aSN1ObjectIdentifier13.getId(), numValueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = PKCSObjectIdentifiers.id_hmacWithSHA384;
        map2.put(aSN1ObjectIdentifier14.getId(), Integers.valueOf(384));
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        map2.put(aSN1ObjectIdentifier15.getId(), Integers.valueOf(512));
        map.put("DESEDE", aSN1ObjectIdentifier9);
        map.put(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NTTObjectIdentifiers.id_camellia256_cbc;
        map.put("CAMELLIA", aSN1ObjectIdentifier16);
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = KISAObjectIdentifiers.id_seedCBC;
        map.put("SEED", aSN1ObjectIdentifier17);
        map.put("DES", aSN1ObjectIdentifier10);
        map3.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
        map3.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
        map3.put(OIWObjectIdentifiers.desECB.getId(), "DES");
        map3.put(aSN1ObjectIdentifier10.getId(), "DES");
        map3.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
        map3.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
        map3.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
        map3.put(aSN1ObjectIdentifier9.getId(), "DESede");
        map3.put(aSN1ObjectIdentifier8.getId(), "DESede");
        map3.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
        map3.put(aSN1ObjectIdentifier12.getId(), Constants.HMAC_SHA1_ALGORITHM);
        map3.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
        map3.put(aSN1ObjectIdentifier13.getId(), "HmacSHA256");
        map3.put(aSN1ObjectIdentifier14.getId(), "HmacSHA384");
        map3.put(aSN1ObjectIdentifier15.getId(), "HmacSHA512");
        map3.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
        map3.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier16.getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier4.getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier5.getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier6.getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier7.getId(), "SEED");
        map3.put(aSN1ObjectIdentifier17.getId(), "SEED");
        map3.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
        map3.put(aSN1ObjectIdentifier11.getId(), "GOST28147");
        map3.put(aSN1ObjectIdentifier2.getId(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        map3.put(aSN1ObjectIdentifier3.getId(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        map3.put(aSN1ObjectIdentifier3.getId(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        hashtable.put("DESEDE", aSN1ObjectIdentifier9);
        hashtable.put(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, aSN1ObjectIdentifier);
        hashtable.put("DES", aSN1ObjectIdentifier10);
        hashtable2.put("DES", "DES");
        hashtable2.put("DESEDE", "DES");
        hashtable2.put(aSN1ObjectIdentifier10.getId(), "DES");
        hashtable2.put(aSN1ObjectIdentifier9.getId(), "DES");
        hashtable2.put(aSN1ObjectIdentifier8.getId(), "DES");
    }

    public BaseAgreementSpi(String str, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.kdf = derivationFunction;
    }

    protected static String getAlgorithm(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(NISTObjectIdentifiers.aes.getId())) {
            return JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
        }
        if (str.startsWith(GNUObjectIdentifiers.Serpent.getId())) {
            return "Serpent";
        }
        String str2 = (String) nameTable.get(Strings.toUpperCase(str));
        return str2 != null ? str2 : str;
    }

    protected static int getKeySize(String str) {
        if (str.indexOf(91) > 0) {
            return Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93)));
        }
        String upperCase = Strings.toUpperCase(str);
        Map map = keySizes;
        if (map.containsKey(upperCase)) {
            return ((Integer) map.get(upperCase)).intValue();
        }
        return -1;
    }

    private byte[] getSharedSecretBytes(byte[] bArr, String str, int i) throws DataLengthException, NoSuchAlgorithmException, IllegalArgumentException {
        DerivationParameters kDFParameters;
        DerivationFunction derivationFunction = this.kdf;
        if (derivationFunction == null) {
            if (i <= 0) {
                return bArr;
            }
            int i2 = i / 8;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            Arrays.clear(bArr);
            return bArr2;
        }
        if (i < 0) {
            throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
        }
        int i3 = i / 8;
        byte[] bArr3 = new byte[i3];
        if (!(derivationFunction instanceof DHKEKGenerator)) {
            kDFParameters = new KDFParameters(bArr, this.ukmParameters);
        } else {
            if (str == null) {
                throw new NoSuchAlgorithmException("algorithm OID is null");
            }
            try {
                kDFParameters = new DHKDFParameters(new ASN1ObjectIdentifier(str), i, bArr, this.ukmParameters);
            } catch (IllegalArgumentException unused) {
                throw new NoSuchAlgorithmException("no OID for algorithm: " + str);
            }
        }
        this.kdf.init(kDFParameters);
        this.kdf.generateBytes(bArr3, 0, i3);
        Arrays.clear(bArr);
        return bArr3;
    }

    protected static byte[] trimZeroes(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i = 0;
        while (i < bArr.length && bArr[i] == 0) {
            i++;
        }
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    protected abstract byte[] calcSecret();

    @Override // javax.crypto.KeyAgreementSpi
    protected int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] bArrEngineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= bArrEngineGenerateSecret.length) {
            System.arraycopy(bArrEngineGenerateSecret, 0, bArr, i, bArrEngineGenerateSecret.length);
            return bArrEngineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + bArrEngineGenerateSecret.length + " bytes");
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected SecretKey engineGenerateSecret(String str) throws DataLengthException, NoSuchAlgorithmException, IllegalArgumentException {
        String upperCase = Strings.toUpperCase(str);
        Hashtable hashtable = oids;
        String id = hashtable.containsKey(upperCase) ? ((ASN1ObjectIdentifier) hashtable.get(upperCase)).getId() : str;
        byte[] sharedSecretBytes = getSharedSecretBytes(calcSecret(), id, getKeySize(id));
        String algorithm = getAlgorithm(str);
        if (des.containsKey(algorithm)) {
            DESParameters.setOddParity(sharedSecretBytes);
        }
        return new SecretKeySpec(sharedSecretBytes, algorithm);
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) {
            return calcSecret();
        }
        byte[] bArrCalcSecret = calcSecret();
        try {
            return getSharedSecretBytes(bArrCalcSecret, null, bArrCalcSecret.length * 8);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
