package androidx.media3.exoplayer.metadata;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface MetadataOutput {
    void onMetadata(Metadata metadata);
}
