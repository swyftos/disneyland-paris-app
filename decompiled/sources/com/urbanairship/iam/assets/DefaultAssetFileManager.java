package com.urbanairship.iam.assets;

import android.content.Context;
import android.net.Uri;
import android.os.storage.StorageManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.net.UriKt;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.UALog;
import com.urbanairship.util.FileUtils;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/assets/DefaultAssetFileManager;", "Lcom/urbanairship/iam/assets/AssetFileManager;", "context", "Landroid/content/Context;", "rootFolder", "", "(Landroid/content/Context;Ljava/lang/String;)V", "Ljava/io/File;", "storageManager", "Landroid/os/storage/StorageManager;", "assetItemExists", "", "cacheUri", "Landroid/net/Uri;", "clearAssets", "", "identifier", "ensureCacheDirectory", "ensureRootCacheDirectory", "getRootDirectory", "moveAsset", "from", TypedValues.TransitionType.S_TO, "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAssetFileManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssetFileManager.kt\ncom/urbanairship/iam/assets/DefaultAssetFileManager\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,135:1\n36#2:136\n*S KotlinDebug\n*F\n+ 1 AssetFileManager.kt\ncom/urbanairship/iam/assets/DefaultAssetFileManager\n*L\n128#1:136\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultAssetFileManager implements AssetFileManager {
    private final File rootFolder;
    private final StorageManager storageManager;

    public DefaultAssetFileManager(@NotNull Context context, @NotNull String rootFolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootFolder, "rootFolder");
        this.rootFolder = new File(context.getCacheDir(), rootFolder);
        Object systemService = context.getSystemService("storage");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        this.storageManager = (StorageManager) systemService;
    }

    public /* synthetic */ DefaultAssetFileManager(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "com.urbanairship.iam.assets" : str);
    }

    @Override // com.urbanairship.iam.assets.AssetFileManager
    @NotNull
    public Uri getRootDirectory() throws IOException {
        return ensureRootCacheDirectory();
    }

    @Override // com.urbanairship.iam.assets.AssetFileManager
    @NotNull
    public File ensureCacheDirectory(@NotNull String identifier) throws IOException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        ensureRootCacheDirectory();
        final File file = new File(this.rootFolder, identifier);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Failed to create cache sub-folder! " + identifier);
        }
        try {
            this.storageManager.setCacheBehaviorGroup(file, true);
        } catch (IOException e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.assets.DefaultAssetFileManager.ensureCacheDirectory.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to set cache behavior group! " + file;
                }
            });
        }
        return file;
    }

    @Override // com.urbanairship.iam.assets.AssetFileManager
    public boolean assetItemExists(@NotNull Uri cacheUri) throws IOException {
        Intrinsics.checkNotNullParameter(cacheUri, "cacheUri");
        return UriKt.toFile(cacheUri).exists();
    }

    @Override // com.urbanairship.iam.assets.AssetFileManager
    public void moveAsset(@NotNull final Uri from, @NotNull final Uri to) throws IOException {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        File file = UriKt.toFile(from);
        if (!file.exists()) {
            throw new IOException("can't find file at " + from);
        }
        File file2 = UriKt.toFile(to);
        if (file2.exists()) {
            file2.delete();
        }
        if (!file.renameTo(file2)) {
            try {
                FilesKt.copyTo$default(file, file2, true, 0, 4, null);
                file.delete();
            } catch (Exception e) {
                UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.assets.DefaultAssetFileManager.moveAsset.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to copy asset file from '" + from + "' to '" + to + CoreConstants.SINGLE_QUOTE_CHAR;
                    }
                });
                return;
            }
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAssetFileManager.moveAsset.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Moved asset file from '" + from + "' to '" + to + CoreConstants.SINGLE_QUOTE_CHAR;
            }
        }, 1, null);
    }

    @Override // com.urbanairship.iam.assets.AssetFileManager
    public void clearAssets(@NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        FileUtils.deleteRecursively(new File(this.rootFolder, identifier));
    }

    private final Uri ensureRootCacheDirectory() throws IOException {
        if (this.rootFolder.exists() || this.rootFolder.mkdirs() || this.rootFolder.exists()) {
            return Uri.fromFile(this.rootFolder);
        }
        throw new IOException("Failed to create cache folder: " + this.rootFolder.getPath());
    }
}
