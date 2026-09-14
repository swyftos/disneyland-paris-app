package io.cucumber.datatable;

/* JADX INFO: loaded from: classes5.dex */
public class TableDiffException extends RuntimeException {
    private TableDiffException(String str) {
        super(str);
    }

    public static TableDiffException diff(DataTableDiff dataTableDiff) {
        return new TableDiffException("tables were different:\n" + dataTableDiff.toString());
    }
}
