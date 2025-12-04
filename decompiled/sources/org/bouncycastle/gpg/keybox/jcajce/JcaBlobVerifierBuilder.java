package org.bouncycastle.gpg.keybox.jcajce;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;

/* loaded from: classes6.dex */
public class JcaBlobVerifierBuilder {
    private JcaJceHelper helper = new DefaultJcaJceHelper();

    public JcaBlobVerifier build() throws NoSuchAlgorithmException, NoSuchProviderException {
        return new JcaBlobVerifier(this.helper);
    }

    public JcaBlobVerifierBuilder setProvider(String str) {
        this.helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcaBlobVerifierBuilder setProvider(Provider provider) {
        this.helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
