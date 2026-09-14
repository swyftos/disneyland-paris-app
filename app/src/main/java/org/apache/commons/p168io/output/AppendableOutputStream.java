package org.apache.commons.p168io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Appendable;

/* JADX INFO: loaded from: classes6.dex */
public class AppendableOutputStream<T extends Appendable> extends OutputStream {
    private final Appendable appendable;

    public AppendableOutputStream(T t) {
        this.appendable = t;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.appendable.append((char) i);
    }

    public T getAppendable() {
        return (T) this.appendable;
    }
}
