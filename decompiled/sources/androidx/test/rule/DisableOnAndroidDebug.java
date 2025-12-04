package androidx.test.rule;

import android.os.Debug;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* loaded from: classes2.dex */
public class DisableOnAndroidDebug implements TestRule {
    private final TestRule rule;

    public DisableOnAndroidDebug(TestRule testRule) {
        this.rule = testRule;
    }

    @Override // org.junit.rules.TestRule
    public final Statement apply(Statement statement, Description description) {
        return isDebugging() ? statement : this.rule.apply(statement, description);
    }

    public boolean isDebugging() {
        return Debug.isDebuggerConnected();
    }
}
