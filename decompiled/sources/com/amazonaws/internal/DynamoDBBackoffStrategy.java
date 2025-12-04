package com.amazonaws.internal;

/* loaded from: classes2.dex */
public class DynamoDBBackoffStrategy extends CustomBackoffStrategy {
    public static final CustomBackoffStrategy DEFAULT = new DynamoDBBackoffStrategy();

    @Override // com.amazonaws.internal.CustomBackoffStrategy
    public int getBackoffPeriod(int i) {
        if (i <= 0) {
            return 0;
        }
        int iPow = ((int) Math.pow(2.0d, i - 1)) * 50;
        if (iPow < 0) {
            return Integer.MAX_VALUE;
        }
        return iPow;
    }
}
