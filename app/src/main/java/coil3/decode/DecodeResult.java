package coil3.decode;

import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u000b"}, m1836d2 = {"Lcoil3/decode/DecodeResult;", "", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "isSampled", "", "<init>", "(Lcoil3/Image;Z)V", "getImage", "()Lcoil3/Image;", "()Z", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DecodeResult {
    private final Image image;
    private final boolean isSampled;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return Intrinsics.areEqual(this.image, decodeResult.image) && this.isSampled == decodeResult.isSampled;
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + Boolean.hashCode(this.isSampled);
    }

    @NotNull
    public String toString() {
        return "DecodeResult(image=" + this.image + ", isSampled=" + this.isSampled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DecodeResult(@NotNull Image image, boolean z) {
        this.image = image;
        this.isSampled = z;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: isSampled, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }
}
