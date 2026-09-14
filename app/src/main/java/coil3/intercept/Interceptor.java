package coil3.intercept;

import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Size;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/intercept/Interceptor;", "", "intercept", "Lcoil3/request/ImageResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Chain", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface Interceptor {

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/intercept/Interceptor$Chain;", "", "request", "Lcoil3/request/ImageRequest;", "getRequest", "()Lcoil3/request/ImageRequest;", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "getSize", "()Lcoil3/size/Size;", "withRequest", "withSize", "proceed", "Lcoil3/request/ImageResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface Chain {
        @NotNull
        ImageRequest getRequest();

        @NotNull
        Size getSize();

        @Nullable
        Object proceed(@NotNull Continuation<? super ImageResult> continuation);

        @NotNull
        Chain withRequest(@NotNull ImageRequest request);

        @NotNull
        Chain withSize(@NotNull Size size);
    }

    @Nullable
    Object intercept(@NotNull Chain chain, @NotNull Continuation<? super ImageResult> continuation);
}
