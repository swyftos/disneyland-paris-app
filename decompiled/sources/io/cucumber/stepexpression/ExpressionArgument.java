package io.cucumber.stepexpression;

import io.cucumber.cucumberexpressions.Group;

/* loaded from: classes5.dex */
public final class ExpressionArgument implements Argument {
    private final io.cucumber.cucumberexpressions.Argument argument;

    ExpressionArgument(io.cucumber.cucumberexpressions.Argument argument) {
        this.argument = argument;
    }

    @Override // io.cucumber.stepexpression.Argument
    public Object getValue() {
        return this.argument.getValue();
    }

    public Group getGroup() {
        return this.argument.getGroup();
    }

    public String toString() {
        if (this.argument.getGroup() == null) {
            return null;
        }
        return this.argument.getGroup().getValue();
    }
}
