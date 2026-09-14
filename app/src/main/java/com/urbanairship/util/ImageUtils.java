package com.urbanairship.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.urbanairship.UALog;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public final class ImageUtils {

    /* JADX INFO: Access modifiers changed from: private */
    interface ImageProcessor {
        Object onProcessFile(File file);
    }

    public static final class DrawableResult {
        public final long bytes;
        public final Drawable drawable;

        private DrawableResult(Drawable drawable, long j) {
            this.drawable = drawable;
            this.bytes = j;
        }
    }

    @Nullable
    public static DrawableResult fetchScaledDrawable(@NonNull Context context, @NonNull URL url, int i, int i2) throws IOException {
        return fetchScaledDrawable(context, url, i, i2, -1, -1);
    }

    @Nullable
    public static DrawableResult fetchScaledDrawable(@NonNull Context context, @NonNull URL url, final int i, final int i2, final int i3, final int i4) throws IOException {
        return (DrawableResult) fetchImage(context, url, new ImageProcessor() { // from class: com.urbanairship.util.ImageUtils$$ExternalSyntheticLambda1
            @Override // com.urbanairship.util.ImageUtils.ImageProcessor
            public final Object onProcessFile(File file) {
                return ImageUtils.lambda$fetchScaledDrawable$1(i, i2, i3, i4, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DrawableResult lambda$fetchScaledDrawable$1(final int i, final int i2, final int i3, final int i4, File file) throws IOException {
        long length;
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file), new ImageDecoder.OnHeaderDecodedListener() { // from class: com.urbanairship.util.ImageUtils$$ExternalSyntheticLambda3
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                ImageUtils.lambda$fetchScaledDrawable$0(i, i2, i3, i4, imageDecoder, imageInfo, source);
            }
        });
        if (drawableDecodeDrawable instanceof BitmapDrawable) {
            length = ((BitmapDrawable) drawableDecodeDrawable).getBitmap().getByteCount();
        } else {
            length = file.length();
        }
        return new DrawableResult(drawableDecodeDrawable, length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchScaledDrawable$0(int i, int i2, int i3, int i4, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int width = imageInfo.getSize().getWidth();
        int height = imageInfo.getSize().getHeight();
        Size sizeCalculateTargetSize = calculateTargetSize(width, height, i, i2, i3, i4);
        imageDecoder.setTargetSampleSize(calculateInSampleSize(width, height, sizeCalculateTargetSize.width, sizeCalculateTargetSize.height));
    }

    @Nullable
    public static Bitmap fetchScaledBitmap(@NonNull Context context, @NonNull URL url, int i, int i2) throws IOException {
        return fetchScaledBitmap(context, url, i, i2, -1, -1);
    }

    @Nullable
    public static Bitmap fetchScaledBitmap(@NonNull Context context, @NonNull URL url, final int i, final int i2, final int i3, final int i4) throws IOException {
        Bitmap bitmap = (Bitmap) fetchImage(context, url, new ImageProcessor() { // from class: com.urbanairship.util.ImageUtils$$ExternalSyntheticLambda0
            @Override // com.urbanairship.util.ImageUtils.ImageProcessor
            public final Object onProcessFile(File file) {
                return ImageUtils.lambda$fetchScaledBitmap$3(i, i2, i3, i4, file);
            }
        });
        if (bitmap != null) {
            UALog.m1741d("Fetched image from: %s. Original image size: %dx%d. Requested image size: %dx%d. Bitmap size: %dx%d.", url, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bitmap lambda$fetchScaledBitmap$3(final int i, final int i2, final int i3, final int i4, File file) {
        return ImageDecoder.decodeBitmap(ImageDecoder.createSource(file), new ImageDecoder.OnHeaderDecodedListener() { // from class: com.urbanairship.util.ImageUtils$$ExternalSyntheticLambda2
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                ImageUtils.lambda$fetchScaledBitmap$2(i, i2, i3, i4, imageDecoder, imageInfo, source);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchScaledBitmap$2(int i, int i2, int i3, int i4, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int width = imageInfo.getSize().getWidth();
        int height = imageInfo.getSize().getHeight();
        Size sizeCalculateTargetSize = calculateTargetSize(width, height, i, i2, i3, i4);
        imageDecoder.setTargetSampleSize(calculateInSampleSize(width, height, sizeCalculateTargetSize.width, sizeCalculateTargetSize.height));
    }

    public static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (true) {
                if (i6 / i5 <= i4 && i7 / i5 <= i3) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    @NonNull
    public static Size calculateTargetSize(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i == 0 || i2 == 0) {
            throw new IllegalArgumentException("Failed to calculate target size! width and height must be greater than zero.");
        }
        if (i3 == 0 && i4 == 0) {
            throw new IllegalArgumentException("Failed to calculate target size! reqWidth and reqHeight may not both be zero.");
        }
        if (i3 != 0) {
            i5 = i3;
        } else if (i5 <= 0) {
            i5 = (int) (((double) i4) * (((double) i) / ((double) i2)));
        }
        if (i4 == 0) {
            i4 = i6 > 0 ? i6 : (int) (((double) i3) * (((double) i2) / ((double) i)));
        }
        return new Size(i5, i4);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b5  */
    /* JADX WARN: Multi-variable type inference failed */
    private static Object fetchImage(Context context, URL url, ImageProcessor imageProcessor) throws Throwable {
        File fileCreateTempFile;
        UALog.m1751v("Fetching image from: %s", url);
        boolean z = false;
        File file = 0;
        try {
            try {
                if (URLUtil.isFileUrl(url.toString())) {
                    fileCreateTempFile = new File(url.toURI());
                } else {
                    fileCreateTempFile = File.createTempFile("ua_", ".temp", context.getCacheDir());
                    z = true;
                    try {
                        if (!FileUtils.downloadFile(url, fileCreateTempFile).isSuccess) {
                            UALog.m1751v("Failed to fetch image from: %s", url);
                            if (fileCreateTempFile != null) {
                                if (fileCreateTempFile.delete()) {
                                    UALog.m1751v("Deleted temp file: %s", fileCreateTempFile);
                                } else {
                                    UALog.m1751v("Failed to delete temp file: %s", fileCreateTempFile);
                                }
                            }
                            return null;
                        }
                    } catch (URISyntaxException unused) {
                        UALog.m1744e("ImageUtils - Invalid URL: %s ", url);
                        if (z && fileCreateTempFile != null) {
                            if (fileCreateTempFile.delete()) {
                                UALog.m1751v("Deleted temp file: %s", fileCreateTempFile);
                            } else {
                                UALog.m1751v("Failed to delete temp file: %s", fileCreateTempFile);
                            }
                        }
                        return null;
                    }
                }
                Object objOnProcessFile = imageProcessor.onProcessFile(fileCreateTempFile);
                if (z && fileCreateTempFile != null) {
                    if (fileCreateTempFile.delete()) {
                        UALog.m1751v("Deleted temp file: %s", fileCreateTempFile);
                    } else {
                        UALog.m1751v("Failed to delete temp file: %s", fileCreateTempFile);
                    }
                }
                return objOnProcessFile;
            } catch (URISyntaxException unused2) {
                fileCreateTempFile = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    if (file.delete()) {
                        UALog.m1751v("Deleted temp file: %s", file);
                    } else {
                        UALog.m1751v("Failed to delete temp file: %s", file);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            file = context;
            th = th2;
            if (0 != 0 && file != 0) {
                if (file.delete()) {
                    UALog.m1751v("Deleted temp file: %s", file);
                } else {
                    UALog.m1751v("Failed to delete temp file: %s", file);
                }
            }
            throw th;
        }
    }

    static class Size {
        final int height;
        final int width;

        Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Size size = (Size) obj;
            return this.width == size.width && this.height == size.height;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.width), Integer.valueOf(this.height));
        }
    }
}
