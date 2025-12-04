package androidx.test.internal.runner.filters;

import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

/* loaded from: classes2.dex */
public abstract class ParentFilter extends Filter {
    protected abstract boolean evaluateTest(Description description);

    @Override // org.junit.runner.manipulation.Filter
    public boolean shouldRun(Description description) {
        if (description.isTest()) {
            return evaluateTest(description);
        }
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            if (shouldRun(it.next())) {
                return true;
            }
        }
        return false;
    }
}
