package coil3.decode;

import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\u000f"}, m1836d2 = {"ImageSource", "Lcoil3/decode/ImageSource;", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "diskCacheKey", "", "closeable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "metadata", "Lcoil3/decode/ImageSource$Metadata;", "source", "Lokio/BufferedSource;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageSourceKt {
    public static /* synthetic */ ImageSource ImageSource$default(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable, ImageSource.Metadata metadata, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            autoCloseable = null;
        }
        if ((i & 16) != 0) {
            metadata = null;
        }
        return ImageSource(path, fileSystem, str, autoCloseable, metadata);
    }

    @NotNull
    public static final ImageSource ImageSource(@NotNull Path path, @NotNull FileSystem fileSystem, @Nullable String str, @Nullable AutoCloseable autoCloseable, @Nullable ImageSource.Metadata metadata) {
        return new FileImageSource(path, fileSystem, str, autoCloseable, metadata);
    }

    public static /* synthetic */ ImageSource ImageSource$default(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata, int i, Object obj) {
        if ((i & 4) != 0) {
            metadata = null;
        }
        return ImageSource(bufferedSource, fileSystem, metadata);
    }

    @NotNull
    public static final ImageSource ImageSource(@NotNull BufferedSource bufferedSource, @NotNull FileSystem fileSystem, @Nullable ImageSource.Metadata metadata) {
        return new SourceImageSource(bufferedSource, fileSystem, metadata);
    }
}
