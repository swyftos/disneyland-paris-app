package io.cucumber.cucumberexpressions;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class RegularExpression implements Expression {
    private final Pattern expressionRegexp;
    private final ParameterTypeRegistry parameterTypeRegistry;
    private final TreeRegexp treeRegexp;

    public RegularExpression(Pattern pattern, ParameterTypeRegistry parameterTypeRegistry) {
        this.expressionRegexp = pattern;
        this.parameterTypeRegistry = parameterTypeRegistry;
        this.treeRegexp = new TreeRegexp(pattern);
    }

    @Override // io.cucumber.cucumberexpressions.Expression
    public List<Argument<?>> match(String str, Type... typeArr) {
        int i;
        Type type;
        ParameterByTypeTransformer defaultParameterTransformer = this.parameterTypeRegistry.getDefaultParameterTransformer();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.treeRegexp.getGroupBuilder().getChildren().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String source = ((GroupBuilder) it.next()).getSource();
            if (i2 < typeArr.length) {
                i = i2 + 1;
                type = typeArr[i2];
            } else {
                i = i2;
                type = String.class;
            }
            ParameterType parameterTypeLookupByRegexp = this.parameterTypeRegistry.lookupByRegexp(source, this.expressionRegexp, str);
            if (parameterTypeLookupByRegexp == null) {
                parameterTypeLookupByRegexp = ParameterType.createAnonymousParameterType(source);
            }
            if (parameterTypeLookupByRegexp.isAnonymous()) {
                parameterTypeLookupByRegexp = parameterTypeLookupByRegexp.deAnonymize(type, new ObjectMapperTransformer(defaultParameterTransformer, type));
            }
            arrayList.add(parameterTypeLookupByRegexp);
            i2 = i;
        }
        return Argument.build(this.treeRegexp, arrayList, str);
    }

    @Override // io.cucumber.cucumberexpressions.Expression
    public Pattern getRegexp() {
        return this.expressionRegexp;
    }

    @Override // io.cucumber.cucumberexpressions.Expression
    public String getSource() {
        return this.expressionRegexp.pattern();
    }
}
