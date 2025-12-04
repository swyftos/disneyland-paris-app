package cucumber.runtime.snippets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class ArgumentPattern {
    private final Pattern pattern;
    private final String replacement;

    ArgumentPattern(Pattern pattern) {
        this(pattern, pattern.pattern());
    }

    private ArgumentPattern(Pattern pattern, String str) {
        this.pattern = pattern;
        this.replacement = str;
    }

    String replaceMatchesWithSpace(String str) {
        return replaceMatchWith(str, " ");
    }

    private String replaceMatchWith(String str, String str2) {
        return this.pattern.matcher(str).replaceAll(Matcher.quoteReplacement(str2));
    }
}
