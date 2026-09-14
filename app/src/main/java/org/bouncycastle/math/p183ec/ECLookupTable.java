package org.bouncycastle.math.p183ec;

/* JADX INFO: loaded from: classes6.dex */
public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int i);

    ECPoint lookupVar(int i);
}
