package io.cucumber.stepexpression;

import gherkin.pickles.PickleCell;
import gherkin.pickles.PickleRow;
import gherkin.pickles.PickleTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
abstract class PickleTableConverter {
    static List toTable(PickleTable pickleTable) {
        ArrayList arrayList = new ArrayList();
        for (PickleRow pickleRow : pickleTable.getRows()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<PickleCell> it = pickleRow.getCells().iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getValue());
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
