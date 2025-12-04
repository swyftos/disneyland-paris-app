package cucumber.runtime.java;

import cucumber.runtime.HookDefinition;
import cucumber.runtime.StepDefinition;
import io.cucumber.stepexpression.TypeRegistry;

/* loaded from: classes5.dex */
public interface LambdaGlueRegistry {
    public static final ThreadLocal<LambdaGlueRegistry> INSTANCE = new ThreadLocal<>();

    void addAfterHookDefinition(HookDefinition hookDefinition);

    void addAfterStepHookDefinition(HookDefinition hookDefinition);

    void addBeforeHookDefinition(HookDefinition hookDefinition);

    void addBeforeStepHookDefinition(HookDefinition hookDefinition);

    void addStepDefinition(Function<TypeRegistry, StepDefinition> function);
}
