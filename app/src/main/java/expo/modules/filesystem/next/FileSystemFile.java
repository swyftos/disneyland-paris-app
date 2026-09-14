package expo.modules.filesystem.next;

import android.net.Uri;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.typedarray.TypedArray;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p163io.CloseableKt;
import kotlin.p163io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00128F¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b#\u0010\u001d¨\u0006$"}, m1836d2 = {"Lexpo/modules/filesystem/next/FileSystemFile;", "Lexpo/modules/filesystem/next/FileSystemPath;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "validatePath", "", "validateType", "exists", "", "getExists", "()Z", "create", "options", "Lexpo/modules/filesystem/next/CreateOptions;", "write", "content", "", "Lexpo/modules/kotlin/typedarray/TypedArray;", "asString", "text", "base64", "bytes", "", "md5", "getMd5$annotations", "()V", "getMd5", "()Ljava/lang/String;", TCEventPropertiesNames.TCP_SIZE, "", "getSize", "()Ljava/lang/Long;", "type", "getType", "expo-file-system_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nFileSystemFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystemFile.kt\nexpo/modules/filesystem/next/FileSystemFile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n1#2:116\n*E\n"})
public final class FileSystemFile extends FileSystemPath {
    public static /* synthetic */ void getMd5$annotations() {
    }

    public final void validatePath() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemFile(@NotNull File file) {
        super(file);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // expo.modules.filesystem.next.FileSystemPath
    public void validateType() throws InvalidTypeFileException {
        validatePermission(Permission.READ);
        if (getFile().exists() && getFile().isDirectory()) {
            throw new InvalidTypeFileException();
        }
    }

    public final boolean getExists() {
        validatePermission(Permission.READ);
        return getFile().isFile();
    }

    public static /* synthetic */ void create$default(FileSystemFile fileSystemFile, CreateOptions createOptions, int i, Object obj) throws UnableToCreateException, InvalidTypeFileException {
        if ((i & 1) != 0) {
            createOptions = new CreateOptions(false, false, 3, null);
        }
        fileSystemFile.create(createOptions);
    }

    public final void create(@NotNull CreateOptions options) throws UnableToCreateException, InvalidTypeFileException {
        File parentFile;
        Intrinsics.checkNotNullParameter(options, "options");
        validateType();
        validatePermission(Permission.WRITE);
        validateCanCreate(options);
        if (options.getOverwrite() && getFile().exists()) {
            getFile().delete();
        }
        if (options.getIntermediates() && (parentFile = getFile().getParentFile()) != null) {
            parentFile.mkdirs();
        }
        if (!getFile().createNewFile()) {
            throw new UnableToCreateException("file already exists or could not be created");
        }
    }

    public final void write(@NotNull String content) throws UnableToCreateException, InvalidTypeFileException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getFile());
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public final void write(@NotNull TypedArray content) throws UnableToCreateException, InvalidTypeFileException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getFile());
        try {
            fileOutputStream.getChannel().write(content.toDirectBuffer());
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    @NotNull
    public final String asString() {
        String string = Uri.fromFile(getFile()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.endsWith$default(string, "/", false, 2, (Object) null) ? StringsKt.dropLast(string, 1) : string;
    }

    @NotNull
    public final String text() throws InvalidTypeFileException {
        validateType();
        validatePermission(Permission.READ);
        return FilesKt.readText$default(getFile(), null, 1, null);
    }

    @NotNull
    public final String base64() throws InvalidTypeFileException {
        validateType();
        validatePermission(Permission.READ);
        String strEncodeToString = Base64.encodeToString(FilesKt.readBytes(getFile()), 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    @NotNull
    public final byte[] bytes() throws InvalidTypeFileException {
        validateType();
        validatePermission(Permission.READ);
        return FilesKt.readBytes(getFile());
    }

    @NotNull
    public final String getMd5() {
        validatePermission(Permission.READ);
        byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(FilesKt.readBytes(getFile()));
        Intrinsics.checkNotNull(bArrDigest);
        return HexExtensionsKt.toHexString$default(bArrDigest, (HexFormat) null, 1, (Object) null);
    }

    @Nullable
    public final Long getSize() {
        if (getFile().exists()) {
            return Long.valueOf(getFile().length());
        }
        return null;
    }

    @Nullable
    public final String getType() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getFile().getPath());
        if (fileExtensionFromUrl == null) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }
}
