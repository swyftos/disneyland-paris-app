package io.cucumber.datatable;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class DataTableDiff {
    private final List diffTypes;
    private final List table;

    static DataTableDiff create(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            arrayList2.add(simpleEntry.getKey());
            arrayList.add(simpleEntry.getValue());
        }
        return new DataTableDiff(arrayList2, arrayList);
    }

    private DataTableDiff(List list, List list2) {
        this.table = list;
        this.diffTypes = list2;
    }

    public boolean isEmpty() {
        return (this.diffTypes.contains(DiffType.DELETE) || this.diffTypes.contains(DiffType.INSERT)) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        new DiffTablePrinter(this.diffTypes).printTable(this.table, sb);
        return sb.toString();
    }
}
