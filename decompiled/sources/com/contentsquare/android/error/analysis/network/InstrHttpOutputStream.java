package com.contentsquare.android.error.analysis.network;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.communication.error.analysis.NetworkEventBuilder;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/InstrHttpOutputStream;", "Ljava/io/OutputStream;", "outputStream", "builder", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "errorAnalysis", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "(Ljava/io/OutputStream;Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;Lcom/contentsquare/android/error/analysis/ErrorAnalysis;)V", "bytesWritten", "", ReactMessageView.EVENT_CLOSE, "", "flush", "write", "bytes", "", "off", "", "len", "byt", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInstrHttpOutputStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstrHttpOutputStream.kt\ncom/contentsquare/android/error/analysis/network/InstrHttpOutputStream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
/* loaded from: classes2.dex */
public final class InstrHttpOutputStream extends OutputStream {

    @NotNull
    private NetworkEventBuilder builder;
    private long bytesWritten;

    @NotNull
    private final ErrorAnalysis errorAnalysis;

    @NotNull
    private final OutputStream outputStream;

    public InstrHttpOutputStream(OutputStream outputStream, NetworkEventBuilder builder, ErrorAnalysis errorAnalysis) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        this.outputStream = outputStream;
        this.builder = builder;
        this.errorAnalysis = errorAnalysis;
        this.bytesWritten = -1L;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.builder.setTimeToRequestCompletedMillis(System.currentTimeMillis());
        try {
            this.outputStream.close();
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.outputStream.flush();
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int byt) throws IOException {
        try {
            this.outputStream.write(byt);
            this.bytesWritten++;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
            }
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j = this.bytesWritten;
        try {
            this.outputStream.write(bytes);
            this.bytesWritten = j + bytes.length;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
                Unit unit = Unit.INSTANCE;
            }
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int off, int len) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j = this.bytesWritten;
        try {
            this.outputStream.write(bytes, off, len);
            this.bytesWritten = j + len;
        } catch (IOException e) {
            this.builder.setTimeToResponseCompletedMillis(System.currentTimeMillis());
            NetworkEvent networkEventBuild = this.builder.build();
            if (networkEventBuild != null) {
                this.errorAnalysis.sendEvent(networkEventBuild);
                Unit unit = Unit.INSTANCE;
            }
            throw e;
        }
    }
}
