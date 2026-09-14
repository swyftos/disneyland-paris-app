package coil3.fetch;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1836d2 = {"asSource", "Lokio/Source;", "Ljava/nio/ByteBuffer;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ByteBufferFetcherKt {
    @NotNull
    public static final Source asSource(@NotNull ByteBuffer byteBuffer) {
        return new Source(byteBuffer) { // from class: coil3.fetch.ByteBufferFetcherKt.asSource.1
            private final ByteBuffer buffer;
            private final int len;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            {
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                this.buffer = byteBufferSlice;
                this.len = byteBufferSlice.capacity();
            }

            @Override // okio.Source
            public long read(Buffer sink, long byteCount) {
                if (this.buffer.position() == this.len) {
                    return -1L;
                }
                this.buffer.limit(RangesKt.coerceAtMost((int) (((long) this.buffer.position()) + byteCount), this.len));
                return sink.write(this.buffer);
            }

            @Override // okio.Source
            /* JADX INFO: renamed from: timeout */
            public Timeout getThis$0() {
                return Timeout.NONE;
            }
        };
    }
}
