package cucumber.api;

import gherkin.pickles.PickleStep;
import java.util.List;

/* loaded from: classes5.dex */
public interface PickleStepTestStep extends TestStep {
    List<Argument> getDefinitionArgument();

    String getPattern();

    PickleStep getPickleStep();

    List<gherkin.pickles.Argument> getStepArgument();

    int getStepLine();

    String getStepLocation();

    String getStepText();
}
