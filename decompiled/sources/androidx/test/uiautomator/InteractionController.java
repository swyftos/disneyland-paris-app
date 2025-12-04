package androidx.test.uiautomator;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.Context;
import android.graphics.Point;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.InputDeviceCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
class InteractionController {
    private static final boolean DEBUG = Log.isLoggable(InteractionController.class.getSimpleName(), 3);
    private static final String LOG_TAG = "InteractionController";
    private long mDownTime;
    private final Instrumentation mInstrumentation;
    private final KeyCharacterMap mKeyCharacterMap = KeyCharacterMap.load(-1);

    private int getPointerAction(int i, int i2) {
        return i + (i2 << 8);
    }

    public InteractionController(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
    }

    class WaitForAnyEventPredicate implements UiAutomation.AccessibilityEventFilter {
        int mMask;

        WaitForAnyEventPredicate(int i) {
            this.mMask = i;
        }

        @Override // android.app.UiAutomation.AccessibilityEventFilter
        public boolean accept(AccessibilityEvent accessibilityEvent) {
            return (this.mMask & accessibilityEvent.getEventType()) != 0;
        }
    }

    class EventCollectingPredicate implements UiAutomation.AccessibilityEventFilter {
        List mEventsList;
        int mMask;

        EventCollectingPredicate(int i, List list) {
            this.mMask = i;
            this.mEventsList = list;
        }

        @Override // android.app.UiAutomation.AccessibilityEventFilter
        public boolean accept(AccessibilityEvent accessibilityEvent) {
            if ((accessibilityEvent.getEventType() & this.mMask) == 0) {
                return false;
            }
            this.mEventsList.add(AccessibilityEvent.obtain(accessibilityEvent));
            return false;
        }
    }

    class WaitForAllEventPredicate implements UiAutomation.AccessibilityEventFilter {
        int mMask;

        WaitForAllEventPredicate(int i) {
            this.mMask = i;
        }

        @Override // android.app.UiAutomation.AccessibilityEventFilter
        public boolean accept(AccessibilityEvent accessibilityEvent) {
            int eventType = accessibilityEvent.getEventType();
            int i = this.mMask;
            if ((eventType & i) == 0) {
                return false;
            }
            int i2 = (~accessibilityEvent.getEventType()) & i;
            this.mMask = i2;
            return i2 == 0;
        }
    }

    private AccessibilityEvent runAndWaitForEvents(Runnable runnable, UiAutomation.AccessibilityEventFilter accessibilityEventFilter, long j) {
        try {
            return getUiAutomation().executeAndWaitForEvent(runnable, accessibilityEventFilter, j);
        } catch (TimeoutException unused) {
            Log.w(LOG_TAG, "runAndwaitForEvents timed out waiting for events");
            return null;
        } catch (Exception e) {
            Log.e(LOG_TAG, "exception from executeCommandAndWaitForAccessibilityEvent", e);
            return null;
        }
    }

    public boolean sendKeyAndWaitForEvent(final int i, final int i2, int i3, long j) {
        return runAndWaitForEvents(new Runnable() { // from class: androidx.test.uiautomator.InteractionController.1
            @Override // java.lang.Runnable
            public void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (InteractionController.this.injectEventSync(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, i, 0, i2, -1, 0, 0, 257))) {
                    InteractionController.this.injectEventSync(new KeyEvent(jUptimeMillis, jUptimeMillis, 1, i, 0, i2, -1, 0, 0, 257));
                }
            }
        }, new WaitForAnyEventPredicate(i3), j) != null;
    }

    public boolean clickNoSync(int i, int i2) {
        Log.d(LOG_TAG, "clickNoSync (" + i + ", " + i2 + ")");
        if (!touchDown(i, i2)) {
            return false;
        }
        SystemClock.sleep(100L);
        return touchUp(i, i2);
    }

    public boolean clickAndSync(int i, int i2, long j) {
        Log.d(LOG_TAG, String.format("clickAndSync(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2)));
        return runAndWaitForEvents(clickRunnable(i, i2), new WaitForAnyEventPredicate(2052), j) != null;
    }

    public boolean clickAndWaitForNewWindow(int i, int i2, long j) {
        Log.d(LOG_TAG, String.format("clickAndWaitForNewWindow(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2)));
        return runAndWaitForEvents(clickRunnable(i, i2), new WaitForAllEventPredicate(2080), j) != null;
    }

    private Runnable clickRunnable(final int i, final int i2) {
        return new Runnable() { // from class: androidx.test.uiautomator.InteractionController.2
            @Override // java.lang.Runnable
            public void run() {
                if (InteractionController.this.touchDown(i, i2)) {
                    SystemClock.sleep(100L);
                    InteractionController.this.touchUp(i, i2);
                }
            }
        };
    }

    private Runnable longTapRunnable(final int i, final int i2) {
        return new Runnable() { // from class: androidx.test.uiautomator.InteractionController.3
            @Override // java.lang.Runnable
            public void run() {
                if (InteractionController.this.touchDown(i, i2)) {
                    SystemClock.sleep(ViewConfiguration.getLongPressTimeout());
                    InteractionController.this.touchUp(i, i2);
                }
            }
        };
    }

    public boolean longTapNoSync(int i, int i2) {
        if (DEBUG) {
            Log.d(LOG_TAG, "longTapNoSync (" + i + ", " + i2 + ")");
        }
        if (!touchDown(i, i2)) {
            return false;
        }
        SystemClock.sleep(ViewConfiguration.getLongPressTimeout());
        return touchUp(i, i2);
    }

    public boolean longTapAndSync(int i, int i2, long j) {
        Log.d(LOG_TAG, String.format("clickAndSync(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2)));
        return runAndWaitForEvents(longTapRunnable(i, i2), new WaitForAnyEventPredicate(2052), j) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean touchDown(int i, int i2) {
        if (DEBUG) {
            Log.d(LOG_TAG, "touchDown (" + i + ", " + i2 + ")");
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.mDownTime = jUptimeMillis;
        return injectEventSync(getMotionEvent(jUptimeMillis, jUptimeMillis, 0, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean touchUp(int i, int i2) {
        if (DEBUG) {
            Log.d(LOG_TAG, "touchUp (" + i + ", " + i2 + ")");
        }
        MotionEvent motionEvent = getMotionEvent(this.mDownTime, SystemClock.uptimeMillis(), 1, i, i2);
        this.mDownTime = 0L;
        return injectEventSync(motionEvent);
    }

    private boolean touchMove(int i, int i2) {
        if (DEBUG) {
            Log.d(LOG_TAG, "touchMove (" + i + ", " + i2 + ")");
        }
        return injectEventSync(getMotionEvent(this.mDownTime, SystemClock.uptimeMillis(), 2, i, i2));
    }

    public boolean scrollSwipe(final int i, final int i2, final int i3, final int i4, final int i5) {
        String str = LOG_TAG;
        Log.d(str, "scrollSwipe (" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ")");
        Runnable runnable = new Runnable() { // from class: androidx.test.uiautomator.InteractionController.4
            @Override // java.lang.Runnable
            public void run() {
                InteractionController.this.swipe(i, i2, i3, i4, i5);
            }
        };
        ArrayList arrayList = new ArrayList();
        runAndWaitForEvents(runnable, new EventCollectingPredicate(4096, arrayList), Configurator.getInstance().getScrollAcknowledgmentTimeout());
        AccessibilityEvent lastMatchingEvent = getLastMatchingEvent(arrayList, 4096);
        if (lastMatchingEvent == null) {
            recycleAccessibilityEvents(arrayList);
            return false;
        }
        if (lastMatchingEvent.getFromIndex() != -1 && lastMatchingEvent.getToIndex() != -1 && lastMatchingEvent.getItemCount() != -1) {
            z = lastMatchingEvent.getFromIndex() == 0 || lastMatchingEvent.getItemCount() - 1 == lastMatchingEvent.getToIndex();
            Log.d(str, "scrollSwipe reached scroll end: " + z);
        } else if (lastMatchingEvent.getScrollX() != -1 && lastMatchingEvent.getScrollY() != -1) {
            if (i == i3) {
                z = lastMatchingEvent.getScrollY() == 0 || lastMatchingEvent.getScrollY() == lastMatchingEvent.getMaxScrollY();
                Log.d(str, "Vertical scrollSwipe reached scroll end: " + z);
            } else if (i2 == i4) {
                z = lastMatchingEvent.getScrollX() == 0 || lastMatchingEvent.getScrollX() == lastMatchingEvent.getMaxScrollX();
                Log.d(str, "Horizontal scrollSwipe reached scroll end: " + z);
            }
        }
        recycleAccessibilityEvents(arrayList);
        return !z;
    }

    private AccessibilityEvent getLastMatchingEvent(List list, int i) {
        for (int size = list.size(); size > 0; size--) {
            AccessibilityEvent accessibilityEvent = (AccessibilityEvent) list.get(size - 1);
            if (accessibilityEvent.getEventType() == i) {
                return accessibilityEvent;
            }
        }
        return null;
    }

    private void recycleAccessibilityEvents(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AccessibilityEvent) it.next()).recycle();
        }
        list.clear();
    }

    public boolean swipe(int i, int i2, int i3, int i4, int i5) {
        return swipe(i, i2, i3, i4, i5, false);
    }

    public boolean swipe(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i5 == 0 ? 1 : i5;
        double d = i6;
        double d2 = (i3 - i) / d;
        double d3 = (i4 - i2) / d;
        boolean z2 = touchDown(i, i2);
        if (z) {
            SystemClock.sleep(ViewConfiguration.getLongPressTimeout());
        }
        for (int i7 = 1; i7 < i6; i7++) {
            double d4 = i7;
            z2 &= touchMove(i + ((int) (d2 * d4)), i2 + ((int) (d4 * d3)));
            if (!z2) {
                break;
            }
            SystemClock.sleep(5L);
        }
        if (z) {
            SystemClock.sleep(100L);
        }
        return touchUp(i3, i4) & z2;
    }

    public boolean swipe(Point[] pointArr, int i) {
        int i2;
        int i3;
        int i4 = i == 0 ? 1 : i;
        int i5 = 0;
        if (pointArr.length == 0) {
            return false;
        }
        Point point = pointArr[0];
        boolean z = touchDown(point.x, point.y);
        while (i5 < pointArr.length) {
            int i6 = i5 + 1;
            if (i6 < pointArr.length) {
                int i7 = pointArr[i6].x;
                Point point2 = pointArr[i5];
                double d = i4;
                double d2 = (i7 - point2.x) / d;
                double d3 = (r8.y - point2.y) / d;
                int i8 = 1;
                while (i8 < i) {
                    Point point3 = pointArr[i5];
                    i2 = i4;
                    double d4 = i8;
                    int i9 = i5;
                    i3 = i6;
                    z &= touchMove(point3.x + ((int) (d2 * d4)), point3.y + ((int) (d4 * d3)));
                    if (!z) {
                        break;
                    }
                    SystemClock.sleep(5L);
                    i8++;
                    i4 = i2;
                    i5 = i9;
                    i6 = i3;
                }
                i2 = i4;
                i3 = i6;
            } else {
                i2 = i4;
                i3 = i6;
            }
            i4 = i2;
            i5 = i3;
        }
        return touchUp(pointArr[pointArr.length - 1].x, pointArr[pointArr.length - 1].y) & z;
    }

    public boolean sendText(String str) {
        if (DEBUG) {
            Log.d(LOG_TAG, "sendText (" + str + ")");
        }
        KeyEvent[] events = this.mKeyCharacterMap.getEvents(str.toCharArray());
        if (events == null) {
            return true;
        }
        long keyInjectionDelay = Configurator.getInstance().getKeyInjectionDelay();
        for (KeyEvent keyEvent : events) {
            if (!injectEventSync(KeyEvent.changeTimeRepeat(keyEvent, SystemClock.uptimeMillis(), 0))) {
                return false;
            }
            SystemClock.sleep(keyInjectionDelay);
        }
        return true;
    }

    public boolean sendKey(int i, int i2) {
        if (DEBUG) {
            Log.d(LOG_TAG, "sendKey (" + i + ", " + i2 + ")");
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        return injectEventSync(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, i, 0, i2, -1, 0, 0, 257)) && injectEventSync(new KeyEvent(jUptimeMillis, jUptimeMillis, 1, i, 0, i2, -1, 0, 0, 257));
    }

    public void setRotationRight() {
        getUiAutomation().setRotation(3);
    }

    public void setRotationLeft() {
        getUiAutomation().setRotation(1);
    }

    public void setRotationNatural() {
        getUiAutomation().setRotation(0);
    }

    public void freezeRotation() {
        getUiAutomation().setRotation(-1);
    }

    public void unfreezeRotation() {
        getUiAutomation().setRotation(-2);
    }

    public boolean wakeDevice() {
        if (isScreenOn()) {
            return false;
        }
        sendKey(26, 0);
        return true;
    }

    public boolean sleepDevice() {
        if (!isScreenOn()) {
            return false;
        }
        sendKey(26, 0);
        return true;
    }

    public boolean isScreenOn() {
        return ((PowerManager) getContext().getSystemService("power")).isScreenOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean injectEventSync(InputEvent inputEvent) {
        return getUiAutomation().injectInputEvent(inputEvent, true);
    }

    public boolean performMultiPointerGesture(MotionEvent.PointerCoords[]... pointerCoordsArr) {
        if (pointerCoordsArr.length < 2) {
            throw new IllegalArgumentException("Must provide coordinates for at least 2 pointers");
        }
        int length = 0;
        for (MotionEvent.PointerCoords[] pointerCoordsArr2 : pointerCoordsArr) {
            if (length < pointerCoordsArr2.length) {
                length = pointerCoordsArr2.length;
            }
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCoordsArr.length];
        MotionEvent.PointerCoords[] pointerCoordsArr3 = new MotionEvent.PointerCoords[pointerCoordsArr.length];
        for (int i = 0; i < pointerCoordsArr.length; i++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = i;
            pointerProperties.toolType = Configurator.getInstance().getToolType();
            pointerPropertiesArr[i] = pointerProperties;
            pointerCoordsArr3[i] = pointerCoordsArr[i][0];
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean zInjectEventSync = injectEventSync(MotionEvent.obtain(jUptimeMillis, SystemClock.uptimeMillis(), 0, 1, pointerPropertiesArr, pointerCoordsArr3, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0));
        int i2 = 1;
        while (i2 < pointerCoordsArr.length) {
            int i3 = i2 + 1;
            zInjectEventSync &= injectEventSync(MotionEvent.obtain(jUptimeMillis, SystemClock.uptimeMillis(), getPointerAction(5, i2), i3, pointerPropertiesArr, pointerCoordsArr3, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0));
            i2 = i3;
        }
        for (int i4 = 1; i4 < length - 1; i4++) {
            for (int i5 = 0; i5 < pointerCoordsArr.length; i5++) {
                MotionEvent.PointerCoords[] pointerCoordsArr4 = pointerCoordsArr[i5];
                if (pointerCoordsArr4.length > i4) {
                    pointerCoordsArr3[i5] = pointerCoordsArr4[i4];
                } else {
                    pointerCoordsArr3[i5] = pointerCoordsArr4[pointerCoordsArr4.length - 1];
                }
            }
            zInjectEventSync &= injectEventSync(MotionEvent.obtain(jUptimeMillis, SystemClock.uptimeMillis(), 2, pointerCoordsArr.length, pointerPropertiesArr, pointerCoordsArr3, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0));
            SystemClock.sleep(5L);
        }
        for (int i6 = 0; i6 < pointerCoordsArr.length; i6++) {
            pointerCoordsArr3[i6] = pointerCoordsArr[i6][r5.length - 1];
        }
        int i7 = 1;
        while (i7 < pointerCoordsArr.length) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            int pointerAction = getPointerAction(6, i7);
            i7++;
            zInjectEventSync &= injectEventSync(MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, pointerAction, i7, pointerPropertiesArr, pointerCoordsArr3, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0));
        }
        Log.i(LOG_TAG, "x " + pointerCoordsArr3[0].x);
        return zInjectEventSync & injectEventSync(MotionEvent.obtain(jUptimeMillis, SystemClock.uptimeMillis(), 1, 1, pointerPropertiesArr, pointerCoordsArr3, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0));
    }

    public boolean toggleRecentApps() {
        return getUiAutomation().performGlobalAction(3);
    }

    public boolean openNotification() {
        return getUiAutomation().performGlobalAction(4);
    }

    public boolean openQuickSettings() {
        return getUiAutomation().performGlobalAction(5);
    }

    private static MotionEvent getMotionEvent(long j, long j2, int i, float f, float f2) {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = 0;
        pointerProperties.toolType = Configurator.getInstance().getToolType();
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.pressure = 1.0f;
        pointerCoords.size = 1.0f;
        pointerCoords.x = f;
        pointerCoords.y = f2;
        return MotionEvent.obtain(j, j2, i, 1, new MotionEvent.PointerProperties[]{pointerProperties}, new MotionEvent.PointerCoords[]{pointerCoords}, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0);
    }

    UiAutomation getUiAutomation() {
        return UiDevice.getUiAutomation(getInstrumentation());
    }

    Context getContext() {
        return getInstrumentation().getContext();
    }

    Instrumentation getInstrumentation() {
        return this.mInstrumentation;
    }
}
