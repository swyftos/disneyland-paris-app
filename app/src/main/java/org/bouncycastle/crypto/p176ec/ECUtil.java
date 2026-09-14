package org.bouncycastle.crypto.p176ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.p183ec.ECConstants;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes6.dex */
abstract class ECUtil {
    static BigInteger generateK(BigInteger bigInteger, SecureRandom secureRandom) {
        int iBitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, secureRandom);
            if (!bigIntegerCreateRandomBigInteger.equals(ECConstants.ZERO) && bigIntegerCreateRandomBigInteger.compareTo(bigInteger) < 0) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }
}
