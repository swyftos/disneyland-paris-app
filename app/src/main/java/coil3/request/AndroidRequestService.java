package coil3.request;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.FrameMetricsAggregator;
import androidx.lifecycle.Lifecycle;
import coil3.BitmapImage;
import coil3.Extras;
import coil3.Image;
import coil3.ImageLoader;
import coil3.content.BitmapsKt;
import coil3.content.Context;
import coil3.content.HardwareBitmapService;
import coil3.content.HardwareBitmapsKt;
import coil3.content.Logger;
import coil3.content.SystemCallbacks;
import coil3.content.Utils_androidKt;
import coil3.memory.MemoryCache;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.size.ViewSizeResolver;
import coil3.size.ViewSizeResolverKt;
import coil3.target.Target;
import coil3.target.ViewTarget;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0014*\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u000fH\u0002J\f\u0010\u001c\u001a\u00020\u001d*\u00020\u000fH\u0002J\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010 \u001a\u00020\u001bH\u0002J\u0014\u0010!\u001a\u00020\"*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m1836d2 = {"Lcoil3/request/AndroidRequestService;", "Lcoil3/request/RequestService;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/util/Logger;)V", "hardwareBitmapService", "Lcoil3/util/HardwareBitmapService;", "requestDelegate", "Lcoil3/request/RequestDelegate;", "request", "Lcoil3/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "findLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "updateRequest", "options", "Lcoil3/request/Options;", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "resolveSizeResolver", "Lcoil3/size/SizeResolver;", "resolveScale", "Lcoil3/size/Scale;", "resolvePrecision", "Lcoil3/size/Precision;", "sizeResolver", "resolveExtras", "Lcoil3/Extras;", "updateOptions", "isCacheValueValidForHardware", "cacheValue", "Lcoil3/memory/MemoryCache$Value;", "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isBitmapConfigValidMainThread", "isBitmapConfigValidWorkerThread", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nRequestService.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestService.android.kt\ncoil3/request/AndroidRequestService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,258:1\n1#2:259\n*E\n"})
public final class AndroidRequestService implements RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final SystemCallbacks systemCallbacks;

    public AndroidRequestService(@NotNull ImageLoader imageLoader, @NotNull SystemCallbacks systemCallbacks, @Nullable Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.logger = logger;
        this.hardwareBitmapService = HardwareBitmapsKt.HardwareBitmapService(logger);
    }

    @Override // coil3.request.RequestService
    @NotNull
    public RequestDelegate requestDelegate(@NotNull ImageRequest request, @NotNull Job job, boolean findLifecycle) {
        Target target = request.getTarget();
        if (target instanceof ViewTarget) {
            Lifecycle lifecycle = ImageRequests_androidKt.getLifecycle(request);
            if (lifecycle == null) {
                lifecycle = findLifecycle(request);
            }
            return new ViewTargetRequestDelegate(this.imageLoader, request, (ViewTarget) target, lifecycle, job);
        }
        Lifecycle lifecycle2 = ImageRequests_androidKt.getLifecycle(request);
        if (lifecycle2 == null) {
            lifecycle2 = findLifecycle ? findLifecycle(request) : null;
        }
        if (lifecycle2 != null) {
            return new LifecycleRequestDelegate(lifecycle2, job);
        }
        return BaseRequestDelegate.m2788boximpl(BaseRequestDelegate.m2789constructorimpl(job));
    }

    private final Lifecycle findLifecycle(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        return Context.getLifecycle(target instanceof ViewTarget ? ((ViewTarget) target).getView().getContext() : imageRequest.getContext());
    }

    @Override // coil3.request.RequestService
    @NotNull
    public ImageRequest updateRequest(@NotNull ImageRequest request) {
        ImageRequest.Builder builderDefaults = ImageRequest.newBuilder$default(request, null, 1, null).defaults(this.imageLoader.getDefaults());
        SizeResolver sizeResolver = request.getDefined().getSizeResolver();
        if (sizeResolver == null) {
            sizeResolver = resolveSizeResolver(request);
            builderDefaults.size(sizeResolver);
        }
        if (request.getDefined().getScale() == null) {
            builderDefaults.scale(resolveScale(request));
        }
        if (request.getDefined().getPrecision() == null) {
            builderDefaults.precision(resolvePrecision(request, sizeResolver));
        }
        return builderDefaults.build();
    }

    @Override // coil3.request.RequestService
    @NotNull
    public Options options(@NotNull ImageRequest request, @NotNull Size size) {
        return new Options(request.getContext(), size, request.getScale(), request.getPrecision(), request.getDiskCacheKey(), request.getFileSystem(), request.getMemoryCachePolicy(), request.getDiskCachePolicy(), request.getNetworkCachePolicy(), resolveExtras(request, size));
    }

    private final SizeResolver resolveSizeResolver(ImageRequest imageRequest) {
        ImageView.ScaleType scaleType;
        if (imageRequest.getTarget() instanceof ViewTarget) {
            View view = ((ViewTarget) imageRequest.getTarget()).getView();
            if ((view instanceof ImageView) && ((scaleType = ((ImageView) view).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) {
                return SizeResolver.ORIGINAL;
            }
            return ViewSizeResolverKt.ViewSizeResolver$default(view, false, 2, null);
        }
        return SizeResolver.ORIGINAL;
    }

    private final Scale resolveScale(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        ViewTarget viewTarget = target instanceof ViewTarget ? (ViewTarget) target : null;
        View view = viewTarget != null ? viewTarget.getView() : null;
        ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
        if (imageView != null) {
            return Utils_androidKt.getScale(imageView);
        }
        return imageRequest.getScale();
    }

    private final Precision resolvePrecision(ImageRequest imageRequest, SizeResolver sizeResolver) {
        if (imageRequest.getDefined().getSizeResolver() == null && Intrinsics.areEqual(sizeResolver, SizeResolver.ORIGINAL)) {
            return Precision.INEXACT;
        }
        if ((imageRequest.getTarget() instanceof ViewTarget) && (sizeResolver instanceof ViewSizeResolver) && (((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) && ((ViewTarget) imageRequest.getTarget()).getView() == ((ViewSizeResolver) sizeResolver).getView()) {
            return Precision.INEXACT;
        }
        return Precision.EXACT;
    }

    private final Extras resolveExtras(ImageRequest imageRequest, Size size) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(imageRequest);
        boolean allowRgb565 = ImageRequests_androidKt.getAllowRgb565(imageRequest);
        if (!isBitmapConfigValidMainThread(imageRequest, size)) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        boolean z = allowRgb565 && ImageRequests_androidKt.getTransformations(imageRequest).isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8;
        Extras.Builder builder = new Extras.Builder((Map<Extras.Key<?>, ? extends Object>) MapsKt.plus(imageRequest.getDefaults().getExtras().asMap(), imageRequest.getExtras().asMap()));
        if (bitmapConfig != ImageRequests_androidKt.getBitmapConfig(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.INSTANCE), bitmapConfig);
        }
        if (z != ImageRequests_androidKt.getAllowRgb565(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getAllowRgb565(Extras.Key.INSTANCE), Boolean.valueOf(z));
        }
        return builder.build();
    }

    @Override // coil3.request.RequestService
    @NotNull
    public Options updateOptions(@NotNull Options options) {
        boolean z;
        Extras extras = options.getExtras();
        if (isBitmapConfigValidWorkerThread(options)) {
            z = false;
        } else {
            extras = extras.newBuilder().set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.INSTANCE), Bitmap.Config.ARGB_8888).build();
            z = true;
        }
        Extras extras2 = extras;
        if (z) {
            return options.copy((FrameMetricsAggregator.EVERY_DURATION & 1) != 0 ? options.context : null, (FrameMetricsAggregator.EVERY_DURATION & 2) != 0 ? options.size : null, (FrameMetricsAggregator.EVERY_DURATION & 4) != 0 ? options.scale : null, (FrameMetricsAggregator.EVERY_DURATION & 8) != 0 ? options.precision : null, (FrameMetricsAggregator.EVERY_DURATION & 16) != 0 ? options.diskCacheKey : null, (FrameMetricsAggregator.EVERY_DURATION & 32) != 0 ? options.fileSystem : null, (FrameMetricsAggregator.EVERY_DURATION & 64) != 0 ? options.memoryCachePolicy : null, (FrameMetricsAggregator.EVERY_DURATION & 128) != 0 ? options.diskCachePolicy : null, (FrameMetricsAggregator.EVERY_DURATION & 256) != 0 ? options.networkCachePolicy : null, (FrameMetricsAggregator.EVERY_DURATION & 512) != 0 ? options.extras : extras2);
        }
        return options;
    }

    @Override // coil3.request.RequestService
    public boolean isCacheValueValidForHardware(@NotNull ImageRequest request, @NotNull MemoryCache.Value cacheValue) {
        Image image = cacheValue.getImage();
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null) {
            return true;
        }
        return isConfigValidForHardware(request, BitmapsKt.getSafeConfig(bitmapImage.getBitmap()));
    }

    private final boolean isConfigValidForHardware(ImageRequest request, Bitmap.Config requestedConfig) {
        if (!BitmapsKt.isHardware(requestedConfig)) {
            return true;
        }
        if (!ImageRequests_androidKt.getAllowHardware(request)) {
            return false;
        }
        Target target = request.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isBitmapConfigValidMainThread(ImageRequest request, Size size) {
        return (ImageRequests_androidKt.getTransformations(request).isEmpty() || ArraysKt.contains(Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), ImageRequests_androidKt.getBitmapConfig(request))) && (!BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(request)) || (isConfigValidForHardware(request, ImageRequests_androidKt.getBitmapConfig(request)) && this.hardwareBitmapService.allowHardwareMainThread(size)));
    }

    private final boolean isBitmapConfigValidWorkerThread(Options options) {
        return !BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(options)) || this.hardwareBitmapService.allowHardwareWorkerThread();
    }
}
