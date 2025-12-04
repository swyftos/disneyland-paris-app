package cucumber.runtime;

import cucumber.runtime.snippets.FunctionNameGenerator;
import gherkin.pickles.PickleStep;
import java.net.URI;
import java.util.List;

/* loaded from: classes5.dex */
public interface Backend {
    void buildWorld();

    void disposeWorld();

    List<String> getSnippet(PickleStep pickleStep, String str, FunctionNameGenerator functionNameGenerator);

    void loadGlue(Glue glue, List<URI> list);
}
