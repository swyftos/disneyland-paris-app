package androidx.test.uiautomator;

import android.util.SparseArray;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class UiSelector {
    private SparseArray mSelectorAttributes;

    public UiSelector() {
        this.mSelectorAttributes = new SparseArray();
    }

    UiSelector(UiSelector uiSelector) {
        this.mSelectorAttributes = new SparseArray();
        this.mSelectorAttributes = uiSelector.cloneSelector().mSelectorAttributes;
    }

    protected UiSelector cloneSelector() {
        UiSelector uiSelector = new UiSelector();
        uiSelector.mSelectorAttributes = this.mSelectorAttributes.clone();
        if (hasChildSelector()) {
            uiSelector.mSelectorAttributes.put(19, new UiSelector(getChildSelector()));
        }
        if (hasParentSelector()) {
            uiSelector.mSelectorAttributes.put(22, new UiSelector(getParentSelector()));
        }
        if (hasPatternSelector()) {
            uiSelector.mSelectorAttributes.put(21, new UiSelector(getPatternSelector()));
        }
        return uiSelector;
    }

    static UiSelector patternBuilder(UiSelector uiSelector) {
        return !uiSelector.hasPatternSelector() ? new UiSelector().patternSelector(uiSelector) : uiSelector;
    }

    static UiSelector patternBuilder(UiSelector uiSelector, UiSelector uiSelector2) {
        return new UiSelector(new UiSelector().containerSelector(uiSelector).patternSelector(uiSelector2));
    }

    public UiSelector text(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        return buildSelector(1, str);
    }

    public UiSelector textMatches(String str) {
        if (str == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }
        return buildSelector(25, Pattern.compile(str));
    }

    public UiSelector textStartsWith(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        return buildSelector(2, str);
    }

    public UiSelector textContains(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        return buildSelector(3, str);
    }

    public UiSelector className(String str) {
        if (str == null) {
            throw new IllegalArgumentException("className cannot be null");
        }
        return buildSelector(4, str);
    }

    public UiSelector classNameMatches(String str) {
        if (str == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }
        return buildSelector(26, Pattern.compile(str));
    }

    public <T> UiSelector className(Class<T> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return buildSelector(4, cls.getName());
    }

    public UiSelector description(String str) {
        if (str == null) {
            throw new IllegalArgumentException("desc cannot be null");
        }
        return buildSelector(5, str);
    }

    public UiSelector descriptionMatches(String str) {
        if (str == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }
        return buildSelector(27, Pattern.compile(str));
    }

    public UiSelector descriptionStartsWith(String str) {
        if (str == null) {
            throw new IllegalArgumentException("desc cannot be null");
        }
        return buildSelector(6, str);
    }

    public UiSelector descriptionContains(String str) {
        if (str == null) {
            throw new IllegalArgumentException("desc cannot be null");
        }
        return buildSelector(7, str);
    }

    public UiSelector resourceId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        return buildSelector(29, str);
    }

    public UiSelector resourceIdMatches(String str) {
        if (str == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }
        return buildSelector(31, Pattern.compile(str));
    }

    public UiSelector index(int i) {
        return buildSelector(8, Integer.valueOf(i));
    }

    public UiSelector instance(int i) {
        return buildSelector(9, Integer.valueOf(i));
    }

    public UiSelector enabled(boolean z) {
        return buildSelector(10, Boolean.valueOf(z));
    }

    public UiSelector focused(boolean z) {
        return buildSelector(11, Boolean.valueOf(z));
    }

    public UiSelector focusable(boolean z) {
        return buildSelector(12, Boolean.valueOf(z));
    }

    public UiSelector scrollable(boolean z) {
        return buildSelector(13, Boolean.valueOf(z));
    }

    public UiSelector selected(boolean z) {
        return buildSelector(16, Boolean.valueOf(z));
    }

    public UiSelector checked(boolean z) {
        return buildSelector(15, Boolean.valueOf(z));
    }

    public UiSelector clickable(boolean z) {
        return buildSelector(14, Boolean.valueOf(z));
    }

    public UiSelector checkable(boolean z) {
        return buildSelector(30, Boolean.valueOf(z));
    }

    public UiSelector longClickable(boolean z) {
        return buildSelector(24, Boolean.valueOf(z));
    }

    public UiSelector childSelector(UiSelector uiSelector) {
        if (uiSelector == null) {
            throw new IllegalArgumentException("selector cannot be null");
        }
        return buildSelector(19, uiSelector);
    }

    private UiSelector patternSelector(UiSelector uiSelector) {
        return buildSelector(21, uiSelector);
    }

    private UiSelector containerSelector(UiSelector uiSelector) {
        return buildSelector(20, uiSelector);
    }

    public UiSelector fromParent(UiSelector uiSelector) {
        if (uiSelector == null) {
            throw new IllegalArgumentException("selector cannot be null");
        }
        return buildSelector(22, uiSelector);
    }

    public UiSelector packageName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        return buildSelector(18, str);
    }

    public UiSelector packageNameMatches(String str) {
        if (str == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }
        return buildSelector(28, Pattern.compile(str));
    }

    private UiSelector buildSelector(int i, Object obj) {
        UiSelector uiSelector = new UiSelector(this);
        if (i == 19 || i == 22) {
            uiSelector.getLastSubSelector().mSelectorAttributes.put(i, obj);
        } else {
            uiSelector.mSelectorAttributes.put(i, obj);
        }
        return uiSelector;
    }

    UiSelector getChildSelector() {
        UiSelector uiSelector = (UiSelector) this.mSelectorAttributes.get(19, null);
        if (uiSelector != null) {
            return new UiSelector(uiSelector);
        }
        return null;
    }

    UiSelector getPatternSelector() {
        UiSelector uiSelector = (UiSelector) this.mSelectorAttributes.get(21, null);
        if (uiSelector != null) {
            return new UiSelector(uiSelector);
        }
        return null;
    }

    UiSelector getContainerSelector() {
        UiSelector uiSelector = (UiSelector) this.mSelectorAttributes.get(20, null);
        if (uiSelector != null) {
            return new UiSelector(uiSelector);
        }
        return null;
    }

    UiSelector getParentSelector() {
        UiSelector uiSelector = (UiSelector) this.mSelectorAttributes.get(22, null);
        if (uiSelector != null) {
            return new UiSelector(uiSelector);
        }
        return null;
    }

    int getInstance() {
        return getInt(9);
    }

    String getString(int i) {
        return (String) this.mSelectorAttributes.get(i, null);
    }

    boolean getBoolean(int i) {
        return ((Boolean) this.mSelectorAttributes.get(i, Boolean.FALSE)).booleanValue();
    }

    int getInt(int i) {
        return ((Integer) this.mSelectorAttributes.get(i, 0)).intValue();
    }

    Pattern getPattern(int i) {
        return (Pattern) this.mSelectorAttributes.get(i, null);
    }

    boolean isMatchFor(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        int size = this.mSelectorAttributes.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = this.mSelectorAttributes.keyAt(i2);
            switch (iKeyAt) {
                case 1:
                    CharSequence text = accessibilityNodeInfo.getText();
                    if (text == null || !text.toString().contentEquals(getString(iKeyAt))) {
                        return false;
                    }
                    break;
                    break;
                case 2:
                    CharSequence text2 = accessibilityNodeInfo.getText();
                    if (text2 == null || !text2.toString().toLowerCase().startsWith(getString(iKeyAt).toLowerCase())) {
                        return false;
                    }
                    break;
                    break;
                case 3:
                    CharSequence text3 = accessibilityNodeInfo.getText();
                    if (text3 == null || !text3.toString().toLowerCase().contains(getString(iKeyAt).toLowerCase())) {
                        return false;
                    }
                    break;
                case 4:
                    CharSequence className = accessibilityNodeInfo.getClassName();
                    if (className == null || !className.toString().contentEquals(getString(iKeyAt))) {
                        return false;
                    }
                    break;
                    break;
                case 5:
                    CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription == null || !contentDescription.toString().contentEquals(getString(iKeyAt))) {
                        return false;
                    }
                    break;
                    break;
                case 6:
                    CharSequence contentDescription2 = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription2 == null || !contentDescription2.toString().toLowerCase().startsWith(getString(iKeyAt).toLowerCase())) {
                        return false;
                    }
                    break;
                case 7:
                    CharSequence contentDescription3 = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription3 == null || !contentDescription3.toString().toLowerCase().contains(getString(iKeyAt).toLowerCase())) {
                        return false;
                    }
                    break;
                case 8:
                    if (i != getInt(iKeyAt)) {
                        return false;
                    }
                    break;
                case 10:
                    if (accessibilityNodeInfo.isEnabled() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 11:
                    if (accessibilityNodeInfo.isFocused() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 12:
                    if (accessibilityNodeInfo.isFocusable() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 13:
                    if (accessibilityNodeInfo.isScrollable() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 14:
                    if (accessibilityNodeInfo.isClickable() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 15:
                    if (accessibilityNodeInfo.isChecked() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 16:
                    if (accessibilityNodeInfo.isSelected() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 18:
                    CharSequence packageName = accessibilityNodeInfo.getPackageName();
                    if (packageName == null || !packageName.toString().contentEquals(getString(iKeyAt))) {
                        return false;
                    }
                    break;
                    break;
                case 24:
                    if (accessibilityNodeInfo.isLongClickable() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 25:
                    CharSequence text4 = accessibilityNodeInfo.getText();
                    if (text4 == null || !getPattern(iKeyAt).matcher(text4).matches()) {
                        return false;
                    }
                    break;
                    break;
                case 26:
                    CharSequence className2 = accessibilityNodeInfo.getClassName();
                    if (className2 == null || !getPattern(iKeyAt).matcher(className2).matches()) {
                        return false;
                    }
                    break;
                case 27:
                    CharSequence contentDescription4 = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription4 == null || !getPattern(iKeyAt).matcher(contentDescription4).matches()) {
                        return false;
                    }
                    break;
                    break;
                case 28:
                    CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                    if (packageName2 == null || !getPattern(iKeyAt).matcher(packageName2).matches()) {
                        return false;
                    }
                    break;
                    break;
                case 29:
                    String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                    if (viewIdResourceName == null || !viewIdResourceName.toString().contentEquals(getString(iKeyAt))) {
                        return false;
                    }
                    break;
                    break;
                case 30:
                    if (accessibilityNodeInfo.isCheckable() != getBoolean(iKeyAt)) {
                        return false;
                    }
                    break;
                case 31:
                    String viewIdResourceName2 = accessibilityNodeInfo.getViewIdResourceName();
                    if (viewIdResourceName2 == null || !getPattern(iKeyAt).matcher(viewIdResourceName2).matches()) {
                        return false;
                    }
                    break;
            }
        }
        return matchOrUpdateInstance();
    }

    private boolean matchOrUpdateInstance() {
        int iIntValue = this.mSelectorAttributes.indexOfKey(9) >= 0 ? ((Integer) this.mSelectorAttributes.get(9)).intValue() : 0;
        int iIntValue2 = this.mSelectorAttributes.indexOfKey(23) >= 0 ? ((Integer) this.mSelectorAttributes.get(23)).intValue() : 0;
        if (iIntValue == iIntValue2) {
            return true;
        }
        if (iIntValue > iIntValue2) {
            this.mSelectorAttributes.put(23, Integer.valueOf(iIntValue2 + 1));
        }
        return false;
    }

    boolean isLeaf() {
        return this.mSelectorAttributes.indexOfKey(19) < 0 && this.mSelectorAttributes.indexOfKey(22) < 0;
    }

    boolean hasChildSelector() {
        return this.mSelectorAttributes.indexOfKey(19) >= 0;
    }

    boolean hasPatternSelector() {
        return this.mSelectorAttributes.indexOfKey(21) >= 0;
    }

    boolean hasContainerSelector() {
        return this.mSelectorAttributes.indexOfKey(20) >= 0;
    }

    boolean hasParentSelector() {
        return this.mSelectorAttributes.indexOfKey(22) >= 0;
    }

    private UiSelector getLastSubSelector() {
        if (this.mSelectorAttributes.indexOfKey(19) >= 0) {
            UiSelector uiSelector = (UiSelector) this.mSelectorAttributes.get(19);
            return uiSelector.getLastSubSelector() == null ? uiSelector : uiSelector.getLastSubSelector();
        }
        if (this.mSelectorAttributes.indexOfKey(22) < 0) {
            return this;
        }
        UiSelector uiSelector2 = (UiSelector) this.mSelectorAttributes.get(22);
        return uiSelector2.getLastSubSelector() == null ? uiSelector2 : uiSelector2.getLastSubSelector();
    }

    public String toString() {
        return dumpToString(true);
    }

    String dumpToString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(UiSelector.class.getSimpleName() + "[");
        int size = this.mSelectorAttributes.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            int iKeyAt = this.mSelectorAttributes.keyAt(i);
            switch (iKeyAt) {
                case 1:
                    sb.append("TEXT=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 2:
                    sb.append("START_TEXT=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 3:
                    sb.append("CONTAINS_TEXT=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 4:
                    sb.append("CLASS=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 5:
                    sb.append("DESCRIPTION=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 6:
                    sb.append("START_DESCRIPTION=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 7:
                    sb.append("CONTAINS_DESCRIPTION=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 8:
                    sb.append("INDEX=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 9:
                    sb.append("INSTANCE=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 10:
                    sb.append("ENABLED=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 11:
                    sb.append("FOCUSED=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 12:
                    sb.append("FOCUSABLE=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 13:
                    sb.append("SCROLLABLE=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 14:
                    sb.append("CLICKABLE=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 15:
                    sb.append("CHECKED=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 16:
                    sb.append("SELECTED=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 17:
                    sb.append("ID=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 18:
                    sb.append("PACKAGE NAME=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 19:
                    if (z) {
                        sb.append("CHILD=");
                        sb.append(this.mSelectorAttributes.valueAt(i));
                        break;
                    } else {
                        sb.append("CHILD[..]");
                        break;
                    }
                case 20:
                    if (z) {
                        sb.append("CONTAINER=");
                        sb.append(this.mSelectorAttributes.valueAt(i));
                        break;
                    } else {
                        sb.append("CONTAINER[..]");
                        break;
                    }
                case 21:
                    if (z) {
                        sb.append("PATTERN=");
                        sb.append(this.mSelectorAttributes.valueAt(i));
                        break;
                    } else {
                        sb.append("PATTERN[..]");
                        break;
                    }
                case 22:
                    if (z) {
                        sb.append("PARENT=");
                        sb.append(this.mSelectorAttributes.valueAt(i));
                        break;
                    } else {
                        sb.append("PARENT[..]");
                        break;
                    }
                case 23:
                    sb.append("COUNT=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 24:
                    sb.append("LONG_CLICKABLE=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 25:
                    sb.append("TEXT_REGEX=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 26:
                    sb.append("CLASS_REGEX=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 27:
                    sb.append("DESCRIPTION_REGEX=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 28:
                    sb.append("PACKAGE_NAME_REGEX=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 29:
                    sb.append("RESOURCE_ID=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 30:
                    sb.append("CHECKABLE=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                case 31:
                    sb.append("RESOURCE_ID_REGEX=");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
                default:
                    sb.append("UNDEFINED=" + iKeyAt + " ");
                    sb.append(this.mSelectorAttributes.valueAt(i));
                    break;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
