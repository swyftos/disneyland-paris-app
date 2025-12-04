package androidx.test.uiautomator;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
class QueryController {
    private static final boolean DEBUG;
    private static final String LOG_TAG = "QueryController";
    private static final boolean VERBOSE;
    private final Instrumentation mInstrumentation;
    private final Object mLock = new Object();
    private String mLastActivityName = null;
    private int mPatternCounter = 0;
    private int mPatternIndexer = 0;
    private int mLogIndent = 0;
    private int mLogParentIndent = 0;
    private String mLastTraversedText = "";
    private UiAutomation.OnAccessibilityEventListener mEventListener = new UiAutomation.OnAccessibilityEventListener() { // from class: androidx.test.uiautomator.QueryController.1
        @Override // android.app.UiAutomation.OnAccessibilityEventListener
        public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            synchronized (QueryController.this.mLock) {
                try {
                    int eventType = accessibilityEvent.getEventType();
                    if (eventType != 32) {
                        if (eventType == 131072) {
                            if (accessibilityEvent.getText() != null && accessibilityEvent.getText().size() > 0 && accessibilityEvent.getText().get(0) != null) {
                                QueryController.this.mLastTraversedText = accessibilityEvent.getText().get(0).toString();
                            }
                            if (QueryController.DEBUG) {
                                Log.d(QueryController.LOG_TAG, "Last text selection reported: " + QueryController.this.mLastTraversedText);
                            }
                        }
                    } else if (accessibilityEvent.getText() != null && accessibilityEvent.getText().size() > 0 && accessibilityEvent.getText().get(0) != null) {
                        QueryController.this.mLastActivityName = accessibilityEvent.getText().get(0).toString();
                    }
                    QueryController.this.mLock.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    static {
        String simpleName = QueryController.class.getSimpleName();
        DEBUG = Log.isLoggable(simpleName, 3);
        VERBOSE = Log.isLoggable(simpleName, 2);
    }

    public QueryController(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
        UiDevice.getUiAutomation(instrumentation).setOnAccessibilityEventListener(this.mEventListener);
    }

    public String getLastTraversedText() {
        waitForIdle();
        synchronized (this.mLock) {
            try {
                if (this.mLastTraversedText.length() <= 0) {
                    return null;
                }
                return this.mLastTraversedText;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearLastTraversedText() {
        waitForIdle();
        synchronized (this.mLock) {
            this.mLastTraversedText = "";
        }
    }

    private void initializeNewSearch() {
        this.mPatternCounter = 0;
        this.mPatternIndexer = 0;
        this.mLogIndent = 0;
        this.mLogParentIndent = 0;
    }

    public int getPatternCount(UiSelector uiSelector) {
        findAccessibilityNodeInfo(uiSelector, true);
        return this.mPatternCounter;
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfo(UiSelector uiSelector) {
        return findAccessibilityNodeInfo(uiSelector, false);
    }

    protected AccessibilityNodeInfo findAccessibilityNodeInfo(UiSelector uiSelector, boolean z) {
        waitForIdle();
        initializeNewSearch();
        if (DEBUG) {
            Log.d(LOG_TAG, "Searching: " + uiSelector);
        }
        AccessibilityNodeInfo rootNode = getRootNode();
        if (rootNode == null) {
            Log.e(LOG_TAG, "Cannot proceed when root node is null. Aborted search");
            return null;
        }
        return translateCompoundSelector(new UiSelector(uiSelector), rootNode, z);
    }

    AccessibilityNodeInfo getRootNode() {
        long j = 250;
        AccessibilityNodeInfo rootInActiveWindow = null;
        for (int i = 0; i < 6; i++) {
            rootInActiveWindow = UiDevice.getUiAutomation(getInstrumentation()).getRootInActiveWindow();
            if (rootInActiveWindow != null) {
                return rootInActiveWindow;
            }
            if (i < 5) {
                Log.e(LOG_TAG, "Got null root node from accessibility - Retrying...");
                SystemClock.sleep(j);
                j *= 2;
            }
        }
        return rootInActiveWindow;
    }

    private AccessibilityNodeInfo translateCompoundSelector(UiSelector uiSelector, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        AccessibilityNodeInfo accessibilityNodeInfoTranslateReqularSelector;
        if (uiSelector.hasContainerSelector()) {
            if (uiSelector.getContainerSelector().hasContainerSelector()) {
                accessibilityNodeInfoTranslateReqularSelector = translateCompoundSelector(uiSelector.getContainerSelector(), accessibilityNodeInfo, false);
                initializeNewSearch();
            } else {
                accessibilityNodeInfoTranslateReqularSelector = translateReqularSelector(uiSelector.getContainerSelector(), accessibilityNodeInfo);
            }
        } else {
            accessibilityNodeInfoTranslateReqularSelector = translateReqularSelector(uiSelector, accessibilityNodeInfo);
        }
        if (accessibilityNodeInfoTranslateReqularSelector == null) {
            if (DEBUG) {
                Log.d(LOG_TAG, "Container selector not found: " + uiSelector.dumpToString(false));
            }
            return null;
        }
        if (uiSelector.hasPatternSelector()) {
            accessibilityNodeInfoTranslateReqularSelector = translatePatternSelector(uiSelector.getPatternSelector(), accessibilityNodeInfoTranslateReqularSelector, z);
            if (z) {
                Log.i(LOG_TAG, String.format("Counted %d instances of: %s", Integer.valueOf(this.mPatternCounter), uiSelector));
                return null;
            }
            if (accessibilityNodeInfoTranslateReqularSelector == null) {
                if (DEBUG) {
                    Log.d(LOG_TAG, "Pattern selector not found: " + uiSelector.dumpToString(false));
                }
                return null;
            }
        }
        if ((uiSelector.hasContainerSelector() || uiSelector.hasPatternSelector()) && (uiSelector.hasChildSelector() || uiSelector.hasParentSelector())) {
            accessibilityNodeInfoTranslateReqularSelector = translateReqularSelector(uiSelector, accessibilityNodeInfoTranslateReqularSelector);
        }
        if (accessibilityNodeInfoTranslateReqularSelector == null) {
            if (DEBUG) {
                Log.d(LOG_TAG, "Object Not Found for selector " + uiSelector);
            }
            return null;
        }
        Log.i(LOG_TAG, String.format("Matched selector: %s <<==>> [%s]", uiSelector, accessibilityNodeInfoTranslateReqularSelector));
        return accessibilityNodeInfoTranslateReqularSelector;
    }

    private AccessibilityNodeInfo translateReqularSelector(UiSelector uiSelector, AccessibilityNodeInfo accessibilityNodeInfo) {
        return findNodeRegularRecursive(uiSelector, accessibilityNodeInfo, 0);
    }

    private AccessibilityNodeInfo findNodeRegularRecursive(UiSelector uiSelector, AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        if (uiSelector.isMatchFor(accessibilityNodeInfo, i)) {
            if (DEBUG) {
                Log.d(LOG_TAG, formatLog(String.format("%s", uiSelector.dumpToString(false))));
            }
            if (uiSelector.isLeaf()) {
                return accessibilityNodeInfo;
            }
            if (uiSelector.hasChildSelector()) {
                this.mLogIndent++;
                uiSelector = uiSelector.getChildSelector();
                if (uiSelector == null) {
                    Log.e(LOG_TAG, "Error: A child selector without content");
                    return null;
                }
            } else if (uiSelector.hasParentSelector()) {
                this.mLogIndent++;
                uiSelector = uiSelector.getParentSelector();
                if (uiSelector == null) {
                    Log.e(LOG_TAG, "Error: A parent selector without content");
                    return null;
                }
                accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                if (accessibilityNodeInfo == null) {
                    return null;
                }
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
            if (child == null) {
                String str = LOG_TAG;
                Log.w(str, String.format("AccessibilityNodeInfo returned a null child (%d of %d)", Integer.valueOf(i2), Integer.valueOf(childCount)));
                if (!z) {
                    Log.w(str, String.format("parent = %s", accessibilityNodeInfo.toString()));
                }
                z = true;
            } else if (!child.isVisibleToUser()) {
                if (VERBOSE) {
                    Log.v(LOG_TAG, String.format("Skipping invisible child: %s", child.toString()));
                }
            } else {
                AccessibilityNodeInfo accessibilityNodeInfoFindNodeRegularRecursive = findNodeRegularRecursive(uiSelector, child, i2);
                if (accessibilityNodeInfoFindNodeRegularRecursive != null) {
                    return accessibilityNodeInfoFindNodeRegularRecursive;
                }
            }
        }
        return null;
    }

    private AccessibilityNodeInfo translatePatternSelector(UiSelector uiSelector, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        if (uiSelector.hasPatternSelector()) {
            if (z) {
                this.mPatternIndexer = -1;
            } else {
                this.mPatternIndexer = uiSelector.getInstance();
            }
            UiSelector patternSelector = uiSelector.getPatternSelector();
            if (patternSelector == null) {
                Log.e(LOG_TAG, "Pattern portion of the selector is null or not defined");
                return null;
            }
            int i = this.mLogIndent + 1;
            this.mLogIndent = i;
            this.mLogParentIndent = i;
            return findNodePatternRecursive(patternSelector, accessibilityNodeInfo, 0, patternSelector);
        }
        Log.e(LOG_TAG, "Selector must have a pattern selector defined");
        return null;
    }

    private AccessibilityNodeInfo findNodePatternRecursive(UiSelector uiSelector, AccessibilityNodeInfo accessibilityNodeInfo, int i, UiSelector uiSelector2) {
        if (uiSelector.isMatchFor(accessibilityNodeInfo, i)) {
            if (uiSelector.isLeaf()) {
                if (this.mPatternIndexer == 0) {
                    if (DEBUG) {
                        Log.d(LOG_TAG, formatLog(String.format("%s", uiSelector.dumpToString(false))));
                    }
                    return accessibilityNodeInfo;
                }
                if (DEBUG) {
                    Log.d(LOG_TAG, formatLog(String.format("%s", uiSelector.dumpToString(false))));
                }
                this.mPatternCounter++;
                this.mPatternIndexer--;
                this.mLogIndent = this.mLogParentIndent;
                uiSelector = uiSelector2;
            } else {
                if (DEBUG) {
                    Log.d(LOG_TAG, formatLog(String.format("%s", uiSelector.dumpToString(false))));
                }
                if (uiSelector.hasChildSelector()) {
                    this.mLogIndent++;
                    uiSelector = uiSelector.getChildSelector();
                    if (uiSelector == null) {
                        Log.e(LOG_TAG, "Error: A child selector without content");
                        return null;
                    }
                } else if (uiSelector.hasParentSelector()) {
                    this.mLogIndent++;
                    uiSelector = uiSelector.getParentSelector();
                    if (uiSelector == null) {
                        Log.e(LOG_TAG, "Error: A parent selector without content");
                        return null;
                    }
                    accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                    if (accessibilityNodeInfo == null) {
                        return null;
                    }
                }
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
            if (child == null) {
                String str = LOG_TAG;
                Log.w(str, String.format("AccessibilityNodeInfo returned a null child (%d of %d)", Integer.valueOf(i2), Integer.valueOf(childCount)));
                if (!z) {
                    Log.w(str, String.format("parent = %s", accessibilityNodeInfo.toString()));
                }
                z = true;
            } else if (!child.isVisibleToUser()) {
                if (DEBUG) {
                    Log.d(LOG_TAG, String.format("Skipping invisible child: %s", child.toString()));
                }
            } else {
                AccessibilityNodeInfo accessibilityNodeInfoFindNodePatternRecursive = findNodePatternRecursive(uiSelector, child, i2, uiSelector2);
                if (accessibilityNodeInfoFindNodePatternRecursive != null) {
                    return accessibilityNodeInfoFindNodePatternRecursive;
                }
            }
        }
        return null;
    }

    public String getCurrentActivityName() {
        String str;
        waitForIdle();
        synchronized (this.mLock) {
            str = this.mLastActivityName;
        }
        return str;
    }

    public String getCurrentPackageName() {
        waitForIdle();
        AccessibilityNodeInfo rootNode = getRootNode();
        if (rootNode == null || rootNode.getPackageName() == null) {
            return null;
        }
        return rootNode.getPackageName().toString();
    }

    public void waitForIdle() {
        waitForIdle(Configurator.getInstance().getWaitForIdleTimeout());
    }

    public void waitForIdle(long j) {
        try {
            UiDevice.getUiAutomation(getInstrumentation()).waitForIdle(500L, j);
        } catch (TimeoutException unused) {
            Log.w(LOG_TAG, "Could not detect idle state.");
        }
    }

    private String formatLog(String str) {
        int i;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            i = this.mLogIndent;
            if (i2 >= i) {
                break;
            }
            sb.append(". . ");
            i2++;
        }
        if (i > 0) {
            sb.append(String.format(". . [%d]: %s", Integer.valueOf(this.mPatternCounter), str));
        } else {
            sb.append(String.format(". . [%d]: %s", Integer.valueOf(this.mPatternCounter), str));
        }
        return sb.toString();
    }

    private Instrumentation getInstrumentation() {
        return this.mInstrumentation;
    }
}
