package io.cucumber.datatable;

import io.cucumber.datatable.dependency.difflib.Delta;
import io.cucumber.datatable.dependency.difflib.DiffUtils;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class TableDiffer {
    private final DataTable from;
    private final DataTable to;

    public TableDiffer(DataTable dataTable, DataTable dataTable2) {
        checkColumns(dataTable, dataTable2);
        this.from = dataTable;
        this.to = dataTable2;
    }

    private void checkColumns(DataTable dataTable, DataTable dataTable2) {
        if (dataTable.width() == dataTable2.width() || dataTable2.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("Tables must have equal number of columns:\n" + dataTable + "\n" + dataTable2);
    }

    public DataTableDiff calculateDiffs() {
        return createTableDiff(createDeltasByLine());
    }

    public DataTableDiff calculateUnorderedDiffs() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.to.cells());
        for (List<String> list : this.from.cells()) {
            if (!this.to.cells().contains(list)) {
                arrayList.add(new AbstractMap.SimpleEntry(list, DiffType.DELETE));
            } else {
                arrayList.add(new AbstractMap.SimpleEntry(list, DiffType.NONE));
                arrayList2.remove(list);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(new AbstractMap.SimpleEntry((List) it.next(), DiffType.INSERT));
        }
        return DataTableDiff.create(arrayList);
    }

    private static List getDiffableRows(DataTable dataTable) {
        ArrayList arrayList = new ArrayList();
        for (List<String> list : dataTable.cells()) {
            arrayList.add(new DiffableRow(list, list));
        }
        return arrayList;
    }

    private Map createDeltasByLine() {
        List<Delta> deltas = DiffUtils.diff(getDiffableRows(this.from), getDiffableRows(this.to)).getDeltas();
        HashMap map = new HashMap();
        for (Delta delta : deltas) {
            map.put(Integer.valueOf(delta.getOriginal().getPosition()), delta);
        }
        return map;
    }

    private DataTableDiff createTableDiff(Map map) {
        ArrayList arrayList = new ArrayList();
        List<List<String>> listCells = this.from.cells();
        int size = 0;
        while (size < listCells.size()) {
            Delta delta = (Delta) map.get(Integer.valueOf(size));
            if (delta == null) {
                arrayList.add(new AbstractMap.SimpleEntry(this.from.row(size), DiffType.NONE));
            } else {
                addRowsToTableDiff(arrayList, delta);
                if (delta.getType() == Delta.TYPE.CHANGE || delta.getType() == Delta.TYPE.DELETE) {
                    size += delta.getOriginal().getLines().size() - 1;
                } else {
                    arrayList.add(new AbstractMap.SimpleEntry(this.from.row(size), DiffType.NONE));
                }
            }
            size++;
        }
        Delta delta2 = (Delta) map.get(Integer.valueOf(listCells.size()));
        if (delta2 != null) {
            addRowsToTableDiff(arrayList, delta2);
        }
        return DataTableDiff.create(arrayList);
    }

    private void addRowsToTableDiff(List list, Delta delta) {
        markChangedAndDeletedRowsInOriginalAsMissing(list, delta);
        markChangedAndInsertedRowsInRevisedAsNew(list, delta);
    }

    private void markChangedAndDeletedRowsInOriginalAsMissing(List list, Delta delta) {
        Iterator it = delta.getOriginal().getLines().iterator();
        while (it.hasNext()) {
            list.add(new AbstractMap.SimpleEntry(((DiffableRow) it.next()).row, DiffType.DELETE));
        }
    }

    private void markChangedAndInsertedRowsInRevisedAsNew(List list, Delta delta) {
        Iterator it = delta.getRevised().getLines().iterator();
        while (it.hasNext()) {
            list.add(new AbstractMap.SimpleEntry(((DiffableRow) it.next()).row, DiffType.INSERT));
        }
    }
}
