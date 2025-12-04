package cucumber.runtime;

import cucumber.api.Scenario;
import gherkin.pickles.PickleTag;
import java.util.Collection;

/* loaded from: classes5.dex */
public interface HookDefinition {
    void execute(Scenario scenario) throws Throwable;

    String getLocation(boolean z);

    int getOrder();

    @Deprecated
    boolean isScenarioScoped();

    boolean matches(Collection<PickleTag> collection);
}
