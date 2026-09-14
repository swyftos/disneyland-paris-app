package io.cucumber.cucumberexpressions;

/* JADX INFO: loaded from: classes5.dex */
public class UndefinedParameterTypeException extends CucumberExpressionException {
    UndefinedParameterTypeException(String str) {
        super(String.format("Undefined parameter type {%s}. Please register a ParameterType for {%s}.", str, str));
    }
}
