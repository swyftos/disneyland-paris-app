package androidx.media3.exoplayer.hls;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super("Unable to bind a sample queue to TrackGroup with MIME type " + str + InstructionFileId.DOT);
    }
}
