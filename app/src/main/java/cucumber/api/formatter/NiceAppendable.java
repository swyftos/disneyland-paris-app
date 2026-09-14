package cucumber.api.formatter;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class NiceAppendable implements Appendable {

    /* JADX INFO: renamed from: NL */
    private static final CharSequence f3789NL = "\n";
    private final Appendable out;

    public NiceAppendable(Appendable appendable) {
        this.out = appendable;
    }

    @Override // java.lang.Appendable
    public NiceAppendable append(CharSequence charSequence) {
        try {
            this.out.append(charSequence);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Appendable
    public NiceAppendable append(CharSequence charSequence, int i, int i2) {
        try {
            this.out.append(charSequence, i, i2);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Appendable
    public NiceAppendable append(char c) {
        try {
            this.out.append(c);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public NiceAppendable println() {
        return append(f3789NL);
    }

    public NiceAppendable println(CharSequence charSequence) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(f3789NL);
            this.out.append(sb.toString());
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
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

    private void tryFlush() {
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
