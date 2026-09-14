package gherkin.events;

import gherkin.ast.GherkinDocument;

/* JADX INFO: loaded from: classes5.dex */
public class GherkinDocumentEvent implements CucumberEvent {
    public final GherkinDocument document;
    private final String type = "gherkin-document";
    public final String uri;

    public GherkinDocumentEvent(String str, GherkinDocument gherkinDocument) {
        this.uri = str;
        this.document = gherkinDocument;
    }
}
