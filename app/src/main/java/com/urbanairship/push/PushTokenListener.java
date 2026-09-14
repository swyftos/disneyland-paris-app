package com.urbanairship.push;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes5.dex */
public interface PushTokenListener {
    @WorkerThread
    void onPushTokenUpdated(@NonNull String str);
}
