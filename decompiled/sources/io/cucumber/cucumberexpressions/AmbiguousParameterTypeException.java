package io.cucumber.cucumberexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class AmbiguousParameterTypeException extends CucumberExpressionException {
    private final List generatedExpressions;
    private final String parameterTypeRegexp;
    private final SortedSet parameterTypes;
    private final Pattern regexp;

    public AmbiguousParameterTypeException(String str, Pattern pattern, SortedSet<ParameterType<?>> sortedSet, List<GeneratedExpression> list) {
        super(String.format("Your Regular Expression /%s/\nmatches multiple parameter types with regexp /%s/:\n   %s\n\nI couldn't decide which one to use. You have two options:\n\n1) Use a Cucumber Expression instead of a Regular Expression. Try one of these:\n   %s\n\n2) Make one of the parameter types preferential and continue to use a Regular Expression.\n\n", pattern.pattern(), str, parameterTypeNames(sortedSet), expressions(list)));
        this.regexp = pattern;
        this.parameterTypeRegexp = str;
        this.parameterTypes = sortedSet;
        this.generatedExpressions = list;
    }

    private static String parameterTypeNames(SortedSet sortedSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedSet.iterator();
        while (it.hasNext()) {
            arrayList.add("{" + ((ParameterType) it.next()).getName() + "}");
        }
        return join(arrayList);
    }

    private static String expressions(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((GeneratedExpression) it.next()).getSource());
        }
        return join(arrayList);
    }

    private static String join(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                z = false;
            } else {
                sb.append("\n   ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public Pattern getRegexp() {
        return this.regexp;
    }

    public String getParameterTypeRegexp() {
        return this.parameterTypeRegexp;
    }

    public SortedSet<ParameterType<?>> getParameterTypes() {
        return this.parameterTypes;
    }

    public List<GeneratedExpression> getGeneratedExpressions() {
        return this.generatedExpressions;
    }
}
