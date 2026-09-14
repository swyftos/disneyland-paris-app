package coil3;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1836d2 = {"DefaultSingletonImageLoaderFactory", "Lcoil3/SingletonImageLoader$Factory;", "isDefault", "", "Lcoil3/ImageLoader;", "(Lcoil3/ImageLoader;)Z", "DefaultSingletonImageLoaderKey", "Lcoil3/Extras$Key;", "", "coil_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSingletonImageLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingletonImageLoader.kt\ncoil3/SingletonImageLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
public final class SingletonImageLoaderKt {
    private static final SingletonImageLoader.Factory DefaultSingletonImageLoaderFactory = new SingletonImageLoader.Factory() { // from class: coil3.SingletonImageLoaderKt$$ExternalSyntheticLambda0
        @Override // coil3.SingletonImageLoader.Factory
        public final ImageLoader newImageLoader(Context context) {
            return SingletonImageLoaderKt.DefaultSingletonImageLoaderFactory$lambda$1(context);
        }
    };
    private static final Extras.Key DefaultSingletonImageLoaderKey = new Extras.Key(Unit.INSTANCE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageLoader DefaultSingletonImageLoaderFactory$lambda$1(Context context) {
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        builder.getExtras().set(DefaultSingletonImageLoaderKey, Unit.INSTANCE);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDefault(ImageLoader imageLoader) {
        return imageLoader.getDefaults().getExtras().get(DefaultSingletonImageLoaderKey) != null;
    }
}
