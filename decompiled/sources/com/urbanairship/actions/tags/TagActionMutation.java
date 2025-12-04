package com.urbanairship.actions.tags;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/actions/tags/TagActionMutation;", "", "()V", "ChannelTagGroups", "ChannelTags", "ContactTagGroups", "Lcom/urbanairship/actions/tags/TagActionMutation$ChannelTagGroups;", "Lcom/urbanairship/actions/tags/TagActionMutation$ChannelTags;", "Lcom/urbanairship/actions/tags/TagActionMutation$ContactTagGroups;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class TagActionMutation {
    public /* synthetic */ TagActionMutation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TagActionMutation() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/actions/tags/TagActionMutation$ChannelTags;", "Lcom/urbanairship/actions/tags/TagActionMutation;", FetchDeviceInfoAction.TAGS_KEY, "", "", "(Ljava/util/Set;)V", "getTags", "()Ljava/util/Set;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChannelTags extends TagActionMutation {
        private final Set tags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelTags copy$default(ChannelTags channelTags, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = channelTags.tags;
            }
            return channelTags.copy(set);
        }

        @NotNull
        public final Set<String> component1() {
            return this.tags;
        }

        @NotNull
        public final ChannelTags copy(@NotNull Set<String> tags) {
            Intrinsics.checkNotNullParameter(tags, "tags");
            return new ChannelTags(tags);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChannelTags) && Intrinsics.areEqual(this.tags, ((ChannelTags) other).tags);
        }

        public int hashCode() {
            return this.tags.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelTags(tags=" + this.tags + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelTags(@NotNull Set<String> tags) {
            super(null);
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.tags = tags;
        }

        @NotNull
        public final Set<String> getTags() {
            return this.tags;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/actions/tags/TagActionMutation$ChannelTagGroups;", "Lcom/urbanairship/actions/tags/TagActionMutation;", FetchDeviceInfoAction.TAGS_KEY, "", "", "", "(Ljava/util/Map;)V", "getTags", "()Ljava/util/Map;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChannelTagGroups extends TagActionMutation {
        private final Map tags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelTagGroups copy$default(ChannelTagGroups channelTagGroups, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = channelTagGroups.tags;
            }
            return channelTagGroups.copy(map);
        }

        @NotNull
        public final Map<String, Set<String>> component1() {
            return this.tags;
        }

        @NotNull
        public final ChannelTagGroups copy(@NotNull Map<String, ? extends Set<String>> tags) {
            Intrinsics.checkNotNullParameter(tags, "tags");
            return new ChannelTagGroups(tags);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChannelTagGroups) && Intrinsics.areEqual(this.tags, ((ChannelTagGroups) other).tags);
        }

        public int hashCode() {
            return this.tags.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelTagGroups(tags=" + this.tags + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelTagGroups(@NotNull Map<String, ? extends Set<String>> tags) {
            super(null);
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.tags = tags;
        }

        @NotNull
        public final Map<String, Set<String>> getTags() {
            return this.tags;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/actions/tags/TagActionMutation$ContactTagGroups;", "Lcom/urbanairship/actions/tags/TagActionMutation;", FetchDeviceInfoAction.TAGS_KEY, "", "", "", "(Ljava/util/Map;)V", "getTags", "()Ljava/util/Map;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ContactTagGroups extends TagActionMutation {
        private final Map tags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ContactTagGroups copy$default(ContactTagGroups contactTagGroups, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = contactTagGroups.tags;
            }
            return contactTagGroups.copy(map);
        }

        @NotNull
        public final Map<String, Set<String>> component1() {
            return this.tags;
        }

        @NotNull
        public final ContactTagGroups copy(@NotNull Map<String, ? extends Set<String>> tags) {
            Intrinsics.checkNotNullParameter(tags, "tags");
            return new ContactTagGroups(tags);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContactTagGroups) && Intrinsics.areEqual(this.tags, ((ContactTagGroups) other).tags);
        }

        public int hashCode() {
            return this.tags.hashCode();
        }

        @NotNull
        public String toString() {
            return "ContactTagGroups(tags=" + this.tags + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactTagGroups(@NotNull Map<String, ? extends Set<String>> tags) {
            super(null);
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.tags = tags;
        }

        @NotNull
        public final Map<String, Set<String>> getTags() {
            return this.tags;
        }
    }
}
