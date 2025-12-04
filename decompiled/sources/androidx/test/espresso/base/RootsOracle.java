package androidx.test.espresso.base;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.test.espresso.Root;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RootsOracle implements ActiveRootLister {
    private static final String TAG = "RootsOracle";
    private boolean initialized;
    private final Looper mainLooper;
    private Field paramsField;
    private Field viewsField;
    private Object windowManagerObj;

    RootsOracle(Looper looper) {
        this.mainLooper = looper;
    }

    private void initialize() throws NoSuchFieldException, ClassNotFoundException, SecurityException {
        this.initialized = true;
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            this.windowManagerObj = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            this.viewsField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mParams");
            this.paramsField = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, String.format(Locale.ROOT, "could not find class: %s", "android.view.WindowManagerGlobal"), e);
        } catch (IllegalAccessException e2) {
            Log.e(TAG, String.format(Locale.ROOT, "reflective setup failed using obj: %s method: %s field: %s", "android.view.WindowManagerGlobal", "getInstance", "mViews"), e2);
        } catch (NoSuchFieldException e3) {
            Log.e(TAG, String.format(Locale.ROOT, "could not find field: %s or %s on %s", "mParams", "mViews", "android.view.WindowManagerGlobal"), e3);
        } catch (NoSuchMethodException e4) {
            Log.e(TAG, String.format(Locale.ROOT, "could not find method: %s on %s", "getInstance", "android.view.WindowManagerGlobal"), e4);
        } catch (RuntimeException e5) {
            Log.e(TAG, String.format(Locale.ROOT, "reflective setup failed using obj: %s method: %s field: %s", "android.view.WindowManagerGlobal", "getInstance", "mViews"), e5);
        } catch (InvocationTargetException e6) {
            Log.e(TAG, String.format(Locale.ROOT, "could not invoke: %s on %s", "getInstance", "android.view.WindowManagerGlobal"), e6.getCause());
        }
    }

    @Override // androidx.test.espresso.base.ActiveRootLister
    public List listActiveRoots() throws NoSuchFieldException, ClassNotFoundException, SecurityException {
        Preconditions.checkState(this.mainLooper.equals(Looper.myLooper()), "must be called on main thread.");
        if (!this.initialized) {
            initialize();
        }
        Object obj = this.windowManagerObj;
        if (obj == null) {
            Log.w(TAG, "No reflective access to windowmanager object.");
            return Lists.newArrayList();
        }
        Field field = this.viewsField;
        if (field == null) {
            Log.w(TAG, "No reflective access to mViews");
            return Lists.newArrayList();
        }
        if (this.paramsField == null) {
            Log.w(TAG, "No reflective access to mParams");
            return Lists.newArrayList();
        }
        try {
            List list = (List) field.get(obj);
            List list2 = (List) this.paramsField.get(this.windowManagerObj);
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            int size = list.size();
            while (true) {
                size--;
                if (size < 0) {
                    return arrayListNewArrayList;
                }
                arrayListNewArrayList.add(new Root.Builder().withDecorView((View) list.get(size)).withWindowLayoutParams((WindowManager.LayoutParams) list2.get(size)).build());
            }
        } catch (IllegalAccessException e) {
            Log.w(TAG, String.format(Locale.ROOT, "Reflective access to %s or %s on %s failed.", this.viewsField, this.paramsField, this.windowManagerObj), e);
            return Lists.newArrayList();
        } catch (RuntimeException e2) {
            Log.w(TAG, String.format(Locale.ROOT, "Reflective access to %s or %s on %s failed.", this.viewsField, this.paramsField, this.windowManagerObj), e2);
            return Lists.newArrayList();
        }
    }
}
