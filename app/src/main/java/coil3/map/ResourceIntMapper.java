package coil3.map;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.DrawableRes;
import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, m1836d2 = {"Lcoil3/map/ResourceIntMapper;", "Lcoil3/map/Mapper;", "", "Lcoil3/Uri;", "<init>", "()V", "map", "data", "options", "Lcoil3/request/Options;", "isApplicable", "", "context", "Landroid/content/Context;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ResourceIntMapper implements Mapper<Integer, Uri> {
    @Override // coil3.map.Mapper
    public /* bridge */ /* synthetic */ Uri map(Integer num, Options options) {
        return map(num.intValue(), options);
    }

    @Nullable
    public Uri map(@DrawableRes int data, @NotNull Options options) {
        if (!isApplicable(data, options.getContext())) {
            return null;
        }
        return UriKt.toUri$default("android.resource://" + options.getContext().getPackageName() + '/' + data, null, 1, null);
    }

    private final boolean isApplicable(int data, Context context) {
        try {
            return context.getResources().getResourceEntryName(data) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }
}
