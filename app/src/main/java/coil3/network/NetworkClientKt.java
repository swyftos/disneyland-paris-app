package coil3.network;

import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1836d2 = {"NetworkRequestBody", "Lcoil3/network/NetworkRequestBody;", "bytes", "Lokio/ByteString;", "NetworkResponseBody", "Lcoil3/network/NetworkResponseBody;", "source", "Lokio/BufferedSource;", "coil-network-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class NetworkClientKt {
    @NotNull
    public static final NetworkRequestBody NetworkRequestBody(@NotNull ByteString byteString) {
        return ByteStringNetworkRequestBody.m2762boximpl(ByteStringNetworkRequestBody.m2763constructorimpl(byteString));
    }

    @NotNull
    public static final NetworkResponseBody NetworkResponseBody(@NotNull BufferedSource bufferedSource) {
        return SourceResponseBody.m2770boximpl(SourceResponseBody.m2772constructorimpl(bufferedSource));
    }
}
