package gherkin.pickles;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class PickleTable implements Argument {
    private final List rows;

    public PickleTable(List<PickleRow> list) {
        this.rows = Collections.unmodifiableList(list);
    }

    public List<PickleRow> getRows() {
        return this.rows;
    }

    @Override // gherkin.pickles.Argument
    public PickleLocation getLocation() {
        return ((PickleRow) this.rows.get(0)).getCells().get(0).getLocation();
    }
}
