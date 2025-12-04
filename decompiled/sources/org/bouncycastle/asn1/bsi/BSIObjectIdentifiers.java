package org.bouncycastle.asn1.bsi;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes6.dex */
public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier algorithm;
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512;
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures;
    public static final ASN1ObjectIdentifier ecka_eg;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_3DES;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES128;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES192;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512;
    public static final ASN1ObjectIdentifier id_ecc;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch = aSN1ObjectIdentifier.branch("1.1");
        id_ecc = aSN1ObjectIdentifierBranch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch2 = aSN1ObjectIdentifierBranch.branch("4.1");
        ecdsa_plain_signatures = aSN1ObjectIdentifierBranch2;
        ecdsa_plain_SHA1 = aSN1ObjectIdentifierBranch2.branch("1");
        ecdsa_plain_SHA224 = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_2D);
        ecdsa_plain_SHA256 = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_3D);
        ecdsa_plain_SHA384 = aSN1ObjectIdentifierBranch2.branch("4");
        ecdsa_plain_SHA512 = aSN1ObjectIdentifierBranch2.branch("5");
        ecdsa_plain_RIPEMD160 = aSN1ObjectIdentifierBranch2.branch("6");
        algorithm = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch3 = aSN1ObjectIdentifierBranch.branch("5.1");
        ecka_eg = aSN1ObjectIdentifierBranch3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch4 = aSN1ObjectIdentifierBranch3.branch("1");
        ecka_eg_X963kdf = aSN1ObjectIdentifierBranch4;
        ecka_eg_X963kdf_SHA1 = aSN1ObjectIdentifierBranch4.branch("1");
        ecka_eg_X963kdf_SHA224 = aSN1ObjectIdentifierBranch4.branch(ExifInterface.GPS_MEASUREMENT_2D);
        ecka_eg_X963kdf_SHA256 = aSN1ObjectIdentifierBranch4.branch(ExifInterface.GPS_MEASUREMENT_3D);
        ecka_eg_X963kdf_SHA384 = aSN1ObjectIdentifierBranch4.branch("4");
        ecka_eg_X963kdf_SHA512 = aSN1ObjectIdentifierBranch4.branch("5");
        ecka_eg_X963kdf_RIPEMD160 = aSN1ObjectIdentifierBranch4.branch("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch5 = aSN1ObjectIdentifierBranch3.branch(ExifInterface.GPS_MEASUREMENT_2D);
        ecka_eg_SessionKDF = aSN1ObjectIdentifierBranch5;
        ecka_eg_SessionKDF_3DES = aSN1ObjectIdentifierBranch5.branch("1");
        ecka_eg_SessionKDF_AES128 = aSN1ObjectIdentifierBranch5.branch(ExifInterface.GPS_MEASUREMENT_2D);
        ecka_eg_SessionKDF_AES192 = aSN1ObjectIdentifierBranch5.branch(ExifInterface.GPS_MEASUREMENT_3D);
        ecka_eg_SessionKDF_AES256 = aSN1ObjectIdentifierBranch5.branch("4");
    }
}
