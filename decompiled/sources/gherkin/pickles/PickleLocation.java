package gherkin.pickles;

/* loaded from: classes5.dex */
public class PickleLocation {
    private final int column;
    private final int line;

    public PickleLocation(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }
}
