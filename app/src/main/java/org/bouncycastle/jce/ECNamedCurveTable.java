package org.bouncycastle.jce;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.p172x9.X9ECParameters;
import org.bouncycastle.crypto.p176ec.CustomNamedCurves;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class ECNamedCurveTable {
    public static Enumeration getNames() {
        return org.bouncycastle.asn1.p172x9.ECNamedCurveTable.getNames();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        r0 = org.bouncycastle.asn1.p172x9.ECNamedCurveTable.getByName(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        if (byName == null) {
            try {
                byName = CustomNamedCurves.getByOID(new ASN1ObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
            }
            if (byName == null && byName == null) {
                try {
                    byName = org.bouncycastle.asn1.p172x9.ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(str));
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        if (byName == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), byName.getSeed());
    }
}
