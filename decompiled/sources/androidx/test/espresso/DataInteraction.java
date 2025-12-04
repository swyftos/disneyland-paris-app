package androidx.test.espresso;

import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import androidx.test.espresso.action.AdapterDataLoaderAction;
import androidx.test.espresso.action.AdapterViewProtocol;
import androidx.test.espresso.action.AdapterViewProtocols;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.EspressoOptional;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes2.dex */
public class DataInteraction {
    private final Matcher dataMatcher;
    private Matcher adapterMatcher = ViewMatchers.isAssignableFrom(AdapterView.class);
    private EspressoOptional childViewMatcher = EspressoOptional.absent();
    private EspressoOptional atPosition = EspressoOptional.absent();
    private AdapterViewProtocol adapterViewProtocol = AdapterViewProtocols.standardProtocol();
    private Matcher rootMatcher = RootMatchers.DEFAULT;

    DataInteraction(Matcher matcher) {
        this.dataMatcher = (Matcher) Preconditions.checkNotNull(matcher);
    }

    private Matcher makeTargetMatcher() {
        DisplayDataMatcher displayDataMatcher = DisplayDataMatcher.displayDataMatcher(this.adapterMatcher, this.dataMatcher, this.rootMatcher, this.atPosition, this.adapterViewProtocol);
        return this.childViewMatcher.isPresent() ? Matchers.allOf((Matcher) this.childViewMatcher.get(), ViewMatchers.isDescendantOfA(displayDataMatcher)) : displayDataMatcher;
    }

    public DataInteraction atPosition(Integer num) {
        this.atPosition = EspressoOptional.of((Integer) Preconditions.checkNotNull(num));
        return this;
    }

    public ViewInteraction check(ViewAssertion viewAssertion) {
        return Espresso.onView(makeTargetMatcher()).inRoot(this.rootMatcher).check(viewAssertion);
    }

    public DataInteraction inAdapterView(Matcher<View> matcher) {
        this.adapterMatcher = (Matcher) Preconditions.checkNotNull(matcher);
        return this;
    }

    public DataInteraction inRoot(Matcher<Root> matcher) {
        this.rootMatcher = (Matcher) Preconditions.checkNotNull(matcher);
        return this;
    }

    public DataInteraction onChildView(Matcher<View> matcher) {
        this.childViewMatcher = EspressoOptional.of((Matcher) Preconditions.checkNotNull(matcher));
        return this;
    }

    public ViewInteraction perform(ViewAction... viewActionArr) {
        return Espresso.onView(makeTargetMatcher()).inRoot(this.rootMatcher).perform(viewActionArr);
    }

    public DataInteraction usingAdapterViewProtocol(AdapterViewProtocol adapterViewProtocol) {
        this.adapterViewProtocol = (AdapterViewProtocol) Preconditions.checkNotNull(adapterViewProtocol);
        return this;
    }

    public static final class DisplayDataMatcher extends TypeSafeMatcher<View> {
        private final AdapterDataLoaderAction adapterDataLoaderAction;
        private final Matcher adapterMatcher;
        private final AdapterViewProtocol adapterViewProtocol;
        private final Class adapterViewProtocolClass;
        private final Matcher dataMatcher;

        DisplayDataMatcher(Matcher matcher, Matcher matcher2, AdapterViewProtocol adapterViewProtocol, AdapterDataLoaderAction adapterDataLoaderAction, Function function) {
            this.adapterMatcher = (Matcher) Preconditions.checkNotNull(matcher);
            this.dataMatcher = (Matcher) Preconditions.checkNotNull(matcher2);
            this.adapterViewProtocol = (AdapterViewProtocol) Preconditions.checkNotNull(adapterViewProtocol);
            this.adapterViewProtocolClass = adapterViewProtocol.getClass();
            this.adapterDataLoaderAction = (AdapterDataLoaderAction) Preconditions.checkNotNull(adapterDataLoaderAction);
            ((Function) Preconditions.checkNotNull(function)).apply(adapterDataLoaderAction);
        }

        public static DisplayDataMatcher displayDataMatcher(Matcher<View> matcher, Matcher<? extends Object> matcher2, Matcher<Root> matcher3, EspressoOptional<Integer> espressoOptional, AdapterViewProtocol adapterViewProtocol) {
            return new DisplayDataMatcher(matcher, matcher2, matcher3, adapterViewProtocol, new AdapterDataLoaderAction(matcher2, espressoOptional, adapterViewProtocol));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText(" displaying data matching: ");
            this.dataMatcher.describeTo(description);
            description.appendText(" within adapter view matching: ");
            this.adapterMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            Preconditions.checkState(this.adapterViewProtocol != null, "adapterViewProtocol cannot be null!");
            ViewParent parent = view.getParent();
            while (parent != null && !(parent instanceof AdapterView)) {
                parent = parent.getParent();
            }
            if (parent != null && this.adapterMatcher.matches(parent)) {
                EspressoOptional<AdapterViewProtocol.AdaptedData> dataRenderedByView = this.adapterViewProtocol.getDataRenderedByView((AdapterView) parent, view);
                if (dataRenderedByView.isPresent()) {
                    return dataRenderedByView.get().opaqueToken.equals(this.adapterDataLoaderAction.getAdaptedData().opaqueToken);
                }
            }
            return false;
        }

        private DisplayDataMatcher(final Matcher matcher, Matcher matcher2, final Matcher matcher3, AdapterViewProtocol adapterViewProtocol, AdapterDataLoaderAction adapterDataLoaderAction) {
            this(matcher, matcher2, adapterViewProtocol, adapterDataLoaderAction, new Function<AdapterDataLoaderAction, ViewInteraction>() { // from class: androidx.test.espresso.DataInteraction.DisplayDataMatcher.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
                public ViewInteraction apply(AdapterDataLoaderAction adapterDataLoaderAction2) {
                    return Espresso.onView(matcher).inRoot(matcher3).perform(adapterDataLoaderAction2);
                }
            });
        }
    }
}
