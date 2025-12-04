package com.urbanairship.preferencecenter.ui;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes5.dex */
/* synthetic */ class PreferenceCenterFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function0 {
    PreferenceCenterFragment$onViewCreated$1$1(Object obj) {
        super(0, obj, RecyclerView.class, "isAnimating", "isAnimating()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((RecyclerView) this.receiver).isAnimating());
    }
}
