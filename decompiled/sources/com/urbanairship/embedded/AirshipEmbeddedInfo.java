package com.urbanairship.embedded;

import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "", Constants.FirelogAnalytics.PARAM_INSTANCE_ID, "", "embeddedId", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "extras", "Lcom/urbanairship/json/JsonMap;", "(Ljava/lang/String;Ljava/lang/String;ILcom/urbanairship/json/JsonMap;)V", "getEmbeddedId", "()Ljava/lang/String;", "getExtras", "()Lcom/urbanairship/json/JsonMap;", "getInstanceId", "getPriority", "()I", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipEmbeddedInfo {
    private final String embeddedId;
    private final JsonMap extras;
    private final String instanceId;
    private final int priority;

    public AirshipEmbeddedInfo(@NotNull String instanceId, @NotNull String embeddedId, int i, @NotNull JsonMap extras) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.instanceId = instanceId;
        this.embeddedId = embeddedId;
        this.priority = i;
        this.extras = extras;
    }

    @NotNull
    public final String getInstanceId() {
        return this.instanceId;
    }

    @NotNull
    public final String getEmbeddedId() {
        return this.embeddedId;
    }

    public final int getPriority() {
        return this.priority;
    }

    public /* synthetic */ AirshipEmbeddedInfo(String str, String str2, int i, JsonMap jsonMap, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? JsonExtensionsKt.emptyJsonMap() : jsonMap);
    }

    @NotNull
    public final JsonMap getExtras() {
        return this.extras;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AirshipEmbeddedInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.embedded.AirshipEmbeddedInfo");
        AirshipEmbeddedInfo airshipEmbeddedInfo = (AirshipEmbeddedInfo) other;
        return Intrinsics.areEqual(this.instanceId, airshipEmbeddedInfo.instanceId) && Intrinsics.areEqual(this.embeddedId, airshipEmbeddedInfo.embeddedId) && Intrinsics.areEqual(this.extras, airshipEmbeddedInfo.extras) && this.priority == airshipEmbeddedInfo.priority;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.instanceId, this.embeddedId, this.extras, Integer.valueOf(this.priority));
    }

    @NotNull
    public String toString() {
        return "AirshipEmbeddedInfo(instanceId='" + this.instanceId + "', embeddedId='" + this.embeddedId + "', priority=" + this.priority + ", extras=" + this.extras + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
