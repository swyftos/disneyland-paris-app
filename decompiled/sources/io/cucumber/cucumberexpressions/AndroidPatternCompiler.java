package io.cucumber.cucumberexpressions;

import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class AndroidPatternCompiler implements PatternCompiler {
    @Override // io.cucumber.cucumberexpressions.PatternCompiler
    public Pattern compile(String str, int i) {
        return Pattern.compile(str, i & (-257));
    }
}
