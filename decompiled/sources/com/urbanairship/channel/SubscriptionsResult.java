package com.urbanairship.channel;

import ch.qos.logback.core.CoreConstants;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class SubscriptionsResult {
    private final String channelId;
    private final Set subscriptions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionsResult)) {
            return false;
        }
        SubscriptionsResult subscriptionsResult = (SubscriptionsResult) obj;
        return Intrinsics.areEqual(this.channelId, subscriptionsResult.channelId) && Intrinsics.areEqual(this.subscriptions, subscriptionsResult.subscriptions);
    }

    public int hashCode() {
        return (this.channelId.hashCode() * 31) + this.subscriptions.hashCode();
    }

    public String toString() {
        return "SubscriptionsResult(channelId=" + this.channelId + ", subscriptions=" + this.subscriptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SubscriptionsResult(String channelId, Set subscriptions) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        this.channelId = channelId;
        this.subscriptions = subscriptions;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Set getSubscriptions() {
        return this.subscriptions;
    }
}
