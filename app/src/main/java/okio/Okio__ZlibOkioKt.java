package okio;

import kotlin.jvm.internal.Intrinsics;
import okio.internal.ZipFilesKt;

/* JADX INFO: loaded from: classes6.dex */
abstract /* synthetic */ class Okio__ZlibOkioKt {
    public static final FileSystem openZip(FileSystem fileSystem, Path zipPath) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        return ZipFilesKt.openZip$default(zipPath, fileSystem, null, 4, null);
    }
}
