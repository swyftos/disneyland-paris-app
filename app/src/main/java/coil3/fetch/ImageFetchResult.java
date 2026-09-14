package coil3.fetch;

import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.Image;
import coil3.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1836d2 = {"Lcoil3/fetch/ImageFetchResult;", "Lcoil3/fetch/FetchResult;", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "isSampled", "", "dataSource", "Lcoil3/decode/DataSource;", "<init>", "(Lcoil3/Image;ZLcoil3/decode/DataSource;)V", "getImage", "()Lcoil3/Image;", "()Z", "getDataSource", "()Lcoil3/decode/DataSource;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageFetchResult implements FetchResult {
    private final DataSource dataSource;
    private final Image image;
    private final boolean isSampled;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFetchResult)) {
            return false;
        }
        ImageFetchResult imageFetchResult = (ImageFetchResult) obj;
        return Intrinsics.areEqual(this.image, imageFetchResult.image) && this.isSampled == imageFetchResult.isSampled && this.dataSource == imageFetchResult.dataSource;
    }

    public int hashCode() {
        return (((this.image.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode();
    }

    @NotNull
    public String toString() {
        return "ImageFetchResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ImageFetchResult(@NotNull Image image, boolean z, @NotNull DataSource dataSource) {
        this.image = image;
        this.isSampled = z;
        this.dataSource = dataSource;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: isSampled, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }

    @NotNull
    public final DataSource getDataSource() {
        return this.dataSource;
    }
}
