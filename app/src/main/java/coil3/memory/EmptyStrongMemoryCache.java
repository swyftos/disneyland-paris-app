package coil3.memory;

import androidx.media3.common.MimeTypes;
import coil3.Image;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, m1836d2 = {"Lcoil3/memory/EmptyStrongMemoryCache;", "Lcoil3/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil3/memory/WeakMemoryCache;", "<init>", "(Lcoil3/memory/WeakMemoryCache;)V", TCEventPropertiesNames.TCP_SIZE, "", "getSize", "()J", "maxSize", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", AttributeMutation.ATTRIBUTE_ACTION_SET, "", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "extras", "", "", "", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "", "trimToSize", "clear", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class EmptyStrongMemoryCache implements StrongMemoryCache {
    private final WeakMemoryCache weakMemoryCache;

    @Override // coil3.memory.StrongMemoryCache
    public void clear() {
    }

    @Override // coil3.memory.StrongMemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        return null;
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getMaxSize() {
        return 0L;
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getSize() {
        return 0L;
    }

    @Override // coil3.memory.StrongMemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        return false;
    }

    @Override // coil3.memory.StrongMemoryCache
    public void trimToSize(long size) {
    }

    public EmptyStrongMemoryCache(@NotNull WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // coil3.memory.StrongMemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.emptySet();
    }

    @Override // coil3.memory.StrongMemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> extras, long size) {
        this.weakMemoryCache.set(key, image, extras, size);
    }
}
