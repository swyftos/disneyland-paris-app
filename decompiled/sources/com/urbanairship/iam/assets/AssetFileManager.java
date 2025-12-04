package com.urbanairship.iam.assets;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/assets/AssetFileManager;", "", "assetItemExists", "", "cacheUri", "Landroid/net/Uri;", "clearAssets", "", "identifier", "", "ensureCacheDirectory", "Ljava/io/File;", "getRootDirectory", "moveAsset", "from", TypedValues.TransitionType.S_TO, "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AssetFileManager {
    boolean assetItemExists(@NotNull Uri cacheUri) throws IOException;

    void clearAssets(@NotNull String identifier) throws IOException;

    @NotNull
    File ensureCacheDirectory(@NotNull String identifier) throws IOException;

    @NotNull
    Uri getRootDirectory() throws IOException;

    void moveAsset(@NotNull Uri from, @NotNull Uri to) throws IOException;
}
