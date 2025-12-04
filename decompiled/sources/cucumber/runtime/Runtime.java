package cucumber.runtime;

import cucumber.api.Plugin;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.runner.EventBus;
import cucumber.runner.RunnerSupplier;
import cucumber.runner.SingletonRunnerSupplier;
import cucumber.runner.ThreadLocalRunnerSupplier;
import cucumber.runner.TimeService;
import cucumber.runner.TimeServiceEventBus;
import cucumber.runtime.filter.Filters;
import cucumber.runtime.formatter.PluginFactory;
import cucumber.runtime.formatter.Plugins;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.FeatureLoader;
import cucumber.runtime.order.PickleOrder;
import gherkin.events.PickleEvent;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.core.options.RuntimeOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class Runtime {
    private static final Logger log = LoggerFactory.getLogger(Runtime.class);
    private final EventBus bus;
    private final ExecutorService executor;
    private final ExitStatus exitStatus;
    private final FeatureSupplier featureSupplier;
    private final Filters filters;
    private final PickleOrder pickleOrder;
    private final Plugins plugins;
    private final RunnerSupplier runnerSupplier;

    public Runtime(Plugins plugins, RuntimeOptions runtimeOptions, EventBus eventBus, Filters filters, RunnerSupplier runnerSupplier, FeatureSupplier featureSupplier, ExecutorService executorService, PickleOrder pickleOrder) {
        this.plugins = plugins;
        this.filters = filters;
        this.bus = eventBus;
        this.runnerSupplier = runnerSupplier;
        this.featureSupplier = featureSupplier;
        this.executor = executorService;
        ExitStatus exitStatus = new ExitStatus(runtimeOptions);
        this.exitStatus = exitStatus;
        this.pickleOrder = pickleOrder;
        exitStatus.setEventPublisher(eventBus);
    }

    public void run() throws ExecutionException, InterruptedException {
        List<CucumberFeature> list = this.featureSupplier.get();
        EventBus eventBus = this.bus;
        eventBus.send(new TestRunStarted(eventBus.getTime(), this.bus.getTimeMillis().longValue()));
        Iterator<CucumberFeature> it = list.iterator();
        while (it.hasNext()) {
            it.next().sendTestSourceRead(this.bus);
        }
        this.runnerSupplier.get().reportStepDefinitions(this.plugins.stepDefinitionReporter());
        ArrayList arrayList = new ArrayList();
        Iterator<CucumberFeature> it2 = list.iterator();
        while (it2.hasNext()) {
            for (PickleEvent pickleEvent : it2.next().getPickles()) {
                if (this.filters.matchesFilters(pickleEvent)) {
                    arrayList.add(pickleEvent);
                }
            }
        }
        List<PickleEvent> listLimitPickleEvents = this.filters.limitPickleEvents(this.pickleOrder.orderPickleEvents(arrayList));
        ArrayList arrayList2 = new ArrayList();
        for (final PickleEvent pickleEvent2 : listLimitPickleEvents) {
            arrayList2.add(this.executor.submit(new Runnable() { // from class: cucumber.runtime.Runtime.1
                @Override // java.lang.Runnable
                public void run() {
                    Runtime.this.runnerSupplier.get().runPickle(pickleEvent2);
                }
            }));
        }
        this.executor.shutdown();
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            try {
                ((Future) it3.next()).get();
            } catch (InterruptedException e) {
                this.executor.shutdownNow();
                throw new CucumberException(e);
            } catch (ExecutionException e2) {
                log.error("Exception while executing pickle", e2);
                arrayList3.add(e2.getCause());
            }
        }
        if (arrayList3.size() == 1) {
            throw new CucumberException((Throwable) arrayList3.get(0));
        }
        if (arrayList3.size() > 1) {
            throw new CompositeCucumberException(arrayList3);
        }
        EventBus eventBus2 = this.bus;
        eventBus2.send(new TestRunFinished(eventBus2.getTime(), this.bus.getTimeMillis().longValue()));
    }

    public byte exitStatus() {
        return this.exitStatus.exitStatus();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List additionalPlugins;
        private BackendSupplier backendSupplier;
        private ClassFinder classFinder;
        private ClassLoader classLoader;
        private EventBus eventBus;
        private FeatureSupplier featureSupplier;
        private ResourceLoader resourceLoader;
        private RuntimeOptions runtimeOptions;

        private Builder() {
            this.eventBus = new TimeServiceEventBus(TimeService.SYSTEM);
            this.classLoader = Thread.currentThread().getContextClassLoader();
            this.runtimeOptions = RuntimeOptions.defaultOptions();
            this.additionalPlugins = Collections.emptyList();
        }

        public Builder withRuntimeOptions(RuntimeOptions runtimeOptions) {
            this.runtimeOptions = runtimeOptions;
            return this;
        }

        public Builder withClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
            return this;
        }

        public Builder withResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
            return this;
        }

        public Builder withClassFinder(ClassFinder classFinder) {
            this.classFinder = classFinder;
            return this;
        }

        public Builder withBackendSupplier(BackendSupplier backendSupplier) {
            this.backendSupplier = backendSupplier;
            return this;
        }

        public Builder withFeatureSupplier(FeatureSupplier featureSupplier) {
            this.featureSupplier = featureSupplier;
            return this;
        }

        public Builder withAdditionalPlugins(Plugin... pluginArr) {
            this.additionalPlugins = Arrays.asList(pluginArr);
            return this;
        }

        public Builder withEventBus(EventBus eventBus) {
            this.eventBus = eventBus;
            return this;
        }

        public Runtime build() {
            ResourceLoader multiLoader = this.resourceLoader;
            if (multiLoader == null) {
                multiLoader = new MultiLoader(this.classLoader);
            }
            ClassFinder resourceLoaderClassFinder = this.classFinder;
            if (resourceLoaderClassFinder == null) {
                resourceLoaderClassFinder = new ResourceLoaderClassFinder(multiLoader, this.classLoader);
            }
            BackendSupplier backendModuleBackendSupplier = this.backendSupplier;
            if (backendModuleBackendSupplier == null) {
                backendModuleBackendSupplier = new BackendModuleBackendSupplier(multiLoader, resourceLoaderClassFinder, this.runtimeOptions);
            }
            Plugins plugins = new Plugins(this.classLoader, new PluginFactory(), this.runtimeOptions);
            Iterator it = this.additionalPlugins.iterator();
            while (it.hasNext()) {
                plugins.addPlugin((Plugin) it.next());
            }
            if (this.runtimeOptions.isMultiThreaded()) {
                plugins.setSerialEventBusOnEventListenerPlugins(this.eventBus);
            } else {
                plugins.setEventBusOnEventListenerPlugins(this.eventBus);
            }
            RunnerSupplier threadLocalRunnerSupplier = this.runtimeOptions.isMultiThreaded() ? new ThreadLocalRunnerSupplier(this.runtimeOptions, this.eventBus, backendModuleBackendSupplier) : new SingletonRunnerSupplier(this.runtimeOptions, this.eventBus, backendModuleBackendSupplier);
            ExecutorService executorServiceNewFixedThreadPool = this.runtimeOptions.isMultiThreaded() ? Executors.newFixedThreadPool(this.runtimeOptions.getThreads(), new CucumberThreadFactory()) : new SameThreadExecutorService();
            FeatureLoader featureLoader = new FeatureLoader(multiLoader);
            FeatureSupplier featurePathFeatureSupplier = this.featureSupplier;
            if (featurePathFeatureSupplier == null) {
                featurePathFeatureSupplier = new FeaturePathFeatureSupplier(featureLoader, this.runtimeOptions);
            }
            return new Runtime(plugins, this.runtimeOptions, this.eventBus, new Filters(this.runtimeOptions), threadLocalRunnerSupplier, featurePathFeatureSupplier, executorServiceNewFixedThreadPool, this.runtimeOptions.getPickleOrder());
        }
    }

    private static final class CucumberThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix = "cucumber-runner-" + poolNumber.getAndIncrement() + "-thread-";

        CucumberThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.namePrefix + this.threadNumber.getAndIncrement());
        }
    }

    private static final class SameThreadExecutorService extends AbstractExecutorService {
        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
        }

        private SameThreadExecutorService() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.util.concurrent.ExecutorService
        public List shutdownNow() {
            return Collections.emptyList();
        }
    }
}
