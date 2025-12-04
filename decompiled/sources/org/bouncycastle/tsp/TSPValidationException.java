package org.bouncycastle.tsp;

/* loaded from: classes6.dex */
public class TSPValidationException extends TSPException {
    private int failureCode;

    public TSPValidationException(String str) {
        super(str);
        this.failureCode = -1;
    }

    public TSPValidationException(String str, int i) {
        super(str);
        this.failureCode = i;
    }

    public int getFailureCode() {
        return this.failureCode;
    }
}
