package org.bouncycastle.gpg.keybox.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

/* loaded from: classes6.dex */
public class JcaKeyBoxBuilder {
    private JcaJceHelper helper = new DefaultJcaJceHelper();

    public JcaKeyBox build(InputStream inputStream) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        return new JcaKeyBox(inputStream, new JcaKeyFingerprintCalculator(), new JcaBlobVerifier(this.helper));
    }

    public JcaKeyBox build(byte[] bArr) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        return new JcaKeyBox(bArr, new JcaKeyFingerprintCalculator(), new JcaBlobVerifier(this.helper));
    }

    public JcaKeyBoxBuilder setProvider(String str) {
        this.helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcaKeyBoxBuilder setProvider(Provider provider) {
        this.helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
