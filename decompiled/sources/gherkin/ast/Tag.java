package gherkin.ast;

/* loaded from: classes5.dex */
public class Tag extends Node {
    private final String name;

    public Tag(Location location, String str) {
        super(location);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
