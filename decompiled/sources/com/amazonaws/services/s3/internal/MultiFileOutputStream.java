package com.amazonaws.services.s3.internal;

import androidx.media3.datasource.cache.CacheDataSink;
import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.OnFileDelete;
import com.amazonaws.services.s3.UploadObjectObserver;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class MultiFileOutputStream extends OutputStream implements OnFileDelete {
    private boolean closed;
    private int currFileBytesWritten;
    private long diskLimit;
    private Semaphore diskPermits;
    private int filesCreated;
    private final String namePrefix;
    private UploadObjectObserver observer;
    private FileOutputStream os;
    private long partSize;
    private final File root;
    private long totalBytesWritten;

    public MultiFileOutputStream() {
        this.partSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        this.diskLimit = Long.MAX_VALUE;
        this.root = new File(System.getProperty("java.io.tmpdir"));
        this.namePrefix = yyMMdd_hhmmss() + InstructionFileId.DOT + UUID.randomUUID();
    }

    public MultiFileOutputStream(File file, String str) {
        this.partSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        this.diskLimit = Long.MAX_VALUE;
        if (file == null || !file.isDirectory() || !file.canWrite()) {
            throw new IllegalArgumentException(file + " must be a writable directory");
        }
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Please specify a non-empty name prefix");
        }
        this.root = file;
        this.namePrefix = str;
    }

    public MultiFileOutputStream init(UploadObjectObserver uploadObjectObserver, long j, long j2) {
        if (uploadObjectObserver == null) {
            throw new IllegalArgumentException("Observer must be specified");
        }
        this.observer = uploadObjectObserver;
        if (j2 < (j << 1)) {
            throw new IllegalArgumentException("Maximum temporary disk space must be at least twice as large as the part size: partSize=" + j + ", diskSize=" + j2);
        }
        this.partSize = j;
        this.diskLimit = j2;
        int i = (int) (j2 / j);
        this.diskPermits = i < 0 ? null : new Semaphore(i);
        return this;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        fos().write(i);
        this.currFileBytesWritten++;
        this.totalBytesWritten++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        fos().write(bArr);
        this.currFileBytesWritten += bArr.length;
        this.totalBytesWritten += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        fos().write(bArr, i, i2);
        this.currFileBytesWritten += i2;
        this.totalBytesWritten += i2;
    }

    private FileOutputStream fos() throws InterruptedException, IOException {
        if (this.closed) {
            throw new IOException("Output stream is already closed");
        }
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream == null || this.currFileBytesWritten >= this.partSize) {
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.observer.onPartCreate(new PartCreationEvent(getFile(this.filesCreated), this.filesCreated, false, this));
            }
            this.currFileBytesWritten = 0;
            this.filesCreated++;
            blockIfNecessary();
            File file = getFile(this.filesCreated);
            file.deleteOnExit();
            this.os = new FileOutputStream(file);
        }
        return this.os;
    }

    @Override // com.amazonaws.services.s3.OnFileDelete
    public void onFileDelete(FileDeletionEvent fileDeletionEvent) {
        Semaphore semaphore = this.diskPermits;
        if (semaphore != null) {
            semaphore.release();
        }
    }

    private void blockIfNecessary() throws InterruptedException {
        Semaphore semaphore = this.diskPermits;
        if (semaphore == null || this.diskLimit == Long.MAX_VALUE) {
            return;
        }
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new AbortedException(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream != null) {
            fileOutputStream.close();
            File file = getFile(this.filesCreated);
            if (file.length() == 0) {
                if (file.delete()) {
                    return;
                }
                LogFactory.getLog(getClass()).debug("Ignoring failure to delete empty file " + file);
                return;
            }
            this.observer.onPartCreate(new PartCreationEvent(getFile(this.filesCreated), this.filesCreated, true, this));
        }
    }

    public void cleanup() {
        for (int i = 0; i < getNumFilesWritten(); i++) {
            File file = getFile(i);
            if (file.exists() && !file.delete()) {
                LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + file);
            }
        }
    }

    public int getNumFilesWritten() {
        return this.filesCreated;
    }

    public File getFile(int i) {
        return new File(this.root, this.namePrefix + InstructionFileId.DOT + i);
    }

    public long getPartSize() {
        return this.partSize;
    }

    public File getRoot() {
        return this.root;
    }

    public String getNamePrefix() {
        return this.namePrefix;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    static String yyMMdd_hhmmss() {
        return new SimpleDateFormat("yyMMdd-hhmmss").format(new Date());
    }

    public boolean isClosed() {
        return this.closed;
    }

    public long getDiskLimit() {
        return this.diskLimit;
    }
}
