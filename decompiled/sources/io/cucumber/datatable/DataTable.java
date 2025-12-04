package io.cucumber.datatable;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

/* loaded from: classes5.dex */
public final class DataTable {
    private final List raw;
    private final TableConverter tableConverter;

    public interface TableConverter {
        <T> T convert(DataTable dataTable, Type type);

        <T> T convert(DataTable dataTable, Type type, boolean z);

        <T> List<T> toList(DataTable dataTable, Type type);

        <T> List<List<T>> toLists(DataTable dataTable, Type type);

        <K, V> Map<K, V> toMap(DataTable dataTable, Type type, Type type2);

        <K, V> List<Map<K, V>> toMaps(DataTable dataTable, Type type, Type type2);
    }

    private DataTable(List list, TableConverter tableConverter) {
        if (list == null) {
            throw new NullPointerException("cells can not be null");
        }
        if (tableConverter == null) {
            throw new NullPointerException("tableConverter can not be null");
        }
        this.raw = list;
        this.tableConverter = tableConverter;
    }

    public static DataTable create(List<List<String>> list) {
        return create(list, new NoConverterDefined());
    }

    public static DataTable create(List<List<String>> list, TableConverter tableConverter) {
        return new DataTable(copy(requireNonNullEntries(requireRectangularTable(list))), tableConverter);
    }

    private static List copy(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            if (list2.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList2 = new ArrayList(list2.size());
            arrayList2.addAll(list2);
            arrayList.add(Collections.unmodifiableList(arrayList2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static List requireNonNullEntries(List list) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iIndexOf = ((List) it.next()).indexOf(null);
            if (iIndexOf >= 0) {
                throw new IllegalArgumentException("raw contained null at row: " + i + " column: " + iIndexOf);
            }
            i++;
        }
        return list;
    }

    private static List requireRectangularTable(List list) {
        int size = list.isEmpty() ? 0 : ((List) list.get(0)).size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            if (size != list2.size()) {
                throw new IllegalArgumentException(String.format("Table is not rectangular: expected %s column(s) but found %s.", Integer.valueOf(size), Integer.valueOf(list2.size())));
            }
        }
        return list;
    }

    public static DataTable emptyDataTable() {
        return new DataTable(Collections.emptyList(), new NoConverterDefined());
    }

    public void diff(DataTable dataTable) throws TableDiffException {
        DataTableDiff dataTableDiffCalculateDiffs = new TableDiffer(this, dataTable).calculateDiffs();
        if (!dataTableDiffCalculateDiffs.isEmpty()) {
            throw TableDiffException.diff(dataTableDiffCalculateDiffs);
        }
    }

    public void unorderedDiff(DataTable dataTable) throws TableDiffException {
        DataTableDiff dataTableDiffCalculateUnorderedDiffs = new TableDiffer(this, dataTable).calculateUnorderedDiffs();
        if (!dataTableDiffCalculateUnorderedDiffs.isEmpty()) {
            throw TableDiffException.diff(dataTableDiffCalculateUnorderedDiffs);
        }
    }

    public List<String> asList() {
        return new ListView();
    }

    public <T> List<T> asList(Type type) {
        return this.tableConverter.toList(this, type);
    }

    public List<List<String>> asLists() {
        return cells();
    }

    public List<List<String>> cells() {
        return this.raw;
    }

    public <T> List<List<T>> asLists(Type type) {
        return this.tableConverter.toLists(this, type);
    }

    public <K, V> Map<K, V> asMap(Type type, Type type2) {
        return this.tableConverter.toMap(this, type, type2);
    }

    public List<Map<String, String>> asMaps() {
        if (this.raw.isEmpty()) {
            return Collections.emptyList();
        }
        List list = (List) this.raw.get(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < this.raw.size(); i++) {
            List list2 = (List) this.raw.get(i);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = (String) linkedHashMap.put(list.get(i2), list2.get(i2));
                if (str != null) {
                    throw CucumberDataTableException.duplicateKeyException(String.class, String.class, list.get(i2), list2.get(i2), str);
                }
            }
            arrayList.add(Collections.unmodifiableMap(linkedHashMap));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public <K, V> List<Map<K, V>> asMaps(Type type, Type type2) {
        return this.tableConverter.toMaps(this, type, type2);
    }

    public String cell(int i, int i2) {
        rangeCheckRow(i, height());
        rangeCheckColumn(i2, width());
        return (String) ((List) this.raw.get(i)).get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rangeCheck(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", Size: " + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rangeCheckRow(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("row: " + i + ", Height: " + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rangeCheckColumn(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("column: " + i + ", Width: " + i2);
        }
    }

    public List<String> column(int i) {
        return new ColumnView(i);
    }

    public DataTable columns(int i) {
        return columns(i, width());
    }

    public DataTable columns(int i, int i2) {
        return subTable(0, i, height(), i2);
    }

    public <T> T convert(Type type, boolean z) {
        return (T) this.tableConverter.convert(this, type, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DataTable.class != obj.getClass()) {
            return false;
        }
        return this.raw.equals(((DataTable) obj).raw);
    }

    public int hashCode() {
        return this.raw.hashCode();
    }

    public boolean isEmpty() {
        return this.raw.isEmpty();
    }

    public List<String> row(int i) {
        rangeCheckRow(i, height());
        return (List) this.raw.get(i);
    }

    public DataTable rows(int i) {
        return rows(i, height());
    }

    public DataTable rows(int i, int i2) {
        return subTable(i, 0, i2, width());
    }

    public DataTable subTable(int i, int i2) {
        return subTable(i, i2, height(), width());
    }

    public DataTable subTable(int i, int i2, int i3, int i4) {
        return new DataTable(new RawDataTableView(i, i2, i4, i3), this.tableConverter);
    }

    public int height() {
        return this.raw.size();
    }

    public int width() {
        if (this.raw.isEmpty()) {
            return 0;
        }
        return ((List) this.raw.get(0)).size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb);
        return sb.toString();
    }

    public void print(Appendable appendable) throws IOException {
        new TablePrinter().printTable(this.raw, appendable);
    }

    public void print(StringBuilder sb) {
        new TablePrinter().printTable(this.raw, sb);
    }

    public DataTable transpose() {
        List list = this.raw;
        if (list instanceof TransposedRawDataTableView) {
            return ((TransposedRawDataTableView) list).dataTable();
        }
        return new DataTable(new TransposedRawDataTableView(), this.tableConverter);
    }

    static abstract class AbstractTableConverter implements TableConverter {
        AbstractTableConverter() {
        }

        static Type listItemType(Type type) {
            return typeArg(type, List.class, 0);
        }

        static Type typeArg(Type type, Class cls, int i) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                if ((rawType instanceof Class) && cls.isAssignableFrom((Class) rawType)) {
                    Type type2 = parameterizedType.getActualTypeArguments()[i];
                    if (type2 instanceof TypeVariable) {
                        throw new CucumberDataTableException("Generic types must be explicit");
                    }
                    return type2;
                }
            }
            return null;
        }

        static Type mapKeyType(Type type) {
            return typeArg(type, Map.class, 0);
        }

        static Type mapValueType(Type type) {
            return typeArg(type, Map.class, 1);
        }
    }

    static final class NoConverterDefined implements TableConverter {
        NoConverterDefined() {
        }

        @Override // io.cucumber.datatable.DataTable.TableConverter
        public Object convert(DataTable dataTable, Type type) {
            return convert(dataTable, type, false);
        }

        @Override // io.cucumber.datatable.DataTable.TableConverter
        public Object convert(DataTable dataTable, Type type, boolean z) {
            throw new CucumberDataTableException(String.format("Can't convert DataTable to %s. DataTable was created without a converter", type));
        }

        @Override // io.cucumber.datatable.DataTable.TableConverter
        public List toList(DataTable dataTable, Type type) {
            throw new CucumberDataTableException(String.format("Can't convert DataTable to List<%s>. DataTable was created without a converter", type));
        }

        @Override // io.cucumber.datatable.DataTable.TableConverter
        public List toLists(DataTable dataTable, Type type) {
            throw new CucumberDataTableException(String.format("Can't convert DataTable to List<List<%s>>. DataTable was created without a converter", type));
        }

        @Override // io.cucumber.datatable.DataTable.TableConverter
        public Map toMap(DataTable dataTable, Type type, Type type2) {
            throw new CucumberDataTableException(String.format("Can't convert DataTable to Map<%s,%s>. DataTable was created without a converter", type, type2));
        }

        @Override // io.cucumber.datatable.DataTable.TableConverter
        public List toMaps(DataTable dataTable, Type type, Type type2) {
            throw new CucumberDataTableException(String.format("Can't convert DataTable to List<Map<%s,%s>>. DataTable was created without a converter", type, type2));
        }
    }

    private final class RawDataTableView extends AbstractList implements RandomAccess {
        private final int fromColumn;
        private final int fromRow;
        private final int toColumn;
        private final int toRow;

        RawDataTableView(int i, int i2, int i3, int i4) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("fromRow: " + i);
            }
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("fromColumn: " + i2);
            }
            if (i4 > DataTable.this.height()) {
                throw new IndexOutOfBoundsException("toRow: " + i4 + ", Height: " + DataTable.this.height());
            }
            if (i3 > DataTable.this.width()) {
                throw new IndexOutOfBoundsException("toColumn: " + i3 + ", Width: " + DataTable.this.width());
            }
            if (i > i4) {
                throw new IllegalArgumentException("fromRow(" + i + ") > toRow(" + i4 + ")");
            }
            if (i2 > i3) {
                throw new IllegalArgumentException("fromColumn(" + i2 + ") > toColumn(" + i3 + ")");
            }
            this.fromRow = i;
            this.fromColumn = i2;
            this.toColumn = i3;
            this.toRow = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public List get(final int i) {
            DataTable.rangeCheckRow(i, size());
            return new AbstractList() { // from class: io.cucumber.datatable.DataTable.RawDataTableView.1
                @Override // java.util.AbstractList, java.util.List
                public String get(int i2) {
                    DataTable.rangeCheckColumn(i2, size());
                    return (String) ((List) DataTable.this.raw.get(RawDataTableView.this.fromRow + i)).get(RawDataTableView.this.fromColumn + i2);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return RawDataTableView.this.toColumn - RawDataTableView.this.fromColumn;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            if (this.fromColumn == this.toColumn) {
                return 0;
            }
            return this.toRow - this.fromRow;
        }
    }

    private final class ListView extends AbstractList {
        int height;
        int width;

        private ListView() {
            this.width = DataTable.this.width();
            this.height = DataTable.this.height();
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            DataTable.rangeCheck(i, size());
            return (String) ((List) DataTable.this.raw.get(i / this.width)).get(i % this.width);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.height * this.width;
        }
    }

    private final class ColumnView extends AbstractList implements RandomAccess {
        private final int column;

        ColumnView(int i) {
            DataTable.rangeCheckColumn(i, DataTable.this.width());
            this.column = i;
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            DataTable.rangeCheckRow(i, size());
            return (String) ((List) DataTable.this.raw.get(i)).get(this.column);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return DataTable.this.height();
        }
    }

    private final class TransposedRawDataTableView extends AbstractList implements RandomAccess {
        private TransposedRawDataTableView() {
        }

        DataTable dataTable() {
            return DataTable.this;
        }

        @Override // java.util.AbstractList, java.util.List
        public List get(final int i) {
            DataTable.rangeCheckRow(i, size());
            return new AbstractList() { // from class: io.cucumber.datatable.DataTable.TransposedRawDataTableView.1
                @Override // java.util.AbstractList, java.util.List
                public String get(int i2) {
                    DataTable.rangeCheckColumn(i2, size());
                    return (String) ((List) DataTable.this.raw.get(i2)).get(i);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return DataTable.this.height();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return DataTable.this.width();
        }
    }
}
