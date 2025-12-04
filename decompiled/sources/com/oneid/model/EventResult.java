package com.oneid.model;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.oneid.common.EventId;
import com.oneid.common.ExtensionsKt;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001e\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u001e\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/oneid/model/EventResult;", "", "Lcom/oneid/model/EventType;", "eventType", "Lcom/oneid/common/EventId;", "initializer", "", "guestData", "tokenData", "<init>", "(Lcom/oneid/model/EventType;Lcom/oneid/common/EventId;Ljava/util/Map;Ljava/util/Map;)V", "Lcom/facebook/react/bridge/WritableMap;", "serialize", "()Lcom/facebook/react/bridge/WritableMap;", "copy", "(Lcom/oneid/model/EventType;Lcom/oneid/common/EventId;Ljava/util/Map;Ljava/util/Map;)Lcom/oneid/model/EventResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Lcom/oneid/model/EventType;", "Lcom/oneid/common/EventId;", "Ljava/util/Map;", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EventResult {
    private final EventType eventType;
    private final Map guestData;
    private final EventId initializer;
    private final Map tokenData;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventResult copy$default(EventResult eventResult, EventType eventType, EventId eventId, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            eventType = eventResult.eventType;
        }
        if ((i & 2) != 0) {
            eventId = eventResult.initializer;
        }
        if ((i & 4) != 0) {
            map = eventResult.guestData;
        }
        if ((i & 8) != 0) {
            map2 = eventResult.tokenData;
        }
        return eventResult.copy(eventType, eventId, map, map2);
    }

    @NotNull
    public final EventResult copy(@NotNull EventType eventType, @NotNull EventId initializer, @Nullable Map<?, ?> guestData, @Nullable Map<?, ?> tokenData) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new EventResult(eventType, initializer, guestData, tokenData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventResult)) {
            return false;
        }
        EventResult eventResult = (EventResult) other;
        return this.eventType == eventResult.eventType && this.initializer == eventResult.initializer && Intrinsics.areEqual(this.guestData, eventResult.guestData) && Intrinsics.areEqual(this.tokenData, eventResult.tokenData);
    }

    public int hashCode() {
        int iHashCode = ((this.eventType.hashCode() * 31) + this.initializer.hashCode()) * 31;
        Map map = this.guestData;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map map2 = this.tokenData;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EventResult(eventType=" + this.eventType + ", initializer=" + this.initializer + ", guestData=" + this.guestData + ", tokenData=" + this.tokenData + ")";
    }

    public EventResult(@NotNull EventType eventType, @NotNull EventId initializer, @Nullable Map<?, ?> map, @Nullable Map<?, ?> map2) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.eventType = eventType;
        this.initializer = initializer;
        this.guestData = map;
        this.tokenData = map2;
    }

    public /* synthetic */ EventResult(EventType eventType, EventId eventId, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, eventId, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2);
    }

    @NotNull
    public final WritableMap serialize() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("eventType", this.eventType.getType());
        writableMapCreateMap.putString("initializer", this.initializer.getId());
        Map map = this.guestData;
        writableMapCreateMap.putMap("profile", map != null ? ExtensionsKt.toWriteableMap(map) : null);
        Map map2 = this.tokenData;
        writableMapCreateMap.putMap("token", map2 != null ? ExtensionsKt.toWriteableMap(map2) : null);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
