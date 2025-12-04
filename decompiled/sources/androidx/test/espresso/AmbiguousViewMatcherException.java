package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class AmbiguousViewMatcherException extends RuntimeException implements EspressoException {
    private View[] others;
    private View rootView;
    private View view1;
    private View view2;
    private Matcher viewMatcher;

    public static class Builder {
        private boolean includeViewHierarchy = true;
        private View[] others;
        private View rootView;
        private View view1;
        private View view2;
        private Matcher viewMatcher;

        public AmbiguousViewMatcherException build() {
            Preconditions.checkNotNull(this.viewMatcher);
            Preconditions.checkNotNull(this.rootView);
            Preconditions.checkNotNull(this.view1);
            Preconditions.checkNotNull(this.view2);
            Preconditions.checkNotNull(this.others);
            return new AmbiguousViewMatcherException(this);
        }

        public Builder from(AmbiguousViewMatcherException ambiguousViewMatcherException) {
            this.viewMatcher = ambiguousViewMatcherException.viewMatcher;
            this.rootView = ambiguousViewMatcherException.rootView;
            this.view1 = ambiguousViewMatcherException.view1;
            this.view2 = ambiguousViewMatcherException.view2;
            this.others = ambiguousViewMatcherException.others;
            return this;
        }

        public Builder includeViewHierarchy(boolean z) {
            this.includeViewHierarchy = z;
            return this;
        }

        public Builder withOtherAmbiguousViews(View... viewArr) {
            this.others = viewArr;
            return this;
        }

        public Builder withRootView(View view) {
            this.rootView = view;
            return this;
        }

        public Builder withView1(View view) {
            this.view1 = view;
            return this;
        }

        public Builder withView2(View view) {
            this.view2 = view;
            return this;
        }

        public Builder withViewMatcher(Matcher<? super View> matcher) {
            this.viewMatcher = matcher;
            return this;
        }
    }

    private AmbiguousViewMatcherException(Builder builder) {
        super(getErrorMessage(builder));
        this.viewMatcher = builder.viewMatcher;
        this.rootView = builder.rootView;
        this.view1 = builder.view1;
        this.view2 = builder.view2;
        this.others = builder.others;
    }

    private static String getErrorMessage(Builder builder) {
        if (!builder.includeViewHierarchy) {
            return String.format(Locale.ROOT, "Multiple Ambiguous Views found for matcher %s", builder.viewMatcher);
        }
        return HumanReadables.getViewHierarchyErrorMessage(builder.rootView, Lists.newArrayList(ImmutableSet.builder().add((Object[]) new View[]{builder.view1, builder.view2}).add((Object[]) builder.others).build()), String.format(Locale.ROOT, "'%s' matches multiple views in the hierarchy.", builder.viewMatcher), "****MATCHES****");
    }
}
