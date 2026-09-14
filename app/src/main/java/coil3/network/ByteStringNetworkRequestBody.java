package coil3.network;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
final class ByteStringNetworkRequestBody implements NetworkRequestBody {
    private final ByteString bytes;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ByteStringNetworkRequestBody m2762boximpl(ByteString byteString) {
        return new ByteStringNetworkRequestBody(byteString);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static ByteString m2763constructorimpl(ByteString byteString) {
        return byteString;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2764equalsimpl(ByteString byteString, Object obj) {
        return (obj instanceof ByteStringNetworkRequestBody) && Intrinsics.areEqual(byteString, ((ByteStringNetworkRequestBody) obj).m2768unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2765hashCodeimpl(ByteString byteString) {
        return byteString.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2766toStringimpl(ByteString byteString) {
        return "ByteStringNetworkRequestBody(bytes=" + byteString + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m2764equalsimpl(this.bytes, obj);
    }

    public int hashCode() {
        return m2765hashCodeimpl(this.bytes);
    }

    public String toString() {
        return m2766toStringimpl(this.bytes);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ ByteString m2768unboximpl() {
        return this.bytes;
    }

    private /* synthetic */ ByteStringNetworkRequestBody(ByteString byteString) {
        this.bytes = byteString;
    }

    @Override // coil3.network.NetworkRequestBody
    public Object writeTo(BufferedSink bufferedSink, Continuation continuation) {
        return m2767writeToimpl(this.bytes, bufferedSink, continuation);
    }

    /* JADX INFO: renamed from: writeTo-impl, reason: not valid java name */
    public static Object m2767writeToimpl(ByteString byteString, BufferedSink bufferedSink, Continuation continuation) throws IOException {
        bufferedSink.write(byteString);
        return Unit.INSTANCE;
    }
}
