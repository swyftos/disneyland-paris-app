package io.cucumber.datatable;

import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public class CucumberDataTableException extends RuntimeException {
    CucumberDataTableException(String str) {
        super(str);
    }

    CucumberDataTableException(String str, Throwable th) {
        super(str, th);
    }

    static CucumberDataTableException cantConvertTo(Type type, String str) {
        return new CucumberDataTableException(String.format("Can't convert DataTable to %s. %s", TypeFactory.typeName(type), str));
    }

    private static CucumberDataTableException cantConvertToMap(Type type, Type type2, String str) {
        return new CucumberDataTableException(String.format("Can't convert DataTable to Map<%s, %s>. %s", TypeFactory.typeName(type), TypeFactory.typeName(type2), str));
    }

    static CucumberDataTableException duplicateKeyException(Type type, Type type2, Object obj, Object obj2, Object obj3) {
        return cantConvertToMap(type, type2, String.format("Encountered duplicate key %s with values %s and %s", obj, obj3, obj2));
    }

    static CucumberDataTableException keyValueMismatchException(boolean z, int i, Type type, int i2, Type type2) {
        if (i > i2) {
            return cantConvertToMap(type, type2, "There are more keys then values. Did you use a TableEntryTransformer for the value while using a TableRow or TableCellTransformer for the keys?");
        }
        if (i2 % i == 0) {
            return cantConvertToMap(type, type2, String.format("There is more then one value per key. Did you mean to transform to Map<%s, List<%s>> instead?", TypeFactory.typeName(type), TypeFactory.typeName(type2)));
        }
        if (z) {
            return cantConvertToMap(type, type2, "There are more values then keys. The first header cell was left blank. You can add a value there");
        }
        return cantConvertToMap(type, type2, "There are more values then keys. Did you use a TableEntryTransformer for the key while using a TableRow or TableCellTransformer for the value?");
    }

    static CucumberDataTableException keysImplyTableEntryTransformer(Type type, Type type2) {
        return cantConvertToMap(type, type2, String.format("The first cell was either blank or you have registered a TableEntryTransformer for the key type.\n\nThis requires that there is a TableEntryTransformer for the value type but I couldn't find any.\n\nYou can either:\n\n  1) Use a DataTableType that uses a TableEntryTransformer for %s\n\n  2) Add a key to the first cell and use a DataTableType that uses a TableEntryTransformer for %s", type2, type));
    }
}
