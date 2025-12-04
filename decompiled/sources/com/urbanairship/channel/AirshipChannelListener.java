package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

/* loaded from: classes5.dex */
public interface AirshipChannelListener {
    @WorkerThread
    void onChannelCreated(@NonNull String str);
}
