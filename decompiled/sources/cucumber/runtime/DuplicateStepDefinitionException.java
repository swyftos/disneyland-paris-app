package cucumber.runtime;

/* loaded from: classes5.dex */
public class DuplicateStepDefinitionException extends CucumberException {
    public DuplicateStepDefinitionException(StepDefinition stepDefinition, StepDefinition stepDefinition2) {
        super(createMessage(stepDefinition, stepDefinition2));
    }

    private static String createMessage(StepDefinition stepDefinition, StepDefinition stepDefinition2) {
        return String.format("Duplicate step definitions in %s and %s", stepDefinition.getLocation(true), stepDefinition2.getLocation(true));
    }
}
