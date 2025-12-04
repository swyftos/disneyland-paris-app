package cucumber.runner;

import cucumber.runtime.HookDefinition;
import java.util.Comparator;

/* loaded from: classes5.dex */
class HookComparator implements Comparator {
    private final boolean ascending;

    HookComparator(boolean z) {
        this.ascending = z;
    }

    @Override // java.util.Comparator
    public int compare(HookDefinition hookDefinition, HookDefinition hookDefinition2) {
        int order = hookDefinition.getOrder();
        int order2 = hookDefinition2.getOrder();
        return this.ascending ? Integer.compare(order, order2) : Integer.compare(order2, order);
    }
}
