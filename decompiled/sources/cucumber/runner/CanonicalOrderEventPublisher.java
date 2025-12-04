package cucumber.runner;

import cucumber.api.event.Event;
import cucumber.api.event.TestRunFinished;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public class CanonicalOrderEventPublisher extends AbstractEventPublisher {
    private final List queue = new LinkedList();

    public void handle(Event event) {
        this.queue.add(event);
        if (event instanceof TestRunFinished) {
            Collections.sort(this.queue, Event.CANONICAL_ORDER);
            sendAll(this.queue);
            this.queue.clear();
        }
    }
}
