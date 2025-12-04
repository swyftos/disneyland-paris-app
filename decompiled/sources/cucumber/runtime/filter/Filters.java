package cucumber.runtime.filter;

import gherkin.events.PickleEvent;
import io.cucumber.core.options.FilterOptions;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class Filters {
    private int count;
    private final List filters;

    public Filters(FilterOptions filterOptions) {
        ArrayList arrayList = new ArrayList();
        this.filters = arrayList;
        List<String> tagFilters = filterOptions.getTagFilters();
        if (!tagFilters.isEmpty()) {
            arrayList.add(new TagPredicate(tagFilters));
        }
        List<Pattern> nameFilters = filterOptions.getNameFilters();
        if (!nameFilters.isEmpty()) {
            arrayList.add(new NamePredicate(nameFilters));
        }
        Map<URI, Set<Integer>> lineFilters = filterOptions.getLineFilters();
        if (!lineFilters.isEmpty()) {
            arrayList.add(new LinePredicate(lineFilters));
        }
        this.count = filterOptions.getLimitCount();
    }

    public boolean matchesFilters(PickleEvent pickleEvent) {
        Iterator it = this.filters.iterator();
        while (it.hasNext()) {
            if (!((PicklePredicate) it.next()).apply(pickleEvent)) {
                return false;
            }
        }
        return true;
    }

    public List<PickleEvent> limitPickleEvents(List<PickleEvent> list) {
        int i;
        return (this.count > list.size() || (i = this.count) < 1) ? list : list.subList(0, i);
    }
}
