package com.allegion.accesssdk.actions;

import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class AlEnrollmentProvidable$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ AlEnrollmentProvidable f$0;

    public /* synthetic */ AlEnrollmentProvidable$$ExternalSyntheticLambda0(AlEnrollmentProvidable alEnrollmentProvidable) {
        this.f$0 = alEnrollmentProvidable;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.errorMapping((Throwable) obj);
    }
}
