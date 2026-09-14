package org.apache.commons.p168io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class WindowsLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashRSeen = false;
    private boolean slashNSeen = false;
    private boolean injectSlashN = false;
    private boolean eofSeen = false;

    public WindowsLineEndingInputStream(InputStream inputStream, boolean z) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z;
    }

    private int readWithUpdate() throws IOException {
        int i = this.target.read();
        boolean z = i == -1;
        this.eofSeen = z;
        if (z) {
            return i;
        }
        this.slashRSeen = i == 13;
        this.slashNSeen = i == 10;
        return i;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.eofSeen) {
            return eofGame();
        }
        if (this.injectSlashN) {
            this.injectSlashN = false;
            return 10;
        }
        boolean z = this.slashRSeen;
        int withUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame();
        }
        if (withUpdate != 10 || z) {
            return withUpdate;
        }
        this.injectSlashN = true;
        return 13;
    }

    private int eofGame() {
        if (!this.ensureLineFeedAtEndOfFile) {
            return -1;
        }
        boolean z = this.slashNSeen;
        if (!z && !this.slashRSeen) {
            this.slashRSeen = true;
            return 13;
        }
        if (z) {
            return -1;
        }
        this.slashRSeen = false;
        this.slashNSeen = true;
        return 10;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("Mark not supported");
    }
}
