package org.apache.commons.p168io.input;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class ClosedInputStream extends InputStream {
    public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
