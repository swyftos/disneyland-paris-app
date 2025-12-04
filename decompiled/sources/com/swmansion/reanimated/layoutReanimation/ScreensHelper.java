package com.swmansion.reanimated.layoutReanimation;

import android.util.Log;
import android.view.View;
import com.swmansion.rnscreens.ScreenFragment;
import com.swmansion.rnscreens.ScreenStack;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class ScreensHelper {
    public static View getTabNavigator(View view) {
        while (view != null) {
            if (isScreenContainer(view)) {
                return view;
            }
            if (isScreen(view) && isScreensCoordinatorLayout(view.getParent())) {
                try {
                    view = (View) view.getClass().getMethod("getContainer", new Class[0]).invoke(view, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    Log.e("[Reanimated]", e.getMessage() != null ? e.getMessage() : "Unable to invoke the getContainer method");
                    return null;
                }
            } else {
                if (!(view.getParent() instanceof View)) {
                    return null;
                }
                view = (View) view.getParent();
            }
        }
        return null;
    }

    public static boolean isViewChildOfScreen(View view, View view2) {
        while (view != null) {
            if (view == view2) {
                return true;
            }
            if (!(view.getParent() instanceof View)) {
                return false;
            }
            view = (View) view.getParent();
        }
        return false;
    }

    public static View getTopScreenForStack(View view) {
        if (isScreenStack(view)) {
            try {
                return (View) view.getClass().getMethod("getTopScreen", new Class[0]).invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return view;
    }

    public static boolean isScreen(Object obj) {
        return isInstanceOf(obj, "Screen");
    }

    public static boolean isScreenStack(Object obj) {
        return isInstanceOf(obj, ScreenStack.TAG);
    }

    public static boolean isScreenContainer(Object obj) {
        return isInstanceOf(obj, "ScreenContainer");
    }

    public static boolean isScreensCoordinatorLayout(Object obj) {
        return isInstanceOf(obj, "ScreensCoordinatorLayout");
    }

    public static boolean isScreenFragment(Object obj) {
        return isInstanceOf(obj, ScreenFragment.TAG);
    }

    private static boolean isInstanceOf(Object obj, String str) {
        return obj != null && obj.getClass().getSimpleName().equals(str);
    }
}
