package com.urbanairship.push;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes5.dex */
public interface PushListener {
    @WorkerThread
    void onPushReceived(@NonNull PushMessage pushMessage, boolean z);
}
