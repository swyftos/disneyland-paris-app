package androidx.test.espresso.action;

import android.view.MotionEvent;
import androidx.test.espresso.UiController;
import androidx.test.espresso.action.Swiper;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import com.google.android.gms.common.ConnectionResult;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public enum Swipe implements Swiper {
    FAST { // from class: androidx.test.espresso.action.Swipe.1
        @Override // androidx.test.espresso.action.Swiper
        public Swiper.Status sendSwipe(UiController uiController, float[] fArr, float[] fArr2, float[] fArr3) {
            return Swipe.sendLinearSwipe(uiController, fArr, fArr2, fArr3, 150);
        }
    },
    SLOW { // from class: androidx.test.espresso.action.Swipe.2
        @Override // androidx.test.espresso.action.Swiper
        public Swiper.Status sendSwipe(UiController uiController, float[] fArr, float[] fArr2, float[] fArr3) {
            return Swipe.sendLinearSwipe(uiController, fArr, fArr2, fArr3, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
    };

    private static final String TAG = Swipe.class.getSimpleName();

    private static float[][] interpolate(float[] fArr, float[] fArr2, int i) {
        Preconditions.checkElementIndex(1, fArr.length);
        Preconditions.checkElementIndex(1, fArr2.length);
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 2);
        for (int i2 = 1; i2 < i + 1; i2++) {
            float[] fArr4 = fArr3[i2 - 1];
            float f = fArr[0];
            float f2 = i2;
            float f3 = i + 2.0f;
            fArr4[0] = f + (((fArr2[0] - f) * f2) / f3);
            float f4 = fArr[1];
            fArr4[1] = f4 + (((fArr2[1] - f4) * f2) / f3);
        }
        return fArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Swiper.Status sendLinearSwipe(UiController uiController, float[] fArr, float[] fArr2, float[] fArr3, int i) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(fArr);
        Preconditions.checkNotNull(fArr2);
        Preconditions.checkNotNull(fArr3);
        float[][] fArrInterpolate = interpolate(fArr, fArr2, 10);
        ArrayList arrayList = new ArrayList();
        MotionEvent motionEventObtainDownEvent = MotionEvents.obtainDownEvent(fArr, fArr3);
        arrayList.add(motionEventObtainDownEvent);
        try {
            try {
                long length = i / fArrInterpolate.length;
                long downTime = motionEventObtainDownEvent.getDownTime();
                for (float[] fArr4 : fArrInterpolate) {
                    downTime += length;
                    arrayList.add(MotionEvents.obtainMovement(motionEventObtainDownEvent.getDownTime(), downTime, fArr4));
                }
                arrayList.add(MotionEvent.obtain(motionEventObtainDownEvent.getDownTime(), length + downTime, 1, fArr2[0], fArr2[1], 0));
                uiController.injectMotionEventSequence(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionEvent) it.next()).recycle();
                }
                return Swiper.Status.SUCCESS;
            } catch (Exception unused) {
                Swiper.Status status = Swiper.Status.FAILURE;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((MotionEvent) it2.next()).recycle();
                }
                return status;
            }
        } catch (Throwable th) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((MotionEvent) it3.next()).recycle();
            }
            throw th;
        }
    }
}
