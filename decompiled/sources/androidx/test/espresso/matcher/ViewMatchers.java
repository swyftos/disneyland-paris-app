package androidx.test.espresso.matcher;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.test.annotation.Beta;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.Locale;
import java.util.regex.Pattern;
import junit.framework.AssertionFailedError;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/* loaded from: classes2.dex */
public final class ViewMatchers {
    private static final Pattern RESOURCE_ID_PATTERN = Pattern.compile("\\d+");

    /* renamed from: androidx.test.espresso.matcher.ViewMatchers$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod;

        static {
            int[] iArr = new int[WithCharSequenceMatcher.TextViewMethod.values().length];
            $SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod = iArr;
            try {
                iArr[WithCharSequenceMatcher.TextViewMethod.GET_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod[WithCharSequenceMatcher.TextViewMethod.GET_HINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static final class HasChildCountMatcher extends BoundedDiagnosingMatcher<View, ViewGroup> {
        private final int childCount;

        private HasChildCountMatcher(int i) {
            super(ViewGroup.class);
            this.childCount = i;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("viewGroup.getChildCount() to be ").appendValue(Integer.valueOf(this.childCount));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(ViewGroup viewGroup, Description description) {
            description.appendText("viewGroup.getChildCount() was ").appendValue(Integer.valueOf(viewGroup.getChildCount()));
            return viewGroup.getChildCount() == this.childCount;
        }
    }

    static final class HasContentDescriptionMatcher extends TypeSafeDiagnosingMatcher<View> {
        @RemoteMsgConstructor
        private HasContentDescriptionMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getContentDescription() is not null");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (view.getContentDescription() != null) {
                return true;
            }
            description.appendText("view.getContentDescription() was null");
            return false;
        }
    }

    static final class HasDescendantMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher descendantMatcher;
        private final Matcher isViewGroupMatcher;

        private HasDescendantMatcher(Matcher matcher) {
            this.isViewGroupMatcher = Matchers.isA(ViewGroup.class);
            this.descendantMatcher = matcher;
        }

        final /* synthetic */ boolean lambda$matchesSafely$0$ViewMatchers$HasDescendantMatcher(View view, View view2) {
            return view2 != view && this.descendantMatcher.matches(view2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(final View view, Description description) {
            if (!this.isViewGroupMatcher.matches(view)) {
                description.appendText("view ");
                this.isViewGroupMatcher.describeMismatch(view, description);
                return false;
            }
            if (Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), new Predicate(this, view) { // from class: androidx.test.espresso.matcher.ViewMatchers$HasDescendantMatcher$$Lambda$0
                private final ViewMatchers.HasDescendantMatcher arg$1;
                private final View arg$2;

                {
                    this.arg$1 = this;
                    this.arg$2 = view;
                }

                @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
                public boolean apply(Object obj) {
                    return this.arg$1.lambda$matchesSafely$0$ViewMatchers$HasDescendantMatcher(this.arg$2, (View) obj);
                }
            }).iterator().hasNext()) {
                return true;
            }
            description.appendText("no descendant matching ").appendDescriptionOf(this.descendantMatcher).appendText(" was found");
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(view ").appendDescriptionOf(this.isViewGroupMatcher).appendText(" and has descendant matching ").appendDescriptionOf(this.descendantMatcher).appendText(")");
        }
    }

    static final class HasErrorTextMatcher extends BoundedDiagnosingMatcher<View, EditText> {
        private final Matcher stringMatcher;

        private HasErrorTextMatcher(Matcher matcher) {
            super(EditText.class);
            this.stringMatcher = matcher;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("editText.getError() to match ").appendDescriptionOf(this.stringMatcher);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(EditText editText, Description description) {
            description.appendText("editText.getError() was ").appendValue(editText.getError());
            return this.stringMatcher.matches(editText.getError());
        }
    }

    static final class HasFocusMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final boolean hasFocus;

        private HasFocusMatcher(boolean z) {
            this.hasFocus = z;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.hasFocus() is ").appendValue(Boolean.valueOf(this.hasFocus));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zHasFocus = view.hasFocus();
            if (zHasFocus == this.hasFocus) {
                return true;
            }
            description.appendText("view.hasFocus() is ").appendValue(Boolean.valueOf(zHasFocus));
            return false;
        }
    }

    static final class HasImeActionMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher imeActionMatcher;

        private HasImeActionMatcher(Matcher matcher) {
            this.imeActionMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            EditorInfo editorInfo = new EditorInfo();
            if (view.onCreateInputConnection(editorInfo) == null) {
                description.appendText("view.onCreateInputConnection() was null");
                return false;
            }
            int i = editorInfo.actionId;
            if (i == 0) {
                i = editorInfo.imeOptions & 255;
            }
            if (this.imeActionMatcher.matches(Integer.valueOf(i))) {
                return true;
            }
            description.appendText("editorInfo.actionId ");
            this.imeActionMatcher.describeMismatch(Integer.valueOf(i), description);
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(view.onCreateInputConnection() is not null and editorInfo.actionId ").appendDescriptionOf(this.imeActionMatcher).appendText(")");
        }
    }

    static final class HasLinksMatcher extends BoundedDiagnosingMatcher<View, TextView> {
        @RemoteMsgConstructor
        private HasLinksMatcher() {
            super(TextView.class);
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("textView.getUrls().length > 0");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(TextView textView, Description description) {
            description.appendText("textView.getUrls().length was ").appendValue(Integer.valueOf(textView.getUrls().length));
            return textView.getUrls().length > 0;
        }
    }

    static final class HasMinimumChildCountMatcher extends BoundedDiagnosingMatcher<View, ViewGroup> {
        private final int minChildCount;

        private HasMinimumChildCountMatcher(int i) {
            super(ViewGroup.class);
            this.minChildCount = i;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("viewGroup.getChildCount() to be at least ").appendValue(Integer.valueOf(this.minChildCount));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(ViewGroup viewGroup, Description description) {
            description.appendText("viewGroup.getChildCount() was ").appendValue(Integer.valueOf(viewGroup.getChildCount()));
            return viewGroup.getChildCount() >= this.minChildCount;
        }
    }

    static final class HasSiblingMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher parentMatcher;
        private final Matcher siblingMatcher;

        private HasSiblingMatcher(Matcher matcher) {
            this.parentMatcher = Matchers.isA(ViewGroup.class);
            this.siblingMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            ViewParent parent = view.getParent();
            if (!this.parentMatcher.matches(parent)) {
                description.appendText("view.getParent() ");
                this.parentMatcher.describeMismatch(parent, description);
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getChildCount() == 1) {
                description.appendText("no siblings found");
                return false;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (view != childAt && this.siblingMatcher.matches(childAt)) {
                    return true;
                }
            }
            description.appendText("none of the ").appendValue(Integer.valueOf(viewGroup.getChildCount() - 1)).appendText(" siblings match");
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(view.getParent() ").appendDescriptionOf(this.parentMatcher).appendText(" and has a sibling matching ").appendDescriptionOf(this.siblingMatcher).appendText(")");
        }
    }

    static final class IsAssignableFromMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Class clazz;

        private IsAssignableFromMatcher(Class cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is assignable from class ").appendValue(this.clazz);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (this.clazz.isAssignableFrom(view.getClass())) {
                return true;
            }
            description.appendText("view.getClass() was ").appendValue(view.getClass());
            return false;
        }
    }

    static final class IsClickableMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final boolean isClickable;

        private IsClickableMatcher(boolean z) {
            this.isClickable = z;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.isClickable() is ").appendValue(Boolean.valueOf(this.isClickable));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zIsClickable = view.isClickable();
            if (zIsClickable == this.isClickable) {
                return true;
            }
            description.appendText("view.isClickable() was ").appendValue(Boolean.valueOf(zIsClickable));
            return false;
        }
    }

    static final class IsDescendantOfAMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher ancestorMatcher;

        private IsDescendantOfAMatcher(Matcher matcher) {
            this.ancestorMatcher = matcher;
        }

        private boolean checkAncestors(ViewParent viewParent) {
            if (!(viewParent instanceof View)) {
                return false;
            }
            if (this.ancestorMatcher.matches(viewParent)) {
                return true;
            }
            return checkAncestors(viewParent.getParent());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zCheckAncestors = checkAncestors(view.getParent());
            if (!zCheckAncestors) {
                description.appendText("none of the ancestors match ").appendDescriptionOf(this.ancestorMatcher);
            }
            return zCheckAncestors;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is descendant of a view matching ").appendDescriptionOf(this.ancestorMatcher);
        }
    }

    static final class IsDisplayedMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher visibilityMatcher;

        @RemoteMsgConstructor
        private IsDisplayedMatcher() {
            this.visibilityMatcher = ViewMatchers.withEffectiveVisibility(Visibility.VISIBLE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (!this.visibilityMatcher.matches(view)) {
                this.visibilityMatcher.describeMismatch(view, description);
                return false;
            }
            if (view.getGlobalVisibleRect(new Rect())) {
                return true;
            }
            description.appendText("view.getGlobalVisibleRect() returned empty rectangle");
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(").appendDescriptionOf(this.visibilityMatcher).appendText(" and view.getGlobalVisibleRect() to return non-empty rectangle)");
        }
    }

    static final class IsDisplayingAtLeastMatcher extends TypeSafeDiagnosingMatcher<View> {
        final int areaPercentage;
        private final Matcher visibilityMatchers;

        private IsDisplayingAtLeastMatcher(int i) {
            this.visibilityMatchers = ViewMatchers.withEffectiveVisibility(Visibility.VISIBLE);
            this.areaPercentage = i;
        }

        private Rect getScreenWithoutStatusBarActionBar(View view) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int identifier = view.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? view.getContext().getResources().getDimensionPixelSize(identifier) : 0;
            TypedValue typedValue = new TypedValue();
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels - (dimensionPixelSize + (view.getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, view.getContext().getResources().getDisplayMetrics()) : 0)));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (!this.visibilityMatchers.matches(view)) {
                this.visibilityMatchers.describeMismatch(view, description);
                return false;
            }
            if (!view.getGlobalVisibleRect(new Rect())) {
                description.appendText("view was ").appendValue(0).appendText(" percent visible to the user");
                return false;
            }
            Rect screenWithoutStatusBarActionBar = getScreenWithoutStatusBarActionBar(view);
            if (view.getHeight() > screenWithoutStatusBarActionBar.height()) {
                screenWithoutStatusBarActionBar.height();
            } else {
                view.getHeight();
            }
            if (view.getWidth() > screenWithoutStatusBarActionBar.width()) {
                screenWithoutStatusBarActionBar.width();
            } else {
                view.getWidth();
            }
            int iHeight = (int) (((r0.height() * r0.width()) / (Math.min(view.getHeight() * Math.abs(view.getScaleY()), screenWithoutStatusBarActionBar.height()) * Math.min(view.getWidth() * Math.abs(view.getScaleX()), screenWithoutStatusBarActionBar.width()))) * 100.0d);
            if (iHeight >= this.areaPercentage) {
                return true;
            }
            description.appendText("view was ").appendValue(Integer.valueOf(iHeight)).appendText(" percent visible to the user");
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(").appendDescriptionOf(this.visibilityMatchers).appendText(" and view.getGlobalVisibleRect() covers at least ").appendValue(Integer.valueOf(this.areaPercentage)).appendText(" percent of the view's area)");
        }
    }

    static final class IsEnabledMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final boolean isEnabled;

        private IsEnabledMatcher(boolean z) {
            this.isEnabled = z;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.isEnabled() is ").appendValue(Boolean.valueOf(this.isEnabled));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zIsEnabled = view.isEnabled();
            if (zIsEnabled == this.isEnabled) {
                return true;
            }
            description.appendText("view.isEnabled() was ").appendValue(Boolean.valueOf(zIsEnabled));
            return false;
        }
    }

    static final class IsFocusableMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final boolean isFocusable;

        private IsFocusableMatcher(boolean z) {
            this.isFocusable = z;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.isFocusable() is ").appendValue(Boolean.valueOf(this.isFocusable));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zIsFocusable = view.isFocusable();
            if (zIsFocusable == this.isFocusable) {
                return true;
            }
            description.appendText("view.isFocusable() was ").appendValue(Boolean.valueOf(zIsFocusable));
            return false;
        }
    }

    static final class IsFocusedMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final boolean isFocused;

        private IsFocusedMatcher(boolean z) {
            this.isFocused = z;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.isFocused() is ").appendValue(Boolean.valueOf(this.isFocused));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zIsFocused = view.isFocused();
            if (zIsFocused == this.isFocused) {
                return true;
            }
            description.appendText("view.isFocused() was ").appendValue(Boolean.valueOf(zIsFocused));
            return false;
        }
    }

    static final class IsJavascriptEnabledMatcher extends BoundedDiagnosingMatcher<View, WebView> {
        @RemoteMsgConstructor
        private IsJavascriptEnabledMatcher() {
            super(WebView.class);
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("webView.getSettings().getJavaScriptEnabled() is ").appendValue(Boolean.TRUE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(WebView webView, Description description) {
            description.appendText("webView.getSettings().getJavaScriptEnabled() was ").appendValue(Boolean.valueOf(webView.getSettings().getJavaScriptEnabled()));
            return webView.getSettings().getJavaScriptEnabled();
        }
    }

    static final class IsRootMatcher extends TypeSafeDiagnosingMatcher<View> {
        @RemoteMsgConstructor
        private IsRootMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getRootView() to equal view");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            View rootView = view.getRootView();
            if (rootView == view) {
                return true;
            }
            description.appendText("view.getRootView() was ").appendValue(rootView);
            return false;
        }
    }

    static final class IsSelectedMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final boolean isSelected;

        private IsSelectedMatcher(boolean z) {
            this.isSelected = z;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.isSelected() is ").appendValue(Boolean.valueOf(this.isSelected));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zIsSelected = view.isSelected();
            if (zIsSelected == this.isSelected) {
                return true;
            }
            description.appendText("view.isSelected() was ").appendValue(Boolean.valueOf(zIsSelected));
            return false;
        }
    }

    static final class SupportsInputMethodsMatcher extends TypeSafeDiagnosingMatcher<View> {
        @RemoteMsgConstructor
        private SupportsInputMethodsMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.onCreateInputConnection() is not null");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (view.onCreateInputConnection(new EditorInfo()) != null) {
                return true;
            }
            description.appendText("view.onCreateInputConnection() was null");
            return false;
        }
    }

    public enum Visibility {
        VISIBLE(0),
        INVISIBLE(4),
        GONE(8);

        private final int value;

        Visibility(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static Visibility forViewVisibility(int i) {
            if (i == 0) {
                return VISIBLE;
            }
            if (i == 4) {
                return INVISIBLE;
            }
            if (i == 8) {
                return GONE;
            }
            StringBuilder sb = new StringBuilder(38);
            sb.append("Invalid visibility value <");
            sb.append(i);
            sb.append(">");
            throw new IllegalArgumentException(sb.toString());
        }

        public static Visibility forViewVisibility(View view) {
            return forViewVisibility(view.getVisibility());
        }
    }

    static final class WithAlphaMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final float alpha;

        private WithAlphaMatcher(float f) {
            this.alpha = f;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getAlpha() is ").appendValue(Float.valueOf(this.alpha));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            float alpha = view.getAlpha();
            if (alpha == this.alpha) {
                return true;
            }
            description.appendText("view.getAlpha() was ").appendValue(Float.valueOf(alpha));
            return false;
        }
    }

    static final class WithCharSequenceMatcher extends BoundedDiagnosingMatcher<View, TextView> {
        private String expectedText;
        private final TextViewMethod method;
        private final int resourceId;
        private String resourceName;

        private enum TextViewMethod {
            GET_TEXT,
            GET_HINT
        }

        private WithCharSequenceMatcher(int i, TextViewMethod textViewMethod) {
            super(TextView.class);
            this.resourceId = i;
            this.method = textViewMethod;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            int i = AnonymousClass2.$SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod[this.method.ordinal()];
            if (i == 1) {
                description.appendText("view.getText()");
            } else if (i == 2) {
                description.appendText("view.getHint()");
            }
            description.appendText(" equals string from resource id: ").appendValue(Integer.valueOf(this.resourceId));
            if (this.resourceName != null) {
                description.appendText(" [").appendText(this.resourceName).appendText("]");
            }
            if (this.expectedText != null) {
                description.appendText(" value: ").appendText(this.expectedText);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(TextView textView, Description description) {
            CharSequence text;
            if (this.expectedText == null) {
                try {
                    this.expectedText = textView.getResources().getString(this.resourceId);
                } catch (Resources.NotFoundException unused) {
                }
                this.resourceName = ViewMatchers.safeGetResourceEntryName(textView.getResources(), this.resourceId);
            }
            int i = AnonymousClass2.$SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod[this.method.ordinal()];
            if (i == 1) {
                text = textView.getText();
                description.appendText("view.getText() was ");
            } else {
                if (i != 2) {
                    String strValueOf = String.valueOf(this.method);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
                    sb.append("Unexpected TextView method: ");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                }
                text = textView.getHint();
                description.appendText("view.getHint() was ");
            }
            description.appendValue(text);
            String str = this.expectedText;
            return (str == null || text == null || !str.contentEquals(text)) ? false : true;
        }
    }

    static final class WithCheckBoxStateMatcher<E extends View & Checkable> extends BoundedDiagnosingMatcher<View, E> {
        private final Matcher checkStateMatcher;

        private WithCheckBoxStateMatcher(Matcher matcher) {
            super(View.class, Checkable.class, new Class[0]);
            this.checkStateMatcher = matcher;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("view.isChecked() matching: ").appendDescriptionOf(this.checkStateMatcher);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            boolean zIsChecked = ((Checkable) view).isChecked();
            description.appendText("view.isChecked() was ").appendValue(Boolean.valueOf(zIsChecked));
            return this.checkStateMatcher.matches(Boolean.valueOf(zIsChecked));
        }
    }

    static final class WithChildMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher childMatcher;
        private final Matcher viewGroupMatcher;

        private WithChildMatcher(Matcher matcher) {
            this.viewGroupMatcher = Matchers.isA(ViewGroup.class);
            this.childMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (!this.viewGroupMatcher.matches(view)) {
                description.appendText("view ");
                this.viewGroupMatcher.describeMismatch(view, description);
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (this.childMatcher.matches(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
            description.appendText("All ").appendValue(Integer.valueOf(viewGroup.getChildCount())).appendText(" children did not match");
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(view ").appendDescriptionOf(this.viewGroupMatcher).appendText(" and has child matching: ").appendDescriptionOf(this.childMatcher).appendText(")");
        }
    }

    static final class WithClassNameMatcher extends TypeSafeDiagnosingMatcher<View> {
        final Matcher classNameMatcher;

        private WithClassNameMatcher(Matcher matcher) {
            this.classNameMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            String name = view.getClass().getName();
            if (this.classNameMatcher.matches(name)) {
                return true;
            }
            description.appendText("view.getClass().getName() ");
            this.classNameMatcher.describeMismatch(name, description);
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getClass().getName() matches: ").appendDescriptionOf(this.classNameMatcher);
        }
    }

    static final class WithContentDescriptionFromIdMatcher extends TypeSafeDiagnosingMatcher<View> {
        private String expectedText;
        private final int resourceId;
        private String resourceName;

        private WithContentDescriptionFromIdMatcher(int i) {
            this.resourceName = null;
            this.expectedText = null;
            this.resourceId = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (this.expectedText == null) {
                try {
                    this.expectedText = view.getResources().getString(this.resourceId);
                } catch (Resources.NotFoundException unused) {
                }
                this.resourceName = ViewMatchers.safeGetResourceEntryName(view.getResources(), this.resourceId);
            }
            if (this.expectedText == null) {
                description.appendText("Failed to resolve resource id ").appendValue(Integer.valueOf(this.resourceId));
                return false;
            }
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription != null && this.expectedText.contentEquals(contentDescription)) {
                return true;
            }
            description.appendText("view.getContentDescription() was ").appendValue(contentDescription);
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getContentDescription() to match resource id ").appendValue(Integer.valueOf(this.resourceId));
            if (this.resourceName != null) {
                description.appendText("[").appendText(this.resourceName).appendText("]");
            }
            if (this.expectedText != null) {
                description.appendText(" with value ").appendValue(this.expectedText);
            }
        }
    }

    static final class WithContentDescriptionMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher charSequenceMatcher;

        private WithContentDescriptionMatcher(Matcher matcher) {
            this.charSequenceMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            CharSequence contentDescription = view.getContentDescription();
            if (this.charSequenceMatcher.matches(contentDescription)) {
                return true;
            }
            description.appendText("view.getContentDescription() ");
            this.charSequenceMatcher.describeMismatch(contentDescription, description);
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getContentDescription() ").appendDescriptionOf(this.charSequenceMatcher);
        }
    }

    static final class WithContentDescriptionTextMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher textMatcher;

        private WithContentDescriptionTextMatcher(Matcher matcher) {
            this.textMatcher = matcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getContentDescription() ").appendDescriptionOf(this.textMatcher);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            String string = view.getContentDescription() != null ? view.getContentDescription().toString() : null;
            if (this.textMatcher.matches(string)) {
                return true;
            }
            description.appendText("view.getContentDescription() ");
            this.textMatcher.describeMismatch(string, description);
            return false;
        }
    }

    static final class WithEffectiveVisibilityMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Visibility visibility;

        private WithEffectiveVisibilityMatcher(Visibility visibility) {
            this.visibility = visibility;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view has effective visibility ").appendValue(this.visibility);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            if (this.visibility.getValue() != 0) {
                if (view.getVisibility() == this.visibility.getValue()) {
                    return true;
                }
                while (view.getParent() instanceof View) {
                    view = (View) view.getParent();
                    if (view.getVisibility() == this.visibility.getValue()) {
                        return true;
                    }
                }
                description.appendText("neither view nor its ancestors have getVisibility() set to ").appendValue(this.visibility);
                return false;
            }
            if (view.getVisibility() != this.visibility.getValue()) {
                description.appendText("view.getVisibility() was ").appendValue(Visibility.forViewVisibility(view));
                return false;
            }
            while (view.getParent() instanceof View) {
                view = (View) view.getParent();
                if (view.getVisibility() != this.visibility.getValue()) {
                    description.appendText("ancestor ").appendValue(view).appendText("'s getVisibility() was ").appendValue(Visibility.forViewVisibility(view));
                    return false;
                }
            }
            return true;
        }
    }

    static final class WithHintMatcher extends BoundedDiagnosingMatcher<View, TextView> {
        private final Matcher stringMatcher;

        private WithHintMatcher(Matcher matcher) {
            super(TextView.class);
            this.stringMatcher = matcher;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("view.getHint() matching: ");
            this.stringMatcher.describeTo(description);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(TextView textView, Description description) {
            CharSequence hint = textView.getHint();
            description.appendText("view.getHint() was ").appendValue(hint);
            return this.stringMatcher.matches(hint);
        }
    }

    static final class WithIdMatcher extends TypeSafeDiagnosingMatcher<View> {
        private Resources resources;
        Matcher viewIdMatcher;

        private WithIdMatcher(Matcher matcher) {
            this.viewIdMatcher = matcher;
        }

        private String getViewIdString(String str) throws NumberFormatException {
            java.util.regex.Matcher matcher = ViewMatchers.RESOURCE_ID_PATTERN.matcher(str);
            StringBuffer stringBuffer = new StringBuffer(str.length());
            while (matcher.find()) {
                if (this.resources != null) {
                    String strGroup = matcher.group();
                    String strSafeGetResourceName = ViewMatchers.safeGetResourceName(this.resources, Integer.parseInt(strGroup));
                    if (strSafeGetResourceName != null) {
                        StringBuilder sb = new StringBuilder(String.valueOf(strGroup).length() + 1 + strSafeGetResourceName.length());
                        sb.append(strGroup);
                        sb.append("/");
                        sb.append(strSafeGetResourceName);
                        matcher.appendReplacement(stringBuffer, sb.toString());
                    } else {
                        matcher.appendReplacement(stringBuffer, String.format(Locale.ROOT, "%s (resource name not found)", strGroup));
                    }
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) throws NumberFormatException {
            description.appendText("view.getId() ").appendText(getViewIdString(this.viewIdMatcher.toString()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            this.resources = view.getResources();
            boolean zMatches = this.viewIdMatcher.matches(Integer.valueOf(view.getId()));
            if (!zMatches && !(description instanceof Description.NullDescription)) {
                Description descriptionAppendText = description.appendText("view.getId() was ");
                int id = view.getId();
                StringBuilder sb = new StringBuilder(13);
                sb.append("<");
                sb.append(id);
                sb.append(">");
                descriptionAppendText.appendText(getViewIdString(sb.toString()));
            }
            return zMatches;
        }
    }

    static final class WithInputTypeMatcher extends BoundedDiagnosingMatcher<View, EditText> {
        private final int inputType;

        private WithInputTypeMatcher(int i) {
            super(EditText.class);
            this.inputType = i;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("editText.getInputType() is ").appendValue(Integer.valueOf(this.inputType));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(EditText editText, Description description) {
            description.appendText("editText.getInputType() was ").appendValue(Integer.valueOf(editText.getInputType()));
            return editText.getInputType() == this.inputType;
        }
    }

    static final class WithParentIndexMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final int index;
        private final Matcher parentViewGroupMatcher;

        private WithParentIndexMatcher(int i) {
            this.parentViewGroupMatcher = Matchers.isA(ViewGroup.class);
            this.index = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            ViewParent parent = view.getParent();
            if (!this.parentViewGroupMatcher.matches(parent)) {
                description.appendText("view.getParent() ");
                this.parentViewGroupMatcher.describeMismatch(parent, description);
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            int i = this.index;
            if (childCount <= i) {
                description.appendText("parent only has ").appendValue(Integer.valueOf(viewGroup.getChildCount())).appendText(" children");
                return false;
            }
            View childAt = viewGroup.getChildAt(i);
            if (childAt == view) {
                return true;
            }
            description.appendText("child view at index ").appendValue(Integer.valueOf(this.index)).appendText(" was ").appendValue(childAt);
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("(view.getParent() ").appendDescriptionOf(this.parentViewGroupMatcher).appendText(" and is at child index ").appendValue(Integer.valueOf(this.index)).appendText(")");
        }
    }

    static final class WithParentMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher parentMatcher;

        private WithParentMatcher(Matcher matcher) {
            this.parentMatcher = matcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getParent() ").appendDescriptionOf(this.parentMatcher);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            ViewParent parent = view.getParent();
            if (this.parentMatcher.matches(parent)) {
                return true;
            }
            description.appendText("view.getParent() ");
            this.parentMatcher.describeMismatch(parent, description);
            return false;
        }
    }

    static final class WithResourceNameMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher stringMatcher;

        private WithResourceNameMatcher(Matcher matcher) {
            this.stringMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            int id = view.getId();
            if (id == -1) {
                description.appendText("view.getId() was View.NO_ID");
                return false;
            }
            if (view.getResources() == null) {
                description.appendText("view.getResources() was null, can't resolve resource name");
                return false;
            }
            if (ViewMatchers.isViewIdGenerated(id)) {
                description.appendText("view.getId() was generated by a call to View.generateViewId()");
                return false;
            }
            String strSafeGetResourceEntryName = ViewMatchers.safeGetResourceEntryName(view.getResources(), view.getId());
            if (strSafeGetResourceEntryName == null) {
                description.appendText("view.getId() was ").appendValue(Integer.valueOf(id)).appendText(" which fails to resolve resource name");
                return false;
            }
            if (this.stringMatcher.matches(strSafeGetResourceEntryName)) {
                return true;
            }
            description.appendText("view.getId() was <").appendText(strSafeGetResourceEntryName).appendText(">");
            return false;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getId()'s resource name should match ").appendDescriptionOf(this.stringMatcher);
        }
    }

    static final class WithSpinnerTextIdMatcher extends BoundedDiagnosingMatcher<View, Spinner> {
        private String expectedText;
        private final int resourceId;
        private String resourceName;

        private WithSpinnerTextIdMatcher(int i) {
            super(Spinner.class);
            this.resourceName = null;
            this.expectedText = null;
            this.resourceId = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(Spinner spinner, Description description) {
            if (this.expectedText == null) {
                try {
                    this.expectedText = spinner.getResources().getString(this.resourceId);
                } catch (Resources.NotFoundException unused) {
                }
                this.resourceName = ViewMatchers.safeGetResourceEntryName(spinner.getResources(), this.resourceId);
            }
            if (this.expectedText == null) {
                description.appendText("failure to resolve resourceId ").appendValue(Integer.valueOf(this.resourceId));
                return false;
            }
            Object selectedItem = spinner.getSelectedItem();
            if (selectedItem == null) {
                description.appendText("spinner.getSelectedItem() was null");
                return false;
            }
            description.appendText("spinner.getSelectedItem().toString() was ").appendValue(selectedItem.toString());
            return this.expectedText.equals(selectedItem.toString());
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("spinner.getSelectedItem().toString() to match string from resource id: ").appendValue(Integer.valueOf(this.resourceId));
            if (this.resourceName != null) {
                description.appendText(" [").appendText(this.resourceName).appendText("]");
            }
            if (this.expectedText != null) {
                description.appendText(" value: ").appendText(this.expectedText);
            }
        }
    }

    static final class WithSpinnerTextMatcher extends BoundedDiagnosingMatcher<View, Spinner> {
        private final Matcher stringMatcher;

        private WithSpinnerTextMatcher(Matcher matcher) {
            super(Spinner.class);
            this.stringMatcher = matcher;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(Spinner spinner, Description description) {
            Object selectedItem = spinner.getSelectedItem();
            if (selectedItem == null) {
                description.appendText("spinner.getSelectedItem() was null");
                return false;
            }
            description.appendText("spinner.getSelectedItem().toString() was ").appendValue(selectedItem.toString());
            return this.stringMatcher.matches(spinner.getSelectedItem().toString());
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("spinner.getSelectedItem().toString() to match ").appendDescriptionOf(this.stringMatcher);
        }
    }

    static final class WithTagKeyMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final int key;
        private final Matcher objectMatcher;

        private WithTagKeyMatcher(int i, Matcher matcher) {
            this.key = i;
            this.objectMatcher = matcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            int i = this.key;
            StringBuilder sb = new StringBuilder(25);
            sb.append("view.getTag(");
            sb.append(i);
            sb.append(") ");
            description.appendText(sb.toString()).appendDescriptionOf(this.objectMatcher);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            Object tag = view.getTag(this.key);
            if (this.objectMatcher.matches(tag)) {
                return true;
            }
            int i = this.key;
            StringBuilder sb = new StringBuilder(25);
            sb.append("view.getTag(");
            sb.append(i);
            sb.append(") ");
            description.appendText(sb.toString());
            this.objectMatcher.describeMismatch(tag, description);
            return false;
        }
    }

    static final class WithTagValueMatcher extends TypeSafeDiagnosingMatcher<View> {
        private final Matcher tagValueMatcher;

        private WithTagValueMatcher(Matcher matcher) {
            this.tagValueMatcher = matcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("view.getTag() ").appendDescriptionOf(this.tagValueMatcher);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.hamcrest.TypeSafeDiagnosingMatcher
        public boolean matchesSafely(View view, Description description) {
            Object tag = view.getTag();
            if (this.tagValueMatcher.matches(tag)) {
                return true;
            }
            description.appendText("view.getTag() ");
            this.tagValueMatcher.describeMismatch(tag, description);
            return false;
        }
    }

    static final class WithTextMatcher extends BoundedDiagnosingMatcher<View, TextView> {
        private final Matcher stringMatcher;

        private WithTextMatcher(Matcher matcher) {
            super(TextView.class);
            this.stringMatcher = matcher;
        }

        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        protected void describeMoreTo(Description description) {
            description.appendText("view.getText() with or without transformation to match: ");
            this.stringMatcher.describeTo(description);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
        public boolean matchesSafely(TextView textView, Description description) {
            String string = textView.getText().toString();
            if (this.stringMatcher.matches(string)) {
                return true;
            }
            description.appendText("view.getText() was ").appendValue(string);
            if (textView.getTransformationMethod() == null) {
                return false;
            }
            CharSequence transformation = textView.getTransformationMethod().getTransformation(string, textView);
            description.appendText(" transformed text was ").appendValue(transformation);
            if (transformation != null) {
                return this.stringMatcher.matches(transformation.toString());
            }
            return false;
        }
    }

    public static <T> void assertThat(T t, Matcher<T> matcher) {
        assertThat("", t, matcher);
    }

    public static Matcher<View> doesNotHaveFocus() {
        return new HasFocusMatcher(false);
    }

    private static String getMismatchDescriptionString(Object obj, Matcher matcher) {
        StringDescription stringDescription = new StringDescription();
        matcher.describeMismatch(obj, stringDescription);
        String strTrim = stringDescription.toString().trim();
        return strTrim.isEmpty() ? obj.toString() : strTrim;
    }

    @Beta
    public static Matcher<View> hasBackground(int i) {
        return new HasBackgroundMatcher(i);
    }

    public static Matcher<View> hasChildCount(int i) {
        return new HasChildCountMatcher(i);
    }

    public static Matcher<View> hasContentDescription() {
        return new HasContentDescriptionMatcher();
    }

    public static Matcher<View> hasDescendant(Matcher<View> matcher) {
        return new HasDescendantMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> hasErrorText(String str) {
        return hasErrorText((Matcher<String>) Matchers.is(str));
    }

    public static Matcher<View> hasFocus() {
        return new HasFocusMatcher(true);
    }

    public static Matcher<View> hasImeAction(int i) {
        return hasImeAction((Matcher<Integer>) Matchers.is(Integer.valueOf(i)));
    }

    public static Matcher<View> hasLinks() {
        return new HasLinksMatcher();
    }

    public static Matcher<View> hasMinimumChildCount(int i) {
        return new HasMinimumChildCountMatcher(i);
    }

    public static Matcher<View> hasSibling(Matcher<View> matcher) {
        return new HasSiblingMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    @Beta
    public static Matcher<View> hasTextColor(final int i) {
        return new BoundedDiagnosingMatcher<View, TextView>(TextView.class) { // from class: androidx.test.espresso.matcher.ViewMatchers.1
            private Context context;

            private String getColorHex(int i2) {
                return String.format(Locale.ROOT, "#%02X%06X", Integer.valueOf(Color.alpha(i2) & 255), Integer.valueOf(i2 & ViewCompat.MEASURED_SIZE_MASK));
            }

            @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
            protected void describeMoreTo(Description description) {
                description.appendText("textView.getCurrentTextColor() is color with ");
                Context context = this.context;
                if (context == null) {
                    description.appendText("ID ").appendValue(Integer.valueOf(i));
                } else {
                    String strValueOf = String.valueOf(getColorHex(context.getColor(i)));
                    description.appendText(strValueOf.length() != 0 ? "value ".concat(strValueOf) : new String("value "));
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.test.espresso.matcher.BoundedDiagnosingMatcher
            public boolean matchesSafely(TextView textView, Description description) {
                this.context = textView.getContext();
                int currentTextColor = textView.getCurrentTextColor();
                int color = this.context.getColor(i);
                description.appendText("textView.getCurrentTextColor() was ").appendText(getColorHex(currentTextColor));
                return currentTextColor == color;
            }
        };
    }

    public static Matcher<View> isAssignableFrom(Class<? extends View> cls) {
        return new IsAssignableFromMatcher(cls);
    }

    public static Matcher<View> isChecked() {
        return withCheckBoxState(Matchers.is(Boolean.TRUE));
    }

    public static Matcher<View> isClickable() {
        return new IsClickableMatcher(true);
    }

    public static Matcher<View> isCompletelyDisplayed() {
        return isDisplayingAtLeast(100);
    }

    public static Matcher<View> isDescendantOfA(Matcher<View> matcher) {
        return new IsDescendantOfAMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> isDisplayed() {
        return new IsDisplayedMatcher();
    }

    public static Matcher<View> isDisplayingAtLeast(int i) {
        Preconditions.checkArgument(i <= 100, "Cannot have over 100 percent: %s", i);
        Preconditions.checkArgument(i > 0, "Must have a positive, non-zero value: %s", i);
        return new IsDisplayingAtLeastMatcher(i);
    }

    public static Matcher<View> isEnabled() {
        return new IsEnabledMatcher(true);
    }

    public static Matcher<View> isFocusable() {
        return new IsFocusableMatcher(true);
    }

    public static Matcher<View> isFocused() {
        return new IsFocusedMatcher(true);
    }

    public static Matcher<View> isJavascriptEnabled() {
        return new IsJavascriptEnabledMatcher();
    }

    public static Matcher<View> isNotChecked() {
        return withCheckBoxState(Matchers.is(Boolean.FALSE));
    }

    public static Matcher<View> isNotClickable() {
        return new IsClickableMatcher(false);
    }

    public static Matcher<View> isNotEnabled() {
        return new IsEnabledMatcher(false);
    }

    public static Matcher<View> isNotFocusable() {
        return new IsFocusableMatcher(false);
    }

    public static Matcher<View> isNotFocused() {
        return new IsFocusedMatcher(false);
    }

    public static Matcher<View> isNotSelected() {
        return new IsSelectedMatcher(false);
    }

    public static Matcher<View> isRoot() {
        return new IsRootMatcher();
    }

    public static Matcher<View> isSelected() {
        return new IsSelectedMatcher(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isViewIdGenerated(int i) {
        return ((-16777216) & i) == 0 && (i & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String safeGetResourceEntryName(Resources resources, int i) {
        try {
            if (isViewIdGenerated(i)) {
                return null;
            }
            return resources.getResourceEntryName(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String safeGetResourceName(Resources resources, int i) {
        try {
            if (isViewIdGenerated(i)) {
                return null;
            }
            return resources.getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static Matcher<View> supportsInputMethods() {
        return new SupportsInputMethodsMatcher();
    }

    public static Matcher<View> withAlpha(float f) {
        return new WithAlphaMatcher(f);
    }

    private static Matcher withCheckBoxState(Matcher matcher) {
        return new WithCheckBoxStateMatcher(matcher);
    }

    public static Matcher<View> withChild(Matcher<View> matcher) {
        return new WithChildMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withClassName(Matcher<String> matcher) {
        return new WithClassNameMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withContentDescription(int i) {
        return new WithContentDescriptionFromIdMatcher(i);
    }

    public static Matcher<View> withEffectiveVisibility(Visibility visibility) {
        return new WithEffectiveVisibilityMatcher(visibility);
    }

    public static Matcher<View> withHint(int i) {
        return new WithCharSequenceMatcher(i, WithCharSequenceMatcher.TextViewMethod.GET_HINT);
    }

    public static Matcher<View> withId(int i) {
        return withId((Matcher<Integer>) Matchers.is(Integer.valueOf(i)));
    }

    public static Matcher<View> withInputType(int i) {
        return new WithInputTypeMatcher(i);
    }

    public static Matcher<View> withParent(Matcher<View> matcher) {
        return new WithParentMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withParentIndex(int i) {
        Preconditions.checkArgument(i >= 0, "Index %s must be >= 0", i);
        return new WithParentIndexMatcher(i);
    }

    public static Matcher<View> withResourceName(String str) {
        return withResourceName((Matcher<String>) Matchers.is(str));
    }

    public static Matcher<View> withSpinnerText(int i) {
        return new WithSpinnerTextIdMatcher(i);
    }

    public static Matcher<View> withSubstring(String str) {
        return withText(Matchers.containsString(str));
    }

    public static Matcher<View> withTagKey(int i) {
        return withTagKey(i, Matchers.notNullValue());
    }

    public static Matcher<View> withTagValue(Matcher<Object> matcher) {
        return new WithTagValueMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withText(int i) {
        return new WithCharSequenceMatcher(i, WithCharSequenceMatcher.TextViewMethod.GET_TEXT);
    }

    public static Matcher<View> hasErrorText(Matcher<String> matcher) {
        return new HasErrorTextMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> hasImeAction(Matcher<Integer> matcher) {
        return new HasImeActionMatcher(matcher);
    }

    public static Matcher<View> withContentDescription(String str) {
        return new WithContentDescriptionTextMatcher(Matchers.is(str));
    }

    public static Matcher<View> withHint(String str) {
        return withHint((Matcher<String>) Matchers.is((String) Preconditions.checkNotNull(str)));
    }

    public static Matcher<View> withId(Matcher<Integer> matcher) {
        return new WithIdMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withResourceName(Matcher<String> matcher) {
        return new WithResourceNameMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withSpinnerText(String str) {
        return withSpinnerText((Matcher<String>) Matchers.is(str));
    }

    public static Matcher<View> withTagKey(int i, Matcher<?> matcher) {
        return new WithTagKeyMatcher(i, (Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withText(String str) {
        return withText((Matcher<String>) Matchers.is(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void assertThat(String str, T t, Matcher<T> matcher) {
        if (matcher.matches(t)) {
            return;
        }
        StringDescription stringDescription = new StringDescription();
        stringDescription.appendText(str).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n     Got: ").appendText(getMismatchDescriptionString(t, matcher));
        if (t instanceof View) {
            stringDescription.appendText("\nView Details: ").appendText(HumanReadables.describe((View) t));
        }
        stringDescription.appendText("\n");
        throw new AssertionFailedError(stringDescription.toString());
    }

    public static Matcher<View> withContentDescription(Matcher<? extends CharSequence> matcher) {
        return new WithContentDescriptionMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withHint(Matcher<String> matcher) {
        return new WithHintMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withSpinnerText(Matcher<String> matcher) {
        return new WithSpinnerTextMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static Matcher<View> withText(Matcher<String> matcher) {
        return new WithTextMatcher((Matcher) Preconditions.checkNotNull(matcher));
    }
}
