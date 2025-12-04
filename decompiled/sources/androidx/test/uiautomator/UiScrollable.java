package androidx.test.uiautomator;

import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes2.dex */
public class UiScrollable extends UiCollection {
    private static final String LOG_TAG = "UiScrollable";
    private static int mMaxSearchSwipes = 30;
    private boolean mIsVerticalList;
    private double mSwipeDeadZonePercentage;

    public UiScrollable(UiSelector uiSelector) {
        super(uiSelector);
        this.mIsVerticalList = true;
        this.mSwipeDeadZonePercentage = 0.1d;
    }

    public UiScrollable setAsVerticalList() {
        Tracer.trace(new Object[0]);
        this.mIsVerticalList = true;
        return this;
    }

    public UiScrollable setAsHorizontalList() {
        Tracer.trace(new Object[0]);
        this.mIsVerticalList = false;
        return this;
    }

    protected boolean exists(UiSelector uiSelector) {
        return getQueryController().findAccessibilityNodeInfo(uiSelector) != null;
    }

    @Override // androidx.test.uiautomator.UiCollection
    public UiObject getChildByDescription(UiSelector uiSelector, String str) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, str);
        return getChildByDescription(uiSelector, str, true);
    }

    public UiObject getChildByDescription(UiSelector uiSelector, String str, boolean z) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, str, Boolean.valueOf(z));
        if (str != null) {
            if (z) {
                scrollIntoView(new UiSelector().descriptionContains(str));
            }
            return super.getChildByDescription(uiSelector, str);
        }
        throw new UiObjectNotFoundException("for description= \"" + str + "\"");
    }

    @Override // androidx.test.uiautomator.UiCollection
    public UiObject getChildByInstance(UiSelector uiSelector, int i) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, Integer.valueOf(i));
        return new UiObject(UiSelector.patternBuilder(getSelector(), UiSelector.patternBuilder(uiSelector).instance(i)));
    }

    @Override // androidx.test.uiautomator.UiCollection
    public UiObject getChildByText(UiSelector uiSelector, String str) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, str);
        return getChildByText(uiSelector, str, true);
    }

    public UiObject getChildByText(UiSelector uiSelector, String str, boolean z) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, str, Boolean.valueOf(z));
        if (str != null) {
            if (z) {
                scrollIntoView(new UiSelector().text(str));
            }
            return super.getChildByText(uiSelector, str);
        }
        throw new UiObjectNotFoundException("for text= \"" + str + "\"");
    }

    public boolean scrollDescriptionIntoView(String str) throws UiObjectNotFoundException {
        Tracer.trace(str);
        return scrollIntoView(new UiSelector().description(str));
    }

    public boolean scrollIntoView(UiObject uiObject) throws UiObjectNotFoundException {
        Tracer.trace(uiObject.getSelector());
        return scrollIntoView(uiObject.getSelector());
    }

    public boolean scrollIntoView(UiSelector uiSelector) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector);
        UiSelector uiSelectorChildSelector = getSelector().childSelector(uiSelector);
        if (exists(uiSelectorChildSelector)) {
            return true;
        }
        scrollToBeginning(mMaxSearchSwipes);
        if (exists(uiSelectorChildSelector)) {
            return true;
        }
        for (int i = 0; i < mMaxSearchSwipes; i++) {
            boolean zScrollForward = scrollForward();
            if (exists(uiSelectorChildSelector)) {
                return true;
            }
            if (!zScrollForward) {
                return false;
            }
        }
        return false;
    }

    public boolean ensureFullyVisible(UiObject uiObject) throws UiObjectNotFoundException {
        Rect bounds = uiObject.getBounds();
        Rect visibleBounds = uiObject.getVisibleBounds();
        boolean z = true;
        if (visibleBounds.width() * visibleBounds.height() == bounds.width() * bounds.height()) {
            return true;
        }
        boolean z2 = this.mIsVerticalList;
        if (!z2 ? bounds.left != visibleBounds.left : bounds.top != visibleBounds.top) {
            z = false;
        }
        if (z2) {
            if (z) {
                return swipeUp(10);
            }
            return swipeDown(10);
        }
        if (z) {
            return swipeLeft(10);
        }
        return swipeRight(10);
    }

    public boolean scrollTextIntoView(String str) throws UiObjectNotFoundException {
        Tracer.trace(str);
        return scrollIntoView(new UiSelector().text(str));
    }

    public UiScrollable setMaxSearchSwipes(int i) {
        Tracer.trace(Integer.valueOf(i));
        mMaxSearchSwipes = i;
        return this;
    }

    public int getMaxSearchSwipes() {
        Tracer.trace(new Object[0]);
        return mMaxSearchSwipes;
    }

    public boolean flingForward() throws UiObjectNotFoundException {
        Tracer.trace(new Object[0]);
        return scrollForward(5);
    }

    public boolean scrollForward() throws UiObjectNotFoundException {
        Tracer.trace(new Object[0]);
        return scrollForward(55);
    }

    public boolean scrollForward(int i) throws UiObjectNotFoundException {
        int iCenterX;
        int iCenterY;
        int iCenterX2;
        int iCenterY2;
        Tracer.trace(Integer.valueOf(i));
        Log.d(LOG_TAG, "scrollForward() on selector = " + getSelector());
        AccessibilityNodeInfo accessibilityNodeInfoFindAccessibilityNodeInfo = findAccessibilityNodeInfo(10000L);
        if (accessibilityNodeInfoFindAccessibilityNodeInfo == null) {
            throw new UiObjectNotFoundException(getSelector().toString());
        }
        Rect rect = new Rect();
        accessibilityNodeInfoFindAccessibilityNodeInfo.getBoundsInScreen(rect);
        if (this.mIsVerticalList) {
            int iHeight = (int) (rect.height() * getSwipeDeadZonePercentage());
            iCenterX = rect.centerX();
            iCenterY = rect.bottom - iHeight;
            iCenterX2 = rect.centerX();
            iCenterY2 = rect.top + iHeight;
        } else {
            int iWidth = (int) (rect.width() * getSwipeDeadZonePercentage());
            iCenterX = rect.right - iWidth;
            iCenterY = rect.centerY();
            iCenterX2 = rect.left + iWidth;
            iCenterY2 = rect.centerY();
        }
        return getInteractionController().scrollSwipe(iCenterX, iCenterY, iCenterX2, iCenterY2, i);
    }

    public boolean flingBackward() throws UiObjectNotFoundException {
        Tracer.trace(new Object[0]);
        return scrollBackward(5);
    }

    public boolean scrollBackward() throws UiObjectNotFoundException {
        Tracer.trace(new Object[0]);
        return scrollBackward(55);
    }

    public boolean scrollBackward(int i) throws UiObjectNotFoundException {
        int iCenterX;
        int iCenterY;
        int iCenterX2;
        int iCenterY2;
        Tracer.trace(Integer.valueOf(i));
        String str = LOG_TAG;
        Log.d(str, "scrollBackward() on selector = " + getSelector());
        AccessibilityNodeInfo accessibilityNodeInfoFindAccessibilityNodeInfo = findAccessibilityNodeInfo(10000L);
        if (accessibilityNodeInfoFindAccessibilityNodeInfo == null) {
            throw new UiObjectNotFoundException(getSelector().toString());
        }
        Rect rect = new Rect();
        accessibilityNodeInfoFindAccessibilityNodeInfo.getBoundsInScreen(rect);
        if (this.mIsVerticalList) {
            int iHeight = (int) (rect.height() * getSwipeDeadZonePercentage());
            Log.d(str, "scrollToBegining() using vertical scroll");
            iCenterX = rect.centerX();
            iCenterY = rect.top + iHeight;
            iCenterX2 = rect.centerX();
            iCenterY2 = rect.bottom - iHeight;
        } else {
            int iWidth = (int) (rect.width() * getSwipeDeadZonePercentage());
            Log.d(str, "scrollToBegining() using hotizontal scroll");
            iCenterX = rect.left + iWidth;
            iCenterY = rect.centerY();
            iCenterX2 = rect.right - iWidth;
            iCenterY2 = rect.centerY();
        }
        return getInteractionController().scrollSwipe(iCenterX, iCenterY, iCenterX2, iCenterY2, i);
    }

    public boolean scrollToBeginning(int i, int i2) throws UiObjectNotFoundException {
        Tracer.trace(Integer.valueOf(i), Integer.valueOf(i2));
        Log.d(LOG_TAG, "scrollToBeginning() on selector = " + getSelector());
        for (int i3 = 0; i3 < i && scrollBackward(i2); i3++) {
        }
        return true;
    }

    public boolean scrollToBeginning(int i) throws UiObjectNotFoundException {
        Tracer.trace(Integer.valueOf(i));
        return scrollToBeginning(i, 55);
    }

    public boolean flingToBeginning(int i) throws UiObjectNotFoundException {
        Tracer.trace(Integer.valueOf(i));
        return scrollToBeginning(i, 5);
    }

    public boolean scrollToEnd(int i, int i2) throws UiObjectNotFoundException {
        Tracer.trace(Integer.valueOf(i), Integer.valueOf(i2));
        for (int i3 = 0; i3 < i && scrollForward(i2); i3++) {
        }
        return true;
    }

    public boolean scrollToEnd(int i) throws UiObjectNotFoundException {
        Tracer.trace(Integer.valueOf(i));
        return scrollToEnd(i, 55);
    }

    public boolean flingToEnd(int i) throws UiObjectNotFoundException {
        Tracer.trace(Integer.valueOf(i));
        return scrollToEnd(i, 5);
    }

    public double getSwipeDeadZonePercentage() {
        Tracer.trace(new Object[0]);
        return this.mSwipeDeadZonePercentage;
    }

    public UiScrollable setSwipeDeadZonePercentage(double d) {
        Tracer.trace(Double.valueOf(d));
        this.mSwipeDeadZonePercentage = d;
        return this;
    }
}
