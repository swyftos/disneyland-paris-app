package com.urbanairship.liveupdate;

import com.urbanairship.liveupdate.LiveUpdateProcessor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\t"}, d2 = {"notificationTag", "", "Lcom/urbanairship/liveupdate/LiveUpdate;", "getNotificationTag", "(Lcom/urbanairship/liveupdate/LiveUpdate;)Ljava/lang/String;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$NotificationCancel;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$NotificationCancel;)Ljava/lang/String;", "type", "name", "urbanairship-live-update_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LiveUpdateRegistrarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getNotificationTag(LiveUpdate liveUpdate) {
        return notificationTag(liveUpdate.getType(), liveUpdate.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getNotificationTag(LiveUpdateProcessor.NotificationCancel notificationCancel) {
        return notificationTag(notificationCancel.getType(), notificationCancel.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String notificationTag(String str, String str2) {
        return str + ':' + str2;
    }
}
