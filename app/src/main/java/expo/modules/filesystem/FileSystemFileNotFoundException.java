package expo.modules.filesystem;

import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/filesystem/FileSystemFileNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "expo-file-system_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FileSystemFileNotFoundException extends CodedException {
    public FileSystemFileNotFoundException(@Nullable Uri uri) {
        super("File '" + uri + "' could not be deleted because it could not be found", null, 2, null);
    }
}
