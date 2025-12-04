package androidx.test.internal.runner.listener;

import android.util.Log;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public class LogRunListener extends RunListener {
    @Override // org.junit.runner.notification.RunListener
    public void testRunStarted(Description description) throws Exception {
        Log.i("TestRunner", String.format("run started: %d tests", Integer.valueOf(description.testCount())));
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(Result result) throws Exception {
        Log.i("TestRunner", String.format("run finished: %d tests, %d failed, %d ignored", Integer.valueOf(result.getRunCount()), Integer.valueOf(result.getFailureCount()), Integer.valueOf(result.getIgnoreCount())));
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) throws Exception {
        String strValueOf = String.valueOf(description.getDisplayName());
        Log.i("TestRunner", strValueOf.length() != 0 ? "started: ".concat(strValueOf) : new String("started: "));
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) throws Exception {
        String strValueOf = String.valueOf(description.getDisplayName());
        Log.i("TestRunner", strValueOf.length() != 0 ? "finished: ".concat(strValueOf) : new String("finished: "));
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) throws Exception {
        String strValueOf = String.valueOf(failure.getDescription().getDisplayName());
        Log.e("TestRunner", strValueOf.length() != 0 ? "failed: ".concat(strValueOf) : new String("failed: "));
        Log.e("TestRunner", "----- begin exception -----");
        Log.e("TestRunner", failure.getTrace());
        Log.e("TestRunner", "----- end exception -----");
    }

    @Override // org.junit.runner.notification.RunListener
    public void testAssumptionFailure(Failure failure) {
        String strValueOf = String.valueOf(failure.getDescription().getDisplayName());
        Log.e("TestRunner", strValueOf.length() != 0 ? "assumption failed: ".concat(strValueOf) : new String("assumption failed: "));
        Log.e("TestRunner", "----- begin exception -----");
        Log.e("TestRunner", failure.getTrace());
        Log.e("TestRunner", "----- end exception -----");
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) throws Exception {
        String strValueOf = String.valueOf(description.getDisplayName());
        Log.i("TestRunner", strValueOf.length() != 0 ? "ignored: ".concat(strValueOf) : new String("ignored: "));
    }
}
