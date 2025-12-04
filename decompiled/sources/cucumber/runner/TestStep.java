package cucumber.runner;

import cucumber.api.Pending;
import cucumber.api.Result;
import cucumber.api.event.TestStepFinished;
import cucumber.api.event.TestStepStarted;
import cucumber.runtime.StepDefinitionMatch;
import java.util.Arrays;

/* loaded from: classes5.dex */
abstract class TestStep implements cucumber.api.TestStep {
    private static final String[] ASSUMPTION_VIOLATED_EXCEPTIONS;
    private final StepDefinitionMatch stepDefinitionMatch;

    static {
        String[] strArr = {"org.junit.AssumptionViolatedException", "org.junit.internal.AssumptionViolatedException", "org.testng.SkipException"};
        ASSUMPTION_VIOLATED_EXCEPTIONS = strArr;
        Arrays.sort(strArr);
    }

    TestStep(StepDefinitionMatch stepDefinitionMatch) {
        this.stepDefinitionMatch = stepDefinitionMatch;
    }

    @Override // cucumber.api.TestStep
    public String getCodeLocation() {
        return this.stepDefinitionMatch.getCodeLocation();
    }

    boolean run(cucumber.api.TestCase testCase, EventBus eventBus, Scenario scenario, boolean z) {
        Throwable th;
        Result.Type typeMapThrowableToStatus;
        Long timeMillis = eventBus.getTimeMillis();
        Long time = eventBus.getTime();
        eventBus.send(new TestStepStarted(time, timeMillis.longValue(), testCase, this));
        try {
            typeMapThrowableToStatus = executeStep(scenario, z);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            typeMapThrowableToStatus = mapThrowableToStatus(th);
        }
        Long time2 = eventBus.getTime();
        Long timeMillis2 = eventBus.getTimeMillis();
        Result resultMapStatusToResult = mapStatusToResult(typeMapThrowableToStatus, th, time2.longValue() - time.longValue());
        scenario.add(resultMapStatusToResult);
        eventBus.send(new TestStepFinished(time2, timeMillis2.longValue(), testCase, this, resultMapStatusToResult));
        return !resultMapStatusToResult.is(Result.Type.PASSED);
    }

    private Result.Type executeStep(Scenario scenario, boolean z) throws Throwable {
        if (!z) {
            this.stepDefinitionMatch.runStep(scenario);
            return Result.Type.PASSED;
        }
        this.stepDefinitionMatch.dryRunStep(scenario);
        return Result.Type.SKIPPED;
    }

    private Result.Type mapThrowableToStatus(Throwable th) {
        if (th.getClass().isAnnotationPresent(Pending.class)) {
            return Result.Type.PENDING;
        }
        if (Arrays.binarySearch(ASSUMPTION_VIOLATED_EXCEPTIONS, th.getClass().getName()) >= 0) {
            return Result.Type.SKIPPED;
        }
        if (th.getClass() == UndefinedStepDefinitionException.class) {
            return Result.Type.UNDEFINED;
        }
        if (th.getClass() == AmbiguousStepDefinitionsException.class) {
            return Result.Type.AMBIGUOUS;
        }
        return Result.Type.FAILED;
    }

    private Result mapStatusToResult(Result.Type type, Throwable th, long j) {
        if (type == Result.Type.UNDEFINED) {
            return Result.UNDEFINED;
        }
        return new Result(type, Long.valueOf(j), th);
    }
}
