package io.cucumber.datatable;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes5.dex */
public final class DataTableTypeRegistry {
    private TableCellByTypeTransformer defaultDataTableCellTransformer;
    private TableEntryByTypeTransformer defaultDataTableEntryTransformer;
    private final DataTableCellByTypeTransformer tableCellByTypeTransformer = new DataTableCellByTypeTransformer(this);
    private final Map tableTypeByType = new HashMap();

    public DataTableTypeRegistry(Locale locale) {
        final NumberParser numberParser = new NumberParser(locale);
        defineDataTableType(new DataTableType(BigInteger.class, new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.1
            @Override // io.cucumber.datatable.TableCellTransformer
            public BigInteger transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return new BigInteger(str);
            }
        }));
        defineDataTableType(new DataTableType(BigDecimal.class, new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.2
            @Override // io.cucumber.datatable.TableCellTransformer
            public BigDecimal transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return numberParser.parseBigDecimal(str);
            }
        }));
        TableCellTransformer tableCellTransformer = new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.3
            @Override // io.cucumber.datatable.TableCellTransformer
            public Byte transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return Byte.decode(str);
            }
        };
        defineDataTableType(new DataTableType(Byte.class, tableCellTransformer));
        defineDataTableType(new DataTableType(Byte.TYPE, tableCellTransformer));
        TableCellTransformer tableCellTransformer2 = new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.4
            @Override // io.cucumber.datatable.TableCellTransformer
            public Short transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return Short.decode(str);
            }
        };
        defineDataTableType(new DataTableType(Short.class, tableCellTransformer2));
        defineDataTableType(new DataTableType(Short.TYPE, tableCellTransformer2));
        TableCellTransformer tableCellTransformer3 = new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.5
            @Override // io.cucumber.datatable.TableCellTransformer
            public Integer transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return Integer.decode(str);
            }
        };
        defineDataTableType(new DataTableType(Integer.class, tableCellTransformer3));
        defineDataTableType(new DataTableType(Integer.TYPE, tableCellTransformer3));
        TableCellTransformer tableCellTransformer4 = new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.6
            @Override // io.cucumber.datatable.TableCellTransformer
            public Long transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return Long.decode(str);
            }
        };
        defineDataTableType(new DataTableType(Long.class, tableCellTransformer4));
        defineDataTableType(new DataTableType(Long.TYPE, tableCellTransformer4));
        TableCellTransformer tableCellTransformer5 = new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.7
            @Override // io.cucumber.datatable.TableCellTransformer
            public Float transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return Float.valueOf(numberParser.parseFloat(str));
            }
        };
        defineDataTableType(new DataTableType(Float.class, tableCellTransformer5));
        defineDataTableType(new DataTableType(Float.TYPE, tableCellTransformer5));
        TableCellTransformer tableCellTransformer6 = new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.8
            @Override // io.cucumber.datatable.TableCellTransformer
            public Double transform(String str) {
                if (str.isEmpty()) {
                    return null;
                }
                return Double.valueOf(numberParser.parseDouble(str));
            }
        };
        defineDataTableType(new DataTableType(Double.class, tableCellTransformer6));
        defineDataTableType(new DataTableType(Double.TYPE, tableCellTransformer6));
        defineDataTableType(new DataTableType(String.class, new TableCellTransformer() { // from class: io.cucumber.datatable.DataTableTypeRegistry.9
            @Override // io.cucumber.datatable.TableCellTransformer
            public String transform(String str) {
                return str;
            }
        }));
    }

    public void defineDataTableType(DataTableType dataTableType) {
        DataTableType dataTableType2 = (DataTableType) this.tableTypeByType.get(dataTableType.getTargetType());
        if (dataTableType2 != null) {
            throw new DuplicateTypeException(String.format("There is already a data table type registered for %s.\nIt registered an %s. You are trying to add a %s", dataTableType.getElementType(), dataTableType.getTransformerType().getSimpleName(), dataTableType2.getTransformerType().getSimpleName()));
        }
        this.tableTypeByType.put(dataTableType.getTargetType(), dataTableType);
    }

    public DataTableType lookupTableTypeByType(Type type) {
        return (DataTableType) this.tableTypeByType.get(TypeFactory.constructType(type));
    }

    DataTableType getDefaultTableCellTransformer(Type type) {
        if (this.defaultDataTableCellTransformer == null) {
            return null;
        }
        return DataTableType.defaultCell(TypeFactory.constructType(type).getRawClass(), this.defaultDataTableCellTransformer);
    }

    DataTableType getDefaultTableEntryTransformer(Type type) {
        if (this.defaultDataTableEntryTransformer == null) {
            return null;
        }
        return DataTableType.defaultEntry(TypeFactory.constructType(type).getRawClass(), this.defaultDataTableEntryTransformer, this.tableCellByTypeTransformer);
    }

    public void setDefaultDataTableEntryTransformer(TableEntryByTypeTransformer tableEntryByTypeTransformer) {
        this.defaultDataTableEntryTransformer = tableEntryByTypeTransformer;
    }

    public void setDefaultDataTableCellTransformer(TableCellByTypeTransformer tableCellByTypeTransformer) {
        this.defaultDataTableCellTransformer = tableCellByTypeTransformer;
    }
}
