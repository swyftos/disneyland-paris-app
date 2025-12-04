package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

/* loaded from: classes5.dex */
abstract class AbstractObservableWithUpstream extends Observable implements HasUpstreamObservableSource {
    protected final ObservableSource<Object> source;

    AbstractObservableWithUpstream(ObservableSource observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public final ObservableSource<Object> source() {
        return this.source;
    }
}
