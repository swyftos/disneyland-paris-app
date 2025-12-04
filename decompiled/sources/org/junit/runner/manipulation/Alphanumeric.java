package org.junit.runner.manipulation;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Ordering;

/* loaded from: classes6.dex */
public final class Alphanumeric extends Sorter implements Ordering.Factory {
    private static final Comparator COMPARATOR = new Comparator() { // from class: org.junit.runner.manipulation.Alphanumeric.1
        @Override // java.util.Comparator
        public int compare(Description description, Description description2) {
            return description.getDisplayName().compareTo(description2.getDisplayName());
        }
    };

    @Override // org.junit.runner.manipulation.Ordering.Factory
    public Ordering create(Ordering.Context context) {
        return this;
    }

    public Alphanumeric() {
        super(COMPARATOR);
    }
}
