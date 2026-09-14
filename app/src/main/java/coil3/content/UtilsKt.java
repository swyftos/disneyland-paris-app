package coil3.content;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Image;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.intercept.Interceptor;
import coil3.intercept.RealInterceptorChain;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\u0007j\u0002`\bH\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\tj\u0002`\nH\u0000\u001a*\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014H\u0000\u001a\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\u001a\f\u0010&\u001a\u00020\u001f*\u00020'H\u0000\u001a\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0000\u001a\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010!\"\u0018\u0010\"\u001a\u00020#*\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u000e\u0010(\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u00061"}, m1836d2 = {"emoji", "", "Lcoil3/decode/DataSource;", "getEmoji", "(Lcoil3/decode/DataSource;)Ljava/lang/String;", "closeQuietly", "", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "EMPTY_IMAGE_FACTORY", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "getEMPTY_IMAGE_FACTORY", "()Lkotlin/jvm/functions/Function1;", "addFirst", "Lcoil3/ComponentRegistry$Builder;", "pair", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "factory", "Lcoil3/decode/Decoder$Factory;", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "MIME_TYPE_HEIC", "MIME_TYPE_HEIF", "MIME_TYPE_XML", "isPlaceholderCached", "", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;)Z", "eventListener", "Lcoil3/EventListener;", "getEventListener", "(Lcoil3/intercept/Interceptor$Chain;)Lcoil3/EventListener;", "isMinOrMax", "", "SCHEME_FILE", "isFileUri", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Lcoil3/Uri;", "ErrorResult", "Lcoil3/request/ErrorResult;", "request", "throwable", "", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\ncoil3/util/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class UtilsKt {
    private static final Function1 EMPTY_IMAGE_FACTORY = new Function1() { // from class: coil3.util.UtilsKt$EMPTY_IMAGE_FACTORY$1
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(ImageRequest imageRequest) {
            return null;
        }
    };

    @NotNull
    public static final String MIME_TYPE_HEIC = "image/heic";

    @NotNull
    public static final String MIME_TYPE_HEIF = "image/heif";

    @NotNull
    public static final String MIME_TYPE_JPEG = "image/jpeg";

    @NotNull
    public static final String MIME_TYPE_WEBP = "image/webp";

    @NotNull
    public static final String MIME_TYPE_XML = "text/xml";

    @NotNull
    public static final String SCHEME_FILE = "file";

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isMinOrMax(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    @NotNull
    public static final String getEmoji(@NotNull DataSource dataSource) {
        int i = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i == 1 || i == 2) {
            return "🧠";
        }
        if (i == 3) {
            return "💾";
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return "☁️";
    }

    public static final void closeQuietly(@NotNull Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@NotNull AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final Function1<ImageRequest, Image> getEMPTY_IMAGE_FACTORY() {
        return EMPTY_IMAGE_FACTORY;
    }

    @NotNull
    public static final ComponentRegistry.Builder addFirst(@NotNull ComponentRegistry.Builder builder, @Nullable final Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair) {
        if (pair != null) {
            builder.getLazyFetcherFactories$coil_core_release().add(0, new Function0() { // from class: coil3.util.UtilsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionsKt.listOf(pair);
                }
            });
        }
        return builder;
    }

    @NotNull
    public static final ComponentRegistry.Builder addFirst(@NotNull ComponentRegistry.Builder builder, @Nullable final Decoder.Factory factory) {
        if (factory != null) {
            builder.getLazyDecoderFactories$coil_core_release().add(0, new Function0() { // from class: coil3.util.UtilsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionsKt.listOf(factory);
                }
            });
        }
        return builder;
    }

    public static final boolean isPlaceholderCached(@NotNull Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).getIsPlaceholderCached();
    }

    @NotNull
    public static final EventListener getEventListener(@NotNull Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final boolean isFileUri(@NotNull Uri uri) {
        return ((uri.getScheme() != null && !Intrinsics.areEqual(uri.getScheme(), "file")) || uri.getPath() == null || Utils_androidKt.isAssetUri(uri)) ? false : true;
    }

    @NotNull
    public static final ErrorResult ErrorResult(@NotNull ImageRequest imageRequest, @NotNull Throwable th) {
        Image imageError;
        if (!(th instanceof NullRequestDataException) || (imageError = imageRequest.fallback()) == null) {
            imageError = imageRequest.error();
        }
        return new ErrorResult(imageError, imageRequest, th);
    }
}
