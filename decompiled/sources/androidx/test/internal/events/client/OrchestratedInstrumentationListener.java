package androidx.test.internal.events.client;

import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.FailureInfo;
import androidx.test.services.events.ParcelableConverter;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.TestEventException;
import androidx.test.services.events.run.TestAssumptionFailureEvent;
import androidx.test.services.events.run.TestFailureEvent;
import androidx.test.services.events.run.TestFinishedEvent;
import androidx.test.services.events.run.TestIgnoredEvent;
import androidx.test.services.events.run.TestRunFinishedEvent;
import androidx.test.services.events.run.TestRunStartedEvent;
import androidx.test.services.events.run.TestStartedEvent;
import gherkin.GherkinLanguageConstants;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public final class OrchestratedInstrumentationListener extends RunListener {
    private final TestRunEventService notificationService;
    private final ConditionVariable testFinishedCondition = new ConditionVariable();
    private final AtomicBoolean isTestFailed = new AtomicBoolean(false);
    private Description description = Description.EMPTY;

    public OrchestratedInstrumentationListener(@NonNull TestRunEventService testRunEventService) {
        Checks.checkNotNull(testRunEventService, "notificationService cannot be null");
        this.notificationService = testRunEventService;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunStarted(Description description) {
        try {
            this.notificationService.send(new TestRunStartedEvent(ParcelableConverter.getTestCaseFromDescription(description)));
        } catch (TestEventException e) {
            Log.e("OrchestrationListener", "Unable to send TestRunStartedEvent to Orchestrator", e);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(Result result) {
        List<FailureInfo> listEmptyList = Collections.emptyList();
        try {
            listEmptyList = ParcelableConverter.getFailuresFromList(result.getFailures());
        } catch (TestEventException e) {
            Log.w("OrchestrationListener", "Failure event doesn't contain a test case", e);
        }
        try {
            this.notificationService.send(new TestRunFinishedEvent(result.getRunCount(), result.getIgnoreCount(), result.getRunTime(), listEmptyList));
        } catch (TestEventException e2) {
            Log.e("OrchestrationListener", "Unable to send TestRunFinishedEvent to Orchestrator", e2);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) {
        this.description = description;
        if (!JUnitValidator.validateDescription(description)) {
            String className = description.getClassName();
            String methodName = description.getMethodName();
            StringBuilder sb = new StringBuilder(String.valueOf(className).length() + 51 + String.valueOf(methodName).length());
            sb.append("testStarted: JUnit reported ");
            sb.append(className);
            sb.append(GherkinLanguageConstants.COMMENT_PREFIX);
            sb.append(methodName);
            sb.append("; discarding as bogus.");
            Log.w("OrchestrationListener", sb.toString());
            return;
        }
        try {
            this.notificationService.send(new TestStartedEvent(ParcelableConverter.getTestCaseFromDescription(description)));
        } catch (TestEventException e) {
            Log.e("OrchestrationListener", "Unable to send TestStartedEvent to Orchestrator", e);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) {
        if (!JUnitValidator.validateDescription(description)) {
            String className = description.getClassName();
            String methodName = description.getMethodName();
            StringBuilder sb = new StringBuilder(String.valueOf(className).length() + 52 + String.valueOf(methodName).length());
            sb.append("testFinished: JUnit reported ");
            sb.append(className);
            sb.append(GherkinLanguageConstants.COMMENT_PREFIX);
            sb.append(methodName);
            sb.append("; discarding as bogus.");
            Log.w("OrchestrationListener", sb.toString());
            return;
        }
        try {
            this.notificationService.send(new TestFinishedEvent(ParcelableConverter.getTestCaseFromDescription(description)));
        } catch (TestEventException e) {
            Log.e("OrchestrationListener", "Unable to send TestFinishedEvent to Orchestrator", e);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) {
        TestFailureEvent testFailureEventFromCachedDescription;
        if (this.isTestFailed.compareAndSet(false, true)) {
            Description description = failure.getDescription();
            if (!JUnitValidator.validateDescription(description)) {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(className).length() + 51 + String.valueOf(methodName).length());
                sb.append("testFailure: JUnit reported ");
                sb.append(className);
                sb.append(GherkinLanguageConstants.COMMENT_PREFIX);
                sb.append(methodName);
                sb.append("; discarding as bogus.");
                Log.w("OrchestrationListener", sb.toString());
                return;
            }
            try {
                testFailureEventFromCachedDescription = new TestFailureEvent(ParcelableConverter.getTestCaseFromDescription(failure.getDescription()), ParcelableConverter.getFailure(failure));
            } catch (TestEventException e) {
                String strValueOf = String.valueOf(failure);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 45);
                sb2.append("Unable to determine test case from failure [");
                sb2.append(strValueOf);
                sb2.append("]");
                Log.d("OrchestrationListener", sb2.toString(), e);
                testFailureEventFromCachedDescription = getTestFailureEventFromCachedDescription(failure);
                if (testFailureEventFromCachedDescription == null) {
                    return;
                }
            }
            try {
                this.notificationService.send(testFailureEventFromCachedDescription);
            } catch (TestEventException e2) {
                throw new IllegalStateException("Unable to send TestFailureEvent, terminating", e2);
            }
        }
    }

    private TestFailureEvent getTestFailureEventFromCachedDescription(Failure failure) {
        Checks.checkNotNull(failure, "failure cannot be null");
        try {
            TestCaseInfo testCaseFromDescription = ParcelableConverter.getTestCaseFromDescription(this.description);
            return new TestFailureEvent(testCaseFromDescription, new FailureInfo(failure.getMessage(), failure.getTestHeader(), failure.getTrace(), testCaseFromDescription));
        } catch (TestEventException e) {
            String strValueOf = String.valueOf(this.description);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
            sb.append("Unable to determine test case from description [");
            sb.append(strValueOf);
            sb.append("]");
            Log.e("OrchestrationListener", sb.toString(), e);
            return null;
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testAssumptionFailure(Failure failure) {
        try {
            this.notificationService.send(new TestAssumptionFailureEvent(ParcelableConverter.getTestCaseFromDescription(failure.getDescription()), ParcelableConverter.getFailure(failure)));
        } catch (TestEventException e) {
            Log.e("OrchestrationListener", "Unable to send TestAssumptionFailureEvent to Orchestrator", e);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) {
        try {
            TestCaseInfo testCaseFromDescription = ParcelableConverter.getTestCaseFromDescription(description);
            String displayName = description.getDisplayName();
            String className = description.getClassName();
            String methodName = description.getMethodName();
            String classAndMethodName = testCaseFromDescription.getClassAndMethodName();
            StringBuilder sb = new StringBuilder(String.valueOf(displayName).length() + 24 + String.valueOf(className).length() + String.valueOf(methodName).length() + String.valueOf(classAndMethodName).length());
            sb.append("TestIgnoredEvent(");
            sb.append(displayName);
            sb.append("): ");
            sb.append(className);
            sb.append(GherkinLanguageConstants.COMMENT_PREFIX);
            sb.append(methodName);
            sb.append(" = ");
            sb.append(classAndMethodName);
            Log.i("OrchestrationListener", sb.toString());
            this.notificationService.send(new TestIgnoredEvent(testCaseFromDescription));
        } catch (TestEventException e) {
            Log.e("OrchestrationListener", "Unable to send TestIgnoredEvent to Orchestrator", e);
        }
    }

    public void reportProcessCrash(Throwable th, long j) {
        waitUntilTestFinished(j);
        if (this.isTestFailed.get()) {
            return;
        }
        Log.i("OrchestrationListener", "No test failure has been reported. Report the process crash.");
        reportProcessCrash(th);
    }

    private void reportProcessCrash(Throwable th) {
        testFailure(new Failure(this.description, th));
        testFinished(this.description);
    }

    private void waitUntilTestFinished(long j) {
        if (this.testFinishedCondition.block(j)) {
            return;
        }
        Log.w("OrchestrationListener", "Timeout waiting for the test to finish");
    }
}
