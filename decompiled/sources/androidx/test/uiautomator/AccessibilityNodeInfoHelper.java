package androidx.test.uiautomator;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes2.dex */
abstract class AccessibilityNodeInfoHelper {
    static Rect getVisibleBoundsInScreen(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        Rect rect2 = new Rect();
        rect2.top = 0;
        rect2.left = 0;
        rect2.right = i;
        rect2.bottom = i2;
        rect.intersect(rect2);
        if (UiDevice.API_LEVEL_ACTUAL >= 21) {
            Rect rect3 = new Rect();
            if (accessibilityNodeInfo.getWindow() != null) {
                accessibilityNodeInfo.getWindow().getBoundsInScreen(rect3);
                rect.intersect(rect3);
            }
        }
        return rect;
    }
}
