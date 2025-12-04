package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.actions.IAlImmutableRequestCacheable;
import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.exceptions.AlStorageException;
import com.allegion.logging.AlLog;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class AlCacheStorageDecorator<Q extends IAlImmutableRequestCacheable<P>, P extends Serializable> implements IAlActionSingleExecution<Q, P> {
    private final IAlActionSingleExecution<Q, P> action;
    private final IAlStorageService storageService;

    AlCacheStorageDecorator(IAlActionSingleExecution<Q, P> iAlActionSingleExecution) {
        AlErrorCode alErrorCode = AlErrorCode.SDK_NULL_VALUE_ERROR;
        this.action = (IAlActionSingleExecution) AlObjects.requireNonNull(iAlActionSingleExecution, "Action must not be null", alErrorCode);
        this.storageService = (IAlStorageService) AlObjects.requireNonNull((IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class), "Storage service must not be null", alErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$run$0(IAlImmutableRequestCacheable iAlImmutableRequestCacheable, Serializable serializable) throws Exception {
        this.storageService.store(iAlImmutableRequestCacheable.getCacheKey(), serializable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$run$1(final IAlImmutableRequestCacheable iAlImmutableRequestCacheable) throws Exception {
        Serializable serializableRetrieve;
        try {
            if (!iAlImmutableRequestCacheable.getIgnoreCache() && this.storageService.contains(iAlImmutableRequestCacheable.getCacheKey()) && (serializableRetrieve = this.storageService.retrieve(iAlImmutableRequestCacheable.getCacheKey(), iAlImmutableRequestCacheable.getResponseType())) != null) {
                return Single.just(serializableRetrieve);
            }
        } catch (AlStorageException e) {
            AlLog.e(e);
        }
        return this.action.run((IAlActionSingleExecution<Q, P>) iAlImmutableRequestCacheable).doOnSuccess(new Consumer() { // from class: com.allegion.accesssdk.actions.AlCacheStorageDecorator$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$run$0(iAlImmutableRequestCacheable, (Serializable) obj);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single<P> run(final Q q) {
        return Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlCacheStorageDecorator$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$run$1(q);
            }
        });
    }
}
