package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* loaded from: classes6.dex */
public interface ECPrivateKey extends ECKey, PrivateKey {
    BigInteger getD();
}
