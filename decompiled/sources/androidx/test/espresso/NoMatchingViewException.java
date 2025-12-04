package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;
import java.util.List;
import java.util.Locale;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class NoMatchingViewException extends RuntimeException implements EspressoException {
    private EspressoOptional adapterViewWarning;
    private List adapterViews;
    private boolean includeViewHierarchy;
    private View rootView;
    private Matcher viewMatcher;

    public static class Builder {
        private Throwable cause;
        private View rootView;
        private Matcher viewMatcher;
        private List adapterViews = Lists.newArrayList();
        private boolean includeViewHierarchy = true;
        private EspressoOptional adapterViewWarning = EspressoOptional.absent();

        public NoMatchingViewException build() {
            Preconditions.checkNotNull(this.viewMatcher);
            Preconditions.checkNotNull(this.rootView);
            Preconditions.checkNotNull(this.adapterViews);
            Preconditions.checkNotNull(this.adapterViewWarning);
            return new NoMatchingViewException(this);
        }

        public Builder from(NoMatchingViewException noMatchingViewException) {
            this.viewMatcher = noMatchingViewException.viewMatcher;
            this.rootView = noMatchingViewException.rootView;
            this.adapterViews = noMatchingViewException.adapterViews;
            this.adapterViewWarning = noMatchingViewException.adapterViewWarning;
            this.includeViewHierarchy = noMatchingViewException.includeViewHierarchy;
            return this;
        }

        public Builder includeViewHierarchy(boolean z) {
            this.includeViewHierarchy = z;
            return this;
        }

        public Builder withAdapterViewWarning(EspressoOptional<String> espressoOptional) {
            this.adapterViewWarning = espressoOptional;
            return this;
        }

        public Builder withAdapterViews(List<View> list) {
            this.adapterViews = list;
            return this;
        }

        public Builder withCause(Throwable th) {
            this.cause = th;
            return this;
        }

        public Builder withRootView(View view) {
            this.rootView = view;
            return this;
        }

        public Builder withViewMatcher(Matcher<? super View> matcher) {
            this.viewMatcher = matcher;
            return this;
        }
    }

    private NoMatchingViewException(Builder builder) {
        super(getErrorMessage(builder), builder.cause);
        this.adapterViews = Lists.newArrayList();
        this.includeViewHierarchy = true;
        this.adapterViewWarning = EspressoOptional.absent();
        this.viewMatcher = builder.viewMatcher;
        this.rootView = builder.rootView;
        this.adapterViews = builder.adapterViews;
        this.adapterViewWarning = builder.adapterViewWarning;
        this.includeViewHierarchy = builder.includeViewHierarchy;
    }

    private static String getErrorMessage(Builder builder) {
        if (!builder.includeViewHierarchy) {
            return String.format(Locale.ROOT, "Could not find a view that matches %s", builder.viewMatcher);
        }
        String strConcat = String.format(Locale.ROOT, "No views in hierarchy found matching: %s", builder.viewMatcher);
        if (builder.adapterViewWarning.isPresent()) {
            String strValueOf = String.valueOf((String) builder.adapterViewWarning.get());
            strConcat = strValueOf.length() != 0 ? strConcat.concat(strValueOf) : new String(strConcat);
        }
        return HumanReadables.getViewHierarchyErrorMessage(builder.rootView, null, strConcat, null);
    }

    public String getViewMatcherDescription() {
        Matcher matcher = this.viewMatcher;
        return matcher != null ? matcher.toString() : "unknown";
    }
}
