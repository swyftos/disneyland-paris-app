package io.cucumber.stepexpression;

import gherkin.pickles.PickleStep;
import gherkin.pickles.PickleString;
import gherkin.pickles.PickleTable;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes5.dex */
public class ExpressionArgumentMatcher implements ArgumentMatcher {
    private final StepExpression expression;

    public ExpressionArgumentMatcher(StepExpression stepExpression) {
        this.expression = stepExpression;
    }

    @Override // io.cucumber.stepexpression.ArgumentMatcher
    public List<Argument> argumentsFrom(PickleStep pickleStep, Type... typeArr) {
        if (pickleStep.getArgument().isEmpty()) {
            return this.expression.match(pickleStep.getText(), typeArr);
        }
        gherkin.pickles.Argument argument = pickleStep.getArgument().get(0);
        if (argument instanceof PickleString) {
            return this.expression.match(pickleStep.getText(), ((PickleString) argument).getContent(), typeArr);
        }
        if (argument instanceof PickleTable) {
            return this.expression.match(pickleStep.getText(), PickleTableConverter.toTable((PickleTable) argument), typeArr);
        }
        throw new IllegalStateException("Argument was neither PickleString nor PickleTable");
    }
}
