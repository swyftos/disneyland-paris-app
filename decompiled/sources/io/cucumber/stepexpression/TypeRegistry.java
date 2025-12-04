package io.cucumber.stepexpression;

import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.ParameterTypeRegistry;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class TypeRegistry implements cucumber.api.TypeRegistry, io.cucumber.core.api.TypeRegistry {
    private final DataTableTypeRegistry dataTableTypeRegistry;
    private final ParameterTypeRegistry parameterTypeRegistry;

    public TypeRegistry(Locale locale) {
        this.parameterTypeRegistry = new ParameterTypeRegistry(locale);
        this.dataTableTypeRegistry = new DataTableTypeRegistry(locale);
    }

    public ParameterTypeRegistry parameterTypeRegistry() {
        return this.parameterTypeRegistry;
    }

    public DataTableTypeRegistry dataTableTypeRegistry() {
        return this.dataTableTypeRegistry;
    }

    @Override // cucumber.api.TypeRegistry, io.cucumber.core.api.TypeRegistry
    public void defineParameterType(ParameterType<?> parameterType) {
        this.parameterTypeRegistry.defineParameterType(parameterType);
    }

    @Override // cucumber.api.TypeRegistry, io.cucumber.core.api.TypeRegistry
    public void defineDataTableType(DataTableType dataTableType) {
        this.dataTableTypeRegistry.defineDataTableType(dataTableType);
    }

    @Override // cucumber.api.TypeRegistry, io.cucumber.core.api.TypeRegistry
    public void setDefaultParameterTransformer(ParameterByTypeTransformer parameterByTypeTransformer) {
        this.parameterTypeRegistry.setDefaultParameterTransformer(parameterByTypeTransformer);
    }

    @Override // cucumber.api.TypeRegistry, io.cucumber.core.api.TypeRegistry
    public void setDefaultDataTableEntryTransformer(TableEntryByTypeTransformer tableEntryByTypeTransformer) {
        this.dataTableTypeRegistry.setDefaultDataTableEntryTransformer(tableEntryByTypeTransformer);
    }

    @Override // cucumber.api.TypeRegistry, io.cucumber.core.api.TypeRegistry
    public void setDefaultDataTableCellTransformer(TableCellByTypeTransformer tableCellByTypeTransformer) {
        this.dataTableTypeRegistry.setDefaultDataTableCellTransformer(tableCellByTypeTransformer);
    }
}
