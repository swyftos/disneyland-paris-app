package coil3.request;

import coil3.Extras;
import coil3.ExtrasKt;
import coil3.ImageLoader;
import coil3.size.Size;
import coil3.size.SizeKt;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0007\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\u0007\u001a\u00020\t*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u000f*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0011\"\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016\"\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011\"\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1836d2 = {"crossfade", "Lcoil3/request/ImageRequest$Builder;", "enable", "", "Lcoil3/ImageLoader$Builder;", "DEFAULT_CROSSFADE_MILLIS", "", "maxBitmapSize", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "Lcoil3/request/ImageRequest;", "getMaxBitmapSize", "(Lcoil3/request/ImageRequest;)Lcoil3/size/Size;", "Lcoil3/request/Options;", "(Lcoil3/request/Options;)Lcoil3/size/Size;", "Lcoil3/Extras$Key;", "Lcoil3/Extras$Key$Companion;", "(Lcoil3/Extras$Key$Companion;)Lcoil3/Extras$Key;", "maxBitmapSizeKey", "addLastModifiedToFileCacheKey", "getAddLastModifiedToFileCacheKey", "(Lcoil3/request/ImageRequest;)Z", "(Lcoil3/request/Options;)Z", "addLastModifiedToFileCacheKeyKey", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageRequestsKt {
    public static final int DEFAULT_CROSSFADE_MILLIS = 200;
    private static final Extras.Key maxBitmapSizeKey = new Extras.Key(SizeKt.Size(4096, 4096));
    private static final Extras.Key addLastModifiedToFileCacheKeyKey = new Extras.Key(Boolean.FALSE);

    @NotNull
    public static final ImageRequest.Builder crossfade(@NotNull ImageRequest.Builder builder, boolean z) {
        return ImageRequests_androidKt.crossfade(builder, z ? 200 : 0);
    }

    @NotNull
    public static final ImageLoader.Builder crossfade(@NotNull ImageLoader.Builder builder, boolean z) {
        return ImageRequests_androidKt.crossfade(builder, z ? 200 : 0);
    }

    @NotNull
    public static final ImageRequest.Builder maxBitmapSize(@NotNull ImageRequest.Builder builder, @NotNull Size size) {
        builder.getExtras().set(maxBitmapSizeKey, size);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder maxBitmapSize(@NotNull ImageLoader.Builder builder, @NotNull Size size) {
        builder.getExtras().set(maxBitmapSizeKey, size);
        return builder;
    }

    @NotNull
    public static final Size getMaxBitmapSize(@NotNull ImageRequest imageRequest) {
        return (Size) ExtrasKt.getExtra(imageRequest, maxBitmapSizeKey);
    }

    @NotNull
    public static final Size getMaxBitmapSize(@NotNull Options options) {
        return (Size) ExtrasKt.getExtra(options, maxBitmapSizeKey);
    }

    @NotNull
    public static final Extras.Key<Size> getMaxBitmapSize(@NotNull Extras.Key.Companion companion) {
        return maxBitmapSizeKey;
    }

    @NotNull
    public static final ImageRequest.Builder addLastModifiedToFileCacheKey(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(addLastModifiedToFileCacheKeyKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder addLastModifiedToFileCacheKey(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(addLastModifiedToFileCacheKeyKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAddLastModifiedToFileCacheKey(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, addLastModifiedToFileCacheKeyKey)).booleanValue();
    }

    public static final boolean getAddLastModifiedToFileCacheKey(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, addLastModifiedToFileCacheKeyKey)).booleanValue();
    }

    @NotNull
    public static final Extras.Key<Boolean> getAddLastModifiedToFileCacheKey(@NotNull Extras.Key.Companion companion) {
        return addLastModifiedToFileCacheKeyKey;
    }
}
