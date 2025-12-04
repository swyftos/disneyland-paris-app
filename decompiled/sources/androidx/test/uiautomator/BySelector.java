package androidx.test.uiautomator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class BySelector {
    Boolean mCheckable;
    Boolean mChecked;
    List mChildSelectors = new LinkedList();
    Pattern mClazz;
    Boolean mClickable;
    Pattern mDesc;
    Boolean mEnabled;
    Boolean mFocusable;
    Boolean mFocused;
    Boolean mLongClickable;
    Integer mMaxDepth;
    Integer mMinDepth;
    Pattern mPkg;
    Pattern mRes;
    Boolean mScrollable;
    Boolean mSelected;
    Pattern mText;

    BySelector() {
    }

    BySelector(BySelector bySelector) {
        this.mClazz = bySelector.mClazz;
        this.mDesc = bySelector.mDesc;
        this.mPkg = bySelector.mPkg;
        this.mRes = bySelector.mRes;
        this.mText = bySelector.mText;
        this.mChecked = bySelector.mChecked;
        this.mCheckable = bySelector.mCheckable;
        this.mClickable = bySelector.mClickable;
        this.mEnabled = bySelector.mEnabled;
        this.mFocused = bySelector.mFocused;
        this.mFocusable = bySelector.mFocusable;
        this.mLongClickable = bySelector.mLongClickable;
        this.mScrollable = bySelector.mScrollable;
        this.mSelected = bySelector.mSelected;
        Iterator it = bySelector.mChildSelectors.iterator();
        while (it.hasNext()) {
            this.mChildSelectors.add(new BySelector((BySelector) it.next()));
        }
    }

    public BySelector clazz(String str) {
        checkNotNull(str, "className cannot be null");
        if (str.charAt(0) == '.') {
            return clazz("android.widget", str.substring(1));
        }
        return clazz(Pattern.compile(Pattern.quote(str)));
    }

    public BySelector clazz(String str, String str2) {
        checkNotNull(str, "packageName cannot be null");
        checkNotNull(str2, "className cannot be null");
        return clazz(Pattern.compile(Pattern.quote(String.format("%s.%s", str, str2))));
    }

    public BySelector clazz(Class cls) {
        checkNotNull(cls, "clazz cannot be null");
        return clazz(Pattern.compile(Pattern.quote(cls.getName())));
    }

    public BySelector clazz(Pattern pattern) {
        checkNotNull(pattern, "className cannot be null");
        if (this.mClazz != null) {
            throw new IllegalStateException("Class selector is already defined");
        }
        this.mClazz = pattern;
        return this;
    }

    public BySelector desc(String str) {
        checkNotNull(str, "contentDescription cannot be null");
        return desc(Pattern.compile(Pattern.quote(str)));
    }

    public BySelector descContains(String str) {
        checkNotNull(str, "substring cannot be null");
        return desc(Pattern.compile(String.format("^.*%s.*$", Pattern.quote(str))));
    }

    public BySelector descStartsWith(String str) {
        checkNotNull(str, "substring cannot be null");
        return desc(Pattern.compile(String.format("^%s.*$", Pattern.quote(str))));
    }

    public BySelector descEndsWith(String str) {
        checkNotNull(str, "substring cannot be null");
        return desc(Pattern.compile(String.format("^.*%s$", Pattern.quote(str))));
    }

    public BySelector desc(Pattern pattern) {
        checkNotNull(pattern, "contentDescription cannot be null");
        if (this.mDesc != null) {
            throw new IllegalStateException("Description selector is already defined");
        }
        this.mDesc = pattern;
        return this;
    }

    public BySelector pkg(String str) {
        checkNotNull(str, "applicationPackage cannot be null");
        return pkg(Pattern.compile(Pattern.quote(str)));
    }

    public BySelector pkg(Pattern pattern) {
        checkNotNull(pattern, "applicationPackage cannot be null");
        if (this.mPkg != null) {
            throw new IllegalStateException("Package selector is already defined");
        }
        this.mPkg = pattern;
        return this;
    }

    public BySelector res(String str) {
        checkNotNull(str, "resourceName cannot be null");
        return res(Pattern.compile(Pattern.quote(str)));
    }

    public BySelector res(String str, String str2) {
        checkNotNull(str, "resourcePackage cannot be null");
        checkNotNull(str2, "resourceId cannot be null");
        return res(Pattern.compile(Pattern.quote(String.format("%s:id/%s", str, str2))));
    }

    public BySelector res(Pattern pattern) {
        checkNotNull(pattern, "resourceName cannot be null");
        if (this.mRes != null) {
            throw new IllegalStateException("Resource name selector is already defined");
        }
        this.mRes = pattern;
        return this;
    }

    public BySelector text(String str) {
        checkNotNull(str, "textValue cannot be null");
        return text(Pattern.compile(Pattern.quote(str)));
    }

    public BySelector textContains(String str) {
        checkNotNull(str, "substring cannot be null");
        return text(Pattern.compile(String.format("^.*%s.*$", Pattern.quote(str))));
    }

    public BySelector textStartsWith(String str) {
        checkNotNull(str, "substring cannot be null");
        return text(Pattern.compile(String.format("^%s.*$", Pattern.quote(str))));
    }

    public BySelector textEndsWith(String str) {
        checkNotNull(str, "substring cannot be null");
        return text(Pattern.compile(String.format("^.*%s$", Pattern.quote(str))));
    }

    public BySelector text(Pattern pattern) {
        checkNotNull(pattern, "textValue cannot be null");
        if (this.mText != null) {
            throw new IllegalStateException("Text selector is already defined");
        }
        this.mText = pattern;
        return this;
    }

    public BySelector checkable(boolean z) {
        if (this.mCheckable != null) {
            throw new IllegalStateException("Checkable selector is already defined");
        }
        this.mCheckable = Boolean.valueOf(z);
        return this;
    }

    public BySelector checked(boolean z) {
        if (this.mChecked != null) {
            throw new IllegalStateException("Checked selector is already defined");
        }
        this.mChecked = Boolean.valueOf(z);
        return this;
    }

    public BySelector clickable(boolean z) {
        if (this.mClickable != null) {
            throw new IllegalStateException("Clickable selector is already defined");
        }
        this.mClickable = Boolean.valueOf(z);
        return this;
    }

    public BySelector enabled(boolean z) {
        if (this.mEnabled != null) {
            throw new IllegalStateException("Enabled selector is already defined");
        }
        this.mEnabled = Boolean.valueOf(z);
        return this;
    }

    public BySelector focusable(boolean z) {
        if (this.mFocusable != null) {
            throw new IllegalStateException("Focusable selector is already defined");
        }
        this.mFocusable = Boolean.valueOf(z);
        return this;
    }

    public BySelector focused(boolean z) {
        if (this.mFocused != null) {
            throw new IllegalStateException("Focused selector is already defined");
        }
        this.mFocused = Boolean.valueOf(z);
        return this;
    }

    public BySelector longClickable(boolean z) {
        if (this.mLongClickable != null) {
            throw new IllegalStateException("Long Clickable selector is already defined");
        }
        this.mLongClickable = Boolean.valueOf(z);
        return this;
    }

    public BySelector scrollable(boolean z) {
        if (this.mScrollable != null) {
            throw new IllegalStateException("Scrollable selector is already defined");
        }
        this.mScrollable = Boolean.valueOf(z);
        return this;
    }

    public BySelector selected(boolean z) {
        if (this.mSelected != null) {
            throw new IllegalStateException("Selected selector is already defined");
        }
        this.mSelected = Boolean.valueOf(z);
        return this;
    }

    public BySelector depth(int i) {
        return depth(i, i);
    }

    public BySelector depth(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("min cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("max cannot be negative");
        }
        if (this.mMinDepth != null) {
            throw new IllegalStateException("Minimum Depth selector is already defined");
        }
        if (this.mMaxDepth != null) {
            throw new IllegalStateException("Maximum Depth selector is already defined");
        }
        this.mMinDepth = Integer.valueOf(i);
        this.mMaxDepth = Integer.valueOf(i2);
        return this;
    }

    public BySelector minDepth(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("min cannot be negative");
        }
        if (this.mMinDepth != null) {
            throw new IllegalStateException("Depth selector is already defined");
        }
        this.mMinDepth = Integer.valueOf(i);
        return this;
    }

    public BySelector maxDepth(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max cannot be negative");
        }
        if (this.mMaxDepth != null) {
            throw new IllegalStateException("Depth selector is already defined");
        }
        this.mMaxDepth = Integer.valueOf(i);
        return this;
    }

    public BySelector hasChild(BySelector bySelector) {
        checkNotNull(bySelector, "childSelector cannot be null");
        return hasDescendant(bySelector, 1);
    }

    public BySelector hasDescendant(BySelector bySelector) {
        checkNotNull(bySelector, "descendantSelector cannot be null");
        this.mChildSelectors.add(bySelector);
        return this;
    }

    public BySelector hasDescendant(BySelector bySelector, int i) {
        checkNotNull(bySelector, "descendantSelector cannot be null");
        bySelector.mMaxDepth = Integer.valueOf(i);
        this.mChildSelectors.add(bySelector);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BySelector [");
        if (this.mClazz != null) {
            sb.append("CLASS='");
            sb.append(this.mClazz);
            sb.append("', ");
        }
        if (this.mDesc != null) {
            sb.append("DESC='");
            sb.append(this.mDesc);
            sb.append("', ");
        }
        if (this.mPkg != null) {
            sb.append("PKG='");
            sb.append(this.mPkg);
            sb.append("', ");
        }
        if (this.mRes != null) {
            sb.append("RES='");
            sb.append(this.mRes);
            sb.append("', ");
        }
        if (this.mText != null) {
            sb.append("TEXT='");
            sb.append(this.mText);
            sb.append("', ");
        }
        if (this.mChecked != null) {
            sb.append("CHECKED='");
            sb.append(this.mChecked);
            sb.append("', ");
        }
        if (this.mCheckable != null) {
            sb.append("CHECKABLE='");
            sb.append(this.mCheckable);
            sb.append("', ");
        }
        if (this.mClickable != null) {
            sb.append("CLICKABLE='");
            sb.append(this.mClickable);
            sb.append("', ");
        }
        if (this.mEnabled != null) {
            sb.append("ENABLED='");
            sb.append(this.mEnabled);
            sb.append("', ");
        }
        if (this.mFocused != null) {
            sb.append("FOCUSED='");
            sb.append(this.mFocused);
            sb.append("', ");
        }
        if (this.mFocusable != null) {
            sb.append("FOCUSABLE='");
            sb.append(this.mFocusable);
            sb.append("', ");
        }
        if (this.mLongClickable != null) {
            sb.append("LONGCLICKABLE='");
            sb.append(this.mLongClickable);
            sb.append("', ");
        }
        if (this.mScrollable != null) {
            sb.append("SCROLLABLE='");
            sb.append(this.mScrollable);
            sb.append("', ");
        }
        if (this.mSelected != null) {
            sb.append("SELECTED='");
            sb.append(this.mSelected);
            sb.append("', ");
        }
        for (BySelector bySelector : this.mChildSelectors) {
            sb.append("CHILD='");
            sb.append(bySelector.toString().substring(11));
            sb.append("', ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    private static Object checkNotNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
