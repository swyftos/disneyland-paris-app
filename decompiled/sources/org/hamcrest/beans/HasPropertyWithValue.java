package org.hamcrest.beans;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.hamcrest.Condition;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/* loaded from: classes6.dex */
public class HasPropertyWithValue<T> extends TypeSafeDiagnosingMatcher<T> {
    private static final Condition.Step WITH_READ_METHOD = withReadMethod();
    private final String propertyName;
    private final Matcher valueMatcher;

    private static Matcher nastyGenericsWorkaround(Matcher matcher) {
        return matcher;
    }

    public HasPropertyWithValue(String str, Matcher<?> matcher) {
        this.propertyName = str;
        this.valueMatcher = nastyGenericsWorkaround(matcher);
    }

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(T t, Description description) {
        return propertyOn(t, description).and(WITH_READ_METHOD).and(withPropertyValue(t)).matching(this.valueMatcher, "property '" + this.propertyName + "' ");
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("hasProperty(").appendValue(this.propertyName).appendText(", ").appendDescriptionOf(this.valueMatcher).appendText(")");
    }

    private Condition propertyOn(Object obj, Description description) throws IllegalArgumentException {
        PropertyDescriptor propertyDescriptor = PropertyUtil.getPropertyDescriptor(this.propertyName, obj);
        if (propertyDescriptor == null) {
            description.appendText("No property \"" + this.propertyName + "\"");
            return Condition.notMatched();
        }
        return Condition.matched(propertyDescriptor, description);
    }

    private Condition.Step withPropertyValue(final Object obj) {
        return new Condition.Step() { // from class: org.hamcrest.beans.HasPropertyWithValue.1
            @Override // org.hamcrest.Condition.Step
            public Condition apply(Method method, Description description) {
                try {
                    return Condition.matched(method.invoke(obj, PropertyUtil.NO_ARGUMENTS), description);
                } catch (Exception e) {
                    description.appendText(e.getMessage());
                    return Condition.notMatched();
                }
            }
        };
    }

    private static Condition.Step withReadMethod() {
        return new Condition.Step() { // from class: org.hamcrest.beans.HasPropertyWithValue.2
            @Override // org.hamcrest.Condition.Step
            public Condition apply(PropertyDescriptor propertyDescriptor, Description description) {
                Method readMethod = propertyDescriptor.getReadMethod();
                if (readMethod == null) {
                    description.appendText("property \"" + propertyDescriptor.getName() + "\" is not readable");
                    return Condition.notMatched();
                }
                return Condition.matched(readMethod, description);
            }
        };
    }

    @Factory
    public static <T> Matcher<T> hasProperty(String str, Matcher<?> matcher) {
        return new HasPropertyWithValue(str, matcher);
    }
}
