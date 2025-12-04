package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

/* loaded from: classes6.dex */
final class CacheEntry {
    public final KSerializer serializer;

    public CacheEntry(KSerializer kSerializer) {
        this.serializer = kSerializer;
    }
}
