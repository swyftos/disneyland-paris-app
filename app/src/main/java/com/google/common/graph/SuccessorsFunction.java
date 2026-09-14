package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: classes4.dex */
@DoNotMock("Implement with a lambda, or use GraphBuilder to build a Graph with the desired edges")
@Beta
public interface SuccessorsFunction<N> {
    Iterable<? extends N> successors(N n);
}
