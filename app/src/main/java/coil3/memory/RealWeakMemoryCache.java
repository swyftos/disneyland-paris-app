package coil3.memory;

import androidx.media3.common.MimeTypes;
import coil3.Image;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.channel.AttributeMutation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\r\u0010$\u001a\u00020\u0017H\u0000¢\u0006\u0002\b%RP\u0010\u0004\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0005j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t`\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, m1836d2 = {"Lcoil3/memory/RealWeakMemoryCache;", "Lcoil3/memory/WeakMemoryCache;", "<init>", "()V", "cache", "Ljava/util/LinkedHashMap;", "Lcoil3/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil3/memory/RealWeakMemoryCache$InternalValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "getCache$coil_core_release", "()Ljava/util/LinkedHashMap;", "operationsSinceCleanUp", "", "keys", "", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", AttributeMutation.ATTRIBUTE_ACTION_SET, "", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "extras", "", "", "", TCEventPropertiesNames.TCP_SIZE, "", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "", "clear", "cleanUpIfNecessary", "cleanUp", "cleanUp$coil_core_release", "InternalValue", "Companion", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nWeakMemoryCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeakMemoryCache.kt\ncoil3/memory/RealWeakMemoryCache\n+ 2 collections.kt\ncoil3/util/CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,146:1\n90#2,2:147\n93#2:151\n101#2,9:159\n1#3:149\n1#3:150\n381#4,7:152\n*S KotlinDebug\n*F\n+ 1 WeakMemoryCache.kt\ncoil3/memory/RealWeakMemoryCache\n*L\n57#1:147,2\n57#1:151\n126#1:159,9\n57#1:150\n71#1:152,7\n*E\n"})
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private final LinkedHashMap cache = new LinkedHashMap();
    private int operationsSinceCleanUp;

    @NotNull
    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$coil_core_release() {
        return this.cache;
    }

    @Override // coil3.memory.WeakMemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        return CollectionsKt.toSet(this.cache.keySet());
    }

    @Override // coil3.memory.WeakMemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        ArrayList arrayList = (ArrayList) this.cache.get(key);
        MemoryCache.Value value = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            InternalValue internalValue = (InternalValue) arrayList.get(i);
            Image image = internalValue.getImage().get();
            MemoryCache.Value value2 = image != null ? new MemoryCache.Value(image, internalValue.getExtras()) : null;
            if (value2 != null) {
                value = value2;
                break;
            }
        }
        cleanUpIfNecessary();
        return value;
    }

    @Override // coil3.memory.WeakMemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> extras, long size) {
        LinkedHashMap linkedHashMap = this.cache;
        Object arrayList = linkedHashMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList();
            linkedHashMap.put(key, arrayList);
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        InternalValue internalValue = new InternalValue(new WeakReference(image), extras, size);
        if (arrayList2.isEmpty()) {
            arrayList2.add(internalValue);
        } else {
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                InternalValue internalValue2 = (InternalValue) arrayList2.get(i);
                if (size >= internalValue2.getSize()) {
                    if (internalValue2.getImage().get() == image) {
                        arrayList2.set(i, internalValue);
                        break;
                    } else {
                        arrayList2.add(i, internalValue);
                        break;
                    }
                }
            }
        }
        cleanUpIfNecessary();
    }

    @Override // coil3.memory.WeakMemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        return this.cache.remove(key) != null;
    }

    @Override // coil3.memory.WeakMemoryCache
    public void clear() {
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$coil_core_release();
        }
    }

    public final void cleanUp$coil_core_release() {
        WeakReference<Image> image;
        this.operationsSinceCleanUp = 0;
        Iterator it = this.cache.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() > 1) {
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = i2 - i;
                    if (((InternalValue) arrayList.get(i3)).getImage().get() == null) {
                        arrayList.remove(i3);
                        i++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            } else {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull((List) arrayList);
                if (((internalValue == null || (image = internalValue.getImage()) == null) ? null : image.get()) == null) {
                    it.remove();
                }
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1836d2 = {"Lcoil3/memory/RealWeakMemoryCache$InternalValue;", "", MimeTypes.BASE_TYPE_IMAGE, "Ljava/lang/ref/WeakReference;", "Lcoil3/Image;", "Lcoil3/util/WeakReference;", "extras", "", "", TCEventPropertiesNames.TCP_SIZE, "", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/Map;J)V", "getImage", "()Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getSize", "()J", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class InternalValue {
        private final Map extras;
        private final WeakReference image;
        private final long size;

        public InternalValue(@NotNull WeakReference<Image> weakReference, @NotNull Map<String, ? extends Object> map, long j) {
            this.image = weakReference;
            this.extras = map;
            this.size = j;
        }

        @NotNull
        public final WeakReference<Image> getImage() {
            return this.image;
        }

        @NotNull
        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final long getSize() {
            return this.size;
        }
    }
}
