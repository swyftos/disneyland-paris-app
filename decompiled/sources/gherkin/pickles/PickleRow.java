package gherkin.pickles;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class PickleRow {
    private final List cells;

    public PickleRow(List<PickleCell> list) {
        this.cells = Collections.unmodifiableList(list);
    }

    public List<PickleCell> getCells() {
        return this.cells;
    }
}
