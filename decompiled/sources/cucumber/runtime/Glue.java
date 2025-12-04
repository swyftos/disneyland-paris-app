package cucumber.runtime;

/* loaded from: classes5.dex */
public interface Glue {
    void addAfterHook(HookDefinition hookDefinition);

    void addAfterStepHook(HookDefinition hookDefinition);

    void addBeforeHook(HookDefinition hookDefinition);

    void addBeforeStepHook(HookDefinition hookDefinition);

    void addStepDefinition(StepDefinition stepDefinition) throws DuplicateStepDefinitionException;

    void removeScenarioScopedGlue();
}
