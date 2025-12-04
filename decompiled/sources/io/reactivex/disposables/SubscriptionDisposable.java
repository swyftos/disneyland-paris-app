package io.reactivex.disposables;

import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
final class SubscriptionDisposable extends ReferenceDisposable {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(Subscription subscription) {
        subscription.cancel();
    }
}
