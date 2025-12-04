package com.facebook.react.fabric.mounting;

import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class MountingManager {
    private static final int MAX_STOPPED_SURFACE_IDS_LENGTH = 15;
    public static final String TAG = "MountingManager";

    @Nullable
    private SurfaceMountingManager mLastQueriedSurfaceMountingManager;

    @Nullable
    private SurfaceMountingManager mMostRecentSurfaceMountingManager;

    @NonNull
    private final MountItemExecutor mMountItemExecutor;

    @NonNull
    private final ViewManagerRegistry mViewManagerRegistry;

    @NonNull
    private final ConcurrentHashMap<Integer, SurfaceMountingManager> mSurfaceIdToManager = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<Integer> mStoppedSurfaceIds = new CopyOnWriteArrayList<>();

    @NonNull
    private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();

    @NonNull
    private final RootViewManager mRootViewManager = new RootViewManager();

    public interface MountItemExecutor {
        @ThreadConfined(ThreadConfined.UI)
        @UiThread
        void executeItems(Queue<MountItem> queue);
    }

    public MountingManager(@NonNull ViewManagerRegistry viewManagerRegistry, @NonNull MountItemExecutor mountItemExecutor) {
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mMountItemExecutor = mountItemExecutor;
    }

    @AnyThread
    public SurfaceMountingManager startSurface(int i, ThemedReactContext themedReactContext, @Nullable View view) {
        SurfaceMountingManager surfaceMountingManager = new SurfaceMountingManager(i, this.mJSResponderHandler, this.mViewManagerRegistry, this.mRootViewManager, this.mMountItemExecutor, themedReactContext);
        this.mSurfaceIdToManager.putIfAbsent(Integer.valueOf(i), surfaceMountingManager);
        if (this.mSurfaceIdToManager.get(Integer.valueOf(i)) != surfaceMountingManager) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Called startSurface more than once for the SurfaceId [" + i + "]"));
        }
        this.mMostRecentSurfaceMountingManager = this.mSurfaceIdToManager.get(Integer.valueOf(i));
        if (view != null) {
            surfaceMountingManager.attachRootView(view, themedReactContext);
        }
        return surfaceMountingManager;
    }

    @AnyThread
    public void attachRootView(int i, @NonNull View view, ThemedReactContext themedReactContext) {
        SurfaceMountingManager surfaceManagerEnforced = getSurfaceManagerEnforced(i, "attachView");
        if (surfaceManagerEnforced.isStopped()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to attach a view to a stopped surface"));
        } else {
            surfaceManagerEnforced.attachRootView(view, themedReactContext);
        }
    }

    @AnyThread
    public void stopSurface(int i) {
        SurfaceMountingManager surfaceMountingManager = this.mSurfaceIdToManager.get(Integer.valueOf(i));
        if (surfaceMountingManager != null) {
            while (this.mStoppedSurfaceIds.size() >= 15) {
                Integer num = this.mStoppedSurfaceIds.get(0);
                ConcurrentHashMap<Integer, SurfaceMountingManager> concurrentHashMap = this.mSurfaceIdToManager;
                num.intValue();
                concurrentHashMap.remove(num);
                this.mStoppedSurfaceIds.remove(num);
                FLog.d(TAG, "Removing stale SurfaceMountingManager: [%d]", num);
            }
            this.mStoppedSurfaceIds.add(Integer.valueOf(i));
            surfaceMountingManager.stopSurface();
            if (this.mMostRecentSurfaceMountingManager == surfaceMountingManager) {
                this.mMostRecentSurfaceMountingManager = null;
            }
            if (this.mLastQueriedSurfaceMountingManager == surfaceMountingManager) {
                this.mLastQueriedSurfaceMountingManager = null;
                return;
            }
            return;
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot call stopSurface on non-existent surface: [" + i + "]"));
    }

    @Nullable
    public SurfaceMountingManager getSurfaceManager(int i) {
        SurfaceMountingManager surfaceMountingManager = this.mLastQueriedSurfaceMountingManager;
        if (surfaceMountingManager != null && surfaceMountingManager.getSurfaceId() == i) {
            return this.mLastQueriedSurfaceMountingManager;
        }
        SurfaceMountingManager surfaceMountingManager2 = this.mMostRecentSurfaceMountingManager;
        if (surfaceMountingManager2 != null && surfaceMountingManager2.getSurfaceId() == i) {
            return this.mMostRecentSurfaceMountingManager;
        }
        SurfaceMountingManager surfaceMountingManager3 = this.mSurfaceIdToManager.get(Integer.valueOf(i));
        this.mLastQueriedSurfaceMountingManager = surfaceMountingManager3;
        return surfaceMountingManager3;
    }

    @NonNull
    public SurfaceMountingManager getSurfaceManagerEnforced(int i, String str) {
        SurfaceMountingManager surfaceManager = getSurfaceManager(i);
        if (surfaceManager != null) {
            return surfaceManager;
        }
        throw new RetryableMountingLayerException("Unable to find SurfaceMountingManager for surfaceId: [" + i + "]. Context: " + str);
    }

    public boolean surfaceIsStopped(int i) {
        if (this.mStoppedSurfaceIds.contains(Integer.valueOf(i))) {
            return true;
        }
        SurfaceMountingManager surfaceManager = getSurfaceManager(i);
        return surfaceManager != null && surfaceManager.isStopped();
    }

    public boolean isWaitingForViewAttach(int i) {
        SurfaceMountingManager surfaceManager = getSurfaceManager(i);
        if (surfaceManager == null || surfaceManager.isStopped()) {
            return false;
        }
        return !surfaceManager.isRootViewAttached();
    }

    @Nullable
    public SurfaceMountingManager getSurfaceManagerForView(int i) {
        SurfaceMountingManager surfaceMountingManager = this.mMostRecentSurfaceMountingManager;
        if (surfaceMountingManager != null && surfaceMountingManager.getViewExists(i)) {
            return this.mMostRecentSurfaceMountingManager;
        }
        Iterator<Map.Entry<Integer, SurfaceMountingManager>> it = this.mSurfaceIdToManager.entrySet().iterator();
        while (it.hasNext()) {
            SurfaceMountingManager value = it.next().getValue();
            if (value != this.mMostRecentSurfaceMountingManager && value.getViewExists(i)) {
                if (this.mMostRecentSurfaceMountingManager == null) {
                    this.mMostRecentSurfaceMountingManager = value;
                }
                return value;
            }
        }
        return null;
    }

    @NonNull
    @AnyThread
    public SurfaceMountingManager getSurfaceManagerForViewEnforced(int i) {
        SurfaceMountingManager surfaceManagerForView = getSurfaceManagerForView(i);
        if (surfaceManagerForView != null) {
            return surfaceManagerForView;
        }
        throw new RetryableMountingLayerException("Unable to find SurfaceMountingManager for tag: [" + i + "]");
    }

    public boolean getViewExists(int i) {
        return getSurfaceManagerForView(i) != null;
    }

    @Deprecated
    public void receiveCommand(int i, int i2, int i3, @Nullable ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        getSurfaceManagerEnforced(i, "receiveCommand:int").receiveCommand(i2, i3, readableArray);
    }

    public void receiveCommand(int i, int i2, @NonNull String str, @Nullable ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        getSurfaceManagerEnforced(i, "receiveCommand:string").receiveCommand(i2, str, readableArray);
    }

    public void sendAccessibilityEvent(int i, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        if (i == -1) {
            getSurfaceManagerForViewEnforced(i2).sendAccessibilityEvent(i2, i3);
        } else {
            getSurfaceManagerEnforced(i, "sendAccessibilityEvent").sendAccessibilityEvent(i2, i3);
        }
    }

    @UiThread
    public void updateProps(int i, @Nullable ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        if (readableMap == null) {
            return;
        }
        getSurfaceManagerForViewEnforced(i).updateProps(i, readableMap);
    }

    @UiThread
    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    @Nullable
    @AnyThread
    @ThreadConfined(ThreadConfined.ANY)
    public EventEmitterWrapper getEventEmitter(int i, int i2) {
        SurfaceMountingManager surfaceMountingManager = getSurfaceMountingManager(i, i2);
        if (surfaceMountingManager == null) {
            return null;
        }
        return surfaceMountingManager.getEventEmitter(i2);
    }

    @AnyThread
    public long measure(@NonNull ReactContext reactContext, @NonNull String str, @NonNull ReadableMap readableMap, @NonNull ReadableMap readableMap2, @NonNull ReadableMap readableMap3, float f, @NonNull YogaMeasureMode yogaMeasureMode, float f2, @NonNull YogaMeasureMode yogaMeasureMode2, @Nullable float[] fArr) {
        return this.mViewManagerRegistry.get(str).measure(reactContext, readableMap, readableMap2, readableMap3, f, yogaMeasureMode, f2, yogaMeasureMode2, fArr);
    }

    @AnyThread
    public long measureMapBuffer(@NonNull ReactContext reactContext, @NonNull String str, @NonNull MapBuffer mapBuffer, @NonNull MapBuffer mapBuffer2, @Nullable MapBuffer mapBuffer3, float f, @NonNull YogaMeasureMode yogaMeasureMode, float f2, @NonNull YogaMeasureMode yogaMeasureMode2, @Nullable float[] fArr) {
        return this.mViewManagerRegistry.get(str).measure(reactContext, mapBuffer, mapBuffer2, mapBuffer3, f, yogaMeasureMode, f2, yogaMeasureMode2, fArr);
    }

    @AnyThread
    @UnstableReactNativeAPI
    public void experimental_prefetchResource(ReactContext reactContext, String str, int i, int i2, MapBuffer mapBuffer) {
        this.mViewManagerRegistry.get(str).experimental_prefetchResource(reactContext, i, i2, mapBuffer);
    }

    public void enqueuePendingEvent(int i, int i2, String str, boolean z, @Nullable WritableMap writableMap, int i3) {
        SurfaceMountingManager surfaceMountingManager = getSurfaceMountingManager(i, i2);
        if (surfaceMountingManager == null) {
            FLog.d(TAG, "Cannot queue event without valid surface mounting manager for tag: %d, surfaceId: %d", Integer.valueOf(i2), Integer.valueOf(i));
        } else {
            surfaceMountingManager.enqueuePendingEvent(i2, str, z, writableMap, i3);
        }
    }

    @Nullable
    private SurfaceMountingManager getSurfaceMountingManager(int i, int i2) {
        if (i == -1) {
            return getSurfaceManagerForView(i2);
        }
        return getSurfaceManager(i);
    }
}
