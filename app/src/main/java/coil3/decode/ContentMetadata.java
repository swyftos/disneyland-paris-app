package coil3.decode;

import android.content.res.AssetFileDescriptor;
import coil3.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1836d2 = {"Lcoil3/decode/ContentMetadata;", "Lcoil3/decode/ImageSource$Metadata;", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Lcoil3/Uri;", "assetFileDescriptor", "Landroid/content/res/AssetFileDescriptor;", "<init>", "(Lcoil3/Uri;Landroid/content/res/AssetFileDescriptor;)V", "getUri", "()Lcoil3/Uri;", "getAssetFileDescriptor", "()Landroid/content/res/AssetFileDescriptor;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ContentMetadata extends ImageSource.Metadata {
    private final AssetFileDescriptor assetFileDescriptor;
    private final Uri uri;

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    @NotNull
    public final AssetFileDescriptor getAssetFileDescriptor() {
        return this.assetFileDescriptor;
    }

    public ContentMetadata(@NotNull Uri uri, @NotNull AssetFileDescriptor assetFileDescriptor) {
        this.uri = uri;
        this.assetFileDescriptor = assetFileDescriptor;
    }
}
