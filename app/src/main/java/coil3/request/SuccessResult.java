package coil3.request;

import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.Image;
import coil3.decode.DataSource;
import coil3.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001b¨\u0006\u001d"}, m1836d2 = {"Lcoil3/request/SuccessResult;", "Lcoil3/request/ImageResult;", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "request", "Lcoil3/request/ImageRequest;", "dataSource", "Lcoil3/decode/DataSource;", "memoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "diskCacheKey", "", "isSampled", "", "isPlaceholderCached", "<init>", "(Lcoil3/Image;Lcoil3/request/ImageRequest;Lcoil3/decode/DataSource;Lcoil3/memory/MemoryCache$Key;Ljava/lang/String;ZZ)V", "getImage", "()Lcoil3/Image;", "getRequest", "()Lcoil3/request/ImageRequest;", "getDataSource", "()Lcoil3/decode/DataSource;", "getMemoryCacheKey", "()Lcoil3/memory/MemoryCache$Key;", "getDiskCacheKey", "()Ljava/lang/String;", "()Z", "copy", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SuccessResult implements ImageResult {
    private final DataSource dataSource;
    private final String diskCacheKey;
    private final Image image;
    private final boolean isPlaceholderCached;
    private final boolean isSampled;
    private final MemoryCache.Key memoryCacheKey;
    private final ImageRequest request;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual(this.image, successResult.image) && Intrinsics.areEqual(this.request, successResult.request) && this.dataSource == successResult.dataSource && Intrinsics.areEqual(this.memoryCacheKey, successResult.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, successResult.diskCacheKey) && this.isSampled == successResult.isSampled && this.isPlaceholderCached == successResult.isPlaceholderCached;
    }

    public int hashCode() {
        int iHashCode = ((((this.image.hashCode() * 31) + this.request.hashCode()) * 31) + this.dataSource.hashCode()) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode2 = (iHashCode + (key == null ? 0 : key.hashCode())) * 31;
        String str = this.diskCacheKey;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSampled)) * 31) + Boolean.hashCode(this.isPlaceholderCached);
    }

    @NotNull
    public String toString() {
        return "SuccessResult(image=" + this.image + ", request=" + this.request + ", dataSource=" + this.dataSource + ", memoryCacheKey=" + this.memoryCacheKey + ", diskCacheKey=" + this.diskCacheKey + ", isSampled=" + this.isSampled + ", isPlaceholderCached=" + this.isPlaceholderCached + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SuccessResult(@NotNull Image image, @NotNull ImageRequest imageRequest, @NotNull DataSource dataSource, @Nullable MemoryCache.Key key, @Nullable String str, boolean z, boolean z2) {
        this.image = image;
        this.request = imageRequest;
        this.dataSource = dataSource;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    @Override // coil3.request.ImageResult
    @NotNull
    public Image getImage() {
        return this.image;
    }

    @Override // coil3.request.ImageResult
    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    public /* synthetic */ SuccessResult(Image image, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, imageRequest, (i & 4) != 0 ? DataSource.MEMORY : dataSource, (i & 8) != 0 ? null : key, (i & 16) != 0 ? null : str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2);
    }

    @NotNull
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    @Nullable
    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    @Nullable
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    /* JADX INFO: renamed from: isSampled, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }

    /* JADX INFO: renamed from: isPlaceholderCached, reason: from getter */
    public final boolean getIsPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public static /* synthetic */ SuccessResult copy$default(SuccessResult successResult, Image image, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            image = successResult.getImage();
        }
        if ((i & 2) != 0) {
            imageRequest = successResult.getRequest();
        }
        ImageRequest imageRequest2 = imageRequest;
        if ((i & 4) != 0) {
            dataSource = successResult.dataSource;
        }
        DataSource dataSource2 = dataSource;
        if ((i & 8) != 0) {
            key = successResult.memoryCacheKey;
        }
        MemoryCache.Key key2 = key;
        if ((i & 16) != 0) {
            str = successResult.diskCacheKey;
        }
        String str2 = str;
        if ((i & 32) != 0) {
            z = successResult.isSampled;
        }
        boolean z3 = z;
        if ((i & 64) != 0) {
            z2 = successResult.isPlaceholderCached;
        }
        return successResult.copy(image, imageRequest2, dataSource2, key2, str2, z3, z2);
    }

    @NotNull
    public final SuccessResult copy(@NotNull Image image, @NotNull ImageRequest request, @NotNull DataSource dataSource, @Nullable MemoryCache.Key memoryCacheKey, @Nullable String diskCacheKey, boolean isSampled, boolean isPlaceholderCached) {
        return new SuccessResult(image, request, dataSource, memoryCacheKey, diskCacheKey, isSampled, isPlaceholderCached);
    }
}
