package gherkin.ast;

/* loaded from: classes5.dex */
public class Comment extends Node {
    private final String text;

    public Comment(Location location, String str) {
        super(location);
        this.text = str;
    }

    public String getText() {
        return this.text;
    }
}
