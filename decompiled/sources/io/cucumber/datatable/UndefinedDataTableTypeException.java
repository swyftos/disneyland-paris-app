package io.cucumber.datatable;

import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public class UndefinedDataTableTypeException extends CucumberDataTableException {
    private UndefinedDataTableTypeException(String str) {
        super(str);
    }

    static UndefinedDataTableTypeException singletonNoConverterDefined(Type type) {
        return new UndefinedDataTableTypeException(String.format("Can't convert DataTable to %s.\nPlease register a DataTableType with a TableTransformer, TableEntryTransformer or TableRowTransformer for %s.", TypeFactory.typeName(type), TypeFactory.typeName(type)));
    }

    static UndefinedDataTableTypeException mapNoConverterDefined(Type type, Type type2, String str, Type type3) {
        return new UndefinedDataTableTypeException(String.format("Can't convert DataTable to Map<%s, %s>.\nPlease register a DataTableType with a %s for %s.", TypeFactory.typeName(type), TypeFactory.typeName(type2), str, TypeFactory.typeName(type3)));
    }

    static UndefinedDataTableTypeException mapsNoConverterDefined(Type type, Type type2, Type type3) {
        return new UndefinedDataTableTypeException(String.format("Can't convert DataTable to List<Map<%s, %s>>.\nPlease register a DataTableType with a TableCellTransformer for %s.", TypeFactory.typeName(type), TypeFactory.typeName(type2), TypeFactory.typeName(type3)));
    }

    static CucumberDataTableException listNoConverterDefined(Type type, String str, Type type2) {
        return new UndefinedDataTableTypeException(String.format("Can't convert DataTable to List<%s>.\nYou can register a DataTableType using DataTableType.entry(%s.class).\nFor more control you can define your own DataTableType with a %s for %s.\n", TypeFactory.typeName(type), TypeFactory.typeName(type2), str, TypeFactory.typeName(type2)));
    }

    static CucumberDataTableException listsNoConverterDefined(Type type) {
        return new UndefinedDataTableTypeException(String.format("Can't convert DataTable to List<List<%s>>.\nPlease register a DataTableType with a TableCellTransformer for %s.", TypeFactory.typeName(type), TypeFactory.typeName(type)));
    }
}
