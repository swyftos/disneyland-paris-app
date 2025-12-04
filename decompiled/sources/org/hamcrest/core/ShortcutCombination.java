package org.hamcrest.core;

import java.util.Iterator;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/* loaded from: classes6.dex */
abstract class ShortcutCombination extends BaseMatcher {
    private final Iterable matchers;

    public ShortcutCombination(Iterable iterable) {
        this.matchers = iterable;
    }

    protected boolean matches(Object obj, boolean z) {
        Iterator it = this.matchers.iterator();
        while (it.hasNext()) {
            if (((Matcher) it.next()).matches(obj) == z) {
                return z;
            }
        }
        return !z;
    }

    public void describeTo(Description description, String str) {
        description.appendList("(", " " + str + " ", ")", this.matchers);
    }
}
