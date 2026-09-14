package org.bouncycastle.crypto.agreement.jpake;

import com.facebook.common.callercontext.ContextChain;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class JPAKEPrimeOrderGroup {

    /* JADX INFO: renamed from: g */
    private final BigInteger f4136g;

    /* JADX INFO: renamed from: p */
    private final BigInteger f4137p;

    /* JADX INFO: renamed from: q */
    private final BigInteger f4138q;

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z) {
        JPAKEUtil.validateNotNull(bigInteger, ContextChain.TAG_PRODUCT);
        JPAKEUtil.validateNotNull(bigInteger2, "q");
        JPAKEUtil.validateNotNull(bigInteger3, "g");
        if (!z) {
            BigInteger bigInteger4 = JPAKEUtil.ONE;
            if (!bigInteger.subtract(bigInteger4).mod(bigInteger2).equals(JPAKEUtil.ZERO)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            }
            if (bigInteger3.compareTo(BigInteger.valueOf(2L)) == -1 || bigInteger3.compareTo(bigInteger.subtract(bigInteger4)) == 1) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            }
            if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(bigInteger4)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            }
            if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            }
            if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.f4137p = bigInteger;
        this.f4138q = bigInteger2;
        this.f4136g = bigInteger3;
    }

    public BigInteger getG() {
        return this.f4136g;
    }

    public BigInteger getP() {
        return this.f4137p;
    }

    public BigInteger getQ() {
        return this.f4138q;
    }
}
