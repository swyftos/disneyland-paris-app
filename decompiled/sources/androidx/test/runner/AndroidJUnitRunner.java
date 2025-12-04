package androidx.test.runner;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import androidx.test.internal.events.client.TestEventClient;
import androidx.test.internal.events.client.TestEventClientArgs;
import androidx.test.internal.events.client.TestEventClientConnectListener;
import androidx.test.internal.runner.ClassPathScanner;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.TestExecutor;
import androidx.test.internal.runner.TestRequestBuilder;
import androidx.test.internal.runner.listener.ActivityFinisherRunListener;
import androidx.test.internal.runner.listener.CoverageListener;
import androidx.test.internal.runner.listener.DelayInjector;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import androidx.test.internal.runner.listener.LogRunListener;
import androidx.test.internal.runner.listener.SuiteAssignmentPrinter;
import androidx.test.internal.runner.storage.RunnerFileIO;
import androidx.test.internal.runner.storage.RunnerIO;
import androidx.test.internal.runner.storage.RunnerTestStorageIO;
import androidx.test.internal.runner.tracker.AnalyticsBasedUsageTracker;
import androidx.test.internal.util.ReflectionUtil;
import androidx.test.runner.MonitoringInstrumentation;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.screenshot.Screenshot;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.runner.Request;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public class AndroidJUnitRunner extends MonitoringInstrumentation implements TestEventClientConnectListener {
    private static final long MILLIS_TO_WAIT_FOR_TEST_FINISH = TimeUnit.SECONDS.toMillis(20);
    private Bundle arguments;
    private RunnerArgs runnerArgs;
    private UsageTrackerFacilitator usageTrackerFacilitator;
    private InstrumentationResultPrinter instrumentationResultPrinter = new InstrumentationResultPrinter();
    private TestEventClient testEventClient = TestEventClient.NO_OP_CLIENT;
    private RunnerIO runnerIO = new RunnerFileIO();

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.arguments = bundle;
        parseRunnerArgs(bundle);
        if (waitForDebugger(this.runnerArgs)) {
            Log.i(InstrumentationResultPrinter.REPORT_VALUE_ID, "Waiting for debugger to connect...");
            Debug.waitForDebugger();
            Log.i(InstrumentationResultPrinter.REPORT_VALUE_ID, "Debugger connected.");
        }
        if (isPrimaryInstrProcess(this.runnerArgs.targetProcess)) {
            this.usageTrackerFacilitator = new UsageTrackerFacilitator(this.runnerArgs);
        } else {
            this.usageTrackerFacilitator = new UsageTrackerFacilitator(false);
        }
        Iterator<ApplicationLifecycleCallback> it = this.runnerArgs.appListeners.iterator();
        while (it.hasNext()) {
            ApplicationLifecycleMonitorRegistry.getInstance().addLifecycleCallback(it.next());
        }
        addScreenCaptureProcessors(this.runnerArgs);
        if (isOrchestratorServiceProvided()) {
            Log.v(InstrumentationResultPrinter.REPORT_VALUE_ID, "Waiting to connect to the Orchestrator service...");
        } else {
            start();
        }
    }

    private boolean isOrchestratorServiceProvided() {
        TestEventClient testEventClientConnect = TestEventClient.connect(getContext(), this, TestEventClientArgs.builder().setConnectionFactory(AndroidJUnitRunner$$Lambda$0.$instance).setOrchestratorService(this.runnerArgs.orchestratorService).setPrimaryInstProcess(isPrimaryInstrProcess(this.runnerArgs.targetProcess)).setTestDiscoveryRequested(this.runnerArgs.listTestsForOrchestrator).setTestRunEventsRequested(!this.runnerArgs.listTestsForOrchestrator).setTestDiscoveryService(this.runnerArgs.testDiscoveryService).setTestRunEventService(this.runnerArgs.testRunEventsService).setTestPlatformMigration(this.runnerArgs.testPlatformMigration).build());
        this.testEventClient = testEventClientConnect;
        return testEventClientConnect.isTestDiscoveryEnabled() || this.testEventClient.isTestRunEventsEnabled();
    }

    private boolean waitForDebugger(RunnerArgs runnerArgs) {
        return runnerArgs.debug && !runnerArgs.listTestsForOrchestrator;
    }

    @Deprecated
    public void onOrchestratorConnect() {
        onTestEventClientConnect();
    }

    @Override // androidx.test.internal.events.client.TestEventClientConnectListener
    public void onTestEventClientConnect() {
        start();
    }

    private void parseRunnerArgs(Bundle bundle) {
        this.runnerArgs = new RunnerArgs.Builder().fromManifest(this).fromBundle(this, bundle).build();
    }

    private Bundle getArguments() {
        return this.arguments;
    }

    InstrumentationResultPrinter getInstrumentationResultPrinter() {
        return this.instrumentationResultPrinter;
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onStart() throws ExecutionException, IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setJsBridgeClassName("androidx.test.espresso.web.bridge.JavaScriptBridge");
        super.onStart();
        Request requestBuildRequest = buildRequest(this.runnerArgs, getArguments());
        if (this.testEventClient.isTestDiscoveryEnabled()) {
            this.testEventClient.addTests(requestBuildRequest.getRunner().getDescription());
            finish(-1, new Bundle());
            return;
        }
        RunnerArgs.TestArg testArg = this.runnerArgs.remoteMethod;
        if (testArg != null) {
            ReflectionUtil.reflectivelyInvokeRemoteMethod(testArg.testClassName, testArg.methodName);
        }
        if (!isPrimaryInstrProcess(this.runnerArgs.targetProcess)) {
            Log.i(InstrumentationResultPrinter.REPORT_VALUE_ID, "Runner is idle...");
            return;
        }
        if (this.runnerArgs.useTestStorageService) {
            this.runnerIO = new RunnerTestStorageIO();
        }
        Bundle bundle = new Bundle();
        try {
            TestExecutor.Builder builder = new TestExecutor.Builder(this);
            addListeners(this.runnerArgs, builder);
            bundle = builder.build().execute(requestBuildRequest);
        } catch (RuntimeException e) {
            Log.e(InstrumentationResultPrinter.REPORT_VALUE_ID, "Fatal exception when running tests", e);
            String strValueOf = String.valueOf(Log.getStackTraceString(e));
            bundle.putString("stream", strValueOf.length() != 0 ? "Fatal exception when running tests\n".concat(strValueOf) : new String("Fatal exception when running tests\n"));
        }
        finish(-1, bundle);
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void finish(int i, Bundle bundle) throws InterruptedException {
        try {
            this.usageTrackerFacilitator.trackUsage(InstrumentationResultPrinter.REPORT_VALUE_ID, "1.4.0");
            this.usageTrackerFacilitator.sendUsages();
        } catch (RuntimeException e) {
            Log.w(InstrumentationResultPrinter.REPORT_VALUE_ID, "Failed to send analytics.", e);
        }
        super.finish(i, bundle);
    }

    final void addListeners(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        if (runnerArgs.newRunListenerMode) {
            addListenersNewOrder(runnerArgs, builder);
        } else {
            addListenersLegacyOrder(runnerArgs, builder);
        }
    }

    private void addListenersLegacyOrder(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        if (runnerArgs.logOnly) {
            builder.addRunListener(getInstrumentationResultPrinter());
        } else if (runnerArgs.suiteAssignment) {
            builder.addRunListener(new SuiteAssignmentPrinter());
        } else {
            builder.addRunListener(new LogRunListener());
            if (this.testEventClient.isTestRunEventsEnabled()) {
                builder.addRunListener(this.testEventClient.getRunListener());
            } else {
                builder.addRunListener(getInstrumentationResultPrinter());
            }
            if (shouldWaitForActivitiesToComplete()) {
                builder.addRunListener(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() { // from class: androidx.test.runner.AndroidJUnitRunner.1
                    @Override // java.lang.Runnable
                    public void run() throws InterruptedException {
                        AndroidJUnitRunner.this.waitForActivitiesToComplete();
                    }
                }));
            }
            addDelayListener(runnerArgs, builder);
            addCoverageListener(runnerArgs, builder);
        }
        addListenersFromClasspath(builder);
        addListenersFromArg(runnerArgs, builder);
    }

    private void addListenersNewOrder(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        addListenersFromClasspath(builder);
        addListenersFromArg(runnerArgs, builder);
        if (runnerArgs.logOnly) {
            builder.addRunListener(getInstrumentationResultPrinter());
            return;
        }
        if (runnerArgs.suiteAssignment) {
            builder.addRunListener(new SuiteAssignmentPrinter());
            return;
        }
        builder.addRunListener(new LogRunListener());
        addDelayListener(runnerArgs, builder);
        addCoverageListener(runnerArgs, builder);
        if (this.testEventClient.isTestRunEventsEnabled()) {
            builder.addRunListener(this.testEventClient.getRunListener());
        } else {
            builder.addRunListener(getInstrumentationResultPrinter());
        }
        if (shouldWaitForActivitiesToComplete()) {
            builder.addRunListener(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() { // from class: androidx.test.runner.AndroidJUnitRunner.2
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    AndroidJUnitRunner.this.waitForActivitiesToComplete();
                }
            }));
        }
    }

    private void addScreenCaptureProcessors(RunnerArgs runnerArgs) {
        Screenshot.addScreenCaptureProcessors(new HashSet(runnerArgs.screenCaptureProcessors));
    }

    private void addCoverageListener(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        if (runnerArgs.codeCoverage) {
            builder.addRunListener(new CoverageListener(runnerArgs.codeCoveragePath, this.runnerIO));
        }
    }

    private void addDelayListener(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        int i = runnerArgs.delayInMillis;
        if (i > 0) {
            builder.addRunListener(new DelayInjector(i));
        }
    }

    private static void addListenersFromClasspath(TestExecutor.Builder builder) {
        Iterator it = ServiceLoader.load(RunListener.class).iterator();
        while (it.hasNext()) {
            builder.addRunListener((RunListener) it.next());
        }
    }

    private void addListenersFromArg(RunnerArgs runnerArgs, TestExecutor.Builder builder) {
        Iterator<RunListener> it = runnerArgs.listeners.iterator();
        while (it.hasNext()) {
            builder.addRunListener(it.next());
        }
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public boolean onException(Object obj, Throwable th) {
        Log.e(InstrumentationResultPrinter.REPORT_VALUE_ID, "An unhandled exception was thrown by the app.");
        InstrumentationResultPrinter instrumentationResultPrinter = getInstrumentationResultPrinter();
        if (instrumentationResultPrinter != null) {
            instrumentationResultPrinter.reportProcessCrash(th);
        }
        if (this.testEventClient.isTestRunEventsEnabled()) {
            this.testEventClient.reportProcessCrash(th, MILLIS_TO_WAIT_FOR_TEST_FINISH);
        }
        Log.i(InstrumentationResultPrinter.REPORT_VALUE_ID, "Bringing down the entire Instrumentation process.");
        return super.onException(obj, th);
    }

    Request buildRequest(RunnerArgs runnerArgs, Bundle bundle) {
        TestRequestBuilder testRequestBuilderCreateTestRequestBuilder = createTestRequestBuilder(this, bundle);
        testRequestBuilderCreateTestRequestBuilder.addPathsToScan(runnerArgs.classpathToScan);
        if (runnerArgs.classpathToScan.isEmpty()) {
            testRequestBuilderCreateTestRequestBuilder.addPathsToScan(ClassPathScanner.getDefaultClasspaths(this));
        }
        testRequestBuilderCreateTestRequestBuilder.addFromRunnerArgs(runnerArgs);
        registerUserTracker();
        return testRequestBuilderCreateTestRequestBuilder.build();
    }

    private void registerUserTracker() {
        Context targetContext = getTargetContext();
        if (targetContext != null) {
            this.usageTrackerFacilitator.registerUsageTracker(new AnalyticsBasedUsageTracker.Builder(targetContext).buildIfPossible());
        }
    }

    TestRequestBuilder createTestRequestBuilder(Instrumentation instrumentation, Bundle bundle) {
        return new TestRequestBuilder(instrumentation, bundle);
    }
}
