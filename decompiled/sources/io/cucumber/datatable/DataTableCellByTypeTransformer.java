package io.cucumber.datatable;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
class DataTableCellByTypeTransformer implements TableCellByTypeTransformer {
    private DataTableTypeRegistry dataTableTypeRegistry;

    DataTableCellByTypeTransformer(DataTableTypeRegistry dataTableTypeRegistry) {
        this.dataTableTypeRegistry = dataTableTypeRegistry;
    }

    @Override // io.cucumber.datatable.TableCellByTypeTransformer
    public Object transform(String str, Class cls) {
        DataTableType dataTableTypeLookupTableTypeByType = this.dataTableTypeRegistry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(cls)));
        if (dataTableTypeLookupTableTypeByType == null) {
            throw new CucumberDataTableException("There is no DataTableType registered for cell type " + cls);
        }
        return ((List) ((List) dataTableTypeLookupTableTypeByType.transform(Collections.singletonList(Collections.singletonList(str)))).get(0)).get(0);
    }
}
