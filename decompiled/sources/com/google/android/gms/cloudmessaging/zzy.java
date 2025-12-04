package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
final class zzy extends com.google.android.gms.internal.cloudmessaging.zze {
    private final /* synthetic */ Rpc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zza.zza(message);
    }
}
