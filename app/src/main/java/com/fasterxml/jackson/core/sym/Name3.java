package com.fasterxml.jackson.core.sym;

/* JADX INFO: loaded from: classes3.dex */
public final class Name3 extends Name {

    /* JADX INFO: renamed from: q1 */
    private final int f3417q1;

    /* JADX INFO: renamed from: q2 */
    private final int f3418q2;

    /* JADX INFO: renamed from: q3 */
    private final int f3419q3;

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return this.f3417q1 == i && this.f3418q2 == i2 && this.f3419q3 == i3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.f3417q1 && iArr[1] == this.f3418q2 && iArr[2] == this.f3419q3;
    }
}
