package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;

/* JADX INFO: loaded from: classes6.dex */
public interface MQVPublicKey extends PublicKey {
    PublicKey getEphemeralKey();

    PublicKey getStaticKey();
}
