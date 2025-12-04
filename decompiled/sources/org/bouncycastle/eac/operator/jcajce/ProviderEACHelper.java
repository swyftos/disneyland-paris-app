package org.bouncycastle.eac.operator.jcajce;

import java.security.Provider;
import java.security.Signature;

/* loaded from: classes6.dex */
class ProviderEACHelper extends EACHelper {
    private final Provider provider;

    ProviderEACHelper(Provider provider) {
        this.provider = provider;
    }

    @Override // org.bouncycastle.eac.operator.jcajce.EACHelper
    protected Signature createSignature(String str) {
        return Signature.getInstance(str, this.provider);
    }
}
