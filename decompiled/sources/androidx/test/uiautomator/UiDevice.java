package androidx.test.uiautomator;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class UiDevice implements Searchable {
    static final int API_LEVEL_ACTUAL = Build.VERSION.SDK_INT + (!"REL".equals(Build.VERSION.CODENAME) ? 1 : 0);
    private static final String LOG_TAG = "UiDevice";
    private static UiDevice sInstance;
    private Instrumentation mInstrumentation;
    private InteractionController mInteractionController;
    private QueryController mQueryController;
    private final HashMap mWatchers = new HashMap();
    private final List mWatchersTriggers = new ArrayList();
    private boolean mInWatcherContext = false;
    private WaitMixin mWaitMixin = new WaitMixin(this);

    UiDevice(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
        this.mQueryController = new QueryController(instrumentation);
        this.mInteractionController = new InteractionController(instrumentation);
        if (API_LEVEL_ACTUAL >= 21) {
            AccessibilityServiceInfo serviceInfo = getUiAutomation().getServiceInfo();
            serviceInfo.flags |= 64;
            getUiAutomation().setServiceInfo(serviceInfo);
        }
    }

    public UiObject findObject(UiSelector uiSelector) {
        return new UiObject(this, uiSelector);
    }

    @Override // androidx.test.uiautomator.Searchable
    public boolean hasObject(BySelector bySelector) {
        AccessibilityNodeInfo accessibilityNodeInfoFindMatch = ByMatcher.findMatch(this, bySelector, getWindowRoots());
        if (accessibilityNodeInfoFindMatch == null) {
            return false;
        }
        accessibilityNodeInfoFindMatch.recycle();
        return true;
    }

    @Override // androidx.test.uiautomator.Searchable
    public UiObject2 findObject(BySelector bySelector) {
        AccessibilityNodeInfo accessibilityNodeInfoFindMatch = ByMatcher.findMatch(this, bySelector, getWindowRoots());
        if (accessibilityNodeInfoFindMatch != null) {
            return new UiObject2(this, bySelector, accessibilityNodeInfoFindMatch);
        }
        return null;
    }

    @Override // androidx.test.uiautomator.Searchable
    public List<UiObject2> findObjects(BySelector bySelector) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ByMatcher.findMatches(this, bySelector, getWindowRoots()).iterator();
        while (it.hasNext()) {
            arrayList.add(new UiObject2(this, bySelector, (AccessibilityNodeInfo) it.next()));
        }
        return arrayList;
    }

    public <R> R wait(SearchCondition<R> searchCondition, long j) {
        return (R) this.mWaitMixin.wait(searchCondition, j);
    }

    public <R> R performActionAndWait(Runnable runnable, EventCondition<R> eventCondition, long j) throws TimeoutException {
        AccessibilityEvent accessibilityEventExecuteAndWaitForEvent;
        try {
            accessibilityEventExecuteAndWaitForEvent = getUiAutomation().executeAndWaitForEvent(runnable, new EventForwardingFilter(eventCondition), j);
        } catch (TimeoutException unused) {
            accessibilityEventExecuteAndWaitForEvent = null;
        }
        if (accessibilityEventExecuteAndWaitForEvent != null) {
            accessibilityEventExecuteAndWaitForEvent.recycle();
        }
        return (R) eventCondition.getResult();
    }

    private static class EventForwardingFilter implements UiAutomation.AccessibilityEventFilter {
        private EventCondition mCondition;

        public EventForwardingFilter(EventCondition eventCondition) {
            this.mCondition = eventCondition;
        }

        @Override // android.app.UiAutomation.AccessibilityEventFilter
        public boolean accept(AccessibilityEvent accessibilityEvent) {
            return Boolean.TRUE.equals(this.mCondition.apply(accessibilityEvent));
        }
    }

    public void setCompressedLayoutHeirarchy(boolean z) {
        AccessibilityServiceInfo serviceInfo = getUiAutomation().getServiceInfo();
        if (z) {
            serviceInfo.flags &= -3;
        } else {
            serviceInfo.flags |= 2;
        }
        getUiAutomation().setServiceInfo(serviceInfo);
    }

    @Deprecated
    public static UiDevice getInstance() {
        UiDevice uiDevice = sInstance;
        if (uiDevice != null) {
            return uiDevice;
        }
        throw new IllegalStateException("UiDevice singleton not initialized");
    }

    public static UiDevice getInstance(Instrumentation instrumentation) {
        if (sInstance == null) {
            sInstance = new UiDevice(instrumentation);
        }
        return sInstance;
    }

    public Point getDisplaySizeDp() {
        Tracer.trace(new Object[0]);
        Display defaultDisplay = getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        float f = point.x;
        float f2 = displayMetrics.density;
        point.x = Math.round(f / f2);
        point.y = Math.round(point.y / f2);
        return point;
    }

    public String getProductName() {
        Tracer.trace(new Object[0]);
        return Build.PRODUCT;
    }

    public String getLastTraversedText() {
        Tracer.trace(new Object[0]);
        return getQueryController().getLastTraversedText();
    }

    public void clearLastTraversedText() {
        Tracer.trace(new Object[0]);
        getQueryController().clearLastTraversedText();
    }

    public boolean pressMenu() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getInteractionController().sendKeyAndWaitForEvent(82, 0, 2048, 1000L);
    }

    public boolean pressBack() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getInteractionController().sendKeyAndWaitForEvent(4, 0, 2048, 1000L);
    }

    public boolean pressHome() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getInteractionController().sendKeyAndWaitForEvent(3, 0, 2048, 1000L);
    }

    public boolean pressSearch() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(84);
    }

    public boolean pressDPadCenter() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(23);
    }

    public boolean pressDPadDown() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(20);
    }

    public boolean pressDPadUp() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(19);
    }

    public boolean pressDPadLeft() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(21);
    }

    public boolean pressDPadRight() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(22);
    }

    public boolean pressDelete() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(67);
    }

    public boolean pressEnter() {
        Tracer.trace(new Object[0]);
        return pressKeyCode(66);
    }

    public boolean pressKeyCode(int i) {
        Tracer.trace(Integer.valueOf(i));
        waitForIdle();
        return getInteractionController().sendKey(i, 0);
    }

    public boolean pressKeyCode(int i, int i2) {
        Tracer.trace(Integer.valueOf(i), Integer.valueOf(i2));
        waitForIdle();
        return getInteractionController().sendKey(i, i2);
    }

    public boolean pressRecentApps() throws RemoteException {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getInteractionController().toggleRecentApps();
    }

    public boolean openNotification() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getInteractionController().openNotification();
    }

    public boolean openQuickSettings() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getInteractionController().openQuickSettings();
    }

    public int getDisplayWidth() {
        Tracer.trace(new Object[0]);
        Display defaultDisplay = getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public int getDisplayHeight() {
        Tracer.trace(new Object[0]);
        Display defaultDisplay = getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public boolean click(int i, int i2) {
        Tracer.trace(Integer.valueOf(i), Integer.valueOf(i2));
        if (i >= getDisplayWidth() || i2 >= getDisplayHeight()) {
            return false;
        }
        return getInteractionController().clickNoSync(i, i2);
    }

    public boolean swipe(int i, int i2, int i3, int i4, int i5) {
        Tracer.trace(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        return getInteractionController().swipe(i, i2, i3, i4, i5);
    }

    public boolean drag(int i, int i2, int i3, int i4, int i5) {
        Tracer.trace(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        return getInteractionController().swipe(i, i2, i3, i4, i5, true);
    }

    public boolean swipe(Point[] pointArr, int i) {
        Tracer.trace(pointArr, Integer.valueOf(i));
        return getInteractionController().swipe(pointArr, i);
    }

    public void waitForIdle() {
        Tracer.trace(new Object[0]);
        getQueryController().waitForIdle();
    }

    public void waitForIdle(long j) {
        Tracer.trace(Long.valueOf(j));
        getQueryController().waitForIdle(j);
    }

    @Deprecated
    public String getCurrentActivityName() {
        Tracer.trace(new Object[0]);
        return getQueryController().getCurrentActivityName();
    }

    public String getCurrentPackageName() {
        Tracer.trace(new Object[0]);
        return getQueryController().getCurrentPackageName();
    }

    public void registerWatcher(String str, UiWatcher uiWatcher) {
        Tracer.trace(str, uiWatcher);
        if (this.mInWatcherContext) {
            throw new IllegalStateException("Cannot register new watcher from within another");
        }
        this.mWatchers.put(str, uiWatcher);
    }

    public void removeWatcher(String str) {
        Tracer.trace(str);
        if (this.mInWatcherContext) {
            throw new IllegalStateException("Cannot remove a watcher from within another");
        }
        this.mWatchers.remove(str);
    }

    public void runWatchers() {
        Tracer.trace(new Object[0]);
        if (this.mInWatcherContext) {
            return;
        }
        for (String str : this.mWatchers.keySet()) {
            UiWatcher uiWatcher = (UiWatcher) this.mWatchers.get(str);
            if (uiWatcher != null) {
                try {
                    try {
                        this.mInWatcherContext = true;
                        if (uiWatcher.checkForCondition()) {
                            setWatcherTriggered(str);
                        }
                    } catch (Exception e) {
                        Log.e(LOG_TAG, "Exceuting watcher: " + str, e);
                    }
                } finally {
                    this.mInWatcherContext = false;
                }
            }
        }
    }

    public void resetWatcherTriggers() {
        Tracer.trace(new Object[0]);
        this.mWatchersTriggers.clear();
    }

    public boolean hasWatcherTriggered(String str) {
        Tracer.trace(str);
        return this.mWatchersTriggers.contains(str);
    }

    public boolean hasAnyWatcherTriggered() {
        Tracer.trace(new Object[0]);
        return this.mWatchersTriggers.size() > 0;
    }

    private void setWatcherTriggered(String str) {
        Tracer.trace(str);
        if (hasWatcherTriggered(str)) {
            return;
        }
        this.mWatchersTriggers.add(str);
    }

    public boolean isNaturalOrientation() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        int displayRotation = getDisplayRotation();
        return displayRotation == 0 || displayRotation == 2;
    }

    public int getDisplayRotation() {
        Tracer.trace(new Object[0]);
        waitForIdle();
        return getDefaultDisplay().getRotation();
    }

    public void freezeRotation() throws RemoteException {
        Tracer.trace(new Object[0]);
        getInteractionController().freezeRotation();
    }

    public void unfreezeRotation() throws RemoteException {
        Tracer.trace(new Object[0]);
        getInteractionController().unfreezeRotation();
    }

    public void setOrientationLeft() throws RemoteException {
        Tracer.trace(new Object[0]);
        getInteractionController().setRotationLeft();
        waitForIdle();
    }

    public void setOrientationRight() throws RemoteException {
        Tracer.trace(new Object[0]);
        getInteractionController().setRotationRight();
        waitForIdle();
    }

    public void setOrientationNatural() throws RemoteException {
        Tracer.trace(new Object[0]);
        getInteractionController().setRotationNatural();
        waitForIdle();
    }

    public void wakeUp() throws RemoteException {
        Tracer.trace(new Object[0]);
        if (getInteractionController().wakeDevice()) {
            SystemClock.sleep(500L);
        }
    }

    public boolean isScreenOn() throws RemoteException {
        Tracer.trace(new Object[0]);
        return getInteractionController().isScreenOn();
    }

    public void sleep() throws RemoteException {
        Tracer.trace(new Object[0]);
        getInteractionController().sleepDevice();
    }

    @Deprecated
    public void dumpWindowHierarchy(String str) {
        Tracer.trace(str);
        File file = new File(str);
        if (!file.isAbsolute()) {
            file = this.mInstrumentation.getContext().getFileStreamPath(str);
        }
        try {
            dumpWindowHierarchy(file);
        } catch (IOException unused) {
        }
    }

    public void dumpWindowHierarchy(File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            dumpWindowHierarchy(new BufferedOutputStream(new FileOutputStream(file)));
        } finally {
            bufferedOutputStream.close();
        }
    }

    public void dumpWindowHierarchy(OutputStream outputStream) throws IOException {
        AccessibilityNodeInfoDumper.dumpWindowHierarchy(this, outputStream);
    }

    public boolean waitForWindowUpdate(final String str, long j) throws TimeoutException {
        Tracer.trace(str, Long.valueOf(j));
        if (str != null && !str.equals(getCurrentPackageName())) {
            return false;
        }
        try {
            getUiAutomation().executeAndWaitForEvent(new Runnable() { // from class: androidx.test.uiautomator.UiDevice.1
                @Override // java.lang.Runnable
                public void run() {
                }
            }, new UiAutomation.AccessibilityEventFilter() { // from class: androidx.test.uiautomator.UiDevice.2
                @Override // android.app.UiAutomation.AccessibilityEventFilter
                public boolean accept(AccessibilityEvent accessibilityEvent) {
                    if (accessibilityEvent.getEventType() != 2048) {
                        return false;
                    }
                    String str2 = str;
                    return str2 == null || str2.equals(accessibilityEvent.getPackageName());
                }
            }, j);
            return true;
        } catch (TimeoutException unused) {
            return false;
        } catch (Exception e) {
            Log.e(LOG_TAG, "waitForWindowUpdate: general exception from bridge", e);
            return false;
        }
    }

    public boolean takeScreenshot(File file) {
        Tracer.trace(file);
        return takeScreenshot(file, 1.0f, 90);
    }

    public boolean takeScreenshot(File file, float f, int i) throws Throwable {
        Tracer.trace(file, Float.valueOf(f), Integer.valueOf(i));
        Bitmap bitmapTakeScreenshot = getUiAutomation().takeScreenshot();
        if (bitmapTakeScreenshot == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmapTakeScreenshot.compress(Bitmap.CompressFormat.PNG, i, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    bitmapTakeScreenshot.recycle();
                    return true;
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    Log.e(LOG_TAG, "failed to save screen shot to file", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    bitmapTakeScreenshot.recycle();
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    bitmapTakeScreenshot.recycle();
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String getLauncherPackageName() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        return this.mInstrumentation.getContext().getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName;
    }

    public String executeShellCommand(String str) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorExecuteShellCommand = getUiAutomation().executeShellCommand(str);
        byte[] bArr = new byte[512];
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorExecuteShellCommand);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i = autoCloseInputStream.read(bArr);
            if (i != -1) {
                stringBuffer.append(new String(bArr, 0, i));
            } else {
                autoCloseInputStream.close();
                return stringBuffer.toString();
            }
        }
    }

    private Display getDefaultDisplay() {
        return ((WindowManager) getInstrumentation().getContext().getSystemService("window")).getDefaultDisplay();
    }

    AccessibilityNodeInfo[] getWindowRoots() {
        waitForIdle();
        HashSet hashSet = new HashSet();
        AccessibilityNodeInfo rootInActiveWindow = getUiAutomation().getRootInActiveWindow();
        if (rootInActiveWindow != null) {
            hashSet.add(rootInActiveWindow);
        }
        if (API_LEVEL_ACTUAL >= 21) {
            for (AccessibilityWindowInfo accessibilityWindowInfo : getUiAutomation().getWindows()) {
                AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                if (root == null) {
                    Log.w(LOG_TAG, String.format("Skipping null root node for window: %s", accessibilityWindowInfo.toString()));
                } else {
                    hashSet.add(root);
                }
            }
        }
        return (AccessibilityNodeInfo[]) hashSet.toArray(new AccessibilityNodeInfo[hashSet.size()]);
    }

    Instrumentation getInstrumentation() {
        return this.mInstrumentation;
    }

    static UiAutomation getUiAutomation(Instrumentation instrumentation) {
        int uiAutomationFlags = Configurator.getInstance().getUiAutomationFlags();
        if (API_LEVEL_ACTUAL > 23) {
            return instrumentation.getUiAutomation(uiAutomationFlags);
        }
        if (uiAutomationFlags != 0) {
            Log.w(LOG_TAG, "UiAutomation flags not supported prior to N - ignoring.");
        }
        return instrumentation.getUiAutomation();
    }

    UiAutomation getUiAutomation() {
        return getUiAutomation(getInstrumentation());
    }

    QueryController getQueryController() {
        return this.mQueryController;
    }

    InteractionController getInteractionController() {
        return this.mInteractionController;
    }
}
