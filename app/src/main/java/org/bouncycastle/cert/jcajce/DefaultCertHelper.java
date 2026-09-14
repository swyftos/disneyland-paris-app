package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateFactory;

/* JADX INFO: loaded from: classes6.dex */
class DefaultCertHelper extends CertHelper {
    DefaultCertHelper() {
    }

    @Override // org.bouncycastle.cert.jcajce.CertHelper
    protected CertificateFactory createCertificateFactory(String str) {
        return CertificateFactory.getInstance(str);
    }
}
