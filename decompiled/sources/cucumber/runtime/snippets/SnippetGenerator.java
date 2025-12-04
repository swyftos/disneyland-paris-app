package cucumber.runtime.snippets;

import gherkin.pickles.Argument;
import gherkin.pickles.PickleStep;
import gherkin.pickles.PickleString;
import gherkin.pickles.PickleTable;
import io.cucumber.cucumberexpressions.CucumberExpressionGenerator;
import io.cucumber.cucumberexpressions.GeneratedExpression;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.ParameterTypeRegistry;
import io.cucumber.datatable.DataTable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class SnippetGenerator {
    private static final ArgumentPattern[] DEFAULT_ARGUMENT_PATTERNS = {new ArgumentPattern(Pattern.compile("\\{.*?\\}"))};
    private final CucumberExpressionGenerator generator;
    private final Snippet snippet;

    public SnippetGenerator(Snippet snippet, ParameterTypeRegistry parameterTypeRegistry) {
        this.snippet = snippet;
        this.generator = new CucumberExpressionGenerator(parameterTypeRegistry);
    }

    public List<String> getSnippet(PickleStep pickleStep, String str, FunctionNameGenerator functionNameGenerator) {
        List<GeneratedExpression> listGenerateExpressions = this.generator.generateExpressions(pickleStep.getText());
        ArrayList arrayList = new ArrayList(listGenerateExpressions.size());
        for (GeneratedExpression generatedExpression : listGenerateExpressions) {
            arrayList.add(MessageFormat.format(this.snippet.template(), str, this.snippet.escapePattern(generatedExpression.getSource()), functionName(generatedExpression.getSource(), functionNameGenerator), this.snippet.arguments(arguments(pickleStep, generatedExpression.getParameterNames(), generatedExpression.getParameterTypes())), "Write code here that turns the phrase above into concrete actions", (pickleStep.getArgument().isEmpty() || !(pickleStep.getArgument().get(0) instanceof PickleTable)) ? "" : this.snippet.tableHint()));
        }
        return arrayList;
    }

    private String functionName(String str, FunctionNameGenerator functionNameGenerator) {
        if (functionNameGenerator == null) {
            return null;
        }
        for (ArgumentPattern argumentPattern : argumentPatterns()) {
            str = argumentPattern.replaceMatchesWithSpace(str);
        }
        return functionNameGenerator.generateFunctionName(str);
    }

    private Map arguments(PickleStep pickleStep, List list, List list2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(list2.size() + 1);
        for (int i = 0; i < list2.size(); i++) {
            linkedHashMap.put((String) list.get(i), ((ParameterType) list2.get(i)).getType());
        }
        if (pickleStep.getArgument().isEmpty()) {
            return linkedHashMap;
        }
        Argument argument = pickleStep.getArgument().get(0);
        if (argument instanceof PickleString) {
            linkedHashMap.put(parameterName("docString", list), String.class);
        }
        if (argument instanceof PickleTable) {
            linkedHashMap.put(parameterName("dataTable", list), DataTable.class);
        }
        return linkedHashMap;
    }

    private String parameterName(String str, List list) {
        if (!list.contains(str)) {
            return str;
        }
        int i = 1;
        while (true) {
            if (!list.contains(str + i)) {
                return str + i;
            }
            i++;
        }
    }

    ArgumentPattern[] argumentPatterns() {
        return DEFAULT_ARGUMENT_PATTERNS;
    }
}
