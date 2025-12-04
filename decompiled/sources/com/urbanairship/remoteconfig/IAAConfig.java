package com.urbanairship.remoteconfig;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/remoteconfig/IAAConfig;", "Lcom/urbanairship/json/JsonSerializable;", "retryingQueue", "Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "additionalAudienceCheck", "Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "(Lcom/urbanairship/remoteconfig/RetryingQueueConfig;Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;)V", "getAdditionalAudienceCheck", "()Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "getRetryingQueue", "()Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class IAAConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AdditionalAudienceCheckConfig additionalAudienceCheck;
    private final RetryingQueueConfig retryingQueue;

    public IAAConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ IAAConfig copy$default(IAAConfig iAAConfig, RetryingQueueConfig retryingQueueConfig, AdditionalAudienceCheckConfig additionalAudienceCheckConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            retryingQueueConfig = iAAConfig.retryingQueue;
        }
        if ((i & 2) != 0) {
            additionalAudienceCheckConfig = iAAConfig.additionalAudienceCheck;
        }
        return iAAConfig.copy(retryingQueueConfig, additionalAudienceCheckConfig);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final RetryingQueueConfig getRetryingQueue() {
        return this.retryingQueue;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final AdditionalAudienceCheckConfig getAdditionalAudienceCheck() {
        return this.additionalAudienceCheck;
    }

    @NotNull
    public final IAAConfig copy(@Nullable RetryingQueueConfig retryingQueue, @Nullable AdditionalAudienceCheckConfig additionalAudienceCheck) {
        return new IAAConfig(retryingQueue, additionalAudienceCheck);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IAAConfig)) {
            return false;
        }
        IAAConfig iAAConfig = (IAAConfig) other;
        return Intrinsics.areEqual(this.retryingQueue, iAAConfig.retryingQueue) && Intrinsics.areEqual(this.additionalAudienceCheck, iAAConfig.additionalAudienceCheck);
    }

    public int hashCode() {
        RetryingQueueConfig retryingQueueConfig = this.retryingQueue;
        int iHashCode = (retryingQueueConfig == null ? 0 : retryingQueueConfig.hashCode()) * 31;
        AdditionalAudienceCheckConfig additionalAudienceCheckConfig = this.additionalAudienceCheck;
        return iHashCode + (additionalAudienceCheckConfig != null ? additionalAudienceCheckConfig.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "IAAConfig(retryingQueue=" + this.retryingQueue + ", additionalAudienceCheck=" + this.additionalAudienceCheck + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public IAAConfig(@Nullable RetryingQueueConfig retryingQueueConfig, @Nullable AdditionalAudienceCheckConfig additionalAudienceCheckConfig) {
        this.retryingQueue = retryingQueueConfig;
        this.additionalAudienceCheck = additionalAudienceCheckConfig;
    }

    public /* synthetic */ IAAConfig(RetryingQueueConfig retryingQueueConfig, AdditionalAudienceCheckConfig additionalAudienceCheckConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : retryingQueueConfig, (i & 2) != 0 ? null : additionalAudienceCheckConfig);
    }

    @Nullable
    public final RetryingQueueConfig getRetryingQueue() {
        return this.retryingQueue;
    }

    @Nullable
    public final AdditionalAudienceCheckConfig getAdditionalAudienceCheck() {
        return this.additionalAudienceCheck;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/remoteconfig/IAAConfig$Companion;", "", "()V", "ADDITIONAL_AUDIENCE_CONFIG", "", "RETRYING_QUEUE", "fromJson", "Lcom/urbanairship/remoteconfig/IAAConfig;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/IAAConfig$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final IAAConfig fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("queue");
            RetryingQueueConfig retryingQueueConfigFromJson = jsonValue != null ? RetryingQueueConfig.INSTANCE.fromJson(jsonValue) : null;
            JsonValue jsonValue2 = jsonMapRequireMap.get("additional_audience_check");
            return new IAAConfig(retryingQueueConfigFromJson, jsonValue2 != null ? AdditionalAudienceCheckConfig.INSTANCE.fromJson(jsonValue2) : null);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("queue", this.retryingQueue), TuplesKt.to("additional_audience_check", this.additionalAudienceCheck)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
