package cucumber.api;

import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface TypeRegistry {
    void defineDataTableType(DataTableType dataTableType);

    void defineParameterType(ParameterType<?> parameterType);

    void setDefaultDataTableCellTransformer(TableCellByTypeTransformer tableCellByTypeTransformer);

    void setDefaultDataTableEntryTransformer(TableEntryByTypeTransformer tableEntryByTypeTransformer);

    void setDefaultParameterTransformer(ParameterByTypeTransformer parameterByTypeTransformer);
}
