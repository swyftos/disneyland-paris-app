package com.contentsquare.android.error.analysis.network;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.communication.error.analysis.NetworkEventBuilder;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/InstrHttpInputStream;", "Ljava/io/InputStream;", "inputStream", "builder", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "errorAnalysis", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "(Ljava/io/InputStream;Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;Lcom/contentsquare/android/error/analysis/ErrorAnalysis;)V", "timeToResponseInitiated", "", "timeToResponseLastRead", "available", "", ReactMessageView.EVENT_CLOSE, "", "mark", "readlimit", "markSupported", "", "read", "buffer", "", "byteOffset", "byteCount", "reset", "skip", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInstrHttpInputStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstrHttpInputStream.kt\ncom/contentsquare/android/error/analysis/network/InstrHttpInputStream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
/* loaded from: classes2.dex */
public final class InstrHttpInputStream extends InputStream {

    @NotNull
    private final NetworkEventBuilder builder;

    @NotNull
    private final ErrorAnalysis errorAnalysis;

    @NotNull
    private final InputStream inputStream;
    private long timeToResponseInitiated;
    private long timeToResponseLastRead;

    public InstrHttpInputStream(InputStream inputStream, NetworkEventBuilder builder, ErrorAnalysis errorAnalysis) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        this.inputStream = inputStream;
        this.builder = builder;
        this.errorAnalysis = errorAnalysis;
        this.timeToResponseInitiated = builder.getTimeToResponseInitiatedMillis();
        this.timeToResponseLastRead = -1L;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.inputStream.available();
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.timeToResponseLastRead == -1) {
            this.timeToResponseLastRead = jCurrentTimeMillis;
        }
        try {
            this.inputStream.close();
            long j = this.timeToResponseInitiated;
            if (j != -1) {
                this.builder.setTimeToResponseInitiatedMillis(j);
            }
            this.builder.setTimeToResponseCompletedMillis(this.timeToResponseLastRead);
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        this.inputStream.mark(readlimit);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int i = this.inputStream.read();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = jCurrentTimeMillis;
            }
            if (i == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = jCurrentTimeMillis;
                this.builder.setTimeToResponseCompletedMillis(jCurrentTimeMillis);
            }
            return i;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        try {
            this.inputStream.reset();
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public long skip(long byteCount) throws IOException {
        try {
            long jSkip = this.inputStream.skip(byteCount);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = jCurrentTimeMillis;
            }
            if (this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = jCurrentTimeMillis;
                this.builder.setTimeToResponseCompletedMillis(jCurrentTimeMillis);
            }
            return jSkip;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        try {
            int i = this.inputStream.read(buffer);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = jCurrentTimeMillis;
            }
            if (i == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = jCurrentTimeMillis;
                this.builder.setTimeToResponseCompletedMillis(jCurrentTimeMillis);
            }
            return i;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        try {
            int i = this.inputStream.read(buffer, byteOffset, byteCount);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = jCurrentTimeMillis;
            }
            if (i == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = jCurrentTimeMillis;
                this.builder.setTimeToResponseCompletedMillis(jCurrentTimeMillis);
            }
            return i;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }
}
