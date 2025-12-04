package com.urbanairship.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.urbanairship.UALog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/* loaded from: classes5.dex */
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
            UALog.d("Fetched image from: %s. Original image size: %dx%d. Requested image size: %dx%d. Bitmap size: %dx%d.", url, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
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
            i5 = (int) (i4 * (i / i2));
        }
        if (i4 == 0) {
            i4 = i6 > 0 ? i6 : (int) (i3 * (i2 / i));
        }
        return new Size(i5, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object fetchImage(android.content.Context r6, java.net.URL r7, com.urbanairship.util.ImageUtils.ImageProcessor r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Failed to delete temp file: %s"
            java.lang.String r1 = "Deleted temp file: %s"
            java.lang.String r2 = "Fetching image from: %s"
            java.lang.Object[] r3 = new java.lang.Object[]{r7}
            com.urbanairship.UALog.v(r2, r3)
            r2 = 0
            r3 = 0
            java.lang.String r4 = r7.toString()     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            boolean r4 = android.webkit.URLUtil.isFileUrl(r4)     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            if (r4 == 0) goto L28
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            java.net.URI r4 = r7.toURI()     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            goto L62
        L23:
            r6 = move-exception
            goto La3
        L26:
            r6 = r3
            goto L80
        L28:
            java.lang.String r4 = "ua_"
            java.lang.String r5 = ".temp"
            java.io.File r6 = r6.getCacheDir()     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            java.io.File r6 = java.io.File.createTempFile(r4, r5, r6)     // Catch: java.lang.Throwable -> L23 java.net.URISyntaxException -> L26
            r2 = 1
            com.urbanairship.util.FileUtils$DownloadResult r4 = com.urbanairship.util.FileUtils.downloadFile(r7, r6)     // Catch: java.lang.Throwable -> L5e java.net.URISyntaxException -> L80
            boolean r4 = r4.isSuccess     // Catch: java.lang.Throwable -> L5e java.net.URISyntaxException -> L80
            if (r4 != 0) goto L62
            java.lang.String r8 = "Failed to fetch image from: %s"
            java.lang.Object[] r4 = new java.lang.Object[]{r7}     // Catch: java.lang.Throwable -> L5e java.net.URISyntaxException -> L80
            com.urbanairship.UALog.v(r8, r4)     // Catch: java.lang.Throwable -> L5e java.net.URISyntaxException -> L80
            if (r6 == 0) goto L5d
            boolean r7 = r6.delete()
            if (r7 == 0) goto L56
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.urbanairship.UALog.v(r1, r6)
            goto L5d
        L56:
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.urbanairship.UALog.v(r0, r6)
        L5d:
            return r3
        L5e:
            r7 = move-exception
            r3 = r6
            r6 = r7
            goto La3
        L62:
            java.lang.Object r7 = r8.onProcessFile(r6)     // Catch: java.lang.Throwable -> L5e java.net.URISyntaxException -> L80
            if (r2 == 0) goto L7f
            if (r6 == 0) goto L7f
            boolean r8 = r6.delete()
            if (r8 == 0) goto L78
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.urbanairship.UALog.v(r1, r6)
            goto L7f
        L78:
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.urbanairship.UALog.v(r0, r6)
        L7f:
            return r7
        L80:
            java.lang.String r8 = "ImageUtils - Invalid URL: %s "
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch: java.lang.Throwable -> L5e
            com.urbanairship.UALog.e(r8, r7)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto La2
            if (r6 == 0) goto La2
            boolean r7 = r6.delete()
            if (r7 == 0) goto L9b
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.urbanairship.UALog.v(r1, r6)
            goto La2
        L9b:
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.urbanairship.UALog.v(r0, r6)
        La2:
            return r3
        La3:
            if (r2 == 0) goto Lbc
            if (r3 == 0) goto Lbc
            boolean r7 = r3.delete()
            if (r7 == 0) goto Lb5
            java.lang.Object[] r7 = new java.lang.Object[]{r3}
            com.urbanairship.UALog.v(r1, r7)
            goto Lbc
        Lb5:
            java.lang.Object[] r7 = new java.lang.Object[]{r3}
            com.urbanairship.UALog.v(r0, r7)
        Lbc:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.util.ImageUtils.fetchImage(android.content.Context, java.net.URL, com.urbanairship.util.ImageUtils$ImageProcessor):java.lang.Object");
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
