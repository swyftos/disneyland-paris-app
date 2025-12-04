package cucumber.api;

import gherkin.pickles.PickleTag;
import java.util.List;

/* loaded from: classes5.dex */
public interface TestCase {
    int getLine();

    String getName();

    String getScenarioDesignation();

    List<PickleTag> getTags();

    List<TestStep> getTestSteps();

    String getUri();
}
