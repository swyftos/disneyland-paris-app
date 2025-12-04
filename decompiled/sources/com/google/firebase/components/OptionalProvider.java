package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes4.dex */
class OptionalProvider implements Provider, Deferred {
    private volatile Provider delegate;
    private Deferred.DeferredHandler handler;
    private static final Deferred.DeferredHandler NOOP_HANDLER = OptionalProvider$$Lambda$4.instance;
    private static final Provider EMPTY_PROVIDER = OptionalProvider$$Lambda$5.instance;

    static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    private OptionalProvider(Deferred.DeferredHandler deferredHandler, Provider provider) {
        this.handler = deferredHandler;
        this.delegate = provider;
    }

    static OptionalProvider empty() {
        return new OptionalProvider(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    static OptionalProvider of(Provider provider) {
        return new OptionalProvider(null, provider);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return this.delegate.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(Provider provider) {
        Deferred.DeferredHandler deferredHandler;
        if (this.delegate != EMPTY_PROVIDER) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            deferredHandler = this.handler;
            this.handler = null;
            this.delegate = provider;
        }
        deferredHandler.handle(provider);
    }

    @Override // com.google.firebase.inject.Deferred
    public void whenAvailable(Deferred.DeferredHandler deferredHandler) {
        Provider provider;
        Provider provider2;
        Provider provider3 = this.delegate;
        Provider provider4 = EMPTY_PROVIDER;
        if (provider3 != provider4) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.delegate;
            if (provider != provider4) {
                provider2 = provider;
            } else {
                this.handler = OptionalProvider$$Lambda$1.lambdaFactory$(this.handler, deferredHandler);
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }

    static /* synthetic */ void lambda$whenAvailable$2(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }
}
