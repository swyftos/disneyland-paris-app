package io.cucumber.stepexpression;

import io.cucumber.datatable.DataTable;
import java.util.List;

/* loaded from: classes5.dex */
public final class DataTableArgument implements Argument {
    private final List argument;
    private final RawTableTransformer tableType;

    DataTableArgument(RawTableTransformer rawTableTransformer, List list) {
        this.tableType = rawTableTransformer;
        this.argument = list;
    }

    @Override // io.cucumber.stepexpression.Argument
    public Object getValue() {
        return this.tableType.transform(this.argument);
    }

    public String getText() {
        return DataTable.create(this.argument).toString();
    }

    public String toString() {
        return "Table:\n" + getText();
    }
}
