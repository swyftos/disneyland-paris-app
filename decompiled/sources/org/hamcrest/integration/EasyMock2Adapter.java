package org.hamcrest.integration;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

/* loaded from: classes6.dex */
public class EasyMock2Adapter implements IArgumentMatcher {
    private final Matcher hamcrestMatcher;

    public static IArgumentMatcher adapt(Matcher<?> matcher) {
        EasyMock2Adapter easyMock2Adapter = new EasyMock2Adapter(matcher);
        EasyMock.reportMatcher(easyMock2Adapter);
        return easyMock2Adapter;
    }

    public EasyMock2Adapter(Matcher<?> matcher) {
        this.hamcrestMatcher = matcher;
    }

    public boolean matches(Object obj) {
        return this.hamcrestMatcher.matches(obj);
    }

    public void appendTo(StringBuffer stringBuffer) {
        this.hamcrestMatcher.describeTo(new StringDescription(stringBuffer));
    }
}
