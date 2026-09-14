package coil3.size;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m1836d2 = {"ViewSizeResolver", "Lcoil3/size/ViewSizeResolver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "view", "subtractPadding", "", "(Landroid/view/View;Z)Lcoil3/size/ViewSizeResolver;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ViewSizeResolverKt {
    @JvmOverloads
    @NotNull
    public static final <T extends View> ViewSizeResolver<T> ViewSizeResolver(@NotNull T t) {
        return ViewSizeResolver$default(t, false, 2, null);
    }

    public static /* synthetic */ ViewSizeResolver ViewSizeResolver$default(View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return ViewSizeResolver(view, z);
    }

    @JvmOverloads
    @NotNull
    public static final <T extends View> ViewSizeResolver<T> ViewSizeResolver(@NotNull T t, boolean z) {
        return new RealViewSizeResolver(t, z);
    }
}
