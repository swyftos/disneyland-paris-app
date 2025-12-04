package cucumber.runner;

import cucumber.api.HookType;

/* loaded from: classes5.dex */
final class HookTestStep extends TestStep implements cucumber.api.HookTestStep {
    private final HookType hookType;

    HookTestStep(HookType hookType, HookDefinitionMatch hookDefinitionMatch) {
        super(hookDefinitionMatch);
        this.hookType = hookType;
    }

    @Override // cucumber.api.HookTestStep
    public HookType getHookType() {
        return this.hookType;
    }
}
