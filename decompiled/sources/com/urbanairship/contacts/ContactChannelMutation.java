package com.urbanairship.contacts;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/contacts/ContactChannelMutation;", "", "()V", "Associate", "AssociateAnon", "Disassociated", "Lcom/urbanairship/contacts/ContactChannelMutation$Associate;", "Lcom/urbanairship/contacts/ContactChannelMutation$AssociateAnon;", "Lcom/urbanairship/contacts/ContactChannelMutation$Disassociated;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ContactChannelMutation {
    public /* synthetic */ ContactChannelMutation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/contacts/ContactChannelMutation$Associate;", "Lcom/urbanairship/contacts/ContactChannelMutation;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "channelId", "", "(Lcom/urbanairship/contacts/ContactChannel;Ljava/lang/String;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getChannelId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Associate extends ContactChannelMutation {
        private final ContactChannel channel;
        private final String channelId;

        public static /* synthetic */ Associate copy$default(Associate associate, ContactChannel contactChannel, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                contactChannel = associate.channel;
            }
            if ((i & 2) != 0) {
                str = associate.channelId;
            }
            return associate.copy(contactChannel, str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ContactChannel getChannel() {
            return this.channel;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final Associate copy(@NotNull ContactChannel channel, @Nullable String channelId) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            return new Associate(channel, channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Associate)) {
                return false;
            }
            Associate associate = (Associate) other;
            return Intrinsics.areEqual(this.channel, associate.channel) && Intrinsics.areEqual(this.channelId, associate.channelId);
        }

        public int hashCode() {
            int iHashCode = this.channel.hashCode() * 31;
            String str = this.channelId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "Associate(channel=" + this.channel + ", channelId=" + this.channelId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Associate(@NotNull ContactChannel channel, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.channelId = str;
        }

        public /* synthetic */ Associate(ContactChannel contactChannel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(contactChannel, (i & 2) != 0 ? null : str);
        }

        @NotNull
        public final ContactChannel getChannel() {
            return this.channel;
        }

        @Nullable
        public final String getChannelId() {
            return this.channelId;
        }
    }

    private ContactChannelMutation() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/contacts/ContactChannelMutation$AssociateAnon;", "Lcom/urbanairship/contacts/ContactChannelMutation;", "channelId", "", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "(Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AssociateAnon extends ContactChannelMutation {
        private final String channelId;
        private final ChannelType channelType;

        public static /* synthetic */ AssociateAnon copy$default(AssociateAnon associateAnon, String str, ChannelType channelType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = associateAnon.channelId;
            }
            if ((i & 2) != 0) {
                channelType = associateAnon.channelType;
            }
            return associateAnon.copy(str, channelType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final ChannelType getChannelType() {
            return this.channelType;
        }

        @NotNull
        public final AssociateAnon copy(@NotNull String channelId, @NotNull ChannelType channelType) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(channelType, "channelType");
            return new AssociateAnon(channelId, channelType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssociateAnon)) {
                return false;
            }
            AssociateAnon associateAnon = (AssociateAnon) other;
            return Intrinsics.areEqual(this.channelId, associateAnon.channelId) && this.channelType == associateAnon.channelType;
        }

        public int hashCode() {
            return (this.channelId.hashCode() * 31) + this.channelType.hashCode();
        }

        @NotNull
        public String toString() {
            return "AssociateAnon(channelId=" + this.channelId + ", channelType=" + this.channelType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssociateAnon(@NotNull String channelId, @NotNull ChannelType channelType) {
            super(null);
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
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/contacts/ContactChannelMutation$Disassociated;", "Lcom/urbanairship/contacts/ContactChannelMutation;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "channelId", "", "(Lcom/urbanairship/contacts/ContactChannel;Ljava/lang/String;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getChannelId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Disassociated extends ContactChannelMutation {
        private final ContactChannel channel;
        private final String channelId;

        public static /* synthetic */ Disassociated copy$default(Disassociated disassociated, ContactChannel contactChannel, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                contactChannel = disassociated.channel;
            }
            if ((i & 2) != 0) {
                str = disassociated.channelId;
            }
            return disassociated.copy(contactChannel, str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ContactChannel getChannel() {
            return this.channel;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final Disassociated copy(@NotNull ContactChannel channel, @Nullable String channelId) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            return new Disassociated(channel, channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Disassociated)) {
                return false;
            }
            Disassociated disassociated = (Disassociated) other;
            return Intrinsics.areEqual(this.channel, disassociated.channel) && Intrinsics.areEqual(this.channelId, disassociated.channelId);
        }

        public int hashCode() {
            int iHashCode = this.channel.hashCode() * 31;
            String str = this.channelId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "Disassociated(channel=" + this.channel + ", channelId=" + this.channelId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Disassociated(@NotNull ContactChannel channel, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.channelId = str;
        }

        public /* synthetic */ Disassociated(ContactChannel contactChannel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(contactChannel, (i & 2) != 0 ? null : str);
        }

        @NotNull
        public final ContactChannel getChannel() {
            return this.channel;
        }

        @Nullable
        public final String getChannelId() {
            return this.channelId;
        }
    }
}
