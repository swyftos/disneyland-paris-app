package expo.modules.core.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public interface ReactActivityLifecycleListener {
    default boolean onBackPressed() {
        return false;
    }

    default void onContentChanged(Activity activity) {
    }

    default void onCreate(Activity activity, Bundle bundle) {
    }

    default void onDestroy(Activity activity) {
    }

    default boolean onNewIntent(Intent intent) {
        return false;
    }

    default void onPause(Activity activity) {
    }

    default void onResume(Activity activity) {
    }

    default void onUserLeaveHint(Activity activity) {
    }
}
