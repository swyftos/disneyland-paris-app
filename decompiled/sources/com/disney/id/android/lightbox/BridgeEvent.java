package com.disney.id.android.lightbox;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/disney/id/android/lightbox/BridgeEvent;", "", "flow", "", "name", "data", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getFlow", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BridgeEvent {

    @Nullable
    private final Map<String, Object> data;

    @NotNull
    private final String flow;

    @NotNull
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BridgeEvent copy$default(BridgeEvent bridgeEvent, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bridgeEvent.flow;
        }
        if ((i & 2) != 0) {
            str2 = bridgeEvent.name;
        }
        if ((i & 4) != 0) {
            map = bridgeEvent.data;
        }
        return bridgeEvent.copy(str, str2, map);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFlow() {
        return this.flow;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Map<String, Object> component3() {
        return this.data;
    }

    @NotNull
    public final BridgeEvent copy(@NotNull String flow, @NotNull String name, @Nullable Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(name, "name");
        return new BridgeEvent(flow, name, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeEvent)) {
            return false;
        }
        BridgeEvent bridgeEvent = (BridgeEvent) other;
        return Intrinsics.areEqual(this.flow, bridgeEvent.flow) && Intrinsics.areEqual(this.name, bridgeEvent.name) && Intrinsics.areEqual(this.data, bridgeEvent.data);
    }

    public int hashCode() {
        int iHashCode = ((this.flow.hashCode() * 31) + this.name.hashCode()) * 31;
        Map<String, Object> map = this.data;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "BridgeEvent(flow=" + this.flow + ", name=" + this.name + ", data=" + this.data + ")";
    }

    public BridgeEvent(@NotNull String flow, @NotNull String name, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(name, "name");
        this.flow = flow;
        this.name = name;
        this.data = map;
    }

    public /* synthetic */ BridgeEvent(String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : map);
    }

    @NotNull
    public final String getFlow() {
        return this.flow;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Map<String, Object> getData() {
        return this.data;
    }
}
