package coil3.memory;

import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1836d2 = {"needsSizeInCacheKey", "", "Lcoil3/request/ImageRequest;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class MemoryCacheServiceKt {
    public static final boolean needsSizeInCacheKey(@NotNull ImageRequest imageRequest) {
        return !ImageRequests_androidKt.getTransformations(imageRequest).isEmpty();
    }
}
