package cucumber.runtime.filter;

import gherkin.events.PickleEvent;
import gherkin.pickles.PickleLocation;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
class LinePredicate implements PicklePredicate {
    private Map lineFilters;

    LinePredicate(Map map) {
        this.lineFilters = map;
    }

    @Override // cucumber.runtime.filter.PicklePredicate
    public boolean apply(PickleEvent pickleEvent) {
        URI uriCreate = URI.create(pickleEvent.uri);
        if (!this.lineFilters.containsKey(uriCreate)) {
            return true;
        }
        for (Integer num : (Collection) this.lineFilters.get(uriCreate)) {
            Iterator<PickleLocation> it = pickleEvent.pickle.getLocations().iterator();
            while (it.hasNext()) {
                if (num.intValue() == it.next().getLine()) {
                    return true;
                }
            }
        }
        return false;
    }
}
