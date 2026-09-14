package cucumber.runtime.order;

import gherkin.events.PickleEvent;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface PickleOrder {
    List<PickleEvent> orderPickleEvents(List<PickleEvent> list);
}
