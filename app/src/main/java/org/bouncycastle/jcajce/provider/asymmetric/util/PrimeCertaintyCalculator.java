package org.bouncycastle.jcajce.provider.asymmetric.util;

/* JADX INFO: loaded from: classes6.dex */
public class PrimeCertaintyCalculator {
    public static int getDefaultCertainty(int i) {
        if (i <= 1024) {
            return 80;
        }
        return (((i - 1) / 1024) * 16) + 96;
    }
}
