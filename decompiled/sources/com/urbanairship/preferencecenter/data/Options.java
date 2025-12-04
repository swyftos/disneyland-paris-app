package com.urbanairship.preferencecenter.data;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Options;", "", "mergeChannelDataToContact", "", "(Z)V", "getMergeChannelDataToContact", "()Z", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Options {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean mergeChannelDataToContact;

    public static /* synthetic */ Options copy$default(Options options, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = options.mergeChannelDataToContact;
        }
        return options.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getMergeChannelDataToContact() {
        return this.mergeChannelDataToContact;
    }

    @NotNull
    public final Options copy(boolean mergeChannelDataToContact) {
        return new Options(mergeChannelDataToContact);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Options) && this.mergeChannelDataToContact == ((Options) other).mergeChannelDataToContact;
    }

    public int hashCode() {
        return Boolean.hashCode(this.mergeChannelDataToContact);
    }

    @NotNull
    public String toString() {
        return "Options(mergeChannelDataToContact=" + this.mergeChannelDataToContact + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Options(boolean z) {
        this.mergeChannelDataToContact = z;
    }

    public final boolean getMergeChannelDataToContact() {
        return this.mergeChannelDataToContact;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Options$Companion;", "", "()V", "KEY_MERGE_CHANNEL_DATA_TO_CONTACT", "", "parse", "Lcom/urbanairship/preferencecenter/data/Options;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Options parse$urbanairship_preference_center_release(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            return new Options(json.opt("merge_channel_data_to_contact").getBoolean(false));
        }
    }

    @NotNull
    public final JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
        return JsonExtensionsKt.jsonMapOf(TuplesKt.to("merge_channel_data_to_contact", Boolean.valueOf(this.mergeChannelDataToContact)));
    }
}
