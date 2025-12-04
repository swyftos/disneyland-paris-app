package cucumber.runtime.order;

import gherkin.events.PickleEvent;
import java.util.List;

/* loaded from: classes5.dex */
public interface PickleOrder {
    List<PickleEvent> orderPickleEvents(List<PickleEvent> list);
}
