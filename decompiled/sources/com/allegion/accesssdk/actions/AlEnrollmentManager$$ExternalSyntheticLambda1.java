package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.listeners.IAlListener;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class AlEnrollmentManager$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ IAlListener f$0;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.onError((Throwable) obj);
    }
}
