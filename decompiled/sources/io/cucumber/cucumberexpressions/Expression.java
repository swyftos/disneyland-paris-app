package io.cucumber.cucumberexpressions;

import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public interface Expression {
    Pattern getRegexp();

    String getSource();

    List<Argument<?>> match(String str, Type... typeArr);
}
