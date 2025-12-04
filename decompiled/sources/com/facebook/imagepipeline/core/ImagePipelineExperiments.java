package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 [2\u00020\u0001:\u0004XYZ[B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u0011\u0010\"\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010$\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0011\u0010%\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070+¢\u0006\b\n\u0000\u001a\u0004\b*\u0010,R\u0011\u0010-\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\bR\u0011\u0010.\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070+¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u00102\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u0011\u00109\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u0011\u0010;\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u0011\u0010<\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\bR\u0011\u0010=\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\bR\u0011\u0010>\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0011\u0010?\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001bR\u0011\u0010A\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\bR\u0011\u0010C\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u0011\u0010E\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\bR\u0011\u0010G\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\bR\u0011\u0010I\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u0011\u0010K\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\bR\u0011\u0010M\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\bR\u0011\u0010O\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001bR\u0011\u0010Q\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\bR\u0011\u0010S\u001a\u00020T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010W\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\b¨\u0006\\"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;)V", "isWebpSupportEnabled", "", "()Z", "webpErrorLogger", "Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "getWebpErrorLogger", "()Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "isDecodeCancellationEnabled", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "getWebpBitmapFactory", "()Lcom/facebook/common/webp/WebpBitmapFactory;", "useDownsamplingRatioForResizing", "getUseDownsamplingRatioForResizing", "useBitmapPrepareToDraw", "getUseBitmapPrepareToDraw", "useBalancedAnimationStrategy", "getUseBalancedAnimationStrategy", "animationStrategyBufferLengthMilliseconds", "", "getAnimationStrategyBufferLengthMilliseconds", "()I", "bitmapPrepareToDrawMinSizeBytes", "getBitmapPrepareToDrawMinSizeBytes", "bitmapPrepareToDrawMaxSizeBytes", "getBitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "getBitmapPrepareToDrawForPrefetch", "maxBitmapDimension", "getMaxBitmapDimension", "isNativeCodeDisabled", "isPartialImageCachingEnabled", "producerFactoryMethod", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "getProducerFactoryMethod", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "isLazyDataSource", "Lcom/facebook/common/internal/Supplier;", "()Lcom/facebook/common/internal/Supplier;", "isGingerbreadDecoderEnabled", "downscaleFrameToDrawableDimensions", "getDownscaleFrameToDrawableDimensions", "suppressBitmapPrefetchingSupplier", "getSuppressBitmapPrefetchingSupplier", "isExperimentalThreadHandoffQueueEnabled", "memoryType", "", "getMemoryType", "()J", "keepCancelledFetchAsLowPriority", "getKeepCancelledFetchAsLowPriority", "downsampleIfLargeBitmap", "getDownsampleIfLargeBitmap", "isEncodedCacheEnabled", "isEnsureTranscoderLibraryLoaded", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "trackedKeysSize", "getTrackedKeysSize", "allowDelay", "getAllowDelay", "handOffOnUiThreadOnly", "getHandOffOnUiThreadOnly", "shouldStoreCacheEntrySize", "getShouldStoreCacheEntrySize", "shouldIgnoreCacheSizeMismatch", "getShouldIgnoreCacheSizeMismatch", "shouldUseDecodingBufferHelper", "getShouldUseDecodingBufferHelper", "allowProgressiveOnPrefetch", "getAllowProgressiveOnPrefetch", "cancelDecodeOnCacheMiss", "getCancelDecodeOnCacheMiss", "animationRenderFpsLimit", "getAnimationRenderFpsLimit", "prefetchShortcutEnabled", "getPrefetchShortcutEnabled", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "getPlatformDecoderOptions", "()Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "isBinaryXmlEnabled", "Builder", "ProducerFactoryMethod", "DefaultProducerFactoryMethod", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImagePipelineExperiments {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowDelay;
    private final boolean allowProgressiveOnPrefetch;
    private final int animationRenderFpsLimit;
    private final int animationStrategyBufferLengthMilliseconds;
    private final boolean bitmapPrepareToDrawForPrefetch;
    private final int bitmapPrepareToDrawMaxSizeBytes;
    private final int bitmapPrepareToDrawMinSizeBytes;
    private final boolean cancelDecodeOnCacheMiss;
    private final boolean downsampleIfLargeBitmap;
    private final boolean downscaleFrameToDrawableDimensions;
    private final boolean handOffOnUiThreadOnly;
    private final boolean isBinaryXmlEnabled;
    private final boolean isDecodeCancellationEnabled;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedCacheEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;
    private final boolean isEnsureTranscoderLibraryLoaded;
    private final boolean isExperimentalThreadHandoffQueueEnabled;
    private final boolean isGingerbreadDecoderEnabled;
    private final Supplier isLazyDataSource;
    private final boolean isNativeCodeDisabled;
    private final boolean isPartialImageCachingEnabled;
    private final boolean isWebpSupportEnabled;
    private final boolean keepCancelledFetchAsLowPriority;
    private final int maxBitmapDimension;
    private final long memoryType;
    private final PlatformDecoderOptions platformDecoderOptions;
    private final boolean prefetchShortcutEnabled;
    private final ProducerFactoryMethod producerFactoryMethod;
    private final boolean shouldIgnoreCacheSizeMismatch;
    private final boolean shouldStoreCacheEntrySize;
    private final boolean shouldUseDecodingBufferHelper;
    private final Supplier suppressBitmapPrefetchingSupplier;
    private final int trackedKeysSize;
    private final boolean useBalancedAnimationStrategy;
    private final boolean useBitmapPrepareToDraw;
    private final boolean useDownsamplingRatioForResizing;
    private final WebpBitmapFactory webpBitmapFactory;
    private final WebpBitmapFactory.WebpErrorLogger webpErrorLogger;

    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JÞ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020%H&¨\u0006-"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "", "createProducerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", "context", "Landroid/content/Context;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "resizeAndRotateEnabledForNetwork", "", "decodeCancellationEnabled", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ProducerFactoryMethod {
        @NotNull
        ProducerFactory createProducerFactory(@NotNull Context context, @NotNull ByteArrayPool byteArrayPool, @NotNull ImageDecoder imageDecoder, @NotNull ProgressiveJpegConfig progressiveJpegConfig, @NotNull DownsampleMode downsampleMode, boolean resizeAndRotateEnabledForNetwork, boolean decodeCancellationEnabled, @NotNull ExecutorSupplier executorSupplier, @NotNull PooledByteBufferFactory pooledByteBufferFactory, @NotNull PooledByteStreams pooledByteStreams, @NotNull MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, @NotNull MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, @NotNull Supplier<DiskCachesStore> diskCachesStoreSupplier, @NotNull CacheKeyFactory cacheKeyFactory, @NotNull PlatformBitmapFactory platformBitmapFactory, int bitmapPrepareToDrawMinSizeBytes, int bitmapPrepareToDrawMaxSizeBytes, boolean bitmapPrepareToDrawForPrefetch, int maxBitmapSize, @NotNull CloseableReferenceFactory closeableReferenceFactory, boolean keepCancelledFetchAsLowPriority, int trackedKeysSize);
    }

    public /* synthetic */ ImagePipelineExperiments(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    @NotNull
    public static final Builder newBuilder(@NotNull ImagePipelineConfig.Builder builder) {
        return INSTANCE.newBuilder(builder);
    }

    private ImagePipelineExperiments(Builder builder) {
        this.isWebpSupportEnabled = builder.webpSupportEnabled;
        this.webpErrorLogger = builder.webpErrorLogger;
        this.isDecodeCancellationEnabled = builder.decodeCancellationEnabled;
        this.webpBitmapFactory = builder.webpBitmapFactory;
        this.useDownsamplingRatioForResizing = builder.useDownsamplingRatioForResizing;
        this.useBitmapPrepareToDraw = builder.useBitmapPrepareToDraw;
        this.useBalancedAnimationStrategy = builder.useBalancedAnimationStrategy;
        this.animationStrategyBufferLengthMilliseconds = builder.animationStrategyBufferLengthMilliseconds;
        this.bitmapPrepareToDrawMinSizeBytes = builder.bitmapPrepareToDrawMinSizeBytes;
        this.bitmapPrepareToDrawMaxSizeBytes = builder.bitmapPrepareToDrawMaxSizeBytes;
        this.bitmapPrepareToDrawForPrefetch = builder.bitmapPrepareToDrawForPrefetch;
        this.maxBitmapDimension = builder.maxBitmapDimension;
        this.isNativeCodeDisabled = builder.nativeCodeDisabled;
        this.isPartialImageCachingEnabled = builder.isPartialImageCachingEnabled;
        ProducerFactoryMethod producerFactoryMethod = builder.producerFactoryMethod;
        this.producerFactoryMethod = producerFactoryMethod == null ? new DefaultProducerFactoryMethod() : producerFactoryMethod;
        Supplier<Boolean> BOOLEAN_FALSE = builder.lazyDataSource;
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.isLazyDataSource = BOOLEAN_FALSE;
        this.isGingerbreadDecoderEnabled = builder.gingerbreadDecoderEnabled;
        this.downscaleFrameToDrawableDimensions = builder.downscaleFrameToDrawableDimensions;
        this.suppressBitmapPrefetchingSupplier = builder.suppressBitmapPrefetchingSupplier;
        this.isExperimentalThreadHandoffQueueEnabled = builder.experimentalThreadHandoffQueueEnabled;
        this.memoryType = builder.memoryType;
        this.keepCancelledFetchAsLowPriority = builder.keepCancelledFetchAsLowPriority;
        this.downsampleIfLargeBitmap = builder.downsampleIfLargeBitmap;
        this.isEncodedCacheEnabled = builder.encodedCacheEnabled;
        this.isEnsureTranscoderLibraryLoaded = builder.ensureTranscoderLibraryLoaded;
        this.isEncodedMemoryCacheProbingEnabled = builder.isEncodedMemoryCacheProbingEnabled;
        this.isDiskCacheProbingEnabled = builder.isDiskCacheProbingEnabled;
        this.trackedKeysSize = builder.trackedKeysSize;
        this.allowProgressiveOnPrefetch = builder.allowProgressiveOnPrefetch;
        this.animationRenderFpsLimit = builder.animationRenderFpsLimit;
        this.allowDelay = builder.allowDelay;
        this.handOffOnUiThreadOnly = builder.handOffOnUiThreadOnly;
        this.shouldStoreCacheEntrySize = builder.shouldStoreCacheEntrySize;
        this.shouldIgnoreCacheSizeMismatch = builder.shouldIgnoreCacheSizeMismatch;
        this.shouldUseDecodingBufferHelper = builder.shouldUseDecodingBufferHelper;
        this.cancelDecodeOnCacheMiss = builder.cancelDecodeOnCacheMiss;
        this.prefetchShortcutEnabled = builder.prefetchShortcutEnabled;
        this.platformDecoderOptions = builder.platformDecoderOptions;
        this.isBinaryXmlEnabled = builder.isBinaryXmlEnabled;
    }

    /* renamed from: isWebpSupportEnabled, reason: from getter */
    public final boolean getIsWebpSupportEnabled() {
        return this.isWebpSupportEnabled;
    }

    @Nullable
    public final WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        return this.webpErrorLogger;
    }

    /* renamed from: isDecodeCancellationEnabled, reason: from getter */
    public final boolean getIsDecodeCancellationEnabled() {
        return this.isDecodeCancellationEnabled;
    }

    @Nullable
    public final WebpBitmapFactory getWebpBitmapFactory() {
        return this.webpBitmapFactory;
    }

    public final boolean getUseDownsamplingRatioForResizing() {
        return this.useDownsamplingRatioForResizing;
    }

    public final boolean getUseBitmapPrepareToDraw() {
        return this.useBitmapPrepareToDraw;
    }

    public final boolean getUseBalancedAnimationStrategy() {
        return this.useBalancedAnimationStrategy;
    }

    public final int getAnimationStrategyBufferLengthMilliseconds() {
        return this.animationStrategyBufferLengthMilliseconds;
    }

    public final int getBitmapPrepareToDrawMinSizeBytes() {
        return this.bitmapPrepareToDrawMinSizeBytes;
    }

    public final int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.bitmapPrepareToDrawMaxSizeBytes;
    }

    public final boolean getBitmapPrepareToDrawForPrefetch() {
        return this.bitmapPrepareToDrawForPrefetch;
    }

    public final int getMaxBitmapDimension() {
        return this.maxBitmapDimension;
    }

    /* renamed from: isNativeCodeDisabled, reason: from getter */
    public final boolean getIsNativeCodeDisabled() {
        return this.isNativeCodeDisabled;
    }

    /* renamed from: isPartialImageCachingEnabled, reason: from getter */
    public final boolean getIsPartialImageCachingEnabled() {
        return this.isPartialImageCachingEnabled;
    }

    @NotNull
    public final ProducerFactoryMethod getProducerFactoryMethod() {
        return this.producerFactoryMethod;
    }

    @NotNull
    public final Supplier<Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    /* renamed from: isGingerbreadDecoderEnabled, reason: from getter */
    public final boolean getIsGingerbreadDecoderEnabled() {
        return this.isGingerbreadDecoderEnabled;
    }

    public final boolean getDownscaleFrameToDrawableDimensions() {
        return this.downscaleFrameToDrawableDimensions;
    }

    @NotNull
    public final Supplier<Boolean> getSuppressBitmapPrefetchingSupplier() {
        return this.suppressBitmapPrefetchingSupplier;
    }

    /* renamed from: isExperimentalThreadHandoffQueueEnabled, reason: from getter */
    public final boolean getIsExperimentalThreadHandoffQueueEnabled() {
        return this.isExperimentalThreadHandoffQueueEnabled;
    }

    public final long getMemoryType() {
        return this.memoryType;
    }

    public final boolean getKeepCancelledFetchAsLowPriority() {
        return this.keepCancelledFetchAsLowPriority;
    }

    public final boolean getDownsampleIfLargeBitmap() {
        return this.downsampleIfLargeBitmap;
    }

    /* renamed from: isEncodedCacheEnabled, reason: from getter */
    public final boolean getIsEncodedCacheEnabled() {
        return this.isEncodedCacheEnabled;
    }

    /* renamed from: isEnsureTranscoderLibraryLoaded, reason: from getter */
    public final boolean getIsEnsureTranscoderLibraryLoaded() {
        return this.isEnsureTranscoderLibraryLoaded;
    }

    /* renamed from: isEncodedMemoryCacheProbingEnabled, reason: from getter */
    public final boolean getIsEncodedMemoryCacheProbingEnabled() {
        return this.isEncodedMemoryCacheProbingEnabled;
    }

    /* renamed from: isDiskCacheProbingEnabled, reason: from getter */
    public final boolean getIsDiskCacheProbingEnabled() {
        return this.isDiskCacheProbingEnabled;
    }

    public final int getTrackedKeysSize() {
        return this.trackedKeysSize;
    }

    public final boolean getAllowDelay() {
        return this.allowDelay;
    }

    public final boolean getHandOffOnUiThreadOnly() {
        return this.handOffOnUiThreadOnly;
    }

    public final boolean getShouldStoreCacheEntrySize() {
        return this.shouldStoreCacheEntrySize;
    }

    public final boolean getShouldIgnoreCacheSizeMismatch() {
        return this.shouldIgnoreCacheSizeMismatch;
    }

    public final boolean getShouldUseDecodingBufferHelper() {
        return this.shouldUseDecodingBufferHelper;
    }

    public final boolean getAllowProgressiveOnPrefetch() {
        return this.allowProgressiveOnPrefetch;
    }

    public final boolean getCancelDecodeOnCacheMiss() {
        return this.cancelDecodeOnCacheMiss;
    }

    public final int getAnimationRenderFpsLimit() {
        return this.animationRenderFpsLimit;
    }

    public final boolean getPrefetchShortcutEnabled() {
        return this.prefetchShortcutEnabled;
    }

    @NotNull
    public final PlatformDecoderOptions getPlatformDecoderOptions() {
        return this.platformDecoderOptions;
    }

    /* renamed from: isBinaryXmlEnabled, reason: from getter */
    public final boolean getIsBinaryXmlEnabled() {
        return this.isBinaryXmlEnabled;
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u00106\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0007J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010D\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010E\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ&\u0010F\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010N\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010O\u001a\u00020\u00002\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007J\u0014\u0010R\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020#J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0007J\u000e\u0010_\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0012J\u000e\u0010`\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0007J\u000e\u0010a\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0007J\u0006\u0010d\u001a\u00020eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00070\u00070\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "", "configBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;)V", "shouldUseDecodingBufferHelper", "", "webpSupportEnabled", "webpErrorLogger", "Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "decodeCancellationEnabled", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "useDownsamplingRatioForResizing", "useBitmapPrepareToDraw", "useBalancedAnimationStrategy", "animationStrategyBufferLengthMilliseconds", "", "bitmapPrepareToDrawMinSizeBytes", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapDimension", "nativeCodeDisabled", "isPartialImageCachingEnabled", "producerFactoryMethod", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "lazyDataSource", "Lcom/facebook/common/internal/Supplier;", "gingerbreadDecoderEnabled", "downscaleFrameToDrawableDimensions", "suppressBitmapPrefetchingSupplier", "kotlin.jvm.PlatformType", "experimentalThreadHandoffQueueEnabled", "memoryType", "", "keepCancelledFetchAsLowPriority", "downsampleIfLargeBitmap", "encodedCacheEnabled", "ensureTranscoderLibraryLoaded", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "trackedKeysSize", "allowDelay", "handOffOnUiThreadOnly", "shouldStoreCacheEntrySize", "shouldIgnoreCacheSizeMismatch", "allowProgressiveOnPrefetch", "animationRenderFpsLimit", "cancelDecodeOnCacheMiss", "prefetchShortcutEnabled", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "isBinaryXmlEnabled", "asBuilder", "block", "Lkotlin/Function0;", "", "setHandOffOnUiThreadOnly", "setStoreCacheEntrySize", "setIgnoreCacheSizeMismatch", "setWebpSupportEnabled", "setPrefetchShortcutEnabled", "setShouldUseDecodingBufferHelper", "setUseDownsampligRatioForResizing", "setPartialImageCachingEnabled", "partialImageCachingEnabled", "setDecodeCancellationEnabled", "setWebpErrorLogger", "setWebpBitmapFactory", "setBitmapPrepareToDraw", "minBitmapSizeBytes", "maxBitmapSizeBytes", "preparePrefetch", "setBalancedAnimationStrategy", "setAnimationStrategyBufferLengthMilliseconds", "setMaxBitmapDimension", "setNativeCodeDisabled", "setProducerFactoryMethod", "setLazyDataSource", "setGingerbreadDecoderEnabled", "setShouldDownscaleFrameToDrawableDimensions", "setSuppressBitmapPrefetchingSupplier", "setExperimentalThreadHandoffQueueEnabled", "setExperimentalMemoryType", "MemoryType", "setKeepCancelledFetchAsLowPriority", "setDownsampleIfLargeBitmap", "setEncodedCacheEnabled", "setEnsureTranscoderLibraryLoaded", "setIsDiskCacheProbingEnabled", "setIsEncodedMemoryCacheProbingEnabled", "setTrackedKeysSize", "setAllowDelay", "setAllowProgressiveOnPrefetch", "setAnimationRenderFpsLimit", "setCancelDecodeOnCacheMiss", "setPlatformDecoderOptions", "setBinaryXmlEnabled", "binaryXmlEnabled", "build", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        @JvmField
        public boolean allowDelay;

        @JvmField
        public boolean allowProgressiveOnPrefetch;

        @JvmField
        public int animationRenderFpsLimit;

        @JvmField
        public int animationStrategyBufferLengthMilliseconds;

        @JvmField
        public boolean bitmapPrepareToDrawForPrefetch;

        @JvmField
        public int bitmapPrepareToDrawMaxSizeBytes;

        @JvmField
        public int bitmapPrepareToDrawMinSizeBytes;

        @JvmField
        public boolean cancelDecodeOnCacheMiss;
        private final ImagePipelineConfig.Builder configBuilder;

        @JvmField
        public boolean decodeCancellationEnabled;

        @JvmField
        public boolean downsampleIfLargeBitmap;

        @JvmField
        public boolean downscaleFrameToDrawableDimensions;

        @JvmField
        public boolean encodedCacheEnabled;

        @JvmField
        public boolean ensureTranscoderLibraryLoaded;

        @JvmField
        public boolean experimentalThreadHandoffQueueEnabled;

        @JvmField
        public boolean gingerbreadDecoderEnabled;

        @JvmField
        public boolean handOffOnUiThreadOnly;

        @JvmField
        public boolean isBinaryXmlEnabled;

        @JvmField
        public boolean isDiskCacheProbingEnabled;

        @JvmField
        public boolean isEncodedMemoryCacheProbingEnabled;

        @JvmField
        public boolean isPartialImageCachingEnabled;

        @JvmField
        public boolean keepCancelledFetchAsLowPriority;

        @JvmField
        @Nullable
        public Supplier<Boolean> lazyDataSource;

        @JvmField
        public int maxBitmapDimension;

        @JvmField
        public long memoryType;

        @JvmField
        public boolean nativeCodeDisabled;

        @JvmField
        @NotNull
        public PlatformDecoderOptions platformDecoderOptions;

        @JvmField
        public boolean prefetchShortcutEnabled;

        @JvmField
        @Nullable
        public ProducerFactoryMethod producerFactoryMethod;

        @JvmField
        public boolean shouldIgnoreCacheSizeMismatch;

        @JvmField
        public boolean shouldStoreCacheEntrySize;

        @JvmField
        public boolean shouldUseDecodingBufferHelper;

        @JvmField
        @NotNull
        public Supplier<Boolean> suppressBitmapPrefetchingSupplier;

        @JvmField
        public int trackedKeysSize;

        @JvmField
        public boolean useBalancedAnimationStrategy;

        @JvmField
        public boolean useBitmapPrepareToDraw;

        @JvmField
        public boolean useDownsamplingRatioForResizing;

        @JvmField
        @Nullable
        public WebpBitmapFactory webpBitmapFactory;

        @JvmField
        @Nullable
        public WebpBitmapFactory.WebpErrorLogger webpErrorLogger;

        @JvmField
        public boolean webpSupportEnabled;

        public Builder(@NotNull ImagePipelineConfig.Builder configBuilder) {
            Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            this.configBuilder = configBuilder;
            this.animationStrategyBufferLengthMilliseconds = 1000;
            this.maxBitmapDimension = 2048;
            Supplier<Boolean> supplierOf = Suppliers.of(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(supplierOf, "of(...)");
            this.suppressBitmapPrefetchingSupplier = supplierOf;
            this.encodedCacheEnabled = true;
            this.ensureTranscoderLibraryLoaded = true;
            this.trackedKeysSize = 20;
            this.animationRenderFpsLimit = 30;
            this.platformDecoderOptions = new PlatformDecoderOptions(false, false, 3, null);
        }

        private final Builder asBuilder(Function0 block) {
            block.invoke();
            return this;
        }

        @NotNull
        public final Builder setHandOffOnUiThreadOnly(final boolean handOffOnUiThreadOnly) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setHandOffOnUiThreadOnly$lambda$0(this.f$0, handOffOnUiThreadOnly);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setHandOffOnUiThreadOnly$lambda$0(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.handOffOnUiThreadOnly = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setStoreCacheEntrySize(final boolean shouldStoreCacheEntrySize) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setStoreCacheEntrySize$lambda$1(this.f$0, shouldStoreCacheEntrySize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setStoreCacheEntrySize$lambda$1(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.shouldStoreCacheEntrySize = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setIgnoreCacheSizeMismatch(final boolean shouldIgnoreCacheSizeMismatch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIgnoreCacheSizeMismatch$lambda$2(this.f$0, shouldIgnoreCacheSizeMismatch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setIgnoreCacheSizeMismatch$lambda$2(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.shouldIgnoreCacheSizeMismatch = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setWebpSupportEnabled(final boolean webpSupportEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setWebpSupportEnabled$lambda$3(this.f$0, webpSupportEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setWebpSupportEnabled$lambda$3(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.webpSupportEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setPrefetchShortcutEnabled(final boolean prefetchShortcutEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPrefetchShortcutEnabled$lambda$4(this.f$0, prefetchShortcutEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setPrefetchShortcutEnabled$lambda$4(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.prefetchShortcutEnabled = z;
            return Unit.INSTANCE;
        }

        /* renamed from: shouldUseDecodingBufferHelper, reason: from getter */
        public final boolean getShouldUseDecodingBufferHelper() {
            return this.shouldUseDecodingBufferHelper;
        }

        @NotNull
        public final Builder setShouldUseDecodingBufferHelper(final boolean shouldUseDecodingBufferHelper) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setShouldUseDecodingBufferHelper$lambda$5(this.f$0, shouldUseDecodingBufferHelper);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setShouldUseDecodingBufferHelper$lambda$5(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.shouldUseDecodingBufferHelper = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setUseDownsampligRatioForResizing(final boolean useDownsamplingRatioForResizing) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setUseDownsampligRatioForResizing$lambda$6(this.f$0, useDownsamplingRatioForResizing);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUseDownsampligRatioForResizing$lambda$6(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.useDownsamplingRatioForResizing = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setPartialImageCachingEnabled(final boolean partialImageCachingEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPartialImageCachingEnabled$lambda$7(this.f$0, partialImageCachingEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setPartialImageCachingEnabled$lambda$7(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isPartialImageCachingEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setDecodeCancellationEnabled(final boolean decodeCancellationEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setDecodeCancellationEnabled$lambda$8(this.f$0, decodeCancellationEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setDecodeCancellationEnabled$lambda$8(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.decodeCancellationEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setWebpErrorLogger(@Nullable final WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setWebpErrorLogger$lambda$9(this.f$0, webpErrorLogger);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setWebpErrorLogger$lambda$9(Builder this$0, WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.webpErrorLogger = webpErrorLogger;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setWebpBitmapFactory(@Nullable final WebpBitmapFactory webpBitmapFactory) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setWebpBitmapFactory$lambda$10(this.f$0, webpBitmapFactory);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setWebpBitmapFactory$lambda$10(Builder this$0, WebpBitmapFactory webpBitmapFactory) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.webpBitmapFactory = webpBitmapFactory;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setBitmapPrepareToDraw(final boolean useBitmapPrepareToDraw, final int minBitmapSizeBytes, final int maxBitmapSizeBytes, final boolean preparePrefetch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBitmapPrepareToDraw$lambda$11(this.f$0, useBitmapPrepareToDraw, minBitmapSizeBytes, maxBitmapSizeBytes, preparePrefetch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setBitmapPrepareToDraw$lambda$11(Builder this$0, boolean z, int i, int i2, boolean z2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.useBitmapPrepareToDraw = z;
            this$0.bitmapPrepareToDrawMinSizeBytes = i;
            this$0.bitmapPrepareToDrawMaxSizeBytes = i2;
            this$0.bitmapPrepareToDrawForPrefetch = z2;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setBalancedAnimationStrategy(final boolean useBalancedAnimationStrategy) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBalancedAnimationStrategy$lambda$12(this.f$0, useBalancedAnimationStrategy);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setBalancedAnimationStrategy$lambda$12(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.useBalancedAnimationStrategy = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setAnimationStrategyBufferLengthMilliseconds(final int animationStrategyBufferLengthMilliseconds) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAnimationStrategyBufferLengthMilliseconds$lambda$13(this.f$0, animationStrategyBufferLengthMilliseconds);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setAnimationStrategyBufferLengthMilliseconds$lambda$13(Builder this$0, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.animationStrategyBufferLengthMilliseconds = i;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setMaxBitmapDimension(final int maxBitmapDimension) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setMaxBitmapDimension$lambda$14(this.f$0, maxBitmapDimension);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setMaxBitmapDimension$lambda$14(Builder this$0, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.maxBitmapDimension = i;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setNativeCodeDisabled(final boolean nativeCodeDisabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setNativeCodeDisabled$lambda$15(this.f$0, nativeCodeDisabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setNativeCodeDisabled$lambda$15(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.nativeCodeDisabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setProducerFactoryMethod(@Nullable final ProducerFactoryMethod producerFactoryMethod) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setProducerFactoryMethod$lambda$16(this.f$0, producerFactoryMethod);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setProducerFactoryMethod$lambda$16(Builder this$0, ProducerFactoryMethod producerFactoryMethod) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.producerFactoryMethod = producerFactoryMethod;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setLazyDataSource(@Nullable final Supplier<Boolean> lazyDataSource) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setLazyDataSource$lambda$17(this.f$0, lazyDataSource);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setLazyDataSource$lambda$17(Builder this$0, Supplier supplier) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.lazyDataSource = supplier;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setGingerbreadDecoderEnabled(final boolean gingerbreadDecoderEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setGingerbreadDecoderEnabled$lambda$18(this.f$0, gingerbreadDecoderEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setGingerbreadDecoderEnabled$lambda$18(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.gingerbreadDecoderEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setShouldDownscaleFrameToDrawableDimensions(final boolean downscaleFrameToDrawableDimensions) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setShouldDownscaleFrameToDrawableDimensions$lambda$19(this.f$0, downscaleFrameToDrawableDimensions);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setShouldDownscaleFrameToDrawableDimensions$lambda$19(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.downscaleFrameToDrawableDimensions = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setSuppressBitmapPrefetchingSupplier(@NotNull final Supplier<Boolean> suppressBitmapPrefetchingSupplier) {
            Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setSuppressBitmapPrefetchingSupplier$lambda$20(this.f$0, suppressBitmapPrefetchingSupplier);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setSuppressBitmapPrefetchingSupplier$lambda$20(Builder this$0, Supplier suppressBitmapPrefetchingSupplier) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "$suppressBitmapPrefetchingSupplier");
            this$0.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setExperimentalThreadHandoffQueueEnabled(final boolean experimentalThreadHandoffQueueEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setExperimentalThreadHandoffQueueEnabled$lambda$21(this.f$0, experimentalThreadHandoffQueueEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setExperimentalThreadHandoffQueueEnabled$lambda$21(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.experimentalThreadHandoffQueueEnabled = z;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setExperimentalMemoryType$lambda$22(Builder this$0, long j) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.memoryType = j;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setExperimentalMemoryType(final long MemoryType) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setExperimentalMemoryType$lambda$22(this.f$0, MemoryType);
                }
            });
        }

        @NotNull
        public final Builder setKeepCancelledFetchAsLowPriority(final boolean keepCancelledFetchAsLowPriority) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setKeepCancelledFetchAsLowPriority$lambda$23(this.f$0, keepCancelledFetchAsLowPriority);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setKeepCancelledFetchAsLowPriority$lambda$23(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.keepCancelledFetchAsLowPriority = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setDownsampleIfLargeBitmap(final boolean downsampleIfLargeBitmap) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setDownsampleIfLargeBitmap$lambda$24(this.f$0, downsampleIfLargeBitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setDownsampleIfLargeBitmap$lambda$24(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.downsampleIfLargeBitmap = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setEncodedCacheEnabled(final boolean encodedCacheEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setEncodedCacheEnabled$lambda$25(this.f$0, encodedCacheEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setEncodedCacheEnabled$lambda$25(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.encodedCacheEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setEnsureTranscoderLibraryLoaded(final boolean ensureTranscoderLibraryLoaded) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setEnsureTranscoderLibraryLoaded$lambda$26(this.f$0, ensureTranscoderLibraryLoaded);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setEnsureTranscoderLibraryLoaded$lambda$26(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.ensureTranscoderLibraryLoaded = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setIsDiskCacheProbingEnabled(final boolean isDiskCacheProbingEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIsDiskCacheProbingEnabled$lambda$27(this.f$0, isDiskCacheProbingEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setIsDiskCacheProbingEnabled$lambda$27(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isDiskCacheProbingEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setIsEncodedMemoryCacheProbingEnabled(final boolean isEncodedMemoryCacheProbingEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIsEncodedMemoryCacheProbingEnabled$lambda$28(this.f$0, isEncodedMemoryCacheProbingEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setIsEncodedMemoryCacheProbingEnabled$lambda$28(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isEncodedMemoryCacheProbingEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setTrackedKeysSize(final int trackedKeysSize) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setTrackedKeysSize$lambda$29(this.f$0, trackedKeysSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setTrackedKeysSize$lambda$29(Builder this$0, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.trackedKeysSize = i;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setAllowDelay$lambda$30(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.allowDelay = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setAllowDelay(final boolean allowDelay) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAllowDelay$lambda$30(this.f$0, allowDelay);
                }
            });
        }

        @NotNull
        public final Builder setAllowProgressiveOnPrefetch(final boolean allowProgressiveOnPrefetch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAllowProgressiveOnPrefetch$lambda$31(this.f$0, allowProgressiveOnPrefetch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setAllowProgressiveOnPrefetch$lambda$31(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.allowProgressiveOnPrefetch = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setAnimationRenderFpsLimit(final int animationRenderFpsLimit) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAnimationRenderFpsLimit$lambda$32(this.f$0, animationRenderFpsLimit);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setAnimationRenderFpsLimit$lambda$32(Builder this$0, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.animationRenderFpsLimit = i;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setCancelDecodeOnCacheMiss(final boolean cancelDecodeOnCacheMiss) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setCancelDecodeOnCacheMiss$lambda$33(this.f$0, cancelDecodeOnCacheMiss);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setCancelDecodeOnCacheMiss$lambda$33(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.cancelDecodeOnCacheMiss = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setPlatformDecoderOptions(@NotNull final PlatformDecoderOptions platformDecoderOptions) {
            Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPlatformDecoderOptions$lambda$34(this.f$0, platformDecoderOptions);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setPlatformDecoderOptions$lambda$34(Builder this$0, PlatformDecoderOptions platformDecoderOptions) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(platformDecoderOptions, "$platformDecoderOptions");
            this$0.platformDecoderOptions = platformDecoderOptions;
            return Unit.INSTANCE;
        }

        @NotNull
        public final Builder setBinaryXmlEnabled(final boolean binaryXmlEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBinaryXmlEnabled$lambda$35(this.f$0, binaryXmlEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setBinaryXmlEnabled$lambda$35(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isBinaryXmlEnabled = z;
            return Unit.INSTANCE;
        }

        @NotNull
        public final ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JÞ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a2\u0016\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020'H\u0016¨\u0006/"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$DefaultProducerFactoryMethod;", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "<init>", "()V", "createProducerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", "context", "Landroid/content/Context;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "resizeAndRotateEnabledForNetwork", "", "decodeCancellationEnabled", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        @NotNull
        public ProducerFactory createProducerFactory(@NotNull Context context, @NotNull ByteArrayPool byteArrayPool, @NotNull ImageDecoder imageDecoder, @NotNull ProgressiveJpegConfig progressiveJpegConfig, @NotNull DownsampleMode downsampleMode, boolean resizeAndRotateEnabledForNetwork, boolean decodeCancellationEnabled, @NotNull ExecutorSupplier executorSupplier, @NotNull PooledByteBufferFactory pooledByteBufferFactory, @NotNull PooledByteStreams pooledByteStreams, @NotNull MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, @NotNull MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, @NotNull Supplier<DiskCachesStore> diskCachesStoreSupplier, @NotNull CacheKeyFactory cacheKeyFactory, @NotNull PlatformBitmapFactory platformBitmapFactory, int bitmapPrepareToDrawMinSizeBytes, int bitmapPrepareToDrawMaxSizeBytes, boolean bitmapPrepareToDrawForPrefetch, int maxBitmapSize, @NotNull CloseableReferenceFactory closeableReferenceFactory, boolean keepCancelledFetchAsLowPriority, int trackedKeysSize) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(byteArrayPool, "byteArrayPool");
            Intrinsics.checkNotNullParameter(imageDecoder, "imageDecoder");
            Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
            Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
            Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
            Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
            Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
            Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
            Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
            Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
            Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
            Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
            return new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, downsampleMode, resizeAndRotateEnabledForNetwork, decodeCancellationEnabled, executorSupplier, pooledByteBufferFactory, bitmapMemoryCache, encodedMemoryCache, diskCachesStoreSupplier, cacheKeyFactory, platformBitmapFactory, bitmapPrepareToDrawMinSizeBytes, bitmapPrepareToDrawMaxSizeBytes, bitmapPrepareToDrawForPrefetch, maxBitmapSize, closeableReferenceFactory, keepCancelledFetchAsLowPriority, trackedKeysSize);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Companion;", "", "<init>", "()V", "newBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "configBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Builder newBuilder(@NotNull ImagePipelineConfig.Builder configBuilder) {
            Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            return new Builder(configBuilder);
        }
    }
}
