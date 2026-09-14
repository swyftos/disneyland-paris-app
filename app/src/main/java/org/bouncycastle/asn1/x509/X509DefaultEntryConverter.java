package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes6.dex */
public class X509DefaultEntryConverter extends X509NameEntryConverter {
    @Override // org.bouncycastle.asn1.x509.X509NameEntryConverter
    public ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() != 0 && str.charAt(0) == '#') {
            try {
                return convertHexEncoded(str, 1);
            } catch (IOException unused) {
                throw new RuntimeException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
            }
        }
        if (str.length() != 0 && str.charAt(0) == '\\') {
            str = str.substring(1);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.EmailAddress) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.f4065DC)) {
            return new DERIA5String(str);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.DATE_OF_BIRTH)) {
            return new DERGeneralizedTime(str);
        }
        return (aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.f4063C) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.f4070SN) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.DN_QUALIFIER) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.TELEPHONE_NUMBER)) ? new DERPrintableString(str) : new DERUTF8String(str);
    }
}
