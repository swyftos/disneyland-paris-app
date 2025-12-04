package io.cucumber.datatable;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class DataTableType {
    private static final ConversionRequired CONVERSION_REQUIRED = new ConversionRequired();
    private final Class elementType;
    private final JavaType targetType;
    private final RawTableTransformer transformer;

    interface RawTableTransformer {
        Class getOriginalTransformerType();

        Object transform(List list);
    }

    private DataTableType(Class cls, Type type, RawTableTransformer rawTableTransformer) {
        if (cls == null) {
            throw new NullPointerException("targetType cannot be null");
        }
        if (type == null) {
            throw new NullPointerException("target cannot be null");
        }
        if (rawTableTransformer == null) {
            throw new NullPointerException("transformer cannot be null");
        }
        this.elementType = cls;
        this.targetType = TypeFactory.constructType(type);
        this.transformer = rawTableTransformer;
    }

    public <T> DataTableType(Class<T> cls, TableTransformer<T> tableTransformer) {
        this(cls, cls, new TableTransformerAdaptor(tableTransformer));
    }

    public <T> DataTableType(Class<T> cls, TableRowTransformer<T> tableRowTransformer) {
        this(cls, TypeFactory.aListOf(cls), new TableRowTransformerAdaptor(tableRowTransformer));
    }

    public <T> DataTableType(Class<T> cls, TableEntryTransformer<T> tableEntryTransformer) {
        this(cls, TypeFactory.aListOf(cls), new TableEntryTransformerAdaptor(tableEntryTransformer));
    }

    public <T> DataTableType(Class<T> cls, TableCellTransformer<T> tableCellTransformer) {
        this(cls, TypeFactory.aListOf(TypeFactory.aListOf(cls)), new TableCellTransformerAdaptor(tableCellTransformer));
    }

    public static <T> DataTableType entry(final Class<T> cls) {
        return new DataTableType(cls, new TableEntryTransformer() { // from class: io.cucumber.datatable.DataTableType.1
            @Override // io.cucumber.datatable.TableEntryTransformer
            public Object transform(Map map) {
                return new ObjectMapper().convertValue(map, cls);
            }
        });
    }

    public static <T> DataTableType cell(final Class<T> cls) {
        return new DataTableType(cls, new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableType.2
            @Override // io.cucumber.datatable.TableCellTransformer
            public Object transform(String str) {
                return new ObjectMapper().convertValue(str, cls);
            }
        });
    }

    static DataTableType defaultCell(final Class cls, final TableCellByTypeTransformer tableCellByTypeTransformer) {
        return new DataTableType(cls, new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableType.3
            @Override // io.cucumber.datatable.TableCellTransformer
            public Object transform(String str) {
                return tableCellByTypeTransformer.transform(str, cls);
            }
        });
    }

    static DataTableType defaultEntry(final Class cls, final TableEntryByTypeTransformer tableEntryByTypeTransformer, final TableCellByTypeTransformer tableCellByTypeTransformer) {
        return new DataTableType(cls, new TableEntryTransformer() { // from class: io.cucumber.datatable.DataTableType.4
            @Override // io.cucumber.datatable.TableEntryTransformer
            public Object transform(Map map) {
                return tableEntryByTypeTransformer.transform(map, cls, tableCellByTypeTransformer);
            }
        });
    }

    public Object transform(List<List<String>> list) {
        try {
            return this.transformer.transform(list);
        } catch (Throwable th) {
            throw new CucumberDataTableException(String.format("'%s' could not transform%n%s", this.toCanonical(), DataTable.create(list)), th);
        }
    }

    JavaType getTargetType() {
        return this.targetType;
    }

    String toCanonical() {
        return this.targetType.toCanonical();
    }

    Class getElementType() {
        return this.elementType;
    }

    Class getTransformerType() {
        return this.transformer.getOriginalTransformerType();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DataTableType.class != obj.getClass()) {
            return false;
        }
        return this.targetType.equals(((DataTableType) obj).targetType);
    }

    public int hashCode() {
        return this.targetType.hashCode();
    }

    private static class TableCellTransformerAdaptor implements RawTableTransformer {
        private final TableCellTransformer transformer;

        TableCellTransformerAdaptor(TableCellTransformer tableCellTransformer) {
            if (tableCellTransformer == null) {
                throw new NullPointerException("transformer cannot be null");
            }
            this.transformer = tableCellTransformer;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public Class getOriginalTransformerType() {
            return TableCellTransformer.class;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public List transform(List list) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                List list2 = (List) it.next();
                ArrayList arrayList2 = new ArrayList(list2.size());
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(this.transformer.transform((String) it2.next()));
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
    }

    private static class TableRowTransformerAdaptor implements RawTableTransformer {
        private final TableRowTransformer transformer;

        TableRowTransformerAdaptor(TableRowTransformer tableRowTransformer) {
            if (tableRowTransformer == null) {
                throw new NullPointerException("transformer cannot be null");
            }
            this.transformer = tableRowTransformer;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public Class getOriginalTransformerType() {
            return TableRowTransformer.class;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public List transform(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(this.transformer.transform((List) it.next()));
            }
            return arrayList;
        }
    }

    private static class TableEntryTransformerAdaptor implements RawTableTransformer {
        private final TableEntryTransformer transformer;

        TableEntryTransformerAdaptor(TableEntryTransformer tableEntryTransformer) {
            if (tableEntryTransformer == null) {
                throw new NullPointerException("transformer cannot be null");
            }
            this.transformer = tableEntryTransformer;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public Class getOriginalTransformerType() {
            return TableEntryTransformer.class;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public List transform(List list) {
            DataTable dataTableCreate = DataTable.create(list, DataTableType.CONVERSION_REQUIRED);
            ArrayList arrayList = new ArrayList();
            Iterator<Map<String, String>> it = dataTableCreate.asMaps().iterator();
            while (it.hasNext()) {
                arrayList.add(this.transformer.transform(it.next()));
            }
            return arrayList;
        }
    }

    private static class TableTransformerAdaptor implements RawTableTransformer {
        private final TableTransformer transformer;

        TableTransformerAdaptor(TableTransformer tableTransformer) {
            if (tableTransformer == null) {
                throw new NullPointerException("transformer cannot be null");
            }
            this.transformer = tableTransformer;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public Class getOriginalTransformerType() {
            return TableTransformer.class;
        }

        @Override // io.cucumber.datatable.DataTableType.RawTableTransformer
        public Object transform(List list) {
            return this.transformer.transform(DataTable.create(list, DataTableType.CONVERSION_REQUIRED));
        }
    }
}
