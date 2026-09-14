package coil3.network.internal;

import coil3.network.CacheStrategy;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ0\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m1836d2 = {"Lcoil3/network/internal/DefaultCacheStrategy;", "Lcoil3/network/CacheStrategy;", "<init>", "()V", "read", "Lcoil3/network/CacheStrategy$ReadResult;", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "options", "Lcoil3/request/Options;", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/request/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "Lcoil3/network/CacheStrategy$WriteResult;", "networkResponse", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lcoil3/request/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DefaultCacheStrategy implements CacheStrategy {
    @Override // coil3.network.CacheStrategy
    @Nullable
    public Object read(@NotNull NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull Options options, @NotNull Continuation<? super CacheStrategy.ReadResult> continuation) {
        return new CacheStrategy.ReadResult(networkResponse);
    }

    @Override // coil3.network.CacheStrategy
    @Nullable
    public Object write(@Nullable NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull NetworkResponse networkResponse2, @NotNull Options options, @NotNull Continuation<? super CacheStrategy.WriteResult> continuation) {
        if (networkResponse2.getCode() == 304 && networkResponse != null) {
            return new CacheStrategy.WriteResult(networkResponse2.copy((39 & 1) != 0 ? networkResponse2.code : 0, (39 & 2) != 0 ? networkResponse2.requestMillis : 0L, (39 & 4) != 0 ? networkResponse2.responseMillis : 0L, (39 & 8) != 0 ? networkResponse2.headers : UtilsKt.plus(networkResponse.getHeaders(), networkResponse2.getHeaders()), (39 & 16) != 0 ? networkResponse2.body : null, (39 & 32) != 0 ? networkResponse2.delegate : null));
        }
        return new CacheStrategy.WriteResult(networkResponse2);
    }
}
