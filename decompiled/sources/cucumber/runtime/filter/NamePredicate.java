package cucumber.runtime.filter;

import gherkin.events.PickleEvent;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class NamePredicate implements PicklePredicate {
    private List patterns;

    NamePredicate(List list) {
        this.patterns = list;
    }

    @Override // cucumber.runtime.filter.PicklePredicate
    public boolean apply(PickleEvent pickleEvent) {
        String name = pickleEvent.pickle.getName();
        Iterator it = this.patterns.iterator();
        while (it.hasNext()) {
            if (((Pattern) it.next()).matcher(name).find()) {
                return true;
            }
        }
        return false;
    }
}
