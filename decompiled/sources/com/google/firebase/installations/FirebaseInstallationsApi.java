package com.google.firebase.installations;

import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public interface FirebaseInstallationsApi {
    Task<Void> delete();

    Task<String> getId();

    Task<InstallationTokenResult> getToken(boolean z);
}
