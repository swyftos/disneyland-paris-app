package cucumber.runtime.model;

import cucumber.runtime.CucumberException;
import cucumber.runtime.io.Resource;
import cucumber.util.Encoding;
import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.ParserException;
import gherkin.TokenMatcher;
import gherkin.ast.GherkinDocument;
import gherkin.events.PickleEvent;
import gherkin.pickles.Compiler;
import gherkin.pickles.Pickle;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class FeatureParser {
    public static CucumberFeature parseResource(Resource resource) {
        Objects.requireNonNull(resource);
        URI path = resource.getPath();
        String str = read(resource);
        try {
            GherkinDocument gherkinDocument = (GherkinDocument) new Parser(new AstBuilder()).parse(str, new TokenMatcher());
            return new CucumberFeature(gherkinDocument, path, str, compilePickles(gherkinDocument, resource));
        } catch (ParserException e) {
            throw new CucumberException("Failed to parse resource at: " + path.toString(), e);
        }
    }

    private static String read(Resource resource) {
        try {
            return Encoding.readFile(resource);
        } catch (IOException e) {
            throw new CucumberException("Failed to read resource:" + resource.getPath(), e);
        }
    }

    private static List compilePickles(GherkinDocument gherkinDocument, Resource resource) {
        if (gherkinDocument.getFeature() == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Pickle> it = new Compiler().compile(gherkinDocument).iterator();
        while (it.hasNext()) {
            arrayList.add(new PickleEvent(resource.getPath().toString(), it.next()));
        }
        return arrayList;
    }
}
