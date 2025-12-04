package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.swmansion.reanimated.Utils;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import com.swmansion.worklets.AndroidUIScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.slf4j.Marker;

/* loaded from: classes4.dex */
public class AnimationsManager implements ViewHierarchyObserver {
    private ReactContext mContext;
    private NativeMethodsHolder mNativeMethodsHolder;
    private ReanimatedNativeHierarchyManager mReanimatedNativeHierarchyManager;
    private UIManager mUIManager;
    private WeakReference<AndroidUIScheduler> mWeakAndroidUIScheduler = new WeakReference<>(null);
    private final HashSet<Integer> mEnteringViews = new HashSet<>();
    private final HashMap<Integer, Rect> mEnteringViewTargetValues = new HashMap<>();
    private HashMap<Integer, View> mExitingViews = new HashMap<>();
    private HashMap<Integer, Integer> mExitingSubviewCountMap = new HashMap<>();
    private HashSet<Integer> mAncestorsToRemove = new HashSet<>();
    private HashMap<Integer, Runnable> mCallbacks = new HashMap<>();
    private boolean isInvalidated = false;
    private final SharedTransitionManager mSharedTransitionManager = new SharedTransitionManager(this);

    public void setReanimatedNativeHierarchyManager(ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager) {
        this.mReanimatedNativeHierarchyManager = reanimatedNativeHierarchyManager;
    }

    public ReanimatedNativeHierarchyManager getReanimatedNativeHierarchyManager() {
        return this.mReanimatedNativeHierarchyManager;
    }

    public void setAndroidUIScheduler(AndroidUIScheduler androidUIScheduler) {
        this.mWeakAndroidUIScheduler = new WeakReference<>(androidUIScheduler);
    }

    public AnimationsManager(ReactContext reactContext, UIManager uIManager) {
        this.mContext = reactContext;
        this.mUIManager = uIManager;
    }

    public void invalidate() {
        this.isInvalidated = true;
        this.mNativeMethodsHolder = null;
        this.mContext = null;
        this.mUIManager = null;
        this.mExitingViews = null;
        this.mExitingSubviewCountMap = null;
        this.mAncestorsToRemove = null;
        this.mCallbacks = null;
    }

    @Override // com.swmansion.reanimated.layoutReanimation.ViewHierarchyObserver
    public void onViewRemoval(View view, ViewGroup viewGroup, Runnable runnable) {
        if (this.isInvalidated) {
            return;
        }
        this.mCallbacks.put(Integer.valueOf(view.getId()), runnable);
        if (removeOrAnimateExitRecursive(view, true, true)) {
            return;
        }
        removeView(view, viewGroup);
    }

    @Override // com.swmansion.reanimated.layoutReanimation.ViewHierarchyObserver
    public void onViewCreate(View view, ViewGroup viewGroup, Snapshot snapshot) {
        AndroidUIScheduler androidUIScheduler;
        if (this.isInvalidated) {
            return;
        }
        maybeRegisterSharedView(view);
        if (hasAnimationForTag(view.getId(), 1) && (androidUIScheduler = this.mWeakAndroidUIScheduler.get()) != null) {
            androidUIScheduler.triggerUI();
            int id = view.getId();
            HashMap<String, Object> targetMap = snapshot.toTargetMap();
            if (targetMap != null) {
                this.mNativeMethodsHolder.startAnimation(id, 1, prepareDataForAnimationWorklet(targetMap, true));
                this.mEnteringViews.add(Integer.valueOf(id));
            }
        }
    }

    @Override // com.swmansion.reanimated.layoutReanimation.ViewHierarchyObserver
    public void onViewUpdate(View view, Snapshot snapshot, Snapshot snapshot2) {
        if (this.isInvalidated) {
            return;
        }
        int id = view.getId();
        if (!hasAnimationForTag(id, 3)) {
            if (this.mEnteringViews.contains(Integer.valueOf(id))) {
                HashMap<Integer, Rect> map = this.mEnteringViewTargetValues;
                Integer numValueOf = Integer.valueOf(id);
                int i = snapshot2.originX;
                int i2 = snapshot2.originY;
                map.put(numValueOf, new Rect(i, i2, snapshot2.width + i, snapshot2.height + i2));
                int i3 = snapshot.originX;
                int i4 = snapshot.originY;
                view.layout(i3, i4, snapshot.width + i3, snapshot.height + i4);
                return;
            }
            return;
        }
        HashMap<String, Object> currentMap = snapshot.toCurrentMap();
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        boolean z = true;
        for (int i5 = 0; i5 < Snapshot.targetKeysToTransform.size(); i5++) {
            if (((Number) currentMap.get(Snapshot.currentKeysToTransform.get(i5))).doubleValue() != ((Number) targetMap.get(Snapshot.targetKeysToTransform.get(i5))).doubleValue()) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        HashMap<String, Object> mapPrepareDataForAnimationWorklet = prepareDataForAnimationWorklet(currentMap, false);
        HashMap<String, Object> map2 = new HashMap<>(prepareDataForAnimationWorklet(targetMap, true));
        for (String str : mapPrepareDataForAnimationWorklet.keySet()) {
            map2.put(str, mapPrepareDataForAnimationWorklet.get(str));
        }
        this.mNativeMethodsHolder.startAnimation(id, 3, map2);
    }

    public void maybeRegisterSharedView(View view) {
        if (hasAnimationForTag(view.getId(), 4)) {
            this.mSharedTransitionManager.notifyAboutNewView(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkDuplicateSharedTag(View view) {
        int id = view.getId();
        ViewParent parent = view.getParent();
        while (parent != 0 && !parent.getClass().getSimpleName().equals("Screen")) {
            parent = parent.getParent();
        }
        if (parent != 0) {
            this.mNativeMethodsHolder.checkDuplicateSharedTag(id, ((View) parent).getId());
        }
    }

    public void progressLayoutAnimation(int i, Map<String, Object> map, boolean z) {
        ViewGroup viewGroup;
        View viewResolveView = resolveView(i);
        if (viewResolveView == null || (viewGroup = (ViewGroup) viewResolveView.getParent()) == null) {
            return;
        }
        ViewManager viewManagerResolveViewManager = resolveViewManager(i);
        ViewManager viewManagerResolveViewManager2 = resolveViewManager(viewGroup.getId());
        if (viewManagerResolveViewManager == null) {
            return;
        }
        setNewProps(map, viewResolveView, viewManagerResolveViewManager, viewManagerResolveViewManager2, Integer.valueOf(viewGroup.getId()), z);
    }

    public void endLayoutAnimation(int i, boolean z) {
        View viewResolveView = resolveView(i);
        if (viewResolveView == null) {
            return;
        }
        Rect rect = this.mEnteringViewTargetValues.get(Integer.valueOf(i));
        if (!z && this.mEnteringViews.contains(Integer.valueOf(i)) && rect != null) {
            viewResolveView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
        this.mEnteringViews.remove(Integer.valueOf(i));
        this.mEnteringViewTargetValues.remove(Integer.valueOf(i));
        if (z) {
            if ((viewResolveView instanceof ViewGroup) && this.mAncestorsToRemove.contains(Integer.valueOf(i))) {
                cancelAnimationsInSubviews((ViewGroup) viewResolveView);
            }
            this.mExitingViews.remove(Integer.valueOf(i));
            maybeDropAncestors(viewResolveView);
            removeView(viewResolveView, (ViewGroup) viewResolveView.getParent());
        }
        this.mSharedTransitionManager.finishSharedAnimation(i);
    }

    public void printSubTree(View view, int i) {
        if (i == 0) {
            Log.v("rea", "----------------------");
        }
        if (view == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Marker.ANY_NON_NULL_MARKER);
        }
        sb.append(" TAG:");
        sb.append(view.getId());
        sb.append(" CLASS:");
        sb.append(view.getClass().getSimpleName());
        Log.v("rea", sb.toString());
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            printSubTree(viewGroup.getChildAt(i2), i + 1);
            i2++;
        }
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> map, boolean z) {
        return prepareDataForAnimationWorklet(map, z, false);
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> map, boolean z, boolean z2) {
        ArrayList<String> arrayList;
        HashMap<String, Object> map2 = new HashMap<>();
        if (z) {
            arrayList = Snapshot.targetKeysToTransform;
        } else {
            arrayList = Snapshot.currentKeysToTransform;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map2.put(next, Float.valueOf(PixelUtil.toDIPFromPixel(Utils.convertToFloat(map.get(next)))));
        }
        if (z2) {
            String str = z ? Snapshot.TARGET_TRANSFORM_MATRIX : Snapshot.CURRENT_TRANSFORM_MATRIX;
            map2.put(str, map.get(str));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            map2.put("windowWidth", Float.valueOf(PixelUtil.toDIPFromPixel(displayMetrics.widthPixels)));
            map2.put("windowHeight", Float.valueOf(PixelUtil.toDIPFromPixel(i)));
        } else {
            map2.put("windowWidth", Float.valueOf(PixelUtil.toDIPFromPixel(BitmapDescriptorFactory.HUE_RED)));
            map2.put("windowHeight", Float.valueOf(PixelUtil.toDIPFromPixel(BitmapDescriptorFactory.HUE_RED)));
        }
        return map2;
    }

    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
        this.mSharedTransitionManager.setNativeMethods(nativeMethodsHolder);
    }

    public void setNewProps(Map<String, Object> map, View view, ViewManager viewManager, ViewManager viewManager2, Integer num, boolean z) {
        float dIPFromPixel;
        float dIPFromPixel2;
        float dIPFromPixel3;
        float dIPFromPixel4;
        if (map.get(Snapshot.ORIGIN_X) != null) {
            dIPFromPixel = ((Double) map.get(Snapshot.ORIGIN_X)).floatValue();
        } else {
            dIPFromPixel = PixelUtil.toDIPFromPixel(view.getLeft());
        }
        float f = dIPFromPixel;
        if (map.get(Snapshot.ORIGIN_Y) != null) {
            dIPFromPixel2 = ((Double) map.get(Snapshot.ORIGIN_Y)).floatValue();
        } else {
            dIPFromPixel2 = PixelUtil.toDIPFromPixel(view.getTop());
        }
        float f2 = dIPFromPixel2;
        if (map.get("width") != null) {
            dIPFromPixel3 = ((Double) map.get("width")).floatValue();
        } else {
            dIPFromPixel3 = PixelUtil.toDIPFromPixel(view.getWidth());
        }
        float f3 = dIPFromPixel3;
        if (map.get("height") != null) {
            dIPFromPixel4 = ((Double) map.get("height")).floatValue();
        } else {
            dIPFromPixel4 = PixelUtil.toDIPFromPixel(view.getHeight());
        }
        float f4 = dIPFromPixel4;
        if (map.containsKey(Snapshot.TRANSFORM_MATRIX)) {
            float[] fArr = new float[9];
            Object obj = map.get(Snapshot.TRANSFORM_MATRIX);
            if (obj instanceof ReadableNativeArray) {
                ReadableNativeArray readableNativeArray = (ReadableNativeArray) obj;
                for (int i = 0; i < 9; i++) {
                    fArr[i] = Double.valueOf(readableNativeArray.getDouble(i)).floatValue();
                }
            } else {
                ArrayList arrayList = (ArrayList) map.get(Snapshot.TRANSFORM_MATRIX);
                for (int i2 = 0; i2 < 9; i2++) {
                    fArr[i2] = ((Float) arrayList.get(i2)).floatValue();
                }
            }
            view.setScaleX(fArr[0]);
            view.setScaleY(fArr[4]);
            map.remove(Snapshot.TRANSFORM_MATRIX);
        }
        updateLayout(view, viewManager2, num.intValue(), f, f2, f3, f4, z);
        map.remove(Snapshot.ORIGIN_X);
        map.remove(Snapshot.ORIGIN_Y);
        map.remove(Snapshot.GLOBAL_ORIGIN_X);
        map.remove(Snapshot.GLOBAL_ORIGIN_Y);
        map.remove("width");
        map.remove("height");
        if (map.size() == 0) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (String str : map.keySet()) {
            addProp(javaOnlyMap, str, map.get(str));
        }
        viewManager.updateProperties(view, new ReactStylesDiffMap(javaOnlyMap));
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
            return;
        }
        if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else {
            if (obj instanceof ReadableMap) {
                writableMap.putMap(str, (ReadableMap) obj);
                return;
            }
            throw new IllegalStateException("[Reanimated] Unknown type of animated value for Layout Animations.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateLayout(View view, ViewManager viewManager, int i, float f, float f2, float f3, float f4, boolean z) {
        int iRound = Math.round(PixelUtil.toPixelFromDIP(f));
        int iRound2 = Math.round(PixelUtil.toPixelFromDIP(f2));
        int iRound3 = Math.round(PixelUtil.toPixelFromDIP(f3));
        int iRound4 = Math.round(PixelUtil.toPixelFromDIP(f4));
        view.measure(View.MeasureSpec.makeMeasureSpec(iRound3, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound4, 1073741824));
        ViewParent parent = view.getParent();
        if (parent instanceof RootView) {
            parent.requestLayout();
        }
        if (i % 10 == 1 && viewManager != 0) {
            if (!(viewManager instanceof IViewManagerWithChildren)) {
                throw new IllegalViewOperationException("[Reanimated] Trying to use view with tag " + i + " as a parent, but its Manager doesn't implement IViewManagerWithChildren.");
            }
            if (((IViewManagerWithChildren) viewManager).needsCustomLayoutForChildren()) {
                return;
            }
            view.layout(iRound, iRound2, iRound3 + iRound, iRound4 + iRound2);
            return;
        }
        if (z) {
            Point pointConvertScreenLocationToViewCoordinates = convertScreenLocationToViewCoordinates(new Point(iRound, iRound2), (View) view.getParent());
            int i2 = pointConvertScreenLocationToViewCoordinates.x;
            iRound2 = pointConvertScreenLocationToViewCoordinates.y;
            iRound = i2;
        }
        view.layout(iRound, iRound2, iRound3 + iRound, iRound4 + iRound2);
    }

    public boolean shouldAnimateExiting(int i, boolean z) {
        return this.mNativeMethodsHolder.shouldAnimateExiting(i, z);
    }

    public boolean hasAnimationForTag(int i, int i2) {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        return nativeMethodsHolder != null && nativeMethodsHolder.hasAnimation(i, i2);
    }

    public boolean isLayoutAnimationEnabled() {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        return nativeMethodsHolder != null && nativeMethodsHolder.isLayoutAnimationEnabled();
    }

    private boolean removeOrAnimateExitRecursive(View view, boolean z, boolean z2) {
        boolean z3;
        int id = view.getId();
        ViewManager viewManagerResolveViewManager = resolveViewManager(id);
        if (viewManagerResolveViewManager != null) {
            String name = viewManagerResolveViewManager.getName();
            if (name.equals(ReactModalHostManager.REACT_CLASS) || name.equals(ScreenViewManager.REACT_CLASS) || name.equals(ScreenStackViewManager.REACT_CLASS)) {
                cancelAnimationsRecursive(view);
                return false;
            }
        }
        boolean zShouldAnimateExiting = shouldAnimateExiting(id, z2);
        boolean z4 = zShouldAnimateExiting && (hasAnimationForTag(id, 2) || this.mExitingViews.containsKey(Integer.valueOf(id)));
        boolean z5 = z && !z4;
        if (hasAnimationForTag(id, 4)) {
            this.mSharedTransitionManager.notifyAboutRemovedView(view);
            this.mSharedTransitionManager.makeSnapshot(view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z3 = false;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (removeOrAnimateExitRecursive(childAt, z5, zShouldAnimateExiting)) {
                    z3 = true;
                } else if (z5 && childAt.getId() != -1) {
                    arrayList.add(childAt);
                }
            }
        } else {
            z3 = false;
        }
        boolean z6 = z4 || z3;
        if (z4) {
            HashMap<String, Object> mapPrepareDataForAnimationWorklet = prepareDataForAnimationWorklet(new Snapshot(view, this.mReanimatedNativeHierarchyManager).toCurrentMap(), false);
            if (!this.mExitingViews.containsKey(Integer.valueOf(id))) {
                this.mExitingViews.put(Integer.valueOf(id), view);
                registerExitingAncestors(view);
                this.mNativeMethodsHolder.startAnimation(id, 2, mapPrepareDataForAnimationWorklet);
            }
        }
        this.mNativeMethodsHolder.clearAnimationConfig(id);
        if (!z6) {
            return false;
        }
        if (z3) {
            if (id == -1) {
                cancelAnimationsRecursive(view);
                return false;
            }
            this.mAncestorsToRemove.add(Integer.valueOf(id));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeView((View) it.next(), (ViewGroup) view);
        }
        return true;
    }

    public void clearAnimationConfigRecursive(View view) {
        this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                clearAnimationConfigRecursive(viewGroup.getChildAt(i));
            }
        }
    }

    public void cancelAnimationsInSubviews(View view) {
        cancelAnimationsRecursive(view);
        clearAnimationConfigRecursive(view);
    }

    private void registerExitingAncestors(View view) {
        for (View view2 = (View) view.getParent(); view2 != null && !(view2 instanceof RootView); view2 = (View) view2.getParent()) {
            int id = view2.getId();
            Integer num = this.mExitingSubviewCountMap.get(Integer.valueOf(id));
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            this.mExitingSubviewCountMap.put(Integer.valueOf(id), Integer.valueOf(iIntValue));
        }
    }

    private void maybeDropAncestors(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            while (view2 != null && !(view2 instanceof RootView)) {
                View view3 = (View) view2.getParent();
                int id = view2.getId();
                int iIntValue = this.mExitingSubviewCountMap.get(Integer.valueOf(id)) != null ? r2.intValue() - 1 : 0;
                Integer numValueOf = Integer.valueOf(iIntValue);
                if (iIntValue <= 0) {
                    if (this.mAncestorsToRemove.contains(Integer.valueOf(id))) {
                        this.mAncestorsToRemove.remove(Integer.valueOf(id));
                        if (!this.mExitingViews.containsKey(Integer.valueOf(id))) {
                            removeView(view2, (ViewGroup) view3);
                        }
                    }
                    this.mExitingSubviewCountMap.remove(Integer.valueOf(id));
                } else {
                    this.mExitingSubviewCountMap.put(Integer.valueOf(id), numValueOf);
                }
                view2 = view3;
            }
        }
    }

    private void removeView(View view, @Nullable ViewGroup viewGroup) {
        int id = view.getId();
        if (this.mCallbacks.containsKey(Integer.valueOf(id))) {
            Runnable runnable = this.mCallbacks.get(Integer.valueOf(id));
            this.mCallbacks.remove(Integer.valueOf(id));
            if (runnable != null) {
                runnable.run();
            }
        } else {
            this.mReanimatedNativeHierarchyManager.publicDropView(view);
        }
        if (viewGroup == null || viewGroup.indexOfChild(view) == -1) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void cancelAnimationsRecursive(View view) {
        if (this.mExitingViews.containsKey(Integer.valueOf(view.getId()))) {
            endLayoutAnimation(view.getId(), true);
        } else if ((view instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(view.getId()))) {
            cancelAnimationsInSubviews((ViewGroup) view);
        }
    }

    private void cancelAnimationsInSubviews(ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != null) {
                if (this.mExitingViews.containsKey(Integer.valueOf(childAt.getId()))) {
                    endLayoutAnimation(childAt.getId(), true);
                } else if ((childAt instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(childAt.getId()))) {
                    cancelAnimationsInSubviews((ViewGroup) childAt);
                }
            }
        }
    }

    protected View resolveView(int i) {
        if (this.mExitingViews.containsKey(Integer.valueOf(i))) {
            return this.mExitingViews.get(Integer.valueOf(i));
        }
        View transitioningView = this.mSharedTransitionManager.getTransitioningView(i);
        if (transitioningView != null) {
            return transitioningView;
        }
        try {
            return this.mUIManager.resolveView(i);
        } catch (IllegalViewOperationException unused) {
            return null;
        }
    }

    private ViewManager resolveViewManager(int i) {
        try {
            return this.mReanimatedNativeHierarchyManager.resolveViewManager(i);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Point convertScreenLocationToViewCoordinates(Point point, View view) {
        int[] iArr = {0, 0};
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return new Point(point.x - iArr[0], point.y - iArr[1]);
    }

    public void screenDidLayout(View view) {
        this.mSharedTransitionManager.screenDidLayout(view);
    }

    public void navigationTabChanged(View view, View view2) {
        this.mSharedTransitionManager.navigationTabChanged(view, view2);
    }

    public void visitNativeTreeAndMakeSnapshot(View view) {
        this.mSharedTransitionManager.visitNativeTreeAndMakeSnapshot(view);
    }

    public void viewDidLayout(View view) {
        this.mSharedTransitionManager.viewDidLayout(view);
    }

    public void notifyAboutViewsRemoval(int[] iArr) {
        this.mSharedTransitionManager.onViewsRemoval(iArr);
    }

    public void notifyAboutScreenWillDisappear() {
        this.mSharedTransitionManager.onScreenWillDisappear();
    }

    public void makeSnapshotOfTopScreenViews(ViewGroup viewGroup) {
        this.mSharedTransitionManager.doSnapshotForTopScreenViews(viewGroup);
    }

    protected ReactContext getContext() {
        return this.mContext;
    }
}
