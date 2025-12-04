package org.bouncycastle.its.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;

/* loaded from: classes6.dex */
public class SspRange extends ASN1Object {
    private final BitmapSspRange bitmapSspRange;
    private final boolean isAll;
    private final SequenceOfOctetString opaque;

    private SspRange() {
        this.isAll = true;
        this.opaque = null;
        this.bitmapSspRange = null;
    }

    public SspRange(BitmapSspRange bitmapSspRange) {
        this.isAll = false;
        this.bitmapSspRange = bitmapSspRange;
        this.opaque = null;
    }

    private SspRange(SequenceOfOctetString sequenceOfOctetString) {
        this.isAll = false;
        BitmapSspRange bitmapSspRange = null;
        if (sequenceOfOctetString.size() != 2) {
            this.opaque = sequenceOfOctetString;
        } else {
            this.opaque = SequenceOfOctetString.getInstance(sequenceOfOctetString);
            try {
                bitmapSspRange = BitmapSspRange.getInstance(sequenceOfOctetString);
            } catch (IllegalArgumentException unused) {
            }
        }
        this.bitmapSspRange = bitmapSspRange;
    }

    public static SspRange getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof SspRange) {
            return (SspRange) obj;
        }
        if (obj instanceof ASN1Null) {
            return new SspRange();
        }
        if (obj instanceof ASN1Sequence) {
            return new SspRange(SequenceOfOctetString.getInstance(obj));
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public BitmapSspRange getBitmapSspRange() {
        return this.bitmapSspRange;
    }

    public SequenceOfOctetString getOpaque() {
        return this.opaque;
    }

    public boolean isAll() {
        return this.isAll;
    }

    public boolean maybeOpaque() {
        return this.opaque != null;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.isAll) {
            return DERNull.INSTANCE;
        }
        BitmapSspRange bitmapSspRange = this.bitmapSspRange;
        return bitmapSspRange != null ? bitmapSspRange.toASN1Primitive() : this.opaque.toASN1Primitive();
    }
}
