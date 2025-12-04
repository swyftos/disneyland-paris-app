package cucumber.runner;

import cucumber.api.event.Event;
import cucumber.api.event.EventHandler;
import cucumber.runtime.BackendSupplier;
import io.cucumber.core.options.RunnerOptions;

/* loaded from: classes5.dex */
public class ThreadLocalRunnerSupplier implements RunnerSupplier {
    private final BackendSupplier backendSupplier;
    private final RunnerOptions runnerOptions;
    private final ThreadLocal runners = new ThreadLocal() { // from class: cucumber.runner.ThreadLocalRunnerSupplier.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Runner initialValue() {
            return ThreadLocalRunnerSupplier.this.createRunner();
        }
    };
    private final SynchronizedEventBus sharedEventBus;

    public ThreadLocalRunnerSupplier(RunnerOptions runnerOptions, EventBus eventBus, BackendSupplier backendSupplier) {
        this.runnerOptions = runnerOptions;
        this.sharedEventBus = SynchronizedEventBus.synchronize(eventBus);
        this.backendSupplier = backendSupplier;
    }

    @Override // cucumber.runner.RunnerSupplier
    public Runner get() {
        return (Runner) this.runners.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runner createRunner() {
        return new Runner(new LocalEventBus(this.sharedEventBus), this.backendSupplier.get(), this.runnerOptions);
    }

    private static final class LocalEventBus extends AbstractEventBus {
        private final SynchronizedEventBus parent;

        LocalEventBus(SynchronizedEventBus synchronizedEventBus) {
            this.parent = synchronizedEventBus;
        }

        @Override // cucumber.runner.EventBus
        public Long getTime() {
            return this.parent.getTime();
        }

        @Override // cucumber.runner.AbstractEventBus, cucumber.runner.AbstractEventPublisher, cucumber.runner.EventBus
        public void send(Event event) {
            super.send(event);
            this.parent.send(event);
        }

        @Override // cucumber.runner.EventBus
        public Long getTimeMillis() {
            return this.parent.getTimeMillis();
        }
    }

    private static final class SynchronizedEventBus implements EventBus {
        private final EventBus delegate;

        static SynchronizedEventBus synchronize(EventBus eventBus) {
            if (eventBus instanceof SynchronizedEventBus) {
                return (SynchronizedEventBus) eventBus;
            }
            return new SynchronizedEventBus(eventBus);
        }

        private SynchronizedEventBus(EventBus eventBus) {
            this.delegate = eventBus;
        }

        @Override // cucumber.runner.EventBus
        public synchronized Long getTime() {
            return this.delegate.getTime();
        }

        @Override // cucumber.runner.EventBus
        public synchronized void send(Event event) {
            this.delegate.send(event);
        }

        @Override // cucumber.runner.EventBus
        public synchronized void sendAll(Iterable iterable) {
            this.delegate.sendAll(iterable);
        }

        @Override // cucumber.api.event.EventPublisher
        public synchronized void registerHandlerFor(Class cls, EventHandler eventHandler) {
            this.delegate.registerHandlerFor(cls, eventHandler);
        }

        @Override // cucumber.api.event.EventPublisher
        public synchronized void removeHandlerFor(Class cls, EventHandler eventHandler) {
            this.delegate.removeHandlerFor(cls, eventHandler);
        }

        @Override // cucumber.runner.EventBus
        public Long getTimeMillis() {
            return this.delegate.getTimeMillis();
        }
    }
}
