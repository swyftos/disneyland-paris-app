package org.bouncycastle.asn1;

import java.io.OutputStream;

/* loaded from: classes6.dex */
class DLOutputStream extends ASN1OutputStream {
    DLOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    ASN1OutputStream getDLSubStream() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) {
        aSN1Primitive.toDLObject().encode(this, z);
    }
}
