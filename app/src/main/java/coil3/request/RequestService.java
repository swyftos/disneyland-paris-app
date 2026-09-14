package coil3.request;

import coil3.memory.MemoryCache;
import coil3.size.Size;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, m1836d2 = {"Lcoil3/request/RequestService;", "", "requestDelegate", "Lcoil3/request/RequestDelegate;", "request", "Lcoil3/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "findLifecycle", "", "updateRequest", "options", "Lcoil3/request/Options;", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "updateOptions", "isCacheValueValidForHardware", "cacheValue", "Lcoil3/memory/MemoryCache$Value;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface RequestService {
    boolean isCacheValueValidForHardware(@NotNull ImageRequest request, @NotNull MemoryCache.Value cacheValue);

    @NotNull
    Options options(@NotNull ImageRequest request, @NotNull Size size);

    @NotNull
    RequestDelegate requestDelegate(@NotNull ImageRequest request, @NotNull Job job, boolean findLifecycle);

    @NotNull
    Options updateOptions(@NotNull Options options);

    @NotNull
    ImageRequest updateRequest(@NotNull ImageRequest request);
}
