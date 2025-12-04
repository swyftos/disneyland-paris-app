package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.runner.Description;

/* loaded from: classes6.dex */
public class Sorter extends Ordering implements Comparator<Description> {
    public static final Sorter NULL = new Sorter(new Comparator() { // from class: org.junit.runner.manipulation.Sorter.1
        @Override // java.util.Comparator
        public int compare(Description description, Description description2) {
            return 0;
        }
    });
    private final Comparator comparator;

    @Override // org.junit.runner.manipulation.Ordering
    boolean validateOrderingIsCorrect() {
        return false;
    }

    public Sorter(Comparator<Description> comparator) {
        this.comparator = comparator;
    }

    @Override // org.junit.runner.manipulation.Ordering
    public void apply(Object obj) {
        if (obj instanceof Sortable) {
            ((Sortable) obj).sort(this);
        }
    }

    @Override // java.util.Comparator
    public int compare(Description description, Description description2) {
        return this.comparator.compare(description, description2);
    }

    @Override // org.junit.runner.manipulation.Ordering
    protected final List<Description> orderItems(Collection<Description> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, this);
        return arrayList;
    }
}
