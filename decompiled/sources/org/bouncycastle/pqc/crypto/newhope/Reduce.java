package org.bouncycastle.pqc.crypto.newhope;

import kotlin.UShort;

/* loaded from: classes6.dex */
abstract class Reduce {
    static short barrett(short s) {
        int i = s & UShort.MAX_VALUE;
        return (short) (i - (((i * 5) >>> 16) * 12289));
    }

    static short montgomery(int i) {
        return (short) (((((i * 12287) & 262143) * 12289) + i) >>> 18);
    }
}
