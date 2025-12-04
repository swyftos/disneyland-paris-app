package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

/* loaded from: classes6.dex */
public class DefaultAlgorithmNameFinder implements AlgorithmNameFinder {
    private static final Map algorithms;

    static {
        HashMap map = new HashMap();
        algorithms = map;
        map.put(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
        map.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410-2001");
        map.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410-94");
        map.put(CryptoProObjectIdentifiers.gostR3411, "GOST3411");
        map.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411WITHECGOST3410-2012-256");
        map.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411WITHECGOST3410-2012-512");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
        map.put(NISTObjectIdentifiers.id_sha224, "SHA224");
        map.put(NISTObjectIdentifiers.id_sha256, "SHA256");
        map.put(NISTObjectIdentifiers.id_sha384, "SHA384");
        map.put(NISTObjectIdentifiers.id_sha512, "SHA512");
        map.put(NISTObjectIdentifiers.id_sha3_224, MessageDigestAlgorithms.SHA3_224);
        map.put(NISTObjectIdentifiers.id_sha3_256, "SHA3-256");
        map.put(NISTObjectIdentifiers.id_sha3_384, MessageDigestAlgorithms.SHA3_384);
        map.put(NISTObjectIdentifiers.id_sha3_512, MessageDigestAlgorithms.SHA3_512);
        map.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        map.put(OIWObjectIdentifiers.elGamalAlgorithm, "ELGAMAL");
        map.put(OIWObjectIdentifiers.idSHA1, "SHA1");
        map.put(OIWObjectIdentifiers.md5WithRSA, "MD5WITHRSA");
        map.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        map.put(PKCSObjectIdentifiers.id_RSAES_OAEP, "RSAOAEP");
        map.put(PKCSObjectIdentifiers.id_RSASSA_PSS, "RSAPSS");
        map.put(PKCSObjectIdentifiers.md2WithRSAEncryption, "MD2WITHRSA");
        map.put(PKCSObjectIdentifiers.md5, MessageDigestAlgorithms.MD5);
        map.put(PKCSObjectIdentifiers.md5WithRSAEncryption, "MD5WITHRSA");
        map.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        map.put(PKCSObjectIdentifiers.sha1WithRSAEncryption, "SHA1WITHRSA");
        map.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        map.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        map.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        map.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        map.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_224, "SHA3-224WITHRSA");
        map.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_256, "SHA3-256WITHRSA");
        map.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_384, "SHA3-384WITHRSA");
        map.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512, "SHA3-512WITHRSA");
        map.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
        map.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
        map.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
        map.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128, "RIPEMD128WITHRSA");
        map.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160, "RIPEMD160WITHRSA");
        map.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256, "RIPEMD256WITHRSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "ECDSAWITHSHA1");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        map.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_224, "SHA3-224WITHECDSA");
        map.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_256, "SHA3-256WITHECDSA");
        map.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_384, "SHA3-384WITHECDSA");
        map.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_512, "SHA3-512WITHECDSA");
        map.put(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1WITHDSA");
        map.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        map.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        map.put(NISTObjectIdentifiers.dsa_with_sha384, "SHA384WITHDSA");
        map.put(NISTObjectIdentifiers.dsa_with_sha512, "SHA512WITHDSA");
        map.put(NISTObjectIdentifiers.id_dsa_with_sha3_224, "SHA3-224WITHDSA");
        map.put(NISTObjectIdentifiers.id_dsa_with_sha3_256, "SHA3-256WITHDSA");
        map.put(NISTObjectIdentifiers.id_dsa_with_sha3_384, "SHA3-384WITHDSA");
        map.put(NISTObjectIdentifiers.id_dsa_with_sha3_512, "SHA3-512WITHDSA");
        map.put(GNUObjectIdentifiers.Tiger_192, "Tiger");
        map.put(PKCSObjectIdentifiers.RC2_CBC, "RC2/CBC");
        map.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESEDE-3KEY/CBC");
        map.put(NISTObjectIdentifiers.id_aes128_ECB, "AES-128/ECB");
        map.put(NISTObjectIdentifiers.id_aes192_ECB, "AES-192/ECB");
        map.put(NISTObjectIdentifiers.id_aes256_ECB, "AES-256/ECB");
        map.put(NISTObjectIdentifiers.id_aes128_CBC, "AES-128/CBC");
        map.put(NISTObjectIdentifiers.id_aes192_CBC, "AES-192/CBC");
        map.put(NISTObjectIdentifiers.id_aes256_CBC, "AES-256/CBC");
        map.put(NISTObjectIdentifiers.id_aes128_CFB, "AES-128/CFB");
        map.put(NISTObjectIdentifiers.id_aes192_CFB, "AES-192/CFB");
        map.put(NISTObjectIdentifiers.id_aes256_CFB, "AES-256/CFB");
        map.put(NISTObjectIdentifiers.id_aes128_OFB, "AES-128/OFB");
        map.put(NISTObjectIdentifiers.id_aes192_OFB, "AES-192/OFB");
        map.put(NISTObjectIdentifiers.id_aes256_OFB, "AES-256/OFB");
        map.put(NTTObjectIdentifiers.id_camellia128_cbc, "CAMELLIA-128/CBC");
        map.put(NTTObjectIdentifiers.id_camellia192_cbc, "CAMELLIA-192/CBC");
        map.put(NTTObjectIdentifiers.id_camellia256_cbc, "CAMELLIA-256/CBC");
        map.put(KISAObjectIdentifiers.id_seedCBC, "SEED/CBC");
        map.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC, "IDEA/CBC");
        map.put(MiscObjectIdentifiers.cast5CBC, "CAST5/CBC");
        map.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB, "Blowfish/ECB");
        map.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC, "Blowfish/CBC");
        map.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB, "Blowfish/CFB");
        map.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB, "Blowfish/OFB");
        map.put(GNUObjectIdentifiers.Serpent_128_ECB, "Serpent-128/ECB");
        map.put(GNUObjectIdentifiers.Serpent_128_CBC, "Serpent-128/CBC");
        map.put(GNUObjectIdentifiers.Serpent_128_CFB, "Serpent-128/CFB");
        map.put(GNUObjectIdentifiers.Serpent_128_OFB, "Serpent-128/OFB");
        map.put(GNUObjectIdentifiers.Serpent_192_ECB, "Serpent-192/ECB");
        map.put(GNUObjectIdentifiers.Serpent_192_CBC, "Serpent-192/CBC");
        map.put(GNUObjectIdentifiers.Serpent_192_CFB, "Serpent-192/CFB");
        map.put(GNUObjectIdentifiers.Serpent_192_OFB, "Serpent-192/OFB");
        map.put(GNUObjectIdentifiers.Serpent_256_ECB, "Serpent-256/ECB");
        map.put(GNUObjectIdentifiers.Serpent_256_CBC, "Serpent-256/CBC");
        map.put(GNUObjectIdentifiers.Serpent_256_CFB, "Serpent-256/CFB");
        map.put(GNUObjectIdentifiers.Serpent_256_OFB, "Serpent-256/OFB");
    }

    @Override // org.bouncycastle.operator.AlgorithmNameFinder
    public String getAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) algorithms.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.getId();
    }

    @Override // org.bouncycastle.operator.AlgorithmNameFinder
    public String getAlgorithmName(AlgorithmIdentifier algorithmIdentifier) {
        return getAlgorithmName(algorithmIdentifier.getAlgorithm());
    }

    @Override // org.bouncycastle.operator.AlgorithmNameFinder
    public boolean hasAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return algorithms.containsKey(aSN1ObjectIdentifier);
    }
}
