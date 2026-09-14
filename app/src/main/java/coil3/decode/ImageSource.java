package coil3.decode;

import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0011J\b\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000e\u001a\u00020\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\u0012\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, m1836d2 = {"Lcoil3/decode/ImageSource;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "metadata", "Lcoil3/decode/ImageSource$Metadata;", "getMetadata", "()Lcoil3/decode/ImageSource$Metadata;", "source", "Lokio/BufferedSource;", "sourceOrNull", "file", "Lokio/Path;", "fileOrNull", "Metadata", "Lcoil3/decode/FileImageSource;", "Lcoil3/decode/SourceImageSource;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface ImageSource extends AutoCloseable {

    @kotlin.Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcoil3/decode/ImageSource$Metadata;", "", "<init>", "()V", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static abstract class Metadata {
    }

    @NotNull
    Path file();

    @Nullable
    Path fileOrNull();

    @NotNull
    FileSystem getFileSystem();

    @Nullable
    Metadata getMetadata();

    @NotNull
    BufferedSource source();

    @Nullable
    BufferedSource sourceOrNull();
}
