package com.appdynamics.eumagent.runtime.p000private;

import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class cn<T> implements Iterable<T> {
    private final ArrayDeque<T> a = new ArrayDeque<>();
    private final int b = 99;

    public final synchronized void a(T t) {
        try {
            if (this.a.size() == 99) {
                this.a.removeFirst();
            }
            this.a.add(t);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.lang.Iterable
    public final synchronized Iterator<T> iterator() {
        return this.a.clone().iterator();
    }
}
