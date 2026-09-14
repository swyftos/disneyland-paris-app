package coil3.content;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.channel.AttributeMutation;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0017J\b\u0010\"\u001a\u00020\u0005H\u0002J\u001d\u0010#\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, m1836d2 = {"Lcoil3/util/LruCache;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "maxSize", "", "<init>", "(J)V", "getMaxSize", "()J", "map", "", "value", TCEventPropertiesNames.TCP_SIZE, "getSize", "keys", "", "getKeys", "()Ljava/util/Set;", "sizeOf", "key", "(Ljava/lang/Object;Ljava/lang/Object;)J", "entryRemoved", "", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "trimToSize", "clear", "recomputeSize", "safeSizeOf", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\ncoil3/util/LruCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
public class LruCache<K, V> {
    private final Map map = Collections_jvmCommonKt.LruMutableMap$default(0, BitmapDescriptorFactory.HUE_RED, 3, null);
    private final long maxSize;
    private long size;

    public void entryRemoved(@NotNull K key, @NotNull V oldValue, @Nullable V newValue) {
    }

    public long sizeOf(@NotNull K key, @NotNull V value) {
        return 1L;
    }

    public LruCache(long j) {
        this.maxSize = j;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public final long getMaxSize() {
        return this.maxSize;
    }

    public final long getSize() {
        if (this.size == -1) {
            this.size = recomputeSize();
        }
        return this.size;
    }

    @NotNull
    public final Set<K> getKeys() {
        return CollectionsKt.toSet(this.map.keySet());
    }

    @Nullable
    public final V put(@NotNull K key, @NotNull V value) {
        V v = (V) this.map.put(key, value);
        this.size = getSize() + safeSizeOf(key, value);
        if (v != null) {
            this.size = getSize() - safeSizeOf(key, v);
            entryRemoved(key, v, value);
        }
        trimToSize(this.maxSize);
        return v;
    }

    @Nullable
    public final V get(@NotNull K key) {
        return (V) this.map.get(key);
    }

    @Nullable
    public final V remove(@NotNull K key) {
        V v = (V) this.map.remove(key);
        if (v != null) {
            this.size = getSize() - safeSizeOf(key, v);
            entryRemoved(key, v, null);
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void trimToSize(long size) {
        while (getSize() > size) {
            if (this.map.isEmpty()) {
                if (getSize() != 0) {
                    throw new IllegalStateException("sizeOf() is returning inconsistent values");
                }
                return;
            }
            Map.Entry entry = (Map.Entry) CollectionsKt.first(this.map.entrySet());
            Object key = entry.getKey();
            Object value = entry.getValue();
            this.map.remove(key);
            this.size = getSize() - safeSizeOf(key, value);
            entryRemoved(key, value, null);
        }
    }

    public final void clear() {
        trimToSize(-1L);
    }

    private final long recomputeSize() {
        Iterator<T> it = this.map.entrySet().iterator();
        long jSafeSizeOf = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jSafeSizeOf += safeSizeOf(entry.getKey(), entry.getValue());
        }
        return jSafeSizeOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long safeSizeOf(Object key, Object value) throws Exception {
        try {
            long jSizeOf = sizeOf(key, value);
            if (jSizeOf >= 0) {
                return jSizeOf;
            }
            throw new IllegalStateException(("sizeOf(" + key + ", " + value + ") returned a negative value: " + jSizeOf).toString());
        } catch (Exception e) {
            this.size = -1L;
            throw e;
        }
    }
}
