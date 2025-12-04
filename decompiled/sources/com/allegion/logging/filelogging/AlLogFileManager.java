package com.allegion.logging.filelogging;

import android.content.Context;
import com.allegion.logging.AlLog;
import com.allegion.logging.utility.ZippingUtil;
import java.io.File;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/allegion/logging/filelogging/AlLogFileManager;", "", "()V", "getZipFilePath", "", "fileName", "getZippedLogFiles", "Ljava/io/File;", "context", "Landroid/content/Context;", "Companion", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlLogFileManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_FILES_DIR = "file_log";

    @NotNull
    private static final String ZIP_EXTENSION = ".zip";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/allegion/logging/filelogging/AlLogFileManager$Companion;", "", "()V", "LOG_FILES_DIR", "", "getLOG_FILES_DIR", "()Ljava/lang/String;", "ZIP_EXTENSION", "getZIP_EXTENSION", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getLOG_FILES_DIR() {
            return AlLogFileManager.LOG_FILES_DIR;
        }

        @NotNull
        public final String getZIP_EXTENSION() {
            return AlLogFileManager.ZIP_EXTENSION;
        }
    }

    public static /* synthetic */ File getZippedLogFiles$default(AlLogFileManager alLogFileManager, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = new Date().toString();
            Intrinsics.checkExpressionValueIsNotNull(str, "Date().toString()");
        }
        return alLogFileManager.getZippedLogFiles(context, str);
    }

    @NotNull
    public final File getZippedLogFiles(@NotNull Context context, @NotNull String fileName) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Objects.requireNonNull(context);
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        File filesDir = context.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
        sb.append(filesDir.getPath());
        sb.append(str);
        sb.append(LOG_FILES_DIR);
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        File filesDir2 = context.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir2, "context.filesDir");
        sb2.append(filesDir2.getPath());
        sb2.append(str);
        sb2.append(fileName);
        sb2.append(ZIP_EXTENSION);
        File zippedFile = ZippingUtil.INSTANCE.getZippedFile(string, sb2.toString());
        if (zippedFile.exists() && zippedFile.length() > 0) {
            return zippedFile;
        }
        if (zippedFile.exists() && zippedFile.delete()) {
            AlLog.e("Partial zip file created - [DELETED]", new Object[0]);
        }
        throw new RuntimeException("Failed to perform action. Please try again later.");
    }

    @NotNull
    public final String getZipFilePath(@NotNull String fileName) {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        return Paths.get("", new String[0]).toAbsolutePath().toString() + File.separator + fileName;
    }
}
