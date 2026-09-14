package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import coil3.content.BitmapsKt;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lcoil3/decode/ExifUtils;", "", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "getExifData", "Lcoil3/decode/ExifData;", "mimeType", "", "source", "Lokio/BufferedSource;", "strategy", "Lcoil3/decode/ExifOrientationStrategy;", "reverseTransformations", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nExifUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExifUtils.kt\ncoil3/decode/ExifUtils\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,114:1\n95#2:115\n95#2:116\n43#2,3:117\n*S KotlinDebug\n*F\n+ 1 ExifUtils.kt\ncoil3/decode/ExifUtils\n*L\n60#1:115\n62#1:116\n65#1:117,3\n*E\n"})
public final class ExifUtils {

    @NotNull
    public static final ExifUtils INSTANCE = new ExifUtils();
    private static final Paint paint = new Paint(3);

    private ExifUtils() {
    }

    @NotNull
    public final ExifData getExifData(@Nullable String mimeType, @NotNull BufferedSource source, @NotNull ExifOrientationStrategy strategy) {
        if (strategy.supports(mimeType, source)) {
            ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(source.peek().inputStream()));
            return new ExifData(exifInterface.isFlipped(), exifInterface.getRotationDegrees());
        }
        return ExifData.NONE;
    }

    @NotNull
    public final Bitmap reverseTransformations(@NotNull Bitmap inBitmap, @NotNull ExifData exifData) {
        Bitmap bitmapCreateBitmap;
        if (!exifData.getIsFlipped() && !ExifUtilsKt.isRotated(exifData)) {
            return inBitmap;
        }
        Matrix matrix = new Matrix();
        float width = inBitmap.getWidth() / 2.0f;
        float height = inBitmap.getHeight() / 2.0f;
        if (exifData.getIsFlipped()) {
            matrix.postScale(-1.0f, 1.0f, width, height);
        }
        if (ExifUtilsKt.isRotated(exifData)) {
            matrix.postRotate(exifData.getRotationDegrees(), width, height);
        }
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, inBitmap.getWidth(), inBitmap.getHeight());
        matrix.mapRect(rectF);
        float f = rectF.left;
        if (f != BitmapDescriptorFactory.HUE_RED || rectF.top != BitmapDescriptorFactory.HUE_RED) {
            matrix.postTranslate(-f, -rectF.top);
        }
        if (ExifUtilsKt.isSwapped(exifData)) {
            bitmapCreateBitmap = Bitmap.createBitmap(inBitmap.getHeight(), inBitmap.getWidth(), BitmapsKt.getSafeConfig(inBitmap));
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(inBitmap.getWidth(), inBitmap.getHeight(), BitmapsKt.getSafeConfig(inBitmap));
        }
        new Canvas(bitmapCreateBitmap).drawBitmap(inBitmap, matrix, paint);
        inBitmap.recycle();
        return bitmapCreateBitmap;
    }
}
