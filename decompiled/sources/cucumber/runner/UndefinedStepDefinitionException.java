package cucumber.runner;

import cucumber.runtime.CucumberException;

/* loaded from: classes5.dex */
final class UndefinedStepDefinitionException extends CucumberException {
    UndefinedStepDefinitionException() {
        super("No step definitions found");
    }
}
