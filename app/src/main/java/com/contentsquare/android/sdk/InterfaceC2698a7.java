package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.a7 */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2698a7 {
    @NotNull
    /* JADX INFO: renamed from: a */
    int mo890a();

    @Nullable
    /* JADX INFO: renamed from: a */
    Object mo891a(@NotNull Continuation<? super Unit> continuation);

    @NotNull
    /* JADX INFO: renamed from: b */
    EnumC2760h mo892b();

    @Nullable
    /* JADX INFO: renamed from: b */
    Object mo893b(@NotNull Continuation<? super JSONObject> continuation);

    /* JADX INFO: renamed from: c */
    void mo894c();

    void start();
}
