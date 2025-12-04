package gherkin.ast;

/* loaded from: classes5.dex */
public class Step extends Node {
    private final Node argument;
    private final String keyword;
    private final String text;

    public Step(Location location, String str, String str2, Node node) {
        super(location);
        this.keyword = str;
        this.text = str2;
        this.argument = node;
    }

    public String getText() {
        return this.text;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public Node getArgument() {
        return this.argument;
    }
}
