package coil3.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1836d2 = {"Lcoil3/network/HttpException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "response", "Lcoil3/network/NetworkResponse;", "<init>", "(Lcoil3/network/NetworkResponse;)V", "getResponse", "()Lcoil3/network/NetworkResponse;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class HttpException extends RuntimeException {
    private final NetworkResponse response;

    public HttpException(@NotNull NetworkResponse networkResponse) {
        super("HTTP " + networkResponse.getCode());
        this.response = networkResponse;
    }

    @NotNull
    public final NetworkResponse getResponse() {
        return this.response;
    }
}
