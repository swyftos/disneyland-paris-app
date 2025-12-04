package cucumber.api.formatter;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes5.dex */
public class NiceAppendable implements Appendable {
    private static final CharSequence NL = "\n";
    private final Appendable out;

    public NiceAppendable(Appendable appendable) {
        this.out = appendable;
    }

    @Override // java.lang.Appendable
    public NiceAppendable append(CharSequence charSequence) throws IOException {
        try {
            this.out.append(charSequence);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Appendable
    public NiceAppendable append(CharSequence charSequence, int i, int i2) throws IOException {
        try {
            this.out.append(charSequence, i, i2);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Appendable
    public NiceAppendable append(char c) throws IOException {
        try {
            this.out.append(c);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public NiceAppendable println() {
        return append(NL);
    }

    public NiceAppendable println(CharSequence charSequence) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(NL);
            this.out.append(sb.toString());
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws IOException {
        try {
            tryFlush();
            Appendable appendable = this.out;
            if (appendable instanceof Closeable) {
                ((Closeable) appendable).close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void tryFlush() throws IOException {
        Appendable appendable = this.out;
        if (appendable instanceof Flushable) {
            try {
                ((Flushable) appendable).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
