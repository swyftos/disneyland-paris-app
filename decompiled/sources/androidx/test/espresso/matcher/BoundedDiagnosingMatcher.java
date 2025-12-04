package androidx.test.espresso.matcher;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.ArrayList;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* loaded from: classes2.dex */
public abstract class BoundedDiagnosingMatcher<S, T extends S> extends BaseMatcher<S> {
    private final Matcher matcher;

    public BoundedDiagnosingMatcher(Class<? extends S> cls) {
        this.matcher = Matchers.instanceOf((Class) Preconditions.checkNotNull(cls));
    }

    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public final void describeMismatch(Object obj, Description description) {
        if (obj == null) {
            description.appendText("was null");
        } else if (this.matcher.matches(obj)) {
            matchesSafely(obj, description);
        } else {
            this.matcher.describeMismatch(obj, description);
        }
    }

    protected abstract void describeMoreTo(Description description);

    @Override // org.hamcrest.SelfDescribing
    public final void describeTo(Description description) {
        this.matcher.describeTo(description);
        StringDescription stringDescription = new StringDescription();
        describeMoreTo(stringDescription);
        String string = stringDescription.toString();
        if (string.isEmpty()) {
            return;
        }
        description.appendText(" and ").appendText(string);
    }

    @Override // org.hamcrest.Matcher
    public final boolean matches(Object obj) {
        return obj != null && this.matcher.matches(obj) && matchesSafely(obj, Description.NONE);
    }

    protected abstract boolean matchesSafely(T t, Description description);

    public BoundedDiagnosingMatcher(Class<? extends S> cls, Class<?> cls2, Class<?>... clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length + 2);
        arrayList.add(Matchers.instanceOf((Class) Preconditions.checkNotNull(cls)));
        Preconditions.checkNotNull(clsArr);
        arrayList.add(Matchers.instanceOf((Class) Preconditions.checkNotNull(cls2)));
        Preconditions.checkArgument(cls2.isInterface());
        for (Class<?> cls3 : clsArr) {
            arrayList.add(Matchers.instanceOf((Class) Preconditions.checkNotNull(cls3)));
            Preconditions.checkArgument(cls3.isInterface());
        }
        this.matcher = Matchers.allOf(arrayList);
    }
}
