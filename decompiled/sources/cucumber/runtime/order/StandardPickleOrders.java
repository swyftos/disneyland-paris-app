package cucumber.runtime.order;

import gherkin.events.PickleEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* loaded from: classes5.dex */
public final class StandardPickleOrders {
    public static PickleOrder lexicalUriOrder() {
        return new PickleOrder() { // from class: cucumber.runtime.order.StandardPickleOrders.1
            @Override // cucumber.runtime.order.PickleOrder
            public List orderPickleEvents(List list) {
                Collections.sort(list, new PickleUriComparator());
                return list;
            }
        };
    }

    public static PickleOrder reverseLexicalUriOrder() {
        return new PickleOrder() { // from class: cucumber.runtime.order.StandardPickleOrders.2
            @Override // cucumber.runtime.order.PickleOrder
            public List orderPickleEvents(List list) {
                Collections.sort(list, new PickleUriComparator());
                Collections.reverse(list);
                return list;
            }
        };
    }

    public static PickleOrder random(final long j) {
        return new PickleOrder() { // from class: cucumber.runtime.order.StandardPickleOrders.3
            @Override // cucumber.runtime.order.PickleOrder
            public List orderPickleEvents(List list) {
                Collections.shuffle(list, new Random(j));
                return list;
            }
        };
    }

    private static class PickleUriComparator implements Comparator {
        private PickleUriComparator() {
        }

        @Override // java.util.Comparator
        public int compare(PickleEvent pickleEvent, PickleEvent pickleEvent2) {
            return pickleEvent.uri.compareTo(pickleEvent2.uri);
        }
    }
}
