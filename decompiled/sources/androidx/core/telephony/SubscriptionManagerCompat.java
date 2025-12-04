package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
/* loaded from: classes.dex */
public class SubscriptionManagerCompat {
    public static int getSlotIndex(int i) {
        if (i == -1) {
            return -1;
        }
        return Api29Impl.getSlotIndex(i);
    }

    private static class Api29Impl {
        static int getSlotIndex(int i) {
            return SubscriptionManager.getSlotIndex(i);
        }
    }
}
