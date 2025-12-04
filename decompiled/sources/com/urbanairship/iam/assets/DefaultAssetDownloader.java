package com.urbanairship.iam.assets;

import android.content.Context;
import android.net.Uri;
import com.urbanairship.util.FileUtils;
import com.urbanairship.util.UriExtensionsKt;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/assets/DefaultAssetDownloader;", "Lcom/urbanairship/iam/assets/AssetDownloader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheFolder", "Ljava/io/File;", "downloadAsset", "Landroid/net/Uri;", "remoteUri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAssetDownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssetDownloader.kt\ncom/urbanairship/iam/assets/DefaultAssetDownloader\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,35:1\n36#2:36\n*S KotlinDebug\n*F\n+ 1 AssetDownloader.kt\ncom/urbanairship/iam/assets/DefaultAssetDownloader\n*L\n31#1:36\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultAssetDownloader implements AssetDownloader {
    private final File cacheFolder;

    public DefaultAssetDownloader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File cacheDir = context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
        this.cacheFolder = cacheDir;
    }

    @Override // com.urbanairship.iam.assets.AssetDownloader
    @Nullable
    public Object downloadAsset(@NotNull Uri uri, @NotNull Continuation<? super Uri> continuation) throws Throwable {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return null;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        File file = new File(this.cacheFolder, string + '-' + lastPathSegment);
        FileUtils.downloadFile(UriExtensionsKt.toURL(uri), file);
        return Uri.fromFile(file);
    }
}
