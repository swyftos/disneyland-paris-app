package androidx.media3.exoplayer.offline;

import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
/* loaded from: classes.dex */
public interface FilterableManifest<T> {
    T copy(List<StreamKey> list);
}
