package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.CircularTransformation;
import com.facebook.imagepipeline.transformation.TransformationUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class DefaultImageDecoder implements ImageDecoder {
    private final ImageDecoder mAnimatedGifDecoder;
    private final ImageDecoder mAnimatedWebPDecoder;
    private final Map mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;
    private final Supplier mEnableEncodedImageColorSpaceUsage;
    private final PlatformDecoder mPlatformDecoder;
    private final ImageDecoder mXmlDecoder;

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, @Nullable ImageDecoder imageDecoder2, @Nullable ImageDecoder imageDecoder3, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, imageDecoder3, platformDecoder, null);
    }

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, @Nullable ImageDecoder imageDecoder2, @Nullable ImageDecoder imageDecoder3, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map) {
        this(imageDecoder, imageDecoder2, imageDecoder3, platformDecoder, map, Suppliers.BOOLEAN_FALSE);
    }

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, @Nullable ImageDecoder imageDecoder2, @Nullable ImageDecoder imageDecoder3, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map, Supplier<Boolean> supplier) {
        this.mDefaultDecoder = new ImageDecoder() { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ColorSpace colorSpace;
                ImageFormat imageFormat = encodedImage.getImageFormat();
                if (((Boolean) DefaultImageDecoder.this.mEnableEncodedImageColorSpaceUsage.get()).booleanValue()) {
                    colorSpace = imageDecodeOptions.colorSpace;
                    if (colorSpace == null) {
                        colorSpace = encodedImage.getColorSpace();
                    }
                } else {
                    colorSpace = imageDecodeOptions.colorSpace;
                }
                ColorSpace colorSpace2 = colorSpace;
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions, colorSpace2);
                }
                if (imageFormat == DefaultImageFormats.GIF) {
                    return DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.BINARY_XML) {
                    return DefaultImageDecoder.this.decodeXml(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == ImageFormat.UNKNOWN) {
                    throw new DecodeException("unknown image format", encodedImage);
                }
                return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mXmlDecoder = imageDecoder3;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
        this.mEnableEncodedImageColorSpaceUsage = supplier;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    @Nullable
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InputStream inputStream;
        ImageDecoder imageDecoder;
        ImageDecoder imageDecoder2 = imageDecodeOptions.customImageDecoder;
        if (imageDecoder2 != null) {
            return imageDecoder2.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if ((imageFormat == null || imageFormat == ImageFormat.UNKNOWN) && (inputStream = encodedImage.getInputStream()) != null) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
            encodedImage.setImageFormat(imageFormat);
        }
        Map map = this.mCustomDecoders;
        if (map != null && (imageDecoder = (ImageDecoder) map.get(imageFormat)) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    @Nullable
    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
            throw new DecodeException("image width or height is incorrect", encodedImage);
        }
        if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedGifDecoder) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> closeableReferenceDecodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.colorSpace);
        try {
            boolean zMaybeApplyTransformation = TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, closeableReferenceDecodeFromEncodedImageWithColorSpace);
            Preconditions.checkNotNull(closeableReferenceDecodeFromEncodedImageWithColorSpace);
            CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceDecodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            closeableStaticBitmapOf.putExtra("is_rounded", Boolean.valueOf(zMaybeApplyTransformation && (imageDecodeOptions.bitmapTransformation instanceof CircularTransformation)));
            CloseableReference.closeSafely(closeableReferenceDecodeFromEncodedImageWithColorSpace);
            return closeableStaticBitmapOf;
        } catch (Throwable th) {
            CloseableReference.closeSafely(closeableReferenceDecodeFromEncodedImageWithColorSpace);
            throw th;
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions, @Nullable ColorSpace colorSpace) {
        CloseableReference<Bitmap> closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i, colorSpace);
        try {
            boolean zMaybeApplyTransformation = TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            Preconditions.checkNotNull(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            closeableStaticBitmapOf.putExtra("is_rounded", Boolean.valueOf(zMaybeApplyTransformation && (imageDecodeOptions.bitmapTransformation instanceof CircularTransformation)));
            CloseableReference.closeSafely(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            return closeableStaticBitmapOf;
        } catch (Throwable th) {
            CloseableReference.closeSafely(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            throw th;
        }
    }

    @Nullable
    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedWebPDecoder) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloseableImage decodeXml(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder = this.mXmlDecoder;
        if (imageDecoder != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return null;
    }
}
