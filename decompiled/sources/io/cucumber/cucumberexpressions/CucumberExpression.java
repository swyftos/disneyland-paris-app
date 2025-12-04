package io.cucumber.cucumberexpressions;

import gherkin.GherkinLanguageConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class CucumberExpression implements Expression {
    private final ParameterTypeRegistry parameterTypeRegistry;
    private final List parameterTypes = new ArrayList();
    private final String source;
    private final TreeRegexp treeRegexp;
    private static final Pattern ESCAPE_PATTERN = Pattern.compile("([\\\\^\\[$.|?*+\\]])");
    static final Pattern PARAMETER_PATTERN = Pattern.compile("(\\\\\\\\)?\\{([^}]*)\\}");
    private static final Pattern OPTIONAL_PATTERN = Pattern.compile("(\\\\\\\\)?\\(([^)]+)\\)");
    private static final Pattern ALTERNATIVE_NON_WHITESPACE_TEXT_REGEXP = Pattern.compile("([^\\s^/]+)((/[^\\s^/]+)+)");

    public CucumberExpression(String str, ParameterTypeRegistry parameterTypeRegistry) {
        this.source = str;
        this.parameterTypeRegistry = parameterTypeRegistry;
        this.treeRegexp = new TreeRegexp("^" + processParameters(processAlternation(processOptional(processEscapes(str))), parameterTypeRegistry) + "$");
    }

    private String processEscapes(String str) {
        return ESCAPE_PATTERN.matcher(str).replaceAll("\\\\$1");
    }

    private String processAlternation(String str) {
        Matcher matcher = ALTERNATIVE_NON_WHITESPACE_TEXT_REGEXP.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strReplaceAll = matcher.group(0).replace('/', '|').replaceAll("\\\\\\|", "/");
            if (strReplaceAll.contains(GherkinLanguageConstants.TABLE_CELL_SEPARATOR)) {
                for (String str2 : strReplaceAll.split("\\|")) {
                    checkNotParameterType(str2, "Parameter types cannot be alternative: ");
                }
                matcher.appendReplacement(stringBuffer, "(?:" + strReplaceAll + ")");
            } else {
                matcher.appendReplacement(stringBuffer, strReplaceAll);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private void checkNotParameterType(String str, String str2) {
        if (PARAMETER_PATTERN.matcher(str).find()) {
            throw new CucumberExpressionException(str2 + this.source);
        }
    }

    private String processOptional(String str) {
        Matcher matcher = OPTIONAL_PATTERN.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(2);
            if ("\\\\".equals(matcher.group(1))) {
                matcher.appendReplacement(stringBuffer, "\\\\(" + strGroup + "\\\\)");
            } else {
                checkNotParameterType(strGroup, "Parameter types cannot be optional: ");
                matcher.appendReplacement(stringBuffer, "(?:" + strGroup + ")?");
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private String processParameters(String str, ParameterTypeRegistry parameterTypeRegistry) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = PARAMETER_PATTERN.matcher(str);
        while (matcher.find()) {
            if ("\\\\".equals(matcher.group(1))) {
                matcher.appendReplacement(stringBuffer, "\\\\{" + matcher.group(2) + "\\\\}");
            } else {
                String strGroup = matcher.group(2);
                ParameterType.checkParameterTypeName(strGroup);
                ParameterType parameterTypeLookupByTypeName = parameterTypeRegistry.lookupByTypeName(strGroup);
                if (parameterTypeLookupByTypeName == null) {
                    throw new UndefinedParameterTypeException(strGroup);
                }
                this.parameterTypes.add(parameterTypeLookupByTypeName);
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(buildCaptureRegexp(parameterTypeLookupByTypeName.getRegexps())));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private String buildCaptureRegexp(List list) {
        StringBuilder sb = new StringBuilder("(");
        boolean z = false;
        if (list.size() == 1) {
            sb.append((String) list.get(0));
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (z) {
                    sb.append(GherkinLanguageConstants.TABLE_CELL_SEPARATOR);
                }
                sb.append("(?:");
                sb.append(str);
                sb.append(")");
                z = true;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // io.cucumber.cucumberexpressions.Expression
    public List<Argument<?>> match(String str, Type... typeArr) {
        ArrayList arrayList = new ArrayList(this.parameterTypes);
        int i = 0;
        while (i < arrayList.size()) {
            ParameterType parameterType = (ParameterType) arrayList.get(i);
            Class cls = i < typeArr.length ? typeArr[i] : String.class;
            if (parameterType.isAnonymous()) {
                arrayList.set(i, parameterType.deAnonymize(cls, new ObjectMapperTransformer(this.parameterTypeRegistry.getDefaultParameterTransformer(), cls)));
            }
            i++;
        }
        return Argument.build(this.treeRegexp, arrayList, str);
    }

    @Override // io.cucumber.cucumberexpressions.Expression
    public String getSource() {
        return this.source;
    }

    @Override // io.cucumber.cucumberexpressions.Expression
    public Pattern getRegexp() {
        return this.treeRegexp.pattern();
    }
}
