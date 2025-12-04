package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlRequestCacheable;
import com.allegion.logging.AlLog;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class AlCacheMemoryDecorator<Q extends IAlRequestCacheable, P> implements IAlActionSingleExecution<Q, P> {
    private static ConcurrentHashMap<Object, Object> memoryCache = new ConcurrentHashMap<>();
    private final IAlActionSingleExecution<Q, P> action;

    AlCacheMemoryDecorator(IAlActionSingleExecution<Q, P> iAlActionSingleExecution) {
        this.action = (IAlActionSingleExecution) AlObjects.requireNonNull(iAlActionSingleExecution, "Action must not be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$0(IAlRequestCacheable iAlRequestCacheable, Object obj) throws Exception {
        memoryCache.put(iAlRequestCacheable, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$run$1(final IAlRequestCacheable iAlRequestCacheable) throws Exception {
        Object obj;
        try {
            if (!iAlRequestCacheable.getIgnoreCache() && memoryCache.containsKey(iAlRequestCacheable) && (obj = memoryCache.get(iAlRequestCacheable)) != null) {
                return Single.just(obj);
            }
        } catch (Exception e) {
            AlLog.e(e);
        }
        return this.action.run((IAlActionSingleExecution<Q, P>) iAlRequestCacheable).doOnSuccess(new Consumer() { // from class: com.allegion.accesssdk.actions.AlCacheMemoryDecorator$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) throws Exception {
                AlCacheMemoryDecorator.lambda$run$0(iAlRequestCacheable, obj2);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single<P> run(final Q q) {
        return Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlCacheMemoryDecorator$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$run$1(q);
            }
        });
    }
}
