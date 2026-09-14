package com.google.mlkit.vision.common.internal;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
@KeepForSdk
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    @NonNull
    @KeepForSdk
    public static ImageUtils getInstance() {
        return zzb;
    }

    @NonNull
    @KeepForSdk
    public IObjectWrapper getImageDataWrapper(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
        }
        if (format != 17) {
            if (format == 35) {
                return ObjectWrapper.wrap(inputImage.getMediaImage());
            }
            if (format != 842094169) {
                throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
    }

    @KeepForSdk
    public int getMobileVisionImageFormat(@NonNull InputImage inputImage) {
        return inputImage.getFormat();
    }

    @KeepForSdk
    public int getMobileVisionImageSize(@NonNull InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    @Nullable
    @KeepForSdk
    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:38:0x008b A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x008f A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0096 A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009a A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a1 A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a5 A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ac A[Catch: FileNotFoundException -> 0x0025, TryCatch #3 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:35:0x0071, B:36:0x0086, B:47:0x00b7, B:49:0x00c1, B:38:0x008b, B:39:0x008f, B:40:0x0096, B:41:0x009a, B:42:0x00a1, B:43:0x00a5, B:45:0x00ac, B:34:0x006a, B:31:0x0058, B:51:0x00c6, B:52:0x00cd), top: B:62:0x0004 }] */
    @NonNull
    public final Bitmap zza(@NonNull ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        ExifInterface exifInterface;
        Matrix matrix;
        Matrix matrix2;
        Bitmap bitmapCreateBitmap;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            if (bitmap == null) {
                throw new IOException("The image Uri could not be resolved.");
            }
            int attributeInt = 0;
            if ("content".equals(uri.getScheme()) || "file".equals(uri.getScheme())) {
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            exifInterface = new ExifInterface(inputStreamOpenInputStream);
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        exifInterface = null;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e = e;
                            zza.m1444e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    exifInterface = null;
                    zza.m1444e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                    if (exifInterface == null) {
                        attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                    }
                    matrix = new Matrix();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    switch (attributeInt) {
                        case 2:
                            matrix = new Matrix();
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 3:
                            matrix.postRotate(180.0f);
                            matrix2 = matrix;
                            break;
                        case 4:
                            matrix.postScale(1.0f, -1.0f);
                            matrix2 = matrix;
                            break;
                        case 5:
                            matrix.postRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 6:
                            matrix.postRotate(90.0f);
                            matrix2 = matrix;
                            break;
                        case 7:
                            matrix.postRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 8:
                            matrix.postRotate(-90.0f);
                            matrix2 = matrix;
                            break;
                        default:
                            matrix2 = null;
                            break;
                    }
                    return matrix2 == null ? bitmap : bitmap;
                }
                if (exifInterface == null) {
                    attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                }
            }
            matrix = new Matrix();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            switch (attributeInt) {
                case 2:
                    matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    matrix2 = matrix;
                    break;
                case 4:
                    matrix.postScale(1.0f, -1.0f);
                    matrix2 = matrix;
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    matrix2 = matrix;
                    break;
                case 7:
                    matrix.postRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 8:
                    matrix.postRotate(-90.0f);
                    matrix2 = matrix;
                    break;
                default:
                    matrix2 = null;
                    break;
            }
            if (matrix2 == null && bitmap != (bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix2, true))) {
                bitmap.recycle();
                return bitmapCreateBitmap;
            }
        } catch (FileNotFoundException e3) {
            zza.m1444e("MLKitImageUtils", "Could not open file: ".concat(String.valueOf(uri)), e3);
            throw e3;
        }
    }
}
