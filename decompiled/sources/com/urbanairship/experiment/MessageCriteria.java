package com.urbanairship.experiment;

import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/experiment/MessageCriteria;", "", "messageTypePredicate", "Lcom/urbanairship/json/JsonPredicate;", "campaignPredicate", "(Lcom/urbanairship/json/JsonPredicate;Lcom/urbanairship/json/JsonPredicate;)V", "getCampaignPredicate", "()Lcom/urbanairship/json/JsonPredicate;", "getMessageTypePredicate", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "evaluate", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/experiment/MessageInfo;", "hashCode", "", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MessageCriteria {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonPredicate campaignPredicate;
    private final JsonPredicate messageTypePredicate;

    public static /* synthetic */ MessageCriteria copy$default(MessageCriteria messageCriteria, JsonPredicate jsonPredicate, JsonPredicate jsonPredicate2, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonPredicate = messageCriteria.messageTypePredicate;
        }
        if ((i & 2) != 0) {
            jsonPredicate2 = messageCriteria.campaignPredicate;
        }
        return messageCriteria.copy(jsonPredicate, jsonPredicate2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final JsonPredicate getMessageTypePredicate() {
        return this.messageTypePredicate;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JsonPredicate getCampaignPredicate() {
        return this.campaignPredicate;
    }

    @NotNull
    public final MessageCriteria copy(@Nullable JsonPredicate messageTypePredicate, @Nullable JsonPredicate campaignPredicate) {
        return new MessageCriteria(messageTypePredicate, campaignPredicate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageCriteria)) {
            return false;
        }
        MessageCriteria messageCriteria = (MessageCriteria) other;
        return Intrinsics.areEqual(this.messageTypePredicate, messageCriteria.messageTypePredicate) && Intrinsics.areEqual(this.campaignPredicate, messageCriteria.campaignPredicate);
    }

    public int hashCode() {
        JsonPredicate jsonPredicate = this.messageTypePredicate;
        int iHashCode = (jsonPredicate == null ? 0 : jsonPredicate.hashCode()) * 31;
        JsonPredicate jsonPredicate2 = this.campaignPredicate;
        return iHashCode + (jsonPredicate2 != null ? jsonPredicate2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MessageCriteria(messageTypePredicate=" + this.messageTypePredicate + ", campaignPredicate=" + this.campaignPredicate + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MessageCriteria(@Nullable JsonPredicate jsonPredicate, @Nullable JsonPredicate jsonPredicate2) {
        this.messageTypePredicate = jsonPredicate;
        this.campaignPredicate = jsonPredicate2;
    }

    @Nullable
    public final JsonPredicate getMessageTypePredicate() {
        return this.messageTypePredicate;
    }

    @Nullable
    public final JsonPredicate getCampaignPredicate() {
        return this.campaignPredicate;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/experiment/MessageCriteria$Companion;", "", "()V", "KEY_PREDICATE", "", "KEY_PREDICATE_CAMPAIGNS", "fromJson", "Lcom/urbanairship/experiment/MessageCriteria;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJson$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMessageCriteria.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCriteria.kt\ncom/urbanairship/experiment/MessageCriteria$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final MessageCriteria fromJson$urbanairship_core_release(@NotNull final JsonMap json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                return new MessageCriteria(json.containsKey(Constants.MessagePayloadKeys.MESSAGE_TYPE) ? JsonPredicate.parse(json.opt(Constants.MessagePayloadKeys.MESSAGE_TYPE)) : null, json.containsKey("campaigns") ? JsonPredicate.parse(json.opt("campaigns")) : null);
            } catch (JsonException unused) {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.experiment.MessageCriteria$Companion$fromJson$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "failed to parse MessageCriteria from json " + json;
                    }
                }, 1, null);
                return null;
            }
        }
    }

    public final boolean evaluate(@NotNull MessageInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        JsonPredicate jsonPredicate = this.messageTypePredicate;
        boolean zApply = jsonPredicate != null ? jsonPredicate.apply((JsonSerializable) JsonValue.wrap(info.getMessageType())) : false;
        JsonPredicate jsonPredicate2 = this.campaignPredicate;
        return zApply || (jsonPredicate2 != null ? jsonPredicate2.apply((JsonSerializable) info.getCampaigns()) : false);
    }
}
