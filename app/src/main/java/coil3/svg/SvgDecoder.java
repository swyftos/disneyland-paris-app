package coil3.svg;

import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.content.IntPair;
import coil3.decode.DecodeResult;
import coil3.decode.DecodeUtils;
import coil3.decode.Decoder;
import coil3.decode.ImageSource;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.size.SizeKt;
import coil3.svg.internal.Svg;
import coil3.svg.internal.Svg_androidKt;
import coil3.svg.internal.UtilsKt;
import coil3.svg.internal.Utils_androidKt;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlinx.coroutines.InterruptibleKt;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0014"}, m1836d2 = {"Lcoil3/svg/SvgDecoder;", "Lcoil3/decode/Decoder;", "source", "Lcoil3/decode/ImageSource;", "options", "Lcoil3/request/Options;", "useViewBoundsAsIntrinsicSize", "", "renderToBitmap", "scaleToDensity", "<init>", "(Lcoil3/decode/ImageSource;Lcoil3/request/Options;ZZZ)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "getRenderToBitmap", "getScaleToDensity", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-svg_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSvgDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvgDecoder.kt\ncoil3/svg/SvgDecoder\n+ 2 utils.jvmCommon.kt\ncoil3/svg/internal/Utils_jvmCommonKt\n+ 3 Okio.kt\nokio/Okio__OkioKt\n+ 4 collections.kt\ncoil3/util/CollectionsKt\n*L\n1#1,135:1\n5#2,5:136\n66#3:141\n52#3,22:142\n23#4,3:164\n*S KotlinDebug\n*F\n+ 1 SvgDecoder.kt\ncoil3/svg/SvgDecoder\n*L\n44#1:136,5\n45#1:141\n45#1:142,22\n67#1:164,3\n*E\n"})
public final class SvgDecoder implements Decoder {
    private final Options options;
    private final boolean renderToBitmap;
    private final boolean scaleToDensity;
    private final ImageSource source;
    private final boolean useViewBoundsAsIntrinsicSize;

    public SvgDecoder(@NotNull ImageSource imageSource, @NotNull Options options, boolean z, boolean z2, boolean z3) {
        this.source = imageSource;
        this.options = options;
        this.useViewBoundsAsIntrinsicSize = z;
        this.renderToBitmap = z2;
        this.scaleToDensity = z3;
    }

    public /* synthetic */ SvgDecoder(ImageSource imageSource, Options options, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3);
    }

    public final boolean getUseViewBoundsAsIntrinsicSize() {
        return this.useViewBoundsAsIntrinsicSize;
    }

    public final boolean getRenderToBitmap() {
        return this.renderToBitmap;
    }

    public final boolean getScaleToDensity() {
        return this.scaleToDensity;
    }

    @Override // coil3.decode.Decoder
    @Nullable
    public Object decode(@NotNull Continuation<? super DecodeResult> continuation) {
        return InterruptibleKt.runInterruptible(EmptyCoroutineContext.INSTANCE, new Function0() { // from class: coil3.svg.SvgDecoder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SvgDecoder.decode$lambda$0(this.f$0);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecodeResult decode$lambda$0(SvgDecoder svgDecoder) throws Throwable {
        Throwable th;
        Svg svg;
        float width;
        float height;
        BufferedSource bufferedSourceSource = svgDecoder.source.source();
        try {
            svg = Svg_androidKt.parseSvg(bufferedSourceSource);
            if (bufferedSourceSource != null) {
                try {
                    bufferedSourceSource.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            th = null;
        } catch (Throwable th3) {
            if (bufferedSourceSource != null) {
                try {
                    bufferedSourceSource.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            th = th3;
            svg = null;
        }
        if (th == null) {
            float[] viewBox = svg.getViewBox();
            if (svgDecoder.useViewBoundsAsIntrinsicSize && viewBox != null) {
                width = viewBox[2] - viewBox[0];
                height = viewBox[3] - viewBox[1];
            } else {
                width = svg.getWidth();
                height = svg.getHeight();
            }
            if (svgDecoder.scaleToDensity && SizeKt.isOriginal(svgDecoder.options.getSize())) {
                float density = Utils_androidKt.getDensity(svgDecoder.options.getContext());
                if (width > BitmapDescriptorFactory.HUE_RED) {
                    width *= density;
                }
                if (height > BitmapDescriptorFactory.HUE_RED) {
                    height *= density;
                }
            }
            long jM2757computeDstSizesEdh43o = DecodeUtils.m2757computeDstSizesEdh43o(width > BitmapDescriptorFactory.HUE_RED ? MathKt.roundToInt(width) : 512, height > BitmapDescriptorFactory.HUE_RED ? MathKt.roundToInt(height) : 512, svgDecoder.options.getSize(), svgDecoder.options.getScale(), ImageRequestsKt.getMaxBitmapSize(svgDecoder.options));
            int iM2813getFirstimpl = IntPair.m2813getFirstimpl(jM2757computeDstSizesEdh43o);
            int iM2814getSecondimpl = IntPair.m2814getSecondimpl(jM2757computeDstSizesEdh43o);
            if (width > BitmapDescriptorFactory.HUE_RED && height > BitmapDescriptorFactory.HUE_RED) {
                float fComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, iM2813getFirstimpl, iM2814getSecondimpl, svgDecoder.options.getScale());
                int i = (int) (fComputeSizeMultiplier * width);
                int i2 = (int) (fComputeSizeMultiplier * height);
                if (viewBox == null) {
                    svg.viewBox(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, width, height});
                }
                iM2814getSecondimpl = i2;
                iM2813getFirstimpl = i;
            }
            svg.width("100%");
            svg.height("100%");
            svg.options(svgDecoder.options);
            Image imageAsImage = svg.asImage(iM2813getFirstimpl, iM2814getSecondimpl);
            if (svgDecoder.renderToBitmap) {
                imageAsImage = Image_androidKt.asImage$default(Image_androidKt.toBitmap$default(imageAsImage, 0, 0, 3, null), false, 1, null);
            }
            return new DecodeResult(imageAsImage, svgDecoder.renderToBitmap);
        }
        throw th;
    }

    @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, m1836d2 = {"Lcoil3/svg/SvgDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "useViewBoundsAsIntrinsicSize", "", "renderToBitmap", "scaleToDensity", "<init>", "(ZZZ)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "getRenderToBitmap", "getScaleToDensity", "create", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "coil-svg_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final boolean renderToBitmap;
        private final boolean scaleToDensity;
        private final boolean useViewBoundsAsIntrinsicSize;

        public Factory() {
            this(false, false, false, 7, null);
        }

        public Factory(boolean z, boolean z2, boolean z3) {
            this.useViewBoundsAsIntrinsicSize = z;
            this.renderToBitmap = z2;
            this.scaleToDensity = z3;
        }

        public /* synthetic */ Factory(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? false : z3);
        }

        public final boolean getUseViewBoundsAsIntrinsicSize() {
            return this.useViewBoundsAsIntrinsicSize;
        }

        public final boolean getRenderToBitmap() {
            return this.renderToBitmap;
        }

        public final boolean getScaleToDensity() {
            return this.scaleToDensity;
        }

        @Override // coil3.decode.Decoder.Factory
        @Nullable
        public Decoder create(@NotNull SourceFetchResult result, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (isApplicable(result)) {
                return new SvgDecoder(result.getSource(), options, this.useViewBoundsAsIntrinsicSize, this.renderToBitmap, this.scaleToDensity);
            }
            return null;
        }

        private final boolean isApplicable(SourceFetchResult result) {
            return Intrinsics.areEqual(result.getMimeType(), UtilsKt.MIME_TYPE_SVG) || DecodeUtilsKt.isSvg(DecodeUtils.INSTANCE, result.getSource().source());
        }
    }
}
