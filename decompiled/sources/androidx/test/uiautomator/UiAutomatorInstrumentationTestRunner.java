package androidx.test.uiautomator;

import android.test.AndroidTestRunner;
import android.test.InstrumentationTestRunner;
import androidx.test.uiautomator.Tracer;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

/* loaded from: classes2.dex */
public class UiAutomatorInstrumentationTestRunner extends InstrumentationTestRunner {
    public void onStart() {
        String string = getArguments().getString("traceOutputMode");
        if (string != null) {
            Tracer.Mode mode = (Tracer.Mode) Enum.valueOf(Tracer.Mode.class, string);
            if (mode == Tracer.Mode.FILE || mode == Tracer.Mode.ALL) {
                String string2 = getArguments().getString("traceLogFilename");
                if (string2 == null) {
                    throw new RuntimeException("Name of log file not specified. Please specify it using traceLogFilename parameter");
                }
                Tracer.getInstance().setOutputFilename(string2);
            }
            Tracer.getInstance().setOutputMode(mode);
        }
        super.onStart();
    }

    protected void initializeUiAutomatorTest(UiAutomatorTestCase uiAutomatorTestCase) {
        uiAutomatorTestCase.initialize(getArguments());
    }

    protected AndroidTestRunner getAndroidTestRunner() {
        AndroidTestRunner androidTestRunner = super.getAndroidTestRunner();
        androidTestRunner.addTestListener(new TestListener() { // from class: androidx.test.uiautomator.UiAutomatorInstrumentationTestRunner.1
            @Override // junit.framework.TestListener
            public void addError(Test test, Throwable th) {
            }

            @Override // junit.framework.TestListener
            public void addFailure(Test test, AssertionFailedError assertionFailedError) {
            }

            @Override // junit.framework.TestListener
            public void endTest(Test test) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // junit.framework.TestListener
            public void startTest(Test test) {
                if (test instanceof UiAutomatorTestCase) {
                    UiAutomatorInstrumentationTestRunner.this.initializeUiAutomatorTest((UiAutomatorTestCase) test);
                }
            }
        });
        return androidTestRunner;
    }
}
