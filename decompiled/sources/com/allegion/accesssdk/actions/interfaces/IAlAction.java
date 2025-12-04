package com.allegion.accesssdk.actions.interfaces;

import com.allegion.accesssdk.exceptions.AlException;
import kotlin.Metadata;

@FunctionalInterface
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\ba\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/allegion/accesssdk/actions/interfaces/IAlAction;", "Q", "P", "", "request", "run", "(Ljava/lang/Object;)Ljava/lang/Object;", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlAction<Q, P> {
    P run(Q request) throws AlException;
}
