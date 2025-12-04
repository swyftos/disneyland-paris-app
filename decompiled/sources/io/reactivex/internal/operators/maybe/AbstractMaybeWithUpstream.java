package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* loaded from: classes5.dex */
abstract class AbstractMaybeWithUpstream extends Maybe implements HasUpstreamMaybeSource {
    protected final MaybeSource<Object> source;

    AbstractMaybeWithUpstream(MaybeSource maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public final MaybeSource<Object> source() {
        return this.source;
    }
}
