package expo.modules.filesystem.next;

import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u0011J\u0006\u0010\u0015\u001a\u00020\u0013R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m1836d2 = {"Lexpo/modules/filesystem/next/FileSystemDirectory;", "Lexpo/modules/filesystem/next/FileSystemPath;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "validatePath", "", "validateType", "exists", "", "getExists", "()Z", "create", "options", "Lexpo/modules/filesystem/next/CreateOptions;", "listAsRecords", "", "", "", "", "asString", "expo-file-system_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nFileSystemDirectory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystemDirectory.kt\nexpo/modules/filesystem/next/FileSystemDirectory\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,58:1\n11165#2:59\n11500#2,3:60\n*S KotlinDebug\n*F\n+ 1 FileSystemDirectory.kt\nexpo/modules/filesystem/next/FileSystemDirectory\n*L\n44#1:59\n44#1:60,3\n*E\n"})
public final class FileSystemDirectory extends FileSystemPath {
    public final void validatePath() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemDirectory(@NotNull File file) {
        super(file);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // expo.modules.filesystem.next.FileSystemPath
    public void validateType() throws InvalidTypeFolderException {
        if (getFile().exists() && !getFile().isDirectory()) {
            throw new InvalidTypeFolderException();
        }
    }

    public final boolean getExists() {
        validatePermission(Permission.READ);
        return getFile().isDirectory();
    }

    public static /* synthetic */ void create$default(FileSystemDirectory fileSystemDirectory, CreateOptions createOptions, int i, Object obj) throws UnableToCreateException, InvalidTypeFolderException {
        if ((i & 1) != 0) {
            createOptions = new CreateOptions(false, false, 3, null);
        }
        fileSystemDirectory.create(createOptions);
    }

    public final void create(@NotNull CreateOptions options) throws UnableToCreateException, InvalidTypeFolderException {
        boolean zMkdir;
        Intrinsics.checkNotNullParameter(options, "options");
        validateType();
        validatePermission(Permission.WRITE);
        validateCanCreate(options);
        if (options.getOverwrite() && getFile().exists()) {
            getFile().delete();
        }
        if (options.getIntermediates()) {
            zMkdir = getFile().mkdirs();
        } else {
            zMkdir = getFile().mkdir();
        }
        if (!zMkdir) {
            throw new UnableToCreateException("directory already exists or could not be created");
        }
    }

    @NotNull
    public final List<Map<String, Object>> listAsRecords() throws InvalidTypeFolderException {
        validateType();
        validatePermission(Permission.READ);
        File[] fileArrListFiles = getFile().listFiles();
        if (fileArrListFiles == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file : fileArrListFiles) {
            String string = Uri.fromFile(file).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Pair pairM1842to = TuplesKt.m1842to("isDirectory", Boolean.valueOf(file.isDirectory()));
            if (!StringsKt.endsWith$default(string, "/", false, 2, (Object) null)) {
                string = string + "/";
            }
            arrayList.add(MapsKt.mapOf(pairM1842to, TuplesKt.m1842to(ReactNativeBlobUtilConst.DATA_ENCODE_URI, string)));
        }
        return arrayList;
    }

    @NotNull
    public final String asString() {
        String string = Uri.fromFile(getFile()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (StringsKt.endsWith$default(string, "/", false, 2, (Object) null)) {
            return string;
        }
        return string + "/";
    }
}
