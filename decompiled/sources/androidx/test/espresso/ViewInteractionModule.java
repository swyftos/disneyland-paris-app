package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.base.ViewFinderImpl;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.remote.RemoteInteraction;
import androidx.test.espresso.remote.RemoteInteractionRegistry;
import java.util.concurrent.atomic.AtomicReference;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
class ViewInteractionModule {
    private final Matcher viewMatcher;
    private final AtomicReference rootMatcher = new AtomicReference(RootMatchers.DEFAULT);
    private final AtomicReference needsActivity = new AtomicReference(Boolean.TRUE);

    ViewInteractionModule(Matcher matcher) {
        this.viewMatcher = (Matcher) Preconditions.checkNotNull(matcher);
    }

    AtomicReference provideNeedsActivity() {
        return this.needsActivity;
    }

    RemoteInteraction provideRemoteInteraction() {
        return RemoteInteractionRegistry.getInstance();
    }

    AtomicReference provideRootMatcher() {
        return this.rootMatcher;
    }

    public View provideRootView(RootViewPicker rootViewPicker) {
        return rootViewPicker.get2();
    }

    ViewFinder provideViewFinder(ViewFinderImpl viewFinderImpl) {
        return viewFinderImpl;
    }

    Matcher provideViewMatcher() {
        return this.viewMatcher;
    }
}
