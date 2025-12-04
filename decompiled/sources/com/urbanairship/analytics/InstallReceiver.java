package com.urbanairship.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;

/* loaded from: classes4.dex */
public class InstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        Autopilot.automaticTakeOff(context);
        if (!UAirship.isTakingOff() && !UAirship.isFlying()) {
            UALog.e("InstallReceiver - unable to track install referrer, takeOff not called.", new Object[0]);
            return;
        }
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(TCEventPropertiesNames.TCE_REFERRER);
        if (UAStringUtil.isEmpty(stringExtra) || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            UALog.d("missing referrer or invalid action.", new Object[0]);
        } else {
            UAirship.shared().getAnalytics().addEvent(new InstallAttributionEvent(stringExtra));
        }
    }
}
