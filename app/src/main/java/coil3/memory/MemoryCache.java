package coil3.memory;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.Image;
import coil3.content.Collections_jvmCommonKt;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\nH¦\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH¦\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/memory/MemoryCache;", "", TCEventPropertiesNames.TCP_SIZE, "", "getSize", "()J", "maxSize", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "value", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "", "trimToSize", "clear", "Key", "Value", "Builder", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface MemoryCache {
    void clear();

    @Nullable
    Value get(@NotNull Key key);

    @NotNull
    Set<Key> getKeys();

    long getMaxSize();

    long getSize();

    boolean remove(@NotNull Key key);

    void set(@NotNull Key key, @NotNull Value value);

    void trimToSize(long size);

    @Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m1836d2 = {"Lcoil3/memory/MemoryCache$Key;", "", "key", "", "extras", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getKey", "()Ljava/lang/String;", "getExtras", "()Ljava/util/Map;", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Key {
        private final Map extras;
        private final String key;

        @JvmOverloads
        public Key(@NotNull String str) {
            this(str, null, 2, 0 == true ? 1 : 0);
        }

        @JvmOverloads
        public Key(@NotNull String str, @NotNull Map<String, String> map) {
            this.key = str;
            this.extras = Collections_jvmCommonKt.toImmutableMap(map);
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        public /* synthetic */ Key(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        @NotNull
        public final Map<String, String> getExtras() {
            return this.extras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key key, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key.key;
            }
            if ((i & 2) != 0) {
                map = key.extras;
            }
            return key.copy(str, map);
        }

        @NotNull
        public final Key copy(@NotNull String key, @NotNull Map<String, String> extras) {
            return new Key(key, extras);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Key) {
                Key key = (Key) other;
                if (Intrinsics.areEqual(this.key, key.key) && Intrinsics.areEqual(this.extras, key.extras)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        @NotNull
        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m1836d2 = {"Lcoil3/memory/MemoryCache$Value;", "", MimeTypes.BASE_TYPE_IMAGE, "Lcoil3/Image;", "extras", "", "", "<init>", "(Lcoil3/Image;Ljava/util/Map;)V", "getImage", "()Lcoil3/Image;", "getExtras", "()Ljava/util/Map;", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Value {
        private final Map extras;
        private final Image image;

        @JvmOverloads
        public Value(@NotNull Image image) {
            this(image, null, 2, 0 == true ? 1 : 0);
        }

        @JvmOverloads
        public Value(@NotNull Image image, @NotNull Map<String, ? extends Object> map) {
            this.image = image;
            this.extras = Collections_jvmCommonKt.toImmutableMap(map);
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        public /* synthetic */ Value(Image image, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(image, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        @NotNull
        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value value, Image image, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                image = value.image;
            }
            if ((i & 2) != 0) {
                map = value.extras;
            }
            return value.copy(image, map);
        }

        @NotNull
        public final Value copy(@NotNull Image image, @NotNull Map<String, ? extends Object> extras) {
            return new Value(image, extras);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Value) {
                Value value = (Value) other;
                if (Intrinsics.areEqual(this.image, value.image) && Intrinsics.areEqual(this.extras, value.extras)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.image.hashCode() * 31) + this.extras.hashCode();
        }

        @NotNull
        public String toString() {
            return "Value(image=" + this.image + ", extras=" + this.extras + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J!\u0010\f\u001a\u00020\u00002\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1836d2 = {"Lcoil3/memory/MemoryCache$Builder;", "", "<init>", "()V", "maxSizeBytesFactory", "Lkotlin/Function0;", "", "strongReferencesEnabled", "", "weakReferencesEnabled", "maxSizeBytes", TCEventPropertiesNames.TCP_SIZE, "maxSizePercent", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "percent", "", "(Landroid/content/Context;D)Lcoil3/memory/MemoryCache$Builder;", "enable", "build", "Lcoil3/memory/MemoryCache;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nMemoryCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryCache.kt\ncoil3/memory/MemoryCache$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1#2:190\n*E\n"})
    public static final class Builder {
        private Function0 maxSizeBytesFactory;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        /* JADX INFO: Access modifiers changed from: private */
        public static final long maxSizeBytes$lambda$1$lambda$0(long j) {
            return j;
        }

        @NotNull
        public final Builder maxSizeBytes(final long size) {
            this.maxSizeBytesFactory = new Function0() { // from class: coil3.memory.MemoryCache$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Long.valueOf(MemoryCache.Builder.maxSizeBytes$lambda$1$lambda$0(size));
                }
            };
            return this;
        }

        @NotNull
        public final Builder maxSizeBytes(@NotNull Function0<Long> size) {
            this.maxSizeBytesFactory = size;
            return this;
        }

        public static /* synthetic */ Builder maxSizePercent$default(Builder builder, Context context, double d, int i, Object obj) {
            if ((i & 2) != 0) {
                d = coil3.content.Context.defaultMemoryCacheSizePercent(context);
            }
            return builder.maxSizePercent(context, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long maxSizePercent$lambda$5$lambda$4(double d, Context context) {
            return (long) (d * coil3.content.Context.totalAvailableMemoryBytes(context));
        }

        @NotNull
        public final Builder maxSizePercent(@NotNull final Context context, final double percent) {
            if (AudioStats.AUDIO_AMPLITUDE_NONE > percent || percent > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].");
            }
            this.maxSizeBytesFactory = new Function0() { // from class: coil3.memory.MemoryCache$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Long.valueOf(MemoryCache.Builder.maxSizePercent$lambda$5$lambda$4(percent, context));
                }
            };
            return this;
        }

        @NotNull
        public final Builder strongReferencesEnabled(boolean enable) {
            this.strongReferencesEnabled = enable;
            return this;
        }

        @NotNull
        public final Builder weakReferencesEnabled(boolean enable) {
            this.weakReferencesEnabled = enable;
            return this;
        }

        @NotNull
        public final MemoryCache build() {
            WeakMemoryCache emptyWeakMemoryCache;
            StrongMemoryCache emptyStrongMemoryCache;
            if (this.weakReferencesEnabled) {
                emptyWeakMemoryCache = new RealWeakMemoryCache();
            } else {
                emptyWeakMemoryCache = new EmptyWeakMemoryCache();
            }
            if (this.strongReferencesEnabled) {
                Function0 function0 = this.maxSizeBytesFactory;
                if (function0 == null) {
                    throw new IllegalStateException("maxSizeBytesFactory == null");
                }
                long jLongValue = ((Number) function0.invoke()).longValue();
                if (jLongValue > 0) {
                    emptyStrongMemoryCache = new RealStrongMemoryCache(jLongValue, emptyWeakMemoryCache);
                } else {
                    emptyStrongMemoryCache = new EmptyStrongMemoryCache(emptyWeakMemoryCache);
                }
            } else {
                emptyStrongMemoryCache = new EmptyStrongMemoryCache(emptyWeakMemoryCache);
            }
            return new RealMemoryCache(emptyStrongMemoryCache, emptyWeakMemoryCache);
        }
    }
}
