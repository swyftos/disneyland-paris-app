package androidx.test.internal.events.client;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.internal.events.client.TestEventClientArgs;
import androidx.test.internal.util.Checks;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public final class TestEventClient {
    public static final TestEventClient NO_OP_CLIENT = new TestEventClient();
    private final OrchestratedInstrumentationListener notificationRunListener;
    private final TestDiscovery testDiscovery;
    private final TestPlatformListener testPlatformListener;

    private TestEventClient() {
        this.testDiscovery = null;
        this.notificationRunListener = null;
        this.testPlatformListener = null;
    }

    private TestEventClient(TestDiscovery testDiscovery) {
        Checks.checkNotNull(testDiscovery, "testDiscovery cannot be null");
        this.testDiscovery = testDiscovery;
        this.notificationRunListener = null;
        this.testPlatformListener = null;
    }

    private TestEventClient(OrchestratedInstrumentationListener orchestratedInstrumentationListener) {
        Checks.checkNotNull(orchestratedInstrumentationListener, "runListener cannot be null");
        this.testDiscovery = null;
        this.notificationRunListener = orchestratedInstrumentationListener;
        this.testPlatformListener = null;
    }

    private TestEventClient(TestPlatformListener testPlatformListener) {
        Checks.checkNotNull(testPlatformListener, "runListener cannot be null");
        this.testDiscovery = null;
        this.notificationRunListener = null;
        this.testPlatformListener = testPlatformListener;
    }

    public static TestEventClient connect(@NonNull Context context, @NonNull TestEventClientConnectListener testEventClientConnectListener, @NonNull TestEventClientArgs testEventClientArgs) {
        TestEventClient testEventClient;
        Checks.checkNotNull(context, "context parameter cannot be null!");
        Checks.checkNotNull(testEventClientConnectListener, "listener parameter cannot be null!");
        Checks.checkNotNull(testEventClientArgs, "args parameter cannot be null!");
        if (!testEventClientArgs.isOrchestrated) {
            return NO_OP_CLIENT;
        }
        if (!testEventClientArgs.isPrimaryInstrProcess) {
            Log.w("TestEventClient", "Orchestration requested, but this isn't the primary instrumentation");
            return NO_OP_CLIENT;
        }
        TestEventServiceConnection connection = getConnection(testEventClientConnectListener, testEventClientArgs);
        TestEventClient testEventClient2 = NO_OP_CLIENT;
        if (testEventClientArgs.isTestDiscoveryRequested) {
            Log.v("TestEventClient", "Test discovery events requested");
            testEventClient = new TestEventClient(new TestDiscovery((TestDiscoveryEventService) connection));
        } else {
            if (testEventClientArgs.isTestRunEventsRequested) {
                Log.v("TestEventClient", "Test run events requested");
                if (testEventClientArgs.testPlatformMigration) {
                    testEventClient2 = new TestEventClient(new TestPlatformListener((TestPlatformEventService) connection));
                } else {
                    testEventClient = new TestEventClient(new OrchestratedInstrumentationListener((TestRunEventService) connection));
                }
            }
            connection.connect(context);
            return testEventClient2;
        }
        testEventClient2 = testEventClient;
        connection.connect(context);
        return testEventClient2;
    }

    public boolean isTestDiscoveryEnabled() {
        return this.testDiscovery != null;
    }

    public boolean isTestRunEventsEnabled() {
        return (this.notificationRunListener == null && this.testPlatformListener == null) ? false : true;
    }

    @Nullable
    public RunListener getRunListener() {
        if (!isTestRunEventsEnabled()) {
            Log.e("TestEventClient", "Orchestrator service not connected - can't send test run notifications");
        }
        OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.notificationRunListener;
        return orchestratedInstrumentationListener != null ? orchestratedInstrumentationListener : this.testPlatformListener;
    }

    public void addTests(@NonNull Description description) {
        if (!isTestDiscoveryEnabled()) {
            Log.e("TestEventClient", "Orchestrator service not connected - can't send tests");
            return;
        }
        try {
            this.testDiscovery.addTests(description);
        } catch (TestEventClientException e) {
            String strValueOf = String.valueOf(description);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 21);
            sb.append("Failed to add test [");
            sb.append(strValueOf);
            sb.append("]");
            Log.e("TestEventClient", sb.toString(), e);
        }
    }

    private static TestEventServiceConnection getConnection(TestEventClientConnectListener testEventClientConnectListener, TestEventClientArgs testEventClientArgs) {
        int i = testEventClientArgs.orchestratorVersion;
        if (i == 1) {
            TestEventClientArgs.ConnectionFactory connectionFactory = testEventClientArgs.connectionFactory;
            if (connectionFactory != null) {
                return connectionFactory.create(testEventClientConnectListener);
            }
            throw new IllegalArgumentException("Orchestrator v1 connectionFactory must be provided by TestEventClientArgs.Builder#setConnectionFactory()");
        }
        if (i == 2) {
            if (testEventClientArgs.isTestDiscoveryRequested) {
                return new TestDiscoveryEventServiceConnection((String) Checks.checkNotNull(testEventClientArgs.testDiscoveryService), testEventClientConnectListener);
            }
            if (testEventClientArgs.isTestRunEventsRequested) {
                if (testEventClientArgs.testPlatformMigration) {
                    return new TestPlatformEventServiceConnection((String) Checks.checkNotNull(testEventClientArgs.testRunEventService), testEventClientConnectListener);
                }
                return new TestRunEventServiceConnection((String) Checks.checkNotNull(testEventClientArgs.testRunEventService), testEventClientConnectListener);
            }
        }
        throw new IllegalArgumentException("TestEventClientArgs misconfiguration - can't determine which service connection to use.");
    }

    public void reportProcessCrash(Throwable th, long j) {
        if (isTestRunEventsEnabled()) {
            OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.notificationRunListener;
            if (orchestratedInstrumentationListener != null) {
                orchestratedInstrumentationListener.reportProcessCrash(th, j);
            }
            TestPlatformListener testPlatformListener = this.testPlatformListener;
            if (testPlatformListener != null) {
                testPlatformListener.reportProcessCrash(th);
            }
        }
    }
}
