package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class DataTable extends Node {
    private final List rows;

    public DataTable(List<TableRow> list) {
        super(list.get(0).getLocation());
        this.rows = Collections.unmodifiableList(list);
    }

    public List<TableRow> getRows() {
        return this.rows;
    }
}
