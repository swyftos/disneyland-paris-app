package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym;

/* loaded from: classes5.dex */
public final class Name2 extends Name {
    private final int q1;
    private final int q2;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.q1 && i2 == this.q2;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.q1 && iArr[1] == this.q2;
    }
}
