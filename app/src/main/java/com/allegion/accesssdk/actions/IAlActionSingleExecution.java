package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.actions.interfaces.IAlAction;
import io.reactivex.Single;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
interface IAlActionSingleExecution<Q, P> extends IAlAction<Q, Single<P>> {
    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    Single<P> run(Q q);
}
