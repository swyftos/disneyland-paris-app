package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.S2K;

/* loaded from: classes6.dex */
abstract class PGPUtil implements HashAlgorithmTags {
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1 A[Catch: IOException -> 0x0062, TryCatch #0 {IOException -> 0x0062, blocks: (B:23:0x005c, B:26:0x0065, B:31:0x0074, B:32:0x0081, B:35:0x0089, B:37:0x008f, B:38:0x0094, B:40:0x00a0, B:41:0x00a6, B:48:0x00d5, B:50:0x00e1, B:52:0x00e9, B:51:0x00e5, B:42:0x00ab, B:43:0x00c5, B:44:0x00c6, B:45:0x00c9, B:47:0x00cf), top: B:63:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5 A[Catch: IOException -> 0x0062, TryCatch #0 {IOException -> 0x0062, blocks: (B:23:0x005c, B:26:0x0065, B:31:0x0074, B:32:0x0081, B:35:0x0089, B:37:0x008f, B:38:0x0094, B:40:0x00a0, B:41:0x00a6, B:48:0x00d5, B:50:0x00e1, B:52:0x00e9, B:51:0x00e5, B:42:0x00ab, B:43:0x00c5, B:44:0x00c6, B:45:0x00c9, B:47:0x00cf), top: B:63:0x005c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static byte[] makeKeyFromPassPhrase(org.bouncycastle.openpgp.operator.PGPDigestCalculator r15, int r16, org.bouncycastle.bcpg.S2K r17, char[] r18) throws java.io.IOException, org.bouncycastle.openpgp.PGPException {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.openpgp.operator.PGPUtil.makeKeyFromPassPhrase(org.bouncycastle.openpgp.operator.PGPDigestCalculator, int, org.bouncycastle.bcpg.S2K, char[]):byte[]");
    }

    public static byte[] makeKeyFromPassPhrase(PGPDigestCalculatorProvider pGPDigestCalculatorProvider, int i, S2K s2k, char[] cArr) {
        return makeKeyFromPassPhrase(pGPDigestCalculatorProvider.get(s2k != null ? s2k.getHashAlgorithm() : 1), i, s2k, cArr);
    }
}
