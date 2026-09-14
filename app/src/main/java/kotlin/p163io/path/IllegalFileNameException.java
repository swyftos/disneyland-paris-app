package kotlin.p163io.path;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m1836d2 = {"Lkotlin/io/path/IllegalFileNameException;", "Ljava/nio/file/FileSystemException;", "file", "Ljava/nio/file/Path;", "(Ljava/nio/file/Path;)V", ETCPaymentMethod.OTHER, "message", "", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/String;)V", "kotlin-stdlib-jdk7"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class IllegalFileNameException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalFileNameException(@NotNull Path file, @Nullable Path path, @Nullable String str) {
        super(file.toString(), path != null ? path.toString() : null, str);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IllegalFileNameException(@NotNull Path file) {
        this(file, null, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
