package com.urbanairship.channel;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/channel/ChannelGenerationMethod;", "", "()V", "isValid", "", "isValid$urbanairship_core_release", "()Z", "Automatic", "Restore", "Lcom/urbanairship/channel/ChannelGenerationMethod$Automatic;", "Lcom/urbanairship/channel/ChannelGenerationMethod$Restore;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ChannelGenerationMethod {
    public /* synthetic */ ChannelGenerationMethod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/channel/ChannelGenerationMethod$Automatic;", "Lcom/urbanairship/channel/ChannelGenerationMethod;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Automatic extends ChannelGenerationMethod {

        @NotNull
        public static final Automatic INSTANCE = new Automatic();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Automatic);
        }

        public int hashCode() {
            return -706063583;
        }

        @NotNull
        public String toString() {
            return "Automatic";
        }

        private Automatic() {
            super(null);
        }
    }

    private ChannelGenerationMethod() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/channel/ChannelGenerationMethod$Restore;", "Lcom/urbanairship/channel/ChannelGenerationMethod;", "channelID", "", "(Ljava/lang/String;)V", "getChannelID$urbanairship_core_release", "()Ljava/lang/String;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Restore extends ChannelGenerationMethod {
        private final String channelID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Restore(@NotNull String channelID) {
            super(null);
            Intrinsics.checkNotNullParameter(channelID, "channelID");
            this.channelID = channelID;
        }

        @NotNull
        /* renamed from: getChannelID$urbanairship_core_release, reason: from getter */
        public final String getChannelID() {
            return this.channelID;
        }
    }

    public final boolean isValid$urbanairship_core_release() {
        if (Intrinsics.areEqual(this, Automatic.INSTANCE)) {
            return true;
        }
        if (this instanceof Restore) {
            try {
                UUID.fromString(((Restore) this).getChannelID());
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        throw new NoWhenBranchMatchedException();
    }
}
