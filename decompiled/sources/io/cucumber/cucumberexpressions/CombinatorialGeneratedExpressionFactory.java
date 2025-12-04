package io.cucumber.cucumberexpressions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* loaded from: classes5.dex */
class CombinatorialGeneratedExpressionFactory {
    private final String expressionTemplate;
    private final List parameterTypeCombinations;

    CombinatorialGeneratedExpressionFactory(String str, List list) {
        this.expressionTemplate = str;
        this.parameterTypeCombinations = list;
    }

    List generateExpressions() {
        ArrayList arrayList = new ArrayList();
        generatePermutations(arrayList, new ArrayDeque(this.parameterTypeCombinations.size()));
        return arrayList;
    }

    private void generatePermutations(List list, Deque deque) {
        if (list.size() >= 256) {
            return;
        }
        if (deque.size() == this.parameterTypeCombinations.size()) {
            list.add(new GeneratedExpression(this.expressionTemplate, new ArrayList(deque)));
            return;
        }
        for (ParameterType parameterType : (List) this.parameterTypeCombinations.get(deque.size())) {
            if (list.size() >= 256) {
                return;
            }
            deque.addLast(parameterType);
            generatePermutations(list, deque);
            deque.removeLast();
        }
    }
}
