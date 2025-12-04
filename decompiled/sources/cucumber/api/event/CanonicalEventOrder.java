package cucumber.api.event;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes5.dex */
final class CanonicalEventOrder implements Comparator {
    private static final FixedEventOrderComparator fixedOrder;
    private static final TestCaseEventComparator testCaseOrder;

    CanonicalEventOrder() {
    }

    static {
        fixedOrder = new FixedEventOrderComparator();
        testCaseOrder = new TestCaseEventComparator();
    }

    @Override // java.util.Comparator
    public int compare(Event event, Event event2) {
        int iCompare = fixedOrder.compare(event, event2);
        return (iCompare == 0 && (event instanceof TestCaseEvent) && (event2 instanceof TestCaseEvent)) ? testCaseOrder.compare((TestCaseEvent) event, (TestCaseEvent) event2) : iCompare;
    }

    private static final class FixedEventOrderComparator implements Comparator {
        private final List fixedOrder;

        private FixedEventOrderComparator() {
            this.fixedOrder = Arrays.asList(TestRunStarted.class, TestSourceRead.class, SnippetsSuggestedEvent.class, StepDefinedEvent.class, TestCaseEvent.class, TestRunFinished.class);
        }

        @Override // java.util.Comparator
        public int compare(Event event, Event event2) {
            return Integer.compare(requireInFixOrder(event.getClass()), requireInFixOrder(event2.getClass()));
        }

        private int requireInFixOrder(Class cls) {
            int iFindInFixedOrder = findInFixedOrder(cls);
            if (iFindInFixedOrder >= 0) {
                return iFindInFixedOrder;
            }
            throw new IllegalStateException(cls + "was not in " + this.fixedOrder);
        }

        private int findInFixedOrder(Class cls) {
            for (int i = 0; i < this.fixedOrder.size(); i++) {
                if (((Class) this.fixedOrder.get(i)).isAssignableFrom(cls)) {
                    return i;
                }
            }
            return -1;
        }
    }

    private static final class TestCaseEventComparator implements Comparator {
        private TestCaseEventComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TestCaseEvent testCaseEvent, TestCaseEvent testCaseEvent2) {
            int iCompareTo = testCaseEvent.getTestCase().getUri().compareTo(testCaseEvent2.getTestCase().getUri());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompare = Integer.compare(testCaseEvent.getTestCase().getLine(), testCaseEvent2.getTestCase().getLine());
            return iCompare != 0 ? iCompare : Long.compare(testCaseEvent.getTimeStamp().longValue(), testCaseEvent2.getTimeStamp().longValue());
        }
    }
}
