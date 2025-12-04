package androidx.test.internal.runner.filters;

import java.util.regex.Pattern;
import org.junit.runner.Description;

/* loaded from: classes2.dex */
public final class TestsRegExFilter extends ParentFilter {
    private Pattern pattern = null;

    public void setPattern(String str) {
        this.pattern = Pattern.compile(str);
    }

    @Override // androidx.test.internal.runner.filters.ParentFilter
    protected boolean evaluateTest(Description description) {
        if (this.pattern == null) {
            return true;
        }
        return this.pattern.matcher(String.format("%s#%s", description.getClassName(), description.getMethodName())).find();
    }

    @Override // org.junit.runner.manipulation.Filter
    public String describe() {
        return "tests filter";
    }
}
