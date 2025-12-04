package androidx.test.orchestrator.listeners.result;

import android.util.Log;
import androidx.test.orchestrator.listeners.result.TestResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class TestRunResult implements ITestRunListener {
    private static final String LOG_TAG = "TestRunResult";
    private Map testResults = new LinkedHashMap();
    private Map runMetrics = new HashMap();
    private boolean isRunComplete = false;
    private long elapsedTime = 0;
    private int[] statusCounts = new int[TestResult.TestStatus.values().length];
    private boolean isCountDirty = true;
    private String runFailureError = null;
    private boolean aggregateMetrics = false;
    private String testRunName = "not started";

    public void setAggregateMetrics(boolean z) {
        this.aggregateMetrics = z;
    }

    public String getName() {
        return this.testRunName;
    }

    public Map<TestIdentifier, TestResult> getTestResults() {
        return this.testResults;
    }

    public Map<String, String> getRunMetrics() {
        return this.runMetrics;
    }

    public Set<TestIdentifier> getCompletedTests() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<TestIdentifier, TestResult> entry : getTestResults().entrySet()) {
            if (!entry.getValue().getStatus().equals(TestResult.TestStatus.INCOMPLETE)) {
                linkedHashSet.add(entry.getKey());
            }
        }
        return linkedHashSet;
    }

    public boolean isRunFailure() {
        return this.runFailureError != null;
    }

    public boolean isRunComplete() {
        return this.isRunComplete;
    }

    public void setRunComplete(boolean z) {
        this.isRunComplete = z;
    }

    public int getNumTestsInState(TestResult.TestStatus testStatus) {
        if (this.isCountDirty) {
            int i = 0;
            while (true) {
                int[] iArr = this.statusCounts;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = 0;
                i++;
            }
            for (TestResult testResult : this.testResults.values()) {
                int[] iArr2 = this.statusCounts;
                int iOrdinal = testResult.getStatus().ordinal();
                iArr2[iOrdinal] = iArr2[iOrdinal] + 1;
            }
            this.isCountDirty = false;
        }
        return this.statusCounts[testStatus.ordinal()];
    }

    public int getNumTests() {
        return this.testResults.size();
    }

    public int getNumCompleteTests() {
        return getNumTests() - getNumTestsInState(TestResult.TestStatus.INCOMPLETE);
    }

    public boolean hasFailedTests() {
        return getNumAllFailedTests() > 0;
    }

    public int getNumAllFailedTests() {
        return getNumTestsInState(TestResult.TestStatus.FAILURE);
    }

    public long getElapsedTime() {
        return this.elapsedTime;
    }

    public String getRunFailureMessage() {
        return this.runFailureError;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testRunStarted(String str, int i) {
        this.testRunName = str;
        this.isRunComplete = false;
        this.runFailureError = null;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testStarted(TestIdentifier testIdentifier) {
        addTestResult(testIdentifier, new TestResult());
    }

    private void addTestResult(TestIdentifier testIdentifier, TestResult testResult) {
        this.isCountDirty = true;
        this.testResults.put(testIdentifier, testResult);
    }

    private void updateTestResult(TestIdentifier testIdentifier, TestResult.TestStatus testStatus, String str) {
        TestResult testResult = (TestResult) this.testResults.get(testIdentifier);
        if (testResult == null) {
            Log.w(LOG_TAG, String.format("received test event %s without test start for %s. trace: %s", testStatus.name(), testIdentifier, str));
            testResult = new TestResult();
        }
        testResult.setStatus(testStatus);
        testResult.setStackTrace(str);
        addTestResult(testIdentifier, testResult);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testFailed(TestIdentifier testIdentifier, String str) {
        updateTestResult(testIdentifier, TestResult.TestStatus.FAILURE, str);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testAssumptionFailure(TestIdentifier testIdentifier, String str) {
        updateTestResult(testIdentifier, TestResult.TestStatus.ASSUMPTION_FAILURE, str);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testIgnored(TestIdentifier testIdentifier) {
        updateTestResult(testIdentifier, TestResult.TestStatus.IGNORED, null);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testEnded(TestIdentifier testIdentifier, Map<String, String> map) {
        TestResult testResult = (TestResult) this.testResults.get(testIdentifier);
        if (testResult == null) {
            testResult = new TestResult();
        }
        if (testResult.getStatus().equals(TestResult.TestStatus.INCOMPLETE)) {
            testResult.setStatus(TestResult.TestStatus.PASSED);
        }
        testResult.setEndTime(System.currentTimeMillis());
        testResult.setMetrics(map);
        addTestResult(testIdentifier, testResult);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testRunFailed(String str) {
        this.runFailureError = str;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testRunStopped(long j) {
        this.elapsedTime += j;
        this.isRunComplete = true;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void testRunEnded(long j, Map<String, String> map) {
        if (this.aggregateMetrics) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.runMetrics.put(entry.getKey(), combineValues((String) this.runMetrics.get(entry.getKey()), entry.getValue()));
            }
        } else {
            this.runMetrics.putAll(map);
        }
        this.elapsedTime += j;
        this.isRunComplete = true;
    }

    private String combineValues(String str, String str2) {
        if (str != null) {
            try {
                try {
                    return Long.toString(Long.parseLong(str) + Long.parseLong(str2));
                } catch (NumberFormatException unused) {
                    return Double.toString(Double.parseDouble(str) + Double.parseDouble(str2));
                }
            } catch (NumberFormatException unused2) {
            }
        }
        return str2;
    }

    public String getTextSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total tests %d, ", Integer.valueOf(getNumTests())));
        for (TestResult.TestStatus testStatus : TestResult.TestStatus.values()) {
            int numTestsInState = getNumTestsInState(testStatus);
            if (numTestsInState > 0) {
                sb.append(String.format("%s %d, ", testStatus.toString().toLowerCase(), Integer.valueOf(numTestsInState)));
            }
        }
        return sb.toString();
    }
}
