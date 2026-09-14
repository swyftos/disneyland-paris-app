package androidx.media3.extractor.text;

import androidx.media3.common.C0740C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class CuesWithTiming {
    public final ImmutableList<Cue> cues;
    public final long durationUs;
    public final long endTimeUs;
    public final long startTimeUs;

    public CuesWithTiming(List<Cue> list, long j, long j2) {
        this.cues = ImmutableList.copyOf((Collection) list);
        this.startTimeUs = j;
        this.durationUs = j2;
        long j3 = C0740C.TIME_UNSET;
        if (j != C0740C.TIME_UNSET && j2 != C0740C.TIME_UNSET) {
            j3 = j + j2;
        }
        this.endTimeUs = j3;
    }
}
