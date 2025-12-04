package io.cucumber.datatable.dependency.difflib;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes5.dex */
public class DeltaComparator implements Comparator<Delta<?>>, Serializable {
    public static final Comparator<Delta<?>> INSTANCE = new DeltaComparator();
    private static final long serialVersionUID = 1;

    private DeltaComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Delta<?> delta, Delta<?> delta2) {
        int position = delta.getOriginal().getPosition();
        int position2 = delta2.getOriginal().getPosition();
        if (position > position2) {
            return 1;
        }
        return position < position2 ? -1 : 0;
    }
}
