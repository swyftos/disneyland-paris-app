package io.cucumber.cucumberexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes5.dex */
public class ExpressionFactory {
    private final ParameterTypeRegistry parameterTypeRegistry;
    private static final Pattern BEGIN_ANCHOR = Pattern.compile("^\\^.*");
    private static final Pattern END_ANCHOR = Pattern.compile(".*\\$$");
    private static final Pattern SCRIPT_STYLE_REGEXP = Pattern.compile("^/(.*)/$");
    private static final Pattern PARENS = Pattern.compile("\\(([^)]+)\\)");
    private static final Pattern REGEXP_CHARS = Pattern.compile("[\\[\\].+*]+");

    public ExpressionFactory(ParameterTypeRegistry parameterTypeRegistry) {
        this.parameterTypeRegistry = parameterTypeRegistry;
    }

    public Expression createExpression(String str) {
        if (!BEGIN_ANCHOR.matcher(str).find()) {
            Pattern pattern = END_ANCHOR;
            if (!pattern.matcher(str).find()) {
                if (pattern.matcher(str).find()) {
                    return new RegularExpression(Pattern.compile(str), this.parameterTypeRegistry);
                }
                Matcher matcher = SCRIPT_STYLE_REGEXP.matcher(str);
                if (matcher.find()) {
                    return new RegularExpression(Pattern.compile(matcher.group(1)), this.parameterTypeRegistry);
                }
                Matcher matcher2 = PARENS.matcher(str);
                if (matcher2.find()) {
                    if (REGEXP_CHARS.matcher(matcher2.group(1)).find()) {
                        return new RegularExpression(Pattern.compile(str), this.parameterTypeRegistry);
                    }
                }
                return new CucumberExpression(str, this.parameterTypeRegistry);
            }
        }
        return createRegularExpressionWithAnchors(str);
    }

    private RegularExpression createRegularExpressionWithAnchors(String str) {
        try {
            return new RegularExpression(Pattern.compile(str), this.parameterTypeRegistry);
        } catch (PatternSyntaxException e) {
            if (CucumberExpression.PARAMETER_PATTERN.matcher(str).find()) {
                throw new CucumberExpressionException("You cannot use anchors (^ or $) in Cucumber Expressions. Please remove them from " + str, e);
            }
            throw e;
        }
    }
}
