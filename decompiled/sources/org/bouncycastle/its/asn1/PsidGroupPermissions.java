package org.bouncycastle.its.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

/* loaded from: classes6.dex */
public class PsidGroupPermissions extends ASN1Object {
    private final BigInteger chainLengthRange;
    private final Object eeType;
    private final BigInteger minChainLength;
    private final SubjectPermissions subjectPermissions;

    private PsidGroupPermissions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException("sequence not length 2");
        }
        this.subjectPermissions = SubjectPermissions.getInstance(aSN1Sequence.getObjectAt(0));
        this.minChainLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
        this.chainLengthRange = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue();
        this.eeType = EndEntityType.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static PsidGroupPermissions getInstance(Object obj) {
        if (obj instanceof PsidGroupPermissions) {
            return (PsidGroupPermissions) obj;
        }
        if (obj != null) {
            return new PsidGroupPermissions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
