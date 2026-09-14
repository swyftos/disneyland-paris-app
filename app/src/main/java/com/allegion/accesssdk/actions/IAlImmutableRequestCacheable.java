package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.interfaces.IAlRequestCacheable;

/* JADX INFO: loaded from: classes2.dex */
public interface IAlImmutableRequestCacheable<P> extends IAlRequestCacheable {
    String getCacheKey();

    Class<P> getResponseType();
}
