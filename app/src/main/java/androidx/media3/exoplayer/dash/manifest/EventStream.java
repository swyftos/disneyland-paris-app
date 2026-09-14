package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.emsg.EventMessage;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class EventStream {
    public final EventMessage[] events;
    public final long[] presentationTimesUs;
    public final String schemeIdUri;
    public final long timescale;
    public final String value;

    public EventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.timescale = j;
        this.presentationTimesUs = jArr;
        this.events = eventMessageArr;
    }

    /* JADX INFO: renamed from: id */
    public String m329id() {
        return this.schemeIdUri + "/" + this.value;
    }
}
