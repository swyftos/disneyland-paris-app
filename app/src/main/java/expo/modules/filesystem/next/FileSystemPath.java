package expo.modules.filesystem.next;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p163io.FilesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\nH&J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0000J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0019"}, m1836d2 = {"Lexpo/modules/filesystem/next/FileSystemPath;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "setFile", "delete", "", "fileOrDirectory", "validateType", "getMoveOrCopyPath", "destination", "validatePermission", "", "permission", "Lexpo/modules/interfaces/filesystem/Permission;", "validateCanCreate", "options", "Lexpo/modules/filesystem/next/CreateOptions;", "copy", TypedValues.TransitionType.S_TO, "move", "expo-file-system_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nFileSystemPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystemPath.kt\nexpo/modules/filesystem/next/FileSystemPath\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,106:1\n13409#2,2:107\n*S KotlinDebug\n*F\n+ 1 FileSystemPath.kt\nexpo/modules/filesystem/next/FileSystemPath\n*L\n20#1:107,2\n*E\n"})
public abstract class FileSystemPath extends SharedObject {
    private File file;

    public abstract void validateType();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemPath(@NotNull File file) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    public final void setFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        this.file = file;
    }

    public static /* synthetic */ void delete$default(FileSystemPath fileSystemPath, File file, int i, Object obj) throws UnableToDeleteException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i & 1) != 0) {
            file = fileSystemPath.file;
        }
        fileSystemPath.delete(file);
    }

    public final void delete(@NotNull File fileOrDirectory) throws UnableToDeleteException {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        if (!fileOrDirectory.exists()) {
            throw new UnableToDeleteException("path '" + fileOrDirectory.getPath() + "' does not exist");
        }
        if (fileOrDirectory.isDirectory() && (fileArrListFiles = fileOrDirectory.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    Intrinsics.checkNotNull(file);
                    delete(file);
                } else if (!file.delete()) {
                    throw new UnableToDeleteException("failed to delete '" + file.getPath() + "'");
                }
            }
        }
        if (fileOrDirectory.delete()) {
            return;
        }
        throw new UnableToDeleteException("failed to delete '" + fileOrDirectory.getPath() + "'");
    }

    @NotNull
    public final File getMoveOrCopyPath(@NotNull FileSystemPath destination) throws DestinationDoesNotExistException, CopyOrMoveDirectoryToFileException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FileSystemDirectory) {
            if (this instanceof FileSystemFile) {
                if (!((FileSystemDirectory) destination).getExists()) {
                    throw new DestinationDoesNotExistException();
                }
                return new File(destination.file, this.file.getName());
            }
            if (((FileSystemDirectory) destination).getExists()) {
                return new File(destination.file, this.file.getName());
            }
            File parentFile = destination.file.getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                throw new DestinationDoesNotExistException();
            }
            return destination.file;
        }
        if (!(this instanceof FileSystemFile)) {
            throw new CopyOrMoveDirectoryToFileException();
        }
        File parentFile2 = destination.file.getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            throw new DestinationDoesNotExistException();
        }
        return destination.file;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    public final boolean validatePermission(@NotNull Permission permission) {
        EnumSet<Permission> enumSetNoneOf;
        FilePermissionModuleInterface filePermission;
        Intrinsics.checkNotNullParameter(permission, "permission");
        AppContext appContext = getAppContext();
        if (appContext == null || (filePermission = appContext.getFilePermission()) == null) {
            enumSetNoneOf = EnumSet.noneOf(Permission.class);
        } else {
            AppContext appContext2 = getAppContext();
            enumSetNoneOf = filePermission.getPathPermissions(appContext2 != null ? appContext2.getReactContext() : null, this.file.getPath());
            if (enumSetNoneOf == null) {
                enumSetNoneOf = EnumSet.noneOf(Permission.class);
            }
        }
        if (enumSetNoneOf.contains(permission)) {
            return true;
        }
        throw new InvalidPermissionException(permission);
    }

    public final void validateCanCreate(@NotNull CreateOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!options.getOverwrite() && this.file.exists()) {
            throw new UnableToCreateException("it already exists");
        }
    }

    public final void copy(@NotNull FileSystemPath to) {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(Permission.READ);
        to.validatePermission(Permission.WRITE);
        FilesKt.copyRecursively$default(this.file, getMoveOrCopyPath(to), false, null, 6, null);
    }

    public final void move(@NotNull FileSystemPath to) throws DestinationDoesNotExistException, CopyOrMoveDirectoryToFileException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        Permission permission = Permission.WRITE;
        validatePermission(permission);
        to.validatePermission(permission);
        File moveOrCopyPath = getMoveOrCopyPath(to);
        Path path = this.file.toPath();
        Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
        Path path2 = moveOrCopyPath.toPath();
        Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
        Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        this.file = moveOrCopyPath;
    }
}
