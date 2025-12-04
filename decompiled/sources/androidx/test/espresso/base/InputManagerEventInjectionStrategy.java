package androidx.test.espresso.base;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class InputManagerEventInjectionStrategy implements EventInjectionStrategy {
    private int asyncEventMode;
    private boolean initComplete;
    private Method injectInputEventMethod;
    private Object instanceInputManagerObject;
    private Method setSourceMotionMethod;
    private int syncEventMode;

    InputManagerEventInjectionStrategy() {
        Preconditions.checkState(true, "Unsupported API level.");
    }

    private boolean innerInjectMotionEvent(MotionEvent motionEvent, boolean z, boolean z2) throws IllegalAccessException, InjectEventSecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if ((motionEvent.getSource() & 2) == 0 && !isFromTouchpadInGlassDevice(motionEvent)) {
                this.setSourceMotionMethod.invoke(motionEvent, Integer.valueOf(InputDeviceCompat.SOURCE_TOUCHSCREEN));
            }
            return ((Boolean) this.injectInputEventMethod.invoke(this.instanceInputManagerObject, motionEvent, Integer.valueOf(z2 ? this.syncEventMode : this.asyncEventMode))).booleanValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (SecurityException e3) {
            throw new InjectEventSecurityException(e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (!(cause instanceof SecurityException)) {
                throw new RuntimeException(e4);
            }
            if (!z) {
                throw new InjectEventSecurityException(cause);
            }
            Log.w("EventInjectionStrategy", "Error performing a ViewAction! soft keyboard dismissal animation may have been in the way. Retrying once after: 1000 millis");
            SystemClock.sleep(1000L);
            this.innerInjectMotionEvent(motionEvent, false, z2);
            return false;
        }
    }

    private static boolean isFromTouchpadInGlassDevice(MotionEvent motionEvent) {
        String str = Build.DEVICE;
        return (str.contains("glass") || str.contains("Glass") || str.contains("wingman")) && (motionEvent.getSource() & InputDeviceCompat.SOURCE_TOUCHPAD) != 0;
    }

    void initialize() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.initComplete) {
            return;
        }
        try {
            Log.d("EventInjectionStrategy", "Creating injection strategy with input manager.");
            Class<?> cls = Class.forName("android.hardware.input.InputManager");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(cls, new Object[0]);
            this.instanceInputManagerObject = objInvoke;
            Class<?> cls2 = objInvoke.getClass();
            Class cls3 = Integer.TYPE;
            Method declaredMethod2 = cls2.getDeclaredMethod("injectInputEvent", InputEvent.class, cls3);
            this.injectInputEventMethod = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Field field = cls.getField("INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH");
            field.setAccessible(true);
            this.syncEventMode = field.getInt(cls);
            this.asyncEventMode = 0;
            this.setSourceMotionMethod = MotionEvent.class.getDeclaredMethod("setSource", cls3);
            this.initComplete = true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // androidx.test.espresso.base.EventInjectionStrategy
    public boolean injectKeyEvent(KeyEvent keyEvent) throws InjectEventSecurityException {
        try {
            return ((Boolean) this.injectInputEventMethod.invoke(this.instanceInputManagerObject, keyEvent, Integer.valueOf(this.syncEventMode))).booleanValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e2) {
            throw new InjectEventSecurityException(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof SecurityException) {
                throw new InjectEventSecurityException(cause);
            }
            throw new RuntimeException(e3);
        }
    }

    @Override // androidx.test.espresso.base.EventInjectionStrategy
    public boolean injectMotionEvent(MotionEvent motionEvent, boolean z) {
        return innerInjectMotionEvent(motionEvent, true, z);
    }
}
