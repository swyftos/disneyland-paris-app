package cucumber.runner;

import cucumber.runtime.BackendSupplier;
import io.cucumber.core.options.RunnerOptions;

/* loaded from: classes5.dex */
public class SingletonRunnerSupplier implements RunnerSupplier {
    private final BackendSupplier backendSupplier;
    private final EventBus eventBus;
    private Runner runner;
    private final RunnerOptions runnerOptions;

    public SingletonRunnerSupplier(RunnerOptions runnerOptions, EventBus eventBus, BackendSupplier backendSupplier) {
        this.backendSupplier = backendSupplier;
        this.runnerOptions = runnerOptions;
        this.eventBus = eventBus;
    }

    @Override // cucumber.runner.RunnerSupplier
    public Runner get() {
        if (this.runner == null) {
            this.runner = createRunner();
        }
        return this.runner;
    }

    private Runner createRunner() {
        return new Runner(this.eventBus, this.backendSupplier.get(), this.runnerOptions);
    }
}
