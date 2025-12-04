package androidx.test.uiautomator;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class UiObject2 implements Searchable {
    private static final String TAG = "UiObject2";
    private AccessibilityNodeInfo mCachedNode;
    private UiDevice mDevice;
    private DisplayMetrics mDisplayMetrics;
    private GestureController mGestureController;
    private Gestures mGestures;
    private BySelector mSelector;
    private int mMarginLeft = 5;
    private int mMarginTop = 5;
    private int mMarginRight = 5;
    private int mMarginBottom = 5;
    private final long SCROLL_TIMEOUT = 1000;
    private final long FLING_TIMEOUT = 5000;
    private WaitMixin mWaitMixin = new WaitMixin(this);

    UiObject2(UiDevice uiDevice, BySelector bySelector, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mDevice = uiDevice;
        this.mSelector = bySelector;
        this.mCachedNode = accessibilityNodeInfo;
        this.mGestures = Gestures.getInstance(uiDevice);
        this.mGestureController = GestureController.getInstance(uiDevice);
        this.mDisplayMetrics = this.mDevice.getInstrumentation().getContext().getResources().getDisplayMetrics();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        try {
            return getAccessibilityNodeInfo().equals(((UiObject2) obj).getAccessibilityNodeInfo());
        } catch (StaleObjectException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getAccessibilityNodeInfo().hashCode();
    }

    public void recycle() {
        this.mCachedNode.recycle();
        this.mCachedNode = null;
    }

    public void setGestureMargin(int i) {
        setGestureMargins(i, i, i, i);
    }

    public void setGestureMargins(int i, int i2, int i3, int i4) {
        this.mMarginLeft = i;
        this.mMarginTop = i2;
        this.mMarginRight = i3;
        this.mMarginBottom = i4;
    }

    public <R> R wait(UiObject2Condition<R> uiObject2Condition, long j) {
        return (R) this.mWaitMixin.wait(uiObject2Condition, j);
    }

    public <R> R wait(SearchCondition<R> searchCondition, long j) {
        return (R) this.mWaitMixin.wait(searchCondition, j);
    }

    public UiObject2 getParent() {
        AccessibilityNodeInfo parent = getAccessibilityNodeInfo().getParent();
        if (parent != null) {
            return new UiObject2(getDevice(), this.mSelector, parent);
        }
        return null;
    }

    public int getChildCount() {
        return getAccessibilityNodeInfo().getChildCount();
    }

    public List<UiObject2> getChildren() {
        return findObjects(By.depth(1));
    }

    @Override // androidx.test.uiautomator.Searchable
    public boolean hasObject(BySelector bySelector) {
        AccessibilityNodeInfo accessibilityNodeInfoFindMatch = ByMatcher.findMatch(getDevice(), bySelector, getAccessibilityNodeInfo());
        if (accessibilityNodeInfoFindMatch == null) {
            return false;
        }
        accessibilityNodeInfoFindMatch.recycle();
        return true;
    }

    @Override // androidx.test.uiautomator.Searchable
    public UiObject2 findObject(BySelector bySelector) {
        AccessibilityNodeInfo accessibilityNodeInfoFindMatch = ByMatcher.findMatch(getDevice(), bySelector, getAccessibilityNodeInfo());
        if (accessibilityNodeInfoFindMatch != null) {
            return new UiObject2(getDevice(), bySelector, accessibilityNodeInfoFindMatch);
        }
        return null;
    }

    @Override // androidx.test.uiautomator.Searchable
    public List<UiObject2> findObjects(BySelector bySelector) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ByMatcher.findMatches(getDevice(), bySelector, getAccessibilityNodeInfo()).iterator();
        while (it.hasNext()) {
            arrayList.add(new UiObject2(getDevice(), bySelector, (AccessibilityNodeInfo) it.next()));
        }
        return arrayList;
    }

    public Rect getVisibleBounds() {
        return getVisibleBounds(getAccessibilityNodeInfo());
    }

    private Rect getVisibleBoundsForGestures() {
        Rect visibleBounds = getVisibleBounds();
        visibleBounds.left += this.mMarginLeft;
        visibleBounds.top += this.mMarginTop;
        visibleBounds.right -= this.mMarginRight;
        visibleBounds.bottom -= this.mMarginBottom;
        return visibleBounds;
    }

    private Rect getVisibleBounds(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        rect.intersect(new Rect(0, 0, getDevice().getDisplayWidth(), getDevice().getDisplayHeight()));
        if (UiDevice.API_LEVEL_ACTUAL >= 21) {
            Rect rect2 = new Rect();
            if (accessibilityNodeInfo.getWindow() != null) {
                accessibilityNodeInfo.getWindow().getBoundsInScreen(rect2);
                rect.intersect(rect2);
            }
        }
        while (true) {
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
            if (accessibilityNodeInfo == null) {
                break;
            }
            if (accessibilityNodeInfo.isScrollable()) {
                rect.intersect(getVisibleBounds(accessibilityNodeInfo));
                break;
            }
        }
        return rect;
    }

    public Point getVisibleCenter() {
        Rect visibleBounds = getVisibleBounds();
        return new Point(visibleBounds.centerX(), visibleBounds.centerY());
    }

    public String getClassName() {
        CharSequence className = getAccessibilityNodeInfo().getClassName();
        if (className != null) {
            return className.toString();
        }
        return null;
    }

    public String getContentDescription() {
        CharSequence contentDescription = getAccessibilityNodeInfo().getContentDescription();
        if (contentDescription != null) {
            return contentDescription.toString();
        }
        return null;
    }

    public String getApplicationPackage() {
        CharSequence packageName = getAccessibilityNodeInfo().getPackageName();
        if (packageName != null) {
            return packageName.toString();
        }
        return null;
    }

    public String getResourceName() {
        String viewIdResourceName = getAccessibilityNodeInfo().getViewIdResourceName();
        if (viewIdResourceName != null) {
            return viewIdResourceName.toString();
        }
        return null;
    }

    public String getText() {
        CharSequence text = getAccessibilityNodeInfo().getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public boolean isCheckable() {
        return getAccessibilityNodeInfo().isCheckable();
    }

    public boolean isChecked() {
        return getAccessibilityNodeInfo().isChecked();
    }

    public boolean isClickable() {
        return getAccessibilityNodeInfo().isClickable();
    }

    public boolean isEnabled() {
        return getAccessibilityNodeInfo().isEnabled();
    }

    public boolean isFocusable() {
        return getAccessibilityNodeInfo().isFocusable();
    }

    public boolean isFocused() {
        return getAccessibilityNodeInfo().isFocused();
    }

    public boolean isLongClickable() {
        return getAccessibilityNodeInfo().isLongClickable();
    }

    public boolean isScrollable() {
        return getAccessibilityNodeInfo().isScrollable();
    }

    public boolean isSelected() {
        return getAccessibilityNodeInfo().isSelected();
    }

    public void clear() {
        setText("");
    }

    public void click() {
        this.mGestureController.performGesture(this.mGestures.click(getVisibleCenter()));
    }

    public void click(long j) {
        this.mGestureController.performGesture(this.mGestures.click(getVisibleCenter(), j));
    }

    public <R> R clickAndWait(EventCondition<R> eventCondition, long j) {
        return (R) this.mGestureController.performGestureAndWait(eventCondition, j, this.mGestures.click(getVisibleCenter()));
    }

    public void drag(Point point) {
        drag(point, (int) (this.mDisplayMetrics.density * 2500.0f));
    }

    public void drag(Point point, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.mGestureController.performGesture(this.mGestures.drag(getVisibleCenter(), point, i));
    }

    public void longClick() {
        this.mGestureController.performGesture(this.mGestures.longClick(getVisibleCenter()));
    }

    public void pinchClose(float f) {
        pinchClose(f, (int) (this.mDisplayMetrics.density * 2500.0f));
    }

    public void pinchClose(float f, int i) {
        if (f < BitmapDescriptorFactory.HUE_RED || f > 1.0f) {
            throw new IllegalArgumentException("Percent must be between 0.0f and 1.0f");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.mGestureController.performGesture(this.mGestures.pinchClose(getVisibleBoundsForGestures(), f, i));
    }

    public void pinchOpen(float f) {
        pinchOpen(f, (int) (this.mDisplayMetrics.density * 2500.0f));
    }

    public void pinchOpen(float f, int i) {
        if (f < BitmapDescriptorFactory.HUE_RED || f > 1.0f) {
            throw new IllegalArgumentException("Percent must be between 0.0f and 1.0f");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.mGestureController.performGesture(this.mGestures.pinchOpen(getVisibleBoundsForGestures(), f, i));
    }

    public void swipe(Direction direction, float f) {
        swipe(direction, f, (int) (this.mDisplayMetrics.density * 5000.0f));
    }

    public void swipe(Direction direction, float f, int i) {
        if (f < BitmapDescriptorFactory.HUE_RED || f > 1.0f) {
            throw new IllegalArgumentException("Percent must be between 0.0f and 1.0f");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.mGestureController.performGesture(this.mGestures.swipeRect(getVisibleBoundsForGestures(), direction, f, i));
    }

    public boolean scroll(Direction direction, float f) {
        return scroll(direction, f, (int) (this.mDisplayMetrics.density * 5000.0f));
    }

    public boolean scroll(Direction direction, float f, int i) {
        if (f < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Percent must be greater than 0.0f");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        Direction directionReverse = Direction.reverse(direction);
        Rect visibleBoundsForGestures = getVisibleBoundsForGestures();
        while (f > BitmapDescriptorFactory.HUE_RED) {
            if (((Boolean) this.mGestureController.performGestureAndWait(Until.scrollFinished(direction), 1000L, this.mGestures.swipeRect(visibleBoundsForGestures, directionReverse, f > 1.0f ? 1.0f : f, i).pause(250L))).booleanValue()) {
                return false;
            }
            f -= 1.0f;
        }
        return true;
    }

    public boolean fling(Direction direction) {
        return fling(direction, (int) (this.mDisplayMetrics.density * 7500.0f));
    }

    public boolean fling(Direction direction, int i) {
        if (i < ViewConfiguration.get(getDevice().getInstrumentation().getContext()).getScaledMinimumFlingVelocity()) {
            throw new IllegalArgumentException("Speed is less than the minimum fling velocity");
        }
        Direction directionReverse = Direction.reverse(direction);
        return !((Boolean) this.mGestureController.performGestureAndWait(Until.scrollFinished(direction), 5000L, this.mGestures.swipeRect(getVisibleBoundsForGestures(), directionReverse, 1.0f, i))).booleanValue();
    }

    public void legacySetText(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = getAccessibilityNodeInfo();
        if (str == null) {
            str = "";
        }
        if (str.equals(accessibilityNodeInfo.getText())) {
            return;
        }
        InteractionController interactionController = getDevice().getInteractionController();
        Rect visibleBounds = getVisibleBounds();
        interactionController.longTapNoSync(visibleBounds.left + 20, visibleBounds.centerY());
        ((UiObject2) getDevice().wait(Until.findObject(By.descContains("Select all")), 50L)).click();
        SystemClock.sleep(250L);
        interactionController.sendKey(67, 0);
        interactionController.sendText(str);
    }

    public void setText(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = getAccessibilityNodeInfo();
        if (str == null) {
            str = "";
        }
        if (UiDevice.API_LEVEL_ACTUAL > 19) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
            if (accessibilityNodeInfo.performAction(2097152, bundle)) {
                return;
            }
            Log.w(TAG, "AccessibilityNodeInfo#performAction(ACTION_SET_TEXT) failed");
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (str.equals(text)) {
            return;
        }
        if (!accessibilityNodeInfo.performAction(1) && !accessibilityNodeInfo.isFocused()) {
            Log.w(TAG, "AccessibilityNodeInfo#performAction(ACTION_FOCUS) failed");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, 0);
        bundle2.putInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, str.length());
        if (!accessibilityNodeInfo.performAction(131072, bundle2) && text != null && text.length() > 0) {
            Log.w(TAG, "AccessibilityNodeInfo#performAction(ACTION_SET_SELECTION) failed");
        }
        InteractionController interactionController = getDevice().getInteractionController();
        interactionController.sendKey(67, 0);
        interactionController.sendText(str);
    }

    private AccessibilityNodeInfo getAccessibilityNodeInfo() {
        if (this.mCachedNode == null) {
            throw new IllegalStateException("This object has already been recycled");
        }
        getDevice().waitForIdle();
        if (!this.mCachedNode.refresh()) {
            getDevice().runWatchers();
            if (!this.mCachedNode.refresh()) {
                throw new StaleObjectException();
            }
        }
        return this.mCachedNode;
    }

    UiDevice getDevice() {
        return this.mDevice;
    }
}
