package expo.modules.core.interfaces;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;

/* JADX INFO: loaded from: classes5.dex */
public interface ReactActivityHandler {

    public interface DelayLoadAppHandler {
        void whenReady(Runnable runnable);
    }

    @Nullable
    default ViewGroup createReactRootViewContainer(Activity activity) {
        return null;
    }

    @Nullable
    default DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity reactActivity, ReactNativeHost reactNativeHost) {
        return null;
    }

    @Nullable
    default ReactActivityDelegate onDidCreateReactActivityDelegate(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
        return null;
    }

    default boolean onKeyDown(int i, @Nullable KeyEvent keyEvent) {
        return false;
    }

    default boolean onKeyLongPress(int i, @Nullable KeyEvent keyEvent) {
        return false;
    }

    default boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }
}
