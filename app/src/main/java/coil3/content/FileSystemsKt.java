package coil3.content;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.text.StringsKt;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0000\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1836d2 = {"createFile", "", "Lokio/FileSystem;", "file", "Lokio/Path;", "mustCreate", "", "createTempFile", "deleteContents", "directory", "extension", "", "getExtension", "(Lokio/Path;)Ljava/lang/String;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FileSystemsKt {
    public static /* synthetic */ void createFile$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        createFile(fileSystem, path, z);
    }

    public static final void createFile(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z) {
        if (z) {
            UtilsKt.closeQuietly((Closeable) fileSystem.sink(path, true));
        } else {
            if (fileSystem.exists(path)) {
                return;
            }
            UtilsKt.closeQuietly((Closeable) fileSystem.sink(path));
        }
    }

    @NotNull
    public static final Path createTempFile(@NotNull FileSystem fileSystem) {
        Path pathResolve;
        do {
            pathResolve = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.resolve("tmp_" + ((Object) ULong.m5341toStringimpl(URandomKt.nextULong(Random.INSTANCE))));
        } while (fileSystem.exists(pathResolve));
        createFile(fileSystem, pathResolve, true);
        return pathResolve;
    }

    public static final void deleteContents(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).getIsDirectory()) {
                        deleteContents(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    @NotNull
    public static final String getExtension(@NotNull Path path) {
        return StringsKt.substringAfterLast(path.name(), '.', "");
    }
}
