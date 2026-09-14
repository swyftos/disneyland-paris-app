package coil3.network;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.channel.AttributeMutation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB#\b\u0002\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003J\u0006\u0010\f\u001a\u00020\rR \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lcoil3/network/NetworkHeaders;", "", "data", "", "", "", "<init>", "(Ljava/util/Map;)V", "get", "key", "getAll", "asMap", "newBuilder", "Lcoil3/network/NetworkHeaders$Builder;", "Builder", "Companion", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class NetworkHeaders {

    @JvmField
    @NotNull
    public static final NetworkHeaders EMPTY = new Builder().build();
    private final Map data;

    public /* synthetic */ NetworkHeaders(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkHeaders) && Intrinsics.areEqual(this.data, ((NetworkHeaders) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "NetworkHeaders(data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private NetworkHeaders(Map map) {
        this.data = map;
    }

    @Nullable
    public final String get(@NotNull String key) {
        Map map = this.data;
        String lowerCase = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List list = (List) map.get(lowerCase);
        if (list != null) {
            return (String) CollectionsKt.lastOrNull(list);
        }
        return null;
    }

    @NotNull
    public final List<String> getAll(@NotNull String key) {
        Map map = this.data;
        String lowerCase = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = (List) map.get(lowerCase);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @NotNull
    public final Map<String, List<String>> asMap() {
        return this.data;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0086\u0002J\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0086\u0002J\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0005R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lcoil3/network/NetworkHeaders$Builder;", "", "<init>", "()V", "headers", "Lcoil3/network/NetworkHeaders;", "(Lcoil3/network/NetworkHeaders;)V", "data", "", "", "", AttributeMutation.ATTRIBUTE_ACTION_SET, "key", "value", "values", "", "add", "build", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nNetworkHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkHeaders.kt\ncoil3/network/NetworkHeaders$Builder\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n412#2:62\n381#2,7:67\n1246#3,4:63\n*S KotlinDebug\n*F\n+ 1 NetworkHeaders.kt\ncoil3/network/NetworkHeaders$Builder\n*L\n36#1:62\n48#1:67,7\n36#1:63,4\n*E\n"})
    public static final class Builder {
        private final Map data;

        public Builder() {
            this.data = new LinkedHashMap();
        }

        public Builder(@NotNull NetworkHeaders networkHeaders) {
            Map map = networkHeaders.data;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
            }
            this.data = linkedHashMap;
        }

        @NotNull
        public final Builder set(@NotNull String key, @NotNull String value) {
            Map map = this.data;
            String lowerCase = key.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.put(lowerCase, CollectionsKt.mutableListOf(value));
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String key, @NotNull List<String> values) {
            Map map = this.data;
            String lowerCase = key.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.put(lowerCase, CollectionsKt.toMutableList((Collection) values));
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String key, @NotNull String value) {
            Map map = this.data;
            String lowerCase = key.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Object arrayList = map.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(lowerCase, arrayList);
            }
            ((List) arrayList).add(value);
            return this;
        }

        @NotNull
        public final NetworkHeaders build() {
            return new NetworkHeaders(MapsKt.toMap(this.data), null);
        }
    }
}
