package coil3.request;

import androidx.media3.common.MimeTypes;
import coil3.Image;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\n\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/request/ImageResult;", "", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "getImage", "()Lcoil3/Image;", "request", "Lcoil3/request/ImageRequest;", "getRequest", "()Lcoil3/request/ImageRequest;", "Lcoil3/request/ErrorResult;", "Lcoil3/request/SuccessResult;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface ImageResult {
    @Nullable
    Image getImage();

    @NotNull
    ImageRequest getRequest();
}
