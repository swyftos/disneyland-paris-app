package cucumber.runtime;

import gherkin.pickles.PickleStep;
import io.cucumber.stepexpression.Argument;
import java.util.List;

/* loaded from: classes5.dex */
public interface StepDefinition {
    void execute(Object[] objArr) throws Throwable;

    String getLocation(boolean z);

    Integer getParameterCount();

    String getPattern();

    boolean isDefinedAt(StackTraceElement stackTraceElement);

    @Deprecated
    boolean isScenarioScoped();

    List<Argument> matchedArguments(PickleStep pickleStep);
}
