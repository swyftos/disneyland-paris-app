package coil3.disk;

import java.io.File;
import kotlin.Metadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"}, m1836d2 = {"directory", "Lcoil3/disk/DiskCache$Builder;", "Ljava/io/File;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DiskCacheKt {
    @NotNull
    public static final DiskCache.Builder directory(@NotNull DiskCache.Builder builder, @NotNull File file) {
        return builder.directory(Path.Companion.get$default(Path.INSTANCE, file, false, 1, (Object) null));
    }
}
