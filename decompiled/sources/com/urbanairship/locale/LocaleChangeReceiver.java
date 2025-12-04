package com.urbanairship.locale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class LocaleChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null || !"android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
            return;
        }
        if (!UAirship.isTakingOff() && !UAirship.isFlying()) {
            UALog.e("LocaleChangedReceiver - unable to receive intent, takeOff not called.", new Object[0]);
        } else {
            Autopilot.automaticTakeOff(context);
            UAirship.shared().getLocaleManager().onDeviceLocaleChanged();
        }
    }
}
