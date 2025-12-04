package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

/* loaded from: classes5.dex */
abstract class AbstractFlowableWithUpstream extends Flowable implements HasUpstreamPublisher {
    protected final Flowable<Object> source;

    AbstractFlowableWithUpstream(Flowable flowable) {
        this.source = (Flowable) ObjectHelper.requireNonNull(flowable, "source is null");
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public final Publisher<Object> source() {
        return this.source;
    }
}
