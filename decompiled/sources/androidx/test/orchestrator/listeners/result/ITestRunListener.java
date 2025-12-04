package androidx.test.orchestrator.listeners.result;

import java.util.Map;

/* loaded from: classes2.dex */
public interface ITestRunListener {
    void testAssumptionFailure(TestIdentifier testIdentifier, String str);

    void testEnded(TestIdentifier testIdentifier, Map<String, String> map);

    void testFailed(TestIdentifier testIdentifier, String str);

    void testIgnored(TestIdentifier testIdentifier);

    void testRunEnded(long j, Map<String, String> map);

    void testRunFailed(String str);

    void testRunStarted(String str, int i);

    void testRunStopped(long j);

    void testStarted(TestIdentifier testIdentifier);
}
