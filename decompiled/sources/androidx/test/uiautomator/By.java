package androidx.test.uiautomator;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class By {
    public static BySelector copy(BySelector bySelector) {
        return new BySelector(bySelector);
    }

    public static BySelector clazz(String str) {
        return new BySelector().clazz(str);
    }

    public static BySelector clazz(String str, String str2) {
        return new BySelector().clazz(str, str2);
    }

    public static BySelector clazz(Class cls) {
        return new BySelector().clazz(cls);
    }

    public static BySelector clazz(Pattern pattern) {
        return new BySelector().clazz(pattern);
    }

    public static BySelector desc(String str) {
        return new BySelector().desc(str);
    }

    public static BySelector descContains(String str) {
        return new BySelector().descContains(str);
    }

    public static BySelector descStartsWith(String str) {
        return new BySelector().descStartsWith(str);
    }

    public static BySelector descEndsWith(String str) {
        return new BySelector().descEndsWith(str);
    }

    public static BySelector desc(Pattern pattern) {
        return new BySelector().desc(pattern);
    }

    public static BySelector pkg(String str) {
        return new BySelector().pkg(str);
    }

    public static BySelector pkg(Pattern pattern) {
        return new BySelector().pkg(pattern);
    }

    public static BySelector res(String str) {
        return new BySelector().res(str);
    }

    public static BySelector res(String str, String str2) {
        return new BySelector().res(str, str2);
    }

    public static BySelector res(Pattern pattern) {
        return new BySelector().res(pattern);
    }

    public static BySelector text(String str) {
        return new BySelector().text(str);
    }

    public static BySelector textContains(String str) {
        return new BySelector().textContains(str);
    }

    public static BySelector textStartsWith(String str) {
        return new BySelector().textStartsWith(str);
    }

    public static BySelector textEndsWith(String str) {
        return new BySelector().textEndsWith(str);
    }

    public static BySelector text(Pattern pattern) {
        return new BySelector().text(pattern);
    }

    public static BySelector checkable(boolean z) {
        return new BySelector().checkable(z);
    }

    public static BySelector checked(boolean z) {
        return new BySelector().checked(z);
    }

    public static BySelector clickable(boolean z) {
        return new BySelector().clickable(z);
    }

    public static BySelector enabled(boolean z) {
        return new BySelector().enabled(z);
    }

    public static BySelector focusable(boolean z) {
        return new BySelector().focusable(z);
    }

    public static BySelector focused(boolean z) {
        return new BySelector().focused(z);
    }

    public static BySelector longClickable(boolean z) {
        return new BySelector().longClickable(z);
    }

    public static BySelector scrollable(boolean z) {
        return new BySelector().scrollable(z);
    }

    public static BySelector selected(boolean z) {
        return new BySelector().selected(z);
    }

    public static BySelector depth(int i) {
        return new BySelector().depth(i);
    }

    public static BySelector hasChild(BySelector bySelector) {
        return new BySelector().hasChild(bySelector);
    }

    public static BySelector hasDescendant(BySelector bySelector) {
        return new BySelector().hasDescendant(bySelector);
    }

    public static BySelector hasDescendant(BySelector bySelector, int i) {
        return new BySelector().hasDescendant(bySelector, i);
    }
}
