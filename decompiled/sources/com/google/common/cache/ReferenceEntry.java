package com.google.common.cache;

import com.google.common.cache.LocalCache;

/* loaded from: classes4.dex */
interface ReferenceEntry {
    long getAccessTime();

    int getHash();

    Object getKey();

    ReferenceEntry getNext();

    ReferenceEntry getNextInAccessQueue();

    ReferenceEntry getNextInWriteQueue();

    ReferenceEntry getPreviousInAccessQueue();

    ReferenceEntry getPreviousInWriteQueue();

    LocalCache.ValueReference getValueReference();

    long getWriteTime();

    void setAccessTime(long j);

    void setNextInAccessQueue(ReferenceEntry referenceEntry);

    void setNextInWriteQueue(ReferenceEntry referenceEntry);

    void setPreviousInAccessQueue(ReferenceEntry referenceEntry);

    void setPreviousInWriteQueue(ReferenceEntry referenceEntry);

    void setValueReference(LocalCache.ValueReference valueReference);

    void setWriteTime(long j);
}
