package com.appdynamics.eumagent.runtime.p192private;

import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cn */
/* JADX INFO: loaded from: classes2.dex */
public final class C2118cn<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a */
    private final ArrayDeque<T> f811a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b */
    private final int f812b = 99;

    /* JADX INFO: renamed from: a */
    public final synchronized void m651a(T t) {
        try {
            if (this.f811a.size() == 99) {
                this.f811a.removeFirst();
            }
            this.f811a.add(t);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.lang.Iterable
    public final synchronized Iterator<T> iterator() {
        return this.f811a.clone().iterator();
    }
}
