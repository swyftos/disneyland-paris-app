package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class MethodUtils$$ExternalSyntheticLambda6 implements Consumer {
    public final /* synthetic */ List f$0;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add((Method) obj);
    }
}
