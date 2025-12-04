package org.bouncycastle.math.ec;

/* loaded from: classes6.dex */
class ValidityPrecompInfo implements PreCompInfo {
    private boolean failed = false;
    private boolean curveEquationPassed = false;
    private boolean orderPassed = false;

    ValidityPrecompInfo() {
    }

    boolean hasCurveEquationPassed() {
        return this.curveEquationPassed;
    }

    boolean hasFailed() {
        return this.failed;
    }

    boolean hasOrderPassed() {
        return this.orderPassed;
    }

    void reportCurveEquationPassed() {
        this.curveEquationPassed = true;
    }

    void reportFailed() {
        this.failed = true;
    }

    void reportOrderPassed() {
        this.orderPassed = true;
    }
}
