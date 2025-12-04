package com.urbanairship.experiment;

import androidx.annotation.RestrictTo;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/experiment/MessageInfo;", "", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "", "campaigns", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getCampaigns", "()Lcom/urbanairship/json/JsonValue;", "getMessageType", "()Ljava/lang/String;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class MessageInfo {
    private final JsonValue campaigns;
    private final String messageType;

    public MessageInfo(@NotNull String messageType, @Nullable JsonValue jsonValue) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        this.messageType = messageType;
        this.campaigns = jsonValue;
    }

    @NotNull
    public final String getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final JsonValue getCampaigns() {
        return this.campaigns;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(MessageInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.experiment.MessageInfo");
        return Intrinsics.areEqual(this.messageType, ((MessageInfo) other).messageType);
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }
}
