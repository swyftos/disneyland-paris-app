package coil3.content;

import coil3.RealImageLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1836d2 = {"SystemCallbacks", "Lcoil3/util/SystemCallbacks;", "imageLoader", "Lcoil3/RealImageLoader;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SystemCallbacksKt {
    @NotNull
    public static final SystemCallbacks SystemCallbacks(@NotNull RealImageLoader realImageLoader) {
        return new AndroidSystemCallbacks(realImageLoader);
    }
}
