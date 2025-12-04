package com.urbanairship.contacts;

import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dBo\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/contacts/ConflictEvent;", "", "tagGroups", "", "", "", "attributes", "Lcom/urbanairship/json/JsonValue;", "subscriptionLists", "Lcom/urbanairship/contacts/Scope;", "associatedChannels", "", "Lcom/urbanairship/contacts/ConflictEvent$ChannelInfo;", "conflictingNameUserId", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V", "getAssociatedChannels", "()Ljava/util/List;", "getAttributes", "()Ljava/util/Map;", "getConflictingNameUserId", "()Ljava/lang/String;", "getSubscriptionLists", "getTagGroups", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "ChannelInfo", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConflictEvent {
    private final List associatedChannels;
    private final Map attributes;
    private final String conflictingNameUserId;
    private final Map subscriptionLists;
    private final Map tagGroups;

    public ConflictEvent() {
        this(null, null, null, null, null, 31, null);
    }

    public ConflictEvent(@NotNull Map<String, ? extends Set<String>> tagGroups, @NotNull Map<String, ? extends JsonValue> attributes, @NotNull Map<String, ? extends Set<? extends Scope>> subscriptionLists, @NotNull List<ChannelInfo> associatedChannels, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tagGroups, "tagGroups");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(subscriptionLists, "subscriptionLists");
        Intrinsics.checkNotNullParameter(associatedChannels, "associatedChannels");
        this.tagGroups = tagGroups;
        this.attributes = attributes;
        this.subscriptionLists = subscriptionLists;
        this.associatedChannels = associatedChannels;
        this.conflictingNameUserId = str;
    }

    public /* synthetic */ ConflictEvent(Map map, Map map2, Map map3, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : str);
    }

    @NotNull
    public final Map<String, Set<String>> getTagGroups() {
        return this.tagGroups;
    }

    @NotNull
    public final Map<String, JsonValue> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final Map<String, Set<Scope>> getSubscriptionLists() {
        return this.subscriptionLists;
    }

    @NotNull
    public final List<ChannelInfo> getAssociatedChannels() {
        return this.associatedChannels;
    }

    @Nullable
    public final String getConflictingNameUserId() {
        return this.conflictingNameUserId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConflictEvent)) {
            return false;
        }
        ConflictEvent conflictEvent = (ConflictEvent) other;
        return Intrinsics.areEqual(this.tagGroups, conflictEvent.tagGroups) && Intrinsics.areEqual(this.attributes, conflictEvent.attributes) && Intrinsics.areEqual(this.subscriptionLists, conflictEvent.subscriptionLists) && Intrinsics.areEqual(this.associatedChannels, conflictEvent.associatedChannels) && Intrinsics.areEqual(this.conflictingNameUserId, conflictEvent.conflictingNameUserId);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.tagGroups, this.attributes, this.subscriptionLists, this.associatedChannels, this.conflictingNameUserId);
    }

    @NotNull
    public String toString() {
        return "ConflictEvent(tagGroups=" + this.tagGroups + ", attributes=" + this.attributes + ", subscriptionLists=" + this.subscriptionLists + ", associatedChannels=" + this.associatedChannels + ", conflictingNameUserId=" + this.conflictingNameUserId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/contacts/ConflictEvent$ChannelInfo;", "", "channelId", "", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "(Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ChannelInfo {
        private final String channelId;
        private final ChannelType channelType;

        public ChannelInfo(@NotNull String channelId, @NotNull ChannelType channelType) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(channelType, "channelType");
            this.channelId = channelId;
            this.channelType = channelType;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final ChannelType getChannelType() {
            return this.channelType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(ChannelInfo.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ConflictEvent.ChannelInfo");
            ChannelInfo channelInfo = (ChannelInfo) other;
            return Intrinsics.areEqual(this.channelId, channelInfo.channelId) && this.channelType == channelInfo.channelType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.channelId, this.channelType);
        }
    }
}
