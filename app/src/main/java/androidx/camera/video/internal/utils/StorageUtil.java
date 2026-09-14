package androidx.camera.video.internal.utils;

import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioStats;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(m1835d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0017\u001a\u00020\u00162\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m1836d2 = {"Landroidx/camera/video/internal/utils/StorageUtil;", "", "<init>", "()V", "Ljava/io/File;", "file", "", "getAvailableBytes", "(Ljava/io/File;)J", "", "path", "(Ljava/lang/String;)J", "Landroid/net/Uri;", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "getAvailableBytesForMediaStoreUri", "(Landroid/net/Uri;)J", "bytes", "formatSize", "(J)Ljava/lang/String;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "isStorageFullException", "(Ljava/lang/Exception;)Z", "camera-video_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nStorageUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageUtil.kt\nandroidx/camera/video/internal/utils/StorageUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
public final class StorageUtil {

    @NotNull
    public static final StorageUtil INSTANCE = new StorageUtil();

    private StorageUtil() {
    }

    @JvmStatic
    public static final long getAvailableBytes(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "file.path");
        return getAvailableBytes(path);
    }

    @JvmStatic
    public static final long getAvailableBytes(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new StatFs(path).getAvailableBytes();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r0.equals("external") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r0.equals("external_primary") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r3 = android.os.Environment.getExternalStorageDirectory();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "getExternalStorageDirectory()");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return getAvailableBytes(r3);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long getAvailableBytesForMediaStoreUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!Intrinsics.areEqual(uri.getScheme(), "content")) {
            throw new IllegalStateException(("Not a content uri: " + uri).toString());
        }
        String str = uri.getPathSegments().get(0);
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1921573490) {
                if (iHashCode != -1820761141) {
                    if (iHashCode == 570410685 && str.equals("internal")) {
                        File dataDirectory = Environment.getDataDirectory();
                        Intrinsics.checkNotNullExpressionValue(dataDirectory, "getDataDirectory()");
                        return getAvailableBytes(dataDirectory);
                    }
                }
            }
        }
        Logger.m34w("StorageUtil", "Unknown MediaStore URI: " + uri);
        return Long.MAX_VALUE;
    }

    @JvmStatic
    @NotNull
    public static final String formatSize(long bytes) {
        if (bytes < 0) {
            throw new IllegalArgumentException("Bytes cannot be negative");
        }
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double d = bytes;
        int i = 0;
        double d2 = d;
        while (d2 >= 1024.0d && i < 4) {
            d2 /= 1024.0d;
            i++;
        }
        if (i == 0) {
            return decimalFormat.format(d2) + ' ' + strArr[i];
        }
        StringBuilder sb = new StringBuilder();
        while (-1 < i) {
            double dPow = Math.pow(1024.0d, i);
            double dFloor = Math.floor(d / dPow);
            if (dFloor > AudioStats.AUDIO_AMPLITUDE_NONE) {
                sb.append(decimalFormat.format(dFloor));
                sb.append(" ");
                sb.append(strArr[i]);
                sb.append(" ");
                d -= dFloor * dPow;
            }
            i--;
        }
        return StringsKt.trim(sb).toString();
    }

    @JvmStatic
    public static final boolean isStorageFullException(@NotNull Exception e) {
        String message;
        Intrinsics.checkNotNullParameter(e, "e");
        return (e instanceof FileNotFoundException) && (message = e.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "No space left on device", false, 2, (Object) null);
    }
}
