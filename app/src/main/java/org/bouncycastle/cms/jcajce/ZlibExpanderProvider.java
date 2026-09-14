package org.bouncycastle.cms.jcajce;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.InputExpander;
import org.bouncycastle.operator.InputExpanderProvider;
import org.bouncycastle.util.p190io.StreamOverflowException;

/* JADX INFO: loaded from: classes6.dex */
public class ZlibExpanderProvider implements InputExpanderProvider {
    private final long limit;

    private static class LimitedInputStream extends FilterInputStream {
        private long remaining;

        public LimitedInputStream(InputStream inputStream, long j) {
            super(inputStream);
            this.remaining = j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            if (r4 >= 0) goto L8;
         */
        @Override // java.io.FilterInputStream, java.io.InputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int read() throws IOException {
            if (this.remaining >= 0) {
                int i = ((FilterInputStream) this).in.read();
                if (i >= 0) {
                    long j = this.remaining - 1;
                    this.remaining = j;
                }
                return i;
            }
            throw new StreamOverflowException("expanded byte limit exceeded");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (i2 < 1) {
                return super.read(bArr, i, i2);
            }
            long j = this.remaining;
            if (j < 1) {
                read();
                return -1;
            }
            if (j <= i2) {
                i2 = (int) j;
            }
            int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (i3 > 0) {
                this.remaining -= (long) i3;
            }
            return i3;
        }
    }

    public ZlibExpanderProvider() {
        this.limit = -1L;
    }

    public ZlibExpanderProvider(long j) {
        this.limit = j;
    }

    @Override // org.bouncycastle.operator.InputExpanderProvider
    public InputExpander get(final AlgorithmIdentifier algorithmIdentifier) {
        return new InputExpander() { // from class: org.bouncycastle.cms.jcajce.ZlibExpanderProvider.1
            @Override // org.bouncycastle.operator.InputExpander
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier;
            }

            @Override // org.bouncycastle.operator.InputExpander
            public InputStream getInputStream(InputStream inputStream) {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
                return ZlibExpanderProvider.this.limit >= 0 ? new LimitedInputStream(inflaterInputStream, ZlibExpanderProvider.this.limit) : inflaterInputStream;
            }
        };
    }
}
