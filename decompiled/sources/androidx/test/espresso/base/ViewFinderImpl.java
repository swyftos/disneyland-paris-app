package androidx.test.espresso.base;

import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import androidx.test.espresso.AmbiguousViewMatcherException;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewFinder;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.TreeIterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class ViewFinderImpl implements ViewFinder {
    private final Provider rootViewProvider;
    private final Matcher viewMatcher;

    private static class MatcherPredicateAdapter<T> implements Predicate<T> {
        private final Matcher matcher;

        private MatcherPredicateAdapter(Matcher matcher) {
            this.matcher = (Matcher) Preconditions.checkNotNull(matcher);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
        public boolean apply(Object obj) {
            return this.matcher.matches(obj);
        }
    }

    ViewFinderImpl(Matcher matcher, Provider provider) {
        this.viewMatcher = matcher;
        this.rootViewProvider = provider;
    }

    private void checkMainThread() {
        Preconditions.checkState(Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Executing a query on the view hierarchy outside of the main thread (on: %s)", Thread.currentThread().getName());
    }

    @Override // androidx.test.espresso.ViewFinder
    public View getView() throws NoMatchingViewException, AmbiguousViewMatcherException {
        checkMainThread();
        MatcherPredicateAdapter matcherPredicateAdapter = new MatcherPredicateAdapter((Matcher) Preconditions.checkNotNull(this.viewMatcher));
        View view = (View) this.rootViewProvider.get2();
        Iterator it = Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), matcherPredicateAdapter).iterator();
        View view2 = null;
        while (it.hasNext()) {
            if (view2 != null) {
                throw new AmbiguousViewMatcherException.Builder().withViewMatcher(this.viewMatcher).withRootView(view).withView1(view2).withView2((View) it.next()).withOtherAmbiguousViews((View[]) Iterators.toArray(it, View.class)).build();
            }
            view2 = (View) it.next();
        }
        if (view2 != null) {
            return view2;
        }
        ArrayList arrayListNewArrayList = Lists.newArrayList(Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), new MatcherPredicateAdapter(ViewMatchers.isAssignableFrom(AdapterView.class))).iterator());
        if (arrayListNewArrayList.isEmpty()) {
            throw new NoMatchingViewException.Builder().withViewMatcher(this.viewMatcher).withRootView(view).build();
        }
        throw new NoMatchingViewException.Builder().withViewMatcher(this.viewMatcher).withRootView(view).withAdapterViews(arrayListNewArrayList).withAdapterViewWarning(EspressoOptional.of(String.format(Locale.ROOT, "\nIf the target view is not part of the view hierarchy, you may need to use Espresso.onData to load it from one of the following AdapterViews:%s", Joiner.on("\n- ").join(arrayListNewArrayList)))).build();
    }
}
