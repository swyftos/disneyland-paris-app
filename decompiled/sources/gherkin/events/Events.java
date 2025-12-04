package gherkin.events;

import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.TokenMatcher;
import gherkin.ast.GherkinDocument;
import gherkin.pickles.Compiler;
import gherkin.pickles.Pickle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Events {
    public static List<CucumberEvent> generate(String str, String str2) {
        return generate(str, str2, new TokenMatcher());
    }

    public static List<CucumberEvent> generate(String str, String str2, String str3) {
        return generate(str, str2, new TokenMatcher(str3));
    }

    private static List generate(String str, String str2, TokenMatcher tokenMatcher) {
        Parser parser = new Parser(new AstBuilder());
        Compiler compiler = new Compiler();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SourceEvent(str, str2));
        GherkinDocument gherkinDocument = (GherkinDocument) parser.parse(str, tokenMatcher);
        arrayList.add(new GherkinDocumentEvent(str2, gherkinDocument));
        Iterator<Pickle> it = compiler.compile(gherkinDocument).iterator();
        while (it.hasNext()) {
            arrayList.add(new PickleEvent(str2, it.next()));
        }
        return arrayList;
    }
}
