package gherkin.stream;

import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.ParserException;
import gherkin.TokenMatcher;
import gherkin.ast.GherkinDocument;
import gherkin.events.AttachmentEvent;
import gherkin.events.CucumberEvent;
import gherkin.events.GherkinDocumentEvent;
import gherkin.events.PickleEvent;
import gherkin.events.SourceEvent;
import gherkin.pickles.Compiler;
import gherkin.pickles.Pickle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class GherkinEvents {
    private final boolean printAst;
    private final boolean printPickles;
    private final boolean printSource;
    private final Parser parser = new Parser(new AstBuilder());
    private final TokenMatcher matcher = new TokenMatcher();
    private final Compiler compiler = new Compiler();

    public GherkinEvents(boolean z, boolean z2, boolean z3) {
        this.printSource = z;
        this.printAst = z2;
        this.printPickles = z3;
    }

    public Iterable<? extends CucumberEvent> iterable(SourceEvent sourceEvent) {
        ArrayList arrayList = new ArrayList();
        try {
            GherkinDocument gherkinDocument = (GherkinDocument) this.parser.parse(sourceEvent.data, this.matcher);
            if (this.printSource) {
                arrayList.add(sourceEvent);
            }
            if (this.printAst) {
                arrayList.add(new GherkinDocumentEvent(sourceEvent.uri, gherkinDocument));
            }
            if (this.printPickles) {
                Iterator<Pickle> it = this.compiler.compile(gherkinDocument).iterator();
                while (it.hasNext()) {
                    arrayList.add(new PickleEvent(sourceEvent.uri, it.next()));
                }
            }
        } catch (ParserException.CompositeParserException e) {
            Iterator<ParserException> it2 = e.errors.iterator();
            while (it2.hasNext()) {
                addErrorAttachment(arrayList, it2.next(), sourceEvent.uri);
            }
        } catch (ParserException e2) {
            addErrorAttachment(arrayList, e2, sourceEvent.uri);
        }
        return arrayList;
    }

    private void addErrorAttachment(List list, ParserException parserException, String str) {
        list.add(new AttachmentEvent(new AttachmentEvent.SourceRef(str, new AttachmentEvent.Location(parserException.location.getLine(), parserException.location.getColumn())), parserException.getMessage()));
    }
}
