package androidx.test.espresso.assertion;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.test.espresso.AmbiguousViewMatcherException;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.Iterator;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class PositionAssertions {

    /* JADX INFO: renamed from: androidx.test.espresso.assertion.PositionAssertions$3 */
    static /* synthetic */ class C13253 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position */
        static final /* synthetic */ int[] f162xe61fedbe;

        static {
            int[] iArr = new int[Position.values().length];
            f162xe61fedbe = iArr;
            try {
                iArr[Position.COMPLETELY_LEFT_OF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f162xe61fedbe[Position.COMPLETELY_RIGHT_OF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f162xe61fedbe[Position.COMPLETELY_ABOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f162xe61fedbe[Position.COMPLETELY_BELOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f162xe61fedbe[Position.PARTIALLY_LEFT_OF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f162xe61fedbe[Position.PARTIALLY_RIGHT_OF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f162xe61fedbe[Position.PARTIALLY_ABOVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f162xe61fedbe[Position.PARTIALLY_BELOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f162xe61fedbe[Position.LEFT_ALIGNED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f162xe61fedbe[Position.RIGHT_ALIGNED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f162xe61fedbe[Position.TOP_ALIGNED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f162xe61fedbe[Position.BOTTOM_ALIGNED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    enum Position {
        COMPLETELY_LEFT_OF("completely left of"),
        COMPLETELY_RIGHT_OF("completely right of"),
        COMPLETELY_ABOVE("completely above"),
        COMPLETELY_BELOW("completely below"),
        PARTIALLY_LEFT_OF("partially left of"),
        PARTIALLY_RIGHT_OF("partially right of"),
        PARTIALLY_ABOVE("partially above"),
        PARTIALLY_BELOW("partially below"),
        LEFT_ALIGNED("aligned left with"),
        RIGHT_ALIGNED("aligned right with"),
        TOP_ALIGNED("aligned top with"),
        BOTTOM_ALIGNED("aligned bottom with");

        private final String positionValue;

        Position(String str) {
            this.positionValue = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.positionValue;
        }
    }

    static View findView(final Matcher matcher, View view) {
        Preconditions.checkNotNull(matcher);
        Preconditions.checkNotNull(view);
        Iterator it = Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), new Predicate<View>() { // from class: androidx.test.espresso.assertion.PositionAssertions.2
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
            public boolean apply(View view2) {
                return matcher.matches(view2);
            }
        }).iterator();
        View view2 = null;
        while (it.hasNext()) {
            if (view2 != null) {
                throw new AmbiguousViewMatcherException.Builder().withRootView(view).withViewMatcher(matcher).withView1(view2).withView2((View) it.next()).withOtherAmbiguousViews((View[]) Iterators.toArray(it, View.class)).build();
            }
            view2 = (View) it.next();
        }
        if (view2 != null) {
            return view2;
        }
        throw new NoMatchingViewException.Builder().withViewMatcher(matcher).withRootView(view).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup getTopViewGroup(View view) {
        ViewGroup viewGroup = null;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
        }
        return viewGroup;
    }

    @Deprecated
    public static ViewAssertion isAbove(Matcher<View> matcher) {
        return isCompletelyAbove(matcher);
    }

    @Deprecated
    public static ViewAssertion isBelow(Matcher<View> matcher) {
        return isCompletelyBelow(matcher);
    }

    public static ViewAssertion isBottomAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.BOTTOM_ALIGNED);
    }

    public static ViewAssertion isCompletelyAbove(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_ABOVE);
    }

    public static ViewAssertion isCompletelyBelow(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_BELOW);
    }

    public static ViewAssertion isCompletelyLeftOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_LEFT_OF);
    }

    public static ViewAssertion isCompletelyRightOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_RIGHT_OF);
    }

    public static ViewAssertion isLeftAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.LEFT_ALIGNED);
    }

    @Deprecated
    public static ViewAssertion isLeftOf(Matcher<View> matcher) {
        return isCompletelyLeftOf(matcher);
    }

    public static ViewAssertion isPartiallyAbove(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_ABOVE);
    }

    public static ViewAssertion isPartiallyBelow(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_BELOW);
    }

    public static ViewAssertion isPartiallyLeftOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_LEFT_OF);
    }

    public static ViewAssertion isPartiallyRightOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_RIGHT_OF);
    }

    static boolean isRelativePosition(View view, View view2, Position position) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view2.getLocationOnScreen(iArr2);
        switch (C13253.f162xe61fedbe[position.ordinal()]) {
            case 1:
                return iArr[0] + view.getWidth() <= iArr2[0];
            case 2:
                return iArr2[0] + view2.getWidth() <= iArr[0];
            case 3:
                return iArr[1] + view.getHeight() <= iArr2[1];
            case 4:
                return iArr2[1] + view2.getHeight() <= iArr[1];
            case 5:
                int i = iArr[0];
                int i2 = iArr2[0];
                return i < i2 && i2 < i + view.getWidth();
            case 6:
                int i3 = iArr2[0];
                int i4 = iArr[0];
                return i3 < i4 && i4 < i3 + view2.getWidth();
            case 7:
                int i5 = iArr[1];
                int i6 = iArr2[1];
                return i5 < i6 && i6 < i5 + view.getHeight();
            case 8:
                int i7 = iArr2[1];
                int i8 = iArr[1];
                return i7 < i8 && i8 < i7 + view2.getHeight();
            case 9:
                return iArr[0] == iArr2[0];
            case 10:
                return iArr[0] + view.getWidth() == iArr2[0] + view2.getWidth();
            case 11:
                return iArr[1] == iArr2[1];
            case 12:
                return iArr[1] + view.getHeight() == iArr2[1] + view2.getHeight();
            default:
                return false;
        }
    }

    public static ViewAssertion isRightAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.RIGHT_ALIGNED);
    }

    @Deprecated
    public static ViewAssertion isRightOf(Matcher<View> matcher) {
        return isCompletelyRightOf(matcher);
    }

    public static ViewAssertion isTopAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.TOP_ALIGNED);
    }

    static ViewAssertion relativePositionOf(final Matcher matcher, final Position position) {
        Preconditions.checkNotNull(matcher);
        return new ViewAssertion() { // from class: androidx.test.espresso.assertion.PositionAssertions.1
            @Override // androidx.test.espresso.ViewAssertion
            public void check(View view, NoMatchingViewException noMatchingViewException) {
                StringDescription stringDescription = new StringDescription();
                if (noMatchingViewException == null) {
                    stringDescription.appendText("View:").appendText(HumanReadables.describe(view)).appendText(" is not ").appendText(position.toString()).appendText(" view ").appendText(matcher.toString());
                    ViewMatchers.assertThat(stringDescription.toString(), Boolean.valueOf(PositionAssertions.isRelativePosition(view, PositionAssertions.findView(matcher, PositionAssertions.getTopViewGroup(view)), position)), Matchers.m2121is(Boolean.TRUE));
                } else {
                    stringDescription.appendText(String.format(Locale.ROOT, "' check could not be performed because view '%s' was not found.\n", noMatchingViewException.getViewMatcherDescription()));
                    Log.e("PositionAssertions", stringDescription.toString());
                    throw noMatchingViewException;
                }
            }
        };
    }
}
