package kotlin.p163io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@SinceKotlin(version = "1.8")
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1836d2 = {"Lkotlin/io/path/CopyActionContext;", "", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", TypedValues.AttributesType.S_TARGET, "followLinks", "", "kotlin-stdlib-jdk7"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@ExperimentalPathApi
public interface CopyActionContext {
    @NotNull
    CopyActionResult copyToIgnoringExistingDirectory(@NotNull Path path, @NotNull Path path2, boolean z);
}
