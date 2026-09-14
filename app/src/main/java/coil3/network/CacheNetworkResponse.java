package coil3.network;

import coil3.annotation.InternalCoilApi;
import coil3.network.internal.UtilsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSink;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, m1836d2 = {"Lcoil3/network/CacheNetworkResponse;", "", "<init>", "()V", "readFrom", "Lcoil3/network/NetworkResponse;", "source", "Lokio/BufferedSource;", "writeTo", "", "response", "sink", "Lokio/BufferedSink;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@InternalCoilApi
@SourceDebugExtension({"SMAP\nCacheNetworkResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheNetworkResponse.kt\ncoil3/network/CacheNetworkResponse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class CacheNetworkResponse {

    @NotNull
    public static final CacheNetworkResponse INSTANCE = new CacheNetworkResponse();

    private CacheNetworkResponse() {
    }

    @NotNull
    public final NetworkResponse readFrom(@NotNull BufferedSource source) {
        int i = Integer.parseInt(source.readUtf8LineStrict());
        long j = Long.parseLong(source.readUtf8LineStrict());
        long j2 = Long.parseLong(source.readUtf8LineStrict());
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        int i2 = Integer.parseInt(source.readUtf8LineStrict());
        for (int i3 = 0; i3 < i2; i3++) {
            UtilsKt.append(builder, source.readUtf8LineStrict());
        }
        return new NetworkResponse(i, j, j2, builder.build(), null, null, 48, null);
    }

    public final void writeTo(@NotNull NetworkResponse response, @NotNull BufferedSink sink) throws IOException {
        sink.writeDecimalLong(response.getCode()).writeByte(10);
        sink.writeDecimalLong(response.getRequestMillis()).writeByte(10);
        sink.writeDecimalLong(response.getResponseMillis()).writeByte(10);
        Set<Map.Entry<String, List<String>>> setEntrySet = response.getHeaders().asMap().entrySet();
        Iterator<T> it = setEntrySet.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((List) ((Map.Entry) it.next()).getValue()).size();
        }
        sink.writeDecimalLong(size).writeByte(10);
        for (Map.Entry<String, List<String>> entry : setEntrySet) {
            Iterator<String> it2 = entry.getValue().iterator();
            while (it2.hasNext()) {
                sink.writeUtf8(entry.getKey()).writeUtf8(":").writeUtf8(it2.next()).writeByte(10);
            }
        }
    }
}
