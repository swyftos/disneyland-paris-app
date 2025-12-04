package androidx.test.espresso.base;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.UiController$$CC;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.platform.ui.UiController;

/* loaded from: classes2.dex */
public class UiControllerModule {

    private static class EspressoUiControllerAdapter implements InterruptableUiController {
        private final UiController platformUiController;

        private EspressoUiControllerAdapter(UiController uiController) {
            this.platformUiController = uiController;
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectKeyEvent(KeyEvent keyEvent) throws InjectEventSecurityException {
            try {
                return this.platformUiController.injectKeyEvent(keyEvent);
            } catch (androidx.test.platform.ui.InjectEventSecurityException e) {
                throw new InjectEventSecurityException(e);
            }
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectMotionEvent(MotionEvent motionEvent) throws InjectEventSecurityException {
            try {
                return this.platformUiController.injectMotionEvent(motionEvent);
            } catch (androidx.test.platform.ui.InjectEventSecurityException e) {
                throw new InjectEventSecurityException(e);
            }
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectMotionEventSequence(Iterable iterable) {
            return UiController$$CC.injectMotionEventSequence$$dflt$$(this, iterable);
        }

        @Override // androidx.test.espresso.UiController
        public boolean injectString(String str) throws InjectEventSecurityException {
            try {
                return this.platformUiController.injectString(str);
            } catch (androidx.test.platform.ui.InjectEventSecurityException e) {
                throw new InjectEventSecurityException(e);
            }
        }

        @Override // androidx.test.espresso.base.InterruptableUiController
        public void interruptEspressoTasks() {
            Log.w("UiController", "interruptEspressoTasks called, no-op");
        }

        @Override // androidx.test.espresso.UiController
        public void loopMainThreadForAtLeast(long j) {
            this.platformUiController.loopMainThreadForAtLeast(j);
        }

        @Override // androidx.test.espresso.UiController
        public void loopMainThreadUntilIdle() {
            this.platformUiController.loopMainThreadUntilIdle();
        }
    }

    public androidx.test.espresso.UiController provideUiController(UiControllerImpl uiControllerImpl) {
        UiController uiController = (UiController) ServiceLoaderWrapper.loadSingleServiceOrNull(UiController.class);
        return uiController == null ? uiControllerImpl : new EspressoUiControllerAdapter(uiController);
    }
}
