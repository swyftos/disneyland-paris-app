package org.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes6.dex */
public interface EdDSAPrivateKey extends EdDSAKey, PrivateKey {
    EdDSAPublicKey getPublicKey();
}
