package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Sequence;

/* loaded from: classes6.dex */
public class EncryptedData {
    private EncryptedData(ASN1Sequence aSN1Sequence) {
    }

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj != null) {
            return new EncryptedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
