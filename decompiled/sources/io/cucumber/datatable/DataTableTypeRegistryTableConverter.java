package io.cucumber.datatable;

import io.cucumber.datatable.DataTable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class DataTableTypeRegistryTableConverter extends DataTable.AbstractTableConverter {
    private final DataTableTypeRegistry registry;

    public DataTableTypeRegistryTableConverter(DataTableTypeRegistry dataTableTypeRegistry) {
        this.registry = dataTableTypeRegistry;
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public <T> T convert(DataTable dataTable, Type type) {
        return (T) convert(dataTable, type, false);
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public <T> T convert(DataTable dataTable, Type type, boolean z) {
        Object obj = dataTable;
        if (dataTable == null) {
            throw new NullPointerException("dataTable may not be null");
        }
        if (type == null) {
            throw new NullPointerException("type may not be null");
        }
        if (z) {
            obj = (T) dataTable.transpose();
        }
        DataTableType dataTableTypeLookupTableTypeByType = this.registry.lookupTableTypeByType(type);
        if (dataTableTypeLookupTableTypeByType != null) {
            return (T) dataTableTypeLookupTableTypeByType.transform(((DataTable) obj).cells());
        }
        if (type.equals(DataTable.class)) {
            return (T) obj;
        }
        Type typeMapKeyType = DataTable.AbstractTableConverter.mapKeyType(type);
        if (typeMapKeyType != null) {
            return (T) toMap((DataTable) obj, typeMapKeyType, DataTable.AbstractTableConverter.mapValueType(type));
        }
        if (Map.class.equals(type)) {
            return (T) toMap((DataTable) obj, String.class, String.class);
        }
        Type typeListItemType = DataTable.AbstractTableConverter.listItemType(type);
        if (typeListItemType == null) {
            if (List.class.equals(type)) {
                return (T) toList((DataTable) obj, String.class);
            }
            return (T) toSingleton((DataTable) obj, type);
        }
        Type typeMapKeyType2 = DataTable.AbstractTableConverter.mapKeyType(typeListItemType);
        if (typeMapKeyType2 != null) {
            return (T) toMaps((DataTable) obj, typeMapKeyType2, DataTable.AbstractTableConverter.mapValueType(typeListItemType));
        }
        if (Map.class.equals(typeListItemType)) {
            return (T) toMaps((DataTable) obj, String.class, String.class);
        }
        Type typeListItemType2 = DataTable.AbstractTableConverter.listItemType(typeListItemType);
        if (typeListItemType2 != null) {
            return (T) toLists((DataTable) obj, typeListItemType2);
        }
        if (List.class.equals(typeListItemType)) {
            return (T) toLists((DataTable) obj, String.class);
        }
        return (T) toList((DataTable) obj, typeListItemType);
    }

    private Object toSingleton(DataTable dataTable, Type type) {
        if (dataTable.isEmpty()) {
            return null;
        }
        List listOrNull = toListOrNull(dataTable, type);
        if (listOrNull == null) {
            throw UndefinedDataTableTypeException.singletonNoConverterDefined(type);
        }
        if (listOrNull.size() == 1) {
            return listOrNull.get(0);
        }
        throw CucumberDataTableException.cantConvertTo(type, "The table contained more then one item: " + listOrNull);
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public <T> List<T> toList(DataTable dataTable, Type type) {
        if (dataTable == null) {
            throw new NullPointerException("dataTable may not be null");
        }
        if (type == null) {
            throw new NullPointerException("itemType may not be null");
        }
        if (dataTable.isEmpty()) {
            return Collections.emptyList();
        }
        List listOrNull = toListOrNull(dataTable, type);
        if (listOrNull != null) {
            return Collections.unmodifiableList(listOrNull);
        }
        if (dataTable.width() > 1) {
            throw UndefinedDataTableTypeException.listNoConverterDefined(type, "TableEntryTransformer or TableRowTransformer", type);
        }
        throw UndefinedDataTableTypeException.listNoConverterDefined(type, "TableEntryTransformer, TableRowTransformer or TableCellTransformer", type);
    }

    private List toListOrNull(DataTable dataTable, Type type) {
        return toListOrNull(dataTable.cells(), type);
    }

    private List toListOrNull(List list, Type type) {
        DataTableType defaultTableEntryTransformer;
        DataTableType dataTableTypeLookupTableTypeByType = this.registry.lookupTableTypeByType(TypeFactory.aListOf(type));
        if (dataTableTypeLookupTableTypeByType != null) {
            return (List) dataTableTypeLookupTableTypeByType.transform(list);
        }
        DataTableType dataTableTypeLookupTableTypeByType2 = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(type)));
        if (dataTableTypeLookupTableTypeByType2 != null) {
            return unpack((List) dataTableTypeLookupTableTypeByType2.transform(list));
        }
        if (list.size() > 1 && (defaultTableEntryTransformer = this.registry.getDefaultTableEntryTransformer(type)) != null) {
            return (List) defaultTableEntryTransformer.transform(list);
        }
        DataTableType defaultTableCellTransformer = this.registry.getDefaultTableCellTransformer(type);
        if (defaultTableCellTransformer != null) {
            return unpack((List) defaultTableCellTransformer.transform(list));
        }
        return null;
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public <T> List<List<T>> toLists(DataTable dataTable, Type type) {
        if (dataTable == null) {
            throw new NullPointerException("dataTable may not be null");
        }
        if (type == null) {
            throw new NullPointerException("itemType may not be null");
        }
        if (dataTable.isEmpty()) {
            return Collections.emptyList();
        }
        DataTableType dataTableTypeLookupTableTypeByType = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(type)));
        if (dataTableTypeLookupTableTypeByType == null) {
            dataTableTypeLookupTableTypeByType = this.registry.getDefaultTableCellTransformer(type);
        }
        if (dataTableTypeLookupTableTypeByType != null) {
            return Collections.unmodifiableList((List) dataTableTypeLookupTableTypeByType.transform(dataTable.cells()));
        }
        throw UndefinedDataTableTypeException.listsNoConverterDefined(type);
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public <K, V> Map<K, V> toMap(DataTable dataTable, Type type, Type type2) {
        if (dataTable == null) {
            throw new NullPointerException("dataTable may not be null");
        }
        if (type == null) {
            throw new NullPointerException("keyType may not be null");
        }
        if (type2 == null) {
            throw new NullPointerException("valueType may not be null");
        }
        if (dataTable.isEmpty()) {
            return Collections.emptyMap();
        }
        DataTable dataTableColumns = dataTable.columns(0, 1);
        DataTable dataTableColumns2 = dataTable.columns(1);
        String strCell = dataTableColumns.cell(0, 0);
        boolean z = strCell == null || strCell.isEmpty();
        List listConvertEntryKeys = convertEntryKeys(type, dataTableColumns.cells(), type2, z);
        if (dataTableColumns2.isEmpty()) {
            return createMap(type, listConvertEntryKeys, type2, Collections.nCopies(listConvertEntryKeys.size(), null));
        }
        List listConvertEntryValues = convertEntryValues(dataTableColumns2, type, type2, listConvertEntryKeys.size() == dataTable.height() - 1);
        if (listConvertEntryKeys.size() != listConvertEntryValues.size()) {
            throw CucumberDataTableException.keyValueMismatchException(z, listConvertEntryKeys.size(), type, listConvertEntryValues.size(), type2);
        }
        return createMap(type, listConvertEntryKeys, type2, listConvertEntryValues);
    }

    private static Map createMap(Type type, List list, Type type2, List list2) {
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            Object next2 = it2.next();
            Object objPut = linkedHashMap.put(next, next2);
            if (objPut != null) {
                throw CucumberDataTableException.duplicateKeyException(type, type2, next, next2, objPut);
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private List convertEntryKeys(Type type, List list, Type type2, boolean z) {
        if (z) {
            DataTableType dataTableTypeLookupTableTypeByType = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(type)));
            if (dataTableTypeLookupTableTypeByType == null) {
                dataTableTypeLookupTableTypeByType = this.registry.getDefaultTableCellTransformer(type);
            }
            if (dataTableTypeLookupTableTypeByType == null) {
                throw UndefinedDataTableTypeException.mapNoConverterDefined(type, type2, "TableCellTransformer", type);
            }
            return unpack((List) dataTableTypeLookupTableTypeByType.transform(list.subList(1, list.size())));
        }
        List listOrNull = toListOrNull(list, type);
        if (listOrNull != null) {
            return listOrNull;
        }
        throw UndefinedDataTableTypeException.mapNoConverterDefined(type, type2, "TableEntryTransformer or TableCellTransformer", type);
    }

    private List convertEntryValues(DataTable dataTable, Type type, Type type2, boolean z) {
        Type typeListItemType = DataTable.AbstractTableConverter.listItemType(type2);
        if (typeListItemType != null) {
            DataTableType dataTableTypeLookupTableTypeByType = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(typeListItemType)));
            if (dataTableTypeLookupTableTypeByType == null) {
                dataTableTypeLookupTableTypeByType = this.registry.getDefaultTableCellTransformer(typeListItemType);
            }
            if (dataTableTypeLookupTableTypeByType == null) {
                throw UndefinedDataTableTypeException.mapNoConverterDefined(type, type2, "TableCellTransformer", type2);
            }
            return (List) dataTableTypeLookupTableTypeByType.transform(dataTable.cells());
        }
        Type typeMapKeyType = DataTable.AbstractTableConverter.mapKeyType(type2);
        if (typeMapKeyType != null) {
            return toMaps(dataTable, typeMapKeyType, DataTable.AbstractTableConverter.mapValueType(type2));
        }
        if (Map.class.equals(type2)) {
            return toMaps(dataTable, String.class, String.class);
        }
        DataTableType dataTableTypeLookupTableTypeByType2 = this.registry.lookupTableTypeByType(TypeFactory.aListOf(type2));
        if (dataTableTypeLookupTableTypeByType2 != null) {
            return (List) dataTableTypeLookupTableTypeByType2.transform(dataTable.cells());
        }
        if (z) {
            DataTableType defaultTableEntryTransformer = this.registry.getDefaultTableEntryTransformer(type2);
            if (defaultTableEntryTransformer != null) {
                return (List) defaultTableEntryTransformer.transform(dataTable.cells());
            }
            throw CucumberDataTableException.keysImplyTableEntryTransformer(type, type2);
        }
        DataTableType dataTableTypeLookupTableTypeByType3 = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(type2)));
        if (dataTableTypeLookupTableTypeByType3 != null) {
            return unpack((List) dataTableTypeLookupTableTypeByType3.transform(dataTable.cells()));
        }
        DataTableType defaultTableCellTransformer = this.registry.getDefaultTableCellTransformer(type2);
        if (defaultTableCellTransformer != null) {
            return unpack((List) defaultTableCellTransformer.transform(dataTable.cells()));
        }
        throw UndefinedDataTableTypeException.mapNoConverterDefined(type, type2, "TableEntryTransformer or TableCellTransformer", type2);
    }

    @Override // io.cucumber.datatable.DataTable.TableConverter
    public <K, V> List<Map<K, V>> toMaps(DataTable dataTable, Type type, Type type2) {
        if (dataTable == null) {
            throw new NullPointerException("dataTable may not be null");
        }
        if (type == null) {
            throw new NullPointerException("keyType may not be null");
        }
        if (type2 == null) {
            throw new NullPointerException("valueType may not be null");
        }
        if (dataTable.isEmpty()) {
            return Collections.emptyList();
        }
        DataTableType dataTableTypeLookupTableTypeByType = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(type)));
        DataTableType dataTableTypeLookupTableTypeByType2 = this.registry.lookupTableTypeByType(TypeFactory.aListOf(TypeFactory.aListOf(type2)));
        if (dataTableTypeLookupTableTypeByType == null) {
            throw UndefinedDataTableTypeException.mapsNoConverterDefined(type, type2, type);
        }
        if (dataTableTypeLookupTableTypeByType2 == null) {
            throw UndefinedDataTableTypeException.mapsNoConverterDefined(type, type2, type2);
        }
        DataTable dataTableRows = dataTable.rows(0, 1);
        ArrayList arrayList = new ArrayList();
        List listUnpack = unpack((List) dataTableTypeLookupTableTypeByType.transform(dataTableRows.cells()));
        DataTable dataTableRows2 = dataTable.rows(1);
        if (dataTableRows2.isEmpty()) {
            return Collections.emptyList();
        }
        Iterator it = ((List) dataTableTypeLookupTableTypeByType2.transform(dataTableRows2.cells())).iterator();
        while (it.hasNext()) {
            arrayList.add(createMap(type, listUnpack, type2, (List) it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static List unpack(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) it.next());
        }
        return arrayList;
    }
}
