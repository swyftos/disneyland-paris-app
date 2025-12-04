package com.allegion.accesssdk.models;

import com.allegion.accesssdk.interfaces.IAlRequestCacheable;

/* loaded from: classes2.dex */
public final class AlPullRightsRequest implements IAlRequestCacheable {
    private boolean ignoreCache;

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    public AlPullRightsRequest setIgnoreCache(boolean z) {
        this.ignoreCache = z;
        return this;
    }
}
