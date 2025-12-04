package cucumber.runtime.java;

/* loaded from: classes5.dex */
final class JavaSnippet extends AbstractJavaSnippet {
    JavaSnippet() {
    }

    @Override // cucumber.runtime.snippets.Snippet
    public String template() {
        return "@{0}(\"{1}\")\npublic void {2}({3}) '{'\n    // {4}\n{5}    throw new cucumber.api.PendingException();\n'}'\n";
    }
}
