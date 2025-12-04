package io.cucumber.datatable;

import java.util.List;

/* loaded from: classes5.dex */
class DiffableRow {
    private final List convertedRow;
    final List row;

    DiffableRow(List list, List list2) {
        this.row = list;
        this.convertedRow = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.convertedRow.equals(((DiffableRow) obj).convertedRow);
    }

    public int hashCode() {
        return this.convertedRow.hashCode();
    }
}
