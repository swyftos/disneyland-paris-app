package io.cucumber.core.api;

import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import org.apiguardian.api.API;

@API(status = API.Status.STABLE)
/* loaded from: classes5.dex */
public interface TypeRegistry {
    void defineDataTableType(DataTableType dataTableType);

    void defineParameterType(ParameterType<?> parameterType);

    void setDefaultDataTableCellTransformer(TableCellByTypeTransformer tableCellByTypeTransformer);

    void setDefaultDataTableEntryTransformer(TableEntryByTypeTransformer tableEntryByTypeTransformer);

    void setDefaultParameterTransformer(ParameterByTypeTransformer parameterByTypeTransformer);
}
