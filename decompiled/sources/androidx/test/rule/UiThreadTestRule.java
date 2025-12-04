package androidx.test.rule;

import android.test.UiThreadTest;
import android.util.Log;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Deprecated
/* loaded from: classes2.dex */
public class UiThreadTestRule implements TestRule {
    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return ((statement instanceof FailOnTimeout) || ((statement instanceof UiThreadStatement) && !((UiThreadStatement) statement).isRunOnUiThread())) ? statement : new UiThreadStatement(statement, shouldRunOnUiThread(description));
    }

    protected boolean shouldRunOnUiThread(Description description) {
        if (description.getAnnotation(UiThreadTest.class) == null) {
            return description.getAnnotation(androidx.test.annotation.UiThreadTest.class) != null;
        }
        Log.w("UiThreadTestRule", "Deprecated android.test.UiThreadTest annotation is used! please switch to using androidx.test.annotation.UiThreadTest instead.");
        return true;
    }

    public void runOnUiThread(Runnable runnable) throws Throwable {
        UiThreadStatement.runOnUiThread(runnable);
    }
}
