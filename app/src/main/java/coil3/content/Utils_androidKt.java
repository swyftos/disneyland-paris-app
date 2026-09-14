package coil3.content;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil3.BitmapImage;
import coil3.Image;
import coil3.Uri;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.size.Scale;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0003H\u0002\u001a\b\u0010\u001f\u001a\u00020\u0012H\u0000\u001a3\u0010)\u001a\u0004\u0018\u00010\u0013*\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00132\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\b2\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\u0010.\u001a\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0000\u001a\f\u00108\u001a\u00020\u0001*\u000209H\u0000\"\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\b*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014\"\u0018\u0010\u0015\u001a\u00020\b*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0018\u0010\u0018\u001a\u00020\b*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\"\u0018\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0080\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$\"\u0014\u0010&\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\"\u000e\u0010/\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u00103\u001a\u000204*\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006:"}, m1836d2 = {"println", "", "level", "Lcoil3/util/Logger$Level;", "tag", "", "message", "toInt", "", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "isVector", "", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)Z", "width", "getWidth", "(Landroid/graphics/drawable/Drawable;)I", "height", "getHeight", "safeCacheDir", "Ljava/io/File;", "Landroid/content/Context;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "isMainThread", "VALID_TRANSFORMATION_CONFIGS", "", "Landroid/graphics/Bitmap$Config;", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "getDrawableCompat", "Lcoil3/request/ImageRequest;", "drawable", "resId", "default", "(Lcoil3/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "ASSET_FILE_PATH_ROOT", "isAssetUri", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Lcoil3/Uri;", "scale", "Lcoil3/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil3/size/Scale;", "prepareToDraw", "Lcoil3/Image;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nutils.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.android.kt\ncoil3/util/Utils_androidKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
public final class Utils_androidKt {

    @NotNull
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    private static final ColorSpace NULL_COLOR_SPACE = null;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = {Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG = Bitmap.Config.HARDWARE;

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Logger.Level.values().length];
            try {
                iArr[Logger.Level.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Logger.Level.Debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Logger.Level.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Logger.Level.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Logger.Level.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void println(@NotNull Logger.Level level, @NotNull String str, @NotNull String str2) {
        Log.println(toInt(level), str, str2);
    }

    private static final int toInt(Logger.Level level) {
        int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            return 2;
        }
        int i2 = 3;
        if (i != 2) {
            if (i == 3) {
                return 4;
            }
            i2 = 5;
            if (i != 4) {
                if (i == 5) {
                    return 6;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return i2;
    }

    @Nullable
    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final int getNightMode(@NotNull Configuration configuration) {
        return configuration.uiMode & 48;
    }

    public static final boolean isVector(@NotNull Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final int getWidth(@NotNull Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final int getHeight(@NotNull Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    @NotNull
    public static final File getSafeCacheDir(@NotNull Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null");
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @NotNull
    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    @NotNull
    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    @Nullable
    public static final Drawable getDrawableCompat(@NotNull ImageRequest imageRequest, @Nullable Drawable drawable, @DrawableRes @Nullable Integer num, @Nullable Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() != 0) {
            return Context.getDrawableCompat(imageRequest.getContext(), num.intValue());
        }
        return null;
    }

    public static final boolean isAssetUri(@NotNull Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "file") && Intrinsics.areEqual(CollectionsKt.firstOrNull((List) UriKt.getPathSegments(uri)), ASSET_FILE_PATH_ROOT);
    }

    @NotNull
    public static final Scale getScale(@NotNull ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final void prepareToDraw(@NotNull Image image) {
        if (image instanceof BitmapImage) {
            ((BitmapImage) image).getBitmap().prepareToDraw();
        }
    }
}
