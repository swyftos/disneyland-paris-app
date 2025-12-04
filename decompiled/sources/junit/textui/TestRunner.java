package junit.textui;

import java.io.IOException;
import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.Version;

/* loaded from: classes5.dex */
public class TestRunner extends BaseTestRunner {
    public static final int EXCEPTION_EXIT = 2;
    public static final int FAILURE_EXIT = 1;
    public static final int SUCCESS_EXIT = 0;
    private ResultPrinter fPrinter;

    @Override // junit.runner.BaseTestRunner
    public void testEnded(String str) {
    }

    @Override // junit.runner.BaseTestRunner
    public void testFailed(int i, Test test, Throwable th) {
    }

    @Override // junit.runner.BaseTestRunner
    public void testStarted(String str) {
    }

    public TestRunner() {
        this(System.out);
    }

    public TestRunner(PrintStream printStream) {
        this(new ResultPrinter(printStream));
    }

    public TestRunner(ResultPrinter resultPrinter) {
        this.fPrinter = resultPrinter;
    }

    public static void run(Class<? extends TestCase> cls) {
        run(new TestSuite(cls));
    }

    public static TestResult run(Test test) {
        return new TestRunner().doRun(test);
    }

    public static void runAndWait(Test test) throws IOException {
        new TestRunner().doRun(test, true);
    }

    protected TestResult createTestResult() {
        return new TestResult();
    }

    public TestResult doRun(Test test) {
        return doRun(test, false);
    }

    public TestResult doRun(Test test, boolean z) throws IOException {
        TestResult testResultCreateTestResult = createTestResult();
        testResultCreateTestResult.addListener(this.fPrinter);
        long jCurrentTimeMillis = System.currentTimeMillis();
        test.run(testResultCreateTestResult);
        this.fPrinter.print(testResultCreateTestResult, System.currentTimeMillis() - jCurrentTimeMillis);
        pause(z);
        return testResultCreateTestResult;
    }

    protected void pause(boolean z) throws IOException {
        if (z) {
            this.fPrinter.printWaitPrompt();
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
    }

    public static void main(String[] strArr) {
        try {
            if (!new TestRunner().start(strArr).wasSuccessful()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }

    public TestResult start(String[] strArr) throws Exception {
        String strExtractClassName = "";
        String strSubstring = strExtractClassName;
        int i = 0;
        boolean z = false;
        while (i < strArr.length) {
            if (strArr[i].equals("-wait")) {
                z = true;
            } else if (strArr[i].equals("-c")) {
                i++;
                strExtractClassName = extractClassName(strArr[i]);
            } else if (strArr[i].equals("-m")) {
                i++;
                String str = strArr[i];
                int iLastIndexOf = str.lastIndexOf(46);
                String strSubstring2 = str.substring(0, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf + 1);
                strExtractClassName = strSubstring2;
            } else if (strArr[i].equals("-v")) {
                System.err.println("JUnit " + Version.id() + " by Kent Beck and Erich Gamma");
            } else {
                strExtractClassName = strArr[i];
            }
            i++;
        }
        if (strExtractClassName.equals("")) {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
        try {
            if (!strSubstring.equals("")) {
                return runSingleMethod(strExtractClassName, strSubstring, z);
            }
            return doRun(getTest(strExtractClassName), z);
        } catch (Exception e) {
            throw new Exception("Could not create and run test suite: " + e);
        }
    }

    protected TestResult runSingleMethod(String str, String str2, boolean z) throws Exception {
        return doRun(TestSuite.createTest(loadSuiteClass(str).asSubclass(TestCase.class), str2), z);
    }

    @Override // junit.runner.BaseTestRunner
    protected void runFailed(String str) {
        System.err.println(str);
        System.exit(1);
    }

    public void setPrinter(ResultPrinter resultPrinter) {
        this.fPrinter = resultPrinter;
    }
}
