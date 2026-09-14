package coil3.request;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.Extras;
import coil3.Image;
import coil3.content.Collections_jvmCommonKt;
import coil3.content.Coroutines_nonJsCommonKt;
import coil3.content.FileSystems_nonJsCommonKt;
import coil3.content.UtilsKt;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.memory.MemoryCache;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.size.SizeResolver;
import coil3.size.SizeResolverKt;
import coil3.target.Target;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004hijkBµ\u0002\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u001c\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u000201¢\u0006\u0004\b2\u00103J\b\u0010b\u001a\u0004\u0018\u00010#J\b\u0010c\u001a\u0004\u0018\u00010#J\b\u0010d\u001a\u0004\u0018\u00010#J\u001b\u0010e\u001a\u00020f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0002\u0010gR\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010>R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR'\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0011\u0010\u001a\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bK\u0010IR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u001d\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bN\u0010MR\u0011\u0010\u001e\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bO\u0010MR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001f\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001f\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bT\u0010SR\u001f\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bU\u0010SR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b`\u0010a¨\u0006l"}, m1836d2 = {"Lcoil3/request/ImageRequest;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "data", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/request/ImageRequest$Listener;", "memoryCacheKey", "", "memoryCacheKeyExtras", "", "diskCacheKey", "fileSystem", "Lokio/FileSystem;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "decoderFactory", "Lcoil3/decode/Decoder$Factory;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderMemoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "extras", "Lcoil3/Extras;", "defined", "Lcoil3/request/ImageRequest$Defined;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Lcoil3/target/Target;Lcoil3/request/ImageRequest$Listener;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lokio/FileSystem;Lkotlin/Pair;Lcoil3/decode/Decoder$Factory;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/memory/MemoryCache$Key;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;Lcoil3/Extras;Lcoil3/request/ImageRequest$Defined;Lcoil3/request/ImageRequest$Defaults;)V", "getContext", "()Landroid/content/Context;", "Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getTarget", "()Lcoil3/target/Target;", "getListener", "()Lcoil3/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Ljava/lang/String;", "getMemoryCacheKeyExtras", "()Ljava/util/Map;", "getDiskCacheKey", "getFileSystem", "()Lokio/FileSystem;", "getFetcherFactory", "()Lkotlin/Pair;", "getDecoderFactory", "()Lcoil3/decode/Decoder$Factory;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderMemoryCacheKey", "()Lcoil3/memory/MemoryCache$Key;", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getExtras", "()Lcoil3/Extras;", "getDefined", "()Lcoil3/request/ImageRequest$Defined;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", ReactTextInputShadowNode.PROP_PLACEHOLDER, Constants.IPC_BUNDLE_KEY_SEND_ERROR, "fallback", "newBuilder", "Lcoil3/request/ImageRequest$Builder;", "(Landroid/content/Context;)Lcoil3/request/ImageRequest$Builder;", "Listener", "Defined", "Defaults", "Builder", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageRequest {
    private final Context context;
    private final Object data;
    private final CoroutineContext decoderCoroutineContext;
    private final Decoder.Factory decoderFactory;
    private final Defaults defaults;
    private final Defined defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Function1 errorFactory;
    private final Extras extras;
    private final Function1 fallbackFactory;
    private final CoroutineContext fetcherCoroutineContext;
    private final Pair fetcherFactory;
    private final FileSystem fileSystem;
    private final CoroutineContext interceptorCoroutineContext;
    private final Listener listener;
    private final String memoryCacheKey;
    private final Map memoryCacheKeyExtras;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Function1 placeholderFactory;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Precision precision;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Target target;

    @Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/request/ImageRequest$Listener;", "", "onStart", "", "request", "Lcoil3/request/ImageRequest;", "onCancel", "onError", "result", "Lcoil3/request/ErrorResult;", "onSuccess", "Lcoil3/request/SuccessResult;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface Listener {
        default void onCancel(@NotNull ImageRequest request) {
        }

        default void onError(@NotNull ImageRequest request, @NotNull ErrorResult result) {
        }

        default void onStart(@NotNull ImageRequest request) {
        }

        default void onSuccess(@NotNull ImageRequest request, @NotNull SuccessResult result) {
        }
    }

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, String str, Map map, String str2, FileSystem fileSystem, Pair pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1 function1, Function1 function2, Function1 function3, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, str, map, str2, fileSystem, pair, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, key, function1, function2, function3, sizeResolver, scale, precision, extras, defined, defaults);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.areEqual(this.context, imageRequest.context) && Intrinsics.areEqual(this.data, imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && Intrinsics.areEqual(this.listener, imageRequest.listener) && Intrinsics.areEqual(this.memoryCacheKey, imageRequest.memoryCacheKey) && Intrinsics.areEqual(this.memoryCacheKeyExtras, imageRequest.memoryCacheKeyExtras) && Intrinsics.areEqual(this.diskCacheKey, imageRequest.diskCacheKey) && Intrinsics.areEqual(this.fileSystem, imageRequest.fileSystem) && Intrinsics.areEqual(this.fetcherFactory, imageRequest.fetcherFactory) && Intrinsics.areEqual(this.decoderFactory, imageRequest.decoderFactory) && Intrinsics.areEqual(this.interceptorCoroutineContext, imageRequest.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, imageRequest.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, imageRequest.decoderCoroutineContext) && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.placeholderMemoryCacheKey, imageRequest.placeholderMemoryCacheKey) && Intrinsics.areEqual(this.placeholderFactory, imageRequest.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, imageRequest.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, imageRequest.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && this.precision == imageRequest.precision && Intrinsics.areEqual(this.extras, imageRequest.extras) && Intrinsics.areEqual(this.defined, imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults);
    }

    public int hashCode() {
        int iHashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target = this.target;
        int iHashCode2 = (iHashCode + (target == null ? 0 : target.hashCode())) * 31;
        Listener listener = this.listener;
        int iHashCode3 = (iHashCode2 + (listener == null ? 0 : listener.hashCode())) * 31;
        String str = this.memoryCacheKey;
        int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.memoryCacheKeyExtras.hashCode()) * 31;
        String str2 = this.diskCacheKey;
        int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.fileSystem.hashCode()) * 31;
        Pair pair = this.fetcherFactory;
        int iHashCode6 = (iHashCode5 + (pair == null ? 0 : pair.hashCode())) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int iHashCode7 = (((((((((((((iHashCode6 + (factory == null ? 0 : factory.hashCode())) * 31) + this.interceptorCoroutineContext.hashCode()) * 31) + this.fetcherCoroutineContext.hashCode()) * 31) + this.decoderCoroutineContext.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31;
        MemoryCache.Key key = this.placeholderMemoryCacheKey;
        return ((((((((((((((((((iHashCode7 + (key != null ? key.hashCode() : 0)) * 31) + this.placeholderFactory.hashCode()) * 31) + this.errorFactory.hashCode()) * 31) + this.fallbackFactory.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.extras.hashCode()) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    @JvmOverloads
    @NotNull
    public final Builder newBuilder() {
        return newBuilder$default(this, null, 1, null);
    }

    @NotNull
    public String toString() {
        return "ImageRequest(context=" + this.context + ", data=" + this.data + ", target=" + this.target + ", listener=" + this.listener + ", memoryCacheKey=" + this.memoryCacheKey + ", memoryCacheKeyExtras=" + this.memoryCacheKeyExtras + ", diskCacheKey=" + this.diskCacheKey + ", fileSystem=" + this.fileSystem + ", fetcherFactory=" + this.fetcherFactory + ", decoderFactory=" + this.decoderFactory + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderMemoryCacheKey=" + this.placeholderMemoryCacheKey + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ", extras=" + this.extras + ", defined=" + this.defined + ", defaults=" + this.defaults + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private ImageRequest(Context context, Object obj, Target target, Listener listener, String str, Map map, String str2, FileSystem fileSystem, Pair pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1 function1, Function1 function2, Function1 function3, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.listener = listener;
        this.memoryCacheKey = str;
        this.memoryCacheKeyExtras = map;
        this.diskCacheKey = str2;
        this.fileSystem = fileSystem;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.interceptorCoroutineContext = coroutineContext;
        this.fetcherCoroutineContext = coroutineContext2;
        this.decoderCoroutineContext = coroutineContext3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderMemoryCacheKey = key;
        this.placeholderFactory = function1;
        this.errorFactory = function2;
        this.fallbackFactory = function3;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.precision = precision;
        this.extras = extras;
        this.defined = defined;
        this.defaults = defaults;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final Target getTarget() {
        return this.target;
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    @Nullable
    public final String getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    @NotNull
    public final Map<String, String> getMemoryCacheKeyExtras() {
        return this.memoryCacheKeyExtras;
    }

    @Nullable
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    @NotNull
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Nullable
    public final Pair<Fetcher.Factory<?>, KClass<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    @Nullable
    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    @NotNull
    public final CoroutineContext getInterceptorCoroutineContext() {
        return this.interceptorCoroutineContext;
    }

    @NotNull
    public final CoroutineContext getFetcherCoroutineContext() {
        return this.fetcherCoroutineContext;
    }

    @NotNull
    public final CoroutineContext getDecoderCoroutineContext() {
        return this.decoderCoroutineContext;
    }

    @NotNull
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    @NotNull
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    @NotNull
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    @Nullable
    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    @NotNull
    public final Function1<ImageRequest, Image> getPlaceholderFactory() {
        return this.placeholderFactory;
    }

    @NotNull
    public final Function1<ImageRequest, Image> getErrorFactory() {
        return this.errorFactory;
    }

    @NotNull
    public final Function1<ImageRequest, Image> getFallbackFactory() {
        return this.fallbackFactory;
    }

    @NotNull
    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    @NotNull
    public final Precision getPrecision() {
        return this.precision;
    }

    @NotNull
    public final Extras getExtras() {
        return this.extras;
    }

    @NotNull
    public final Defined getDefined() {
        return this.defined;
    }

    @NotNull
    public final Defaults getDefaults() {
        return this.defaults;
    }

    @Nullable
    public final Image placeholder() {
        Image image = (Image) this.placeholderFactory.invoke(this);
        return image == null ? this.defaults.getPlaceholderFactory().invoke(this) : image;
    }

    @Nullable
    public final Image error() {
        Image image = (Image) this.errorFactory.invoke(this);
        return image == null ? this.defaults.getErrorFactory().invoke(this) : image;
    }

    @Nullable
    public final Image fallback() {
        Image image = (Image) this.fallbackFactory.invoke(this);
        return image == null ? this.defaults.getFallbackFactory().invoke(this) : image;
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = imageRequest.context;
        }
        return imageRequest.newBuilder(context);
    }

    @JvmOverloads
    @NotNull
    public final Builder newBuilder(@NotNull Context context) {
        return new Builder(this, context);
    }

    @Metadata(m1835d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B³\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019JÌ\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006/"}, m1836d2 = {"Lcoil3/request/ImageRequest$Defined;", "", "fileSystem", "Lokio/FileSystem;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "<init>", "(Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;)V", "getFileSystem", "()Lokio/FileSystem;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "copy", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Defined {
        private final CoroutineContext decoderCoroutineContext;
        private final CachePolicy diskCachePolicy;
        private final Function1 errorFactory;
        private final Function1 fallbackFactory;
        private final CoroutineContext fetcherCoroutineContext;
        private final FileSystem fileSystem;
        private final CoroutineContext interceptorCoroutineContext;
        private final CachePolicy memoryCachePolicy;
        private final CachePolicy networkCachePolicy;
        private final Function1 placeholderFactory;
        private final Precision precision;
        private final Scale scale;
        private final SizeResolver sizeResolver;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defined)) {
                return false;
            }
            Defined defined = (Defined) obj;
            return Intrinsics.areEqual(this.fileSystem, defined.fileSystem) && Intrinsics.areEqual(this.interceptorCoroutineContext, defined.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, defined.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, defined.decoderCoroutineContext) && this.memoryCachePolicy == defined.memoryCachePolicy && this.diskCachePolicy == defined.diskCachePolicy && this.networkCachePolicy == defined.networkCachePolicy && Intrinsics.areEqual(this.placeholderFactory, defined.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, defined.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, defined.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, defined.sizeResolver) && this.scale == defined.scale && this.precision == defined.precision;
        }

        public int hashCode() {
            FileSystem fileSystem = this.fileSystem;
            int iHashCode = (fileSystem == null ? 0 : fileSystem.hashCode()) * 31;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            int iHashCode2 = (iHashCode + (coroutineContext == null ? 0 : coroutineContext.hashCode())) * 31;
            CoroutineContext coroutineContext2 = this.fetcherCoroutineContext;
            int iHashCode3 = (iHashCode2 + (coroutineContext2 == null ? 0 : coroutineContext2.hashCode())) * 31;
            CoroutineContext coroutineContext3 = this.decoderCoroutineContext;
            int iHashCode4 = (iHashCode3 + (coroutineContext3 == null ? 0 : coroutineContext3.hashCode())) * 31;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            int iHashCode5 = (iHashCode4 + (cachePolicy == null ? 0 : cachePolicy.hashCode())) * 31;
            CachePolicy cachePolicy2 = this.diskCachePolicy;
            int iHashCode6 = (iHashCode5 + (cachePolicy2 == null ? 0 : cachePolicy2.hashCode())) * 31;
            CachePolicy cachePolicy3 = this.networkCachePolicy;
            int iHashCode7 = (iHashCode6 + (cachePolicy3 == null ? 0 : cachePolicy3.hashCode())) * 31;
            Function1 function1 = this.placeholderFactory;
            int iHashCode8 = (iHashCode7 + (function1 == null ? 0 : function1.hashCode())) * 31;
            Function1 function2 = this.errorFactory;
            int iHashCode9 = (iHashCode8 + (function2 == null ? 0 : function2.hashCode())) * 31;
            Function1 function3 = this.fallbackFactory;
            int iHashCode10 = (iHashCode9 + (function3 == null ? 0 : function3.hashCode())) * 31;
            SizeResolver sizeResolver = this.sizeResolver;
            int iHashCode11 = (iHashCode10 + (sizeResolver == null ? 0 : sizeResolver.hashCode())) * 31;
            Scale scale = this.scale;
            int iHashCode12 = (iHashCode11 + (scale == null ? 0 : scale.hashCode())) * 31;
            Precision precision = this.precision;
            return iHashCode12 + (precision != null ? precision.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Defined(fileSystem=" + this.fileSystem + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Defined(@Nullable FileSystem fileSystem, @Nullable CoroutineContext coroutineContext, @Nullable CoroutineContext coroutineContext2, @Nullable CoroutineContext coroutineContext3, @Nullable CachePolicy cachePolicy, @Nullable CachePolicy cachePolicy2, @Nullable CachePolicy cachePolicy3, @Nullable Function1<? super ImageRequest, ? extends Image> function1, @Nullable Function1<? super ImageRequest, ? extends Image> function2, @Nullable Function1<? super ImageRequest, ? extends Image> function3, @Nullable SizeResolver sizeResolver, @Nullable Scale scale, @Nullable Precision precision) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function2;
            this.fallbackFactory = function3;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
        }

        @Nullable
        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        @Nullable
        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        @Nullable
        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        @Nullable
        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        @Nullable
        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        @Nullable
        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        @Nullable
        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        @Nullable
        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        @Nullable
        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        @Nullable
        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        @Nullable
        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        @Nullable
        public final Scale getScale() {
            return this.scale;
        }

        @Nullable
        public final Precision getPrecision() {
            return this.precision;
        }

        @NotNull
        public final Defined copy(@Nullable FileSystem fileSystem, @Nullable CoroutineContext interceptorCoroutineContext, @Nullable CoroutineContext fetcherCoroutineContext, @Nullable CoroutineContext decoderCoroutineContext, @Nullable CachePolicy memoryCachePolicy, @Nullable CachePolicy diskCachePolicy, @Nullable CachePolicy networkCachePolicy, @Nullable Function1<? super ImageRequest, ? extends Image> placeholderFactory, @Nullable Function1<? super ImageRequest, ? extends Image> errorFactory, @Nullable Function1<? super ImageRequest, ? extends Image> fallbackFactory, @Nullable SizeResolver sizeResolver, @Nullable Scale scale, @Nullable Precision precision) {
            return new Defined(fileSystem, interceptorCoroutineContext, fetcherCoroutineContext, decoderCoroutineContext, memoryCachePolicy, diskCachePolicy, networkCachePolicy, placeholderFactory, errorFactory, fallbackFactory, sizeResolver, scale, precision);
        }
    }

    @Metadata(m1835d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 32\u00020\u0001:\u00013B½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ¼\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019Jª\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00064"}, m1836d2 = {"Lcoil3/request/ImageRequest$Defaults;", "", "fileSystem", "Lokio/FileSystem;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "extras", "Lcoil3/Extras;", "<init>", "(Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;Lcoil3/Extras;)V", "getFileSystem", "()Lokio/FileSystem;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getExtras", "()Lcoil3/Extras;", "copy", "Companion", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Defaults {

        @JvmField
        @NotNull
        public static final Defaults DEFAULT = new Defaults(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        private final CoroutineContext decoderCoroutineContext;
        private final CachePolicy diskCachePolicy;
        private final Function1 errorFactory;
        private final Extras extras;
        private final Function1 fallbackFactory;
        private final CoroutineContext fetcherCoroutineContext;
        private final FileSystem fileSystem;
        private final CoroutineContext interceptorCoroutineContext;
        private final CachePolicy memoryCachePolicy;
        private final CachePolicy networkCachePolicy;
        private final Function1 placeholderFactory;
        private final Precision precision;
        private final Scale scale;
        private final SizeResolver sizeResolver;

        public Defaults() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defaults)) {
                return false;
            }
            Defaults defaults = (Defaults) obj;
            return Intrinsics.areEqual(this.fileSystem, defaults.fileSystem) && Intrinsics.areEqual(this.interceptorCoroutineContext, defaults.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, defaults.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, defaults.decoderCoroutineContext) && this.memoryCachePolicy == defaults.memoryCachePolicy && this.diskCachePolicy == defaults.diskCachePolicy && this.networkCachePolicy == defaults.networkCachePolicy && Intrinsics.areEqual(this.placeholderFactory, defaults.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, defaults.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, defaults.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, defaults.sizeResolver) && this.scale == defaults.scale && this.precision == defaults.precision && Intrinsics.areEqual(this.extras, defaults.extras);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.fileSystem.hashCode() * 31) + this.interceptorCoroutineContext.hashCode()) * 31) + this.fetcherCoroutineContext.hashCode()) * 31) + this.decoderCoroutineContext.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.placeholderFactory.hashCode()) * 31) + this.errorFactory.hashCode()) * 31) + this.fallbackFactory.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.extras.hashCode();
        }

        @NotNull
        public String toString() {
            return "Defaults(fileSystem=" + this.fileSystem + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ", extras=" + this.extras + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Defaults(@NotNull FileSystem fileSystem, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2, @NotNull CoroutineContext coroutineContext3, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3, @NotNull Function1<? super ImageRequest, ? extends Image> function1, @NotNull Function1<? super ImageRequest, ? extends Image> function2, @NotNull Function1<? super ImageRequest, ? extends Image> function3, @NotNull SizeResolver sizeResolver, @NotNull Scale scale, @NotNull Precision precision, @NotNull Extras extras) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function2;
            this.fallbackFactory = function3;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
            this.extras = extras;
        }

        public /* synthetic */ Defaults(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function2, Function1 function3, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? FileSystems_nonJsCommonKt.defaultFileSystem() : fileSystem, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i & 4) != 0 ? Coroutines_nonJsCommonKt.ioCoroutineDispatcher() : coroutineContext2, (i & 8) != 0 ? Coroutines_nonJsCommonKt.ioCoroutineDispatcher() : coroutineContext3, (i & 16) != 0 ? CachePolicy.ENABLED : cachePolicy, (i & 32) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i & 64) != 0 ? CachePolicy.ENABLED : cachePolicy3, (i & 128) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function1, (i & 256) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function2, (i & 512) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function3, (i & 1024) != 0 ? SizeResolver.ORIGINAL : sizeResolver, (i & 2048) != 0 ? Scale.FIT : scale, (i & 4096) != 0 ? Precision.EXACT : precision, (i & 8192) != 0 ? Extras.EMPTY : extras);
        }

        @NotNull
        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        @NotNull
        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        @NotNull
        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        @NotNull
        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        @NotNull
        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        @NotNull
        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        @NotNull
        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        @NotNull
        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        @NotNull
        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        @NotNull
        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        @NotNull
        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        @NotNull
        public final Scale getScale() {
            return this.scale;
        }

        @NotNull
        public final Precision getPrecision() {
            return this.precision;
        }

        @NotNull
        public final Extras getExtras() {
            return this.extras;
        }

        @NotNull
        public final Defaults copy(@NotNull FileSystem fileSystem, @NotNull CoroutineContext interceptorCoroutineContext, @NotNull CoroutineContext fetcherCoroutineContext, @NotNull CoroutineContext decoderCoroutineContext, @NotNull CachePolicy memoryCachePolicy, @NotNull CachePolicy diskCachePolicy, @NotNull CachePolicy networkCachePolicy, @NotNull Function1<? super ImageRequest, ? extends Image> placeholderFactory, @NotNull Function1<? super ImageRequest, ? extends Image> errorFactory, @NotNull Function1<? super ImageRequest, ? extends Image> fallbackFactory, @NotNull SizeResolver sizeResolver, @NotNull Scale scale, @NotNull Precision precision, @NotNull Extras extras) {
            return new Defaults(fileSystem, interceptorCoroutineContext, fetcherCoroutineContext, decoderCoroutineContext, memoryCachePolicy, diskCachePolicy, networkCachePolicy, placeholderFactory, errorFactory, fallbackFactory, sizeResolver, scale, precision, extras);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public final /* synthetic */ Defaults copy(FileSystem fileSystem, CoroutineContext interceptorCoroutineContext, CoroutineContext fetcherCoroutineContext, CoroutineContext decoderCoroutineContext, CachePolicy memoryCachePolicy, CachePolicy diskCachePolicy, CachePolicy networkCachePolicy, Function1 placeholderFactory, Function1 errorFactory, Function1 fallbackFactory, Precision precision, Extras extras) {
            return new Defaults(fileSystem, interceptorCoroutineContext, fetcherCoroutineContext, decoderCoroutineContext, memoryCachePolicy, diskCachePolicy, networkCachePolicy, placeholderFactory, errorFactory, fallbackFactory, null, null, precision, extras, 3072, null);
        }
    }

    @Metadata(m1835d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001f\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0001J|\u0010\u000e\u001a\u00020\u00002%\b\u0006\u0010>\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020B0/2%\b\u0006\u0010C\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020B0/2#\b\u0006\u0010E\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0/H\u0086\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010-J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130HJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u00132\b\u0010J\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJÇ\u0001\u0010\u0010\u001a\u00020\u00002#\b\u0006\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020B0/2#\b\u0006\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020B0/28\b\u0006\u0010C\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110M¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0L28\b\u0006\u0010E\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110N¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0LH\u0086\bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020QJ\u0016\u0010P\u001a\u00020\u00002\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QJ\u0016\u0010P\u001a\u00020\u00002\u0006\u0010R\u001a\u00020T2\u0006\u0010S\u001a\u00020TJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020UJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010V\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u000208J#\u0010\u001e\u001a\u00020\u0000\"\n\b\u0000\u0010W\u0018\u0001*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0 H\u0086\bJ,\u0010\u001e\u001a\u00020\u0000\"\b\b\u0000\u0010W*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0 2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0!J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010X\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u0010\u0010,\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u0010\u0010,\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010-J\u0010\u0010A\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010A\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u0010\u0010D\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010D\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u0010\u0010\\\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010\\\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010]\u001a\u00020\bR\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006^"}, m1836d2 = {"Lcoil3/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "<init>", "(Landroid/content/Context;)V", "request", "Lcoil3/request/ImageRequest;", "(Lcoil3/request/ImageRequest;Landroid/content/Context;)V", "Landroid/content/Context;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "data", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil3/request/ImageRequest$Listener;", "memoryCacheKey", "", "memoryCacheKeyExtrasAreMutable", "", "lazyMemoryCacheKeyExtras", "memoryCacheKeyExtras", "", "getMemoryCacheKeyExtras", "()Ljava/util/Map;", "diskCacheKey", "fileSystem", "Lokio/FileSystem;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "decoderFactory", "Lcoil3/decode/Decoder$Factory;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderMemoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "lazyExtras", "extras", "Lcoil3/Extras$Builder;", "getExtras", "()Lcoil3/Extras$Builder;", "onStart", "Lkotlin/ParameterName;", "name", ReactTextInputShadowNode.PROP_PLACEHOLDER, "", "onError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "onSuccess", "result", "key", "", "memoryCacheKeyExtra", "value", "onCancel", "Lkotlin/Function2;", "Lcoil3/request/ErrorResult;", "Lcoil3/request/SuccessResult;", "coroutineContext", TCEventPropertiesNames.TCP_SIZE, "", "width", "height", "Lcoil3/size/Dimension;", "Lcoil3/size/Size;", "resolver", ExifInterface.GPS_DIRECTION_TRUE, "factory", "type", "policy", MimeTypes.BASE_TYPE_IMAGE, "fallback", "build", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nImageRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageRequest.kt\ncoil3/request/ImageRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,749:1\n1#2:750\n*E\n"})
    public static final class Builder {
        private final Context context;
        private Object data;
        private CoroutineContext decoderCoroutineContext;
        private Decoder.Factory decoderFactory;
        private Defaults defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Function1 errorFactory;
        private Function1 fallbackFactory;
        private CoroutineContext fetcherCoroutineContext;
        private Pair fetcherFactory;
        private FileSystem fileSystem;
        private CoroutineContext interceptorCoroutineContext;
        private Object lazyExtras;
        private Object lazyMemoryCacheKeyExtras;
        private Listener listener;
        private String memoryCacheKey;
        private boolean memoryCacheKeyExtrasAreMutable;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Function1 placeholderFactory;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Precision precision;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Target target;

        @JvmOverloads
        public Builder(@NotNull ImageRequest imageRequest) {
            this(imageRequest, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image error$lambda$27(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image fallback$lambda$29(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image placeholder$lambda$25(Image image, ImageRequest imageRequest) {
            return image;
        }

        private final Map getMemoryCacheKeyExtras() {
            Object mutableMap = this.lazyMemoryCacheKeyExtras;
            if (!Intrinsics.areEqual(mutableMap, Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                if (mutableMap instanceof Map) {
                    mutableMap = MapsKt.toMutableMap((Map) mutableMap);
                    this.lazyMemoryCacheKeyExtras = mutableMap;
                    this.memoryCacheKeyExtrasAreMutable = true;
                } else {
                    throw new AssertionError();
                }
            }
            Intrinsics.checkNotNull(mutableMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            return TypeIntrinsics.asMutableMap(mutableMap);
        }

        @NotNull
        public final Extras.Builder getExtras() {
            Object obj = this.lazyExtras;
            if (obj instanceof Extras.Builder) {
                return (Extras.Builder) obj;
            }
            if (!(obj instanceof Extras)) {
                throw new AssertionError();
            }
            Extras.Builder builderNewBuilder = ((Extras) obj).newBuilder();
            this.lazyExtras = builderNewBuilder;
            return builderNewBuilder;
        }

        public Builder(@NotNull Context context) {
            this.context = context;
            this.defaults = Defaults.DEFAULT;
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.lazyMemoryCacheKeyExtras = MapsKt.emptyMap();
            this.diskCacheKey = null;
            this.fileSystem = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.interceptorCoroutineContext = null;
            this.fetcherCoroutineContext = null;
            this.decoderCoroutineContext = null;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.errorFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.fallbackFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.sizeResolver = null;
            this.scale = null;
            this.precision = null;
            this.lazyExtras = Extras.EMPTY;
        }

        @JvmOverloads
        public Builder(@NotNull ImageRequest imageRequest, @NotNull Context context) {
            this.context = context;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.lazyMemoryCacheKeyExtras = imageRequest.getMemoryCacheKeyExtras();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.fileSystem = imageRequest.getDefined().getFileSystem();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.interceptorCoroutineContext = imageRequest.getDefined().getInterceptorCoroutineContext();
            this.fetcherCoroutineContext = imageRequest.getDefined().getFetcherCoroutineContext();
            this.decoderCoroutineContext = imageRequest.getDefined().getDecoderCoroutineContext();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderFactory = imageRequest.getDefined().getPlaceholderFactory();
            this.errorFactory = imageRequest.getDefined().getErrorFactory();
            this.fallbackFactory = imageRequest.getDefined().getFallbackFactory();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            this.precision = imageRequest.getDefined().getPrecision();
            this.lazyExtras = imageRequest.getExtras();
        }

        public /* synthetic */ Builder(ImageRequest imageRequest, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i & 2) != 0 ? imageRequest.getContext() : context);
        }

        @NotNull
        public final Builder data(@Nullable Object data) {
            this.data = data;
            return this;
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function2, Function1 function3, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                        invoke2(image);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 2) != 0) {
                function2 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$2
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                        invoke2(image);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 4) != 0) {
                function3 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$3
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                        invoke2(image);
                        return Unit.INSTANCE;
                    }
                };
            }
            return builder.target(new ImageRequest$Builder$target$4(function1, function2, function3));
        }

        @NotNull
        public final Builder target(@NotNull Function1<? super Image, Unit> onStart, @NotNull Function1<? super Image, Unit> onError, @NotNull Function1<? super Image, Unit> onSuccess) {
            return target(new ImageRequest$Builder$target$4(onStart, onError, onSuccess));
        }

        @NotNull
        public final Builder target(@Nullable Target target) {
            this.target = target;
            return this;
        }

        @NotNull
        public final Builder memoryCacheKey(@Nullable MemoryCache.Key key) {
            memoryCacheKey(key != null ? key.getKey() : null);
            Map<String, String> extras = key != null ? key.getExtras() : null;
            if (extras == null) {
                extras = MapsKt.emptyMap();
            }
            memoryCacheKeyExtras(extras);
            return this;
        }

        @NotNull
        public final Builder memoryCacheKey(@Nullable String key) {
            this.memoryCacheKey = key;
            return this;
        }

        @NotNull
        public final Builder memoryCacheKeyExtras(@NotNull Map<String, String> extras) {
            this.lazyMemoryCacheKeyExtras = MapsKt.toMutableMap(extras);
            this.memoryCacheKeyExtrasAreMutable = true;
            return this;
        }

        @NotNull
        public final Builder memoryCacheKeyExtra(@NotNull String key, @Nullable String value) {
            if (value != null) {
                getMemoryCacheKeyExtras().put(key, value);
            } else {
                getMemoryCacheKeyExtras().remove(key);
            }
            return this;
        }

        @NotNull
        public final Builder diskCacheKey(@Nullable String key) {
            this.diskCacheKey = key;
            return this;
        }

        @NotNull
        public final Builder fileSystem(@NotNull FileSystem fileSystem) {
            this.fileSystem = fileSystem;
            return this;
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function2, Function2 function3, Function2 function4, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new Function1<ImageRequest, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest) {
                        invoke2(imageRequest);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 2) != 0) {
                function2 = new Function1<ImageRequest, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$2
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest) {
                        invoke2(imageRequest);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 4) != 0) {
                function3 = new Function2<ImageRequest, ErrorResult, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$3
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest, ErrorResult errorResult) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest, ErrorResult errorResult) {
                        invoke2(imageRequest, errorResult);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 8) != 0) {
                function4 = new Function2<ImageRequest, SuccessResult, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$4
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageRequest imageRequest, SuccessResult successResult) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ImageRequest imageRequest, SuccessResult successResult) {
                        invoke2(imageRequest, successResult);
                        return Unit.INSTANCE;
                    }
                };
            }
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function2, function3, function4));
        }

        @NotNull
        public final Builder listener(@NotNull Function1<? super ImageRequest, Unit> onStart, @NotNull Function1<? super ImageRequest, Unit> onCancel, @NotNull Function2<? super ImageRequest, ? super ErrorResult, Unit> onError, @NotNull Function2<? super ImageRequest, ? super SuccessResult, Unit> onSuccess) {
            return listener(new ImageRequest$Builder$listener$5(onStart, onCancel, onError, onSuccess));
        }

        @NotNull
        public final Builder listener(@Nullable Listener listener) {
            this.listener = listener;
            return this;
        }

        @NotNull
        public final Builder coroutineContext(@NotNull CoroutineContext context) {
            this.interceptorCoroutineContext = context;
            this.fetcherCoroutineContext = context;
            this.decoderCoroutineContext = context;
            return this;
        }

        @NotNull
        public final Builder interceptorCoroutineContext(@NotNull CoroutineContext context) {
            this.interceptorCoroutineContext = context;
            return this;
        }

        @NotNull
        public final Builder fetcherCoroutineContext(@NotNull CoroutineContext context) {
            this.fetcherCoroutineContext = context;
            return this;
        }

        @NotNull
        public final Builder decoderCoroutineContext(@NotNull CoroutineContext context) {
            this.decoderCoroutineContext = context;
            return this;
        }

        @NotNull
        public final Builder size(int size) {
            return size(SizeKt.Size(size, size));
        }

        @NotNull
        public final Builder size(int width, int height) {
            return size(SizeKt.Size(width, height));
        }

        @NotNull
        public final Builder size(@NotNull Dimension width, @NotNull Dimension height) {
            return size(new Size(width, height));
        }

        @NotNull
        public final Builder size(@NotNull Size size) {
            return size(SizeResolverKt.SizeResolver(size));
        }

        @NotNull
        public final Builder size(@NotNull SizeResolver resolver) {
            this.sizeResolver = resolver;
            return this;
        }

        @NotNull
        public final Builder scale(@NotNull Scale scale) {
            this.scale = scale;
            return this;
        }

        @NotNull
        public final Builder precision(@NotNull Precision precision) {
            this.precision = precision;
            return this;
        }

        public final /* synthetic */ <T> Builder fetcherFactory(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return fetcherFactory(factory, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @NotNull
        public final <T> Builder fetcherFactory(@NotNull Fetcher.Factory<T> factory, @NotNull KClass<T> type) {
            this.fetcherFactory = TuplesKt.m1842to(factory, type);
            return this;
        }

        @NotNull
        public final Builder decoderFactory(@NotNull Decoder.Factory factory) {
            this.decoderFactory = factory;
            return this;
        }

        @NotNull
        public final Builder memoryCachePolicy(@NotNull CachePolicy policy) {
            this.memoryCachePolicy = policy;
            return this;
        }

        @NotNull
        public final Builder diskCachePolicy(@NotNull CachePolicy policy) {
            this.diskCachePolicy = policy;
            return this;
        }

        @NotNull
        public final Builder networkCachePolicy(@NotNull CachePolicy policy) {
            this.networkCachePolicy = policy;
            return this;
        }

        @NotNull
        public final Builder placeholderMemoryCacheKey(@Nullable String key) {
            MemoryCache.Key key2 = null;
            byte b = 0;
            byte b2 = 0;
            if (key != null) {
                key2 = new MemoryCache.Key(key, b2 == true ? 1 : 0, 2, b == true ? 1 : 0);
            }
            return placeholderMemoryCacheKey(key2);
        }

        @NotNull
        public final Builder placeholderMemoryCacheKey(@Nullable MemoryCache.Key key) {
            this.placeholderMemoryCacheKey = key;
            return this;
        }

        @NotNull
        public final Builder placeholder(@Nullable final Image image) {
            return placeholder(new Function1() { // from class: coil3.request.ImageRequest$Builder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ImageRequest.Builder.placeholder$lambda$25(image, (ImageRequest) obj);
                }
            });
        }

        @NotNull
        public final Builder placeholder(@NotNull Function1<? super ImageRequest, ? extends Image> factory) {
            this.placeholderFactory = factory;
            return this;
        }

        @NotNull
        public final Builder error(@Nullable final Image image) {
            return error(new Function1() { // from class: coil3.request.ImageRequest$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ImageRequest.Builder.error$lambda$27(image, (ImageRequest) obj);
                }
            });
        }

        @NotNull
        public final Builder error(@NotNull Function1<? super ImageRequest, ? extends Image> factory) {
            this.errorFactory = factory;
            return this;
        }

        @NotNull
        public final Builder fallback(@Nullable final Image image) {
            return fallback(new Function1() { // from class: coil3.request.ImageRequest$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ImageRequest.Builder.fallback$lambda$29(image, (ImageRequest) obj);
                }
            });
        }

        @NotNull
        public final Builder fallback(@NotNull Function1<? super ImageRequest, ? extends Image> factory) {
            this.fallbackFactory = factory;
            return this;
        }

        @NotNull
        public final Builder defaults(@NotNull Defaults defaults) {
            this.defaults = defaults;
            return this;
        }

        @NotNull
        public final ImageRequest build() {
            Map immutableMap;
            Extras extrasBuild;
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Listener listener = this.listener;
            String str = this.memoryCacheKey;
            Object obj3 = this.lazyMemoryCacheKeyExtras;
            if (Intrinsics.areEqual(obj3, Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
                immutableMap = Collections_jvmCommonKt.toImmutableMap(TypeIntrinsics.asMutableMap(obj3));
            } else {
                if (!(obj3 instanceof Map)) {
                    throw new AssertionError();
                }
                immutableMap = (Map) obj3;
            }
            Map map = immutableMap;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            String str2 = this.diskCacheKey;
            FileSystem fileSystem = this.fileSystem;
            if (fileSystem == null) {
                fileSystem = this.defaults.getFileSystem();
            }
            FileSystem fileSystem2 = fileSystem;
            Pair pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            CachePolicy memoryCachePolicy = this.memoryCachePolicy;
            if (memoryCachePolicy == null) {
                memoryCachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy = memoryCachePolicy;
            CachePolicy diskCachePolicy = this.diskCachePolicy;
            if (diskCachePolicy == null) {
                diskCachePolicy = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy2 = diskCachePolicy;
            CachePolicy networkCachePolicy = this.networkCachePolicy;
            if (networkCachePolicy == null) {
                networkCachePolicy = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy3 = networkCachePolicy;
            CoroutineContext interceptorCoroutineContext = this.interceptorCoroutineContext;
            if (interceptorCoroutineContext == null) {
                interceptorCoroutineContext = this.defaults.getInterceptorCoroutineContext();
            }
            CoroutineContext coroutineContext = interceptorCoroutineContext;
            CoroutineContext fetcherCoroutineContext = this.fetcherCoroutineContext;
            if (fetcherCoroutineContext == null) {
                fetcherCoroutineContext = this.defaults.getFetcherCoroutineContext();
            }
            CoroutineContext coroutineContext2 = fetcherCoroutineContext;
            CoroutineContext decoderCoroutineContext = this.decoderCoroutineContext;
            if (decoderCoroutineContext == null) {
                decoderCoroutineContext = this.defaults.getDecoderCoroutineContext();
            }
            CoroutineContext coroutineContext3 = decoderCoroutineContext;
            MemoryCache.Key key = this.placeholderMemoryCacheKey;
            Function1<ImageRequest, Image> placeholderFactory = this.placeholderFactory;
            if (placeholderFactory == null) {
                placeholderFactory = this.defaults.getPlaceholderFactory();
            }
            Function1<ImageRequest, Image> function1 = placeholderFactory;
            Function1<ImageRequest, Image> errorFactory = this.errorFactory;
            if (errorFactory == null) {
                errorFactory = this.defaults.getErrorFactory();
            }
            Function1<ImageRequest, Image> function2 = errorFactory;
            Function1<ImageRequest, Image> fallbackFactory = this.fallbackFactory;
            if (fallbackFactory == null) {
                fallbackFactory = this.defaults.getFallbackFactory();
            }
            Function1<ImageRequest, Image> function3 = fallbackFactory;
            SizeResolver sizeResolver = this.sizeResolver;
            if (sizeResolver == null) {
                sizeResolver = this.defaults.getSizeResolver();
            }
            SizeResolver sizeResolver2 = sizeResolver;
            Scale scale = this.scale;
            if (scale == null) {
                scale = this.defaults.getScale();
            }
            Scale scale2 = scale;
            Precision precision = this.precision;
            if (precision == null) {
                precision = this.defaults.getPrecision();
            }
            Precision precision2 = precision;
            Object obj4 = this.lazyExtras;
            if (obj4 instanceof Extras.Builder) {
                extrasBuild = ((Extras.Builder) obj4).build();
            } else {
                if (!(obj4 instanceof Extras)) {
                    throw new AssertionError();
                }
                extrasBuild = (Extras) obj4;
            }
            return new ImageRequest(context, obj2, target, listener, str, map, str2, fileSystem2, pair, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, key, function1, function2, function3, sizeResolver2, scale2, precision2, extrasBuild, new Defined(this.fileSystem, this.interceptorCoroutineContext, this.fetcherCoroutineContext, this.decoderCoroutineContext, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy, this.placeholderFactory, this.errorFactory, this.fallbackFactory, this.sizeResolver, this.scale, this.precision), this.defaults, null);
        }
    }
}
