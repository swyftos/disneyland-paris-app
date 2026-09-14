package com.fasterxml.jackson.core.sym;

/* JADX INFO: loaded from: classes3.dex */
public final class Name2 extends Name {

    /* JADX INFO: renamed from: q1 */
    private final int f3415q1;

    /* JADX INFO: renamed from: q2 */
    private final int f3416q2;

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.f3415q1 && i2 == this.f3416q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.f3415q1 && iArr[1] == this.f3416q2;
    }
}
