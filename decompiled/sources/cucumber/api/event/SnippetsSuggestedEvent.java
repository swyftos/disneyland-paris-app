package cucumber.api.event;

import gherkin.pickles.PickleLocation;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class SnippetsSuggestedEvent extends TimeStampedEvent {
    public final List<String> snippets;
    public final List<PickleLocation> stepLocations;
    public final String uri;

    @Override // cucumber.api.event.TimeStampedEvent, cucumber.api.event.Event
    public /* bridge */ /* synthetic */ Long getTimeStamp() {
        return super.getTimeStamp();
    }

    @Override // cucumber.api.event.TimeStampedEvent
    public /* bridge */ /* synthetic */ long getTimeStampMillis() {
        return super.getTimeStampMillis();
    }

    @Deprecated
    public SnippetsSuggestedEvent(Long l, String str, List<PickleLocation> list, List<String> list2) {
        this(l, 0L, str, list, list2);
    }

    public SnippetsSuggestedEvent(Long l, long j, String str, List<PickleLocation> list, List<String> list2) {
        super(l, Long.valueOf(j));
        this.uri = str;
        this.stepLocations = list;
        this.snippets = Collections.unmodifiableList(list2);
    }
}
