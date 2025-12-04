package cucumber.runtime.java;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.MethodFormat;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.Utils;
import gherkin.pickles.PickleStep;
import io.cucumber.stepexpression.ArgumentMatcher;
import io.cucumber.stepexpression.ExpressionArgumentMatcher;
import io.cucumber.stepexpression.StepExpression;
import io.cucumber.stepexpression.StepExpressionFactory;
import io.cucumber.stepexpression.TypeRegistry;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes5.dex */
class JavaStepDefinition implements StepDefinition {
    private final ArgumentMatcher argumentMatcher;
    private final StepExpression expression;
    private final String fullFormat;
    private final Method method;
    private final ObjectFactory objectFactory;
    private final Type[] parameterTypes;
    private final String shortFormat;
    private final long timeoutMillis;

    @Override // cucumber.runtime.StepDefinition
    public boolean isScenarioScoped() {
        return false;
    }

    JavaStepDefinition(Method method, String str, long j, ObjectFactory objectFactory, TypeRegistry typeRegistry) {
        this.method = method;
        this.timeoutMillis = j;
        this.objectFactory = objectFactory;
        List listFromMethod = ParameterInfo.fromMethod(method);
        this.parameterTypes = getTypes(listFromMethod);
        StepExpression stepExpressionCreateExpression = createExpression(listFromMethod, str, typeRegistry);
        this.expression = stepExpressionCreateExpression;
        this.argumentMatcher = new ExpressionArgumentMatcher(stepExpressionCreateExpression);
        this.shortFormat = MethodFormat.SHORT.format(method);
        this.fullFormat = MethodFormat.FULL.format(method);
    }

    private StepExpression createExpression(List list, String str, TypeRegistry typeRegistry) {
        if (list.isEmpty()) {
            return new StepExpressionFactory(typeRegistry).createExpression(str);
        }
        ParameterInfo parameterInfo = (ParameterInfo) list.get(list.size() - 1);
        return new StepExpressionFactory(typeRegistry).createExpression(str, parameterInfo.getType(), parameterInfo.isTransposed());
    }

    @Override // cucumber.runtime.StepDefinition
    public void execute(Object[] objArr) throws Throwable {
        Utils.invoke(this.objectFactory.getInstance(this.method.getDeclaringClass()), this.method, this.timeoutMillis, objArr);
    }

    @Override // cucumber.runtime.StepDefinition
    public List matchedArguments(PickleStep pickleStep) {
        return this.argumentMatcher.argumentsFrom(pickleStep, this.parameterTypes);
    }

    private static Type[] getTypes(List list) {
        int size = list.size();
        Type[] typeArr = new Type[size];
        for (int i = 0; i < size; i++) {
            typeArr[i] = ((ParameterInfo) list.get(i)).getType();
        }
        return typeArr;
    }

    @Override // cucumber.runtime.StepDefinition
    public String getLocation(boolean z) {
        return z ? this.fullFormat : this.shortFormat;
    }

    @Override // cucumber.runtime.StepDefinition
    public Integer getParameterCount() {
        return Integer.valueOf(this.parameterTypes.length);
    }

    @Override // cucumber.runtime.StepDefinition
    public boolean isDefinedAt(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName().equals(this.method.getDeclaringClass().getName()) && stackTraceElement.getMethodName().equals(this.method.getName());
    }

    @Override // cucumber.runtime.StepDefinition
    public String getPattern() {
        return this.expression.getSource();
    }
}
