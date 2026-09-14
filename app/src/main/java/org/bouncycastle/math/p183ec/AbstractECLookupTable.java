package org.bouncycastle.math.p183ec;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractECLookupTable implements ECLookupTable {
    @Override // org.bouncycastle.math.p183ec.ECLookupTable
    public ECPoint lookupVar(int i) {
        return lookup(i);
    }
}
