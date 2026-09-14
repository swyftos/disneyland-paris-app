package androidx.test.espresso.action;

import androidx.test.espresso.UiController;

/* JADX INFO: loaded from: classes2.dex */
public interface Swiper {

    public enum Status {
        SUCCESS,
        FAILURE
    }

    Status sendSwipe(UiController uiController, float[] fArr, float[] fArr2, float[] fArr3);
}
