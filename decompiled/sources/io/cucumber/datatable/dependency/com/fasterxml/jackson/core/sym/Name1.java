package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym;

/* loaded from: classes5.dex */
public final class Name1 extends Name {
    private static final Name1 EMPTY = new Name1("", 0, 0);
    private final int q;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    Name1(String str, int i, int i2) {
        super(str, i);
        this.q = i2;
    }

    public static Name1 getEmptyName() {
        return EMPTY;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return i == this.q;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.q && i2 == 0;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.q;
    }
}
