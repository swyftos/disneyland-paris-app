package cucumber.runtime;

import cucumber.api.Argument;
import io.cucumber.cucumberexpressions.Group;
import io.cucumber.stepexpression.ExpressionArgument;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class DefinitionArgument implements Argument {
    private final Group group;

    private DefinitionArgument(ExpressionArgument expressionArgument) {
        this.group = expressionArgument.getGroup();
    }

    public static List<Argument> createArguments(List<io.cucumber.stepexpression.Argument> list) {
        ArrayList arrayList = new ArrayList();
        for (io.cucumber.stepexpression.Argument argument : list) {
            if (argument instanceof ExpressionArgument) {
                arrayList.add(new DefinitionArgument((ExpressionArgument) argument));
            }
        }
        return arrayList;
    }

    @Override // cucumber.api.Argument
    public String getValue() {
        Group group = this.group;
        if (group == null) {
            return null;
        }
        return group.getValue();
    }

    @Override // cucumber.api.Argument
    public int getStart() {
        Group group = this.group;
        if (group == null) {
            return -1;
        }
        return group.getStart();
    }

    @Override // cucumber.api.Argument
    public int getEnd() {
        Group group = this.group;
        if (group == null) {
            return -1;
        }
        return group.getEnd();
    }
}
