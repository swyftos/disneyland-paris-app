package org.bouncycastle.asn1.p172x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECPoint;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class X9ECPoint extends ASN1Object {

    /* JADX INFO: renamed from: c */
    private ECCurve f4085c;
    private final ASN1OctetString encoding;

    /* JADX INFO: renamed from: p */
    private ECPoint f4086p;

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.getOctets());
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.f4085c = eCCurve;
        this.encoding = new DEROctetString(Arrays.clone(bArr));
    }

    public X9ECPoint(ECPoint eCPoint, boolean z) {
        this.f4086p = eCPoint.normalize();
        this.encoding = new DEROctetString(eCPoint.getEncoded(z));
    }

    public synchronized ECPoint getPoint() {
        try {
            if (this.f4086p == null) {
                this.f4086p = this.f4085c.decodePoint(this.encoding.getOctets()).normalize();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f4086p;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.encoding.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        byte b = octets[0];
        return b == 2 || b == 3;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
