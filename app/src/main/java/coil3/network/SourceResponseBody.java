package coil3.network;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: loaded from: classes2.dex */
final class SourceResponseBody implements NetworkResponseBody {
    private final BufferedSource source;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SourceResponseBody m2770boximpl(BufferedSource bufferedSource) {
        return new SourceResponseBody(bufferedSource);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static BufferedSource m2772constructorimpl(BufferedSource bufferedSource) {
        return bufferedSource;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2773equalsimpl(BufferedSource bufferedSource, Object obj) {
        return (obj instanceof SourceResponseBody) && Intrinsics.areEqual(bufferedSource, ((SourceResponseBody) obj).m2778unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2774hashCodeimpl(BufferedSource bufferedSource) {
        return bufferedSource.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2775toStringimpl(BufferedSource bufferedSource) {
        return "SourceResponseBody(source=" + bufferedSource + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m2773equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m2774hashCodeimpl(this.source);
    }

    public String toString() {
        return m2775toStringimpl(this.source);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ BufferedSource m2778unboximpl() {
        return this.source;
    }

    /* JADX INFO: renamed from: writeTo-impl, reason: not valid java name */
    public static Object m2777writeToimpl(BufferedSource bufferedSource, FileSystem fileSystem, Path path, Continuation continuation) throws Throwable {
        BufferedSink bufferedSinkBuffer = Okio.buffer(fileSystem.sink(path, false));
        try {
            Boxing.boxLong(bufferedSource.readAll(bufferedSinkBuffer));
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th3) {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        return Unit.INSTANCE;
    }

    private /* synthetic */ SourceResponseBody(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    @Override // coil3.network.NetworkResponseBody
    public Object writeTo(BufferedSink bufferedSink, Continuation continuation) {
        return m2776writeToimpl(this.source, bufferedSink, continuation);
    }

    /* JADX INFO: renamed from: writeTo-impl, reason: not valid java name */
    public static Object m2776writeToimpl(BufferedSource bufferedSource, BufferedSink bufferedSink, Continuation continuation) throws IOException {
        bufferedSource.readAll(bufferedSink);
        return Unit.INSTANCE;
    }

    @Override // coil3.network.NetworkResponseBody
    public Object writeTo(FileSystem fileSystem, Path path, Continuation continuation) {
        return m2777writeToimpl(this.source, fileSystem, path, continuation);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        m2771closeimpl(this.source);
    }

    /* JADX INFO: renamed from: close-impl, reason: not valid java name */
    public static void m2771closeimpl(BufferedSource bufferedSource) throws IOException {
        bufferedSource.close();
    }
}
