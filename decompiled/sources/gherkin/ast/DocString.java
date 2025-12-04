package gherkin.ast;

/* loaded from: classes5.dex */
public class DocString extends Node {
    private final String content;
    private final String contentType;

    public DocString(Location location, String str, String str2) {
        super(location);
        this.contentType = str;
        this.content = str2;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }
}
