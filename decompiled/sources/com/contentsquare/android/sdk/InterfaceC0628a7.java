package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.a7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0628a7 {
    @NotNull
    int a();

    @Nullable
    Object a(@NotNull Continuation<? super Unit> continuation);

    @NotNull
    EnumC0690h b();

    @Nullable
    Object b(@NotNull Continuation<? super JSONObject> continuation);

    void c();

    void start();
}
