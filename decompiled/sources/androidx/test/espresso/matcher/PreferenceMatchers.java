package androidx.test.espresso.matcher;

import android.content.res.Resources;
import android.preference.Preference;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes2.dex */
public final class PreferenceMatchers {
    public static Matcher<Preference> isEnabled() {
        return new TypeSafeMatcher<Preference>() { // from class: androidx.test.espresso.matcher.PreferenceMatchers.5
            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText(" is an enabled preference");
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(Preference preference) {
                return preference.isEnabled();
            }
        };
    }

    public static Matcher<Preference> withKey(String str) {
        return withKey((Matcher<String>) Matchers.is(str));
    }

    public static Matcher<Preference> withSummary(final int i) {
        return new TypeSafeMatcher<Preference>() { // from class: androidx.test.espresso.matcher.PreferenceMatchers.1
            private String resourceName = null;
            private String expectedText = null;

            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText(" with summary string from resource id: ");
                description.appendValue(Integer.valueOf(i));
                if (this.resourceName != null) {
                    description.appendText("[");
                    description.appendText(this.resourceName);
                    description.appendText("]");
                }
                if (this.expectedText != null) {
                    description.appendText(" value: ");
                    description.appendText(this.expectedText);
                }
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(Preference preference) {
                if (this.expectedText == null) {
                    try {
                        this.expectedText = preference.getContext().getResources().getString(i);
                        this.resourceName = preference.getContext().getResources().getResourceEntryName(i);
                    } catch (Resources.NotFoundException unused) {
                    }
                }
                String str = this.expectedText;
                if (str != null) {
                    return str.equals(preference.getSummary().toString());
                }
                return false;
            }
        };
    }

    public static Matcher<Preference> withSummaryText(String str) {
        return withSummaryText((Matcher<String>) Matchers.is(str));
    }

    public static Matcher<Preference> withTitle(final int i) {
        return new TypeSafeMatcher<Preference>() { // from class: androidx.test.espresso.matcher.PreferenceMatchers.3
            private String resourceName = null;
            private String expectedText = null;

            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText(" with title string from resource id: ");
                description.appendValue(Integer.valueOf(i));
                if (this.resourceName != null) {
                    description.appendText("[");
                    description.appendText(this.resourceName);
                    description.appendText("]");
                }
                if (this.expectedText != null) {
                    description.appendText(" value: ");
                    description.appendText(this.expectedText);
                }
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(Preference preference) {
                if (this.expectedText == null) {
                    try {
                        this.expectedText = preference.getContext().getResources().getString(i);
                        this.resourceName = preference.getContext().getResources().getResourceEntryName(i);
                    } catch (Resources.NotFoundException unused) {
                    }
                }
                if (this.expectedText == null || preference.getTitle() == null) {
                    return false;
                }
                return this.expectedText.equals(preference.getTitle().toString());
            }
        };
    }

    public static Matcher<Preference> withTitleText(String str) {
        return withTitleText((Matcher<String>) Matchers.is(str));
    }

    public static Matcher<Preference> withKey(final Matcher<String> matcher) {
        return new TypeSafeMatcher<Preference>() { // from class: androidx.test.espresso.matcher.PreferenceMatchers.6
            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText(" preference with key matching: ");
                matcher.describeTo(description);
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(Preference preference) {
                return matcher.matches(preference.getKey());
            }
        };
    }

    public static Matcher<Preference> withSummaryText(final Matcher<String> matcher) {
        return new TypeSafeMatcher<Preference>() { // from class: androidx.test.espresso.matcher.PreferenceMatchers.2
            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText(" a preference with summary matching: ");
                matcher.describeTo(description);
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(Preference preference) {
                return matcher.matches(preference.getSummary().toString());
            }
        };
    }

    public static Matcher<Preference> withTitleText(final Matcher<String> matcher) {
        return new TypeSafeMatcher<Preference>() { // from class: androidx.test.espresso.matcher.PreferenceMatchers.4
            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText(" a preference with title matching: ");
                matcher.describeTo(description);
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(Preference preference) {
                if (preference.getTitle() == null) {
                    return false;
                }
                return matcher.matches(preference.getTitle().toString());
            }
        };
    }
}
