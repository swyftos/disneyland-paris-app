package coil3;

import android.content.Context;
import androidx.concurrent.futures.AbstractC0365xc40028dd;
import coil3.annotation.DelicateCoilApi;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u0011\u001a\u00020\fH\u0007J\u0014\u0010\u0012\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0002R\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¨\u0006\u0014"}, m1836d2 = {"Lcoil3/SingletonImageLoader;", "", "<init>", "()V", "reference", "Lkotlinx/atomicfu/AtomicRef;", "get", "Lcoil3/ImageLoader;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "setSafe", "", "factory", "Lcoil3/SingletonImageLoader$Factory;", "setUnsafe", "imageLoader", "reset", "newImageLoader", "Factory", "coil_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSingletonImageLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingletonImageLoader.kt\ncoil3/SingletonImageLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
public final class SingletonImageLoader {

    @NotNull
    public static final SingletonImageLoader INSTANCE = new SingletonImageLoader();
    private static final /* synthetic */ C1755x535a4b86 singletonImageLoader$VolatileWrapper$atomicfu$private = new C1755x535a4b86(null);

    @Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m1836d2 = {"Lcoil3/SingletonImageLoader$Factory;", "", "newImageLoader", "Lcoil3/ImageLoader;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "coil_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface Factory {
        @NotNull
        ImageLoader newImageLoader(@NotNull Context context);
    }

    private SingletonImageLoader() {
    }

    @JvmStatic
    @NotNull
    public static final ImageLoader get(@NotNull Context context) {
        Object obj = C1755x535a4b86.reference$volatile$FU.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        ImageLoader imageLoader = obj instanceof ImageLoader ? (ImageLoader) obj : null;
        return imageLoader == null ? INSTANCE.newImageLoader(context) : imageLoader;
    }

    @JvmStatic
    public static final void setSafe(@NotNull Factory factory) {
        Object obj = C1755x535a4b86.reference$volatile$FU.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        if (obj instanceof ImageLoader) {
            if (SingletonImageLoaderKt.isDefault((ImageLoader) obj)) {
                throw new IllegalStateException("The singleton image loader has already been created. This indicates that\n                    'setSafe' is being called after the first 'get' call. Ensure that 'setSafe' is\n                    called before any Coil API usages (e.g. `load`, `AsyncImage`,\n                    `rememberAsyncImagePainter`, etc.).");
            }
        } else {
            AbstractC0365xc40028dd.m91m(C1755x535a4b86.reference$volatile$FU, singletonImageLoader$VolatileWrapper$atomicfu$private, obj, factory);
        }
    }

    @JvmStatic
    @DelicateCoilApi
    public static final void setUnsafe(@NotNull ImageLoader imageLoader) {
        C1755x535a4b86.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, imageLoader);
    }

    @JvmStatic
    @DelicateCoilApi
    public static final void setUnsafe(@NotNull Factory factory) {
        C1755x535a4b86.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, factory);
    }

    @JvmStatic
    @DelicateCoilApi
    public static final void reset() {
        C1755x535a4b86.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, null);
    }

    private final ImageLoader newImageLoader(Context context) {
        ImageLoader imageLoader;
        C1755x535a4b86 c1755x535a4b86 = singletonImageLoader$VolatileWrapper$atomicfu$private;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1755x535a4b86.reference$volatile$FU;
        ImageLoader imageLoaderNewImageLoader = null;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(c1755x535a4b86);
            if (obj instanceof ImageLoader) {
                imageLoader = imageLoaderNewImageLoader;
                imageLoaderNewImageLoader = (ImageLoader) obj;
            } else {
                if (imageLoaderNewImageLoader == null) {
                    Factory factory = obj instanceof Factory ? (Factory) obj : null;
                    if (factory == null || (imageLoaderNewImageLoader = factory.newImageLoader(context)) == null) {
                        Factory factoryApplicationImageLoaderFactory = SingletonImageLoader_androidKt.applicationImageLoaderFactory(context);
                        imageLoaderNewImageLoader = factoryApplicationImageLoaderFactory != null ? factoryApplicationImageLoaderFactory.newImageLoader(context) : SingletonImageLoaderKt.DefaultSingletonImageLoaderFactory.newImageLoader(context);
                    }
                }
                imageLoader = imageLoaderNewImageLoader;
            }
            if (AbstractC0365xc40028dd.m91m(atomicReferenceFieldUpdater, c1755x535a4b86, obj, imageLoaderNewImageLoader)) {
                Intrinsics.checkNotNull(imageLoaderNewImageLoader, "null cannot be cast to non-null type coil3.ImageLoader");
                return imageLoaderNewImageLoader;
            }
            imageLoaderNewImageLoader = imageLoader;
        }
    }
}
