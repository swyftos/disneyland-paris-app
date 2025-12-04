package com.urbanairship.audience;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.SubscriptionListMutation;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.contacts.ContactChannelMutation;
import com.urbanairship.contacts.ScopedSubscriptionListMutation;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/audience/AudienceOverrides;", "", "()V", "Channel", "Contact", "Lcom/urbanairship/audience/AudienceOverrides$Channel;", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AudienceOverrides {
    public /* synthetic */ AudienceOverrides(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/audience/AudienceOverrides$Contact;", "Lcom/urbanairship/audience/AudienceOverrides;", FetchDeviceInfoAction.TAGS_KEY, "", "Lcom/urbanairship/channel/TagGroupsMutation;", "attributes", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptions", "Lcom/urbanairship/contacts/ScopedSubscriptionListMutation;", "channels", "Lcom/urbanairship/contacts/ContactChannelMutation;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAttributes", "()Ljava/util/List;", "getChannels", "getSubscriptions", "getTags", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Contact extends AudienceOverrides {
        private final List attributes;
        private final List channels;
        private final List subscriptions;
        private final List tags;

        public Contact() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Contact copy$default(Contact contact, List list, List list2, List list3, List list4, int i, Object obj) {
            if ((i & 1) != 0) {
                list = contact.tags;
            }
            if ((i & 2) != 0) {
                list2 = contact.attributes;
            }
            if ((i & 4) != 0) {
                list3 = contact.subscriptions;
            }
            if ((i & 8) != 0) {
                list4 = contact.channels;
            }
            return contact.copy(list, list2, list3, list4);
        }

        @Nullable
        public final List<TagGroupsMutation> component1() {
            return this.tags;
        }

        @Nullable
        public final List<AttributeMutation> component2() {
            return this.attributes;
        }

        @Nullable
        public final List<ScopedSubscriptionListMutation> component3() {
            return this.subscriptions;
        }

        @Nullable
        public final List<ContactChannelMutation> component4() {
            return this.channels;
        }

        @NotNull
        public final Contact copy(@Nullable List<? extends TagGroupsMutation> tags, @Nullable List<? extends AttributeMutation> attributes, @Nullable List<? extends ScopedSubscriptionListMutation> subscriptions, @Nullable List<? extends ContactChannelMutation> channels) {
            return new Contact(tags, attributes, subscriptions, channels);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Contact)) {
                return false;
            }
            Contact contact = (Contact) other;
            return Intrinsics.areEqual(this.tags, contact.tags) && Intrinsics.areEqual(this.attributes, contact.attributes) && Intrinsics.areEqual(this.subscriptions, contact.subscriptions) && Intrinsics.areEqual(this.channels, contact.channels);
        }

        public int hashCode() {
            List list = this.tags;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            List list2 = this.attributes;
            int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
            List list3 = this.subscriptions;
            int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
            List list4 = this.channels;
            return iHashCode3 + (list4 != null ? list4.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Contact(tags=" + this.tags + ", attributes=" + this.attributes + ", subscriptions=" + this.subscriptions + ", channels=" + this.channels + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Contact(List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4);
        }

        @Nullable
        public final List<TagGroupsMutation> getTags() {
            return this.tags;
        }

        @Nullable
        public final List<AttributeMutation> getAttributes() {
            return this.attributes;
        }

        @Nullable
        public final List<ScopedSubscriptionListMutation> getSubscriptions() {
            return this.subscriptions;
        }

        @Nullable
        public final List<ContactChannelMutation> getChannels() {
            return this.channels;
        }

        public Contact(@Nullable List<? extends TagGroupsMutation> list, @Nullable List<? extends AttributeMutation> list2, @Nullable List<? extends ScopedSubscriptionListMutation> list3, @Nullable List<? extends ContactChannelMutation> list4) {
            super(null);
            this.tags = list;
            this.attributes = list2;
            this.subscriptions = list3;
            this.channels = list4;
        }
    }

    private AudienceOverrides() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/audience/AudienceOverrides$Channel;", "Lcom/urbanairship/audience/AudienceOverrides;", FetchDeviceInfoAction.TAGS_KEY, "", "Lcom/urbanairship/channel/TagGroupsMutation;", "attributes", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptions", "Lcom/urbanairship/channel/SubscriptionListMutation;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAttributes", "()Ljava/util/List;", "getSubscriptions", "getTags", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Channel extends AudienceOverrides {
        private final List attributes;
        private final List subscriptions;
        private final List tags;

        public Channel() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Channel copy$default(Channel channel, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = channel.tags;
            }
            if ((i & 2) != 0) {
                list2 = channel.attributes;
            }
            if ((i & 4) != 0) {
                list3 = channel.subscriptions;
            }
            return channel.copy(list, list2, list3);
        }

        @Nullable
        public final List<TagGroupsMutation> component1() {
            return this.tags;
        }

        @Nullable
        public final List<AttributeMutation> component2() {
            return this.attributes;
        }

        @Nullable
        public final List<SubscriptionListMutation> component3() {
            return this.subscriptions;
        }

        @NotNull
        public final Channel copy(@Nullable List<? extends TagGroupsMutation> tags, @Nullable List<? extends AttributeMutation> attributes, @Nullable List<? extends SubscriptionListMutation> subscriptions) {
            return new Channel(tags, attributes, subscriptions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Channel)) {
                return false;
            }
            Channel channel = (Channel) other;
            return Intrinsics.areEqual(this.tags, channel.tags) && Intrinsics.areEqual(this.attributes, channel.attributes) && Intrinsics.areEqual(this.subscriptions, channel.subscriptions);
        }

        public int hashCode() {
            List list = this.tags;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            List list2 = this.attributes;
            int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
            List list3 = this.subscriptions;
            return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Channel(tags=" + this.tags + ", attributes=" + this.attributes + ", subscriptions=" + this.subscriptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Channel(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
        }

        @Nullable
        public final List<TagGroupsMutation> getTags() {
            return this.tags;
        }

        @Nullable
        public final List<AttributeMutation> getAttributes() {
            return this.attributes;
        }

        @Nullable
        public final List<SubscriptionListMutation> getSubscriptions() {
            return this.subscriptions;
        }

        public Channel(@Nullable List<? extends TagGroupsMutation> list, @Nullable List<? extends AttributeMutation> list2, @Nullable List<? extends SubscriptionListMutation> list3) {
            super(null);
            this.tags = list;
            this.attributes = list2;
            this.subscriptions = list3;
        }
    }
}
