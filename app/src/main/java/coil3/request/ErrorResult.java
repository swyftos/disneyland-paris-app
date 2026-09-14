package coil3.request;

import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m1836d2 = {"Lcoil3/request/ErrorResult;", "Lcoil3/request/ImageResult;", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "request", "Lcoil3/request/ImageRequest;", "throwable", "", "<init>", "(Lcoil3/Image;Lcoil3/request/ImageRequest;Ljava/lang/Throwable;)V", "getImage", "()Lcoil3/Image;", "getRequest", "()Lcoil3/request/ImageRequest;", "getThrowable", "()Ljava/lang/Throwable;", "copy", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ErrorResult implements ImageResult {
    private final Image image;
    private final ImageRequest request;
    private final Throwable throwable;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual(this.image, errorResult.image) && Intrinsics.areEqual(this.request, errorResult.request) && Intrinsics.areEqual(this.throwable, errorResult.throwable);
    }

    public int hashCode() {
        Image image = this.image;
        return ((((image == null ? 0 : image.hashCode()) * 31) + this.request.hashCode()) * 31) + this.throwable.hashCode();
    }

    @NotNull
    public String toString() {
        return "ErrorResult(image=" + this.image + ", request=" + this.request + ", throwable=" + this.throwable + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ErrorResult(@Nullable Image image, @NotNull ImageRequest imageRequest, @NotNull Throwable th) {
        this.image = image;
        this.request = imageRequest;
        this.throwable = th;
    }

    @Override // coil3.request.ImageResult
    @Nullable
    public Image getImage() {
        return this.image;
    }

    @Override // coil3.request.ImageResult
    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    @NotNull
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public static /* synthetic */ ErrorResult copy$default(ErrorResult errorResult, Image image, ImageRequest imageRequest, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            image = errorResult.getImage();
        }
        if ((i & 2) != 0) {
            imageRequest = errorResult.getRequest();
        }
        if ((i & 4) != 0) {
            th = errorResult.throwable;
        }
        return errorResult.copy(image, imageRequest, th);
    }

    @NotNull
    public final ErrorResult copy(@Nullable Image image, @NotNull ImageRequest request, @NotNull Throwable throwable) {
        return new ErrorResult(image, request, throwable);
    }
}
