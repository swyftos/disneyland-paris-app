package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/producers/ThumbnailSizeChecker;", "", "<init>", "()V", "", "width", "height", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "resizeOptions", "", "isImageBigEnough", "(IILcom/facebook/imagepipeline/common/ResizeOptions;)Z", "Lcom/facebook/imagepipeline/image/EncodedImage;", "encodedImage", "(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/common/ResizeOptions;)Z", TCEventPropertiesNames.TCP_SIZE, "getAcceptableSize", "(I)I", "", "ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO", "F", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThumbnailSizeChecker {
    public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334f;

    @NotNull
    public static final ThumbnailSizeChecker INSTANCE = new ThumbnailSizeChecker();

    @JvmStatic
    public static final int getAcceptableSize(int size) {
        return (int) (size * 1.3333334f);
    }

    private ThumbnailSizeChecker() {
    }

    @JvmStatic
    public static final boolean isImageBigEnough(int width, int height, @Nullable ResizeOptions resizeOptions) {
        if (resizeOptions == null) {
            if (getAcceptableSize(width) < 2048.0f || getAcceptableSize(height) < 2048) {
                return false;
            }
        } else if (getAcceptableSize(width) < resizeOptions.width || getAcceptableSize(height) < resizeOptions.height) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isImageBigEnough(@Nullable EncodedImage encodedImage, @Nullable ResizeOptions resizeOptions) {
        if (encodedImage == null) {
            return false;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 270) {
            return isImageBigEnough(encodedImage.getHeight(), encodedImage.getWidth(), resizeOptions);
        }
        return isImageBigEnough(encodedImage.getWidth(), encodedImage.getHeight(), resizeOptions);
    }
}
