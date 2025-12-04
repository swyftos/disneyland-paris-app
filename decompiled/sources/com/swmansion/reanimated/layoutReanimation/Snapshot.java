package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.ViewManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.swmansion.reanimated.ReactNativeUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class Snapshot {
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
    public static final String BORDER_RADIUS = "borderRadius";
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
    public static final String CURRENT_TRANSFORM_MATRIX = "currentTransformMatrix";
    public static final String GLOBAL_ORIGIN_X = "globalOriginX";
    public static final String GLOBAL_ORIGIN_Y = "globalOriginY";
    public static final String HEIGHT = "height";
    public static final String ORIGIN_X = "originX";
    public static final String ORIGIN_Y = "originY";
    public static final String TARGET_TRANSFORM_MATRIX = "targetTransformMatrix";
    public static final String TRANSFORM_MATRIX = "transformMatrix";
    public static final String WIDTH = "width";
    public ReactNativeUtils.BorderRadii borderRadii;
    public int globalOriginX;
    public int globalOriginY;
    public int height;
    private float[] identityMatrix;
    public int originX;
    public int originXByParent;
    public int originY;
    public int originYByParent;
    public ViewGroup parent;
    public ViewManager parentViewManager;
    public List<Float> transformMatrix;
    public View view;
    public ViewManager viewManager;
    public int width;
    public static final String TARGET_WIDTH = "targetWidth";
    public static final String TARGET_HEIGHT = "targetHeight";
    public static final String TARGET_ORIGIN_X = "targetOriginX";
    public static final String TARGET_ORIGIN_Y = "targetOriginY";
    public static final String TARGET_GLOBAL_ORIGIN_X = "targetGlobalOriginX";
    public static final String TARGET_GLOBAL_ORIGIN_Y = "targetGlobalOriginY";
    public static final String TARGET_BORDER_RADIUS = "targetBorderRadius";
    public static final String TARGET_BORDER_TOP_LEFT_RADIUS = "targetBorderTopLeftRadius";
    public static final String TARGET_BORDER_TOP_RIGHT_RADIUS = "targetBorderTopRightRadius";
    public static final String TARGET_BORDER_BOTTOM_LEFT_RADIUS = "targetBorderBottomLeftRadius";
    public static final String TARGET_BORDER_BOTTOM_RIGHT_RADIUS = "targetBorderBottomRightRadius";
    public static ArrayList<String> targetKeysToTransform = new ArrayList<>(Arrays.asList(TARGET_WIDTH, TARGET_HEIGHT, TARGET_ORIGIN_X, TARGET_ORIGIN_Y, TARGET_GLOBAL_ORIGIN_X, TARGET_GLOBAL_ORIGIN_Y, TARGET_BORDER_RADIUS, TARGET_BORDER_TOP_LEFT_RADIUS, TARGET_BORDER_TOP_RIGHT_RADIUS, TARGET_BORDER_BOTTOM_LEFT_RADIUS, TARGET_BORDER_BOTTOM_RIGHT_RADIUS));
    public static final String CURRENT_WIDTH = "currentWidth";
    public static final String CURRENT_HEIGHT = "currentHeight";
    public static final String CURRENT_ORIGIN_X = "currentOriginX";
    public static final String CURRENT_ORIGIN_Y = "currentOriginY";
    public static final String CURRENT_GLOBAL_ORIGIN_X = "currentGlobalOriginX";
    public static final String CURRENT_GLOBAL_ORIGIN_Y = "currentGlobalOriginY";
    public static final String CURRENT_BORDER_RADIUS = "currentBorderRadius";
    public static final String CURRENT_BORDER_TOP_LEFT_RADIUS = "currentBorderTopLeftRadius";
    public static final String CURRENT_BORDER_TOP_RIGHT_RADIUS = "currentBorderTopRightRadius";
    public static final String CURRENT_BORDER_BOTTOM_LEFT_RADIUS = "currentBorderBottomLeftRadius";
    public static final String CURRENT_BORDER_BOTTOM_RIGHT_RADIUS = "currentBorderBottomRightRadius";
    public static ArrayList<String> currentKeysToTransform = new ArrayList<>(Arrays.asList(CURRENT_WIDTH, CURRENT_HEIGHT, CURRENT_ORIGIN_X, CURRENT_ORIGIN_Y, CURRENT_GLOBAL_ORIGIN_X, CURRENT_GLOBAL_ORIGIN_Y, CURRENT_BORDER_RADIUS, CURRENT_BORDER_TOP_LEFT_RADIUS, CURRENT_BORDER_TOP_RIGHT_RADIUS, CURRENT_BORDER_BOTTOM_LEFT_RADIUS, CURRENT_BORDER_BOTTOM_RIGHT_RADIUS));

    Snapshot(View view, NativeViewHierarchyManager nativeViewHierarchyManager) {
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
        this.transformMatrix = new ArrayList(Arrays.asList(fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf));
        this.identityMatrix = new float[]{1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
        this.parent = (ViewGroup) view.getParent();
        try {
            this.viewManager = nativeViewHierarchyManager.resolveViewManager(view.getId());
            this.parentViewManager = nativeViewHierarchyManager.resolveViewManager(this.parent.getId());
        } catch (IllegalViewOperationException | NullPointerException unused) {
        }
        this.width = view.getWidth();
        this.height = view.getHeight();
        this.originX = view.getLeft();
        this.originY = view.getTop();
        this.view = view;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.globalOriginX = iArr[0];
        this.globalOriginY = iArr[1];
        this.borderRadii = new ReactNativeUtils.BorderRadii(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    private int[] tryGetRealPosition(View view) {
        int[] iArr = new int[2];
        while (view != null) {
            iArr[0] = (int) (iArr[0] + view.getX());
            iArr[1] = (int) (iArr[1] + view.getY());
            if (ScreensHelper.isScreen(view) && ScreensHelper.isScreensCoordinatorLayout(view.getParent())) {
                try {
                    view = (View) view.getClass().getMethod("getContainer", new Class[0]).invoke(view, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            } else {
                if (!(view.getParent() instanceof View)) {
                    break;
                }
                view = (View) view.getParent();
            }
        }
        return iArr;
    }

    public Snapshot(View view) {
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
        this.transformMatrix = new ArrayList(Arrays.asList(fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf));
        this.identityMatrix = new float[]{1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
        int[] iArrTryGetRealPosition = new int[2];
        view.getLocationOnScreen(iArrTryGetRealPosition);
        if (iArrTryGetRealPosition[0] == 0 && iArrTryGetRealPosition[1] == 0) {
            iArrTryGetRealPosition = tryGetRealPosition(view);
        }
        this.originX = iArrTryGetRealPosition[0];
        this.originY = iArrTryGetRealPosition[1];
        this.width = view.getWidth();
        this.height = view.getHeight();
        View viewFindTransformedView = findTransformedView(view);
        if (viewFindTransformedView != null) {
            float[] fArr = new float[9];
            viewFindTransformedView.getMatrix().getValues(fArr);
            this.transformMatrix = new ArrayList();
            for (int i = 0; i < 9; i++) {
                this.transformMatrix.add(Float.valueOf(fArr[i]));
            }
            this.transformMatrix.set(0, Float.valueOf(viewFindTransformedView.getScaleX()));
            this.transformMatrix.set(4, Float.valueOf(viewFindTransformedView.getScaleY()));
            this.transformMatrix.set(2, Float.valueOf(viewFindTransformedView.getTranslationX()));
            this.transformMatrix.set(5, Float.valueOf(viewFindTransformedView.getTranslationY()));
            float f = this.originX;
            int i2 = this.width;
            this.originX = (int) (f - ((i2 - (i2 * viewFindTransformedView.getScaleX())) / 2.0f));
            float f2 = this.originY;
            int i3 = this.height;
            this.originY = (int) (f2 - ((i3 - (i3 * viewFindTransformedView.getScaleY())) / 2.0f));
        }
        this.originXByParent = view.getLeft();
        this.originYByParent = view.getTop();
        this.borderRadii = ReactNativeUtils.getBorderRadii(view);
    }

    private void addTargetConfig(HashMap<String, Object> map) {
        map.put(TARGET_ORIGIN_Y, Integer.valueOf(this.originY));
        map.put(TARGET_ORIGIN_X, Integer.valueOf(this.originX));
        map.put(TARGET_GLOBAL_ORIGIN_Y, Integer.valueOf(this.globalOriginY));
        map.put(TARGET_GLOBAL_ORIGIN_X, Integer.valueOf(this.globalOriginX));
        map.put(TARGET_HEIGHT, Integer.valueOf(this.height));
        map.put(TARGET_WIDTH, Integer.valueOf(this.width));
        map.put(TARGET_TRANSFORM_MATRIX, this.transformMatrix);
        map.put(TARGET_BORDER_RADIUS, Float.valueOf(this.borderRadii.full));
        map.put(TARGET_BORDER_TOP_LEFT_RADIUS, Float.valueOf(this.borderRadii.topLeft));
        map.put(TARGET_BORDER_TOP_RIGHT_RADIUS, Float.valueOf(this.borderRadii.topRight));
        map.put(TARGET_BORDER_BOTTOM_LEFT_RADIUS, Float.valueOf(this.borderRadii.bottomLeft));
        map.put(TARGET_BORDER_BOTTOM_RIGHT_RADIUS, Float.valueOf(this.borderRadii.bottomRight));
    }

    private void addCurrentConfig(HashMap<String, Object> map) {
        map.put(CURRENT_ORIGIN_Y, Integer.valueOf(this.originY));
        map.put(CURRENT_ORIGIN_X, Integer.valueOf(this.originX));
        map.put(CURRENT_GLOBAL_ORIGIN_Y, Integer.valueOf(this.globalOriginY));
        map.put(CURRENT_GLOBAL_ORIGIN_X, Integer.valueOf(this.globalOriginX));
        map.put(CURRENT_HEIGHT, Integer.valueOf(this.height));
        map.put(CURRENT_WIDTH, Integer.valueOf(this.width));
        map.put(CURRENT_TRANSFORM_MATRIX, this.transformMatrix);
        map.put(CURRENT_BORDER_RADIUS, Float.valueOf(this.borderRadii.full));
        map.put(CURRENT_BORDER_TOP_LEFT_RADIUS, Float.valueOf(this.borderRadii.topLeft));
        map.put(CURRENT_BORDER_TOP_RIGHT_RADIUS, Float.valueOf(this.borderRadii.topRight));
        map.put(CURRENT_BORDER_BOTTOM_LEFT_RADIUS, Float.valueOf(this.borderRadii.bottomLeft));
        map.put(CURRENT_BORDER_BOTTOM_RIGHT_RADIUS, Float.valueOf(this.borderRadii.bottomRight));
    }

    private void addBasicConfig(HashMap<String, Object> map) {
        map.put(ORIGIN_Y, Integer.valueOf(this.originY));
        map.put(ORIGIN_X, Integer.valueOf(this.originX));
        map.put(GLOBAL_ORIGIN_Y, Integer.valueOf(this.globalOriginY));
        map.put(GLOBAL_ORIGIN_X, Integer.valueOf(this.globalOriginX));
        map.put("height", Integer.valueOf(this.height));
        map.put("width", Integer.valueOf(this.width));
        map.put(TRANSFORM_MATRIX, this.transformMatrix);
        map.put("borderRadius", Float.valueOf(this.borderRadii.full));
        map.put("borderTopLeftRadius", Float.valueOf(this.borderRadii.topLeft));
        map.put("borderTopRightRadius", Float.valueOf(this.borderRadii.topRight));
        map.put("borderBottomLeftRadius", Float.valueOf(this.borderRadii.bottomLeft));
        map.put("borderBottomRightRadius", Float.valueOf(this.borderRadii.bottomRight));
    }

    public HashMap<String, Object> toTargetMap() {
        HashMap<String, Object> map = new HashMap<>();
        addTargetConfig(map);
        return map;
    }

    public HashMap<String, Object> toCurrentMap() {
        HashMap<String, Object> map = new HashMap<>();
        addCurrentConfig(map);
        return map;
    }

    public HashMap<String, Object> toBasicMap() {
        HashMap<String, Object> map = new HashMap<>();
        addBasicConfig(map);
        return map;
    }

    private View findTransformedView(View view) {
        boolean z;
        boolean z2 = false;
        View view2 = null;
        while (true) {
            if (view2 == null) {
                view2 = view;
            } else {
                if (!(view2.getParent() instanceof View)) {
                    break;
                }
                view2 = (View) view2.getParent();
            }
            if (view2 == null) {
                break;
            }
            float[] fArr = new float[9];
            view2.getMatrix().getValues(fArr);
            boolean zEquals = Arrays.equals(fArr, this.identityMatrix);
            z = !zEquals;
            if (!zEquals || view2.getClass().getSimpleName().equals("Screen")) {
                break;
            }
            z2 = z;
        }
        z2 = z;
        if (!z2 || view2 == null) {
            return null;
        }
        return view2;
    }
}
