package com.contentsquare.android.core.utils;

import android.os.StatFs;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.facebook.react.uimanager.ViewProps;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0016J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u001aJ\u0017\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\bJ\u0015\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\bH\u0001¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bJ*\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010 \u001a\u00020\b2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0)J\u001b\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010+2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u00101\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000bJ\u001e\u00102\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00104\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u0006J \u00105\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/contentsquare/android/core/utils/FileStorageUtil;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "deleteFileOrFolder", "", "filename", "", "deleteRecursive", "fileOrDirectory", "Ljava/io/File;", "getBufferReader", "Ljava/io/BufferedReader;", "inputStreamReader", "Ljava/io/InputStreamReader;", "getBufferReader$core_release", "getFile", "path", "getFileInputStream", "Ljava/io/FileInputStream;", "file", "getFileInputStream$core_release", "getFileOutputStream", "Ljava/io/FileOutputStream;", "append", "getFileOutputStream$core_release", "getInputStreamReader", "fileInputStream", "getInputStreamReader$core_release", "getPhysicalSize", "", "directory", "blockSize", "getStatFs", "Landroid/os/StatFs;", "getStatFs$core_release", "isFolderWritable", "listFiles", "", ViewProps.TRANSFORM, "Lkotlin/Function1;", "listFolder", "", "(Ljava/lang/String;)[Ljava/lang/String;", "mkdirs", "readFileContentAsBytes", "", "readFileContentByLine", "touchFile", "writeBytesToFile", "", "data", "writeStringToFile", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileStorageUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileStorageUtil.kt\ncom/contentsquare/android/core/utils/FileStorageUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,268:1\n11335#2:269\n11670#2,3:270\n13579#2,2:273\n*S KotlinDebug\n*F\n+ 1 FileStorageUtil.kt\ncom/contentsquare/android/core/utils/FileStorageUtil\n*L\n163#1:269\n163#1:270,3\n182#1:273,2\n*E\n"})
/* loaded from: classes2.dex */
public final class FileStorageUtil {

    @NotNull
    public static final String CS_FILES_FOLDER = "cs";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final byte[] INVALID_FILE = new byte[0];

    @NotNull
    private final Logger logger = new Logger("FileStorageUtil");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/core/utils/FileStorageUtil$Companion;", "", "()V", "CS_FILES_FOLDER", "", "INVALID_FILE", "", "getINVALID_FILE", "()[B", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final byte[] getINVALID_FILE() {
            return FileStorageUtil.INVALID_FILE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final long getPhysicalSize(File directory, long blockSize) {
        long length;
        long length2 = directory.length();
        File[] fileArrListFiles = directory.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    Intrinsics.checkNotNullExpressionValue(file, "file");
                    length = getPhysicalSize(file, blockSize);
                } else {
                    length = file.length() % blockSize == 0 ? file.length() : ((file.length() / blockSize) + 1) * blockSize;
                }
                length2 += length;
            }
        }
        return length2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List listFiles$default(FileStorageUtil fileStorageUtil, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<File, String>() { // from class: com.contentsquare.android.core.utils.FileStorageUtil.listFiles.1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(File it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String absolutePath = it.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                    return absolutePath;
                }
            };
        }
        return fileStorageUtil.listFiles(str, function1);
    }

    public static /* synthetic */ void writeStringToFile$default(FileStorageUtil fileStorageUtil, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        fileStorageUtil.writeStringToFile(str, str2, z);
    }

    public final boolean deleteFileOrFolder(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return getFile(filename).delete();
    }

    public final boolean deleteRecursive(File fileOrDirectory) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        if (fileOrDirectory.isDirectory() && (fileArrListFiles = fileOrDirectory.listFiles()) != null) {
            for (File child : fileArrListFiles) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                deleteRecursive(child);
            }
        }
        return fileOrDirectory.delete();
    }

    @VisibleForTesting
    @NotNull
    public final BufferedReader getBufferReader$core_release(InputStreamReader inputStreamReader) {
        return new BufferedReader(inputStreamReader);
    }

    @NotNull
    public final File getFile(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(path);
    }

    @VisibleForTesting
    @NotNull
    public final FileInputStream getFileInputStream$core_release(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new FileInputStream(file);
    }

    @VisibleForTesting
    @NotNull
    public final FileOutputStream getFileOutputStream$core_release(File file, boolean append) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new FileOutputStream(file, append);
    }

    @VisibleForTesting
    @NotNull
    public final InputStreamReader getInputStreamReader$core_release(FileInputStream fileInputStream) {
        return new InputStreamReader(fileInputStream, Charsets.UTF_8);
    }

    @VisibleForTesting
    @NotNull
    public final StatFs getStatFs$core_release(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new StatFs(path);
    }

    public final boolean isFolderWritable(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = getFile(path);
        return file.isDirectory() && file.canRead() && file.canWrite();
    }

    @NotNull
    public final List<String> listFiles(String directory, Function1<? super File, String> transform) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(transform, "transform");
        File[] fileArrListFiles = getFile(directory).listFiles();
        if (fileArrListFiles != null) {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File it : fileArrListFiles) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(transform.invoke(it));
            }
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    @Nullable
    public final String[] listFolder(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = getFile(path);
        if (file.isDirectory() && file.canRead()) {
            return file.list();
        }
        return null;
    }

    public final boolean mkdirs(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return getFile(path).mkdirs();
    }

    @NotNull
    public final byte[] readFileContentAsBytes(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        File file = new File(filename);
        if (!file.exists()) {
            return INVALID_FILE;
        }
        try {
            FileInputStream fileInputStream$core_release = getFileInputStream$core_release(file);
            try {
                byte[] bytes = ByteStreamsKt.readBytes(fileInputStream$core_release);
                CloseableKt.closeFinally(fileInputStream$core_release, null);
                return bytes;
            } finally {
            }
        } catch (IOException e) {
            this.logger.e(e, "Failed while reading file : " + filename);
            return INVALID_FILE;
        }
    }

    @NotNull
    public final List<String> readFileContentByLine(String filename) {
        Logger logger;
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(filename, "filename");
        File file = new File(filename);
        ArrayList arrayList = new ArrayList();
        if (file.exists()) {
            try {
                FileInputStream fileInputStream$core_release = getFileInputStream$core_release(file);
                try {
                    BufferedReader bufferReader$core_release = getBufferReader$core_release(getInputStreamReader$core_release(fileInputStream$core_release));
                    try {
                        arrayList.addAll(TextStreamsKt.readLines(bufferReader$core_release));
                        CloseableKt.closeFinally(bufferReader$core_release, null);
                        CloseableKt.closeFinally(fileInputStream$core_release, null);
                    } finally {
                    }
                } finally {
                }
            } catch (FileNotFoundException e) {
                e = e;
                logger = this.logger;
                sb = new StringBuilder("Failed while reading file : ");
                sb.append(filename);
                logger.e(e, sb.toString());
                return arrayList;
            } catch (IOException e2) {
                e = e2;
                logger = this.logger;
                sb = new StringBuilder("Failed while reading file : ");
                sb.append(filename);
                logger.e(e, sb.toString());
                return arrayList;
            }
        }
        return arrayList;
    }

    public final boolean touchFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            this.logger.e(e, "Failed to create File. exiting... ");
            return false;
        }
    }

    public final void writeBytesToFile(String filename, byte[] data, boolean append) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(data, "data");
        File file = getFile(filename);
        if (!touchFile(file)) {
            this.logger.e("Failed to open File: " + filename);
            return;
        }
        try {
            FileOutputStream fileOutputStream$core_release = getFileOutputStream$core_release(file, append);
            try {
                this.logger.d("Writing to file: " + filename + ", size: " + data.length);
                fileOutputStream$core_release.write(data);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream$core_release, null);
            } finally {
            }
        } catch (IOException e) {
            this.logger.e(e, "Data not written to file. Filename : " + filename);
        }
    }

    public final void writeStringToFile(String filename, String data, boolean append) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(data, "data");
        writeBytesToFile(filename, StringsKt.encodeToByteArray(data), append);
    }

    public final long getPhysicalSize(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return getPhysicalSize(getFile(path), getStatFs$core_release(path).getBlockSizeLong());
    }
}
