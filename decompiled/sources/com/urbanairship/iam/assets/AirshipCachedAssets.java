package com.urbanairship.iam.assets;

import android.net.Uri;
import android.os.Parcelable;
import android.util.Size;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "Landroid/os/Parcelable;", "cacheUri", "Landroid/net/Uri;", "remoteUrl", "", "getMediaSize", "Landroid/util/Size;", "isCached", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AirshipCachedAssets extends Parcelable {
    @Nullable
    Uri cacheUri(@NotNull String remoteUrl);

    @NotNull
    Size getMediaSize(@NotNull String remoteUrl);

    boolean isCached(@NotNull String remoteUrl);
}
