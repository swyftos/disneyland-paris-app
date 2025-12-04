package gherkin.ast;

/* loaded from: classes5.dex */
public class TableCell extends Node {
    private final String value;

    public TableCell(Location location, String str) {
        super(location);
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
