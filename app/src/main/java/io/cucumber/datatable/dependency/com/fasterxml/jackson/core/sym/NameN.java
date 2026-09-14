package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class NameN extends Name {

    /* JADX INFO: renamed from: q */
    private final int[] f3815q;

    /* JADX INFO: renamed from: q1 */
    private final int f3816q1;

    /* JADX INFO: renamed from: q2 */
    private final int f3817q2;

    /* JADX INFO: renamed from: q3 */
    private final int f3818q3;

    /* JADX INFO: renamed from: q4 */
    private final int f3819q4;
    private final int qlen;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    NameN(String str, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        super(str, i);
        this.f3816q1 = i2;
        this.f3817q2 = i3;
        this.f3818q3 = i4;
        this.f3819q4 = i5;
        this.f3815q = iArr;
        this.qlen = i6;
    }

    public static NameN construct(String str, int i, int[] iArr, int i2) {
        if (i2 < 4) {
            throw new IllegalArgumentException();
        }
        return new NameN(str, i, iArr[0], iArr[1], iArr[2], iArr[3], i2 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i2) : null, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0040 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x004a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0054 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0055 A[RETURN] */
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        if (i != this.qlen || iArr[0] != this.f3816q1 || iArr[1] != this.f3817q2 || iArr[2] != this.f3818q3 || iArr[3] != this.f3819q4) {
            return false;
        }
        switch (i) {
            case 4:
                return true;
            case 5:
                if (iArr[4] != this.f3815q[0]) {
                    return false;
                }
                return true;
            case 6:
                if (iArr[5] != this.f3815q[1]) {
                    return false;
                }
                if (iArr[4] != this.f3815q[0]) {
                    return false;
                }
                return true;
            case 7:
                if (iArr[6] != this.f3815q[2]) {
                    return false;
                }
                if (iArr[5] != this.f3815q[1]) {
                    return false;
                }
                if (iArr[4] != this.f3815q[0]) {
                    return false;
                }
                return true;
            case 8:
                if (iArr[7] != this.f3815q[3]) {
                    return false;
                }
                if (iArr[6] != this.f3815q[2]) {
                    return false;
                }
                if (iArr[5] != this.f3815q[1]) {
                    return false;
                }
                if (iArr[4] != this.f3815q[0]) {
                    return false;
                }
                return true;
            default:
                return _equals2(iArr);
        }
    }

    private final boolean _equals2(int[] iArr) {
        int i = this.qlen - 4;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2 + 4] != this.f3815q[i2]) {
                return false;
            }
        }
        return true;
    }
}
