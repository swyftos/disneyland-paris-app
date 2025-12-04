package org.bouncycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.PGPDigestCalculatorProvider;

/* loaded from: classes6.dex */
public class JcaPGPDigestCalculatorProviderBuilder {
    private OperatorHelper helper;

    private class DigestOutputStream extends OutputStream {
        private MessageDigest dig;

        DigestOutputStream(MessageDigest messageDigest) {
            this.dig = messageDigest;
        }

        byte[] getDigest() {
            return this.dig.digest();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.dig.update((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.dig.update(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.dig.update(bArr, i, i2);
        }
    }

    public JcaPGPDigestCalculatorProviderBuilder() {
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    JcaPGPDigestCalculatorProviderBuilder(OperatorHelper operatorHelper) {
        new OperatorHelper(new DefaultJcaJceHelper());
        this.helper = operatorHelper;
    }

    public PGPDigestCalculatorProvider build() throws PGPException {
        return new PGPDigestCalculatorProvider() { // from class: org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder.1
            @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculatorProvider
            public PGPDigestCalculator get(final int i) throws PGPException {
                try {
                    final MessageDigest messageDigestCreateDigest = JcaPGPDigestCalculatorProviderBuilder.this.helper.createDigest(i);
                    final DigestOutputStream digestOutputStream = JcaPGPDigestCalculatorProviderBuilder.this.new DigestOutputStream(messageDigestCreateDigest);
                    return new PGPDigestCalculator() { // from class: org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder.1.1
                        @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
                        public int getAlgorithm() {
                            return i;
                        }

                        @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
                        public byte[] getDigest() {
                            return digestOutputStream.getDigest();
                        }

                        @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
                        public OutputStream getOutputStream() {
                            return digestOutputStream;
                        }

                        @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
                        public void reset() {
                            messageDigestCreateDigest.reset();
                        }
                    };
                } catch (GeneralSecurityException e) {
                    throw new PGPException("exception on setup: " + e, e);
                }
            }
        };
    }

    public JcaPGPDigestCalculatorProviderBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcaPGPDigestCalculatorProviderBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
