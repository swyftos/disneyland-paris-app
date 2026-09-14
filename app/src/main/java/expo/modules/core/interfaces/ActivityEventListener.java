package expo.modules.core.interfaces;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface ActivityEventListener {
    void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent);

    void onNewIntent(Intent intent);
}
