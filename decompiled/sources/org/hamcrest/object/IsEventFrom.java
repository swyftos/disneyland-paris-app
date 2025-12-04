package org.hamcrest.object;

import java.util.EventObject;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/* loaded from: classes6.dex */
public class IsEventFrom extends TypeSafeDiagnosingMatcher<EventObject> {
    private final Class eventClass;
    private final Object source;

    public IsEventFrom(Class<?> cls, Object obj) {
        this.eventClass = cls;
        this.source = obj;
    }

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(EventObject eventObject, Description description) {
        if (!this.eventClass.isInstance(eventObject)) {
            description.appendText("item type was " + eventObject.getClass().getName());
            return false;
        }
        if (eventHasSameSource(eventObject)) {
            return true;
        }
        description.appendText("source was ").appendValue(eventObject.getSource());
        return false;
    }

    private boolean eventHasSameSource(EventObject eventObject) {
        return eventObject.getSource() == this.source;
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an event of type ").appendText(this.eventClass.getName()).appendText(" from ").appendValue(this.source);
    }

    @Factory
    public static Matcher<EventObject> eventFrom(Class<? extends EventObject> cls, Object obj) {
        return new IsEventFrom(cls, obj);
    }

    @Factory
    public static Matcher<EventObject> eventFrom(Object obj) {
        return eventFrom(EventObject.class, obj);
    }
}
