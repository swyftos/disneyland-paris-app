package cucumber.api.event;

import java.util.Comparator;

/* loaded from: classes5.dex */
public interface Event {
    public static final Comparator<Event> CANONICAL_ORDER = new CanonicalEventOrder();

    @Deprecated
    Long getTimeStamp();
}
