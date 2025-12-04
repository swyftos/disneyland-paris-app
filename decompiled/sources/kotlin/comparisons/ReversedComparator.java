package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class ReversedComparator implements Comparator {
    private final Comparator comparator;

    public ReversedComparator(Comparator comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.comparator = comparator;
    }

    public final Comparator getComparator() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return this.comparator;
    }
}
