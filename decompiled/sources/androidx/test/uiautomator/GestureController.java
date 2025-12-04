package androidx.test.uiautomator;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
class GestureController {
    private static GestureController sInstance;
    private UiDevice mDevice;
    private static final Comparator START_TIME_COMPARATOR = new Comparator<PointerGesture>() { // from class: androidx.test.uiautomator.GestureController.1
        @Override // java.util.Comparator
        public int compare(PointerGesture pointerGesture, PointerGesture pointerGesture2) {
            return (int) (pointerGesture.delay() - pointerGesture2.delay());
        }
    };
    private static final Comparator END_TIME_COMPARATOR = new Comparator<PointerGesture>() { // from class: androidx.test.uiautomator.GestureController.2
        @Override // java.util.Comparator
        public int compare(PointerGesture pointerGesture, PointerGesture pointerGesture2) {
            return (int) ((pointerGesture.delay() + pointerGesture2.duration()) - (pointerGesture2.delay() + pointerGesture2.duration()));
        }
    };

    private GestureController(UiDevice uiDevice) {
        this.mDevice = uiDevice;
    }

    public static GestureController getInstance(UiDevice uiDevice) {
        if (sInstance == null) {
            sInstance = new GestureController(uiDevice);
        }
        return sInstance;
    }

    public Object performGestureAndWait(EventCondition eventCondition, long j, PointerGesture... pointerGestureArr) {
        return getDevice().performActionAndWait(new GestureRunnable(pointerGestureArr), eventCondition, j);
    }

    public void performGesture(PointerGesture... pointerGestureArr) {
        HashMap map = new HashMap();
        int length = pointerGestureArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            PointerGesture pointerGesture = pointerGestureArr[i];
            map.put(pointerGesture, new Pointer(i2, pointerGesture.start()));
            i++;
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        PriorityQueue priorityQueue = new PriorityQueue(pointerGestureArr.length, END_TIME_COMPARATOR);
        PriorityQueue priorityQueue2 = new PriorityQueue(pointerGestureArr.length, START_TIME_COMPARATOR);
        priorityQueue2.addAll(Arrays.asList(pointerGestureArr));
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jUptimeMillis2 = 0;
        while (true) {
            if (priorityQueue2.isEmpty() && priorityQueue.isEmpty()) {
                return;
            }
            while (!priorityQueue2.isEmpty() && jUptimeMillis2 > ((PointerGesture) priorityQueue2.peek()).delay()) {
                PointerGesture pointerGesture2 = (PointerGesture) priorityQueue2.remove();
                Pointer pointer = (Pointer) map.get(pointerGesture2);
                arrayList.add(pointer.prop);
                arrayList2.add(pointer.coords);
                getDevice().getUiAutomation().injectInputEvent(getMotionEvent(jUptimeMillis, jUptimeMillis + jUptimeMillis2, !priorityQueue.isEmpty() ? ((arrayList.size() - 1) << 8) + 5 : 0, arrayList, arrayList2), true);
                priorityQueue.add(pointerGesture2);
                jUptimeMillis2 = jUptimeMillis2;
                priorityQueue2 = priorityQueue2;
                jUptimeMillis = jUptimeMillis;
            }
            PriorityQueue priorityQueue3 = priorityQueue2;
            long j = jUptimeMillis;
            long j2 = jUptimeMillis2;
            while (!priorityQueue.isEmpty() && j2 > ((PointerGesture) priorityQueue.peek()).delay() + ((PointerGesture) priorityQueue.peek()).duration()) {
                PointerGesture pointerGesture3 = (PointerGesture) priorityQueue.remove();
                Pointer pointer2 = (Pointer) map.get(pointerGesture3);
                pointer2.updatePosition(pointerGesture3.end());
                Iterator it = priorityQueue.iterator();
                while (it.hasNext()) {
                    PointerGesture pointerGesture4 = (PointerGesture) it.next();
                    ((Pointer) map.get(pointerGesture4)).updatePosition(pointerGesture4.pointAt(j2));
                }
                int iIndexOf = arrayList.indexOf(pointer2.prop);
                getDevice().getUiAutomation().injectInputEvent(getMotionEvent(j, j + j2, !priorityQueue.isEmpty() ? (iIndexOf << 8) + 6 : 1, arrayList, arrayList2), true);
                arrayList.remove(iIndexOf);
                arrayList2.remove(iIndexOf);
            }
            Iterator it2 = priorityQueue.iterator();
            while (it2.hasNext()) {
                PointerGesture pointerGesture5 = (PointerGesture) it2.next();
                ((Pointer) map.get(pointerGesture5)).updatePosition(pointerGesture5.pointAt(j2 - pointerGesture5.delay()));
            }
            if (!priorityQueue.isEmpty()) {
                getDevice().getUiAutomation().injectInputEvent(getMotionEvent(j, j + j2, 2, arrayList, arrayList2), true);
            }
            jUptimeMillis2 = SystemClock.uptimeMillis() - j;
            priorityQueue2 = priorityQueue3;
            jUptimeMillis = j;
        }
    }

    private static MotionEvent getMotionEvent(long j, long j2, int i, List list, List list2) {
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) list.toArray(new MotionEvent.PointerProperties[list.size()]);
        return MotionEvent.obtain(j, j2, i, pointerPropertiesArr.length, pointerPropertiesArr, (MotionEvent.PointerCoords[]) list2.toArray(new MotionEvent.PointerCoords[list2.size()]), 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0);
    }

    private static class Pointer {
        MotionEvent.PointerCoords coords;
        MotionEvent.PointerProperties prop;

        public Pointer(int i, Point point) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            this.prop = pointerProperties;
            pointerProperties.id = i;
            pointerProperties.toolType = Configurator.getInstance().getToolType();
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            this.coords = pointerCoords;
            pointerCoords.pressure = 1.0f;
            pointerCoords.size = 1.0f;
            pointerCoords.x = point.x;
            pointerCoords.y = point.y;
        }

        public void updatePosition(Point point) {
            MotionEvent.PointerCoords pointerCoords = this.coords;
            pointerCoords.x = point.x;
            pointerCoords.y = point.y;
        }
    }

    private class GestureRunnable implements Runnable {
        private PointerGesture[] mGestures;

        public GestureRunnable(PointerGesture[] pointerGestureArr) {
            this.mGestures = pointerGestureArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            GestureController.this.performGesture(this.mGestures);
        }
    }

    UiDevice getDevice() {
        return this.mDevice;
    }
}
