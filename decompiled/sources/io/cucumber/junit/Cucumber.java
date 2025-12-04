package io.cucumber.junit;

import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.runner.EventBus;
import cucumber.runner.ThreadLocalRunnerSupplier;
import cucumber.runner.TimeService;
import cucumber.runner.TimeServiceEventBus;
import cucumber.runtime.BackendModuleBackendSupplier;
import cucumber.runtime.Env;
import cucumber.runtime.FeaturePathFeatureSupplier;
import cucumber.runtime.filter.Filters;
import cucumber.runtime.formatter.PluginFactory;
import cucumber.runtime.formatter.Plugins;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.FeatureLoader;
import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.core.options.EnvironmentOptionsParser;
import io.cucumber.core.options.RuntimeOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;

@API(status = API.Status.STABLE)
/* loaded from: classes5.dex */
public class Cucumber extends ParentRunner<FeatureRunner> {
    private final EventBus bus;
    private final List children;
    private final List features;
    private boolean multiThreadingAssumed;
    private final Plugins plugins;
    private final ThreadLocalRunnerSupplier runnerSupplier;

    public Cucumber(Class cls) throws SecurityException, InitializationError {
        super((Class<?>) cls);
        this.children = new ArrayList();
        this.multiThreadingAssumed = false;
        Assertions.assertNoCucumberAnnotatedMethods(cls);
        ClassLoader classLoader = cls.getClassLoader();
        MultiLoader multiLoader = new MultiLoader(classLoader);
        RuntimeOptions runtimeOptionsBuild = new EnvironmentOptionsParser(multiLoader).parse(Env.INSTANCE).build(new CucumberOptionsAnnotationParser(multiLoader).withOptionsProvider(new JUnitCucumberOptionsProvider()).parse(cls).build());
        runtimeOptionsBuild.addUndefinedStepsPrinterIfSummaryNotDefined();
        JUnitOptions jUnitOptionsBuild = new JUnitOptionsParser().parse(runtimeOptionsBuild.getJunitOptions()).setStrict(runtimeOptionsBuild.isStrict()).build(new JUnitOptionsParser().parse(cls).build());
        ResourceLoaderClassFinder resourceLoaderClassFinder = new ResourceLoaderClassFinder(multiLoader, classLoader);
        List<CucumberFeature> list = new FeaturePathFeatureSupplier(new FeatureLoader(multiLoader), runtimeOptionsBuild).get();
        this.features = list;
        this.plugins = new Plugins(classLoader, new PluginFactory(), runtimeOptionsBuild);
        TimeServiceEventBus timeServiceEventBus = new TimeServiceEventBus(TimeService.SYSTEM);
        this.bus = timeServiceEventBus;
        this.runnerSupplier = new ThreadLocalRunnerSupplier(runtimeOptionsBuild, timeServiceEventBus, new BackendModuleBackendSupplier(multiLoader, resourceLoaderClassFinder, runtimeOptionsBuild));
        Filters filters = new Filters(runtimeOptionsBuild);
        Iterator<CucumberFeature> it = list.iterator();
        while (it.hasNext()) {
            FeatureRunner featureRunner = new FeatureRunner(it.next(), filters, this.runnerSupplier, jUnitOptionsBuild);
            if (!featureRunner.isEmpty()) {
                this.children.add(featureRunner);
            }
        }
    }

    @Override // org.junit.runners.ParentRunner
    public List<FeatureRunner> getChildren() {
        return this.children;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public Description describeChild(FeatureRunner featureRunner) {
        return featureRunner.getDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(FeatureRunner featureRunner, RunNotifier runNotifier) {
        featureRunner.run(runNotifier);
    }

    @Override // org.junit.runners.ParentRunner
    protected Statement childrenInvoker(RunNotifier runNotifier) {
        return new RunCucumber(super.childrenInvoker(runNotifier));
    }

    class RunCucumber extends Statement {
        private final Statement runFeatures;

        RunCucumber(Statement statement) {
            this.runFeatures = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            if (Cucumber.this.multiThreadingAssumed) {
                Cucumber.this.plugins.setSerialEventBusOnEventListenerPlugins(Cucumber.this.bus);
            } else {
                Cucumber.this.plugins.setEventBusOnEventListenerPlugins(Cucumber.this.bus);
            }
            Cucumber.this.bus.send(new TestRunStarted(Cucumber.this.bus.getTime(), Cucumber.this.bus.getTimeMillis().longValue()));
            Iterator it = Cucumber.this.features.iterator();
            while (it.hasNext()) {
                ((CucumberFeature) it.next()).sendTestSourceRead(Cucumber.this.bus);
            }
            Cucumber.this.runnerSupplier.get().reportStepDefinitions(Cucumber.this.plugins.stepDefinitionReporter());
            this.runFeatures.evaluate();
            Cucumber.this.bus.send(new TestRunFinished(Cucumber.this.bus.getTime(), Cucumber.this.bus.getTimeMillis().longValue()));
        }
    }

    @Override // org.junit.runners.ParentRunner
    public void setScheduler(RunnerScheduler runnerScheduler) {
        super.setScheduler(runnerScheduler);
        this.multiThreadingAssumed = true;
    }
}
