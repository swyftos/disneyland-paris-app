package coil3.map;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import kotlin.Metadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1836d2 = {"Lcoil3/map/PathMapper;", "Lcoil3/map/Mapper;", "Lokio/Path;", "Lcoil3/Uri;", "<init>", "()V", "map", "data", "options", "Lcoil3/request/Options;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class PathMapper implements Mapper<Path, Uri> {
    @Override // coil3.map.Mapper
    @NotNull
    public Uri map(@NotNull Path data, @NotNull Options options) {
        return UriKt.Uri$default("file", null, data.toString(), null, null, null, 58, null);
    }
}
