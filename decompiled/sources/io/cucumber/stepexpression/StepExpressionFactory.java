package io.cucumber.stepexpression;

import cucumber.runtime.CucumberException;
import io.cucumber.cucumberexpressions.ExpressionFactory;
import io.cucumber.cucumberexpressions.UndefinedParameterTypeException;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class StepExpressionFactory {
    private static final DocStringTransformer DOC_STRING_IDENTITY = new DocStringTransformer() { // from class: io.cucumber.stepexpression.StepExpressionFactory.1
        @Override // io.cucumber.stepexpression.DocStringTransformer
        public String transform(String str) {
            return str;
        }
    };
    private final ExpressionFactory expressionFactory;
    private final DataTableTypeRegistryTableConverter tableConverter;

    public StepExpressionFactory(TypeRegistry typeRegistry) {
        this.expressionFactory = new ExpressionFactory(typeRegistry.parameterTypeRegistry());
        this.tableConverter = new DataTableTypeRegistryTableConverter(typeRegistry.dataTableTypeRegistry());
    }

    public StepExpression createExpression(String str) {
        if (str == null) {
            throw new NullPointerException("expression can not be null");
        }
        return new StepExpression(this.expressionFactory.createExpression(str), DOC_STRING_IDENTITY, new RawTableTransformer() { // from class: io.cucumber.stepexpression.StepExpressionFactory.2
            @Override // io.cucumber.stepexpression.RawTableTransformer
            public DataTable transform(List list) {
                return DataTable.create(list, StepExpressionFactory.this.tableConverter);
            }
        });
    }

    public StepExpression createExpression(String str, Type type) {
        return createExpression(str, (TypeResolver) new ResolvedType(type), false);
    }

    public StepExpression createExpression(String str, TypeResolver typeResolver) {
        return createExpression(str, typeResolver, false);
    }

    public StepExpression createExpression(String str, Type type, boolean z) {
        return createExpression(str, new ResolvedType(type), z);
    }

    public StepExpression createExpression(String str, final TypeResolver typeResolver, final boolean z) {
        if (str == null) {
            throw new NullPointerException("expressionString can not be null");
        }
        if (typeResolver == null) {
            throw new NullPointerException("tableOrDocStringType can not be null");
        }
        try {
            return new StepExpression(this.expressionFactory.createExpression(str), new DocStringTransformer() { // from class: io.cucumber.stepexpression.StepExpressionFactory.4
                @Override // io.cucumber.stepexpression.DocStringTransformer
                public Object transform(String str2) {
                    Type typeResolve = typeResolver.resolve();
                    return Object.class.equals(typeResolve) ? str2 : DataTable.create(Collections.singletonList(Collections.singletonList(str2)), StepExpressionFactory.this.tableConverter).convert(typeResolve, z);
                }
            }, new RawTableTransformer() { // from class: io.cucumber.stepexpression.StepExpressionFactory.3
                @Override // io.cucumber.stepexpression.RawTableTransformer
                public Object transform(List list) {
                    DataTable dataTableCreate = DataTable.create(list, StepExpressionFactory.this.tableConverter);
                    Type typeResolve = typeResolver.resolve();
                    if (Object.class.equals(typeResolve)) {
                        typeResolve = DataTable.class;
                    }
                    return dataTableCreate.convert(typeResolve, z);
                }
            });
        } catch (UndefinedParameterTypeException e) {
            throw registerTypeInConfiguration(str, e);
        }
    }

    private CucumberException registerTypeInConfiguration(String str, UndefinedParameterTypeException undefinedParameterTypeException) {
        return new CucumberException(String.format("Could not create a cucumber expression for '%s'.\nIt appears you did not register parameter type. The details are in the stacktrace below.\nYou can find the documentation here: https://docs.cucumber.io/cucumber/cucumber-expressions/", str), undefinedParameterTypeException);
    }

    private static final class ResolvedType implements TypeResolver {
        private final Type type;

        private ResolvedType(Type type) {
            this.type = type;
        }

        @Override // io.cucumber.stepexpression.TypeResolver
        public Type resolve() {
            return this.type;
        }
    }
}
