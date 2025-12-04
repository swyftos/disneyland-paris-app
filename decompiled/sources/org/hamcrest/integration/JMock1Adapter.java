package org.hamcrest.integration;

import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.jmock.core.Constraint;

/* loaded from: classes6.dex */
public class JMock1Adapter implements Constraint {
    private final Matcher hamcrestMatcher;

    public static Constraint adapt(Matcher<?> matcher) {
        return new JMock1Adapter(matcher);
    }

    public JMock1Adapter(Matcher<?> matcher) {
        this.hamcrestMatcher = matcher;
    }

    public boolean eval(Object obj) {
        return this.hamcrestMatcher.matches(obj);
    }

    public StringBuffer describeTo(StringBuffer stringBuffer) {
        this.hamcrestMatcher.describeTo(new StringDescription(stringBuffer));
        return stringBuffer;
    }
}
