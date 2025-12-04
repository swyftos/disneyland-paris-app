package okio;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
abstract /* synthetic */ class Okio__OkioKt {
    public static final BufferedSource buffer(Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new buffer(source);
    }

    public static final BufferedSink buffer(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new buffer(sink);
    }

    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final Object use(Closeable closeable, Function1 block) throws Throwable {
        Object objInvoke;
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable th = null;
        try {
            objInvoke = block.invoke(closeable);
            InlineMarker.finallyStart(1);
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th3) {
            InlineMarker.finallyStart(1);
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            InlineMarker.finallyEnd(1);
            th = th3;
            objInvoke = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(objInvoke);
        return objInvoke;
    }
}
