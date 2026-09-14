package coil3;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u0003H\u0000¨\u0006\u0004"}, m1836d2 = {"applicationImageLoaderFactory", "Lcoil3/SingletonImageLoader$Factory;", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "coil_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SingletonImageLoader_androidKt {
    @Nullable
    public static final SingletonImageLoader.Factory applicationImageLoaderFactory(@NotNull Context context) {
        Object applicationContext = context.getApplicationContext();
        if (applicationContext instanceof SingletonImageLoader.Factory) {
            return (SingletonImageLoader.Factory) applicationContext;
        }
        return null;
    }
}
