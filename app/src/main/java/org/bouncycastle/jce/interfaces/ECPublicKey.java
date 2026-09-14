package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;
import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
