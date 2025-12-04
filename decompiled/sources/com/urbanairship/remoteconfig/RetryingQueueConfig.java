package com.urbanairship.remoteconfig;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006!"}, d2 = {"Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "Lcom/urbanairship/json/JsonSerializable;", "maxConcurrentOperations", "", "maxPendingResults", "initialBackoff", "", "maxBackOff", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getInitialBackoff", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxBackOff", "getMaxConcurrentOperations", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxPendingResults", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class RetryingQueueConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Long initialBackoff;
    private final Long maxBackOff;
    private final Integer maxConcurrentOperations;
    private final Integer maxPendingResults;

    public static /* synthetic */ RetryingQueueConfig copy$default(RetryingQueueConfig retryingQueueConfig, Integer num, Integer num2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = retryingQueueConfig.maxConcurrentOperations;
        }
        if ((i & 2) != 0) {
            num2 = retryingQueueConfig.maxPendingResults;
        }
        if ((i & 4) != 0) {
            l = retryingQueueConfig.initialBackoff;
        }
        if ((i & 8) != 0) {
            l2 = retryingQueueConfig.maxBackOff;
        }
        return retryingQueueConfig.copy(num, num2, l, l2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getMaxConcurrentOperations() {
        return this.maxConcurrentOperations;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getMaxPendingResults() {
        return this.maxPendingResults;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getInitialBackoff() {
        return this.initialBackoff;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getMaxBackOff() {
        return this.maxBackOff;
    }

    @NotNull
    public final RetryingQueueConfig copy(@Nullable Integer maxConcurrentOperations, @Nullable Integer maxPendingResults, @Nullable Long initialBackoff, @Nullable Long maxBackOff) {
        return new RetryingQueueConfig(maxConcurrentOperations, maxPendingResults, initialBackoff, maxBackOff);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetryingQueueConfig)) {
            return false;
        }
        RetryingQueueConfig retryingQueueConfig = (RetryingQueueConfig) other;
        return Intrinsics.areEqual(this.maxConcurrentOperations, retryingQueueConfig.maxConcurrentOperations) && Intrinsics.areEqual(this.maxPendingResults, retryingQueueConfig.maxPendingResults) && Intrinsics.areEqual(this.initialBackoff, retryingQueueConfig.initialBackoff) && Intrinsics.areEqual(this.maxBackOff, retryingQueueConfig.maxBackOff);
    }

    public int hashCode() {
        Integer num = this.maxConcurrentOperations;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.maxPendingResults;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.initialBackoff;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.maxBackOff;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RetryingQueueConfig(maxConcurrentOperations=" + this.maxConcurrentOperations + ", maxPendingResults=" + this.maxPendingResults + ", initialBackoff=" + this.initialBackoff + ", maxBackOff=" + this.maxBackOff + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public RetryingQueueConfig(@Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable Long l2) {
        this.maxConcurrentOperations = num;
        this.maxPendingResults = num2;
        this.initialBackoff = l;
        this.maxBackOff = l2;
    }

    @Nullable
    public final Integer getMaxConcurrentOperations() {
        return this.maxConcurrentOperations;
    }

    @Nullable
    public final Integer getMaxPendingResults() {
        return this.maxPendingResults;
    }

    @Nullable
    public final Long getInitialBackoff() {
        return this.initialBackoff;
    }

    @Nullable
    public final Long getMaxBackOff() {
        return this.maxBackOff;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/remoteconfig/RetryingQueueConfig$Companion;", "", "()V", "INITIAL_BACKOFF", "", "MAX_BACK_OFF", "MAX_CONCURRENT_OPERATIONS", "MAX_PENDING_RESULTS", "fromJson", "Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/RetryingQueueConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,283:1\n79#2,16:284\n79#2,16:300\n79#2,16:316\n79#2,16:332\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/RetryingQueueConfig$Companion\n*L\n236#1:284,16\n237#1:300,16\n238#1:316,16\n239#1:332,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        @org.jetbrains.annotations.NotNull
        public final com.urbanairship.remoteconfig.RetryingQueueConfig fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r21) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1433
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remoteconfig.RetryingQueueConfig.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.remoteconfig.RetryingQueueConfig");
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("max_concurrent_operations", this.maxConcurrentOperations), TuplesKt.to("max_pending_results", this.maxPendingResults), TuplesKt.to("initial_back_off_seconds", this.initialBackoff), TuplesKt.to("max_back_off_seconds", this.maxBackOff)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
