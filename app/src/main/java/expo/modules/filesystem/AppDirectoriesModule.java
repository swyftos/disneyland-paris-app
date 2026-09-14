package expo.modules.filesystem;

import android.content.Context;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/filesystem/AppDirectoriesModule;", "Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "Lexpo/modules/core/interfaces/InternalModule;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getExportedInterfaces", "", "Ljava/lang/Class;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "persistentFilesDirectory", "getPersistentFilesDirectory", "expo-file-system_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public class AppDirectoriesModule implements AppDirectoriesModuleInterface, InternalModule {
    private final Context context;

    public AppDirectoriesModule(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // expo.modules.core.interfaces.InternalModule
    @NotNull
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(AppDirectoriesModuleInterface.class);
    }

    @Override // expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface
    @NotNull
    public File getCacheDirectory() {
        File cacheDir = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
        return cacheDir;
    }

    @Override // expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface
    @NotNull
    public File getPersistentFilesDirectory() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        return filesDir;
    }
}
