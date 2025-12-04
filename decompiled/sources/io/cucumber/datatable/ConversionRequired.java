package io.cucumber.datatable;

import io.cucumber.datatable.DataTable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
final class ConversionRequired implements DataTable.TableConverter {
    ConversionRequired() {
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public Object convert(DataTable dataTable, Type type) {
        return convert(dataTable, type, false);
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public Object convert(DataTable dataTable, Type type, boolean z) {
        throw new CucumberDataTableException(String.format("Can't convert DataTable to %s. You have to write the conversion for it in this method", type));
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public List toList(DataTable dataTable, Type type) {
        throw new CucumberDataTableException(String.format("Can't convert DataTable to List<%s>. You have to write the conversion for it in this method", type));
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public List toLists(DataTable dataTable, Type type) {
        throw new CucumberDataTableException(String.format("Can't convert DataTable to List<List<%s>>. You have to write the conversion for it in this method", type));
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public Map toMap(DataTable dataTable, Type type, Type type2) {
        throw new CucumberDataTableException(String.format("Can't convert DataTable to Map<%s,%s>. You have to write the conversion for it in this method", type, type2));
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public List toMaps(DataTable dataTable, Type type, Type type2) {
        throw new CucumberDataTableException(String.format("Can't convert DataTable to List<Map<%s,%s>>. You have to write the conversion for it in this method", type, type2));
    }
}
