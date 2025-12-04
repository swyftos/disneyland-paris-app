package org.bouncycastle.eac.operator.jcajce;

import java.security.Signature;

/* loaded from: classes6.dex */
class NamedEACHelper extends EACHelper {
    private final String providerName;

    NamedEACHelper(String str) {
        this.providerName = str;
    }

    @Override // org.bouncycastle.eac.operator.jcajce.EACHelper
    protected Signature createSignature(String str) {
        return Signature.getInstance(str, this.providerName);
    }
}
