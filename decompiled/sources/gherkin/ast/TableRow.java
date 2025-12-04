package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class TableRow extends Node {
    private final List cells;

    public TableRow(Location location, List<TableCell> list) {
        super(location);
        this.cells = Collections.unmodifiableList(list);
    }

    public List<TableCell> getCells() {
        return this.cells;
    }
}
