package com.facebook.fresco.vito.source;

import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, m1836d2 = {"Lcom/facebook/fresco/vito/source/SingleImageSource;", "Lcom/facebook/fresco/vito/source/UriImageSource;", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "getStringExtra", "", "key", "source_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface SingleImageSource extends UriImageSource {
    @Nullable
    String getStringExtra(@NotNull String key);

    @NotNull
    Uri getUri();
}
