package io.cucumber.cucumberexpressions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class CucumberExpressionGenerator {
    private final ParameterTypeRegistry parameterTypeRegistry;

    public CucumberExpressionGenerator(ParameterTypeRegistry parameterTypeRegistry) {
        this.parameterTypeRegistry = parameterTypeRegistry;
    }

    public List<GeneratedExpression> generateExpressions(String str) {
        ArrayList arrayList = new ArrayList();
        List<ParameterTypeMatcher> listCreateParameterTypeMatchers = createParameterTypeMatchers(str);
        StringBuilder sb = new StringBuilder();
        int iStart = 0;
        do {
            ArrayList<ParameterTypeMatcher> arrayList2 = new ArrayList();
            for (ParameterTypeMatcher parameterTypeMatcher : listCreateParameterTypeMatchers) {
                if (parameterTypeMatcher.advanceToAndFind(iStart)) {
                    arrayList2.add(parameterTypeMatcher);
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            Collections.sort(arrayList2);
            ParameterTypeMatcher parameterTypeMatcher2 = (ParameterTypeMatcher) arrayList2.get(0);
            ArrayList arrayList3 = new ArrayList();
            for (ParameterTypeMatcher parameterTypeMatcher3 : arrayList2) {
                if (parameterTypeMatcher3.compareTo(parameterTypeMatcher2) == 0) {
                    arrayList3.add(parameterTypeMatcher3);
                }
            }
            TreeSet treeSet = new TreeSet();
            HashSet hashSet = new HashSet();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                hashSet.add(((ParameterTypeMatcher) it.next()).getParameterType());
            }
            treeSet.addAll(hashSet);
            arrayList.add(new ArrayList(treeSet));
            sb.append(escape(str.substring(iStart, parameterTypeMatcher2.start())));
            sb.append("{%s}");
            iStart = parameterTypeMatcher2.start() + parameterTypeMatcher2.group().length();
        } while (iStart < str.length());
        sb.append(escape(str.substring(iStart)));
        return new CombinatorialGeneratedExpressionFactory(sb.toString(), arrayList).generateExpressions();
    }

    private String escape(String str) {
        return str.replaceAll("%", "%%").replaceAll("\\(", "\\\\(").replaceAll("\\{", "\\\\{").replaceAll("/", "\\\\/");
    }

    @Deprecated
    public GeneratedExpression generateExpression(String str) {
        return generateExpressions(str).get(0);
    }

    private List createParameterTypeMatchers(String str) {
        Collection<ParameterType<?>> parameterTypes = this.parameterTypeRegistry.getParameterTypes();
        ArrayList arrayList = new ArrayList();
        for (ParameterType<?> parameterType : parameterTypes) {
            if (parameterType.useForSnippets()) {
                arrayList.addAll(createParameterTypeMatchers(parameterType, str));
            }
        }
        return arrayList;
    }

    private static List createParameterTypeMatchers(ParameterType parameterType, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = parameterType.getRegexps().iterator();
        while (it.hasNext()) {
            arrayList.add(new ParameterTypeMatcher(parameterType, Pattern.compile("(" + it.next() + ")").matcher(str), str.length()));
        }
        return arrayList;
    }
}
