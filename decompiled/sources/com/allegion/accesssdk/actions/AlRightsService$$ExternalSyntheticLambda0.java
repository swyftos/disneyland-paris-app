package com.allegion.accesssdk.actions;

import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class AlRightsService$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ AlRightsService f$0;

    public /* synthetic */ AlRightsService$$ExternalSyntheticLambda0(AlRightsService alRightsService) {
        this.f$0 = alRightsService;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.errorMapping((Throwable) obj);
    }
}
