package androidx.test.internal.runner.listener;

import android.os.Bundle;
import android.util.Log;
import androidx.test.services.events.internal.StackTrimmer;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.PrintStream;
import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/* loaded from: classes2.dex */
public class InstrumentationResultPrinter extends InstrumentationRunListener {
    public static final String REPORT_KEY_NAME_CLASS = "class";
    public static final String REPORT_KEY_NAME_TEST = "test";
    public static final String REPORT_KEY_NUM_CURRENT = "current";
    public static final String REPORT_KEY_NUM_TOTAL = "numtests";
    public static final String REPORT_KEY_STACK = "stack";
    public static final String REPORT_VALUE_ID = "AndroidJUnitRunner";
    public static final int REPORT_VALUE_RESULT_ASSUMPTION_FAILURE = -4;

    @Deprecated
    public static final int REPORT_VALUE_RESULT_ERROR = -1;
    public static final int REPORT_VALUE_RESULT_FAILURE = -2;
    public static final int REPORT_VALUE_RESULT_IGNORED = -3;
    public static final int REPORT_VALUE_RESULT_OK = 0;
    public static final int REPORT_VALUE_RESULT_START = 1;
    private final Bundle resultTemplate;
    Bundle testResult;
    int testNum = 0;
    int testResultCode = -999;
    String testClass = null;
    private Description description = Description.EMPTY;

    public InstrumentationResultPrinter() {
        Bundle bundle = new Bundle();
        this.resultTemplate = bundle;
        this.testResult = new Bundle(bundle);
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunStarted(Description description) throws Exception {
        this.resultTemplate.putString("id", REPORT_VALUE_ID);
        this.resultTemplate.putInt(REPORT_KEY_NUM_TOTAL, description.testCount());
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) throws Exception {
        this.description = description;
        String className = description.getClassName();
        String methodName = description.getMethodName();
        Bundle bundle = new Bundle(this.resultTemplate);
        this.testResult = bundle;
        bundle.putString("class", className);
        this.testResult.putString(REPORT_KEY_NAME_TEST, methodName);
        Bundle bundle2 = this.testResult;
        int i = this.testNum + 1;
        this.testNum = i;
        bundle2.putInt("current", i);
        if (className == null || className.equals(this.testClass)) {
            this.testResult.putString("stream", "");
        } else {
            this.testResult.putString("stream", String.format("\n%s:", className));
            this.testClass = className;
        }
        sendStatus(1, this.testResult);
        this.testResultCode = 0;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) throws Exception {
        if (this.testResultCode == 0) {
            this.testResult.putString("stream", InstructionFileId.DOT);
        }
        sendStatus(this.testResultCode, this.testResult);
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) throws Exception {
        boolean z;
        if (this.description.equals(Description.EMPTY) && this.testNum == 0 && this.testClass == null) {
            testStarted(failure.getDescription());
            z = true;
        } else {
            z = false;
        }
        this.testResultCode = -2;
        reportFailure(failure);
        if (z) {
            testFinished(failure.getDescription());
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testAssumptionFailure(Failure failure) {
        this.testResultCode = -4;
        this.testResult.putString("stack", failure.getTrace());
    }

    private void reportFailure(Failure failure) {
        String trimmedStackTrace = StackTrimmer.getTrimmedStackTrace(failure);
        this.testResult.putString("stack", trimmedStackTrace);
        this.testResult.putString("stream", String.format("\nError in %s:\n%s", failure.getDescription().getDisplayName(), trimmedStackTrace));
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) throws Exception {
        testStarted(description);
        this.testResultCode = -3;
        testFinished(description);
    }

    public void reportProcessCrash(Throwable th) {
        try {
            this.testResultCode = -2;
            Failure failure = new Failure(this.description, th);
            this.testResult.putString("stack", failure.getTrace());
            this.testResult.putString("stream", String.format("\nProcess crashed while executing %s:\n%s", this.description.getDisplayName(), failure.getTrace()));
            testFinished(this.description);
        } catch (Exception unused) {
            Description description = this.description;
            if (description == null) {
                Log.e("InstrumentationResultPrinter", "Failed to initialize test before process crash");
                return;
            }
            String displayName = description.getDisplayName();
            StringBuilder sb = new StringBuilder(String.valueOf(displayName).length() + 52);
            sb.append("Failed to mark test ");
            sb.append(displayName);
            sb.append(" as finished after process crash");
            Log.e("InstrumentationResultPrinter", sb.toString());
        }
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void instrumentationRunFinished(PrintStream printStream, Bundle bundle, Result result) {
        new TextListener(printStream).testRunFinished(result);
    }
}
