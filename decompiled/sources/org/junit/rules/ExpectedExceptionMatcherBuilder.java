package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.matchers.JUnitMatchers;

/* loaded from: classes6.dex */
class ExpectedExceptionMatcherBuilder {
    private final List matchers = new ArrayList();

    private Matcher cast(Matcher matcher) {
        return matcher;
    }

    ExpectedExceptionMatcherBuilder() {
    }

    void add(Matcher matcher) {
        this.matchers.add(matcher);
    }

    boolean expectsThrowable() {
        return !this.matchers.isEmpty();
    }

    Matcher build() {
        return JUnitMatchers.isThrowable(allOfTheMatchers());
    }

    private Matcher allOfTheMatchers() {
        if (this.matchers.size() == 1) {
            return cast((Matcher) this.matchers.get(0));
        }
        return CoreMatchers.allOf(castedMatchers());
    }

    private List castedMatchers() {
        return new ArrayList(this.matchers);
    }
}
