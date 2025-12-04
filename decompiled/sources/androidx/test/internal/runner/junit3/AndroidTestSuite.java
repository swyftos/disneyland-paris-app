package androidx.test.internal.runner.junit3;

import android.os.Looper;
import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Ignore;

@Ignore
/* loaded from: classes2.dex */
class AndroidTestSuite extends DelegatingFilterableTestSuite {
    private final AndroidRunnerParams androidRunnerParams;

    public AndroidTestSuite(Class cls, AndroidRunnerParams androidRunnerParams) {
        this(new NonLeakyTestSuite(cls), androidRunnerParams);
    }

    public AndroidTestSuite(TestSuite testSuite, AndroidRunnerParams androidRunnerParams) {
        super(testSuite);
        this.androidRunnerParams = androidRunnerParams;
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite, junit.framework.Test
    public void run(TestResult testResult) throws ExecutionException, InterruptedException, TimeoutException {
        AndroidTestResult androidTestResult = new AndroidTestResult(this.androidRunnerParams.getBundle(), this.androidRunnerParams.getInstrumentation(), testResult);
        long perTestTimeout = this.androidRunnerParams.getPerTestTimeout();
        if (perTestTimeout > 0) {
            runTestsWithTimeout(perTestTimeout, androidTestResult);
        } else {
            super.run(androidTestResult);
        }
    }

    private void runTestsWithTimeout(long j, AndroidTestResult androidTestResult) throws ExecutionException, InterruptedException, TimeoutException {
        int iTestCount = testCount();
        for (int i = 0; i < iTestCount; i++) {
            runTestWithTimeout(testAt(i), androidTestResult, j);
        }
    }

    private void runTestWithTimeout(final Test test, final AndroidTestResult androidTestResult, long j) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory(this) { // from class: androidx.test.internal.runner.junit3.AndroidTestSuite.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName("AndroidTestSuite");
                return threadNewThread;
            }
        });
        Runnable runnable = new Runnable(this) { // from class: androidx.test.internal.runner.junit3.AndroidTestSuite.2
            @Override // java.lang.Runnable
            public void run() {
                test.run(androidTestResult);
            }
        };
        androidTestResult.setCurrentTimeout(j);
        Future<?> futureSubmit = executorServiceNewSingleThreadExecutor.submit(runnable);
        executorServiceNewSingleThreadExecutor.shutdown();
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorServiceNewSingleThreadExecutor.awaitTermination(j, timeUnit)) {
                return;
            }
            executorServiceNewSingleThreadExecutor.shutdownNow();
            if (executorServiceNewSingleThreadExecutor.awaitTermination(1L, TimeUnit.MINUTES)) {
                return;
            }
            Log.e("AndroidTestSuite", "Failed to to stop test execution thread, the correctness of the test runner is at risk. Abort all execution!");
            try {
                try {
                    futureSubmit.get(0L, timeUnit);
                } catch (ExecutionException e) {
                    Log.e("AndroidTestSuite", "Exception from the execution thread", e.getCause());
                }
            } catch (TimeoutException e2) {
                Log.e("AndroidTestSuite", "Exception from the execution thread", e2);
            }
            terminateAllRunnerExecution(new IllegalStateException(String.format("Test timed out after %d milliseconds but execution thread failed to terminate\nDumping instr and main threads:\n%s", Long.valueOf(j), getStackTraces())));
        } catch (InterruptedException e3) {
            Log.e("AndroidTestSuite", "The correctness of the test runner is at risk. Abort all execution!");
            terminateAllRunnerExecution(new IllegalStateException(String.format("Test execution thread got interrupted:\n%s\nDumping instr and main threads:\n%s", e3, getStackTraces())));
        }
    }

    private void terminateAllRunnerExecution(final RuntimeException runtimeException) throws InterruptedException {
        Thread thread = new Thread(new Runnable(this) { // from class: androidx.test.internal.runner.junit3.AndroidTestSuite.3
            @Override // java.lang.Runnable
            public void run() {
                throw runtimeException;
            }
        }, "Terminator");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    private String getStackTraces() {
        StringBuilder sb = new StringBuilder();
        Thread threadCurrentThread = Thread.currentThread();
        sb.append(threadCurrentThread.toString());
        sb.append('\n');
        for (StackTraceElement stackTraceElement : threadCurrentThread.getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement.toString());
            sb.append('\n');
        }
        sb.append('\n');
        Thread thread = Looper.getMainLooper().getThread();
        sb.append(thread.toString());
        sb.append('\n');
        for (StackTraceElement stackTraceElement2 : thread.getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement2.toString());
            sb.append('\n');
        }
        sb.append('\n');
        return sb.toString();
    }
}
